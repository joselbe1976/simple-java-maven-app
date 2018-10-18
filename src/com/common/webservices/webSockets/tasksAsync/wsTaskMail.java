package com.common.webservices.webSockets.tasksAsync;


import com.common.server.queue.Task;
import com.common.tools.interfaces.iTaskMethod;
import com.common.tools.mail.SendMail;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.webSockets.JSONHelper;

public class wsTaskMail implements iTaskMethod{

	@Override
	public void Dispose() {
		
	}

	@Override
	public int Execute(String ArgsJson, TokenInfo userConected, Task task) {
		
		
		JSONHelper jsonData = null;
		SendMail mail = null;
		
		try {
			
			// get mail argument
			jsonData = new JSONHelper(ArgsJson);
			String to = jsonData.getValue("to"); 
			String subject = jsonData.getValue("subject"); 
			String body = jsonData.getValue("body"); 
			
			//send mail
			mail = new SendMail();
			mail.sendMail(to, subject, body);
			
			return iTaskMethod.FINISH_SUCCESS;
			
		}
		catch(Exception e) {
			return iTaskMethod.FINISH_ERROR;
		}
		finally {
		    if (mail != null) {mail.Dispose();}
			mail = null;
		}
		
		
	}
	
	
}