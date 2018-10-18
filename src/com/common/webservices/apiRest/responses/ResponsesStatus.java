package com.common.webservices.apiRest.responses;

public interface ResponsesStatus {
	
	public final static int RESPONSE_SUCCESS = 200;
	public final static int RESPONSE_ERROR   = 500;
	public final static int RESPONSE_LOGIN_ERROR = 404;
	public final static int RESPONSE_ERROR_EXECUTING = 401;	
	
	
	public final static String RESPONSE_SUCCESS_STRING = "SUCCESS";
	public final static String RESPONSE_ERROR_STRING   = "ERROR SERVER";
	public final static String RESPONSE_LOGIN_ERROR_STRING = "ERROR LOGIN";
	public final static String RESPONSE_ERROR_EXECUTING_STRING = "ERROR EXECUTING";


}
