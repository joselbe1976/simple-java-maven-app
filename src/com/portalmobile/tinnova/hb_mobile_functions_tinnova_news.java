/*
 * Equilibrha 2016. Metodos para el telefono de tinnova
 * Jose Luis Bustos. 
 */

package com.portalmobile.tinnova;

import java.util.List;
import java.util.Map;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.hb_tools;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.tools.cache.documentsCache;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.xml.XmlHelper;


public class hb_mobile_functions_tinnova_news extends hb_main_tinnova  implements iDisposable{
	private boolean SYSTEM_CACHE_FOTOS = true; 
	private tiinova_backend_tools backendToolsTiinova;
	
	
	private static String className = "";
	
	// constructor class
	public hb_mobile_functions_tinnova_news() {
		backendToolsTiinova = new tiinova_backend_tools();
	
		className = this.getClass().getSimpleName(); //Class name for logs
	}
	public void Dispose() {
		backendToolsTiinova.Dispose();
		backendToolsTiinova = null;
	}
	
	public void setCacheFotos(boolean value) {
		SYSTEM_CACHE_FOTOS = value;
	}
	
	@SuppressWarnings("rawtypes")
	public String getEssMisNoticias(logonCredencialProcess Session)  throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}
		
		String XML="";

		Map row =null;
		Map rowData =null;
		
		try{
			
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
			
			//Public News & Private News
		
			String SQL = "";
			SQL += " SELECT ID_SOCIEDAD, ORDINAL, TITULO, SUBTITULO, FOTO_EXT, DOC_EXT, [DESCRIPTION]  FROM EQ_MBL_NOTICIAS WHERE INICIO  <= GETDATE() AND FIN >= GETDATE() AND ID_SOCIEDAD = '"+sociedad+"' AND TP_NOTICIA = 0 ";
			SQL += " UNION ALL ";
			SQL += "	 SELECT ID_SOCIEDAD, ORDINAL, TITULO, SUBTITULO, FOTO_EXT, DOC_EXT, [DESCRIPTION]  FROM EQ_MBL_NOTICIAS WHERE INICIO  <= GETDATE() AND FIN >= GETDATE() AND ID_SOCIEDAD = '"+sociedad+"' AND TP_NOTICIA = 1 ";
			SQL += "	 AND ORDINAL IN  (SELECT DISTINCT ORDINAL FROM  EQ_MBL_NOTICIAS_RH WHERE EQ_MBL_NOTICIAS.ID_SOCIEDAD = ID_SOCIEDAD AND EQ_MBL_NOTICIAS.ORDINAL = ORDINAL AND ID_EMPLEADO = '"+idEmpleado+"' ) ";

			List<?> data  = this.getDataSQLNativo(SQL);
			int numRegMeta4 = data.size();
			
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
			//code meta4
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			
			//Result
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
					
			//XML: num records
			helperXml.addXmlItem("Records", String.valueOf(numRegMeta4), helperXml.XML_NORMAL);
		
		
			String fileCache="";
			
		
			//Recorrmeos los registros
			@SuppressWarnings("unused") String ExtensionFile = "";
			
			for (int z = 0;z < data.size(); z++)
			{	
				row = (Map)data.get(z);
					
				helperXml.addXmlItem("titulo" , z,row.get("TITULO").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("descripcion" , z,row.get("SUBTITULO").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("ordinal" , z,row.get("ORDINAL").toString(), helperXml.XML_NORMAL);
				
				// ---- IMAGEN NOTICIA  (multisociedad)
				//Nombre cache imagen. SIempre el Sociedad + news_+ ordinal de la noticia
				fileCache =  row.get("ID_SOCIEDAD").toString() + "_news_" + row.get("ORDINAL").toString();
				helperXml.addXmlItem("fileId",z,fileCache, helperXml.XML_NORMAL);
				
				
				//extension
				String extFinal =  row.get("FOTO_EXT").toString();
				helperXml.addXmlItem("extension" , z, extFinal, helperXml.XML_NORMAL);
				
				
				//------DOCUMENTO ADJUNTO
				String fileCacheDoc =  row.get("ID_SOCIEDAD").toString() + "_news_doc_" + row.get("ORDINAL").toString();
				helperXml.addXmlItem("fileIdDoc",z,fileCacheDoc, helperXml.XML_NORMAL);
				
				//extension Doc
				String extFinalDoc =   row.get("DOC_EXT").toString();
				helperXml.addXmlItem("extensionDoc" , z,extFinalDoc, helperXml.XML_NORMAL);
				
				
				//Validete if Key is in cache
				String FileCacheImagen = new documentsCache().getCacheFileListImage(fileCacheDoc);
				
				if (ParamsApp.SYSTEM_CACHE_LEVEL == 2){
					FileCacheImagen = ""; 
				}
				
				//no cacheada	
				if (FileCacheImagen.equals(""))
				{
					try{
						//Find Files in DataBase and Cache on Redis Server Cache. Is yes or yes necesary
						
						String SqlFiles = "SELECT FOTO_S, DOC_S FROM EQ_MBL_NOTICIAS WHERE ID_SOCIEDAD = '"+row.get("ID_SOCIEDAD").toString() +"' AND ORDINAL = " + row.get("ORDINAL").toString();
						List<?> dataFiles  = this.getDataSQLNativo(SqlFiles);
						
						if (dataFiles.size() > 0) {
							rowData = (Map)dataFiles.get(0);
							
							// Image new
							if (rowData.get("FOTO_S").toString().length() > 0) {
								
								//Cache directly
								if (SYSTEM_CACHE_FOTOS)
								{
									new documentsCache().cacheDataFile(fileCache,extFinal, rowData.get("FOTO_S").toString() );
								}
							}
							// Document of the new
							if (rowData.get("DOC_S").toString().length() > 0) {
								
								//Cache directly
								if (SYSTEM_CACHE_FOTOS)
								{
									new documentsCache().cacheDataFile(fileCacheDoc,extFinalDoc,rowData.get("DOC_S").toString() );
								}
							}
						} //if
						
					}
					catch(Exception ee) 
					{
						addLog("getEssMisNoticias (image cache) : \n" + ee.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
					}
					finally
					{
						helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
						helperXml.addXmlItem("doc",z,"", helperXml.XML_NORMAL);
					}
				}//del if de la cache
				
				
			} //del for

			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
			
		}
		catch(Exception e)
		{
			helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			XML = helperXml.getValues(); 
			addLog("getEssMisNoticias : \n" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
			
		}
		finally
		{
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
			row = null;
			rowData = null;
		
		}
		
		return XML;
	}
	
	
	
	
	
	// Debug class
	protected void addLog(String info, int logType)
	{
		new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
	}
		
}
