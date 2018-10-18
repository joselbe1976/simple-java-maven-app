//**********************************************************
// Jose Luis Bustos Esteban
// Funciones Comunes a todos los sistemas para logon
// control de session etc.
// **********************************************************

package com.common.globalSystems.login;

import java.util.Date;
import java.util.List;
import java.util.Random;

import com.common.config.ParamsApp;
import com.common.hibernate.classes.hb_devices;
import com.common.hibernate.classes.hb_dynamic_actions;
import com.common.hibernate.classes.hb_statistics;
import com.common.hibernate.classes.hb_systems;
import com.common.hibernate.classes.hb_users;
import com.common.hibernate.classes.hb_users_system;
import com.common.hibernate.entidades.VinDevices;
import com.common.hibernate.entidades.VinRoles;
import com.common.hibernate.entidades.VinSystems;
import com.common.hibernate.entidades.VinUsers;
import com.common.hibernate.entidades.VinUsersSystem;
import com.common.hibernate.entidades.VinUsersSystemId;
import com.common.tools.encript.encriptAES;
import com.common.tools.interfaces.iDisposable;

public class logonCommon implements iDisposable {

	public static final long ONE_MINUTE_IN_MILLIS=60000;

	//Constantes 
	public static final int ID_USUARIO_PK = 1;
	public static final int SYS_USER = 2;
	public static final int SYS_PASSWORD = 3;
	public static final int SYS_PASSWORD_NO_ENCRIPT = 4;
	public static final int ID_SYSTEM = 5;
	public static final int USER_UUID_LOGIN = 6;
	public static final int USER_UUID_ACCESS = 7;
	public static final int USER_ID_DEVICE_LOGIN = 8;
	public static final int USER_ID_DEVICE_ACCESS = 9;	
	public static final int ROLE_OF_USER = 10;
	


	private String className = "";
	private String languaje="";
	private String Device="";
	private String UUID;
	
	//Constructores
	public logonCommon()
	{
		className = this.getClass().getSimpleName(); //nombre de la clase
		languaje = ParamsApp.META4_LANGUAJE; //idioma por defecto
	}

	public logonCommon(String idioma, String Dispositivo, String UUIDDispo)
	{
		className = this.getClass().getSimpleName(); //nombre de la clase
		languaje = idioma;
		Device = Dispositivo;
		UUID = UUIDDispo;
		
	}
	
	public void Dispose() {
		
	}
	
	//para cambiar el idioma
	public void setLanguaje(String idioma)
	{
		languaje = idioma;
	}
	
	
	
	// -----------------------------------------------------
	// Control del timeout de un token
	// -----------------------------------------------------
	public boolean ControlTokenTimeOut(String user, String System)
	{
		addLog("---- Start ControlTokenTimeOut ...");
		hb_users_system a = new hb_users_system();
		List<?> aux=null;
		VinUsersSystem data = null;

		try{
			aux = a.getUserSystem(user, System);
		
			//si existe, sino error
			if (aux.size() > 0)
			{
				data = (VinUsersSystem)aux.get(0);
				
				if (data == null) {return false;}
				
				Date date = new Date(); //fecha actual
				
				if (data.getDtCadToken() == null) {
					return false;
				}
				
				if (data.getDtCadToken().compareTo(date)>0) //fecha grabada token mayor a la actual
				{
					return true; //ok
				}
				else
				{
					return false; //fail timeout
				}
			}
			else
			{
				return false; //no tiene asignado este sistema el usuario
			}
		}
		finally
		{
			a.close_session_user();			
			a= null;
			aux = null;
			data = null;
			addLog("---- Ends ControlTokenTimeOut ...");
		}
	}
	
	// -----------------------------------------------------
	// Get Serial from user and System
	// -----------------------------------------------------
	public String getUserToken(String user, String System)
	{
		addLog("---- Start getUserToken ...");
		hb_users_system a = new hb_users_system();
		List<?> aux=null;
		VinUsersSystem data = null;

		try{
			aux = a.getUserSystem(user, System);
		
			//si existe, sino error
			if (aux.size() > 0)
			{
				data = (VinUsersSystem)aux.get(0);
				return data.getTokenSystem();
			}
			else
			{
				return "";
			}
		}
		catch(Exception e) {
			return "";
		}
		finally
		{
			a.close_session_user();			
			a= null;
			aux = null;
			data = null;
			addLog("---- Ends getUserToken ...");
		}
	}
	
	    // -----------------------------------------------------
		//Force to Expire a Token
		// -----------------------------------------------------
		public boolean ExpireTokenForce(String user, String System)
		{
		
			addLog("---- Start ExpireTokenForce ...");
		
			hb_users_system a =null;
			List<?> aux = null;
			VinUsersSystem data = null;
			
			try{
					
					a = new hb_users_system();
					aux = a.getUserSystem(user, System);
					
					if (aux.size() > 0)
					{
						data = (VinUsersSystem)aux.get(0);
						
						//Force to expire the Token
						 
						Date date = new Date();
						long t=date.getTime();
						Date dateAfter = new Date(t - (20 * ONE_MINUTE_IN_MILLIS)); //calculamos los minutos de vida del token
						data.setDtCadToken(dateAfter);

						// Update
						a.updateRecord(data);
						
						return true; //Save OK
					}
					else
					{
						return false; //error
					}
			}
			catch(Exception e)
			{
				addLog("ERROR -- ExpireTokenForce : " +e.getStackTrace());
				return false;
			}		
			finally
			{
				a.close_session_user();
				data = null;
				a=null;
				addLog("---- Ends ExpireTokenForce ...");
			}
		}	
	
	
	
	
	// -----------------------------------------------------	
	//Creamos la credenciales
	// -----------------------------------------------------
	public String createSerialSystem(String User, String claveMd5,String System)
	{
		Random rnd = new Random();
		
		String Final = "";
		Final = User + String.valueOf(rnd.nextInt(85632)) +  System + String.valueOf(rnd.nextInt(78545)) +claveMd5 + String.valueOf(rnd.nextInt(99999));
		return Final;
	}
	
	
	
	// Generacion automatica de usuario por sistema externo en sistema Local
	
	public void autoGenUserExternal(String user, String sistema){
		hb_users usuarios;
		VinUsers userExt;

		//si esta parametrizado la autogeneracion
		
		if (!(ParamsApp.SYSTEM_CREATE_LOCAL_USER_AUTO == 1)){
			return;
		}
		
		try{
		
			userExt = new VinUsers();
			VinDevices device = new VinDevices();
			
			userExt.setIdUser(user);
			userExt.setComment("AutoGenerado Backend");
			userExt.setUserName(user);
			userExt.setBloq(0); //no bloqueado
			userExt.setIntentosLogin(0);
			
			device.setIdDevice("0");
			userExt.setVinDevicesByIdDispAccess(device);
			
			device.setIdDevice("0");
			userExt.setVinDevicesByIdDispLogin(device);	
			
			VinRoles rol = new VinRoles();
			rol.setId(Integer.parseInt("300")); //como portal mobile
			userExt.setVinRoles(rol);	
			
			userExt.setUuidAccess("");
			userExt.setVisible(1);//viisble
			userExt.setPassword("0123456789"); //clave por defecto. No se podr� entrar nunca.
			userExt.setUuidLogin(" ");
			userExt.setBloq(0); //default no esta bloqueado
			
			
			userExt.setNif("00000000");
			userExt.setIdEmpleadoRrhh("");
			userExt.setFaseAltaRrhh("");
			
			
			
			//grabamos si existe no hace nada
			usuarios = new hb_users();
			usuarios.addRecord(userExt);
			
			//verificamos si tiene el sistema asignado (externo) sino lo hacemos. Asi queda 100% transparente
			this.validateUserSystemAsign(user, sistema);
			
		}
		catch(Exception e){}
		finally{
			usuarios = null;
			userExt = null;
			usuarios = null;

			
		}
	}
	
	
	
	// -----------------------------------------------------
	//grabamos la informacion del usuario en el sistema
	// -----------------------------------------------------
	public boolean saveUserData(String user, String System, String token,String sysUser, String syspassword )
	{
	
		addLog("---- Start saveUserData ...");
	
		hb_users_system a =null;
		List<?> aux = null;
		VinUsersSystem data = null;
		
		try{
			
				autoGenUserExternal(user, System); 
			
				a = new hb_users_system();
				aux = a.getUserSystem(user, System);
			
				//si existe, sino error
				if (aux.size() > 0)
				{
					data = (VinUsersSystem)aux.get(0);
					
					data.setSysUser(sysUser);
					data.setSysPassword(syspassword);
					data.setTokenSystem(token);
					
					
					//Calculamos la fecha de expiracion del Token
					
					new ParamsApp();
					 
					Date date = new Date();
					long t=date.getTime();
					Date dateAfter = new Date(t + (ParamsApp.SYSTEM_LOGIN_TIME_TOKEN_MINUTES * ONE_MINUTE_IN_MILLIS)); //calculamos los minutos de vida del token
					data.setDtCadToken(dateAfter);
					data.setIdiomaSession(languaje);
					
					//actualizamos
					a.updateRecord(data);
					
					return true; //Todo Ok
				}
				else
				{
					return false; //no tiene asignado este sistema el usuario
				}
		}
		catch(Exception e)
		{
			addLog("ERROR -- saveUserData : " +e.getStackTrace());
			return false;
		}		
		finally
		{
			a.close_session_user();
			data = null;
			a=null;
			addLog("---- Ends saveUserData ...");
		}
	}	

	
	//resetea las credenciales del usuario antes del login
	public boolean sessionResetUserCredentials(String localUser)
	{
		addLog("---- Start sessionResetUserCredentials ...");
		hb_dynamic_actions hb; //esta clase autocierra y autoabre la session
		
		try{
			hb = new hb_dynamic_actions();
			String Sql = "update vin_users_system set token_system = '', sys_user='', sys_password='', idioma_session='' where id_user = '"+ localUser + "' and id_system <> 'Parse'";
			addLog("   Sql for Update: " + Sql);
			return hb.execDynamicUpdate(Sql);
		}
		catch(Exception e)
		{
			addLog("   Error:"+e.getMessage());
			System.out.print(e.getStackTrace());
			return false;
		}
		finally
		{
			hb = null;
			addLog("---- Ends sessionResetUserCredentials ...");
		}
	}
	
	
		// -----------------------------------------------------
		// Control TOKEN para validad en el tiempo
		// -----------------------------------------------------
		public boolean ControlTokenTimeOut(String Token)
		{
		
			addLog("---- Start ControlTokenTimeOut ...");
			hb_users_system a = null;
			List<?> aux = null;
			VinUsersSystem data = null;
			
			try{
					a = new hb_users_system();
					aux = a.getListaBaseTable("token_system='"+Token+"'"); //Filtramos por Token
					
					//si existe, sino error
					if (aux.size() > 0)
					{
						data = (VinUsersSystem)aux.get(0);
						Date date = new Date();
						
						if (data.getDtCadToken().compareTo(date)>0) //fecha grabada token mayor a la actual
						{
							//volvemos a incrementarlo. en 15 minutos. desde esta ejecucion				
							new ParamsApp();
							 
							long t=date.getTime();
							Date dateAfter = new Date(t + (ParamsApp.SYSTEM_LOGIN_TIME_TOKEN_MINUTES * ONE_MINUTE_IN_MILLIS)); //calculamos los minutos de vida del token
							data.setDtCadToken(dateAfter);
							data.setIdiomaSession(languaje);
							
							//actualizamos
							a.updateRecord(data);
							return true; //ok
						}
						else
						{
							return false; //fail timeout
						}
					}
					else
					{
						return false; //no se encuentra el Token
					}
			}
			catch(Exception e)
			{
				addLog("ERROR -- ControlTokenTimeOut : " +e.getStackTrace());
				return false;
			}
			finally
			{
			 a.close_session_user();
			 a=null;
			 aux = null;
			 data = null;
			 addLog("---- Ends ControlTokenTimeOut ...");
			}
			 
		}	
	
		
		// ---------------------------------------------------
		// Save Login FAIL
		// ---------------------------------------------------		
		public void saveUserLoginFail(String id_user_local,String Sistema)
		{
			addLog("---- Start saveUserLoginFail ...");
			
			hb_users data = null;
			VinUsers aux = null;
			
			try{
				data = new hb_users();
				aux = data.getUser(id_user_local);
				
				//usuario no existe
				if (aux == null)
				{
					//Estadisticas
					new hb_statistics().insertEstadistics("internal", "usernoexist", "The user: " +id_user_local + " not exit. Login fail" );
					
				}
				
				//incrementamoe el numero de intentos
				int intentos = aux.getIntentosLogin();
				intentos++;
				aux.setIntentosLogin(intentos);
	
				//Si hay mas de 5 intentos, bloqueamos
				if (intentos > ParamsApp.SYSTEM_LOGIN_BLOQ_INTENTOS )
				{
					addLog("    .. Usuario bloqueado!!!!");
					aux.setBloq(1); 
					
					//Estadisticas
					new hb_statistics().insertEstadistics(id_user_local, "userBloq", "User bloqued");
				}
				
				//guardamos
				data.updateRecord(aux);
				
				//Estadisticas
				String idProcess="LOCAL_FAIL";
				if (Sistema.equals("Meta4")){idProcess="Meta4_FAIL";}
				new hb_statistics().insertEstadistics(id_user_local, idProcess, "Login Fail");
			}
			catch(Exception e)
			{
				addLog("ERROR -- saveUserLoginFail : " +e.getStackTrace());
			}			
			finally
			{
				data.close_session_user(); 
				data = null;
				aux = null;
				addLog("---- Ends saveUserLoginFail ...");
			}
			
			
		}
		
		// ---------------------------------------------------
		// Save Login Success
		// ---------------------------------------------------		
		public void saveUserLoginSuccess(String id_user_local,String Sistema)
		{
			addLog("---- Start saveUserLoginSuccess ...");
			
			hb_users data = null;
			VinUsers  aux = null;
			hb_devices auxDevices = null;
			
			try
			{
				
				autoGenUserExternal(id_user_local, Sistema); 
				
				auxDevices = new hb_devices();
				data = new hb_users();
				aux = data.getUser(id_user_local);

				//incrementamoe el numero de intentos
				int intentos = 0;
				aux.setIntentosLogin(intentos); //quitamos los intentos
				aux.setUuidLogin(UUID);
				
				//Dispositivo
				addLog("\n Device to save in login success: " + Device);
				aux.setVinDevicesByIdDispLogin(auxDevices.getDevice(Device));
				
				//guardamos
				data.updateRecord(aux);
				
				//Estadisticas
				String idProceso = "LOCAL";
				if (Sistema.equals("Meta4")){idProceso="Meta4";}
				new hb_statistics().insertEstadistics(id_user_local, idProceso, "Login success");

			}
			
			catch(Exception e)
			{
				addLog("ERROR -- saveUserLoginSuccess : " +e.getStackTrace());
			}			
			finally
			{
				auxDevices.close_session_user();
				data.close_session_user();
				data = null;
				aux = null;
				addLog("---- Ends saveUserLoginSuccess ...");
			}
		}
		
				// ---------------------------------------------------------------------------------------------				
				//Devuelve objeto de la clase con los datos necesarios para login y control de credenciales.
				// ---------------------------------------------------------------------------------------------
		
				public logonData getvalueUserOfTokenPerformance(String Token)
				{
					
					
					
					//creamos los objetos necesarios para extraer la informacion
					encriptAES encript = new encriptAES();
					hb_users_system a = null;
					hb_users b = null;
					List<?> aux;
					VinUsersSystem data;
					VinUsers usr;
					logonData dataSend = new logonData();
					
					// Control of Token Void
					if (Token.length() == 0) {
						return dataSend;
					}
					
					addLog("---- Start getvalueUserOfTokenPerformance ...");
					
					try{
						a = new hb_users_system();
						b = new hb_users();
						aux = a.getListaBaseTable("token_system='"+Token+"'"); //Filtramos por Token
						
						//si existe, sino error
						if (aux.size() > 0)
						{
							data = (VinUsersSystem)aux.get(0); //capturamos el usuario-sistema
							usr = b.getUser(data.getVinUsers().getIdUser());  //capturamos el usuario
							
							dataSend.idUserLocal= data.getVinUsers().getIdUser();
							dataSend.sysUser = data.getSysUser();
							dataSend.sysPassword = data.getSysPassword();
							dataSend.languaje = data.getIdiomaSession();
							dataSend.sysPasswordNoEncript= encript.decryptWithAES(data.getSysPassword());
							dataSend.idSystem = data.getVinSystems().getIdSystem();
							dataSend.uuidLogin = usr.getUuidLogin();
							dataSend.uuidAccess =  usr.getUuidAccess();
							dataSend.idDeviceLogin = usr.getVinDevicesByIdDispLogin().getIdDevice();
							dataSend.idDeviceAccess =  usr.getVinDevicesByIdDispAccess().getIdDevice();
							dataSend.idRole = usr.getVinRoles().getId();
							dataSend.keyCodeDDBB = data.getTokenSystem();
							dataSend.sociedad = usr.getIdOrganization();
							
							//si es el Sistema principal de logado, vericamos si el servidor es el mismo que el actual
							//Dado que el dispositivo puede estar "saltando" de un a otro backend gracias al Dispacher. Si pasa
							//esto debemos actualizar el servidor en el que está trabajando el usuario del dispositivo.
							
							String ServerIdBackend = new ParamsApp().SYSTEM_SERVER_ID;
							if (!data.getServerId().trim().equals(ServerIdBackend))
							{
								//Persist in DataDase the server ID new
								data.setServerId(ServerIdBackend);
								a.updateRecord(data);
								
								addLog("    Actualizado server id a =  ("+ ServerIdBackend +")");
							}

						}
					}
					catch(Exception e)
					{
						System.out.print("\n\nERROR (getvalueUserOfTokenPerformance): "+e.getStackTrace());
					}
					finally
					{
						a.close_session_user();
						b.close_session_user();
						usr = null;
						data = null;
						encript = null;
						a=null;
						b=null;
						aux = null;
						addLog("---- Ends getvalueUserOfTokenPerformance ...");
						
					}
					
					return dataSend;
					
				}					
				
				// ---------------------------------------------------------------------------------------------				
				// Revisa si el sistema lo tiene asignado el usuario (siendo este para todos los usuarios
				// ---------------------------------------------------------------------------------------------				
				public void validateUserSystemAsign(String userLocal, String idSystem)
				{
					//miramos si lo tiene el usuario
					hb_users_system data;
					hb_users dataUsr;
					hb_systems dataSys;
					
					VinUsersSystem usr;
					List<?> user ;
					VinSystems sys;
					try{
						
							data = new hb_users_system();
							
						
							if (data.getUserSystem(userLocal, idSystem).size()==0)
							{
							
								//Primero verifico que exista el usuario
								dataUsr = new hb_users();
								user = dataUsr.getListaBaseTable("id_user='"+userLocal+"'");
								
								if (user.size() > 0) //existe usuario
								{
									//Valido si el sistema es de tipo para todos los usuarios
									dataSys = new hb_systems();
									sys = (VinSystems)dataSys.getDataObject(idSystem);
									
									if (sys.getChkAllUsers()==1)
									{	
										//Asignamos el sistema al usuario
										usr = new VinUsersSystem();
										VinUsersSystemId usrAux = new VinUsersSystemId();
											usrAux.setIdSystem(idSystem);
											usrAux.setIdUser(userLocal);
										usr.setId(usrAux);
										data.addRecord(usr);
									}
								}
								
								dataUsr.close_session_user();
							}
							data.close_session_user();
						}
						catch (Exception e)
						{
							System.out.print("\n ERROR (validateUserSystemAsign) :"+e.getStackTrace());
						}
						finally
						{
							data = null;
							dataUsr=null;
							dataSys = null;
							usr=null;
						}
					
				}
				
				
				
				
				
				// Debug class
				protected void addLog(String info)
				{
						new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, ParamsApp.LOG_TYPE_INFO);
				}
				

				//Valida si el Token es correcto pero solo informativamente
				public boolean controlTokenTimeOutInfo(String Token)
				{
					hb_users_system a = null;
					List<?> aux = null;
					VinUsersSystem data = null;
					
					try{
						a = new hb_users_system();
							aux = a.getListaBaseTable("token_system='"+Token+"'"); //Filtramos por Token
							
							//si existe, sino error
							if (aux.size() > 0)
							{
								data = (VinUsersSystem)aux.get(0);
								Date date = new Date();
								
								if (data.getDtCadToken().compareTo(date)>0) //fecha grabada token mayor a la actual
								{
									return true; //ok
								}
								else
								{
									return false; //fail timeout
								}
							}
							else
							{
								return false; //no se encuentra el Token
							}
					}
					catch (Exception e)
					{
						System.out.print("\n ERROR (ControlTokenTimeOut) :"+e.getStackTrace());
						return false;
					}					
					finally
					{
					 a.close_session_user();
					 a=null;
					 aux = null;
					 data = null;
					 addLog("---- Ends ControlTokenTimeOut ...");
					}
					 
				}					
				

				// Devuelve si las credenciales de un sistema son fijas o no
				public boolean isSystemCredencialtheSameAllUsers(String idSystem)
				{
				
					addLog("---- Start isSystemCredencialtheSameAllUsers ...");
					hb_systems a = null;
					VinSystems data = null;
					boolean dev = false;
					
					try{
							a = new hb_systems();
							data = a.getDataObject(idSystem);
							
							if (data.getChkTokenLogin()==1) //esto indica que esas credenciales para todos los usuarios en este sistema
							{
								dev = true;
							}
					
							a.close_session_user();
					}
					catch (Exception e)
					{
						System.out.print("\n ERROR (isSystemCredencialtheSameAllUsers) :"+e.getStackTrace());
						return false;
					}					
					finally
					{
					 
					 a=null;
					 data = null;
					 addLog("---- Ends isSystemCredencialtheSameAllUsers ...");
					}
					 
					return dev;
				}					

				//Devuelve un objeto sistema
				public VinSystems getSystem(String idSystem)
				{
				
					addLog("---- Begin getSystem ...");
					hb_systems a = null;
					VinSystems data = null;
					
					
					try{
							a = new hb_systems();
							data = a.getDataObject(idSystem);
							a.close_session_user();
					}
					catch (Exception e)
					{
						System.out.print("\n ERROR (getSystem) :"+e.getStackTrace());
						return data;
					}						
					finally
					{
					 a.close_session_user();
					 a=null;
					 
					 addLog("---- Ends getSystem ...");
					}
					 
					return data;
				}					
				
}
