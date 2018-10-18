/*
--------------------------------------------------------------------------------------------
Jos� Luis Bustos Esteban23
--------------------------------------------------------------------------------------------
Funciones mas usadas y parametros de la aplicación.
--------------------------------------------------------------------------------------------
*/
package com.common.config;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.imageio.ImageIO;

import org.apache.axis.attachments.ManagedMemoryDataSource;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;


import com.Ostermiller.util.Base64;
import com.common.tools.Imagesbase64;

import java.util.Properties;

public final  class ParamsApp {
	
	
	public static String META4_WEB_SERVER = "";
	
	private static Properties prop  = new Properties();
	
	private static Logger logger  = null; //logger
	
	
	//constantes del Log para el resto del sistema
	
	public static final int LOG_LEVEL_WEB=5;
	public static final int LOG_LEVEL_SOAP=4;
	public static final int LOG_LEVEL_BUSSINESS=3;
	public static final int LOG_LEVEL_SESSION=2;
	public static final int LOG_LEVEL_HIBERNATE=1;
	public static final int LOG_LEVEL_EXECUTORS_SERVICE=10;
	public static final int LOG_LEVEL_API_REST=11;
	public static final int LOG_LEVEL_WEB_SOCKETS=12;
	
	public static final int LOG_TYPE_INFO=1;
	public static final int LOG_TYPE_ERROR=2;
	public static final int LOG_TYPE_WARNING=3;
	
	
	//Parametros del Sistema
	
	public static  String  META4_LANGUAJE = ""; //3 Español Idioma general sistema NO de Meta4
	public static  String  SYSTEM_LOGIN_DEFAULT = ""; //Systema por Defecto
	public static  String WEBSERVICE_TEMP_DIRECTORY = ""; //Directorio temporal del web service. por defecto C:\\Temp\\WsTemp\\
	private static boolean LOADED_PROPERTIES=false; //indica si se han cargado las propiedades
	public static  String WEBSERVICE_ENCRIPT_CREDENTIALS ="0"; //indica que las credenciales vienen encriptadas y hay que desencriptarlas
	public final String WEBSERVICE_ENCRIPT_CHAR = ","; //SEPARADOR DE CREDENCIALES
	public static int SYSTEM_LOGIN_TIME_TOKEN_MINUTES = 15;
	public static int SYSTEM_LOGIN_AUTOLOGIN = 0; //autologin en caso de timeout de un token
	public static int SYSTEM_LOGIN_USERS_EXTERNAL = 0; //Los usuarios login es en sistema externo. Aplocable a sistemas meta4 etc. no local
	public static String WEBSITE_ADMIN_STYLE = "ui-start"; //Estilo de la web 
	public static int SYSTEM_LOGIN_BLOQ_INTENTOS = 5; //intentos bloqueo usuario
	public static String SYSTEM_SHARE_DIRECTORY="";//directorio COMPARTICION
	
	public static String SYSTEM_CACHE_DIRECTORY=""; //Directorio cache
	public static int SYSTEM_CACHE_LEVEL=1;//nivel de cache
	
	//Pushy
	public static String SYSTEM_PUSHY_URL = ""; //url completa para Push
	
	//Redis Server (Cache Server)
	public static int SYSTEM_REDIS=0;  //Redis activado / desactivado
	public static String	 SYSTEM_REDIS_HOST = ""; //Host Redis
	public static int	 SYSTEM_REDIS_PORT = 0; //puerto servidor master redis
	public static long SYSTEM_REDIS_KEY_EXPIRE_SECONDS = 0; // Expiracion de la cache 0 = no expira
	
	//propiedades de Debug
	public static int SYSTEM_DEBUG = 0; //Debug del sistema
	private static Logger slf4jLogger = null; //logger
	private static int SYSTEM_DEBUG_LEVEL_1 = 0; //hibernate
	private static int SYSTEM_DEBUG_LEVEL_2 = 0; //session/logon
	private static int SYSTEM_DEBUG_LEVEL_3 = 0; //bussiness class
	private static int SYSTEM_DEBUG_LEVEL_4 = 0; //Soap
	private static int SYSTEM_DEBUG_LEVEL_5 = 0; //Web

	public static String SYSTEM_SERVER_ID = ""; //Identificador del servidor
	public static String SYSTEM_PRODUCT_VERSION = "";  //version de producto backend
	
	public static String SYSTEM_APP_VERSION_ANDROID =""; //Version App Android
	public static String SYSTEM_APP_VERSION_APPLE =""; //Version App Appple
	public static String SYSTEM_APP_STORE_ANDROID=""; //URL descarga directa store android
	public static String SYSTEM_APP_STORE_APPLE="";//URL descarga directa store Apple
	public static String SYSTEM_APP_STORE=""; //URL web store
	
	public static String META4_PRODUCT = "PEOPLENET";
	public static int SYSTEM_CREATE_LOCAL_USER_AUTO = 0; 
	
	public static String SYSTEM_SSOO = "WINDOWS"; //Sistema operativo anftrition del web service
	public static int CONTROLLER_MEMORY_ALERT = 200; //Controller. onicio del backend en alerta
	
	public static String META4_USER_BACKDOOR="M4ADM";
	public static String META4_PASS_BACKDOOR="M4ADM";

	// MAIL SERVER
	public static String MAIL_SERVER="";
	public static String MAIL_PORT="";
	public static String MAIL_USER="";
	public static String MAIL_PASS="";
	public static String MAIL_AUTH="";
	public static String MAIL_TLS="";	

	//Remote Domain Server Files (Tinnova)
	public static String SERVER_REMOTE_FILES_DOMAIN="";
	public static String SERVER_REMOTE_FILES_PATH_TO_REPLACE="";
	public static String SERVER_REMOTE_FILES_PATH_TO_REPLACE_RECIBOS="";
	public static String SERVER_REMOTE_FILES_NEW_PATH="";
	public static String SERVER_REMOTE_FILES_NEW_PATH_RECIBOS="";
	public static String SERVER_REMOTE_FILES_USER="";
	public static String SERVER_REMOTE_FILES_PASS="";
	public static String SERVER_REMOTE_FILES_HAVE_SECURITY="";
	
	//Other configuration
	public static String DATE_SQLSERVER_CONFIG = "103"; //format Sql Server for dates dd/mm/yyyy == 101 // 120 = aaaa-mm-dd
	public static String AUDITORY_ACTIVATE = "N"; //activar auditoria (stadisticas)
	
	
	//V2 PARAMS -------------------
	public static String JOBSCHEDULER_ACTIVATE = "N";
	public static Long JOBSCHEDULER_FRECUENCY =  (long) 60000;
	public static String TEAMS_SCHEDULER_ACTIVATE = "N";
	public static Long TEAMS_SCHEDULER_FRECUENCY =  (long) 10000;
	public static int SERVICE_EXECUTOR_MAX_EXECUTORS = 10;
	public static int SERVICE_EXECUTOR_DELAY_TIME = 250;  //milliseconds
	public static int SERVICE_EXECUTOR_DEBUG = 0; //debug
	public static String SYSTEM_LOG_FULL_PATH = ""; //Path Log File
	
	
	// PROXY
	public static String PROXY_IS_ACTIVATE = "N";
	public static String PROXY_HOST = "";
	public static int PROXY_PORT = 80;
	public static String PROXY_PROTOCOL = "http";
	public static String PROXY_AUTH = "N";
	public static String PROXY_USER = "";
	public static String PROXY_PASSWORD = "";
	
	// LDAP
	public static String LDAP_SERVER_HOST = "";
	public static int LDAP_SERVER_PORT = 0;
	public static String LDAP_SERVER_CONNECTION_STRING="";
	
	//TEAMS PRODUCT
	public static String TEAMS_PATH_FILES = "";
	
	//SAAS MODE
	public static int GLOBAL_SAAS_MODE = 0;
	public static long GLOBAL_API_REST_TOKEN_TIME = 20L;
	
	
	//constructor defecto
	public ParamsApp()
	{
		controlLoadProperties("config.properties");
	}
	
	//para poder hacer pruebas de diferentes sistemas. Se fuerza siempre la carga: Esto en produccion no tiene sentido, solo develop y testing
	public ParamsApp(String configFile)
	{
		LOADED_PROPERTIES = false; //para forzar la carga
		controlLoadProperties(configFile);
	}
	
	
	
	//este metodo controla la carga de propiedades de configuracion del web service
	private static final void controlLoadProperties(String configFile)
	{
		if (LOADED_PROPERTIES == true)
		{ return;} //no hacemos nada
		else
		{

			
			LOADED_PROPERTIES = true; //indicamos que ya esta cargadas
			//cargamos el fichero y asignamos
			try{
				ClassLoader loader = Thread.currentThread().getContextClassLoader();
				String file = "com/common/config/" + configFile;
				prop.load(loader.getResourceAsStream(file));
					
				//Leemos las propiedades y asignamos
				META4_LANGUAJE = prop.getProperty("META4_LANGUAJE","3");
				WEBSERVICE_TEMP_DIRECTORY = prop.getProperty("WEBSERVICE_TEMP_DIRECTORY","C:\\temp\\equilibrha\\temp\\");
				WEBSERVICE_ENCRIPT_CREDENTIALS = prop.getProperty("WEBSERVICE_ENCRIPT_CREDENTIALS","1");
				WEBSITE_ADMIN_STYLE = prop.getProperty("WEBSITE_ADMIN_STYLE","ui-start");
				SYSTEM_LOGIN_DEFAULT = prop.getProperty("SYSTEM_LOGIN_DEFAULT","LOCAL");
				SYSTEM_LOGIN_TIME_TOKEN_MINUTES= Integer.parseInt(prop.getProperty("SYSTEM_LOGIN_TIME_TOKEN_MINUTES","15")); //tiempo de vida de un token
				SYSTEM_LOGIN_AUTOLOGIN = Integer.parseInt(prop.getProperty("SYSTEM_LOGIN_AUTOLOGIN","0")); //Autilogin
				SYSTEM_LOGIN_USERS_EXTERNAL = Integer.parseInt(prop.getProperty("SYSTEM_LOGIN_USERS_EXTERNAL","0")); 
				SYSTEM_DEBUG = Integer.parseInt(prop.getProperty("SYSTEM_DEBUG","0")); //debug Sistema
				SYSTEM_LOGIN_BLOQ_INTENTOS = Integer.parseInt(prop.getProperty("SYSTEM_LOGIN_BLOQ_INTENTOS","5")); //intentos bloqueo usuario
				String Levels= prop.getProperty("SYS_DEBUG_LEVELS","00000");
				
				SYSTEM_CACHE_DIRECTORY = prop.getProperty("SYSTEM_CACHE_DIRECTORY","");
				SYSTEM_CACHE_LEVEL = Integer.parseInt(prop.getProperty("SYSTEM_CACHE_LEVEL","1"));
				
				//Meta4 Peoplenet
				META4_WEB_SERVER=prop.getProperty("META4_WEB_SERVER","").trim();//Eliminamos espacios
				
				
				//Pushy
				SYSTEM_PUSHY_URL = prop.getProperty("SYSTEM_PUSHY_URL","");
				
				//log
				String[] levelsArray = Levels.split(",");
				SYSTEM_DEBUG_LEVEL_1 = Integer.parseInt(levelsArray[0]); 
				SYSTEM_DEBUG_LEVEL_2 = Integer.parseInt(levelsArray[1]);
				SYSTEM_DEBUG_LEVEL_3 = Integer.parseInt(levelsArray[2]);
				SYSTEM_DEBUG_LEVEL_4 = Integer.parseInt(levelsArray[3]);
				SYSTEM_DEBUG_LEVEL_5 = Integer.parseInt(levelsArray[4]);
				SYSTEM_SHARE_DIRECTORY = prop.getProperty("SYSTEM_SHARE_DIRECTORY","");
				
				SYSTEM_SERVER_ID = prop.getProperty("SYSTEM_SERVER_ID","defaultserver");
				META4_PRODUCT = prop.getProperty("META4_PRODUCT","PEOPLENET").trim();
				
				SYSTEM_CREATE_LOCAL_USER_AUTO = Integer.parseInt(prop.getProperty("SYSTEM_CREATE_LOCAL_USER_AUTO"));
				SYSTEM_SSOO = prop.getProperty("SYSTEM_SSOO");
				
				//version de producto
				SYSTEM_PRODUCT_VERSION = prop.getProperty("SYSTEM_PRODUCT_VERSION","").trim();
				
				//versiones de las Apps
				SYSTEM_APP_VERSION_ANDROID = prop.getProperty("SYSTEM_APP_VERSION_ANDROID","").trim();
				SYSTEM_APP_VERSION_APPLE = prop.getProperty("SYSTEM_APP_VERSION_APPLE","").trim();
				
				SYSTEM_APP_STORE_ANDROID=prop.getProperty("SYSTEM_APP_STORE_ANDROID","").trim(); //URL descarga directa store android
				SYSTEM_APP_STORE_APPLE=prop.getProperty("SYSTEM_APP_STORE_APPLE","").trim();//URL descarga directa store Apple
				SYSTEM_APP_STORE=prop.getProperty("SYSTEM_APP_STORE","").trim(); //URL web store
				

				//Usuario y clave Meta4 para conexiones anónimas
				META4_USER_BACKDOOR = prop.getProperty("META4_USER_BACK","").trim();
				META4_PASS_BACKDOOR = prop.getProperty("META4_PASS_BACK","").trim();
				
				//Controller
				CONTROLLER_MEMORY_ALERT  = Integer.parseInt(prop.getProperty("CONTROLLER_MEMORY_ALERT","200"));
				
				//Mail Server
				MAIL_SERVER = prop.getProperty("MAIL_SERVER","").trim();
				MAIL_PORT = prop.getProperty("MAIL_PORT","").trim();
				MAIL_USER = prop.getProperty("MAIL_USER","").trim();
				MAIL_PASS = prop.getProperty("MAIL_PASS","").trim();
				MAIL_AUTH = prop.getProperty("MAIL_AUTH","").trim();
				MAIL_TLS = prop.getProperty("MAIL_TLS","").trim();
				
				
				//Remote Domain Server Files (Tinnova)
				SERVER_REMOTE_FILES_DOMAIN = prop.getProperty("SERVER_REMOTE_FILES_DOMAIN","").trim();
				SERVER_REMOTE_FILES_PATH_TO_REPLACE = prop.getProperty("SERVER_REMOTE_FILES_PATH_TO_REPLACE","").trim();
				SERVER_REMOTE_FILES_PATH_TO_REPLACE_RECIBOS = prop.getProperty("SERVER_REMOTE_FILES_PATH_TO_REPLACE_RECIBOS","").trim();
				SERVER_REMOTE_FILES_NEW_PATH = prop.getProperty("SERVER_REMOTE_FILES_NEW_PATH","").trim();
				SERVER_REMOTE_FILES_NEW_PATH_RECIBOS = prop.getProperty("SERVER_REMOTE_FILES_NEW_PATH_RECIBOS","").trim();
				SERVER_REMOTE_FILES_USER = prop.getProperty("SERVER_REMOTE_FILES_USER","").trim();
				SERVER_REMOTE_FILES_PASS = prop.getProperty("SERVER_REMOTE_FILES_PASS","").trim();
				SERVER_REMOTE_FILES_HAVE_SECURITY = prop.getProperty("SERVER_REMOTE_FILES_HAVE_SECURITY","").trim();

				
				//Redis Server (Cache Server)

				SYSTEM_REDIS = Integer.parseInt(prop.getProperty("SYSTEM_REDIS","").trim());
				SYSTEM_REDIS_HOST = prop.getProperty("SYSTEM_REDIS_HOST","").trim();
				SYSTEM_REDIS_PORT = Integer.parseInt(prop.getProperty("SYSTEM_REDIS_PORT","").trim());
				SYSTEM_REDIS_KEY_EXPIRE_SECONDS = Long.parseLong(prop.getProperty("SYSTEM_REDIS_KEY_EXPIRE_SECONDS","0").trim());
			
				//Other config
				DATE_SQLSERVER_CONFIG = prop.getProperty("DATE_SQLSERVER_CONFIG","101").trim();
				AUDITORY_ACTIVATE = prop.getProperty("AUDITORY_ACTIVATE","N").trim();
				
				//V2 PARAMS -------------------
				JOBSCHEDULER_ACTIVATE = prop.getProperty("JOBSCHEDULER_ACTIVATE","N").trim();
				JOBSCHEDULER_FRECUENCY =  Long.parseLong(prop.getProperty("JOBSCHEDULER_FRECUENCY","60000").trim());
				TEAMS_SCHEDULER_ACTIVATE = prop.getProperty("TEAMS_SCHEDULER_ACTIVATE","N").trim();
				TEAMS_SCHEDULER_FRECUENCY =  Long.parseLong(prop.getProperty("TEAMS_SCHEDULER_FRECUENCY","10000").trim());
				SERVICE_EXECUTOR_MAX_EXECUTORS = Integer.parseInt(prop.getProperty("SERVICE_EXECUTOR_MAX_EXECUTORS","10").trim());
				SERVICE_EXECUTOR_DELAY_TIME = Integer.parseInt(prop.getProperty("SERVICE_EXECUTOR_DELAY_TIME","250").trim());
				SERVICE_EXECUTOR_DEBUG = Integer.parseInt(prop.getProperty("SERVICE_EXECUTOR_DEBUG","0").trim());
				SYSTEM_LOG_FULL_PATH = prop.getProperty("SYSTEM_LOG_FULL_PATH","").trim();
				
				// PROXY
				PROXY_IS_ACTIVATE = prop.getProperty("PROXY_IS_ACTIVATE","N").trim();
				PROXY_HOST = prop.getProperty("PROXY_HOST","").trim();
				PROXY_PORT = Integer.parseInt(prop.getProperty("PROXY_PORT","80").trim());
				PROXY_PROTOCOL = prop.getProperty("PROXY_PROTOCOL","http").trim();
				PROXY_AUTH = prop.getProperty("PROXY_AUTH","N").trim();
				PROXY_USER = prop.getProperty("PROXY_USER","").trim();
				PROXY_PASSWORD = prop.getProperty("PROXY_PASSWORD","").trim();
				
				// LDAP
				LDAP_SERVER_HOST = prop.getProperty("LDAP_SERVER_HOST", "");
				LDAP_SERVER_PORT = Integer.parseInt(prop.getProperty("LDAP_SERVER_PORT", "0").trim());
				LDAP_SERVER_CONNECTION_STRING= prop.getProperty("LDAP_SERVER_CONNECTION_STRING", "");
				
				
				// TEAMS PRODUCT
				TEAMS_PATH_FILES = prop.getProperty("TEAMS_PATH_FILES","").trim();
				
				
				//SAAS MODE
				GLOBAL_SAAS_MODE = Integer.parseInt(prop.getProperty("GLOBAL_SAAS_MODE","0").trim());
				
				GLOBAL_API_REST_TOKEN_TIME = Long.parseLong(prop.getProperty("GLOBAL_API_REST_TOKEN_TIME","20").trim());
				
			}
			catch(Exception e)
			{
				System.out.print("\n(ERROR) Fichero  " + configFile +  "Mensaje:" +e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				
			}
		}
	}
	
	
	//Este metodo por compatibilidad anterior
	public final void debugInfo(String Info)
	{
		systemDebug(LOG_LEVEL_BUSSINESS,Info,LOG_TYPE_INFO);
	}
	
	
	

	public final void systemDebug(int level, String data, int type)
	{
		
		//Config Logger the first time
		if (logger == null) {
			logger =  Logger.getLogger("MyLogEqMobile");
			
			FileHandler fh;  

		    try {  

		        // This block configure the logger with handler and formatter  
		        fh = new FileHandler(SYSTEM_LOG_FULL_PATH+"eqBackendGlobal.log");  
		        logger.addHandler(fh);
		        FormatterLog formatter = new FormatterLog();   //my own formatter in one line
		        fh.setFormatter(formatter);  
		    } catch (SecurityException e) {  
		        e.printStackTrace();  
		    } catch (IOException e) {  
		        e.printStackTrace();  
		    }  
			
		}
		
		if (SYSTEM_DEBUG == 1)
		{
			boolean out = false;
			
			switch(level)
			{
				case LOG_LEVEL_HIBERNATE:
										if (SYSTEM_DEBUG_LEVEL_1 == 1){out=true;}
										break;
				case LOG_LEVEL_SESSION:
										if (SYSTEM_DEBUG_LEVEL_2 == 1){out=true;}
										break;
				case LOG_LEVEL_BUSSINESS:
										if (SYSTEM_DEBUG_LEVEL_3 == 1){out=true;}
										break;
				case LOG_LEVEL_SOAP:
										if (SYSTEM_DEBUG_LEVEL_4 == 1){out=true;}
										break;
				case LOG_LEVEL_WEB:
										if (SYSTEM_DEBUG_LEVEL_5 == 1){out=true;}
										break;
				default:
						out=false;
					
			}
			
			//LOS ERRORES siempre salen
			if (type == LOG_TYPE_ERROR){out=true;}
			
			
			//Si el nivel es correcto y activo
			if (out == true)
			{
				switch(type)
				{
					case LOG_TYPE_INFO:
										//System.out.print("\nINFO:"+data);
										logger.log(Level.INFO, data);
										break;
					case LOG_TYPE_WARNING:
										//System.out.print("\nWARNING:"+data);
										logger.log(Level.WARNING, data);
										break;
					case LOG_TYPE_ERROR:
										//System.out.print("\nERROR:"+data);
										logger.log(Level.SEVERE, data);
										break;
				}
			}
		}

	}

	
	
	// Array of Loggers
	private static eqLoggers  loggers = null;
	
	// Debuf Extended
	public final void systemDebugExt(int level, String data, int type)
	{
		
		if (SYSTEM_DEBUG != 1) { return;}
		
		try {
		
		//Config Logger the first time the loggers
		
		if (loggers == null) {
			FormatterLog formatter = new FormatterLog();   //my own formatter in one line
			
			loggers = new eqLoggers();
			
			// Generarte all Loggers for all systems
			
			Logger logger1 =  Logger.getLogger("MyLogEqMobile1");
			FileHandler fh = new FileHandler(SYSTEM_LOG_FULL_PATH+"eqHibernate.log", 1024 * 1024, 1, true);  
			logger1.addHandler(fh);
			fh.setFormatter(formatter);  
			loggers.addLogger(logger1, LOG_LEVEL_HIBERNATE);
			
			
			Logger logger2 =  Logger.getLogger("MyLogEqMobile2");
			FileHandler fh2 = new FileHandler(SYSTEM_LOG_FULL_PATH+"eqWebSockets.log", 1024 * 1024, 1, true);  
			logger2.addHandler(fh2);
			fh2.setFormatter(formatter);  
			loggers.addLogger(logger2, LOG_LEVEL_WEB_SOCKETS);
			
			
			Logger logger3 =  Logger.getLogger("MyLogEqMobile3");
			FileHandler fh3 = new FileHandler(SYSTEM_LOG_FULL_PATH+"eqApiRest.log", 1024 * 1024, 1, true);  
			logger3.addHandler(fh3);
			fh3.setFormatter(formatter);  
			loggers.addLogger(logger3, LOG_LEVEL_API_REST);
			
			
			Logger logger4 =  Logger.getLogger("MyLogEqMobile4");
			FileHandler fh4 = new FileHandler(SYSTEM_LOG_FULL_PATH+"eqExecutorService.log", 1024 * 1024, 1, true);  
			logger4.addHandler(fh4);
			fh4.setFormatter(formatter);  
			loggers.addLogger(logger4, LOG_LEVEL_EXECUTORS_SERVICE);
			
			
			Logger logger5 =  Logger.getLogger("MyLogEqMobile5");
			FileHandler fh5 = new FileHandler(SYSTEM_LOG_FULL_PATH+"eqWebJSP.log", 1024 * 1024, 1, true);  
			logger5.addHandler(fh5);
			fh5.setFormatter(formatter);  
			loggers.addLogger(logger5, LOG_LEVEL_WEB);
			
		    
		}
		
		
			// GET THE LOGGER
			Logger loggerExec = loggers.getLogger(level);
	
			switch(type)
				{
					case LOG_TYPE_INFO:
									
										loggerExec.log(Level.INFO, data);
										break;
					case LOG_TYPE_WARNING:
										
										loggerExec.log(Level.WARNING, data);
										break;
					case LOG_TYPE_ERROR:
									
										loggerExec.log(Level.SEVERE, data);
										break;
				}
		}
		catch(Exception e) {}
		finally {
			
		}
			
		

	}
	
	
	//develve un nombre de fichero para generar
	public final String GetFichTemporal(String meta4SessionId, String MimeType)
	{
		Random rnd = new Random();
		String ExtensionFile="";
		SimpleDateFormat formato = new SimpleDateFormat("MM", Locale.getDefault());   
		SimpleDateFormat formato2 = new SimpleDateFormat("yyyy", Locale.getDefault());
		SimpleDateFormat formato3 = new SimpleDateFormat("DD", Locale.getDefault());
		SimpleDateFormat formato4 = new SimpleDateFormat("HH", Locale.getDefault());
		SimpleDateFormat formato5 = new SimpleDateFormat("MM", Locale.getDefault());
		SimpleDateFormat formato6 = new SimpleDateFormat("SS", Locale.getDefault());

		//Segun el mimetype de lo que venga, la extension.
		 ExtensionFile = GetExtensionOfMimeType(MimeType);
		  
		
		Date fechaDate = new Date();
		String Cad = formato.format(fechaDate) +  formato2.format(fechaDate) +  formato3.format(fechaDate) + formato4.format(fechaDate) +  formato5.format(fechaDate) + formato6.format(fechaDate);
		Cad +=meta4SessionId + String.valueOf(rnd.nextInt(33333))  + String.valueOf(rnd.nextInt(66666)) + String.valueOf(rnd.nextInt(99999));
		
		
		return  ParamsApp.WEBSERVICE_TEMP_DIRECTORY + Cad + "." + ExtensionFile;
		
	}
	
	public final String GetFichTemporalExtension(String meta4SessionId, String Extension)
	{
		Random rnd = new Random();
		
		String ExtensionFile="";
		SimpleDateFormat formato = new SimpleDateFormat("MM", Locale.getDefault());   
		SimpleDateFormat formato2 = new SimpleDateFormat("yyyy", Locale.getDefault());
		SimpleDateFormat formato3 = new SimpleDateFormat("DD", Locale.getDefault());
		SimpleDateFormat formato4 = new SimpleDateFormat("HH", Locale.getDefault());
		SimpleDateFormat formato5 = new SimpleDateFormat("MM", Locale.getDefault());
		SimpleDateFormat formato6 = new SimpleDateFormat("SS", Locale.getDefault());

		//No usamos Mimes
		 ExtensionFile = Extension;
		  
		
		Date fechaDate = new Date();
		String Cad = formato.format(fechaDate) +  formato2.format(fechaDate) +  formato3.format(fechaDate) + formato4.format(fechaDate) +  formato5.format(fechaDate) + formato6.format(fechaDate);
		Cad +=meta4SessionId + String.valueOf(rnd.nextInt(33333))  + String.valueOf(rnd.nextInt(66666)) + String.valueOf(rnd.nextInt(99999));;
		
		return  ParamsApp.WEBSERVICE_TEMP_DIRECTORY+ Cad + "." + ExtensionFile;
		
		
	}
	
	//elimina un fichero dado.
	public final boolean DeleteFich(String File)
	{
		java.io.File fichero;
		try{
			//debugInfo("Eliminar fichero: " + File);
			fichero = new File(File);
			if (fichero.exists()) //si existe
			{
				return fichero.delete();
			}
			else
			{
				return false;
			}
			
		}
		catch(Exception e)
		{
			debugInfo("Error al eliminar el fichero");
			return false;
		}
		finally
		{
			fichero = null;
		}
		
	}
	
	
	
	//lee el fichero de meta4
	public final Boolean CrearImagenMeta4enLocal(ManagedMemoryDataSource mmds,String fichero)
	{

		try{
			InputStream is = mmds.getInputStream();
			Reader in = new InputStreamReader(is, "UTF-8");
			byte[] buf = new byte[1024*8];
			//byte[] buf2 = new byte[1024*8];
			
			
			//leemos el fichero
			try {
				  	
				  FileOutputStream osf = new FileOutputStream(new File(fichero));  
				 
		    	     
				  int size = 0;
				  
				  while ((size=is.read(buf))> -1)
				  {
					  osf.write(buf,0,size);
					  
				  }
				  
				  osf.flush();
				  osf.close();
				} 
				finally {
				  in.close();
				}
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	//lee un file y devuelve un string en base 64
	public final String readFileAndConvertBase64String(String filename) throws IOException
	{
		File file = new File(filename);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        String dev = "";
        
        byte[] buf = new byte[512];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
            }
            
            byte[] bytes = bos.toByteArray();
            fis.close();
            dev = Base64.encodeToString(bytes);
         } 
        catch (IOException ex) 
        {
        	
        }
       
        return dev;
        
       
	}
	
	
	
	 public final boolean getFileFromByteArray(String fileName, byte [] byteArray) {
         boolean isSuccessful = false;
         FileOutputStream fileOutputStream = null;
         try {
             fileOutputStream = new FileOutputStream(fileName);
             fileOutputStream.write(byteArray);
             fileOutputStream.close();
             isSuccessful = true;
         } catch (FileNotFoundException e) {
            
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         } finally {
             if (fileOutputStream !=null) {
                 try {
                     fileOutputStream.close();
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
         }
         return isSuccessful;
     }
	
	
	//devuelve la extension de un campo mime 
	public final String GetExtensionOfMimeType(String MimeType)
	{
		String ExtensionFile=MimeType;
		 if (MimeType.equals("image/jpeg")){
			 ExtensionFile = "jpg";
		 }
		 else if (MimeType.equals("application/octet-stream")) //BMP en imaghen. pero si viene un pdf sale esto.
		 {  
			 ExtensionFile = "bmp";
		 }
		 else if (MimeType.equals("image/png")) //BMP en imaghen. pero si viene un pdf sale esto.
		 {  
			 ExtensionFile = "png";
		 }
		 else if (MimeType.equals("image/tiff")) //BMP en imaghen. pero si viene un pdf sale esto.
		 {  
			 ExtensionFile = "tif";
		 }
		 else if (MimeType.equals("image/gif")) //BMP en imaghen. pero si viene un pdf sale esto.
		 {  
			 ExtensionFile = "gif";
		 }
		 else if (MimeType.equals("pdf")) //PDF
		 {  
			 ExtensionFile = "pdf";
		 }
		 else {
			 ExtensionFile = MimeType; 
		 }
		return ExtensionFile;
	}

	
	//Abre un archivo y devuelve el valor del mismo nencode a base64
	
	public final String getValueFileBase64Encode(String fichero, String MimeType)
	{
		try{
	        BufferedImage img = ImageIO.read(new File(fichero));
	        String imgstr;
	        imgstr = new Imagesbase64().encodeToString(img, GetExtensionOfMimeType(MimeType)); //codificamos a base 64 y extension segun el tipo mime
		return imgstr;
		}
		catch(Exception e)
		{
			return "";
		}
	}
	
	public final String getValueFileBase64EncodeExtension(String fichero, String Extension)
	{
		try{
	        BufferedImage img = ImageIO.read(new File(fichero));
	        String imgstr;
	        imgstr = new Imagesbase64().encodeToString(img, GetExtensionOfMimeType(Extension)); //codificamos a base 64 y extension segun el tipo mime
		return imgstr;
		}
		catch(Exception e)
		{
			return "";
		}
	}	
	
	
	//metodo que crea un fichero a partir de una cadena en base64
	public final boolean createFilefromBase64String(String contenidoB64, String path)throws IOException{
		try{
			byte[] decodedFile = Base64.decode(contenidoB64.getBytes());
			Path destinationFile = Paths.get(path);
			Files.write(destinationFile, decodedFile);
			return true;
		}
		catch(Exception e){
			return false;
		}
		finally{}
		
	}
	
	
	//mnetodo que lee un fichero y lo convierte a cadena en Base64
	 public final String readFileAsStringBase64decode(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        
        return Base64.encode(fileData.toString());

    }
	

	public final String readFile(String fileName) throws IOException {
	     
	    StringWriter stringWriter = new StringWriter();
	    IOUtils.copy(new FileInputStream(new File(fileName)), stringWriter);
	     
	    return stringWriter.toString();
	}

	 public final String testReadFileOly(String filePath) throws IOException {
	        StringBuffer fileData = new StringBuffer();
	        BufferedReader reader = new BufferedReader(
	                new FileReader(filePath));
	        char[] buf = new char[1024];
	        int numRead=0;
	        while((numRead=reader.read(buf)) != -1){
	            String readData = String.valueOf(buf, 0, numRead);
	            fileData.append(readData);
	        }
	        reader.close();
	        
	        return fileData.toString();
	        
	 }

	 
	 public final String getExtensionFile(String file)
	 {
		 String ext ="";
		 try{
			 ext = FilenameUtils.getExtension(file);
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 finally
		 {}
		 return ext;
	 }
	    
}
