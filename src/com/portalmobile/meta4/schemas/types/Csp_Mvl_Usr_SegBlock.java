/**
 * Csp_Mvl_Usr_SegBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mvl_Usr_SegBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mvl_Usr_SegRecord[] csp_Mvl_Usr_SegRecordSet;

    public Csp_Mvl_Usr_SegBlock() {
    }

    public Csp_Mvl_Usr_SegBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mvl_Usr_SegRecord[] csp_Mvl_Usr_SegRecordSet) {
           this.csp_Mvl_Usr_SegRecordSet = csp_Mvl_Usr_SegRecordSet;
    }


    /**
     * Gets the csp_Mvl_Usr_SegRecordSet value for this Csp_Mvl_Usr_SegBlock.
     * 
     * @return csp_Mvl_Usr_SegRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mvl_Usr_SegRecord[] getCsp_Mvl_Usr_SegRecordSet() {
        return csp_Mvl_Usr_SegRecordSet;
    }


    /**
     * Sets the csp_Mvl_Usr_SegRecordSet value for this Csp_Mvl_Usr_SegBlock.
     * 
     * @param csp_Mvl_Usr_SegRecordSet
     */
    public void setCsp_Mvl_Usr_SegRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mvl_Usr_SegRecord[] csp_Mvl_Usr_SegRecordSet) {
        this.csp_Mvl_Usr_SegRecordSet = csp_Mvl_Usr_SegRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mvl_Usr_SegBlock)) return false;
        Csp_Mvl_Usr_SegBlock other = (Csp_Mvl_Usr_SegBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mvl_Usr_SegRecordSet==null && other.getCsp_Mvl_Usr_SegRecordSet()==null) || 
             (this.csp_Mvl_Usr_SegRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mvl_Usr_SegRecordSet, other.getCsp_Mvl_Usr_SegRecordSet())));
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
        if (getCsp_Mvl_Usr_SegRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mvl_Usr_SegRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mvl_Usr_SegRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Mvl_Usr_SegBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mvl_Usr_SegBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mvl_Usr_SegRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mvl_Usr_SegRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mvl_Usr_SegRecord"));
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
