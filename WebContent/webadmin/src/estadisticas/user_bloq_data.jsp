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
		String sql = "select count(*), CASE bloq   when '0' then 'No Bloqueado'   when '1' then 'Bloqueado' END as tipo from vin_users a group by bloq";
		result = a.execDynamicSelect(sql);
		
		
		while ( result.hasNext() ) {
		    Object[] tuple = (Object[]) result.next();
		    BigInteger numero = (BigInteger) tuple[0];
		    String nombre = (String) tuple[1];
		    
		    JSONObject obj = new JSONObject();
		    obj.put("num",numero);	
		    obj.put("name",nombre);	
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