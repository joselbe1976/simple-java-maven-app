/**
 * Csp_Mbl_Rh_FavBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Rh_FavBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Rh_FavRecord[] csp_Mbl_Rh_FavRecordSet;

    private java.lang.String std_Id_Person_Target;

    public Csp_Mbl_Rh_FavBlock() {
    }

    public Csp_Mbl_Rh_FavBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Rh_FavRecord[] csp_Mbl_Rh_FavRecordSet,
           java.lang.String std_Id_Person_Target) {
           this.csp_Mbl_Rh_FavRecordSet = csp_Mbl_Rh_FavRecordSet;
           this.std_Id_Person_Target = std_Id_Person_Target;
    }


    /**
     * Gets the csp_Mbl_Rh_FavRecordSet value for this Csp_Mbl_Rh_FavBlock.
     * 
     * @return csp_Mbl_Rh_FavRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Rh_FavRecord[] getCsp_Mbl_Rh_FavRecordSet() {
        return csp_Mbl_Rh_FavRecordSet;
    }


    /**
     * Sets the csp_Mbl_Rh_FavRecordSet value for this Csp_Mbl_Rh_FavBlock.
     * 
     * @param csp_Mbl_Rh_FavRecordSet
     */
    public void setCsp_Mbl_Rh_FavRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Rh_FavRecord[] csp_Mbl_Rh_FavRecordSet) {
        this.csp_Mbl_Rh_FavRecordSet = csp_Mbl_Rh_FavRecordSet;
    }


    /**
     * Gets the std_Id_Person_Target value for this Csp_Mbl_Rh_FavBlock.
     * 
     * @return std_Id_Person_Target
     */
    public java.lang.String getStd_Id_Person_Target() {
        return std_Id_Person_Target;
    }


    /**
     * Sets the std_Id_Person_Target value for this Csp_Mbl_Rh_FavBlock.
     * 
     * @param std_Id_Person_Target
     */
    public void setStd_Id_Person_Target(java.lang.String std_Id_Person_Target) {
        this.std_Id_Person_Target = std_Id_Person_Target;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Rh_FavBlock)) return false;
        Csp_Mbl_Rh_FavBlock other = (Csp_Mbl_Rh_FavBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mbl_Rh_FavRecordSet==null && other.getCsp_Mbl_Rh_FavRecordSet()==null) || 
             (this.csp_Mbl_Rh_FavRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Rh_FavRecordSet, other.getCsp_Mbl_Rh_FavRecordSet()))) &&
            ((this.std_Id_Person_Target==null && other.getStd_Id_Person_Target()==null) || 
             (this.std_Id_Person_Target!=null &&
              this.std_Id_Person_Target.equals(other.getStd_Id_Person_Target())));
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
        if (getCsp_Mbl_Rh_FavRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Rh_FavRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Rh_FavRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getStd_Id_Person_Target() != null) {
            _hashCode += getStd_Id_Person_Target().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Rh_FavBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Rh_FavBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Rh_FavRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Rh_FavRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Rh_FavRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("std_Id_Person_Target");
        elemField.setXmlName(new javax.xml.namespace.QName("", "std_Id_Person_Target"));
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
