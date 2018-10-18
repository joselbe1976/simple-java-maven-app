/*
 * Equilibrha 2017. Metodos para el telefono de tinnova
 * Jose Luis Bustos. 
 */

package com.portalmobile.tinnova;

import java.util.List;
import java.util.Map;

import javax.activation.DataHandler;
import javax.xml.rpc.Stub;

import org.apache.axis.attachments.ManagedMemoryDataSource;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.tools.cache.documentsCache;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.xml.XmlHelper;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosServiceService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosServiceServiceLocator;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssServiceService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssServiceServiceLocator;
import com.portalmobile.meta4.schemas.types.Ess_Download_ReciboOutput;
import com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput;
import com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_ResultBlock;
import com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_NominaOutput;
import com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock;
import com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultRecord;

public class hb_mobile_functions_tinnova_economic extends hb_main_tinnova  implements iDisposable{
	private ParamsApp IntParams;
	private tiinova_backend_tools backendToolsTiinova;
	
	private static String className = "";
	
	// constructor class
	public hb_mobile_functions_tinnova_economic() {
		IntParams = new ParamsApp();
		backendToolsTiinova = new tiinova_backend_tools();
		className = this.getClass().getSimpleName(); //Class name for logs
	}
	public void Dispose() {
		IntParams = null;
		backendToolsTiinova.Dispose();
		backendToolsTiinova = null;
	}
	
	// -------------------------------------------------------------------------------------
	// Return Account Bank Employe. Current User
	// -------------------------------------------------------------------------------------
	public String getEssDatosBancarios(logonCredencialProcess Session,String IdHR) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		
		String XML="";
		
		try{
			String cuentaBancoIBAN = getEssDatosBancariosInternal(Session, IdHR);
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("cuentaiban",cuentaBancoIBAN, helperXml.XML_NORMAL);
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
			
		}
		catch(Exception e)
		{
			addLog("getEssDatosBancarios : " + e.getMessage() , ParamsApp.LOG_TYPE_ERROR);
			XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
		}
		finally
		{
			if (helperXml != null) {helperXml.Dispose();}
			helperXml = null;
		}
		
		return XML;
	}
	
	// -------------------------------------------------------------------------------------
	// Return payroll receipt of this year for this employee or connected if is null an year
	// -------------------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	public String getEssRecibosNomina(logonCredencialProcess Session,String IdHR, double year)throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
			
		String XML="";
		String cuentaBancaria = "";
		Map row =null;
		
		try{
			
			//The account IBAN
			cuentaBancaria = getEssDatosBancariosInternal(Session,IdHR);
			
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
			
			//the payroll receipt
			String Sql = "SELECT ID_SOCIEDAD, ID_EMPLEADO, CONVERT(VARCHAR,FEC_PAGA,120) AS FEC_PAGA, N_HIST_PAGA AS NOMBRE, DATEPART(MONTH, FEC_PAGA)  AS MONTH, DATEPART(YEAR, FEC_PAGA)  AS YEAR, CONVERT(VARCHAR,FEC_IMPUTACION,120) AS FEC_IMPUTACION, TIPO_RECIBO from MBL_RECIBOS_EMPLEADO where ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEADO = '"+idEmpleado+"'AND DATEPART(YEAR, FEC_PAGA) = "+year+" ORDER BY FEC_PAGA DESC , FEC_IMPUTACION DESC";
			List<?> data  = this.getDataSQLNativo(Sql);
			int numRegMeta4 = data.size();
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("Records", String.valueOf(numRegMeta4), helperXml.XML_NORMAL);
			helperXml.addXmlItem("cuentaBancaria", cuentaBancaria, helperXml.XML_NORMAL);
			
			
			for (int z = 0;z<numRegMeta4;z++)
			{
				row = (Map)data.get(z);
					
				helperXml.addXmlItem("anio" , z,row.get("YEAR").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("mes" , z,row.get("MONTH").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("fpago" , z,row.get("FEC_PAGA").toString().replace(" 00:00:00", "").trim(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("falloc" , z,row.get("FEC_IMPUTACION").toString().replace(" 00:00:00", "").trim(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("nombrepaga" , z,row.get("NOMBRE").toString() , helperXml.XML_NORMAL);
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
		
		}
		
		return XML;
	}
	
	// -------------------------------------------------------------------------------------
	// Devuelve el fichero de la paga indicada y empleado.
	// -------------------------------------------------------------------------------------
	@SuppressWarnings("rawtypes")
	public String essDownloadReciboNomina(logonCredencialProcess Session,String IdHR, String fechaPago, String fechaAlloc) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
			
		String XML="";
		String cuentaBancaria = "";
		Map row =null;
		tiinova_backend_tools tool = null;
		
		try{
			
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
			
			//the payroll receipt
			String Sql = "SELECT ID_SOCIEDAD, ID_EMPLEADO, HTML, PDF, PATH_PDF, CONVERT(VARCHAR,FEC_PAGA,120) AS FEC_PAGA, N_HIST_PAGA AS NOMBRE, DATEPART(MONTH, FEC_PAGA)  AS MONTH, DATEPART(YEAR, FEC_PAGA)  AS YEAR, CONVERT(VARCHAR,FEC_IMPUTACION,120) AS FEC_IMPUTACION, TIPO_RECIBO from MBL_RECIBOS_EMPLEADO where ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEADO = '"+idEmpleado+"' ";
			Sql += "AND  FEC_PAGA = " +  backendToolsTiinova.getFormatDateFilter(fechaPago);
			Sql += "AND  FEC_IMPUTACION = " +  backendToolsTiinova.getFormatDateFilter(fechaAlloc);
			
			List<?> data  = this.getDataSQLNativo(Sql);
			int numRegMeta4 = data.size();
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
			helperXml.addXmlItem("Records", String.valueOf(1), helperXml.XML_NORMAL);
			
			
			for (int z = 0;z<numRegMeta4;z++)
			{
				row = (Map)data.get(z);
					
				helperXml.addXmlItem("anio" , z,row.get("YEAR").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("mes" , z,row.get("MONTH").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("fpago" , z,row.get("FEC_PAGA").toString().replace(" 00:00:00", "").trim(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("falloc" , z,row.get("FEC_IMPUTACION").toString().replace(" 00:00:00", "").trim(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("nombrepaga" , z,row.get("NOMBRE").toString() , helperXml.XML_NORMAL);
			
				//file. In Tinnova we have 3 posibilities: html, pdf (into the table) and pdf in a path
				//we have to determinate with option is in each execution. (each client hace diferents options and the same client
				// have some options in the time (years).
				
				if (row.get("PDF") != null) {
					//PDF file into row
					
					byte [] byteArray = (byte[]) row.get("PDF"); //get the binary ==> byteArray
					String filePDfBase64 = com.Ostermiller.util.Base64.encodeToString(byteArray); //array ==> String base 64
					helperXml.addXmlItem("file" , z,filePDfBase64 , helperXml.XML_NORMAL);
					helperXml.addXmlItem("ext" , z,"PDF" , helperXml.XML_NORMAL);
				}
				else if (row.get("PATH_PDF") != null && row.get("PATH_PDF").toString().trim().length() > 0 && !row.get("PATH_PDF").toString().trim().equals("NULL")) {
					// PDF path to Disk. (note: the fields is some cases have "NULL" as text)
					String PathPDF = row.get("PATH_PDF").toString();
					
					//control of Remote Files of Tinnova
					tool = new tiinova_backend_tools();
					PathPDF = tool.readRemoteFilesToLocal(PathPDF,Session.SerialKeyMainReturnApps, true); //Get Remote File to Local temp File (RECIBOS)
					
					
					//GetBase 64 of File
					String FileBase64 = new ParamsApp().readFileAndConvertBase64String(PathPDF);
					
					helperXml.addXmlItem("file" , z,FileBase64 , helperXml.XML_NORMAL);
					helperXml.addXmlItem("ext" , z,"PDF" , helperXml.XML_NORMAL);
					
					//Delete Temp File Remote
					new ParamsApp().DeleteFich(PathPDF);
					
				}
				else  {
					// HTML.
					helperXml.addXmlItem("file" , z,com.Ostermiller.util.Base64.encode(row.get("HTML").toString()) , helperXml.XML_NORMAL);
					helperXml.addXmlItem("ext" , z,"HTML" , helperXml.XML_NORMAL);
				}
			
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
			if (tool != null) {tool.Dispose();}
			tool = null;
		
		}
		
		return XML;
	}
	
	// return Account IBAN of connected employee
	public String getEssDatosBancariosInternal(logonCredencialProcess Session,String IdHR) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		if (Session==null) {return helperXml.getErrorValues("");}
		
		String Value = "";
		tiinova_backend_tools tools = null;
		
		try{
			tools = new tiinova_backend_tools();
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
			
			String Sql = "select CODIGO_IBAN from MBL_BANK_ACCOUNT_RH_TODAY WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEADO = '"+idEmpleado+"'";
			Value = hideAccountNumber(tools.getDBValueSql(Sql, "CODIGO_IBAN"));
			
			
		}
		catch(Exception e)
		{
			addLog("getEssDatosBancarios : " + e.getMessage() , ParamsApp.LOG_TYPE_ERROR);
			Value = "";
		}
		finally
		{
			if (tools != null) {tools.Dispose();}
			tools = null;
		}
		
		return Value;
	}
			
	
	//Hide the account number (mask)
	private String hideAccountNumber(String account) {
		String hideAccount = account;
		hideAccount = hideAccount.substring(0,4)+'*'+hideAccount.substring(5);
		hideAccount = hideAccount.substring(0,8)+'*'+hideAccount.substring(9);
		hideAccount = hideAccount.substring(0,15)+'*'+hideAccount.substring(16);
		hideAccount = hideAccount.substring(0,17)+'*'+hideAccount.substring(18);
		hideAccount = hideAccount.substring(0,21)+'*'+hideAccount.substring(22);
		return hideAccount;
	}
	
	
	// Debug class
	protected void addLog(String info, int logType)
	{
		new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
	}
		
}
