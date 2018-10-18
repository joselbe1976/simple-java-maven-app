/**
 * CSP_MBL_SOAP_EMPLEADOSSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public class CSP_MBL_SOAP_EMPLEADOSSoapBindingStub extends org.apache.axis.client.Stub implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[10];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ESS_GET_BANK_ACCCOUNT");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_HR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_AcccountOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_GET_BANK_ACCCOUNTReturn"));
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
        oper.setName("CSP_GET_LISTA_EMPLE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "NUM_PAGINA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_FILTERS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Lista_EmpleOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_Lista_EmpleOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_LISTA_EMPLEReturn"));
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
        oper.setName("CSP_GET_LIST_WLOC");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "NUM_PAGINA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_FILTERS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_WlocOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_List_WlocOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_LIST_WLOCReturn"));
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
        oper.setName("CSP_ADD_ABSENTISMO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_ID_EMPLEADO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_INICIO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_FIN"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_ID_ABSENTISMO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_COMENTARIO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_PERIODO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Add_AbsentismoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Add_AbsentismoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_ADD_ABSENTISMOReturn"));
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
        oper.setName("ESS_GET_MIS_EMPLEADOS");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "NUM_PAGINA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_FILTERS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ITEMS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Mis_EmpleadosOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Get_Mis_EmpleadosOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_GET_MIS_EMPLEADOSReturn"));
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
        oper.setName("ESS_GET_LISTA_EMPLE");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "NUM_PAGINA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_FILTERS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ITEMS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "double"), java.lang.Double.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Lista_EmpleOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Ess_Get_Lista_EmpleOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ESS_GET_LISTA_EMPLEReturn"));
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
        oper.setName("M4LoadObject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_TOOLS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_ToolsBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_INF_ABS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Inf_AbsBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_WLOC_FILTER"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Wloc_FilterBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_CONTROL_MANAGER"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Control_ManagerBlock"), com.portalmobile.meta4.schemas.types.Ess_Control_ManagerBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "SSE_RESPONSABLE_WUNIT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Sse_Responsable_WunitBlock"), com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_SOAP_EMPLEADOS"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EmpleadosBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_LIST_WLOC_RESUL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Wloc_ResulBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_List_Wloc_ResulBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_EMPLEADOS_COUNT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Empleados_CountBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_CountBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_EMPLEADOS_FILTER"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Empleados_FilterBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_FilterBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_LISTA_EMPLE_RESUL"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Lista_Emple_ResulBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_BANK_ACCCOUNT_DATA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_Acccount_DataBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_DataBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ESS_GET_BANK_ACCCOUNT_RESULT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_Acccount_ResultBlock"), com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_ResultBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_GET_ABSENTISMOS_TODAY"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Get_Absentismos_TodayBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayBlock.class, false, false);
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
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_ADD_FAVORITO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_EMPLEADO_FAV"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Add_FavoritoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Add_FavoritoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_ADD_FAVORITOReturn"));
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
        oper.setName("CSP_DEL_FAVORITO");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ID_EMPLEADO_FAV"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Del_FavoritoOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Del_FavoritoOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_DEL_FAVORITOReturn"));
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
        _operations[9] = oper;

    }

    public CSP_MBL_SOAP_EMPLEADOSSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CSP_MBL_SOAP_EMPLEADOSSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CSP_MBL_SOAP_EMPLEADOSSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Add_AbsentismoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Add_AbsentismoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Add_FavoritoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Add_FavoritoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Del_FavoritoOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Del_FavoritoOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Wloc_ResulBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Wloc_ResulBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Wloc_ResulRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Wloc_ResulRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_WlocOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_WlocOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Lista_Emple_ResulBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Lista_Emple_ResulRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Lista_EmpleOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Lista_EmpleOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Empleados_CountBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_CountBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Empleados_CountRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_CountRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Empleados_FilterBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_FilterBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Empleados_FilterRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_FilterRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Get_Absentismos_TodayBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Get_Absentismos_TodayRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Inf_AbsBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Inf_AbsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_MailBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_MailBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_MailRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_MailRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_PhoneBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_PhoneBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_PhoneRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_PhoneRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Rh_FavBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Rh_FavBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Rh_FavRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Rh_FavRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EmpleadosBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EmpleadosRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_ToolsBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_ToolsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Wloc_FilterBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Wloc_FilterRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Control_ManagerBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Control_ManagerBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Control_ManagerRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Control_ManagerRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_Acccount_DataBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_DataBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_Acccount_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_DataRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_Acccount_ResultBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_ResultBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_Acccount_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_ResultRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_AcccountOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Lista_EmpleOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Lista_EmpleOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Mis_EmpleadosOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Mis_EmpleadosOutput.class;
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Sse_Responsable_WunitBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Sse_Responsable_WunitRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_List_Wloc_ResulRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Wloc_ResulRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Wloc_ResulRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_Lista_Emple_ResulRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Lista_Emple_ResulRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Empleados_CountRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_CountRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Empleados_CountRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Empleados_FilterRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_FilterRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Empleados_FilterRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Get_Absentismos_TodayRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Get_Absentismos_TodayRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Inf_AbsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Inf_AbsRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_MailRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_MailRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_MailRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_PhoneRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_PhoneRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_PhoneRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Rh_FavRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Rh_FavRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Rh_FavRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Soap_EmpleadosRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EmpleadosRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_ToolsRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_ToolsRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Wloc_FilterRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Wloc_FilterRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Control_ManagerRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Control_ManagerRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Control_ManagerRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Bank_Acccount_DataRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_DataRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_Acccount_DataRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Ess_Get_Bank_Acccount_ResultRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_ResultRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Bank_Acccount_ResultRecord");
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Sse_Responsable_WunitRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Sse_Responsable_WunitRecord");
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

    public com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput ESS_GET_BANK_ACCCOUNT(java.lang.String ID_HR) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_GET_BANK_ACCCOUNT"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_HR});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_Lista_EmpleOutput CSP_GET_LISTA_EMPLE(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_LISTA_EMPLE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {NUM_PAGINA, ARG_FILTERS});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Lista_EmpleOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Lista_EmpleOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_Lista_EmpleOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_List_WlocOutput CSP_GET_LIST_WLOC(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_LIST_WLOC"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {NUM_PAGINA, ARG_FILTERS});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_List_WlocOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_List_WlocOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_List_WlocOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Add_AbsentismoOutput CSP_ADD_ABSENTISMO(java.lang.String ARG_ID_EMPLEADO, java.lang.String ARG_INICIO, java.lang.String ARG_FIN, java.lang.String ARG_ID_ABSENTISMO, java.lang.String ARG_COMENTARIO, java.lang.String ARG_PERIODO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_ADD_ABSENTISMO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ARG_ID_EMPLEADO, ARG_INICIO, ARG_FIN, ARG_ID_ABSENTISMO, ARG_COMENTARIO, ARG_PERIODO});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Add_AbsentismoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Add_AbsentismoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Add_AbsentismoOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Ess_Get_Mis_EmpleadosOutput ESS_GET_MIS_EMPLEADOS(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS, java.lang.Double ITEMS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_GET_MIS_EMPLEADOS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {NUM_PAGINA, ARG_FILTERS, ITEMS});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Mis_EmpleadosOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Mis_EmpleadosOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Get_Mis_EmpleadosOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Ess_Get_Lista_EmpleOutput ESS_GET_LISTA_EMPLE(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS, java.lang.Double ITEMS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "ESS_GET_LISTA_EMPLE"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {NUM_PAGINA, ARG_FILTERS, ITEMS});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Lista_EmpleOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Ess_Get_Lista_EmpleOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Ess_Get_Lista_EmpleOutput.class);
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

    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsBlock CSP_MBL_TOOLS, com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsBlock CSP_MBL_INF_ABS, com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterBlock CSP_MBL_WLOC_FILTER, com.portalmobile.meta4.schemas.types.Ess_Control_ManagerBlock ESS_CONTROL_MANAGER, com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitBlock SSE_RESPONSABLE_WUNIT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosBlock CSP_MBL_SOAP_EMPLEADOS, com.portalmobile.meta4.schemas.types.Csp_Get_List_Wloc_ResulBlock CSP_GET_LIST_WLOC_RESUL, com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_CountBlock CSP_MBL_EMPLEADOS_COUNT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_FilterBlock CSP_MBL_EMPLEADOS_FILTER, com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulBlock CSP_GET_LISTA_EMPLE_RESUL, com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_DataBlock ESS_GET_BANK_ACCCOUNT_DATA, com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_ResultBlock ESS_GET_BANK_ACCCOUNT_RESULT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayBlock CSP_MBL_GET_ABSENTISMOS_TODAY) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "M4LoadObject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {CSP_MBL_TOOLS, CSP_MBL_INF_ABS, CSP_MBL_WLOC_FILTER, ESS_CONTROL_MANAGER, SSE_RESPONSABLE_WUNIT, CSP_MBL_SOAP_EMPLEADOS, CSP_GET_LIST_WLOC_RESUL, CSP_MBL_EMPLEADOS_COUNT, CSP_MBL_EMPLEADOS_FILTER, CSP_GET_LISTA_EMPLE_RESUL, ESS_GET_BANK_ACCCOUNT_DATA, ESS_GET_BANK_ACCCOUNT_RESULT, CSP_MBL_GET_ABSENTISMOS_TODAY});

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

    public com.portalmobile.meta4.schemas.types.Csp_Add_FavoritoOutput CSP_ADD_FAVORITO(java.lang.String ID_EMPLEADO_FAV) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_ADD_FAVORITO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_EMPLEADO_FAV});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Add_FavoritoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Add_FavoritoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Add_FavoritoOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Del_FavoritoOutput CSP_DEL_FAVORITO(java.lang.String ID_EMPLEADO_FAV) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_DEL_FAVORITO"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ID_EMPLEADO_FAV});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Del_FavoritoOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Del_FavoritoOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Del_FavoritoOutput.class);
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
        _call.setOperation(_operations[9]);
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
