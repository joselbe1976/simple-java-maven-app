/*
 * Jose Luis Bustos Esteban 2014. Clase de operaciones hibernate
 *  
 */


package com.common.hibernate.classes;

import java.util.List;

import org.hibernate.Transaction;

import com.common.hibernate.entidades.VinDevices;



public class hb_devices extends hb_main {

	//Atributos
		@SuppressWarnings("unused")
		private VinDevices entidad;

		

		//Contructores
		public hb_devices ()
		{
			this.entidad = new VinDevices(); 
			this.tableClassBase = "VinDevices";  //Tabla base (ojo es la clase no la tabla fisica)
			this.tableClassView = "VinDevices";  //Vista listados
		}
		
		

		// 	-------------------------------------------	
		//Metodos  funcionales de la clase
		// 	-------------------------------------------
		
		//Add new Role
		public boolean addRecord(VinDevices data)
		{
			
			Transaction tx=null; 
			try{
				controlOpen();
				this.logData(data,"New");
				
				tx = this.hibernateSession.beginTransaction();
					hibernateSession.save(data);
				tx.commit();
				this.hibernateSession.clear(); //limpiamos toda la cache
			}
			catch(Exception e)
			{
				addLog("(addRecord)ERROR:"+e.getMessage());
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
		public boolean updateRecord(VinDevices data)
		{
			
			Transaction tx = null;
			try{
				controlOpen();
				this.logData(data,"Update");
				
				tx = this.hibernateSession.beginTransaction();
					hibernateSession.update(data);
				tx.commit(); 
				this.hibernateSession.clear(); //limpiamos toda la cache			
			}
			catch(Exception e)
			{
				addLog("(UpdateRercord)ERROR:"+e.getMessage());
				tx.rollback();
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
		public boolean deleteRecord(String identificator)
		{
			//buscamos el registro
			VinDevices  data = this.getDevice(identificator); 
			
			Transaction tx = null;
			try{
				controlOpen();
				this.logData(data,"Delete");
				
				tx = this.hibernateSession.beginTransaction();
					hibernateSession.delete(data);			
				tx.commit();
				this.hibernateSession.clear(); //limpiamos toda la cache			
			}
			catch(Exception e)
			{
				addLog("(DeleteRecord)ERROR:"+e.getMessage());
				tx.rollback();
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
		public VinDevices getDevice(String id_device)
		{
			List<?> dataAux;
			VinDevices  Arecord = new VinDevices();
			try{
				dataAux =	this.getListaBaseTable("id_device='"+id_device+"'");
				Arecord = (VinDevices)dataAux.get(0);
			}
			catch(Exception e){}
			finally
			{
				dataAux = null;
			}
			return Arecord;				
			
		}
		
		
		
		//Hace log de un role
		private void logData(VinDevices data,String operation)
		{
			if (this.debug == true)
			{
				/*
				System.out.print("\n >>>>>>>>>>>>>>> Operation:" + operation+"<<<<<<<<<<<<<<<<<<<");
				System.out.print("\n --- Begin Debug Hibernate data class ----");
				System.out.print("\n   id_device :"+ data.getIdDevice());
				System.out.print("\n   name      :"+ data.getName());
				System.out.print("\n   comment   :"+ data.getComment());
				System.out.print("\n --- End   Debug Hibernate data class ----");
				System.out.print("\n >>>>>>>>>>>>>>>>>>>><<<<>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n\n");
				*/
			}
		}
		

		
		
		
}
