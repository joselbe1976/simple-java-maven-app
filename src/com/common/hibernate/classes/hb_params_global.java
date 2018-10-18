/*
 * Jose Luis Bustos Esteban 2014. Clase de operaciones hibernate
 *  
 */

package com.common.hibernate.classes;

import java.util.List;
import org.hibernate.Transaction;

import com.common.hibernate.entidades.VinParamsGlobal;

public class hb_params_global extends hb_main{

	//Atributos
	@SuppressWarnings("unused")
	private VinParamsGlobal entidad;
	
	//Contructores
			public hb_params_global ()
			{
				this.entidad = new VinParamsGlobal(); 
				this.tableClassBase = "VinParamsGlobal";  //Tabla base (ojo es la clase no la tabla fisica)
				this.tableClassView = "VinParamsGlobal";  //Vista listados
			}
			
			

			// 	-------------------------------------------	
			//Metodos  funcionales de la clase
			// 	-------------------------------------------
			
			//Add new Role
			public boolean addRecord(VinParamsGlobal data)
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
			public boolean updateRecord(VinParamsGlobal data)
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
				VinParamsGlobal  data = this.getDataObject(identificator); 
				
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
			public VinParamsGlobal getDataObject(String id)
			{
				List<?> dataAux;
				VinParamsGlobal  Arecord = null;
				try{
					Arecord = new VinParamsGlobal();
					dataAux =	this.getListaBaseTable("id="+id);
					Arecord = (VinParamsGlobal)dataAux.get(0);
				}
				catch(Exception e){addLog("(getDataObject)ERROR:"+e.getStackTrace());}
				finally
				{
					dataAux = null;
				}
				return Arecord;				
				
			}
			
			
			
			//Hace log de un role
			private void logData(VinParamsGlobal data,String operation)
			{
				
			}
				
	
	
	
}
