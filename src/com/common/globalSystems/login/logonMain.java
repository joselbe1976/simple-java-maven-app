//**********************************************************
// Jose Luis Bustos Esteban
// Sistema Local
// **********************************************************


package com.common.globalSystems.login;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.common.config.ParamsApp;
import com.common.globalSystems.applyValueParams;
import com.common.hibernate.classes.hb_dynamic_actions;
import com.common.hibernate.classes.hb_statistics;
import com.common.hibernate.classes.hb_users_system;
import com.common.hibernate.entidades.VinSystems;
import com.common.hibernate.entidades.VinUsersSystem;
import com.common.hibernate.entidades.VinUsersSystemId;
import com.common.pushnotifications.Parse.parseOperations;


public class logonMain implements logon { //hereda del interface logon

	
	public static final int  PARAM_BLOQUEO_SISTEMA = 3; //valores constantes que estan en la tabla de parametros
	public static final int  PARAM_DIAS_CONEXION = 6;
	public static final int  PARAM_HORARIO_CONEXION = 7;
	public static final int  PARAM_DISPOSITIVO_ACCESO = 101;//Estos no estan en tabla de �rametrizacion
	public static final int  PARAM_UUID_ACCESO = 102;//Estos no estan en tabla de �rametrizacion
	
	
	public String IdDefaultSystemLogon = ""; //viene en properties del app
	public int autoLogin=0; //del properties, 1 = si 
	public String languaje;
	
		
	
	//para Debug
	public String className = "";
	public int externalUsers=0;

	
	public String idProcess = "";  //id proceso de login
	public String idUsuarioLocal="";
	public String idUsuario="";
	public String password="";
	public String idSistema=""; //sistema
	public String idDispositivoLogin=""; 
	public String idDispositivoAcceso="0"; //por defecto el dispositivo 0 es que se puede conectar a todos.
	public String idUUIDLogin="";
	public String idUUIDAcceso="";
	public int idRole=-1;
	
	public String credentialSerialSend=""; //serial que nos llega desde fuera
	public String credentialSerialGenerate=""; //Serial que generamos y devolvemos
	
	private logonData dataUser = new logonData();  //objeto que almacena datos usuario y session
	
	//seguridad Web
	private String DispositivoAccesoWeb = "";
	private String UUIDAccesoWeb = "";
	private Boolean isFromWeb = false;
	
	private Boolean LoginByToken = false;
	
	
	logonCommon common = null; //clase de operaciones comunes
	
	//constructores
	public logonMain()
	{
		initClass("");
	}
	

	public logonMain(String idioma,String Dispositivo,String UUID)
	{
		idUUIDAcceso = UUID;
		idDispositivoAcceso = Dispositivo;
		languaje = idioma; //forzado el idioma
		
		// paso a web por si es login Web
		
		initClass(idioma);

	}
	
	//metodo que se usa desde web adimnintracion para securizar roles que pueden entrar
	public void setAccessFromWeb()
	{
		isFromWeb = true;
		DispositivoAccesoWeb = idDispositivoAcceso;
		UUIDAccesoWeb = idUUIDAcceso;
	}
	
	private void initClass(String idioma)
	{
		new ParamsApp();
		
		IdDefaultSystemLogon = ParamsApp.SYSTEM_LOGIN_DEFAULT; //Sistema de login por defecto.
		autoLogin = ParamsApp.SYSTEM_LOGIN_AUTOLOGIN; //autologin
		externalUsers = ParamsApp.SYSTEM_LOGIN_USERS_EXTERNAL; //usuario externos, no de mysql
		
		this.className = this.getClass().getSimpleName(); //nombre de la clase
		
		//Idioma
		if (idioma.equals("")){	languaje = ParamsApp.META4_LANGUAJE;}
		
		common = new logonCommon(languaje,idDispositivoAcceso,idUUIDAcceso);		//constructor del objeto con el idioma

	}
	
	
	
	//Destructores
	protected void finalize()
	{
		common = null; //liberamos
		dataUser = null;
	}
	
	
	//Calculamos el sistema a instanciar para login
	private logon getSystemLogonObject()
	{
		logon sistema = null;
		//instanciamos la clase correcta
		if (IdDefaultSystemLogon.equals(SYSTEM_LOCAL)) //Sistema Local
		{
			sistema = new logonLocal(languaje,SYSTEM_LOCAL,idDispositivoAcceso,idUUIDAcceso);
			addLog("Sistema LOCAL");
			
		}
		else if (IdDefaultSystemLogon.equals(SYSTEM_META4))  //Meta4 Peopelnet
		{
			sistema = new logonMeta4(languaje,idDispositivoAcceso,idUUIDAcceso);
			addLog("Sistema META4");
		}

		return sistema;
	}


	// --------------------------------------------------------------------	
	//Login al sistema con user / clave y sistema por defecto del backend
	// --------------------------------------------------------------------
	public String logonSystem(String userLocal, String user, String p_password)
	{
		idUsuarioLocal = userLocal;
		idUsuario = user;
		password = p_password;
		
		addLog("----------------------------------------------------");
		addLog("---------------------  LOGIN  ----------------------");
		addLog("----------------------------------------------------");
		addLog("Local User:"+ userLocal);
		addLog("Sys User:"+ user);
		
		
		logon sistema = null;
		
		
		try{
			
			//capturamos el objeto de la clase de logon del sistema correcto
			sistema = getSystemLogonObject();
			
			//validamos que el usuario tenga asignado el sistema(si es un sistema para todos los usuarios)
			common.validateUserSystemAsign(userLocal, IdDefaultSystemLogon);
			
		
			//llamamos al login
			credentialSerialGenerate =  sistema.logonSystem(userLocal,user, p_password);
			addLog("Devuelve Login: "+credentialSerialGenerate);
			
			//Control de bloqueo y de numero de intentos
			if (credentialSerialGenerate.equals(""))
			{
				//si el usuario no es externo en login
				if (externalUsers == 0){common.saveUserLoginFail(userLocal,idSistema);}
				addLog("Login FAIL");
			}
			else
			{
				//verificamos las credenciales del sistema son fijas. (una vez verificadas)
				if (common.isSystemCredencialtheSameAllUsers(IdDefaultSystemLogon)==true)
				{
					addLog("\n Inicio Sistema con credenciales Fijas !!!!!!!");
					
					//capturamos el sistema para coger usuario y clave fijos del sistema
					 VinSystems sysObj = common.getSystem(IdDefaultSystemLogon);
					 
					 //forzamos el usuario y clave
					 user = sysObj.getSysUserFijo();
					 p_password = sysObj.getSysPassFijo();
					 idUsuario = user;
					 password = p_password;				 
					 
					 addLog("       - New user    :"+user);
					 addLog("       - New password:"+password);

					 //llamamos al login
					 addLog("       - 2 llamada al login con nuevas credenciales");
					credentialSerialGenerate =  sistema.logonSystem(userLocal,user, p_password);
					addLog("       - Devuelve Login: "+credentialSerialGenerate);
					 
					 addLog(" --- Fin Sistema con credenciales Fijas ---\n");
				}
				
				//volvemos a validar la credencial por si el segundo login falla
				if (credentialSerialGenerate.equals(""))
				{
					//si el usuario no es externo en login
					if (externalUsers == 0){common.saveUserLoginFail(userLocal,idSistema);}
					addLog("Login FAIL");

				}
				else
				{
					addLog("Login SUCCESS");

					//Login Correcto
					if (externalUsers==0){common.saveUserLoginSuccess(userLocal,idSistema);}				
					// Control de session
					controlSessionLogin();

				}
			}
			
			
			return credentialSerialGenerate; 
		}
		catch(Exception e)
		{
			System.out.print(e.getStackTrace());
		}
		finally
		{
			addLog("Final Login. KeyCode: " + credentialSerialGenerate);
			sistema = null;
			
		}
		
		return credentialSerialGenerate;
		
	}

	
	//Control de la session de login seguin parametros con aplicaValor
	
	private void controlSessionLogin()
	{
		
		
		//el control de sesion solo se debe ejecutar en el Login, nada mas
		//if (LoginByToken == true){return;}
		
		
		logon sistema = getSystemLogonObject();
		
		applyValueParams applyVal = null;
		
		try{
			
			
			
				// --------------------------------------------------------------------------------------------
				//Cargamos todos los parametros necesarios para el control parametrizable del aplicaValor
				// --------------------------------------------------------------------------------------------
				
				dataUser = common.getvalueUserOfTokenPerformance(credentialSerialGenerate);
	
				idRole = dataUser.idRole;
				idSistema=dataUser.idSystem;
				idDispositivoLogin= dataUser.idDeviceLogin;
				idDispositivoAcceso= dataUser.idDeviceAccess;
				idUUIDLogin=dataUser.uuidLogin;
				idUUIDAcceso=dataUser.uuidAccess;
				languaje = dataUser.languaje;
	
				
				//Seguridad Acceso a la Web
				if(isFromWeb == true)
				{
					if (idRole != 2) //Si tiene role administrador puede acceder a la web sino error control dfispositivo acceso
					{
						addLog("    Validacion control desde Web. No es administrador.");
						addLog("    NO permitimos acceso");
						credentialSerialGenerate = sistema.evaluarParametrosLogin(logonMain.PARAM_DISPOSITIVO_ACCESO);
						return;
					}
				}
				
		
				// Extaremos los parametros de aplicaValor asociados al acceso al sistema
				// Siempre debe existir un proceso que se llame igual queel sistema para el login 
				applyVal = new applyValueParams(dataUser,idSistema); 
			
				//Valores de aplicaValor
				int bloq = Integer.parseInt(applyVal.clcGetValueApplyValues(logonMain.PARAM_BLOQUEO_SISTEMA));
				String dias = applyVal.clcGetValueApplyValues(logonMain.PARAM_DIAS_CONEXION);
				String horario = applyVal.clcGetValueApplyValues(logonMain.PARAM_HORARIO_CONEXION);
				
				//bloqueo por UUID especifico
				if (!idUUIDAcceso.trim().equals(""))
				{
					if (!idUUIDAcceso.trim().equals(idUUIDLogin))
					{
						addLog("UUID de acceso ("+idUUIDAcceso+") <> UUID Login ("+idUUIDLogin+")del usuario!!!!!!");
						addLog("    NO permitimos acceso");
						credentialSerialGenerate = sistema.evaluarParametrosLogin(logonMain.PARAM_UUID_ACCESO);
						return;
					}
				}
					
				//bloqueo por dispositivo
				//si no esta vacio y no es 0(todos los dispositivos) sin restriccion
				if (!idDispositivoAcceso.trim().equals("") && !idDispositivoAcceso.equals("0"))
				{
					if (!idDispositivoAcceso.equals(idDispositivoLogin))
					{
						addLog("Dispositivo de acceso("+idDispositivoAcceso+") <> Dispositivo Login ("+idDispositivoLogin+" del usuario!!!!!!");
						addLog("    NO permitimos acceso");
						credentialSerialGenerate = sistema.evaluarParametrosLogin(logonMain.PARAM_DISPOSITIVO_ACCESO);

						return;
					}
				}
				
				
				
				//Control de bloqueo
				if (bloq == 1)
				{
					addLog("Sistema Bloqueado para el usuario");
					credentialSerialGenerate = sistema.evaluarParametrosLogin(logonMain.PARAM_BLOQUEO_SISTEMA);
					return;
				}
				
				//Dia de la semana
				if(!dias.equals("ALL")) //Si es distinto de ALL
				{
					GregorianCalendar cal = new GregorianCalendar();
					cal.setTime(new Date());
					int dia = cal.get(Calendar.DAY_OF_WEEK); //1 = domingo, 2 = lunes etc..
					
					
					//Si el parametro No contiene el dia de la semana , no entra
					if (!dias.contains(String.valueOf(dia)))
					{
						//addLog("Acceso no permitido. Dia de la semana");
						credentialSerialGenerate = sistema.evaluarParametrosLogin(logonMain.PARAM_DIAS_CONEXION);
					}
					
				}
				//Horario de accesso
				if(!horario.equals("ALL")) //Si es distinto de ALL
				{
					String Desde =  horario.split(",")[0] + ":00";
					String Hasta =  horario.split(",")[1] + ":00";
					
					DateFormat datos = new SimpleDateFormat("HH:mm:ss");
					try {
						//Convertimos a fechas y hora
				        Date dtDesde = datos.parse(Desde);
				        Date dtHasta = datos.parse(Hasta);
				        
				        //Calculamos la hora actual
				        Date actual = new Date();
				        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
				        calendar.setTime(actual);   // assigns calendar to given date 
				        String ActualHour = String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)) + ":" + String.valueOf(calendar.get(Calendar.MONTH)) + ":00";  
				        Date dtActual = datos.parse(ActualHour);
				        
				        //Si actual date esta entre las dos fechas
				        if (dtActual.compareTo(dtDesde)>0 && dtActual.compareTo(dtHasta)<0)
				        {
				        	//OK estamos en horario
				        	addLog(" ... Dentro de Horario OK ...");
				        }
				        else
				        {
				        	//ERROR
				        	addLog(" ... Fuera de Horario ERROR ...");
				        	credentialSerialGenerate = sistema.evaluarParametrosLogin(logonMain.PARAM_HORARIO_CONEXION);
				        }
				        
				    } catch ( Exception z ) {
				        z.printStackTrace();
				    }
				}
		}
		finally
		{
			sistema = null;
			applyVal = null;
			addLog("----------------------------------------");
			addLog("-- FIN Control de session de Login  ----");
			addLog("----------------------------------------");
		}
		
	}
	// --------------------------------------------------------------------
	//Login del sistema, forzando el sistema
	// --------------------------------------------------------------------	
	public String logonSystem(String userLocal,String user, String password, String idSistema)
	{
		
		IdDefaultSystemLogon = idSistema; // se fuerza el sistema
		return logonSystem(userLocal,user, password);
		
	}
	
	// --------------------------------------------------------------------	
	//Recibe keycode y verifica su timeout
	// --------------------------------------------------------------------	
	public String controlSessionSystem(String KeyCode)
	{
		try{
			
			LoginByToken = true;
			
				credentialSerialGenerate = KeyCode; //asigno el serial que me pasan
				
				//Control de token en el sistema 
				boolean dev = common.ControlTokenTimeOut(KeyCode);
				
				//si es OK, lanzo ECHO contra el sistema externo (si tiene)
				if (dev == true)
				{
					logon sistema = getSystemLogonObject();
					dev = sistema.echoToSystemExternal(KeyCode);
					sistema = null;
				}
				
				//Si estan OK las sessiones
				if (dev == true)
				{
					//Serial correcto. Miramos el control de sssion parametros
					controlSessionLogin(); 
					return credentialSerialGenerate;
				}
				else
				{
					//verificamos si hay autologin (del properties del backend)
					if (autoLogin == 1)
					{
						dataUser = common.getvalueUserOfTokenPerformance(KeyCode);
						//si el token es incorrecto (un ataque o cualquier error de programacion del cliente, salimos y devolvemos cadena vacia)
						if (dataUser.idUserLocal.equals(""))
						{
							return "";
						}

						//Fuerzo el idioma de la session en los objetos y esta clase
						languaje = dataUser.languaje;
						common.setLanguaje(dataUser.languaje);
						
						
						//backend V2. Force the Date Expire Token to Expire. If not do it, Logins control token expire. If not expire, returnn the token, and its a ploblem. Need it action
						common.ExpireTokenForce(dataUser.idUserLocal,dataUser.idSystem);
						
												//hacemos login forzando el sistema
						return logonSystem(dataUser.idUserLocal, dataUser.sysUser, dataUser.sysPasswordNoEncript, dataUser.idSystem);
					}
					else
					{
						return ""; //Incorrecto. Devolvemos KeyCode vacio	
					}
				}
		}
		finally
		{
		}
	}

	// ------------------------------------------------------------------------------------------
	//Login al sistema desde credenciales. Pueden venir credenciales de N sistemas.
	//Devolvemos el serialKey del sistema por defecto, aunque en base de datos,
	//se podra almacenar usuario-sistemas, las credenciales de N sistemas.
	// ------------------------------------------------------------------------------------------
	public String logonSystemBySerialCredentials(String Credentials)
	{
		LoginByToken = false;
		
		
		String serial_default="";
		String user_default="";
		String aux="";
		
		logonCredencialProcess credentialsProcess = new logonCredencialProcess();
		credentialsProcess.clcCredenciales(Credentials);
		
		try{
		
				//buscamos que venga el suistema default. y aklamcenamos el usuario que ser� el local
				
				if ( credentialsProcess.getPosDefaultSystem() == -1)
				{
					//no login, falta sistema local
					addLog("       ---- LOGIN NO PERMITDO. En las credenciales no viene el sistema por defecto");
					return "";
				} 
				else
				{
					//Si hay sistema por defecto, pillamos el usuario "local"
					user_default = credentialsProcess.getData(credentialsProcess.getPosDefaultSystem()).user.trim();
					idDispositivoAcceso=credentialsProcess.getData(credentialsProcess.getPosDefaultSystem()).IdDevice.trim(); 
					idUUIDAcceso=credentialsProcess.getData(credentialsProcess.getPosDefaultSystem()).UUID.trim();
					
					
				}
				
				
				//Reseteamos los datos "viejos" de las credenciales asignadas a todos los sistemas.
		
			// Backend V2. Delete this acttion. 0º/05/2018. Not necesary
			/*	if (common.sessionResetUserCredentials(user_default)==false)
				{
					return ""; //Error al resetear
				}
			*/
				
				int errors=0;
				
				
				
				//recorremos cada credencial
				for(int i = 0;i<credentialsProcess.getCount();i++)
				{
					
					//por cada sistema hacemos login. Si falla alguno de los sistemas, no se accede al mismo
					
					//idiomas
					languaje = credentialsProcess.getData(i).languaje;
					//common.setLanguaje(credentialsProcess.getData(i).languaje);
					idDispositivoAcceso=credentialsProcess.getData(i).IdDevice.trim(); 
					idUUIDAcceso=credentialsProcess.getData(i).UUID.trim();
					common = new logonCommon(languaje,idDispositivoAcceso,idUUIDAcceso); //pasamos los disposivos
					
					//hacemos login forzando el sistema
					
					addLog("  - Procesando login ... ");
					addLog("         -Local user:" + user_default);
					addLog("         -user      :" + credentialsProcess.getData(i).user);
					addLog("         -Sistema   :" + credentialsProcess.getData(i).idSystem);
					addLog("         -Idioma    :" + credentialsProcess.getData(i).languaje);
					addLog("         -Dispositivo    :" + credentialsProcess.getData(i).IdDevice);
					addLog("         -UUID    :" + credentialsProcess.getData(i).UUID);
					addLog("");
					
					//Si el sistema no es Parse.com
					if (credentialsProcess.getData(i).idSystem.equals(logon.SYSTEM_PARSE))
					{
						//PARSE.COM
						
						// --- Verificamos si el serial Key Parse que manda el dispositivo es iguakl
						
						parseOperations parse;
						
						try
						{
							//verificacion parse.
							parse = new parseOperations();
							parse.parseLoginVerification(credentialsProcess.getData(i).user,credentialsProcess.getData(credentialsProcess.getPosDefaultSystem()).user);
							
						}
						catch(Exception e)
						{
							addLog("Error: " + e.getMessage());
						}
						finally
						{
							parse = null;
						}
						
						
					}
					else
					{
						aux = logonSystem(user_default, credentialsProcess.getData(i).user, credentialsProcess.getData(i).password, credentialsProcess.getData(i).idSystem);
						
						addLog("        <Serial login>:"+aux);
						
						//control de errores de login
						if (aux.equals(""))
						{
							errors++;
							addLog("        Error de login:"+errors);
						}
						
						//Si es el sistema por defecto, entonces nos quedamos con el serial
						if (credentialsProcess.getData(i).defaultSystem.equals("1"))
						{
							serial_default = aux;
							addLog("        (serial DEFAUL)");
						}
					
					}
				}

				
				//si hay errores, no logamos
				if (errors > 0)
				{
					addLog("        HAY ERRORES EN ALGUN LOGIN!!!!! \n");
					serial_default=""; 
				}
		
		}
		catch(Exception e)
		{
			System.out.print(e.getStackTrace());
		}
		finally
		{
			credentialsProcess = null;
		}
		
		addLog("        Serial que devuelve el login credencials:"+serial_default);
		addLog(" --- Fin login por credenciales logonSystemBySerialCredentials ...");
		return serial_default;
	}
	
	
	//logout. Cuando se invoca a esto, se recuepran todos los sistemas del usuario con credencial y se llama
	// a cada sistema a logout. Por cada llamada cambiamos la fecha de caducidad de la credencial asignando la fecha y hora actuial - 1 minito. (evitamos posibles ataques por serial despues del logout)
	// credencial.
	public void logout(String userLocal)
	{
		
		//cerramos las sessiones de los sitemas que lo necesiten
		hb_users_system data = new hb_users_system();
		VinUsersSystem usr = new VinUsersSystem();
		logon  loginn;
		Date dateAfter = new java.util.Date(new java.util.Date().getTime()-5000); //calculamos los minutos de vida del token restandole la vida dle mismo (logout) (restamos 5 minutos)
		
		try{
		
			//SISTEMA META4
			usr = (VinUsersSystem)data.getUserSystem(userLocal, logon.SYSTEM_META4).get(0);
	
			//asigno el sistema login por defecto meta4
			this.IdDefaultSystemLogon=logon.SYSTEM_META4;
			loginn = getSystemLogonObject(); //creo el objeto
			loginn.logout(usr.getTokenSystem()); //logout de meta4. Si no esta activa la session del app meta4 no da error.
			usr.setSysPassword("");
			usr.setSysUser("");
			usr.setDtCadToken(dateAfter);
			data.updateRecord(usr); //grabamos
			
			//SISTEMA LOCAL. Solo  el sistema por defecto es LOCAL hacemos logout.
			
			if (new ParamsApp().SYSTEM_LOGIN_DEFAULT.equals("LOCAL"))
			{
				usr = (VinUsersSystem)data.getUserSystem(userLocal, logon.SYSTEM_LOCAL).get(0);
		
				this.IdDefaultSystemLogon=logon.SYSTEM_LOCAL;
				loginn = null;//libero
				loginn = getSystemLogonObject(); //creo el objeto
				loginn.logout(usr.getTokenSystem()); //logout local
				usr.setSysPassword("");
				usr.setSysUser("");
				usr.setDtCadToken(dateAfter);
				data.updateRecord(usr); //grabamos
			}		
		}
	catch(Exception e)
	{
		addLog("Error: Logout -->" + e.getMessage().toString());
		
	}
	finally
	{
		
		//liberamos recursos
		
				loginn = null;
				usr = null;
				data = null;
				dateAfter = null;
	}
		
		
	}; //Logout del sistema
	
	
	
	// Debug class
	protected void addLog(String info)
	{
			new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, ParamsApp.LOG_TYPE_INFO);
	}
	
	
	
	
	
	
	
	//No en esta clase, SI en cada sistema
	public String evaluarParametrosLogin(int Param){return "";}
	public boolean echoToSystemExternal(String KeyCode){return true;}
	
}
