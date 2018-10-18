<%@include file="../globales/globalAllPages.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@include file="../login/seguridad_data.jsp" %>
<%@ page import="com.common.tools.cache.documentsCache" %>


<%

out.println("<div>");
out.println("<hr><h1>");
out.println("&nbsp;&nbsp;Limpieza Cachés del sistema Mobile");
out.println("<hr></h1>");
//linmpieza de las caches
documentsCache cache;
try{
	cache = new documentsCache();
	cache.cleanAllCaches();
	
	//todo OK
	out.println("</br><h2>");
	out.println("Las cachés se han limpiado correctamente");
	out.println("</h2>");
	
	//resumen eliminacion
	out.println("<h3>");
	out.println("Se han eliminado " + cache.CleanCachesNumFilesDeleted +  " archivos de un total de " + cache.CleanCachesNumTotFiles + " archivos de caché");
	out.println("</h3>");
	
	//Detalle eliminacion
	out.println("<hr><h3>");
	out.println("Detalle limpieza cachés");
	out.println("<hr></h3>");
	out.println(cache.CleanCachesLog);
		
		
}
catch(Exception e){
	System.out.print("\n\n ERROR GRAVE:"+e.getMessage()+"\n\n");
	out.println("Error al limpiar: " +e.getMessage() );
}
finally
{
	cache = null;	
	
	out.println("</div>");
}


%>