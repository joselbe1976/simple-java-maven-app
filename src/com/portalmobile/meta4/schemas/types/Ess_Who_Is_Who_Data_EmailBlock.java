/**
 * Ess_Who_Is_Who_Data_EmailBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Who_Is_Who_Data_EmailBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_EmailRecord[] ess_Who_Is_Who_Data_EmailRecordSet;

    private java.lang.String std_Id_Person;

    public Ess_Who_Is_Who_Data_EmailBlock() {
    }

    public Ess_Who_Is_Who_Data_EmailBlock(
           com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_EmailRecord[] ess_Who_Is_Who_Data_EmailRecordSet,
           java.lang.String std_Id_Person) {
           this.ess_Who_Is_Who_Data_EmailRecordSet = ess_Who_Is_Who_Data_EmailRecordSet;
           this.std_Id_Person = std_Id_Person;
    }


    /**
     * Gets the ess_Who_Is_Who_Data_EmailRecordSet value for this Ess_Who_Is_Who_Data_EmailBlock.
     * 
     * @return ess_Who_Is_Who_Data_EmailRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_EmailRecord[] getEss_Who_Is_Who_Data_EmailRecordSet() {
        return ess_Who_Is_Who_Data_EmailRecordSet;
    }


    /**
     * Sets the ess_Who_Is_Who_Data_EmailRecordSet value for this Ess_Who_Is_Who_Data_EmailBlock.
     * 
     * @param ess_Who_Is_Who_Data_EmailRecordSet
     */
    public void setEss_Who_Is_Who_Data_EmailRecordSet(com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_EmailRecord[] ess_Who_Is_Who_Data_EmailRecordSet) {
        this.ess_Who_Is_Who_Data_EmailRecordSet = ess_Who_Is_Who_Data_EmailRecordSet;
    }


    /**
     * Gets the std_Id_Person value for this Ess_Who_Is_Who_Data_EmailBlock.
     * 
     * @return std_Id_Person
     */
    public java.lang.String getStd_Id_Person() {
        return std_Id_Person;
    }


    /**
     * Sets the std_Id_Person value for this Ess_Who_Is_Who_Data_EmailBlock.
     * 
     * @param std_Id_Person
     */
    public void setStd_Id_Person(java.lang.String std_Id_Person) {
        this.std_Id_Person = std_Id_Person;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Who_Is_Who_Data_EmailBlock)) return false;
        Ess_Who_Is_Who_Data_EmailBlock other = (Ess_Who_Is_Who_Data_EmailBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Who_Is_Who_Data_EmailRecordSet==null && other.getEss_Who_Is_Who_Data_EmailRecordSet()==null) || 
             (this.ess_Who_Is_Who_Data_EmailRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Who_Is_Who_Data_EmailRecordSet, other.getEss_Who_Is_Who_Data_EmailRecordSet()))) &&
            ((this.std_Id_Person==null && other.getStd_Id_Person()==null) || 
             (this.std_Id_Person!=null &&
              this.std_Id_Person.equals(other.getStd_Id_Person())));
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
        if (getEss_Who_Is_Who_Data_EmailRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Who_Is_Who_Data_EmailRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Who_Is_Who_Data_EmailRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStd_Id_Person() != null) {
            _hashCode += getStd_Id_Person().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ess_Who_Is_Who_Data_EmailBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_EmailBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Who_Is_Who_Data_EmailRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Who_Is_Who_Data_EmailRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_EmailRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("std_Id_Person");
        elemField.setXmlName(new javax.xml.namespace.QName("", "std_Id_Person"));
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
