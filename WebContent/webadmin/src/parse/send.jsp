<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../login/seguridad_view.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="java.util.*" %>

<div id="FormPush">
 <div id="FormPush2">
<h1>Envio notificaciones Push</h1>

<form action="../parse/sendpushuser.jsp" name="enviar" id="enviar" method="POST">
<table width="100%">
<hr>
<h3>Envio por usuario</h3>
<hr>
<tr>
	<td width="30%">Usuario</td>
	<td width="70%"><input  width="100%" type="text" id="grupo" name="grupo"></td>
</tr>

<tr>
	<td width="30%">Texto enviar</td>
	<td width="70%"><input  width="100%" type="text" id="texto" name="texto"></td>
</tr>

<tr>
	
	<td width="100%" colspan="2"><input type="submit" value="Enviar" id="enviarusuario"></td>
</tr>
<tr>
	<td width="30%"></td>
	<td width="70%"><span style="color: #ed1b24" id="result1" name="result1"></span></td>
</tr>
</table>
</form>

<form action="" name="enviar2" id="enviar2" method="POST">
<table width="100%">
<hr>
<h3>Envio por Canal Push</h3>
<hr>
<tr>
	<td width="30%">Canal Push</td>
	<td width="70%"><input  width="100%" type="text" id="grupo" name="grupo"></td>
</tr>

<tr>
	<td width="30%">Texto enviar</td>
	<td width="70%"><input  width="100%" type="text" id="texto" name="texto"></td>
</tr>

<tr>
	
	<td width="100%" colspan="2"><input type="submit" value="Enviar" id="enviarcanal"></td>
</tr>
<tr>
	<td width="30%"></td>
	<td width="70%"><span style="color: #ed1b24" id="result2" name="result2"></span></td>
</tr>

</table>
</form>
</div>


<script type="text/javascript">

//ENVIO POR USUARIO
$(document).ready(function () {
	$("#enviarusuario").click(function(){
		$("#result1").text("Enviando ...");
		event.preventDefault();
	    $.ajax({
	         type: 'POST',
	         url: "../parse/sendpushuser.jsp",
	         data: $('#enviar').serialize(), 
	         success: function(response) {
	            $("#result1").text($.trim(response));
	            
	         },
	        error: function() {
	           $("#result1").text("Error al enviar");
	        }
	     });
	});

	//ENVIO POR CANAL
		$("#enviarcanal").click(function(){
			$("#result2").text("Enviando a todo el canal ...");
			event.preventDefault();
		    $.ajax({
		         type: 'POST',
		         url: "../parse/sendpushcanal.jsp",
		         data: $('#enviar2').serialize(), 
		         success: function(response) {
		            $("#result2").text($.trim(response));
		         },
		        error: function() {
		        	$("#result2").text("Error al enviar");
		        }
		     });
		});
		
});
</script>

</div>