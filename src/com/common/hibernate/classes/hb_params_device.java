package com.common.hibernate.classes;

import java.util.List;


import org.hibernate.Transaction;

import com.common.hibernate.entidades.VinParamsDevice;

public class hb_params_device extends hb_main {
	//Atributos
	@SuppressWarnings("unused")
	private VinParamsDevice entidad;
		
	//Contructores
	public hb_params_device()
	{
		this.entidad = new VinParamsDevice(); 
		this.tableClassBase = "VinParamsDevice";  //Tabla base
		this.tableClassView = "VinParamsDeviceView";  //Vista listados
	}
	
	// 	-------------------------------------------	
	//Metodos  funcionales de la clase
	// 	-------------------------------------------
	
	//Add new Role
	public boolean addRecord(VinParamsDevice data)
	{
		
		//verifico si existe ya el dato.
		
		 List<?>  ex = this.getListaBaseTable("id_device ='"+data.getId().getIdDevice() + "' and id_param=" + data.getId().getIdParam() + " "); 
		if (ex.size() > 0)
		{
			ex = null;
			return false;
		}

		//a�adimos el registro
		
		Transaction tx=null;
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
			
			this.logData(data,"New");
			hibernateSession.save(data);
			tx.commit();
			//SessionClean();
			
		}
		catch(Exception e)
		{
			tx.rollback();
			//SessionClean();

			addLog("(addRecord)ERROR:"+e.getMessage());
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
	public boolean updateRecord(VinParamsDevice data)
	{
		
		Transaction tx=null;
		
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
			this.logData(data,"Update");
				hibernateSession.update(data);
			tx.commit(); 
			//SessionClean();	
			
		}
		catch(Exception e)
		{
			tx.rollback();
			//SessionClean();

			addLog("(UpdateRercord)ERROR:"+e.getMessage());
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
	public boolean deleteRecord(String id_device, String id_param)
	{
		//buscamos el registro
		VinParamsDevice  data = this.getObject(Integer.parseInt(id_param), id_device); 
		
		Transaction tx=null;

		
				
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
			this.logData(data,"Delete");
						hibernateSession.delete(data);			
			tx.commit();
			//SessionClean();
			
		}
		catch(Exception e)
		{
			tx.rollback();
			//SessionClean();
			
			addLog("(DeleteRecord)ERROR:"+e.getMessage());
			return false; //error de grabaci�n al eliminar
		}
		{
			controlClose();
			tx = null; //liberamos la transaccion de memoria
			data = null;
		}
		return true;
	}
			
	
	//Devuelve un objeto usuario. Crear en todas las clases
	public VinParamsDevice getObject(int id_param, String id_device)
	{
		VinParamsDevice  Arecord = null; 
		List<?> dataAux =	this.getListaBaseTable( " id_device='"+id_device+ "' and id_param=" + id_param + " ");
		
		if (dataAux.size() > 0)
		{
			Arecord = (VinParamsDevice)dataAux.get(0);
		}
		return Arecord;
	}
	
	
	//Hace log de un role
	private void logData(VinParamsDevice data,String operation)
	{
		
	}

}
