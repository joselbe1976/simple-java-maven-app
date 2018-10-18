package com.teams.hibernate;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.saas.hibernate.hb_main_server;
import com.common.server.queue.QueueTask;
import com.common.server.queue.Task;
import com.common.webservices.apiRest.responses.ResponsesStatus;
import com.common.webservices.webSockets.JSONHelper;
import com.common.webservices.webSockets.webSocketsTeams;
import com.common.webservices.webSockets.model.wsSession;
import com.common.webservices.webSockets.model.wsSessionList;
import com.common.webservices.webSockets.tasksAsync.wsTaskGetUserMessages;
import com.teams.models.teamMessage;

public class hb_teams_messages extends hb_main_server{

	// Add Message Work Flow and return the idMessage
	public BigDecimal newMessageWorkFlow(BigDecimal idChat, String sociedad, String idOper, String idEmpleado, String text, String file, String ext, BigDecimal size) {
		

		// Step 1. Add Table messages and asign users / employees of this chat actives. The user that send message, mark it as sender.

		BigDecimal idMessageNew = insertMessage(idChat, sociedad,idOper, idEmpleado, text, file, ext, size);
		
		// Step 2.  Send Push notifications and To connect clients comunicate the chat messages
		
		
		
		// Step 3. Communicate with other Servers by Redis Server Chhanels
		
		
		
		return idMessageNew;  //return idMessage for client
		
		
	}
	
	

	
	
	
	// Inset Message in Data Base correctly
	@SuppressWarnings({ "rawtypes" })
	public BigDecimal insertMessage(BigDecimal idChat, String sociedad, String idOper, String idEmpleado, String text, String file, String ext, BigDecimal size)  {
		
		BigDecimal id = BigDecimal.valueOf(-1L);
		List<?> data = null;
		SQLQuery query = null;
		SQLQuery queryInsert = null;
		Map row = null;
		
		try {
		
				 // Step 1. Create Message definition
				
				String SQL = "INSERT INTO teams_messages (id_chat,dt_created,text,idfile, sizefile, all_employees_recibed, ext) VALUES(:idChat, SYSDATETIME(), :text, NULL, 0, 0, NULL); SELECT SCOPE_IDENTITY() as id";
				query  = getSqlQuery(SQL);
				query.setParameter("idChat", idChat);
				query.setParameter("text", text);
				data = this.getDataFromQuery(query);
				
				
				if (data.size() > 0) {
					row = (Map)data.get(0);
					id =  (BigDecimal)row.get("id");
				}
				
				
				// Step 2. Asign the message to active Chat users
				
				
				SQL = "select id_employee from teams_chats_employees where id_chat = :idchat and active = :active";
				query  = getSqlQuery(SQL);
				query.setParameter("idchat", idChat);
				query.setParameter("active", 1);
				data = this.getDataFromQuery(query);
				
				for (int i = 0 ; i < data.size() ; i++) {
					row = (Map)data.get(i);
					
					// Insert into Message Employees
					
					String SqlInsert = "insert into teams_messages_employees (id_message,id_organization, id_employee,dt_send_client, send_client_id_process, send_client_status, send_client_timeout, send_id_server,send_push, send_push_status,\n" + 
							"   dt_read_employee,dt_send_push_device ) values (:id, :idsociedad, :idEmpleado, SYSDATETIME(), :idOper, :status, '4000-01-01 00:00:00' , NULL, 0, NULL,:dtRead, NULL)";
				
					queryInsert  = getSqlQuery(SqlInsert);
					queryInsert.setParameter("id", id);
					queryInsert.setParameter("idsociedad", sociedad);
					queryInsert.setParameter("idEmpleado", row.get("id_employee").toString());
					
					// DT Read
					String noRead = "4000-01-01 00:00:00";
					DateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
					Date readMessage = formatter.parse(noRead);
					
					
					
					if (row.get("id_employee").toString().equals(idEmpleado)) {
						queryInsert.setParameter("status", 2);
						queryInsert.setParameter("idOper", idOper);
						queryInsert.setParameter("dtRead", new Date()); //mark as readed
					}
					else {
						queryInsert.setParameter("status", 0);
						queryInsert.setParameter("idOper", "");
						queryInsert.setParameter("dtRead", readMessage); //mark as No Readed
					}
					
					 this.executeSqlAdvance(queryInsert); //execute the Insert
				
				}
				
				
				
				// Step 2. Send Messages List to all connected users of this chat
				
				this.sendComunicationsToSubscbribeChat(idChat, id, text, file, sociedad, idEmpleado);
				
		}
		catch(Exception e) {
			this.addLog("Error Teams function <insertMessage>", ParamsApp.LOG_TYPE_ERROR);
			this.addLog(e.getStackTrace().toString(), ParamsApp.LOG_TYPE_ERROR);
		}
		finally {
			queryInsert = null;
			query = null;
			data = null;
			row = null;
		}
		
		return id;
	}
	
	
	
	// Connect to active Users and Send Messages. (Server --> Client)
	public void sendComunicationsToSubscbribeChat(BigDecimal idChat, BigDecimal idMessageNew, String text, String file, String sociedad,  String idEmpleado ) {
		
		
		try {
				this.addLog("Initi sendComunicationsToSubscbribeChat", ParamsApp.LOG_TYPE_INFO);
				
				// Find Employees to Send. Active subscribtion in the Chat.
				
				List<?> data =  this.getActiveUsersChatMessage(idMessageNew);
				webSocketsTeams ws = new webSocketsTeams();
				
				
				wsSessionList sessionWebSockets = new wsSessionList();
				
				
				this.addLog("  - EMPLEADOS ENVIAR ACTIVOS: " +  data.size(), ParamsApp.LOG_TYPE_INFO);
				
				
				// Bucle finding Active Users
				
				for (int i = 0 ; i < data.size() ; i++) {
					Map row = (Map)data.get(i);
					
					String idEmployee = row.get("id_employee").toString();
					String idOrganization = row.get("id_organization").toString();
					
					
					this.addLog("  - Empleado : " +  idEmployee, ParamsApp.LOG_TYPE_INFO);
					
					// Control of Connect
					wsSession session = sessionWebSockets.getEmployeeSessionActive(idEmployee, idOrganization);
					
					
					
					if (session != null) {
						// connected
						
						this.addLog("  - Session id WS (conected): " +  session.get_sesion().toString(), ParamsApp.LOG_TYPE_INFO);
						
						String webSocketSessionID = session.get_sesion().toString();
						String operID = this.generateOperId(session.get_userApp());
						
						// generate repsònse JSOn
						
						JSONHelper jsonData = new JSONHelper();
						jsonData.addData("operid",operID);  // Autogenerated by Server
						jsonData.addData("token", "");
						jsonData.addData("action", "GET-USER-MESSAGES");
						
						// get messages and create Response
						List<teamMessage> messagesUser = new hb_teams_chats().getUserMessages(idOrganization, idEmployee, "");
						this.addLog("  - num. Mensajes usuario : " + messagesUser.size(), ParamsApp.LOG_TYPE_INFO);
						
						//mark as sender the messages
						for (int zz= 0 ; zz < messagesUser.size();zz++) {
							new hb_teams_chats().updateMessageAsProcessSend(operID, idOrganization, idEmployee, messagesUser.get(zz).get_id());
						}
						this.addLog("  - Mensajes actualizados!!!. Generamos Response", ParamsApp.LOG_TYPE_INFO);
						
						String ResponseJson = new wsTaskGetUserMessages().getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_SUCCESS , ResponsesStatus.RESPONSE_SUCCESS_STRING, "", messagesUser);
					
						this.addLog("  - JSOn Generado para cliente : " + ResponseJson, ParamsApp.LOG_TYPE_INFO);
						
						// comunicate with the client
						
						try {
							ws.SendToClientSession(webSocketSessionID, ResponseJson);
						} catch (IOException e1) {
							e1.printStackTrace();
						}
						
						// Push notification
						
				
						
					}
					else {
						// not connected. Push notification
						this.addLog("  - Session id WS (not connected) : " +  session.get_sesion().toString(), ParamsApp.LOG_TYPE_INFO);
					}
				
				}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			
		}
		
		
		
		
		
	}
	
	private String generateOperId(String userApp) {
		return userApp + "JDLKSFJSLKDJFSKD";
	}
	
	
	// return list of Users / Employees of message pending to send
	private List<?> getActiveUsersChatMessage(BigDecimal idMessageNew){
		
		List<?> data = null;
		SQLQuery query = null;
		SQLQuery queryInsert = null;
		Map row = null;
		
		try {
			String SQL = "select id_organization, id_employee from teams_messages_employees\n" + 
					"  where id_message = :idMessage and send_client_status <= 0 ";
			query  = getSqlQuery(SQL);
			query.setParameter("idMessage", idMessageNew);
			data = this.getDataFromQuery(query);
			
		}
		catch(Exception e) {
			this.addLog("Error Teams function <getActiveUsersChatMessage>", ParamsApp.LOG_TYPE_ERROR);
			this.addLog(e.getStackTrace().toString(), ParamsApp.LOG_TYPE_ERROR);
		}
		finally {
			
		}
		
		return data;
		
	}
	
	
}
