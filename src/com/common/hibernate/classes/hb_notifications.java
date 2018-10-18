package com.common.hibernate.classes;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.common.hibernate.entidades.VinNotifications;
import com.common.tools.DatesTools;


public class hb_notifications extends hb_main {

	//Atributos
	@SuppressWarnings("unused")
	private VinNotifications entidad;
	
	
	
	//Contructores
	public hb_notifications()
	{
		this.entidad = new VinNotifications();
		this.tableClassView = "VinNotifications"; //Vista para vistas y listados
		this.tableClassBase = "VinNotifications"; //tabla base
	}
	
	

	// 	-------------------------------------------	
	//Metodos  funcionales de la clase
	// 	-------------------------------------------
	
	//Add new data
	public boolean addRegister(VinNotifications data )
	{
		
		Transaction tx=null;
		this.logData(data,"New");
		
		try{
			controlOpen();

			tx = this.hibernateSession.beginTransaction();
				hibernateSession.save(data);
			tx.commit();
			//SessionClean();
		}
		catch(Exception e)
		{
			tx.rollback();
			//SessionClean();
			addLog("(adddata)ERROR:"+e.getMessage());
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
	public boolean Updatedata(VinNotifications data)
	{
		
		Transaction tx=null;
		this.logData(data,"Update");

		
		try{
			controlOpen();

			tx = this.hibernateSession.beginTransaction();
			hibernateSession.update(data);
			tx.commit(); 
			//SessionClean();			
		}
		catch(Exception e)
		{
			tx.rollback();
			//SessionClean();
			addLog("(Updatedata)ERROR:"+e.getMessage());
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
	public boolean Deletedata(String user, int ordinal)
	{
		
		//buscamos el registro
		VinNotifications  data = getDataObject(user,ordinal);
		

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
			tx.rollback();
			//SessionClean();

			addLog("(Deletedata)ERROR:"+e.getMessage());
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
	public VinNotifications getDataObject(String user, int ordinal)
	{
		List<?> dataAux;
		VinNotifications  Arecord = null;
		try{
			
			Arecord = new VinNotifications();
			dataAux =	this.getListaBaseTable("id_user='"+user+"' and ordinal ="+ordinal);
			Arecord = (VinNotifications)dataAux.get(0);
		}
		catch(Exception e){
			System.out.print("\n ERROR: hb_notifications->getDataObjet:"+e.getStackTrace());
		}
		finally
		{
			dataAux = null;
		}
		return Arecord;				
		
	}
	
	
	//devuelve la lista de notificaciones activas
	public List<?> getListaNotificacionesActivas(String user)
	{
	
		 
		String filter="";
		try {
			filter = new DatesTools().StringToDate(new Date(), "yyyy/MM/dd");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.print("\n ERROR: hb_notifications->getListaNotificacionesActivas:"+e.getStackTrace());
		}
		
		return getListaBaseTable("id_user ='"+user+"' AND chk_deleted=0 AND dt_end > '" + filter +"'" );
	}
		
	
	
	//Hace log de un data
	private void logData(VinNotifications data,String operation)
	{
		if (this.debug == true)
		{
			/*
			System.out.print("\n >>>>>>>>>>>>>>> Operation:" + operation+"<<<<<<<<<<<<<<<<<<<");
			System.out.print("\n --- Begin Debug Hibernate data class (notifications) ----");
			System.out.print("\n   user        :"+ data.getId().getIdUser());
			System.out.print("\n   ordinal     :"+ data.getId().getOrdinal());
			System.out.print("\n   titulo      :"+ data.getTitle());
			System.out.print("\n   mensaje     :"+ data.getMessage());
			System.out.print("\n   eliminado   :"+ data.getChkDeleted());
			System.out.print("\n   leido       :"+ data.getChkReaded());
			System.out.print("\n   fecha envio :"+ data.getDtSend());
			System.out.print("\n   fecha fin   :"+ data.getDtEnd());
			System.out.print("\n --- End   Debug Hibernate data class ----");
			System.out.print("\n >>>>>>>>>>>>>>>>>>>><<<<>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n");
			*/
		}
	}

}
