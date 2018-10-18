//**********************************************************
// Jose Luis Bustos Esteban 2014
// Sistema Local (mySql)
// **********************************************************

package com.common.globalSystems.login;
import com.common.config.ParamsApp;
import com.common.hibernate.classes.*;
import com.common.hibernate.entidades.*;

public class logonLocal implements logon {

	public String className = "";
	public String languaje;
	public String idSystema;
	private String UUID;
	private String Device;
	
	
	logonCommon common = null;
	
	//Constructores
	public logonLocal()
	{
		initClass("");
	}
	
	public logonLocal(String idioma)
	{
		languaje = idioma;
		initClass(idioma);
		
	}

	public logonLocal(String idioma, String sistema, String dispositivo, String UUIDDispos)
	{
		UUID = UUIDDispos;
		Device = dispositivo;		
		languaje = idioma;
		idSystema = sistema;
		initClass(idioma);
	}

	
	
	private void initClass(String idioma)
	{
		common = new logonCommon(languaje,Device, UUID); //instanciamos la clase
		
		//debug = 1
		this.className = this.getClass().getSimpleName(); //nombre de la clase
		
		if (idioma.equals("")){languaje = ParamsApp.META4_LANGUAJE;}
	}
	
	
	//Destructor
	protected void finalize()
	{
		common = null; 
	}
		
		
	
		
		// -----------------------------------------------------------
		// login al sistema
		// -----------------------------------------------------------
		public String logonSystem(String userLocal, String user, String p_password)
		{
			hb_users obj = null;
			VinUsers data = null;
			
			try{
				
				//obtenemos el usuario
				obj = new hb_users();
				
				//Si es sistema mismas credenciales, carfamos un usuario u otro
				if (common.isSystemCredencialtheSameAllUsers(idSystema)==true)
				{
					data = obj.getUser(user);
				}
				else
				{
					data = obj.getUser(userLocal);
				}
				
				if (data != null)
				{
					
					// Backend v2. Verify if the Staorage Toke IS OK. In this case return this token
					
					if (common.ControlTokenTimeOut(data.getIdUser(), SYSTEM_LOCAL)) {
						
						//Active Token, returns it
						String serial = common.getUserToken(userLocal, SYSTEM_LOCAL);
						addLog("*** Token is active . Login No necessary. Return " + serial);
						return serial;
					}
					
					
					
					//encript password 
					String passwordIntroducida = obj.encriptaPassword(p_password);
					
					if (passwordIntroducida.equals(data.getPassword())) //password OK
					{
						//Bloqued user control
						if (data.getBloq()==0)
						{
							//Creamos el serial con los datos en Md5
							String Token =  common.createSerialSystem(obj.encriptaPassword(user)+obj.encriptaPassword(userLocal), obj.encriptaPassword(passwordIntroducida),SYSTEM_LOCAL);
							
							//Actualizamos los sistemas y datos del usuario
							if (common.saveUserData(userLocal, SYSTEM_LOCAL, Token,user, passwordIntroducida ) == false){
								return ""; //error al guardar las credenciales
							
							}else {
							
								// Generate Data if is Saas
								if (ParamsApp.GLOBAL_SAAS_MODE == 1) {
									
									
								}
								
								return Token;
							
							} //OK
						} else {return ""; }//usuario bloqueado
					} else {return ""; }//no hace login, clave incorrecta
				} else {return "";} //no hace login, usuario no encontrado
				
			}
			catch(Exception e)
			{
				System.out.print("ERROR: logonSystem : "+e.getStackTrace());
				return "";
			}
			finally
			{
				obj = null;
				data = null;
			}
		}

		
		

		//Evaluamos cada par�metro que no se cumnpla. Par poder codificar codigos especiales en caso de moviles
		//Todos los sistemas deben ser igual este metodo
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
			//	aqui no se hace nada. Ya lo hace el LogonMain
			
		}; //Logout del sistema		
		
		

		// Debug class
		protected void addLog(String info)
		{
				new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, ParamsApp.LOG_TYPE_INFO);
		}
		
		
		//En este sistema local, no tiene sentido. devolvemos true
		public boolean echoToSystemExternal(String KeyCode){return true;}
		
		
		// -----------------------------------------------------------		
		//  Sin Uso
		// -----------------------------------------------------------
		public String logonSystem(String userLocal, String user, String password, String idSistema){return "";}
		public String logonSystem(String serialCredential){return "";}
		public String controlSessionSystem(String serialCode){return "";}
		public String logonSystemBySerialCredentials(String Credentials){return"";}		
		
}


