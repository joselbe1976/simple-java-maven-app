/**
 * Csp_Mbl_Soap_EssBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Soap_EssBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssRecord[] csp_Mbl_Soap_EssRecordSet;

    private java.lang.Double private_Clc_Units;

    private java.lang.String private_Format_Fecha;

    private java.lang.String private_Get_Extension;

    private java.lang.String private_Get_Mes_Literal;

    private java.lang.String seg_Clc_Password;

    public Csp_Mbl_Soap_EssBlock() {
    }

    public Csp_Mbl_Soap_EssBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssRecord[] csp_Mbl_Soap_EssRecordSet,
           java.lang.Double private_Clc_Units,
           java.lang.String private_Format_Fecha,
           java.lang.String private_Get_Extension,
           java.lang.String private_Get_Mes_Literal,
           java.lang.String seg_Clc_Password) {
           this.csp_Mbl_Soap_EssRecordSet = csp_Mbl_Soap_EssRecordSet;
           this.private_Clc_Units = private_Clc_Units;
           this.private_Format_Fecha = private_Format_Fecha;
           this.private_Get_Extension = private_Get_Extension;
           this.private_Get_Mes_Literal = private_Get_Mes_Literal;
           this.seg_Clc_Password = seg_Clc_Password;
    }


    /**
     * Gets the csp_Mbl_Soap_EssRecordSet value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @return csp_Mbl_Soap_EssRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssRecord[] getCsp_Mbl_Soap_EssRecordSet() {
        return csp_Mbl_Soap_EssRecordSet;
    }


    /**
     * Sets the csp_Mbl_Soap_EssRecordSet value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @param csp_Mbl_Soap_EssRecordSet
     */
    public void setCsp_Mbl_Soap_EssRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_EssRecord[] csp_Mbl_Soap_EssRecordSet) {
        this.csp_Mbl_Soap_EssRecordSet = csp_Mbl_Soap_EssRecordSet;
    }


    /**
     * Gets the private_Clc_Units value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @return private_Clc_Units
     */
    public java.lang.Double getPrivate_Clc_Units() {
        return private_Clc_Units;
    }


    /**
     * Sets the private_Clc_Units value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @param private_Clc_Units
     */
    public void setPrivate_Clc_Units(java.lang.Double private_Clc_Units) {
        this.private_Clc_Units = private_Clc_Units;
    }


    /**
     * Gets the private_Format_Fecha value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @return private_Format_Fecha
     */
    public java.lang.String getPrivate_Format_Fecha() {
        return private_Format_Fecha;
    }


    /**
     * Sets the private_Format_Fecha value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @param private_Format_Fecha
     */
    public void setPrivate_Format_Fecha(java.lang.String private_Format_Fecha) {
        this.private_Format_Fecha = private_Format_Fecha;
    }


    /**
     * Gets the private_Get_Extension value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @return private_Get_Extension
     */
    public java.lang.String getPrivate_Get_Extension() {
        return private_Get_Extension;
    }


    /**
     * Sets the private_Get_Extension value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @param private_Get_Extension
     */
    public void setPrivate_Get_Extension(java.lang.String private_Get_Extension) {
        this.private_Get_Extension = private_Get_Extension;
    }


    /**
     * Gets the private_Get_Mes_Literal value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @return private_Get_Mes_Literal
     */
    public java.lang.String getPrivate_Get_Mes_Literal() {
        return private_Get_Mes_Literal;
    }


    /**
     * Sets the private_Get_Mes_Literal value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @param private_Get_Mes_Literal
     */
    public void setPrivate_Get_Mes_Literal(java.lang.String private_Get_Mes_Literal) {
        this.private_Get_Mes_Literal = private_Get_Mes_Literal;
    }


    /**
     * Gets the seg_Clc_Password value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @return seg_Clc_Password
     */
    public java.lang.String getSeg_Clc_Password() {
        return seg_Clc_Password;
    }


    /**
     * Sets the seg_Clc_Password value for this Csp_Mbl_Soap_EssBlock.
     * 
     * @param seg_Clc_Password
     */
    public void setSeg_Clc_Password(java.lang.String seg_Clc_Password) {
        this.seg_Clc_Password = seg_Clc_Password;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Soap_EssBlock)) return false;
        Csp_Mbl_Soap_EssBlock other = (Csp_Mbl_Soap_EssBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mbl_Soap_EssRecordSet==null && other.getCsp_Mbl_Soap_EssRecordSet()==null) || 
             (this.csp_Mbl_Soap_EssRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Soap_EssRecordSet, other.getCsp_Mbl_Soap_EssRecordSet()))) &&
            ((this.private_Clc_Units==null && other.getPrivate_Clc_Units()==null) || 
             (this.private_Clc_Units!=null &&
              this.private_Clc_Units.equals(other.getPrivate_Clc_Units()))) &&
            ((this.private_Format_Fecha==null && other.getPrivate_Format_Fecha()==null) || 
             (this.private_Format_Fecha!=null &&
              this.private_Format_Fecha.equals(other.getPrivate_Format_Fecha()))) &&
            ((this.private_Get_Extension==null && other.getPrivate_Get_Extension()==null) || 
             (this.private_Get_Extension!=null &&
              this.private_Get_Extension.equals(other.getPrivate_Get_Extension()))) &&
            ((this.private_Get_Mes_Literal==null && other.getPrivate_Get_Mes_Literal()==null) || 
             (this.private_Get_Mes_Literal!=null &&
              this.private_Get_Mes_Literal.equals(other.getPrivate_Get_Mes_Literal()))) &&
            ((this.seg_Clc_Password==null && other.getSeg_Clc_Password()==null) || 
             (this.seg_Clc_Password!=null &&
              this.seg_Clc_Password.equals(other.getSeg_Clc_Password())));
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
        if (getCsp_Mbl_Soap_EssRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Soap_EssRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Soap_EssRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPrivate_Clc_Units() != null) {
            _hashCode += getPrivate_Clc_Units().hashCode();
        }
        if (getPrivate_Format_Fecha() != null) {
            _hashCode += getPrivate_Format_Fecha().hashCode();
        }
        if (getPrivate_Get_Extension() != null) {
            _hashCode += getPrivate_Get_Extension().hashCode();
        }
        if (getPrivate_Get_Mes_Literal() != null) {
            _hashCode += getPrivate_Get_Mes_Literal().hashCode();
        }
        if (getSeg_Clc_Password() != null) {
            _hashCode += getSeg_Clc_Password().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Soap_EssBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EssBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Soap_EssRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Soap_EssRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_EssRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("private_Clc_Units");
        elemField.setXmlName(new javax.xml.namespace.QName("", "private_Clc_Units"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("private_Format_Fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "private_Format_Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("private_Get_Extension");
        elemField.setXmlName(new javax.xml.namespace.QName("", "private_Get_Extension"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("private_Get_Mes_Literal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "private_Get_Mes_Literal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("seg_Clc_Password");
        elemField.setXmlName(new javax.xml.namespace.QName("", "seg_Clc_Password"));
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
