/**
 * Mss_Get_Mis_Consultas_ParsBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Mss_Get_Mis_Consultas_ParsBlock  implements java.io.Serializable {
    private java.lang.String id_Meta4Object;

    private com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ParsRecord[] mss_Get_Mis_Consultas_ParsRecordSet;

    public Mss_Get_Mis_Consultas_ParsBlock() {
    }

    public Mss_Get_Mis_Consultas_ParsBlock(
           java.lang.String id_Meta4Object,
           com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ParsRecord[] mss_Get_Mis_Consultas_ParsRecordSet) {
           this.id_Meta4Object = id_Meta4Object;
           this.mss_Get_Mis_Consultas_ParsRecordSet = mss_Get_Mis_Consultas_ParsRecordSet;
    }


    /**
     * Gets the id_Meta4Object value for this Mss_Get_Mis_Consultas_ParsBlock.
     * 
     * @return id_Meta4Object
     */
    public java.lang.String getId_Meta4Object() {
        return id_Meta4Object;
    }


    /**
     * Sets the id_Meta4Object value for this Mss_Get_Mis_Consultas_ParsBlock.
     * 
     * @param id_Meta4Object
     */
    public void setId_Meta4Object(java.lang.String id_Meta4Object) {
        this.id_Meta4Object = id_Meta4Object;
    }


    /**
     * Gets the mss_Get_Mis_Consultas_ParsRecordSet value for this Mss_Get_Mis_Consultas_ParsBlock.
     * 
     * @return mss_Get_Mis_Consultas_ParsRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ParsRecord[] getMss_Get_Mis_Consultas_ParsRecordSet() {
        return mss_Get_Mis_Consultas_ParsRecordSet;
    }


    /**
     * Sets the mss_Get_Mis_Consultas_ParsRecordSet value for this Mss_Get_Mis_Consultas_ParsBlock.
     * 
     * @param mss_Get_Mis_Consultas_ParsRecordSet
     */
    public void setMss_Get_Mis_Consultas_ParsRecordSet(com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ParsRecord[] mss_Get_Mis_Consultas_ParsRecordSet) {
        this.mss_Get_Mis_Consultas_ParsRecordSet = mss_Get_Mis_Consultas_ParsRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mss_Get_Mis_Consultas_ParsBlock)) return false;
        Mss_Get_Mis_Consultas_ParsBlock other = (Mss_Get_Mis_Consultas_ParsBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id_Meta4Object==null && other.getId_Meta4Object()==null) || 
             (this.id_Meta4Object!=null &&
              this.id_Meta4Object.equals(other.getId_Meta4Object()))) &&
            ((this.mss_Get_Mis_Consultas_ParsRecordSet==null && other.getMss_Get_Mis_Consultas_ParsRecordSet()==null) || 
             (this.mss_Get_Mis_Consultas_ParsRecordSet!=null &&
              java.util.Arrays.equals(this.mss_Get_Mis_Consultas_ParsRecordSet, other.getMss_Get_Mis_Consultas_ParsRecordSet())));
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
        if (getId_Meta4Object() != null) {
            _hashCode += getId_Meta4Object().hashCode();
        }
        if (getMss_Get_Mis_Consultas_ParsRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMss_Get_Mis_Consultas_ParsRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMss_Get_Mis_Consultas_ParsRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Mss_Get_Mis_Consultas_ParsBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ParsBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_Meta4Object");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id_Meta4Object"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mss_Get_Mis_Consultas_ParsRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mss_Get_Mis_Consultas_ParsRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ParsRecord"));
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
