/**
 * Ess_Who_Is_Who_Data_EmailRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Who_Is_Who_Data_EmailRecord  implements java.io.Serializable {
    private java.lang.String m4AutoGeneratedRecordID;

    private boolean m4AutoGeneratedToDelete;

    private java.lang.String std_Email;

    public Ess_Who_Is_Who_Data_EmailRecord() {
    }

    public Ess_Who_Is_Who_Data_EmailRecord(
           java.lang.String m4AutoGeneratedRecordID,
           boolean m4AutoGeneratedToDelete,
           java.lang.String std_Email) {
           this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
           this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
           this.std_Email = std_Email;
    }


    /**
     * Gets the m4AutoGeneratedRecordID value for this Ess_Who_Is_Who_Data_EmailRecord.
     * 
     * @return m4AutoGeneratedRecordID
     */
    public java.lang.String getM4AutoGeneratedRecordID() {
        return m4AutoGeneratedRecordID;
    }


    /**
     * Sets the m4AutoGeneratedRecordID value for this Ess_Who_Is_Who_Data_EmailRecord.
     * 
     * @param m4AutoGeneratedRecordID
     */
    public void setM4AutoGeneratedRecordID(java.lang.String m4AutoGeneratedRecordID) {
        this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
    }


    /**
     * Gets the m4AutoGeneratedToDelete value for this Ess_Who_Is_Who_Data_EmailRecord.
     * 
     * @return m4AutoGeneratedToDelete
     */
    public boolean isM4AutoGeneratedToDelete() {
        return m4AutoGeneratedToDelete;
    }


    /**
     * Sets the m4AutoGeneratedToDelete value for this Ess_Who_Is_Who_Data_EmailRecord.
     * 
     * @param m4AutoGeneratedToDelete
     */
    public void setM4AutoGeneratedToDelete(boolean m4AutoGeneratedToDelete) {
        this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
    }


    /**
     * Gets the std_Email value for this Ess_Who_Is_Who_Data_EmailRecord.
     * 
     * @return std_Email
     */
    public java.lang.String getStd_Email() {
        return std_Email;
    }


    /**
     * Sets the std_Email value for this Ess_Who_Is_Who_Data_EmailRecord.
     * 
     * @param std_Email
     */
    public void setStd_Email(java.lang.String std_Email) {
        this.std_Email = std_Email;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Who_Is_Who_Data_EmailRecord)) return false;
        Ess_Who_Is_Who_Data_EmailRecord other = (Ess_Who_Is_Who_Data_EmailRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.m4AutoGeneratedRecordID==null && other.getM4AutoGeneratedRecordID()==null) || 
             (this.m4AutoGeneratedRecordID!=null &&
              this.m4AutoGeneratedRecordID.equals(other.getM4AutoGeneratedRecordID()))) &&
            this.m4AutoGeneratedToDelete == other.isM4AutoGeneratedToDelete() &&
            ((this.std_Email==null && other.getStd_Email()==null) || 
             (this.std_Email!=null &&
              this.std_Email.equals(other.getStd_Email())));
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
        if (getM4AutoGeneratedRecordID() != null) {
            _hashCode += getM4AutoGeneratedRecordID().hashCode();
        }
        _hashCode += (isM4AutoGeneratedToDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getStd_Email() != null) {
            _hashCode += getStd_Email().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ess_Who_Is_Who_Data_EmailRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_Data_EmailRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m4AutoGeneratedRecordID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m4AutoGeneratedRecordID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m4AutoGeneratedToDelete");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m4AutoGeneratedToDelete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("std_Email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "std_Email"));
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
