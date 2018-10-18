/*
 * Equilibrha 2018. Tinnova Manager Validation Absences Request
 * Jose Luis Bustos. 
 */

package com.portalmobile.tinnova;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.globalSystems.paramsSystem;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.hb_params_global;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.hibernate.entidades.VinParamsGlobal;
import com.common.tools.cache.documentsCache;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.mail.sendMailAsync;
import com.common.tools.xml.XmlHelper;


public class hb_mobile_functions_tinnova_mss_validate extends hb_main_tinnova  implements iDisposable{
	private boolean SYSTEM_CACHE_FOTOS = true; // cacheo de fotos
	private tiinova_backend_tools backendToolsTiinova;
	
	
	private static String className = "";
	
	// constructor class
	public hb_mobile_functions_tinnova_mss_validate() {
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
	
	// -------------------------------------------------------------------------------------
	// MSS. Manager request to validate
	// -------------------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	public String getMssListaSolicAbsentPorValidar(logonCredencialProcess Session,String IdHR,String optional) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		String XML="";
		List<?> data = null;
		List<?> dataFich = null;
		Map row =null;
		
		try{
		
			//current Employee
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
			
			//get Data from SQL. Request to validate manager
			String SQLReal = "SELECT * FROM MBL_AUSENCIAS_MANAGER_PENDIENTE  WHERE ID_SOCIEDAD = '" + sociedad + "' AND ID_EMPLEADO_RESPONSABLE = '" + idEmpleado +  "'"; 
			data  = this.getDataSQLNativo(SQLReal);
	
			//Generate XML Data for Response
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("Records", String.valueOf(data.size()), helperXml.XML_NORMAL);
		
			String fileCache="";
				
			for (int z = 0; z < data.size(); z++)
			{
				row = (Map)data.get(z);

				fileCache =  row.get("ID_SOCIEDAD").toString() +  "_" + row.get("ID_LEGAL").toString() ;
				
				String name = row.get("NOMBRE").toString() + " " + row.get("APELLIDO_1").toString();
				if (row.get("APELLIDO_2") != null) {
					name += " " + row.get("APELLIDO_2").toString();
				}
				String comment = row.get("COMMENT_EMPLOYEE") != null ? row.get("COMMENT_EMPLOYEE").toString() : "";
				String idEmployeeSendApp = backendToolsTiinova.getCreateIdEmployeeComp(row.get("ID_EMPLEDO").toString(), row.get("ID_SOCIEDAD").toString());
				
				helperXml.addXmlItem("comentariosolicitante" , z,comment , helperXml.XML_NORMAL);
				helperXml.addXmlItem("nombre" , z,name, helperXml.XML_NORMAL);
				helperXml.addXmlItem("estado" , z,"1", helperXml.XML_NORMAL);
				helperXml.addXmlItem("nmestado" , z,"Pendiente", helperXml.XML_NORMAL);
				helperXml.addXmlItem("inicio" , z,row.get("FECHA_INICIO").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("fin" , z,row.get("FECHA_FIN").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("dias" , z,row.get("DIAS").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("idabsentismo" , z,row.get("ID_INCIDENCE").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("nmabsentismo" , z,row.get("N_TIPO_ABSENTISMO").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("idempleado" , z,idEmployeeSendApp, helperXml.XML_NORMAL);
				helperXml.addXmlItem("nif" , z,row.get("ID_LEGAL").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("ordinalsolic" , z,row.get("ORDINAL").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("sociedad" , z,row.get("ID_SOCIEDAD").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("idfile" , z,fileCache, helperXml.XML_NORMAL); 
				helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
				
				
				//Image Employee
				try{
					String FileCacheImagen = new documentsCache().getCacheFileListImage(fileCache);
					
					if (FileCacheImagen.equals(""))
					{
	
							String PathFoto = "";

							String Sql = "SELECT N_FICHERO FROM M4T_INF_GRAF_EMPL WHERE ID_EMPLEADO='" + idEmpleado + "' AND  ID_SOCIEDAD = '" + sociedad + "'";
							dataFich = this.getDataSQLNativo(Sql);
							if (dataFich.size() > 0)
							{
								row = (Map)dataFich.get(0); 
								PathFoto= row.get("N_FICHERO").toString();
							}
							
							if (!PathFoto.equals("")) //Employee has a foto asigned in tinnova
							{
								//control of Remote Files of Tinnova
								PathFoto = backendToolsTiinova.readRemoteFilesToLocal(PathFoto,Session.SerialKeyMainReturnApps,false); //Get Remote File to Local temp File
								
								if (SYSTEM_CACHE_FOTOS)
								{
									new documentsCache().cacheFile(PathFoto, fileCache, documentsCache.CACHE_GROUP_IMAGE);
								}
								
								//Delete Temp File Remote
								new ParamsApp().DeleteFich(PathFoto);
							}
					}
				}
				catch(Exception ee)  
				{
					addLog("getMssListaSolicAbsentPorValidar -  Imagen: " + ee.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				}
				
			} 

			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
		}
		catch(Exception e)
		{
			XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			addLog("getMssListaSolicAbsentPorValidar:" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
		}
		finally
		{
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
			row = null;
			data = null;
			dataFich = null;
		}
		
		return XML;
	}
	
	
	
	// -------------------------------------------------------------------------------------
	// MSS. Cancel Request
	// -------------------------------------------------------------------------------------
	public String setMssCancelSolicAbs(logonCredencialProcess Session,String IdHR, double ordinal, String motivo, String optional)  throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		String XML="";
	
		try{
	
			String idEmpleadoReal = backendToolsTiinova.getIdEmployeeRealOfIdEmployeeComp(IdHR);
			String idSociedadReal = backendToolsTiinova.getSociedadRealOfIdEmployeeComp(IdHR);
			int dev = 0;
			
			//update the status to 3 //Cancel
			String SqlUpdate = "UPDATE EQ_SOLIC_ABSEN SET ESTADO = 3 , COMMENT_MANAGER = :motivo WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEDO = :empleado AND ORDINAL = :ordinal";
				
			SQLQuery query  = this.getSqlQuery(SqlUpdate);
			query.setParameter("sociedad", idSociedadReal);
			query.setParameter("empleado", idEmpleadoReal);
			query.setParameter("ordinal", ordinal);
			query.setParameter("motivo", motivo);

			dev = executeSqlAdvance(query); //execute the Update
			
			if (dev == 0) {
				//Send Notification to the Employee
				String message = this.clcMensajeEmployeeCancel(idSociedadReal, idEmpleadoReal, motivo);
				String title = "Rechazada solicitud absentismo";
				backendToolsTiinova.addNotification(idSociedadReal, idEmpleadoReal, message, title);
			}
			
			
			//Generate the XML Response
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
			
		}
		catch(Exception e)
		{
			XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			addLog("setMssCancelSolicAbs:" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
			
		}
		finally
		{
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
		}
		
		return XML;
	}	
	
	
	private String clcMensajeEmployeeCancel(String sociedad, String idEmpleado, String motivo) {
		String MsImagenWeb = backendToolsTiinova.getValueParams(sociedad, "URL_LOGO");
		String MsBackGroundColor = backendToolsTiinova.getValueParams(sociedad,"LOGO_HTML_BACKCOLOR");
		String MsBody =   backendToolsTiinova.getValueParams(sociedad,"NOTIF_0001_CANCEL");
	    String MsFirma =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0002");
	    String MsTitle =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0003_CANCEL");

	    //Create body
	    String Code = "<table width='100%'><tr  bgcolor='"+MsBackGroundColor+"'><td><img src='";
	    Code= Code + MsImagenWeb + "' width='300'></td></tr></table><h2>";
	    Code= Code + MsTitle + "</h2><h4>";
	    Code= Code + MsBody  + "<br><br><b>Motivo: "+ motivo + "</b>";
	    Code= Code +"</h4> <br><br>" + MsFirma ;
	    
	    return Code;
	    
}
	
	// -------------------------------------------------------------------------------------
	// MSS. Acept Request
	// -------------------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	public String setMssAceptarSolicAbs(logonCredencialProcess Session,String IdHR, double ordinal, String motivo, String optional) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		String XML="";
		List<?> data = null;
		paramsSystem apply;
		sendMailAsync xmail;
		tiinova_backend_tools toolsTinnova;

		Map row =null;
		
		apply = new paramsSystem();
		String auxfasesVal = apply.getParamValue(11, Session.SerialKeyForIdProcess, this.getClass().getSimpleName()).trim(); //el proceso siempre el nombre de la clase
		String auxIdResponsable = apply.getParamValue(10, Session.SerialKeyForIdProcess, this.getClass().getSimpleName()).trim();
		

		try{
			
			String idEmpleadoReal = backendToolsTiinova.getIdEmployeeRealOfIdEmployeeComp(IdHR);
			String idSociedadReal = backendToolsTiinova.getSociedadRealOfIdEmployeeComp(IdHR);
			int dev = 0;
			if (motivo == null) {
				motivo = "";
			}
			
			
			
			if(auxfasesVal.equals("1")) {
                
				//update the status to 2 //Approve
				String SqlUpdate = "UPDATE EQ_SOLIC_ABSEN SET ESTADO = 2 , COMMENT_MANAGER = :motivo WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEDO = :empleado AND ORDINAL = :ordinal";
					
				SQLQuery query  = this.getSqlQuery(SqlUpdate);
				query.setParameter("sociedad", idSociedadReal);
				query.setParameter("empleado", idEmpleadoReal);
				query.setParameter("ordinal", ordinal);
				query.setParameter("motivo", motivo);

				dev = executeSqlAdvance(query); //execute the Update
				
				// Insert absent in Tinnova Table. The data is possible exist, we have to update.
				String FecAltaEmpleado = backendToolsTiinova.getDBValueSql("SELECT FEC_ALTA_EMPLEADO FROM MBL_EMPLEADOS_LISTA WHERE ID_SOCIEDAD = '"+idSociedadReal+"' AND ID_EMPLEADO = '"+idEmpleadoReal+"'","FEC_ALTA_EMPLEADO");
				String SqlDataRequest = "SELECT * FROM EQ_SOLIC_ABSEN WHERE ID_SOCIEDAD = '"+idSociedadReal+"' AND ID_EMPLEDO = '"+idEmpleadoReal+"' AND ORDINAL = " + ordinal;
				data  = this.getDataSQLNativo(SqlDataRequest);
				String dtStart = "";
				String dtEnd = "";
				String idAbsence = "";
				
				if (data != null) {
					row = (Map)data.get(0);
					if (row != null) {
						dtStart = row.get("FECHA_INICIO").toString();
						idAbsence = row.get("ID_INCIDENCE").toString();
						dtEnd = row.get("FECHA_FIN").toString();
					}
				}
				
				int numDataInTiinova = 0;
				String num = backendToolsTiinova.getDBValueSql("SELECT COUNT(*) AS NUM FROM M4T_ABSENTISMOS WHERE ID_SOCIEDAD = '"+idSociedadReal+"' AND ID_EMPLEADO = '"+idEmpleadoReal+"' AND FEC_ALTA_EMPLEADO = "+backendToolsTiinova.getFormatDateFilter(FecAltaEmpleado)+" AND FEC_INICIO = "+backendToolsTiinova.getFormatDateFilter(dtStart)+" AND ID_TIPO_ABSENTISMO = '"+idAbsence+"'" ,"NUM");
				if (!num.equals("")) {
					numDataInTiinova = Integer.parseInt(num);
				}
				
                // if exist Update
                if (numDataInTiinova > 0) {
                //    String SqlUpdateM4t = “UPDATE M4T_ABSENTISMOS SET ESTADO = 2 , COMMENT_MANAGER = :motivo WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEDO = :empleado AND ORDINAL = :ordinal”;
    
                }
                else {
                    //Insert
                    String SqlInsertM4t  = "INSERT INTO M4T_ABSENTISMOS (ID_SOCIEDAD, ID_EMPLEADO, FEC_ALTA_EMPLEADO, FEC_INICIO, FEC_FIN, ID_TIPO_ABSENTISMO, COMENT, HOSPITALIZACION, COM_MP_AFI_ST)"; 
                           SqlInsertM4t += "VALUES (:sociedad, :idempleado, :fecalta, :inicio, :fin, :tipoabs, :comment, ‘N’,‘N’)";
                
                   SQLQuery queryInsert  = this.getSqlQuery(SqlInsertM4t);
                
                   //Dates Convert
                    DateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
                    Date inicioD = formatter.parse(dtStart);
                    Date finD    = formatter.parse(dtEnd);
                    Date alta    = formatter.parse(FecAltaEmpleado);
                  
                   queryInsert.setParameter("sociedad", idSociedadReal);
                   queryInsert.setParameter("idempleado", idEmpleadoReal);
                   queryInsert.setParameter("fecalta", alta);
                   queryInsert.setParameter("inicio", inicioD);
                   queryInsert.setParameter("fin", finD);
                   queryInsert.setParameter("tipoabs", idAbsence);
                   queryInsert.setParameter("comment", "Portal Mobile (manager)");
    
                   dev = executeSqlAdvance(queryInsert); //execute the insert
                   
                   if (dev == 0) {
	    				//Send Notification to the Employee
	    				String message = this.clcMensajeEmployeeAceptar(idSociedadReal, idEmpleadoReal, motivo);
	    				String title = "Aprobada solicitud absentismo";
	    				backendToolsTiinova.addNotification(idSociedadReal, idEmpleadoReal, message, title);
   				}
                
                }
            }else {  //Validation level 2
                
            		//Se quita la sociedad del idEmpleado
                String idResponsableAux = backendToolsTiinova.getIdEmployeeRealOfIdEmployeeComp(auxIdResponsable);
                
                String sqlUpdateResponsable = "UPDATE EQ_SOLIC_ABSEN SET ESTADO = 1 , ID_EMPLEADO_RESPONSABLE = :idResponsable , COMMENT_MANAGER = :motivo WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEDO = :empleado AND ORDINAL = :ordinal";
                
                SQLQuery queryResp  = this.getSqlQuery(sqlUpdateResponsable);
                queryResp.setParameter("sociedad", idSociedadReal);
                queryResp.setParameter("empleado", idEmpleadoReal);
                queryResp.setParameter("ordinal", ordinal);
                queryResp.setParameter("idResponsable", idResponsableAux);
                queryResp.setParameter("motivo", motivo);

                dev = executeSqlAdvance(queryResp); //execute the Update
                
                toolsTinnova = new tiinova_backend_tools();
                          
                String nameEmployee = toolsTinnova.getNameOfEmployee(idSociedadReal, idEmpleadoReal) ;
                String nameManager = toolsTinnova.getNameOfEmployee(Session.getData(0).sociedad, Session.getData(0).id_persona);
                
                //envio de mail al responable de rrhh
                	String mailAddress = toolsTinnova.getMailOfEmployee(idSociedadReal, idEmpleadoReal);
                	String Subject = "Tiene un absentismo pendiente de validar";
				String body = "El responsable "+nameManager+", ha aprobado una solicitud de ausencia del empleado "+nameEmployee+". Por favor, revise sus solicitudes pendientes.\n\nPortal Mobile"; 
				
				xmail  = new sendMailAsync();
				xmail.setMailData(mailAddress, Subject, body);
				xmail.start();
                
            }
			
			//Generate the XML Response
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
			
		}
		catch(Exception e)
		{
			XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			addLog("setMssAceptarSolicAbs:" + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
		}
		finally
		{
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
		}
		
		return XML;
	}			
	
	
	private String clcMensajeEmployeeAceptar(String sociedad, String idEmpleado, String motivo) {
		String MsImagenWeb = backendToolsTiinova.getValueParams(sociedad, "URL_LOGO");
		String MsBackGroundColor = backendToolsTiinova.getValueParams(sociedad,"LOGO_HTML_BACKCOLOR");
		String MsBody =   backendToolsTiinova.getValueParams(sociedad,"NOTIF_0001_CONFIRM");
	    String MsFirma =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0002");
	    String MsTitle =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0003_CONFIRM");

	    //Create body
	    String Code = "<table width='100%'><tr  bgcolor='"+MsBackGroundColor+"'><td><img src='";
	    Code= Code + MsImagenWeb + "' width='300'></td></tr></table><h2>";
	    Code= Code + MsTitle + "</h2><h4>";
	    Code= Code + MsBody  + "<br><br><b>Motivo: "+ motivo + "</b>";
	    Code= Code +"</h4> <br><br>" + MsFirma ;
	    
	    return Code;
	    
}
	
	
	// Debug class
	protected void addLog(String info, int logType)
	{
		new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
	}
		
}
