/**
 * Mss_Get_Absentismos_ResultBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Mss_Get_Absentismos_ResultBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultRecord[] mss_Get_Absentismos_ResultRecordSet;

    public Mss_Get_Absentismos_ResultBlock() {
    }

    public Mss_Get_Absentismos_ResultBlock(
           com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultRecord[] mss_Get_Absentismos_ResultRecordSet) {
           this.mss_Get_Absentismos_ResultRecordSet = mss_Get_Absentismos_ResultRecordSet;
    }


    /**
     * Gets the mss_Get_Absentismos_ResultRecordSet value for this Mss_Get_Absentismos_ResultBlock.
     * 
     * @return mss_Get_Absentismos_ResultRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultRecord[] getMss_Get_Absentismos_ResultRecordSet() {
        return mss_Get_Absentismos_ResultRecordSet;
    }


    /**
     * Sets the mss_Get_Absentismos_ResultRecordSet value for this Mss_Get_Absentismos_ResultBlock.
     * 
     * @param mss_Get_Absentismos_ResultRecordSet
     */
    public void setMss_Get_Absentismos_ResultRecordSet(com.portalmobile.meta4.schemas.types.Mss_Get_Absentismos_ResultRecord[] mss_Get_Absentismos_ResultRecordSet) {
        this.mss_Get_Absentismos_ResultRecordSet = mss_Get_Absentismos_ResultRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mss_Get_Absentismos_ResultBlock)) return false;
        Mss_Get_Absentismos_ResultBlock other = (Mss_Get_Absentismos_ResultBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.mss_Get_Absentismos_ResultRecordSet==null && other.getMss_Get_Absentismos_ResultRecordSet()==null) || 
             (this.mss_Get_Absentismos_ResultRecordSet!=null &&
              java.util.Arrays.equals(this.mss_Get_Absentismos_ResultRecordSet, other.getMss_Get_Absentismos_ResultRecordSet())));
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
        if (getMss_Get_Absentismos_ResultRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMss_Get_Absentismos_ResultRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMss_Get_Absentismos_ResultRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Mss_Get_Absentismos_ResultBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_ResultBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mss_Get_Absentismos_ResultRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mss_Get_Absentismos_ResultRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Absentismos_ResultRecord"));
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
