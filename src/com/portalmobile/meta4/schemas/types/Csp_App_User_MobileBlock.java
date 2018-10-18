/**
 * Csp_App_User_MobileBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_App_User_MobileBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_App_User_MobileRecord[] csp_App_User_MobileRecordSet;

    public Csp_App_User_MobileBlock() {
    }

    public Csp_App_User_MobileBlock(
           com.portalmobile.meta4.schemas.types.Csp_App_User_MobileRecord[] csp_App_User_MobileRecordSet) {
           this.csp_App_User_MobileRecordSet = csp_App_User_MobileRecordSet;
    }


    /**
     * Gets the csp_App_User_MobileRecordSet value for this Csp_App_User_MobileBlock.
     * 
     * @return csp_App_User_MobileRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_App_User_MobileRecord[] getCsp_App_User_MobileRecordSet() {
        return csp_App_User_MobileRecordSet;
    }


    /**
     * Sets the csp_App_User_MobileRecordSet value for this Csp_App_User_MobileBlock.
     * 
     * @param csp_App_User_MobileRecordSet
     */
    public void setCsp_App_User_MobileRecordSet(com.portalmobile.meta4.schemas.types.Csp_App_User_MobileRecord[] csp_App_User_MobileRecordSet) {
        this.csp_App_User_MobileRecordSet = csp_App_User_MobileRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_App_User_MobileBlock)) return false;
        Csp_App_User_MobileBlock other = (Csp_App_User_MobileBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_App_User_MobileRecordSet==null && other.getCsp_App_User_MobileRecordSet()==null) || 
             (this.csp_App_User_MobileRecordSet!=null &&
              java.util.Arrays.equals(this.csp_App_User_MobileRecordSet, other.getCsp_App_User_MobileRecordSet())));
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
        if (getCsp_App_User_MobileRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_App_User_MobileRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_App_User_MobileRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_App_User_MobileBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_User_MobileBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_App_User_MobileRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_App_User_MobileRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_App_User_MobileRecord"));
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
