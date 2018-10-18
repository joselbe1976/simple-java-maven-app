/*
 * Jose Luis Bustos Esteban 2014. Clase de operaciones hibernate
 *  
 */


package com.common.hibernate.classes;

import java.util.List;

import org.hibernate.Transaction;

import com.common.hibernate.entidades.VinSystems;

 
public class hb_systems extends hb_main {
	//Atributos
	@SuppressWarnings("unused")
	private VinSystems entidad;
	
	//Contructores
			public hb_systems ()
			{
				this.entidad = new VinSystems(); 
				this.tableClassBase = "VinSystems";  //Tabla base (ojo es la clase no la tabla fisica)
				this.tableClassView = "VinSystems";  //Vista listados
			}
			
			

			// 	-------------------------------------------	
			//Metodos  funcionales de la clase
			// 	-------------------------------------------
			
			//Add new Role
			public boolean addRecord(VinSystems data)
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
					addLog("(addRecord)ERROR:"+e.getStackTrace());
					tx.rollback();
					
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
			public boolean updateRecord(VinSystems data)
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
				VinSystems  data = this.getDataObject(identificator); 
				
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
			public VinSystems getDataObject(String id_system)
			{
				List<?> dataAux;
				VinSystems  Arecord = null;
				try{
					 Arecord = new VinSystems();
					dataAux =	this.getListaBaseTable("id_system='"+id_system+"'");
					Arecord = (VinSystems)dataAux.get(0);
				}
				catch(Exception e){addLog("(VinSystems -> getDataObject)ERROR:"+e.getStackTrace());}
				finally
				{
					dataAux = null;
				}
				return Arecord;				
				
			}
			
			
			
			//Hace log de un role
			private void logData(VinSystems data,String operation)
			{
				
			}
				
	
}
