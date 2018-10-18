/**
 * Csp_Mbl_Get_Absentismos_TodayBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Get_Absentismos_TodayBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayRecord[] csp_Mbl_Get_Absentismos_TodayRecordSet;

    private java.lang.String p_Id_Empleado;

    public Csp_Mbl_Get_Absentismos_TodayBlock() {
    }

    public Csp_Mbl_Get_Absentismos_TodayBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayRecord[] csp_Mbl_Get_Absentismos_TodayRecordSet,
           java.lang.String p_Id_Empleado) {
           this.csp_Mbl_Get_Absentismos_TodayRecordSet = csp_Mbl_Get_Absentismos_TodayRecordSet;
           this.p_Id_Empleado = p_Id_Empleado;
    }


    /**
     * Gets the csp_Mbl_Get_Absentismos_TodayRecordSet value for this Csp_Mbl_Get_Absentismos_TodayBlock.
     * 
     * @return csp_Mbl_Get_Absentismos_TodayRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayRecord[] getCsp_Mbl_Get_Absentismos_TodayRecordSet() {
        return csp_Mbl_Get_Absentismos_TodayRecordSet;
    }


    /**
     * Sets the csp_Mbl_Get_Absentismos_TodayRecordSet value for this Csp_Mbl_Get_Absentismos_TodayBlock.
     * 
     * @param csp_Mbl_Get_Absentismos_TodayRecordSet
     */
    public void setCsp_Mbl_Get_Absentismos_TodayRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Get_Absentismos_TodayRecord[] csp_Mbl_Get_Absentismos_TodayRecordSet) {
        this.csp_Mbl_Get_Absentismos_TodayRecordSet = csp_Mbl_Get_Absentismos_TodayRecordSet;
    }


    /**
     * Gets the p_Id_Empleado value for this Csp_Mbl_Get_Absentismos_TodayBlock.
     * 
     * @return p_Id_Empleado
     */
    public java.lang.String getP_Id_Empleado() {
        return p_Id_Empleado;
    }


    /**
     * Sets the p_Id_Empleado value for this Csp_Mbl_Get_Absentismos_TodayBlock.
     * 
     * @param p_Id_Empleado
     */
    public void setP_Id_Empleado(java.lang.String p_Id_Empleado) {
        this.p_Id_Empleado = p_Id_Empleado;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Get_Absentismos_TodayBlock)) return false;
        Csp_Mbl_Get_Absentismos_TodayBlock other = (Csp_Mbl_Get_Absentismos_TodayBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mbl_Get_Absentismos_TodayRecordSet==null && other.getCsp_Mbl_Get_Absentismos_TodayRecordSet()==null) || 
             (this.csp_Mbl_Get_Absentismos_TodayRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Get_Absentismos_TodayRecordSet, other.getCsp_Mbl_Get_Absentismos_TodayRecordSet()))) &&
            ((this.p_Id_Empleado==null && other.getP_Id_Empleado()==null) || 
             (this.p_Id_Empleado!=null &&
              this.p_Id_Empleado.equals(other.getP_Id_Empleado())));
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
        if (getCsp_Mbl_Get_Absentismos_TodayRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Get_Absentismos_TodayRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Get_Absentismos_TodayRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getP_Id_Empleado() != null) {
            _hashCode += getP_Id_Empleado().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Get_Absentismos_TodayBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Get_Absentismos_TodayBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Get_Absentismos_TodayRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Get_Absentismos_TodayRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Get_Absentismos_TodayRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_Id_Empleado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "p_Id_Empleado"));
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
