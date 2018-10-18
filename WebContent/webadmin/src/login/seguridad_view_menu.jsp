<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.globalSystems.login.*" %>
<%@ page import="com.common.config.ParamsApp" %>


<%

logonMain Login;


try{

	String segKey = (String)session.getAttribute( "SessionLoginKeySerial");
	
	if (segKey==null || segKey.equals(""))
	{
		%>
			<script type="text/javascript">
					window.location = "../../index.html";
			</script>
		<%
	}
	
	//obtenemos un objketo Login
	String Dispositivo = "1"; //Web
	String UUID = "WEB"; //UUID para la web
	Login = new logonMain((String)session.getAttribute( "SessionLanguaje"),Dispositivo,UUID); //le indico idioma, dipositivo del que me conecto, y UUID que aqui no aplica.

	
	segKey = Login.controlSessionSystem(segKey);

	session.setAttribute( "SessionLoginKeySerial", segKey); //asignamos el valor
}
catch(Exception e){
	%>
	<script type="text/javascript">
			window.location = "../../index.html";
	</script>
<%
}
finally
{
	Login =null;	
}



String viewIdioma = "";

try{

	
	String segLogin = (String)session.getAttribute( "SessionLoginKeySerial");


	
	
	
	if (segLogin.contains("ERROR") || segLogin.equals(""))
	{
		String redirectURL = "http://localhost:8080/backendmovilidad/webadmin";
		%>
			<script type="text/javascript">
					window.location = "../../index.html";
			</script>
		<%
	}
	
	viewIdioma = (String)session.getAttribute( "SessionLanguaje");
	if (viewIdioma.equals("3")){ viewIdioma="es";}
	if (viewIdioma.equals("2")){ viewIdioma="en";}
}
catch(Exception e)
{
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error seguridad_view_menu.jsp",ParamsApp.LOG_TYPE_INFO);
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Detail:" + e.getStackTrace(),ParamsApp.LOG_TYPE_INFO);
}
finally
{

}



// --------------- Stilo CSS a Usar.  -------------

new ParamsApp();
String UIStyleCss = ParamsApp.WEBSITE_ADMIN_STYLE;  



%>