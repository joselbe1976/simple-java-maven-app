/**
 * Csp_Mbl_Soap_DashboardService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public interface Csp_Mbl_Soap_DashboardService extends java.rmi.Remote {
    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutBlock CSP_GET_FECHA_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_List_Grps_OutBlock CSP_GET_LIST_GRPS_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_List_Dates_OutBlock CSP_GET_LIST_DATES_OUT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardBlock CSP_MBL_SOAP_DASHBOARD, com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutBlock CSP_GET_DATA_GRAFIC_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutBlock CSP_GET_LIST_INDICADORES_OUT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_List_GrpsOutput CSP_GET_LIST_GRPS() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_List_DatesOutput CSP_GET_LIST_DATES() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_List_IndicadoresOutput CSP_GET_LIST_INDICADORES(java.lang.String ARG_GRUPO, java.lang.String ARG_FECHA, java.lang.String OPERACION) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_Data_GraficOutput CSP_GET_DATA_GRAFIC(java.lang.String GRUPO, java.lang.String INDICADOR, java.lang.String FECHA) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_FechaOutput CSP_GET_FECHA(java.lang.String OPERACION, java.lang.String FECHA_ACT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
}
