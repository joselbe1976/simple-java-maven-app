/**
 * Csp_Mbl_ToolsBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_ToolsBlock  implements java.io.Serializable {
    private java.lang.String csp_Get_Value_Filter;

    private com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsRecord[] csp_Mbl_ToolsRecordSet;

    public Csp_Mbl_ToolsBlock() {
    }

    public Csp_Mbl_ToolsBlock(
           java.lang.String csp_Get_Value_Filter,
           com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsRecord[] csp_Mbl_ToolsRecordSet) {
           this.csp_Get_Value_Filter = csp_Get_Value_Filter;
           this.csp_Mbl_ToolsRecordSet = csp_Mbl_ToolsRecordSet;
    }


    /**
     * Gets the csp_Get_Value_Filter value for this Csp_Mbl_ToolsBlock.
     * 
     * @return csp_Get_Value_Filter
     */
    public java.lang.String getCsp_Get_Value_Filter() {
        return csp_Get_Value_Filter;
    }


    /**
     * Sets the csp_Get_Value_Filter value for this Csp_Mbl_ToolsBlock.
     * 
     * @param csp_Get_Value_Filter
     */
    public void setCsp_Get_Value_Filter(java.lang.String csp_Get_Value_Filter) {
        this.csp_Get_Value_Filter = csp_Get_Value_Filter;
    }


    /**
     * Gets the csp_Mbl_ToolsRecordSet value for this Csp_Mbl_ToolsBlock.
     * 
     * @return csp_Mbl_ToolsRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsRecord[] getCsp_Mbl_ToolsRecordSet() {
        return csp_Mbl_ToolsRecordSet;
    }


    /**
     * Sets the csp_Mbl_ToolsRecordSet value for this Csp_Mbl_ToolsBlock.
     * 
     * @param csp_Mbl_ToolsRecordSet
     */
    public void setCsp_Mbl_ToolsRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_ToolsRecord[] csp_Mbl_ToolsRecordSet) {
        this.csp_Mbl_ToolsRecordSet = csp_Mbl_ToolsRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_ToolsBlock)) return false;
        Csp_Mbl_ToolsBlock other = (Csp_Mbl_ToolsBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Get_Value_Filter==null && other.getCsp_Get_Value_Filter()==null) || 
             (this.csp_Get_Value_Filter!=null &&
              this.csp_Get_Value_Filter.equals(other.getCsp_Get_Value_Filter()))) &&
            ((this.csp_Mbl_ToolsRecordSet==null && other.getCsp_Mbl_ToolsRecordSet()==null) || 
             (this.csp_Mbl_ToolsRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_ToolsRecordSet, other.getCsp_Mbl_ToolsRecordSet())));
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
        if (getCsp_Get_Value_Filter() != null) {
            _hashCode += getCsp_Get_Value_Filter().hashCode();
        }
        if (getCsp_Mbl_ToolsRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_ToolsRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_ToolsRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Mbl_ToolsBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_ToolsBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Get_Value_Filter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Get_Value_Filter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_ToolsRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_ToolsRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_ToolsRecord"));
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
