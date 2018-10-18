/*
 * Equilibrha 2018. Backend V2.0.0
 * 
 * Task Class for be executed by serviceExecutor.
 * 
 */

package com.common.server.queue;

import java.io.Serializable;
import java.util.Date;



public class Task implements Serializable {
	
	private static final long serialVersionUID = -1604766932017737116L;
	
	//Priority Task (will be used by de executor service)
	public static final int LOW_PRIORITY    = 2;
	public static final int NORMAL_PRIORITY = 1;
	public static final int HIGH_PRIORITY   = 0;
	
	
	private String _token ;
	private boolean _tokenJWT;
	private String _className ;
	private String _argumentJson;  //arguments Method in Json format
	private String _id;
	private Date _executionDate; //Date for JobScheduler
	private int _Priority;
	private int dbId; //id of DataBase
	private String WebSocketID;  // id socket Web scoket

	private boolean loginForzed;  // if put true, force validate token + internal Login. Only if need use connected object in Task Asyn.
	private boolean ValidateLogin; // deafult true. If False, not do nothing with the login and JWT validations. Activate for expecial things async not necesary credentials. Example-: send error to client




	// --- Constructors ------
	public Task(String Token, boolean isTokenJWT, String className, String argumentsJson, Date executionDate) {
		this._token = Token;
		this._tokenJWT = isTokenJWT;
		this._className = className;
		this._argumentJson = argumentsJson;
		this._executionDate = executionDate;
		this._Priority = NORMAL_PRIORITY;
		this.dbId = -1;
		loginForzed = false;
		setValidateLogin(true);
	}
	
	public Task(String Token, boolean isTokenJWT, String className, String argumentsJson) {
		this._token = Token;
		this._tokenJWT = isTokenJWT;
		this._className = className;
		this._argumentJson = argumentsJson;
		this._Priority = NORMAL_PRIORITY;
		this.dbId = -1;
		loginForzed = false;
		setValidateLogin(true);
	}
	
	
	
	
	
	// --- Getter /Setters -----
	
	
	
	
	
	public Date getExecutionDate() {
		return _executionDate;
	}
	public void setExecutionDate(Date executionDate) {
		this._executionDate = executionDate;
	}
	//gebnerate de ID
	public String get_id() {
		return   _className  + " - " +  _token;
	}
	public String get_argumentJson() {
		return _argumentJson;
	}
	public void set_argumentJson(String _argumentJson) {
		this._argumentJson = _argumentJson;
	}
	public String get_token() {
		return _token;
	}
	public void set_token(String _token) {
		this._token = _token;
	}
	public String get_className() {
		return _className;
	}
	public void set_className(String _className) {
		this._className = _className;
	}
	public boolean is_tokenJWT() {
		return _tokenJWT;
	}
	public void set_tokenJWT(boolean _tokenJWT) {
		this._tokenJWT = _tokenJWT;
	}

	public int get_Priority() {
		return _Priority;
	}

	public void set_Priority(int _Priority) {
		//not set Invalid Priorities
		if (_Priority < 0 || _Priority > 2) {
			return;
		}
		
		this._Priority = _Priority;
	}
	public int getDbId() {
		return dbId;
	}

	public void setDbId(int dbId) {
		this.dbId = dbId;
	}

	public String getWebSocketID() {
		return WebSocketID;
	}

	public void setWebSocketID(String webSocketID) {
		WebSocketID = webSocketID;
	}
	
	public boolean isLoginForzed() {
		return loginForzed;
	}

	public void setLoginForzed(boolean loginForzed) {
		this.loginForzed = loginForzed;
	}

	public boolean isValidateLogin() {
		return ValidateLogin;
	}

	public void setValidateLogin(boolean validateLogin) {
		ValidateLogin = validateLogin;
	}


}