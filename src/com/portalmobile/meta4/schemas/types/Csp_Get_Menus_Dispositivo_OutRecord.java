/**
 * Csp_Get_Menus_Dispositivo_OutRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Get_Menus_Dispositivo_OutRecord  implements java.io.Serializable {
    private java.lang.String descripcion;

    private java.lang.String id_Menu;

    private javax.activation.DataHandler imagen_Menu;

    private java.lang.String m4AutoGeneratedRecordID;

    private boolean m4AutoGeneratedToDelete;

    private java.lang.String nombre;

    public Csp_Get_Menus_Dispositivo_OutRecord() {
    }

    public Csp_Get_Menus_Dispositivo_OutRecord(
           java.lang.String descripcion,
           java.lang.String id_Menu,
           javax.activation.DataHandler imagen_Menu,
           java.lang.String m4AutoGeneratedRecordID,
           boolean m4AutoGeneratedToDelete,
           java.lang.String nombre) {
           this.descripcion = descripcion;
           this.id_Menu = id_Menu;
           this.imagen_Menu = imagen_Menu;
           this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
           this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
           this.nombre = nombre;
    }


    /**
     * Gets the descripcion value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the id_Menu value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @return id_Menu
     */
    public java.lang.String getId_Menu() {
        return id_Menu;
    }


    /**
     * Sets the id_Menu value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @param id_Menu
     */
    public void setId_Menu(java.lang.String id_Menu) {
        this.id_Menu = id_Menu;
    }


    /**
     * Gets the imagen_Menu value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @return imagen_Menu
     */
    public javax.activation.DataHandler getImagen_Menu() {
        return imagen_Menu;
    }


    /**
     * Sets the imagen_Menu value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @param imagen_Menu
     */
    public void setImagen_Menu(javax.activation.DataHandler imagen_Menu) {
        this.imagen_Menu = imagen_Menu;
    }


    /**
     * Gets the m4AutoGeneratedRecordID value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @return m4AutoGeneratedRecordID
     */
    public java.lang.String getM4AutoGeneratedRecordID() {
        return m4AutoGeneratedRecordID;
    }


    /**
     * Sets the m4AutoGeneratedRecordID value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @param m4AutoGeneratedRecordID
     */
    public void setM4AutoGeneratedRecordID(java.lang.String m4AutoGeneratedRecordID) {
        this.m4AutoGeneratedRecordID = m4AutoGeneratedRecordID;
    }


    /**
     * Gets the m4AutoGeneratedToDelete value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @return m4AutoGeneratedToDelete
     */
    public boolean isM4AutoGeneratedToDelete() {
        return m4AutoGeneratedToDelete;
    }


    /**
     * Sets the m4AutoGeneratedToDelete value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @param m4AutoGeneratedToDelete
     */
    public void setM4AutoGeneratedToDelete(boolean m4AutoGeneratedToDelete) {
        this.m4AutoGeneratedToDelete = m4AutoGeneratedToDelete;
    }


    /**
     * Gets the nombre value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Csp_Get_Menus_Dispositivo_OutRecord.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Get_Menus_Dispositivo_OutRecord)) return false;
        Csp_Get_Menus_Dispositivo_OutRecord other = (Csp_Get_Menus_Dispositivo_OutRecord) obj;
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
            ((this.id_Menu==null && other.getId_Menu()==null) || 
             (this.id_Menu!=null &&
              this.id_Menu.equals(other.getId_Menu()))) &&
            ((this.imagen_Menu==null && other.getImagen_Menu()==null) || 
             (this.imagen_Menu!=null &&
              this.imagen_Menu.equals(other.getImagen_Menu()))) &&
            ((this.m4AutoGeneratedRecordID==null && other.getM4AutoGeneratedRecordID()==null) || 
             (this.m4AutoGeneratedRecordID!=null &&
              this.m4AutoGeneratedRecordID.equals(other.getM4AutoGeneratedRecordID()))) &&
            this.m4AutoGeneratedToDelete == other.isM4AutoGeneratedToDelete() &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre())));
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
        if (getId_Menu() != null) {
            _hashCode += getId_Menu().hashCode();
        }
        if (getImagen_Menu() != null) {
            _hashCode += getImagen_Menu().hashCode();
        }
        if (getM4AutoGeneratedRecordID() != null) {
            _hashCode += getM4AutoGeneratedRecordID().hashCode();
        }
        _hashCode += (isM4AutoGeneratedToDelete() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Get_Menus_Dispositivo_OutRecord.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Menus_Dispositivo_OutRecord"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id_Menu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id_Menu"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagen_Menu");
        elemField.setXmlName(new javax.xml.namespace.QName("", "imagen_Menu"));
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
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
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