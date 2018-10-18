package com.common.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



// Jose Luis Bustos Esteban 2014. Clase de operaciones con Fechas como Tools del web service
public class DatesTools {

	
	//Funcion que convierte una cadena y devuyelve la fecha Calendar
	public Calendar StringToDate(String cadfecha) throws ParseException
	{
	
		//SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); //formarto fecha desde Cliente IOS/Android 
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss"); //formarto fecha desde Cliente IOS/Android 
		//Date date = formatter.parse(cadfecha);
		Calendar cal = Calendar.getInstance();
		cal.setTime(formatter.parse(cadfecha));
		return cal;
	 
		
	}
	
	public String StringToDate(Date fecha, String format) throws ParseException
	{
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(fecha);
			
	}	
}
