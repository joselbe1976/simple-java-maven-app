package com.common.hibernate.classes.server;


import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;

import com.common.config.ParamsApp;
import com.common.hibernate.classes.hb_main;
import com.common.server.queue.QueueTask;
import com.common.server.queue.Task;
import com.common.tools.interfaces.iDisposable;


public class hb_jobscheduler extends hb_main implements iDisposable{
	private static String className = "";

	// constructor class
	public hb_jobscheduler() {
		className = this.getClass().getSimpleName(); //Class name for logs
	}
	public void Dispose() {
	}
	
	
	// returns True if there are Task pending to Execute
	public boolean jobshedulerPendingTask() {
		List<?> data = null;
		
		try {

			data  = getPendingTask();
			
			if (data == null) {
				return false;
			}
			
			if (data.size() > 0) {
				return true;
			}
			
			return false;
		}
		catch(Exception e) {
			
			return false;
		}
		finally {
			data = null;
		}
		
	}
	
	
	// Load the Task to execute to the Queue of the backend
	public void loadTaskToQueue() {
		addLog("*** [Jobscheduler finding] ***", ParamsApp.LOG_TYPE_INFO);
		
		if (jobshedulerPendingTask()) {
			
			addLog("*** [Jobscheduler - There are Task to Execute] ***", ParamsApp.LOG_TYPE_INFO);
			
			//up to Queue the tasks
			Map row =null;
			List<?> data = null;
			
			try {
				
				 data = getPendingTask(); //get the task to execute
				 
				 for (int z = 0;z<data.size();z++)
					{
							row = (Map)data.get(z); //Extract the row
							
							//create a Task object with jobscheduler table row
							boolean isJWT =  ((int) row.get("tokenJWT")) == 1 ? true : false;
							Task job = new Task(row.get("token").toString(), isJWT, row.get("class").toString(), row.get("args").toString());
							job.setDbId((int)row.get("id"));
							job.set_Priority(Task.LOW_PRIORITY);
							
							//mark as Loaded in Queue
							setStatusAsExecuting((int) row.get("id"));
							
							Thread.sleep(4000); //time necesary for not blocking the queue, memory and CPU. And when there are more task of same user.
							
							//send to the Queue
							QueueTask.getInstance().add(job);
					}
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				row = null;
				data = null;
			}
		}
		
		
	}
	
	
	public boolean setStatusAsExecuting(int id) {
		String SQL ="update vin_jobscheduler set status = :status, comment = :comment ,log = :log where id = :id";
		
		SQLQuery query  = getSqlQuery(SQL);
		query.setParameter("status", 1);
		query.setParameter("comment", "Waiting to Execute");
		query.setParameter("id", id);
		query.setParameter("log", "Executing ....");
		
		int dev = executeSqlAdvance(query); //execute the update
		
		if (dev == 0) { //Execution OK
			addLog("Task from Jobscheduler (" + id +") is Executing", ParamsApp.LOG_TYPE_INFO);
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	public boolean setStatusAsExecuted(int id) {
		String SQL ="update  vin_jobscheduler set status = :status, comment = :comment ,log = :log, executiondate = :executiondate  where  id = :id";
		
		SQLQuery query  = getSqlQuery(SQL);
		query.setParameter("status", 2);
		query.setParameter("comment", "Executed");
		query.setParameter("id", id);
		query.setParameter("log", "Success Executed Task");
		query.setParameter("executiondate", new Date());
		
		int dev = executeSqlAdvance(query); //execute the update
		
		if (dev == 0) { //Execution OK
			addLog("Task from Jobscheduler (" + id +") is Executed OK", ParamsApp.LOG_TYPE_INFO);
			controlAutoJobsScheduler(id);
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	public boolean setStatusAsErrorExecuted(int id, String log) {
		String SQL ="update  vin_jobscheduler set status = :status, comment = :comment, log = :log ,executiondate = :executiondate where  id = :id";
		
		SQLQuery query  = getSqlQuery(SQL);
		query.setParameter("status", -1);
		query.setParameter("comment", "Error in the execution");
		query.setParameter("id", id);
		query.setParameter("log", log);
		query.setParameter("executiondate", new Date());
		
		int dev = executeSqlAdvance(query); //execute the update
		
		if (dev == 0) { //Execution OK
			addLog("Task from Jobscheduler (" + id +") is Executed with Error ("+log+")", ParamsApp.LOG_TYPE_INFO);
			controlAutoJobsScheduler(id);
			
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	private void controlAutoJobsScheduler(int id) {
		
		Map row = null;
			
		try {
				row = this.getTask(id);
				if (row != null) {
					
					int autoschedule = (int) row.get("autoschedule");
					int autoscheduleseconds = (int) row.get("autoscheduleseconds");
					
					if ( autoschedule == 1) {
						String token = row.get("token").toString();
						String user = row.get("user").toString();
						String args = row.get("args").toString();
						String clase = row.get("class").toString();
						boolean tokenJWT = (((int)row.get("tokenJWT")) == 1) ? true : false; 
						
						//Generate the new Scheduler Date
						Date date = new Date();
						long t=date.getTime();
						Date dateScheduleNew = new Date(t + (autoscheduleseconds * 1000));
						
						//scheduler in database
						addTaskJobScheduler(token,user,tokenJWT,args,clase,dateScheduleNew,autoschedule,autoscheduleseconds);
					}
					
				}
		}
		finally {}
	}
	
	//add Task to Scheduler in DataBase
	public boolean addTaskJobScheduler(String token, String user, boolean tokenJWT, String args, String clase, Date dtexec, int AutoSchedule, int AutoScheduleSeconds ) {
		String SQL ="insert into  vin_jobscheduler ( `user`, `token`, `tokenJWT`, `args`, `class`, `dtexec`, `status`, `comment`, `log`, `autoschedule`, `autoscheduleseconds`)";
		       SQL += " VALUES (:user, :token, :tokenJWT,  :args, :class, :dtexec, :status, :comment, :log, :autoschedule,  :autoscheduleseconds)";

		SQLQuery query  = getSqlQuery(SQL);
		query.setParameter("user", user);
		query.setParameter("token", token);
		query.setParameter("args", args);
		query.setParameter("class", clase);
		query.setParameter("autoschedule", AutoSchedule);
		query.setParameter("autoscheduleseconds", AutoScheduleSeconds);
		query.setParameter("log", "");
		query.setParameter("comment", "Scheduler");
		query.setParameter("status", 0);
		query.setParameter("dtexec", dtexec);
		
		if (tokenJWT) {
			query.setParameter("tokenJWT", 1);
		}
		else {
			query.setParameter("tokenJWT", 0);
		}

		
		int dev = executeSqlAdvance(query); //execute the update
		
		if (dev == 0) { //Execution OK
			addLog("Added Task to Jobscheduler in database", ParamsApp.LOG_TYPE_INFO);
			return true;
		}
		else {
			return false;
		}	
	}
	
	
	private List<?> getPendingTask(){
		String SQL ="select * from vin_jobscheduler where status = 0 and dtexec <= now()";
		SQLQuery query = null;
		List<?> data = null;
		
		try {
			query  = this.getSqlQuery(SQL);
			data  = this.getDataFromQuery(query); //execute SQL from Query Object
			
			return data;
		}
		catch(Exception e) {
			
			return null;
		}
		finally {
			query = null;
			data = null;
		}
	}
	
	private Map getTask(int id){
		String SQL ="select * from vin_jobscheduler where  id = :id";
		SQLQuery query = null;
		List<?> data = null;
		Map row = null;
		
		try {
			query  = this.getSqlQuery(SQL);
			query.setParameter("id", id);
			data  = this.getDataFromQuery(query); //execute SQL from Query Object
			
			if (data.size() > 0) {
				return (Map)data.get(0); //Extract the row
				
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			
			return null;
		}
		finally {
			query = null;
			data = null;
			row = null;
		}
	}
	
	
	
	
	
	//  ------  internal functions   -------
	
	public List<?> getDataSQLNativo(String SQL)
	{
		addLog("init: getDataSQLNativo: \n"+SQL+ "\n",ParamsApp.LOG_TYPE_INFO);
		
		List<?> data=null;
		
		String HSql = SQL;
		
		try{		
			    controlOpen();
				hibernateSession.beginTransaction();
				SQLQuery query =  hibernateSession.createSQLQuery(HSql);
				query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				data = query.list();
				hibernateSession.getTransaction().commit();
				hibernateSession.close();
				    
			}catch(HibernateException e)
				{
					addLog(e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
					hibernateSession.getTransaction().rollback();
				}
		finally{
			controlClose();
		}		

        return data;
	}

	public List<?> getDataFromQuery(SQLQuery Query)
	{
		List<?> data=null;
		
		try{		
			    controlOpen();
				hibernateSession.beginTransaction();
				Query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
				data = Query.list();
				hibernateSession.getTransaction().commit();
				hibernateSession.close();
				    
			}catch(HibernateException e)
				{
					addLog(e.getMessage(), ParamsApp.LOG_TYPE_ERROR);
					hibernateSession.getTransaction().rollback();
				}
		finally{
			controlClose();
		}		

        return data;
	}
	
	
	public SQLQuery getSqlQuery(String SQL){
		controlOpen();
		return hibernateSession.createSQLQuery(SQL);
	}
	
	
	//exec advance Sql (insert /delete /update)
		public int executeSqlAdvance(SQLQuery Query)
		{
			
			addLog("init: executeSqlAdvance"+Query.toString(),ParamsApp.LOG_TYPE_INFO);
			
			try{		
				    controlOpen();
						hibernateSession.beginTransaction();
							Query.executeUpdate(); //exec query
						hibernateSession.getTransaction().commit();
					hibernateSession.close();
					
					return 0; //ok
					    
				}catch(HibernateException e)
					{
						addLog(""+e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
						hibernateSession.getTransaction().rollback();
						return -1; //error
					}
			finally{
				controlClose();
			}		


		}
		
		
	
	// Debug class
	protected void addLog(String info, int logType)
	{
			new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_EXECUTORS_SERVICE, "("+className+") "+info, logType);
	}
	
	
}
