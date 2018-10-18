/**
 * Csp_Get_Fecha_OutBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Get_Fecha_OutBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutRecord[] csp_Get_Fecha_OutRecordSet;

    private java.lang.String fecha;

    private java.lang.String nombre;

    public Csp_Get_Fecha_OutBlock() {
    }

    public Csp_Get_Fecha_OutBlock(
           com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutRecord[] csp_Get_Fecha_OutRecordSet,
           java.lang.String fecha,
           java.lang.String nombre) {
           this.csp_Get_Fecha_OutRecordSet = csp_Get_Fecha_OutRecordSet;
           this.fecha = fecha;
           this.nombre = nombre;
    }


    /**
     * Gets the csp_Get_Fecha_OutRecordSet value for this Csp_Get_Fecha_OutBlock.
     * 
     * @return csp_Get_Fecha_OutRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutRecord[] getCsp_Get_Fecha_OutRecordSet() {
        return csp_Get_Fecha_OutRecordSet;
    }


    /**
     * Sets the csp_Get_Fecha_OutRecordSet value for this Csp_Get_Fecha_OutBlock.
     * 
     * @param csp_Get_Fecha_OutRecordSet
     */
    public void setCsp_Get_Fecha_OutRecordSet(com.portalmobile.meta4.schemas.types.Csp_Get_Fecha_OutRecord[] csp_Get_Fecha_OutRecordSet) {
        this.csp_Get_Fecha_OutRecordSet = csp_Get_Fecha_OutRecordSet;
    }


    /**
     * Gets the fecha value for this Csp_Get_Fecha_OutBlock.
     * 
     * @return fecha
     */
    public java.lang.String getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this Csp_Get_Fecha_OutBlock.
     * 
     * @param fecha
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the nombre value for this Csp_Get_Fecha_OutBlock.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Csp_Get_Fecha_OutBlock.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Get_Fecha_OutBlock)) return false;
        Csp_Get_Fecha_OutBlock other = (Csp_Get_Fecha_OutBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Get_Fecha_OutRecordSet==null && other.getCsp_Get_Fecha_OutRecordSet()==null) || 
             (this.csp_Get_Fecha_OutRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Get_Fecha_OutRecordSet, other.getCsp_Get_Fecha_OutRecordSet()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre())));
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
        if (getCsp_Get_Fecha_OutRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Get_Fecha_OutRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Get_Fecha_OutRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Get_Fecha_OutBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Fecha_OutBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Get_Fecha_OutRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Get_Fecha_OutRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Fecha_OutRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
