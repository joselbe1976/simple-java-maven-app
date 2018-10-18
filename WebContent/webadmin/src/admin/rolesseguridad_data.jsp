<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@include file="../globales/filtersTablejquery.jsp" %>
<%@ page import="com.common.hibernate.classes.hb_roles" %>

<%@include file="../login/seguridad_data.jsp" %>
<%@page import="com.common.config.ParamsApp"%>

<%


hb_roles roles;
JSONArray lista;

try{
	
		//filtro de la tabla
		
	
	
	
		//Instanciamos la clase de roles
		roles = new hb_roles();
		
		//creamos un array de Json
		lista = new JSONArray();
		
		//Ejecutamos la consulta de roles
		List<?> data = roles.getLista(where); //aplicamos el filtro
		
		//recorremos los datos
		for (int i = 0; i< data.size();i++)
		{
			 VinRoles  rol = (VinRoles)data.get(i); //capturamos la entidad role de la lista
		
			 //creamos objeto Json
			 JSONObject obj = new JSONObject();
			 
			 //asignamos datos
			 obj.put("id", rol.getId());	
			 obj.put("name", rol.getName());
			 String rolec = rol.getComment();
			 if (rolec == null)
			 {
				 rolec="";
			 }
			 obj.put("comment", rolec);
			 obj.put("parse_channel", rol.getParseChannel());
			 
			 
			 //añadimos al array de registros de Json
			 lista.put(obj);
			 
		}

		roles.close_session_user(); //cerramos a mano la session
		out.print(lista.toString()); //imprimirmos el Jason
}
catch(Exception e){
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error roles_seguridad_data.jsp:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
	
}
finally
{
	lista = null;
	
	roles=null;
}


%>