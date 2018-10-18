<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="com.common.hibernate.classes.hb_params_device, com.common.hibernate.entidades.*" %>
<%@page import="com.common.config.ParamsApp"%>
<%@include file="../login/seguridad_data.jsp" %>
<%


String oper  ="";
String code  ="";
String id_param  ="";
String value  ="";
String comment  ="";
try{
	//recuperamos el request
	oper = request.getParameter("oper");
	id_param = request.getParameter("id_param")==null?"0":request.getParameter("id_param");
	code = request.getParameter("code")==null?"":request.getParameter("code");
	value = request.getParameter("value")==null?"":request.getParameter("value");
	comment = request.getParameter("comment")==null?" ":request.getParameter("comment");
}
catch(Exception e)
{
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error JSP:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
}
finally
{

}

hb_params_device data; //objeto clase
Boolean result = false;
String DevText="true{Datos grabados correctamente";

data = new hb_params_device();
VinParamsDevice usr = new VinParamsDevice();

try{

	
	
	if (oper.equals("NEW"))  //registro nuevo
	{
		
		VinParamsDeviceId aux = new VinParamsDeviceId();
		aux.setIdParam(Integer.parseInt(id_param));
		aux.setIdDevice(code);
		usr.setId(aux);
		usr.setComment(comment);
		usr.setValue(value);
		
		//Lanzamos la grabación	
		result = data.addRecord(usr);	
	}
	else if (oper.equals("MOD"))
	{

		usr = data.getObject(Integer.parseInt(id_param), code);
		usr.setComment(comment);
		usr.setValue(value);
		
		result = data.updateRecord(usr);
			
	}
	else if (oper.equals("DEL"))
	{
		result = data.deleteRecord(code, id_param); //Le pasamos el procerso y el parametro 
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