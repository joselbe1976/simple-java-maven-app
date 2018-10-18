/**
 * CSP_MBL_SOAP_TOOLSSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public class CSP_MBL_SOAP_TOOLSSoapBindingStub extends org.apache.axis.client.Stub implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_ToolsService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[15];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_GET_PARAMS");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_ParamsOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_ParamsOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_PARAMSReturn"));
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
        oper.setName("CSP_DELETE_FILE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Delete_FileOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Delete_FileOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_DELETE_FILEReturn"));
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
        oper.setName("M4LoadObject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_INFO_USER"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Info_UserBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Info_UserBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_FILES_USER"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Files_UserBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_PARAMS_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Params_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_Params_OutBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_FILES_USER"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Files_UserBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Files_UserBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_SOAP_TOOLS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_ToolsBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_MOBILE_NOTIF"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Mobile_NotifBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_Mobile_NotifBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_FILE_REAL_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_File_Real_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_INFO_USER_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Info_User_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_Info_User_OutBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_MENUS_DISPOSITIVO_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Menus_Dispositivo_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_NOTIFICATIONS_USER_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Notifications_User_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_User_OutBlock.class, false, false);
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
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_GET_INFO_USER");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Info_UserOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_Info_UserOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_INFO_USERReturn"));
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
        oper.setName("CSP_SAVE_FILE_RECIBIDO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Save_File_RecibidoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Save_File_RecibidoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_SAVE_FILE_RECIBIDOReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_DELETE_NOTIFICATION");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Delete_NotificationOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Delete_NotificationOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_DELETE_NOTIFICATIONReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_CONTROL_ACCESO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "TIPO_DISPOSITIVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "UUID"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
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
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_GET_FILE_REAL");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_File_RealOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_File_RealOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_FILE_REALReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_GET_PARAM_VALUE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_PARAMETRO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Param_ValueOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_Param_ValueOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_PARAM_VALUEReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_GET_NOTIFICATIONS_USER");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Notifications_UserOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_UserOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_NOTIFICATIONS_USERReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_GET_MENUS_DISPOSITIVO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_TP_DISPOSITIVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Menus_DispositivoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_Menus_DispositivoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_MENUS_DISPOSITIVOReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_SAVE_NOTIFICATOIN_RECIBIDO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Save_Notificatoin_RecibidoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Save_Notificatoin_RecibidoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_SAVE_NOTIFICATOIN_RECIBIDOReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_GET_FILES_USER");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"), double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Files_UserOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_FILES_USERReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("retrieveM4Session");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "in0"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
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
        _operations[14] = oper;

    }

    public CSP_MBL_SOAP_TOOLSSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CSP_MBL_SOAP_TOOLSSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CSP_MBL_SOAP_TOOLSSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Control_AccesoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Delete_FileOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Delete_FileOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Delete_NotificationOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Delete_NotificationOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Echo_SessionOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_File_Real_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_File_Real_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_File_RealOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_File_RealOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Files_UserBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Files_UserOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Files_UserRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Info_User_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Info_User_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Info_User_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Info_User_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Info_UserOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Info_UserOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Menus_Dispositivo_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Menus_Dispositivo_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Menus_DispositivoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Menus_DispositivoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Mobile_NotifBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Mobile_NotifBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Mobile_NotifRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Mobile_NotifRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Notifications_User_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_User_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Notifications_User_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_User_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Notifications_UserOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_UserOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Param_ValueOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Param_ValueOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Params_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Params_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Params_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Params_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_ParamsOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_ParamsOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Files_UserBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Files_UserBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Files_UserRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Files_UserRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Info_UserBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Info_UserBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Info_UserRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Info_UserRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_ToolsBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_ToolsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Save_File_RecibidoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Save_File_RecibidoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Save_Notificatoin_RecibidoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Save_Notificatoin_RecibidoOutput.class;
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_File_Real_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_File_Real_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_Files_UserRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Files_UserRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_Info_User_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Info_User_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Info_User_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_Menus_Dispositivo_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Menus_Dispositivo_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_Mobile_NotifRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Mobile_NotifRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Mobile_NotifRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_Notifications_User_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_User_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Notifications_User_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_Params_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Params_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Params_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Files_UserRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Files_UserRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Files_UserRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Info_UserRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Info_UserRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Info_UserRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Soap_ToolsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_ToolsRecord");
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_ParamsOutput CSP_GET_PARAMS() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_PARAMS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_ParamsOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_ParamsOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_ParamsOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Delete_FileOutput CSP_DELETE_FILE(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_DELETE_FILE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Double(ORDINAL)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Delete_FileOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Delete_FileOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Delete_FileOutput.class);
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

    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Mbl_Info_UserBlock CSP_MBL_INFO_USER, com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock CSP_GET_FILES_USER, com.portalmobile.meta4.schemas.types.Csp_Get_Params_OutBlock CSP_GET_PARAMS_OUT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Files_UserBlock CSP_MBL_FILES_USER, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsBlock CSP_MBL_SOAP_TOOLS, com.portalmobile.meta4.schemas.types.Csp_Get_Mobile_NotifBlock CSP_GET_MOBILE_NOTIF, com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutBlock CSP_GET_FILE_REAL_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_Info_User_OutBlock CSP_GET_INFO_USER_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutBlock CSP_GET_MENUS_DISPOSITIVO_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_User_OutBlock CSP_GET_NOTIFICATIONS_USER_OUT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "M4LoadObject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {CSP_MBL_INFO_USER, CSP_GET_FILES_USER, CSP_GET_PARAMS_OUT, CSP_MBL_FILES_USER, CSP_MBL_SOAP_TOOLS, CSP_GET_MOBILE_NOTIF, CSP_GET_FILE_REAL_OUT, CSP_GET_INFO_USER_OUT, CSP_GET_MENUS_DISPOSITIVO_OUT, CSP_GET_NOTIFICATIONS_USER_OUT});

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

    public com.portalmobile.meta4.schemas.types.Csp_Get_Info_UserOutput CSP_GET_INFO_USER() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_INFO_USER"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Info_UserOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Info_UserOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_Info_UserOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Save_File_RecibidoOutput CSP_SAVE_FILE_RECIBIDO(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_SAVE_FILE_RECIBIDO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Double(ORDINAL)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Save_File_RecibidoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Save_File_RecibidoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Save_File_RecibidoOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Delete_NotificationOutput CSP_DELETE_NOTIFICATION(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_DELETE_NOTIFICATION"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Double(ORDINAL)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Delete_NotificationOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Delete_NotificationOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Delete_NotificationOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput CSP_CONTROL_ACCESO(java.lang.String TIPO_DISPOSITIVO, java.lang.String UUID) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_CONTROL_ACCESO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {TIPO_DISPOSITIVO, UUID});

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

    public com.portalmobile.meta4.schemas.types.Csp_Get_File_RealOutput CSP_GET_FILE_REAL(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_FILE_REAL"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Double(ORDINAL)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_File_RealOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_File_RealOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_File_RealOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_Param_ValueOutput CSP_GET_PARAM_VALUE(java.lang.String ARG_PARAMETRO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_PARAM_VALUE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ARG_PARAMETRO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Param_ValueOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Param_ValueOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_Param_ValueOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_UserOutput CSP_GET_NOTIFICATIONS_USER(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_NOTIFICATIONS_USER"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Double(ORDINAL)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_UserOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_UserOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_UserOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_Menus_DispositivoOutput CSP_GET_MENUS_DISPOSITIVO(java.lang.String ARG_TP_DISPOSITIVO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_MENUS_DISPOSITIVO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ARG_TP_DISPOSITIVO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Menus_DispositivoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Menus_DispositivoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_Menus_DispositivoOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Save_Notificatoin_RecibidoOutput CSP_SAVE_NOTIFICATOIN_RECIBIDO(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_SAVE_NOTIFICATOIN_RECIBIDO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Double(ORDINAL)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Save_Notificatoin_RecibidoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Save_Notificatoin_RecibidoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Save_Notificatoin_RecibidoOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserOutput CSP_GET_FILES_USER(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_FILES_USER"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {new java.lang.Double(ORDINAL)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserOutput.class);
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
        _call.setOperation(_operations[14]);
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
