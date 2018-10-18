/**
 * LoginServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public interface LoginServiceService extends javax.xml.rpc.Service {
    public java.lang.String getLoginAddress();

    public com.portalmobile.meta4.schemas.LoginService getLogin() throws javax.xml.rpc.ServiceException;

    public com.portalmobile.meta4.schemas.LoginService getLogin(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
