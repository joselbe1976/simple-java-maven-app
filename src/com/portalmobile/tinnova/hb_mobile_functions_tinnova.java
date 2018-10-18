/*
 * Equilibrha 2016. Metodos para el telefono de tinnova
 * Jose Luis Bustos. 
 */

package com.portalmobile.tinnova;

import java.sql.Timestamp;
import java.util.*;
import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.globalSystems.paramsSystem;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.hb_notifications;
import com.common.hibernate.classes.hb_tools;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.hibernate.entidades.VinNotifications;
import com.common.tools.DatesTools;
import com.common.tools.cache.documentsCache;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.mail.sendMailAsync;
import com.common.tools.xml.XmlHelper;


public class hb_mobile_functions_tinnova extends hb_main_tinnova  implements iDisposable {
	private boolean SYSTEM_CACHE_FOTOS = true; // cacheo de fotos
	private ParamsApp IntParams;
	private hb_tools tools;
	private tiinova_backend_tools backendToolsTiinova;
	
	public List<?> log = null;
	
	private static String className = "";

	// constructor class
	public hb_mobile_functions_tinnova() {
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
	public String GetInfoConectedUser(logonCredencialProcess Session)
	{
		
			addLog("Init: GetInfoConectedUser",ParamsApp.LOG_TYPE_INFO);
			XmlHelper helperXml =  new XmlHelper();
			
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
	
			String XML = "";
			String idFoto = "";
			Map row =null;
			
			try{
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
				//XML: num of records
				helperXml.addXmlItem("Records", "1", helperXml.XML_NO_USAR_CDATA);
			
				//product version
				helperXml.addXmlItem("productversion", ParamsApp.SYSTEM_PRODUCT_VERSION.toString(), helperXml.XML_NORMAL);
			

				//Query Employee Data
				String Sql = "SELECT * FROM M4T_EMPLEADOS WHERE ID_EMPLEADO='" + Session.getData(Session.getPosDefaultSystem()).id_persona + "' and  ID_SOCIEDAD = '" +Session.getData(Session.getPosDefaultSystem()).sociedad + "'";
				List<?> data = this.getDataSQLNativo(Sql);
				row = (Map)data.get(0); //The row extract
		        
				String nameRH = row.get("NOMBRE").toString() + " " + tools.controlNulls(row.get("APELLIDO_1").toString()) + " " + tools.controlNulls(row.get("APELLIDO_2").toString());
				
				
				String IdEmpleado = row.get("ID_EMPLEADO").toString();
				String sociedad =  row.get("ID_SOCIEDAD").toString();
				String fecAlta  = Session.getData(Session.getPosDefaultSystem()).fase_alta;
				idFoto = sociedad +  "_"+ row.get("ID_LEGAL").toString();
				
				helperXml.addXmlItem("idempleado",backendToolsTiinova.getCreateIdEmployeeComp(IdEmpleado, sociedad) , helperXml.XML_NORMAL);
				helperXml.addXmlItem("sociedad",sociedad , helperXml.XML_NORMAL); //Always void
				helperXml.addXmlItem("nombre",nameRH, helperXml.XML_NORMAL);
				helperXml.addXmlItem("nif", row.get("ID_LEGAL").toString() , helperXml.XML_NORMAL);
				
				Sql = "SELECT * FROM M4T_HIST_PUESTOS WHERE ID_EMPLEADO='" + IdEmpleado + "' and  ID_SOCIEDAD = '" + sociedad + "' ";
				Sql+= " AND FEC_ALTA_EMPLEADO = " + backendToolsTiinova.getFormatDateFilter(fecAlta) + " AND FEC_FIN IS NULL";

				data = this.getDataSQLNativo(Sql);
				row = (Map)data.get(0); 
				String Id_Puesto = row.get("ID_PUESTO").toString();
				
				//Job Name
				Sql = "SELECT N_PUESTO FROM M4T_PUEST_TRAB WHERE ID_PUESTO='" + Id_Puesto +"' ";
				data = this.getDataSQLNativo(Sql);
				row = (Map)data.get(0);
				String NM_Puesto = row.get("N_PUESTO").toString();
				
				helperXml.addXmlItem("puesto",NM_Puesto , helperXml.XML_NORMAL);
				
				
				//MIRAMOS SI ES RESPONSABLE DE ALGUN DEPARTAMENTO
				Sql = "SELECT * from M4T_DEPARTAMENTOS WHERE  ID_SOCIEDAD = '" + sociedad + "' AND ( ID_RESPONSABLE = '"+ IdEmpleado + "' OR ID_RESPONS_RESP = '"+ IdEmpleado +"' ) ";
				data = this.getDataSQLNativo(Sql);
				
				
				if (data != null)
				{
					if (data.size() == 0)
					{
						helperXml.addXmlItem("esmanager", "0" , helperXml.XML_NORMAL); //0 = no , 1 = si
					}
					else
					{
						helperXml.addXmlItem("esmanager", "1" , helperXml.XML_NORMAL); //0 = no , 1 = si
					}
				}
				else
				{
					
					helperXml.addXmlItem("esmanager", "0" , helperXml.XML_NORMAL); //0 = no , 1 = si
				}
				
				
				//Sql Query in Tinnova the notifications ready today for employee No READ
				Sql = "SELECT ID_SOCIEDAD, ID_EMPLEADO  FROM MBL_NOTIFICACIONES_TODAY WHERE ID_SOCIEDAD = '"+ sociedad + "' AND ID_EMPLEADO = '" + IdEmpleado + "' AND CHECK_RECIBIDO = '0'";
				data = this.getDataSQLNativo(Sql);
				int numero = 0;
				if (data != null)
				{
					numero = data.size();
				}

				// ------------------------------------------------------------------		
				// Now Integrate with local notifications (of other systems) No READ
				// ------------------------------------------------------------------
				
				int numRegLocal = 0;
				
				hb_notifications notif = null;
				try{
					notif = new hb_notifications();
					
					int localSystemPos = Session.getPosDefaultSystem();
					if (localSystemPos >= 0)
					{
						List<?> auxLocal = notif.getListaNotificacionesActivas(Session.getData(localSystemPos).user);
						numRegLocal = auxLocal.size();				
					}
				}
				catch(Exception e)
				{
					addLog(e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				}
				finally{
					notif = null;
				}
				
				//SUM local + Tinnova
				numero+=numRegLocal;
				
				helperXml.addXmlItem("pushnotif",String.valueOf(numero)  , helperXml.XML_NORMAL);
				
				//Files have now the employee
				
				//Sql Query in Tinnova the Files ready today for employee No READ 
				Sql = "SELECT ID_SOCIEDAD, ID_EMPLEADO FROM MBL_FILES_TODAY WHERE ID_SOCIEDAD = '"+ sociedad + "' AND ID_EMPLEADO = '" + IdEmpleado + "' AND CHK_RECIBIDO = '0'";
				data = this.getDataSQLNativo(Sql);
				int numeroFiles = 0;
				if (data != null)
				{
					numeroFiles = data.size();
				}
				
				helperXml.addXmlItem("pushfile",String.valueOf(numeroFiles)  , helperXml.XML_NORMAL);
				
				helperXml.addXmlItem("foto","" , helperXml.XML_NORMAL); //alwways VOID for compatibility
				
					//Image Employee
					try{
						String FileCacheImagen = new documentsCache().getCacheFileListImage(idFoto);
						
						if (FileCacheImagen.equals(""))
						{
								String fileCache = idFoto;
								String PathFoto = "";

								Sql = "SELECT N_FICHERO FROM M4T_INF_GRAF_EMPL WHERE ID_EMPLEADO='" + IdEmpleado + "' AND  ID_SOCIEDAD = '" + sociedad + "'";
								data = this.getDataSQLNativo(Sql);
								if (data.size() > 0)
								{
									row = (Map)data.get(0); 
									PathFoto= row.get("N_FICHERO").toString();
								}
								
								if (!PathFoto.equals("")) //Employee has a foto asigned in tinnova
								{
									//control of Remote Files of Tinnova
									tiinova_backend_tools tool = new tiinova_backend_tools();
									PathFoto = tool.readRemoteFilesToLocal(PathFoto,Session.SerialKeyMainReturnApps,false); //Get Remote File to Local temp File
									tool.Dispose();
									tool = null;
									
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
						addLog(ee.getMessage(), ParamsApp.LOG_TYPE_ERROR);
					}
					finally
					{
						helperXml.addXmlItem("idfoto",idFoto , helperXml.XML_NORMAL);	//id de la foto
						helperXml.addXmlItem("object2","object" , helperXml.XML_SOLO_CERRAR_XML);
						
						XML = helperXml.getValues();
					}
			}
			catch(Exception e)
			{
				addLog("GETINFOUSERAPP"+e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				return helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			}
			finally
			{
				helperXml.Dispose();
				helperXml = null;
			}
			
			return XML;
		
	}


	public String GetMenus(logonCredencialProcess Session) throws Exception {
		return this.GetInfoConectedUser(Session);
	}


	@SuppressWarnings("rawtypes")
	public String GetListaEmpleados(logonCredencialProcess Session, String Base64Filters,double PaginaDatos) throws Exception
	{
			XmlHelper helperXml = new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			
			//Decodificacion
			String Filters =Base64Filters;
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
						
				//Sql for Tinnova. Only Hires
				String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
				String Sql = "SELECT * FROM MBL_EMPLEADOS_LISTA WHERE ID_SOCIEDAD = '" + sociedad +  "' ";
				if (!Filters.equals("")) {
					Sql = Sql + " AND  " + Filters;
				}
				
				Sql = Sql + " ORDER BY ID_EMPLEADO ASC ";
				
				//create Query and Pagination
				SQLQuery query  = this.getSqlQuery(Sql);
				query.setFirstResult(desde.intValue());     
				query.setMaxResults(NumRecords.intValue());
				
				List<?> data  = this.getDataFromQuery(query); //execute SQL from Query Object
				
				this.log = data; //TODO: Eliminar esta linea
				
				//Total Records
				helperXml.addXmlItem("TotalRecords", String.valueOf(data.size()), helperXml.XML_NORMAL);
				
				apply = new paramsSystem();
						
				String fileCache="";
				
				
				//record by record
				@SuppressWarnings("unused") String ExtensionFile = "";
				int numregSend = 0;

				
				for (int z = 0;z<data.size();z++)
				{
						
						numregSend ++;
						row = (Map)data.get(z); //Extract the row
						ExtensionFile="";
						
						String idEmpe= row.get("ID_EMPLEADO").toString();
						String idSoc = row.get("ID_SOCIEDAD").toString();
						String fecAlta = row.get("FEC_ALTA_EMPLEADO").toString();
						
						//Legal Document NIF for the Image Employee + Sociedad
						fileCache =  idSoc + "_" + row.get("ID_LEGAL").toString();
						
						String IdEmployeeSendDevice = backendToolsTiinova.getCreateIdEmployeeComp(row.get("ID_EMPLEADO").toString(), row.get("ID_SOCIEDAD").toString());
						helperXml.addXmlItem("idempleado" , z,IdEmployeeSendDevice, helperXml.XML_NORMAL);
						helperXml.addXmlItem("sociedad" , z,row.get("ID_SOCIEDAD").toString(), helperXml.XML_NORMAL); //ALWAYS VOID 
						helperXml.addXmlItem("ordinal" , z,"0", helperXml.XML_NORMAL);
						helperXml.addXmlItem("fnac" , z,row.get("FEC_NACIMIENTO").toString().replace(" 00:00:00.0", "") , helperXml.XML_NORMAL);
						helperXml.addXmlItem("nombre" , z,row.get("NOMBRE").toString() + " " + row.get("APELLIDO_1").toString() + " " + row.get("APELLIDO_2").toString(), helperXml.XML_NORMAL);
						helperXml.addXmlItem("nif" , z,row.get("ID_LEGAL").toString(), helperXml.XML_NORMAL);
						helperXml.addXmlItem("idfoto" , z,fileCache, helperXml.XML_NORMAL);
						
					
						//Period of the Employee data
						helperXml.addXmlItem("falta" , z,row.get("FEC_ALTA_EMPLEADO").toString().replace(" 00:00:00.0", "") , helperXml.XML_NORMAL);
						
						if (row.get("FEC_BAJA") == null){
							helperXml.addXmlItem("fbaja" , z, "4000-01-01", helperXml.XML_NORMAL);
						}else{
							helperXml.addXmlItem("fbaja" , z, row.get("FEC_BAJA").toString().replace(" 00:00:00.0", ""), helperXml.XML_NORMAL);	
						}
						
						if (row.get("FEC_ANTIGUEDAD") == null){
							helperXml.addXmlItem("fantiguedad" , z,"4000-01-01", helperXml.XML_NORMAL);
						}else{
							helperXml.addXmlItem("fantiguedad" , z,row.get("FEC_ANTIGUEDAD").toString().replace(" 00:00:00.0", ""), helperXml.XML_NORMAL);
						}
						
						if (row.get("DIRECCION_MAIL") == null){
							helperXml.addXmlItem("mail" , z,"", helperXml.XML_NORMAL);
						}else{
							helperXml.addXmlItem("mail" , z,row.get("DIRECCION_MAIL").toString(), helperXml.XML_NORMAL);
						}

						
						//employee Data phone an dif is null the extension
						String SqlTelefono = "SELECT TELEFONO FROM  M4T_DOMIC_EMPL WHERE ID_SOCIEDAD = '"+idSoc+"' AND ID_EMPLEADO = '"+idEmpe+"'";
						String telefono = backendToolsTiinova.getDBValueSql(SqlTelefono,"TELEFONO");
						
						if (telefono != null || telefono.toString().trim().length() == 0) {
							telefono = backendToolsTiinova.getPhoneExtension(idSoc, idEmpe);
						}
						helperXml.addXmlItem("telefono",z, telefono, helperXml.XML_NORMAL);
						
						//Absent state today.
						
						String SqlAbsentismo = "SELECT * FROM MBL_ABSENTISMOS_HOY WHERE ID_SOCIEDAD = '" + idSoc + "' AND ID_EMPLEADO = '" + idEmpe + "'";
						List<?> dataAuxAbs  = this.getDataSQLNativo(SqlAbsentismo);
						String absId = "00";  //by default. Employee is OK today
						if (dataAuxAbs.size() > 0)
						{
							absId = "01"; //He has a absence
						}
						
						helperXml.addXmlItem("estadoempleado",z,absId, helperXml.XML_NORMAL);
						helperXml.addXmlItem("idestadoempleado",z,absId, helperXml.XML_NORMAL);
						helperXml.addXmlItem("base64nmcentrocoste",z,"", helperXml.XML_NORMAL);
						
						String SqlEmpresa = "SELECT C.N_EMPRESA from M4T_HIST_CABEC_TC1 A, M4T_CABECERAS_TC1 B,  M4T_EMPRESAS C WHERE A.ID_EMPLEADO = '"+ idEmpe+"' AND A.ID_SOCIEDAD = '"+idSoc+"' AND A.FEC_FIN IS NULL AND A.ID_SOCIEDAD = B.ID_SOCIEDAD AND A.ID_CABECERA_TC1  = B.ID_CABECERA_TC1 AND B.ID_EMPRESA = C.ID_EMPRESA AND B.ID_SOCIEDAD = C.ID_SOCIEDAD";
						helperXml.addXmlItem("base64nmempresa",z,backendToolsTiinova.getDBValueSql(SqlEmpresa,"N_EMPRESA"), helperXml.XML_NORMAL);
						
						String SqlCentro = "SELECT B.N_CENTRO_TRABAJO FROM M4T_HIST_CENT_TRAB A, M4T_CENTROS_TRAB B WHERE A.ID_SOCIEDAD = '"+idSoc+"' AND A.ID_EMPLEADO = '"+idEmpe+"' AND A.FEC_ALTA_EMPLEADO = " + backendToolsTiinova.getFormatDateFilter(fecAlta) + " AND A.ID_CENTRO_TRABAJO = B.ID_CENTRO_TRABAJO";
						helperXml.addXmlItem("base64nmlugartrabajar",z,backendToolsTiinova.getDBValueSql(SqlCentro,"N_CENTRO_TRABAJO"), helperXml.XML_NORMAL);
						
						String SqlPuesto = "SELECT B.N_PUESTO FROM M4T_HIST_PUESTOS A, M4T_PUEST_TRAB B WHERE A.ID_SOCIEDAD = '"+idSoc+"' AND A.ID_EMPLEADO = '"+idEmpe+"' AND A.FEC_ALTA_EMPLEADO = " + backendToolsTiinova.getFormatDateFilter(fecAlta) + " AND A.ID_PUESTO = B.ID_PUESTO AND A.ID_SOCIEDAD = B.ID_SOCIEDAD  AND A.FEC_FIN IS NULL";
						helperXml.addXmlItem("base64nmpuesto",z,backendToolsTiinova.getDBValueSql(SqlPuesto,"N_PUESTO"), helperXml.XML_NORMAL);
						
						helperXml.addXmlItem("favorito",z,"0", helperXml.XML_NORMAL);
	
						helperXml.addXmlItem("idworklocation",z,"", helperXml.XML_NORMAL);
						helperXml.addXmlItem("nmworklocation",z,"", helperXml.XML_NORMAL);
						
						String SqlResponsable = "SELECT C.NOMBRE + ' ' + C.APELLIDO_1 + ' ' + C.APELLIDO_2 AS NOMBRE FROM M4T_HIST_DEPARTAM A , M4T_DEPARTAMENTOS B, M4T_EMPLEADOS C WHERE A.ID_SOCIEDAD = '"+idSoc+"' AND A.ID_EMPLEADO = '"+idEmpe+"' AND A.FEC_ALTA_EMPLEADO = " + backendToolsTiinova.getFormatDateFilter(fecAlta) + " AND A.FEC_FIN IS NULL AND A.ID_SOCIEDAD = B.ID_SOCIEDAD AND A.ID_DEPARTAMENTO = B.ID_DEPARTAMENTO AND B.ID_SOCIEDAD = C.ID_SOCIEDAD AND B.ID_RESPONSABLE = C.ID_EMPLEADO";
						helperXml.addXmlItem("nmresponworkunit",z,backendToolsTiinova.getDBValueSql(SqlResponsable,"NOMBRE"), helperXml.XML_NORMAL);
	
						//We Query if The employee is Manager (departament responsability)
						List<?> dataManager = this.getDataSQLNativo("SELECT * from M4T_DEPARTAMENTOS WHERE  ID_SOCIEDAD = '"+ idSoc +"' AND ( ID_RESPONSABLE = '"+ idEmpe + "' OR ID_RESPONS_RESP = '"+ idEmpe +"' ) ");
						
						
						if (dataManager != null)
						{
						
							if (dataManager.size() == 0)
							{
								//No manager
								helperXml.addXmlItem("esmanager",z, "0" , helperXml.XML_NORMAL); //0 = no , 1 = si
							}
							else
							{
								//Is Manager
								helperXml.addXmlItem("esmanager",z, "1" , helperXml.XML_NORMAL); //0 = no , 1 = si
							}
						}
						else
						{
							// NO manager
							helperXml.addXmlItem("esmanager",z, "0" , helperXml.XML_NORMAL); //0 = no , 1 = si
						}
						
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
										tiinova_backend_tools tool = new tiinova_backend_tools();
										PathFoto = tool.readRemoteFilesToLocal(PathFoto,Session.SerialKeyMainReturnApps, false); //Get Remote File to Local temp File
										
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
							addLog("GetListaEmpleados (Image) : " + ee.getMessage(), ParamsApp.LOG_TYPE_ERROR);
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
				helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
				XML = helperXml.getValues(); 
				addLog("GetListaEmpleados : "+e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
				
			}
			finally
			{
				helperXml.Dispose();
				helperXml = null;
				apply=null;
			
			}
			
			return XML;
		}
		
		// the IdSociedadMeta4 allways is Void. Sociedad is into IdEmpleadoMeta4
		// example: soc: 01 , idemployee: 00004. Comes from device IdEmpleadoMeta4= 0100004
	public String GetFichaEmpleado(logonCredencialProcess Session, String IdEmpleadoMeta4, String IdSociedadMeta4)
		{
				String Dev = "";
				
				try{
					String FiltroId = "ID_SOCIEDAD = '" +  backendToolsTiinova.getSociedadRealOfIdEmployeeComp(IdEmpleadoMeta4) + "' AND ID_EMPLEADO = '" + backendToolsTiinova.getIdEmployeeRealOfIdEmployeeComp(IdEmpleadoMeta4) + "'";
					
					Dev= this.GetListaEmpleados(Session, FiltroId, 0);
				}
				catch(Exception e)
				{
					Dev = new XmlHelper().getErrorValues(Session.SerialKeyMainReturnApps); //Error
				}
				finally{
				}
				return Dev;
		}
			

	
	//Send file from Device.
	@SuppressWarnings("rawtypes")
	public int sendFileRh(logonCredencialProcess Session, String fileBase64, String extension, String IdHr, String tpFile, String commentsEmployee) throws Exception
	{
			
				hb_main_tinnova tinnova = null;
				Map row =null;
				tiinova_backend_tools toolsTinnova;
				sendMailAsync xmail ;
				
				try{
					String sociedad = backendToolsTiinova.getSociedadRealOfIdEmployeeComp(IdHr);
					String idEmpleado = backendToolsTiinova.getIdEmployeeRealOfIdEmployeeComp(IdHr);
					String Status = "PENDIENTE";//default status
					int Ordinal = 0;
					
					//calcl Ordinal
					String SqlOrdinal = "SELECT MAX(CSP_ORDINAL) as NUM FROM EQ_MBL_RH_DOCS WHERE ID_SOCIEDAD = '"+ sociedad +"' AND ID_EMPLEADO = '"+ idEmpleado +"'";
					String dataOrdinal = backendToolsTiinova.getDBValueSql(SqlOrdinal, "NUM");
					if (dataOrdinal.equals("")) {
						Ordinal = 1;
					}
					else {
						Ordinal = Integer.parseInt(dataOrdinal) + 1;
					}
					
					//Validator document. By type of document and Send a Email
					String EmpleadoValidador = "";
					String mailValidador = "";
					String NameTypeDoc = "";
					
					String SQLValidadorDoc = "SELECT NOMBRE, ID_EMPLEADO, MAIL_NOTIF FROM EQ_MBL_TP_DOCS WHERE ID_SOCIEDAD = '" + sociedad + "' AND ID_TP_DOC = '" + tpFile + "'";
					List<?> data  = this.getDataSQLNativo(SQLValidadorDoc);
					
					if (data.size() != 0 && data != null) {
						row = (Map)data.get(0); //only one record
						EmpleadoValidador = row.get("ID_EMPLEADO").toString();
						mailValidador = row.get("MAIL_NOTIF").toString();
						NameTypeDoc = row.get("NOMBRE").toString();
					}
	
					tinnova = new hb_main_tinnova();
					
					//create the hibernate command Insert
					String SqlInsert = "INSERT INTO EQ_MBL_RH_DOCS   (ID_SOCIEDAD, ID_EMPLEADO, CSP_ORDINAL ,FECHA_ENVIO_APP ,ID_TP_DOC ,FILE_S ,FILE_EXT ,ID_EMPLEADO_VAL ,STATUS ,DESCRIPCION ,COMMENT_EMPLOYEE ,COMMENT_MANAGER) ";
					SqlInsert += "VALUES (:sociedad, :empleado, :ordinal, :fechaenvio, :tpdoc, :file, :ext, :idempleval, :status, :descrip, :commenEmployee, :commentManager)";
					
					SQLQuery query  = tinnova.getSqlQuery(SqlInsert);
					query.setParameter("sociedad", sociedad);
					query.setParameter("empleado", idEmpleado);
					query.setParameter("ordinal", Ordinal);
					
					Calendar cal = Calendar.getInstance(); 
					java.sql.Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
					
					query.setTimestamp("fechaenvio", timestamp);
					query.setParameter("tpdoc", tpFile);
					query.setParameter("file", fileBase64);
					query.setParameter("ext", extension);
					query.setParameter("idempleval", EmpleadoValidador);
					query.setParameter("status", Status);
					query.setParameter("descrip", "");
					query.setParameter("commenEmployee", commentsEmployee);
					query.setParameter("commentManager", "");
	
					int dev = tinnova.executeSqlAdvance(query); //execute the insert
					
					if (dev == 0) {
						
						toolsTinnova = new tiinova_backend_tools();
					
						//if execution of Save in DataBase the document is OK, send a Email.
	
						String Subject = toolsTinnova.getValueParams(sociedad, "DOCS_MAIL_SUBJECT");
						String nameEmployee = toolsTinnova.getNameOfEmployee(sociedad, idEmpleado) ;
						String body = "El empleado " + nameEmployee + " ha enviado un documento de tipo " + NameTypeDoc + " que debe validar.\n\n Portal Mobile";  ;
						
						xmail  = new sendMailAsync();
						xmail.setMailData(mailValidador, Subject, body);
						xmail.start();
						//mail.sendMail(mailValidador, Subject, body);
						return 0;
					}
					else {
						return -1;
					}
				}
				catch(Exception e){
					addLog(e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
					return -1;
				}
				finally{
					if (tinnova != null) {tinnova.Dispose(); }
					tinnova = null;
					row = null;
					xmail = null;
				}
	}

	//Return list od documents
	@SuppressWarnings("rawtypes")
	public String getESSListDocsSendType(logonCredencialProcess Session ) throws Exception{

		
		//control session (si las credenciales erronas, devolvemos error -1)
		if (Session==null) {return "";}
		XmlHelper helperXml = new XmlHelper();
		String XML="";
		Map row =null;
		
		try{
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
			//code meta4
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
		
			String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
			String Sql = "SELECT  ID_SOCIEDAD, ID_TP_DOC, NOMBRE FROM EQ_MBL_TP_DOCS WHERE ID_SOCIEDAD = '"+ sociedad+"'";
			
			List<?> data  = this.getDataSQLNativo(Sql);
			
			//XML: num registros. 
			helperXml.addXmlItem("Records", String.valueOf(data.size()), helperXml.XML_NORMAL);
			
			for (int i= 0; i< data.size(); i++) {
				row = (Map)data.get(i); //The row extract
				helperXml.addXmlItem("id" , i,row.get("ID_TP_DOC").toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("name" , i, row.get("NOMBRE").toString(), helperXml.XML_NORMAL);
			}
		
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues(); 
				}
		catch(Exception e)
		{
			helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			XML = helperXml.getValues(); 
			addLog("getESSListDocsSendType : " + e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
		}
		finally
		{
			if (helperXml!=null) {helperXml.Dispose();}
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
