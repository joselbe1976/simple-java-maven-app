/* Equilibrha 2017
 * Jose Luis Bustos Esteban. 
 * Main web services Class
 */

package com.common.webservices;

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

public class WebServiceMain {

		public logonCredencialProcess userConected; //This object have information about user connected. 
	
	
		//Constructors
		public WebServiceMain()
		{
			new ParamsApp();
		}

		//Ping Method. No use now but can use in any moment
		public int ping(){return 1;}
	
	
	    // -------------------------------------------------------------------------------------
		// -------------------- LOGIN and SESSIONS  SOAP -----------------------------------------
		// -------------------------------------------------------------------------------------
		

		// this function do control session and Login. Depends of one or other params. Both never
		public  String controlSession(String serialKey64, String serialCredentials64)
		{
			logonMain session;
			String serial = "";
			
			try{
				
				//Tinnova. If comes Meta4 in serial from Devices and the System is Tinnova, we change to LOCAL the System in the serial
				if (ParamsApp.META4_PRODUCT.equals("TINNOVA") && serialCredentials64.length() > 1 && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL")) {
					serialCredentials64 = serialCredentials64.replace("{Meta4", "{LOCAL");
				}
				
				String serialKey = Base64.decode(serialKey64); //always is encripted
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
							new sendAsynTaskHelper().AsynInsertStadisticsServer(userConected.getData(userConected.getPosDefaultSystem()).user, "soap-token-validate", "Success");
					}
					else {
						new sendAsynTaskHelper().AsynInsertStadisticsServer(userConected.getData(userConected.getPosDefaultSystem()).user, "soap-token-validate", "Error to Validate token : " + serialKey );
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
						new sendAsynTaskHelper().AsynInsertStadisticsServer(userConected.getData(userConected.getPosDefaultSystem()).user, "loginSoap", "Login success");
					}
					else {
						new sendAsynTaskHelper().AsynInsertStadisticsServer(userConected.getData(userConected.getPosDefaultSystem()).user, "errorloginSoap", "Error Login Soap");
					}
				}
			}
			finally
			{
				session = null;
			}

			return Base64.encode(serial);
		}
		
		// this function is called by web service methods. Verify if user have permissions to exec this method.
		protected String internalControl(String serialKey64, String serialCredentials64 , String idProcess)
		{
			// Always do controlSession function
			String codeSerial = Base64.decode(this.controlSession(serialKey64, "")); //Decript

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
						{	//set the proicess
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
						new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SOAP, "Proceso de negocio ("+ idProcess + ") sin Parametrizar. No se ejecuta!!!!", ParamsApp.LOG_TYPE_ERROR);
					}
					
					try{
						//Stadistics Async
						new sendAsynTaskHelper().AsynInsertStadisticsServer(userConected.getData(userConected.getPosDefaultSystem()).user, idProcess, "Exec Soap process" );
					}
					catch(Exception e1)
					{
						e1.printStackTrace();
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
		//	{
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
						e.printStackTrace();
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
