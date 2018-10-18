package com.common.webservices.webSockets;

import java.io.IOException;
import javax.enterprise.context.ApplicationScoped;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.common.config.ParamsApp;
import com.common.server.queue.QueueTask;
import com.common.server.queue.Task;
import com.common.webservices.webSockets.model.wsSessionList;

@ApplicationScoped
@ServerEndpoint("/teams")
public class webSocketsTeams {

	 private static final wsSessionList sessions =  new wsSessionList();
	 
	 @OnOpen
	 public void open(Session session) {
		 	addLog("Begin Open Session: " + session.toString(), ParamsApp.LOG_TYPE_INFO);
		 	sessions.add(session);
	 }
	 
	 @OnClose
	 public void close(Session session) {
		 addLog("Begin Close Session: " + session.toString(), ParamsApp.LOG_TYPE_INFO);
		 
		 // remove from static list on This Backend
	     sessions.remove(session);
	     sessions.validateSessions(this); //remove all Close sessions
	 }

	 @OnError
	 public void onError(Throwable e) {
		 	addLog("onError: " + e.getStackTrace().toString(), ParamsApp.LOG_TYPE_ERROR);
		 	addLog("onError: " + e.getMessage().toString(), ParamsApp.LOG_TYPE_ERROR);
	 }
	 
	 @OnMessage
	 public void handleMessage(String message, Session session)  {
		 this.dispatchMessage(message, session);
	 }
	 
	 
	 // Dispach all Request  to Asyn Task for the executor Service
	 private void dispatchMessage(String message, Session session) {
		 
			  addLog("Begin dispatchMessage (" +  session.toString() + ") : " + message, ParamsApp.LOG_TYPE_INFO);

			  
			  // Command for LOG in Web scokets in Console.
			  if (message.toUpperCase().trim().equals("LOG")) {
				  sessions.printConsoleDataSessions();
				  return;
			  }
			  		  
			  
			  // Generate the JSON for Task
		   	  JSONHelper jsonData = new JSONHelper(message);
		   	  jsonData.addData("websocketid", session.toString()); //Add the WebSocket ID
		   	  String token = jsonData.getValue("token"); //extract the Token ID for security
		        	  
		   	  // create The main Task Evaluator
		   	  Task jobAsyn = new Task(token, true, "com.common.webservices.webSockets.tasksAsync.mainTaskWebSocket", jsonData.getDataString());
		      jobAsyn.setWebSocketID(session.toString());  //set the ID of Web Socket
		      jobAsyn.set_Priority(Task.HIGH_PRIORITY); // high priority for evalualtor.
			          
		      // Push to Execute
		      QueueTask.getInstance().add(jobAsyn);
			          
		   	  // free resources
		   	  jsonData.Dispose();
		   	  jsonData = null;
			          
	 }
	 
	 
		 
	 // Send Message to Client (only Text). Is called from Asyn Task of Service Executor.
	 public void SendToClientSession(String sessionId, String Message) throws IOException {
		 addLog("SendTextToClientSession:",ParamsApp.LOG_TYPE_INFO);
		 addLog("  - SessionID    : "+ sessionId,ParamsApp.LOG_TYPE_INFO);
		 addLog("  - Message      : " + Message,ParamsApp.LOG_TYPE_INFO);
		 
		 synchronized(sessions) {
			 
			 Session aux = sessions.getSession(sessionId);
			 
			 if (aux != null) {
				//Send
		        	addLog("  - ** Sending message (" +  aux.toString() + ") : " + Message, ParamsApp.LOG_TYPE_INFO);
		        	aux.getBasicRemote().sendText(Message);
			 }
			 else {
				 addLog("Session not Found!!! " + Message,ParamsApp.LOG_TYPE_ERROR);
			 }
			 
		     
		 }
	 }
	 
	 
	 
	 private void addLog(String Message, int severity) {
		 new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB_SOCKETS, Message, severity);
	 }
	 
}
