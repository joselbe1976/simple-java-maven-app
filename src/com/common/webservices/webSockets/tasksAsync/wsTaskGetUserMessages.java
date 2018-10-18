package com.common.webservices.webSockets.tasksAsync;

import java.io.IOException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iTaskMethod;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.apiRest.responses.ResponsesStatus;
import com.common.webservices.webSockets.JSONHelper;
import com.common.webservices.webSockets.webSocketsTeams;
import com.common.webservices.webSockets.model.wsSession;
import com.common.webservices.webSockets.model.wsSessionList;
import com.teams.hibernate.hb_teams_chats;
import com.teams.models.teamMessage;

public class wsTaskGetUserMessages implements iTaskMethod{
	@Override
	public void Dispose() {

		
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected, Task task) {
		JSONHelper jsonData = null;
		String websocketID ="";
		String token = "";
		webSocketsTeams ws = null;
		String lastUpdateClient = "";
		String idOrganization = "", idEmployee = "";
		wsSessionList sessionWebSockets = null;
		
		try {
			// Get the Web Socket of user connected
			jsonData = new JSONHelper(ArgsJson);
			websocketID = jsonData.getValue("websocketid");
			token = task.get_token();
			if (token == null) {
				token = jsonData.getValue("token");
			}
			
			lastUpdateClient = jsonData.getValue("lastupdate");  // the last Client Update in Realm (in devices and ElectronJS)
			
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
			
			//get the Employee Chats
			List<teamMessage> messagesUser = new hb_teams_chats().getUserMessages(idOrganization, idEmployee, lastUpdateClient);
			String json = this.getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_SUCCESS , ResponsesStatus.RESPONSE_SUCCESS_STRING, token, messagesUser);
			
			
			// Mark all messages as process Send, if is with lastupdate, not mark nothing
			
			if (lastUpdateClient == null || lastUpdateClient.equals("")) {
				for (int i = 0 ; i < messagesUser.size(); i++) {
					new hb_teams_chats().updateMessageAsProcessSend(jsonData.getValue("operid"), idOrganization, idEmployee, messagesUser.get(i).get_id());
				}
			}
			
			
			//Send data to client
			ws = new webSocketsTeams();
			ws.SendToClientSession(websocketID, json);
			
		
		}
		catch(Exception e) {
			
			String json = this.getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_ERROR, ResponsesStatus.RESPONSE_ERROR_STRING, token, null);

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
			ws = null;
			sessionWebSockets = null;
		}
		
		return iTaskMethod.FINISH_SUCCESS;
	}

	
	public String getJsonResponseProxy(JSONHelper jsonData, int status, String detail, String token, List<teamMessage> messageUser ) {
		
		JSONHelper json = new JSONHelper();
		json.addData("operid",jsonData.getValue("operid"));
		json.addData("status", status);
		json.addData("detail", detail);
		json.addData("token", token);
		json.addData("action", jsonData.getValue("action"));
		
		JSONArray array = new JSONArray();
		
		if (messageUser != null) {
			for (int i = 0 ; i<messageUser.size(); i++) {
				
				JSONObject item  = new JSONObject();
				item.put("idchat", messageUser.get(i).get_idChat());
				item.put("idmessage", messageUser.get(i).get_id());
				item.put("text", messageUser.get(i).get_text());
				item.put("file", messageUser.get(i).get_idFile());
				item.put("ext", messageUser.get(i).get_extFile());
				item.put("size", messageUser.get(i).get_sizeFile()); //in bytes
				item.put("readed", messageUser.get(i).get_isReaded()); // 1 = Yes, 0 = No
	
				// Add to Array
				array.put(item);
			}

		}
		json.addData("data", array);  //array of data
		
		
		return json.getDataString();
	}
}
