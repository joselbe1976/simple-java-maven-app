/*
 * Equilibrha 2018.  ESS Employee Absences
 * Jose Luis Bustos. 
 */

package com.portalmobile.tinnova;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.globalSystems.paramsSystem;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.pushnotifications.Parse.parseOperations;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.xml.XmlHelper;



public class hb_mobile_functions_tinnova_absences extends hb_main_tinnova  implements iDisposable{

	private tiinova_backend_tools backendToolsTiinova;
	private static String className = "";
	
	// constructor class
	public hb_mobile_functions_tinnova_absences() {
		backendToolsTiinova = new tiinova_backend_tools();
		className = this.getClass().getSimpleName(); //Class name for logs
	}
	public void Dispose() {
		backendToolsTiinova.Dispose();
		backendToolsTiinova = null;
	}
	
	
	
	/*
		In the Apps the absences codes are:
		
		9 = Vacaciones (the same in Poeplenet and Tinnova)
		1 = Enfermedad (IT No Baja) We have To translate Tinnova to code 51
	*/
	
	
	// -------------------------------------------------------------------------------------
	// Get List Ausences of employee
	// -------------------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	public String getEssMisAbsentismos(logonCredencialProcess Session,String IdHR, double year) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		
		String XML="";
		int numRecordsTotal = 0;
		List<?> dataReal = null;
		List<?> data = null;
		Map row =null;
		
		try{
		
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			
			// Get Real Absents of Employee in the Year of parameter
			String SQLReal = "SELECT ID_SOCIEDAD, ID_EMPLEADO,  FEC_INICIO, FEC_FIN, DIAS, ID_TIPO_ABSENTISMO, N_TIPO_ABSENTISMO FROM MBL_ABSENTISMOS_RH WHERE ID_SOCIEDAD = '" + sociedad + "' AND ID_EMPLEADO = '" + idEmpleado + "' AND ( YEAR(FEC_INICIO) = " + year + " OR YEAR(FEC_FIN) = " + year +" ) ";
			dataReal  = this.getDataSQLNativo(SQLReal);
			int numRegMeta4Real = dataReal.size();
			numRecordsTotal += numRegMeta4Real;
			
			// Request Ausences with state waiting (WITH status 0 (filter de View of DataBase)
			String SQLSolci ="SELECT ID_SOCIEDAD, ID_EMPLEDO, ORDINAL, FECHA_INICIO , FECHA_FIN, DIAS , ID_INCIDENCE,  N_TIPO_ABSENTISMO, COMMENT_EMPLOYEE FROM MBL_AUSENCIAS_RH_PENDIENTES WHERE ID_SOCIEDAD = '" + sociedad + "' AND ID_EMPLEDO = '" + idEmpleado + "' AND ( YEAR(FECHA_INICIO) = " + year + " OR YEAR(FECHA_FIN) = " + year +" ) ";
			data  = this.getDataSQLNativo(SQLSolci);
			int numRegMeta4Solic = data.size();
			numRecordsTotal += numRegMeta4Solic;
			
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("Records", String.valueOf(numRecordsTotal), helperXml.XML_NORMAL);
		
			
			
			// Request Ausences with state waiting
			for (int z = 0;z<numRegMeta4Solic;z++)
			{
				row = (Map)data.get(z);
				
				String idEmployee = backendToolsTiinova.getCreateIdEmployeeComp(row.get("ID_EMPLEDO").toString(), row.get("ID_SOCIEDAD").toString());
				
				helperXml.addXmlItem("idempleado" , z,idEmployee, helperXml.XML_NORMAL);
				helperXml.addXmlItem("estado" , z,"1", helperXml.XML_NORMAL);
				helperXml.addXmlItem("nmestado" , z,"Pendiente" , helperXml.XML_NORMAL);
				helperXml.addXmlItem("idabsentismo" , z,row.get("ID_INCIDENCE").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("nmabsentismo" , z,row.get("N_TIPO_ABSENTISMO").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("inicio" , z,row.get("FECHA_INICIO").toString().replace("00:00:00.0","").trim() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("fin" , z,row.get("FECHA_FIN").toString().replace("00:00:00.0","").trim() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("totaldias" , z,row.get("DIAS").toString() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("ordinalsolic" , z,row.get("ORDINAL").toString(), helperXml.XML_NORMAL);
			} 
						
						
			// Real Data Employee
			for (int z = 0;z<numRegMeta4Real;z++)
			{
				row = (Map)dataReal.get(z);
			
				int recordIdNum =  numRegMeta4Solic + z;
				String idEmployee = backendToolsTiinova.getCreateIdEmployeeComp(row.get("ID_EMPLEADO").toString(), row.get("ID_SOCIEDAD").toString());
				
				helperXml.addXmlItem("idempleado" , recordIdNum,idEmployee, helperXml.XML_NORMAL);
				helperXml.addXmlItem("estado" , recordIdNum,"0", helperXml.XML_NORMAL);
				helperXml.addXmlItem("nmestado" , recordIdNum,"REAL" , helperXml.XML_NORMAL);
				helperXml.addXmlItem("idabsentismo" , recordIdNum,row.get("ID_TIPO_ABSENTISMO").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("nmabsentismo" , recordIdNum,row.get("N_TIPO_ABSENTISMO").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("inicio" , recordIdNum,row.get("FEC_INICIO").toString().replace("00:00:00.0","").trim() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("fin" , recordIdNum,row.get("FEC_FIN").toString().replace("00:00:00.0","").trim() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("totaldias" , recordIdNum,row.get("DIAS").toString() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("ordinalsolic" , recordIdNum,"0", helperXml.XML_NORMAL);
			} 
			
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
			
		}
		catch(Exception e)
		{
			XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			addLog("getEssMisAbsentismos  \n"+e.getStackTrace(), ParamsApp.LOG_TYPE_ERROR);
			
		}
		finally
		{
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
			row = null;
			dataReal = null;
			data = null;
		}
		
		return XML;
	}
	
	// -------------------------------------------------------------------------------------
	// Create a Request
	// -------------------------------------------------------------------------------------
	public String addEssNewSolAbsentismo(logonCredencialProcess Session,String IdHR, String idAbsentismo, String inicio, String fin, String comentarios) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		
		if (comentarios == null)
		{
			comentarios = "";
		}
		
		//traslate codes
		if (idAbsentismo.equals("1")) {idAbsentismo = "51";}
		
		String XML="";
		paramsSystem apply;
		
		try{
		
			apply = new paramsSystem();
			String validatorMethodEss = apply.getParamValue(9, Session.SerialKeyForIdProcess, this.getClass().getSimpleName()); 
			
			String idEmpleadoReal = "";
			String idSociedadReal = "";
			
			if (!IdHR.equals("")) {
				idEmpleadoReal = backendToolsTiinova.getIdEmployeeRealOfIdEmployeeComp(IdHR);
				idSociedadReal = backendToolsTiinova.getSociedadRealOfIdEmployeeComp(IdHR);
			}
			else {
				idEmpleadoReal = Session.getData(Session.getPosDefaultSystem()).id_persona;
				idSociedadReal = Session.getData(Session.getPosDefaultSystem()).sociedad;
			}
			
			//Dates
			DateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd");
			Date inicioD = formatter.parse(inicio);
			Date finD    = formatter.parse(fin);
			
			//Calc de Units of days with the start an d date dates
			long diff = finD.getTime() - inicioD.getTime();
			int units = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
			

			
			//add Record to Request Ausence Table (EQ_SOLIC_ABSEN)
			int ordinal =  this.getOrdinalNewRequest(idSociedadReal, idEmpleadoReal);
			
			//create the hibernate command Insert
			String SqlInsert = "INSERT INTO EQ_SOLIC_ABSEN   (ID_SOCIEDAD, ID_EMPLEDO, ORDINAL,FECHA_INICIO, FECHA_FIN, UNITS,ID_INCIDENCE, ESTADO, COMMENT_EMPLOYEE, ID_EMPLEADO_RESPONSABLE ) ";
			SqlInsert += "VALUES (:sociedad, :empleado, :ordinal, :inicio, :fin, :num, :idIncidence, :estado, :comment , :resposable)";
			
			SQLQuery query  = this.getSqlQuery(SqlInsert);
			query.setParameter("sociedad", idSociedadReal);
			query.setParameter("empleado", idEmpleadoReal);
			query.setParameter("ordinal", ordinal);
			query.setParameter("inicio", inicioD);
			query.setParameter("fin", finD);
			query.setParameter("num", units);
			query.setParameter("idIncidence", idAbsentismo);
			query.setParameter("estado", 1); //by default 1 always = pendiente
			query.setParameter("comment", comentarios);
			
			String idSendNotif = "";
			
			// If the validator Method is RRHH Then We put the Parametrer Global of person
			if (validatorMethodEss.equals("MANAGER")) {
				//Calc Manager of Employee
				String idPersonManager = backendToolsTiinova.getManagerOfEmployee(idSociedadReal, idEmpleadoReal);
				query.setParameter("resposable", idPersonManager);		
				idSendNotif = idPersonManager;
			}
			else {
				String validatorRrhhID  = apply.getParamValue(10, Session.SerialKeyForIdProcess, this.getClass().getSimpleName()); 
				query.setParameter("resposable", backendToolsTiinova.getIdEmployeeRealOfIdEmployeeComp(validatorRrhhID));
				idSendNotif = validatorRrhhID;
			}
			
			int dev = executeSqlAdvance(query); //execute the insert
			
			if (dev == 0) {
				//Insert OK. Notifications
				String msgEmployee = this.clcMensajeEmployee(idSociedadReal);
				String msgManager = this.clcMensajeManager(idSociedadReal, idEmpleadoReal);
				
				//Employee
				backendToolsTiinova.addNotification(idSociedadReal, idEmpleadoReal, msgEmployee, "Solicitud Absentismo realizada");
				
				//Manager only (no RRHH)
				if (validatorMethodEss.equals("MANAGER")) {
					backendToolsTiinova.addNotification(idSociedadReal, idSendNotif, msgManager, "Solicitud Absentismo pendiente validar");
				}
				
				//Send Push notification to Device
				parseOperations parse = new parseOperations();
				parse.sendPushNotificationUser("Solicitud de ausencia en proceso", Session.getData(Session.getPosDefaultSystem()).user, "");
		
			}

			
			// Generate the XML to Resonse
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado",String.valueOf(dev) , helperXml.XML_NORMAL);
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
			apply = null;

		
		}
		
		return XML;
	}
	
	//Create notificacion Employee body
	private String clcMensajeEmployee(String sociedad) {
	    		String MsImagenWeb = backendToolsTiinova.getValueParams(sociedad, "URL_LOGO");
	    		String MsBackGroundColor = backendToolsTiinova.getValueParams(sociedad,"LOGO_HTML_BACKCOLOR");
	    		String MsBody =   backendToolsTiinova.getValueParams(sociedad,"NOTIF_0001");
	    	    String MsFirma =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0002");
	    	    String MsTitle =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0003");

	    	    //Create body
	    	    String Code = "<table width='100%'><tr  bgcolor='"+MsBackGroundColor+"'><td><img src='";
	    	    Code= Code + MsImagenWeb + "' width='300'></td></tr></table><h2>";
	    	    Code= Code + MsTitle + "</h2><h4>";
	    	    Code= Code + MsBody ;
	    	    Code= Code +"</h4> <br><br>" + MsFirma ;
	    	    
	    	    return Code;
	    	    
	}
	
	//Create notificacion Employee body
	private String clcMensajeManager(String sociedad, String idHR) {
	    		String MsImagenWeb = backendToolsTiinova.getValueParams(sociedad, "URL_LOGO");
	    		String MsBackGroundColor = backendToolsTiinova.getValueParams(sociedad,"LOGO_HTML_BACKCOLOR");
	    		String MsBody =   backendToolsTiinova.getValueParams(sociedad,"NOTIF_0001_MANAGER");
	    	    String MsFirma =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0002");
	    	    String MsTitle =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0003_MANAGER");

	    	    //Create body
	    	    String Code = "<table width='100%'><tr  bgcolor='"+MsBackGroundColor+"'><td><img src='";
	    	    Code= Code + MsImagenWeb + "' width='300'></td></tr></table><h2>";
	    	    Code= Code + MsTitle + "</h2><h4>";
	    	    Code= Code + MsBody ;
	    	    Code= Code + MsBody + "<b> " + idHR + "</b>.";
	    	    Code= Code +"</h4> <br><br>" + MsFirma ;
	    	    
	    	    return Code;
	    	    
	}
	
		
		
	
	
	
	
	
	/*
	 * Remove a Request
	 */
	public String EssDelSolAbsentismo(logonCredencialProcess Session,String IdHR, double ordinal) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		
		String XML="";
		paramsSystem apply; //aplicaValor
		
		
		try{
			apply = new paramsSystem();
			
			String idEmpleadoReal = backendToolsTiinova.getIdEmployeeRealOfIdEmployeeComp(IdHR);
			String idSociedadReal = backendToolsTiinova.getSociedadRealOfIdEmployeeComp(IdHR);
			int dev = 0;
			
			//update the status to 4
			String SqlUpdate = "UPDATE EQ_SOLIC_ABSEN SET ESTADO = 4 WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEDO = :empleado AND ORDINAL = :ordinal";
				
			SQLQuery query  = this.getSqlQuery(SqlUpdate);
			query.setParameter("sociedad", idSociedadReal);
			query.setParameter("empleado", idEmpleadoReal);
			query.setParameter("ordinal", ordinal);

			dev = executeSqlAdvance(query); //execute the insert
			
			if (dev == 0) {
				String validatorMethodEss = apply.getParamValue(9, Session.SerialKeyForIdProcess, this.getClass().getSimpleName()); 
				
				if (validatorMethodEss.equals("MANAGER")) {
					//Send Notification to the manager
					String message = this.clcMensajeManagerDelete(idSociedadReal, idEmpleadoReal);
					String title = "Eliminación Solicitud ausencia";
					backendToolsTiinova.addNotification(idSociedadReal, idEmpleadoReal, message, title);
				}
			}
			
			
			
			// Generate XML Response
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado",String.valueOf(dev), helperXml.XML_NORMAL);
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
			apply = null;

		
		}
		
		return XML;
	}
	
	//Create notificacion Employee body
	private String clcMensajeManagerDelete(String sociedad, String idHR) {
	    		String MsImagenWeb = backendToolsTiinova.getValueParams(sociedad, "URL_LOGO");
	    		String MsBackGroundColor = backendToolsTiinova.getValueParams(sociedad,"LOGO_HTML_BACKCOLOR");
	    		String MsBody =   backendToolsTiinova.getValueParams(sociedad,"NOTIF_0001_DELETE");
	    	    String MsFirma =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0002");
	    	    String MsTitle =  backendToolsTiinova.getValueParams(sociedad,"NOTIF_0003_DELETE");

	    	    //Create body
	    	    String Code = "<table width='100%'><tr  bgcolor='"+MsBackGroundColor+"'><td><img src='";
	    	    Code= Code + MsImagenWeb + "' width='300'></td></tr></table><h2>";
	    	    Code= Code + MsTitle + "</h2><h4>";
	    	    Code= Code + MsBody ;
	    	    Code= Code + MsBody + "<b> " + idHR + "</b>.";
	    	    Code= Code +"</h4> <br><br>" + MsFirma ;
	    	    
	    	    return Code;
	    	    
	}
		
	
	
	
	// Return Ordinal Notification to add to table
	private int getOrdinalNewRequest(String sociedad, String IdEmpleado){
		String SQL  = "SELECT MAX(ORDINAL) AS NUM FROM EQ_SOLIC_ABSEN WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEDO = '"+IdEmpleado+"'";
		String NumAux = backendToolsTiinova.getDBValueSql(SQL, "NUM");
		
		if (NumAux.equals("")) {
			return 1;
		}
		else {
			return  Integer.parseInt(NumAux) + 1;
		}
	}

	
	// Debug class
	protected void addLog(String info, int logType)
	{
		new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
	}
		
}
