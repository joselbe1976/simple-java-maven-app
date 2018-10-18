/**
 * LoginServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

import com.common.config.ParamsApp;

public class LoginServiceServiceLocator extends org.apache.axis.client.Service implements com.portalmobile.meta4.schemas.LoginServiceService {

    public LoginServiceServiceLocator() {
    }


    public LoginServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LoginServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Login
   // private java.lang.String Login_address = "http://192.168.1.34:8100/services/Login";
    
    private java.lang.String Login_address = ParamsApp.META4_WEB_SERVER +"/Login";
    

    public java.lang.String getLoginAddress() {
        return Login_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LoginWSDDServiceName = "Login";

    public java.lang.String getLoginWSDDServiceName() {
        return LoginWSDDServiceName;
    }

    public void setLoginWSDDServiceName(java.lang.String name) {
        LoginWSDDServiceName = name;
    }

    public com.portalmobile.meta4.schemas.LoginService getLogin() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Login_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLogin(endpoint);
    }

    public com.portalmobile.meta4.schemas.LoginService getLogin(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.portalmobile.meta4.schemas.LoginSoapBindingStub _stub = new com.portalmobile.meta4.schemas.LoginSoapBindingStub(portAddress, this);
            _stub.setPortName(getLoginWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLoginEndpointAddress(java.lang.String address) {
        Login_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.portalmobile.meta4.schemas.LoginService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.portalmobile.meta4.schemas.LoginSoapBindingStub _stub = new com.portalmobile.meta4.schemas.LoginSoapBindingStub(new java.net.URL(Login_address), this);
                _stub.setPortName(getLoginWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Login".equals(inputPortName)) {
            return getLogin();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://schemas.meta4.com/", "LoginServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://schemas.meta4.com/", "Login"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Login".equals(portName)) {
            setLoginEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
