/**
 * Csp_Mbl_Soap_EmpleadosService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public interface Csp_Mbl_Soap_EmpleadosService extends java.rmi.Remote {
    public com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput ESS_GET_BANK_ACCCOUNT(java.lang.String ID_HR) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_Lista_EmpleOutput CSP_GET_LISTA_EMPLE(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_List_WlocOutput CSP_GET_LIST_WLOC(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Add_AbsentismoOutput CSP_ADD_ABSENTISMO(java.lang.String ARG_ID_EMPLEADO, java.lang.String ARG_INICIO, java.lang.String ARG_FIN, java.lang.String ARG_ID_ABSENTISMO, java.lang.String ARG_COMENTARIO, java.lang.String ARG_PERIODO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Ess_Get_Mis_EmpleadosOutput ESS_GET_MIS_EMPLEADOS(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS, java.lang.Double ITEMS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Ess_Get_Lista_EmpleOutput ESS_GET_LISTA_EMPLE(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS, java.lang.Double ITEMS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsBlock CSP_MBL_TOOLS, com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsBlock CSP_MBL_INF_ABS, com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterBlock CSP_MBL_WLOC_FILTER, com.portalmobile.meta4.schemas.types.Ess_Control_ManagerBlock ESS_CONTROL_MANAGER, com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitBlock SSE_RESPONSABLE_WUNIT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosBlock CSP_MBL_SOAP_EMPLEADOS, com.portalmobile.meta4.schemas.types.Csp_Get_List_Wloc_ResulBlock CSP_GET_LIST_WLOC_RESUL, com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_CountBlock CSP_MBL_EMPLEADOS_COUNT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_FilterBlock CSP_MBL_EMPLEADOS_FILTER, com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulBlock CSP_GET_LISTA_EMPLE_RESUL, com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_DataBlock ESS_GET_BANK_ACCCOUNT_DATA, com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_ResultBlock ESS_GET_BANK_ACCCOUNT_RESULT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayBlock CSP_MBL_GET_ABSENTISMOS_TODAY) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Add_FavoritoOutput CSP_ADD_FAVORITO(java.lang.String ID_EMPLEADO_FAV) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Del_FavoritoOutput CSP_DEL_FAVORITO(java.lang.String ID_EMPLEADO_FAV) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
}
