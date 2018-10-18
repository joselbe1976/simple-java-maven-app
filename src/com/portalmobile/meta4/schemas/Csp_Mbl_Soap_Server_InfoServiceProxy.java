package com.portalmobile.meta4.schemas;

public class Csp_Mbl_Soap_Server_InfoServiceProxy implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Server_InfoService {
  private String _endpoint = null;
  private com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Server_InfoService csp_Mbl_Soap_Server_InfoService = null;
  
  public Csp_Mbl_Soap_Server_InfoServiceProxy() {
    _initCsp_Mbl_Soap_Server_InfoServiceProxy();
  }
  
  public Csp_Mbl_Soap_Server_InfoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCsp_Mbl_Soap_Server_InfoServiceProxy();
  }
  
  private void _initCsp_Mbl_Soap_Server_InfoServiceProxy() {
    try {
      csp_Mbl_Soap_Server_InfoService = (new com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Server_InfoServiceServiceLocator()).getCSP_MBL_SOAP_SERVER_INFO();
      if (csp_Mbl_Soap_Server_InfoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)csp_Mbl_Soap_Server_InfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)csp_Mbl_Soap_Server_InfoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (csp_Mbl_Soap_Server_InfoService != null)
      ((javax.xml.rpc.Stub)csp_Mbl_Soap_Server_InfoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Server_InfoService getCsp_Mbl_Soap_Server_InfoService() {
    if (csp_Mbl_Soap_Server_InfoService == null)
      _initCsp_Mbl_Soap_Server_InfoServiceProxy();
    return csp_Mbl_Soap_Server_InfoService;
  }
  
  public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Server_InfoBlock CSP_MBL_SOAP_SERVER_INFO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_Server_InfoService == null)
      _initCsp_Mbl_Soap_Server_InfoServiceProxy();
    return csp_Mbl_Soap_Server_InfoService.m4LoadObject(CSP_MBL_SOAP_SERVER_INFO);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_Session_M4_ValueOutput CSP_GET_SESSION_M4_VALUE(java.lang.String ID_PARAM) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_Server_InfoService == null)
      _initCsp_Mbl_Soap_Server_InfoServiceProxy();
    return csp_Mbl_Soap_Server_InfoService.CSP_GET_SESSION_M4_VALUE(ID_PARAM);
  }
  
  public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_Server_InfoService == null)
      _initCsp_Mbl_Soap_Server_InfoServiceProxy();
    return csp_Mbl_Soap_Server_InfoService.retrieveM4Session(in0);
  }
  
  
}