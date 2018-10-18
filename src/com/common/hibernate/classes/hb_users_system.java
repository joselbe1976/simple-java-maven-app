package com.common.hibernate.classes;

import java.util.List;
import org.hibernate.Transaction;

import com.common.config.ParamsApp;
import com.common.hibernate.entidades.VinUsersSystem;
import com.common.hibernate.entidades.VinUsersSystemId;


public class hb_users_system   extends hb_main {  //hereda de main

	//Atributos
	@SuppressWarnings("unused")
	private VinUsersSystem entidad;
		
	//Contructores
	public hb_users_system()
	{
		this.entidad = new VinUsersSystem(); 
		this.tableClassBase = "VinUsersSystem";  //Tabla base
		this.tableClassView = "VinUsersSystem";  //Vista listados
	}
	
	

	// 	-------------------------------------------	
	//Metodos  funcionales de la clase
	// 	-------------------------------------------
	
	//Add new Role
	public boolean addRecord(VinUsersSystem aux)
	{

		VinUsersSystemId data = aux.getId();
		
		//Verifico si existe ya el dato.
		List<?>  ex = this.getListaBaseTable("id_user='" + data.getIdUser() + "' and id_system='"+ data.getIdSystem()+"'"); 
		
		if (ex.size() > 0)
		{
			ex = null;
			return false;
		}

		//asignamos el Server ID
		aux.setServerId(ParamsApp.SYSTEM_SERVER_ID);
		
		this.logData(aux,"New");
		
		//A�adimos el registro
		Transaction tx=null;
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.save(aux);
			tx.commit();
		//	SessionClean();
			
			
			//cada vez que asigamos un sistema, debemos regenerar Parse.
			//regeneraParseForUser(data.getIdUser());
			
		}
		catch(Exception e)
		{
			addLog("(addRecord)ERROR:"+e.getStackTrace());
			tx.rollback();
			//SessionClean();

			
			return false; //error de grabaci�n
		}
		finally
		{
			controlClose();
			tx = null; //liberamos la transaccion de memoria
			ex = null; //libero
		}
		return true;
	}
	
	
	//Save or update
	public boolean updateRecord(VinUsersSystem aux)
	{
		
		//asignamos el Server ID
		aux.setServerId(ParamsApp.SYSTEM_SERVER_ID);
		
		this.logData(aux,"Update");
		
		Transaction tx=null;
		
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.update(aux);
			tx.commit(); 
			//SessionClean();
			
				
		}
		catch(Exception e)
		{
			addLog("(UpdateRercord)ERROR:"+e.getStackTrace());
			tx.rollback();
			//SessionClean();

			return false; //error de grabaci�n al guardar y/o actualizar
		}
		finally
		{
			//controlClose();
			tx = null; //liberamos la transaccion de memoria
		}
		return true;
	}
		
	//Delete
	public boolean deleteRecord(String idUser, String IdSystem)
	{
		
		//buscamos el registro
		VinUsersSystem  data = (VinUsersSystem)this.getUserSystem(idUser,IdSystem).get(0); 
		
		this.logData(data,"Delete");
		
		Transaction tx=null;
		
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.delete(data);			
			tx.commit();
			//SessionClean();

			//cada vez que asigamos un sistema, debemos regenerar Parse.
		//	regeneraParseForUser(idUser);
			
			
		}
		catch(Exception e)
		{
			addLog("(DeleteRecord)ERROR:"+e.getStackTrace());
			tx.rollback();
			//SessionClean();
			
			return false; //error de grabaci�n al eliminar
		}
		finally
		{
			controlClose();
			tx = null; //liberamos la transaccion de memoria
			data = null;
		}
		return true;
	}
			
	
	
	//Devuelve un objeto usuario-System. Crear en todas las clases
	public List<?> getUserSystem(String id_user, String id_system)
	{
		List<?> dataAux;
		if (id_system.equals("")) //Si no viene el filtro por sistema, traemos todo los sistemas
		{
			dataAux =	this.getListaBaseTable("id_user='"+id_user+"'");
		}
		else
		{
			dataAux =	this.getListaBaseTable("id_user='"+id_user+"' and id_system='"+id_system+"'");
		}
		
		return dataAux;
	}
	
	//devuelve una lista de usuartios de un sistema
	public List<?> getUsersSystem( String id_system)
	{
		List<?> dataAux;
		
		dataAux =	this.getListaBaseTable("id_system='"+id_system+"'");
		
		
		return dataAux;
	}
	
	
	
	//Hace log de un role
	private void logData(VinUsersSystem aux,String operation)
	{
		
	}
	

}