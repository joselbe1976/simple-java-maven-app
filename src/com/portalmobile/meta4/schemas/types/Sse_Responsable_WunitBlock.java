/**
 * Sse_Responsable_WunitBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Sse_Responsable_WunitBlock  implements java.io.Serializable {
    private java.lang.String filter_Id_Wunit;

    private com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitRecord[] sse_Responsable_WunitRecordSet;

    public Sse_Responsable_WunitBlock() {
    }

    public Sse_Responsable_WunitBlock(
           java.lang.String filter_Id_Wunit,
           com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitRecord[] sse_Responsable_WunitRecordSet) {
           this.filter_Id_Wunit = filter_Id_Wunit;
           this.sse_Responsable_WunitRecordSet = sse_Responsable_WunitRecordSet;
    }


    /**
     * Gets the filter_Id_Wunit value for this Sse_Responsable_WunitBlock.
     * 
     * @return filter_Id_Wunit
     */
    public java.lang.String getFilter_Id_Wunit() {
        return filter_Id_Wunit;
    }


    /**
     * Sets the filter_Id_Wunit value for this Sse_Responsable_WunitBlock.
     * 
     * @param filter_Id_Wunit
     */
    public void setFilter_Id_Wunit(java.lang.String filter_Id_Wunit) {
        this.filter_Id_Wunit = filter_Id_Wunit;
    }


    /**
     * Gets the sse_Responsable_WunitRecordSet value for this Sse_Responsable_WunitBlock.
     * 
     * @return sse_Responsable_WunitRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitRecord[] getSse_Responsable_WunitRecordSet() {
        return sse_Responsable_WunitRecordSet;
    }


    /**
     * Sets the sse_Responsable_WunitRecordSet value for this Sse_Responsable_WunitBlock.
     * 
     * @param sse_Responsable_WunitRecordSet
     */
    public void setSse_Responsable_WunitRecordSet(com.portalmobile.meta4.schemas.types.Sse_Responsable_WunitRecord[] sse_Responsable_WunitRecordSet) {
        this.sse_Responsable_WunitRecordSet = sse_Responsable_WunitRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Sse_Responsable_WunitBlock)) return false;
        Sse_Responsable_WunitBlock other = (Sse_Responsable_WunitBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filter_Id_Wunit==null && other.getFilter_Id_Wunit()==null) || 
             (this.filter_Id_Wunit!=null &&
              this.filter_Id_Wunit.equals(other.getFilter_Id_Wunit()))) &&
            ((this.sse_Responsable_WunitRecordSet==null && other.getSse_Responsable_WunitRecordSet()==null) || 
             (this.sse_Responsable_WunitRecordSet!=null &&
              java.util.Arrays.equals(this.sse_Responsable_WunitRecordSet, other.getSse_Responsable_WunitRecordSet())));
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
        if (getFilter_Id_Wunit() != null) {
            _hashCode += getFilter_Id_Wunit().hashCode();
        }
        if (getSse_Responsable_WunitRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getSse_Responsable_WunitRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getSse_Responsable_WunitRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Sse_Responsable_WunitBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Sse_Responsable_WunitBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter_Id_Wunit");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filter_Id_Wunit"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sse_Responsable_WunitRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sse_Responsable_WunitRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Sse_Responsable_WunitRecord"));
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
