/*
 * Jose Luis Bustos Esteban. Hibernate factory
 * ------------------------------------------------------------------------------------------------------------------
 * Esta clase crea estaticamente en el servidor web, la factory sobre la bbdd my sql.
 * Si se quiere, se puede crear N conexiones a otras bbdd. Para ello hay que crear otro fichero de configuracion
 * y crear otro session factory como abajo. Despues crear otro metodo getsessionFactory nuevo para devolver el nuevo
 * sessionfactory a otra base de datos.
 * ------------------------------------------------------------------------------------------------------------------
 */

package com.common.hibernate;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.*;
import org.hibernate.service.ServiceRegistry;

import com.common.config.ParamsApp;

public class HibernateUtil {


    private static  SessionFactory sessionFactory=null; //MySql
    private static  SessionFactory sessionFactory2=null; //DDBBTinnova
    private static  SessionFactory sessionFactoryServer=null; //Teams SQL Server Data Base Server 2x

    

    static {
	    try {
	    	// -------------------------------------------------------------------------------------------------------------		    
	    	//Principal MySql . For internal Use of server
	    	// -------------------------------------------------------------------------------------------------------------
			Configuration configuration = new Configuration();
	        configuration.configure("hibernate.cfg.xml");
		    ServiceRegistry  serviceRegistry;

	        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        
	    	// -------------------------------------------------------------------------------------------------------------		    
	    	// Server Teams, Dsata Lake etc in Sql Server
	    	// -------------------------------------------------------------------------------------------------------------
			Configuration configuration3 = new Configuration();
	        configuration3.configure("hibernate_server.cfg.xml");
		    ServiceRegistry  serviceRegistry3;

	        serviceRegistry3 = new StandardServiceRegistryBuilder().applySettings(configuration3.getProperties()).build();
	        sessionFactoryServer = configuration.buildSessionFactory(serviceRegistry3);
	        
	        
	        
	        
	        
	        /*
	         *  Tinnova. only if is Tinnova Product
	         * 
	         */
	        new ParamsApp();
	        if (ParamsApp.META4_PRODUCT.equals("TINNOVA"))
	        {
	        
		        Configuration configuration2 = new Configuration();
		        configuration2.configure("hibernate_tinnova.cfg.xml");
			    ServiceRegistry  serviceRegistry2;
	
		        serviceRegistry2 = new StandardServiceRegistryBuilder().applySettings(configuration2.getProperties()).build();
		        sessionFactory2 = configuration.buildSessionFactory(serviceRegistry2);
		               
	        }
	        
	    } 
	    catch (HibernateException ex) {
	    	ex.printStackTrace();
	    	throw new RuntimeException("Error Config Hibernate : "  + ex.getMessage(), ex);
		    
	    }
    }
 
    
    public static SessionFactory getSessionFactory() {
    	return sessionFactory; 
    }
    public static SessionFactory getSessionFactoryTinnova() {
    	return sessionFactory2; 
    }    
    public static SessionFactory getSessionFactoryServer() {
    	return sessionFactoryServer; 
    }    
        
  

    
}