/*
 * Jose Luis Bustos Esteban. Esta clase abstrae del uso del aplicavalor en los metodos funcionales del sistema
 */
package com.common.globalSystems;

import com.common.globalSystems.login.logonCommon;
import com.common.globalSystems.login.logonData;
import com.common.tools.interfaces.iDisposable;

public class paramsSystem {
	
	//constructor
	public paramsSystem()
	{
		
	}
	

	
	
	//apartir de un serial, devolvemos el parametro con el aplicaValor
	public String getParamValue(int Param, String KeySerial, String idProceso)
	{
		logonCommon session;
		logonData data = null;
		applyValueParams apply;
		String value= "";
		
		try{
			
			//recuperamos los datos de la session
			session = new logonCommon();
			data = session.getvalueUserOfTokenPerformance(KeySerial);
			
			//Hacemos el aplicaValor
			apply = new applyValueParams(data, idProceso);
			value= apply.clcGetValueApplyValues(Param);
			
			//Dispose
			session.Dispose();
			apply.Dispose();
			
		}
		catch(Exception e)
		{
			value="";
		}
		finally
		{
			
			session = null;
			data = null;
			apply=null;
		}
		return value;
		
	}
	
	

}
