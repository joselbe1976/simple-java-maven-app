/*
 * Jose Luis Bustos Esteban 2014. Funciones para cosas de hibernate
 */
package com.common.hibernate.classes;

import java.util.Calendar;
import java.util.Date;

public class hb_tools {

	//Control de nulos
	public String controlNulls(String value)
	{	
		if (value==null)
		{
			return "";
		}
		else
		{
			return value;
		}
		
	}

	//Devuelve la fecha actual
	public String getDateToday()
	{
		//fecha de hoy
		Calendar cal1 = Calendar.getInstance();
		String mes = getFillData(String.valueOf(cal1.get(Calendar.MONTH)),2,"0",0);
		String dia = getFillData(String.valueOf(cal1.get(Calendar.DAY_OF_MONTH)),2,"0",0);

		return String.valueOf(cal1.get(Calendar.YEAR)) + "-" +  mes + "-" +  dia;
		
	}
	
	//metodo que nos rellena cadenas segun os parametros
	public String getFillData(String value, int size, String FillChar, int orientationFill)
	{
		String aux = value;
		int longdata = value.length();
		
		for (int i=longdata; i<size;i++)
		{
			if (orientationFill == 0) //por delante
			{
				aux = FillChar + aux;
			}
			else
			{
				aux = aux + FillChar;
			} //por detras
		}
		
		return aux;
	}
	
}
