/**
 * Csp_Mbl_Soap_EmpleadosBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Soap_EmpleadosBlock  implements java.io.Serializable {
    private java.lang.String csp_Ctrl_Nulls;

    private java.lang.String csp_Format_Fecha;

    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosRecord[] csp_Mbl_Soap_EmpleadosRecordSet;

    public Csp_Mbl_Soap_EmpleadosBlock() {
    }

    public Csp_Mbl_Soap_EmpleadosBlock(
           java.lang.String csp_Ctrl_Nulls,
           java.lang.String csp_Format_Fecha,
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosRecord[] csp_Mbl_Soap_EmpleadosRecordSet) {
           this.csp_Ctrl_Nulls = csp_Ctrl_Nulls;
           this.csp_Format_Fecha = csp_Format_Fecha;
           this.csp_Mbl_Soap_EmpleadosRecordSet = csp_Mbl_Soap_EmpleadosRecordSet;
    }


    /**
     * Gets the csp_Ctrl_Nulls value for this Csp_Mbl_Soap_EmpleadosBlock.
     * 
     * @return csp_Ctrl_Nulls
     */
    public java.lang.String getCsp_Ctrl_Nulls() {
        return csp_Ctrl_Nulls;
    }


    /**
     * Sets the csp_Ctrl_Nulls value for this Csp_Mbl_Soap_EmpleadosBlock.
     * 
     * @param csp_Ctrl_Nulls
     */
    public void setCsp_Ctrl_Nulls(java.lang.String csp_Ctrl_Nulls) {
        this.csp_Ctrl_Nulls = csp_Ctrl_Nulls;
    }


    /**
     * Gets the csp_Format_Fecha value for this Csp_Mbl_Soap_EmpleadosBlock.
     * 
     * @return csp_Format_Fecha
     */
    public java.lang.String getCsp_Format_Fecha() {
        return csp_Format_Fecha;
    }


    /**
     * Sets the csp_Format_Fecha value for this Csp_Mbl_Soap_EmpleadosBlock.
     * 
     * @param csp_Format_Fecha
     */
    public void setCsp_Format_Fecha(java.lang.String csp_Format_Fecha) {
        this.csp_Format_Fecha = csp_Format_Fecha;
    }


    /**
     * Gets the csp_Mbl_Soap_EmpleadosRecordSet value for this Csp_Mbl_Soap_EmpleadosBlock.
     * 
     * @return csp_Mbl_Soap_EmpleadosRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosRecord[] getCsp_Mbl_Soap_EmpleadosRecordSet() {
        return csp_Mbl_Soap_EmpleadosRecordSet;
    }


    /**
     * Sets the csp_Mbl_Soap_EmpleadosRecordSet value for this Csp_Mbl_Soap_EmpleadosBlock.
     * 
     * @param csp_Mbl_Soap_EmpleadosRecordSet
     */
    public void setCsp_Mbl_Soap_EmpleadosRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EmpleadosRecord[] csp_Mbl_Soap_EmpleadosRecordSet) {
        this.csp_Mbl_Soap_EmpleadosRecordSet = csp_Mbl_Soap_EmpleadosRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Soap_EmpleadosBlock)) return false;
        Csp_Mbl_Soap_EmpleadosBlock other = (Csp_Mbl_Soap_EmpleadosBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Ctrl_Nulls==null && other.getCsp_Ctrl_Nulls()==null) || 
             (this.csp_Ctrl_Nulls!=null &&
              this.csp_Ctrl_Nulls.equals(other.getCsp_Ctrl_Nulls()))) &&
            ((this.csp_Format_Fecha==null && other.getCsp_Format_Fecha()==null) || 
             (this.csp_Format_Fecha!=null &&
              this.csp_Format_Fecha.equals(other.getCsp_Format_Fecha()))) &&
            ((this.csp_Mbl_Soap_EmpleadosRecordSet==null && other.getCsp_Mbl_Soap_EmpleadosRecordSet()==null) || 
             (this.csp_Mbl_Soap_EmpleadosRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Soap_EmpleadosRecordSet, other.getCsp_Mbl_Soap_EmpleadosRecordSet())));
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
        if (getCsp_Ctrl_Nulls() != null) {
            _hashCode += getCsp_Ctrl_Nulls().hashCode();
        }
        if (getCsp_Format_Fecha() != null) {
            _hashCode += getCsp_Format_Fecha().hashCode();
        }
        if (getCsp_Mbl_Soap_EmpleadosRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Soap_EmpleadosRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Soap_EmpleadosRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Soap_EmpleadosBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EmpleadosBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Ctrl_Nulls");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Ctrl_Nulls"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Format_Fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Format_Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Soap_EmpleadosRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Soap_EmpleadosRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EmpleadosRecord"));
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
