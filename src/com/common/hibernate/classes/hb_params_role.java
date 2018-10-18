package com.common.hibernate.classes;

import java.util.List;

import org.hibernate.Transaction;

import com.common.hibernate.entidades.VinParamsRole;

public class hb_params_role extends hb_main{
	//Atributos
	@SuppressWarnings("unused")
	private VinParamsRole entidad;
		
	//Contructores
	public hb_params_role()
	{
		this.entidad = new VinParamsRole(); 
		this.tableClassBase = "VinParamsRole";  //Tabla base
		this.tableClassView = "VinParamsRoleView";  //Vista listados
	}
	
	// 	-------------------------------------------	
	//Metodos  funcionales de la clase
	// 	-------------------------------------------
	
	//Add new Role
	public boolean addRecord(VinParamsRole data)
	{
		
		//verifico si existe ya el dato.
		
		 List<?>  ex = this.getListaBaseTable(" id_role ="+data.getId().getIdRole() + " and id_param=" + data.getId().getIdParam() + " "); 
		
		if (ex.size() > 0)
		{
			ex = null;
			return false;
		}

		//a�adimos el registro
		this.logData(data,"New");
		Transaction tx=null;
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.save(data);
			tx.commit();
			//SessionClean();
			
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
	public boolean updateRecord(VinParamsRole data)
	{
		this.logData(data,"Update");
		Transaction tx=null;
		
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.update(data);
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
			controlClose();
			tx = null; //liberamos la transaccion de memoria
		}
		return true;
	}
		
	//Delete
	public boolean deleteRecord(String id_role, String id_param)
	{
		//buscamos el registro
		VinParamsRole  data = this.getObject(Integer.parseInt(id_param), id_role); 
		
		this.logData(data,"Delete");
		Transaction tx=null;
		

		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
			hibernateSession.delete(data);			
			tx.commit();
			//SessionClean();
			
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
			
	
	//Devuelve un objeto usuario. Crear en todas las clases
	public VinParamsRole getObject(int id_param, String id_role)
	{
		VinParamsRole  Arecord = null;
		List<?> dataAux =	this.getListaBaseTable(" id_role="+id_role+ " and id_param=" + id_param + " ");

		if (dataAux.size() > 0){
			Arecord = (VinParamsRole)dataAux.get(0);
		}
		
		return Arecord;
	}
	
	
	//Hace log de un role
	private void logData(VinParamsRole data,String operation)
	{
		
	}
	

}
