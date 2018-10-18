/**
 * Csp_App_Other_UserBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_App_Other_UserBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_App_Other_UserRecord[] csp_App_Other_UserRecordSet;

    private java.lang.String param_Id_User;

    public Csp_App_Other_UserBlock() {
    }

    public Csp_App_Other_UserBlock(
           com.portalmobile.meta4.schemas.types.Csp_App_Other_UserRecord[] csp_App_Other_UserRecordSet,
           java.lang.String param_Id_User) {
           this.csp_App_Other_UserRecordSet = csp_App_Other_UserRecordSet;
           this.param_Id_User = param_Id_User;
    }


    /**
     * Gets the csp_App_Other_UserRecordSet value for this Csp_App_Other_UserBlock.
     * 
     * @return csp_App_Other_UserRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_App_Other_UserRecord[] getCsp_App_Other_UserRecordSet() {
        return csp_App_Other_UserRecordSet;
    }


    /**
     * Sets the csp_App_Other_UserRecordSet value for this Csp_App_Other_UserBlock.
     * 
     * @param csp_App_Other_UserRecordSet
     */
    public void setCsp_App_Other_UserRecordSet(com.portalmobile.meta4.schemas.types.Csp_App_Other_UserRecord[] csp_App_Other_UserRecordSet) {
        this.csp_App_Other_UserRecordSet = csp_App_Other_UserRecordSet;
    }


    /**
     * Gets the param_Id_User value for this Csp_App_Other_UserBlock.
     * 
     * @return param_Id_User
     */
    public java.lang.String getParam_Id_User() {
        return param_Id_User;
    }


    /**
     * Sets the param_Id_User value for this Csp_App_Other_UserBlock.
     * 
     * @param param_Id_User
     */
    public void setParam_Id_User(java.lang.String param_Id_User) {
        this.param_Id_User = param_Id_User;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_App_Other_UserBlock)) return false;
        Csp_App_Other_UserBlock other = (Csp_App_Other_UserBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_App_Other_UserRecordSet==null && other.getCsp_App_Other_UserRecordSet()==null) || 
             (this.csp_App_Other_UserRecordSet!=null &&
              java.util.Arrays.equals(this.csp_App_Other_UserRecordSet, other.getCsp_App_Other_UserRecordSet()))) &&
            ((this.param_Id_User==null && other.getParam_Id_User()==null) || 
             (this.param_Id_User!=null &&
              this.param_Id_User.equals(other.getParam_Id_User())));
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
        if (getCsp_App_Other_UserRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_App_Other_UserRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_App_Other_UserRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParam_Id_User() != null) {
            _hashCode += getParam_Id_User().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_App_Other_UserBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_Other_UserBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_App_Other_UserRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_App_Other_UserRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_Other_UserRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param_Id_User");
        elemField.setXmlName(new javax.xml.namespace.QName("", "param_Id_User"));
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
