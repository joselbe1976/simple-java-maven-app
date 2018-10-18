/**
 * Csp_Mbl_Soap_Tools_TinnovaService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public interface Csp_Mbl_Soap_Tools_TinnovaService extends java.rmi.Remote {
    public com.portalmobile.meta4.schemas.types.Seg_Change_Password_Other_UserOutput SEG_CHANGE_PASSWORD_OTHER_USER(java.lang.String NEW_PASSWORD, java.lang.String USUARIO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_App_Other_UserBlock CSP_APP_OTHER_USER, com.portalmobile.meta4.schemas.types.Csp_App_User_MobileBlock CSP_APP_USER_MOBILE, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaBlock CSP_MBL_SOAP_TOOLS_TINNOVA) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput CSP_ECHO_SESSION() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput SEG_CHANGE_PASSWORD_USER(java.lang.String NEW_PASSWORD) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput CSP_CONTROL_ACCESO() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
}
