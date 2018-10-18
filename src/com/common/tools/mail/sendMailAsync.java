package com.common.tools.mail;

import com.common.server.queue.QueueTask;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iDisposable;
import com.common.webservices.webSockets.JSONHelper;

public class sendMailAsync extends Thread implements iDisposable {

	private SendMail mail = null;
	public String email, subject, text = ""; 
	
	
	//Constructor
	public sendMailAsync() {
		mail = new 	SendMail();
	}
	
	public void Dispose() {
		if (mail != null) {mail.Dispose();}
		mail = null;
	}
	
	//set data to Send
	public void setMailData(String email, String subject, String text) {
		this.email = email;
		this.subject = subject;
		this.text = text;
	}
	
	
	//execution async
	public void run() {
		
		// Generqte the JSON for Task
				JSONHelper jsonData = new JSONHelper();
				try {
					// send mail Async
					// this.mail.sendMail(this.email, this.subject, this.text);


					jsonData.addData("to", this.email); // to
					jsonData.addData("subject", this.subject); // subject
					jsonData.addData("body", this.text); // body

					Task tarea = new Task("", false, "com.common.webservices.webSockets.tasksAsync.wsTaskMail",
							jsonData.getDataString());
					tarea.set_Priority(MIN_PRIORITY);
					tarea.setValidateLogin(false);

					// Push to Execute
					QueueTask.getInstance().add(tarea);

				} catch (Exception ex) {
					ex.printStackTrace();
				}finally {
			    		//finish
					if(!this.equals(null)) {
			    			this.Dispose();  //free resources
			    	}
					jsonData = null;
				}
        /*
		try {
        		//send mail Async
        		this.mail.sendMail(this.email, this.subject, this.text);
        		
        	
        		//finish
        		this.Dispose();  //free resources
        	
        } catch (Exception ex) {
            ex.printStackTrace();
        }    
        */
    }   
}
