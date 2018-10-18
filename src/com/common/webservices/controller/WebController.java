//Equilibra. Controller para alta disponibilidad
package com.common.webservices.controller;

import java.math.BigInteger;
import java.util.Iterator;

import com.common.config.ParamsApp;
import com.common.hibernate.classes.hb_dynamic_actions;

public class WebController {
	
	//Método llamado por el Dispacher, para saber de un backend como esta en rendimiento. 
	public double getUserActives()
	{

		double rst = 0;  //  resultado
		BigInteger numUsers = BigInteger.valueOf(0); //  usuarios conectados al backend
		double numDouble =0;  //  % de CPU en uso
	    	EqControlRuntime controlRunTime;
	    	Runtime runtime;
		 
		 //Obtenemos los usuarios activos
			hb_dynamic_actions a = new hb_dynamic_actions();
			Iterator result = null;
			String Servidor = new ParamsApp().SYSTEM_SERVER_ID;  //ID DEL SERVIDOR DEL BACKEND
			String SystemDefault = new ParamsApp().SYSTEM_LOGIN_DEFAULT;  //SISTEMA POR DEFECTO DELL BACKEND
			
			try{
					//Calculamos el % de CPU
					controlRunTime = new EqControlRuntime(); //instancio clase
					numDouble = controlRunTime.getLoadCPU(); //Calculo % CPU usada
				
					//usuarios se consideran los del sistema LOCAL
					String sql = "select count(*), 'nada' from vin_users_system a, vin_systems b, vin_users c where a.id_system = b.id_system and a.id_user=c.id_user and a.server_id = '" + Servidor  + "'";
					sql+= " and a.id_system = '"+ SystemDefault +"' and a.dt_cad_token > now() ";;
					result = a.execDynamicSelect(sql);
					

					while ( result.hasNext() ) {
						Object[] tuple = (Object[]) result.next();
						numUsers = (BigInteger) tuple[0]; //Usuarios
	
					}
	
					//Calculo el rendimiento. Usuarios / carga de CPU
					// Asi calculamos si con un % de PCU cuantos usuarios tenga. A menor % de CPU Mejor.
					
					//Si el % de CPU = 0% = Ponemos por defecto 0,1%
					if (numDouble == 0){ numDouble = 0.1;}
			
					//Si no hay usuario, considero siempre como 10, porque sino siempre va dar mál rendimiento
					if (numUsers.intValue() == 0){numUsers = BigInteger.valueOf(10);}
			
					//calculamos el %
					rst = numUsers.intValue()/numDouble;  //FACTOR Multiplicador
					
					//alert Control
					if (controlRunTime.getStatusMemoryBackend().equals("ALERT")){
						rst = -1; //devolvemos -1
					}
					
			}	
			catch(Exception e){
					System.out.println("\n Error WebController:"+ e.getMessage());
			}
			
		finally
		{
				a = null;
				result = null;
				controlRunTime = null;
		}
		return rst;
	}
	
	
	
	
	//Ping Method for Dispacher
	public int pingWC()
	{
		return 1;
	}

}
