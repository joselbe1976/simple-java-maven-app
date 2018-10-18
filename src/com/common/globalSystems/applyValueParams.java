/*-----------------------------------------------------------------------------------
 * Jose luis Bustos
 * -----------------------------------------------------------------------------------
 * Calculo del aplicavalor de parametros del sistema
 * -----------------------------------------------------------------------------------
 * Orden de prioridad (global a mas concreto)
 * 1. Parametros Globales
 * 2. Parametros por Role
 * 3. Parametros por Sistema
 * 4. Parametros por Dispositivo
 * 5. Parametros por proceso
 * 6. Parametros por Usuario
 * -----------------------------------------------------------------------------------
 *  Argumentos del constructor: Usuario, Proceso. A partir de aqui tenemos que calcular el resto y calcular la pir�mide de aplicavalor
 */
package com.common.globalSystems;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonData;
import com.common.hibernate.classes.*;
import com.common.hibernate.entidades.*;
import com.common.tools.interfaces.iDisposable;


public class applyValueParams  implements iDisposable{

	
	private String className = "";

	//items
	private String idUser="";
	private String idProcess="";

	
	//auxiliares
	private int idRole=-1;
	private String idSystem="";
	private String idDevice="";
	
	//objeto auxiliar de datos.
	globalToolsData dataTool; 
	
	
	//Constructores
	// ------------------------------------------------------------------
	public  applyValueParams()
	{
		initClass();
	}
	
	public  applyValueParams(String id_User, String id_Process)
	{
		
		initClass();
		
		dataTool = new globalToolsData();
		
		idUser = id_User;
		idProcess=id_Process;
		clcAuxiliarValues(); //Calculamos los valores auxiliares
	}
	
	//le pasamos los parametros para que no los tenga que buscar.
	public  applyValueParams(String id_User, String id_Process, String IdDevice, int p_idRole, String Sistema)
	{
		
		initClass();
	
		dataTool = new globalToolsData();
		idUser = id_User;
		idProcess=id_Process;
		idRole = p_idRole;
		idDevice = IdDevice;
		idSystem = Sistema;		
	}
	
	//Contructor inicializado con la clase logon data
	public  applyValueParams(logonData data, String proceso)
	{
		
		initClass();
	
		dataTool = new globalToolsData();
		idUser = data.idUserLocal;
		idProcess=proceso;
		idRole = data.idRole;
		idDevice = data.idDeviceLogin;
		idSystem = data.idSystem;		
	}
		
	
	//Comun a todos los constructores
	private void initClass()
	{
		new ParamsApp();
		className = this.getClass().getSimpleName(); //nombre de la clase
		
	}
	
	public void Dispose() {
		dataTool = null;
	}
	
		
	//Destructores
	// ------------------------------------------------------------------
	protected void finalize()
	{
		dataTool = null; //liberamos objetos
	}	
	
		
	//Setters de las propiedades. Para poder forzar
	
	public void setSystem(String id_System)
	{
		idSystem = id_System;
	}
	
	public void setDevice(String id_Device)
	{
		idDevice = id_Device;
	}

	public void setRole(int Role)
	{
		idRole = Role;
	}

	public void setUser(String id_User)
	{
		idUser = id_User;
	}

	public void setProcess(String id_Process)
	{
		idProcess = id_Process;
	}
	

	
	
	//-------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------
	//   METODOS DE LA CLASE DE CALCULO
	// -------------------------------------------------------------------------------------------
	//-------------------------------------------------------------------------------------------	
	
	// ----------------------------------------------------------------------	
	// Calculo de valores auxiliares, previo al calculo real
	// ----------------------------------------------------------------------
	private void clcAuxiliarValues()
	{
		//Calculamos el Role, Sistema,  Dispositivo
		idRole = dataTool.getRoleOfUser(idUser);
		idDevice = dataTool.getDeviceOfUser(idUser);
		idSystem = dataTool.getSystemOfProcessId(idProcess);
	}
	
	//Calcula el aplicaValor y devuelve el mismo
	public String clcGetValueApplyValues(int Param)
	{
		String Dev="";
		hb_params_global auxGlobal = null;
		hb_params_role auxRole = null;
		hb_params_system auxSistema = null;
		hb_params_device auxDevice = null;
		hb_params_process auxProcess  = null;
		hb_params_users auxUser = null;
		
		VinParamsGlobal dataGlobal = null;
		VinParamsRole dataRole = null;
		VinParamsSystem dataSistema = null;
		VinParamsDevice dataDevice = null;
		VinParamsProcess dataProcess = null;
		VinParamsUser dataUser = null;

		try{
		
				String paramStr = String.valueOf(Param);
				
				
				// ----------------------------------------------
				//VALORES GLOBALES
				// ----------------------------------------------
				  auxGlobal = new hb_params_global();
				  dataGlobal = auxGlobal.getDataObject(paramStr);
				  Dev = dataGlobal.getValue();
				
				 
					// ----------------------------------------------
					//VALORES ROLE
					// ----------------------------------------------
					 auxRole = new hb_params_role();
					 dataRole = auxRole.getObject(Param, String.valueOf(idRole));
					 
					 if (dataRole != null) //Si existe dato para el role y par�metro
					 {
						 Dev = dataRole.getValue();
					 }
	
				
					 
						// ----------------------------------------------
						//VALORES SISTEMA
						// ----------------------------------------------
						 auxSistema = new hb_params_system();
						 dataSistema = auxSistema.getObject(Param, idSystem);
						 
						 if (dataSistema != null) //Si existe dato para el role y par�metro
						 {
							 Dev = dataSistema.getValue();
						 }
				
							// ----------------------------------------------
							//VALORES DEVICE
							// ----------------------------------------------
							 auxDevice = new hb_params_device();
							 dataDevice = auxDevice.getObject(Param, idDevice);
							 
							 if (dataDevice != null) //Si existe dato para el role y par�metro
							 {
								 Dev = dataDevice.getValue();
							 }
					
								// ----------------------------------------------
								//VALORES PROCESO
								// ----------------------------------------------
								 auxProcess = new hb_params_process();
								 dataProcess = auxProcess.getObject(Param, idProcess);
								 
								 if (dataProcess != null) //Si existe dato para el role y par�metro
								 {
									 Dev = dataProcess.getValue();
								 }
	
								 	// ----------------------------------------------
									//VALORES USUARIO
									// ----------------------------------------------
									 auxUser = new hb_params_users();
									 dataUser = auxUser.getObject(Param, idUser);
									 
									 if (dataUser != null) //Si existe dato para el role y par�metro
									 {
										 Dev = dataUser.getValue();
									 }
		
		}
		catch (Exception e) {
			new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_BUSSINESS, e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
		}
		finally
		{
			 if (auxGlobal != null) { auxGlobal.Dispose();}
			 if (auxRole != null) { auxRole.Dispose();}
			 if (auxSistema != null) { auxSistema.Dispose();}
			 if (auxDevice != null) { auxDevice.Dispose();}
			 if (auxProcess != null) { auxProcess.Dispose();}
			 if (auxUser != null) { auxUser.Dispose();}
			 
			 auxGlobal = null;
			 auxRole = null;
			 auxSistema = null;
			 auxDevice = null;
			 auxProcess  = null;
			 auxUser = null;
			
			 dataGlobal = null;
			 dataRole = null;
			 dataSistema = null;
			 dataDevice = null;
			 dataProcess = null;
			 dataUser = null;
		}
		
		return Dev;
	}
	

	protected void addDebug(String info)
	{
			new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_BUSSINESS, "("+className+") "+info, ParamsApp.LOG_TYPE_INFO);
	}
	
}
