/*
 * Equilibrha 2018. ESS Documents Employee
 * Jose Luis Bustos. 
 */

package com.portalmobile.tinnova;

import java.util.List;
import java.util.Map;
import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.xml.XmlHelper;

public class hb_mobile_functions_tinnova_documents extends hb_main_tinnova  implements iDisposable{
	private tiinova_backend_tools backendToolsTiinova;
	
	
	private static String className = "";
	
	// constructor class
	public hb_mobile_functions_tinnova_documents() {
		backendToolsTiinova = new tiinova_backend_tools();
		className = this.getClass().getSimpleName(); //Class name for logs
	}
	public void Dispose() {
		backendToolsTiinova.Dispose();
		backendToolsTiinova = null;
	}
	
	// get File from device (no cache in Server)
	@SuppressWarnings("rawtypes")
	public String GetRealFileUser(logonCredencialProcess Session, double OrdFile)
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}

		String XML = "";
		Map row =null;
		
		try{
			
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;

			// Get Docuemnts from Tiinova
			String SQL = "SELECT ID_SOCIEDAD, ID_EMPLEADO, ORDINAL,  EXT_FILE, FILE_S FROM MBL_FILES_TODAY WHERE  ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEADO = '"+idEmpleado+"' AND ORDINAL = " +  String.valueOf(OrdFile);
			List<?> data  = this.getDataSQLNativo(SQL);
			int numRegMeta4 = data.size();
			
			//control No records (concurrency is possible)
			if (numRegMeta4 == 0) {
				return helperXml.getErrorValues("");
			}

			row = (Map)data.get(0);
			
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
			//code meta4
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);

			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
					
			//Records  
			helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);
			
			//Extension and file
			helperXml.addXmlItem("extension", row.get("EXT_FILE").toString(), helperXml.XML_NORMAL);
			helperXml.addXmlItem("file", row.get("FILE_S").toString(), helperXml.XML_NORMAL);
			
			//ordinal
			helperXml.addXmlItem("ordinal", row.get("ORDINAL").toString(), helperXml.XML_NORMAL);
		
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			
			XML = helperXml.getValues();	
			
			// Mark in DataBase the File as Downloaded.
			Boolean dev = this.SaveFileUserDownload(sociedad, idEmpleado, OrdFile);
			
			if (!dev) {
				//error
				addLog("GetRealFileUser (error to mark as downloaded the file)", ParamsApp.LOG_TYPE_ERROR);
			}
	
		}
		catch(Exception e)
		{
			addLog("GetRealFileUser : " + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
			XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
		}
		finally
		{
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
			row = null;
		}
		
		return XML;

	}
	
	
	
	// --------------------------------------------------------------------------------
	// Mark a file in database as Deleted
	// --------------------------------------------------------------------------------
	public String DeleteFileUser(logonCredencialProcess Session, double OrdFile)
	{
		XmlHelper helperXml = new XmlHelper();
		hb_main_tinnova tinnova = null;
		
		if (Session==null) {return helperXml.getErrorValues("");}

		String XML = "";

		try{
			tinnova = new hb_main_tinnova();
			
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
		
			String SqlUpdate = "UPDATE EQ_MBL_FILES SET CHK_DEL_MOBILE = '1' ";
			SqlUpdate += " WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEADO = :empleado  AND ORDINAL = :ordinal";
			
			SQLQuery query  = tinnova.getSqlQuery(SqlUpdate);
			query.setParameter("sociedad", sociedad);
			query.setParameter("empleado", idEmpleado);
			query.setParameter("ordinal", OrdFile);
			
			int dev = tinnova.executeSqlAdvance(query); //execute the update
					
			if (dev == 0) { //Execution OK
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
				helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);
				helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
				XML = helperXml.getValues();	
			}
			else {
				XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			}
			
		}
		catch(Exception e)
		{
			XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			addLog("DeleteFileUser : " + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
		}
		finally
		{
			if (tinnova != null) {tinnova.Dispose();}
			tinnova = null;
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
		}
		
		return XML;

	}
	
	
	// --------------------------------------------------------------------------------
	// Save File in DataBAse as Readed
	// --------------------------------------------------------------------------------
	public String SaveFileUserRead(logonCredencialProcess Session, double OrdFile)
	{
		
	XmlHelper helperXml = new XmlHelper();
	hb_main_tinnova tinnova = null;
	
	if (Session==null) {return helperXml.getErrorValues("");}

	String XML = "";

	try{
		tinnova = new hb_main_tinnova();
		
		String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
		String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
	
		String SqlUpdate = "UPDATE EQ_MBL_FILES SET CHK_RECIBIDO = '1' ";
		SqlUpdate += " WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEADO = :empleado  AND ORDINAL = :ordinal";
		
		SQLQuery query  = tinnova.getSqlQuery(SqlUpdate);
		query.setParameter("sociedad", sociedad);
		query.setParameter("empleado", idEmpleado);
		query.setParameter("ordinal", OrdFile);
		
		int dev = tinnova.executeSqlAdvance(query); //execute the update
				
		if (dev == 0) { //Execution OK
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues();	
		}
		else {
			XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
		}
		
	}
	catch(Exception e)
	{
		XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
		addLog("SaveFileUserRead : " + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
	}
	finally
	{
		if (tinnova != null) {tinnova.Dispose();}
		tinnova = null;
		if (helperXml != null) {helperXml.Dispose();}
		helperXml = null;
	}
	
	return XML;

}	
	
	// --------------------------------------------------------------------------------
	// Internal Use
	// --------------------------------------------------------------------------------
	private Boolean SaveFileUserDownload(String sociedad, String idEmpleado,  double OrdFile)
	{
		hb_main_tinnova tinnova = null;
	
		try{
			tinnova = new hb_main_tinnova();
			
			String SqlUpdate = "UPDATE EQ_MBL_FILES SET CHK_DOWNLOAD = '1' ";
			SqlUpdate += " WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEADO = :empleado  AND ORDINAL = :ordinal";
			
			SQLQuery query  = tinnova.getSqlQuery(SqlUpdate);
			query.setParameter("sociedad", sociedad);
			query.setParameter("empleado", idEmpleado);
			query.setParameter("ordinal", OrdFile);
			
			int dev = tinnova.executeSqlAdvance(query); //execute the update
					
			if (dev == 0) { //Execution OK
				return true;
			}
			else {
				return false;
			}
			
		}
		catch(Exception e)
		{
			addLog("SaveFileUserDownload : " + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
			return false;
		}
		finally
		{
			if (tinnova != null) {tinnova.Dispose();}
			tinnova = null;
		}
	
	

	}	
		
		
	// Returns list of documents send user connectd
	@SuppressWarnings("rawtypes")
	public String GetFilesUserMeta4(logonCredencialProcess Session, double OrdFile){
			
			XmlHelper helperXml = new XmlHelper();
			
			if (Session==null) {return helperXml.getErrorValues("");}

			String XML = "";
			Map row =null;

			
			try{
				
				String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
				String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;

				// Get Docuemnts from Tiinova
				String SQL = "SELECT ID_SOCIEDAD, ID_EMPLEADO, ORDINAL,  MENSAJE, CHK_RECIBIDO, CHK_DOWNLOAD, CHK_DEL_MOBILE, DESCRIPCION, CONVERT(VARCHAR,FECHA_ENVIO, "+ ParamsApp.DATE_SQLSERVER_CONFIG +")  AS FECHA_ENVIO, EXT_FILE FROM MBL_FILES_TODAY WHERE  ID_SOCIEDAD = '"+sociedad+"' and ID_EMPLEADO = '"+idEmpleado+"'";
				List<?> data  = this.getDataSQLNativo(SQL);
				int numRegMeta4 = data.size();
				
				
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code Session
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//compatibility soap execution method
				helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
						
				//num records  
				helperXml.addXmlItem("Records", String.valueOf(numRegMeta4), helperXml.XML_NORMAL);	
	
			
				for (int z = 0;z<numRegMeta4;z++)
				{		
					row = (Map)data.get(z);
					
					helperXml.addXmlItem("recibido",z,row.get("CHK_RECIBIDO").toString(), helperXml.XML_NORMAL);	
					helperXml.addXmlItem("descripcion",z,row.get("MENSAJE").toString(), helperXml.XML_NORMAL);	
					helperXml.addXmlItem("ext",z,row.get("EXT_FILE").toString(), helperXml.XML_NORMAL);	
					helperXml.addXmlItem("mensaje",z,row.get("DESCRIPCION").toString(), helperXml.XML_NORMAL);	
					helperXml.addXmlItem("ordinal",z,row.get("ORDINAL").toString(), helperXml.XML_NORMAL);	
					helperXml.addXmlItem("fenvio",z,row.get("FECHA_ENVIO").toString(), helperXml.XML_NORMAL);	
				}
				
				helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
				XML = helperXml.getValues();			
		}
		catch(Exception e)
		{
			addLog("GetFilesUserMeta4 : " + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
			XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
		}
		finally
		{
			if (helperXml != null) { helperXml.Dispose();}
			helperXml = null;
			row = null;
		}
		
		return XML;
	}
	
	
	// Debug class
	protected void addLog(String info, int logType)
	{
		new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
	}
		
}
