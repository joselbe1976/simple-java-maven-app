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
import com.teams.models.teamChat;

public class wsTaskGetUserChats implements iTaskMethod {

	@Override
	public void Dispose() {

		
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected, Task task) {
		JSONHelper jsonData = null;
		String websocketID ="";
		String token = "";
		webSocketsTeams ws = null;
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
			List<teamChat> chatsUser = new hb_teams_chats().getActiveChatsEmployee(idOrganization, idEmployee);
			String json = this.getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_SUCCESS , ResponsesStatus.RESPONSE_SUCCESS_STRING, token, chatsUser);
			
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
				// TODO Auto-generated catch block
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

	
	private String getJsonResponseProxy(JSONHelper jsonData, int status, String detail, String token, List<teamChat> chatsUser ) {
		
		JSONHelper json = new JSONHelper();
		json.addData("operid",jsonData.getValue("operid"));
		json.addData("status", status);
		json.addData("detail", detail);
		json.addData("token", token);
		
		JSONArray array = new JSONArray();
		
		if (chatsUser != null) {
			for (int i = 0 ; i<chatsUser.size(); i++) {
				
				JSONObject item  = new JSONObject();
				item.put("id", chatsUser.get(i).get_id());
				item.put("name", chatsUser.get(i).get_name());
				item.put("descrip", chatsUser.get(i).get_description());
				item.put("idEmployeeCreator", chatsUser.get(i).get_idEmployeeCreator());
				item.put("image", chatsUser.get(i).get_image());
				item.put("typechat", chatsUser.get(i).get_typeChat());
				
	
				// Add to Array
				array.put(item);
			}

		}
		json.addData("data", array);  //array of data
		
		
		return json.getDataString();
	}
	
	
}
