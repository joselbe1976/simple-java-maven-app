package com.common.webservices.apiRest.auxiliar;

import com.common.webservices.apiRest.models.TokenInfo;

public class RestAuth {

	TokenInfo tokenInfo = null;
	
	protected boolean AuthToken(String token,String resource) {
		
		//control session
		tokenInfo = AuthHelper.verifyTokenAndInternalControl(token, resource);
		
		if (tokenInfo != null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
