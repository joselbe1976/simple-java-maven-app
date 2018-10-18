/**
 * Mss_Get_Mis_Consultas_EngineRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Mss_Get_Mis_Consultas_EngineRecord  implements java.io.Serializable {
    private java.lang.String id_Parametro;

    private java.lang.String m4AutoGeneratedRecordID;

    private boolean m4AutoGeneratedToDelete;

    private java.lang.String tipo_Dato;

    private java.lang.String value;

    public Mss_Get_Mis_Consultas_EngineRecord() {
    }

    public Mss_Get_Mis_Consultas_EngineRecord(
           java.lang.String id_Parametro,
           java.lang.String m4AutoGeneratedRecordID,
           boolean m4AutoGeneratedToDelete,
           java.lang.String tipo_Dato,
           java.lang.String value) {
           this.id_Parametro = id_Parametro;
           this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
           this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
           this.tipo_Dato = tipo_Dato;
           this.value = value;
    }


    /**
     * Gets the id_Parametro value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @return id_Parametro
     */
    public java.lang.String getId_Parametro() {
        return id_Parametro;
    }


    /**
     * Sets the id_Parametro value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @param id_Parametro
     */
    public void setId_Parametro(java.lang.String id_Parametro) {
        this.id_Parametro = id_Parametro;
    }


    /**
     * Gets the m4AutoGeneratedRecordID value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @return m4AutoGeneratedRecordID
     */
    public java.lang.String getM4AutoGeneratedRecordID() {
        return m4AutoGeneratedRecordID;
    }


    /**
     * Sets the m4AutoGeneratedRecordID value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @param m4AutoGeneratedRecordID
     */
    public void setM4AutoGeneratedRecordID(java.lang.String m4AutoGeneratedRecordID) {
        this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
    }


    /**
     * Gets the m4AutoGeneratedToDelete value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @return m4AutoGeneratedToDelete
     */
    public boolean isM4AutoGeneratedToDelete() {
        return m4AutoGeneratedToDelete;
    }


    /**
     * Sets the m4AutoGeneratedToDelete value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @param m4AutoGeneratedToDelete
     */
    public void setM4AutoGeneratedToDelete(boolean m4AutoGeneratedToDelete) {
        this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
    }


    /**
     * Gets the tipo_Dato value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @return tipo_Dato
     */
    public java.lang.String getTipo_Dato() {
        return tipo_Dato;
    }


    /**
     * Sets the tipo_Dato value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @param tipo_Dato
     */
    public void setTipo_Dato(java.lang.String tipo_Dato) {
        this.tipo_Dato = tipo_Dato;
    }


    /**
     * Gets the value value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @return value
     */
    public java.lang.String getValue() {
        return value;
    }


    /**
     * Sets the value value for this Mss_Get_Mis_Consultas_EngineRecord.
     * 
     * @param value
     */
    public void setValue(java.lang.String value) {
        this.value = value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Mss_Get_Mis_Consultas_EngineRecord)) return false;
        Mss_Get_Mis_Consultas_EngineRecord other = (Mss_Get_Mis_Consultas_EngineRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.id_Parametro==null && other.getId_Parametro()==null) || 
             (this.id_Parametro!=null &&
              this.id_Parametro.equals(other.getId_Parametro()))) &&
            ((this.m4AutoGeneratedRecordID==null && other.getM4AutoGeneratedRecordID()==null) || 
             (this.m4AutoGeneratedRecordID!=null &&
              this.m4AutoGeneratedRecordID.equals(other.getM4AutoGeneratedRecordID()))) &&
            this.m4AutoGeneratedToDelete == other.isM4AutoGeneratedToDelete() &&
            ((this.tipo_Dato==null && other.getTipo_Dato()==null) || 
             (this.tipo_Dato!=null &&
              this.tipo_Dato.equals(other.getTipo_Dato()))) &&
            ((this.value==null && other.getValue()==null) || 
             (this.value!=null &&
              this.value.equals(other.getValue())));
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
        if (getId_Parametro() != null) {
            _hashCode += getId_Parametro().hashCode();
        }
        if (getM4AutoGeneratedRecordID() != null) {
            _hashCode += getM4AutoGeneratedRecordID().hashCode();
        }
        _hashCode += (isM4AutoGeneratedToDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getTipo_Dato() != null) {
            _hashCode += getTipo_Dato().hashCode();
        }
        if (getValue() != null) {
            _hashCode += getValue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Mss_Get_Mis_Consultas_EngineRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Mss_Get_Mis_Consultas_EngineRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_Parametro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id_Parametro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m4AutoGeneratedRecordID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m4AutoGeneratedRecordID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("m4AutoGeneratedToDelete");
        elemField.setXmlName(new javax.xml.namespace.QName("", "m4AutoGeneratedToDelete"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo_Dato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo_Dato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("value");
        elemField.setXmlName(new javax.xml.namespace.QName("", "value"));
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