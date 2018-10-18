<%@page import="com.common.config.ParamsApp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.common.globalSystems.login.*" %>

<%

	//logout del sistema
	logonMain Login;
	try{
		Login = new logonMain();
		Login.logout((String)session.getAttribute("SessionUser"));  //logout del usuario.
	}
	catch(Exception e)
	{
		new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error en hacer Logout",ParamsApp.LOG_TYPE_INFO);
		new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"detail:" + e.getStackTrace(),ParamsApp.LOG_TYPE_INFO);
	}
	finally{
		Login = null;
		request.getSession().invalidate(); //Eliminamos la session del server web
		response.sendRedirect("../../index.html"); //redireccionamos
	}

%>