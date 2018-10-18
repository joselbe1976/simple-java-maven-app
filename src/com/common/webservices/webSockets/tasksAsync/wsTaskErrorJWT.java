package com.common.webservices.webSockets.tasksAsync;

import com.common.server.queue.Task;
import com.common.tools.interfaces.iTaskMethod;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.apiRest.responses.ResponsesStatus;
import com.common.webservices.webSockets.JSONHelper;
import com.common.webservices.webSockets.webSocketsTeams;

public class wsTaskErrorJWT implements iTaskMethod{

	@Override
	public void Dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected, Task taskArg) {

		webSocketsTeams ws = null;
		JSONHelper jsonData = null;
		String websocketID ="";

		
		try {
			
			jsonData = new JSONHelper(ArgsJson);
			websocketID = jsonData.getValue("websocketid");
			String token = jsonData.getValue("token"); 
			
			// comunicate with the client
			ws = new webSocketsTeams();
			
			String responseClient = getJsonResponse(jsonData, ResponsesStatus.RESPONSE_ERROR, ResponsesStatus.RESPONSE_ERROR_STRING + " - Error Login JWT", token);
			ws.SendToClientSession(websocketID, responseClient);
		}
		catch(Exception e) {
			
		}
		finally {
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
