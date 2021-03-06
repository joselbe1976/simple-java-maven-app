<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@include file="../globales/filtersTablejquery.jsp" %>
<%@ page import="com.common.hibernate.classes.hb_devices" %>
<%@ page import="com.common.hibernate.classes.hb_tools" %>


<%@include file="../login/seguridad_data.jsp" %>

<%

hb_devices data1;
JSONArray lista;
List<?> dataAux;
hb_tools tools;

try{
		//Instanciamos la clase de roles
		data1 = new hb_devices();
		tools = new hb_tools();
		
		//creamos un array de Json
		lista = new JSONArray();
		
		//Ejecutamos la consulta de roles
		dataAux = data1.getLista(where); //aplicamos el filtro
		
		//recorremos los datos
		for (int i = 0; i< dataAux.size();i++)
		{
			VinDevices  record = (VinDevices)dataAux.get(i); //capturamos la entidad Usamos vista 
			  	 
			 //creamos objeto Json
			 JSONObject obj = new JSONObject();
			 
			 //asignamos datos
			 obj.put("id_device",record.getIdDevice());	
			 obj.put("name", record.getName());
			 obj.put("comment", tools.controlNulls(record.getComment()));
			 obj.put("parse_channel", tools.controlNulls(record.getParseChannel()));
			 obj.put("parse_device_type", tools.controlNulls(record.getParseDeviceType()));
			 
			 

			 //añadimos al array de registros de Json
			 lista.put(obj);
		}

		if (dataAux.size() ==0)
		{
			out.print("null");
		}
		else
		{
			out.print(lista.toString()); //imprimirmos el Json
		}
		
		data1.close_session_user(); //cerramos a mano la session


}
catch(Exception e){
	System.out.print("\n\n (JSP) ERROR GRAVE:"+e.getMessage()+"\n\n");
	out.print("null");
}
finally
{
	lista = null;
	data1=null;
	dataAux=null;
	tools=null;
}


%>