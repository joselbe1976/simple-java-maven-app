/**
 * Ess_Get_Noticias_ResultRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Ess_Get_Noticias_ResultRecord  implements java.io.Serializable {
    private java.lang.String descripcion;

    private javax.activation.DataHandler documento;

    private java.lang.String ext_Doc;

    private javax.activation.DataHandler imagen;

    private java.lang.String m4AutoGeneratedRecordID;

    private boolean m4AutoGeneratedToDelete;

    private java.lang.String ordinal;

    private java.lang.Double ordinal_Number;

    private java.lang.String sociedad;

    private java.lang.String titulo;

    public Ess_Get_Noticias_ResultRecord() {
    }

    public Ess_Get_Noticias_ResultRecord(
           java.lang.String descripcion,
           javax.activation.DataHandler documento,
           java.lang.String ext_Doc,
           javax.activation.DataHandler imagen,
           java.lang.String m4AutoGeneratedRecordID,
           boolean m4AutoGeneratedToDelete,
           java.lang.String ordinal,
           java.lang.Double ordinal_Number,
           java.lang.String sociedad,
           java.lang.String titulo) {
           this.descripcion = descripcion;
           this.documento = documento;
           this.ext_Doc = ext_Doc;
           this.imagen = imagen;
           this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
           this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
           this.ordinal = ordinal;
           this.ordinal_Number = ordinal_Number;
           this.sociedad = sociedad;
           this.titulo = titulo;
    }


    /**
     * Gets the descripcion value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the documento value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return documento
     */
    public javax.activation.DataHandler getDocumento() {
        return documento;
    }


    /**
     * Sets the documento value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param documento
     */
    public void setDocumento(javax.activation.DataHandler documento) {
        this.documento = documento;
    }


    /**
     * Gets the ext_Doc value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return ext_Doc
     */
    public java.lang.String getExt_Doc() {
        return ext_Doc;
    }


    /**
     * Sets the ext_Doc value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param ext_Doc
     */
    public void setExt_Doc(java.lang.String ext_Doc) {
        this.ext_Doc = ext_Doc;
    }


    /**
     * Gets the imagen value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return imagen
     */
    public javax.activation.DataHandler getImagen() {
        return imagen;
    }


    /**
     * Sets the imagen value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param imagen
     */
    public void setImagen(javax.activation.DataHandler imagen) {
        this.imagen = imagen;
    }


    /**
     * Gets the m4AutoGeneratedRecordID value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return m4AutoGeneratedRecordID
     */
    public java.lang.String getM4AutoGeneratedRecordID() {
        return m4AutoGeneratedRecordID;
    }


    /**
     * Sets the m4AutoGeneratedRecordID value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param m4AutoGeneratedRecordID
     */
    public void setM4AutoGeneratedRecordID(java.lang.String m4AutoGeneratedRecordID) {
        this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
    }


    /**
     * Gets the m4AutoGeneratedToDelete value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return m4AutoGeneratedToDelete
     */
    public boolean isM4AutoGeneratedToDelete() {
        return m4AutoGeneratedToDelete;
    }


    /**
     * Sets the m4AutoGeneratedToDelete value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param m4AutoGeneratedToDelete
     */
    public void setM4AutoGeneratedToDelete(boolean m4AutoGeneratedToDelete) {
        this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
    }


    /**
     * Gets the ordinal value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return ordinal
     */
    public java.lang.String getOrdinal() {
        return ordinal;
    }


    /**
     * Sets the ordinal value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param ordinal
     */
    public void setOrdinal(java.lang.String ordinal) {
        this.ordinal = ordinal;
    }


    /**
     * Gets the ordinal_Number value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return ordinal_Number
     */
    public java.lang.Double getOrdinal_Number() {
        return ordinal_Number;
    }


    /**
     * Sets the ordinal_Number value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param ordinal_Number
     */
    public void setOrdinal_Number(java.lang.Double ordinal_Number) {
        this.ordinal_Number = ordinal_Number;
    }


    /**
     * Gets the sociedad value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return sociedad
     */
    public java.lang.String getSociedad() {
        return sociedad;
    }


    /**
     * Sets the sociedad value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param sociedad
     */
    public void setSociedad(java.lang.String sociedad) {
        this.sociedad = sociedad;
    }


    /**
     * Gets the titulo value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @return titulo
     */
    public java.lang.String getTitulo() {
        return titulo;
    }


    /**
     * Sets the titulo value for this Ess_Get_Noticias_ResultRecord.
     * 
     * @param titulo
     */
    public void setTitulo(java.lang.String titulo) {
        this.titulo = titulo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Ess_Get_Noticias_ResultRecord)) return false;
        Ess_Get_Noticias_ResultRecord other = (Ess_Get_Noticias_ResultRecord) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            ((this.documento==null && other.getDocumento()==null) || 
             (this.documento!=null &&
              this.documento.equals(other.getDocumento()))) &&
            ((this.ext_Doc==null && other.getExt_Doc()==null) || 
             (this.ext_Doc!=null &&
              this.ext_Doc.equals(other.getExt_Doc()))) &&
            ((this.imagen==null && other.getImagen()==null) || 
             (this.imagen!=null &&
              this.imagen.equals(other.getImagen()))) &&
            ((this.m4AutoGeneratedRecordID==null && other.getM4AutoGeneratedRecordID()==null) || 
             (this.m4AutoGeneratedRecordID!=null &&
              this.m4AutoGeneratedRecordID.equals(other.getM4AutoGeneratedRecordID()))) &&
            this.m4AutoGeneratedToDelete == other.isM4AutoGeneratedToDelete() &&
            ((this.ordinal==null && other.getOrdinal()==null) || 
             (this.ordinal!=null &&
              this.ordinal.equals(other.getOrdinal()))) &&
            ((this.ordinal_Number==null && other.getOrdinal_Number()==null) || 
             (this.ordinal_Number!=null &&
              this.ordinal_Number.equals(other.getOrdinal_Number()))) &&
            ((this.sociedad==null && other.getSociedad()==null) || 
             (this.sociedad!=null &&
              this.sociedad.equals(other.getSociedad()))) &&
            ((this.titulo==null && other.getTitulo()==null) || 
             (this.titulo!=null &&
              this.titulo.equals(other.getTitulo())));
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
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        if (getDocumento() != null) {
            _hashCode += getDocumento().hashCode();
        }
        if (getExt_Doc() != null) {
            _hashCode += getExt_Doc().hashCode();
        }
        if (getImagen() != null) {
            _hashCode += getImagen().hashCode();
        }
        if (getM4AutoGeneratedRecordID() != null) {
            _hashCode += getM4AutoGeneratedRecordID().hashCode();
        }
        _hashCode += (isM4AutoGeneratedToDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getOrdinal() != null) {
            _hashCode += getOrdinal().hashCode();
        }
        if (getOrdinal_Number() != null) {
            _hashCode += getOrdinal_Number().hashCode();
        }
        if (getSociedad() != null) {
            _hashCode += getSociedad().hashCode();
        }
        if (getTitulo() != null) {
            _hashCode += getTitulo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Ess_Get_Noticias_ResultRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Ess_Get_Noticias_ResultRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("documento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "documento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "DataHandler"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ext_Doc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ext_Doc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imagen"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xml.apache.org/xml-soap", "DataHandler"));
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
        elemField.setFieldName("ordinal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordinal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ordinal_Number");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ordinal_Number"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sociedad");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sociedad"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("titulo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "titulo"));
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
