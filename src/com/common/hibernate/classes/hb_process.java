package com.common.hibernate.classes;

import java.util.List;

import org.hibernate.Transaction;

import com.common.hibernate.entidades.VinProcess;

public class hb_process extends hb_main {

	
	//Atributos
	@SuppressWarnings("unused")
	private VinProcess entidad;
	
	
	
	//Contructores
	public hb_process()
	{
		this.entidad = new VinProcess();
		this.tableClassView = "VinProcessView"; //Vista para vistas y listados
		this.tableClassBase = "VinProcess"; //tabla base
	}
	

	// 	-------------------------------------------	
	//Metodos  funcionales de la clase
	// 	-------------------------------------------
	
	//Add new data
	public boolean addRegister(VinProcess data )
	{
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
			addLog("(adddata)ERROR:"+e.getStackTrace());
			tx.rollback();
			//SessionClean();		
			
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
	public boolean Updatedata(VinProcess data)
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
			addLog("(Updatedata)ERROR:"+e.getStackTrace());
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
	public boolean Deletedata(String identificator)
	{
		
		//buscamos el registro
		VinProcess  data = getDataObject(identificator);
		
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
			addLog("(Deletedata)ERROR:"+e.getStackTrace());
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
			

	//Devuelve un objeto Device
	public VinProcess getDataObject(String id)
	{
		List<?> dataAux;
		VinProcess  Arecord = null;
		try{
			Arecord = new VinProcess();
			dataAux =	this.getListaBaseTable("id_process='"+id+"'");
			Arecord = (VinProcess)dataAux.get(0);
		}
		catch(Exception e){addLog("(getDataObject -hb_process)ERROR:"+e.getStackTrace());}
		finally
		{
			dataAux = null;
		}
		return Arecord;				
		
	}
		
	
	//Hace log de un data
	private void logData(VinProcess data,String operation)
	{
		
	}
}
