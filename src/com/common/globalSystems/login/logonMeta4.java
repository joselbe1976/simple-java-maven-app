//**********************************************************
// Jose Luis Bustos Esteban
// Sistema Meta4 PeopleNet
// **********************************************************

package com.common.globalSystems.login;

import com.common.config.ParamsApp;
import com.common.hibernate.classes.hb_statistics;
import com.common.hibernate.classes.hb_users;
import com.portalmobile.meta4.funcional.Meta4Control;
import com.portalmobile.meta4.funcional.Meta4Login;
import com.portalmobile.meta4.funcional.Meta4LoginTinnova;

public class logonMeta4 implements logon {


	public String className = "";
	public String languaje;
	private String UUID;
	private String Device;
	
	logonCommon common = null;
	
	
	//constructor
	public logonMeta4()
	{
		Device="0";
		initClass("");
	}

	public logonMeta4(String idioma, String dispositivo, String UUIDDispos)
	{
		UUID = UUIDDispos;
		Device = dispositivo;
		languaje = idioma; //forzamos el idioma
		initClass(idioma);
	}


	private void initClass(String idioma)
	{
		
		common = new logonCommon(languaje,Device, UUID); //instanciamos la clase
		this.className = this.getClass().getSimpleName(); //nombre de la clase
		if (idioma.equals("")){languaje = ParamsApp.META4_LANGUAJE;}

	}
	
	
	//Destructor
	protected void finalize()
	{
		common = null; 
	}

		
		

		// ----------------------------------------------------		
		// Login a Meta4 con usuario y clave Contra Meta4
		// ----------------------------------------------------
		public String logonSystem(String userLocal,String user, String p_password)
		{
		
			//Si Tinnova y login por el sistema local, no hacemos nada
			if (ParamsApp.META4_PRODUCT.equals("TINNOVA") && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL"))
			{
				return "tinnova";
			}
			
			//si llega aqui es peoplenet
			
			Meta4Login meta4;
			Meta4LoginTinnova meta4Tiinova;
			String serial = "";
			hb_users obj = null;
			
			addLog("------ login Systema Meta4 ------");
			addLog("user:"+user);
			try{
				
				obj = new hb_users();
				
				
				
				if (ParamsApp.META4_PRODUCT.equals("TINNOVA") )
				{
					meta4Tiinova = new Meta4LoginTinnova();
					serial =  meta4Tiinova.loginMeta4Tinnova(user, p_password,languaje); //logamos a Meta4 Tiinova (peoplenet del portal)
				}
				else {
					meta4 = new Meta4Login();
					serial =  meta4.loginMeta4(user, p_password,languaje); //logamos a Meta4 Peoplenet
				}
				
				//Logado OK, control token activo
				
				if (!serial.equals("")) {
				
					// Backend v2. Verify if the Staorage Toke IS OK. In this case return this token
					if (common.ControlTokenTimeOut(userLocal, SYSTEM_META4)) {
						//Active Token, returns it
						serial = common.getUserToken(userLocal, SYSTEM_META4);
						addLog("*** Token is active . Not generare new internal Token. Return " + serial);
						
						new hb_statistics().insertEstadistics(userLocal, "controlSession", "Login success in Meta4 System. Token reusable");
						return serial;
					}
					else {
						addLog("*** Token is NOT active . New Interal Token. Continue");
					}
				}
				
				
				
				
				//guardamos los datos del usuario, en su sistema
				
				//encriptamos la clave a Md5
				String passwordIntroducida = obj.encriptaPassword(p_password);
				
				if (!serial.equals("")){
					
					//logado todo OK.
					common.saveUserData(userLocal, SYSTEM_META4, serial,user, passwordIntroducida );
					
					//stadisticas
					new hb_statistics().insertEstadistics(userLocal, "controlSession", "Login success in Meta4 System");
					
					
				}
				else {
					//stadisticas
					new hb_statistics().insertEstadistics(userLocal, "error_login_ws", "Login error to Meta4 System");
				}
				addLog("Despues Login Meta4: serial:"+ serial);
			}
			catch(Exception e)
			{
				System.out.print("\n ERROR (logonSystem) Sistema Meta4. Descrip: "+e.getMessage());
			}
			finally
			{
				meta4 = null;
				meta4Tiinova = null;
				obj = null;
			}
			return serial;
		}
		
		// -------------------------------------------		
		//Hacemos Echo contra el sistema
		// -------------------------------------------
		public boolean echoToSystemExternal(String KeyCode)
		{
			
			//Si Tinnova nada
			if (new ParamsApp().META4_PRODUCT.equals("TINNOVA") && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL"))
			{
				return true;
			}	
			
			
			Meta4Control meta4;
			Meta4LoginTinnova meta4Tiinova;
			logonCredencialProcess Session;
			int dev= -1;
			
			
			try
			{
				//debemos pasar un objeto Session de la clase logonCredencialProcess
				Session = new logonCredencialProcess();
				Session.SerialKeyForIdProcess= KeyCode; //asignamos para que pueda hacer echo a meta4
				
				
				
				if (ParamsApp.META4_PRODUCT.equals("TINNOVA") )
				{
					meta4Tiinova = new Meta4LoginTinnova();
					dev = meta4Tiinova.EchoSession(Session); //lanzamos el echo sobre meta4 peoplenet portal Tinnova
				}
				else {
					meta4 = new Meta4Control();
					dev = meta4.EchoSession(Session); //lanzamos el echo sobre meta4 Peoplenet 
				}

				
				addLog("    ..... OK!");
				
			}
			catch(Exception e)
			{
				System.out.print("\n .......... ERROR (echoToSystemExternal Meta4)"+e.getStackTrace());
			}			
			finally
			{
				meta4 = null;
				meta4Tiinova = null;
				Session = null;
			}
			addLog(" .. End   executing echoToSystemExternal (Ping meta4)..");
			
			//devolucion (as boolean)
			if (dev == 0){
				return true;
			} //ok
			else{
				return false;
			} //fail
			
		}		
		
		
		//Evaluamos cada parametro que no se cumnpla. Par poder codificar codigos especiales en caso de moviles
		public String evaluarParametrosLogin(int Param)
		{
			switch(Param)
			{
			case logonMain.PARAM_BLOQUEO_SISTEMA:
						return "ERROR_LOCK";
			case logonMain.PARAM_DIAS_CONEXION:
						return "ERROR_WEEK_DAY";
			case logonMain.PARAM_HORARIO_CONEXION:
						return "ERROR_HOUR_DAY";
			case logonMain.PARAM_DISPOSITIVO_ACCESO:
						return "ERROR_DISPOSITIVO";
			case logonMain.PARAM_UUID_ACCESO:
				return "ERROR_UUID";
				
			default:
					return "";
			}

		}

		
		public void logout(String userLocal)
		{
			
			//Si Tinnova nada
			if (new ParamsApp().META4_PRODUCT.equals("TINNOVA") && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL"))
			{
				return;
			}			
			
			
			Meta4Login meta4;
			Meta4LoginTinnova meta4Tiinova;
			addLog(" .. Start executing logout Meta4 ..");
			String Serial="";
			
			try
			{
				int dev;
				
				if (ParamsApp.META4_PRODUCT.equals("TINNOVA") )
				{
					meta4Tiinova = new Meta4LoginTinnova();
					dev = meta4Tiinova.LogoutNMeta4(userLocal); 
				}
				else 
				{
					meta4 = new Meta4Login();
					dev = meta4.LogoutNMeta4(userLocal); //aqui userLocal es el serial peoplenet
				}
				
				
				addLog("\n    código logout app server meta4: " + dev);
				
			}
			catch(Exception e)
			{
				System.out.print("\n ERROR ( logout)"+e.getStackTrace());
			}			
			finally
			{
				meta4 = null;
				meta4Tiinova = null;

			}
			addLog(" .. End   executing logout Meta4 ..");
			
			
		}; //Logout del sistema
		
		
		
		// Debug class
		protected void addLog(String info)
		{
				new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, ParamsApp.LOG_TYPE_INFO);
		}		
		
		
		// -----------------------------------------------------------		
		//  Sin Uso
		// -----------------------------------------------------------
		public String logonSystem(String userLocal, String user, String password, String idSistema){return "";}
		public String logonSystem(String serialCredential){return "";}
		public String controlSessionSystem(String serialCode){return "";}
		public String logonSystemBySerialCredentials(String Credentials){return"";}		
		
		
		
		
		
}
