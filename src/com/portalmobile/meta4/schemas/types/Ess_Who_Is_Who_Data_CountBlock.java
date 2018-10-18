/**
 * Ess_Who_Is_Who_Data_CountBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Who_Is_Who_Data_CountBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountRecord[] ess_Who_Is_Who_Data_CountRecordSet;

    private java.lang.String filter_Gb_Name;

    public Ess_Who_Is_Who_Data_CountBlock() {
    }

    public Ess_Who_Is_Who_Data_CountBlock(
           com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountRecord[] ess_Who_Is_Who_Data_CountRecordSet,
           java.lang.String filter_Gb_Name) {
           this.ess_Who_Is_Who_Data_CountRecordSet = ess_Who_Is_Who_Data_CountRecordSet;
           this.filter_Gb_Name = filter_Gb_Name;
    }


    /**
     * Gets the ess_Who_Is_Who_Data_CountRecordSet value for this Ess_Who_Is_Who_Data_CountBlock.
     * 
     * @return ess_Who_Is_Who_Data_CountRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountRecord[] getEss_Who_Is_Who_Data_CountRecordSet() {
        return ess_Who_Is_Who_Data_CountRecordSet;
    }


    /**
     * Sets the ess_Who_Is_Who_Data_CountRecordSet value for this Ess_Who_Is_Who_Data_CountBlock.
     * 
     * @param ess_Who_Is_Who_Data_CountRecordSet
     */
    public void setEss_Who_Is_Who_Data_CountRecordSet(com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_CountRecord[] ess_Who_Is_Who_Data_CountRecordSet) {
        this.ess_Who_Is_Who_Data_CountRecordSet = ess_Who_Is_Who_Data_CountRecordSet;
    }


    /**
     * Gets the filter_Gb_Name value for this Ess_Who_Is_Who_Data_CountBlock.
     * 
     * @return filter_Gb_Name
     */
    public java.lang.String getFilter_Gb_Name() {
        return filter_Gb_Name;
    }


    /**
     * Sets the filter_Gb_Name value for this Ess_Who_Is_Who_Data_CountBlock.
     * 
     * @param filter_Gb_Name
     */
    public void setFilter_Gb_Name(java.lang.String filter_Gb_Name) {
        this.filter_Gb_Name = filter_Gb_Name;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Who_Is_Who_Data_CountBlock)) return false;
        Ess_Who_Is_Who_Data_CountBlock other = (Ess_Who_Is_Who_Data_CountBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Who_Is_Who_Data_CountRecordSet==null && other.getEss_Who_Is_Who_Data_CountRecordSet()==null) || 
             (this.ess_Who_Is_Who_Data_CountRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Who_Is_Who_Data_CountRecordSet, other.getEss_Who_Is_Who_Data_CountRecordSet()))) &&
            ((this.filter_Gb_Name==null && other.getFilter_Gb_Name()==null) || 
             (this.filter_Gb_Name!=null &&
              this.filter_Gb_Name.equals(other.getFilter_Gb_Name())));
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
        if (getEss_Who_Is_Who_Data_CountRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Who_Is_Who_Data_CountRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Who_Is_Who_Data_CountRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFilter_Gb_Name() != null) {
            _hashCode += getFilter_Gb_Name().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ess_Who_Is_Who_Data_CountBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_CountBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Who_Is_Who_Data_CountRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Who_Is_Who_Data_CountRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_CountRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter_Gb_Name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filter_Gb_Name"));
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
