package com.common.webservices.webSockets.tasksAsync;

import com.common.hibernate.classes.hb_statistics;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iTaskMethod;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.webSockets.JSONHelper;


public class hbTaskStadistics implements iTaskMethod{

	@Override
	public void Dispose() {
		
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected, Task task) {

		JSONHelper jsonData = null;
		
		try {
		
			//Get JSOn Params
			jsonData = new JSONHelper(ArgsJson);
			String user = jsonData.getValue("user"); 
			String process = jsonData.getValue("process"); 
			String text = jsonData.getValue("text"); 
			
			
			//Save
			new hb_statistics().insertEstadistics(user, process, text);
		
		}
		catch(Exception e) {
			return iTaskMethod.FINISH_ERROR;
		}
		finally {
			jsonData = null;
		}
		
		return iTaskMethod.FINISH_SUCCESS;
	
	}

}
