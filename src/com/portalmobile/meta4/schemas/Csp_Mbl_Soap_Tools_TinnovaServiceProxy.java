package com.portalmobile.meta4.schemas;

public class Csp_Mbl_Soap_Tools_TinnovaServiceProxy implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Tools_TinnovaService {
  private String _endpoint = null;
  private com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Tools_TinnovaService csp_Mbl_Soap_Tools_TinnovaService = null;
  
  public Csp_Mbl_Soap_Tools_TinnovaServiceProxy() {
    _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy();
  }
  
  public Csp_Mbl_Soap_Tools_TinnovaServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy();
  }
  
  private void _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy() {
    try {
      csp_Mbl_Soap_Tools_TinnovaService = (new com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Tools_TinnovaServiceServiceLocator()).getCSP_MBL_SOAP_TOOLS_TINNOVA();
      if (csp_Mbl_Soap_Tools_TinnovaService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)csp_Mbl_Soap_Tools_TinnovaService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)csp_Mbl_Soap_Tools_TinnovaService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (csp_Mbl_Soap_Tools_TinnovaService != null)
      ((javax.xml.rpc.Stub)csp_Mbl_Soap_Tools_TinnovaService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_Tools_TinnovaService getCsp_Mbl_Soap_Tools_TinnovaService() {
    if (csp_Mbl_Soap_Tools_TinnovaService == null)
      _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy();
    return csp_Mbl_Soap_Tools_TinnovaService;
  }
  
  public com.portalmobile.meta4.schemas.types.Seg_Change_Password_Other_UserOutput SEG_CHANGE_PASSWORD_OTHER_USER(java.lang.String NEW_PASSWORD, java.lang.String USUARIO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_Tools_TinnovaService == null)
      _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy();
    return csp_Mbl_Soap_Tools_TinnovaService.SEG_CHANGE_PASSWORD_OTHER_USER(NEW_PASSWORD, USUARIO);
  }
  
  public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_App_Other_UserBlock CSP_APP_OTHER_USER, com.portalmobile.meta4.schemas.types.Csp_App_User_MobileBlock CSP_APP_USER_MOBILE, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaBlock CSP_MBL_SOAP_TOOLS_TINNOVA) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_Tools_TinnovaService == null)
      _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy();
    return csp_Mbl_Soap_Tools_TinnovaService.m4LoadObject(CSP_APP_OTHER_USER, CSP_APP_USER_MOBILE, CSP_MBL_SOAP_TOOLS_TINNOVA);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput CSP_ECHO_SESSION() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_Tools_TinnovaService == null)
      _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy();
    return csp_Mbl_Soap_Tools_TinnovaService.CSP_ECHO_SESSION();
  }
  
  public com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput SEG_CHANGE_PASSWORD_USER(java.lang.String NEW_PASSWORD) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_Tools_TinnovaService == null)
      _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy();
    return csp_Mbl_Soap_Tools_TinnovaService.SEG_CHANGE_PASSWORD_USER(NEW_PASSWORD);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput CSP_CONTROL_ACCESO() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_Tools_TinnovaService == null)
      _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy();
    return csp_Mbl_Soap_Tools_TinnovaService.CSP_CONTROL_ACCESO();
  }
  
  public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_Tools_TinnovaService == null)
      _initCsp_Mbl_Soap_Tools_TinnovaServiceProxy();
    return csp_Mbl_Soap_Tools_TinnovaService.retrieveM4Session(in0);
  }
  
  
}