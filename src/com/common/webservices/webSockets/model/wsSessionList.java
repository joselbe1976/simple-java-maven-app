package com.common.webservices.webSockets.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.Session;

import com.common.webservices.webSockets.webSocketsTeams;

public class wsSessionList {

	private static final Set<wsSession> sessions =  Collections.synchronizedSet(new HashSet<wsSession>());
	
	
	public void add(Session sesion) {
		sessions.add(new wsSession(sesion));
	}
	
	public void remove(Session sesion) {
		wsSession aux = this.getWsSession(sesion.toString());
		
		if (aux != null) {
			 synchronized(sessions) {
				 sessions.remove(aux); //remove
			 }
			 
		}
	}
	
	
	public Session getSession(String sessionID) {
		 synchronized(sessions) {
		      for (wsSession s : sessions) {
		    	
		    	  Session aux = s.get_sesion();
		    	  
		        if (aux.toString().equals(sessionID) && aux.isOpen()) {
		        	return aux; // return the session
		        }
		      }
		 }
		 
		 return null; //not found
	}
	
	public wsSession getWsSession(String sessionID) {
		 synchronized(sessions) {
		      for (wsSession s : sessions) {
		    
		        if (s.get_sesion().toString().equals(sessionID)) {
		        	return s; // return the wssession
		        }
		      }
		 }
		 
		 return null; //not found
	}
	
	
	// validate the session, if is not open, close
	public void validateSessions(webSocketsTeams ref) {
		 synchronized(sessions) {
		      for (wsSession s : sessions) {
		    	  
		    	 // if is not Open, close (No deberia ejecutar esto nunca.)
		        if (!s.get_sesion().isOpen()) {
		        	ref.close(s.get_sesion());
		        }
		      }
		 }
	 }
	
	
	
	// Update data of session
	public void setDataSession(String sessionID, String idOrganization, String idEmployee, String dtStart, String user, int DeviceType, int SSOOType) {
		
		wsSession session = this.getWsSession(sessionID);
		
		synchronized(session) {
			if (session != null) {
				session.set_idOrganization(idOrganization);
				session.set_idEmployee(idEmployee);
				session.set_dtStart(dtStart);
				session.set_userApp(user);
				session.setDeviceType(DeviceType);
				session.setSSOOType(SSOOType);
			}
		}		
	}
	
	
	public wsSession getEmployeeSessionActive(String idEmployee, String idOrganization) {
		 
		
		synchronized(sessions) {
		
			    wsSession dev = null;
				for (wsSession s : sessions) {
		    		  if (s.get_idEmployee().equals(idEmployee) && s.get_idOrganization().equals(idOrganization) && s.get_sesion().isOpen()) {
			    		  dev = s; //Employee and Orghanizacion Found!!
			    	  }
		    	}
				
				return dev;
		 }
	}
	
	
	public void printConsoleDataSessions() {
		
		System.out.println("\n\n ---------------[ Log websockets session in Server ] -----------------\n");
		
		synchronized(sessions) {
		      for (wsSession s : sessions) {
		    	  
		    	  System.out.println("\nSession id: " + s.get_sesion().toString() );
		    	  System.out.println("     - user: " + s.get_userApp());
		    	  System.out.println("     - sociedad    : " + s.get_idOrganization());
		    	  System.out.println("     - id Empleado : " + s.get_idEmployee());
		    	  System.out.println("     - Fecha alta  : " + s.get_dtStart());
		    	  System.out.println("     - Device Type : " + s.getDeviceType());
		    	  System.out.println("     - SSOO Type   : " + s.getSSOOType());
		    	  System.out.println("");
		    	
		      }
		 }
		
		System.out.println("\n\n -----------------------[ Logs Ends ]----------------------------------\n\n");
	}
	
}
