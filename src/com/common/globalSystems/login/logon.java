//**********************************************************
// Jose Luis Bustos Esteban  2017
// Interface global de login y control de session
// **********************************************************

package com.common.globalSystems.login;

public interface logon {

	//Constantes de los sistemas (códigos que estan en la tabla de sistemas)
	public static final String SYSTEM_LOCAL = "LOCAL";
	public static final String SYSTEM_META4 = "Meta4";
	public static final String SYSTEM_PARSE = "Parse";
	

	
	//metodos
	public String logonSystemBySerialCredentials(String Credentials);
	public String logonSystem(String userLocal, String user, String password);
	public String logonSystem(String userLocal, String user, String password, String idSistema);
	public String controlSessionSystem(String KeyCode);
	public String evaluarParametrosLogin(int Param); //evaluamos el parametros. Cada sistema lo debe hacer
	public boolean echoToSystemExternal(String KeyCode); //en caso de sistema externo, lanzamos el echo
	public void logout(String userLocal); //Logout del sistema
}
