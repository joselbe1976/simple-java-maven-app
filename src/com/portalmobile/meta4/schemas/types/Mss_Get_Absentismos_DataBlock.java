/**
 * Mss_Get_Absentismos_DataBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Mss_Get_Absentismos_DataBlock  implements java.io.Serializable {
    private java.lang.String filter_Manager_Id;

    private com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataRecord[] mss_Get_Absentismos_DataRecordSet;

    public Mss_Get_Absentismos_DataBlock() {
    }

    public Mss_Get_Absentismos_DataBlock(
           java.lang.String filter_Manager_Id,
           com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataRecord[] mss_Get_Absentismos_DataRecordSet) {
           this.filter_Manager_Id = filter_Manager_Id;
           this.mss_Get_Absentismos_DataRecordSet = mss_Get_Absentismos_DataRecordSet;
    }


    /**
     * Gets the filter_Manager_Id value for this Mss_Get_Absentismos_DataBlock.
     * 
     * @return filter_Manager_Id
     */
    public java.lang.String getFilter_Manager_Id() {
        return filter_Manager_Id;
    }


    /**
     * Sets the filter_Manager_Id value for this Mss_Get_Absentismos_DataBlock.
     * 
     * @param filter_Manager_Id
     */
    public void setFilter_Manager_Id(java.lang.String filter_Manager_Id) {
        this.filter_Manager_Id = filter_Manager_Id;
    }


    /**
     * Gets the mss_Get_Absentismos_DataRecordSet value for this Mss_Get_Absentismos_DataBlock.
     * 
     * @return mss_Get_Absentismos_DataRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataRecord[] getMss_Get_Absentismos_DataRecordSet() {
        return mss_Get_Absentismos_DataRecordSet;
    }


    /**
     * Sets the mss_Get_Absentismos_DataRecordSet value for this Mss_Get_Absentismos_DataBlock.
     * 
     * @param mss_Get_Absentismos_DataRecordSet
     */
    public void setMss_Get_Absentismos_DataRecordSet(com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_DataRecord[] mss_Get_Absentismos_DataRecordSet) {
        this.mss_Get_Absentismos_DataRecordSet = mss_Get_Absentismos_DataRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mss_Get_Absentismos_DataBlock)) return false;
        Mss_Get_Absentismos_DataBlock other = (Mss_Get_Absentismos_DataBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filter_Manager_Id==null && other.getFilter_Manager_Id()==null) || 
             (this.filter_Manager_Id!=null &&
              this.filter_Manager_Id.equals(other.getFilter_Manager_Id()))) &&
            ((this.mss_Get_Absentismos_DataRecordSet==null && other.getMss_Get_Absentismos_DataRecordSet()==null) || 
             (this.mss_Get_Absentismos_DataRecordSet!=null &&
              java.util.Arrays.equals(this.mss_Get_Absentismos_DataRecordSet, other.getMss_Get_Absentismos_DataRecordSet())));
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
        if (getFilter_Manager_Id() != null) {
            _hashCode += getFilter_Manager_Id().hashCode();
        }
        if (getMss_Get_Absentismos_DataRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMss_Get_Absentismos_DataRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMss_Get_Absentismos_DataRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Mss_Get_Absentismos_DataBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_DataBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter_Manager_Id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filter_Manager_Id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mss_Get_Absentismos_DataRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mss_Get_Absentismos_DataRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_DataRecord"));
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
