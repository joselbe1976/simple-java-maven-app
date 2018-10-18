package com.portalmobile.meta4.schemas;

public class Csp_Mbl_Soap_EssServiceProxy implements com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssService {
  private String _endpoint = null;
  private com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssService csp_Mbl_Soap_EssService = null;
  
  public Csp_Mbl_Soap_EssServiceProxy() {
    _initCsp_Mbl_Soap_EssServiceProxy();
  }
  
  public Csp_Mbl_Soap_EssServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initCsp_Mbl_Soap_EssServiceProxy();
  }
  
  private void _initCsp_Mbl_Soap_EssServiceProxy() {
    try {
      csp_Mbl_Soap_EssService = (new com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssServiceServiceLocator()).getCSP_MBL_SOAP_ESS();
      if (csp_Mbl_Soap_EssService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)csp_Mbl_Soap_EssService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)csp_Mbl_Soap_EssService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (csp_Mbl_Soap_EssService != null)
      ((javax.xml.rpc.Stub)csp_Mbl_Soap_EssService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.portalmobile.meta4.schemas.Csp_Mbl_Soap_EssService getCsp_Mbl_Soap_EssService() {
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService;
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Delete_Abs_SolicOutput ESS_DELETE_ABS_SOLIC(java.lang.String ID_HR, java.lang.Double ORDINAL, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.ESS_DELETE_ABS_SOLIC(ID_HR, ORDINAL, OPTIONAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Mss_Cancel_AbsentismoOutput MSS_CANCEL_ABSENTISMO(java.lang.String ID_HR, java.lang.Double ORDINAL, java.lang.String MOTIVO, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.MSS_CANCEL_ABSENTISMO(ID_HR, ORDINAL, MOTIVO, OPTIONAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Seg_Change_Password_UserOutput SEG_CHANGE_PASSWORD_USER(java.lang.String NEW_PASSWORD) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.SEG_CHANGE_PASSWORD_USER(NEW_PASSWORD);
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_RhOutput ESS_GET_ABSENTISMOS_RH(java.lang.String ID_HR, java.lang.Double ANIO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.ESS_GET_ABSENTISMOS_RH(ID_HR, ANIO);
  }
  
  public com.portalmobile.meta4.schemas.types.Seg_Forget_Password_UserOutput SEG_FORGET_PASSWORD_USER(java.lang.String PARAM_NIF, java.lang.String PARAM_APELLIDO1, java.lang.String PARAM_MAIL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.SEG_FORGET_PASSWORD_USER(PARAM_NIF, PARAM_APELLIDO1, PARAM_MAIL);
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Download_ReciboOutput ESS_DOWNLOAD_RECIBO(java.lang.String ID_HR, java.lang.String FECHA_PAGO, java.lang.String FECHA_IMPUTACION) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.ESS_DOWNLOAD_RECIBO(ID_HR, FECHA_PAGO, FECHA_IMPUTACION);
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_NominaOutput ESS_GET_RECIBOS_NOMINA(java.lang.String ID_HR, java.lang.Double ANIO, java.lang.String OPTIONALS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.ESS_GET_RECIBOS_NOMINA(ID_HR, ANIO, OPTIONALS);
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Save_New_AbsentismoOutput ESS_SAVE_NEW_ABSENTISMO(java.lang.String ID_HR, java.lang.String INICIO, java.lang.String FIN, java.lang.String TIPO_AUSENCIA, java.lang.String COMENTARIO, java.lang.String TIPO_RERSPONSABLE, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.ESS_SAVE_NEW_ABSENTISMO(ID_HR, INICIO, FIN, TIPO_AUSENCIA, COMENTARIO, TIPO_RERSPONSABLE, OPTIONAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Mss_Get_AbsentismosOutput MSS_GET_ABSENTISMOS(java.lang.String ID_HR, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.MSS_GET_ABSENTISMOS(ID_HR, OPTIONAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Mss_Confirm_AbsentismoOutput MSS_CONFIRM_ABSENTISMO(java.lang.String ID_HR, java.lang.Double ORDINAL, java.lang.String MOTIVO, java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.MSS_CONFIRM_ABSENTISMO(ID_HR, ORDINAL, MOTIVO, OPTIONAL);
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Send_FileOutput ESS_SEND_FILE(java.lang.String ARG_ID_EMPLEADO, java.lang.String ARG_TP_FILE, java.lang.String ARG_EXTENSION, java.lang.String ARG_COMMENT_USER, com.portalmobile.meta4.schemas.types.Ess_Send_FileBlock ESS_SEND_FILE) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.ESS_SEND_FILE(ARG_ID_EMPLEADO, ARG_TP_FILE, ARG_EXTENSION, ARG_COMMENT_USER, ESS_SEND_FILE);
  }
  
  public com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasOutput MSS_GET_MIS_CONSULTAS(java.lang.String OPTIONAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.MSS_GET_MIS_CONSULTAS(OPTIONAL);
  }
  
  public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Ess_Send_FileBlock ESS_SEND_FILE, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssBlock CSP_MBL_SOAP_ESS, com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendBlock ESS_TP_DOCS_SEND, com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsBlock MSS_WORKFLOW_ABS, com.portalmobile.meta4.schemas.types.Ess_Send_File_DataBlock ESS_SEND_FILE_DATA, com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_DataBlock ESS_WHO_IS_WHO_DATA, com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataBlock ESS_GET_NOTICIAS_DATA, com.portalmobile.meta4.schemas.types.Ess_Send_File_Rh_DataBlock ESS_SEND_FILE_RH_DATA, com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultBlock ESS_WHO_IS_WHO_RESULT, com.portalmobile.meta4.schemas.types.Mss_Get_Mis_ConsultasBlock MSS_GET_MIS_CONSULTAS, com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_ResultBlock ESS_GET_NOTICIAS_RESULT, com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataBlock MSS_GET_ABSENTISMOS_DATA, com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountBlock ESS_WHO_IS_WHO_DATA_COUNT, com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultBlock MSS_GET_ABSENTISMOS_RESULT, com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_DataBlock ESS_GET_ABSENTISMOS_RH_DATA, com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_DataBlock ESS_GET_RECIBOS_NOMINA_DATA, com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultBlock ESS_GET_TP_DOCUMENTS_RESULT, com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_EngineBlock MSS_GET_MIS_CONSULTAS_ENGINE, com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultBlock MSS_GET_MIS_CONSULTAS_RESULT, com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_ResultBlock ESS_GET_ABSENTISMOS_RH_RESULT, com.portalmobile.meta4.schemas.types.Ess_Get_Absentismos_Rh_SolictBlock ESS_GET_ABSENTISMOS_RH_SOLICT, com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateBlock ESS_GET_NOTICIAS_DATA_PRIVATE, com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock ESS_GET_RECIBOS_NOMINA_RESULT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.m4LoadObject(ESS_SEND_FILE, CSP_MBL_SOAP_ESS, ESS_TP_DOCS_SEND, MSS_WORKFLOW_ABS, ESS_SEND_FILE_DATA, ESS_WHO_IS_WHO_DATA, ESS_GET_NOTICIAS_DATA, ESS_SEND_FILE_RH_DATA, ESS_WHO_IS_WHO_RESULT, MSS_GET_MIS_CONSULTAS, ESS_GET_NOTICIAS_RESULT, MSS_GET_ABSENTISMOS_DATA, ESS_WHO_IS_WHO_DATA_COUNT, MSS_GET_ABSENTISMOS_RESULT, ESS_GET_ABSENTISMOS_RH_DATA, ESS_GET_RECIBOS_NOMINA_DATA, ESS_GET_TP_DOCUMENTS_RESULT, MSS_GET_MIS_CONSULTAS_ENGINE, MSS_GET_MIS_CONSULTAS_RESULT, ESS_GET_ABSENTISMOS_RH_RESULT, ESS_GET_ABSENTISMOS_RH_SOLICT, ESS_GET_NOTICIAS_DATA_PRIVATE, ESS_GET_RECIBOS_NOMINA_RESULT);
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Who_Is_WhoOutput ESS_WHO_IS_WHO(java.lang.Double PAGINA, java.lang.String FILTRO, java.lang.Double ITEMS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.ESS_WHO_IS_WHO(PAGINA, FILTRO, ITEMS);
  }
  
  public com.portalmobile.meta4.schemas.types.Mss_Exec_QueryOutput MSS_EXEC_QUERY(java.lang.String ID_META4OBJECT, java.lang.String ARGUMENTS) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.MSS_EXEC_QUERY(ID_META4OBJECT, ARGUMENTS);
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Get_NoticiasOutput ESS_GET_NOTICIAS() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.ESS_GET_NOTICIAS();
  }
  
  public com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_SendOutput ESS_GET_TP_DOCUMENTS_SEND() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.ESS_GET_TP_DOCUMENTS_SEND();
  }
  
  public com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_MetadataOutput MSS_GET_MIS_CONSULTAS_METADATA(java.lang.String ID_META4OBJECT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.MSS_GET_MIS_CONSULTAS_METADATA(ID_META4OBJECT);
  }
  
  public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException{
    if (csp_Mbl_Soap_EssService == null)
      _initCsp_Mbl_Soap_EssServiceProxy();
    return csp_Mbl_Soap_EssService.retrieveM4Session(in0);
  }
  
  
}