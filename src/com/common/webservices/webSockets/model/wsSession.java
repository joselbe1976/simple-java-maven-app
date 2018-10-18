package com.common.webservices.webSockets.model;

import javax.websocket.Session;

public class wsSession {
	
	private Session _sesion;  //Web Sockets Session
	private String _userApp;  //id app user
	private String _idOrganization; //organization
	private String _idEmployee; // id Employee
	private String _dtStart;   //start hire employee
	
	private int _DeviceType;
	private int _SSOOType;
	
	
	// --- Constructors
	
	public wsSession(Session session, String user, String idOrganization, String idEmployee, String dtStart, int DeviceType, int SSOOType) {
		_sesion = session;
		_userApp = user;
		_idOrganization = idOrganization;
		_idEmployee = idEmployee;
		_dtStart = dtStart;
		_DeviceType = DeviceType;
		_SSOOType = SSOOType;
	}
	
	public wsSession(Session session) {
		_sesion = session;
		_userApp = "";
		_idOrganization = "";
		_idEmployee = "";
		_dtStart = "";
	}
	
	// Functional Methods
	
	public boolean isSessionOf(String idOrganization, String idEmployee) {
		if (_idOrganization.equals(idOrganization) &&  _idEmployee.equals(idEmployee)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean isSessionOf(String user) {
		if (_userApp.equals(user)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	// ---- Getters and Setters
	
	public Session get_sesion() {
		return _sesion;
	}
	public void set_sesion(Session _sesion) {
		this._sesion = _sesion;
	}
	public String get_userApp() {
		return _userApp;
	}
	public void set_userApp(String _userApp) {
		this._userApp = _userApp;
	}
	public String get_idOrganization() {
		return _idOrganization;
	}
	public void set_idOrganization(String _idOrganization) {
		this._idOrganization = _idOrganization;
	}
	public String get_idEmployee() {
		return _idEmployee;
	}
	public void set_idEmployee(String _idEmployee) {
		this._idEmployee = _idEmployee;
	}
	public String get_dtStart() {
		return _dtStart;
	}
	public void set_dtStart(String _dtStart) {
		this._dtStart = _dtStart;
	}

	public int getDeviceType() {
		return _DeviceType;
	}

	public void setDeviceType(int deviceType) {
		_DeviceType = deviceType;
	}

	public int getSSOOType() {
		return _SSOOType;
	}

	public void setSSOOType(int sSOOType) {
		_SSOOType = sSOOType;
	}
	
	
}
