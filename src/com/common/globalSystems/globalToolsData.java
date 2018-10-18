/*-----------------------------------------------------------------------------------
 * Jose Luis Bustos Esteban
 * -----------------------------------------------------------------------------------
 * Funciones globales al sistema
 * -----------------------------------------------------------------------------------
 */

package com.common.globalSystems;

import com.common.config.ParamsApp;
import com.common.hibernate.classes.*;
import com.common.hibernate.entidades.*;
import com.common.tools.interfaces.iDisposable;

public class globalToolsData {

	
	private String className = "";
	
	//Constructores
	public globalToolsData()
	{
		initClass();
	}

	//Coomun a todos los constructores
	private void initClass()
	{
		new ParamsApp();
		className = this.getClass().getSimpleName(); //nombre de la clase
		
	}
		
	
	
	// ----------------------------------------------------------------
	// Devuelve el codigo del sistema de un proceso
	// ----------------------------------------------------------------
	public String getSystemOfProcessId(String IdProcess)
	{
		hb_process data2 = new hb_process();
		VinProcess aux2;
		
		String idSystem = "";
		try{
			aux2 =  data2.getDataObject(IdProcess);
			idSystem = aux2.getVinSystems().getIdSystem();
		}
		catch (Exception e)
		{
			addDebug("ERROR: " + e.getMessage());
		}
		finally
		{
			if (data2 != null) {data2.Dispose();}
			data2 = null;
			aux2 = null;
		}		
		return idSystem;
	}

	
	
	// ----------------------------------------------------------------
	// Devuelve el c�digo del Role de un Usuario
	// ----------------------------------------------------------------	
	public int getRoleOfUser(String IdUser)
	{
		hb_users data = new hb_users();
		VinUsers aux;
		int idRole=-1;
		
		try{
			aux =  data.getUser(IdUser);
			idRole = aux.getVinRoles().getId();
		}
		catch (Exception e)
		{
			addDebug("ERROR: " + e.getMessage());
		}
		finally
		{
			if (data != null) {data.Dispose();}
			data = null;
			aux = null;
		}		
		return idRole;
	}
	
	// ----------------------------------------------------------------
	// Devuelve el Device de un usuario
	// ----------------------------------------------------------------	
		public String getDeviceOfUser(String IdUser)
		{
			hb_users data = new hb_users();
			VinUsers aux;
			String idDevice="";
			
			try{
				aux =  data.getUser(IdUser);
				idDevice = aux.getVinDevicesByIdDispAccess().getIdDevice();
			}
			catch (Exception e)
			{
				addDebug("ERROR: " + e.getMessage());
			}
			finally
			{
				if (data != null) {data.Dispose();}
				data = null;
				aux = null;
			}		
			return idDevice;
		}	
	
	
	
	
	// Debug de la clase
	private void addDebug(String info)
	{
		new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_BUSSINESS, "("+className+") "+info, ParamsApp.LOG_TYPE_INFO);	
	}

	
	
	
	
	
	
	
	
	
}
