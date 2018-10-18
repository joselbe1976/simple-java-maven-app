/**
 * Csp_Mbl_Soap_Server_InfoService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public interface Csp_Mbl_Soap_Server_InfoService extends java.rmi.Remote {
    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Server_InfoBlock CSP_MBL_SOAP_SERVER_INFO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_Session_M4_ValueOutput CSP_GET_SESSION_M4_VALUE(java.lang.String ID_PARAM) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
}
