<%@include file="../globales/globalAllPages.jsp" %>
<%@include file="../includes/hibernate.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.json.JSONObject,org.json.JSONException,java.util.*" %>
<%@ page import="org.json.JSONArray" %>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%@ page import="com.common.hibernate.classes.hb_users_system" %>
<%@ page import="com.common.hibernate.classes.hb_systems" %>
<%@ page import="com.common.hibernate.classes.hb_tools" %>
<%@page import="com.common.config.ParamsApp"%>


<%


String id_user = request.getParameter("id_user")==null?"":request.getParameter("id_user");

hb_users_system data1;
JSONArray lista;
List<?> dataAux;
hb_tools tools;

hb_systems auxData = new hb_systems();
VinSystems auxData2;
try{
		//Instanciamos la clase de roles
		data1 = new hb_users_system();
		tools = new hb_tools();
		
		//creamos un array de Json
		lista = new JSONArray();
		
		//Ejecutamos la consulta 
		dataAux = data1.getUserSystem(id_user,""); //aplicamos el filtro
		
		
		//recorremos los datos
		for (int i = 0; i< dataAux.size() ;i++)
		{
			
			 // Pasamos el array a object
			 VinUsersSystem  Arecord = (VinUsersSystem)dataAux.get(i); 
			 VinUsersSystemId record = Arecord.getId(); 
		
			 //creamos objeto Json
			 JSONObject obj = new JSONObject();
		
			 auxData2 = auxData.getDataObject(record.getIdSystem());
			 
			 
			 
			 //asignamos datos
			 obj.put("id_user",record.getIdUser());
			 obj.put("id_system",record.getIdSystem());
			 obj.put("name",auxData2.getName()); //nombre del systema
			 //añadimos al array de registros de Json
			 lista.put(obj);
			 
			 auxData2 = null; //libero por cada ejecucion
			 
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
	new ParamsApp().systemDebugExt(ParamsApp.LOG_LEVEL_WEB,"Error usuarios_system_data.jsp:" + e.getStackTrace(),ParamsApp.LOG_TYPE_ERROR);
	out.print("null");
}
finally
{
	lista = null;
	data1=null;
	dataAux=null;
	tools=null;
	auxData2 = null;
	auxData = null;
}


%>