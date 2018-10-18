/*
 * Jose Luis Bustos Esteban. Esta clase opera sobre las credenciales
 * 
 * Formato de las credenciales
 * {sistema@usuario@clave@idioma},{sistema@usuario@clave@idioma} etc...
 */
package com.common.globalSystems.login;

import java.util.Date;
import java.util.List;

import com.common.config.ParamsApp;
import com.common.hibernate.classes.hb_users_system;
import com.common.hibernate.entidades.VinUsersSystem;

public class logonCredencialProcess {

	private logonCredencialData[] data; //array para almacenar N objetos de credencial en memoria
	private String credenciales=""; //credenciales que nos han pasado
	private int size; //numero de credenciales
	public String idProcessExec="";
	public String SerialKeyForIdProcess=""; //Serial a usar para ese proceso
	public String SerialKeyMainReturnApps="";  //serial que hay que devolver
	public Date dateTokenCaduc; //fecha caducidad del token
	
	public String tokenJWT="";  //Token API REST
	
	//Constructores
	public logonCredencialProcess()
	{
		size = 0;
	}
	
	//destructor
	protected void finalize()
	{
		data = null; //liberamos
	}
	
	
	//Calcula las credenciales y devuelve un array de credenciales
	public void clcCredenciales(String credencial)
	{
		credenciales = credencial;
		
		//array de cada sistema
		String[] aux = credenciales.split(",");
		size = aux.length;
		
		//redimensiono
		data = new logonCredencialData[size];
		
		 //cargamos el array con los datos
		 for(int i = 0; i<size;i++)
		 {
			 
			 data[i] = new logonCredencialData(aux[i]);

		 }
	}
	
	//devuelve la posicion del sistema por defecto 
	public int getPosDefaultSystem()
	{
		int pos = -1;
		
		for (int i = 0; i<data.length;i++)
		{
			if (data[i].defaultSystem == "1") {pos=i;}
		}
		
		//si no hay, es posible que no esté marcado, lo marcamos nosotros
		if (pos == -1)
		{
			new ParamsApp();
			
			for (int i = 0; i<data.length;i++)
			{
				if (data[i].idSystem.equals(ParamsApp.SYSTEM_LOGIN_DEFAULT)) {
					pos=i;
					data[i].defaultSystem = "1"; //lo dejamos maracdo
				}
			}
		}
		return pos;
	}
	
	
	public int getPosOfSystem(String idSystema)
	{
		int pos = -1;
		
		for (int i = 0; i<data.length;i++)
		{
			if (data[i].idSystem.equals(idSystema)) {pos=i;}
		}
		return pos;
		
	}
	

	//devuelve el numero de registros
	public int getCount()
	{
		return size;
	}
	
	
	//devuelve un objeto
	public  logonCredencialData getData(int pos)
	{
		
		if (pos <= size && pos >= 0)
		{
			return data[pos];
		}
		else
		{
			return null;
		}
	}
	
	
	
	//especials methods.
	
	//Cargamos los datos de BBDD a memoria de todas las credenciales
	public void loadDataFromSerial(String KeyCode)
	{
		hb_users_system data1=null;
		List<?> aux=null;
		data = null;
		VinUsersSystem auxUsr=null;
		logonCredencialData zz=null;
		logonData auxDataLogon;
		VinUsersSystem usr=null;
		
		try{
			
		
		
		//Buscamos el usuario Local, del KeyCode
		// ----------------------------------------------------------------------------------------
		
		data1 = new hb_users_system();
		 aux = data1.getListaBaseTable("token_system = '"+ KeyCode + "'");
		
		//si viene vacio salimos
		if (aux.size() <= 0){return;}

		 usr = (VinUsersSystem) aux.get(0);
		String user_local = usr.getId().getIdUser();
		
		this.dateTokenCaduc = usr.getDtCadToken(); //fecha de caducidad

		
		//Buscamos todos los datos KeyCodes que haya en el sistema-usuario
		// ----------------------------------------------------------------------------------------

		aux = data1.getListaBaseTable("id_user = '"+ user_local + "' and id_system <> '" + logon.SYSTEM_PARSE + "'"); //cargamos los sistemas menos Parse.com

		//si viene vacio salimos
		if (aux.size() <= 0){return;}
		
		
		// cargamos cada uno
		
		logonCommon common = new logonCommon(); 
		size = aux.size();
		
		//redimensiono
		data = new logonCredencialData[size];
		
		for (int i =0;i<aux.size();i++)
		{
			auxUsr = (VinUsersSystem) aux.get(i);
			
			//datos del usuario/sistemna
			auxDataLogon = common.getvalueUserOfTokenPerformance(auxUsr.getTokenSystem());
			
			 zz = new logonCredencialData();
				zz.idSystem = auxDataLogon.idSystem;
				zz.languaje = auxDataLogon.languaje;
				zz.user = auxDataLogon.sysUser;
				zz.password = auxDataLogon.sysPasswordNoEncript;
				zz.UUID = auxDataLogon.uuidLogin;
				zz.IdDevice = auxDataLogon.idDeviceLogin;
				zz.KeyCode = auxDataLogon.keyCodeDDBB;
				
				//usuario conectado
				zz.sociedad = auxDataLogon.sociedad;
				zz.id_persona = auxDataLogon.id_persona;
				zz.fase_alta = auxDataLogon.fase_alta;
				
			
			data[i] = zz; 
		}
		
		
		}
		catch(Exception e)
		{
			System.out.print("\nERROR(loadDataFromSerial):"+e.getStackTrace());
		}
		finally{
		
			data1.close_session_user();
			data1 = null;
			usr=null;
			aux = null;
			auxDataLogon = null;
			zz=null;
		}
		
	}

	
	
	
	
}
