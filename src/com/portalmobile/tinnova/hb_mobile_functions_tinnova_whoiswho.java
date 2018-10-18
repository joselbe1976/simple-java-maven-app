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
import com.common.tools.interfaces.iDisposable;
import com.common.tools.xml.XmlHelper;


public class hb_mobile_functions_tinnova_whoiswho extends hb_main_tinnova  implements iDisposable{
	private boolean SYSTEM_CACHE_FOTOS = true; // cacheo de fotos
	private ParamsApp IntParams;
	private hb_tools tools;
	private tiinova_backend_tools backendToolsTiinova;
	
	
	private static String className = "";
	
	// constructor class
	public hb_mobile_functions_tinnova_whoiswho() {
		IntParams = new ParamsApp();
		tools = new hb_tools();
		backendToolsTiinova = new tiinova_backend_tools();
	
		className = this.getClass().getSimpleName(); //Class name for logs
	}
	public void Dispose() {
		tools = null;
		IntParams = null;
		backendToolsTiinova.Dispose();
		backendToolsTiinova = null;
	}
	
	public void setCacheFotos(boolean value) {
		SYSTEM_CACHE_FOTOS = value;
	}
	
	
	
	@SuppressWarnings("rawtypes")
	public String getEssWhoIsWho(logonCredencialProcess Session,String filters, double PaginaDatos) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		String XML="";
		paramsSystem apply; //aplicaValor
		Map row =null;
		
		
		try{
			
			//Call to applyValues to get NUm records by Device is now connected the user
			apply = new paramsSystem();
			double numRegGetMeta4 = Double.parseDouble(apply.getParamValue(4, Session.SerialKeyForIdProcess, this.getClass().getSimpleName())); //el proceso siempre el nombre de la clase 
			
			//calculate the page and data to send Device
			Double pagina = PaginaDatos ; //Data Page
			Double desde = pagina * numRegGetMeta4;
			Double NumRecords = numRegGetMeta4;
			

			//Get the prioncipal Data
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String Sql = "SELECT * FROM MBL_EMPLEADOS_LISTA WHERE ID_SOCIEDAD = '" + sociedad +  "' ";
			String SqlCount = "SELECT count(*) as NUM FROM MBL_EMPLEADOS_LISTA WHERE ID_SOCIEDAD = '" + sociedad +  "' ";
			
			if (!filters.equals("")) {
				//filter by name or appells and Id employee
				String filterSend = " ( NOMBRE LIKE '%" + filters +  "%' ";
				filterSend += " OR APELLIDO_1 LIKE '%" +  filters +  "%' ";
				filterSend += " OR APELLIDO_2 LIKE '%" +  filters +  "%' ";
				filterSend += " OR ID_EMPLEADO LIKE '%" +  filters +  "%' ) ";
				
				//Add to SQL
				Sql = Sql + " AND  " + filterSend;
				SqlCount = SqlCount + " AND " + filterSend;
			}
			Sql = Sql + " ORDER BY APELLIDO_1 ASC,  APELLIDO_2 ASC, NOMBRE ASC ";
			
			//create Query and Pagination
			SQLQuery query  = this.getSqlQuery(Sql);
			query.setFirstResult(desde.intValue());     
			query.setMaxResults(NumRecords.intValue());
			List<?> data  = this.getDataFromQuery(query); //execute SQL from Query Object
			
			int records = data.size();
			
			// Calculate the Count Total of Records in DataBase
			int totRecords = 0;
			String dataResultCount = this.backendToolsTiinova.getDBValueSql(SqlCount, "NUM");
			if (!dataResultCount.equals("")) {
				totRecords = Integer.parseInt(dataResultCount);
			}
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("Records", String.valueOf(records), helperXml.XML_NORMAL);
			helperXml.addXmlItem("TotalRecords", String.valueOf(totRecords), helperXml.XML_NORMAL);
			
			String fileCache="";
			String FileCacheImagen = "";
			
			for (int z = 0;z<records;z++)
			{
		
				row = (Map)data.get(z); //Extract the row
				String idEmpe= row.get("ID_EMPLEADO").toString();
				String idSoc = row.get("ID_SOCIEDAD").toString();
				String nif = row.get("ID_LEGAL").toString();
				String name = row.get("NOMBRE").toString() + " " + row.get("APELLIDO_1").toString() + " ";
				
				if (row.get("APELLIDO_2") != null) {
					name += row.get("APELLIDO_2").toString();
				}
				/*
				String SqlTelefono = "SELECT TELEFONO FROM  M4T_DOMIC_EMPL WHERE ID_SOCIEDAD = '"+idSoc+"' AND ID_EMPLEADO = '"+idEmpe+"'";
				String telefono = backendToolsTiinova.getDBValueSql(SqlTelefono,"TELEFONO");
				*/
				
				//Se obtiene la extension en lugar del telefono
				String telefono = backendToolsTiinova.getPhoneExtension(idSoc, idEmpe);
				
				//Legal Document NIF for the Image Employee + Sociedad
				fileCache =  idSoc + "_" + nif;
				
				helperXml.addXmlItem("idempleado" , z,idEmpe, helperXml.XML_NORMAL);
				helperXml.addXmlItem("nombre" , z,name, helperXml.XML_NORMAL);
				helperXml.addXmlItem("telefono" , z,telefono, helperXml.XML_NORMAL);
				helperXml.addXmlItem("nif" , z,nif, helperXml.XML_NORMAL);
				helperXml.addXmlItem("idfile" , z,fileCache, helperXml.XML_NORMAL);
				helperXml.addXmlItem("sociedad" , z,idSoc, helperXml.XML_NORMAL);
				helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL); 
				
				if (row.get("DIRECCION_MAIL") == null){
					helperXml.addXmlItem("mail" , z,"", helperXml.XML_NORMAL);
				}else{
					helperXml.addXmlItem("mail" , z,row.get("DIRECCION_MAIL").toString(), helperXml.XML_NORMAL);
				}				
				
				
				//Employee Image
				
				List<?> dataAuxFoto = null;
				Map rowFoto = null;
				
				try{
					
				    FileCacheImagen = new documentsCache().getCacheFileListImage(fileCache);
					
					if (FileCacheImagen.equals(""))
					{
						//no foto in cache
						
							String PathFoto = "";

							Sql = "SELECT N_FICHERO FROM M4T_INF_GRAF_EMPL WHERE ID_EMPLEADO='" + idEmpe + "' and  ID_SOCIEDAD = '" + idSoc + "'";
						    dataAuxFoto  = this.getDataSQLNativo(Sql);
							
							if (dataAuxFoto.size() > 0)
							{
								rowFoto = (Map)dataAuxFoto.get(0); 
								PathFoto= rowFoto.get("N_FICHERO").toString();
							}
							
							if (!PathFoto.equals("")) //foto
							{
								//control of Remote Files of Tinnova
								PathFoto = this.backendToolsTiinova.readRemoteFilesToLocal(PathFoto,Session.SerialKeyMainReturnApps, false); //Get Remote File to Local temp File
								
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
					addLog("getEssWhoIsWho (Image) : " + ee.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				}
				finally {
					dataAuxFoto = null;
					rowFoto = null;
				}
				
				
				
			} //del for

			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
			
		}
		catch(Exception e)
		{
			addLog("getEssWhoIsWho  : " + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
			XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
		}
		finally
		{
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
			apply=null;
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
