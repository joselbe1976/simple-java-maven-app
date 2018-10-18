package com.common.webservices.apiRest;


import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.common.tools.LDAP.LDAP;
import com.common.tools.mail.sendMailAsync;
import com.common.webservices.apiRest.responses.ResponseBase;
import com.common.webservices.apiRest.responses.ResponsesStatus;
import com.common.webservices.apiRest.ws.WebSocketsClient;





@Path("/testing")
public class RestTesting {
	
	 //Servidor web socket in header
	 @HeaderParam("server")
	 private String wsServer;
	
	
	
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ldap/{user}/{clave}")
	public Response connectLdap(@PathParam("user") String user, @PathParam("clave") String clave) {
		//Creating an LDAPConnection object from our LDAPConnection class.
		LDAP ldap = new LDAP();
		
		// Crearte the response. Si quieres enviar algo mas , debes crear una clase hija de ResponseBase con mas campos a enviar.
		ResponseBase responseOK = new ResponseBase("", ResponsesStatus.RESPONSE_SUCCESS_STRING);
		ResponseBase responseKO = new ResponseBase("", ResponsesStatus.RESPONSE_LOGIN_ERROR_STRING);
		
		if(ldap.login(user, clave)) {
			

			//Returns Client
			return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(responseOK).build();
			
			
		}else {
			//Returns Client
			return Response.status(ResponsesStatus.RESPONSE_ERROR).entity(responseKO).build();
			
			
		}

 
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/mail/{to}/{subject}/{body}")
	public Response mailTest(@PathParam("to") String to, @PathParam("subject") String subject, @PathParam("body") String body) {

		sendMailAsync mail = new sendMailAsync();
		mail.setMailData(to, subject, body);
		mail.run();
		
		// Crearte the response. Si quieres enviar algo mas , debes crear una clase hija de ResponseBase con mas campos a enviar.
		ResponseBase response = new ResponseBase("executed mail send", ResponsesStatus.RESPONSE_SUCCESS_STRING);
		
		//Returns Client
		return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(response).build();
 

 
	}
	
	/*
	 * 
	 * For testing Web socket by Api rest Resource. Loops = max seconds execution (timeout)
	 */
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/ws/{loops}")
	public Response ws(@PathParam("loops") int loops, String body) {


		// mín 1 second
		if (loops == 0) {
			loops = 1;
		}
		
		// if is null o balnck, defaul web socket URL local
		if (wsServer.equals("")) {
			wsServer = "ws://localhost:8080/backendmovilidad/teams";
		}
		
		
		
		int interacctions = 1;
		WebSocketsClient client = null;
		try {
			
			// Conecion al servidor. Creacion cliente
			client = new WebSocketsClient(new URI(wsServer));
			
			// Se envia 
			client.sendMessage(body);
			
			
			// Tiempo de Espera maximo 20 segundos o cuando termine
			while(interacctions <= loops && client.hayResponse == false) {
				Thread.sleep(1000);
				interacctions++;
			}
			
			
			String responseFinal = "";
			
			if (client.hayResponse) {
				responseFinal = client.response; //Server response
				return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(responseFinal).build();
			}
			else {
				// Error
				return Response.status(ResponsesStatus.RESPONSE_ERROR_EXECUTING).entity("{'ERROR':'Error executing'}").build();	
			}

		} 
		catch (URISyntaxException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(ResponsesStatus.RESPONSE_LOGIN_ERROR).entity("{'ERROR':'Excepcion" + e.getMessage() + "'}").build();	
		}
		finally {
			if (client != null) {
				client.forzeCloseConnection();
			}
			client = null;
		}
	}
	
	
	
	
	
}
