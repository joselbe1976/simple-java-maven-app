/**
 * Csp_Get_List_Indicadores_OutBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Get_List_Indicadores_OutBlock  implements java.io.Serializable {
    private java.lang.String csp_Fecha_Proceso;

    private java.lang.String csp_Fecha_Proceso_Name;

    private com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutRecord[] csp_Get_List_Indicadores_OutRecordSet;

    public Csp_Get_List_Indicadores_OutBlock() {
    }

    public Csp_Get_List_Indicadores_OutBlock(
           java.lang.String csp_Fecha_Proceso,
           java.lang.String csp_Fecha_Proceso_Name,
           com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutRecord[] csp_Get_List_Indicadores_OutRecordSet) {
           this.csp_Fecha_Proceso = csp_Fecha_Proceso;
           this.csp_Fecha_Proceso_Name = csp_Fecha_Proceso_Name;
           this.csp_Get_List_Indicadores_OutRecordSet = csp_Get_List_Indicadores_OutRecordSet;
    }


    /**
     * Gets the csp_Fecha_Proceso value for this Csp_Get_List_Indicadores_OutBlock.
     * 
     * @return csp_Fecha_Proceso
     */
    public java.lang.String getCsp_Fecha_Proceso() {
        return csp_Fecha_Proceso;
    }


    /**
     * Sets the csp_Fecha_Proceso value for this Csp_Get_List_Indicadores_OutBlock.
     * 
     * @param csp_Fecha_Proceso
     */
    public void setCsp_Fecha_Proceso(java.lang.String csp_Fecha_Proceso) {
        this.csp_Fecha_Proceso = csp_Fecha_Proceso;
    }


    /**
     * Gets the csp_Fecha_Proceso_Name value for this Csp_Get_List_Indicadores_OutBlock.
     * 
     * @return csp_Fecha_Proceso_Name
     */
    public java.lang.String getCsp_Fecha_Proceso_Name() {
        return csp_Fecha_Proceso_Name;
    }


    /**
     * Sets the csp_Fecha_Proceso_Name value for this Csp_Get_List_Indicadores_OutBlock.
     * 
     * @param csp_Fecha_Proceso_Name
     */
    public void setCsp_Fecha_Proceso_Name(java.lang.String csp_Fecha_Proceso_Name) {
        this.csp_Fecha_Proceso_Name = csp_Fecha_Proceso_Name;
    }


    /**
     * Gets the csp_Get_List_Indicadores_OutRecordSet value for this Csp_Get_List_Indicadores_OutBlock.
     * 
     * @return csp_Get_List_Indicadores_OutRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutRecord[] getCsp_Get_List_Indicadores_OutRecordSet() {
        return csp_Get_List_Indicadores_OutRecordSet;
    }


    /**
     * Sets the csp_Get_List_Indicadores_OutRecordSet value for this Csp_Get_List_Indicadores_OutBlock.
     * 
     * @param csp_Get_List_Indicadores_OutRecordSet
     */
    public void setCsp_Get_List_Indicadores_OutRecordSet(com.portalmobile.meta4.schemas.types.Csp_Get_List_Indicadores_OutRecord[] csp_Get_List_Indicadores_OutRecordSet) {
        this.csp_Get_List_Indicadores_OutRecordSet = csp_Get_List_Indicadores_OutRecordSet;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Get_List_Indicadores_OutBlock)) return false;
        Csp_Get_List_Indicadores_OutBlock other = (Csp_Get_List_Indicadores_OutBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Fecha_Proceso==null && other.getCsp_Fecha_Proceso()==null) || 
             (this.csp_Fecha_Proceso!=null &&
              this.csp_Fecha_Proceso.equals(other.getCsp_Fecha_Proceso()))) &&
            ((this.csp_Fecha_Proceso_Name==null && other.getCsp_Fecha_Proceso_Name()==null) || 
             (this.csp_Fecha_Proceso_Name!=null &&
              this.csp_Fecha_Proceso_Name.equals(other.getCsp_Fecha_Proceso_Name()))) &&
            ((this.csp_Get_List_Indicadores_OutRecordSet==null && other.getCsp_Get_List_Indicadores_OutRecordSet()==null) || 
             (this.csp_Get_List_Indicadores_OutRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Get_List_Indicadores_OutRecordSet, other.getCsp_Get_List_Indicadores_OutRecordSet())));
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
        if (getCsp_Fecha_Proceso() != null) {
            _hashCode += getCsp_Fecha_Proceso().hashCode();
        }
        if (getCsp_Fecha_Proceso_Name() != null) {
            _hashCode += getCsp_Fecha_Proceso_Name().hashCode();
        }
        if (getCsp_Get_List_Indicadores_OutRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Get_List_Indicadores_OutRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Get_List_Indicadores_OutRecordSet(), i);
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
        new org.apache.axis.description.TypeDesc(Csp_Get_List_Indicadores_OutBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Indicadores_OutBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Fecha_Proceso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Fecha_Proceso"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Fecha_Proceso_Name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Fecha_Proceso_Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Get_List_Indicadores_OutRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Get_List_Indicadores_OutRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Get_List_Indicadores_OutRecord"));
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
