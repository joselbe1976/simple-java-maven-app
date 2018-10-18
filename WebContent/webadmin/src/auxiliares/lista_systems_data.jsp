<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@include file="../globales/filtersTablejquery.jsp" %>
<%@ page import="com.common.hibernate.classes.hb_systems" %>
<%@ page import="com.common.hibernate.classes.hb_tools" %>

<%@include file="../login/seguridad_data.jsp" %>


<%

hb_systems data1;
JSONArray lista;
List<?> dataAux;
hb_tools tools;

try{
		//Instanciamos la clase de roles
		data1 = new hb_systems();
		tools = new hb_tools();
		
		//creamos un array de Json
		lista = new JSONArray();
		
		//Ejecutamos la consulta 
		dataAux = data1.getLista(where); //aplicamos el filtro

		
		//Blanco
			 JSONObject obj2 = new JSONObject();
			 
			 obj2.put("id_system",""); //cadena de 10
			 obj2.put("name","");
			 
			 //añadimos al array de registros de Json
			 lista.put(obj2);
		
		
		//recorremos los datos
		for (int i = 0; i< dataAux.size();i++)
		{
			 VinSystems  record = (VinSystems)dataAux.get(i); //capturamos la entidad Usamos vista 
 
			 //creamos objeto Json
			 JSONObject obj = new JSONObject();
			 
			 obj.put("id_system",record.getIdSystem()); //cadena de 10
			 obj.put("name",record.getName());
			 
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