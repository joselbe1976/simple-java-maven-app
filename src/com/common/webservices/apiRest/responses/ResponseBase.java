package com.common.webservices.apiRest.responses;



public class ResponseBase {
	public String token;
	public String status;

	
	public ResponseBase(String token, String status) {
		this.token = token;
		this.status = status;
	}
	
}
