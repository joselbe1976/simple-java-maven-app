<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.common.hibernate.classes.hb_users_system,com.common.hibernate.entidades.*" %>

<%@include file="../login/seguridad_data.jsp" %>
<%@page import="com.common.config.ParamsApp"%>

<%

String oper  ="";
String id_user  ="";
String id_system="";
try{
	//recuperamos el request
	oper = request.getParameter("oper");
	id_user = request.getParameter("id_user")==null?"":request.getParameter("id_user");
	id_system= request.getParameter("id_system")==null?"":request.getParameter("id_system"); 	
}
catch(Exception e)
{
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error usuarios_system_save.jsp:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
	
}
finally
{

}

hb_users_system data; //objeto clase
Boolean result = false;
String DevText="true{Datos grabados correctamente";

data = new hb_users_system();
VinUsersSystem usr = new VinUsersSystem();
VinUsersSystemId usr2;
try{

	
	
	if (oper.equals("NEW"))  //registro nuevo
	{
		
		//creamos el objeto de la clase de grabacion

		usr2 = new VinUsersSystemId();
			usr2.setIdSystem(id_system);
			usr2.setIdUser(id_user);
		usr.setId(usr2);
		
		
		//Lanzamos la grabación	
		result = data.addRecord(usr);	
	}
	else if (oper.equals("MOD"))
	{
		usr = (VinUsersSystem)data.getUserSystem(id_user,id_system).get(0);
		usr2 = usr.getId();
			usr2.setIdSystem(id_system);
			usr2.setIdUser(id_user);
		usr.setId(usr2);
		
		result = data.updateRecord(usr);
			
	}
	else if (oper.equals("DEL"))
	{
		result = data.deleteRecord(id_user,id_system); 
	}
	
	
	if (result==false)
	{
		if (oper.equals("NEW"))
		{	
			DevText="false{Error al insertar";		
		}
		else if (oper.equals("MOD"))
		{	
			DevText="false{Error al actualizar";		
		}	
		else if (oper.equals("DEL"))
		{	
			DevText="false{Error al eliminar";		
		}	
		else 
		{	
			DevText="false{Error al procesar";		
		}	
	}
	
	
	out.print(DevText);
	
}
catch(Exception e){
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error usuarios_system_save.jsp:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
	
}
finally
{
	data.close_session_user(); //cerramos a mano la session Siempre
	data = null;
	usr = null;
}
%>