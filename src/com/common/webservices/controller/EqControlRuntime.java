//Equilibrha, Control de carga de CPU. Devolvemos el % de carga. (No lo libre sino estado de carga de los procesadores)

package com.common.webservices.controller;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.Iterator;

import com.common.config.ParamsApp;
import com.common.hibernate.classes.hb_dynamic_actions;

public class EqControlRuntime {
	 
	//Devuelve la carga de la CPU	
	 public double getLoadCPU() {
		 
		 
				 //Obtengo la carga de la CPU
				OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
				 
				 double numDouble = 0;
				 int cont=0;
				 double x = 100.0;
				
				 for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
					  cont=cont+1;
				    method.setAccessible(true);
				    
					if (method.getName().startsWith("getSystemCpuLoad") 
				        && Modifier.isPublic(method.getModifiers())) {
				            Object value;
				        try {
				            value = method.invoke(operatingSystemMXBean);
				            value = method.invoke(operatingSystemMXBean).toString();
				            numDouble=Double.parseDouble((String) value)*100;
					        x=numDouble;
					        x=(double)((int)(x*100)/100.0); 
			        		
				        } catch (Exception e) {
				            value = e;
				        } 
				    } // if
					
				   } // for
				
	
				return x;
	}
	 
	 
	 
	 public int getNumActiveUsers(){
		    hb_dynamic_actions a = new hb_dynamic_actions();
			Iterator result = null;
			String Servidor = new ParamsApp().SYSTEM_SERVER_ID;  //ID DEL SERVIDOR DEL BACKEND
			String SystemDefault = new ParamsApp().SYSTEM_LOGIN_DEFAULT;  //SISTEMA POR DEFECTO DELL BACKEND
			BigInteger numUsers = BigInteger.valueOf(0); 
			
			
			try{
				
			
				//usuarios se consideran los del sistema LOCAL
				String sql = "select count(*), 'nada' from vin_users_system a, vin_systems b, vin_users c where a.id_system = b.id_system and a.id_user=c.id_user and a.server_id = '" + Servidor  + "'";
				sql+= " and a.id_system = '"+ SystemDefault +"' and a.dt_cad_token > now() ";
				result = a.execDynamicSelect(sql);
				

				while ( result.hasNext() ) {
					Object[] tuple = (Object[]) result.next();
					numUsers = (BigInteger) tuple[0]; //Usuarios

				}

				return numUsers.intValue();
				
		}	
		catch(Exception e){
				System.out.println("\n Error getNumActiveUsers:"+ e.getMessage());
				return 0;
		}
		
			finally
			{
				a = null;
				result = null;

			}

	 }
	 
		
		//Funciones de estado memoria
	 
	 
	 	public int getControllerAlertMemory(){
	 		return new ParamsApp().CONTROLLER_MEMORY_ALERT; 
	 	}

		public String getStatusMemoryBackend()
		{
			Runtime runtime;
			int CONTROLLER_MEMORY_ALERT  = getControllerAlertMemory(); 
			
			//Calculamos la memoria
			// --------------------
			try{
				 runtime = Runtime.getRuntime();
				 long total, free, used;
			     int mb = 1024*1024;

			     //calculamos como estamos de memoria en el RunTime de Java
			     total = runtime.totalMemory() / mb;
			     free = runtime.freeMemory() / mb;
			     used = (total - free);

			     if (used <= CONTROLLER_MEMORY_ALERT)
			     {
			    	 return "NORMAL";
			     }
			     else
			     {
			    	 return "ALERT";
			     }
			     
			}
			catch(Exception ee)
			{
				System.out.println("\n Error WebController:"+ ee.getMessage());
				return "ERROR";
			}
			finally{
				runtime = null;
			}
		}
		

		public long getMemoryTotalBackend()
		{
			Runtime runtime;
			try{
				 runtime = Runtime.getRuntime();
				 long total= 0;
			     int mb = 1024*1024;

			     //calculamos como estamos de memoria en el RunTime de Java
			     total = runtime.totalMemory() / mb;
			     return total;
			     
			}
			catch(Exception ee)
			{
				System.out.println("\n Error getMemoryTotalBackend:"+ ee.getMessage());
				return -1;
			}
			finally{
				runtime = null;
			}
		}
		
		public long getMemoryFreeBackend()
		{
			Runtime runtime;
			try{
				 runtime = Runtime.getRuntime();
				 long free= 0;
			     int mb = 1024*1024;

			     //calculamos como estamos de memoria en el RunTime de Java
			     free = runtime.freeMemory() / mb;
			     return free;
			     
			}
			catch(Exception ee)
			{
				System.out.println("\n Error getMemoryFreeBackend:"+ ee.getMessage());
				return -1;
			}
			finally{
				runtime = null;
			}
		}
		public long getMemoryUsedBackend()
		{
			Runtime runtime;
			try{
				runtime = Runtime.getRuntime();
				 long total, free, used;
			     int mb = 1024*1024;

			     //calculamos como estamos de memoria en el RunTime de Java
			     total = runtime.totalMemory() / mb;
			     free = runtime.freeMemory() / mb;
			     used = total - free;
			     return used;
			     
			}
			catch(Exception ee)
			{
				System.out.println("\n Error getMemoryUsedBackend:"+ ee.getMessage());
				return -1;
			}
			finally{
				runtime = null;
			}
		}
	 
}

			