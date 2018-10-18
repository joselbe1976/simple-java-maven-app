/**
 * Ess_Get_Noticias_DataBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Get_Noticias_DataBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataRecord[] ess_Get_Noticias_DataRecordSet;

    public Ess_Get_Noticias_DataBlock() {
    }

    public Ess_Get_Noticias_DataBlock(
           com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataRecord[] ess_Get_Noticias_DataRecordSet) {
           this.ess_Get_Noticias_DataRecordSet = ess_Get_Noticias_DataRecordSet;
    }


    /**
     * Gets the ess_Get_Noticias_DataRecordSet value for this Ess_Get_Noticias_DataBlock.
     * 
     * @return ess_Get_Noticias_DataRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataRecord[] getEss_Get_Noticias_DataRecordSet() {
        return ess_Get_Noticias_DataRecordSet;
    }


    /**
     * Sets the ess_Get_Noticias_DataRecordSet value for this Ess_Get_Noticias_DataBlock.
     * 
     * @param ess_Get_Noticias_DataRecordSet
     */
    public void setEss_Get_Noticias_DataRecordSet(com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_DataRecord[] ess_Get_Noticias_DataRecordSet) {
        this.ess_Get_Noticias_DataRecordSet = ess_Get_Noticias_DataRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Get_Noticias_DataBlock)) return false;
        Ess_Get_Noticias_DataBlock other = (Ess_Get_Noticias_DataBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Get_Noticias_DataRecordSet==null && other.getEss_Get_Noticias_DataRecordSet()==null) || 
             (this.ess_Get_Noticias_DataRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Get_Noticias_DataRecordSet, other.getEss_Get_Noticias_DataRecordSet())));
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
        if (getEss_Get_Noticias_DataRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Get_Noticias_DataRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Get_Noticias_DataRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Ess_Get_Noticias_DataBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_DataBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Get_Noticias_DataRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Get_Noticias_DataRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_DataRecord"));
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
