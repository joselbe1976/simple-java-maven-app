/*
 * Equilibrha 2016. Metodos para el telefono de tinnova
 * Jose Luis Bustos. 
 */

package com.portalmobile.tinnova;

import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.hb_notifications;
import com.common.hibernate.classes.hb_tools;
import com.common.hibernate.classes.tinnova.hb_main_tinnova;
import com.common.hibernate.entidades.VinNotifications;
import com.common.tools.DatesTools;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.xml.XmlHelper;

public class hb_mobile_functions_tinnova_notifications extends hb_main_tinnova  implements iDisposable{
	private ParamsApp IntParams;
	private tiinova_backend_tools backendToolsTiinova;
	
	
	private static String className = "";
	
	// constructor class
	public hb_mobile_functions_tinnova_notifications() {
		IntParams = new ParamsApp();
		backendToolsTiinova = new tiinova_backend_tools();
	
		className = this.getClass().getSimpleName(); //Class name for logs
	}
	public void Dispose() {
		IntParams = null;
		backendToolsTiinova.Dispose();
		backendToolsTiinova = null;
	}
	
	// get botifications of user connected
		@SuppressWarnings("rawtypes")
		public String GetNotificationsUserMeta4(logonCredencialProcess Session, double MaxNotificacionDispositivo){
				
				XmlHelper helperXml = new XmlHelper();	
				if (Session==null) {return helperXml.getErrorValues("");}
		
				String XML = "";
				Map row =null;

				try{
					helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
					helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
					helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
					
					//code meta4
					helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
					
					//Result code. Compatibility with meta4 Soap web servicess
					helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
							
					
					// Load Tinnova notifications
					
					String sociedad = Session.getData(Session.getPosDefaultSystem()).sociedad;
					String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
					String userID = Session.getData(Session.getPosDefaultSystem()).user;
					
					String Sql = "SELECT ID_SOCIEDAD, ID_EMPLEADO, ORDINAL, MENSAJE, CHECK_RECIBIDO, CHK_DEL_MOBILE, CONVERT(VARCHAR,FECHA_ENVIO, " + ParamsApp.DATE_SQLSERVER_CONFIG  + ") AS FECHA_ENVIO, DESCRIPCION FROM MBL_NOTIFICACIONES_TODAY WHERE ID_SOCIEDAD = '"+sociedad+"' AND ID_EMPLEADO = '"+idEmpleado+"'";
					List<?> data  = this.getDataSQLNativo(Sql);
					int numRegMeta4 = data.size();
					
					for (int z = 0;z < data.size(); z++)
					{	
						row = (Map)data.get(z);
						
						helperXml.addXmlItem("recibido",z, row.get("CHECK_RECIBIDO").toString(), helperXml.XML_NORMAL);
						helperXml.addXmlItem("descripcion",z,row.get("MENSAJE").toString() , helperXml.XML_NORMAL);
						helperXml.addXmlItem("mensaje",z, row.get("DESCRIPCION").toString(), helperXml.XML_NORMAL);
						helperXml.addXmlItem("ordinal",z,row.get("ORDINAL").toString() , helperXml.XML_NORMAL);
						helperXml.addXmlItem("fenvio",z,row.get("FECHA_ENVIO").toString() , helperXml.XML_NORMAL);
						helperXml.addXmlItem("system",z,"Meta4" , helperXml.XML_NORMAL); //Notification System
						
					}
					
					// -------------------------------------------------------------		
					//  Now integrate local notifications (mySQL)
					// -------------------------------------------------------------
					
					int numRegLocal = 0;
					
					hb_notifications notif ;
					VinNotifications notificacionlocal ;
					try{
							notif = new hb_notifications();
							notificacionlocal = new VinNotifications(); 
							
							List<?> auxLocal = notif.getListaNotificacionesActivas(userID);
							
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
					catch(Exception ee)
					{
						addLog("GetNotificationsUserMeta4 - Local notification error: \n"+ee.getStackTrace(), ParamsApp.LOG_TYPE_ERROR);
					}
					finally
					{
						notif = null;
						notificacionlocal = null;
					}
					
					
					//XML: num registros de Meta4 + Local
					helperXml.addXmlItem("Records", String.valueOf(numRegMeta4 + numRegLocal), helperXml.XML_NORMAL);	
					
					helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
					XML = helperXml.getValues();	
					
				}
				catch(Exception e)
				{
					addLog("GetNotificationsUserMeta4 : \n"+e.getStackTrace(), ParamsApp.LOG_TYPE_ERROR);
					XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
					
				}
				finally
				{
					if (helperXml != null) {helperXml.Dispose();}
					helperXml = null;
					row = null;
				}
				
				return XML;
		}
			
					
		
		public String SaveNotificacionLeido(logonCredencialProcess Session, double OrdNotificacion)
		{
			
			XmlHelper helperXml = new XmlHelper();	
			hb_main_tinnova tinnova = null;

			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}

			String XML = "";
			try{
				
				tinnova = new hb_main_tinnova();
			
				String sociedad   = Session.getData(Session.getPosDefaultSystem()).sociedad; 
				String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
				
				//execute Update in DataBase
				String SqlUpdate = "UPDATE EQ_MBL_NOTIFICATIONS  SET CHECK_RECIBIDO = '1' ";
				SqlUpdate += " WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEADO = :empleado  AND ORDINAL = :ordinal";
				
				
				SQLQuery query  = tinnova.getSqlQuery(SqlUpdate);
				query.setParameter("sociedad", sociedad);
				query.setParameter("empleado", idEmpleado);
				query.setParameter("ordinal", OrdNotificacion);
				
				int dev = tinnova.executeSqlAdvance(query); //execute the update
						
				if (dev == 0) {
					//generate XML response
					helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
					helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
					helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
					//code meta4
					helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
					helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
					helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);	
					helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
					XML = helperXml.getValues();	
				}
				else {
					XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
				}
				
			}
			catch(Exception e)
			{
				XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
				
			}
			finally
			{
				if (helperXml != null) {helperXml.Dispose();}
				helperXml = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
			
			return XML;

		}
		
		
		public String DeleteNotificacion(logonCredencialProcess Session, double OrdNotificacion)
		{
			
			XmlHelper helperXml = new XmlHelper();	
			hb_main_tinnova tinnova = null;

			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}

			String XML = "";
			try{
				
				tinnova = new hb_main_tinnova();
			
				String sociedad   = Session.getData(Session.getPosDefaultSystem()).sociedad; 
				String idEmpleado = Session.getData(Session.getPosDefaultSystem()).id_persona;
				
				//execute Update in DataBase
				String SqlUpdate = "UPDATE EQ_MBL_NOTIFICATIONS  SET CHK_DEL_MOBILE = '1' ";
				SqlUpdate += " WHERE ID_SOCIEDAD = :sociedad  AND ID_EMPLEADO = :empleado  AND ORDINAL = :ordinal";
				
				
				SQLQuery query  = tinnova.getSqlQuery(SqlUpdate);
				query.setParameter("sociedad", sociedad);
				query.setParameter("empleado", idEmpleado);
				query.setParameter("ordinal", OrdNotificacion);
				
				int dev = tinnova.executeSqlAdvance(query); //execute the update
						
				if (dev == 0) {
					//generate XML response
					helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
					helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
					helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
					//code meta4
					helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
					helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
					helperXml.addXmlItem("Records", "1", helperXml.XML_NORMAL);	
					helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
					XML = helperXml.getValues();	
				}
				else {
					XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
				}
				
			}
			catch(Exception e)
			{
				XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
				
			}
			finally
			{
				helperXml = null;
				tinnova = null;
			}
			
			return XML;

		}
			
	
	
	// Debug class
	protected void addLog(String info, int logType)
	{
		new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
	}
		
}
