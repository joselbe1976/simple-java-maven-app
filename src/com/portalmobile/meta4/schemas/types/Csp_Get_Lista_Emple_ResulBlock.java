/**
 * Csp_Get_Lista_Emple_ResulBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Get_Lista_Emple_ResulBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulRecord[] csp_Get_Lista_Emple_ResulRecordSet;

    private java.lang.Double total_Registros;

    public Csp_Get_Lista_Emple_ResulBlock() {
    }

    public Csp_Get_Lista_Emple_ResulBlock(
           com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulRecord[] csp_Get_Lista_Emple_ResulRecordSet,
           java.lang.Double total_Registros) {
           this.csp_Get_Lista_Emple_ResulRecordSet = csp_Get_Lista_Emple_ResulRecordSet;
           this.total_Registros = total_Registros;
    }


    /**
     * Gets the csp_Get_Lista_Emple_ResulRecordSet value for this Csp_Get_Lista_Emple_ResulBlock.
     * 
     * @return csp_Get_Lista_Emple_ResulRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulRecord[] getCsp_Get_Lista_Emple_ResulRecordSet() {
        return csp_Get_Lista_Emple_ResulRecordSet;
    }


    /**
     * Sets the csp_Get_Lista_Emple_ResulRecordSet value for this Csp_Get_Lista_Emple_ResulBlock.
     * 
     * @param csp_Get_Lista_Emple_ResulRecordSet
     */
    public void setCsp_Get_Lista_Emple_ResulRecordSet(com.portalmobile.meta4.schemas.types.Csp_Get_Lista_Emple_ResulRecord[] csp_Get_Lista_Emple_ResulRecordSet) {
        this.csp_Get_Lista_Emple_ResulRecordSet = csp_Get_Lista_Emple_ResulRecordSet;
    }


    /**
     * Gets the total_Registros value for this Csp_Get_Lista_Emple_ResulBlock.
     * 
     * @return total_Registros
     */
    public java.lang.Double getTotal_Registros() {
        return total_Registros;
    }


    /**
     * Sets the total_Registros value for this Csp_Get_Lista_Emple_ResulBlock.
     * 
     * @param total_Registros
     */
    public void setTotal_Registros(java.lang.Double total_Registros) {
        this.total_Registros = total_Registros;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Get_Lista_Emple_ResulBlock)) return false;
        Csp_Get_Lista_Emple_ResulBlock other = (Csp_Get_Lista_Emple_ResulBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Get_Lista_Emple_ResulRecordSet==null && other.getCsp_Get_Lista_Emple_ResulRecordSet()==null) || 
             (this.csp_Get_Lista_Emple_ResulRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Get_Lista_Emple_ResulRecordSet, other.getCsp_Get_Lista_Emple_ResulRecordSet()))) &&
            ((this.total_Registros==null && other.getTotal_Registros()==null) || 
             (this.total_Registros!=null &&
              this.total_Registros.equals(other.getTotal_Registros())));
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
        if (getCsp_Get_Lista_Emple_ResulRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Get_Lista_Emple_ResulRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Get_Lista_Emple_ResulRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTotal_Registros() != null) {
            _hashCode += getTotal_Registros().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Get_Lista_Emple_ResulBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Lista_Emple_ResulBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Get_Lista_Emple_ResulRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Get_Lista_Emple_ResulRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Lista_Emple_ResulRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_Registros");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total_Registros"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
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
