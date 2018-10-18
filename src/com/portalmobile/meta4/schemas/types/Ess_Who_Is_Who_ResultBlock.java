/**
 * Ess_Who_Is_Who_ResultBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Who_Is_Who_ResultBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultRecord[] ess_Who_Is_Who_ResultRecordSet;

    private java.lang.Double total_Reg;

    public Ess_Who_Is_Who_ResultBlock() {
    }

    public Ess_Who_Is_Who_ResultBlock(
           com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultRecord[] ess_Who_Is_Who_ResultRecordSet,
           java.lang.Double total_Reg) {
           this.ess_Who_Is_Who_ResultRecordSet = ess_Who_Is_Who_ResultRecordSet;
           this.total_Reg = total_Reg;
    }


    /**
     * Gets the ess_Who_Is_Who_ResultRecordSet value for this Ess_Who_Is_Who_ResultBlock.
     * 
     * @return ess_Who_Is_Who_ResultRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultRecord[] getEss_Who_Is_Who_ResultRecordSet() {
        return ess_Who_Is_Who_ResultRecordSet;
    }


    /**
     * Sets the ess_Who_Is_Who_ResultRecordSet value for this Ess_Who_Is_Who_ResultBlock.
     * 
     * @param ess_Who_Is_Who_ResultRecordSet
     */
    public void setEss_Who_Is_Who_ResultRecordSet(com.portalmobile.meta4.schemas.types.Ess_Who_Is_Who_ResultRecord[] ess_Who_Is_Who_ResultRecordSet) {
        this.ess_Who_Is_Who_ResultRecordSet = ess_Who_Is_Who_ResultRecordSet;
    }


    /**
     * Gets the total_Reg value for this Ess_Who_Is_Who_ResultBlock.
     * 
     * @return total_Reg
     */
    public java.lang.Double getTotal_Reg() {
        return total_Reg;
    }


    /**
     * Sets the total_Reg value for this Ess_Who_Is_Who_ResultBlock.
     * 
     * @param total_Reg
     */
    public void setTotal_Reg(java.lang.Double total_Reg) {
        this.total_Reg = total_Reg;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Who_Is_Who_ResultBlock)) return false;
        Ess_Who_Is_Who_ResultBlock other = (Ess_Who_Is_Who_ResultBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Who_Is_Who_ResultRecordSet==null && other.getEss_Who_Is_Who_ResultRecordSet()==null) || 
             (this.ess_Who_Is_Who_ResultRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Who_Is_Who_ResultRecordSet, other.getEss_Who_Is_Who_ResultRecordSet()))) &&
            ((this.total_Reg==null && other.getTotal_Reg()==null) || 
             (this.total_Reg!=null &&
              this.total_Reg.equals(other.getTotal_Reg())));
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
        if (getEss_Who_Is_Who_ResultRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Who_Is_Who_ResultRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Who_Is_Who_ResultRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTotal_Reg() != null) {
            _hashCode += getTotal_Reg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ess_Who_Is_Who_ResultBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_ResultBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Who_Is_Who_ResultRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Who_Is_Who_ResultRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Who_Is_Who_ResultRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("total_Reg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "total_Reg"));
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
