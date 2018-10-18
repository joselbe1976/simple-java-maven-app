/*
 * Jose Luis Bustos Esteban 2014. Clase de operaciones hibernate
 *  
 */


package com.common.hibernate.classes;

import java.util.List;

import org.hibernate.Transaction;

import com.common.hibernate.entidades.VinRoles;
import com.common.hibernate.entidades.VinUsers;

public class hb_roles extends hb_main {  //hereda de main

	
	//Atributos
	@SuppressWarnings("unused")
	private VinRoles entidad;
	
	
	
	//Contructores
	public hb_roles()
	{
		this.entidad = new VinRoles();
		this.tableClassView = "VinRoles"; //Vista para vistas y listados
		this.tableClassBase = "VinRoles"; //tabla base
	}
	
	

	// 	-------------------------------------------	
	//Metodos  funcionales de la clase
	// 	-------------------------------------------
	
	//Add new Role
	public boolean addRole(VinRoles role)
	{
		
		Transaction tx=null;
		this.logData(role,"New");

		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.save(role);
			tx.commit();
			SessionClean();
			

		}
		catch(Exception e)
		{
			addLog("(addRole)ERROR:"+e.getStackTrace());
			tx.rollback();
			SessionClean();
			
			
			return false; //error de grabaci�n
		}
		finally
		{
			controlClose();
			tx = null; //liberamos la transaccion de memoria
		}
		return true;
	}
	
	
	//Save or update
	public boolean UpdateRole(VinRoles role)
	{
		
		Transaction tx=null;
		this.logData(role,"Update");

		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.update(role);
			tx.commit(); 
			SessionClean();			
		}
		catch(Exception e)
		{
			addLog("(UpdateRole)ERROR:"+e.getStackTrace());
			tx.rollback();
			SessionClean();

			
			return false; //error de grabaci�n al guardar y/o actualizar
		}
		finally
		{
			controlClose();
			tx = null; //liberamos la transaccion de memoria
		}
		return true;
	}
		
	//Delete
	public boolean DeleteRole(String identificator)
	{
		
		//buscamos el registro
		
		
		String filtro = "id=" + identificator;
		List<?> data = this.getLista(filtro);
		
		if (data.size() != 1) {return false;}
		
		VinRoles  role = (VinRoles)data.get(0); 
		

		this.logData(role,"Delete");
		Transaction tx=null;
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.delete(role);			
			tx.commit();
			SessionClean();		
		}
		catch(Exception e)
		{
			addLog("(DeleteRole)ERROR:"+e.getStackTrace());
			tx.rollback();
			SessionClean();

			
			return false; //error de grabaci�n al eliminar
		}
		finally
		{
			controlClose();
			tx = null; //liberamos la transaccion de memoria
			role = null;
		}
		return true;
	}
			
	
	
	//Devuelve un objeto usuario. Crear en todas las clases
	public VinRoles getRole(String id_role)
	{
		VinRoles  Arecord = null;
		List<?> dataAux =	this.getListaBaseTable("id='"+id_role+"'");
		
		if (dataAux.size() >0 )
		{
			Arecord = (VinRoles)dataAux.get(0);
		}
		return Arecord;
	}
	
	
	
	//Hace log de un role
	private void logData(VinRoles role,String operation)
	{
		
	}

	
}
