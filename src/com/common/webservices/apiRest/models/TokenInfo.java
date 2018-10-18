package com.common.webservices.apiRest.models;


import org.joda.time.DateTime;

import com.common.globalSystems.login.logonCredencialProcess;

public class TokenInfo {
	
	
	    private String userId;  //user ID
	    private String internalToken; //internal token (the same used in SOAP) and all system
	    private DateTime issued;
	    private DateTime expires;
	    private String TokenUserReturn; //token to Return to the user.
	    private logonCredencialProcess userConected; //user connected Data
	    private String idEmployee;
	    private String idOrganization;
	    private String FaseAlta;
	    private String roles;
	    
	    private int DeviceType;
	    private int SSOOType;
	    
	    
	    
	    public logonCredencialProcess getUserConected() {
			return userConected;
		}
		public void setUserConected(logonCredencialProcess userConected) {
			this.userConected = userConected;
		}
		public String getTokenUserReturn() {
			return TokenUserReturn;
		}
		public void setTokenUserReturn(String tokenUserReturn) {
			TokenUserReturn = tokenUserReturn;
		}
		public String getUserId() {
	        return userId;
	    }
	    public void setUserId(String userId) {
	        this.userId = userId;
	    }
	    public DateTime getIssued() {
	        return issued;
	    }
	    public void setIssued(DateTime issued) {
	        this.issued = issued;
	    }
	    public DateTime getExpires() {
	        return expires;
	    }
	    public void setExpires(DateTime expires) {
	        this.expires = expires;
	    }
		public String getInternalToken() {
			return internalToken;
		}
		public void setInternalToken(String internalToken) {
			this.internalToken = internalToken;
		}
		public String getIdEmployee() {
			return idEmployee;
		}
		public void setIdEmployee(String idEmployee) {
			this.idEmployee = idEmployee;
		}
		public String getIdOrganization() {
			return idOrganization;
		}
		public void setIdOrganization(String idOrganization) {
			this.idOrganization = idOrganization;
		}
		public String getFaseAlta() {
			return FaseAlta;
		}
		public void setFaseAlta(String faseAlta) {
			FaseAlta = faseAlta;
		}
		public String getRoles() {
			return roles;
		}
		public void setRoles(String roles) {
			this.roles = roles;
		}
		public int getDeviceType() {
			return DeviceType;
		}
		public void setDeviceType(int deviceType) {
			DeviceType = deviceType;
		}
		public int getSSOOType() {
			return SSOOType;
		}
		public void setSSOOType(int sSOOType) {
			SSOOType = sSOOType;
		}
}
