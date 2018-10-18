/**
 * Csp_Mbl_MailBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_MailBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mbl_MailRecord[] csp_Mbl_MailRecordSet;

    private java.lang.String std_Id_Person;

    public Csp_Mbl_MailBlock() {
    }

    public Csp_Mbl_MailBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mbl_MailRecord[] csp_Mbl_MailRecordSet,
           java.lang.String std_Id_Person) {
           this.csp_Mbl_MailRecordSet = csp_Mbl_MailRecordSet;
           this.std_Id_Person = std_Id_Person;
    }


    /**
     * Gets the csp_Mbl_MailRecordSet value for this Csp_Mbl_MailBlock.
     * 
     * @return csp_Mbl_MailRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_MailRecord[] getCsp_Mbl_MailRecordSet() {
        return csp_Mbl_MailRecordSet;
    }


    /**
     * Sets the csp_Mbl_MailRecordSet value for this Csp_Mbl_MailBlock.
     * 
     * @param csp_Mbl_MailRecordSet
     */
    public void setCsp_Mbl_MailRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_MailRecord[] csp_Mbl_MailRecordSet) {
        this.csp_Mbl_MailRecordSet = csp_Mbl_MailRecordSet;
    }


    /**
     * Gets the std_Id_Person value for this Csp_Mbl_MailBlock.
     * 
     * @return std_Id_Person
     */
    public java.lang.String getStd_Id_Person() {
        return std_Id_Person;
    }


    /**
     * Sets the std_Id_Person value for this Csp_Mbl_MailBlock.
     * 
     * @param std_Id_Person
     */
    public void setStd_Id_Person(java.lang.String std_Id_Person) {
        this.std_Id_Person = std_Id_Person;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_MailBlock)) return false;
        Csp_Mbl_MailBlock other = (Csp_Mbl_MailBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mbl_MailRecordSet==null && other.getCsp_Mbl_MailRecordSet()==null) || 
             (this.csp_Mbl_MailRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_MailRecordSet, other.getCsp_Mbl_MailRecordSet()))) &&
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
        if (getCsp_Mbl_MailRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_MailRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_MailRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Mbl_MailBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_MailBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_MailRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_MailRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_MailRecord"));
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
