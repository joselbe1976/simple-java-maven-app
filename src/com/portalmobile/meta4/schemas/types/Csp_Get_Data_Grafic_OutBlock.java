/**
 * Csp_Get_Data_Grafic_OutBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Get_Data_Grafic_OutBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutRecord[] csp_Get_Data_Grafic_OutRecordSet;

    private java.lang.String csp_Literal_Col_1;

    private java.lang.String csp_Nombre;

    private java.lang.String csp_Porc_Anio;

    private java.lang.String csp_Total_Anio_Esperado;

    private java.lang.String csp_Total_Anio_Real;

    public Csp_Get_Data_Grafic_OutBlock() {
    }

    public Csp_Get_Data_Grafic_OutBlock(
           com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutRecord[] csp_Get_Data_Grafic_OutRecordSet,
           java.lang.String csp_Literal_Col_1,
           java.lang.String csp_Nombre,
           java.lang.String csp_Porc_Anio,
           java.lang.String csp_Total_Anio_Esperado,
           java.lang.String csp_Total_Anio_Real) {
           this.csp_Get_Data_Grafic_OutRecordSet = csp_Get_Data_Grafic_OutRecordSet;
           this.csp_Literal_Col_1 = csp_Literal_Col_1;
           this.csp_Nombre = csp_Nombre;
           this.csp_Porc_Anio = csp_Porc_Anio;
           this.csp_Total_Anio_Esperado = csp_Total_Anio_Esperado;
           this.csp_Total_Anio_Real = csp_Total_Anio_Real;
    }


    /**
     * Gets the csp_Get_Data_Grafic_OutRecordSet value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @return csp_Get_Data_Grafic_OutRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutRecord[] getCsp_Get_Data_Grafic_OutRecordSet() {
        return csp_Get_Data_Grafic_OutRecordSet;
    }


    /**
     * Sets the csp_Get_Data_Grafic_OutRecordSet value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @param csp_Get_Data_Grafic_OutRecordSet
     */
    public void setCsp_Get_Data_Grafic_OutRecordSet(com.portalmobile.meta4.schemas.types.Csp_Get_Data_Grafic_OutRecord[] csp_Get_Data_Grafic_OutRecordSet) {
        this.csp_Get_Data_Grafic_OutRecordSet = csp_Get_Data_Grafic_OutRecordSet;
    }


    /**
     * Gets the csp_Literal_Col_1 value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @return csp_Literal_Col_1
     */
    public java.lang.String getCsp_Literal_Col_1() {
        return csp_Literal_Col_1;
    }


    /**
     * Sets the csp_Literal_Col_1 value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @param csp_Literal_Col_1
     */
    public void setCsp_Literal_Col_1(java.lang.String csp_Literal_Col_1) {
        this.csp_Literal_Col_1 = csp_Literal_Col_1;
    }


    /**
     * Gets the csp_Nombre value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @return csp_Nombre
     */
    public java.lang.String getCsp_Nombre() {
        return csp_Nombre;
    }


    /**
     * Sets the csp_Nombre value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @param csp_Nombre
     */
    public void setCsp_Nombre(java.lang.String csp_Nombre) {
        this.csp_Nombre = csp_Nombre;
    }


    /**
     * Gets the csp_Porc_Anio value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @return csp_Porc_Anio
     */
    public java.lang.String getCsp_Porc_Anio() {
        return csp_Porc_Anio;
    }


    /**
     * Sets the csp_Porc_Anio value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @param csp_Porc_Anio
     */
    public void setCsp_Porc_Anio(java.lang.String csp_Porc_Anio) {
        this.csp_Porc_Anio = csp_Porc_Anio;
    }


    /**
     * Gets the csp_Total_Anio_Esperado value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @return csp_Total_Anio_Esperado
     */
    public java.lang.String getCsp_Total_Anio_Esperado() {
        return csp_Total_Anio_Esperado;
    }


    /**
     * Sets the csp_Total_Anio_Esperado value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @param csp_Total_Anio_Esperado
     */
    public void setCsp_Total_Anio_Esperado(java.lang.String csp_Total_Anio_Esperado) {
        this.csp_Total_Anio_Esperado = csp_Total_Anio_Esperado;
    }


    /**
     * Gets the csp_Total_Anio_Real value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @return csp_Total_Anio_Real
     */
    public java.lang.String getCsp_Total_Anio_Real() {
        return csp_Total_Anio_Real;
    }


    /**
     * Sets the csp_Total_Anio_Real value for this Csp_Get_Data_Grafic_OutBlock.
     * 
     * @param csp_Total_Anio_Real
     */
    public void setCsp_Total_Anio_Real(java.lang.String csp_Total_Anio_Real) {
        this.csp_Total_Anio_Real = csp_Total_Anio_Real;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Get_Data_Grafic_OutBlock)) return false;
        Csp_Get_Data_Grafic_OutBlock other = (Csp_Get_Data_Grafic_OutBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Get_Data_Grafic_OutRecordSet==null && other.getCsp_Get_Data_Grafic_OutRecordSet()==null) || 
             (this.csp_Get_Data_Grafic_OutRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Get_Data_Grafic_OutRecordSet, other.getCsp_Get_Data_Grafic_OutRecordSet()))) &&
            ((this.csp_Literal_Col_1==null && other.getCsp_Literal_Col_1()==null) || 
             (this.csp_Literal_Col_1!=null &&
              this.csp_Literal_Col_1.equals(other.getCsp_Literal_Col_1()))) &&
            ((this.csp_Nombre==null && other.getCsp_Nombre()==null) || 
             (this.csp_Nombre!=null &&
              this.csp_Nombre.equals(other.getCsp_Nombre()))) &&
            ((this.csp_Porc_Anio==null && other.getCsp_Porc_Anio()==null) || 
             (this.csp_Porc_Anio!=null &&
              this.csp_Porc_Anio.equals(other.getCsp_Porc_Anio()))) &&
            ((this.csp_Total_Anio_Esperado==null && other.getCsp_Total_Anio_Esperado()==null) || 
             (this.csp_Total_Anio_Esperado!=null &&
              this.csp_Total_Anio_Esperado.equals(other.getCsp_Total_Anio_Esperado()))) &&
            ((this.csp_Total_Anio_Real==null && other.getCsp_Total_Anio_Real()==null) || 
             (this.csp_Total_Anio_Real!=null &&
              this.csp_Total_Anio_Real.equals(other.getCsp_Total_Anio_Real())));
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
        if (getCsp_Get_Data_Grafic_OutRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Get_Data_Grafic_OutRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Get_Data_Grafic_OutRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getCsp_Literal_Col_1() != null) {
            _hashCode += getCsp_Literal_Col_1().hashCode();
        }
        if (getCsp_Nombre() != null) {
            _hashCode += getCsp_Nombre().hashCode();
        }
        if (getCsp_Porc_Anio() != null) {
            _hashCode += getCsp_Porc_Anio().hashCode();
        }
        if (getCsp_Total_Anio_Esperado() != null) {
            _hashCode += getCsp_Total_Anio_Esperado().hashCode();
        }
        if (getCsp_Total_Anio_Real() != null) {
            _hashCode += getCsp_Total_Anio_Real().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Get_Data_Grafic_OutBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Data_Grafic_OutBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Get_Data_Grafic_OutRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Get_Data_Grafic_OutRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_Data_Grafic_OutRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Literal_Col_1");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Literal_Col_1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Porc_Anio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Porc_Anio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Total_Anio_Esperado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Total_Anio_Esperado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Total_Anio_Real");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Total_Anio_Real"));
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
