/**
 * Csp_Mbl_Soap_ToolsBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Soap_ToolsBlock  implements java.io.Serializable {
    private java.lang.String csp_Ctrl_Nulls;

    private java.lang.String csp_Dev_Dia_Semana;

    private java.lang.String csp_Format_Fecha;

    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsRecord[] csp_Mbl_Soap_ToolsRecordSet;

    public Csp_Mbl_Soap_ToolsBlock() {
    }

    public Csp_Mbl_Soap_ToolsBlock(
           java.lang.String csp_Ctrl_Nulls,
           java.lang.String csp_Dev_Dia_Semana,
           java.lang.String csp_Format_Fecha,
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsRecord[] csp_Mbl_Soap_ToolsRecordSet) {
           this.csp_Ctrl_Nulls = csp_Ctrl_Nulls;
           this.csp_Dev_Dia_Semana = csp_Dev_Dia_Semana;
           this.csp_Format_Fecha = csp_Format_Fecha;
           this.csp_Mbl_Soap_ToolsRecordSet = csp_Mbl_Soap_ToolsRecordSet;
    }


    /**
     * Gets the csp_Ctrl_Nulls value for this Csp_Mbl_Soap_ToolsBlock.
     * 
     * @return csp_Ctrl_Nulls
     */
    public java.lang.String getCsp_Ctrl_Nulls() {
        return csp_Ctrl_Nulls;
    }


    /**
     * Sets the csp_Ctrl_Nulls value for this Csp_Mbl_Soap_ToolsBlock.
     * 
     * @param csp_Ctrl_Nulls
     */
    public void setCsp_Ctrl_Nulls(java.lang.String csp_Ctrl_Nulls) {
        this.csp_Ctrl_Nulls = csp_Ctrl_Nulls;
    }


    /**
     * Gets the csp_Dev_Dia_Semana value for this Csp_Mbl_Soap_ToolsBlock.
     * 
     * @return csp_Dev_Dia_Semana
     */
    public java.lang.String getCsp_Dev_Dia_Semana() {
        return csp_Dev_Dia_Semana;
    }


    /**
     * Sets the csp_Dev_Dia_Semana value for this Csp_Mbl_Soap_ToolsBlock.
     * 
     * @param csp_Dev_Dia_Semana
     */
    public void setCsp_Dev_Dia_Semana(java.lang.String csp_Dev_Dia_Semana) {
        this.csp_Dev_Dia_Semana = csp_Dev_Dia_Semana;
    }


    /**
     * Gets the csp_Format_Fecha value for this Csp_Mbl_Soap_ToolsBlock.
     * 
     * @return csp_Format_Fecha
     */
    public java.lang.String getCsp_Format_Fecha() {
        return csp_Format_Fecha;
    }


    /**
     * Sets the csp_Format_Fecha value for this Csp_Mbl_Soap_ToolsBlock.
     * 
     * @param csp_Format_Fecha
     */
    public void setCsp_Format_Fecha(java.lang.String csp_Format_Fecha) {
        this.csp_Format_Fecha = csp_Format_Fecha;
    }


    /**
     * Gets the csp_Mbl_Soap_ToolsRecordSet value for this Csp_Mbl_Soap_ToolsBlock.
     * 
     * @return csp_Mbl_Soap_ToolsRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsRecord[] getCsp_Mbl_Soap_ToolsRecordSet() {
        return csp_Mbl_Soap_ToolsRecordSet;
    }


    /**
     * Sets the csp_Mbl_Soap_ToolsRecordSet value for this Csp_Mbl_Soap_ToolsBlock.
     * 
     * @param csp_Mbl_Soap_ToolsRecordSet
     */
    public void setCsp_Mbl_Soap_ToolsRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_ToolsRecord[] csp_Mbl_Soap_ToolsRecordSet) {
        this.csp_Mbl_Soap_ToolsRecordSet = csp_Mbl_Soap_ToolsRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Soap_ToolsBlock)) return false;
        Csp_Mbl_Soap_ToolsBlock other = (Csp_Mbl_Soap_ToolsBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Ctrl_Nulls==null && other.getCsp_Ctrl_Nulls()==null) || 
             (this.csp_Ctrl_Nulls!=null &&
              this.csp_Ctrl_Nulls.equals(other.getCsp_Ctrl_Nulls()))) &&
            ((this.csp_Dev_Dia_Semana==null && other.getCsp_Dev_Dia_Semana()==null) || 
             (this.csp_Dev_Dia_Semana!=null &&
              this.csp_Dev_Dia_Semana.equals(other.getCsp_Dev_Dia_Semana()))) &&
            ((this.csp_Format_Fecha==null && other.getCsp_Format_Fecha()==null) || 
             (this.csp_Format_Fecha!=null &&
              this.csp_Format_Fecha.equals(other.getCsp_Format_Fecha()))) &&
            ((this.csp_Mbl_Soap_ToolsRecordSet==null && other.getCsp_Mbl_Soap_ToolsRecordSet()==null) || 
             (this.csp_Mbl_Soap_ToolsRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Soap_ToolsRecordSet, other.getCsp_Mbl_Soap_ToolsRecordSet())));
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
        if (getCsp_Ctrl_Nulls() != null) {
            _hashCode += getCsp_Ctrl_Nulls().hashCode();
        }
        if (getCsp_Dev_Dia_Semana() != null) {
            _hashCode += getCsp_Dev_Dia_Semana().hashCode();
        }
        if (getCsp_Format_Fecha() != null) {
            _hashCode += getCsp_Format_Fecha().hashCode();
        }
        if (getCsp_Mbl_Soap_ToolsRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Soap_ToolsRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Soap_ToolsRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Soap_ToolsBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_ToolsBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Ctrl_Nulls");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Ctrl_Nulls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Dev_Dia_Semana");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Dev_Dia_Semana"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Format_Fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Format_Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Soap_ToolsRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Soap_ToolsRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_ToolsRecord"));
        elemField.setNillable(true);
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
