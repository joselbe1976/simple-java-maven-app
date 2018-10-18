/*
 * Jose Luis Bustos Esteban. Pushy 
 */
package com.common.pushnotifications.Parse;


import java.util.List;
import org.json.*;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logon;
import com.common.hibernate.classes.hb_systems;
import com.common.hibernate.classes.hb_users;
import com.common.hibernate.classes.hb_users_system;
import com.common.hibernate.entidades.VinSystems;
import com.common.hibernate.entidades.VinUsers;
import com.common.hibernate.entidades.VinUsersSystem;
import com.common.hibernate.entidades.VinUsersSystemId;
import com.common.pushnotifications.pushy.pushyOperations;



public class parseOperations {
	
	private static String className = "";
	
	private pushyOperations pushyOPer;

	private String usersSend="";
	public int totalUsuarios = 0;
	
	
	//constructores
	public parseOperations()
	{
		//Instancio
		pushyOPer = new pushyOperations();
	}
	
	public String getUsersSend(){
		
		return usersSend;
	}
	
	
	//Destructores
	protected void finalize()
	{
		pushyOPer = null;
	}
	

	/*
	 *  -------------------------------------------------------------------------------------------------
	 *  - -   ENVIO DE MENSAJES PUSH CON PUSHY
	 *  -------------------------------------------------------------------------------------------------
	 */
	
	//envio notificacion a una instalacion Pushy
	public void sendPushNotification(String  menssage, String pushyIdDispositivo, String argsApps)
	{
			this.pushyOPer.sendPushyPushNotification(pushyIdDispositivo, menssage, argsApps);
		
	}
	
	
	//envio a un channel completo. Devuelve numero dispositivos enviados
	public int sendPushNotificationChannel(String  menssage, String Channel, String argsApps)
	{
		usersSend = "";
		totalUsuarios = 0;
		
		addLog("\n<sendPushNotificationChannel>",ParamsApp.LOG_TYPE_INFO);
		addLog("   ----------------------------------------",ParamsApp.LOG_TYPE_INFO);
		addLog("   Argumentos: ",ParamsApp.LOG_TYPE_INFO);
		addLog("      -  menssage :"+menssage,ParamsApp.LOG_TYPE_INFO);
		addLog("      -  Channel  :"+Channel,ParamsApp.LOG_TYPE_INFO);
		addLog("   ----------------------------------------",ParamsApp.LOG_TYPE_INFO);
		
		
		hb_users_system data ;
		VinUsersSystem usr;
		VinUsers usuario;
		hb_users dataUser;
		int NumEnvios = 0;
		try{
			data = new hb_users_system();
			dataUser = new hb_users();
			
			@SuppressWarnings("unchecked")
			List<VinUsersSystem> dataAux =  (List<VinUsersSystem>) data.getUsersSystem(logon.SYSTEM_PARSE);
			
			addLog("   Usuarios que tienen Pushy asignado : " + dataAux.size(),ParamsApp.LOG_TYPE_INFO);
			
			//recorremos cada usuario
			
			String EmpleadoCanal, RoleCanal, DisposCanal, SistemaCanal, AllUsers = "*";
			
			totalUsuarios = dataAux.size();
			for (int z = 0; z < dataAux.size(); z++)
			{
				//inicializo los canales del empleado
				EmpleadoCanal ="";
				RoleCanal="";
				DisposCanal= "";
				SistemaCanal = "";
	
				//recojo cada empleado y miro si tiene Token del sistema Pushy
				usr = dataAux.get(z);
				
				if (usr != null){
					addLog("   - Usuario " + usr.getVinUsers().getIdUser(),ParamsApp.LOG_TYPE_INFO);
					
					if (!usr.getTokenSystem().equals("")){
						
						
						EmpleadoCanal = usr.getVinUsers().getIdUser();
						
						//creamos un objeto usuario
						usuario = dataUser.getUser(EmpleadoCanal);
						
						RoleCanal = usuario.getVinRoles().getParseChannel();
						DisposCanal = usuario.getVinDevicesByIdDispAccess().getParseChannel();
						
						
						addLog("      - Canales del usuario:",ParamsApp.LOG_TYPE_INFO);
						addLog("      		- Usuario    :"+EmpleadoCanal,ParamsApp.LOG_TYPE_INFO);
						addLog("      		- Role       :"+RoleCanal,ParamsApp.LOG_TYPE_INFO);
						addLog("      		- Dispositivo:"+DisposCanal,ParamsApp.LOG_TYPE_INFO);
						addLog("      		- Todos (*)  :"+AllUsers,ParamsApp.LOG_TYPE_INFO);
						
						//si uno de los canales lo tiene, se lo envio al empleado o es una canal *
						
						if (Channel.equals(EmpleadoCanal) || Channel.equals(RoleCanal) || Channel.equals(DisposCanal) || Channel.equals(AllUsers))
						{
							addLog("      - ENVIAMOS POR PUSHY ...",ParamsApp.LOG_TYPE_INFO);
							if (this.pushyOPer.sendPushyPushNotification(usr.getTokenSystem(), menssage, argsApps) == 0)
							{
								NumEnvios++;
								if (!usersSend.equals("")){usersSend+=" , ";}
								usersSend = usersSend  + EmpleadoCanal ;
							}
							
						}
						
					} //if
					else
					{
						addLog("      - No se trata porque no tiene id instalacion",ParamsApp.LOG_TYPE_INFO);
					}
					
				}//if
				else
				{
					
				}
			}
			
		}//try
		catch(Exception e)
		{
			System.out.println("Error clase ParseOPerations : " + e.getStackTrace());
			
		}
		finally{
			dataUser = null;
			data = null;
			
		}
		
		return NumEnvios;
	}

	//Envio a un usuario concreto.
		public int sendPushNotificationUser(String  menssage, String user, String argsApps)
		{
			
			hb_users_system data ;
			VinUsersSystem usr;
			try{
				data = new hb_users_system();
				usr = (VinUsersSystem)data.getUserSystem(user, logon.SYSTEM_PARSE).get(0);
				
				if (usr != null){
					if (!usr.getTokenSystem().equals("")){
						
						addLog("\\n____________________[ Pushy ]___________________________",ParamsApp.LOG_TYPE_INFO);
						addLog("Envio usuario: " + user,ParamsApp.LOG_TYPE_INFO);
						addLog("Envio texto  : " + menssage,ParamsApp.LOG_TYPE_INFO);
						return this.pushyOPer.sendPushyPushNotification(usr.getTokenSystem(), menssage, argsApps);
					}
					else{}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return -1;
		}


	
	public void parseLoginVerification(String deviceToken, String user)
	{
		
		addLog("\n< inicio parseLoginVerification>",ParamsApp.LOG_TYPE_INFO);
		addLog("   ----------------------------------------",ParamsApp.LOG_TYPE_INFO);
		addLog("   Argumentos: ",ParamsApp.LOG_TYPE_INFO);
		addLog("      -  deviceToken:"+deviceToken,ParamsApp.LOG_TYPE_INFO);
		addLog("      -  user       :"+user,ParamsApp.LOG_TYPE_INFO);
		addLog("   ----------------------------------------",ParamsApp.LOG_TYPE_INFO);
		
		
		
		
		//Sui no viene tokenParse entonces no hacemos nada.
		if (deviceToken.equals("")){return;}
		
		
		//Buscamos el usuario/system si lo tiene.
		hb_users_system data = new hb_users_system();
		VinUsersSystem usr = new VinUsersSystem();
		VinUsersSystemId usrId = new VinUsersSystemId();
		
		VinSystems sistema = new VinSystems();
		hb_systems syss = new hb_systems();
		
		sistema = syss.getDataObject(logon.SYSTEM_PARSE);
		
		
		usr = null;

		try{
		  usr = (VinUsersSystem)data.getUserSystem(user, logon.SYSTEM_PARSE).get(0);
		  
		  if (usr!=null)
		  {
			  usr.setTokenSystem(deviceToken); //actualizamos el token
			  data.updateRecord(usr);
			  
		  }
		  
		}
		catch(Exception zz){}
		boolean isNew=false;
		
		if (usr == null && sistema.getChkAllUsers() == 1) //si no tiene asignado el sistema parse y es autoasigable
		{
			addLog("   Sin sistema Parse asignado.. lo asignamos automaticamente...",ParamsApp.LOG_TYPE_INFO);
			//creamos el sistema Parse.com
			usrId.setIdUser(user);
			usrId.setIdSystem(logon.SYSTEM_PARSE);
			usr = new VinUsersSystem();
			usr.setId(usrId);
			usr.setTokenSystem(deviceToken);
			data.addRecord(usr); //save
			usr = (VinUsersSystem)data.getUserSystem(user, logon.SYSTEM_PARSE).get(0);
			isNew = true;
		}
		else
		{
			addLog("   Salimos sin hacer nada. Sistema Parse no es autoasignable.",ParamsApp.LOG_TYPE_INFO);
	
		}

		if (isNew == true) //recargamos el objeto
		{
			usr = (VinUsersSystem)data.getUserSystem(user, logon.SYSTEM_PARSE).get(0);
		}
		

		
		usr=null;
		usrId=null;
		data.close_session_user();
		data = null;
		
		
		addLog("< Fin parseLoginVerification>",ParamsApp.LOG_TYPE_INFO);
		
	}
	 
	
	
	//una vez no pasan el resultado de la grabacion, grabamos en la bbdd
	private String saveDataUserParser(String user, String resultJson)
	{
		
		JSONObject myObjectRes;
		hb_users_system data ;
		VinUsersSystem usr;
		String result="";
		JSONArray channels;

		
		addLog("\n< inicio saveDataUserParser >",ParamsApp.LOG_TYPE_INFO);
		addLog("    ------------------------------------------------",ParamsApp.LOG_TYPE_INFO);
		addLog("    Argumentos:",ParamsApp.LOG_TYPE_INFO);
		addLog("       -user    :"+user.toString(),ParamsApp.LOG_TYPE_INFO);
		addLog("       -resultJson :"+resultJson.toString(),ParamsApp.LOG_TYPE_INFO);
		addLog("    ------------------------------------------------",ParamsApp.LOG_TYPE_INFO);
		
		
		try
		{
			myObjectRes = new JSONObject(resultJson);

			String token = myObjectRes.getString("deviceToken"); //devielvemos el device token (a veces cambia)
			channels = myObjectRes.getJSONArray("channels"); //devielvemos los channels
			
			String cha="";
			for (int i = 0; i<channels.length(); i++)
			{
				cha+=channels.getString(i).toString().replace("\"", "").replace(" ", "");
				if (i < channels.length() -1)
				{
					cha+= ",";
				}
			}
			
			result = token;
			//buscamos el sistema asociado al usuario
			data = new hb_users_system();
			usr = new VinUsersSystem();
	
			usr = (VinUsersSystem)data.getUserSystem(user, logon.SYSTEM_PARSE).get(0);
			usr.setTokenSystem(token);
			usr.setParseChannels(cha);

			//grabamos
			data.updateRecord(usr);
			data.close_session_user();
			addLog("   >Grabacion correcta",ParamsApp.LOG_TYPE_INFO);
			
			
		}
		catch(Exception e)
		{
			addLog(e.getMessage().toString(),ParamsApp.LOG_TYPE_ERROR);
		}
		finally{
			//liberamos recursos
			myObjectRes = null;
			data = null;
			usr=null;
			channels = null;
		}
		
		addLog("< fin saveDataUserParser >",ParamsApp.LOG_TYPE_INFO);
		
		return result;
		
		//return "";
	}
	
		
		

	// Debug class
	protected void addLog(String info, int logType)
	{
			new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
	}
	
	
}
