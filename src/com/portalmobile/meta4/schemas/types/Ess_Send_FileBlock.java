/**
 * Ess_Send_FileBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Send_FileBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Ess_Send_FileRecord[] ess_Send_FileRecordSet;

    private javax.activation.DataHandler node_File;

    public Ess_Send_FileBlock() {
    }

    public Ess_Send_FileBlock(
           com.portalmobile.meta4.schemas.types.Ess_Send_FileRecord[] ess_Send_FileRecordSet,
           javax.activation.DataHandler node_File) {
           this.ess_Send_FileRecordSet = ess_Send_FileRecordSet;
           this.node_File = node_File;
    }


    /**
     * Gets the ess_Send_FileRecordSet value for this Ess_Send_FileBlock.
     * 
     * @return ess_Send_FileRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Ess_Send_FileRecord[] getEss_Send_FileRecordSet() {
        return ess_Send_FileRecordSet;
    }


    /**
     * Sets the ess_Send_FileRecordSet value for this Ess_Send_FileBlock.
     * 
     * @param ess_Send_FileRecordSet
     */
    public void setEss_Send_FileRecordSet(com.portalmobile.meta4.schemas.types.Ess_Send_FileRecord[] ess_Send_FileRecordSet) {
        this.ess_Send_FileRecordSet = ess_Send_FileRecordSet;
    }


    /**
     * Gets the node_File value for this Ess_Send_FileBlock.
     * 
     * @return node_File
     */
    public javax.activation.DataHandler getNode_File() {
        return node_File;
    }


    /**
     * Sets the node_File value for this Ess_Send_FileBlock.
     * 
     * @param node_File
     */
    public void setNode_File(javax.activation.DataHandler node_File) {
        this.node_File = node_File;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Send_FileBlock)) return false;
        Ess_Send_FileBlock other = (Ess_Send_FileBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ess_Send_FileRecordSet==null && other.getEss_Send_FileRecordSet()==null) || 
             (this.ess_Send_FileRecordSet!=null &&
              java.util.Arrays.equals(this.ess_Send_FileRecordSet, other.getEss_Send_FileRecordSet()))) &&
            ((this.node_File==null && other.getNode_File()==null) || 
             (this.node_File!=null &&
              this.node_File.equals(other.getNode_File())));
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
        if (getEss_Send_FileRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEss_Send_FileRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEss_Send_FileRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNode_File() != null) {
            _hashCode += getNode_File().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ess_Send_FileBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_FileBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ess_Send_FileRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ess_Send_FileRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Send_FileRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("node_File");
        elemField.setXmlName(new javax.xml.namespace.QName("", "node_File"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "DataHandler"));
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
