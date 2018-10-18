
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.common.hibernate.classes.hb_roles, com.common.hibernate.entidades.*" %>
<%@include file="../login/seguridad_data.jsp" %>
<%@page import="com.common.config.ParamsApp"%>


<%



String oper = "";
String id = "";
String name="";
String comment="";
String parse_channel="";

oper = request.getParameter("oper");
try{
	id = request.getParameter("id");
	if (id.equals("")){id="0";}
}
catch(Exception e){
	id = "0";
}


//opcionales que vengan
try{
	comment = request.getParameter("comment");
	if (comment.equals("")){comment="";}
}
catch(Exception e){
	comment = "";
}


try{
	name = request.getParameter("name");
}
catch(Exception e){
	name = "";
}

try{
	parse_channel = request.getParameter("parse_channel");
	if (parse_channel.equals("")){parse_channel="";}
}
catch(Exception e){
	parse_channel = "";
}




hb_roles roles; //objeto clase
Boolean result = false;
String DevText="true{Datos grabados correctamente";
roles = new hb_roles();

try{
	
	VinRoles aux = new VinRoles();	
	aux.setId(Integer.parseInt(id));
	aux.setName(name);
	aux.setComment(comment);
	aux.setParseChannel(parse_channel);
	
	if (oper.equals("NEW"))
	{
		result = roles.addRole(aux);	
	}
	else if (oper.equals("MOD"))
	{
		result = roles.UpdateRole(aux);
	}
	else if (oper.equals("DEL"))
	{
		result = roles.DeleteRole(id); //le pasamos la clave que identifica al registro
	}

	
	
	
}
catch(Exception e){
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error roles_seguridad_data.jsp:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
	
	
}
finally
{
	roles.close_session_user(); //cerramos a mano la session	
	roles = null;

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
%>