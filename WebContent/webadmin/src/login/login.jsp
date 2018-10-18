<%@page import="com.common.config.ParamsApp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.common.globalSystems.login.*" %>



<% 

logonMain Login; 

//opcionales que vengan
try{

	//obtenemos los request de la pagina de login
	String user = request.getParameter("loginEmail");
	String password = request.getParameter("loginPass");
	String languaje=request.getParameter("idioma");
	
	//Si el idioma esta vacio, ponemos el por defecto del sistema
	new ParamsApp();
	if (languaje.equals("")) { languaje = ParamsApp.META4_LANGUAJE;}
	
	String DevText="true";
	
	//obtenemos un objketo Login
	String Dispositivo = "1"; //Web
	String UUID = "WEB"; //UUID para la web
	Login = new logonMain(languaje,Dispositivo,UUID); //le indico idioma, dipositivo del que me conecto, y UUID que aqui no aplica.
	
	//Indicamos que venimos desde la web.
	Login.setAccessFromWeb();
	
	//Hacemos Login
	String Dev = Login.logonSystem(user, user, password);
	
	if (Dev.contains("ERROR") || Dev.equals(""))
	{
		//login Error
		session.setAttribute( "SessionLoginKeySerial", "");
		DevText="false";
	}
	else
	{
		//Login OK
		session.setAttribute( "SessionLoginKeySerial", Dev);
		session.setAttribute( "SessionLanguaje", languaje);
		session.setAttribute( "SessionUser", user);
	}
	
	
	
	out.print(DevText);
	
}
catch(Exception e){
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error doing Login",ParamsApp.LOG_TYPE_INFO);
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Detail: " + e.getStackTrace(),ParamsApp.LOG_TYPE_INFO);
	
}
finally
{
	Login =null;	
}



%>