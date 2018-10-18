/**
 * Csp_Get_File_Real_OutBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Get_File_Real_OutBlock  implements java.io.Serializable {
    private java.lang.String csp_Extension;

    private javax.activation.DataHandler csp_File;

    private com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutRecord[] csp_Get_File_Real_OutRecordSet;

    private java.lang.Double ordinal;

    public Csp_Get_File_Real_OutBlock() {
    }

    public Csp_Get_File_Real_OutBlock(
           java.lang.String csp_Extension,
           javax.activation.DataHandler csp_File,
           com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutRecord[] csp_Get_File_Real_OutRecordSet,
           java.lang.Double ordinal) {
           this.csp_Extension = csp_Extension;
           this.csp_File = csp_File;
           this.csp_Get_File_Real_OutRecordSet = csp_Get_File_Real_OutRecordSet;
           this.ordinal = ordinal;
    }


    /**
     * Gets the csp_Extension value for this Csp_Get_File_Real_OutBlock.
     * 
     * @return csp_Extension
     */
    public java.lang.String getCsp_Extension() {
        return csp_Extension;
    }


    /**
     * Sets the csp_Extension value for this Csp_Get_File_Real_OutBlock.
     * 
     * @param csp_Extension
     */
    public void setCsp_Extension(java.lang.String csp_Extension) {
        this.csp_Extension = csp_Extension;
    }


    /**
     * Gets the csp_File value for this Csp_Get_File_Real_OutBlock.
     * 
     * @return csp_File
     */
    public javax.activation.DataHandler getCsp_File() {
        return csp_File;
    }


    /**
     * Sets the csp_File value for this Csp_Get_File_Real_OutBlock.
     * 
     * @param csp_File
     */
    public void setCsp_File(javax.activation.DataHandler csp_File) {
        this.csp_File = csp_File;
    }


    /**
     * Gets the csp_Get_File_Real_OutRecordSet value for this Csp_Get_File_Real_OutBlock.
     * 
     * @return csp_Get_File_Real_OutRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutRecord[] getCsp_Get_File_Real_OutRecordSet() {
        return csp_Get_File_Real_OutRecordSet;
    }


    /**
     * Sets the csp_Get_File_Real_OutRecordSet value for this Csp_Get_File_Real_OutBlock.
     * 
     * @param csp_Get_File_Real_OutRecordSet
     */
    public void setCsp_Get_File_Real_OutRecordSet(com.portalmobile.meta4.schemas.types.Csp_Get_File_Real_OutRecord[] csp_Get_File_Real_OutRecordSet) {
        this.csp_Get_File_Real_OutRecordSet = csp_Get_File_Real_OutRecordSet;
    }


    /**
     * Gets the ordinal value for this Csp_Get_File_Real_OutBlock.
     * 
     * @return ordinal
     */
    public java.lang.Double getOrdinal() {
        return ordinal;
    }


    /**
     * Sets the ordinal value for this Csp_Get_File_Real_OutBlock.
     * 
     * @param ordinal
     */
    public void setOrdinal(java.lang.Double ordinal) {
        this.ordinal = ordinal;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Get_File_Real_OutBlock)) return false;
        Csp_Get_File_Real_OutBlock other = (Csp_Get_File_Real_OutBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Extension==null && other.getCsp_Extension()==null) || 
             (this.csp_Extension!=null &&
              this.csp_Extension.equals(other.getCsp_Extension()))) &&
            ((this.csp_File==null && other.getCsp_File()==null) || 
             (this.csp_File!=null &&
              this.csp_File.equals(other.getCsp_File()))) &&
            ((this.csp_Get_File_Real_OutRecordSet==null && other.getCsp_Get_File_Real_OutRecordSet()==null) || 
             (this.csp_Get_File_Real_OutRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Get_File_Real_OutRecordSet, other.getCsp_Get_File_Real_OutRecordSet()))) &&
            ((this.ordinal==null && other.getOrdinal()==null) || 
             (this.ordinal!=null &&
              this.ordinal.equals(other.getOrdinal())));
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
        if (getCsp_Extension() != null) {
            _hashCode += getCsp_Extension().hashCode();
        }
        if (getCsp_File() != null) {
            _hashCode += getCsp_File().hashCode();
        }
        if (getCsp_Get_File_Real_OutRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Get_File_Real_OutRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Get_File_Real_OutRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getOrdinal() != null) {
            _hashCode += getOrdinal().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Get_File_Real_OutBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_File_Real_OutBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Extension");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_File");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_File"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "DataHandler"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Get_File_Real_OutRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Get_File_Real_OutRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_File_Real_OutRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordinal"));
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
