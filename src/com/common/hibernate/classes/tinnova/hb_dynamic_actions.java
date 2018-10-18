/*
 * Jose Luis Bustos Esteban. acciones dinamicas con SQL
 */

package com.common.hibernate.classes.tinnova;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.common.hibernate.HibernateUtil;


public class hb_dynamic_actions extends hb_main_tinnova{

	
	//ejecucion de un Update pasado como argumento
	public boolean execDynamicUpdate(String query)
	{

		
		
		try {
			if (hibernateSession.isOpen()==false)
			{
				this.hibernateSession = HibernateUtil.getSessionFactoryTinnova().openSession(); //Sesion de hibernate
			}			
			hibernateSession.getTransaction().begin();
				hibernateSession.createSQLQuery(query).executeUpdate();
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
			return true;
		}
		catch (HibernateException erro){
		    System.out.println(erro.getMessage());
		    hibernateSession.getTransaction().rollback();
		    hibernateSession.close();
		    return false;
		} 

	}

	//ejecuta una sentencia de forma din�mica
	public Iterator execDynamicSelect(String query)
	{
		Iterator result=null;
		
		
		
		try {
			if (hibernateSession.isOpen()==false)
			{
				hibernateSession = HibernateUtil.getSessionFactoryTinnova().openSession(); //Sesion de hibernate
			}
			
			Query qry = hibernateSession.createSQLQuery(query);
			result = qry.list().iterator();
			hibernateSession.getTransaction().commit();
			hibernateSession.close();
			return result;
		}
		catch (HibernateException erro){
		    System.out.println(erro.getMessage());
		    hibernateSession.getTransaction().rollback();
		    hibernateSession.close();
		    return result;
		} 

	}

	
	
}
