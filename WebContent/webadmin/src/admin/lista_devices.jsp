<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.hibernate.classes.hb_devices" %>
<%@include file="../login/seguridad_data.jsp" %>

<%


hb_devices data;
JSONArray lista;

try{
	
		//Instanciamos la clase de roles
		data = new hb_devices();
		
		//creamos un array de Json
		lista = new JSONArray();
		
		//Ejecutamos la consulta de roles
		List<?> dataAux = data.getLista(""); //aplicamos el filtro
		
		//recorremos los datos
		for (int i = 0; i< dataAux.size();i++)
		{
			 VinDevices  rec = (VinDevices)dataAux.get(i); //capturamos la entidad 
		
			 //creamos objeto Json
			 JSONObject obj = new JSONObject();
			 
			 //asignamos datos
			 obj.put("id_device", rec.getIdDevice());	
			 obj.put("name", rec.getName());
			 //añadimos al array de registros de Json
			 lista.put(obj);
			 
		}

		data.close_session_user(); //cerramos a mano la session
		out.print(lista.toString()); //imprimirmos el Jason
}
catch(Exception e){
	System.out.print("\n\n ERROR GRAVE:"+e.getMessage()+"\n\n");
}
finally
{
	lista = null;
	data=null;
}


%>