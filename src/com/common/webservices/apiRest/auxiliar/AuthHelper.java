package com.common.webservices.apiRest.auxiliar;

import java.security.InvalidKeyException;
import java.security.SignatureException;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import net.oauth.jsontoken.JsonToken;
import net.oauth.jsontoken.JsonTokenParser;
import net.oauth.jsontoken.crypto.HmacSHA256Signer;
import net.oauth.jsontoken.crypto.HmacSHA256Verifier;
import net.oauth.jsontoken.crypto.SignatureAlgorithm;
import net.oauth.jsontoken.crypto.Verifier;
import net.oauth.jsontoken.discovery.VerifierProvider;
import net.oauth.jsontoken.discovery.VerifierProviders;

import com.Ostermiller.util.Base64;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import com.common.globalSystems.login.logonCredencialProcess;
import com.common.hibernate.classes.hb_users;
import com.common.hibernate.entidades.VinUsers;
import com.common.hibernate.entidades.VinUsersSystem;
import com.common.webservices.apiRest.models.TokenInfo;
import com.google.common.collect.Lists;
import com.google.gson.JsonObject;

public class AuthHelper {

		private static final String AUDIENCE = "ClientesEquilibrha";
	    private static final String ISSUER = "eqMobileEquilibrhaSoluciones2018";
	    private static final String SIGNING_KEY = "Equilibrha20162018LongAndHardToGuessValueWithSpecialCharacters@^($%*$%";

	   
	    
	    
	    /**
	     * Creates a json web token which is a digitally signed token that contains a payload (e.g. userId to identify 
	     * the user). The signing key is secret. That ensures that the token is authentic and has not been modified.
	     * Using a jwt eliminates the need to store authentication session information in a database.
	     * @param userId
	     * @param durationDays
	     * @return
	     */
	    public static String createJsonWebToken( logonCredencialProcess userConected, String internalToken,  Long durationDays, int DeviceType, int SSOOType)    {
	    	
	    	
	    	
	    	String userId = userConected.getData(userConected.getPosDefaultSystem()).user;
	    	
	    	//Acces to DataBase
	    	VinUsers userHb = new hb_users().getUser(userId);
		    	String idEmployee = userHb.getIdEmpleadoRrhh();
		    	String idOrganization = userHb.getIdOrganization();
		    	String FaseAlta = userHb.getFaseAltaRrhh();
		    	userHb = null;
	    	
	        //Current time and signing algorithm
	        Calendar cal = Calendar.getInstance();
	        HmacSHA256Signer signer;
	        try {
	            signer = new HmacSHA256Signer(ISSUER, null, SIGNING_KEY.getBytes());
	        } catch (InvalidKeyException e) {
	            throw new RuntimeException(e);
	        }

	        //Configure JSON token
	        JsonToken token = new net.oauth.jsontoken.JsonToken(signer);
	        token.setAudience(AUDIENCE);
	        token.setIssuedAt(new org.joda.time.Instant(cal.getTimeInMillis()));
	        token.setExpiration(new org.joda.time.Instant(cal.getTimeInMillis() + (1000L * 60L * 60L * 24L * durationDays)));

	        //Configure request object, which provides information of the item
	        JsonObject request = new JsonObject();
	        request.addProperty("userId", userId);
	        request.addProperty("idEmployee", idEmployee);
	        request.addProperty("idOrganization", idOrganization);
	        request.addProperty("FaseAlta", FaseAlta);
	        request.addProperty("internalToken", internalToken);
	        request.addProperty("roles", getListRolesUser(userId));
	        request.addProperty("deviceType", DeviceType);
	        request.addProperty("ssooType", SSOOType);

	        JsonObject payload = token.getPayloadAsJsonObject();
	        payload.add("info", request);

	        try {
	            return token.serializeAndSign();
	        } catch (SignatureException e) {
	            throw new RuntimeException(e);
	        }
	    }

	    /**
	     * Verifies a json web token's validity and extracts the user id and other information from it. 
	     * @param token
	     * @return
	     * @throws SignatureException
	     * @throws InvalidKeyException
	     */
	    public static TokenInfo verifyToken(String token)  
	    {
	        try {
	            final Verifier hmacVerifier = new HmacSHA256Verifier(SIGNING_KEY.getBytes());

	            VerifierProvider hmacLocator = new VerifierProvider() {

	                @Override
	                public List<Verifier> findVerifier(String id, String key){
	                    return Lists.newArrayList(hmacVerifier);
	                }
	            };
	            VerifierProviders locators = new VerifierProviders();
	            locators.setVerifierProvider(SignatureAlgorithm.HS256, hmacLocator);
	            net.oauth.jsontoken.Checker checker = new net.oauth.jsontoken.Checker(){

	                @Override
	                public void check(JsonObject payload) throws SignatureException {
	                    // don't throw - allow anything
	                }
	            };
	            //Ignore Audience does not mean that the Signature is ignored
	            JsonTokenParser parser = new JsonTokenParser(locators,
	                    checker);
	            JsonToken jt;
	            try {
	                jt = parser.verifyAndDeserialize(token);
	            } catch (SignatureException e) {
	                return null;
	            }
	            JsonObject payload = jt.getPayloadAsJsonObject();
	            TokenInfo t = new TokenInfo();
	            String issuer = payload.getAsJsonPrimitive("iss").getAsString();
	            String userIdString =  payload.getAsJsonObject("info").getAsJsonPrimitive("userId").getAsString();
	            String internalToken =  payload.getAsJsonObject("info").getAsJsonPrimitive("internalToken").getAsString();
	            String idEmployee = payload.getAsJsonObject("info").getAsJsonPrimitive("idEmployee").getAsString();
	            String idOrganization = payload.getAsJsonObject("info").getAsJsonPrimitive("idOrganization").getAsString();
	            String FaseAlta = payload.getAsJsonObject("info").getAsJsonPrimitive("FaseAlta").getAsString();
	            String roles = payload.getAsJsonObject("info").getAsJsonPrimitive("roles").getAsString();
	            int DeviceType = payload.getAsJsonObject("info").getAsJsonPrimitive("deviceType").getAsInt();
	            int SSOOType = payload.getAsJsonObject("info").getAsJsonPrimitive("ssooType").getAsInt();
	            
	            if (issuer.equals(ISSUER) && !StringUtils.isBlank(userIdString))
	            {
	                t.setUserId(userIdString);
	                t.setIdEmployee(idEmployee);
	                t.setFaseAlta(FaseAlta);
	                t.setIdOrganization(idOrganization);
	                t.setInternalToken(internalToken);
	                t.setRoles(roles);
	                t.setIssued(new DateTime(payload.getAsJsonPrimitive("iat").getAsLong()));
	                t.setExpires(new DateTime(payload.getAsJsonPrimitive("exp").getAsLong()));
	                t.setTokenUserReturn(token);
	                t.setDeviceType(DeviceType);
	                t.setSSOOType(SSOOType);
	                
	                return t;
	            }
	            else
	            {
	                return null;
	            }
	        } catch (InvalidKeyException e1) {
	            return null;
	        }
	    }
	    
	    //Used This Method by all Api Rest Resources
	    public static TokenInfo verifyTokenAndInternalControl(String token, String idProcess) {
	    	
	    	TokenInfo aux = verifyToken(token);
	    	loginSessionJwt login = null;
	    	
	    	try {
	    	
		    	if (aux != null) {

		    		// Verify Internal control
		    		login = new loginSessionJwt();
		    		String internalToken =  Base64.encode(login.JWTinternalControl(aux.getInternalToken(), "", idProcess)); 
		    		
		    		// Control Change internal token. If Change the internal Token Shuld change the Token to the client
		    		if (!aux.getInternalToken().equals(internalToken)) {
		    			//generate New Token JWT
		    			String newTokenJWT = createJsonWebToken(login.userConected, internalToken,  10L, aux.getDeviceType(), aux.getSSOOType());
		    			aux.setTokenUserReturn(newTokenJWT);
		    			
		    		}
		    		
		    		//Set values
		    		aux.setInternalToken(internalToken);
		    		aux.setUserConected(login.userConected);
		    		
		    		return aux;
		    		
		    	}
		    	else
		    	{
		    		return null;
		    	}
	    	}
	    	catch(Exception e) {
	    		return null;
	    	}
	    	finally {
	    		login = null;
	    	}
	    	
	    }
	    
	    
	    
	    // To be used in Api Rest Resources
	    public static Boolean validateRoleList(String idUser, String roleTarget, String rolesList) {
	    	Boolean Found = false;
	    	
	    	if (!rolesList.equals("")) {
	    		
	    		// Find in the String of Roles List
	    		
	    		String[] lista = rolesList.split("#");
	    		
	    		for(int i = 0; i < lista.length; i++) {
	    			
	    			if (lista[i].trim().toUpperCase().equals(roleTarget.toUpperCase())) {
	    				Found = true;
	    			}
	    		}
	    		
	    	}
	    	else {
	    		// find to Data Base MySQL
	    	
		    	hb_users hb = new hb_users();
		    	VinUsers user = hb.getUser(idUser);
		    	
		    	Set<VinUsersSystem> list = user.getVinUsersSystems();
		   
		    	for (VinUsersSystem item : list) {
		    		
		    		if (item.getId().toString().toUpperCase().equals(roleTarget.toUpperCase()) ) {
		    			Found = true;
		    		}
		    	}
	    	}
		    	
	    	return Found;
	    }
	    
	    
	   
	    
	    
	    // returns true or False
	    public static boolean isTokenActive(String token)  {
	    	
	    	TokenInfo aux = verifyToken(token);
	    	if (aux == null) {
	    		return false;
	    	}
	    	else {
	    		return true;
	    	}
	    	
	    }
	    
	    
	    public static boolean isTokenActiveAndSecurityRole(String token, String Role)  {
	    	
	    	TokenInfo aux = verifyToken(token);
	    	if (aux == null) {
	    		return false;
	    	}
	    	else {
	    		
	    		// Is valid the Token. Now validate user has specific Role.
	    		return validateRoleList(aux.getUserId(), Role, aux.getRoles());
	    			
	    		
	    	}
	    	
	    }
	    
	    
	    
	    
	    // -- Auxiliary -----
	    
	    
	    // generate list of Roles from a user.
	    private static String getListRolesUser(String idUser) {
	    	
	    	hb_users hb = new hb_users();
	    	VinUsers user = hb.getUser(idUser);
	    	String lista = "";
	    	
	    	Set<VinUsersSystem> list = user.getVinUsersSystems();
	   
	    	for (VinUsersSystem item : list) {
	    		
	    		if (lista.equals("") ) {
	    			lista = item.getId().getIdSystem().toString();
	    		}
	    		else {
	    			lista = lista + "#" + item.getId().getIdSystem().toString();
	    		}
	    	}
	    	return lista;
	    }
	    
	    
	 
	
	    


	}



	
