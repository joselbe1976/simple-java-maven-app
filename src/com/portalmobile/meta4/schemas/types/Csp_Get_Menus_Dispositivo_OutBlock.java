/**
 * Csp_Get_Menus_Dispositivo_OutBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Get_Menus_Dispositivo_OutBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutRecord[] csp_Get_Menus_Dispositivo_OutRecordSet;

    public Csp_Get_Menus_Dispositivo_OutBlock() {
    }

    public Csp_Get_Menus_Dispositivo_OutBlock(
           com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutRecord[] csp_Get_Menus_Dispositivo_OutRecordSet) {
           this.csp_Get_Menus_Dispositivo_OutRecordSet = csp_Get_Menus_Dispositivo_OutRecordSet;
    }


    /**
     * Gets the csp_Get_Menus_Dispositivo_OutRecordSet value for this Csp_Get_Menus_Dispositivo_OutBlock.
     * 
     * @return csp_Get_Menus_Dispositivo_OutRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutRecord[] getCsp_Get_Menus_Dispositivo_OutRecordSet() {
        return csp_Get_Menus_Dispositivo_OutRecordSet;
    }


    /**
     * Sets the csp_Get_Menus_Dispositivo_OutRecordSet value for this Csp_Get_Menus_Dispositivo_OutBlock.
     * 
     * @param csp_Get_Menus_Dispositivo_OutRecordSet
     */
    public void setCsp_Get_Menus_Dispositivo_OutRecordSet(com.portalmobile.meta4.schemas.types.Csp_Get_Menus_Dispositivo_OutRecord[] csp_Get_Menus_Dispositivo_OutRecordSet) {
        this.csp_Get_Menus_Dispositivo_OutRecordSet = csp_Get_Menus_Dispositivo_OutRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Get_Menus_Dispositivo_OutBlock)) return false;
        Csp_Get_Menus_Dispositivo_OutBlock other = (Csp_Get_Menus_Dispositivo_OutBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Get_Menus_Dispositivo_OutRecordSet==null && other.getCsp_Get_Menus_Dispositivo_OutRecordSet()==null) || 
             (this.csp_Get_Menus_Dispositivo_OutRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Get_Menus_Dispositivo_OutRecordSet, other.getCsp_Get_Menus_Dispositivo_OutRecordSet())));
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
        if (getCsp_Get_Menus_Dispositivo_OutRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Get_Menus_Dispositivo_OutRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Get_Menus_Dispositivo_OutRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Get_Menus_Dispositivo_OutBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Menus_Dispositivo_OutBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Get_Menus_Dispositivo_OutRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Get_Menus_Dispositivo_OutRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Menus_Dispositivo_OutRecord"));
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
