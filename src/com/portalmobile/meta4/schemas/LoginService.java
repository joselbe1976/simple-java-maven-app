/**
 * LoginService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public interface LoginService extends java.rmi.Remote {
    public com.portalmobile.meta4.schemas.M4LoginOutput login(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public int logout() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.M4LoginOutput loginWithRole(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.M4LoginOutput loginWithCertificate(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
}
