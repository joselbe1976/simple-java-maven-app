/*
 * Equilibrha 2018. Query Module for Devices
 * Jose Luis Bustos. 
 */

package com.portalmobile.tinnova;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.tools.excel.excelGenerate;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.xml.XmlHelper;


public class hb_mobile_functions_tinnova_mss_reports extends hb_main_tinnova  implements iDisposable{
	private ParamsApp IntParams;
	private tiinova_backend_tools backendToolsTiinova;
	
	
	private static String className = "";
	
	// constructor class
	public hb_mobile_functions_tinnova_mss_reports() {
		IntParams = new ParamsApp();
		backendToolsTiinova = new tiinova_backend_tools();
	
		className = this.getClass().getSimpleName(); //Class name for logs
	}
	public void Dispose() {
		IntParams = null;
		backendToolsTiinova.Dispose();
		backendToolsTiinova = null;
	}
	
	

	// Return My Queries
	@SuppressWarnings("rawtypes")
	public String getMssMisConsultas(logonCredencialProcess Session) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		String XML="";
		Map row =null;
		List<?> data ;
		try{
			
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
			
			String SQL = "SELECT A.* FROM EQ_QUERY A , EQ_QUERY_SEG B WHERE A.ID_SOCIEDAD = B.ID_SOCIEDAD AND A.ID_QUERY = B.ID_QUERY AND A.ID_SOCIEDAD = '"+sociedad+"' AND  B.ID_EMPLEADO = '"+idEmpleado+"'";
			data  = this.getDataSQLNativo(SQL);
			int numQueries = data.size();
		
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","1", helperXml.XML_NORMAL);
			helperXml.addXmlItem("Records", String.valueOf(numQueries), helperXml.XML_NORMAL);
			
			for(int z = 0; z<numQueries;z++)
			{
				row = (Map)data.get(z);
				
				String SqlCount = "SELECT  COUNT(*) AS NUM FROM EQ_QUERY_PARAMS WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_QUERY = '"+row.get("ID_QUERY").toString()+"' AND SEND_DEVICE = 1";
				String numParams = backendToolsTiinova.getDBValueSql(SqlCount,"NUM"); //NUMBER OF PARAMS
				
				
				helperXml.addXmlItem("idMeta4Object" , z,row.get("ID_QUERY").toString() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("name" , z,row.get("NOMBRE").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("totparams" , z,numParams, helperXml.XML_NORMAL);
				helperXml.addXmlItem("description" , z,row.get("DESCRIPCION").toString(), helperXml.XML_NORMAL);
			}
			
			
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
			
		}
		catch(Exception e)
		{
			XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			e.printStackTrace();
			
		}
		finally
		{
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
			row = null;
			data = null;
		}
		
		return XML;
	}


	// Get Query MetaData
	@SuppressWarnings("rawtypes")
	public String getMssMiConsultaMetaData(logonCredencialProcess Session, String idQuery) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		String XML="";
		List<?> data = null;
		Map row =null;
		try{

			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			
			//GET params for send to device to hep filter report
			String SQL = "SELECT * FROM EQ_QUERY_PARAMS WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_QUERY = '"+idQuery+"' AND SEND_DEVICE = 1";
			data  = this.getDataSQLNativo(SQL);
			int numQueries = data.size();
		
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","1", helperXml.XML_NORMAL);
			helperXml.addXmlItem("Records", String.valueOf(numQueries), helperXml.XML_NORMAL);
			
			for(int z = 0; z<numQueries;z++)
			{
				row = (Map)data.get(z);
				
				helperXml.addXmlItem("idparam" , z,row.get("ID_PARAM").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("node" , z,"ROOT", helperXml.XML_NORMAL);
				helperXml.addXmlItem("name" , z,row.get("NOMBRE").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("description" , z,row.get("DESCRICION").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("tipodata" , z,row.get("TP_DATA").toString(), helperXml.XML_NORMAL);
			}
			
			
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
			
		}
		catch(Exception e)
		{
			helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			XML = helperXml.getValues(); 
			e.printStackTrace();
			
		}
		finally
		{
			helperXml = null;
			data = null;
			row = null;
		}
		
		return XML;
	}

	// Execute Query from Device
	@SuppressWarnings("rawtypes")
	public String getMssExecuteQuery(logonCredencialProcess Session, String idQuery, String params) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		
		String XML="";
		List<?> dataDef = null;
		List<?> dataPar = null;
		Map row =null;
		excelGenerate excel = null;
		
		try{
			
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
			
			
			//Deserialice params
			HashMap args = this.DeserializeParams(params);
			
			//get query definition
			String SQLDef1 = "SELECT SQL_SENTENCE, SQL_FIELDS_EXCEL, SQL_ORDEN FROM EQ_QUERY WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_QUERY = '"+idQuery+"'";
			dataDef  = this.getDataSQLNativo(SQLDef1);
			
			String SQLQuery = "";
			String ExcelFields = "";
			String SqlOrden = "";
			if (dataDef.size() > 0){
				row = (Map)dataDef.get(0);
				SQLQuery = row.get("SQL_SENTENCE").toString();
				ExcelFields = row.get("SQL_FIELDS_EXCEL").toString();
				
				if (row.get("SQL_ORDEN") != null) {
					SqlOrden = row.get("SQL_ORDEN").toString();
				}
			}
			
			
			//get Query "only" Internal Params 
			String SQLParams = "SELECT ID_PARAM, TP_DATA, DEFAULT_VALUE, SEND_DEVICE, FIELD FROM EQ_QUERY_PARAMS WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_QUERY = '"+idQuery+"'";
			dataPar  = this.getDataSQLNativo(SQLParams);
			

			//set Internal Params into the Sentence		
			for (int i = 0; i < dataPar.size(); i++) {
				row = (Map)dataPar.get(i);
				
				String ID_PARAM = row.get("ID_PARAM").toString();
				String TP_DATA= row.get("TP_DATA").toString();
				String DEFAULT_VALUE= "";
				if (row.get("DEFAULT_VALUE") != null) {
					DEFAULT_VALUE=row.get("DEFAULT_VALUE").toString();
				}
				String FIELD = "";
				if (row.get("FIELD") != null) {
					FIELD = row.get("FIELD").toString();
				}
				
				
				int SEND_DEVICE=  Integer.parseInt(row.get("SEND_DEVICE").toString());
				
				String txtFind = "@" + ID_PARAM + "@";
				String txtReplace = "";
				
				if (SEND_DEVICE == 0) {
					//Internal, no send to Device. Only Replace
					
					switch(ID_PARAM) {
					case "ID_SOCIEDAD":
						txtReplace = sociedad;
						break;
					case "ID_EMPLEADO":
						txtReplace = idEmpleado;
						break;
					}
					
					//Replace all ocurrences in Query SQL
					SQLQuery = SQLQuery.replaceAll(txtFind, txtReplace); 
				}
				else{
					//user. Send to Device
					
					String value = (String) args.get(ID_PARAM);
					
					//if have value and not null
					if (value != null && value.length() > 0) {
							
						SQLQuery+= " AND " + FIELD + " ";
						
						switch(TP_DATA) {
							case "STRING":
								SQLQuery+= " LIKE '%" + value.trim() + "%'";
								break;
							case "DATE":
								SQLQuery+= " = " +  backendToolsTiinova.getFormatDateFilter(value.trim()) + " ";
								break;
							default:
								SQLQuery+= " = " + value.trim() + " ";
						}
						
						
						
						//Replace all ocurrences in Query SQL
						SQLQuery = SQLQuery.replaceAll(txtFind, value); 
					}
				}
			}
			
			//Parse The Order
			SQLQuery += " " + SqlOrden;
			
			//Here The SQL is OK
			addLog("SQLQuery to Execute" + SQLQuery, ParamsApp.LOG_TYPE_INFO);
			dataDef  = this.getDataSQLNativo(SQLQuery); //exec
			
			//generate the XLS Excel File
			excel = new excelGenerate();
			List<String> colsExcel = Arrays.asList(ExcelFields.split(","));
			String excelPath = excel.generateExcelFile(Session.SerialKeyMainReturnApps, dataDef, colsExcel);
			
			//decode to Base64
			String ExcelBase64 = new ParamsApp().readFileAndConvertBase64String(excelPath);
			
			
			//remove file
			IntParams.DeleteFich(excelPath);
		
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","1", helperXml.XML_NORMAL);
			helperXml.addXmlItem("Records", "0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("file",ExcelBase64, helperXml.XML_NORMAL);
			helperXml.addXmlItem("ext","xls", helperXml.XML_NORMAL); //info to Device (ios) that save in realm with XLS extension and not XSLX
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
			
		}
		catch(Exception e)
		{
			helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			XML = helperXml.getValues(); 
			e.printStackTrace();
			
		}
		finally
		{
			helperXml = null;
		}
		
		return XML;
		
	}
	
	
	
	
	//private methods
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private HashMap DeserializeParams(String serial)
	{
		HashMap map = new HashMap();
		
		String data[]  = serial.split("@");
		
		for (int i = 0; i<data.length; i++) {
			
			String data2[] = data[i].split("=");
			
			//have data from device. I use this
			if (data2.length > 1) {
				map.put(data2[0], data2[1]);
			}
			
		}
		return map; //return the hashmap
	}
	
	// Debug class
	protected void addLog(String info, int logType)
	{
		new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
	}
		
}
