<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@include file="../globales/filtersTablejquery.jsp" %>
<%@ page import="com.common.hibernate.classes.hb_statistics" %>
<%@ page import="com.common.hibernate.classes.hb_tools" %>
<%@page import="com.common.config.ParamsApp"%>

<%@include file="../login/seguridad_data.jsp" %>

<%

hb_statistics data1;
JSONArray lista;
List<?> dataAux;
hb_tools tools;

try{
	
	//Buscamos los parametros
	

	String users = request.getParameter("users")==null?"":request.getParameter("users");
	String systems = request.getParameter("systems")==null?"":request.getParameter("systems");
	String process = request.getParameter("process")==null?"":request.getParameter("process");
 	String info = request.getParameter("info")==null?"":request.getParameter("info");

 	
	//componemos el filtro
	
	if (!users.equals(""))
	{
		if (!where.equals("")){where+=" AND ";}
		where += "id_user IN('"+users.replace(",", "','")+"')"; 	
	}

	if (!systems.equals(""))
	{
		if (!where.equals("")){where+=" AND ";}
		where += "id_system IN('"+systems.replace(",", "','")+"')"; 	
	}	

	if (!process.equals(""))
	{
		if (!where.equals("")){where+=" AND ";}
		where += "id_process IN('"+process.replace(",", "','")+"')"; 	
	}	

	if (!info.equals(""))
	{
		if (!where.equals("")){where+=" AND ";}
		where += "text  LIKE '%"+info.trim() + "%'"; //Contenga 	
	}	
	

	
	
		//Instanciamos la clase de roles
		data1 = new hb_statistics();
		tools = new hb_tools();
		
		//creamos un array de Json
		lista = new JSONArray();
		
		//Ejecutamos la consulta de roles
		dataAux = data1.getLista(where); //aplicamos el filtro
		

		
		//recorremos los datos
		int MaxRegs = 200; //maximo registros a enviar
		int NumCount = dataAux.size()>MaxRegs?MaxRegs:dataAux.size();
		
				
		
		for (int i = 0; i<NumCount ;i++)
		{
			 VinStatisticsView  Arecord = (VinStatisticsView)dataAux.get(i); //capturamos la entidad Usamos vista
			 VinStatisticsViewId record = Arecord.getId();
			 
			 //creamos objeto Json
			 JSONObject obj = new JSONObject();
		
			 //asignamos datos
			 obj.put("ordinal",record.getOrdinal());
			 obj.put("id_user",record.getIdUser());	
			 obj.put("user_name", record.getUserName());
			 obj.put("id_process", record.getIdProcess());
			 obj.put("name_process", record.getNameProcess());
			 obj.put("comment", record.getComment()); //comentario del proceso
			 obj.put("id_system", record.getIdSystem());
			 obj.put("name_system", record.getNameSystem());
			 obj.put("date_exec", record.getDateExec());
			 obj.put("text", record.getText());
			 
			 //añadimos al array de registros de Json
			 lista.put(obj);
		}

		if (dataAux.size() ==0)
		{
			out.print("null");
		}
		else
		{
			out.print(lista.toString()); //imprimirmos el Json
		}
		
		data1.close_session_user(); //cerramos a mano la session


}
catch(Exception e){
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error JSP:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
	out.print("null");
}
finally
{
	lista = null;
	data1=null;
	dataAux=null;
	tools=null;
}


%>