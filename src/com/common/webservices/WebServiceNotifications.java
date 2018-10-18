/*
 * Jose Luis Bustos Esteban 2014.
 * Clase de notificaciones locales.
 */
package com.common.webservices;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.hibernate.classes.hb_notifications;
import com.common.hibernate.classes.hb_users;
import com.common.hibernate.entidades.VinNotifications;
import com.common.hibernate.entidades.VinNotificationsId;
import com.common.hibernate.entidades.VinSystems;
import com.common.pushnotifications.Parse.parseOperations;
import com.common.tools.DatesTools;
import com.common.tools.xml.XmlHelper;
import com.portalmobile.tinnova.tiinova_backend_tools;


//heredamos de la padre de web services (MAIN)
public class WebServiceNotifications extends WebServiceMain{

	public static final long ONE_MINUTE_IN_MILLIS=60000;
	
	// Web service de notificaciones. Cuando otros sistemas quieren Leer o enviar notificaciones a un usuario.
	// Es necesario tener acceso por lo menos al sistema LOCAL. Se puede usar un usuario tecnologico
	// solo para estos sistemas que llaman
	// OJO: EL USUARIO debe tener solo 1 sistema asignado LOCAL. ninguno mas.
	
	
	
	public String getListaNotificacionesLOCAL(String StrCredentials)
	{
			XmlHelper helperXml =  new XmlHelper();	
			String XML = "";
		
		
			internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
			if (userConected==null){return "";}
			if (!userConected.SerialKeyForIdProcess.equals(""))
			{
			
		
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(userConected.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado","0", helperXml.XML_NORMAL);
								
				
				hb_notifications notif = null;;
				VinNotifications notificacionlocal = new VinNotifications(); 
				try{
					
					int localSystemPos = userConected.getPosOfSystem("LOCAL");
					if (localSystemPos >= 0)
					{
						notif = new hb_notifications();
						List<?> auxLocal = notif.getListaNotificacionesActivas(userConected.getData(localSystemPos).user);
						notif.close_session_user(); //cuierro la session
						
						//num registros de Local
						helperXml.addXmlItem("Records", String.valueOf(auxLocal.size()), helperXml.XML_NORMAL);

						
						for (int z=0; z<auxLocal.size();z++)
						{
							notificacionlocal = (VinNotifications) auxLocal.get(z);
							
							helperXml.addXmlItem("recibido",z,notificacionlocal.getChkReaded().toString(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("descripcion",z,notificacionlocal.getTitle() , helperXml.XML_NORMAL);
							helperXml.addXmlItem("mensaje",z, notificacionlocal.getMessage(), helperXml.XML_NORMAL);
							helperXml.addXmlItem("ordinal",z,String.valueOf(notificacionlocal.getId().getOrdinal()) , helperXml.XML_NORMAL);
							helperXml.addXmlItem("fenvio",z,new DatesTools().StringToDate(notificacionlocal.getDtSend(),"dd/MM/yyyy") , helperXml.XML_NORMAL);
							helperXml.addXmlItem("system",z,"LOCAL" , helperXml.XML_NORMAL); //sistema de la notificacion
							
						}
								
					}
					
					
					helperXml.addXmlItem("object2","object" , helperXml.XML_SOLO_CERRAR_XML);
					XML = helperXml.getValues();
				}
				catch(Exception El)
				{
					XML  = helperXml.getErrorValues(userConected.SerialKeyMainReturnApps);
				}
				finally
				{
					helperXml=null;
				}	
			}
			return XML;
	}
	
	
	
	
	//añadir notificacion a partir del usuario
	public boolean addNotification(String StrCredentials, String localUser,String title, String message, int daysExpire)
	{
	
		try{
			
			internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
			if (userConected==null){return false;}
			if (!userConected.SerialKeyForIdProcess.equals(""))
			{
				
				
				return addNotificationInternal(localUser,title, message, daysExpire );
			}
			else
			{	
				return false;
			}
			
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
		}
	}

	
	//Send Push notificartion a un usuario. Notificacion PUSHY
	public boolean sendPushNotification(String StrCredentials, String localUser, String message)
	{
	
		parseOperations oper;
		try{
			
			internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
			if (userConected==null){return false;}
			if (!userConected.SerialKeyForIdProcess.equals(""))
			{
				//Debe ser un usuario administrador
				if (isAdminRole() == false){return false;}
				
				
				oper = new parseOperations();
				oper.sendPushNotificationUser(message, localUser,""); //envio
				
				return true;
				
			}
			else
			{	
				return false;
			}
			
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			oper = null;
		}
	}	
	
	//envio a un channel de distribucion. . Notificacion Pushy
	public boolean sendPushNotificationChannel(String StrCredentials, String channel, String message)
	{
	
		parseOperations oper;
		try{
			
			internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
			if (userConected==null){return false;}
			if (!userConected.SerialKeyForIdProcess.equals(""))
			{
				//Debe ser un usuario administrador
				if (isAdminRole() == false){return false;}
				
				
				oper = new parseOperations();
				oper.sendPushNotificationChannel(message, channel, "");
				
				return true;
				
			}
			else
			{	
				return false;
			}
			
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			oper = null;
		}
	}	
		
	
	//send push notification to Tinnvoa Employee
	public boolean sendPushNotificationTinnova(String StrCredentials, String idEmpleado, String sociedad, String message) {
		
		boolean dev = true;
		String localUser  = "";
		parseOperations oper;
		hb_users auxUsr=null;
		
		try {
			
			
			//Credential
			internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); 
			
			
			if (userConected==null){
				return false;
				}
			
			//Should be Admin user the connected User
			if (isAdminRole() == false){
				return false;
				}
			
			//Calculate user of employee send us by arguments
			auxUsr = new hb_users();
			
			if (auxUsr.existLocalUserOfIdEmpleadoAndSociedad(idEmpleado, sociedad)) {
				
				//Get id
				localUser =  auxUsr.getLocalUserOfIdEmpleadoAndSociedad(idEmpleado, sociedad);
				
				//send Push
				oper = new parseOperations();
			
				int operresult = oper.sendPushNotificationUser(message, localUser, ""); 
				
				if (operresult == -1) {dev = false;}
			}
			else {
				dev = false;
			}
			
		}
		catch (Exception e) {
			dev = false;
			System.out.println("\n\n ERROR ( sendPushNotificationTinnova) : " + e.getMessage());
			e.printStackTrace();
		}
		finally {
			oper = null;
			if (auxUsr != null) {auxUsr.Dispose();}
			auxUsr = null;
		}
		
		return dev;
	}
	
	
	
	
	
	
	//Añadir notificacion con el NIF o datos del empleado de RRHH
	public boolean addNotificationFindUser(String StrCredentials, String nif,String id_empleado,String fase_alta,String title, String message, int daysExpire)	
	{
		hb_users auxUsr=null;
		String idLocalUserFind="";
		try{
			internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
			if (userConected==null){return false;}
			if (!userConected.SerialKeyForIdProcess.equals(""))
			{			
				//Debe ser un usuario administrador
				if (isAdminRole() == false){return false;}
				
				auxUsr = new hb_users();
				
				//verificamos si existe usuario para nif
				if (!nif.trim().equals(""))
				{
					if (auxUsr.existLocalUserOfNif(nif))
					{
						idLocalUserFind = auxUsr.getLocalUserOfNif(nif); 
					}
				}

				if (idLocalUserFind.equals(""))
				{
					//no existe nif, buscamos por id empleado y fase alta
					if (auxUsr.existLocalUserOfIdEmpleadoAndFaseAlta(id_empleado, fase_alta))
					{
						idLocalUserFind = auxUsr.getLocalUserOfIdEmpleadoAndFaseAlta(id_empleado, fase_alta);
					}
				}
				
				if (!idLocalUserFind.trim().equals(""))
				{
					//llamamos a la inserccion
					return addNotificationInternal(idLocalUserFind,title, message, daysExpire );
				}
				else {return false;}
			
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			auxUsr.close_session_user();
		}
		
	}

	
	

	//marca como Leida la notificacion
	public boolean setNotificationRead(String StrCredentials,String localUser,int ordinal)
	{
		hb_notifications notif=null;
		VinNotifications notificacion;
		
		
		try{

			internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
			if (userConected==null){return false;}
			if (!userConected.SerialKeyForIdProcess.equals(""))
			{				
				//Debe ser un usuario administrador
				if (isAdminRole() == false){return false;}
				
				
				notif = new hb_notifications();
				notificacion = notif.getDataObject(localUser, ordinal);
				if (notificacion==null){return false;}
				
				if (notificacion.getChkReaded()==0)
				{
					//Marcamos como leida, si no esta marcada
					notificacion.setChkReaded(1);
	
					//grabacion
					return notif.Updatedata(notificacion);
				}else{return true;}
			}
			else {return false;}
				
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if (notif!=null){notif.close_session_user();}
			notif=null;
			notificacion=null;
		
		}
	}	
	
	
	//marca como Leida la notificacion
	public boolean setNotificationDeleted(String StrCredentials,String localUser,int ordinal)
	{
		hb_notifications notif=null;
		VinNotifications notificacion;
		
		
		try{

			internalControl(StrCredentials, "",Thread.currentThread().getStackTrace()[1].getMethodName()); //le pasamos el serial y credenciales //Control sesion del web service y Meta4
			if (userConected==null){return false;}
			if (!userConected.SerialKeyForIdProcess.equals(""))
			{		
				
				//Debe ser un usuario administrador
				if (isAdminRole() == false){return false;}
		
				notif = new hb_notifications();
				notificacion = notif.getDataObject(localUser, ordinal);
				if (notificacion==null){return false;}
				
				//Marcamos como leida si no esta ya marcada
				if (notificacion.getChkDeleted()==0){
					notificacion.setChkDeleted(1);
					//grabacion
					return notif.Updatedata(notificacion);
				}
				else
				{return true;} //no devolvemos error
			}
			else {return false;}
				
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if (notif!=null){notif.close_session_user();}
			notif=null;
			notificacion=null;
		
		}
	}	
	
	
	
	
	// metodos internos del web service Notificaciones.
	
	
	private boolean isAdminRole(){
		
		String usuario = userConected.getData(userConected.getPosDefaultSystem()).user;
		hb_users auxUsr=null;
		
		try{
		//busco el usuario
		
			auxUsr = new hb_users();
			//si el usuario tiene un role administrador
			String idRole = auxUsr.getUser(usuario).getVinRoles().getId().toString().trim();
			if (idRole.equals("2")){
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
		
		
	}
	
	
	
	//inserta la notificacion
	private boolean addNotificationInternal(String localUser,String title, String message, int daysExpire)
	{
		hb_notifications notif=null;
		VinNotifications notificacion;
		VinNotificationsId notificacionId;
		hb_users auxUsr=null;
		try{
			
		
				//logado OK, hacemos la grabaci�n
				notificacion = new VinNotifications();
				auxUsr = new hb_users();
				
				//verifico que exista
				if (auxUsr.existLocalUser(localUser)==false)
				{
					return false; //no insertamos
				}
				
				//la PK
				notificacionId = new VinNotificationsId();
				notificacionId.setIdUser(localUser);
				notificacion.setId(notificacionId);
				
				//los datos
				notificacion.setChkDeleted(0);
				notificacion.setChkReaded(0);
				
				long t=new Date().getTime();
				Date dateAfter = new Date(t + (60*24*ONE_MINUTE_IN_MILLIS*daysExpire)); //fecha de expiraci�n
				
				
				notificacion.setDtSend(new Date());
				notificacion.setDtEnd(dateAfter);
				notificacion.setTitle(title);
				notificacion.setMessage(message);
				
				//sistema
				VinSystems aux = new VinSystems();
				aux.setIdSystem(userConected.getData(userConected.getPosDefaultSystem()).idSystem);
				notificacion.setVinSystems(aux);
				
				//grabacion
				notif = new hb_notifications();	
				return notif.addRegister(notificacion);	
		}
		catch(Exception e)
		{
			return false;
		}
		finally
		{
			if (notif!=null){notif.close_session_user();}
			if (auxUsr!=null){auxUsr.close_session_user();}
			auxUsr=null;
			notif=null;
			notificacion=null;
		
		}
	}
	
	
	
	
	
}
