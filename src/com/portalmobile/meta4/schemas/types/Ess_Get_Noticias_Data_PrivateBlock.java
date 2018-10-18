/**
 * Ess_Get_Noticias_Data_PrivateBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Get_Noticias_Data_PrivateBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateRecord[] ess_Get_Noticias_Data_PrivateRecordSet;

    public Ess_Get_Noticias_Data_PrivateBlock() {
    }

    public Ess_Get_Noticias_Data_PrivateBlock(
           com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateRecord[] ess_Get_Noticias_Data_PrivateRecordSet) {
           this.ess_Get_Noticias_Data_PrivateRecordSet = ess_Get_Noticias_Data_PrivateRecordSet;
    }


    /**
     * Gets the ess_Get_Noticias_Data_PrivateRecordSet value for this Ess_Get_Noticias_Data_PrivateBlock.
     * 
     * @return ess_Get_Noticias_Data_PrivateRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateRecord[] getEss_Get_Noticias_Data_PrivateRecordSet() {
        return ess_Get_Noticias_Data_PrivateRecordSet;
    }


    /**
     * Sets the ess_Get_Noticias_Data_PrivateRecordSet value for this Ess_Get_Noticias_Data_PrivateBlock.
     * 
     * @param ess_Get_Noticias_Data_PrivateRecordSet
     */
    public void setEss_Get_Noticias_Data_PrivateRecordSet(com.portalmobile.meta4.schemas.types.Ess_Get_Noticias_Data_PrivateRecord[] ess_Get_Noticias_Data_PrivateRecordSet) {
        this.ess_Get_Noticias_Data_PrivateRecordSet = ess_Get_Noticias_Data_PrivateRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Get_Noticias_Data_PrivateBlock)) return false;
        Ess_Get_Noticias_Data_PrivateBlock other = (Ess_Get_Noticias_Data_PrivateBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Get_Noticias_Data_PrivateRecordSet==null && other.getEss_Get_Noticias_Data_PrivateRecordSet()==null) || 
             (this.ess_Get_Noticias_Data_PrivateRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Get_Noticias_Data_PrivateRecordSet, other.getEss_Get_Noticias_Data_PrivateRecordSet())));
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
        if (getEss_Get_Noticias_Data_PrivateRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Get_Noticias_Data_PrivateRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Get_Noticias_Data_PrivateRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Ess_Get_Noticias_Data_PrivateBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_Data_PrivateBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Get_Noticias_Data_PrivateRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Get_Noticias_Data_PrivateRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_Data_PrivateRecord"));
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
