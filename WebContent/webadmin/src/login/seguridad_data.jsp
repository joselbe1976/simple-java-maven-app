<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.globalSystems.login.*" %>

<%

logonMain Login;


try{

	String segKey = (String)session.getAttribute( "SessionLoginKeySerial");
	
	//obtenemos un objketo Login
	String Dispositivo = "1"; //Web
	String UUID = "WEB"; //UUID para la web
	Login = new logonMain((String)session.getAttribute( "SessionLanguaje"),Dispositivo,UUID); //le indico idioma, dipositivo del que me conecto, y UUID que aqui no aplica.

	
	//control de la session
	segKey = Login.controlSessionSystem(segKey);
	

	session.setAttribute( "SessionLoginKeySerial", segKey); //asignamos el valor
}
catch(Exception e){
	
	
}
finally
{
	Login =null;	
}



//miramos la key que existe
String segLogin = (String)session.getAttribute( "SessionLoginKeySerial");


if (segLogin.contains("ERROR") || segLogin.equals(""))
{
	out.print("false{Error de sessión");
	return;
}



%>