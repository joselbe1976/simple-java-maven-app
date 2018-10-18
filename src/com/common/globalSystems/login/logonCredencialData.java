/*
 * Jose Luis Bustos Esteban. En esta clase que solo se usa en memoria, es para desglosar los datos de las credenciales 
 */
package com.common.globalSystems.login;

import com.common.config.ParamsApp;

public class logonCredencialData {

	
	public String idSystem;
	public String user;
	public String password;
	public String languaje;
	public String defaultSystem;
	public String sociedad;
	public String id_persona="";
	public String fase_alta="";	
	
	public String UUID;
	public String IdDevice;
	public String KeyCode;
	

	//Constructores
	public logonCredencialData()
	{

	}
	
	public logonCredencialData(String aux)
	{
		
		 String []dat = aux.split("@");
		 
		 idSystem = dat[0].replace("{", "").replace("}","");
		 user = dat[1].replace("{", "").replace("}","");
		 password = dat[2].replace("{", "").replace("}",""); 
		 languaje = dat[3].replace("{", "").replace("}","");
		 IdDevice =  dat[4].replace("{", "").replace("}","");
		 UUID =  dat[5].replace("{", "").replace("}","");
		 defaultSystem = "0"; //no es sistema por defecto
		 clcDefaultsValues();
	}
	
	public void clcDefaultsValues()
	{
		 new ParamsApp();
		 //Si es el sistema por defcto, lo marco
		 if (idSystem.equals(ParamsApp.SYSTEM_LOGIN_DEFAULT))
		 {
			 defaultSystem = "1";
		 }
		 
		 //Si el idioma viene vacio, lo podemos por defecto
		 if (languaje.equals(""))
		 {
			 languaje = ParamsApp.META4_LANGUAJE;
		 }
		
	}
	
}
