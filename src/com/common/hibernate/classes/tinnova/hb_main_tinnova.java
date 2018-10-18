/*
 * Jose Luis Bustos Esteban. Clase base que heredan el resto de HB_class
 *
 */
package com.common.hibernate.classes.tinnova;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.common.config.ParamsApp;
import com.common.hibernate.HibernateUtil;
import com.common.hibernate.entidades.tinnova.*;
import com.common.pushnotifications.Parse.parseOperations;
import com.common.tools.interfaces.iDisposable;

import javax.persistence.Entity; 
import javax.persistence.Table; 



public class hb_main_tinnova implements iDisposable {

	protected boolean debug = false;
	protected String className = "";
	protected String tableClassBase="";
	protected String tableClassView="";
	

	
	
	//Atributos
	public Session hibernateSession;
	
	
	//Parse.com
	parseOperations parse;
	
	
	//Contructor
	public hb_main_tinnova()
	{
		try {
			this.hibernateSession = HibernateUtil.getSessionFactoryTinnova().openSession(); //Sesion de hibernate for Tinnova
			this.className = this.getClass().getSimpleName(); //nombre de la clase
			new ParamsApp();
			if (ParamsApp.SYSTEM_DEBUG == 1) {debug=true;}
		} catch (HibernateException erro) {
			// TODO Auto-generated catch block
			 System.out.println(erro.getMessage());
		}
	}
	
	
	public void Dispose() {
		this.finalize();
	}
	
	//Destructor
	protected void finalize()
	{
		
		try {
			if (this.hibernateSession!=null){

				if (this.hibernateSession.isOpen()==true)
				{
					this.hibernateSession.close(); //Cerramos session hibernate
					this.hibernateSession=null; 
					//addLog("(finalize): Destructor execution");
				}
			}
		} catch (HibernateException erro) {
			// TODO Auto-generated catch block
			 System.out.println(erro.getMessage());
		}
		finally{this.hibernateSession=null;}
	}
	
	public void controlOpen()
	{
		
		try {
			if (this.hibernateSession==null){
				this.hibernateSession = HibernateUtil.getSessionFactoryTinnova().openSession();
			}
			else{

				if (this.hibernateSession.isOpen()==false)
				{
					this.hibernateSession = HibernateUtil.getSessionFactoryTinnova().openSession();
				}
			}
		} catch (HibernateException erro) {
			// TODO Auto-generated catch block
			 System.out.println(erro.getMessage());
		}
	
	}
	
	public void controlClose()
	{
		try {
			if (this.hibernateSession!=null){
				

				if (this.hibernateSession.isOpen()==true)
				{
					this.hibernateSession.close();
				}
			}
		} catch (HibernateException erro) {
			// TODO Auto-generated catch block
			 System.out.println(erro.getMessage());
		}
	}
	
	//close session by developer
	public void close_session_user()
	{
		try {
			if (this.hibernateSession.isOpen()==true)
			{
				this.hibernateSession.close(); //Cerramos session hibernate
			//	this.hibernateSession=null; 
				//addLog("(close_session_user): Developer close session");	
			}
		} catch (HibernateException erro) {
			// TODO Auto-generated catch block
			 System.out.println(erro.getMessage());
		}
	}
	
	
	// Debug class
	protected void addLog(String info)
	{
		if (debug)
		{
			new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_HIBERNATE, "("+className+") "+info, ParamsApp.LOG_TYPE_INFO);
		}
	}

	
	
	//devuelve la lista con la View table 
	public List<?> getLista(String filters)
	{
		List<?> data=null;
		
		String HSql = "from "+ this.tableClassView + " a  where 1=1";
		if(!filters.equals(""))
		{
			HSql+=" AND " + filters;
		}
		
		try{
				controlOpen();
				hibernateSession.beginTransaction();
				data = this.hibernateSession.createQuery(HSql).list();
				hibernateSession.getTransaction().commit();
				hibernateSession.close();
			    
			}catch(Exception e)
				{
					addLog("(Error) " + e.getMessage());
					hibernateSession.getTransaction().rollback();
					hibernateSession.close();
				}
		finally{
				controlClose();
		}
		
        return data;
	}

	
	public List<?> getListaBaseTable(String filters)
	{
		
		List<?> data=null;
		
		String HSql = " from "+ this.tableClassBase + " a  where 1=1";
		if(!filters.equals(""))
		{
			HSql+=" AND " + filters;
		}
		
		try{		
			    controlOpen();
				hibernateSession.beginTransaction();
				
				
				data = this.hibernateSession.createQuery(HSql).list();
				
				hibernateSession.getTransaction().commit();
				hibernateSession.close();
				    
			}catch(HibernateException e)
				{
					addLog("(Error) " + e.getStackTrace());
					hibernateSession.getTransaction().rollback();
					hibernateSession.close();
				}
		finally{
			controlClose();
		}		

        return data;
	}

	
	//devuelve la lista con SQL porparametro 
	public List<?> getListaAdvanceHsql(String Sql)
	{
		
		List<?> data = null;
		try{
			controlOpen();
			hibernateSession.beginTransaction();
			data = this.hibernateSession.createQuery(Sql).list();
		    hibernateSession.getTransaction().commit();
		    hibernateSession.close();
		    
		}catch(Exception e)
		{
			addLog("(Error) " + e.getMessage());
			hibernateSession.getTransaction().rollback();
			hibernateSession.close();
		}
		finally{
			controlClose();
		}		
		
			return data;
		 
	}
	
	
	//Limpiamos la session
	protected void SessionClean()
	{
		
		if (this.hibernateSession.isOpen()==true)
		{
			this.hibernateSession.flush();
			this.hibernateSession.clear(); //limpiamos toda la cache
		}
		
	}
	
	
	//Parse.com. Cuando se cambian cosas de un usuario (role, sistemas etc.)
	public void regeneraParseForUser(String user)
	{
		//nothing to do
	}

	
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
			new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_HIBERNATE, "("+className+") "+info, logType);
	}
	
	
}
