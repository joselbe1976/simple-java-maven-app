/**
 * Ess_Get_Recibos_Nomina_ResultRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Get_Recibos_Nomina_ResultRecord  implements java.io.Serializable {
    private java.lang.String anio;

    private java.lang.String fecha_Imputacion;

    private java.lang.String fecha_Pago;

    private java.lang.String m4AutoGeneratedRecordID;

    private boolean m4AutoGeneratedToDelete;

    private java.lang.String mes;

    private java.lang.String nombre_Paga;

    private javax.activation.DataHandler recibo;

    public Ess_Get_Recibos_Nomina_ResultRecord() {
    }

    public Ess_Get_Recibos_Nomina_ResultRecord(
           java.lang.String anio,
           java.lang.String fecha_Imputacion,
           java.lang.String fecha_Pago,
           java.lang.String m4AutoGeneratedRecordID,
           boolean m4AutoGeneratedToDelete,
           java.lang.String mes,
           java.lang.String nombre_Paga,
           javax.activation.DataHandler recibo) {
           this.anio = anio;
           this.fecha_Imputacion = fecha_Imputacion;
           this.fecha_Pago = fecha_Pago;
           this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
           this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
           this.mes = mes;
           this.nombre_Paga = nombre_Paga;
           this.recibo = recibo;
    }


    /**
     * Gets the anio value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @return anio
     */
    public java.lang.String getAnio() {
        return anio;
    }


    /**
     * Sets the anio value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @param anio
     */
    public void setAnio(java.lang.String anio) {
        this.anio = anio;
    }


    /**
     * Gets the fecha_Imputacion value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @return fecha_Imputacion
     */
    public java.lang.String getFecha_Imputacion() {
        return fecha_Imputacion;
    }


    /**
     * Sets the fecha_Imputacion value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @param fecha_Imputacion
     */
    public void setFecha_Imputacion(java.lang.String fecha_Imputacion) {
        this.fecha_Imputacion = fecha_Imputacion;
    }


    /**
     * Gets the fecha_Pago value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @return fecha_Pago
     */
    public java.lang.String getFecha_Pago() {
        return fecha_Pago;
    }


    /**
     * Sets the fecha_Pago value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @param fecha_Pago
     */
    public void setFecha_Pago(java.lang.String fecha_Pago) {
        this.fecha_Pago = fecha_Pago;
    }


    /**
     * Gets the m4AutoGeneratedRecordID value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @return m4AutoGeneratedRecordID
     */
    public java.lang.String getM4AutoGeneratedRecordID() {
        return m4AutoGeneratedRecordID;
    }


    /**
     * Sets the m4AutoGeneratedRecordID value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @param m4AutoGeneratedRecordID
     */
    public void setM4AutoGeneratedRecordID(java.lang.String m4AutoGeneratedRecordID) {
        this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
    }


    /**
     * Gets the m4AutoGeneratedToDelete value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @return m4AutoGeneratedToDelete
     */
    public boolean isM4AutoGeneratedToDelete() {
        return m4AutoGeneratedToDelete;
    }


    /**
     * Sets the m4AutoGeneratedToDelete value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @param m4AutoGeneratedToDelete
     */
    public void setM4AutoGeneratedToDelete(boolean m4AutoGeneratedToDelete) {
        this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
    }


    /**
     * Gets the mes value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @return mes
     */
    public java.lang.String getMes() {
        return mes;
    }


    /**
     * Sets the mes value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @param mes
     */
    public void setMes(java.lang.String mes) {
        this.mes = mes;
    }


    /**
     * Gets the nombre_Paga value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @return nombre_Paga
     */
    public java.lang.String getNombre_Paga() {
        return nombre_Paga;
    }


    /**
     * Sets the nombre_Paga value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @param nombre_Paga
     */
    public void setNombre_Paga(java.lang.String nombre_Paga) {
        this.nombre_Paga = nombre_Paga;
    }


    /**
     * Gets the recibo value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @return recibo
     */
    public javax.activation.DataHandler getRecibo() {
        return recibo;
    }


    /**
     * Sets the recibo value for this Ess_Get_Recibos_Nomina_ResultRecord.
     * 
     * @param recibo
     */
    public void setRecibo(javax.activation.DataHandler recibo) {
        this.recibo = recibo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Get_Recibos_Nomina_ResultRecord)) return false;
        Ess_Get_Recibos_Nomina_ResultRecord other = (Ess_Get_Recibos_Nomina_ResultRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.anio==null && other.getAnio()==null) || 
             (this.anio!=null &&
              this.anio.equals(other.getAnio()))) &&
            ((this.fecha_Imputacion==null && other.getFecha_Imputacion()==null) || 
             (this.fecha_Imputacion!=null &&
              this.fecha_Imputacion.equals(other.getFecha_Imputacion()))) &&
            ((this.fecha_Pago==null && other.getFecha_Pago()==null) || 
             (this.fecha_Pago!=null &&
              this.fecha_Pago.equals(other.getFecha_Pago()))) &&
            ((this.m4AutoGeneratedRecordID==null && other.getM4AutoGeneratedRecordID()==null) || 
             (this.m4AutoGeneratedRecordID!=null &&
              this.m4AutoGeneratedRecordID.equals(other.getM4AutoGeneratedRecordID()))) &&
            this.m4AutoGeneratedToDelete == other.isM4AutoGeneratedToDelete() &&
            ((this.mes==null && other.getMes()==null) || 
             (this.mes!=null &&
              this.mes.equals(other.getMes()))) &&
            ((this.nombre_Paga==null && other.getNombre_Paga()==null) || 
             (this.nombre_Paga!=null &&
              this.nombre_Paga.equals(other.getNombre_Paga()))) &&
            ((this.recibo==null && other.getRecibo()==null) || 
             (this.recibo!=null &&
              this.recibo.equals(other.getRecibo())));
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
        if (getAnio() != null) {
            _hashCode += getAnio().hashCode();
        }
        if (getFecha_Imputacion() != null) {
            _hashCode += getFecha_Imputacion().hashCode();
        }
        if (getFecha_Pago() != null) {
            _hashCode += getFecha_Pago().hashCode();
        }
        if (getM4AutoGeneratedRecordID() != null) {
            _hashCode += getM4AutoGeneratedRecordID().hashCode();
        }
        _hashCode += (isM4AutoGeneratedToDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMes() != null) {
            _hashCode += getMes().hashCode();
        }
        if (getNombre_Paga() != null) {
            _hashCode += getNombre_Paga().hashCode();
        }
        if (getRecibo() != null) {
            _hashCode += getRecibo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ess_Get_Recibos_Nomina_ResultRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Recibos_Nomina_ResultRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("anio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "anio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_Imputacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha_Imputacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_Pago");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha_Pago"));
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
        elemField.setFieldName("mes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre_Paga");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre_Paga"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recibo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recibo"));
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