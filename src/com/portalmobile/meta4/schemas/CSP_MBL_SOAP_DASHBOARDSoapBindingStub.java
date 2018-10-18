/**
 * CSP_MBL_SOAP_DASHBOARDSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public class CSP_MBL_SOAP_DASHBOARDSoapBindingStub extends org.apache.axis.client.Stub implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_DashboardService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[7];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("M4LoadObject");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_FECHA_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Fecha_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_LIST_GRPS_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Grps_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_List_Grps_OutBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_LIST_DATES_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Dates_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_List_Dates_OutBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_MBL_SOAP_DASHBOARD"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_DashboardBlock"), com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_DATA_GRAFIC_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Data_Grafic_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutBlock.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "CSP_GET_LIST_INDICADORES_OUT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Indicadores_OutBlock"), com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutBlock.class, false, false);
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
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("CSP_GET_LIST_GRPS");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_GrpsOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_List_GrpsOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_LIST_GRPSReturn"));
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
        oper.setName("CSP_GET_LIST_DATES");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_DatesOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_List_DatesOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_LIST_DATESReturn"));
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
        oper.setName("CSP_GET_LIST_INDICADORES");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_GRUPO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "ARG_FECHA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OPERACION"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_IndicadoresOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_List_IndicadoresOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_LIST_INDICADORESReturn"));
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
        oper.setName("CSP_GET_DATA_GRAFIC");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "GRUPO"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "INDICADOR"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FECHA"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Data_GraficOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_Data_GraficOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_DATA_GRAFICReturn"));
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
        oper.setName("CSP_GET_FECHA");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "OPERACION"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("", "FECHA_ACT"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_FechaOutput"));
        oper.setReturnClass(com.portalmobile.meta4.schemas.types.Csp_Get_FechaOutput.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "CSP_GET_FECHAReturn"));
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
        _operations[6] = oper;

    }

    public CSP_MBL_SOAP_DASHBOARDSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public CSP_MBL_SOAP_DASHBOARDSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public CSP_MBL_SOAP_DASHBOARDSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Data_Grafic_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Data_Grafic_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Data_GraficOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Data_GraficOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Fecha_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Fecha_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_FechaOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_FechaOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Dates_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Dates_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Dates_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Dates_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_DatesOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_DatesOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Grps_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Grps_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Grps_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Grps_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_GrpsOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_GrpsOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Indicadores_OutBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Indicadores_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutRecord.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_IndicadoresOutput");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_IndicadoresOutput.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_DashboardBlock");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardBlock.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_DashboardRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardRecord.class;
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

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_Data_Grafic_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Data_Grafic_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_Fecha_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Fecha_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_List_Dates_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Dates_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Dates_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_List_Grps_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Grps_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Grps_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Get_List_Indicadores_OutRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Indicadores_OutRecord");
            qName2 = null;
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/", "ArrayOf_tns1_Csp_Mbl_Soap_DashboardRecord");
            cachedSerQNames.add(qName);
            cls = com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardRecord[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_DashboardRecord");
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

    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutBlock CSP_GET_FECHA_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_List_Grps_OutBlock CSP_GET_LIST_GRPS_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_List_Dates_OutBlock CSP_GET_LIST_DATES_OUT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardBlock CSP_MBL_SOAP_DASHBOARD, com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutBlock CSP_GET_DATA_GRAFIC_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutBlock CSP_GET_LIST_INDICADORES_OUT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "M4LoadObject"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {CSP_GET_FECHA_OUT, CSP_GET_LIST_GRPS_OUT, CSP_GET_LIST_DATES_OUT, CSP_MBL_SOAP_DASHBOARD, CSP_GET_DATA_GRAFIC_OUT, CSP_GET_LIST_INDICADORES_OUT});

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

    public com.portalmobile.meta4.schemas.types.Csp_Get_List_GrpsOutput CSP_GET_LIST_GRPS() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_LIST_GRPS"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_List_GrpsOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_List_GrpsOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_List_GrpsOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_List_DatesOutput CSP_GET_LIST_DATES() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_LIST_DATES"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_List_DatesOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_List_DatesOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_List_DatesOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_List_IndicadoresOutput CSP_GET_LIST_INDICADORES(java.lang.String ARG_GRUPO, java.lang.String ARG_FECHA, java.lang.String OPERACION) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_LIST_INDICADORES"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {ARG_GRUPO, ARG_FECHA, OPERACION});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_List_IndicadoresOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_List_IndicadoresOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_List_IndicadoresOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_Data_GraficOutput CSP_GET_DATA_GRAFIC(java.lang.String GRUPO, java.lang.String INDICADOR, java.lang.String FECHA) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_DATA_GRAFIC"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {GRUPO, INDICADOR, FECHA});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Data_GraficOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_Data_GraficOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_Data_GraficOutput.class);
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

    public com.portalmobile.meta4.schemas.types.Csp_Get_FechaOutput CSP_GET_FECHA(java.lang.String OPERACION, java.lang.String FECHA_ACT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://schemas.meta4.com/", "CSP_GET_FECHA"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {OPERACION, FECHA_ACT});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_FechaOutput) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.portalmobile.meta4.schemas.types.Csp_Get_FechaOutput) org.apache.axis.utils.JavaUtils.convert(_resp, com.portalmobile.meta4.schemas.types.Csp_Get_FechaOutput.class);
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
        _call.setOperation(_operations[6]);
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
