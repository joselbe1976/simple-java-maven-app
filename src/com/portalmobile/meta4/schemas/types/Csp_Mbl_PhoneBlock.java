/**
 * Csp_Mbl_PhoneBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_PhoneBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mbl_PhoneRecord[] csp_Mbl_PhoneRecordSet;

    private java.lang.String std_Id_Person;

    public Csp_Mbl_PhoneBlock() {
    }

    public Csp_Mbl_PhoneBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mbl_PhoneRecord[] csp_Mbl_PhoneRecordSet,
           java.lang.String std_Id_Person) {
           this.csp_Mbl_PhoneRecordSet = csp_Mbl_PhoneRecordSet;
           this.std_Id_Person = std_Id_Person;
    }


    /**
     * Gets the csp_Mbl_PhoneRecordSet value for this Csp_Mbl_PhoneBlock.
     * 
     * @return csp_Mbl_PhoneRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_PhoneRecord[] getCsp_Mbl_PhoneRecordSet() {
        return csp_Mbl_PhoneRecordSet;
    }


    /**
     * Sets the csp_Mbl_PhoneRecordSet value for this Csp_Mbl_PhoneBlock.
     * 
     * @param csp_Mbl_PhoneRecordSet
     */
    public void setCsp_Mbl_PhoneRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_PhoneRecord[] csp_Mbl_PhoneRecordSet) {
        this.csp_Mbl_PhoneRecordSet = csp_Mbl_PhoneRecordSet;
    }


    /**
     * Gets the std_Id_Person value for this Csp_Mbl_PhoneBlock.
     * 
     * @return std_Id_Person
     */
    public java.lang.String getStd_Id_Person() {
        return std_Id_Person;
    }


    /**
     * Sets the std_Id_Person value for this Csp_Mbl_PhoneBlock.
     * 
     * @param std_Id_Person
     */
    public void setStd_Id_Person(java.lang.String std_Id_Person) {
        this.std_Id_Person = std_Id_Person;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_PhoneBlock)) return false;
        Csp_Mbl_PhoneBlock other = (Csp_Mbl_PhoneBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mbl_PhoneRecordSet==null && other.getCsp_Mbl_PhoneRecordSet()==null) || 
             (this.csp_Mbl_PhoneRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_PhoneRecordSet, other.getCsp_Mbl_PhoneRecordSet()))) &&
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
        if (getCsp_Mbl_PhoneRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_PhoneRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_PhoneRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Mbl_PhoneBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_PhoneBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_PhoneRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_PhoneRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_PhoneRecord"));
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
