package com.teams.hibernate;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.saas.hibernate.hb_main_server;
import com.teams.models.teamChat;
import com.teams.models.teamMessage;

public class hb_teams_chats extends hb_main_server{

	// return the active chats of User
	@SuppressWarnings("rawtypes")
	public List<teamChat> getActiveChatsEmployee(String sociedad, String idEmpleado){
		
		
		Map row = null;
		List<?> data = null;
		List<teamChat> tableModel = new ArrayList<teamChat>();
		
		try {
		
				String SQL = "SELECT a.id, a.name, a.id_tp_chat, a.imageId, a.[description], a.id_creator_employee\n" + 
						"FROM teams_chats a, teams_chats_employees b\n" + 
						"WHERE a.id = b.id_chat and a.active = 1 and b.active = 1 and a.id_organization = :sociedad and b.id_employee = :employeeId";
				
				SQLQuery query  = getSqlQuery(SQL);
				query.setParameter("sociedad", sociedad);
				query.setParameter("employeeId", idEmpleado);
		
				//get the Data
				data = this.getDataFromQuery(query);
				
				//generate the model
				for (int z = 0;z < data.size(); z++)
				{	
					row = (Map)data.get(z);
					//add to the list
					tableModel.add(new teamChat((BigDecimal)row.get("id"), row.get("name").toString(), row.get("description"), row.get("id_creator_employee"), (BigDecimal)row.get("id_tp_chat"), row.get("imageId")));
				}
				//return model
				return tableModel;
		}
		catch(Exception e) {
			this.addLog("Error Teams function <getActiveChatsEmployee>", ParamsApp.LOG_TYPE_ERROR);
			this.addLog(e.getStackTrace().toString(), ParamsApp.LOG_TYPE_ERROR);
			return tableModel;
		}
		finally {
				row = null;
				data = null;
		}

		
	}
	
	
	
	
	// return the user messages
		@SuppressWarnings("rawtypes")
		public List<teamMessage> getUserMessages(String sociedad, String idEmpleado, String lastUpdate){
			
			
			Map row = null;
			List<?> data = null;
			List<teamMessage> tableModel = new ArrayList<teamMessage>();
			String SQL = "";
			SQLQuery query = null;
			
			try {
			
					if (lastUpdate == null || lastUpdate.equals("")) {
						 SQL = "\n" + 
								"  select a.id, a.id_chat, a.text, a.idfile, a.ext, a.sizefile , b.dt_read_employee \n" + 
								"  from teams_messages a, teams_messages_employees b\n" + 
								"  where a.id = b.id_message and b.id_organization = :sociedad and b.id_employee = :employeeId \n" + 
								"  and (b.send_client_id_process is null or b.send_client_status <= 0 or (b.send_client_status = 1 and b.send_client_timeout < SYSDATETIME()))"
								+ " order by a.id_chat asc";
						query  = getSqlQuery(SQL);
						query.setParameter("sociedad", sociedad);
						query.setParameter("employeeId", idEmpleado);
					}
					else {
						 SQL = "\n" + 
									"  select a.id, a.id_chat, a.text, a.idfile, a.ext, a.sizefile, b.dt_read_employee\n" + 
									"  from teams_messages a, teams_messages_employees b\n" + 
									"  where a.id = b.id_message and b.id_organization = :sociedad and b.id_employee = :employeeId \n" + 
									"  and  b.dt_send_client >= :lastUpdateClient"
									+ " order by a.id_chat asc";
						 
						query  = getSqlQuery(SQL);
						query.setParameter("sociedad", sociedad);
						query.setParameter("employeeId", idEmpleado);
						
						//Date Last update in client
						DateFormat formatter  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date last = formatter.parse(lastUpdate);
						query.setParameter("lastUpdateClient", last);
					}
						
					
					//get the Data
					data = this.getDataFromQuery(query);
					
					//generate the model
					for (int z = 0;z < data.size(); z++)
					{	
						row = (Map)data.get(z);
						//add to the list
						tableModel.add(new teamMessage((BigDecimal)row.get("id"), (BigDecimal)row.get("id_chat"), row.get("text"), row.get("idfile"), row.get("ext"), (BigDecimal)row.get("sizefile"), (Date)row.get("dt_read_employee")));
					}
					//return model
					return tableModel;
			}
			catch(Exception e) {
				this.addLog("Error Teams function <getUserMessages>", ParamsApp.LOG_TYPE_ERROR);
				this.addLog(e.getStackTrace().toString(), ParamsApp.LOG_TYPE_ERROR);
				return tableModel;
			}
			finally {
					row = null;
					data = null;
			}

			
		}
		
		// Update each message for one user as sender
		public void updateMessageAsProcessSend(String idProcess, String idOrganization, String idEmpleado, BigDecimal idMessage) {
			SQLQuery query = null;
			
			try {
				String SQL = "UPDATE teams_messages_employees SET send_client_id_process = :idprocess, send_client_status = :status,  send_id_server = :idServer,  send_client_timeout = :timeout "
						+ " where id_message = :idMessage and id_organization = :idOrganization and id_employee = :idEmpleado";
						
						// , send_client_timeout = :timeout
				
				query  = getSqlQuery(SQL);
				query.setParameter("idOrganization", idOrganization);
				query.setParameter("idEmpleado", idEmpleado);
				query.setParameter("idMessage", idMessage);
				query.setParameter("idprocess", idProcess);
				query.setParameter("idServer", ParamsApp.SYSTEM_SERVER_ID);
				query.setParameter("status", 1); //estatus sended to client
				
				//Expire Date
				Date expireDate = new Date( System.currentTimeMillis() + 20000L); //expire message in 20 seconds
				query.setParameter("timeout", expireDate);
				
				this.executeSqlAdvance(query);
			}
			catch(Exception e) {
				this.addLog("Error Teams function <updateMessageAsProcessSend>", ParamsApp.LOG_TYPE_ERROR);
				this.addLog(e.getStackTrace().toString(), ParamsApp.LOG_TYPE_ERROR);
			}
			finally {
				query = null;
			}
		}
		
		
			// Update all message for one user as confirm
		public void updateMessageAsProcessConfirm(String idProcess, String idOrganization, String idEmpleado) {
					SQLQuery query = null;
					
					try {
						String SQL = "UPDATE teams_messages_employees SET send_client_status = :status "
								+ " where id_organization = :idOrganization and id_employee = :idEmpleado and send_client_id_process = :idprocess";
						
						query  = getSqlQuery(SQL);
						query.setParameter("idOrganization", idOrganization);
						query.setParameter("idEmpleado", idEmpleado);
						query.setParameter("idprocess", idProcess);
						query.setParameter("status", 2); //estatus OK to client
						
						this.executeSqlAdvance(query);
					}
					catch(Exception e) {
						this.addLog("Error Teams function <updateMessageAsProcessConfirm>", ParamsApp.LOG_TYPE_ERROR);
						this.addLog(e.getStackTrace().toString(), ParamsApp.LOG_TYPE_ERROR);
					}
					finally {
						query = null;
					}
		}
		
		
		//Mark Message as Readed by a Employee
		public boolean readedMessageUser(BigDecimal idMessage, String idOrganization, String idEmpleado) {
					SQLQuery query = null;
					
					try {
						String SQL = "UPDATE teams_messages_employees SET dt_read_employee = SYSDATETIME() "
								+ " where id_message = :idMessage and id_organization = :idOrganization and id_employee = :idEmpleado ";
						
						query  = getSqlQuery(SQL);
						query.setParameter("idOrganization", idOrganization);
						query.setParameter("idEmpleado", idEmpleado);
						query.setParameter("idMessage", idMessage);
						
						if (this.executeSqlAdvance(query) == 0) {
							return true;
						}
						else {
							return false;
						}
					}
					catch(Exception e) {
						this.addLog("Error Teams function <readedMessageUser>", ParamsApp.LOG_TYPE_ERROR);
						this.addLog(e.getStackTrace().toString(), ParamsApp.LOG_TYPE_ERROR);
						return false;
					}
					finally {
						query = null;
					}
		}
		
	
}
