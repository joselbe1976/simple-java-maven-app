/**
 * Csp_Mbl_MenusBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_MenusBlock  implements java.io.Serializable {
    private java.lang.String csp_Id_Tp_Dispositivo;

    private com.portalmobile.meta4.schemas.types.Csp_Mbl_MenusRecord[] csp_Mbl_MenusRecordSet;

    private java.lang.String csp_Role_Seguridad;

    public Csp_Mbl_MenusBlock() {
    }

    public Csp_Mbl_MenusBlock(
           java.lang.String csp_Id_Tp_Dispositivo,
           com.portalmobile.meta4.schemas.types.Csp_Mbl_MenusRecord[] csp_Mbl_MenusRecordSet,
           java.lang.String csp_Role_Seguridad) {
           this.csp_Id_Tp_Dispositivo = csp_Id_Tp_Dispositivo;
           this.csp_Mbl_MenusRecordSet = csp_Mbl_MenusRecordSet;
           this.csp_Role_Seguridad = csp_Role_Seguridad;
    }


    /**
     * Gets the csp_Id_Tp_Dispositivo value for this Csp_Mbl_MenusBlock.
     * 
     * @return csp_Id_Tp_Dispositivo
     */
    public java.lang.String getCsp_Id_Tp_Dispositivo() {
        return csp_Id_Tp_Dispositivo;
    }


    /**
     * Sets the csp_Id_Tp_Dispositivo value for this Csp_Mbl_MenusBlock.
     * 
     * @param csp_Id_Tp_Dispositivo
     */
    public void setCsp_Id_Tp_Dispositivo(java.lang.String csp_Id_Tp_Dispositivo) {
        this.csp_Id_Tp_Dispositivo = csp_Id_Tp_Dispositivo;
    }


    /**
     * Gets the csp_Mbl_MenusRecordSet value for this Csp_Mbl_MenusBlock.
     * 
     * @return csp_Mbl_MenusRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_MenusRecord[] getCsp_Mbl_MenusRecordSet() {
        return csp_Mbl_MenusRecordSet;
    }


    /**
     * Sets the csp_Mbl_MenusRecordSet value for this Csp_Mbl_MenusBlock.
     * 
     * @param csp_Mbl_MenusRecordSet
     */
    public void setCsp_Mbl_MenusRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_MenusRecord[] csp_Mbl_MenusRecordSet) {
        this.csp_Mbl_MenusRecordSet = csp_Mbl_MenusRecordSet;
    }


    /**
     * Gets the csp_Role_Seguridad value for this Csp_Mbl_MenusBlock.
     * 
     * @return csp_Role_Seguridad
     */
    public java.lang.String getCsp_Role_Seguridad() {
        return csp_Role_Seguridad;
    }


    /**
     * Sets the csp_Role_Seguridad value for this Csp_Mbl_MenusBlock.
     * 
     * @param csp_Role_Seguridad
     */
    public void setCsp_Role_Seguridad(java.lang.String csp_Role_Seguridad) {
        this.csp_Role_Seguridad = csp_Role_Seguridad;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_MenusBlock)) return false;
        Csp_Mbl_MenusBlock other = (Csp_Mbl_MenusBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Id_Tp_Dispositivo==null && other.getCsp_Id_Tp_Dispositivo()==null) || 
             (this.csp_Id_Tp_Dispositivo!=null &&
              this.csp_Id_Tp_Dispositivo.equals(other.getCsp_Id_Tp_Dispositivo()))) &&
            ((this.csp_Mbl_MenusRecordSet==null && other.getCsp_Mbl_MenusRecordSet()==null) || 
             (this.csp_Mbl_MenusRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_MenusRecordSet, other.getCsp_Mbl_MenusRecordSet()))) &&
            ((this.csp_Role_Seguridad==null && other.getCsp_Role_Seguridad()==null) || 
             (this.csp_Role_Seguridad!=null &&
              this.csp_Role_Seguridad.equals(other.getCsp_Role_Seguridad())));
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
        if (getCsp_Id_Tp_Dispositivo() != null) {
            _hashCode += getCsp_Id_Tp_Dispositivo().hashCode();
        }
        if (getCsp_Mbl_MenusRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_MenusRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_MenusRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCsp_Role_Seguridad() != null) {
            _hashCode += getCsp_Role_Seguridad().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Mbl_MenusBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_MenusBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Id_Tp_Dispositivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Id_Tp_Dispositivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_MenusRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_MenusRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_MenusRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Role_Seguridad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Role_Seguridad"));
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
