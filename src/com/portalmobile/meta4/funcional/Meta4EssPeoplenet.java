/*
 * EquilibRHa Mobile 2016.
 * 
 * Generamos una clase para portal del empleado. Aqui todo lo que accede al web service
 * de Peoplenet para producto portal del empleado.
 */

package com.portalmobile.meta4.funcional;

import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.rpc.Stub;

import org.apache.axis.attachments.ManagedMemoryDataSource;

import com.common.config.ParamsApp;
import com.common.globalSystems.paramsSystem;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.pushnotifications.Parse.parseOperations;
import com.common.tools.DatesTools;
import com.common.tools.cache.documentsCache;
import com.common.tools.encript.Base64Tools;
import com.common.tools.xml.XmlHelper;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosServiceService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosServiceServiceLocator;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssServiceService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssServiceServiceLocator;
import com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulRecord;
import com.portalmobile.meta4.schemas.types.Ess_Delete_Abs_SolicOutput;
import com.portalmobile.meta4.schemas.types.Ess_Download_ReciboOutput;
import com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_RhOutput;
import com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_ResultBlock;
import com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_ResultRecord;
import com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput;
import com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_ResultBlock;
import com.portalmobile.meta4.schemas.types.Ess_Get_Mis_EmpleadosOutput;
import com.portalmobile.meta4.schemas.types.Ess_Get_NoticiasOutput;
import com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_ResultBlock;
import com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_ResultRecord;
import com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_NominaOutput;
import com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock;
import com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultRecord;
import com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultBlock;
import com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultRecord;
import com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_SendOutput;
import com.portalmobile.meta4.schemas.types.Ess_Save_New_AbsentismoOutput;
import com.portalmobile.meta4.schemas.types.Ess_Send_FileBlock;
import com.portalmobile.meta4.schemas.types.Ess_Send_FileOutput;
import com.portalmobile.meta4.schemas.types.Ess_Send_FileRecord;
import com.portalmobile.meta4.schemas.types.Ess_Who_Is_WhoOutput;
import com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultBlock;
import com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultRecord;
import com.portalmobile.meta4.schemas.types.Mss_Cancel_AbsentismoOutput;
import com.portalmobile.meta4.schemas.types.Mss_Confirm_AbsentismoOutput;
import com.portalmobile.meta4.schemas.types.Mss_Exec_QueryOutput;
import com.portalmobile.meta4.schemas.types.Mss_Get_AbsentismosOutput;
import com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultBlock;
import com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultRecord;
import com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasOutput;
import com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_MetadataOutput;
import com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultBlock;
import com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultRecord;
import com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput;
import com.portalmobile.meta4.schemas.types.Seg_Forget_Password_UserOutput;


public class Meta4EssPeoplenet {
	
	ParamsApp IntParams = new ParamsApp(); //Clase de parametros y funciones especiales
	Base64Tools Base64 = new Base64Tools();
	
	private boolean SYSTEM_CACHE_FOTOS =true; //cacheo de fotos siempre 

	
	// -------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------
	//  Constructopres e incializadores de conveniencia
	// -------------------------------------------------------------------------------------
	// -------------------------------------------------------------------------------------
		public Meta4EssPeoplenet()
		{
			SYSTEM_CACHE_FOTOS =true;
			
		}
		
		public Meta4EssPeoplenet(boolean cacheFotos)
		{
			SYSTEM_CACHE_FOTOS =cacheFotos;
		}
		
		public void setCacheFotos(boolean value)
		{
			SYSTEM_CACHE_FOTOS = value;
		}
		
		// -------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------
		//metodos de la aplicacion.
		// -------------------------------------------------------------------------------------
		// -------------------------------------------------------------------------------------
		
		// -------------------------------------------------------------------------------------
		// Devuelve la cuenta bancaria del empleado. Sino se pasa empleado (vacio) el del 
		// Usuario conectado a Meta4
		// -------------------------------------------------------------------------------------
		public String getEssDatosBancarios(logonCredencialProcess Session,String IdHR) throws Exception
		{

			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			IntParams.debugInfo("Metodo: getEssDatosBancarios");
			IntParams.debugInfo(" .IdHR: " + IdHR);
	
			

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			
			javax.xml.rpc.Stub oStub = null;	
			
			try{
				
				//definimos el meta4 object y metodo 
				Csp_Mbl_Soap_EmpleadosServiceService  Sfactory = new Csp_Mbl_Soap_EmpleadosServiceServiceLocator();
				Csp_Mbl_Soap_EmpleadosService Meta4Object = Sfactory.getCSP_MBL_SOAP_EMPLEADOS();
				Ess_Get_Bank_AcccountOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				
				//ejecutamos el metodo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_GET_BANK_ACCCOUNT(IdHR); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Ess_Get_Bank_Acccount_ResultBlock Bloque = SalidaExec.getEss_Get_Bank_Acccount_Result();
				
				//Accedemos propiedad ambito Nodo
				String cuentaIBAN = Bloque.getSse_Cuenta_Bancaria_Iban(); 
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
				helperXml.addXmlItem("cuentaiban",cuentaIBAN, helperXml.XML_NORMAL);
				
				
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
		
		//devuelve los datos bancarios internos
		public String getEssDatosBancariosInternal(logonCredencialProcess Session,String IdHR) throws Exception
		{

			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
		
			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			
			javax.xml.rpc.Stub oStub = null;	
			
			try{
				
				//definimos el meta4 object y metodo 
				Csp_Mbl_Soap_EmpleadosServiceService  Sfactory = new Csp_Mbl_Soap_EmpleadosServiceServiceLocator();
				Csp_Mbl_Soap_EmpleadosService Meta4Object = Sfactory.getCSP_MBL_SOAP_EMPLEADOS();
				Ess_Get_Bank_AcccountOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				
				//ejecutamos el metodo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_GET_BANK_ACCCOUNT(IdHR); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Ess_Get_Bank_Acccount_ResultBlock Bloque = SalidaExec.getEss_Get_Bank_Acccount_Result();
				
				//Accedemos propiedad ambito Nodo
				String cuentaIBAN = Bloque.getSse_Cuenta_Bancaria_Iban(); 
			
				return cuentaIBAN;
			}
			catch(Exception e)
			{
				e.printStackTrace();
				return "";
				
				
			}
			finally
			{
				
			}
			
		
		}
		
		//envio de un archivo a Meta4 Poeplenet desde el dispositivo
		public int sendFileRh(logonCredencialProcess Session, String fileBase64, String extension, String IdHr, String tpFile, String commentsEmployee) throws Exception
		{
			javax.xml.rpc.Stub oStub = null;
			String fichero="";
			try{
				
				System.out.println("\n --- Envio Archivo  Inicio ---");
				
				//Creamos ruta fichero temporal
				 fichero = new ParamsApp().GetFichTemporalExtension(Session.SerialKeyForIdProcess,extension); //me crea el nombre de un fichero y ruta temporal de ese tipo
				 System.out.println("\n   Ruta temporal fichero aux: "+fichero);
				 
				 
				///Creamos el fichero volcando el base64 en un fichero temporal
				IntParams.createFilefromBase64String(fileBase64, fichero);
			
				//generamos un Datahandler que es como hay que enviarlo a Meta4
				FileDataSource fds = new FileDataSource(fichero);
				DataHandler attachment = new DataHandler(fds);
				
				//instanciamos el Meta4Object y la sesion en el app server de meta4
				
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Ess_Send_FileOutput  SalidaExec = new Ess_Send_FileOutput();
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//cargamos el Bloque y asignamos Fichero
				Ess_Send_FileBlock Bloque = new Ess_Send_FileBlock();
				//Bloque.setNode_File(attachment);
				Ess_Send_FileRecord record = new Ess_Send_FileRecord();
				
		
				record.setEss_Extension(extension); //pasamos extension
				record.setEss_File(attachment); //Fichero asignado
				
				Ess_Send_FileRecord[] recordSet = {record}; //asigno registro al recordser
				Bloque.setEss_Send_FileRecordSet(recordSet); //asigno recordset al nodo
				
				
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
		
				System.out.println("\n     - Antes metodo Meta4: ");
				
				//LLamada al metodo de Peoplenet
				Meta4Object.ESS_SEND_FILE(IdHr, tpFile, extension, commentsEmployee, Bloque) ;//ejecutamos metodo encviando Nodo con el Archivo

				
				System.out.println("\n     - Despues metodo OK. Devuelve 0");
				return 0;
				
			}
			catch(Exception e){
				System.out.print("\n\n"+e.getMessage());
				System.out.println("\n     - Despues metodo ERROR. Devuelve -1");
				return -1;
			}
			finally{
				
				//eliminamos fichero una vez finalizado el envio a Meta4
				if (!fichero.trim().equals("")){
					try{
						IntParams.DeleteFich(fichero); //eliminacion
					}
					catch(Exception e){}
				}
				
				
				System.out.println("\n --- Envio Archivo  Fin  ---");
			}
		}
		
		
		
		// -------------------------------------------------------------------------------------
		// Devuelve los recibos del año y empleado. Ojo SIN Archivo
		// -------------------------------------------------------------------------------------
		public String getEssRecibosNomina(logonCredencialProcess Session,String IdHR, double year)throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			
			IntParams.debugInfo("Metodo: getEssRecibosNomina");
			IntParams.debugInfo(" .IdHR: " + IdHR);
			IntParams.debugInfo(" .Year  : " + year);
			

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			String result="";
			String fichero="";
			String cuentaBancaria = "";
			
			javax.xml.rpc.Stub oStub = null;	
			
			
			try{
				
				//la cuenta bancaria del empleado
				cuentaBancaria = getEssDatosBancariosInternal(Session,IdHR);
				
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Ess_Get_Recibos_NominaOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_GET_RECIBOS_NOMINA(IdHR, year, ""); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Ess_Get_Recibos_Nomina_ResultBlock Bloque = SalidaExec.getEss_Get_Recibos_Nomina_Result();
				//Montamos el recordset
				Ess_Get_Recibos_Nomina_ResultRecord Rec[] =  Bloque.getEss_Get_Recibos_Nomina_ResultRecordSet();
				
				
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//cuenta bancaria
				helperXml.addXmlItem("cuentaBancaria", cuentaBancaria, helperXml.XML_NORMAL);
				
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
			
				
				for (int z = 0;z<Rec.length;z++)
				{
	
						
					helperXml.addXmlItem("anio" , z,Rec[z].getAnio().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("mes" , z,Rec[z].getMes().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("fpago" , z,Rec[z].getFecha_Pago().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("falloc" , z,Rec[z].getFecha_Imputacion().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nombrepaga" , z,Rec[z].getNombre_Paga().toString() , helperXml.XML_NORMAL);
					} //del for

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
		
		// -------------------------------------------------------------------------------------
		// Devuelve el fichero de la paga indicada y empleado.
		// -------------------------------------------------------------------------------------
		public String essDownloadReciboNomina(logonCredencialProcess Session,String IdHR, String fechaPago, String fechaAlloc) throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			
			IntParams.debugInfo("Metodo: essDownloadReciboNomina");
			IntParams.debugInfo(" .IdHR: " + IdHR);
			IntParams.debugInfo(" .fechaPago  : " + fechaPago);
			IntParams.debugInfo(" .fechaAlloc  : " + fechaAlloc);


			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			String result="";
			String fichero="";
			DataHandler attachmentEcho;

			
			javax.xml.rpc.Stub oStub = null;	
			
			
			try{
			
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Ess_Download_ReciboOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_DOWNLOAD_RECIBO(IdHR, fechaPago, fechaAlloc); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Ess_Get_Recibos_Nomina_ResultBlock Bloque = SalidaExec.getEss_Get_Recibos_Nomina_Result();
				//Montamos el recordset
				Ess_Get_Recibos_Nomina_ResultRecord Rec[] =  Bloque.getEss_Get_Recibos_Nomina_ResultRecordSet();
				
				
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
				
				String fileCache="";
				
				for (int z = 0;z<Rec.length;z++)
				{
	
					helperXml.addXmlItem("anio" , z,Rec[z].getAnio().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("mes" , z,Rec[z].getMes().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("fpago" , z,Rec[z].getFecha_Pago().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("falloc" , z,Rec[z].getFecha_Imputacion().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nombrepaga" , z,Rec[z].getNombre_Paga().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("ext" , z,"PDF" , helperXml.XML_NORMAL);
				
					//tratamos el Fichero PDF
					//el propio archivo
					
					
					try{
					
						//Creamos ruta fichero temporal
						fichero = new ParamsApp().GetFichTemporalExtension(Session.SerialKeyForIdProcess,"PDF"); //me crea el nombre de un fichero y ruta temporal de ese tipo
						 
						//fichero adjunto
						attachmentEcho = Rec[z].getRecibo();
						
						
						ManagedMemoryDataSource mmds = (ManagedMemoryDataSource)attachmentEcho.getDataSource(); 
						result="";
						
						if (mmds != null)
						{
							//creamos el fichero en Local para despues leerlo.
							IntParams.CrearImagenMeta4enLocal(mmds, fichero);
							
							//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
							//CUIDADO al leer PDF hay que pasarlo a base64 siempre en array nunca en String. 
							result = IntParams.readFileAndConvertBase64String(fichero);
							helperXml.addXmlItem("file",z, result, helperXml.XML_NORMAL);
										
							mmds.delete();
						}
						else  //no se puede abrir.
						{
							helperXml.addXmlItem("file",z,"", helperXml.XML_NORMAL);
						}
					}
					catch(Exception ee)  //lectura de la imagen
					{
						helperXml.addXmlItem("file",z, "", helperXml.XML_NORMAL);
					}
					finally
					{
						//elimino el fichero generado
						IntParams.DeleteFich(fichero);
					}
				} //del for

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
		
		// -------------------------------------------------------------------------------------
		// Devuelve lista de mis empleados (SIN fotos, siempre se cachea) Se debe usar metodo
		// aparte para descargar de la cache del servidor web. Usar clase cache propia
		// Solo si el empleado es MAnager lo podra ejecutar y filtrado por sus Work Units 
		//-------------------------------------------------------------------------------------
		public String getMssMisEmpleados(logonCredencialProcess Session,String IdHR, String filters, double PaginaDatos) throws Exception
		{

			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			IntParams.debugInfo("Metodo: getEssMisEmpleados");
			IntParams.debugInfo(" .Filtro: " + filters);
			IntParams.debugInfo(" .Pagina de datos  : " + PaginaDatos);
			

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			String result="";
			String fichero="";
			DataHandler attachmentEcho;
			
			javax.xml.rpc.Stub oStub = null;	
			paramsSystem apply; //aplicaValor
			
			
			try{
				
				//numero registros por solicitud
				apply = new paramsSystem();
				double numRegGetMeta4 = Double.parseDouble(apply.getParamValue(4, Session.SerialKeyForIdProcess, this.getClass().getSimpleName())); //el proceso siempre el nombre de la clase 
				
				
				//definimos el meta4 object y metodo 
				Csp_Mbl_Soap_EmpleadosServiceService  Sfactory = new Csp_Mbl_Soap_EmpleadosServiceServiceLocator();
				Csp_Mbl_Soap_EmpleadosService Meta4Object = Sfactory.getCSP_MBL_SOAP_EMPLEADOS();
				Ess_Get_Mis_EmpleadosOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_GET_MIS_EMPLEADOS(PaginaDatos, filters,numRegGetMeta4); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Csp_Get_Lista_Emple_ResulBlock Bloque = SalidaExec.getCsp_Get_Lista_Emple_Resul();
				//Montamos el recordset
				Csp_Get_Lista_Emple_ResulRecord Rec[] =  Bloque.getCsp_Get_Lista_Emple_ResulRecordSet();
				
				
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
			
				//Total registros del filtro aplicado. Necesario para scrolls de tablas en IOS7
				helperXml.addXmlItem("TotalRecords", Bloque.getTotal_Registros().toString(), helperXml.XML_NORMAL);
				

				String fileCache="";
				String sociedad = "";
			
				//Recorrmeos los registros
				@SuppressWarnings("unused") String ExtensionFile = "";
				
				for (int z = 0;z<Rec.length;z++)
				{
					ExtensionFile="";
					
					//sociedad del empleado
					sociedad  = Rec[z].getCsp_Global_Data_20().toString();
					
					//Foto Cache
					fileCache =     sociedad + "_" + Rec[z].getNif().toString();
						
					helperXml.addXmlItem("idempleado" , z,Rec[z].getCsp_Id_Empleado().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("ordinal" , z,Rec[z].getCsp_Global_Data_10().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nombre" , z,Rec[z].getCsp_Nombre().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nif" , z,Rec[z].getNif().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("sociedad" , z,sociedad, helperXml.XML_NORMAL);
					helperXml.addXmlItem("fotoid" , z,fileCache, helperXml.XML_NORMAL);
					helperXml.addXmlItem("falta" , z,Rec[z].getFecha_Alta().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("fbaja" , z, Rec[z].getFecha_Baja().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("fnac" , z,Rec[z].getFecha_Nacimiento().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("fantiguedad" , z,Rec[z].getFecha_Antiguedad().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("mail" , z,Rec[z].getCsp_Global_Data_4().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("telefono",z, Rec[z].getCsp_Global_Data_3().toString(), helperXml.XML_NORMAL);
					//Estado es si esta activo, enfermedad, IT etc.
					helperXml.addXmlItem("estadoempleado",z,Rec[z].getCsp_Global_Data_1().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("idestadoempleado",z,Rec[z].getCsp_Global_Data_2().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("base64nmcentrocoste",z,Rec[z].getNm_Centro_Coste().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("base64nmempresa",z,Rec[z].getNm_Empresa().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("base64nmlugartrabajar",z,Rec[z].getNm_Lugar_Trabajo().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("base64nmpuesto",z,Rec[z].getCsp_Global_Data_5().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("favorito",z,Rec[z].getCsp_Favorito().toString(), helperXml.XML_NORMAL);

					helperXml.addXmlItem("idworklocation",z,Rec[z].getId_Work_Unit(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nmworklocation",z,Rec[z].getNm_Work_Unit().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("esmanager",z,Rec[z].getEs_Manager().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nmresponworkunit",z,Rec[z].getEss_Nm_Resp_Wunit().toString(), helperXml.XML_NORMAL);

					
					//Campos con Imagen -------------------------------------------------------------
					
					String FileCacheImagen = new documentsCache().getCacheFileListImage(fileCache);

					if (new ParamsApp().SYSTEM_CACHE_LEVEL == 2){
						FileCacheImagen = ""; //Siempre se fuerza a cachear, por lo menos verificar
					}
					
					//no cacheada	
					if (FileCacheImagen.equals(""))
					{
						
						
						try{
						
							 //vemos el tipo de archivo que viene
							String MimeType = Rec[z].getFoto_Empleado().getContentType().toString();
							fichero = new ParamsApp().GetFichTemporal(Session.SerialKeyForIdProcess,MimeType); //me crea el nombre de un fichero y ruta temporal de ese tipo
							 
							//fichero adjunto
							attachmentEcho = Rec[z].getFoto_Empleado();
							
							
							ManagedMemoryDataSource mmds = (ManagedMemoryDataSource)attachmentEcho.getDataSource(); 
							result="";
							if (mmds != null)
							{
								//creamos el fichero en Local para despues leerlo.
								IntParams.CrearImagenMeta4enLocal(mmds, fichero);
								
								//cacheamos la imagen
								if (SYSTEM_CACHE_FOTOS)
								{
									new documentsCache().cacheFile(fichero, fileCache, documentsCache.CACHE_GROUP_IMAGE);
								}
								
								
								//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
								//result = IntParams.getValueFileBase64Encode(fichero, MimeType);
									
								helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);			
								mmds.delete();
								IntParams.DeleteFich(fichero);
							}
							else  //no se puede abrir.
							{
								helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
								
							}
						}
						catch(Exception ee)  //lectura de la imagen
						{
							helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
							
						}
						finally
						{
							//elimino el fichero generado
							IntParams.DeleteFich(fichero);

						}
						
					}
					else
					{
						//si cacheada, la cogemos directamete
						helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
					}
					
				} //del for

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
				attachmentEcho=null;
				helperXml = null;
				apply=null;
			
			}
			
			return XML;
		}
		
		// -------------------------------------------------------------------------------------
		// Devuelve las noticias OJO con el archivo (foto) si tiene
		// -------------------------------------------------------------------------------------
		public String getEssMisNoticias(logonCredencialProcess Session)  throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			IntParams.debugInfo("Metodo: getEssMisNoticias");

			

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			String result="";
			String fichero="";
			String ficheroDoc="";
			DataHandler attachmentEcho;
			DataHandler attachmentEchoDoc;
			
			javax.xml.rpc.Stub oStub = null;	
			paramsSystem apply; //aplicaValor
			
			try{
				
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Ess_Get_NoticiasOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el método
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_GET_NOTICIAS(); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				
				//cargamos el Bloque de registros
				Ess_Get_Noticias_ResultBlock Bloque = SalidaExec.getEss_Get_Noticias_Result();
				//Montamos el recordset
				Ess_Get_Noticias_ResultRecord[] Rec =  Bloque.getEss_Get_Noticias_ResultRecordSet();
				
				
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
			
			
				String fileCache="";
				
			
				//Recorrmeos los registros
				@SuppressWarnings("unused") String ExtensionFile = "";
				
				for (int z = 0;z<Rec.length;z++)
				{
					ExtensionFile="";
						
					helperXml.addXmlItem("titulo" , z,Rec[z].getTitulo().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("descripcion" , z,Rec[z].getDescripcion(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("ordinal" , z,Rec[z].getOrdinal().toString(), helperXml.XML_NORMAL);
					
					// ---- IMAGEN NOTICIA  (multisociedad)
					//Nombre cache imagen. SIempre el Sociedad + news_+ ordinal de la noticia
					fileCache =  Rec[z].getSociedad() + "_news_"+Rec[z].getOrdinal().toString();
					helperXml.addXmlItem("fileId",z,fileCache, helperXml.XML_NORMAL);
					
					
					//extension
					String mimeAux = Rec[z].getImagen().getContentType().toString();
					String extFinal =  new ParamsApp().GetExtensionOfMimeType(mimeAux);
					helperXml.addXmlItem("extension" , z,extFinal, helperXml.XML_NORMAL);
					
					
					//------DOCUMENTO ADJUNTO
					String fileCacheDoc =  Rec[z].getSociedad() + "_news_doc_"+Rec[z].getOrdinal().toString();
					helperXml.addXmlItem("fileIdDoc",z,fileCacheDoc, helperXml.XML_NORMAL);
					
					//extension Doc
					String extFinalDoc =   Rec[z].getExt_Doc();
					helperXml.addXmlItem("extensionDoc" , z,extFinalDoc, helperXml.XML_NORMAL);
					
					
					
					//Campos con Imagen -------------------------------------------------------------
					
					String FileCacheImagen = new documentsCache().getCacheFileListImage(fileCacheDoc);
					
					if (ParamsApp.SYSTEM_CACHE_LEVEL == 2){
						FileCacheImagen = ""; //Siempre se fuerza a cachear, por lo menos verificar
					}
					
					//no cacheada	
					if (FileCacheImagen.equals(""))
					{
					
						try{
						
							 //vemos el tipo de archivo que viene
							String MimeType = Rec[z].getImagen().getContentType().toString();
							fichero = new ParamsApp().GetFichTemporal(Session.SerialKeyForIdProcess,MimeType); //me crea el nombre de un fichero y ruta temporal de ese tipo
							
							String MimeTypeDoc = extFinalDoc;
							ficheroDoc = new ParamsApp().GetFichTemporal(Session.SerialKeyForIdProcess,MimeTypeDoc);
							
							
							//ficheros adjunto
							attachmentEcho = Rec[z].getImagen();
							attachmentEchoDoc = Rec[z].getDocumento();
							
							
							// ---> Tratamos la Imagen
							
							ManagedMemoryDataSource mmds = (ManagedMemoryDataSource)attachmentEcho.getDataSource(); 
							
							
							result="";
							if (mmds != null)
							{
								//creamos el fichero en Local para despues leerlo.
								IntParams.CrearImagenMeta4enLocal(mmds, fichero);
								
								//cacheamos la imagen
								if (SYSTEM_CACHE_FOTOS)
								{
									new documentsCache().cacheFile(fichero, fileCache, documentsCache.CACHE_GROUP_IMAGE);
								}
								
								
								//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
								//result = IntParams.getValueFileBase64Encode(fichero, MimeType);
									
								helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);			
								mmds.delete();
								IntParams.DeleteFich(fichero);
							}
							else  //no se puede abrir.
							{
								helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
								
							}
							
							
							// ---> Tratamos el documento
							
							ManagedMemoryDataSource mmdsDoc = (ManagedMemoryDataSource)attachmentEchoDoc.getDataSource(); 
							
							
							result="";
							if (mmdsDoc != null)
							{
								//creamos el fichero en Local para despues leerlo.
								IntParams.CrearImagenMeta4enLocal(mmdsDoc, ficheroDoc);
								
								//cacheamos la imagen
								if (SYSTEM_CACHE_FOTOS)
								{
									new documentsCache().cacheFile(ficheroDoc, fileCacheDoc, documentsCache.CACHE_GROUP_IMAGE);
								}
								
									
								helperXml.addXmlItem("doc",z,"", helperXml.XML_NORMAL);	//documento no se envia		
								mmds.delete();
								IntParams.DeleteFich(fichero);
							}
							else  //no se puede abrir.
							{
								helperXml.addXmlItem("doc",z,"", helperXml.XML_NORMAL);
								
							}
							
						}
						catch(Exception ee)  //lectura de la imagen
						{
							helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
							helperXml.addXmlItem("doc",z,"", helperXml.XML_NORMAL);
							
						}
						finally
						{
							//elimino el ficheros generados
							IntParams.DeleteFich(fichero);
							IntParams.DeleteFich(ficheroDoc);

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
				e.printStackTrace();
				
			}
			finally
			{
				attachmentEcho=null;
				helperXml = null;
				apply=null;
			
			}
			
			return XML;
		}
		
		// -------------------------------------------------------------------------------------
		// Devuelve la lista de empleados del Quien es quien: Filter para filtros desde el app
		// por nombre y apellidos. (SCO_GB_NAME).OJO SIN FOTO. Foto cacheada
		// -------------------------------------------------------------------------------------
		public String getEssWhoIsWho(logonCredencialProcess Session,String filters, double PaginaDatos) throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			IntParams.debugInfo("Metodo: getEssWhoIsWho");
			IntParams.debugInfo(" .Filtro: " + filters);
			IntParams.debugInfo(" .Pagina de datos  : " + PaginaDatos);
			

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			String result="";
			String fichero="";
			DataHandler attachmentEcho;
			
			javax.xml.rpc.Stub oStub = null;	
			paramsSystem apply; //aplicaValor
			
			
			try{
				
				//numero registros por solicitud
				apply = new paramsSystem();
				double numRegGetMeta4 = Double.parseDouble(apply.getParamValue(4, Session.SerialKeyForIdProcess, this.getClass().getSimpleName())); //el proceso siempre el nombre de la clase 
				
				IntParams.debugInfo(" .Registros traer  : " + numRegGetMeta4);
				
				//definimos el meta4 object y metodo 
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Ess_Who_Is_WhoOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_WHO_IS_WHO(PaginaDatos, filters,numRegGetMeta4); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Ess_Who_Is_Who_ResultBlock Bloque = SalidaExec.getEss_Who_Is_Who_Result();
				//Montamos el recordset
				Ess_Who_Is_Who_ResultRecord[] Rec =  Bloque.getEss_Who_Is_Who_ResultRecordSet();
				
				
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
			
				//Total registros del filtro aplicado. Necesario para scrolls de tablas en IOS7
				helperXml.addXmlItem("TotalRecords", Bloque.getTotal_Reg().toString(), helperXml.XML_NORMAL);
				

				String fileCache="";
				
			
				//Recorrmeos los registros
				@SuppressWarnings("unused") String ExtensionFile = "";
				
				for (int z = 0;z<Rec.length;z++)
				{
					ExtensionFile="";
					
					String sociedad = Rec[z].getId_Organization();
					String nif = Rec[z].getNif();
					
					//Nombre cache imagen. Sociedad_NIF
					fileCache =  sociedad + "_" + nif;
					
					helperXml.addXmlItem("idempleado" , z,Rec[z].getId_Empleado().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nombre" , z,Rec[z].getNombre().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("telefono" , z,Rec[z].getTelefono().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("mail" , z,Rec[z].getEmail().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nif" , z,nif, helperXml.XML_NORMAL);
					helperXml.addXmlItem("idfile" , z,fileCache, helperXml.XML_NORMAL);
					helperXml.addXmlItem("sociedad" , z,sociedad, helperXml.XML_NORMAL);
					
					
					
					
					//Campos con Imagen -------------------------------------------------------------
					
					String FileCacheImagen = new documentsCache().getCacheFileListImage(fileCache);

					if (new ParamsApp().SYSTEM_CACHE_LEVEL == 2){
						FileCacheImagen = ""; //Siempre se fuerza a cachear, por lo menos verificar
					}
					
					//no cacheada	
					if (FileCacheImagen.equals(""))
					{
						
						
						try{
						
							 //vemos el tipo de archivo que viene
							String MimeType = Rec[z].getFoto().getContentType().toString();
							fichero = new ParamsApp().GetFichTemporal(Session.SerialKeyForIdProcess,MimeType); //me crea el nombre de un fichero y ruta temporal de ese tipo
							 
							//fichero adjunto
							attachmentEcho = Rec[z].getFoto();
							
							
							ManagedMemoryDataSource mmds = (ManagedMemoryDataSource)attachmentEcho.getDataSource(); 
							result="";
							if (mmds != null)
							{
								//creamos el fichero en Local para despues leerlo.
								IntParams.CrearImagenMeta4enLocal(mmds, fichero);
								
								//cacheamos la imagen
								if (SYSTEM_CACHE_FOTOS)
								{
									new documentsCache().cacheFile(fichero, fileCache, documentsCache.CACHE_GROUP_IMAGE);
								}
								
								
								//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
								//result = IntParams.getValueFileBase64Encode(fichero, MimeType);
									
								helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);			
								mmds.delete();
								IntParams.DeleteFich(fichero);
							}
							else  //no se puede abrir.
							{
								helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
								
							}
						}
						catch(Exception ee)  //lectura de la imagen
						{
							helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
							
						}
						finally
						{
							//elimino el fichero generado
							IntParams.DeleteFich(fichero);

						}
						
					}
					else
					{
						//si cacheada, la cogemos directamete
						helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
					}
					
				} //del for

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
				attachmentEcho=null;
				helperXml = null;
				apply=null;
			
			}
			
			return XML;
		}
				
		// -------------------------------------------------------------------------------------
		// Devuelve la lista de absentismos del empleado ESS. <vienen solicitudes pendientes
		// y absentismos reales en el a�o indicado
		// -------------------------------------------------------------------------------------
		public String getEssMisAbsentismos(logonCredencialProcess Session,String IdHR, double year) throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			
			IntParams.debugInfo("Metodo: getEssRecibosNomina");
			IntParams.debugInfo(" .IdHR: " + IdHR);
			IntParams.debugInfo(" .Year  : " + year);
			

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			String result="";
			String fichero="";

			
			javax.xml.rpc.Stub oStub = null;	
			
			
			try{
			
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Ess_Get_Absentismos_RhOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_GET_ABSENTISMOS_RH(IdHR, year); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Ess_Get_Absentismos_Rh_ResultBlock Bloque = SalidaExec.getEss_Get_Absentismos_Rh_Result();
				//Montamos el recordset
				Ess_Get_Absentismos_Rh_ResultRecord[] Rec =  Bloque.getEss_Get_Absentismos_Rh_ResultRecordSet();
				
				
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
			
				
				for (int z = 0;z<Rec.length;z++)
				{
	
						
					helperXml.addXmlItem("idempleado" , z,Rec[z].getId_Empleado().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("estado" , z,Rec[z].getEstado().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("idabsentismo" , z,Rec[z].getId_Absentismo().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nmabsentismo" , z,Rec[z].getNm_Absentismo().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nmestado" , z,Rec[z].getNm_Estado().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("inicio" , z,Rec[z].getFecha_Inicio().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("fin" , z,Rec[z].getFecha_Fin().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("totaldias" , z,Rec[z].getTotal_Dias().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("ordinalsolic" , z,Rec[z].getOrdinal_Solic().toString() , helperXml.XML_NORMAL);
					
				
				} //del for

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
		
		// -------------------------------------------------------------------------------------
		// Grabacion en Peoplenet de una solicitud de Absentismo. Work flow de notificaciones
		// dentro de Meta4 peoplenet en el meta4oebject
		// -------------------------------------------------------------------------------------
		public String addEssNewSolAbsentismo(logonCredencialProcess Session,String IdHR, String idAbsentismo, String inicio, String fin, String comentarios) throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			
			IntParams.debugInfo("Metodo: addEssNewSolAbsentismo");
			IntParams.debugInfo(" .IdHR: " + IdHR);
			IntParams.debugInfo(" .idAbsentismo  : " + idAbsentismo);
			IntParams.debugInfo(" .inicio  : " + inicio);
			IntParams.debugInfo(" .fin	  : " + fin);
			IntParams.debugInfo(" .comentarios  : " + comentarios);

			
			if (comentarios == null)
			{
				comentarios = "Viene vacio";
				
			}
			

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";

			
			javax.xml.rpc.Stub oStub = null;	
			
			
			paramsSystem apply; //aplicaValor
			
			try{
			
				apply = new paramsSystem();
				String validatorMethodEss = apply.getParamValue(9, Session.SerialKeyForIdProcess, this.getClass().getSimpleName()); 
				
				
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Ess_Save_New_AbsentismoOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_SAVE_NEW_ABSENTISMO(IdHR, inicio,fin, idAbsentismo, comentarios, validatorMethodEss, "Lalalalala"); 
				//Meta4Object.ESS_SAVE_NEW_ABSENTISMO(ID_HR, INICIO, FIN, TIPO_AUSENCIA, COMENTARIO, TIPO_RERSPONSABLE, OPTIONAL)
				DevMetodo = SalidaExec.get_return();
				
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);

				helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
				XML = helperXml.getValues(); 
				
				
				
				//si Todo OK enviamos notificacion Push al solicitante NO al manager
				parseOperations parse = new parseOperations();
				parse.sendPushNotification("Solicitud de ausencia en proceso", Session.getData(Session.getPosDefaultSystem()).user, "");
				
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
				apply = null;

			
			}
			
			return XML;
		}
		
		/*
		 * ESS . El empleado eliminar una solicitud de ausencia
		 */
		
		public String EssDelSolAbsentismo(logonCredencialProcess Session,String IdHR, double ordinal) throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			
			IntParams.debugInfo("Metodo: EssDelSolAbsentismo");
			IntParams.debugInfo(" .IdHR: " + IdHR);
			IntParams.debugInfo(" .ordinal  : " + ordinal);



			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";

			
			javax.xml.rpc.Stub oStub = null;	
			
			
			paramsSystem apply; //aplicaValor
			
			try{
			
				apply = new paramsSystem();
				String validatorMethodEss = apply.getParamValue(9, Session.SerialKeyForIdProcess, this.getClass().getSimpleName()); 
				
				
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Ess_Delete_Abs_SolicOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.ESS_DELETE_ABS_SOLIC(IdHR, ordinal, "");
				DevMetodo = SalidaExec.get_return();
				
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);

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
				apply = null;

			
			}
			
			return XML;
		}
		
		
		// ------------------------------------------------
		// ------------------------------------------------
		// ----> Metodos para el MSS de Absentismos <------
		// ------------------------------------------------
		// ------------------------------------------------
		
		
		
		// -------------------------------------------------------------------------------------
		// MSS. Devuelve la lista de absentismos que tiene el manager por validar.
		// -------------------------------------------------------------------------------------
		public String getMssListaSolicAbsentPorValidar(logonCredencialProcess Session,String IdHR,String optional) throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			IntParams.debugInfo("Metodo: getMssListaSolicAbsentPorValidar");
			IntParams.debugInfo("	.IdHR: " + IdHR);
			

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			String result="";
			String fichero="";
			DataHandler attachmentEcho;
			
			javax.xml.rpc.Stub oStub = null;	
			paramsSystem apply; //aplicaValor
			
			
			try{
				
				
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Mss_Get_AbsentismosOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.MSS_GET_ABSENTISMOS(IdHR, optional); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				
				//cargamos el Bloque de registros
				Mss_Get_Absentismos_ResultBlock Bloque = SalidaExec.getMss_Get_Absentismos_Result();
				//Montamos el recordset
				Mss_Get_Absentismos_ResultRecord[] Rec =  Bloque.getMss_Get_Absentismos_ResultRecordSet();
				
				
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
			
			
				String fileCache="";
				
			
				//Recorrmeos los registros
				@SuppressWarnings("unused") String ExtensionFile = "";
				
				for (int z = 0;z<Rec.length;z++)
				{
					ExtensionFile="";
					
					//Nombre cache imagen Sociedad _ NIF
					fileCache =  Rec[z].getId_Organization() + "_" + Rec[z].getNif().toString();
						
					helperXml.addXmlItem("comentariosolicitante" , z,Rec[z].getCsp_Comment().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nombre" , z,Rec[z].getCsp_Gb_Name().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("estado" , z,Rec[z].getEstado().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nmestado" , z,Rec[z].getNm_Estado().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("inicio" , z,Rec[z].getFecha_Inicio().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("fin" , z,Rec[z].getFecha_Fin().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("dias" , z,Rec[z].getTotal_Dias().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("idabsentismo" , z,Rec[z].getId_Absentismo().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nmabsentismo" , z,Rec[z].getNm_Absentismo().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("idempleado" , z,Rec[z].getId_Empleado().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nif" , z,Rec[z].getNif().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("ordinalsolic" , z,Rec[z].getEq_Def_1().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("sociedad" , z,Rec[z].getId_Organization(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("idfile" , z,fileCache, helperXml.XML_NORMAL);
					
			
					

					
					//Campos con Imagen -------------------------------------------------------------
					
					String FileCacheImagen = new documentsCache().getCacheFileListImage(fileCache);

					//no cacheada	
					if (FileCacheImagen.equals(""))
					{
						try{
						
							 //vemos el tipo de archivo que viene
							String MimeType = Rec[z].getFoto().getContentType().toString();
							fichero = new ParamsApp().GetFichTemporal(Session.SerialKeyForIdProcess,MimeType); //me crea el nombre de un fichero y ruta temporal de ese tipo
							 
							//fichero adjunto
							attachmentEcho = Rec[z].getFoto();
							
							
							ManagedMemoryDataSource mmds = (ManagedMemoryDataSource)attachmentEcho.getDataSource(); 
							
							
							result="";
							if (mmds != null)
							{
								//creamos el fichero en Local para despues leerlo.
								IntParams.CrearImagenMeta4enLocal(mmds, fichero);
								
								//cacheamos la imagen
								if (SYSTEM_CACHE_FOTOS)
								{
									new documentsCache().cacheFile(fichero, fileCache, documentsCache.CACHE_GROUP_IMAGE);
								}
								
								
								//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
								//result = IntParams.getValueFileBase64Encode(fichero, MimeType);
									
								helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);			
								mmds.delete();
								IntParams.DeleteFich(fichero);
							}
							else  //no se puede abrir.
							{
								helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
								
							}
						}
						catch(Exception ee)  //lectura de la imagen
						{
							helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
							
						}
						finally
						{
							//elimino el fichero generado
							IntParams.DeleteFich(fichero);

						}
						
					}
					else
					{
						//si cacheada, la cogemos directamete
						helperXml.addXmlItem("foto",z,"", helperXml.XML_NORMAL);
					}
					
				} //del for

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
				attachmentEcho=null;
				helperXml = null;
				apply=null;
			
			}
			
			return XML;
		}
		
		// -------------------------------------------------------------------------------------
		// MSS. Cancela una solicitud de absentismo
		// -------------------------------------------------------------------------------------
		public String setMssCancelSolicAbs(logonCredencialProcess Session,String IdHR, double ordinal, String motivo, String optional)  throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			
			IntParams.debugInfo("Metodo: setMssCancelSolicAbs");
			IntParams.debugInfo(" .IdHR: " + IdHR);
			IntParams.debugInfo(" .ordinal  : " + ordinal);
			IntParams.debugInfo(" .motivo  : " + motivo);

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			String result="";
			String fichero="";
			
			javax.xml.rpc.Stub oStub = null;	

			try{
			
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Mss_Cancel_AbsentismoOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.MSS_CANCEL_ABSENTISMO(IdHR, ordinal, motivo, optional); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);

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
		
		// -------------------------------------------------------------------------------------
		// MSS. Acepta una solicitud de absentismo
		// -------------------------------------------------------------------------------------
		public String setMssAceptarSolicAbs(logonCredencialProcess Session,String IdHR, double ordinal, String motivo, String optional) throws Exception
		{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			paramsSystem apply;
			
			//Serial de parametros adicionales para meta4
			apply = new paramsSystem();
			String auxfasesVal = apply.getParamValue(11, Session.SerialKeyForIdProcess, this.getClass().getSimpleName()); //el proceso siempre el nombre de la clase
			String auxIdResponsable = apply.getParamValue(10, Session.SerialKeyForIdProcess, this.getClass().getSimpleName());
			String serial = "{NIVEL}={"+auxfasesVal+"}";
			
			
			IntParams.debugInfo("Metodo: setMssAceptarSolicAbs");
			IntParams.debugInfo(" .IdHR: " + IdHR);
			IntParams.debugInfo(" .ordinal  : " + ordinal);
			IntParams.debugInfo(" .motivo  : " + motivo);

			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			String result="";
			String fichero="";
			
			javax.xml.rpc.Stub oStub = null;	

			try{
			
				Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
				Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
				Mss_Confirm_AbsentismoOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.MSS_CONFIRM_ABSENTISMO(IdHR, ordinal, motivo, serial); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);

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
		
		
		
		
		
		
		// MSS Mis Consultas (Especifico de Peoplenet. Tinnova no)
		// -------------------------------------------------------------------------------------
		
		
		
				// Devuelve las consultas del manager del portal mobile
				// -------------------------------------------------------------------------------------
				public String getMssMisConsultas(logonCredencialProcess Session) throws Exception
				{

					XmlHelper helperXml = new XmlHelper();
					//control session (si las credenciales erronas, devolvemos vacio)
					if (Session==null) {return helperXml.getErrorValues("");}
					
					
					IntParams.debugInfo("Metodo: getEssMisConsultas");
	
			
					

					@SuppressWarnings("unused") String dev = "";
					@SuppressWarnings("unused") Double DevMetodo=0.00;
					@SuppressWarnings("unused") String ResultSerial="";
					
					String XML="";
					
					javax.xml.rpc.Stub oStub = null;	
					
					try{
						
						Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
						Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
						Mss_Get_Mis_ConsultasOutput SalidaExec;
						
						
						//mantenemos la session proy
						oStub = (javax.xml.rpc.Stub)Meta4Object;
						oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
						
						
						//ejecutamos el m�todo
						Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
						SalidaExec =	 Meta4Object.MSS_GET_MIS_CONSULTAS(""); //ejecutamos metodo en Meta4
						DevMetodo = SalidaExec.get_return();
						
						
						//cargamos el Bloque de registros
						Mss_Get_Mis_Consultas_ResultBlock Bloque = SalidaExec.getMss_Get_Mis_Consultas_Result();
						
						//Montamos el recordset
						Mss_Get_Mis_Consultas_ResultRecord[] Rec =  Bloque.getMss_Get_Mis_Consultas_ResultRecordSet();
					
						helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
						helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
						helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
						
						//code meta4
						helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
						
						//Resultado Operacion metodo
						helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
						//XML: num registros. 
						helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
						
						for(int z = 0; z<Rec.length;z++)
						{
							helperXml.addXmlItem("idMeta4Object" , z,Rec[z].getId_Meta4Object().toString(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("name" , z,Rec[z].getNombre().toString(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("totparams" , z,Rec[z].getTot_Params().toString(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("description" , z,Rec[z].getDescripcion_Parametro(), helperXml.XML_NORMAL);
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
					}
					
					return XML;
				}
		
		
				// Devuelve la MetaData de una consulta
				// -------------------------------------------------------------------------------------
				public String getMssMiConsultaMetaData(logonCredencialProcess Session, String idMeta4Object) throws Exception
				{

					XmlHelper helperXml = new XmlHelper();
					//control session (si las credenciales erronas, devolvemos vacio)
					if (Session==null) {return helperXml.getErrorValues("");}
					
					
					IntParams.debugInfo("Metodo: getEssMiConsultametaData");
					IntParams.debugInfo("		- idMeta4Object: " + idMeta4Object);
			
					

					@SuppressWarnings("unused") String dev = "";
					@SuppressWarnings("unused") Double DevMetodo=0.00;
					@SuppressWarnings("unused") String ResultSerial="";
					
					String XML="";
					
					javax.xml.rpc.Stub oStub = null;	
					
					try{
						
						Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
						Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
						Mss_Get_Mis_Consultas_MetadataOutput SalidaExec;
						
						
						//mantenemos la session proy
						oStub = (javax.xml.rpc.Stub)Meta4Object;
						oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
						
						
						//ejecutamos el m�todo
						Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
						SalidaExec =	 Meta4Object.MSS_GET_MIS_CONSULTAS_METADATA(idMeta4Object); //ejecutamos metodo en Meta4
						DevMetodo = SalidaExec.get_return();
						
						
						//cargamos el Bloque de registros
						Mss_Get_Mis_Consultas_ResultBlock Bloque = SalidaExec.getMss_Get_Mis_Consultas_Result();
						
						//Montamos el recordset
						Mss_Get_Mis_Consultas_ResultRecord[] Rec =  Bloque.getMss_Get_Mis_Consultas_ResultRecordSet();
					
						helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
						helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
						helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
						
						//code meta4
						helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
						
						//Resultado Operacion metodo
						helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
						//XML: num registros. 
						helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
						
						for(int z = 0; z<Rec.length;z++)
						{
							helperXml.addXmlItem("idparam" , z,Rec[z].getItem_Parametro(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("node" , z,Rec[z].getNodo_Parametro(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("name" , z,Rec[z].getNombre_Parametro(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("description" , z,Rec[z].getDescripcion_Parametro(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("tipodata" , z,Rec[z].getTipo_Dato_Parametro(), helperXml.XML_NORMAL);
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
					}
					
					return XML;
				}
		
				// Devuelve la MetaData de una consulta
				// -------------------------------------------------------------------------------------
				public String getMssExecuteQuery(logonCredencialProcess Session, String idMeta4Object, String params) throws Exception
				{

					XmlHelper helperXml = new XmlHelper();
					//control session (si las credenciales erronas, devolvemos vacio)
					if (Session==null) {return helperXml.getErrorValues("");}
					
					
					IntParams.debugInfo("Metodo: getMssExecuteQuery");
					IntParams.debugInfo("		- idMeta4Object: " + idMeta4Object);
					IntParams.debugInfo("		- params       : " + params);
					

					@SuppressWarnings("unused") String dev = "";
					@SuppressWarnings("unused") Double DevMetodo=0.00;
					@SuppressWarnings("unused") String ResultSerial="";
					DataHandler attachmentEcho;
					
					String XML="";
					
					javax.xml.rpc.Stub oStub = null;	
					String result = "";
					String fichero = "";
					
					try{
						
						Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
						Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
						Mss_Exec_QueryOutput SalidaExec;
						
						
						//mantenemos la session proy
						oStub = (javax.xml.rpc.Stub)Meta4Object;
						oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
						
						
						//ejecutamos el m�todo
						Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
						SalidaExec =	 Meta4Object.MSS_EXEC_QUERY(idMeta4Object, params); //ejecutamos metodo en Meta4
						DevMetodo = SalidaExec.get_return();
						
						
						//cargamos el Bloque de registros
						Mss_Get_Mis_Consultas_ResultBlock Bloque = SalidaExec.getMss_Get_Mis_Consultas_Result();
						
					
						helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
						helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
						helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
						
						//code meta4
						helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
						
						//Resultado Operacion metodo
						helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
						//XML: num registros. 
						helperXml.addXmlItem("Records", "0", helperXml.XML_NORMAL);
						
						
						//Buscamos la Excel de la Query
						try{
							
							//Creamos ruta fichero temporal
							fichero = new ParamsApp().GetFichTemporalExtension(Session.SerialKeyForIdProcess,"XLS"); //me crea el nombre de un fichero y ruta temporal de ese tipo
							 
							//fichero adjunto Excel
							attachmentEcho =Bloque.getBlob_Excel_Consulta();
							
							
							ManagedMemoryDataSource mmds = (ManagedMemoryDataSource)attachmentEcho.getDataSource(); 
							result="";
							
							if (mmds != null)
							{
								//creamos el fichero en Local para despues leerlo.
								IntParams.CrearImagenMeta4enLocal(mmds, fichero);
								
								//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
								result = IntParams.readFileAndConvertBase64String(fichero);
								helperXml.addXmlItem("file", result, helperXml.XML_NORMAL);
											
								mmds.delete();
							}
							else  //no se puede abrir.
							{
								helperXml.addXmlItem("file","", helperXml.XML_NORMAL);
							}
						}
						catch(Exception ee)  //lectura de la imagen
						{
							helperXml.addXmlItem("file", "", helperXml.XML_NORMAL);
						}
						finally
						{
							//elimino el fichero generado
							IntParams.DeleteFich(fichero);
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
					}
					
					return XML;
				}
				
				
				//Devuelve la lista de documentos a enviar desde las Apps
				public String getESSListDocsSendType(logonCredencialProcess Session ) throws Exception{
		
					
					//control session (si las credenciales erronas, devolvemos error -1)
					if (Session==null) {return "";}
					XmlHelper helperXml = new XmlHelper();
					
					String XML="";
					
					IntParams.debugInfo("Metodo: getListaTipoDocumentosEnviar");
					
					@SuppressWarnings("unused") String dev = "";
					@SuppressWarnings("unused") Double DevMetodo=0.00;
					@SuppressWarnings("unused") String ResultSerial="";
		
					
					javax.xml.rpc.Stub oStub = null;	
					String result = "";
					
					try{
						
						Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
						Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
						Ess_Get_Tp_Documents_SendOutput SalidaExec;
						
						
						//mantenemos la session proy
						oStub = (javax.xml.rpc.Stub)Meta4Object;
						oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
						
						
						//ejecutamos el metodo
						Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
						SalidaExec =	 Meta4Object.ESS_GET_TP_DOCUMENTS_SEND(); //ejecutamos metodo en Meta4
						
						//montamos el XML
						helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
						helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
						helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
						
						//code meta4
						helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
						
						//Resultado Operacion metodo
						helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
						//cargamos el Bloque de registros
						Ess_Get_Tp_Documents_ResultBlock Bloque = SalidaExec.getEss_Get_Tp_Documents_Result();
						
						//Montamos el recordset
						Ess_Get_Tp_Documents_ResultRecord[] Rec =  Bloque.getEss_Get_Tp_Documents_ResultRecordSet();
						
						
						//XML: num registros. 
						helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
						
						for(int z = 0; z<Rec.length;z++)
						{
							helperXml.addXmlItem("id" , z,Rec[z].getCsp_Id_Tp_Doc().toString(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("name" , z,Rec[z].getCsp_Nombre().toString(), helperXml.XML_NORMAL);
							
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
					}
					
					return XML; //Devolvemos el XML
					
				
				}
				
				
				
				// ------- Funciones de Seguridad de cambio de contraseña del App ----------
				
				
				
				//cambio de clave desde el App
				public Double chgPasswordUserApp(logonCredencialProcess Session, String newPass ){
		
					
					//control session (si las credenciales erronas, devolvemos error -1)
					if (Session==null) {return (double) -1;}
					
					
					IntParams.debugInfo("Metodo: chgPasswordUserApp");
					
					@SuppressWarnings("unused") String dev = "";
					@SuppressWarnings("unused") Double DevMetodo=0.00;
					@SuppressWarnings("unused") String ResultSerial="";
		
					
					javax.xml.rpc.Stub oStub = null;	
					String result = "";
					
					try{
						
						Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
						Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
						Seg_Change_Password_UserOutput SalidaExec;
						
						
						//mantenemos la session proy
						oStub = (javax.xml.rpc.Stub)Meta4Object;
						oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
						
						
						//ejecutamos el metodo
						Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
						SalidaExec =	 Meta4Object.SEG_CHANGE_PASSWORD_USER(newPass); //ejecutamos metodo en Meta4 para cambiar la clave
						DevMetodo = SalidaExec.get_return();
						
						return DevMetodo; 
						

						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						return (double) -1;
						
					}
					finally
					{
						
					}
					
				
				}
				
				//Clave olvidad usuario. Solicita cambio de clave y envio por mail. Nos pasa el usuario desde el App
				//Nota esto es sin conexion (login). Hay que hacer un login tecnologico.
				public Double chgPasswordForgetAndSendByEmail(String mail, String numDoc, String PrimApp ){
		
					
					//Hacemos Login con el usuario BackDoor para sesiones anónimas
					
					Meta4Login loginTech;
					
					IntParams.debugInfo("Metodo: chgPasswordUserApp");
					
					@SuppressWarnings("unused") String dev = "";
					@SuppressWarnings("unused") Double DevMetodo=0.00;
					@SuppressWarnings("unused") String ResultSerial="";
		
					
					javax.xml.rpc.Stub oStub = null;	
					String result = "";
					String InternalSerial="";
					
					try{
						
						loginTech = new Meta4Login();
						
						InternalSerial = loginTech.loginMeta4(new ParamsApp().META4_USER_BACKDOOR, new ParamsApp().META4_PASS_BACKDOOR);
						
						if (InternalSerial.equals("")){
							IntParams.debugInfo(" Error Login Tecnologico. El usuario y clave " + new ParamsApp().META4_USER_BACKDOOR +  " es incorrecto");
							return (double) -1; //error en el login tecnologico
						}
						
						
						Csp_Mbl_Soap_EssServiceService  Sfactory = new Csp_Mbl_Soap_EssServiceServiceLocator();
						Csp_Mbl_Soap_EssService Meta4Object = Sfactory.getCSP_MBL_SOAP_ESS();
						Seg_Forget_Password_UserOutput SalidaExec;
						
						
						//mantenemos la session proy
						oStub = (javax.xml.rpc.Stub)Meta4Object;
						oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
						
						
						//ejecutamos el metodo
						Meta4Object.retrieveM4Session(InternalSerial); //recuperamos la sesion tecnologica BackDoor
						SalidaExec =	 Meta4Object.SEG_FORGET_PASSWORD_USER(numDoc, PrimApp, mail); //Envio de clave desde Meta4 por Mail
						DevMetodo = SalidaExec.get_return();
						
						
						//si llega aqui hacemos Logout del App server del tecnologico.
						if (!InternalSerial.equals("")){
							loginTech.LogoutNMeta4(InternalSerial);
						}
						
						
						return DevMetodo; 
						

						
					}
					catch(Exception e)
					{
						e.printStackTrace();
						return (double) -1;
						
					}
					finally
					{
						
						loginTech = null;
					}
					
				
				}
		
				
				
				/*
				 * equilibrha
				 * 
				 */
}
