package com.common.webservices.webSockets.tasksAsync;

import java.io.IOException;


import com.common.config.ParamsApp;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iTaskMethod;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.apiRest.responses.ResponsesStatus;
import com.common.webservices.webSockets.JSONHelper;
import com.common.webservices.webSockets.webSocketsTeams;


public class wsTaskFile implements iTaskMethod {

	@Override
	public void Dispose() {

		
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected, Task task) {
		
		JSONHelper jsonData = null;
		String websocketID ="";
		String token = "";
		String idFile = "";
		String typeFile = "";
		webSocketsTeams ws = null;
		
		try {
			
			
			// Get the Web Socket of user connected
			jsonData = new JSONHelper(ArgsJson);
			websocketID = jsonData.getValue("websocketid");
			token = task.get_token();
			if (token == null) {
				token = jsonData.getValue("token");
			}
			
			idFile = jsonData.getValue("data");
			typeFile = jsonData.getValue("group");
			
			String json = "";
			
			
			if (typeFile.trim().toUpperCase().equals("CHAT") || typeFile.trim().toUpperCase().equals("MESSAGE")) {
				
				String path =  ParamsApp.TEAMS_PATH_FILES + idFile;
				String extension = new ParamsApp().getExtensionFile(path);
				String base64File = new ParamsApp().getValueFileBase64EncodeExtension(path, extension);
				
				json = getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_SUCCESS , ResponsesStatus.RESPONSE_SUCCESS_STRING, token, base64File, extension, idFile);
			}
			else {
				json = getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_ERROR_EXECUTING, ResponsesStatus.RESPONSE_ERROR_EXECUTING_STRING, token, "", "", idFile);
			}
			
	
			
			//Send data to client
			ws = new webSocketsTeams();
			ws.SendToClientSession(websocketID, json);
			
		
		}
		catch(Exception e) {
			//Send data to client
			ws = new webSocketsTeams();
			try {
				ws.SendToClientSession(websocketID, getJsonResponseProxy(jsonData, ResponsesStatus.RESPONSE_ERROR, ResponsesStatus.RESPONSE_ERROR_STRING, token, "", "", idFile));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			
			return iTaskMethod.FINISH_ERROR;
		}
		finally {
			ws = null;
		}
		
		return iTaskMethod.FINISH_SUCCESS;
	}
	
private String getJsonResponseProxy(JSONHelper jsonData, int status, String detail, String token, String file, String ext , String fileID) {
		
		JSONHelper json = new JSONHelper();
		
		json.addData("file", file);  //base64 string
		json.addData("ext", ext);  //file extension
		json.addData("fileId",fileID );
		json.addData("operid",jsonData.getValue("operid"));
		json.addData("status",status);
		json.addData("detail",detail);

		return json.getDataString();
	}
	

}
