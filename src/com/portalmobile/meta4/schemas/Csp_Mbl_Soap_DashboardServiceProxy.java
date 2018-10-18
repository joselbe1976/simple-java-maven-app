package com.portalmobile.meta4.schemas;

public class Csp_Mbl_Soap_DashboardServiceProxy implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_DashboardService {
  private String _endpoint = null;
  private com.portalmobile.meta4.schemas.Csp_Mbl_Soap_DashboardService csp_Mbl_Soap_DashboardService = null;
  
  public Csp_Mbl_Soap_DashboardServiceProxy() {
    _initCsp_Mbl_Soap_DashboardServiceProxy();
  }
  
  public Csp_Mbl_Soap_DashboardServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCsp_Mbl_Soap_DashboardServiceProxy();
  }
  
  private void _initCsp_Mbl_Soap_DashboardServiceProxy() {
    try {
      csp_Mbl_Soap_DashboardService = (new com.portalmobile.meta4.schemas.Csp_Mbl_Soap_DashboardServiceServiceLocator()).getCSP_MBL_SOAP_DASHBOARD();
      if (csp_Mbl_Soap_DashboardService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)csp_Mbl_Soap_DashboardService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)csp_Mbl_Soap_DashboardService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (csp_Mbl_Soap_DashboardService != null)
      ((javax.xml.rpc.Stub)csp_Mbl_Soap_DashboardService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_DashboardService getCsp_Mbl_Soap_DashboardService() {
    if (csp_Mbl_Soap_DashboardService == null)
      _initCsp_Mbl_Soap_DashboardServiceProxy();
    return csp_Mbl_Soap_DashboardService;
  }
  
  public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutBlock CSP_GET_FECHA_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_List_Grps_OutBlock CSP_GET_LIST_GRPS_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_List_Dates_OutBlock CSP_GET_LIST_DATES_OUT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardBlock CSP_MBL_SOAP_DASHBOARD, com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutBlock CSP_GET_DATA_GRAFIC_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutBlock CSP_GET_LIST_INDICADORES_OUT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_DashboardService == null)
      _initCsp_Mbl_Soap_DashboardServiceProxy();
    return csp_Mbl_Soap_DashboardService.m4LoadObject(CSP_GET_FECHA_OUT, CSP_GET_LIST_GRPS_OUT, CSP_GET_LIST_DATES_OUT, CSP_MBL_SOAP_DASHBOARD, CSP_GET_DATA_GRAFIC_OUT, CSP_GET_LIST_INDICADORES_OUT);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_List_GrpsOutput CSP_GET_LIST_GRPS() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_DashboardService == null)
      _initCsp_Mbl_Soap_DashboardServiceProxy();
    return csp_Mbl_Soap_DashboardService.CSP_GET_LIST_GRPS();
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_List_DatesOutput CSP_GET_LIST_DATES() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_DashboardService == null)
      _initCsp_Mbl_Soap_DashboardServiceProxy();
    return csp_Mbl_Soap_DashboardService.CSP_GET_LIST_DATES();
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_List_IndicadoresOutput CSP_GET_LIST_INDICADORES(java.lang.String ARG_GRUPO, java.lang.String ARG_FECHA, java.lang.String OPERACION) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_DashboardService == null)
      _initCsp_Mbl_Soap_DashboardServiceProxy();
    return csp_Mbl_Soap_DashboardService.CSP_GET_LIST_INDICADORES(ARG_GRUPO, ARG_FECHA, OPERACION);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_Data_GraficOutput CSP_GET_DATA_GRAFIC(java.lang.String GRUPO, java.lang.String INDICADOR, java.lang.String FECHA) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_DashboardService == null)
      _initCsp_Mbl_Soap_DashboardServiceProxy();
    return csp_Mbl_Soap_DashboardService.CSP_GET_DATA_GRAFIC(GRUPO, INDICADOR, FECHA);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_FechaOutput CSP_GET_FECHA(java.lang.String OPERACION, java.lang.String FECHA_ACT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_DashboardService == null)
      _initCsp_Mbl_Soap_DashboardServiceProxy();
    return csp_Mbl_Soap_DashboardService.CSP_GET_FECHA(OPERACION, FECHA_ACT);
  }
  
  public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_DashboardService == null)
      _initCsp_Mbl_Soap_DashboardServiceProxy();
    return csp_Mbl_Soap_DashboardService.retrieveM4Session(in0);
  }
  
  
}