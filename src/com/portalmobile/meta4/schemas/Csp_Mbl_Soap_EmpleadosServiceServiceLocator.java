/**
 * Csp_Mbl_Soap_EmpleadosServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

import com.common.config.ParamsApp;

public class Csp_Mbl_Soap_EmpleadosServiceServiceLocator extends org.apache.axis.client.Service implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosServiceService {

    public Csp_Mbl_Soap_EmpleadosServiceServiceLocator() {
    }


    public Csp_Mbl_Soap_EmpleadosServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Csp_Mbl_Soap_EmpleadosServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CSP_MBL_SOAP_EMPLEADOS
    private java.lang.String CSP_MBL_SOAP_EMPLEADOS_address = ParamsApp.META4_WEB_SERVER +"/CSP_MBL_SOAP_EMPLEADOS";

    public java.lang.String getCSP_MBL_SOAP_EMPLEADOSAddress() {
        return CSP_MBL_SOAP_EMPLEADOS_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CSP_MBL_SOAP_EMPLEADOSWSDDServiceName = "CSP_MBL_SOAP_EMPLEADOS";

    public java.lang.String getCSP_MBL_SOAP_EMPLEADOSWSDDServiceName() {
        return CSP_MBL_SOAP_EMPLEADOSWSDDServiceName;
    }

    public void setCSP_MBL_SOAP_EMPLEADOSWSDDServiceName(java.lang.String name) {
        CSP_MBL_SOAP_EMPLEADOSWSDDServiceName = name;
    }

    public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService getCSP_MBL_SOAP_EMPLEADOS() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CSP_MBL_SOAP_EMPLEADOS_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCSP_MBL_SOAP_EMPLEADOS(endpoint);
    }

    public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService getCSP_MBL_SOAP_EMPLEADOS(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.portalmobile.meta4.schemas.CSP_MBL_SOAP_EMPLEADOSSoapBindingStub _stub = new com.portalmobile.meta4.schemas.CSP_MBL_SOAP_EMPLEADOSSoapBindingStub(portAddress, this);
            _stub.setPortName(getCSP_MBL_SOAP_EMPLEADOSWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCSP_MBL_SOAP_EMPLEADOSEndpointAddress(java.lang.String address) {
        CSP_MBL_SOAP_EMPLEADOS_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.portalmobile.meta4.schemas.CSP_MBL_SOAP_EMPLEADOSSoapBindingStub _stub = new com.portalmobile.meta4.schemas.CSP_MBL_SOAP_EMPLEADOSSoapBindingStub(new java.net.URL(CSP_MBL_SOAP_EMPLEADOS_address), this);
                _stub.setPortName(getCSP_MBL_SOAP_EMPLEADOSWSDDServiceName());
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
        if ("CSP_MBL_SOAP_EMPLEADOS".equals(inputPortName)) {
            return getCSP_MBL_SOAP_EMPLEADOS();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://schemas.meta4.com/", "Csp_Mbl_Soap_EmpleadosServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_MBL_SOAP_EMPLEADOS"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CSP_MBL_SOAP_EMPLEADOS".equals(portName)) {
            setCSP_MBL_SOAP_EMPLEADOSEndpointAddress(address);
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
