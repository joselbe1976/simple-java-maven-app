/**
 * Mss_Get_Mis_Consultas_ResultBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Mss_Get_Mis_Consultas_ResultBlock  implements java.io.Serializable {
    private javax.activation.DataHandler blob_Excel_Consulta;

    private com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultRecord[] mss_Get_Mis_Consultas_ResultRecordSet;

    public Mss_Get_Mis_Consultas_ResultBlock() {
    }

    public Mss_Get_Mis_Consultas_ResultBlock(
           javax.activation.DataHandler blob_Excel_Consulta,
           com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultRecord[] mss_Get_Mis_Consultas_ResultRecordSet) {
           this.blob_Excel_Consulta = blob_Excel_Consulta;
           this.mss_Get_Mis_Consultas_ResultRecordSet = mss_Get_Mis_Consultas_ResultRecordSet;
    }


    /**
     * Gets the blob_Excel_Consulta value for this Mss_Get_Mis_Consultas_ResultBlock.
     * 
     * @return blob_Excel_Consulta
     */
    public javax.activation.DataHandler getBlob_Excel_Consulta() {
        return blob_Excel_Consulta;
    }


    /**
     * Sets the blob_Excel_Consulta value for this Mss_Get_Mis_Consultas_ResultBlock.
     * 
     * @param blob_Excel_Consulta
     */
    public void setBlob_Excel_Consulta(javax.activation.DataHandler blob_Excel_Consulta) {
        this.blob_Excel_Consulta = blob_Excel_Consulta;
    }


    /**
     * Gets the mss_Get_Mis_Consultas_ResultRecordSet value for this Mss_Get_Mis_Consultas_ResultBlock.
     * 
     * @return mss_Get_Mis_Consultas_ResultRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultRecord[] getMss_Get_Mis_Consultas_ResultRecordSet() {
        return mss_Get_Mis_Consultas_ResultRecordSet;
    }


    /**
     * Sets the mss_Get_Mis_Consultas_ResultRecordSet value for this Mss_Get_Mis_Consultas_ResultBlock.
     * 
     * @param mss_Get_Mis_Consultas_ResultRecordSet
     */
    public void setMss_Get_Mis_Consultas_ResultRecordSet(com.portalmobile.meta4.schemas.types.Mss_Get_Mis_Consultas_ResultRecord[] mss_Get_Mis_Consultas_ResultRecordSet) {
        this.mss_Get_Mis_Consultas_ResultRecordSet = mss_Get_Mis_Consultas_ResultRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mss_Get_Mis_Consultas_ResultBlock)) return false;
        Mss_Get_Mis_Consultas_ResultBlock other = (Mss_Get_Mis_Consultas_ResultBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.blob_Excel_Consulta==null && other.getBlob_Excel_Consulta()==null) || 
             (this.blob_Excel_Consulta!=null &&
              this.blob_Excel_Consulta.equals(other.getBlob_Excel_Consulta()))) &&
            ((this.mss_Get_Mis_Consultas_ResultRecordSet==null && other.getMss_Get_Mis_Consultas_ResultRecordSet()==null) || 
             (this.mss_Get_Mis_Consultas_ResultRecordSet!=null &&
              java.util.Arrays.equals(this.mss_Get_Mis_Consultas_ResultRecordSet, other.getMss_Get_Mis_Consultas_ResultRecordSet())));
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
        if (getBlob_Excel_Consulta() != null) {
            _hashCode += getBlob_Excel_Consulta().hashCode();
        }
        if (getMss_Get_Mis_Consultas_ResultRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMss_Get_Mis_Consultas_ResultRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMss_Get_Mis_Consultas_ResultRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Mss_Get_Mis_Consultas_ResultBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ResultBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("blob_Excel_Consulta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "blob_Excel_Consulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "DataHandler"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mss_Get_Mis_Consultas_ResultRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mss_Get_Mis_Consultas_ResultRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_ResultRecord"));
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
