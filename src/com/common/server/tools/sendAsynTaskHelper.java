package com.common.server.tools;


import com.common.server.queue.QueueTask;
import com.common.server.queue.Task;
import com.common.webservices.webSockets.JSONHelper;

public class sendAsynTaskHelper {

	
	
	public void AsynInsertStadisticsServer(String user, String process, String text) {
		
		
		// Generate JSON
		JSONHelper jsonData = new JSONHelper();
	    jsonData.addData("user", user); 
	    jsonData.addData("process", process); 
	    jsonData.addData("text", text); 
		
		// Send to Execute
		
		Task jobAsyn = null;
		jobAsyn = new Task("", true, "com.common.webservices.webSockets.tasksAsync.hbTaskStadistics", jsonData.getDataString());
		jobAsyn.setValidateLogin(false);  //No Validate the Token
		jobAsyn.setWebSocketID("");  //NO web scoket
	    jobAsyn.set_Priority(Task.LOW_PRIORITY); // low priority because is persistence no priority
	    QueueTask.getInstance().add(jobAsyn); //send to the queue
		
	}
	
}
