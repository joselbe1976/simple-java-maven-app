/**
 * Ess_Get_Tp_Documents_ResultBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Get_Tp_Documents_ResultBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultRecord[] ess_Get_Tp_Documents_ResultRecordSet;

    public Ess_Get_Tp_Documents_ResultBlock() {
    }

    public Ess_Get_Tp_Documents_ResultBlock(
           com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultRecord[] ess_Get_Tp_Documents_ResultRecordSet) {
           this.ess_Get_Tp_Documents_ResultRecordSet = ess_Get_Tp_Documents_ResultRecordSet;
    }


    /**
     * Gets the ess_Get_Tp_Documents_ResultRecordSet value for this Ess_Get_Tp_Documents_ResultBlock.
     * 
     * @return ess_Get_Tp_Documents_ResultRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultRecord[] getEss_Get_Tp_Documents_ResultRecordSet() {
        return ess_Get_Tp_Documents_ResultRecordSet;
    }


    /**
     * Sets the ess_Get_Tp_Documents_ResultRecordSet value for this Ess_Get_Tp_Documents_ResultBlock.
     * 
     * @param ess_Get_Tp_Documents_ResultRecordSet
     */
    public void setEss_Get_Tp_Documents_ResultRecordSet(com.portalmobile.meta4.schemas.types.Ess_Get_Tp_Documents_ResultRecord[] ess_Get_Tp_Documents_ResultRecordSet) {
        this.ess_Get_Tp_Documents_ResultRecordSet = ess_Get_Tp_Documents_ResultRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Get_Tp_Documents_ResultBlock)) return false;
        Ess_Get_Tp_Documents_ResultBlock other = (Ess_Get_Tp_Documents_ResultBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Get_Tp_Documents_ResultRecordSet==null && other.getEss_Get_Tp_Documents_ResultRecordSet()==null) || 
             (this.ess_Get_Tp_Documents_ResultRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Get_Tp_Documents_ResultRecordSet, other.getEss_Get_Tp_Documents_ResultRecordSet())));
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
        if (getEss_Get_Tp_Documents_ResultRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Get_Tp_Documents_ResultRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Get_Tp_Documents_ResultRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Ess_Get_Tp_Documents_ResultBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Tp_Documents_ResultBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Get_Tp_Documents_ResultRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Get_Tp_Documents_ResultRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Tp_Documents_ResultRecord"));
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
