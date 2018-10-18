<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@include file="../globales/filtersTablejquery.jsp" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.hibernate.classes.hb_users" %>
<%@ page import="com.common.hibernate.classes.hb_tools" %>


<%@include file="../login/seguridad_data.jsp" %>

<%

hb_users data1;
JSONArray lista;
List<?> dataAux;
hb_tools tools;

try{
	
		
		//Instanciamos la clase de roles
		data1 = new hb_users();
		tools = new hb_tools();
		
		//creamos un array de Json
		lista = new JSONArray();
		
		//Ejecutamos la consulta de roles
		dataAux = data1.getListaNoSeg(where); //aplicamos el filtro
		
		System.out.print("\n (JSP)numero:"+dataAux.size());
		
		//Vacio
		JSONObject obj2 = new JSONObject();
		 obj2.put("id_user","");	
		 obj2.put("user_name", "");
		lista.put(obj2);
		
		//recorremos los datos
		for (int i = 0; i< dataAux.size();i++)
		{
			 VinUsersView  Arecord = (VinUsersView)dataAux.get(i); //capturamos la entidad Usamos vista 
			 VinUsersViewId record = Arecord.getId(); 
		
			 
			 //creamos objeto Json
			 JSONObject obj = new JSONObject();
			 
			 //asignamos datos
			 obj.put("id_user",record.getIdUser());	
			 obj.put("user_name", record.getUserName());
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