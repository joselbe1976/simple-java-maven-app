/**
 * Csp_Mbl_Roles_UsrBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Roles_UsrBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Roles_UsrRecord[] csp_Mbl_Roles_UsrRecordSet;

    public Csp_Mbl_Roles_UsrBlock() {
    }

    public Csp_Mbl_Roles_UsrBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Roles_UsrRecord[] csp_Mbl_Roles_UsrRecordSet) {
           this.csp_Mbl_Roles_UsrRecordSet = csp_Mbl_Roles_UsrRecordSet;
    }


    /**
     * Gets the csp_Mbl_Roles_UsrRecordSet value for this Csp_Mbl_Roles_UsrBlock.
     * 
     * @return csp_Mbl_Roles_UsrRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Roles_UsrRecord[] getCsp_Mbl_Roles_UsrRecordSet() {
        return csp_Mbl_Roles_UsrRecordSet;
    }


    /**
     * Sets the csp_Mbl_Roles_UsrRecordSet value for this Csp_Mbl_Roles_UsrBlock.
     * 
     * @param csp_Mbl_Roles_UsrRecordSet
     */
    public void setCsp_Mbl_Roles_UsrRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Roles_UsrRecord[] csp_Mbl_Roles_UsrRecordSet) {
        this.csp_Mbl_Roles_UsrRecordSet = csp_Mbl_Roles_UsrRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Roles_UsrBlock)) return false;
        Csp_Mbl_Roles_UsrBlock other = (Csp_Mbl_Roles_UsrBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mbl_Roles_UsrRecordSet==null && other.getCsp_Mbl_Roles_UsrRecordSet()==null) || 
             (this.csp_Mbl_Roles_UsrRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Roles_UsrRecordSet, other.getCsp_Mbl_Roles_UsrRecordSet())));
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
        if (getCsp_Mbl_Roles_UsrRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Roles_UsrRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Roles_UsrRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Roles_UsrBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Roles_UsrBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Roles_UsrRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Roles_UsrRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Roles_UsrRecord"));
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
