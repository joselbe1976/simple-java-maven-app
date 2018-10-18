package com.common.webservices.apiRest;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

import com.common.config.ParamsApp;
import com.common.webservices.apiRest.auxiliar.AuthHelper;
import com.common.webservices.apiRest.auxiliar.loginSessionJwt;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.apiRest.models.deviceType;
import com.common.webservices.apiRest.responses.ResponsesStatus;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;




/* Use PostMan
 * 
 * URL for execution Login: http://server:port/backendmovilidad/rest/auth
 * Sending in header:
 * 	- credential : With the serial of login of Apps IOs And Android
 */



@Path("/auth")
public class RestLogin {
	
	// Token in Header of All calls
	 @HeaderParam("credentials")
	 private String credentials;
	
	// Token in Header
	 @HeaderParam("token")
	 private String token;
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{deviceType}/{SSOOType}")
	public Response logon(@PathParam("deviceType") int deviceType, @PathParam("SSOOType") int SSOOType) {
 
		String token = "";
		
		loginSessionJwt login = null;
		JSONObject jsonObject = null;
		try {
			
			 jsonObject = new JSONObject();
		
				// login
				
				login  = new loginSessionJwt();
				String Internalkey = login.JWTcontrolSession("", credentials);
				
				
				if (Internalkey.equals("")) {
					//error Login
					
					jsonObject.put("status","RESPONSE_LOGIN_ERROR"); 
					jsonObject.put("description","Error Login"); 
					jsonObject.put("token",""); 
					return Response.status(ResponsesStatus.RESPONSE_LOGIN_ERROR).entity(jsonObject.toString()).build();
				}
				
			//	String user = login.userConected.getData(login.userConected.getPosDefaultSystem()).user;
				

				if (Internalkey.length() > 0) {
					
					
					//Generate JSON Token
					
					token = AuthHelper.createJsonWebToken(login.userConected, Internalkey ,ParamsApp.GLOBAL_API_REST_TOKEN_TIME, deviceType, SSOOType);
					
					// Create JSON Response
					jsonObject.put("status","RESPONSE_SUCCESS"); 
					jsonObject.put("description","Login OK"); 
					jsonObject.put("token",token); 
					String result =  jsonObject.toString();
					
					return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(result).build();
				}
				else {
					//error Login
					jsonObject.put("status","RESPONSE_LOGIN_ERROR"); 
					jsonObject.put("description","Error Login"); 
					jsonObject.put("token",""); 
					return Response.status(ResponsesStatus.RESPONSE_LOGIN_ERROR).entity(jsonObject.toString()).build();
				}
		}
		catch (Exception e) {
					jsonObject = new JSONObject();
					jsonObject.put("status","RESPONSE_ERROR"); 
					jsonObject.put("description",e.getMessage()); 
					jsonObject.put("token",""); 
					return Response.status(ResponsesStatus.RESPONSE_ERROR).entity(jsonObject.toString()).build();
		}
		finally {
			login = null;	
			jsonObject = null;
		}
 
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/verify")
	public Response verifyToken() {
		
		JSONObject jsonObject = new JSONObject();
		
		// Token Control
		
		
		Boolean active = AuthHelper.isTokenActive(token); //only verify token timeout
		if (active) {
			
			//Validate OK
			jsonObject.put("status","RESPONSE_SUCCESS"); 
			jsonObject.put("token",token); 
			return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(jsonObject.toString()).build();
		}
		else {
			//Validate ERROR
			jsonObject.put("status","RESPONSE_LOGIN_ERROR"); 
			jsonObject.put("token",""); 
			return Response.status(ResponsesStatus.RESPONSE_LOGIN_ERROR).entity(jsonObject.toString()).build();
		}
		
		/*
		 
		TokenInfo aux = AuthHelper.verifyTokenAndInternalControl(token,"rest-verify-token");
		 
		if (aux != null) {
			String token = aux.getTokenUserReturn();
			
			//Validate OK
			jsonObject.put("status","RESPONSE_SUCCESS"); 
			jsonObject.put("token",token); 
			return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(jsonObject.toString()).build();
		}
		else {
			//Validate ERROR
			jsonObject.put("status","RESPONSE_LOGIN_ERROR"); 
			jsonObject.put("token",""); 
			return Response.status(ResponsesStatus.RESPONSE_LOGIN_ERROR).entity(jsonObject.toString()).build();
		}
		*/
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/infoToken")
	public Response test11() {
		
		JSONObject jsonObject = new JSONObject();
		
		// Token Control
		
		
		Boolean active = AuthHelper.isTokenActive(token); //only verify token timeout
		
		
		
		if (active) {
			
			// verifico el Role
			TokenInfo aux = AuthHelper.verifyToken(token);
			
	
			jsonObject.put("SSOO", deviceType.getName(aux.getSSOOType()));
			jsonObject.put("Device", deviceType.getName(aux.getDeviceType()));
			jsonObject.put("App-user", aux.getUserId());
			jsonObject.put("idHR", aux.getIdEmployee());
			jsonObject.put("Organization", aux.getIdOrganization());
			jsonObject.put("Hire", aux.getFaseAlta());
			jsonObject.put("Meta4 Token", aux.getInternalToken());
			jsonObject.put("Roles", aux.getRoles());
			
			//Validate OK
			jsonObject.put("status","RESPONSE_SUCCESS"); 
			jsonObject.put("token",token); 
			return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(jsonObject.toString()).build();
		}
		else {
			//Validate ERROR
			jsonObject.put("status","Token NO activo!!!!"); 
			jsonObject.put("token",""); 
			return Response.status(ResponsesStatus.RESPONSE_LOGIN_ERROR).entity(jsonObject.toString()).build();
		}
		
	}
	
}
