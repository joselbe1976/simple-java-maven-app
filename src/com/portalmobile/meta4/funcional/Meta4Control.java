/*
 * --------------------------------------------------------------------------------------------
 * Jose Luis Bustos Esteban
 * --------------------------------------------------------------------------------------------
 * Esta clase gestional el Meta4object de Meta4 - CSP_MBL_SOAP_TOOLS
 * Esta clase se encarga del Login, COntrol expiracion session, autologin, Parametros
 * Modulo Meta4, Control acceso (horario, dia semana etc), Informacion usuario conectado
 * --------------------------------------------------------------------------------------------
*/
package com.portalmobile.meta4.funcional;
import java.util.List;

import javax.activation.DataHandler;
import javax.xml.rpc.Stub;

import org.apache.axis.attachments.ManagedMemoryDataSource;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.hb_notifications;
import com.common.hibernate.entidades.VinNotifications;
import com.common.tools.DatesTools;
import com.common.tools.cache.documentsCache;
import com.common.tools.encript.Base64Tools;
import com.common.tools.xml.XmlHelper;
import com.portalmobile.meta4.schemas.*;
import com.portalmobile.meta4.schemas.types.Csp_Delete_FileOutput;
import com.portalmobile.meta4.schemas.types.Csp_Delete_NotificationOutput;
import com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_File_RealOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserRecord;
import com.portalmobile.meta4.schemas.types.Csp_Get_Info_UserOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_Info_User_OutBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_Menus_DispositivoOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutRecord;
import com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_UserOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_User_OutBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_User_OutRecord;
import com.portalmobile.meta4.schemas.types.Csp_Save_File_RecibidoOutput;
import com.portalmobile.meta4.schemas.types.Csp_Save_Notificatoin_RecibidoOutput;


public class Meta4Control {

	 private boolean SYSTEM_CACHE_FOTOS =true; //cacheo de fotos
	 Base64Tools Base64 = new Base64Tools();
	 ParamsApp IntParams ;
	 
	 //constructor
	 public Meta4Control()
	 {
		 new ParamsApp();
		 IntParams = new ParamsApp();
	 }
	 public void setCacheFotos(boolean value)
		{
			SYSTEM_CACHE_FOTOS = value;
		}
	// --------------------------------------------------------------------------------
	// Metodo Echo Session. 
	// --------------------------------------------------------------------------------
	public int EchoSession(logonCredencialProcess Session){
		
	//control session (si las credenciales erronas, devolvemos vacio)
	if (Session==null) {return -1;}

	int dev = 0;
	javax.xml.rpc.Stub oStub = null;	
	try{
	
		Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
		Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
		Csp_Echo_SessionOutput  SalidaExec;
		
		//mantenemos la session proy
		oStub = (javax.xml.rpc.Stub)Meta4Object;
		oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
		Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
		SalidaExec =	 Meta4Object.CSP_ECHO_SESSION(); //ejecutamos metodo
		dev = 0;//OK
		
	}
	catch(Exception e)
	{
		IntParams.debugInfo("ERROR: al ejecutar Echo. Seguro que es timeout: " + e.getMessage());
		dev = -1; //Error
	}
	finally
	{
	}
	
	return dev; //devolvemos el valor
}

	
	

	
	
	// --------------------------------------------------------------------------------
	//Informacion del usuario conectado
	// --------------------------------------------------------------------------------
	public String GetInfoConectedUser(logonCredencialProcess Session)
	{
			XmlHelper helperXml =  new XmlHelper();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}

				
			IntParams.debugInfo("Metodo: GetInfoConectedUser");
			
		
			@SuppressWarnings("unused") String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			DataHandler attachmentEcho;
			//@SuppressWarnings("unused") String XML="";
			String fichero="";
			String result="";
			javax.xml.rpc.Stub oStub = null;	
			String XML = "";
			try{
			
				Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
				Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
				Csp_Get_Info_UserOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				
				
				
				//ejecutamos el método
				System.out.println("\n\n recuperamos sesion del app server: " + Session.SerialKeyForIdProcess);
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				
				System.out.println("\n\n Antes ejecutar metodo soap");
				SalidaExec =	 Meta4Object.CSP_GET_INFO_USER(); //ejecutamos informacion usuario conectado 
				DevMetodo = SalidaExec.get_return();
				
				System.out.println("\n\n Despues Ejecutar metodo soap");
				
				Csp_Get_Info_User_OutBlock Bloque = SalidaExec.getCsp_Get_Info_User_Out();
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				//product version
				helperXml.addXmlItem("productversion", new ParamsApp().SYSTEM_PRODUCT_VERSION.toString(), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros.  SOlo uno porque son propiedades de tipo NODO
				helperXml.addXmlItem("Records", "1", helperXml.XML_NO_USAR_CDATA);
				
			
				String sociedad = Bloque.getCsp_General_4();
				String idFile = sociedad + "_" +  Bloque.getCsp_Nif().toString();
				
				//NO RECORREMOS REGISTROS PORQUE SON PROPIEDADES DE AMBITO NODO EN META4
				helperXml.addXmlItem("idempleado",Bloque.getCsp_Identificador().toString() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("sociedad",sociedad , helperXml.XML_NORMAL); //compatibilidad con Tinnova
				helperXml.addXmlItem("idfoto",idFile , helperXml.XML_NORMAL);	//id de la foto
				
				helperXml.addXmlItem("nombre",Bloque.getCsp_Nombre().toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("nif", Bloque.getCsp_Nif().toString() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("esmanager", Bloque.getCsp_General_5().toString() , helperXml.XML_NORMAL); //indica con 1/0 si es manager
				helperXml.addXmlItem("puesto",Bloque.getCsp_General_1().toString()  , helperXml.XML_NORMAL);
				helperXml.addXmlItem("pushnotif",Bloque.getCsp_General_2().toString()  , helperXml.XML_NORMAL);
				helperXml.addXmlItem("pushfile",Bloque.getCsp_General_3().toString()  , helperXml.XML_NORMAL);
				
					//foto socieda + NIF
					try{
						
						String FileCacheImagen = new documentsCache().getCacheFileListImage(idFile);
						
						if (FileCacheImagen.equals(""))
						{
							//no cacheada		
							
							
								//componemos la imagen para cache (NIF)
								String fileCache = idFile;
								String ExtensionFile = "";
							
								 //vemos el tipo de archivo que viene
								String MimeType = Bloque.getCsp_Photo().getContentType().toString();
								 fichero = new ParamsApp().GetFichTemporal(Session.SerialKeyForIdProcess,MimeType); //me crea el nombre de un fichero y ruta temporal de ese tipo
								 
								//fichero adjunto
								attachmentEcho = Bloque.getCsp_Photo();
								
								
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
									
									helperXml.addXmlItem("foto",""  , helperXml.XML_NORMAL);
										
									mmds.delete();
								}
								else  //no se puede abrir.
								{
									helperXml.addXmlItem("foto","" , helperXml.XML_NORMAL);
								}
						}
						else
						{
							helperXml.addXmlItem("foto",""  , helperXml.XML_NORMAL);
						}
					}
					catch(Exception ee)  //lectura de la imagen
					{
						helperXml.addXmlItem("foto","" , helperXml.XML_NORMAL);
					}
					finally
					{
						//elimino el fichero generado
						IntParams.DeleteFich(fichero);
						
						helperXml.addXmlItem("object2","object" , helperXml.XML_SOLO_CERRAR_XML);
						XML = helperXml.getValues();
					}
		
				
			}
			catch(Exception e)
			{
				IntParams.debugInfo("ERROR: al ejecutar GETINFOUSERAPP. : " + e.getMessage());
				return helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			}
			finally
			{
			}
			
	return XML;
}

	
	
	// --------------------------------------------------------------------------------
	//Devuelve los menus a mostrar en dispositvo con imagenes etc.
	// --------------------------------------------------------------------------------
	public String GetMenusApp(logonCredencialProcess Session,String Dispositivo){
		

		XmlHelper helperXml = new XmlHelper();
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}

	
		@SuppressWarnings("unused") Double DevMetodo=0.00;
	
		DataHandler attachmentEcho;
		String XML="";
		String fichero="";
		String result="";
		javax.xml.rpc.Stub oStub = null;	
		try{
		
			Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
			Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
			Csp_Get_Menus_DispositivoOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			
			//ejecutamos el m�todo
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
			SalidaExec =	 Meta4Object.CSP_GET_MENUS_DISPOSITIVO(Dispositivo); //ejecutamos menu desde meta 
			DevMetodo = SalidaExec.get_return();
			
			
			//cargamos el Bloque de registros
			Csp_Get_Menus_Dispositivo_OutBlock Bloque = SalidaExec.getCsp_Get_Menus_Dispositivo_Out();
			//Montamos el recordset
			Csp_Get_Menus_Dispositivo_OutRecord Rec[] =  Bloque.getCsp_Get_Menus_Dispositivo_OutRecordSet();
			
			
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
			//@SuppressWarnings("unused") String ExtensionFile = "";
			
			for (int z = 0;z<Rec.length;z++)
			{
				helperXml.addXmlItem("id",z, Rec[z].getId_Menu().toString() , helperXml.XML_NORMAL);
				helperXml.addXmlItem("nombre",z, Rec[z].getNombre().toString(), helperXml.XML_NORMAL);
				
				try{
				
					 //vemos el tipo de archivo que viene
					String MimeType = Rec[z].getImagen_Menu().getContentType().toString();
					    fichero = new ParamsApp().GetFichTemporal(Session.SerialKeyForIdProcess,MimeType); //me crea el nombre de un fichero y ruta temporal de ese tipo
					 
					//fichero adjunto
					attachmentEcho = Rec[z].getImagen_Menu();
					
					
					ManagedMemoryDataSource mmds = (ManagedMemoryDataSource)attachmentEcho.getDataSource(); 
					result="";
					if (mmds != null)
					{
						//creamos el fichero en Local para despues leerlo.
						IntParams.CrearImagenMeta4enLocal(mmds, fichero);
						
						//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
						result = IntParams.getValueFileBase64Encode(fichero, MimeType);
						helperXml.addXmlItem("foto",z, result, helperXml.XML_NORMAL);
						mmds.delete();
					}
					else  //no se puede abrir.
					{
						helperXml.addXmlItem("foto",z, "", helperXml.XML_NORMAL);
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
			} //del for
	
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues();		
		
		}
		catch(Exception e)
		{
			IntParams.debugInfo("ERROR: al ejecutar GetMenus. : " + e.getMessage());
			return "";
		}
		finally
		{
			//IntParams.debugInfo("                <---- Fin ejecucion Cotrol accesos Devolucion funcion: " + dev + "  . Resultado Metodo: " + DevMetodo + "----->");
		}
	
	return XML;
}
	

	// -------------------------------------------------------------
	// ------- METODOS DE FICHEROS USUARIO  ------------------
	// -------------------------------------------------------------

	// --------------------------------------------------------------------------------
	//Devuelve el Archivo REAL de un usuario. (Solo el file)
	// --------------------------------------------------------------------------------
	public String GetRealFileUser(logonCredencialProcess Session, double OrdFile)
	{
		
		IntParams.debugInfo("Metodo: GetRealFileUser");
		IntParams.debugInfo("  .OrdFile:" +  OrdFile);
		XmlHelper helperXml = new XmlHelper();
		
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}


		String XML = "";
		String result="";
		String fichero="";
		@SuppressWarnings("unused") double DevMetodo=0.0;
		
		javax.xml.rpc.Stub oStub = null;	
		
		try{
		
			DataHandler attachmentEcho; //para el File
			
			Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
			Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
			Csp_Get_File_RealOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			
			//ejecutamos el m�todo
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion  
			SalidaExec =	 Meta4Object.CSP_GET_FILE_REAL(OrdFile); //ejecutamos el metodoControl accesso
			DevMetodo = SalidaExec.get_return();

			//cargamos el Bloque de registros. OJO no hace falta recordser porque son propiedades de ambito nodo
			Csp_Get_File_Real_OutBlock Bloque = SalidaExec.getCsp_Get_File_Real_Out();
			
			
			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
			//code meta4
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			
			//Resultado Operacion metodo
			helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
			//XML: num registros.  
			helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);
			
			//Extension del archivo descargado.
			helperXml.addXmlItem("extension", Bloque.getCsp_Extension().toString(), helperXml.XML_NORMAL);
			
			//ordinal
			helperXml.addXmlItem("ordinal", Bloque.getOrdinal().toString(), helperXml.XML_NORMAL);
			
			//el propio archivo
			
			
			try{
			
				//Creamos ruta fichero temporal
				fichero = new ParamsApp().GetFichTemporalExtension(Session.SerialKeyForIdProcess,Bloque.getCsp_Extension().toString()); //me crea el nombre de un fichero y ruta temporal de ese tipo
				 
				//fichero adjunto
				attachmentEcho = Bloque.getCsp_File();
				
				
				ManagedMemoryDataSource mmds = (ManagedMemoryDataSource)attachmentEcho.getDataSource(); 
				result="";
				
				if (mmds != null)
				{
					//creamos el fichero en Local para despues leerlo.
					IntParams.CrearImagenMeta4enLocal(mmds, fichero);
					
					//Abrimos el fichero y pasamos su contecnidoa a cadena y Encode Base64 para enviar por XML
					//CUIDADO al leer PDF hay que pasarlo a base64 siempre en array nunca en String. 
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
			XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			helperXml = null;
		}
		finally
		{
		}
		
		return XML;

	}
	
	
	
	// --------------------------------------------------------------------------------
	//Elimina un Archivo de usuario
	// --------------------------------------------------------------------------------
	public String DeleteFileUser(logonCredencialProcess Session, double OrdFile)
	{
		
		IntParams.debugInfo("Metodo : DeleteFileUser");
		IntParams.debugInfo(" .OrdFile: " +  OrdFile);
		XmlHelper helperXml = new XmlHelper();

		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}

		String XML = "";
		@SuppressWarnings("unused") double DevMetodo=0.0;
		javax.xml.rpc.Stub oStub = null;	
		try{
		
			Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
			Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
			Csp_Delete_FileOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			
			//ejecutamos el m�todo
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion  
			SalidaExec =	 Meta4Object.CSP_DELETE_FILE(OrdFile); //ejecutamos el metodoControl accesso
			DevMetodo = SalidaExec.get_return();

			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
			//code meta4
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			
			//Resultado Operacion metodo
			helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
			//XML: num registros.  
			helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);
			
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues();	
			
			
		}
		catch(Exception e)
		{
			XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			helperXml = null;
		}
		finally
		{
		}
		
		return XML;

	}
	
	
		// --------------------------------------------------------------------------------
		//Guarda en meta4 el archivo como leido
		// --------------------------------------------------------------------------------
		public String SaveFileUserRead(logonCredencialProcess Session, double OrdFile)
		{
			
			IntParams.debugInfo("Metodo : SaveFileUserRead");
			IntParams.debugInfo(" .OrdFile: " +  OrdFile);
			XmlHelper helperXml = new XmlHelper();
			
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}

			String XML = "";
			@SuppressWarnings("unused") double DevMetodo=0.0;
			javax.xml.rpc.Stub oStub = null;	
			try{
			
				Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
				Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
				Csp_Save_File_RecibidoOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion  
				SalidaExec =	 Meta4Object.CSP_SAVE_FILE_RECIBIDO(OrdFile); //ejecutamos el metodoControl accesso
				DevMetodo = SalidaExec.get_return();

				
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros.  
				helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);
				
				helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
				XML = helperXml.getValues();	
				
				
			}
			catch(Exception e)
			{
				XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
				helperXml=null;
			}
			finally
			{
			}
			
			return XML;

		}	
		
		
		// --------------------------------------------------------------------------------
		//Devuelve la lista de Archivos del usuario
		// --------------------------------------------------------------------------------
		public String GetFilesUserMeta4(logonCredencialProcess Session, double OrdFile){
			
			
			IntParams.debugInfo("Metodo : GetFilesUserMeta4");
			IntParams.debugInfo(" .OrdFile: " +  OrdFile);
			XmlHelper helperXml = new XmlHelper();		
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}

		String XML = "";
		@SuppressWarnings("unused") double DevMetodo=0.0;
		javax.xml.rpc.Stub oStub = null;	
		try{
		
			Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
			Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
			Csp_Get_Files_UserOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			
			//ejecutamos el m�todo
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
			SalidaExec =	 Meta4Object.CSP_GET_FILES_USER(OrdFile); //ejecutamos el metodoControl accesso
			DevMetodo = SalidaExec.get_return();

			//cargamos el Bloque de registros
			Csp_Get_Files_UserBlock Bloque = SalidaExec.getCsp_Get_Files_User();
			//Montamos el recordset
			Csp_Get_Files_UserRecord Rec[] =  Bloque.getCsp_Get_Files_UserRecordSet();
			
			
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
				helperXml.addXmlItem("recibido",z,Rec[z].getCsp_Chk_Recibido().toString(), helperXml.XML_NORMAL);	
				helperXml.addXmlItem("descripcion",z,Rec[z].getCsp_Descripcion().toString(), helperXml.XML_NORMAL);	
				helperXml.addXmlItem("ext",z,Rec[z].getCsp_File_Ext().toString(), helperXml.XML_NORMAL);	
				helperXml.addXmlItem("mensaje",z,Rec[z].getCsp_Mensaje().toString(), helperXml.XML_NORMAL);	
				helperXml.addXmlItem("ordinal",z,Rec[z].getCsp_Ordinal().toString(), helperXml.XML_NORMAL);	
				helperXml.addXmlItem("fenvio",z,Rec[z].getCsp_Fecha_Envio().toString(), helperXml.XML_NORMAL);	
			}
			
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues();			
		}
		catch(Exception e)
		{
			XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			helperXml = null;
		}
		finally
		{
		}
		
		return XML;
	}
		
	
// -------------------------------------------------------------
// ------- METODOS DE NOTIFICACIONES USUARIO ------------------
// -------------------------------------------------------------


	// --------------------------------------------------------------------------------
	//Elimina una notificacion
	// --------------------------------------------------------------------------------
	public String DeleteNotificacion(logonCredencialProcess Session, double OrdNotificacion)
	{
		
		IntParams.debugInfo("Metodo : DeleteNotificacion");
		IntParams.debugInfo(" .OrdNotificacion: " +  OrdNotificacion);
		XmlHelper helperXml = new XmlHelper();	
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}


		String XML = "";
		@SuppressWarnings("unused") double DevMetodo=0.0;
		javax.xml.rpc.Stub oStub = null;	
		try{
		
			Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
			Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
			Csp_Delete_NotificationOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			
			//ejecutamos el m�todo
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion  OrdNotificacion
			SalidaExec =	 Meta4Object.CSP_DELETE_NOTIFICATION(OrdNotificacion); //ejecutamos el metodoControl accesso
			DevMetodo = SalidaExec.get_return();

			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
			//code meta4
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			
			//Resultado Operacion metodo
			helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
			//XML: num registros.  
			helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);
			
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues();	
		}
		catch(Exception e)
		{
			XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			helperXml = null;
		}
		finally
		{
		}
		
		return XML;

	}
	
	
	// --------------------------------------------------------------------------------
	//Guarda en Meta4 una notificacion como Leida
	// --------------------------------------------------------------------------------
	public String SaveNotificacionLeido(logonCredencialProcess Session, double OrdNotificacion)
	{
		
		IntParams.debugInfo("Metodo : SaveNotificacionLeido");
		IntParams.debugInfo(" .OrdNotificacion: " +  OrdNotificacion);
		XmlHelper helperXml = new XmlHelper();	

		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}

		String XML = "";
		@SuppressWarnings("unused") double DevMetodo=0.0;
		javax.xml.rpc.Stub oStub = null;	
		try{
		
			Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
			Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
			Csp_Save_Notificatoin_RecibidoOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			
			//ejecutamos el m�todo
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion  OrdNotificacion
			SalidaExec =	 Meta4Object.CSP_SAVE_NOTIFICATOIN_RECIBIDO(OrdNotificacion); //ejecutamos el metodoControl accesso
			DevMetodo = SalidaExec.get_return();

			
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
			//code meta4
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			
			//Resultado Operacion metodo
			helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
			//XML: num registros.  
			helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);	
			
			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
			XML = helperXml.getValues();	
			
		}
		catch(Exception e)
		{
			XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			helperXml = null;
		}
		finally
		{
		}
		
		return XML;

	}
	
	
	// --------------------------------------------------------------------------------
	//Devuelve la lista de notificaciones del empleado. INTEGRADO CON LOCAL
	// Devolvemos las notificaciones Meta4 y las notificaciones Local (las integramos)
	// --------------------------------------------------------------------------------
	public String GetNotificationsUserMeta4(logonCredencialProcess Session, double MaxNotificacionDispositivo){
		
		IntParams.debugInfo("Metodo : GetNotificationsUserMeta4");
		XmlHelper helperXml = new XmlHelper();	
	
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}

	String XML = "";
	@SuppressWarnings("unused") double DevMetodo=0.0;
	javax.xml.rpc.Stub oStub = null;	
	try{
	
		Csp_Mbl_Soap_ToolsServiceService  Sfactory = new Csp_Mbl_Soap_ToolsServiceServiceLocator();
		Csp_Mbl_Soap_ToolsService Meta4Object = Sfactory.getCSP_MBL_SOAP_TOOLS();
		Csp_Get_Notifications_UserOutput  SalidaExec;
		
		//mantenemos la session proy
		oStub = (javax.xml.rpc.Stub)Meta4Object;
		oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
		
		//ejecutamos el m�todo
		Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
		SalidaExec =	 Meta4Object.CSP_GET_NOTIFICATIONS_USER(MaxNotificacionDispositivo); //ejecutamos el metodoControl accesso
		DevMetodo = SalidaExec.get_return();

		//cargamos el Bloque de registros
		Csp_Get_Notifications_User_OutBlock Bloque = SalidaExec.getCsp_Get_Notifications_User_Out();
		//Montamos el recordset
		Csp_Get_Notifications_User_OutRecord Rec[] =  Bloque.getCsp_Get_Notifications_User_OutRecordSet();
		
		helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
		helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
		helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
		
		//code meta4
		helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
		
		//Resultado Operacion metodo
		helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
				
		
		int numRegMeta4 = Rec.length;
		
		for (int z = 0;z<Rec.length;z++)
		{	
			helperXml.addXmlItem("recibido",z, Rec[z].getCsp_Chk_Recibido().toString(), helperXml.XML_NORMAL);
			helperXml.addXmlItem("descripcion",z,Rec[z].getCsp_Descripcion().toString() , helperXml.XML_NORMAL);
			helperXml.addXmlItem("mensaje",z, Rec[z].getCsp_Mensaje().toString(), helperXml.XML_NORMAL);
			helperXml.addXmlItem("ordinal",z,Rec[z].getCsp_Ordinal().toString() , helperXml.XML_NORMAL);
			helperXml.addXmlItem("fenvio",z,Rec[z].getCsp_Dt_Envio() , helperXml.XML_NORMAL);
			helperXml.addXmlItem("system",z,"Meta4" , helperXml.XML_NORMAL); //sistema de la notificacion
			
		}
		
		// -------------------------------------------------------------		
		//ahora hay que integrar con las notificaciones locales si
		// se tiene el sistema Local, claro.
		// -------------------------------------------------------------
		
		int numRegLocal = 0;
		
		hb_notifications notif = new hb_notifications();
		VinNotifications notificacionlocal = new VinNotifications(); 
		try{
			
			int localSystemPos = Session.getPosOfSystem("LOCAL");
			if (localSystemPos >= 0)
			{
				List<?> auxLocal = notif.getListaNotificacionesActivas(Session.getData(localSystemPos).user);
				
				//recorremos los registros del sistema Local para el usuario y que esten activos (no expirados)
				numRegLocal = auxLocal.size();
				for (int z=0; z<auxLocal.size();z++)
				{
					notificacionlocal = (VinNotifications) auxLocal.get(z);
					
					helperXml.addXmlItem("recibido",z+numRegMeta4,notificacionlocal.getChkReaded().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("descripcion",z+numRegMeta4,notificacionlocal.getTitle() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("mensaje",z+numRegMeta4, notificacionlocal.getMessage(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("ordinal",z+numRegMeta4,String.valueOf(notificacionlocal.getId().getOrdinal()) , helperXml.XML_NORMAL);
					helperXml.addXmlItem("fenvio",z+numRegMeta4,new DatesTools().StringToDate(notificacionlocal.getDtSend(),"dd/MM/yyyy") , helperXml.XML_NORMAL);
					helperXml.addXmlItem("system",z+numRegMeta4,"LOCAL" , helperXml.XML_NORMAL); //sistema de la notificacion
					
				}
						
			}
			
		}
		catch(Exception El)
		{
			
		}
		finally
		{
			
		}
		
		
		//XML: num registros de Meta4 + Local
		helperXml.addXmlItem("Records", String.valueOf(numRegMeta4 + numRegLocal), helperXml.XML_NORMAL);	
		
		helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
		XML = helperXml.getValues();	
		
	}
	catch(Exception e)
	{
		XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
		
	}
	finally
	{
		helperXml = null;
	}
	
	return XML;
}
	
	
	
	
}//DE LA CLASE
