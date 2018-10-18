<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.globalSystems.login.*" %>
<%@ page import="com.common.config.ParamsApp" %>


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





String segLogin = (String)session.getAttribute( "SessionLoginKeySerial");

if (segLogin.contains("ERROR") || segLogin.equals(""))
{
	String redirectURL = "http://localhost:8090/backendmovilidad/webadmin";
	%>
		<script type="text/javascript">
				window.location = "../../index.html";
		</script>
	<%
}

String viewIdioma = (String)session.getAttribute( "SessionLanguaje");


if (viewIdioma.equals("3")){ viewIdioma="es";}
if (viewIdioma.equals("2")){ viewIdioma="en";}




%>