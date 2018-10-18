/*--------------------------------------------------------------------------------------------
 * Equilibrha 2017
 * --------------------------------------------------------------------------------------------
 * Jose Luis Bustos. Web service for Apps android e IOS
 * --------------------------------------------------------------------------------------------
 */


package com.common.webservices;


import org.json.JSONException;

import com.Ostermiller.util.Base64;
import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.globalSystems.login.logonMain;
import com.common.meta4.meta4ImagesCache;
import com.common.tools.cache.documentsCache;
import com.common.tools.xml.XmlHelper;
import com.portalmobile.meta4.funcional.Meta4Control;
import com.portalmobile.meta4.funcional.Meta4EssPeoplenet;
import com.portalmobile.meta4.funcional.Meta4Login;
import com.portalmobile.meta4.funcional.Meta4Object_Dashboard;
import com.portalmobile.meta4.funcional.Meta4Object_empleados;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_absences;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_documents;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_economic;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_mss_reports;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_mss_team;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_mss_validate;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_news;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_notifications;
import com.portalmobile.tinnova.hb_mobile_functions_tinnova_whoiswho;
import com.portalmobile.tinnova.tiinova_backend_tools;



//web service inherit from main. 
public class WebServiceMobile  extends WebServiceMain{

		// ------------------------------------------------------------------------------------------------
		// FUNCTIONAL METHODS PORTAL MOBILE
		// ------------------------------------------------------------------------------------------------
		
	
		public String meta4GetInfoUserApp(String StrCredentials)
		{
			Meta4Control control;
			hb_mobile_functions_tinnova tinnova;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //seguridad
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					System.out.println("\n\n\nPeopleNet\n");
					control = new Meta4Control();
					return  control.GetInfoConectedUser(userConected);
				}
				else
				{
					tinnova = new hb_mobile_functions_tinnova();
					return tinnova.GetInfoConectedUser(userConected);
				}
				
			}
			finally
			{
				control = null;
				tinnova = null;
			}
		}
		
		public String meta4GetFichaEmpleado(String StrCredentials,String IdEmpleadoMeta4, String IdSociedadMeta4)
		{
			Meta4Object_empleados ficha;
			hb_mobile_functions_tinnova tinnova;
			
			try{
			
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					ficha = new Meta4Object_empleados();
					return ficha.GetFichaEmpleado(userConected, IdEmpleadoMeta4);}
				else
				{
					tinnova = new hb_mobile_functions_tinnova();
					return tinnova.GetFichaEmpleado(userConected, IdEmpleadoMeta4, IdSociedadMeta4); //sociedad solo para Tinnova
				}
				
			}
			finally
			{
				ficha = null;
				tinnova = null;
			}
		}
		
		public String meta4GetListaEmpleados(String StrCredentials,String filters, double paginaDatos) throws Exception 
		{
			Meta4Object_empleados lista;
			hb_mobile_functions_tinnova tinnova;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					lista = new Meta4Object_empleados();
					return lista.GetListaEmpleados(userConected, filters, paginaDatos);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova();
					return tinnova.GetListaEmpleados(userConected, filters, paginaDatos);
				}
			}
			finally
			{
				lista = null;
				tinnova = null;
			}
		}
		
		public String meta4DelNotificacion(String StrCredentials,double OrdinalNotificacion, String System)
		{
			
			Meta4Control  m4object;
			WebServiceNotifications WsNot;
			hb_mobile_functions_tinnova_notifications tinnova;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				if (System.equals("Meta4"))
				{
					if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
					{
						m4object = new Meta4Control();
						return m4object.DeleteNotificacion(userConected,OrdinalNotificacion);
					}
					else {
						tinnova = new hb_mobile_functions_tinnova_notifications();
						return tinnova.DeleteNotificacion(userConected,OrdinalNotificacion);
					}
				}
				else
				{
					//is Local notification
					WsNot = new WebServiceNotifications();
					WsNot.setNotificationDeleted(StrCredentials, userConected.getData(userConected.getPosOfSystem("LOCAL")).user,(int)OrdinalNotificacion);
					return "";
				}
			}
			finally
			{
				m4object = null;
				WsNot = null;
				tinnova = null;
			}
		}
		
		public String meta4SaveNotificacionLeida(String StrCredentials,double OrdinalNotificacion, String System)
		{
			
			Meta4Control  m4object;
			WebServiceNotifications WsNot;
			hb_mobile_functions_tinnova_notifications tinnova;
			try{
				
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				
				if (System.equals("Meta4"))
				{
					if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
					{
						m4object = new Meta4Control();
						return m4object.SaveNotificacionLeido(userConected,OrdinalNotificacion);
					}
					else {
						tinnova = new hb_mobile_functions_tinnova_notifications();
						return tinnova.SaveNotificacionLeido(userConected,OrdinalNotificacion);
					}
				}
				else
				{
					WsNot = new WebServiceNotifications();
					WsNot.setNotificationRead(StrCredentials, userConected.getData(userConected.getPosOfSystem("LOCAL")).user,(int)OrdinalNotificacion);
					return "";
				}
			}
			finally
			{
				m4object = null;
				WsNot = null;
				tinnova = null;
			}
		}
	
		public String meta4GetListaNotificaciones(String StrCredentials,double OrdinalNotificacion)
		{
			
			Meta4Control  m4object;
			hb_mobile_functions_tinnova_notifications tinnova;
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4object = new Meta4Control();
					return m4object.GetNotificationsUserMeta4(userConected,OrdinalNotificacion);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_notifications();
					return tinnova.GetNotificationsUserMeta4(userConected,OrdinalNotificacion);
				}
				
			}
			finally
			{
				m4object = null; 
				tinnova = null;
			}
		}

		public String getEssMisNoticias(String StrCredentials)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_news tinnova = null;
			String dev = "";
			
			try{
			
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getEssMisNoticias(userConected);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_news();
					dev =  tinnova.getEssMisNoticias(userConected);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null){tinnova.Dispose();}
				tinnova = null;		
			}
	
			return dev; 
			
		}
		
		public String getEssDatosBancarios(String StrCredentials, String IdHr)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_economic tinnova = null;
			String dev = "";
			
			try{
			
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getEssDatosBancarios(userConected,IdHr);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_economic();
					dev =  tinnova.getEssDatosBancarios(userConected,IdHr);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null){tinnova.Dispose();}
				tinnova = null;
			}
			return dev;
			
		}
		
		public String getEssRecibosNomina(String StrCredentials,String IdHR, double year)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_economic tinnova = null;
			
			String dev = "";
			
			try{
			
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); 
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getEssRecibosNomina(userConected, IdHR, year);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_economic();
					dev =  tinnova.getEssRecibosNomina(userConected, IdHR, year);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null){tinnova.Dispose();}
				tinnova = null;
			}
			return dev;
			
		}
		
		public String essDownloadReciboNomina(String StrCredentials,String IdHR, String fechaPago, String fechaAlloc)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_economic tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); 
			
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.essDownloadReciboNomina(userConected,IdHR,fechaPago,fechaAlloc);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_economic();
					dev =  tinnova.essDownloadReciboNomina(userConected,IdHR,fechaPago,fechaAlloc);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null){tinnova.Dispose();}
				tinnova = null;
			}
			return dev; 
			
		}

		public String getMSSMisEmpleados(String StrCredentials,String IdHR, String filters, double PaginaDatos)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_mss_team tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); 
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getMssMisEmpleados(userConected,IdHR,filters,PaginaDatos);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_mss_team();
					dev =  tinnova.getMssMisEmpleados(userConected,IdHR,filters,PaginaDatos);
				}
			
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null){tinnova.Dispose();}
				tinnova = null;
				
			}
	
			return dev; 
			
		}

		public String getEssWhoIsWho(String StrCredentials,String filters, double PaginaDatos)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_whoiswho tinnova = null;
			String dev = "";
			
			try{
			
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); 
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getEssWhoIsWho(userConected, filters, PaginaDatos);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_whoiswho();
					dev = tinnova.getEssWhoIsWho(userConected, filters, PaginaDatos);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
				m4o = null;
				
			}
						
			return dev; 
			
		}
		
		public String getEssMisAbsentismos(String StrCredentials,String IdHR, double year)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_absences tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
			
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getEssMisAbsentismos(userConected,IdHR,year);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_absences();
					dev =  tinnova.getEssMisAbsentismos(userConected,IdHR,year);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
				
			}
	
			return dev;
			
		}
		
		public String addEssNewSolAbsentismo(String StrCredentials,String IdHR, String idAbsentismo, String inicio, String fin, String comentarios)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_absences tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.addEssNewSolAbsentismo(userConected,IdHR,idAbsentismo,inicio,fin,comentarios);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_absences();
					dev =  tinnova.addEssNewSolAbsentismo(userConected,IdHR,idAbsentismo,inicio,fin,comentarios);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
	
			return dev;
			
		}
		
		public String essDelSolAbsentismo(String StrCredentials,String IdHR, double ordinal)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_absences tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.EssDelSolAbsentismo(userConected,IdHR,ordinal);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_absences();
					dev =  tinnova.EssDelSolAbsentismo(userConected,IdHR,ordinal);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
	
			return dev; 
			
		}
		
		public String getMssListaSolicAbsentPorValidar(String StrCredentials,String IdHR,String optional)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_mss_validate tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getMssListaSolicAbsentPorValidar(userConected,IdHR, optional);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_mss_validate();
					dev =  tinnova.getMssListaSolicAbsentPorValidar(userConected,IdHR, optional);
				}
				
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
	
			return dev;
			
		}
		
		public String setMssCancelSolicAbs(String StrCredentials,String IdHR, double ordinal, String motivo, String optional)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_mss_validate tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.setMssCancelSolicAbs(userConected, IdHR, ordinal, motivo, optional);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_mss_validate();
					dev =  tinnova.setMssCancelSolicAbs(userConected, IdHR, ordinal, motivo, optional);
				}
					
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
	
			return dev; 
			
		}
		
		public String setMssAceptarSolicAbs(String StrCredentials,String IdHR, double ordinal, String motivo, String optional)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_mss_validate tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
			
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.setMssAceptarSolicAbs(userConected, IdHR, ordinal, motivo, optional);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_mss_validate();
					dev =  tinnova.setMssAceptarSolicAbs(userConected, IdHR, ordinal, motivo, optional);
				}
					
			} catch (Exception e) {

				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
	
			return dev;
			
		}

		public String meta4GetListaFilesUser(String StrCredentials,double OrdinalFile)
		{
			
			Meta4Control  m4object;
			hb_mobile_functions_tinnova_documents tinnova = null;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4object = new Meta4Control();
					return m4object.GetFilesUserMeta4(userConected,OrdinalFile);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_documents();
					return tinnova.GetFilesUserMeta4(userConected,OrdinalFile);
				}
			}
			finally
			{
				m4object = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
		}
		
		public String meta4GetRealFileUser(String StrCredentials,double OrdinalFile)
		{
			
			Meta4Control  m4object;
			hb_mobile_functions_tinnova_documents tinnova = null;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4object = new Meta4Control();
					return m4object.GetRealFileUser(userConected,OrdinalFile);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_documents();
					return tinnova.GetRealFileUser(userConected,OrdinalFile);
				}
			}
			finally
			{
				m4object = null; 
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
		}
		
		public String meta4DelFileUser(String StrCredentials,double OrdinalFile)
		{
			Meta4Control  m4object;
			hb_mobile_functions_tinnova_documents tinnova = null;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4object = new Meta4Control();
					return m4object.DeleteFileUser(userConected,OrdinalFile);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_documents();
					return tinnova.DeleteFileUser(userConected,OrdinalFile);
				}
			
			}
			finally
			{
				m4object = null; 
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
		}	

		public String meta4SaveFileLeido(String StrCredentials,double OrdinalFile)
		{
			
			Meta4Control  m4object;
			hb_mobile_functions_tinnova_documents tinnova = null;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4object = new Meta4Control();
					return m4object.SaveFileUserRead(userConected,OrdinalFile);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_documents();
					return tinnova.SaveFileUserRead(userConected,OrdinalFile);
				}
			}
			finally
			{
				m4object = null; 
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
		}
		
		public String meta4MssGetMyQueries(String StrCredentials)
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_mss_reports tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getMssMisConsultas(userConected);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_mss_reports();
					dev =  tinnova.getMssMisConsultas(userConected);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
			return dev; 
			
		}
		
		public String meta4MssGetMyQueryMetaData(String StrCredentials, String idMeta4Object)
		{
					
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_mss_reports tinnova = null;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getMssMiConsultaMetaData(userConected,idMeta4Object);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_mss_reports();
					dev =  tinnova.getMssMiConsultaMetaData(userConected,idMeta4Object);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
			return dev; 
		}
		
		public String meta4MssExecQuery(String StrCredentials, String idMeta4Object, String params)
		{
					
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova_mss_reports tinnova = null;
			String dev = "";
			
			try{
			
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					dev =  m4o.getMssExecuteQuery(userConected,idMeta4Object,params);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova_mss_reports();
					dev =  tinnova.getMssExecuteQuery(userConected,idMeta4Object,params);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				if (tinnova != null) {tinnova.Dispose();}
				tinnova = null;
			}
			return dev; 
		}
		
		public int sendFileRh(String StrCredentials, String fileBase64, String extension, String IdHr, String tpFile, String commentsEmployee) 
		{
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova tinnova;
			int dev = 0;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					m4o.sendFileRh(userConected, fileBase64, extension, IdHr, tpFile, commentsEmployee);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova();
					return tinnova.sendFileRh(userConected, fileBase64, extension, IdHr, tpFile, commentsEmployee);
				}
				
				
				dev = 0;
			} catch (Exception e) {
				e.printStackTrace();
				dev = -1;
			}
			finally
			{
				m4o = null;
				tinnova = null;
			}
			return dev; 
		}
		
		public String getListTypeDocsSend(String StrCredentials){
			Meta4EssPeoplenet m4o;
			hb_mobile_functions_tinnova tinnova;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
		   		    return m4o.getESSListDocsSendType(userConected);
				}
				else {
					tinnova = new hb_mobile_functions_tinnova();
		   		    return tinnova.getESSListDocsSendType(userConected);
				}
				
				
			} catch (Exception e) {

				e.printStackTrace();
				return "";
			}
			finally
			{
				m4o = null;
				tinnova = null;
			}
		}
		
			
				
		// ------------------------------------------------------------------------------------------------
		// OTHER OPERATIONS
		// ------------------------------------------------------------------------------------------------
		
		//Logout only for Devices Soap use
		public int meta4Logout(String Meta4SessionId)
		{
			try{
				internalControl(Meta4SessionId, "",Thread.currentThread().getStackTrace()[1].getMethodName()); 
				logonMain login = new logonMain();
				login.logout(userConected.getData(userConected.getPosDefaultSystem()).user);
				
				return 0;
			}
			catch(Exception e){
				return -1;
			}

		}	
		
		//Image Cache
		public String  meta4GetImageCache(String idFoto,String idEmpleado)
		{
			String XML="";
			try{
				XmlHelper helperXml =  new XmlHelper();
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
				meta4ImagesCache img = new meta4ImagesCache();
				
				String file =  "";
				
				file =  img.getImageBase64(idFoto);
				
				
				String ext = img.extesion;
				helperXml.addXmlItem("Resultado",file, helperXml.XML_NORMAL);
				helperXml.addXmlItem("extension",ext, helperXml.XML_NORMAL);
				helperXml.addXmlItem("object2","object" , helperXml.XML_SOLO_CERRAR_XML);
				
				XML = helperXml.getValues();
			}
			catch(Exception e){
				System.out.println("\n\n\n error al ejecutar Cache!!!!!!!!");
				
			}
			finally{
			}	
			return XML;
			
		}	
		
		//get the cache and send only the base64
		public String  meta4GetImageCacheURL(String idfoto)
		{
			
			meta4ImagesCache img;
			
			try{
				
				img = new meta4ImagesCache();
				String file =  img.getImageBase64(idfoto);
				return file;
			}
			catch(Exception e){
				return "";
			}
			finally{
					img = null;
			}
		}	
		
		// product version
		public String getProductVersion()
		{
			return new ParamsApp().SYSTEM_PRODUCT_VERSION.trim().toString();
		}
		
		//validate product version	
		public String  getAppVersionValidation(String tipoDevice, String AppVersionUser, String ProductVersionApp){
				ParamsApp params ;
				XmlHelper helperXml;
				
				String XML="";
						
				try{
					params = new ParamsApp();
					helperXml =  new XmlHelper();
				
				
					helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				
				
					//verificamos si el App del usuario está actualizada
					String AppVersionRelease = "";
					String URLStoreInstall = "";
					String AppVersionOK = "1"; //si esta OK
					String ProductVersionOK = "0"; //por defecto no esta OK
					
					if (tipoDevice.equals("4") || tipoDevice.equals("10")){
						
						//androids
						AppVersionRelease = params.SYSTEM_APP_VERSION_ANDROID;
						
						//Si no es la misma version buscamos el Store instalacion directa
						if (!AppVersionRelease.equals(AppVersionUser)){
							URLStoreInstall = params.SYSTEM_APP_STORE_ANDROID;
							AppVersionOK = "0";
						}
					}
					else
					{
						//Iphone e IPad
						AppVersionRelease = params.SYSTEM_APP_VERSION_APPLE;
						
						//Si no es la misma version buscamos el Store instalacion directa
						if (!AppVersionRelease.equals(AppVersionUser)){
							URLStoreInstall = params.SYSTEM_APP_STORE_APPLE;
							AppVersionOK = "0";
						}
					}
					
					//controlamos el ProductVersion
					if (params.SYSTEM_PRODUCT_VERSION.trim().equals(ProductVersionApp.trim()))
					{
						ProductVersionOK = "1";
					}
					
					//montamos el XML
					helperXml.addXmlItem("AppVersionOK",AppVersionOK, helperXml.XML_NORMAL);
					helperXml.addXmlItem("URLStoreInstall",URLStoreInstall, helperXml.XML_NORMAL);
					helperXml.addXmlItem("ProductVersionOK",ProductVersionOK, helperXml.XML_NORMAL);
					
					//Final XML
					helperXml.addXmlItem("object2","object" , helperXml.XML_SOLO_CERRAR_XML);
					
					
					try {
						XML = helperXml.getValues();
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				catch(Exception e){}
				finally{
					params = null;
					helperXml = null;
				}
				
				return XML;  //Devolvemos XML con resulytados de la validacion de Apps y product version
			}

		//lost password or user not exist (tinnova)
		public Double chgPasswordForgetAndSendByEmail( String mail, String numDoc, String PrimApp ){
			Meta4EssPeoplenet m4o;
			tiinova_backend_tools m4oj;
			
			try{
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
					return m4o.chgPasswordForgetAndSendByEmail( mail, numDoc, PrimApp);
				}
				else
				{
					// Tinnova & LOCAL. Here if not exist User, create and data regenerate
					m4oj = new tiinova_backend_tools();
					return m4oj.regenerateUserPasswordAndData(mail, numDoc, PrimApp);
					
				}
				
			}
			catch(Exception e){
				return (double)-1;
			}
			finally{
				m4o = null;
				m4oj = null;
			}
			
		}
		
		//Change password in device
		public Double chgPasswordUserApp(String StrCredentials,  String newPass ){
			Meta4EssPeoplenet m4o;
			tiinova_backend_tools m4oj;
			double dev = -1;
			
			try{
				internalControl(StrCredentials, "","chgPasswordUserApp"); //Validate security in this Method
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					m4o = new Meta4EssPeoplenet();
				
					//Ejecucion del metodo Meta4
					dev =  m4o.chgPasswordUserApp(userConected, newPass);
				}
				else {
					//Tinnova
					m4oj = new tiinova_backend_tools();
					dev = m4oj.chgPasswordUserApp(userConected, newPass);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally
			{
				m4o = null;
				m4oj = null;
				
			}
	
			return dev; //Return the result. -1 == Error
		}
			
		
		// ------------------------------------------------------------------------------------------------
		// DEPRECIATED METHODS.  FOR DELETE IN FUTURE
		// ------------------------------------------------------------------------------------------------
	
		// depreciated . No use in actual Version.
		public double meta4AddFavoriteRh(String StrCredentials,String IdEmpleadoMeta4)
		{
			Meta4Object_empleados m4object;
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				
				m4object = new Meta4Object_empleados();
				return m4object.AddFavoriteRH(userConected, IdEmpleadoMeta4);
			}
			catch(Exception e)
			{
				
				return -1; //aqui nunca deberia llegar por exceptiones anteriores.
			}
			finally
			{
				
				m4object = null; //liberamos el objeto
			}
			
		}
		
		//depreciated . No use in actual Version.
		public double meta4DelFavoriteRh(String StrCredentials,String IdEmpleadoMeta4)
		{
			
			Meta4Object_empleados m4object;
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				m4object = new Meta4Object_empleados();
				return m4object.DelFavoriteRH(userConected, IdEmpleadoMeta4);
			}
			catch(Exception e)
			{
				return -1; //aqui nunca deberia llegar por exceptiones anteriores.
			}
			finally
			{
				
				m4object = null; //liberamos el objeto
			}
			
		}
		
		//depreciated . No use in actual Version.
		public Double meta4AddAbsentismoEmpleado(String StrCredentials,String IdHr,String periodo, String fechaIni, String fechaFin, String idIncidence,String Comentario) 
		{
			
			Meta4Object_empleados lista;
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
				lista = new Meta4Object_empleados();
				return lista.AddAbsentismoEmpleado(userConected, IdHr, periodo, fechaIni, fechaFin, idIncidence, Comentario);
			}
			catch(Exception e)
			{
				return (double) -1; 
			}
			finally
			{
				lista = null;
			}
		}
		
		//depreciated . No use in actual Version
		@SuppressWarnings("unused")
		private int internalMeta4Logout(String Meta4SessionId)
		{
			int dev = 0;
			Meta4Login login;
			
			try{
				login = new Meta4Login(); 
				dev = login.LogoutNMeta4(Meta4SessionId);
				
			}
			catch(Exception e)
			{
				dev = -1;
			}
			finally
			{
				login = null; 
			}
			return dev;
		}

		//depreciated . No use in actual Version
		public String meta4DashboardGetMenus(String StrCredentials)
		{
			Meta4Object_Dashboard control;
			hb_mobile_functions_tinnova tinnova;
			String dev = "";
			
			try{
				internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales
					
				
				if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
				{
					
					control = new Meta4Object_Dashboard();
					dev =  control.GetMenuDashboard(userConected); //sesencriptamos el Serial					
				}
				else
				{
					tinnova = new hb_mobile_functions_tinnova();
					dev =  tinnova.GetMenus(userConected);
				}
				
			}
			catch(Exception e){}
			finally
			{
				control = null;
				tinnova = null;
				
			}
			return dev;
		}
		
}


