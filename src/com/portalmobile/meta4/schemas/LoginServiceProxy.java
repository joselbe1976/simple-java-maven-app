package com.portalmobile.meta4.schemas;

public class LoginServiceProxy implements com.portalmobile.meta4.schemas.LoginService {
  private String _endpoint = null;
  private com.portalmobile.meta4.schemas.LoginService loginService = null;
  
  public LoginServiceProxy() {
    _initLoginServiceProxy();
  }
  
  public LoginServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initLoginServiceProxy();
  }
  
  private void _initLoginServiceProxy() {
    try {
      loginService = (new com.portalmobile.meta4.schemas.LoginServiceServiceLocator()).getLogin();
      if (loginService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)loginService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)loginService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (loginService != null)
      ((javax.xml.rpc.Stub)loginService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.portalmobile.meta4.schemas.LoginService getLoginService() {
    if (loginService == null)
      _initLoginServiceProxy();
    return loginService;
  }
  
  public com.portalmobile.meta4.schemas.M4LoginOutput login(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (loginService == null)
      _initLoginServiceProxy();
    return loginService.login(in0, in1, in2);
  }
  
  public int logout() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (loginService == null)
      _initLoginServiceProxy();
    return loginService.logout();
  }
  
  public com.portalmobile.meta4.schemas.M4LoginOutput loginWithRole(java.lang.String in0, java.lang.String in1, java.lang.String in2, java.lang.String in3) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (loginService == null)
      _initLoginServiceProxy();
    return loginService.loginWithRole(in0, in1, in2, in3);
  }
  
  public com.portalmobile.meta4.schemas.M4LoginOutput loginWithCertificate(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (loginService == null)
      _initLoginServiceProxy();
    return loginService.loginWithCertificate(in0, in1);
  }
  
  public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (loginService == null)
      _initLoginServiceProxy();
    return loginService.retrieveM4Session(in0);
  }
  
  
}