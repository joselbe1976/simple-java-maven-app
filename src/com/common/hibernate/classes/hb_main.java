/*
 * Jose Luis Bustos Esteban. Clase base que heredan el resto de HB_class
 *
 */
package com.common.hibernate.classes;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.common.config.ParamsApp;
import com.common.hibernate.HibernateUtil;
import com.common.pushnotifications.Parse.parseOperations;
import com.common.tools.interfaces.iDisposable;



public class hb_main  implements iDisposable {

	protected boolean debug = false;
	protected String className = "";
	protected String tableClassBase="";
	protected String tableClassView="";
	
	//Atributos
	public Session hibernateSession;
	
	
	//Parse.com
	parseOperations parse;
	
	
	//Contructor
	public hb_main()
	{
		try {
			this.hibernateSession = HibernateUtil.getSessionFactory().openSession(); //Sesion de hibernate
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
				this.hibernateSession = HibernateUtil.getSessionFactory().openSession();
			}
			else{

				if (this.hibernateSession.isOpen()==false)
				{
					this.hibernateSession = HibernateUtil.getSessionFactory().openSession();
				}
			}
		} catch (HibernateException erro) {
			// TODO Auto-generated catch block
			 System.out.println(erro.getMessage());
		}
	
	}
	
	public boolean isOpen(){
		return this.hibernateSession.isOpen();
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
			new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_HIBERNATE, "("+className+") "+info, ParamsApp.LOG_TYPE_INFO);
		}
	}

	protected String createFiltersSql(String filters)
	{
		String Sql = "";
		
		if (filters.equals(""))
		{
			return "";
		}
		else
		{
			return " where " + filters;
		}
	}
	
	//devuelve la lista con la View table 
	public List<?> getLista(String filters)
	{
		List<?> data=null;
		
		String HSql = "from "+ this.tableClassView + " a ";
		
		
		if(!filters.equals(""))
		{
			HSql+=createFiltersSql(filters);
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
		
		String HSql = "from "+ this.tableClassBase + " a ";
		
		if(!filters.equals(""))
		{
			HSql+=createFiltersSql(filters);
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
		/*
		if (this.hibernateSession.isOpen()==true)
		{
			this.hibernateSession.flush();
			this.hibernateSession.clear(); //limpiamos toda la cache
		}
		*/
		
	}
	
	
	//Sin uso
	public void regeneraParseForUser(String user)
	{
		
		
		
		
	}
	
}
