/**
 * Csp_Mbl_Soap_ToolsService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas;

public interface Csp_Mbl_Soap_ToolsService extends java.rmi.Remote {
    public com.portalmobile.meta4.schemas.types.Csp_Get_ParamsOutput CSP_GET_PARAMS() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Delete_FileOutput CSP_DELETE_FILE(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Echo_SessionOutput CSP_ECHO_SESSION() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.M4LoadobjectOutput m4LoadObject(com.portalmobile.meta4.schemas.types.Csp_Mbl_Info_UserBlock CSP_MBL_INFO_USER, com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock CSP_GET_FILES_USER, com.portalmobile.meta4.schemas.types.Csp_Get_Params_OutBlock CSP_GET_PARAMS_OUT, com.portalmobile.meta4.schemas.types.Csp_Mbl_Files_UserBlock CSP_MBL_FILES_USER, com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsBlock CSP_MBL_SOAP_TOOLS, com.portalmobile.meta4.schemas.types.Csp_Get_Mobile_NotifBlock CSP_GET_MOBILE_NOTIF, com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutBlock CSP_GET_FILE_REAL_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_Info_User_OutBlock CSP_GET_INFO_USER_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutBlock CSP_GET_MENUS_DISPOSITIVO_OUT, com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_User_OutBlock CSP_GET_NOTIFICATIONS_USER_OUT) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_Info_UserOutput CSP_GET_INFO_USER() throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Save_File_RecibidoOutput CSP_SAVE_FILE_RECIBIDO(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Delete_NotificationOutput CSP_DELETE_NOTIFICATION(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Control_AccesoOutput CSP_CONTROL_ACCESO(java.lang.String TIPO_DISPOSITIVO, java.lang.String UUID) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_File_RealOutput CSP_GET_FILE_REAL(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_Param_ValueOutput CSP_GET_PARAM_VALUE(java.lang.String ARG_PARAMETRO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_Notifications_UserOutput CSP_GET_NOTIFICATIONS_USER(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_Menus_DispositivoOutput CSP_GET_MENUS_DISPOSITIVO(java.lang.String ARG_TP_DISPOSITIVO) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Save_Notificatoin_RecibidoOutput CSP_SAVE_NOTIFICATOIN_RECIBIDO(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserOutput CSP_GET_FILES_USER(double ORDINAL) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
    public int retrieveM4Session(java.lang.String in0) throws java.rmi.RemoteException, com.portalmobile.meta4.soapservices.exception.M4SoapException;
}
