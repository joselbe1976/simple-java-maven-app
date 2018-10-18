/**
 * Csp_Mbl_Inf_AbsBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Inf_AbsBlock  implements java.io.Serializable {
    private java.lang.String arg_Id_Empleado;

    private java.lang.Double arg_Or_Hr_Period;

    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsRecord[] csp_Mbl_Inf_AbsRecordSet;

    public Csp_Mbl_Inf_AbsBlock() {
    }

    public Csp_Mbl_Inf_AbsBlock(
           java.lang.String arg_Id_Empleado,
           java.lang.Double arg_Or_Hr_Period,
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsRecord[] csp_Mbl_Inf_AbsRecordSet) {
           this.arg_Id_Empleado = arg_Id_Empleado;
           this.arg_Or_Hr_Period = arg_Or_Hr_Period;
           this.csp_Mbl_Inf_AbsRecordSet = csp_Mbl_Inf_AbsRecordSet;
    }


    /**
     * Gets the arg_Id_Empleado value for this Csp_Mbl_Inf_AbsBlock.
     * 
     * @return arg_Id_Empleado
     */
    public java.lang.String getArg_Id_Empleado() {
        return arg_Id_Empleado;
    }


    /**
     * Sets the arg_Id_Empleado value for this Csp_Mbl_Inf_AbsBlock.
     * 
     * @param arg_Id_Empleado
     */
    public void setArg_Id_Empleado(java.lang.String arg_Id_Empleado) {
        this.arg_Id_Empleado = arg_Id_Empleado;
    }


    /**
     * Gets the arg_Or_Hr_Period value for this Csp_Mbl_Inf_AbsBlock.
     * 
     * @return arg_Or_Hr_Period
     */
    public java.lang.Double getArg_Or_Hr_Period() {
        return arg_Or_Hr_Period;
    }


    /**
     * Sets the arg_Or_Hr_Period value for this Csp_Mbl_Inf_AbsBlock.
     * 
     * @param arg_Or_Hr_Period
     */
    public void setArg_Or_Hr_Period(java.lang.Double arg_Or_Hr_Period) {
        this.arg_Or_Hr_Period = arg_Or_Hr_Period;
    }


    /**
     * Gets the csp_Mbl_Inf_AbsRecordSet value for this Csp_Mbl_Inf_AbsBlock.
     * 
     * @return csp_Mbl_Inf_AbsRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsRecord[] getCsp_Mbl_Inf_AbsRecordSet() {
        return csp_Mbl_Inf_AbsRecordSet;
    }


    /**
     * Sets the csp_Mbl_Inf_AbsRecordSet value for this Csp_Mbl_Inf_AbsBlock.
     * 
     * @param csp_Mbl_Inf_AbsRecordSet
     */
    public void setCsp_Mbl_Inf_AbsRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Inf_AbsRecord[] csp_Mbl_Inf_AbsRecordSet) {
        this.csp_Mbl_Inf_AbsRecordSet = csp_Mbl_Inf_AbsRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Inf_AbsBlock)) return false;
        Csp_Mbl_Inf_AbsBlock other = (Csp_Mbl_Inf_AbsBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.arg_Id_Empleado==null && other.getArg_Id_Empleado()==null) || 
             (this.arg_Id_Empleado!=null &&
              this.arg_Id_Empleado.equals(other.getArg_Id_Empleado()))) &&
            ((this.arg_Or_Hr_Period==null && other.getArg_Or_Hr_Period()==null) || 
             (this.arg_Or_Hr_Period!=null &&
              this.arg_Or_Hr_Period.equals(other.getArg_Or_Hr_Period()))) &&
            ((this.csp_Mbl_Inf_AbsRecordSet==null && other.getCsp_Mbl_Inf_AbsRecordSet()==null) || 
             (this.csp_Mbl_Inf_AbsRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Inf_AbsRecordSet, other.getCsp_Mbl_Inf_AbsRecordSet())));
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
        if (getArg_Id_Empleado() != null) {
            _hashCode += getArg_Id_Empleado().hashCode();
        }
        if (getArg_Or_Hr_Period() != null) {
            _hashCode += getArg_Or_Hr_Period().hashCode();
        }
        if (getCsp_Mbl_Inf_AbsRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Inf_AbsRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Inf_AbsRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Inf_AbsBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Inf_AbsBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg_Id_Empleado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg_Id_Empleado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("arg_Or_Hr_Period");
        elemField.setXmlName(new javax.xml.namespace.QName("", "arg_Or_Hr_Period"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Inf_AbsRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Inf_AbsRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Inf_AbsRecord"));
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
