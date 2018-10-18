/*
 * --------------------------------------------------------------------------------------------
 * Jose Luis Bustos Esteban
 * --------------------------------------------------------------------------------------------
 * Esta clase realiza el login y logout tecnologico Meta4. NO se deben usar directamente
 * Sino pasar por la clase Meta4Control.java que es la que consume esta clase. Esto 
 * es muy importante.
 * --------------------------------------------------------------------------------------------
*/
package com.portalmobile.meta4.funcional;
import javax.xml.rpc.Stub;

import com.common.config.ParamsApp;
import com.common.hibernate.classes.hb_users;
import com.common.hibernate.entidades.VinUsers;
import com.common.saas.saas_login_operations;
import com.portalmobile.meta4.schemas.*;
import com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_Session_M4_ValueOutput;


public class Meta4Login {

	private String languaje="3"; //idioma espa�ol de Meta4
	
	
	//Constructor
	public Meta4Login()
	{
		new ParamsApp();
		languaje = ParamsApp.META4_LANGUAJE; //idioma por defecto de Meta4
	}
	
	
	
	// ----------------------------------------------------------
	// Hacemos Login contra Meta4 (solo Login)
	// ----------------------------------------------------------
	
	public String loginMeta4(String User,String Password,String idiomaMeta4)
	{
		languaje = idiomaMeta4;
		return loginMeta4(User,Password);
	}
    
    public String loginMeta4(String User,String Password) 
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
			
			//LOGIN OK en el APp server. Ahora controlamos la session, es decir,
			//si el usuario tiene asignado un role válido
			
			String DevControl = this.ControlSession(code);
			
			if (DevControl.equals("M4_ERROR"))
			{
				//System.out.println("\n\n Error funcional: Acceso no permitido a Peoplenet. No tiene un role válido\n");
				
				//Hacemos Logout si el code del app server no esta vacio
				if (!code.equals("")){
					if (this.LogoutNMeta4(code)==0)
					{
						//System.out.println("\n <Logout App server Correcto>");
					}
					else
					{
						//System.out.println("\n <Logout App server Erroneo>");
					}
				}
				code = "";
			
			}
			else {
				
				// Now Get the Id sociedad and id employee for update user table of mysql

			 	try{
			 		
			 		
			 		Csp_Mbl_Soap_Server_InfoServiceService  Sfactory = new Csp_Mbl_Soap_Server_InfoServiceServiceLocator();
			 		Csp_Mbl_Soap_Server_InfoService Meta4Object = Sfactory.getCSP_MBL_SOAP_SERVER_INFO();
			 		Csp_Get_Session_M4_ValueOutput  SalidaExec;
			 		
			 		//mantenemos la session proyy
			 		oStub = (javax.xml.rpc.Stub)Meta4Object;
			 		oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			 		Meta4Object.retrieveM4Session(code); 
			 		
			 		// ID Person
			 		SalidaExec =	 Meta4Object.CSP_GET_SESSION_M4_VALUE("ID_PERSON");
			 		String idPerson = SalidaExec.get_return();
			 		
			 	   // ID Organization
			 		SalidaExec =	 Meta4Object.CSP_GET_SESSION_M4_VALUE("ID_ORGANIZATION");
			 		String idOrganization = SalidaExec.get_return();
			 		
			 		if (ParamsApp.GLOBAL_SAAS_MODE == 1) {
						// Conect to Sql Server Saas to get Employee Data
						saas_login_operations saas = new saas_login_operations();
						saas.updateUserDataSaas(idPerson, idOrganization, User);
						saas.Dispose();
						saas = null;
					}
			 		else {
			 				// Get data from Meta4 Poeplenet
			 		
			 		
					 		// SSN
					 		SalidaExec =	 Meta4Object.CSP_GET_SESSION_M4_VALUE("SSN");
					 		String SSN = SalidaExec.get_return();
					 		
					 		// Name Employee
					 		SalidaExec =	 Meta4Object.CSP_GET_SESSION_M4_VALUE("NAME_EMPLOYEE");
					 		String NameFullEmployee = SalidaExec.get_return();
					 		
					 	// Name Employee
					 		SalidaExec =	 Meta4Object.CSP_GET_SESSION_M4_VALUE("PERIODO");
					 		String NumPeriodo = SalidaExec.get_return();
					 		
					 		
					 		// Persist This Data en MySql user table
					 		
					 		hb_users hb = new hb_users();
					 		VinUsers user = hb.getUser(User);
					 		user.setIdEmpleadoRrhh(idPerson);
					 		user.setIdOrganization(idOrganization);
					 		user.setNif(SSN);
					 		user.setUserName(NameFullEmployee);
					 		user.setComment("Update Data from PeopleNet");
					 		user.setFaseAltaRrhh(NumPeriodo); 
					 		
					 		//Save
					 		hb.updateRecord(user);
			 		}
			 		
			 	}
			 	catch(Exception e)
			 	{
			 		e.printStackTrace();
			 	}

				
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//System.out.print("\n Error:  Login Meta4 Error no controlado:"+e.getMessage());
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
 	
 		Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
 		Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
 		Csp_Control_AccesoOutput  SalidaExec;
 		
 		//mantenemos la session proy
 		oStub = (javax.xml.rpc.Stub)Meta4Object;
 		oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
 		Meta4Object.retrieveM4Session(serialAppServer); //recuperamos la sesion
 		SalidaExec =	 Meta4Object.CSP_CONTROL_ACCESO("",""); //ejecutamos metodo argumentos SIEMPRE vacios
 		return SalidaExec.get_return();
 		
 	}
 	catch(Exception e)
 	{
 		return "M4_ERROR";
 	}

 	

 }
    
 // ---------------------------------------------------
// Funcion de Logout de Meta4
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