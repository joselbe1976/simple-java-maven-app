package com.common.webservices.webSockets.tasksAsync;


import com.common.server.queue.QueueTask;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iTaskMethod;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.webSockets.JSONHelper;


public class mainTaskWebSocket implements iTaskMethod {

	@Override
	public void Dispose() {
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected, Task taskArg) {


		JSONHelper jsonData = null;
		
		try {

			jsonData = new JSONHelper(ArgsJson);
			String websocketID = jsonData.getValue("websocketid");
			String action = jsonData.getValue("action");  // webscoketTeams (dispacher) insert in Json this value
			String token = jsonData.getValue("token"); 
			Task jobAsyn = null;
			
			// evaluate the action of the WebSocket Client Call. We create a Task and push to execute.
			// Every action have a Task especific.
			
			switch(action) {
				case "INSIDE":
						jobAsyn = new Task(token, true, "com.common.webservices.webSockets.tasksAsync.wsTaskInside", jsonData.getDataString());
						jobAsyn.setLoginForzed(false); // force login to Meta4 Systems or other systems
						break;	
				case "GET-FILE":
						jobAsyn = new Task(token, true, "com.common.webservices.webSockets.tasksAsync.wsTaskFile", jsonData.getDataString());
						jobAsyn.setLoginForzed(false); 
						break;
				case "GET-USER-CHATS":
						jobAsyn = new Task(token, true, "com.common.webservices.webSockets.tasksAsync.wsTaskGetUserChats", jsonData.getDataString());
						jobAsyn.setLoginForzed(false); 
						break;
				case "GET-USER-MESSAGES":
						jobAsyn = new Task(token, true, "com.common.webservices.webSockets.tasksAsync.wsTaskGetUserMessages", jsonData.getDataString());
						jobAsyn.setLoginForzed(false); 
						break;
				case "CONFIRM-OPERATION-ID":
					jobAsyn = new Task(token, true, "com.common.webservices.webSockets.tasksAsync.wsTaskConfirmOperationID", jsonData.getDataString());
					jobAsyn.setLoginForzed(false); 
					break;
				case "READ-MESSAGE":
						jobAsyn = new Task(token, true, "com.common.webservices.webSockets.tasksAsync.wsTaskUserReadMessage", jsonData.getDataString());
						jobAsyn.setLoginForzed(false); 
						break;			
			
				case "SEND-MESSAGE":
					jobAsyn = new Task(token, true, "com.common.webservices.webSockets.tasksAsync.wsTaskSendMessage", jsonData.getDataString());
					jobAsyn.setLoginForzed(false); 
					break;
			
			}
			
			// push to Execute
			if (jobAsyn != null) {
				jobAsyn.setWebSocketID(websocketID);  //set the ID of Web Socket
			    jobAsyn.set_Priority(Task.HIGH_PRIORITY); // high priority 
			    QueueTask.getInstance().add(jobAsyn);
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return iTaskMethod.FINISH_ERROR;
		}
		finally {
			jsonData.Dispose();
			jsonData = null;
			
		}

		return iTaskMethod.FINISH_SUCCESS;
	}

}
