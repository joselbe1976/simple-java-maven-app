package com.common.hibernate.classes;

import java.util.List;

import org.hibernate.CacheMode;
import org.hibernate.Transaction;

import com.common.hibernate.entidades.*;

public class hb_params_process extends hb_main{


	//Atributos
	@SuppressWarnings("unused")
	private VinParamsProcess entidad;
		
	//Contructores
		
	public hb_params_process ()
	{
		this.entidad = new VinParamsProcess(); 
		this.tableClassBase = "VinParamsProcess";  //Tabla base
		this.tableClassView = "VinParamsProcessView";  //Vista listados
	}
	
	

	// 	-------------------------------------------	
	//Metodos  funcionales de la clase
	// 	-------------------------------------------
	
	//Add new Role
	public boolean addRecord(VinParamsProcess data)
	{
		
		//verifico si existe ya el dato.
		
		 List<?>  ex = this.getListaBaseTable(" id_process='"+data.getId().getIdProcess() + "' and id_param=" + data.getId().getIdParam() + " "); 
		
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
	public boolean updateRecord(VinParamsProcess data)
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
	public boolean deleteRecord(String id_process, String id_param)
	{
		//buscamos el registro
		VinParamsProcess  data = this.getObject(Integer.parseInt(id_param), id_process); 
		
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
	public VinParamsProcess getObject(int id_param, String id_process)
	{
		VinParamsProcess  Arecord = null;
		List<?> dataAux =	this.getListaBaseTable(" id_process='"+id_process+ "' and id_param=" + id_param+" ");
		if (dataAux.size() > 0)
		{
			Arecord = (VinParamsProcess)dataAux.get(0);
		}
		return Arecord;
	}
	

	//Hace log de un role
	private void logData(VinParamsProcess data,String operation)
	{
		
	}
	

	
}
