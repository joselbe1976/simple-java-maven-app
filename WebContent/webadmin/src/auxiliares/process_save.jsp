<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.common.hibernate.classes.hb_process,com.common.hibernate.classes.hb_systems, com.common.hibernate.entidades.*" %>
<%@page import="com.common.config.ParamsApp"%>
<%@include file="../login/seguridad_data.jsp" %>

<%

String oper  ="";
String id_process  ="";
String name  ="";
String comment  ="";
String id_system  ="";
try{
	//recuperamos el request
	oper = request.getParameter("oper");
	id_process = request.getParameter("id_process")==null?"0":request.getParameter("id_process");
	name = request.getParameter("name")==null?"":request.getParameter("name");
	comment = request.getParameter("comment")==null?" ":request.getParameter("comment");
	id_system = request.getParameter("id_system")==null?"":request.getParameter("id_system");
		
}
catch(Exception e)
{
	System.out.print("\n\nERROR:\n\n");
	System.out.print(e.getStackTrace());
}
finally
{

}

hb_process data; //objeto clase
Boolean result = false;
String DevText="true{Datos grabados correctamente";

data = new hb_process();
VinProcess usr = new VinProcess();

try{

	
	
	if (oper.equals("NEW"))  //registro nuevo
	{
		
		//creamos el objeto de la clase de grabacion
		usr.setIdProcess(id_process);
		usr.setName(name);
		usr.setComment(comment);
		usr.setVinSystems(new hb_systems().getDataObject(id_system)); //Sistema asociado
		
		//Lanzamos la grabación	
		result = data.addRegister(usr);	
	}
	else if (oper.equals("MOD"))
	{
		//busco al usuario
	 	usr=data.getDataObject(id_process);			

	 	
		//asigno valores
		usr.setName(name);
		usr.setComment(comment);
		usr.setVinSystems(new hb_systems().getDataObject(id_system)); //Sistema asociado
		
		result = data.Updatedata(usr);
			
	}
	else if (oper.equals("DEL"))
	{
		result = data.Deletedata(id_process); 
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
	usr = null;
}
%>