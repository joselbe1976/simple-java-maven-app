/*
 * Jose Luis Bustos Esteban 2014. Clase de operaciones hibernate
 *  
 */


package com.common.hibernate.classes;

import java.util.List;

import org.hibernate.Transaction;

import com.common.hibernate.entidades.VinUsers;
import com.common.hibernate.entidades.VinUsersView;
import com.common.tools.encript.encriptAES;


public class hb_users  extends hb_main {  //hereda de main

	//Atributos
	@SuppressWarnings("unused")
	private VinUsers entidad;
		
	//Contructores
		
	public hb_users ()
	{
		this.entidad = new VinUsers(); 
		this.tableClassBase = "VinUsers";  //Tabla base
		this.tableClassView = "VinUsersView";  //Vista listados
	}
	
	

	// 	-------------------------------------------	
	//Metodos  funcionales de la clase
	// 	-------------------------------------------
	
	//Add new Role
	public boolean addRecord(VinUsers data)
	{
		
		//verifico si existe ya el dato.
		
		 List<?>  ex = this.getListaBaseTable("id_user='" + data.getIdUser() + "'"); 
		
		if (ex.size() > 0)
		{
			ex = null;
			return false;
		}

		this.logData(data,"New");
		
		//A�adimos el registro
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
	public boolean updateRecord(VinUsers data)
	{
		
		this.logData(data,"Update");
		Transaction tx=null;
		
		
		try{
			controlOpen();
			 tx = this.hibernateSession.beginTransaction();
			  	hibernateSession.update(data);
			 tx.commit(); 

			
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
	public boolean deleteRecord(String identificator)
	{
		
		//buscamos el registro
		VinUsers  data = this.getUser(identificator); 
		
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
			return false; //error de grabacion al eliminar
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
	public VinUsers getUser(String id_user)
	{
		VinUsers  Arecord = null;
		List<?> dataAux =	this.getListaBaseTable("id_user='"+id_user+"'");
		
		if (dataAux.size() >0 )
		{
			Arecord = (VinUsers)dataAux.get(0);
		}
		return Arecord;
	}
	

	//Hace log de un role
	private void logData(VinUsers data,String operation)
	{
		
	}
	

	
	//Cambio de clave
	public boolean savePassword(String id_user, String password)
	{
		boolean dev = true;
		VinUsers data;
		encriptAES sha1;
		try{
			data = this.getUser(id_user); //buscamos el usuario
			sha1 = new encriptAES();
			String Newpassword = sha1.cryptWithAES(password); //encriptamos a AES256
			data.setPassword(Newpassword); //asignamos la clave
			dev = this.updateRecord(data); //actualizamos el password del usuario
		}
		catch(Exception e)
		{
			dev = false;
			System.out.print(e.getStackTrace());
		}
		finally
		{
			data=null;
			sha1=null;
		}
		return dev;
		
	}

	
	
	
	//Encriptar clave
	
	public String encriptaPassword(String password)
	{
		encriptAES sha1;
		String Newpassword ="";
		try{
			sha1 = new encriptAES();
			Newpassword = sha1.cryptWithAES(password); //encriptamos a AES256
		}
		catch(Exception e)
		{
			System.out.print(e.getStackTrace());
		}
		finally
		{
			sha1=null;
		}
		return Newpassword ;
		
	}
	
	
	//metodos Sobrecargados
	
	public List<?> getLista(String filters)
	{
		//SessionClean();
		
		String HSql = "from "+ this.tableClassView + " a  where visible = 1 "; //Ocultamos asi los usuarios "internos" al sistema
		if(!filters.equals(""))
		{
			HSql+=" AND " + filters;
		}
		
		List<?> data=null;
		try {
			controlOpen();
			hibernateSession.beginTransaction();
			data = this.hibernateSession.createQuery(HSql).list();
			hibernateSession.getTransaction().commit();
			//hibernateSession.close();
		    
		}catch(Exception e)
			{
				addLog("(Error) " + e.getMessage());
				hibernateSession.getTransaction().rollback();
				//hibernateSession.close();
			}
		finally{
			controlClose();
			
		}		
		
        return data;
	}
	
	
	
		
	
	public List<?> getListaNoSeg(String filters)
	{
		SessionClean();
		
		String HSql = "from "+ this.tableClassView + " a "; 

		if(!filters.equals(""))
		{
			HSql+=createFiltersSql(filters);
		}
		
		List<?> data=null;
		try {
			controlOpen();
			hibernateSession.beginTransaction();
			data = this.hibernateSession.createQuery(HSql).list();
			hibernateSession.getTransaction().commit();
			//hibernateSession.close();
		    
		}catch(Exception e)
			{
				addLog("(Error) " + e.getMessage());
				hibernateSession.getTransaction().rollback();
				//hibernateSession.close();
			}
		finally{
			controlClose();
			
		}
		
        return data;
	}
	
	
	//indica si existe un usuario
	public boolean existLocalUser(String user)
	{
		List<?> aux = getListaNoSeg("id_user='" + user + "'");
		if (aux.size()==0){ return false;}
		else
		{return true;}
	}
	
	public boolean existLocalUserOfNif(String nif)
	{
		List<?> aux = getListaNoSeg("nif='" + nif.trim() + "'");
		if (aux.size()==0){ return false;}
		else
		{return true;}
	}

	public boolean existLocalUserOfIdEmpleadoAndFaseAlta(String idEmpleado, String faseAlta)
	{
		List<?> aux = getListaNoSeg("id_empleado_rrhh='" + idEmpleado.trim() + "' AND fase_alta_rrhh = '" + faseAlta.trim() +"'");
		if (aux.size()==0){ return false;}
		else
		{return true;}
	}

	public boolean existLocalUserOfIdEmpleadoAndSociedad(String idEmpleado, String Sociedad)
	{
		List<?> aux = this.getListaBaseTable("id_empleado_rrhh='" + idEmpleado.trim() + "' AND id_organization = '" + Sociedad.trim() +"'");
		if (aux.size()==0){ return false;}
		else
		{return true;}
	}
	
	public String getLocalUserOfIdEmpleadoAndSociedad(String idEmpleado, String Sociedad)
	{
		String cad = "";
		List<?> aux ;
		VinUsers usr;
		try{
			aux = this.getListaBaseTable("id_empleado_rrhh='" + idEmpleado.trim() + "' AND id_organization = '" + Sociedad.trim() +"'");
			
			if (aux.size()>0)
			{
				usr = (VinUsers)aux.get(0);
				cad = usr.getIdUser().toString();
			}
		}
		catch(Exception e)
		{
			addLog("(Error)getLocalUserOfIdEmpleadoAndFaseAlta : " + e.getStackTrace());
		}
		finally
		{
			aux=null;
			usr=null;
		}
		return cad;
	}
	
	public String getLocalUserOfIdEmpleadoAndFaseAlta(String idEmpleado, String faseAlta)
	{
		String cad = "";
		List<?> aux ;
		VinUsersView usr;
		try{
			aux = getListaNoSeg("id_empleado_rrhh='" + idEmpleado.trim() + "' AND fase_alta_rrhh = '" + faseAlta.trim() +"'");
			
			if (aux.size()>0)
			{
				usr = (VinUsersView)aux.get(0);
				
				cad = usr.getId().getIdUser();
			}
		}
		catch(Exception e)
		{
			addLog("(Error)getLocalUserOfIdEmpleadoAndFaseAlta : " + e.getStackTrace());
		}
		finally
		{
			aux=null;
			usr=null;
		}
		return cad;
	}
	
	
	public String getLocalUserOfNif(String nif)
	{
		String cad = "";
		List<?> aux ;
		VinUsersView a;
		try{
			aux = getListaNoSeg("nif='" + nif.trim() + "'");
			
			if (aux.size()>0)
			{
				a = (VinUsersView)aux.get(0);
				
				cad = a.getId().getIdUser();
			}
		}
		catch(Exception e)
		{
			addLog("(Error)getLocalUserOfNif : " + e.getStackTrace());
		}
		finally
		{
			aux=null;
			a=null;
		}
		return cad;
	}

	
	
	
}
