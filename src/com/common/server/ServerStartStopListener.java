package com.common.server;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.servlet.*;

import org.hibernate.Session;

import com.common.config.ParamsApp;
import com.common.hibernate.HibernateUtil;
import com.common.hibernate.classes.server.hb_jobscheduler;

@SuppressWarnings("serial")
public class ServerStartStopListener  implements ServletContextListener{
	
	
	private  static ServiceExecutor serviceexecutor = null;
	private  static ScheduledExecutorService executor = null;
	
    @Override
	  public void contextDestroyed(ServletContextEvent arg0) {
	    //Notification that the servlet context is about to be shut down.   
		
    	  ParamsApp aux  = new ParamsApp();
    	
		  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, "****************************************************", ParamsApp.LOG_TYPE_INFO);
		  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, " (Stop Web Server) -   < eqMobile v2   -   build: 2.0.0 >", ParamsApp.LOG_TYPE_INFO);
		  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, " (Stop Web Server) -   < equilibrha mobile architecture >", ParamsApp.LOG_LEVEL_SESSION);
		  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, " (Stop Web Server) -   Stopping backend service ...", ParamsApp.LOG_TYPE_INFO);

	      
	      this.serviceexecutor.interrupt();
	      executor.shutdown();
	     
	  }

	  @Override
	  public void contextInitialized(ServletContextEvent arg0) {
			//instance the first time to force to load params
			  ParamsApp aux  = new ParamsApp();
			  
			  executor = Executors.newScheduledThreadPool(1);
			  
			  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, "****************************************************", ParamsApp.LOG_TYPE_INFO);
			  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, " (Start Web Server) -   < eqMobile v2   -   build: 2.0.0 >", ParamsApp.LOG_TYPE_INFO);
			  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, " (Start Web Server) -   < equilibrha mobile architecture >", ParamsApp.LOG_LEVEL_SESSION);
			  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, " (Start Web Server) -   Starting backend service ...", ParamsApp.LOG_TYPE_INFO);
			  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, " (Start Web Server) -   Loading Hibernate ...", ParamsApp.LOG_TYPE_INFO);
			   

	  	    // Force Hibernate Load Connection
		  	     try {
		  	    	 Session hibernateSession = HibernateUtil.getSessionFactory().openSession(); //Sesion de hibernate To Auxiliar
		  	     } 
		  	     catch(Exception e) {
		  	    	aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, "(Start Web Server) -     Error Loading Hibernate", ParamsApp.LOG_TYPE_ERROR);
		  	    	aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, e.getStackTrace().toString(), ParamsApp.LOG_TYPE_ERROR);
		  	     }

		  	     aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, "  Finish Loading Hibernate SUCCESS", ParamsApp.LOG_TYPE_INFO);
	  	      
	  	      //Start JobScheduler if is activate
	  	      
	  	      if (ParamsApp.JOBSCHEDULER_ACTIVATE.equals("Y")) {
					
	  	    	   	  Runnable jobSchedulerBackend = new Runnable() {
						    public void run() {
			   		  	        //every Some seconds, load task from database to queue
						    	hb_jobscheduler job = new hb_jobscheduler();
						    	job.loadTaskToQueue();
						    	job = null;
						    }
					  };
					  
			  	      aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, "  Starting JobScheduler Service ...", ParamsApp.LOG_TYPE_INFO);
				  
					  //execute  jobSchedulerBackend. Start JOB
					  executor.scheduleAtFixedRate(jobSchedulerBackend, ParamsApp.JOBSCHEDULER_FRECUENCY, ParamsApp.JOBSCHEDULER_FRECUENCY, TimeUnit.MILLISECONDS);
	  	      }
	  	      
	  	      
	  	      
	  	    // Start Teams Refresh Service
	  	    if (ParamsApp.TEAMS_SCHEDULER_ACTIVATE.equals("Y")) {
	  	    	 Runnable teamsSchedulerBackend = new Runnable() {
					    public void run() {
		   		  	        //every Some seconds, execute the Teams Service Executor
					    	teamsService tse = new teamsService();
					    	tse.execute();
					    	tse.Dispose();
					    	tse = null;
					    	
					    }
				  };
				  
				  aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, "  Starting Team Scheduler Service ...", ParamsApp.LOG_TYPE_INFO);
			  
				  //execute  service
				  executor.scheduleAtFixedRate(teamsSchedulerBackend, ParamsApp.TEAMS_SCHEDULER_FRECUENCY, ParamsApp.TEAMS_SCHEDULER_FRECUENCY, TimeUnit.MILLISECONDS);
				  
	  	    }
	  	      
	  	         
	  	    // start Executor Service as a Thread
	  	         aux.systemDebug(ParamsApp.LOG_LEVEL_SESSION, "(Start Web Server) -  Starting Service Executor ...", ParamsApp.LOG_TYPE_INFO);
			     this.serviceexecutor = new ServiceExecutor();
			     this.serviceexecutor.start();
	
	  }
	  
}
