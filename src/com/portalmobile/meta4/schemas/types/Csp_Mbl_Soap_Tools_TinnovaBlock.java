/**
 * Csp_Mbl_Soap_Tools_TinnovaBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Soap_Tools_TinnovaBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaRecord[] csp_Mbl_Soap_Tools_TinnovaRecordSet;

    public Csp_Mbl_Soap_Tools_TinnovaBlock() {
    }

    public Csp_Mbl_Soap_Tools_TinnovaBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaRecord[] csp_Mbl_Soap_Tools_TinnovaRecordSet) {
           this.csp_Mbl_Soap_Tools_TinnovaRecordSet = csp_Mbl_Soap_Tools_TinnovaRecordSet;
    }


    /**
     * Gets the csp_Mbl_Soap_Tools_TinnovaRecordSet value for this Csp_Mbl_Soap_Tools_TinnovaBlock.
     * 
     * @return csp_Mbl_Soap_Tools_TinnovaRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaRecord[] getCsp_Mbl_Soap_Tools_TinnovaRecordSet() {
        return csp_Mbl_Soap_Tools_TinnovaRecordSet;
    }


    /**
     * Sets the csp_Mbl_Soap_Tools_TinnovaRecordSet value for this Csp_Mbl_Soap_Tools_TinnovaBlock.
     * 
     * @param csp_Mbl_Soap_Tools_TinnovaRecordSet
     */
    public void setCsp_Mbl_Soap_Tools_TinnovaRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_Tools_TinnovaRecord[] csp_Mbl_Soap_Tools_TinnovaRecordSet) {
        this.csp_Mbl_Soap_Tools_TinnovaRecordSet = csp_Mbl_Soap_Tools_TinnovaRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Soap_Tools_TinnovaBlock)) return false;
        Csp_Mbl_Soap_Tools_TinnovaBlock other = (Csp_Mbl_Soap_Tools_TinnovaBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mbl_Soap_Tools_TinnovaRecordSet==null && other.getCsp_Mbl_Soap_Tools_TinnovaRecordSet()==null) || 
             (this.csp_Mbl_Soap_Tools_TinnovaRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Soap_Tools_TinnovaRecordSet, other.getCsp_Mbl_Soap_Tools_TinnovaRecordSet())));
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
        if (getCsp_Mbl_Soap_Tools_TinnovaRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Soap_Tools_TinnovaRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Soap_Tools_TinnovaRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Soap_Tools_TinnovaBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_Tools_TinnovaBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Soap_Tools_TinnovaRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Soap_Tools_TinnovaRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_Tools_TinnovaRecord"));
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
