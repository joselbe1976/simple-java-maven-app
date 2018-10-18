<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.pushnotifications.Parse.*" %>
<%@ page import="java.util.*" %>


<%

//Clase de operaciones para notificaciones Push
	parseOperations parse;

	try{
		
		String user="";
		String texto="";
		try{
		//recupero los valores y lanzo con Push
			user = request.getParameter("grupo");
			texto = request.getParameter("texto");
		}
		catch(Exception z)
		{
			out.print("Error al enviar:" + z.getMessage());
			z.printStackTrace();
			
			//error salimos
			return;
		}
		
		
		if (user.equals(""))
		{
			out.print("Debe rellenqr el usuario a enviar");
			return;
		}
		
		if (texto.equals(""))
		{
			out.print("Debe introducir un texto a enviar");
			return;
		}
		
		parse = new parseOperations();
		
		int num = parse.sendPushNotificationUser(texto,user,"chat1"); //enviamos al usuario
		
		if (num == -1)
		{
			out.print("Error al enviar. Revise si el empleado tiene asociado en el sistema el identificador válido de dispositivo de su telefono.");
		}
		else
		{
			out.print("Enviado correctamente al usuario");
		}
		
		
	}
	catch(Exception e){
		out.print("Error al enviar:" + e.getMessage());
		e.printStackTrace();
	}
	finally
	{
		parse = null;
	}
%>