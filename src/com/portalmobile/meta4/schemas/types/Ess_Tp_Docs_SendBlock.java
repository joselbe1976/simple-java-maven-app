/**
 * Ess_Tp_Docs_SendBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Tp_Docs_SendBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendRecord[] ess_Tp_Docs_SendRecordSet;

    public Ess_Tp_Docs_SendBlock() {
    }

    public Ess_Tp_Docs_SendBlock(
           com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendRecord[] ess_Tp_Docs_SendRecordSet) {
           this.ess_Tp_Docs_SendRecordSet = ess_Tp_Docs_SendRecordSet;
    }


    /**
     * Gets the ess_Tp_Docs_SendRecordSet value for this Ess_Tp_Docs_SendBlock.
     * 
     * @return ess_Tp_Docs_SendRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendRecord[] getEss_Tp_Docs_SendRecordSet() {
        return ess_Tp_Docs_SendRecordSet;
    }


    /**
     * Sets the ess_Tp_Docs_SendRecordSet value for this Ess_Tp_Docs_SendBlock.
     * 
     * @param ess_Tp_Docs_SendRecordSet
     */
    public void setEss_Tp_Docs_SendRecordSet(com.portalmobile.meta4.schemas.types.Ess_Tp_Docs_SendRecord[] ess_Tp_Docs_SendRecordSet) {
        this.ess_Tp_Docs_SendRecordSet = ess_Tp_Docs_SendRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Tp_Docs_SendBlock)) return false;
        Ess_Tp_Docs_SendBlock other = (Ess_Tp_Docs_SendBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Tp_Docs_SendRecordSet==null && other.getEss_Tp_Docs_SendRecordSet()==null) || 
             (this.ess_Tp_Docs_SendRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Tp_Docs_SendRecordSet, other.getEss_Tp_Docs_SendRecordSet())));
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
        if (getEss_Tp_Docs_SendRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Tp_Docs_SendRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Tp_Docs_SendRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Ess_Tp_Docs_SendBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Tp_Docs_SendBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Tp_Docs_SendRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Tp_Docs_SendRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Tp_Docs_SendRecord"));
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
