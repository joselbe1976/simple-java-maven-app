<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.pushnotifications.Parse.*" %>
<%@ page import="java.util.*" %>


<%

//Clase de operaciones para notificaciones Push por Canal
	parseOperations parse;

	try{
		
		String canal="";
		String texto="";
		try{
		//recupero los valores y lanzo con Push
			canal = request.getParameter("grupo");
			texto = request.getParameter("texto");
		}
		catch(Exception z)
		{
			out.print("Error al enviar:" + z.getMessage());
			//error salimos
			return;
		}
		
		
		if (canal.equals(""))
		{
			canal = "*"; //Canal Virtual ALL *
		}
		
		if (texto.equals(""))
		{
			out.print("Debe introducir un texto a enviar");
			return;
		}
		
		parse = new parseOperations();
		
		int num = parse.sendPushNotificationChannel(texto,canal,""); //enviamos el canal
		
		if (num == -1)
		{
			out.print("Error al enviar. Revise si el Canal Push existe");
		}
		else
		{
			String usuariosSend  = parse.getUsersSend();
			out.print("Enviado correctamente a " + num + " de " + parse.totalUsuarios + " usuarios. Enviado a : " + usuariosSend);
		}
		
		
	}
	catch(Exception e){
		out.print("Error al enviar:" + e.getMessage());
	}
	finally
	{
		parse = null;
	}
%>