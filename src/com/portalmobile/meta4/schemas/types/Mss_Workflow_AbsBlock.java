/**
 * Mss_Workflow_AbsBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Mss_Workflow_AbsBlock  implements java.io.Serializable {
    private java.lang.String filter_Id_Hr;

    private java.lang.Double filter_Ordinal;

    private com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsRecord[] mss_Workflow_AbsRecordSet;

    public Mss_Workflow_AbsBlock() {
    }

    public Mss_Workflow_AbsBlock(
           java.lang.String filter_Id_Hr,
           java.lang.Double filter_Ordinal,
           com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsRecord[] mss_Workflow_AbsRecordSet) {
           this.filter_Id_Hr = filter_Id_Hr;
           this.filter_Ordinal = filter_Ordinal;
           this.mss_Workflow_AbsRecordSet = mss_Workflow_AbsRecordSet;
    }


    /**
     * Gets the filter_Id_Hr value for this Mss_Workflow_AbsBlock.
     * 
     * @return filter_Id_Hr
     */
    public java.lang.String getFilter_Id_Hr() {
        return filter_Id_Hr;
    }


    /**
     * Sets the filter_Id_Hr value for this Mss_Workflow_AbsBlock.
     * 
     * @param filter_Id_Hr
     */
    public void setFilter_Id_Hr(java.lang.String filter_Id_Hr) {
        this.filter_Id_Hr = filter_Id_Hr;
    }


    /**
     * Gets the filter_Ordinal value for this Mss_Workflow_AbsBlock.
     * 
     * @return filter_Ordinal
     */
    public java.lang.Double getFilter_Ordinal() {
        return filter_Ordinal;
    }


    /**
     * Sets the filter_Ordinal value for this Mss_Workflow_AbsBlock.
     * 
     * @param filter_Ordinal
     */
    public void setFilter_Ordinal(java.lang.Double filter_Ordinal) {
        this.filter_Ordinal = filter_Ordinal;
    }


    /**
     * Gets the mss_Workflow_AbsRecordSet value for this Mss_Workflow_AbsBlock.
     * 
     * @return mss_Workflow_AbsRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsRecord[] getMss_Workflow_AbsRecordSet() {
        return mss_Workflow_AbsRecordSet;
    }


    /**
     * Sets the mss_Workflow_AbsRecordSet value for this Mss_Workflow_AbsBlock.
     * 
     * @param mss_Workflow_AbsRecordSet
     */
    public void setMss_Workflow_AbsRecordSet(com.portalmobile.meta4.schemas.types.Mss_Workflow_AbsRecord[] mss_Workflow_AbsRecordSet) {
        this.mss_Workflow_AbsRecordSet = mss_Workflow_AbsRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mss_Workflow_AbsBlock)) return false;
        Mss_Workflow_AbsBlock other = (Mss_Workflow_AbsBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.filter_Id_Hr==null && other.getFilter_Id_Hr()==null) || 
             (this.filter_Id_Hr!=null &&
              this.filter_Id_Hr.equals(other.getFilter_Id_Hr()))) &&
            ((this.filter_Ordinal==null && other.getFilter_Ordinal()==null) || 
             (this.filter_Ordinal!=null &&
              this.filter_Ordinal.equals(other.getFilter_Ordinal()))) &&
            ((this.mss_Workflow_AbsRecordSet==null && other.getMss_Workflow_AbsRecordSet()==null) || 
             (this.mss_Workflow_AbsRecordSet!=null &&
              java.util.Arrays.equals(this.mss_Workflow_AbsRecordSet, other.getMss_Workflow_AbsRecordSet())));
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
        if (getFilter_Id_Hr() != null) {
            _hashCode += getFilter_Id_Hr().hashCode();
        }
        if (getFilter_Ordinal() != null) {
            _hashCode += getFilter_Ordinal().hashCode();
        }
        if (getMss_Workflow_AbsRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMss_Workflow_AbsRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMss_Workflow_AbsRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Mss_Workflow_AbsBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Workflow_AbsBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter_Id_Hr");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filter_Id_Hr"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("filter_Ordinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "filter_Ordinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mss_Workflow_AbsRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mss_Workflow_AbsRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Workflow_AbsRecord"));
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
