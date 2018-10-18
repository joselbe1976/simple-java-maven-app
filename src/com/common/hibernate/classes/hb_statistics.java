package com.common.hibernate.classes;

import java.util.Date;
import java.util.List;

import org.hibernate.Transaction;

import com.common.config.ParamsApp;
import com.common.hibernate.entidades.VinStatistics;
import com.common.hibernate.entidades.VinStatisticsId;

public class hb_statistics extends hb_main {
	
	//Atributos
	@SuppressWarnings("unused")
	private VinStatistics entidad;
	private String AUDITORY_ACTIVATE;
	
	
	//Contructores
	public hb_statistics()
	{
		this.entidad = new VinStatistics();
		this.tableClassView = "VinStatisticsView"; //Vista para vistas y listados
		this.tableClassBase = "VinStatistics"; //tabla base
		
		AUDITORY_ACTIVATE = ParamsApp.AUDITORY_ACTIVATE;
	}
	
	

	// 	-------------------------------------------	
	//Metodos  funcionales de la clase
	// 	-------------------------------------------
	
	//Add new Role
	public boolean addRecord(VinStatistics role)
	{
		this.logData(role,"New");
		Transaction tx=null;
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.save(role);
			tx.commit();
			//SessionClean();
		}
		catch(Exception e)
		{
			addLog("(addRecord)ERROR:"+e.getMessage());
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
	public boolean UpdateRecord(VinStatistics role)
	{
		
		this.logData(role,"Update");
		Transaction tx=null;
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
				hibernateSession.update(role);
			tx.commit(); 
			//SessionClean();			
		}
		catch(Exception e)
		{
			addLog("(UpdateRole)ERROR:"+e.getStackTrace());
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
	public boolean DeleteRecord(String identificator)
	{
		
		//buscamos el registro
		
		
		String filtro = "ordinal=" + identificator;
		List<?> data = this.getLista(filtro);
		
		if (data.size() != 1) {return false;}
		
		VinStatistics  role = (VinStatistics)data.get(0); 
		

		this.logData(role,"Delete");
		Transaction tx=null;
		
		try{
			controlOpen();
			tx = this.hibernateSession.beginTransaction();
			hibernateSession.delete(role);			
			tx.commit();
			//SessionClean();		
		}
		catch(Exception e)
		{
			addLog("(DeleteRole)ERROR:"+e.getStackTrace().toString());
			tx.rollback();
			//SessionClean();
			
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
			
	
	//inserccion de una estadistica (se usa desde todo el sistema)
	public void insertEstadistics(String LocalUser, String IdProcess, String text)
	{
		
		if (!AUDITORY_ACTIVATE.equals("Y")) {return;} //if not activate
		
		
		VinStatistics data;
		VinStatisticsId  dataAux;
		try{
			data = new VinStatistics();
			dataAux = new VinStatisticsId(); 
			
			dataAux.setDateExec(new Date());
			dataAux.setIdUser(LocalUser);
			data.setId(dataAux);
			data.setVinProcess(new hb_process().getDataObject(IdProcess));
			data.setText(text);
			addRecord(data); //save
		}
		catch(Exception e)
		{
			System.out.print("\n ERROR: Error al insertar una estadistica\n"+ e.getStackTrace());
		}
		finally
		{
			data=null;
			dataAux=null;
		}
		
		
		
	}
	
	
	
	
	//Hace log de un role
	private void logData(VinStatistics role,String operation)
	{
		
	}

	
	
	//metodo sobrescrito al padre
	//devuelve la lista con la View table 
	public List<?> getLista(String filters)
	{

		
		String HSql = "from "+ this.tableClassView + " a  where 1=1";
		if(!filters.equals(""))
		{
			HSql+=" AND " + filters;
		}
	
		HSql += " order by date_exec DESC ";
		
		List<?> data=null;
		
		try {
			controlOpen();
			hibernateSession.beginTransaction();
			data = this.hibernateSession.createQuery(HSql).list();
			hibernateSession.getTransaction().commit();
			//hibernateSession.close();
		}     
			catch(Exception e)
			{
				addLog("(Error) " + e.getMessage());
				hibernateSession.getTransaction().rollback();
			//	hibernateSession.close();
			}
		finally{
			controlClose();
		}
		
        return data;
	}
	

}
