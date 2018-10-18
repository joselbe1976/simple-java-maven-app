/**
 * Ess_Who_Is_Who_Data_PhoneBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Who_Is_Who_Data_PhoneBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_PhoneRecord[] ess_Who_Is_Who_Data_PhoneRecordSet;

    private java.lang.String std_Id_Person;

    public Ess_Who_Is_Who_Data_PhoneBlock() {
    }

    public Ess_Who_Is_Who_Data_PhoneBlock(
           com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_PhoneRecord[] ess_Who_Is_Who_Data_PhoneRecordSet,
           java.lang.String std_Id_Person) {
           this.ess_Who_Is_Who_Data_PhoneRecordSet = ess_Who_Is_Who_Data_PhoneRecordSet;
           this.std_Id_Person = std_Id_Person;
    }


    /**
     * Gets the ess_Who_Is_Who_Data_PhoneRecordSet value for this Ess_Who_Is_Who_Data_PhoneBlock.
     * 
     * @return ess_Who_Is_Who_Data_PhoneRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_PhoneRecord[] getEss_Who_Is_Who_Data_PhoneRecordSet() {
        return ess_Who_Is_Who_Data_PhoneRecordSet;
    }


    /**
     * Sets the ess_Who_Is_Who_Data_PhoneRecordSet value for this Ess_Who_Is_Who_Data_PhoneBlock.
     * 
     * @param ess_Who_Is_Who_Data_PhoneRecordSet
     */
    public void setEss_Who_Is_Who_Data_PhoneRecordSet(com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_Data_PhoneRecord[] ess_Who_Is_Who_Data_PhoneRecordSet) {
        this.ess_Who_Is_Who_Data_PhoneRecordSet = ess_Who_Is_Who_Data_PhoneRecordSet;
    }


    /**
     * Gets the std_Id_Person value for this Ess_Who_Is_Who_Data_PhoneBlock.
     * 
     * @return std_Id_Person
     */
    public java.lang.String getStd_Id_Person() {
        return std_Id_Person;
    }


    /**
     * Sets the std_Id_Person value for this Ess_Who_Is_Who_Data_PhoneBlock.
     * 
     * @param std_Id_Person
     */
    public void setStd_Id_Person(java.lang.String std_Id_Person) {
        this.std_Id_Person = std_Id_Person;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Who_Is_Who_Data_PhoneBlock)) return false;
        Ess_Who_Is_Who_Data_PhoneBlock other = (Ess_Who_Is_Who_Data_PhoneBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Who_Is_Who_Data_PhoneRecordSet==null && other.getEss_Who_Is_Who_Data_PhoneRecordSet()==null) || 
             (this.ess_Who_Is_Who_Data_PhoneRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Who_Is_Who_Data_PhoneRecordSet, other.getEss_Who_Is_Who_Data_PhoneRecordSet()))) &&
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
        if (getEss_Who_Is_Who_Data_PhoneRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Who_Is_Who_Data_PhoneRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Who_Is_Who_Data_PhoneRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Ess_Who_Is_Who_Data_PhoneBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_PhoneBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Who_Is_Who_Data_PhoneRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Who_Is_Who_Data_PhoneRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_PhoneRecord"));
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
