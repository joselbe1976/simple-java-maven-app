/**
 * Ess_Download_ReciboOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Download_ReciboOutput  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock ess_Get_Recibos_Nomina_Result;

    private com.portalmobile.meta4.schemas.types.LogMessage[] logMessage;

    private double _return;

    public Ess_Download_ReciboOutput() {
    }

    public Ess_Download_ReciboOutput(
           com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock ess_Get_Recibos_Nomina_Result,
           com.portalmobile.meta4.schemas.types.LogMessage[] logMessage,
           double _return) {
           this.ess_Get_Recibos_Nomina_Result = ess_Get_Recibos_Nomina_Result;
           this.logMessage = logMessage;
           this._return = _return;
    }


    /**
     * Gets the ess_Get_Recibos_Nomina_Result value for this Ess_Download_ReciboOutput.
     * 
     * @return ess_Get_Recibos_Nomina_Result
     */
    public com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock getEss_Get_Recibos_Nomina_Result() {
        return ess_Get_Recibos_Nomina_Result;
    }


    /**
     * Sets the ess_Get_Recibos_Nomina_Result value for this Ess_Download_ReciboOutput.
     * 
     * @param ess_Get_Recibos_Nomina_Result
     */
    public void setEss_Get_Recibos_Nomina_Result(com.portalmobile.meta4.schemas.types.Ess_Get_Recibos_Nomina_ResultBlock ess_Get_Recibos_Nomina_Result) {
        this.ess_Get_Recibos_Nomina_Result = ess_Get_Recibos_Nomina_Result;
    }


    /**
     * Gets the logMessage value for this Ess_Download_ReciboOutput.
     * 
     * @return logMessage
     */
    public com.portalmobile.meta4.schemas.types.LogMessage[] getLogMessage() {
        return logMessage;
    }


    /**
     * Sets the logMessage value for this Ess_Download_ReciboOutput.
     * 
     * @param logMessage
     */
    public void setLogMessage(com.portalmobile.meta4.schemas.types.LogMessage[] logMessage) {
        this.logMessage = logMessage;
    }


    /**
     * Gets the _return value for this Ess_Download_ReciboOutput.
     * 
     * @return _return
     */
    public double get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this Ess_Download_ReciboOutput.
     * 
     * @param _return
     */
    public void set_return(double _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Download_ReciboOutput)) return false;
        Ess_Download_ReciboOutput other = (Ess_Download_ReciboOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Get_Recibos_Nomina_Result==null && other.getEss_Get_Recibos_Nomina_Result()==null) || 
             (this.ess_Get_Recibos_Nomina_Result!=null &&
              this.ess_Get_Recibos_Nomina_Result.equals(other.getEss_Get_Recibos_Nomina_Result()))) &&
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
        if (getEss_Get_Recibos_Nomina_Result() != null) {
            _hashCode += getEss_Get_Recibos_Nomina_Result().hashCode();
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
        new org.apache.axis.description.TypeDesc(Ess_Download_ReciboOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Download_ReciboOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Get_Recibos_Nomina_Result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Get_Recibos_Nomina_Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_ResultBlock"));
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
