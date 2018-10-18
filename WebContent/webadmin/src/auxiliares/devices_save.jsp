<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.common.hibernate.classes.hb_devices, com.common.hibernate.entidades.*" %>

<%@include file="../login/seguridad_data.jsp" %>

<%

String oper  ="";
String id_device  ="";
String name  ="";
String comment  ="";
String parse_chanel  = "";
String parse_device_type  = "";

try{
	//recuperamos el request
	oper = request.getParameter("oper");
	id_device = request.getParameter("id_device")==null?"":request.getParameter("id_device");
	name = request.getParameter("name")==null?"":request.getParameter("name");
	parse_chanel = request.getParameter("parse_channel")==null?"":request.getParameter("parse_channel");
	parse_device_type = request.getParameter("parse_device_type")==null?"":request.getParameter("parse_device_type");
	comment = request.getParameter("comment")==null?" ":request.getParameter("comment");
}
catch(Exception e)
{
	System.out.print(e.getStackTrace());
}
finally
{
}

hb_devices data; //objeto clase
Boolean result = false;
String DevText="true{Datos grabados correctamente";

data = new hb_devices();
VinDevices dev = new VinDevices();

try{

	
	
	if (oper.equals("NEW"))  //registro nuevo
	{
		
		//creamos el objeto de la clase de grabacion
		dev.setIdDevice(id_device);
		dev.setName(name);
		dev.setComment(comment);
		dev.setParseChannel(parse_chanel);
		dev.setParseDeviceType(parse_device_type);
		
		//Lanzamos la grabación	
		result = data.addRecord(dev);	
	}
	else if (oper.equals("MOD"))
	{
		dev.setIdDevice(id_device);
		dev.setName(name);
		dev.setComment(comment);
		dev.setParseChannel(parse_chanel);
		dev.setParseDeviceType(parse_device_type);
				
		
		result = data.updateRecord(dev);
	}
	else if (oper.equals("DEL"))
	{
		result = data.deleteRecord(id_device); 
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
	System.out.print("\n (JSP) ERROR:"+e.getMessage()+"\n");
	System.out.print(e.getStackTrace());
}
finally
{
	data.close_session_user(); //cerramos a mano la session Siempre
	data = null;
	dev = null;
}
%>