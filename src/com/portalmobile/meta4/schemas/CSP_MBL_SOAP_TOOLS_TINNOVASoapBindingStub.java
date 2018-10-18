/**
 * CSP_MBL_SOAP_TOOLS_TINNOVASoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public class CSP_MBL_SOAP_TOOLS_TINNOVASoapBindingStub extends org.apache.axis.client.Stub implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Tools_TinnovaService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[6];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SEG_CHANGE_PASSWORD_OTHER_USER");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "NEW_PASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "USUARIO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Seg_Change_Password_Other_UserOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Seg_Change_Password_Other_UserOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "SEG_CHANGE_PASSWORD_OTHER_USERReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("M4LoadObject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_APP_OTHER_USER"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_Other_UserBlock"), com.portalmobile.meta4.schemas.types.Csp_App_Other_UserBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_APP_USER_MOBILE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_User_MobileBlock"), com.portalmobile.meta4.schemas.types.Csp_App_User_MobileBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_SOAP_TOOLS_TINNOVA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_Tools_TinnovaBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaBlock.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "M4LoadobjectOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.M4LoadobjectOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "M4LoadObjectReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_ECHO_SESSION");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Echo_SessionOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_ECHO_SESSIONReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SEG_CHANGE_PASSWORD_USER");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "NEW_PASSWORD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Seg_Change_Password_UserOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "SEG_CHANGE_PASSWORD_USERReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_CONTROL_ACCESO");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Control_AccesoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_CONTROL_ACCESOReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveM4Session");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "retrieveM4SessionReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[5] = oper;

    }

    public CSP_MBL_SOAP_TOOLS_TINNOVASoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CSP_MBL_SOAP_TOOLS_TINNOVASoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CSP_MBL_SOAP_TOOLS_TINNOVASoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.soapservices.exception.M4SoapException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_Other_UserBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_App_Other_UserBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_Other_UserRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_App_Other_UserRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_User_MobileBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_App_User_MobileBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_User_MobileRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_App_User_MobileRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Control_AccesoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Echo_SessionOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_Tools_TinnovaBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_Tools_TinnovaRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "LogMessage");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.LogMessage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "M4LoadobjectOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.M4LoadobjectOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Seg_Change_Password_Other_UserOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Seg_Change_Password_Other_UserOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Seg_Change_Password_UserOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_App_Other_UserRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_App_Other_UserRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_Other_UserRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_App_User_MobileRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_App_User_MobileRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_User_MobileRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Soap_Tools_TinnovaRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_Tools_TinnovaRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_LogMessage");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.LogMessage[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "LogMessage");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public com.portalmobile.meta4.schemas.types.Seg_Change_Password_Other_UserOutput SEG_CHANGE_PASSWORD_OTHER_USER(java.lang.String NEW_PASSWORD, java.lang.String USUARIO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "SEG_CHANGE_PASSWORD_OTHER_USER"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {NEW_PASSWORD, USUARIO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Seg_Change_Password_Other_UserOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Seg_Change_Password_Other_UserOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Seg_Change_Password_Other_UserOutput.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.portalmobile.meta4.soapservices.exception.M4SoapException) {
              throw (com.portalmobile.meta4.soapservices.exception.M4SoapException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_App_Other_UserBlock CSP_APP_OTHER_USER, com.portalmobile.meta4.schemas.types.Csp_App_User_MobileBlock CSP_APP_USER_MOBILE, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaBlock CSP_MBL_SOAP_TOOLS_TINNOVA) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "M4LoadObject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {CSP_APP_OTHER_USER, CSP_APP_USER_MOBILE, CSP_MBL_SOAP_TOOLS_TINNOVA});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.M4LoadobjectOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.M4LoadobjectOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.M4LoadobjectOutput.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.portalmobile.meta4.soapservices.exception.M4SoapException) {
              throw (com.portalmobile.meta4.soapservices.exception.M4SoapException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput CSP_ECHO_SESSION() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_ECHO_SESSION"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.portalmobile.meta4.soapservices.exception.M4SoapException) {
              throw (com.portalmobile.meta4.soapservices.exception.M4SoapException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput SEG_CHANGE_PASSWORD_USER(java.lang.String NEW_PASSWORD) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "SEG_CHANGE_PASSWORD_USER"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {NEW_PASSWORD});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.portalmobile.meta4.soapservices.exception.M4SoapException) {
              throw (com.portalmobile.meta4.soapservices.exception.M4SoapException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput CSP_CONTROL_ACCESO() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_CONTROL_ACCESO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.portalmobile.meta4.soapservices.exception.M4SoapException) {
              throw (com.portalmobile.meta4.soapservices.exception.M4SoapException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "retrieveM4Session"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {in0});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof com.portalmobile.meta4.soapservices.exception.M4SoapException) {
              throw (com.portalmobile.meta4.soapservices.exception.M4SoapException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
