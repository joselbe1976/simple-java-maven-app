package com.common.webservices.webSockets.tasksAsync;

import java.io.IOException;
import java.math.BigDecimal;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iTaskMethod;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.apiRest.responses.ResponsesStatus;
import com.common.webservices.webSockets.JSONHelper;
import com.common.webservices.webSockets.webSocketsTeams;
import com.common.webservices.webSockets.model.wsSession;
import com.common.webservices.webSockets.model.wsSessionList;
import com.teams.hibernate.hb_teams_messages;

public class wsTaskSendMessage implements iTaskMethod{
	@Override
	public void Dispose() {

		
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected, Task task) {
		JSONHelper jsonData = null;
		String websocketID ="";
		webSocketsTeams ws = null;
		String json = "";
		String token  = "";
		String idOrganization = "", idEmployee = "";
		wsSessionList sessionWebSockets = null;
		
		try {


			jsonData = new JSONHelper(ArgsJson);
			websocketID = jsonData.getValue("websocketid");
			token = task.get_token();
			if (token == null) {
				token = jsonData.getValue("token");
			}

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

			
			// get JSON Argument of the Message to insert
			
			String text = jsonData.getValue("text").toString();
			String file = jsonData.getValue("file").toString();
			String ext = jsonData.getValue("ext").toString();
			BigDecimal numbytes = BigDecimal.valueOf(Double.parseDouble(jsonData.getValue("size").toString()));
			BigDecimal idChat = BigDecimal.valueOf(Double.parseDouble(jsonData.getValue("idchat").toString()));
			
			
			// Control session is filled
			if (idOrganization.trim().equals("") || idEmployee.trim().equals("")) {
				json = getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_ERROR_EXECUTING, ResponsesStatus.RESPONSE_ERROR_EXECUTING_STRING + ". [User credential are void. Execute before method INSIDE]", token,BigDecimal.valueOf(-1L));
				return iTaskMethod.FINISH_SUCCESS;
			}
			else {
				
				
				// Insert Message
				 BigDecimal  idMessageInserted = new hb_teams_messages().insertMessage(idChat, idOrganization, jsonData.getValue("operid").toString(), idEmployee, text, file, ext, numbytes);
				 
				 
				 if (!idMessageInserted.equals(BigDecimal.valueOf(-1L))) {
					 json = getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_SUCCESS , ResponsesStatus.RESPONSE_SUCCESS_STRING, token, idMessageInserted);
				 }else {
					 json = getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_ERROR_EXECUTING, ResponsesStatus.RESPONSE_ERROR_EXECUTING_STRING, token,idMessageInserted);
				 }
			}
			 
			//Send data to client
			ws = new webSocketsTeams();
			ws.SendToClientSession(websocketID, json);
			 
			 return iTaskMethod.FINISH_SUCCESS;
			 
		}
		catch(Exception e) {
			 json = getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_ERROR, ResponsesStatus.RESPONSE_ERROR_STRING, token, BigDecimal.valueOf(-1L));
			//Send data to client
			ws = new webSocketsTeams();
			try {
				ws.SendToClientSession(websocketID, json);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			return iTaskMethod.FINISH_ERROR;
		}
		finally {
			sessionWebSockets = null;
			jsonData = null;
			ws = null;
		}
		
		
	}
	
	public String getJsonResponseProxy(JSONHelper jsonData, int status, String detail, String token,  BigDecimal  idMessageInserted ) {
		
		JSONHelper json = new JSONHelper();
		json.addData("operid",jsonData.getValue("operid"));
		json.addData("status", status);
		json.addData("detail", detail);
		json.addData("token", token);
		json.addData("id", idMessageInserted);
		
		
		return json.getDataString();
	}

}
