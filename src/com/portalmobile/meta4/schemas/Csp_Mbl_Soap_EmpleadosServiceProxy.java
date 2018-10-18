package com.portalmobile.meta4.schemas;

public class Csp_Mbl_Soap_EmpleadosServiceProxy implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService {
  private String _endpoint = null;
  private com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService csp_Mbl_Soap_EmpleadosService = null;
  
  public Csp_Mbl_Soap_EmpleadosServiceProxy() {
    _initCsp_Mbl_Soap_EmpleadosServiceProxy();
  }
  
  public Csp_Mbl_Soap_EmpleadosServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCsp_Mbl_Soap_EmpleadosServiceProxy();
  }
  
  private void _initCsp_Mbl_Soap_EmpleadosServiceProxy() {
    try {
      csp_Mbl_Soap_EmpleadosService = (new com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosServiceServiceLocator()).getCSP_MBL_SOAP_EMPLEADOS();
      if (csp_Mbl_Soap_EmpleadosService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)csp_Mbl_Soap_EmpleadosService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)csp_Mbl_Soap_EmpleadosService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (csp_Mbl_Soap_EmpleadosService != null)
      ((javax.xml.rpc.Stub)csp_Mbl_Soap_EmpleadosService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EmpleadosService getCsp_Mbl_Soap_EmpleadosService() {
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService;
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Get_Bank_AcccountOutput ESS_GET_BANK_ACCCOUNT(java.lang.String ID_HR) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.ESS_GET_BANK_ACCCOUNT(ID_HR);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_Lista_EmpleOutput CSP_GET_LISTA_EMPLE(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.CSP_GET_LISTA_EMPLE(NUM_PAGINA, ARG_FILTERS);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_List_WlocOutput CSP_GET_LIST_WLOC(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.CSP_GET_LIST_WLOC(NUM_PAGINA, ARG_FILTERS);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Add_AbsentismoOutput CSP_ADD_ABSENTISMO(java.lang.String ARG_ID_EMPLEADO, java.lang.String ARG_INICIO, java.lang.String ARG_FIN, java.lang.String ARG_ID_ABSENTISMO, java.lang.String ARG_COMENTARIO, java.lang.String ARG_PERIODO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.CSP_ADD_ABSENTISMO(ARG_ID_EMPLEADO, ARG_INICIO, ARG_FIN, ARG_ID_ABSENTISMO, ARG_COMENTARIO, ARG_PERIODO);
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Get_Mis_EmpleadosOutput ESS_GET_MIS_EMPLEADOS(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS, java.lang.Double ITEMS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.ESS_GET_MIS_EMPLEADOS(NUM_PAGINA, ARG_FILTERS, ITEMS);
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Get_Lista_EmpleOutput ESS_GET_LISTA_EMPLE(java.lang.Double NUM_PAGINA, java.lang.String ARG_FILTERS, java.lang.Double ITEMS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.ESS_GET_LISTA_EMPLE(NUM_PAGINA, ARG_FILTERS, ITEMS);
  }
  
  public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsBlock CSP_MBL_TOOLS, com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsBlock CSP_MBL_INF_ABS, com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterBlock CSP_MBL_WLOC_FILTER, com.portalmobile.meta4.schemas.types.Ess_Control_ManagerBlock ESS_CONTROL_MANAGER, com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitBlock SSE_RESPONSABLE_WUNIT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosBlock CSP_MBL_SOAP_EMPLEADOS, com.portalmobile.meta4.schemas.types.Csp_Get_List_Wloc_ResulBlock CSP_GET_LIST_WLOC_RESUL, com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_CountBlock CSP_MBL_EMPLEADOS_COUNT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Empleados_FilterBlock CSP_MBL_EMPLEADOS_FILTER, com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulBlock CSP_GET_LISTA_EMPLE_RESUL, com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_DataBlock ESS_GET_BANK_ACCCOUNT_DATA, com.portalmobile.meta4.schemas.types.Ess_Get_Bank_Acccount_ResultBlock ESS_GET_BANK_ACCCOUNT_RESULT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayBlock CSP_MBL_GET_ABSENTISMOS_TODAY) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.m4LoadObject(CSP_MBL_TOOLS, CSP_MBL_INF_ABS, CSP_MBL_WLOC_FILTER, ESS_CONTROL_MANAGER, SSE_RESPONSABLE_WUNIT, CSP_MBL_SOAP_EMPLEADOS, CSP_GET_LIST_WLOC_RESUL, CSP_MBL_EMPLEADOS_COUNT, CSP_MBL_EMPLEADOS_FILTER, CSP_GET_LISTA_EMPLE_RESUL, ESS_GET_BANK_ACCCOUNT_DATA, ESS_GET_BANK_ACCCOUNT_RESULT, CSP_MBL_GET_ABSENTISMOS_TODAY);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Add_FavoritoOutput CSP_ADD_FAVORITO(java.lang.String ID_EMPLEADO_FAV) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.CSP_ADD_FAVORITO(ID_EMPLEADO_FAV);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Del_FavoritoOutput CSP_DEL_FAVORITO(java.lang.String ID_EMPLEADO_FAV) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.CSP_DEL_FAVORITO(ID_EMPLEADO_FAV);
  }
  
  public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EmpleadosService == null)
      _initCsp_Mbl_Soap_EmpleadosServiceProxy();
    return csp_Mbl_Soap_EmpleadosService.retrieveM4Session(in0);
  }
  
  
}