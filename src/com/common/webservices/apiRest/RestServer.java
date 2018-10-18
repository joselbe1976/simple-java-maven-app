package com.common.webservices.apiRest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;
import com.common.config.ParamsApp;
import com.common.webservices.apiRest.auxiliar.AuthHelper;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.apiRest.responses.ResponseBase;
import com.common.webservices.apiRest.responses.ResponsesStatus;
import com.portalmobile.meta4.funcional.Meta4EssPeoplenet;
import com.portalmobile.tinnova.tiinova_backend_tools;

@Path("/system")
public class RestServer {

	
	// Token in Header of All calls
	 @HeaderParam("token")
	 private String token;
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{tipoDevice}/{AppVersionUser}/{ProductVersionApp}")
	public Response getversion(@PathParam("tipoDevice") String tipoDevice, @PathParam("AppVersionUser") String AppVersionUser, @PathParam("ProductVersionApp") String ProductVersionApp) {
		
		ParamsApp params = null;
		JSONObject jsonObject = null;
		
		
		try{
		
			params = new ParamsApp();
		
			//Verify if user App is Updated
			String AppVersionRelease = "";
			String URLStoreInstall = "";
			String AppVersionOK = "1"; //is OK
			String ProductVersionOK = "0"; 
			
			if (tipoDevice.equals("4") || tipoDevice.equals("10")){
				
				//androids
				AppVersionRelease = ParamsApp.SYSTEM_APP_VERSION_ANDROID;
				
				//Not the same version.
				if (!AppVersionRelease.equals(AppVersionUser)){
					URLStoreInstall = ParamsApp.SYSTEM_APP_STORE_ANDROID;
					AppVersionOK = "0";
				}
			}
			else
			{
				//Iphone e IPad
				AppVersionRelease = ParamsApp.SYSTEM_APP_VERSION_APPLE;
				
				//Is not the same version
				if (!AppVersionRelease.equals(AppVersionUser)){
					URLStoreInstall = ParamsApp.SYSTEM_APP_STORE_APPLE;
					AppVersionOK = "0";
				}
			}
			
			//ProductCVersion Control
			if (ParamsApp.SYSTEM_PRODUCT_VERSION.trim().equals(ProductVersionApp.trim()))
			{
				ProductVersionOK = "1";
			}
			

			// Create JSON Object
			jsonObject = new JSONObject();
			jsonObject.put("status",ResponsesStatus.RESPONSE_SUCCESS_STRING); 
			jsonObject.put("AppVersionOK",AppVersionOK); 
			jsonObject.put("URLStoreInstall",URLStoreInstall); 
			jsonObject.put("ProductVersionOK",ProductVersionOK); 
	
			//Returns Client data
			return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(jsonObject.toString()).build();

		} catch (Exception e) {
			//Returns Client data
			return Response.status(ResponsesStatus.RESPONSE_ERROR).entity("").build();
		}
		finally {
			params = null;
			jsonObject = null;
		}
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/remember/{mail}/{apell1}/{numdoc}")
	public Response rememberPassword(@PathParam("mail") String mail, @PathParam("apell1") String apell1, @PathParam("numdoc") String numdoc) {
		
		Meta4EssPeoplenet m4o;
		tiinova_backend_tools m4oj;
		
		try{
			
			if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
			{
				m4o = new Meta4EssPeoplenet();
				Double dev = m4o.chgPasswordForgetAndSendByEmail( mail, numdoc, apell1);

				if (dev == 0) {
					return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity("").build();
				}
				else {
					return Response.status(ResponsesStatus.RESPONSE_ERROR_EXECUTING).entity("").build();
				}
				
			}
			else
			{
				// Tinnova. Here if not exist User, create and data regenerate
				m4oj = new tiinova_backend_tools();
				Double dev = m4oj.regenerateUserPasswordAndData(mail, numdoc, apell1);
				if (dev == 0) {
					return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity("").build();
				}
				else {
					return Response.status(ResponsesStatus.RESPONSE_ERROR_EXECUTING).entity("").build();
				}
			}
			
		}
		catch(Exception e){
			return Response.status(ResponsesStatus.RESPONSE_ERROR).entity("").build();
		}
		finally{
			m4o = null; 
			m4oj = null;
		}
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/chgpassword/{password}")
	public Response changepassword(@PathParam("password") String password) {
		
		// Token Control. Only Verify the token
		TokenInfo info = AuthHelper.verifyTokenAndInternalControl(token, "rest-changepassword");
 		if (info == null) {
			return Response.status(ResponsesStatus.RESPONSE_LOGIN_ERROR).entity(new ResponseBase("", ResponsesStatus.RESPONSE_LOGIN_ERROR_STRING)).build();
		}

 		
 		Meta4EssPeoplenet m4o;
		tiinova_backend_tools m4oj;
		JSONObject jsonObject;
		
		try{
			
			if (ParamsApp.META4_PRODUCT.equals("PEOPLENET"))
			{
				m4o = new Meta4EssPeoplenet();
				m4o.chgPasswordUserApp(info.getUserConected(), password);
			}
			else {
				//Tinnova
				m4oj = new tiinova_backend_tools();
				m4oj.chgPasswordUserApp(info.getUserConected(), password);
			}

			// Generate the JSOn Response
			jsonObject = new JSONObject();
			jsonObject.put("status",ResponsesStatus.RESPONSE_SUCCESS_STRING); 
			jsonObject.put("token", info.getTokenUserReturn()); 
			
			return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(jsonObject.toString()).build();
			
		} catch (Exception e) {
			return Response.status(ResponsesStatus.RESPONSE_ERROR).entity("").build();
		}
		finally
		{
			m4o = null;
			m4oj = null;
		}
 	}
}
