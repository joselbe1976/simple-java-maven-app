/* --------------------------------------------------------
 * Equilibrha 2017.
 * Jose Luis Bustos Esteban
 * --------------------------------------------------------
 * Tools for Tinnova.
 */
package com.portalmobile.tinnova;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.config.literals.EqLiterals;
import com.common.globalSystems.login.logonCommon;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.hb_users;
import com.common.hibernate.classes.tinnova.hb_dynamic_actions;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.hibernate.entidades.VinDevices;
import com.common.hibernate.entidades.VinRoles;
import com.common.hibernate.entidades.VinUsers;
import com.common.tools.cache.documentsCache;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.mail.SendMail;
import com.portalmobile.meta4.funcional.Meta4LoginTinnova;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;


public class tiinova_backend_tools extends hb_main_tinnova implements iDisposable{

	/*
	 * When a user not have user o can't enter to the App because is block or data of Tinnova change or forgot the password
	 */
	
	ParamsApp IntParams ;
	private static String className = "";
	
	 public tiinova_backend_tools()
	 {
		 new ParamsApp();
		 new EqLiterals();
		 IntParams = new ParamsApp();
		 className = this.getClass().getSimpleName(); //Class name for logs
	 }
	
	
	 public void Dispose() {
		IntParams = null; 
	 }
	 
	public Double regenerateUserPasswordAndData(String mail, String numDoc, String PrimApp) {
		
		hb_users usrDB;
		VinUsers user;
		hb_dynamic_actions tinnovaDB;
		List<?> data;
		Meta4LoginTinnova tinnovaPN;
		VinUsers usr;
		VinDevices device;
		VinRoles rol;
		
		try {
			// Step 1.  Exist the User?
			
			usrDB = new hb_users();
			boolean existUsr = false;
			
			if (ParamsApp.META4_PRODUCT.equals("TINNOVA")  && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL")) {
				existUsr = usrDB.existLocalUser(numDoc);  //by Legal Document
			}
			else {
				//by document because the user ID is the same as peoplenet for tinnova. No NIF
				existUsr = usrDB.existLocalUserOfNif(numDoc);  //by Legal Document
			}
			
			// if exist the user, only is change the password
			if (existUsr) {
				
				
				if (ParamsApp.META4_PRODUCT.equals("TINNOVA")  && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL")) {
					user = usrDB.getUser(numDoc); 
				}
				else{
					user = usrDB.getUser(usrDB.getLocalUserOfNif(numDoc)); 
				}
				
				
				
				String newPass = getNewPassword( mail, numDoc, numDoc); //regenerate new password Automatic
				
				// we have to verify the Mail, primer App, and numDoc in Tinnova DataBase before to Change.
				
				tinnovaDB = new hb_dynamic_actions();
				String SQL = "SELECT * FROM MBL_EMPLEADOS_HOY WHERE ID_LEGAL = '" + numDoc + "'";
				data = tinnovaDB.getDataSQLNativo(SQL);
				
				// have data, employee exist by Id Legal
				if (data.size() > 0) {
					Map row = (Map)data.get(0); //Extract the row
					
					//verify the first Apell and Mail (case and Trim)
					if (row.get("APELLIDO_1").toString().toUpperCase().trim().equals(PrimApp.toUpperCase().trim()) && row.get("DIRECCION_MAIL").toString().toUpperCase().trim().equals(mail.toUpperCase().trim())) {
						// --------- All is OK. create the User ------------------
						boolean ret = false;
						
						//TODO: Si Tiinova + Peoplenet Login =  cambio clave peoplebet y sino en local. NO generar usuario en caso de peopelnet
						
						if (ParamsApp.META4_PRODUCT.equals("TINNOVA")  && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL")) {
							ret = usrDB.savePassword(numDoc, newPass); //save the new password Generate and encript in DataBase
						}
						else {
							//change the password in Peoplenet
							
							tinnovaPN = new Meta4LoginTinnova();
							ret = tinnovaPN.ChangePasswordPeoplenetTinnova( user.getIdUser().toString(), newPass);
						
						}
					
						if (ret) {
							
							//Copy Employee Data from Tinnova to the user of MySql
							recalcEmployeeUserData(numDoc);
							
							// now send a Email
							
							String subject = EqLiterals.MAIL_CHG_PASSWORD_SUBJECT;
							String body = EqLiterals.MAIL_CHG_PASSWORD_BODY_1;
							String signature = EqLiterals.MAILS_SIGNATURE;
							
							new SendMail().sendMail(mail, subject, body + newPass + signature); //Send
	
							return (double) 0; //OK
						}
						else {	return (double) -1; }//Error
					} else { return (double) -1; }//Error
				}else { 	return (double) -1; }//Error
				
		
			}
			else if (ParamsApp.META4_PRODUCT.equals("TINNOVA")  && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL")) {
				//not exits the user. Create if is Tiinova + LOCAL
				
				//vericate that user exist as Person in Tinnova
				tinnovaDB = new hb_dynamic_actions();
				
				//Find Employee as Id Legal by this DataBase View
				String SQL = "SELECT * FROM MBL_EMPLEADOS_HOY WHERE ID_LEGAL = '" + numDoc + "'";
				data = tinnovaDB.getDataSQLNativo(SQL);
				
				// have data, employee exist by Id Legal
				if (data.size() > 0) {
					Map row = (Map)data.get(0); //Extract the row
					
					//verify the first Apell and Mail (case and Trim)
					if (row.get("APELLIDO_1").toString().toUpperCase().trim().equals(PrimApp.toUpperCase().trim()) && row.get("DIRECCION_MAIL").toString().toUpperCase().trim().equals(mail.toUpperCase().trim())) {
						// --------- All is OK. create the User ------------------
						 usr = new VinUsers();
	
						usr.setIdUser(row.get("ID_LEGAL").toString());
						String comment = EqLiterals.GENUSERSAUTO_COMMENT;
						usr.setComment(comment);
						usr.setUserName(row.get("NOMBRE").toString() + " " + row.get("APELLIDO_1").toString() + " " + row.get("APELLIDO_2").toString());
						
						//devices
						device = new VinDevices();
						
						//device Acceso
						device.setIdDevice("0"); //ALL DEVICES
						usr.setVinDevicesByIdDispAccess(device);
						
						//device Login
						device.setIdDevice("0");
						usr.setVinDevicesByIdDispLogin(device);		
	
						//Role
						rol = new VinRoles();
						rol.setId(Integer.parseInt("300")); //Role portal mobile No admin
						usr.setVinRoles(rol);			
						
						usr.setUuidAccess(" ");
						usr.setVisible(1);//visible true
						usr.setPassword("0123456789"); //Default... after change it down in the code
						usr.setUuidLogin(" ");
						usr.setBloq(0); //default no blocked the user
						
						
						usr.setNif(row.get("ID_LEGAL").toString());
						usr.setIdEmpleadoRrhh(row.get("ID_EMPLEADO").toString());
						usr.setFaseAltaRrhh(row.get("FEC_ALTA_EMPLEADO").toString());
						usr.setIdOrganization(row.get("ID_SOCIEDAD").toString());
						
						//Save New User
						usrDB.addRecord(usr);
						
						//Update password
						String xmail = row.get("DIRECCION_MAIL").toString();
						String xid = row.get("ID_LEGAL").toString();
						String xprim = row.get("APELLIDO_1").toString();
						
						String NewPassowrd = getNewPassword(xmail, xid, xprim);
						usrDB.savePassword(row.get("ID_LEGAL").toString(), NewPassowrd); //save encript in dataBase MySql
						
						// --------- All is OK. Send Email to The user ------------------
						String subject = EqLiterals.MAIL_NEWUSER_SUBJECT;
						String body1 = EqLiterals.MAIL_NEWUSER_BODY_1;
						String body2 = EqLiterals.MAIL_NEWUSER_BODY_2;
						String signature = EqLiterals.MAILS_SIGNATURE;
						
						new SendMail().sendMail(mail, subject, body1 + numDoc + body2 + NewPassowrd + signature);
					}
					else { 	return (double) -1; } //Error mail or Apell1 fail
				}
				else { return (double) -1; }//Error no exist in Tinnova by Id legal
				
			}
			
			return 0.0; //OK
		
		}
		catch(Exception e) {
			IntParams.debugInfo("ERROR: regenerateUserPasswordAndData. : " + e.getMessage());
			return (double) -1;
		}
		finally {
			usrDB = null;
			user = null;
			tinnovaDB = null;
			data = null;
			tinnovaPN = null;
			usr = null;
		    device = null;
		    rol = null;
		}
		
		
	}
	
	
	//Change of Password (inside App with login and session OK)
	public Double chgPasswordUserApp(logonCredencialProcess userConected, String newPassword) {
		
		hb_users usrDB;
		Meta4LoginTinnova tinnovaPN;
		
		try {
		
				int posDefSystem = userConected.getPosDefaultSystem();
				String user = userConected.getData(posDefSystem).user;
				
				boolean ret = false;
				
				if (ParamsApp.META4_PRODUCT.equals("TINNOVA")  && ParamsApp.SYSTEM_LOGIN_DEFAULT.equals("LOCAL")) {
					//We create the User Object
					usrDB = new hb_users();
					ret = usrDB.savePassword(user, newPassword); //Change the Password and Encript Auto AES256
				}
				else {
					//change the password in Peoplenet
					
					tinnovaPN = new Meta4LoginTinnova();
					ret = tinnovaPN.ChangePasswordPeoplenetTinnova( userConected.getData(userConected.getPosDefaultSystem()).user, newPassword);
				}
				
				if (ret) { 	return (double) 0; 	} else {	return (double) -1; 	}
		}
		catch(Exception e) {
			IntParams.debugInfo("ERROR: chgPasswordUserApp. : " + e.getMessage());
			return (double) -1;
		}
		finally {
			usrDB = null;
			tinnovaPN = null;
		}

	}
	
	
	// Regenerate Password Algotim. Is the same as Peoplenet of Meta4
	private String getNewPassword(String mail, String numDoc, String PrimApp ) {
		Random randomGenerator = new Random();
		
		String mFinalPassWord = "";
		

		//Is the Same algothim of Peoplenet
		mFinalPassWord = mFinalPassWord + numDoc.toUpperCase().substring(2,3);
		mFinalPassWord = mFinalPassWord + numDoc.toUpperCase().substring(3,4);
		mFinalPassWord = mFinalPassWord + numDoc.toUpperCase().substring(5,6);

		mFinalPassWord = mFinalPassWord + String.valueOf(randomGenerator.nextInt(9));
		mFinalPassWord = mFinalPassWord + String.valueOf(randomGenerator.nextInt(9));

		mFinalPassWord = mFinalPassWord + PrimApp.toUpperCase().substring(2,3);
		mFinalPassWord = mFinalPassWord + PrimApp.toUpperCase().substring(3,4);

		mFinalPassWord = mFinalPassWord + String.valueOf(randomGenerator.nextInt(9));
		mFinalPassWord = mFinalPassWord + String.valueOf(randomGenerator.nextInt(1000));
		
		return mFinalPassWord;
		
	}
	
	
	
	// Recalculate the user data from Tinnova -> MySql User
	public void recalcEmployeeUserData(String UserLocal) {
		
		hb_users usrDB;
		VinUsers usrAux;
		VinUsers usr;
		hb_dynamic_actions tinnovaDB;
		List<?> data;
		
		try {
				//get connected user
				String localUser =  UserLocal;
				usrDB = new hb_users();
				usrAux =  usrDB.getUser(localUser);
				String idEmp    =  usrAux.getIdEmpleadoRrhh(); //get the id employee in Tinnova
				String IdSoc   = usrAux.getIdOrganization();
				usrAux = null;
				
				
				// Find into Tinnova
				tinnovaDB = new hb_dynamic_actions();
				
				//Find Employee as Id Legal by this DataBase View
				String SQL = "SELECT * FROM MBL_EMPLEADOS_HOY WHERE  ID_SOCIEDAD = '" +  IdSoc + "'  AND ID_EMPLEADO = '" + idEmp + "'";
				data = tinnovaDB.getDataSQLNativo(SQL);
				
				// have data, employee exist by Id Legal
				if (data.size() > 0) {
					Map row = (Map)data.get(0); //Extract the row
				
					// Update in MySql (Users)
					usr =  usrDB.getUser(localUser);
					if (usr != null) {
						
						String nameEmployee = row.get("NOMBRE").toString() + " " +  row.get("APELLIDO_1").toString();
						if (row.get("APELLIDO_1").toString().length() > 0) {
							nameEmployee += " " +  row.get("APELLIDO_2").toString();
						}
						
						usr.setUserName(nameEmployee); //nombre y apellidos del empleado
						usr.setNif(row.get("ID_LEGAL").toString());
						usr.setIdEmpleadoRrhh(row.get("ID_EMPLEADO").toString());
						usr.setFaseAltaRrhh(row.get("FEC_ALTA_EMPLEADO").toString());
						usr.setIdOrganization(row.get("ID_SOCIEDAD").toString());
						usr.setComment("Update Data from Tinnova and Unlock User");
						usr.setBloq(0); //Unlock
						
						//Save
						usrDB.updateRecord(usr);
						
					}
					
				}
				else {
					//Is not Hire today. Lock the User
					usr =  usrDB.getUser(localUser);
					if (usr != null) {
						usr.setComment("Automatic Block. The Employee is not Hire today");
						usr.setBloq(1); //bloq the user
						
						//Save
						usrDB.updateRecord(usr);
					
					}
				}
		}
		catch(Exception e) {
			IntParams.debugInfo("ERROR: recalcEmployeeUserData. : " + e.getMessage());
		}
		finally {
			usrDB=null;
			usrAux=null;
			usr=null;
			tinnovaDB=null;
			data=null;
		}
		
		
	}
		
	
	/*
	 * Regenarate the id organization, id employye and fecha de alta. Only for Tinnova + Portal
	 */
	public void recalcTinnovaUserDataWithPeopleNetUsers(String IdEmployeeTinnova, String userLocal) {
		
		hb_users usrDB;
		logonCommon comTool;
		hb_dynamic_actions tinnovaDB;
		VinUsers usr;
		VinUsers usrAux;
		
		try {
				//get connected user
				String localUser =  userLocal;
				usrDB = new hb_users();
				usrAux =  usrDB.getUser(localUser); //get the MySql User
				
				if (usrAux == null) {
					//no existe el usuario creado en MySql lo generamos
					comTool = new logonCommon();
					comTool.autoGenUserExternal(localUser, "Meta4"); //siempre es el sistema meta4 en este caso porque es algo propio de tinnova
					usrAux =  usrDB.getUser(localUser); 
				}
				
				String IdSoc   = IdEmployeeTinnova.substring(0, 2); //extracc the  Organization first 2 characters
				String idEmp = IdEmployeeTinnova.substring(2);

				usrAux = null;
				
				
				// Find into Tinnova
				tinnovaDB = new hb_dynamic_actions();
				
				//Find Employee as Id Legal by this DataBase View
				String SQL = "SELECT * FROM MBL_EMPLEADOS_HOY WHERE  ID_SOCIEDAD = '" +  IdSoc + "'  AND ID_EMPLEADO = '" + idEmp + "'";
				List<?> data = tinnovaDB.getDataSQLNativo(SQL);
				
				// have data, employee exist by Id Legal
				if (data.size() > 0) {
					Map row = (Map)data.get(0); //Extract the row
				
					// Update in MySql (Users)
					usr =  usrDB.getUser(localUser);
					if (usr != null) {
						
						String nameEmployee = row.get("NOMBRE").toString() + " " +  row.get("APELLIDO_1").toString();
						if (row.get("APELLIDO_1").toString().length() > 0) {
							nameEmployee += " " +  row.get("APELLIDO_2").toString();
						}
						
						usr.setUserName(nameEmployee); //nombre y apellidos del empleado
						usr.setNif(row.get("ID_LEGAL").toString()); //NIF
						usr.setIdEmpleadoRrhh(row.get("ID_EMPLEADO").toString());
						usr.setFaseAltaRrhh(row.get("FEC_ALTA_EMPLEADO").toString());
						usr.setIdOrganization(row.get("ID_SOCIEDAD").toString());
						usr.setComment("Update Data from Tinnova and Unlock User");
						usr.setBloq(0); //Unlock
						
						//Save
						usrDB.updateRecord(usr);
						
					}
					
				}
		}
		catch(Exception e) {
			IntParams.debugInfo("ERROR: recalcTinnovaUserDataWithPeopleNetUsers : " + e.getMessage());
		}
		finally {
			usrDB=null;
			comTool=null;
			tinnovaDB=null;
			usr=null;
			usrAux=null;
		}
				
		
	}
	
	
		
	/* Read files remotes and copy To Local Control of Security in remote
	*  Return absolute Path in Local.
	*/
	public String readRemoteFilesToLocal(String absolutePath, String SerialKey, Boolean useRecibos) {
		
		NtlmPasswordAuthentication auth;
		byte[] buffer;
		FileOutputStream osf ;
		
		try {
				//Get params
				String Domain = ParamsApp.SERVER_REMOTE_FILES_DOMAIN;
				String haveSecurity = ParamsApp.SERVER_REMOTE_FILES_HAVE_SECURITY;
				String pass = ParamsApp.SERVER_REMOTE_FILES_PASS;
				String user = ParamsApp.SERVER_REMOTE_FILES_USER;
				String ToFindReplace = ParamsApp.SERVER_REMOTE_FILES_PATH_TO_REPLACE;
				String Textreplace = ParamsApp.SERVER_REMOTE_FILES_NEW_PATH;		
				String TempDirectory = ParamsApp.WEBSERVICE_TEMP_DIRECTORY;
				
				//recibos salarios
				if (useRecibos) {
					ToFindReplace = ParamsApp.SERVER_REMOTE_FILES_PATH_TO_REPLACE_RECIBOS;
					Textreplace = ParamsApp.SERVER_REMOTE_FILES_NEW_PATH_RECIBOS;	
				}
				
				
				String serial = SerialKey.replace("/", "").replace("=", "");
				String tempNewFile = TempDirectory + "/remote_"+ serial + "." + new ParamsApp().getExtensionFile(absolutePath);
		
			
				//replaces for create the correct remote path
				String FinalPath = absolutePath.replace(ToFindReplace, Textreplace);
				FinalPath = FinalPath.replace("\\","/");
				//FinalPath = "smb://"  + Domain + "/" + FinalPath;
				FinalPath = "smb://"  + Domain + "/" +  FinalPath;
				// If there are Security or not
				
				if (haveSecurity.toUpperCase().trim().equals("Y")) {
					auth = new NtlmPasswordAuthentication("", user, pass); 
					buffer = new byte[1024 * 10]; //10kb readings
					try (InputStream in = new SmbFile(FinalPath, auth).getInputStream()) {
						
							//generate New File
							osf = new FileOutputStream(new File(tempNewFile));  
							
					          //generate New File 
					          int size = 0;
							  
							  while ((size=in.read(buffer))> -1)
							  {
								  osf.write(buffer,0,size);
							  }
							  osf.flush();
							  osf.close();//Close local File
							  in.close(); //close remote File
		
							  return tempNewFile; //return Path to the file
		
					} catch (IOException e) {
					    // Handle IOException
						System.out.println("ERROR: (readRemoteFilesToLocal): "+e.getMessage());
						return "";
					}
					
				}
		
				return "";
		}
		catch(Exception e) {
			System.out.println("ERROR: (readRemoteFilesToLocal): "+e.getMessage());
			return "";
		}
		finally {
			auth=null;
			buffer=null;
			osf=null ;
		}
	}


	//return Value Param. 
	public String getValueParams(String sociedad, String IdParam) {
		hb_mobile_functions_tinnova aux = null;
		documentsCache cache = null;
		String data = "";
		
		try {
			aux = new hb_mobile_functions_tinnova();
			//Sql Common
			String SQL = "SELECT  VALOR FROM EQ_MBL_PARAMS WHERE ID_SOCIEDAD = '" + sociedad + "' AND ID_PARAM = '" + IdParam + "'";
			
			if (ParamsApp.SYSTEM_REDIS == 1) {
				// Redis Cache Server
				cache = new documentsCache();
				String fileCache = sociedad + "_CACHEDATA_PARAMS_" + IdParam;
				
				//Verify if is in cache.
				String FileCacheImagen = cache.getCacheFileListImage(fileCache); //¿Exist in cache?
				
				if (!FileCacheImagen.equals("")) {
					//exists cache y server Redis
					data = cache.getCacheData(fileCache);
				}
				else {
					//No in cache server. Cache all params
					cacheParamsConstrol(sociedad);
					//get cache
					data = cache.getCacheData(fileCache);
				}
			}
			else {
				// NO Redis Cache Server. Find direct to DataBase
				data = getDBValueSql(SQL,"VALOR");
			}
		}
		catch(Exception e){
			System.out.print("ERROR: (getValueParamsDataBase) " + e.getMessage() + "\n" + e.getStackTrace().toString());
		}
		finally {
			if (aux != null) {aux.Dispose();}
			aux = null;
			cache = null;
		}
		return data;
		
	}
	
	
	//this method control the cache Data in cache server of Params (table of Sql Server)
	@SuppressWarnings("rawtypes")
	private void cacheParamsConstrol(String sociedad) {
		hb_mobile_functions_tinnova aux = null;
		Map row =null;
		documentsCache cache = null;
		
		//Only execute this method if Redis Cache Server is ON
		if (ParamsApp.SYSTEM_REDIS != 1) {
			return;
		}
		
		try {
			//dependences
			aux = new hb_mobile_functions_tinnova();
			cache = new documentsCache();
			
			
			// Read of Sql Table all Keys and Save on Redis server
			String SQL = "SELECT ID_SOCIEDAD, ID_PARAM, VALOR FROM EQ_MBL_PARAMS WHERE ID_SOCIEDAD = '" + sociedad + "'";
			List<?> data  = aux.getDataSQLNativo(SQL);
			
			for (int i = 0; i < data.size(); i++) {
				row = (Map)data.get(i);
				String fileCache = sociedad + "_CACHEDATA_PARAMS_" + row.get("ID_PARAM").toString();
				
				//Verify if is in cache.
				String FileCacheImagen = cache.getCacheFileListImage(fileCache); //¿Exist in cache?
				if (FileCacheImagen.equals("")) {
					cache.cacheData(fileCache, row.get("VALOR").toString()); //cache in Redis Server
				}
			}
		}
		catch(Exception e) {
			System.out.print("ERROR: (cacheParamsConstrol) " + e.getMessage() + "\n" + e.getStackTrace().toString());
		}
		finally {
			if (aux != null){aux.Dispose();}
			aux = null;
			cache = null;
			row = null;
			
		
		}
		
	}

	
	//return name of Employee id and organization
	@SuppressWarnings("rawtypes")
	public String getNameOfEmployee(String sociedad, String idHr) {
		
		String SQL = "select NOMBRE, APELLIDO_1, APELLIDO_2 from MBL_EMPLEADOS_LISTA WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEADO = '"+idHr+"'";
		String name = "";
		hb_mobile_functions_tinnova aux = null;
		Map row =null;
		
		try {
			aux = new hb_mobile_functions_tinnova();
			
			List<?> data  = aux.getDataSQLNativo(SQL);
			if (data.size() > 0) {
				row = (Map)data.get(0);
				
				//Create the employee name. 
				name =row.get("NOMBRE").toString() + " " + row.get("APELLIDO_1").toString();
				if (row.get("APELLIDO_2").toString().length() > 0) {
					name += " " + row.get("APELLIDO_1").toString();
				}
			}
		}	
		catch(Exception e) {
			
		}
		finally {
			row = null;
			if (aux != null) {aux.Dispose();}
			aux = null;
		}
		
		return name;
	}
	
	
	//return idHR of manager
	public String getManagerOfEmployee(String sociedad , String idHR) {
		//Fist We calc departament of employee and responsable of this departament
		String Sql = "SELECT B.ID_RESPONSABLE  AS IDHR FROM MBL_EMPLEADOS_BUSCADOR A, M4T_DEPARTAMENTOS B   WHERE A.ID_DEPARTAMENTO = B.ID_DEPARTAMENTO AND A.ID_SOCIEDAD = B.ID_SOCIEDAD AND  A.ID_SOCIEDAD = '"+sociedad+"' AND A.ID_EMPLEADO = '"+idHR+"'";
		return this.getDBValueSql(Sql, "IDHR");
		
	}
	
	//return mail of idHR
	public String getMailOfEmployee(String sociedad, String idHr) {
		String Sql = "SELECT DIRECCION_MAIL FROM MBL_EMPLEADOS_LISTA WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEADO = '"+idHr+"'";
		return this.getDBValueSql(Sql, "DIRECCION_MAIL");
	}
	
	//return phone extension of idHr
	public String getPhoneExtension(String sociedad, String idHr) {
		String Sql = "SELECT EXTENSION_TELEF FROM M4T_FASES_ALTA WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEADO = '"+idHr+"' AND FEC_BAJA IS NULL ";
		return this.getDBValueSql(Sql, "EXTENSION_TELEF");
	}
	
	
	// -------------- < Auxiliar Functions > ----------------------
	
	
			//Return one value of one column. Only 1 record no more.
			
			@SuppressWarnings("rawtypes")
			public String getDBValueSql(String Sql, String columna)
			{
				
				addLog("getDBValueSql \n Sql    : " + Sql  +"\nColumna:" + columna + "\n",ParamsApp.LOG_TYPE_INFO);
				
				List<?> data  = null;
				Map row = null;
				try{
					data = getDataSQLNativo(Sql);
					if (data != null)
					{
						if (data.size() != 0)
						{
							row = (Map)data.get(0); //extraemos la filA
							return row.get(columna).toString();
						}
						else {	return "";	}
					}
					else { 	return "";	}
				}
				catch(Exception e)
				{
					addLog("getDBValueSql : " + e.getMessage(),ParamsApp.LOG_TYPE_ERROR);
					return "";
				}
				finally {
					data = null;
					row = null;
				}
				
				
			}
			
			
			// Return Ordinal Notification to add to table
			public int getOrdinalNewNotification(String sociedad, String IdEmpleado){
				String SQL  = "SELECT MAX(ORDINAL) AS NUM FROM EQ_MBL_NOTIFICATIONS WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEADO = '"+IdEmpleado+"'";
				String NumAux = getDBValueSql(SQL, "NUM");
				
				if (NumAux.equals("")) {
					return 1;
				}
				else {
					return  Integer.parseInt(NumAux) + 1;
				}
			}
			
			//Add Record to notification table.
			public Boolean addNotification(String sociedad, String idEmpleado, String Mensaje, String comentarios) {
				
				int ordinal = this.getOrdinalNewNotification(sociedad, idEmpleado);
				
				//create the hibernate command Insert
				String SqlInsert = "INSERT INTO EQ_MBL_NOTIFICATIONS   (ID_SOCIEDAD, ID_EMPLEADO, ORDINAL, MENSAJE,FECHA_ENVIO, FECHA_CADUCIDAD, CHECK_RECIBIDO, CHK_DEL_MOBILE,DESCRIPCION ) ";
				SqlInsert += "VALUES (:sociedad, :empleado, :ordinal, :mensaje,:fechaenvio, :fechacad, :chckrecibido, :chckdelete, :descrip)";
				
				SQLQuery query  = this.getSqlQuery(SqlInsert);
				query.setParameter("sociedad", sociedad);
				query.setParameter("empleado", idEmpleado);
				query.setParameter("ordinal", ordinal);
				query.setParameter("mensaje", comentarios);
				
				Calendar cal = Calendar.getInstance(); 
				java.sql.Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
				cal.setTime(new Date());
				
				//Get param of Cadud days
				String dayS = this.getValueParams(sociedad, "NOTIF_DIAS_CAD");
				if (dayS.equals("")) {
					dayS = "45"; //if not param by default
				}
				int days = Integer.parseInt(dayS);
				cal.add(Calendar.DATE, days);  // number of days to add 45 by default
				Date cadudcidad = cal.getTime();

				
				query.setTimestamp("fechaenvio", new Date());
				query.setParameter("fechacad", cadudcidad);
				query.setParameter("chckrecibido", "0");
				query.setParameter("chckdelete", "0");
				query.setParameter("descrip", Mensaje);

				int dev = executeSqlAdvance(query); //execute the insert
				
				if (dev == 0) {
					return true;
				}
				else {
					return false;
				}
			}
			
			
			//format the Query String. If Is Sql or Oracle here we can change the format String for apply Filters in DataBase
			// Default: Sql Server.
			public String getFormatDateFilter(String Date) {
				return "'" + Date.replace("-", "") + "'"; //Delete "-" for firler
			}
			
			// create the ID Employee to send Device. Default: Sociedad = 2 digits Allways. Change if one client is diferent
			public String getCreateIdEmployeeComp(String idEmployee, String idSociedad) {
				return idSociedad+idEmployee;
			}
			// return id Sociedad
			public String getSociedadRealOfIdEmployeeComp(String IdEmployeeComp){
				return IdEmployeeComp.substring(0, 2);
			}
			
			//return the Id employee 
			public String getIdEmployeeRealOfIdEmployeeComp(String IdEmployeeComp) {
				int max = IdEmployeeComp.length();
				return IdEmployeeComp.substring(2, max);
			}
			
			
			// Debug class
			protected void addLog(String info, int logType)
			{
					new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
			}
			
	
	
}
