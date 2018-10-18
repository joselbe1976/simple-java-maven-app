/*
 * --------------------------------------------------------------------------------------------
 * . Jose Luis BUstos Esteban
 * --------------------------------------------------------------------------------------------
 * Esta clase gestional el Meta4object de Meta4 - CSP_MBL_SOAP_EMPLEADOS
 * Para la lista de empleados, Ficha y Lista lugares de trabajo
 * --------------------------------------------------------------------------------------------
*/

package com.portalmobile.meta4.funcional;



import java.util.HashMap;
import java.util.Map;

import javax.activation.DataHandler;
import javax.xml.rpc.Stub;

import org.apache.axis.attachments.ManagedMemoryDataSource;

import com.common.config.ParamsApp;
import com.common.globalSystems.paramsSystem;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.pushnotifications.Parse.parseOperations;
import com.common.tools.cache.documentsCache;
import com.common.tools.encript.Base64Tools;
import com.common.tools.xml.XmlHelper;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosServiceService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosServiceServiceLocator;
import com.portalmobile.meta4.schemas.types.Csp_Add_AbsentismoOutput;
import com.portalmobile.meta4.schemas.types.Csp_Add_FavoritoOutput;
import com.portalmobile.meta4.schemas.types.Csp_Del_FavoritoOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_WlocOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_Wloc_ResulBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_Wloc_ResulRecord;
import com.portalmobile.meta4.schemas.types.Csp_Get_Lista_EmpleOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulRecord;
import com.portalmobile.meta4.schemas.types.Ess_Get_Lista_EmpleOutput;


public class Meta4Object_empleados {
	ParamsApp IntParams = new ParamsApp(); //Clase de parametros y funciones especiales
	Base64Tools Base64 = new Base64Tools();
	
	private boolean SYSTEM_CACHE_FOTOS =true; //cacheo de fotos
	
	//constructor
	public Meta4Object_empleados()
	{
		SYSTEM_CACHE_FOTOS =true;
	}
	
	public Meta4Object_empleados(boolean cacheFotos)
	{
		SYSTEM_CACHE_FOTOS =cacheFotos;
	}
	
	public void setCacheFotos(boolean value)
	{
		SYSTEM_CACHE_FOTOS = value;
	}
	
	//lista lugares de trabajo. Devuelve XML. EL NOMBRE va decode base 64. Y FILTERS VIENE en base64
	public String GetListaLugaresTrabajo(logonCredencialProcess Session, String Base64Filters, double PaginaDatos) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}

		//Decodificacion
		String Filters = Base64.decode_string(Base64Filters);
		
		
		@SuppressWarnings("unused")
		String dev = "";
		
		@SuppressWarnings("unused")
		Double DevMetodo=0.00;
		
		@SuppressWarnings("unused")
		String ResultSerial="";
		
		String XML="";
		@SuppressWarnings("unused")
		String result="";
		javax.xml.rpc.Stub oStub = null;	
		try{
		
			Csp_Mbl_Soap_EmpleadosServiceService  Sfactory = new Csp_Mbl_Soap_EmpleadosServiceServiceLocator();
			Csp_Mbl_Soap_EmpleadosService Meta4Object = Sfactory.getCSP_MBL_SOAP_EMPLEADOS();
			Csp_Get_List_WlocOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			
			//ejecutamos el m�todo
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
			SalidaExec =	 Meta4Object.CSP_GET_LIST_WLOC(PaginaDatos, Filters); //ejecutamos metodo en Meta4
			DevMetodo = SalidaExec.get_return();
			
			
			//cargamos el Bloque de registros
			Csp_Get_List_Wloc_ResulBlock Bloque = SalidaExec.getCsp_Get_List_Wloc_Resul();
			//Montamos el recordset
			Csp_Get_List_Wloc_ResulRecord Rec[] =  Bloque.getCsp_Get_List_Wloc_ResulRecordSet();
			
			
			
			
			//Pila de errores
		
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
			//code meta4
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			
			//Resultado Operacion metodo
			helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
			//XML: num registros. 
			helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
		
			//Recorrmeos los registros
			
			@SuppressWarnings("unused")
			String ExtensionFile = "";
			
			for (int z = 0;z<Rec.length;z++)
			{
				ExtensionFile="";
				helperXml.addXmlItem("id_"+z, Rec[z].getId_Work_Loc().toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("nombre_"+z, Base64.encode_string(Rec[z].getNombre().toString()), helperXml.XML_NORMAL);
				
			} //del for

			helperXml.addXmlItem("object1", "object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues();
			
		}
		catch(Exception e)
		{
			IntParams.debugInfo("                - Error al ejecutar GetListaLugaresTrabajo. : " + e.getMessage());
			dev = "";
		}
		finally
		{
			helperXml = null;
		}

		return XML;
		
	}
				

	

	// LIsta de empleados. Devuelve XML
	public String GetListaEmpleados(logonCredencialProcess Session, String Base64Filters,double PaginaDatos) throws Exception
	{
		XmlHelper helperXml = new XmlHelper();
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}
		
		
		//Decodificacion
		String Filters =Base64Filters;
		
		
		IntParams.debugInfo("Metodo: GetListaEmpleados");
		IntParams.debugInfo(" .Filtro: " + Filters);
		IntParams.debugInfo(" .Página de datos  : " + PaginaDatos);
		

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
			
		
			Csp_Mbl_Soap_EmpleadosServiceService  Sfactory = new Csp_Mbl_Soap_EmpleadosServiceServiceLocator();
			Csp_Mbl_Soap_EmpleadosService Meta4Object = Sfactory.getCSP_MBL_SOAP_EMPLEADOS();
			Ess_Get_Lista_EmpleOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			
			//ejecutamos el m�todo
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
			SalidaExec =	 Meta4Object.ESS_GET_LISTA_EMPLE(PaginaDatos, Filters, numRegGetMeta4); //ejecutamos metodo en Meta4
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
			
			//verificamos si se pernite el envio de imagenes
			apply = new paramsSystem();
			//String SendImg = apply.getParamValue(2, Session.SerialKeyForIdProcess, this.getClass().getSimpleName()); //el proceso siempre el nombre de la clase 
					
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
				helperXml.addXmlItem("idfoto" , z,fileCache, helperXml.XML_NORMAL);
				helperXml.addXmlItem("sociedad" , z,sociedad, helperXml.XML_NORMAL);
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
				
				if (ParamsApp.SYSTEM_CACHE_LEVEL == 2){
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
	
	// Ficha del Empleado. Devuelve XML.
	public String GetFichaEmpleado(logonCredencialProcess Session, String IdEmpleadoMeta4)
	{
			String Dev = "";
			
			try{
				String FiltroId = "{ID_EMPLEADO}={"+IdEmpleadoMeta4+"}";
				Dev= this.GetListaEmpleados(Session, FiltroId, 0);
			}
			catch(Exception e)
			{
				Dev = new XmlHelper().getErrorValues(Session.SerialKeyMainReturnApps); //cadena de error
			}
			finally{
			}
			return Dev;
	}
		
		
	//A�adir un empleado como favorito
	public double AddFavoriteRH(logonCredencialProcess Session,String IdHrFav)
	{
		
		IntParams.debugInfo("Metodo: AddFavoriteRH");
		IntParams.debugInfo(" .Empleado a�adir: " + IdHrFav);
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return -1;}

		
		Double DevMetodo=0.00;
		
		javax.xml.rpc.Stub oStub = null;	
		
		try{
				Csp_Mbl_Soap_EmpleadosServiceService  Sfactory = new Csp_Mbl_Soap_EmpleadosServiceServiceLocator();
				Csp_Mbl_Soap_EmpleadosService Meta4Object = Sfactory.getCSP_MBL_SOAP_EMPLEADOS();
				Csp_Add_FavoritoOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.CSP_ADD_FAVORITO(IdHrFav); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
		}
		catch(Exception e)
		{
			IntParams.debugInfo("ERROR: al ejecutar el metodo AddFavoriteRh");
			return -1;
		}
		finally
		{
			
		}
		
		return DevMetodo;
	}

	//A�adir un empleado como favorito
		public double DelFavoriteRH(logonCredencialProcess Session,String IdHrFav)
		{
			
			IntParams.debugInfo("Metodo: DelFavoriteRH");
			IntParams.debugInfo(" .Empleado a�adir: " + IdHrFav);
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return -1;}

			
			
			Double DevMetodo=0.00;
			
			javax.xml.rpc.Stub oStub = null;	
			
			try{
					Csp_Mbl_Soap_EmpleadosServiceService  Sfactory = new Csp_Mbl_Soap_EmpleadosServiceServiceLocator();
					Csp_Mbl_Soap_EmpleadosService Meta4Object = Sfactory.getCSP_MBL_SOAP_EMPLEADOS();
					Csp_Del_FavoritoOutput  SalidaExec;
					
					//mantenemos la session proy
					oStub = (javax.xml.rpc.Stub)Meta4Object;
					oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
					
					//ejecutamos el m�todo
					Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
					SalidaExec =	 Meta4Object.CSP_DEL_FAVORITO(IdHrFav); //ejecutamos metodo en Meta4
					DevMetodo = SalidaExec.get_return();
					
			}
			catch(Exception e)
			{
				IntParams.debugInfo("ERROR: al ejecutar el metodo DelFavoriteRh");
				return -1;
			}
			finally
			{
				
			}
			
			return DevMetodo;
		}


		
		//A�adir UN ABSETISMO al empleado
		public double AddAbsentismoEmpleado(logonCredencialProcess Session,String IdHr,String periodo, String fechaIni, String fechaFin, String idIncidence,String Comentario)
		{
			
			IntParams.debugInfo("Metodo: AddAbsentismoEmpleado");
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return -1;}

			Double DevMetodo=0.00;
			
			javax.xml.rpc.Stub oStub = null;	
			
			//DatesTools toolDate = new DatesTools();
			parseOperations parse = new parseOperations();
			
			try{
				//PUSHY Push notification. Ojo faltaria que solo se emita si es un dispositivo 
				parse.sendPushNotification("Solicitado el absentismos del empleado "+IdHr, Session.getData(Session.getPosDefaultSystem()).user, "");
				
				
				//Sistema Meta4
				
					Csp_Mbl_Soap_EmpleadosServiceService  Sfactory = new Csp_Mbl_Soap_EmpleadosServiceServiceLocator();
					Csp_Mbl_Soap_EmpleadosService Meta4Object = Sfactory.getCSP_MBL_SOAP_EMPLEADOS();
					Csp_Add_AbsentismoOutput SalidaExec;
					
					//mantenemos la session proy
					oStub = (javax.xml.rpc.Stub)Meta4Object;
					oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
					
					//ejecutamos el m�todo
					Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion

					SalidaExec =	 Meta4Object.CSP_ADD_ABSENTISMO(IdHr, fechaIni,fechaFin,idIncidence, Comentario,periodo); //ejecutamos metodo en Meta4
					
					
					
					DevMetodo = SalidaExec.get_return();
			}
			catch(Exception e)
			{
			System.out.print("\nError al aÑadir absentismo:"+ e.getMessage());
				return -1;
			}
			finally
			{
				//toolDate = null;
				parse = null;
			}
			
			return DevMetodo;
		}
		
		
}
