package com.portalmobile.meta4.schemas;

public class Csp_Mbl_Soap_ToolsServiceProxy implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_ToolsService {
  private String _endpoint = null;
  private com.portalmobile.meta4.schemas.Csp_Mbl_Soap_ToolsService csp_Mbl_Soap_ToolsService = null;
  
  public Csp_Mbl_Soap_ToolsServiceProxy() {
    _initCsp_Mbl_Soap_ToolsServiceProxy();
  }
  
  public Csp_Mbl_Soap_ToolsServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCsp_Mbl_Soap_ToolsServiceProxy();
  }
  
  private void _initCsp_Mbl_Soap_ToolsServiceProxy() {
    try {
      csp_Mbl_Soap_ToolsService = (new com.portalmobile.meta4.schemas.Csp_Mbl_Soap_ToolsServiceServiceLocator()).getCSP_MBL_SOAP_TOOLS();
      if (csp_Mbl_Soap_ToolsService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)csp_Mbl_Soap_ToolsService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)csp_Mbl_Soap_ToolsService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (csp_Mbl_Soap_ToolsService != null)
      ((javax.xml.rpc.Stub)csp_Mbl_Soap_ToolsService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_ToolsService getCsp_Mbl_Soap_ToolsService() {
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService;
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_ParamsOutput CSP_GET_PARAMS() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_GET_PARAMS();
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Delete_FileOutput CSP_DELETE_FILE(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_DELETE_FILE(ORDINAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput CSP_ECHO_SESSION() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_ECHO_SESSION();
  }
  
  public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Mbl_Info_UserBlock CSP_MBL_INFO_USER, com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock CSP_GET_FILES_USER, com.portalmobile.meta4.schemas.types.Csp_Get_Params_OutBlock CSP_GET_PARAMS_OUT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Files_UserBlock CSP_MBL_FILES_USER, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsBlock CSP_MBL_SOAP_TOOLS, com.portalmobile.meta4.schemas.types.Csp_Get_Mobile_NotifBlock CSP_GET_MOBILE_NOTIF, com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutBlock CSP_GET_FILE_REAL_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_Info_User_OutBlock CSP_GET_INFO_USER_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutBlock CSP_GET_MENUS_DISPOSITIVO_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_User_OutBlock CSP_GET_NOTIFICATIONS_USER_OUT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.m4LoadObject(CSP_MBL_INFO_USER, CSP_GET_FILES_USER, CSP_GET_PARAMS_OUT, CSP_MBL_FILES_USER, CSP_MBL_SOAP_TOOLS, CSP_GET_MOBILE_NOTIF, CSP_GET_FILE_REAL_OUT, CSP_GET_INFO_USER_OUT, CSP_GET_MENUS_DISPOSITIVO_OUT, CSP_GET_NOTIFICATIONS_USER_OUT);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_Info_UserOutput CSP_GET_INFO_USER() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_GET_INFO_USER();
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Save_File_RecibidoOutput CSP_SAVE_FILE_RECIBIDO(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_SAVE_FILE_RECIBIDO(ORDINAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Delete_NotificationOutput CSP_DELETE_NOTIFICATION(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_DELETE_NOTIFICATION(ORDINAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput CSP_CONTROL_ACCESO(java.lang.String TIPO_DISPOSITIVO, java.lang.String UUID) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_CONTROL_ACCESO(TIPO_DISPOSITIVO, UUID);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_File_RealOutput CSP_GET_FILE_REAL(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_GET_FILE_REAL(ORDINAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_Param_ValueOutput CSP_GET_PARAM_VALUE(java.lang.String ARG_PARAMETRO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_GET_PARAM_VALUE(ARG_PARAMETRO);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_UserOutput CSP_GET_NOTIFICATIONS_USER(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_GET_NOTIFICATIONS_USER(ORDINAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_Menus_DispositivoOutput CSP_GET_MENUS_DISPOSITIVO(java.lang.String ARG_TP_DISPOSITIVO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_GET_MENUS_DISPOSITIVO(ARG_TP_DISPOSITIVO);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Save_Notificatoin_RecibidoOutput CSP_SAVE_NOTIFICATOIN_RECIBIDO(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_SAVE_NOTIFICATOIN_RECIBIDO(ORDINAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserOutput CSP_GET_FILES_USER(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.CSP_GET_FILES_USER(ORDINAL);
  }
  
  public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_ToolsService == null)
      _initCsp_Mbl_Soap_ToolsServiceProxy();
    return csp_Mbl_Soap_ToolsService.retrieveM4Session(in0);
  }
  
  
}