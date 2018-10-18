package com.portalmobile.meta4.funcional;

import javax.xml.rpc.Stub;

import com.common.config.ParamsApp;
import com.common.globalSystems.login.logonCredencialProcess;
import com.common.tools.xml.XmlHelper;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_DashboardService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_DashboardServiceService;
import com.portalmobile.meta4.schemas.Csp_Mbl_Soap_DashboardServiceServiceLocator;
import com.portalmobile.meta4.schemas.types.Csp_Get_Data_GraficOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutRecord;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_DatesOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_Dates_OutBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_Dates_OutRecord;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_GrpsOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_Grps_OutBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_Grps_OutRecord;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_IndicadoresOutput;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutBlock;
import com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutRecord;

public class Meta4Object_Dashboard {
	
	ParamsApp IntParams = new ParamsApp(); //Clase de parametros y funciones especiales
	XmlHelper helperXml =  new XmlHelper();
	
	

	// Lista de grupos de indicadores que ve el usuario conectado
	public String GetListaGruposIndicadores(logonCredencialProcess Session) throws Exception
	{
		
		helperXml.vaciar();
		//control session (si las credenciales erronas, devolvemos vacio)
		if (Session==null) {return helperXml.getErrorValues("");}
		
		
		IntParams.debugInfo("Metodo: GetListaGruposIndicadores");

		

		//String dev = "";
		@SuppressWarnings("unused") Double DevMetodo=0.00;
		@SuppressWarnings("unused") String ResultSerial="";
		
		String XML="";
		//String result="";
		

		
		javax.xml.rpc.Stub oStub = null;	
		try{
		
			Csp_Mbl_Soap_DashboardServiceService  Sfactory = new Csp_Mbl_Soap_DashboardServiceServiceLocator();
			Csp_Mbl_Soap_DashboardService Meta4Object = Sfactory.getCSP_MBL_SOAP_DASHBOARD();
			Csp_Get_List_GrpsOutput  SalidaExec;
			
			//mantenemos la session proy
			oStub = (javax.xml.rpc.Stub)Meta4Object;
			oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
			
			//ejecutamos el m�todo
			Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
			SalidaExec =	 Meta4Object.CSP_GET_LIST_GRPS(); //ejecutamos metodo en Meta4
			DevMetodo = SalidaExec.get_return();
			
			
			//cargamos el Bloque de registros
			Csp_Get_List_Grps_OutBlock Bloque = SalidaExec.getCsp_Get_List_Grps_Out();
			//Montamos el recordset
			Csp_Get_List_Grps_OutRecord Rec[] =  Bloque.getCsp_Get_List_Grps_OutRecordSet();
			
	
			helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
			helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
			
			//code meta4
			helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
			
			//Resultado Operacion metodo
			helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
					
			//XML: num registros. 
			helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
		
			
		
			for (int z = 0;z<Rec.length;z++)
			{
				helperXml.addXmlItem("dbid",z, Rec[z].getCsp_Id_Grupo().toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("dbnombre",z, Rec[z].getCsp_Nombre().toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("dbdescripcion",z, Rec[z].getCsp_Descripcion().toString(), helperXml.XML_NORMAL);
							
			} //del for

			helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);		
			XML = helperXml.getValues();
						

			
		}
		catch(Exception e)
		{
			IntParams.debugInfo("ERROR: .. al ejecutar GetListaGruposIndicadores : " + e.getMessage());
			XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
		}
		finally
		{
		
		}
		
		return XML;
	}
	
	
	
	
	    // Lista de Fechas
		public String GetListaFechas(logonCredencialProcess Session) throws Exception
		{

			helperXml.vaciar();
			
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}

			IntParams.debugInfo("Metodo: GetListaFechas");

			

			//String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			//String result="";
			

			
			javax.xml.rpc.Stub oStub = null;	
			try{
			
				Csp_Mbl_Soap_DashboardServiceService  Sfactory = new Csp_Mbl_Soap_DashboardServiceServiceLocator();
				Csp_Mbl_Soap_DashboardService Meta4Object = Sfactory.getCSP_MBL_SOAP_DASHBOARD();
				Csp_Get_List_DatesOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.CSP_GET_LIST_DATES(); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Csp_Get_List_Dates_OutBlock Bloque = SalidaExec.getCsp_Get_List_Dates_Out();
				//Montamos el recordset
				Csp_Get_List_Dates_OutRecord Rec[] =  Bloque.getCsp_Get_List_Dates_OutRecordSet();
				
				
				
				
				//Pila de errores
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);
			
			
				
					
				for (int z = 0;z<Rec.length;z++)
				{
					helperXml.addXmlItem("fecha",z, Rec[z].getCsp_Fecha().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("anio",z, Rec[z].getCsp_Anio().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("mes",z,Rec[z].getCsp_Mes().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("nombre",z,Rec[z].getCsp_Nombre_Fecha().toString() , helperXml.XML_NORMAL);
					
				} //del for

				helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
				XML = helperXml.getValues();

							

				
			}
			catch(Exception e)
			{
				IntParams.debugInfo("ERROR: .. al ejecutar GetListaFechas : " + e.getMessage());
				XML = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			}
			finally
			{
			
			}
			
			return XML;
		}
		
		
		
		

	    // Lista de Indicadores (los calsula y devuelve resultados)
		public String GetListaIndicadores(logonCredencialProcess Session,String grupoIndicadores,String fechaCalculo, String Operacion) throws Exception
		{
			helperXml.vaciar();

			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}

			
			IntParams.debugInfo("Metodo: GetListaIndicadores");
			IntParams.debugInfo("     Grupo: "+grupoIndicadores);
			

			//String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			//String result="";
			

			
			javax.xml.rpc.Stub oStub = null;	
			try{
			
				Csp_Mbl_Soap_DashboardServiceService  Sfactory = new Csp_Mbl_Soap_DashboardServiceServiceLocator();
				Csp_Mbl_Soap_DashboardService Meta4Object = Sfactory.getCSP_MBL_SOAP_DASHBOARD();
				Csp_Get_List_IndicadoresOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.CSP_GET_LIST_INDICADORES(grupoIndicadores, fechaCalculo,Operacion);//ejecutamos metodo en Meta4
				
				
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Csp_Get_List_Indicadores_OutBlock Bloque = SalidaExec.getCsp_Get_List_Indicadores_Out();
				//Montamos el recordset
				Csp_Get_List_Indicadores_OutRecord Rec[] =  Bloque.getCsp_Get_List_Indicadores_OutRecordSet();
				
				
				
				
				//Pila de errores
			
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);	
				
				//fecha de proceso, se lo enviamos al cliente
				helperXml.addXmlItem("fechaproceso", Bloque.getCsp_Fecha_Proceso().toString(), helperXml.XML_NORMAL);
				helperXml.addXmlItem("fechaprocesonm", Bloque.getCsp_Fecha_Proceso_Name().toString(), helperXml.XML_NORMAL);
				
				
				for (int z = 0;z<Rec.length;z++)
				{
					helperXml.addXmlItem("id",z,Rec[z].getCsp_Id_Indicador().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("semaforo",z,Rec[z].getCsp_Semaforo().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("valor",z,Rec[z].getCsp_Valor_Actual().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("nombre",z,Rec[z].getCsp_Nombre().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("valor_aa",z,Rec[z].getCsp_Valor_Aa().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("valor_ma",z,Rec[z].getCsp_Valor_Ma().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("ten_ma",z,Rec[z].getCsp_Tendencia_Ma().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("ten_aa",z,Rec[z].getCsp_Tendencia_Aa().toString(), helperXml.XML_NORMAL);

					
				} //del for

				helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
				XML = helperXml.getValues();		

							

				
			}
			catch(Exception e)
			{
				IntParams.debugInfo("ERROR: .. al ejecutar GetListaIndicadores : " + e.getMessage());
				System.out.print("\n 	ERROR al Ejecutar:"+e.getMessage());
				System.out.print("\n"+e.getStackTrace());
				
				XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			}
			finally
			{
			}
			
			return XML;
		}
	
	


	    // Lista de Indicadores (los calsula y devuelve resultados)
		public String GetDataGrafico(logonCredencialProcess Session,String grupoIndicadores,String indicador,String fechaCalculo) throws Exception
		{
			helperXml.vaciar();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}
			
			IntParams.debugInfo("Metodo: GetDataGrafico");

	
			//String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			//String result="";
			

			
			javax.xml.rpc.Stub oStub = null;	
			try{
			
				Csp_Mbl_Soap_DashboardServiceService  Sfactory = new Csp_Mbl_Soap_DashboardServiceServiceLocator();
				Csp_Mbl_Soap_DashboardService Meta4Object = Sfactory.getCSP_MBL_SOAP_DASHBOARD();
				Csp_Get_Data_GraficOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.CSP_GET_DATA_GRAFIC(grupoIndicadores,indicador, fechaCalculo);//ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Csp_Get_Data_Grafic_OutBlock Bloque = SalidaExec.getCsp_Get_Data_Grafic_Out();
				//Montamos el recordset
				Csp_Get_Data_Grafic_OutRecord Rec[] =  Bloque.getCsp_Get_Data_Grafic_OutRecordSet();
				
				
				helperXml.addXmlItem("object1", "object", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores1", "Errores", helperXml.XML_NO_CERRAR_XML);
				helperXml.addXmlItem("errores2", "Errores", helperXml.XML_SOLO_CERRAR_XML);
				
				//code meta4
				helperXml.addXmlItem("codeMeta4", com.Ostermiller.util.Base64.encode(Session.SerialKeyMainReturnApps), helperXml.XML_NORMAL);
				
				//Resultado Operacion metodo
				helperXml.addXmlItem("Resultado",String.valueOf(SalidaExec.get_return()), helperXml.XML_NORMAL);
						
				//XML: num registros. 
				helperXml.addXmlItem("Records", String.valueOf(Rec.length), helperXml.XML_NORMAL);	
				

				//Totales
				helperXml.addXmlItem("totalreal", Bloque.getCsp_Total_Anio_Real() , helperXml.XML_NORMAL);	
				helperXml.addXmlItem("totalestimado", Bloque.getCsp_Total_Anio_Esperado(), helperXml.XML_NORMAL);	
				helperXml.addXmlItem("totalporcanio", Bloque.getCsp_Porc_Anio(), helperXml.XML_NORMAL);	
				
				
				
				//Valores de nodo
				
				if (Rec.length > 0)
				{
					helperXml.addXmlItem("nombre", Bloque.getCsp_Nombre().toString(), helperXml.XML_NORMAL);
					helperXml.addXmlItem("lit1", Bloque.getCsp_Literal_Col_1().toString() , helperXml.XML_NORMAL);
				}
				//valores registro
				
				
					
				for (int z = 0;z<Rec.length;z++)
				{
					helperXml.addXmlItem("mes",z, Rec[z].getCsp_Mes().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("anio",z,Rec[z].getCsp_Anio().toString()  , helperXml.XML_NORMAL);
					helperXml.addXmlItem("valor1",z, Rec[z].getCsp_Valor().toString() , helperXml.XML_NORMAL);
					helperXml.addXmlItem("valor2",z, Rec[z].getCsp_Valor_2().toString() , helperXml.XML_NORMAL);
					
				} //del for

				helperXml.addXmlItem("object2","object", helperXml.XML_SOLO_CERRAR_XML);
				XML = helperXml.getValues();	

							

				
			}
			catch(Exception e)
			{
				IntParams.debugInfo("ERROR: .. al ejecutar GetDataGraficos : " + e.getMessage());
				XML  = helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			}
			finally
			{
			
			}
			
			return XML;
		}
		
		
		
		
		

		// MOnta el menu con la imagen (ficha empleado + lista dimensiones)
		public String GetMenuDashboard(logonCredencialProcess Session) throws Exception
		{

			helperXml.vaciar();
			//control session (si las credenciales erronas, devolvemos vacio)
			if (Session==null) {return helperXml.getErrorValues("");}

			IntParams.debugInfo("Metodo: GetMenuDashboard");

			

			//String dev = "";
			@SuppressWarnings("unused") Double DevMetodo=0.00;
			@SuppressWarnings("unused") String ResultSerial="";
			
			String XML="";
			//String result="";
			
			Meta4Control control;
			
			javax.xml.rpc.Stub oStub = null;	
			try{
				
				
				
				//paso 1. Ejecutamos la ficha del empleado. y recogemos el XML
				
				control = new Meta4Control();
				//PENDIENTE
				XML+=  control.GetInfoConectedUser(Session); 
				
			/*
				Csp_Mbl_Soap_DashboardServiceService  Sfactory = new Csp_Mbl_Soap_DashboardServiceServiceLocator();
				Csp_Mbl_Soap_DashboardService Meta4Object = Sfactory.getCSP_MBL_SOAP_DASHBOARD();
				Csp_Get_List_GrpsOutput  SalidaExec;
				
				//mantenemos la session proy
				oStub = (javax.xml.rpc.Stub)Meta4Object;
				oStub._setProperty(Stub.SESSION_MAINTAIN_PROPERTY,new Boolean(true));
				
				//ejecutamos el m�todo
				Meta4Object.retrieveM4Session(Session.SerialKeyForIdProcess); //recuperamos la sesion
				SalidaExec =	 Meta4Object.CSP_GET_LIST_GRPS(); //ejecutamos metodo en Meta4
				DevMetodo = SalidaExec.get_return();
				
				
				//cargamos el Bloque de registros
				Csp_Get_List_Grps_OutBlock Bloque = SalidaExec.getCsp_Get_List_Grps_Out();
				//Montamos el recordset
				Csp_Get_List_Grps_OutRecord Rec[] =  Bloque.getCsp_Get_List_Grps_OutRecordSet();
				
						
				String XML2 ="";
					
				for (int z = 0;z<Rec.length;z++)
				{
					helperXml.addXmlItem("dbid",z, Rec[z].getCsp_Id_Grupo().toString(),helperXml.XML_NORMAL);
					helperXml.addXmlItem("dbnombre",z,Rec[z].getCsp_Nombre().toString() ,helperXml.XML_NORMAL);
					helperXml.addXmlItem("dbdescripcion",z,Rec[z].getCsp_Descripcion().toString() ,helperXml.XML_NORMAL);
				} //del for

				XML2 = helperXml.getValues();
				
				//REEMPLAZAMOS EL XML de la ficha del usuario conectado
				XML = XML.replace("<Records>1</Records>", "<Records>" + Rec.length + "</Records>" + XML2);
			//	XML+= XML + XML2; 		

				*/
				
				//XML = helperXml.getValues();
			}
			catch(Exception e)
			{
				IntParams.debugInfo("ERROR: .. al ejecutar GetMenuDashboard : " + e.getMessage());
				XML  =helperXml.getErrorValues(Session.SerialKeyMainReturnApps);
			}
			finally
			{
				control = null;
			}
			
			
			return XML;
		}
}
