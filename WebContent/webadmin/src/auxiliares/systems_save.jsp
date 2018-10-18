<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.common.hibernate.classes.hb_systems, com.common.hibernate.entidades.*" %>
<%@page import="com.common.config.ParamsApp"%>
<%@include file="../login/seguridad_data.jsp" %>


<%

String oper  ="";
String id_system  ="";
String name  ="";
String comment = "";
String sys_user_fijo="";
String sys_pass_fijo="";
String token_login="";
String ldap="0";
String all_users="";
String parse_chanel  = "";

try{
	//recuperamos el request
	id_system = request.getParameter("id_system")==null?"":request.getParameter("id_system");
	oper = request.getParameter("oper");
	name = request.getParameter("name")==null?"":request.getParameter("name");
	comment = request.getParameter("comment")==null?"":request.getParameter("comment");
	sys_user_fijo = request.getParameter("sys_user_fijo")==null?"":request.getParameter("sys_user_fijo");
	sys_pass_fijo = request.getParameter("sys_pass_fijo")==null?"":request.getParameter("sys_pass_fijo");
	token_login = request.getParameter("token_login")==null?"0":request.getParameter("token_login");
	//ldap = request.getParameter("ldap")==null?"0":request.getParameter("ldap");
	all_users = request.getParameter("all_users")==null?"0":request.getParameter("all_users");
	parse_chanel = request.getParameter("parse_channel")==null?"":request.getParameter("parse_channel");
}
catch(Exception e)
{
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error JSP:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
}
finally
{

}

hb_systems data; //objeto clase
Boolean result = false;
String DevText="true{Datos grabados correctamente";

data = new hb_systems();
VinSystems usr = new VinSystems();

try{


	
	
	if (oper.equals("NEW"))  //registro nuevo
	{
		usr.setIdSystem(id_system);
		usr.setName(name);
		usr.setComment(comment);
		usr.setChkLdap(Integer.parseInt(ldap));
		usr.setChkAllUsers(Integer.parseInt(all_users));
		usr.setChkTokenLogin(Integer.parseInt(token_login));
		usr.setSysPassFijo(sys_pass_fijo);
		usr.setSysUserFijo(sys_user_fijo);
		usr.setParseChannel(parse_chanel);
		
		//Lanzamos la grabación	
		result = data.addRecord(usr);	
	}
	else if (oper.equals("MOD"))
	{
		//busco el objeto a editar
	 	usr=data.getDataObject(id_system);			

	 	
		//asigno valores
		usr.setName(name);
		usr.setComment(comment);
		usr.setChkLdap(Integer.parseInt(ldap));
		usr.setChkAllUsers(Integer.parseInt(all_users));
		usr.setChkTokenLogin(Integer.parseInt(token_login));
		usr.setSysPassFijo(sys_pass_fijo);
		usr.setSysUserFijo(sys_user_fijo);
		usr.setParseChannel(parse_chanel);		
		result = data.updateRecord(usr);
			
	}
	else if (oper.equals("DEL"))
	{
		result = data.deleteRecord(id_system); 
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
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error JSP:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
}
finally
{
	data.close_session_user(); //cerramos a mano la session Siempre
	data = null;
	usr = null;
}
%>