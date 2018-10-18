package com.common.server;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.common.config.ParamsApp;
import com.common.server.queue.QueueTask;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iDisposable;

public class ServiceExecutor extends Thread implements iDisposable {

	private int _numMaxExecutors;
	private int _timeDelay;  
	private String className;
	private int _debug;
	
	QueueTask queue; 
	List<ExecutorTask> Executors; //Executor List
	
	//constructor
	public ServiceExecutor() {
		queue = QueueTask.getInstance(); //instance the singleton
		this.Executors = new ArrayList<ExecutorTask>(); //init the List
		
		
		ParamsApp aux = new ParamsApp(); //force instance
		
		this.className = this.getClass().getSimpleName();
		
		//params
		this._numMaxExecutors = ParamsApp.SERVICE_EXECUTOR_MAX_EXECUTORS;
		this._timeDelay = ParamsApp.SERVICE_EXECUTOR_DELAY_TIME;
		this._debug = ParamsApp.SERVICE_EXECUTOR_DEBUG; //debug od service executor

	}

	@Override
	public void Dispose() {
		queue = null;
	}
	
	//log class
	protected void addLog(String info, int Type)
	{
			if (this._debug == 1) {
				new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_EXECUTORS_SERVICE, "("+className+") "+info,Type);
			}
	}		
	
	
	//internal Methods
	
	private int getNumExecutors() {
		return this.Executors.size();
	}

	public int getNumFreeExecutors() {
		int num = 0;
		
		//remeove all Finish
		deleteAllFinish();
		
		for (int i = 0; i < this.Executors.size(); i++) {
			if (this.Executors.get(i).get_status() == ExecutorTask.STATUS_FREE) {
				num++;
			}
		}
		
		return num;

	}
	
	private int getPosFreeExecutor() {
		//remeove all Finish
		deleteAllFinish();
		
		for (int i = 0; i < this.Executors.size(); i++) {
			if (this.Executors.get(i).get_status() == ExecutorTask.STATUS_FREE) {
				return i;
			}
		}
		return -1;
	}
	
	// Fill all executors 
	private void fillAllExecutors() {
		for (int i = this.Executors.size(); i < this._numMaxExecutors ; i++) {
			this.Executors.add(new ExecutorTask());
		}
		
	}
	
	//Recursive Delete Finish Executors
	private void deleteAllFinish() {
		for (int i = 0; i < this.Executors.size(); i++) {
			if (this.Executors.get(i).get_status() == ExecutorTask.STATUS_FINISH || this.Executors.get(i).get_status() == ExecutorTask.STATUS_FINISH_ERROR || this.Executors.get(i).get_status() == ExecutorTask.STATUS_LOGIN_ERROR) {
				
				//recursive Call
				this.Executors.remove(i);
				deleteAllFinish();
				return;
		
			}
		}
		
		fillAllExecutors();
	}
	
	private ExecutorTask getFreeExecutor() {

		try {
				int pos  = -1;
			
				//remeove all Finish
				deleteAllFinish();
				
				
				//if There are Free Executor
				if (getNumFreeExecutors() > 0) {
					pos = getPosFreeExecutor();
				}
			
				if (pos != -1) {
					//free executor
					return this.Executors.get(pos);
				}
				else {
					//no Free executor. Control max
					
					if (this._numMaxExecutors  > getNumExecutors()) {
						 // Create New Executor
						this.Executors.add(new ExecutorTask());
						pos = getPosFreeExecutor();
						return this.Executors.get(pos); //return the executor
					}
					else {
						
						//wait to Free Executor, because the Array is Full of max of items executorTaask. Cant create new more...
						this.addLog("Waiting for Free Executor ...", ParamsApp.LOG_TYPE_INFO);
						while (getPosFreeExecutor() == -1) {
							Thread.sleep(_timeDelay); //wait
							this.addLog("Waiting for Free Executor ...", ParamsApp.LOG_TYPE_INFO);
						}
						this.addLog("Free Executors Ready!", ParamsApp.LOG_TYPE_INFO);
						
						//OK hay ejecutor libre
						pos = getPosFreeExecutor();
						return this.Executors.get(pos); //return the executor
						
					}
				}
		   }
		   catch (Exception e) {
			   return null;
		   }
		
	}
	
	
	
	@Override
	public void run() {
		
		// Delay 5 seconds in first execution for wait to tomcat to Start
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

		while(true) {
			try {
					
					while (this.queue.getTotalSize() > 0) {
						
						//get the Task
						Task task = this.queue.poll();
						
						// get Free executor
						ExecutorTask executer = this.getFreeExecutor(); 
						executer.setTask(task); //set the task for execute
						
						//logs
						this.addLog("Send to Execute Task id: "  + task.getWebSocketID() , ParamsApp.LOG_TYPE_INFO);
	
						//Execution Start
						executer.start(); //Start de Thread
						
						// Wait 
						Thread.sleep(_timeDelay/5); 
					}
					
					Thread.sleep(_timeDelay*2);  //time to Wait to find Tasks
					
				
			} catch (InterruptedException e) {
				this.addLog("Error Service Executor..." , ParamsApp.LOG_TYPE_ERROR);
				e.printStackTrace();
				
			}
			catch (Exception e) {
				this.addLog("Error Service Executor..." , ParamsApp.LOG_TYPE_ERROR);
				e.printStackTrace();
			}
			
			
			
		}	
	}

	
}
