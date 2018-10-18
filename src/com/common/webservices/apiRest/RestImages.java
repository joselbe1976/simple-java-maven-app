package com.common.webservices.apiRest;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.common.hibernate.classes.hb_statistics;
import com.common.meta4.meta4ImagesCache;
import com.common.server.tools.sendAsynTaskHelper;
import com.common.webservices.apiRest.auxiliar.AuthHelper;
import com.common.webservices.apiRest.auxiliar.RestAuth;
import com.common.webservices.apiRest.models.TokenInfo;
import com.common.webservices.apiRest.responses.ResponseBase;
import com.common.webservices.apiRest.responses.ResponsesStatus;

@Path("/cache")
public class RestImages  extends RestAuth {

	// Token in Header of All calls
	 @HeaderParam("token")
	 private String token;
	 
	 	@GET
		@Produces(MediaType.APPLICATION_JSON)
		@Path("/{param}")
		public Response getfileg(@PathParam("param") String param) {
			
			// Token Control. Only Verify the token
	 		
	 		TokenInfo aux = AuthHelper.verifyToken(token);
	 		
	 		if (aux == null) {
				return Response.status(ResponsesStatus.RESPONSE_LOGIN_ERROR).entity(new ResponseBase("", ResponsesStatus.RESPONSE_LOGIN_ERROR_STRING)).build();
			}
	 		
	 		// async insert
	 		new sendAsynTaskHelper().AsynInsertStadisticsServer(aux.getUserId(), "rest-download-cache", "param:"+param);
	 		

			// get the file From Redis Server
			meta4ImagesCache img = new meta4ImagesCache();
			String file =  img.getImageBase64(param);
			String ext = img.extesion;
			
			// Create JSON Object
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("status",ResponsesStatus.RESPONSE_SUCCESS_STRING); 
			jsonObject.put("token",token); 
			jsonObject.put("file",file); 
			jsonObject.put("ext",ext); 
			
			//Returns Client data
			return Response.status(ResponsesStatus.RESPONSE_SUCCESS).entity(jsonObject.toString()).build();
	 
		}
}
