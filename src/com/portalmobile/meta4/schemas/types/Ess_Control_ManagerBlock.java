/**
 * Ess_Control_ManagerBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Control_ManagerBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Control_ManagerRecord[] ess_Control_ManagerRecordSet;

    private java.lang.String filter_Id_Hr;

    public Ess_Control_ManagerBlock() {
    }

    public Ess_Control_ManagerBlock(
           com.portalmobile.meta4.schemas.types.Ess_Control_ManagerRecord[] ess_Control_ManagerRecordSet,
           java.lang.String filter_Id_Hr) {
           this.ess_Control_ManagerRecordSet = ess_Control_ManagerRecordSet;
           this.filter_Id_Hr = filter_Id_Hr;
    }


    /**
     * Gets the ess_Control_ManagerRecordSet value for this Ess_Control_ManagerBlock.
     * 
     * @return ess_Control_ManagerRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Control_ManagerRecord[] getEss_Control_ManagerRecordSet() {
        return ess_Control_ManagerRecordSet;
    }


    /**
     * Sets the ess_Control_ManagerRecordSet value for this Ess_Control_ManagerBlock.
     * 
     * @param ess_Control_ManagerRecordSet
     */
    public void setEss_Control_ManagerRecordSet(com.portalmobile.meta4.schemas.types.Ess_Control_ManagerRecord[] ess_Control_ManagerRecordSet) {
        this.ess_Control_ManagerRecordSet = ess_Control_ManagerRecordSet;
    }


    /**
     * Gets the filter_Id_Hr value for this Ess_Control_ManagerBlock.
     * 
     * @return filter_Id_Hr
     */
    public java.lang.String getFilter_Id_Hr() {
        return filter_Id_Hr;
    }


    /**
     * Sets the filter_Id_Hr value for this Ess_Control_ManagerBlock.
     * 
     * @param filter_Id_Hr
     */
    public void setFilter_Id_Hr(java.lang.String filter_Id_Hr) {
        this.filter_Id_Hr = filter_Id_Hr;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Control_ManagerBlock)) return false;
        Ess_Control_ManagerBlock other = (Ess_Control_ManagerBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Control_ManagerRecordSet==null && other.getEss_Control_ManagerRecordSet()==null) || 
             (this.ess_Control_ManagerRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Control_ManagerRecordSet, other.getEss_Control_ManagerRecordSet()))) &&
            ((this.filter_Id_Hr==null && other.getFilter_Id_Hr()==null) || 
             (this.filter_Id_Hr!=null &&
              this.filter_Id_Hr.equals(other.getFilter_Id_Hr())));
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
        if (getEss_Control_ManagerRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Control_ManagerRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Control_ManagerRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFilter_Id_Hr() != null) {
            _hashCode += getFilter_Id_Hr().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ess_Control_ManagerBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Control_ManagerBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Control_ManagerRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Control_ManagerRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Control_ManagerRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter_Id_Hr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filter_Id_Hr"));
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
