<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.common.hibernate.classes.hb_users, com.common.hibernate.entidades.*" %>

<%@include file="../login/seguridad_data.jsp" %>

<%
	String oper  ="";
String id_user  ="";
String user_name  ="";
String comment  ="";
String id_role  ="";
String uuid_access  ="";
String id_disp_access  ="";
String password ="";
String bloq="";
try{
	//recuperamos el request
	oper = request.getParameter("oper");
	id_user = request.getParameter("id_user")==null?"0":request.getParameter("id_user");
	user_name = request.getParameter("user_name")==null?"":request.getParameter("user_name");
	comment = request.getParameter("comment")==null?"":request.getParameter("comment");
	id_role = request.getParameter("id_role")==null?"":request.getParameter("id_role");
	uuid_access = request.getParameter("uuid_access")==null?"":request.getParameter("uuid_access");
	id_disp_access = request.getParameter("id_disp_access")==null?"0":request.getParameter("id_disp_access");
	password = request.getParameter("password")==null?"0123456789":request.getParameter("password"); //default password at create de user.
	bloq = request.getParameter("bloq")==null?"0":request.getParameter("bloq"); //default password at create de user.	
}
catch(Exception e)
{
	System.out.print("\n\nERROR:\n\n");
	System.out.print(e.getStackTrace());
}
finally
{
	if (uuid_access.equals("")){uuid_access=" ";}
}

hb_users data; //objeto clase
Boolean result = false;
String DevText="true{Datos grabados correctamente";

data = new hb_users();
VinUsers usr = new VinUsers();

try{

	
	
	if (oper.equals("NEW"))  //registro nuevo
	{
		
		//creamos el objeto de la clase de grabacion
		usr.setIdUser(id_user);
		usr.setComment(comment);
		usr.setUserName(user_name);
		
		//devices
	VinDevices device = new VinDevices();
	
	//device Acceso
	device.setIdDevice(id_disp_access);
	usr.setVinDevicesByIdDispAccess(device);
	
	//device Login
	device.setIdDevice("0");
	usr.setVinDevicesByIdDispLogin(device);		

		//Role
		VinRoles rol = new VinRoles();
		rol.setId(Integer.parseInt(id_role));
		usr.setVinRoles(rol);			
		
		usr.setUuidAccess(uuid_access);
		usr.setPassword("0123456789"); //clave por defecto. No se podrá entrar nunca.
		usr.setUuidLogin(" ");
		usr.setBloq(0); //default no esta bloqueado
		
		//Lanzamos la grabación	
		result = data.addRecord(usr);	
	}
	else if (oper.equals("MOD"))
	{
		//busco al usuario
	 	usr=data.getUser(id_user);			

	 	
		//asigno valores
		usr.setIdUser(id_user);
		usr.setComment(comment);
		usr.setUserName(user_name);
		usr.setUuidAccess(uuid_access);
		usr.setBloq(Integer.parseInt(bloq));
		
		//devices
		VinDevices device = new VinDevices();
		
		//device Acceso
		device.setIdDevice(id_disp_access);
		usr.setVinDevicesByIdDispAccess(device);

		//Role
		VinRoles rol = new VinRoles();
		rol.setId(Integer.parseInt(id_role));
		usr.setVinRoles(rol);			
		
		
		result = data.updateRecord(usr);
	
	}
	else if (oper.equals("DEL"))
	{
		result = data.deleteRecord(id_user); 
	}
	else if (oper.equals("CHGPASSWORD")) //cambio de clave
	{
		result = data.savePassword(id_user, password);
		DevText="Cambiada la clave correctamente";
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
		else if (oper.equals("CHGPASSWORD"))
		{	
	DevText="Error al cambiar la clave";		
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
	usr = null;
}
%>