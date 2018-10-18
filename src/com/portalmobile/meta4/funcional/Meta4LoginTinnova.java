package com.portalmobile.meta4.funcional;

import javax.xml.rpc.Stub;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.saas.saas_login_operations;
import com.portalmobile.meta4.schemas.*;
import com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput;
import com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput;
import com.portalmobile.meta4.schemas.types.Seg_Change_Password_Other_UserOutput;
import com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput;
import com.portalmobile.tinnova.tiinova_backend_tools;


public class Meta4LoginTinnova {
	
	private String languaje="3"; //idioma español de Meta4

	//Constructor
		public Meta4LoginTinnova()
		{
			new ParamsApp();
			this.languaje = ParamsApp.META4_LANGUAJE; //idioma por defecto de Meta4
		}
		

		// ----------------------------------------------------------
		// Hacemos Login contra Meta4 (solo Login)
		// ----------------------------------------------------------
		
		public String loginMeta4Tinnova(String User,String Password,String idiomaMeta4)
		{
			languaje = idiomaMeta4;
			return loginMeta4Tinnova(User,Password);
		}
	    
	    public String loginMeta4Tinnova(String User,String Password) 
	    {
	    		javax.xml.rpc.Stub oStub = null;
			String code="";
			LoginServiceServiceLocator sfactor;
			LoginService login;
			tiinova_backend_tools tinnovaTools;
			
			try{
			
				sfactor = new LoginServiceServiceLocator();
				login = sfactor.getLogin();
				M4LoginOutput salida;

				//Mantener la session
				oStub = (javax.xml.rpc.Stub)login;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				salida = login.login(User, Password, languaje); 
				code = salida.getSessionID().toString(); //KeyCode unico Meta4
				
				//LOGIN OK en el APp server. Ahora controlamos la session, es decir,
				//si el usuario tiene asignado un role válido
				
				String DevControl = this.ControlSession(code);
				
				if (DevControl.equals("M4_ERROR"))
				{
					System.out.println("\n\n Error funcional: Acceso no permitido a Peoplenet. No tiene un role válido\n");
					
					//Hacemos Logout si el code del app server no esta vacio
					if (!code.equals("")){
						if (this.LogoutNMeta4(code)==0)
						{
							System.out.println("\n <Logout App server Correcto>");
						}
						else
						{
							System.out.println("\n <Logout App server Erroneo>");
						}
					}
					code = "";
				
				}
				else {
					
					//Todo OK en el login y la session. Capturamos el empleado y regeneramos los datos de MySQL
					String Employee = getEmployeeUserActive(code);
					
					if (Employee.length() != 0) {
						
						// SAAS CONTROL
						if (ParamsApp.GLOBAL_SAAS_MODE == 1) {
							// Conect to Sql Server Saas to get Employee Data
							saas_login_operations saas = new saas_login_operations();
							saas.updateUserDataSaas(Employee.substring(2), Employee.substring(0, 2), User);
							saas.Dispose();
							saas = null;
						}
						else {
							//NO Saas. Connect to Tinnova to get the user data
							tinnovaTools = new tiinova_backend_tools();
							tinnovaTools.recalcTinnovaUserDataWithPeopleNetUsers(Employee, User);
						}
					}
					else {
						//no tiene asociado una persona el usuario peoplenet de Tinnova. No hacemos login. Hacermos logout
						this.LogoutNMeta4(code);
						System.out.println("\n <Logout App server>");
						code = "";
					}
					
				}
				
			}
			catch(Exception e)
			{
				System.out.print("\n Error:  Login Meta4 Error no controlado:"+e.getMessage());
				code = "";
			}
			finally
			{
				sfactor=null;
				login = null;
				tinnovaTools = null;
			}

			return code; //Devuelve el serial de meta4
	    }		

	    
	    // login solo para el BackDoor para recordar claves etc
	    public String loginMeta4TinnovaBackDoorUser(String User,String Password) 
	    {
	    		javax.xml.rpc.Stub oStub = null;
			String code="";
			LoginServiceServiceLocator sfactor;
			LoginService login;
			
			try{
			
				sfactor = new LoginServiceServiceLocator();
				login = sfactor.getLogin();
				M4LoginOutput salida;

				//Mantener la session
				oStub = (javax.xml.rpc.Stub)login;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				salida = login.login(User, Password, languaje); 
				code = salida.getSessionID().toString(); //KeyCode unico Meta4
				
			}
			catch(Exception e)
			{
				code = "";
			}
			finally
			{
				sfactor=null;
				login = null;
			}

			return code; //Devuelve el serial de meta4
	    }		
	    
	 // --------------------------------------------------------------------------------
	 	// Metodo Control de session. Usado desde pues del login devuelve codigo meta4.
	 	// Es necesario tienen un role valido al usuario.
	 	// --------------------------------------------------------------------------------
	 	public String ControlSession(String serialAppServer){
	 		
	 	//control session (si las credenciales erronas, devolvemos vacio)
	 	if (serialAppServer==null || serialAppServer.equals("")) {return "M4_ERROR";}

	 	javax.xml.rpc.Stub oStub = null;	
	 	try{
	 	
	 		// Peoplenet de Tinnova para los clientes con portal
	 		
	 		Csp_Mbl_Soap_Tools_TinnovaServiceService  Sfactory = new Csp_Mbl_Soap_Tools_TinnovaServiceServiceLocator();
	 		Csp_Mbl_Soap_Tools_TinnovaService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS_TINNOVA();
	 		Csp_Control_AccesoOutput  SalidaExec;
	 		
	 		//mantenemos la session proy
	 		oStub = (javax.xml.rpc.Stub)Meta4Object;
	 		oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
	 		Meta4Object.retrieveM4Session(serialAppServer); //recuperamos la sesion
	 		SalidaExec =	 Meta4Object.CSP_CONTROL_ACCESO();
	 		return SalidaExec.get_return();
	 		
	 	}
	 	catch(Exception e)
	 	{
	 		return "M4_ERROR";
	 	}

	 	

	 }
	    
	 	
	 // --------------------------------------------------------------------------------
		// Metodo Echo Session para Poeplenet de Tinnovca
		// --------------------------------------------------------------------------------
		public int EchoSession(logonCredencialProcess Session){
			
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return -1;}

		int dev = 0;
		javax.xml.rpc.Stub oStub = null;	
		try{
		
			Csp_Mbl_Soap_Tools_TinnovaServiceService  Sfactory = new Csp_Mbl_Soap_Tools_TinnovaServiceServiceLocator();
	 		Csp_Mbl_Soap_Tools_TinnovaService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS_TINNOVA();
	 		Csp_Echo_SessionOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
			SalidaExec =	 Meta4Object.CSP_ECHO_SESSION(); //ejecutamos metodo
			dev = 0;//OK
			
		}
		catch(Exception e)
		{
			dev = -1; //Error
		}
		finally
		{
		}
		
		return dev; //devolvemos el valor
	}

	 	
		// Cambio de clave en Tiinova - Peoplenet
	 	public boolean ChangePasswordPeoplenetTinnova( String UserMeta4, String newPassword) {
			boolean dev = false;
			javax.xml.rpc.Stub oStub = null;	
			try{
				
				//hacemos Login a Peoplenet por la puerta de atras (usuario WEBADM o similar de Peoplenet). Esto se llama sin login en el App
				String InternalSerial =  this.loginMeta4TinnovaBackDoorUser(ParamsApp.META4_USER_BACKDOOR, ParamsApp.META4_PASS_BACKDOOR);
				
				if (InternalSerial.equals("")){
					return false; // No Login
				}
		
				Csp_Mbl_Soap_Tools_TinnovaServiceService  Sfactory = new Csp_Mbl_Soap_Tools_TinnovaServiceServiceLocator();
		 		Csp_Mbl_Soap_Tools_TinnovaService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS_TINNOVA();
		 		Seg_Change_Password_Other_UserOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				Meta4Object.retrieveM4Session(InternalSerial); //get Session tecnological user
				SalidaExec =	 Meta4Object.SEG_CHANGE_PASSWORD_OTHER_USER(newPassword, UserMeta4); //Execute method
				
				//Metodo Meta4 devuelve M4_SUCCESS == 0
				if (SalidaExec.get_return() == 0) {
					dev = true;
				}
				
				//hacemos logout
				this.LogoutNMeta4(InternalSerial);
				
			}
			catch(Exception e)
			{
				dev = false; //Error
			}
			finally
			{
				oStub = null;
			}
			
			return dev; //devolvemos el valor del cambio de clave
	 	}
		
		
		// METODO del meta4Object ECHO que a demas nos devuelve el empleado conectado
		public String getEmployeeUserActive(String serialAppServer) {
			
			
			//control session (si las credenciales erronas, devolvemos vacio)
		 	if (serialAppServer==null || serialAppServer.equals("")) {return "";}

		 	javax.xml.rpc.Stub oStub = null;	
		 	try{
		 	
		 		// Peoplenet de Tinnova para los clientes con portal
		 		
		 		Csp_Mbl_Soap_Tools_TinnovaServiceService  Sfactory = new Csp_Mbl_Soap_Tools_TinnovaServiceServiceLocator();
		 		Csp_Mbl_Soap_Tools_TinnovaService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS_TINNOVA();
		 		Csp_Echo_SessionOutput  SalidaExec;
		 		
		 		//mantenemos la session proy
		 		oStub = (javax.xml.rpc.Stub)Meta4Object;
		 		oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
		 		Meta4Object.retrieveM4Session(serialAppServer); //recuperamos la sesion
		 		SalidaExec =	 Meta4Object.CSP_ECHO_SESSION(); //el ECHO nos da el id empleado que tiene el usuario en la sesion SCH_SESSION
		 		return SalidaExec.get_return();
		 		
		 	}
		 	catch(Exception e)
		 	{
		 		return "";
		 	}
			
		}
		
	 	
	 	
	 // ---------------------------------------------------
	// Logout Tiinova Peroplenet 
	// ---------------------------------------------------

	public int LogoutNMeta4(String Sesion)
	{
		
		LoginServiceServiceLocator sfactor;
		LoginService login;
		int dev = 0;
		javax.xml.rpc.Stub oStub = null;	
		try{
		
			
			sfactor = new LoginServiceServiceLocator();
			login = sfactor.getLogin();
			
			//Mantener la session
			oStub = (javax.xml.rpc.Stub)login;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			login.retrieveM4Session(Sesion); //recogemos la sesion
			login.logout(); //hacemos logout de meta4
		}
		catch(Exception e)
		{
			dev = -1;
		}
		finally
		{
			sfactor=null;
			login = null;
		}
		
		return dev;
	}

}
