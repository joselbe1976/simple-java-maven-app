/**
 * Csp_Mbl_Wloc_FilterBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Wloc_FilterBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterRecord[] csp_Mbl_Wloc_FilterRecordSet;

    private java.lang.String sys_Sentence;

    public Csp_Mbl_Wloc_FilterBlock() {
    }

    public Csp_Mbl_Wloc_FilterBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterRecord[] csp_Mbl_Wloc_FilterRecordSet,
           java.lang.String sys_Sentence) {
           this.csp_Mbl_Wloc_FilterRecordSet = csp_Mbl_Wloc_FilterRecordSet;
           this.sys_Sentence = sys_Sentence;
    }


    /**
     * Gets the csp_Mbl_Wloc_FilterRecordSet value for this Csp_Mbl_Wloc_FilterBlock.
     * 
     * @return csp_Mbl_Wloc_FilterRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterRecord[] getCsp_Mbl_Wloc_FilterRecordSet() {
        return csp_Mbl_Wloc_FilterRecordSet;
    }


    /**
     * Sets the csp_Mbl_Wloc_FilterRecordSet value for this Csp_Mbl_Wloc_FilterBlock.
     * 
     * @param csp_Mbl_Wloc_FilterRecordSet
     */
    public void setCsp_Mbl_Wloc_FilterRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Wloc_FilterRecord[] csp_Mbl_Wloc_FilterRecordSet) {
        this.csp_Mbl_Wloc_FilterRecordSet = csp_Mbl_Wloc_FilterRecordSet;
    }


    /**
     * Gets the sys_Sentence value for this Csp_Mbl_Wloc_FilterBlock.
     * 
     * @return sys_Sentence
     */
    public java.lang.String getSys_Sentence() {
        return sys_Sentence;
    }


    /**
     * Sets the sys_Sentence value for this Csp_Mbl_Wloc_FilterBlock.
     * 
     * @param sys_Sentence
     */
    public void setSys_Sentence(java.lang.String sys_Sentence) {
        this.sys_Sentence = sys_Sentence;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Wloc_FilterBlock)) return false;
        Csp_Mbl_Wloc_FilterBlock other = (Csp_Mbl_Wloc_FilterBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mbl_Wloc_FilterRecordSet==null && other.getCsp_Mbl_Wloc_FilterRecordSet()==null) || 
             (this.csp_Mbl_Wloc_FilterRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Wloc_FilterRecordSet, other.getCsp_Mbl_Wloc_FilterRecordSet()))) &&
            ((this.sys_Sentence==null && other.getSys_Sentence()==null) || 
             (this.sys_Sentence!=null &&
              this.sys_Sentence.equals(other.getSys_Sentence())));
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
        if (getCsp_Mbl_Wloc_FilterRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Wloc_FilterRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Wloc_FilterRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getSys_Sentence() != null) {
            _hashCode += getSys_Sentence().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Wloc_FilterBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Wloc_FilterBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Wloc_FilterRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Wloc_FilterRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Wloc_FilterRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sys_Sentence");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sys_Sentence"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
