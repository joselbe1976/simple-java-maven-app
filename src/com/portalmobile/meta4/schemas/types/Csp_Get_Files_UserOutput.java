/**
 * Csp_Get_Files_UserOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Get_Files_UserOutput  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock csp_Get_Files_User;

    private com.portalmobile.meta4.schemas.types.LogMessage[] logMessage;

    private double _return;

    public Csp_Get_Files_UserOutput() {
    }

    public Csp_Get_Files_UserOutput(
           com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock csp_Get_Files_User,
           com.portalmobile.meta4.schemas.types.LogMessage[] logMessage,
           double _return) {
           this.csp_Get_Files_User = csp_Get_Files_User;
           this.logMessage = logMessage;
           this._return = _return;
    }


    /**
     * Gets the csp_Get_Files_User value for this Csp_Get_Files_UserOutput.
     * 
     * @return csp_Get_Files_User
     */
    public com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock getCsp_Get_Files_User() {
        return csp_Get_Files_User;
    }


    /**
     * Sets the csp_Get_Files_User value for this Csp_Get_Files_UserOutput.
     * 
     * @param csp_Get_Files_User
     */
    public void setCsp_Get_Files_User(com.portalmobile.meta4.schemas.types.Csp_Get_Files_UserBlock csp_Get_Files_User) {
        this.csp_Get_Files_User = csp_Get_Files_User;
    }


    /**
     * Gets the logMessage value for this Csp_Get_Files_UserOutput.
     * 
     * @return logMessage
     */
    public com.portalmobile.meta4.schemas.types.LogMessage[] getLogMessage() {
        return logMessage;
    }


    /**
     * Sets the logMessage value for this Csp_Get_Files_UserOutput.
     * 
     * @param logMessage
     */
    public void setLogMessage(com.portalmobile.meta4.schemas.types.LogMessage[] logMessage) {
        this.logMessage = logMessage;
    }


    /**
     * Gets the _return value for this Csp_Get_Files_UserOutput.
     * 
     * @return _return
     */
    public double get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this Csp_Get_Files_UserOutput.
     * 
     * @param _return
     */
    public void set_return(double _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Get_Files_UserOutput)) return false;
        Csp_Get_Files_UserOutput other = (Csp_Get_Files_UserOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Get_Files_User==null && other.getCsp_Get_Files_User()==null) || 
             (this.csp_Get_Files_User!=null &&
              this.csp_Get_Files_User.equals(other.getCsp_Get_Files_User()))) &&
            ((this.logMessage==null && other.getLogMessage()==null) || 
             (this.logMessage!=null &&
              java.util.Arrays.equals(this.logMessage, other.getLogMessage()))) &&
            this._return == other.get_return();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCsp_Get_Files_User() != null) {
            _hashCode += getCsp_Get_Files_User().hashCode();
        }
        if (getLogMessage() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getLogMessage());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getLogMessage(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += new Double(get_return()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Get_Files_UserOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Files_UserOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Get_Files_User");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Get_Files_User"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Files_UserBlock"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "LogMessage"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("_return");
        elemField.setXmlName(new javax.xml.namespace.QName("", "return"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
