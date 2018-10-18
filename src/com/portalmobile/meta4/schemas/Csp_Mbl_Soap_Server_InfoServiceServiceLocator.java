/**
 * Csp_Mbl_Soap_Server_InfoServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public class Csp_Mbl_Soap_Server_InfoServiceServiceLocator extends org.apache.axis.client.Service implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Server_InfoServiceService {

    public Csp_Mbl_Soap_Server_InfoServiceServiceLocator() {
    }


    public Csp_Mbl_Soap_Server_InfoServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Csp_Mbl_Soap_Server_InfoServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CSP_MBL_SOAP_SERVER_INFO
    private java.lang.String CSP_MBL_SOAP_SERVER_INFO_address = "http://172.20.2.42:8100/services/CSP_MBL_SOAP_SERVER_INFO";

    public java.lang.String getCSP_MBL_SOAP_SERVER_INFOAddress() {
        return CSP_MBL_SOAP_SERVER_INFO_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CSP_MBL_SOAP_SERVER_INFOWSDDServiceName = "CSP_MBL_SOAP_SERVER_INFO";

    public java.lang.String getCSP_MBL_SOAP_SERVER_INFOWSDDServiceName() {
        return CSP_MBL_SOAP_SERVER_INFOWSDDServiceName;
    }

    public void setCSP_MBL_SOAP_SERVER_INFOWSDDServiceName(java.lang.String name) {
        CSP_MBL_SOAP_SERVER_INFOWSDDServiceName = name;
    }

    public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Server_InfoService getCSP_MBL_SOAP_SERVER_INFO() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CSP_MBL_SOAP_SERVER_INFO_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCSP_MBL_SOAP_SERVER_INFO(endpoint);
    }

    public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Server_InfoService getCSP_MBL_SOAP_SERVER_INFO(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.portalmobile.meta4.schemas.CSP_MBL_SOAP_SERVER_INFOSoapBindingStub _stub = new com.portalmobile.meta4.schemas.CSP_MBL_SOAP_SERVER_INFOSoapBindingStub(portAddress, this);
            _stub.setPortName(getCSP_MBL_SOAP_SERVER_INFOWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCSP_MBL_SOAP_SERVER_INFOEndpointAddress(java.lang.String address) {
        CSP_MBL_SOAP_SERVER_INFO_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Server_InfoService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.portalmobile.meta4.schemas.CSP_MBL_SOAP_SERVER_INFOSoapBindingStub _stub = new com.portalmobile.meta4.schemas.CSP_MBL_SOAP_SERVER_INFOSoapBindingStub(new java.net.URL(CSP_MBL_SOAP_SERVER_INFO_address), this);
                _stub.setPortName(getCSP_MBL_SOAP_SERVER_INFOWSDDServiceName());
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
        if ("CSP_MBL_SOAP_SERVER_INFO".equals(inputPortName)) {
            return getCSP_MBL_SOAP_SERVER_INFO();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://schemas.meta4.com/", "Csp_Mbl_Soap_Server_InfoServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_MBL_SOAP_SERVER_INFO"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CSP_MBL_SOAP_SERVER_INFO".equals(portName)) {
            setCSP_MBL_SOAP_SERVER_INFOEndpointAddress(address);
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
