<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.hibernate.classes.hb_dynamic_actions" %>
<%@ page import="java.math.BigInteger" %>
<%@ page import="java.util.Iterator" %>
<%@page import="com.common.config.ParamsApp"%>
<%@include file="../login/seguridad_data.jsp" %>

<%

JSONArray lista;
hb_dynamic_actions a = new hb_dynamic_actions();
Iterator result = null;

try{
		
		lista = new JSONArray();
		String sql = "select c.id_user, c.user_name, b.name, a.dt_cad_token caduca from vin_users_system a, vin_systems b, vin_users c where a.id_system = b.id_system and a.id_user=c.id_user and a.dt_cad_token > NOW()";
		result = a.execDynamicSelect(sql);
		
		
		while ( result.hasNext() ) {
		    Object[] tuple = (Object[]) result.next();
		    String id_user = (String) tuple[0];
		    String nombre_user = (String) tuple[1];
		    String nombre_system = (String) tuple[2];
		    java.sql.Timestamp caduca = (java.sql.Timestamp) tuple[3];
		    
		    JSONObject obj = new JSONObject();
		    obj.put("id_user",id_user);	
		    obj.put("nombre_user",nombre_user);
		    obj.put("nombre_system",nombre_system);
		    obj.put("caduca",caduca);	
		    lista.put(obj);
		}
		
		out.print(lista.toString()); //imprimirmos el Json

}
catch(Exception e){
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error JSP:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
	out.print("null");
}
finally
{
	result = null;
}


%>