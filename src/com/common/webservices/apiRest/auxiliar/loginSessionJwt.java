package com.common.webservices.apiRest.auxiliar;

import com.Ostermiller.util.Base64;
import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.globalSystems.login.logonMain;
import com.common.hibernate.classes.hb_process;
import com.common.hibernate.classes.hb_statistics;
import com.common.hibernate.classes.hb_users;
import com.common.hibernate.entidades.VinProcess;
import com.common.hibernate.entidades.VinUsers;
import com.common.server.tools.sendAsynTaskHelper;

public class loginSessionJwt {
	
	
	public logonCredencialProcess userConected; 
	
	// this function do control session and Login. Depends of one or other params. Both never
	public  String JWTcontrolSession(String serialKey64, String serialCredentials64)
	{
		logonMain session;
		String serial = "";
		
		try{
			
			//Tinnova. If comes Meta4 in serial from Devices and the System is Tinnova, we change to LOCAL the System in the serial
			if (ParamsApp.META4_PRODUCT.equals("TINNOVA") && serialCredentials64.length() > 1 && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL")) {
				serialCredentials64 = serialCredentials64.replace("{Meta4", "{LOCAL");
			}
			
			String serialKey = Base64.decode(serialKey64); // Encripted 
			String serialCredentials = serialCredentials64;
			
			//decode base64
			if (ParamsApp.WEBSERVICE_ENCRIPT_CREDENTIALS.endsWith("1"))
			{
				serialCredentials = Base64.decode(serialCredentials);
			}
			
			session = new logonMain();
			if (!serialKey.equals(""))
			{
				// We verify is active the token
				serial = session.controlSessionSystem(serialKey);
				
				//Generate user credentials
				if (!serial.equals(""))
				{
						//Credential is not caching
						userConected = new logonCredencialProcess();
						userConected.loadDataFromSerial(serial);
				}
				else {
					new sendAsynTaskHelper().AsynInsertStadisticsServer(userConected.getData(userConected.getPosDefaultSystem()).user, "rest-token-validate", "Error to Validate token: " + serialKey );
				}
			}
			else
			{
				//login System
				serial = session.logonSystemBySerialCredentials(serialCredentials);
				if (!serial.equals(""))
				{
					//Credential is not caching
					userConected = new logonCredencialProcess();
					userConected.clcCredenciales(serialCredentials);
					
					// async insert
			 		new sendAsynTaskHelper().AsynInsertStadisticsServer(userConected.getData(userConected.getPosDefaultSystem()).user, "rest-login", "Login Api Rest Success");
				}
				else {
					new sendAsynTaskHelper().AsynInsertStadisticsServer(userConected.getData(userConected.getPosDefaultSystem()).user, "rest-login", "Error to  Login");
				}
			}
		}
		catch(Exception e) {
			serial = "";
		}
		finally
		{
			session = null;
		}

		return Base64.encode(serial);
	}
	
	// this function is called by web service methods. Verify if user have permissions to exec this method.
	public String JWTinternalControl(String serialKey64, String serialCredentials64 , String idProcess)
	{
		// Always do controlSession function
		String codeSerial = Base64.decode(this.JWTcontrolSession(serialKey64, "")); //Decript
		
		if (!codeSerial.equals(""))
		{
			hb_process data = null;
			VinProcess pro=null;
			logonMain session;

			try{
				data = new hb_process();
				pro = data.getDataObject(idProcess); //get the process
				//if is configured the system
				if (pro!=null && pro.getIdProcess() != null)
				{
					if (userConected != null)
					{	//set the process
						userConected.SerialKeyMainReturnApps = codeSerial;  //Serial Main
						userConected.idProcessExec = idProcess;
						
						//positiion iof the system
						int pos = userConected.getPosOfSystem(pro.getVinSystems().getIdSystem()); 
						
						if (pos!=-1)
						{
							String serialSystemaProceso = userConected.getData(pos).KeyCode; //Serial del sistema del proceso
							
							//Serial (keycode) different storage in data base and the actual login
							if (!serialSystemaProceso.equals(userConected))
							{
								//Manual Login
								session = new logonMain();
								String devSerialOtherSystem = session.controlSessionSystem(serialSystemaProceso);
								
								//If is empply = No access
								if (devSerialOtherSystem.equals(""))
								{
									//no access permit
									codeSerial="";
									userConected.SerialKeyForIdProcess="";
								} 
								else
								{
									userConected.SerialKeyForIdProcess=devSerialOtherSystem; //keyCode OK
								}
							}
						}
					}
				}
				else
				{
					new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_API_REST, "Proceso de negocio JWT ("+ idProcess + ") sin Parametrizar. No se ejecuta!!!!", ParamsApp.LOG_TYPE_ERROR);
				}
				
				try{
					//Stadistics Insert Asyn
					int pos = userConected.getPosDefaultSystem();
					new sendAsynTaskHelper().AsynInsertStadisticsServer(userConected.getData(pos).user, idProcess, "Exec API REST process");

				}
				catch(Exception e1)
				{
					new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_API_REST, "Exception Error:" + e1.getStackTrace(), ParamsApp.LOG_TYPE_ERROR);
				}
				finally{}
		
			}
			finally{
				data.close_session_user();
				data=null;
				pro=null;
				session=null;
						
			}
		}

		
		new ParamsApp();
		//if is Tinnova System
 	//	if (ParamsApp.META4_PRODUCT.equals("TINNOVA"))
//		{
			int pos = userConected.getPosDefaultSystem();
			
			//If sociedad, id employee or fase alta is NULL we are goint to find it.
			if (userConected.getData(pos).sociedad == null || userConected.getData(pos).id_persona == null || userConected.getData(pos).fase_alta == null || userConected.getData(pos).fase_alta.trim().length() <= 0 || userConected.getData(pos).id_persona.trim().length() <= 0)
			{
				VinUsers vu = null;
				hb_users hnuser = null;
		
				try{
					hnuser = new hb_users();
					vu = hnuser.getUser(userConected.getData(pos).user);
					
					if (vu != null)
					{
						//Find Data
						userConected.getData(pos).id_persona= vu.getIdEmpleadoRrhh();
						userConected.getData(pos).sociedad = vu.getIdOrganization(); 
						userConected.getData(pos).fase_alta= vu.getFaseAltaRrhh();
						
					}
				}
				catch(Exception e)
				{
					new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_API_REST, "Exception Error  :" + e.getStackTrace(), ParamsApp.LOG_TYPE_ERROR);
				}
				finally
				{
					hnuser = null;
					vu = null;
				}
			}

	//	}
		return codeSerial;
	}

}
