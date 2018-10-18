<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@include file="../globales/filtersTablejquery.jsp" %>
<%@ page import="com.common.hibernate.classes.hb_params_process" %>
<%@ page import="com.common.hibernate.classes.hb_tools" %>
<%@page import="com.common.config.ParamsApp"%>
<%@include file="../login/seguridad_data.jsp" %>


<%

String idFilter = request.getParameter("idFilter");

hb_params_process data1;
JSONArray lista;
List<?> dataAux;
hb_tools tools;

try{
		//Instanciamos la clase de roles
		data1 = new hb_params_process();
		tools = new hb_tools();
		
		//creamos un array de Json
		lista = new JSONArray();
		
		//Filtramos por el código
		where += " AND id_process='" +idFilter + "'";  
		
		//Ejecutamos la consulta de roles
		dataAux = data1.getLista(where); //aplicamos el filtro
		
		System.out.print("\n (JSP)numero:"+dataAux.size());
		
		//recorremos los datos
		for (int i = 0; i< dataAux.size();i++)
		{
			 VinParamsProcessView  record = (VinParamsProcessView)dataAux.get(i); //capturamos la entidad Usamos vista 
			 
		
			 
			 //creamos objeto Json
			 JSONObject obj = new JSONObject();
			 
			 //asignamos datos
			 obj.put("id",record.getId().getIdProcess());	
			 obj.put("id_param", record.getId().getIdParam());
			 obj.put("name_param", record.getId().getNameParam());
			 obj.put("value", record.getId().getValue());
			 obj.put("comment", tools.controlNulls(record.getId().getComment()));
			 obj.put("comment_param", tools.controlNulls(record.getId().getCommentParam())); 
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