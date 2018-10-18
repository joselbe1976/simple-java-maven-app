<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.common.meta4.*" %>

<%
meta4ImagesCache img;

String idfoto = "";
try{
	
	//rescatamos el parametro
	idfoto = request.getParameter("idFoto");
	
	img = new meta4ImagesCache();
	String file =  img.getImageNOBase64(idfoto);

	out.print(file);
	System.out.println("(foto " + idfoto + ") : " + file);
}
catch(Exception e){
	out.print("");
	System.out.println("(foto " + idfoto + ") : Error");
}
finally{
		img = null;
}

%>