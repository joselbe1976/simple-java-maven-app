/*
 * Equilibrha 2016. Metodos para el telefono de tinnova
 * Jose Luis Bustos. 
 */

package com.portalmobile.tinnova;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.globalSystems.paramsSystem;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.hb_tools;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.tools.cache.documentsCache;
import com.common.tools.encript.Base64Tools;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.xml.XmlHelper;

public class hb_mobile_functions_tinnova_mss_team extends hb_main_tinnova  implements iDisposable{
	private boolean SYSTEM_CACHE_FOTOS = true; // cacheo de fotos
	private ParamsApp IntParams;
	private hb_tools tools;
	private tiinova_backend_tools backendToolsTiinova;
	
	
	private static String className = "";
	
	// constructor class
	public hb_mobile_functions_tinnova_mss_team() {
		IntParams = new ParamsApp();
		tools = new hb_tools();
		backendToolsTiinova = new tiinova_backend_tools();
	
		className = this.getClass().getSimpleName(); //Class name for logs
	}
	public void Dispose() {
		tools = null;
		IntParams = null;
		if (backendToolsTiinova != null) {backendToolsTiinova.Dispose();}
		backendToolsTiinova = null;
	}
	
	public void setCacheFotos(boolean value) {
		SYSTEM_CACHE_FOTOS = value;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public String getMssMisEmpleados(logonCredencialProcess Session,String IdHR, String filters, double PaginaDatos) throws Exception
	{
			XmlHelper helperXml = new XmlHelper();
			if (Session==null) {return helperXml.getErrorValues("");}
			String Filters =filters;
			Map row =null;
			paramsSystem apply; //Apply Values MObile
			String XML;
			
			try{
				
				//Call to applyValues to get NUm records by Device is now connected the user
				apply = new paramsSystem();
				double numRegGetMeta4 = Double.parseDouble(apply.getParamValue(4, Session.SerialKeyForIdProcess, this.getClass().getSimpleName())); //el proceso siempre el nombre de la clase 
				
				//calculate the page and data to send Device
				Double pagina = PaginaDatos ; //Data Page
				Double desde = pagina * numRegGetMeta4;
				Double NumRecords = numRegGetMeta4;
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
						
				//Sql for Tinnova. Only Hires and Manager security
				String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
				String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
				String Sql = "SELECT * FROM MBL_EMPLEADOS_BUSCADOR WHERE ID_SOCIEDAD = '" + sociedad +  "' ";
				Sql += " AND ID_DEPARTAMENTO IN (SELECT ID_DEPARTAMENTO FROM M4T_DEPARTAMENTOS WHERE ID_SOCIEDAD = '"+sociedad+"' AND (ID_RESPONSABLE = '"+idEmpleado+"' OR ID_RESPONS_RESP = '"+idEmpleado+"')) ";
				
				//User filter to the end of SQL sentence /(gbname = ""
				if (!Filters.equals("")) {
					
					Filters  = Filters.replace("GB_NAME", "").replace("{","").replace("}", "").replace("=", "").trim();
					
					//filter by name or appells and Id employee
					String filterSend = " ( NOMBRE LIKE '%" + Filters +  "%' ";
					filterSend += " OR APELLIDO_1 LIKE '%" +  Filters +  "%' ";
					filterSend += " OR APELLIDO_2 LIKE '%" +  Filters +  "%' ";
					filterSend += " OR ID_EMPLEADO LIKE '%" + Filters +  "%' ) ";
					
					Sql += " AND  " + filterSend;
				}
				
				Sql = Sql + " ORDER BY ID_EMPLEADO ASC ";
				
				//create Query and Pagination
				SQLQuery query  = this.getSqlQuery(Sql);
				query.setFirstResult(desde.intValue());     
				query.setMaxResults(NumRecords.intValue());
				
				List<?> data  = this.getDataFromQuery(query); //execute SQL from Query Object
				
				//Total Records
				helperXml.addXmlItem("TotalRecords", String.valueOf(data.size()), helperXml.XML_NORMAL);
						
				String fileCache="";
				
				
				//record by record
				int numregSend = 0;
				for (int z = 0;z<data.size();z++)
				{
						numregSend ++;
						row = (Map)data.get(z); //Extract the row
						
						String idEmpe= row.get("ID_EMPLEADO").toString();
						String idSoc = row.get("ID_SOCIEDAD").toString();
						String fecAlta = row.get("FEC_ALTA_EMPLEADO").toString();
						
						//Legal Document NIF for the Image Employee + Sociedad
						fileCache =  idSoc + "_" + row.get("ID_LEGAL").toString();
						
						String IdEmployeeSendDevice = backendToolsTiinova.getCreateIdEmployeeComp(row.get("ID_EMPLEADO").toString(), row.get("ID_SOCIEDAD").toString());
						helperXml.addXmlItem("idempleado" , z,IdEmployeeSendDevice, helperXml.XML_NORMAL);
						helperXml.addXmlItem("sociedad" , z,row.get("ID_SOCIEDAD").toString(), helperXml.XML_NORMAL); //ALWAYS VOID 
						helperXml.addXmlItem("ordinal" , z,"0", helperXml.XML_NORMAL);
						helperXml.addXmlItem("nombre" , z,row.get("NOMBRE").toString() + " " + row.get("APELLIDO_1").toString() + " " + row.get("APELLIDO_2").toString(), helperXml.XML_NORMAL);
						helperXml.addXmlItem("nif" , z,row.get("ID_LEGAL").toString(), helperXml.XML_NORMAL);
						helperXml.addXmlItem("fotoid" , z,fileCache, helperXml.XML_NORMAL);
						
						if (row.get("DIRECCION_MAIL") == null){
							helperXml.addXmlItem("mail" , z,"", helperXml.XML_NORMAL);
						}else{
							helperXml.addXmlItem("mail" , z,row.get("DIRECCION_MAIL").toString(), helperXml.XML_NORMAL);
						}
						
						//Se obtiene la extension
						String extension = backendToolsTiinova.getPhoneExtension(idSoc, idEmpe);
						
						//Se obtiene el numero de telefono
						String SqlTelefono = "SELECT TELEFONO FROM  M4T_DOMIC_EMPL WHERE ID_SOCIEDAD = '"+idSoc+"' AND ID_EMPLEADO = '"+idEmpe+"'";
						String telefono = backendToolsTiinova.getDBValueSql(SqlTelefono,"TELEFONO");
						
						if(extension == null) {
							extension = "";
						}
						
						if(telefono == null) {
							telefono = "";
						}
						
						if(!telefono.equals("") && !extension.equals("")) {
							extension = extension + " - ";
						}
						
						//Ahora se devuelve la extension seguida del número de telefono
						//employee Data
						
						helperXml.addXmlItem("telefono",z,extension + telefono, helperXml.XML_NORMAL);
						
						String SqlPuesto = "SELECT B.N_PUESTO FROM M4T_HIST_PUESTOS A, M4T_PUEST_TRAB B WHERE A.ID_SOCIEDAD = '"+idSoc+"' AND A.ID_EMPLEADO = '"+idEmpe+"' AND A.FEC_ALTA_EMPLEADO = " + backendToolsTiinova.getFormatDateFilter(fecAlta) + " AND A.ID_PUESTO = B.ID_PUESTO AND A.ID_SOCIEDAD = B.ID_SOCIEDAD AND  A.FEC_FIN IS NULL";
						helperXml.addXmlItem("base64nmpuesto",z,backendToolsTiinova.getDBValueSql(SqlPuesto,"N_PUESTO"), helperXml.XML_NORMAL);
						
						//Employee Image
						try{
							
							String FileCacheImagen = new documentsCache().getCacheFileListImage(fileCache);
			
							
							if (FileCacheImagen.equals(""))
							{
								//no foto in cache
								
									String PathFoto = "";

									Sql = "SELECT N_FICHERO FROM M4T_INF_GRAF_EMPL WHERE ID_EMPLEADO='" + idEmpe + "' and  ID_SOCIEDAD = '" + idSoc + "'";
									List<?> dataAuxFoto  = this.getDataSQLNativo(Sql);
									
									if (dataAuxFoto.size() > 0)
									{
										Map rowFoto = (Map)dataAuxFoto.get(0); //extraemos la filA
										PathFoto= rowFoto.get("N_FICHERO").toString();
									}
									
									if (!PathFoto.equals("")) //foto
									{
										//control of Remote Files of Tinnova
										PathFoto = backendToolsTiinova.readRemoteFilesToLocal(PathFoto,Session.SerialKeyMainReturnApps, false); //Get Remote File to Local temp File
										
										//cache is active in params
										if (SYSTEM_CACHE_FOTOS)
										{
											new documentsCache().cacheFile(PathFoto, fileCache, documentsCache.CACHE_GROUP_IMAGE);
										}
										
										//remove the temporal foto
										new ParamsApp().DeleteFich(PathFoto); 
										
									}
							}
						}
						catch(Exception ee) 
						{
							addLog("getMssMisEmpleados (Image) : " + ee.getMessage(), ParamsApp.LOG_TYPE_ERROR);
						}
						finally {
							helperXml.addXmlItem("foto",z,""  , helperXml.XML_NORMAL);
						}
						

				} //del for
				
				//XML: num of records we send in XML 
				helperXml.addXmlItem("Records", String.valueOf(numregSend).replace(".0", ""), helperXml.XML_NORMAL);
				helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			
				//generate the XML Values
				XML = helperXml.getValues(); 
				
			}
			catch(Exception e)
			{
				XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
				addLog("getMssMisEmpleados : "+e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				
			}
			finally
			{
				if (helperXml != null) {	helperXml.Dispose();}
				helperXml = null;
				apply=null;
			
			}
			
			return XML;
		}
	
	
	// Debug class
	protected void addLog(String info, int logType)
	{
		new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_BUSSINESS, "("+className+") "+info, logType);
	}
		
}
