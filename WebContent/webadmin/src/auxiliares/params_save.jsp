<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.common.hibernate.classes.hb_params_global, com.common.hibernate.entidades.*" %>

<%@include file="../login/seguridad_data.jsp" %>

<%

String oper  ="";
String id  ="";
String name  ="";
String comment  ="";
String value  ="";

try{
	//recuperamos el request
	oper = request.getParameter("oper");
	id = request.getParameter("id")==null?"0":request.getParameter("id");
	name = request.getParameter("name")==null?"":request.getParameter("name");
	comment = request.getParameter("comment")==null?" ":request.getParameter("comment");
	value = request.getParameter("value")==null?"":request.getParameter("value");
}
catch(Exception e)
{
	System.out.print("\n\nERROR:\n\n");
	System.out.print(e.getStackTrace());
}
finally
{
	if (id.equals("")){id="0";}
}

hb_params_global data; //objeto clase
Boolean result = false;
String DevText="true{Datos grabados correctamente";

data = new hb_params_global();
VinParamsGlobal usr = new VinParamsGlobal();

try{

	
	
	if (oper.equals("NEW"))  //registro nuevo
	{
		
		//creamos el objeto de la clase de grabacion
		//usr.setId -- No grabmos el ID porque es autonumerico
		usr.setName(name);
		usr.setComment(comment);
		usr.setValue(value);
		
		//Lanzamos la grabación	
		result = data.addRecord(usr);	
	}
	else if (oper.equals("MOD"))
	{
		//busco al usuario
	 	usr=data.getDataObject(id);			

		usr.setName(name);
		usr.setComment(comment);
		usr.setValue(value);
		
		result = data.updateRecord(usr);
			
	}
	else if (oper.equals("DEL"))
	{
		result = data.deleteRecord(id); 
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