package com.common.server;

import java.lang.reflect.Method;
import java.util.Random;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.server.hb_jobscheduler;
import com.common.server.queue.QueueTask;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iDisposable;
import com.common.tools.interfaces.iTaskMethod;
import com.common.webservices.apiRest.auxiliar.AuthHelper;
import com.common.webservices.apiRest.auxiliar.loginSessionJwt;
import com.common.webservices.apiRest.models.TokenInfo;

public class ExecutorTask extends Thread implements iDisposable  {
	
	// STATUS of one executor Task
	public static final int STATUS_FREE = 0;
	public static final int STATUS_EXECUTING = 2;
	public static final int STATUS_FINISH = 1;
	public static final int STATUS_ASIGNED = 3;
	public static final int STATUS_FINISH_ERROR = 5;
	public static final int STATUS_LOGIN_ERROR = 6;
	
	private String _className;
	private  int _status = ExecutorTask.STATUS_FREE; //status of this executor. Only Read
	private int _debug;
	private TokenInfo data = null;
	
	public int get_status() {
		return _status;
	}

	private Task task; //the task to execute
	
	//constructor
	public ExecutorTask() {
		this._status = ExecutorTask.STATUS_FREE;
		this._className = this.getClass().getSimpleName();
		this._debug = ParamsApp.SERVICE_EXECUTOR_DEBUG; //debug od service executor
	}

	public void  setTask(Task task) {
		this.task = task;
		this._status = STATUS_ASIGNED;

	}
	
	//log class
	protected void addLog(String info, int Type)
	{
		if (this._debug == 1) {
			new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_EXECUTORS_SERVICE, "("+_className+") "+info,Type);
		}
	}	
	
	
	@Override
	public void run() {
		
		hb_jobscheduler jobscheduler = new hb_jobscheduler();

		this._status = ExecutorTask.STATUS_EXECUTING; // Executing state
		
		//Execute the Task
		try {
			this.addLog("Start Executing Task: "  + task.getWebSocketID(), ParamsApp.LOG_TYPE_INFO);
			
			String internalToken = "";
			
			if (this.task.isValidateLogin()) {
			
					//step1. Credential Control of The token ID.
					if (this.task.is_tokenJWT()) {
						
						//if Is WebSockets only verify 
						
						if (this.task.getWebSocketID().length() == 0 || this.task.isLoginForzed() == true) {
							 data = AuthHelper.verifyTokenAndInternalControl(this.task.get_token(), "task"); //slow more secure
						}
						else
						{
							 data = AuthHelper.verifyToken(this.task.get_token()); //verify token. Faster
						}
						
						if (data == null) {
							 this.addLog("The token ("+this.task.get_token()+") cant be validate with JWT Validation Token" , ParamsApp.LOG_TYPE_WARNING);
							 this._status = ExecutorTask.STATUS_LOGIN_ERROR; // Executing state FINISH with Error
							 
							 
							 
							 
								// if is a Jobscheduler Task, persist the status
								if (this.task.getDbId() != -1) {
									jobscheduler.setStatusAsErrorExecuted(this.task.getDbId(),"Cant be validate the Token JWT of the Task. Not executed.");
								}
								else {
									// Send Error JWT to the CLient
									this.SendErrorToClient(this.task.get_token(), this.task.getWebSocketID(), this.task.get_argumentJson());
								}
							 return;
							 
						}
						else {
							internalToken = data.getInternalToken(); //get the internal Token
							this.task.set_token(data.getTokenUserReturn()); // set the Token if change set the correct new Token
						}
					}
					else {
						loginSessionJwt logon = new loginSessionJwt();
						internalToken = logon.JWTinternalControl(this.task.get_token(), "", "task"); 
						
						if (internalToken.equals("")) {
							// Error, tolen not run OK
							 this.addLog("The token ("+this.task.get_token()+") cant be validate with Internal Token" , ParamsApp.LOG_TYPE_WARNING);
							 this._status = ExecutorTask.STATUS_LOGIN_ERROR; // Executing state FINISH with Error
							 
								// if is a Jobscheduler Task, persist the status
								if (this.task.getDbId() != -1) {
									jobscheduler.setStatusAsErrorExecuted(this.task.getDbId(),"cant be validate with Internal Token. Not executed.");
								}
								else {
									// Send Error JWT to the CLient
									this.SendErrorToClient(this.task.get_token(), this.task.getWebSocketID(), this.task.get_argumentJson());
									this.addLog("       - Send Error to Client",ParamsApp.LOG_TYPE_WARNING);
								}
							 return;
						}
						
					}
			}
			else {
				//not validate tokens
				this.addLog("  - Not validate Login or Tokens",ParamsApp.LOG_TYPE_INFO);
			}
			
			//Step 2. Execute the Method by Reflexion
			
				// Get The class
				Class classAux = Class.forName(this.task.get_className());
			
				//Intance The class
				Object iClass = classAux.newInstance();
			
				
				//Get The method argument
				@SuppressWarnings("rawtypes")
				Class params[] = {String.class, TokenInfo.class, Task.class}; //define argument
				Object[] args = new Object[]{new String(this.task.get_argumentJson()), data, this.task}; //arguments are 3 only
				
				//Execute the Method (the class has to use a interface(
				@SuppressWarnings("unchecked")
				Method thisMethod = classAux.getDeclaredMethod("Execute", params);
				
				if (Integer.parseInt(thisMethod.invoke(iClass, args).toString()) == iTaskMethod.FINISH_SUCCESS) {
					this.addLog("Executed SUCCESS: "  + task.get_id() , ParamsApp.LOG_TYPE_INFO);
					this._status = ExecutorTask.STATUS_FINISH; // Executing state FINISH
					
					// if is a Jobscheduler Task, persist the status
					if (this.task.getDbId() != -1) {
						jobscheduler.setStatusAsExecuted(this.task.getDbId());
					}
					
				}
				else {
					this.addLog("Executed ERROR: "  + task.getWebSocketID() , ParamsApp.LOG_TYPE_INFO);
					this._status = ExecutorTask.STATUS_FINISH_ERROR; // Executing state FINISH
					
					// if is a Jobscheduler Task, persist the status
					if (this.task.getDbId() != -1) {
						jobscheduler.setStatusAsErrorExecuted(this.task.getDbId(),"Error in service executor of this task. Find error in Service Executer log file");
					}
				}
			
			 this.addLog("End Executing Task: "  + task.getWebSocketID(), ParamsApp.LOG_TYPE_INFO);
			 
			 
		} catch (Exception e) {
			 this.addLog("Error Executing Task!!!!!" , ParamsApp.LOG_TYPE_ERROR);
			// if is a Jobscheduler Task, persist the status
			if (this.task.getDbId() != -1) {
					jobscheduler.setStatusAsErrorExecuted(this.task.getDbId(),"Error in service executor of this task. Find error in Service Executer log file. The token credential are bad");
			}
			else {
				// Send Error JWT to the CLient
				this.SendErrorToClient(this.task.get_token(), this.task.getWebSocketID(), this.task.get_argumentJson());
			}
		}
		finally {
			jobscheduler.Dispose();
			jobscheduler = null;
			
		}

	}

	@Override
	public void Dispose() {
		this.task = null; 
	}
	
	
	
	// only in case of Web Sockets
	private void SendErrorToClient(String token, String websocketID, String jsonData) {
		
		//Only for Web Sockets
		
		if (websocketID == null || websocketID.equals("")) {return;}
		
		
		Task jobAsyn = null;
		jobAsyn = new Task(token, false, "com.common.webservices.webSockets.tasksAsync.wsTaskErrorJWT", jsonData);
		jobAsyn.setValidateLogin(false); //login Control and Credencialts JWt desactivate for executor Task (this clas)
		jobAsyn.setWebSocketID(websocketID);  //set the ID of Web Socket
	    jobAsyn.set_Priority(Task.LOW_PRIORITY); // Low priority 
	    
	    //Add the the queue
	    QueueTask.getInstance().add(jobAsyn);
	}

}
