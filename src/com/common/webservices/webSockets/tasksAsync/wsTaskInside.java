package com.common.webservices.webSockets.tasksAsync;

import java.io.IOException;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iTaskMethod;
import com.common.webservices.apiRest.auxiliar.AuthHelper;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.apiRest.responses.ResponsesStatus;
import com.common.webservices.webSockets.JSONHelper;
import com.common.webservices.webSockets.webSocketsTeams;

import com.common.webservices.webSockets.model.wsSessionList;


public class wsTaskInside implements iTaskMethod {

	@Override
	public void Dispose() {

		
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected,Task taskArg) {
		
		// The client is inside app or Web.
		
		JSONHelper jsonData = null;
		webSocketsTeams ws = null;
		String user = "", token = "", websocketID ="";
		
		try {
			
			jsonData = new JSONHelper(ArgsJson);
			websocketID = jsonData.getValue("websocketid");
			token = taskArg.get_token();
			if (token == null) {
				token = jsonData.getValue("token");
			}
			
			if (userConected == null) {
				userConected = AuthHelper.verifyToken(token);  //generate the values of the Token
			}
			
			
			
			if (userConected != null) {
				user = userConected.getUserId();
			}
			
					
			// set Data in WebSockets Sessions for id organization, id employee, etc
			wsSessionList aux = new wsSessionList();
			synchronized(aux) {
				 aux.setDataSession(websocketID, userConected.getIdOrganization(), userConected.getIdEmployee(), userConected.getFaseAlta(), user, userConected.getDeviceType(), userConected.getSSOOType());
			}
			
			
			 String responseClient = getJsonResponse(jsonData, ResponsesStatus.RESPONSE_SUCCESS, ResponsesStatus.RESPONSE_SUCCESS_STRING, taskArg.get_token());
			
			 ws = new webSocketsTeams();
			 ws.SendToClientSession(websocketID, responseClient);
			
			
		
		}
		catch(Exception e) {
			e.printStackTrace();
			 String responseClient = getJsonResponse(jsonData, ResponsesStatus.RESPONSE_ERROR, ResponsesStatus.RESPONSE_ERROR_STRING, taskArg.get_token());
			 ws = new webSocketsTeams();
			 try {
				 // Send error to client
				ws.SendToClientSession(websocketID, responseClient);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return iTaskMethod.FINISH_ERROR;
		}
		finally {
			if (jsonData != null) {jsonData.Dispose();}
			jsonData = null;
			ws = null;
		}
	

		return iTaskMethod.FINISH_SUCCESS;
	}
	

	
	private String getJsonResponse(JSONHelper jsonData, int status, String detail, String token ) {
		
		JSONHelper json = new JSONHelper();
		json.addData("operid",jsonData.getValue("operid"));
		json.addData("status", status);
		json.addData("detail", detail);
		json.addData("token", token);
		
		return json.getDataString();
	}

}
