//Jose Luis Bustos Esteban. Almacenamos los datos del login
package com.common.globalSystems.login;

import com.common.config.ParamsApp;
import com.common.tools.interfaces.iDisposable;

public class logonData {

	//datos que almacenamos en memoria.
	public String idUserLocal="";
	public String sysUser="";
	public String sysPassword="";
	public String sociedad="";
	public String id_persona="";
	public String fase_alta="";
	
	public String sysPasswordNoEncript="";
	public String uuidLogin="";
	public String uuidAccess="";
	public String idDeviceLogin="";
	public String idDeviceAccess="";
	public String idSystem="";
	public int idRole=-1;
	public String languaje;
	public String keyCodeDDBB;
	
	
	//constructor
	public logonData()
	{
		languaje = ParamsApp.META4_LANGUAJE; //Idioma por defecto
	}
}
