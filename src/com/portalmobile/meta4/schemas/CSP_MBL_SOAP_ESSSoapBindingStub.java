/**
 * CSP_MBL_SOAP_ESSSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public class CSP_MBL_SOAP_ESSSoapBindingStub extends org.apache.axis.client.Stub implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[19];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ESS_DELETE_ABS_SOLIC");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_HR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OPTIONAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Delete_Abs_SolicOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Delete_Abs_SolicOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_DELETE_ABS_SOLICReturn"));
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
        oper.setName("MSS_CANCEL_ABSENTISMO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_HR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MOTIVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OPTIONAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Cancel_AbsentismoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Mss_Cancel_AbsentismoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "MSS_CANCEL_ABSENTISMOReturn"));
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
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ESS_GET_ABSENTISMOS_RH");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_HR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ANIO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_RhOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_RhOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_GET_ABSENTISMOS_RHReturn"));
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
        oper.setName("SEG_FORGET_PASSWORD_USER");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "PARAM_NIF"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "PARAM_APELLIDO1"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "PARAM_MAIL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Seg_Forget_Password_UserOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Seg_Forget_Password_UserOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "SEG_FORGET_PASSWORD_USERReturn"));
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
        oper.setName("ESS_DOWNLOAD_RECIBO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_HR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FECHA_PAGO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FECHA_IMPUTACION"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Download_ReciboOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Download_ReciboOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_DOWNLOAD_RECIBOReturn"));
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
        oper.setName("ESS_GET_RECIBOS_NOMINA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_HR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ANIO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OPTIONALS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_NominaOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_NominaOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_GET_RECIBOS_NOMINAReturn"));
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
        oper.setName("ESS_SAVE_NEW_ABSENTISMO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_HR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "INICIO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FIN"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "TIPO_AUSENCIA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "COMENTARIO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "TIPO_RERSPONSABLE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OPTIONAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Save_New_AbsentismoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Save_New_AbsentismoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_SAVE_NEW_ABSENTISMOReturn"));
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
        oper.setName("MSS_GET_ABSENTISMOS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_HR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OPTIONAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_AbsentismosOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Mss_Get_AbsentismosOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "MSS_GET_ABSENTISMOSReturn"));
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
        oper.setName("MSS_CONFIRM_ABSENTISMO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_HR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ORDINAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MOTIVO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OPTIONAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Confirm_AbsentismoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Mss_Confirm_AbsentismoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "MSS_CONFIRM_ABSENTISMOReturn"));
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
        oper.setName("ESS_SEND_FILE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_ID_EMPLEADO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_TP_FILE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_EXTENSION"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_COMMENT_USER"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_SEND_FILE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_FileBlock"), com.portalmobile.meta4.schemas.types.Ess_Send_FileBlock.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_FileOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Send_FileOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_SEND_FILEReturn"));
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
        oper.setName("MSS_GET_MIS_CONSULTAS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OPTIONAL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_ConsultasOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "MSS_GET_MIS_CONSULTASReturn"));
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
        oper.setName("M4LoadObject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_SEND_FILE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_FileBlock"), com.portalmobile.meta4.schemas.types.Ess_Send_FileBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_SOAP_ESS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EssBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_TP_DOCS_SEND"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Tp_Docs_SendBlock"), com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MSS_WORKFLOW_ABS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Workflow_AbsBlock"), com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_SEND_FILE_DATA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_File_DataBlock"), com.portalmobile.meta4.schemas.types.Ess_Send_File_DataBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_WHO_IS_WHO_DATA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_DataBlock"), com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_DataBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_NOTICIAS_DATA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_DataBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_SEND_FILE_RH_DATA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_File_Rh_DataBlock"), com.portalmobile.meta4.schemas.types.Ess_Send_File_Rh_DataBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_WHO_IS_WHO_RESULT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_ResultBlock"), com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MSS_GET_MIS_CONSULTAS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_ConsultasBlock"), com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_NOTICIAS_RESULT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_ResultBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_ResultBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MSS_GET_ABSENTISMOS_DATA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_DataBlock"), com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_WHO_IS_WHO_DATA_COUNT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_CountBlock"), com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MSS_GET_ABSENTISMOS_RESULT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_ResultBlock"), com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_ABSENTISMOS_RH_DATA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_DataBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_DataBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_RECIBOS_NOMINA_DATA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_DataBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_DataBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_TP_DOCUMENTS_RESULT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Tp_Documents_ResultBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MSS_GET_MIS_CONSULTAS_ENGINE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_EngineBlock"), com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_EngineBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "MSS_GET_MIS_CONSULTAS_RESULT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ResultBlock"), com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_ABSENTISMOS_RH_RESULT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_ResultBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_ResultBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_ABSENTISMOS_RH_SOLICT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_SolictBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_SolictBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_NOTICIAS_DATA_PRIVATE"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_Data_PrivateBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_RECIBOS_NOMINA_RESULT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_ResultBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock.class, false, false);
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
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ESS_WHO_IS_WHO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "PAGINA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FILTRO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ITEMS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_WhoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Who_Is_WhoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_WHO_IS_WHOReturn"));
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
        oper.setName("MSS_EXEC_QUERY");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_META4OBJECT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARGUMENTS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Exec_QueryOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Mss_Exec_QueryOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "MSS_EXEC_QUERYReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ESS_GET_NOTICIAS");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_NoticiasOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Get_NoticiasOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_GET_NOTICIASReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ESS_GET_TP_DOCUMENTS_SEND");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Tp_Documents_SendOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_SendOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_GET_TP_DOCUMENTS_SENDReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MSS_GET_MIS_CONSULTAS_METADATA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_META4OBJECT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_MetadataOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_MetadataOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "MSS_GET_MIS_CONSULTAS_METADATAReturn"));
        oper.setStyle(org.apache.axis.constants.Style.RPC);
        oper.setUse(org.apache.axis.constants.Use.ENCODED);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.meta4.com/", "fault"),
                      "com.portalmobile.meta4.soapservices.exception.M4SoapException",
                      new javax.xml.namespace.QName("http://exception.soapservices.meta4.com", "M4SoapException"), 
                      true
                     ));
        _operations[17] = oper;

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
        _operations[18] = oper;

    }

    public CSP_MBL_SOAP_ESSSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CSP_MBL_SOAP_ESSSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CSP_MBL_SOAP_ESSSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EssBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EssRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Delete_Abs_SolicOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Delete_Abs_SolicOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Download_ReciboOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Download_ReciboOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_DataBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_DataBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_DataRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_ResultBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_ResultBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_ResultRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_SolictBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_SolictBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_SolictRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_SolictRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_RhOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_RhOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_Data_PrivateBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_Data_PrivateRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_DataBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_ResultBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_ResultBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_ResultRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_NoticiasOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_NoticiasOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_DataBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_DataBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_DataRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_ResultBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_NominaOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_NominaOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Tp_Documents_ResultBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Tp_Documents_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Tp_Documents_SendOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_SendOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Save_New_AbsentismoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Save_New_AbsentismoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_File_DataBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_File_DataBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_File_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_File_DataRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_File_Rh_DataBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_File_Rh_DataBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_File_Rh_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_File_Rh_DataRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_FileBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_FileBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_FileOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_FileOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_FileRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_FileRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Tp_Docs_SendBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Tp_Docs_SendRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_CountBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_CountRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_EmailBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_EmailBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_EmailRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_EmailRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_PhoneBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_PhoneBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_PhoneRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_PhoneRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_DataBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_DataBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_DataRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_ResultBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_WhoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_WhoOutput.class;
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Cancel_AbsentismoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Cancel_AbsentismoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Confirm_AbsentismoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Confirm_AbsentismoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Exec_QueryOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Exec_QueryOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_DataBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_ResultBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_AbsentismosOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_AbsentismosOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_EngineBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_EngineBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_EngineRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_EngineRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_MetadataOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_MetadataOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ParsBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ParsBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ParsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ParsRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ResultBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_ConsultasBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_ConsultasOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_ConsultasRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Workflow_AbsBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Workflow_AbsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Seg_Change_Password_UserOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Seg_Forget_Password_UserOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Seg_Forget_Password_UserOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Soap_EssRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EssRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Absentismos_Rh_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_DataRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_DataRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Absentismos_Rh_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_ResultRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_ResultRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Absentismos_Rh_SolictRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_SolictRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Absentismos_Rh_SolictRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Noticias_Data_PrivateRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_Data_PrivateRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Noticias_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_DataRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Noticias_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_ResultRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_ResultRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Recibos_Nomina_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_DataRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_DataRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Recibos_Nomina_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_ResultRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Tp_Documents_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Tp_Documents_ResultRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Send_File_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_File_DataRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_File_DataRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Send_File_Rh_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_File_Rh_DataRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_File_Rh_DataRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Send_FileRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Send_FileRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_FileRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Tp_Docs_SendRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Tp_Docs_SendRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Who_Is_Who_Data_CountRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_CountRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Who_Is_Who_Data_EmailRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_EmailRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_EmailRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Who_Is_Who_Data_PhoneRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_PhoneRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_PhoneRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Who_Is_Who_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_DataRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_DataRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Who_Is_Who_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_ResultRecord");
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Mss_Get_Absentismos_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_DataRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Mss_Get_Absentismos_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_ResultRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Mss_Get_Mis_Consultas_EngineRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_EngineRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_EngineRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Mss_Get_Mis_Consultas_ParsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ParsRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ParsRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Mss_Get_Mis_Consultas_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ResultRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Mss_Get_Mis_ConsultasRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_ConsultasRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Mss_Workflow_AbsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Workflow_AbsRecord");
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

    public com.portalmobile.meta4.schemas.types.Ess_Delete_Abs_SolicOutput ESS_DELETE_ABS_SOLIC(java.lang.String ID_HR, java.lang.Double ORDINAL, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_DELETE_ABS_SOLIC"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_HR, ORDINAL, OPTIONAL});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Delete_Abs_SolicOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Delete_Abs_SolicOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Delete_Abs_SolicOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Mss_Cancel_AbsentismoOutput MSS_CANCEL_ABSENTISMO(java.lang.String ID_HR, java.lang.Double ORDINAL, java.lang.String MOTIVO, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "MSS_CANCEL_ABSENTISMO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_HR, ORDINAL, MOTIVO, OPTIONAL});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Mss_Cancel_AbsentismoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Mss_Cancel_AbsentismoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Mss_Cancel_AbsentismoOutput.class);
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
        _call.setOperation(_operations[2]);
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

    public com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_RhOutput ESS_GET_ABSENTISMOS_RH(java.lang.String ID_HR, java.lang.Double ANIO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_GET_ABSENTISMOS_RH"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_HR, ANIO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_RhOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_RhOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_RhOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Seg_Forget_Password_UserOutput SEG_FORGET_PASSWORD_USER(java.lang.String PARAM_NIF, java.lang.String PARAM_APELLIDO1, java.lang.String PARAM_MAIL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "SEG_FORGET_PASSWORD_USER"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {PARAM_NIF, PARAM_APELLIDO1, PARAM_MAIL});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Seg_Forget_Password_UserOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Seg_Forget_Password_UserOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Seg_Forget_Password_UserOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Ess_Download_ReciboOutput ESS_DOWNLOAD_RECIBO(java.lang.String ID_HR, java.lang.String FECHA_PAGO, java.lang.String FECHA_IMPUTACION) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_DOWNLOAD_RECIBO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_HR, FECHA_PAGO, FECHA_IMPUTACION});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Download_ReciboOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Download_ReciboOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Download_ReciboOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_NominaOutput ESS_GET_RECIBOS_NOMINA(java.lang.String ID_HR, java.lang.Double ANIO, java.lang.String OPTIONALS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_GET_RECIBOS_NOMINA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_HR, ANIO, OPTIONALS});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_NominaOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_NominaOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_NominaOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Ess_Save_New_AbsentismoOutput ESS_SAVE_NEW_ABSENTISMO(java.lang.String ID_HR, java.lang.String INICIO, java.lang.String FIN, java.lang.String TIPO_AUSENCIA, java.lang.String COMENTARIO, java.lang.String TIPO_RERSPONSABLE, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_SAVE_NEW_ABSENTISMO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_HR, INICIO, FIN, TIPO_AUSENCIA, COMENTARIO, TIPO_RERSPONSABLE, OPTIONAL});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Save_New_AbsentismoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Save_New_AbsentismoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Save_New_AbsentismoOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Mss_Get_AbsentismosOutput MSS_GET_ABSENTISMOS(java.lang.String ID_HR, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "MSS_GET_ABSENTISMOS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_HR, OPTIONAL});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Mss_Get_AbsentismosOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Mss_Get_AbsentismosOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Mss_Get_AbsentismosOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Mss_Confirm_AbsentismoOutput MSS_CONFIRM_ABSENTISMO(java.lang.String ID_HR, java.lang.Double ORDINAL, java.lang.String MOTIVO, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "MSS_CONFIRM_ABSENTISMO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_HR, ORDINAL, MOTIVO, OPTIONAL});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Mss_Confirm_AbsentismoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Mss_Confirm_AbsentismoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Mss_Confirm_AbsentismoOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Ess_Send_FileOutput ESS_SEND_FILE(java.lang.String ARG_ID_EMPLEADO, java.lang.String ARG_TP_FILE, java.lang.String ARG_EXTENSION, java.lang.String ARG_COMMENT_USER, com.portalmobile.meta4.schemas.types.Ess_Send_FileBlock ESS_SEND_FILE) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_SEND_FILE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ARG_ID_EMPLEADO, ARG_TP_FILE, ARG_EXTENSION, ARG_COMMENT_USER, ESS_SEND_FILE});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Send_FileOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Send_FileOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Send_FileOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasOutput MSS_GET_MIS_CONSULTAS(java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "MSS_GET_MIS_CONSULTAS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {OPTIONAL});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasOutput.class);
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

    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Ess_Send_FileBlock ESS_SEND_FILE, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssBlock CSP_MBL_SOAP_ESS, com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendBlock ESS_TP_DOCS_SEND, com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsBlock MSS_WORKFLOW_ABS, com.portalmobile.meta4.schemas.types.Ess_Send_File_DataBlock ESS_SEND_FILE_DATA, com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_DataBlock ESS_WHO_IS_WHO_DATA, com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataBlock ESS_GET_NOTICIAS_DATA, com.portalmobile.meta4.schemas.types.Ess_Send_File_Rh_DataBlock ESS_SEND_FILE_RH_DATA, com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultBlock ESS_WHO_IS_WHO_RESULT, com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasBlock MSS_GET_MIS_CONSULTAS, com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_ResultBlock ESS_GET_NOTICIAS_RESULT, com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataBlock MSS_GET_ABSENTISMOS_DATA, com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountBlock ESS_WHO_IS_WHO_DATA_COUNT, com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultBlock MSS_GET_ABSENTISMOS_RESULT, com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_DataBlock ESS_GET_ABSENTISMOS_RH_DATA, com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_DataBlock ESS_GET_RECIBOS_NOMINA_DATA, com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultBlock ESS_GET_TP_DOCUMENTS_RESULT, com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_EngineBlock MSS_GET_MIS_CONSULTAS_ENGINE, com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultBlock MSS_GET_MIS_CONSULTAS_RESULT, com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_ResultBlock ESS_GET_ABSENTISMOS_RH_RESULT, com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_SolictBlock ESS_GET_ABSENTISMOS_RH_SOLICT, com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateBlock ESS_GET_NOTICIAS_DATA_PRIVATE, com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock ESS_GET_RECIBOS_NOMINA_RESULT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "M4LoadObject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ESS_SEND_FILE, CSP_MBL_SOAP_ESS, ESS_TP_DOCS_SEND, MSS_WORKFLOW_ABS, ESS_SEND_FILE_DATA, ESS_WHO_IS_WHO_DATA, ESS_GET_NOTICIAS_DATA, ESS_SEND_FILE_RH_DATA, ESS_WHO_IS_WHO_RESULT, MSS_GET_MIS_CONSULTAS, ESS_GET_NOTICIAS_RESULT, MSS_GET_ABSENTISMOS_DATA, ESS_WHO_IS_WHO_DATA_COUNT, MSS_GET_ABSENTISMOS_RESULT, ESS_GET_ABSENTISMOS_RH_DATA, ESS_GET_RECIBOS_NOMINA_DATA, ESS_GET_TP_DOCUMENTS_RESULT, MSS_GET_MIS_CONSULTAS_ENGINE, MSS_GET_MIS_CONSULTAS_RESULT, ESS_GET_ABSENTISMOS_RH_RESULT, ESS_GET_ABSENTISMOS_RH_SOLICT, ESS_GET_NOTICIAS_DATA_PRIVATE, ESS_GET_RECIBOS_NOMINA_RESULT});

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

    public com.portalmobile.meta4.schemas.types.Ess_Who_Is_WhoOutput ESS_WHO_IS_WHO(java.lang.Double PAGINA, java.lang.String FILTRO, java.lang.Double ITEMS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_WHO_IS_WHO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {PAGINA, FILTRO, ITEMS});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Who_Is_WhoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Who_Is_WhoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Who_Is_WhoOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Mss_Exec_QueryOutput MSS_EXEC_QUERY(java.lang.String ID_META4OBJECT, java.lang.String ARGUMENTS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "MSS_EXEC_QUERY"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_META4OBJECT, ARGUMENTS});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Mss_Exec_QueryOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Mss_Exec_QueryOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Mss_Exec_QueryOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Ess_Get_NoticiasOutput ESS_GET_NOTICIAS() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_GET_NOTICIAS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_NoticiasOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_NoticiasOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Get_NoticiasOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_SendOutput ESS_GET_TP_DOCUMENTS_SEND() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_GET_TP_DOCUMENTS_SEND"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_SendOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_SendOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_SendOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_MetadataOutput MSS_GET_MIS_CONSULTAS_METADATA(java.lang.String ID_META4OBJECT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "MSS_GET_MIS_CONSULTAS_METADATA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_META4OBJECT});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_MetadataOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_MetadataOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_MetadataOutput.class);
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
        _call.setOperation(_operations[18]);
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
