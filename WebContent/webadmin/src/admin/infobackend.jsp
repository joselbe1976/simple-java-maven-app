<%@include file="../globales/globalAllPages.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.webservices.controller.*" %>
<%@ page import="com.common.tools.Redis.*" %>
<%@ page import="com.common.config.*" %>

<%

out.println("<div>");
out.println("<hr>");
out.println("<font size='6' color='#FBEEE6'>Información del sistema</font><font size='2' color='#979A9A'> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Pulse Inicio en el menú para parar el refresco de la pantalla</font>");
out.println("<hr>");
//linmpieza de las caches
EqControlRuntime sistema;
try{
	
	sistema = new EqControlRuntime();
	
	//Estado del sistema
		String estado = sistema.getStatusMemoryBackend();
		out.println("<font size='3' color='#FFFFFF'>");
		out.println("<table width='100%'>");
		
		out.println("<tr><td width='20%'>Estado del sistema</td><td>");
		if (estado.equals("ALERT")){
			out.println( "<font size='2' color='#F9F504'>"+estado + " </font>");
			out.println("<font size='1' color='#FA6E6E'>&nbsp;&nbsp;&nbsp;&nbsp;El sistema está en modo ALERT, el Dispacher no enviará más conexiones a este servidor hasta pasar a modo normal</font>");
		}
		else
		{
			out.println( "<font size='2'>"+estado + "</font>");
		}
		out.println("</td></tr>");
		out.println("</table>");
	

	
	//memoria total
		long total, usado, porcMemoria;
	    total = sistema.getMemoryTotalBackend();
	    usado = sistema.getMemoryUsedBackend();
	    porcMemoria = usado * 100 / total;

	    
	
		out.println("<hr>");
		out.println("<table width='100%'><tr><td width='40%'><font size='5' color='#979A9A'>Información de memoría del sistema</font> </td><td> <div style='margin-top: 10px;' id='jqxProgressBar1'></div></td></tr></table>");
		out.println("<hr>");
		
		out.println("<font size='3' color='#FFFFFF'>");
		out.println("<table width='100%'>");
		
		out.println("<tr><td width='20%'>Memoria total</td><td>");	
		out.println( "<font size='2'>"+total + " MB </font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Memoria Usada</td><td>");	
		out.println( "<font size='2'>"+usado+ " MB </font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Memoria Libre</td><td>");	
		out.println( "<font size='2'>"+sistema.getMemoryFreeBackend()+ " MB </font>");
		out.println("</td></tr>");
		
		out.println("</table>");

	
		
	
		//Estado CPU y otros datos
		out.println("<hr>");
		out.println("<table width='100%'><tr><td width='40%'><font size='5' color='#979A9A'>Información CPU y otros datos</font> </td><td> <div style='margin-top: 10px;' id='jqxProgressBar2'></div></td></tr></table>");
		
		out.println("<hr>");
		
		out.println("<font size='3' color='#FFFFFF'>");
		out.println("<table width='100%'>");
		
		double porcCPU = sistema.getLoadCPU();
		out.println("<tr><td width='20%'>Uso de CPU</td><td>");	
		out.println( "<font size='2'>"+porcCPU + " % </font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Usuarios activos</td><td>");	
		out.println( "<font size='2'>"+sistema.getNumActiveUsers() +"</font>");
		out.println("</td></tr>");
		
		
		out.println("</table>");
		
		
		//PARAMETROS DEL sistema
		out.println("<hr>");
		out.println("<font size='5' color='#979A9A'>Configuración del Sistema</font>");
		out.println("<hr>");
		
		//Límite
		out.println("<font size='3' color='#FFFFFF'>");
		out.println("<table width='100%' >");
		
		out.println("<tr><td width='20%'>Memoria limite configurada</td><td>");	
		out.println( "<font size='2'>"+sistema.getControllerAlertMemory() + " MB Memoria Usada </font><font size='2' color='#979A9A'> LLegado al límite se pasa a modo Alert</font>");
		out.println("</td></tr>");
		
		ParamsApp par = new ParamsApp();
		
		

		
		out.println("<tr><td>JobScheduler Activate</td><td>");
		out.println( "<font size='2'>" + par.JOBSCHEDULER_ACTIVATE +"</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>JobScheduler Frecuency</td><td>");
		out.println( "<font size='2'>" + par.JOBSCHEDULER_FRECUENCY/1000  +" seconds</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Service Execution: Max Executors</td><td>");
		out.println( "<font size='2'>" + par.SERVICE_EXECUTOR_MAX_EXECUTORS+" Executors Asyn</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Service Execution: Executor Delay Time</td><td>");
		out.println( "<font size='2'>" + par.SERVICE_EXECUTOR_DELAY_TIME +" miliseconds</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Service Execution: Debug mode</td><td>");
		out.println( "<font size='2'>" + par.SERVICE_EXECUTOR_DEBUG +" (1 activate / 0 = Desactivate)</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Service Execution: Logs Path</td><td>");
		out.println( "<font size='2'>" + par.SYSTEM_LOG_FULL_PATH +"</font>");
		out.println("</td></tr>");
		
		
		
		out.println("<tr><td>Directorio Caches</td><td>");
			out.println("<font size='2'>"+ par.SYSTEM_CACHE_DIRECTORY +  "</font>");
		out.println("</td></tr>");
		out.println("<tr><td>Directorio Temporal</td><td>");
		out.println("<font size='2'>"+ par.WEBSERVICE_TEMP_DIRECTORY +  "</font>");
		out.println("</td></tr>");
	
		out.println("<tr><td>Modo Debug Server</td><td>");
		out.println("<font size='2'>"+par.SYSTEM_DEBUG +  "</font> <font size='2' color='#979A9A'> [1 Activado / 0 Desactivado]</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Sistema operativo Desplegado</td><td>");
		out.println( "<font size='2'>"+par.SYSTEM_SSOO +  "</font><font size='2' color='#979A9A'> Valores[MAC, LINUX; WINDOWS]</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Identificador Backend ID </td><td>");
		out.println( "<font size='2'>"+par.SYSTEM_SERVER_ID + "</font>" );
		out.println("</td></tr>");
		
		out.println("<tr><td>ID Producto Funcional</td><td>");
		out.println("<font size='2'>"+par.SYSTEM_PRODUCT_VERSION +"</font>");
		out.println("</td></tr>");
		
		
		out.println("<tr><td>Timeout del Token ID</td><td>");
		out.println("<font size='2'>"+par.SYSTEM_LOGIN_TIME_TOKEN_MINUTES +  " minutos </font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Número intentos bloqueos</td><td>");
		out.println( "<font size='2'>"+par.SYSTEM_LOGIN_BLOQ_INTENTOS +  " </font><font size='2' color='#979A9A'>Solo para sistema LOCAL</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Autologin</td><td>");
		out.println( "<font size='2'>"+par.SYSTEM_LOGIN_AUTOLOGIN +  " </font><font size='2' color='#979A9A'>Autologin sistemas en caso de Timeout.</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>URL servidor web Peoplenet</td><td>");
		out.println("<font size='2'>"+par.META4_WEB_SERVER +  "</font> <font size='2' color='#979A9A'> Solo para productos Peoplenet. Redirecciona web services</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Generar usuario auto.</td><td>");
		out.println( "<font size='2'>"+par.SYSTEM_CREATE_LOCAL_USER_AUTO +  " </font><font size='2' color='#979A9A'>[1 Activado / 0 Desactivado] Genera de forma automatica el usuario local al logar sistema externo</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Usar usuarios externos</td><td>");
		out.println("<font size='2'>"+par.SYSTEM_LOGIN_USERS_EXTERNAL +  " </font><font size='2' color='#979A9A'>[1 Activado / 0 Desactivado]</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>URL Servicio Pushy</td><td>");
		out.println( "<font size='2'>" +par.SYSTEM_PUSHY_URL+"</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>URL App Store  Android y Apple</td><td>");
		out.println( "<font size='2'>" +par.SYSTEM_APP_STORE+"</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>URL Store Android (instalacion directa)</td><td>");
		out.println( "<font size='2'>" +par.SYSTEM_APP_STORE_ANDROID +"</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>URL Store Apple (instalacion directa)</td><td>");
		out.println( "<font size='2'>" +par.SYSTEM_APP_STORE_APPLE +"</font>");
		out.println("</td></tr>");
		
		// Redis
		out.println("<tr><td>Servidor Cache activo (Redis)</td><td>");
		out.println( "<font size='2'>" + (par.SYSTEM_REDIS == 1 ? "Activado" : "Desactivado") +"</font>");
		out.println("</td></tr>");
		
		out.println("<tr><td>Host Redis Server</td><td>");
		out.println( "<font size='2'>" + par.SYSTEM_REDIS_HOST  +"</font>");
		out.println("</td></tr>");		
		
		out.println("<tr><td>Port Redis Server</td><td>");
		out.println( "<font size='2'>" + par.SYSTEM_REDIS_PORT +"</font>");
		out.println("</td></tr>");	
		
		out.println("<tr><td>Expire Cache (seconds)</td><td>");
		out.println( "<font size='2'>" + par.SYSTEM_REDIS_KEY_EXPIRE_SECONDS +"</font>");
		out.println("</td></tr>");
		
		RedisInterface redis = new RedisInterface();
		out.println("<tr><td>Num Objects Cache Server</td><td>");
		out.println( "<font size='2'>" + redis.DBSize() +"</font>");
		out.println("</td></tr>");
				

		out.println("<tr><td>Producto META4</td><td>");
		out.println( "<font size='2'>" + par.META4_PRODUCT+"</font>");
		out.println("</td></tr>");
		out.println("<tr><td>Sistema Login</td><td>");
		out.println( "<font size='2'>" + par.SYSTEM_LOGIN_DEFAULT +"</font>");
		out.println("</td></tr>");
		

		
		out.println("</table></font><br>");
		out.println("</div>");
		
		//PRUEBAS
		
	//	out.println("<div style='margin-top: 10px; overflow: hidden;' id='jqxProgressBar'></div>");
				
		
		
		%>
		
		
		
		<script type="text/javascript">
		$(document).ready(function () {

			var porcUsadomem = <%=porcMemoria%>
			var porcCPUjs = <%=porcCPU%>

			//progress de la memoria
			$("#jqxProgressBar1").jqxProgressBar({
                width: 100, height: 20, value: porcUsadomem, theme: JsUIStyleCss, 
                showText: true});
            
			//progress de CPU
			$("#jqxProgressBar2").jqxProgressBar({
                width: 100, height: 20, value: porcCPUjs, theme: JsUIStyleCss, 
                showText: true});
			

		 });
    </script>
		
		
		<% 
		
		
}
catch(Exception e){

}
finally
{
	
	
	//recarga
	//menuclick('../admin/infobackend.jsp','Información sistema');
	%>
	<script>
	setTimeout(function(){
		menuclick('../admin/infobackend.jsp','Información sistema');
		}, 5000);
	
    </script>
	
	<% 
	
	
}






%>