package com.common.webservices.webSockets.tasksAsync;

import com.common.server.queue.Task;
import com.common.tools.interfaces.iTaskMethod;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.webSockets.JSONHelper;
import com.common.webservices.webSockets.model.wsSession;
import com.common.webservices.webSockets.model.wsSessionList;
import com.teams.hibernate.hb_teams_chats;


public class wsTaskConfirmOperationID implements iTaskMethod{
	@Override
	public void Dispose() {

		
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected, Task task) {
		JSONHelper jsonData = null;
		String websocketID ="";
		wsSessionList sessionWebSockets = null;
		String idOrganization = "", idEmployee = "";
		
		try {
			
			//access to Redis server to get the JSOn of Session Web scoket
			jsonData = new JSONHelper(ArgsJson);
			websocketID = jsonData.getValue("websocketid");

			// Session User Data
			
			if (userConected == null) {
				sessionWebSockets = new wsSessionList();
				synchronized(sessionWebSockets) {
					wsSession sesion = sessionWebSockets.getWsSession(websocketID);
					if (sesion != null) {
						idOrganization = sesion.get_idOrganization();
						idEmployee = sesion.get_idEmployee();
					}
				}
			}
			else {
				idOrganization = userConected.getIdOrganization();
				idEmployee = userConected.getIdEmployee();
			}
				
			
			
			// Update the state of id process
			 new hb_teams_chats().updateMessageAsProcessConfirm(jsonData.getValue("operid"),idOrganization, idEmployee);
			 
			 return iTaskMethod.FINISH_SUCCESS;
			 
		}
		catch(Exception e) {
			
			return iTaskMethod.FINISH_ERROR;
		}
		finally {
			jsonData = null;
			sessionWebSockets = null;
		}
		
		
	}

	
	
}
