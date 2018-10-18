/**
 * Mss_Get_Mis_ConsultasOutput.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Mss_Get_Mis_ConsultasOutput  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.LogMessage[] logMessage;

    private com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultBlock mss_Get_Mis_Consultas_Result;

    private double _return;

    public Mss_Get_Mis_ConsultasOutput() {
    }

    public Mss_Get_Mis_ConsultasOutput(
           com.portalmobile.meta4.schemas.types.LogMessage[] logMessage,
           com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultBlock mss_Get_Mis_Consultas_Result,
           double _return) {
           this.logMessage = logMessage;
           this.mss_Get_Mis_Consultas_Result = mss_Get_Mis_Consultas_Result;
           this._return = _return;
    }


    /**
     * Gets the logMessage value for this Mss_Get_Mis_ConsultasOutput.
     * 
     * @return logMessage
     */
    public com.portalmobile.meta4.schemas.types.LogMessage[] getLogMessage() {
        return logMessage;
    }


    /**
     * Sets the logMessage value for this Mss_Get_Mis_ConsultasOutput.
     * 
     * @param logMessage
     */
    public void setLogMessage(com.portalmobile.meta4.schemas.types.LogMessage[] logMessage) {
        this.logMessage = logMessage;
    }


    /**
     * Gets the mss_Get_Mis_Consultas_Result value for this Mss_Get_Mis_ConsultasOutput.
     * 
     * @return mss_Get_Mis_Consultas_Result
     */
    public com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultBlock getMss_Get_Mis_Consultas_Result() {
        return mss_Get_Mis_Consultas_Result;
    }


    /**
     * Sets the mss_Get_Mis_Consultas_Result value for this Mss_Get_Mis_ConsultasOutput.
     * 
     * @param mss_Get_Mis_Consultas_Result
     */
    public void setMss_Get_Mis_Consultas_Result(com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultBlock mss_Get_Mis_Consultas_Result) {
        this.mss_Get_Mis_Consultas_Result = mss_Get_Mis_Consultas_Result;
    }


    /**
     * Gets the _return value for this Mss_Get_Mis_ConsultasOutput.
     * 
     * @return _return
     */
    public double get_return() {
        return _return;
    }


    /**
     * Sets the _return value for this Mss_Get_Mis_ConsultasOutput.
     * 
     * @param _return
     */
    public void set_return(double _return) {
        this._return = _return;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mss_Get_Mis_ConsultasOutput)) return false;
        Mss_Get_Mis_ConsultasOutput other = (Mss_Get_Mis_ConsultasOutput) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.logMessage==null && other.getLogMessage()==null) || 
             (this.logMessage!=null &&
              java.util.Arrays.equals(this.logMessage, other.getLogMessage()))) &&
            ((this.mss_Get_Mis_Consultas_Result==null && other.getMss_Get_Mis_Consultas_Result()==null) || 
             (this.mss_Get_Mis_Consultas_Result!=null &&
              this.mss_Get_Mis_Consultas_Result.equals(other.getMss_Get_Mis_Consultas_Result()))) &&
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
        if (getMss_Get_Mis_Consultas_Result() != null) {
            _hashCode += getMss_Get_Mis_Consultas_Result().hashCode();
        }
        _hashCode += new Double(get_return()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Mss_Get_Mis_ConsultasOutput.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_ConsultasOutput"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("logMessage");
        elemField.setXmlName(new javax.xml.namespace.QName("", "logMessage"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "LogMessage"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mss_Get_Mis_Consultas_Result");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mss_Get_Mis_Consultas_Result"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ResultBlock"));
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
