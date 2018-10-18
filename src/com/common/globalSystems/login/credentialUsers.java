//Equilibrha 2017. Clase para "cachear" datos usuario y no tener que almacenar mas
package com.common.globalSystems.login;

import java.util.ArrayList;
import java.util.Date;

import com.common.config.ParamsApp;

public final class credentialUsers {
	
	//array de credenciales de usuarios
	private static ArrayList<logonCredencialProcess> credentials = new ArrayList<logonCredencialProcess>();

	
	//Devuelvo posicion de una credencial
	
	public  static int getPosCredencial(String KeyCode)
	{
		int aux=-1;
		for (int i = 0; i< credentials.size() ;i++){
			if (credentials.get(i).SerialKeyMainReturnApps.equals(KeyCode))
			{
				aux = i;
				return aux;
			}
		}
		
		return aux;
	}
	
	public  static logonCredencialProcess getCredencial(int pos)
	{
		return credentials.get(pos);
	}
	
	
	
	//aumentamos en minutos a fecha de ejecuciuon la validez
	public static void setNewCredentialDate(String KeyCode){
		int pos = getPosCredencial(KeyCode);
		
		if (pos != -1)
		{
			new ParamsApp();
			 
			long t=new Date().getTime();
			Date dateAfter = new Date(t + (ParamsApp.SYSTEM_LOGIN_TIME_TOKEN_MINUTES * 1000)); 
			credentials.get(pos).dateTokenCaduc = dateAfter; //asignamos nueva fecha
		}
	}
	
	
	//añade una credencial
	public static void addCredential(logonCredencialProcess data){
		credentials.add(data);
	}
	
	//elimina una credencial
	public static void delCredentialInPosition(int pos){
		credentials.remove(pos);
	}
	public static void delCredentialOfKeySerial(String KeyCode){
		int pos = getPosCredencial(KeyCode);
		
		if (pos != -1)
		{
			delCredentialInPosition(pos);
		}
	}
	
	public static void delAllCredential(){
		int Num = credentials.size()-1;
		
		for (int i = 0; i<= Num ;i++){
			delCredentialInPosition(0);
		}
	}
	
	//se eliminan con recuersividad
	public static void delCredencialCaducadas()
	{
		//eliminacion de crendeciales caducadas de la lista
		for (int i = 0; i< credentials.size() ;i++){
			
			Date fecha = credentials.get(i).dateTokenCaduc;
			Date date = new Date();
			if (!(fecha.compareTo(date) > 0)){
				
				//elimino
				delCredentialInPosition(i);
				
				//llamada recursiva
				delCredencialCaducadas();
				
				return;
			}
			
		}
	}

	

	
	
}
