/**
 * Csp_Params_Process_MvlBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Params_Process_MvlBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Params_Process_MvlRecord[] csp_Params_Process_MvlRecordSet;

    private java.lang.String param_Parametro;

    private java.lang.String param_Proceso;

    public Csp_Params_Process_MvlBlock() {
    }

    public Csp_Params_Process_MvlBlock(
           com.portalmobile.meta4.schemas.types.Csp_Params_Process_MvlRecord[] csp_Params_Process_MvlRecordSet,
           java.lang.String param_Parametro,
           java.lang.String param_Proceso) {
           this.csp_Params_Process_MvlRecordSet = csp_Params_Process_MvlRecordSet;
           this.param_Parametro = param_Parametro;
           this.param_Proceso = param_Proceso;
    }


    /**
     * Gets the csp_Params_Process_MvlRecordSet value for this Csp_Params_Process_MvlBlock.
     * 
     * @return csp_Params_Process_MvlRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Params_Process_MvlRecord[] getCsp_Params_Process_MvlRecordSet() {
        return csp_Params_Process_MvlRecordSet;
    }


    /**
     * Sets the csp_Params_Process_MvlRecordSet value for this Csp_Params_Process_MvlBlock.
     * 
     * @param csp_Params_Process_MvlRecordSet
     */
    public void setCsp_Params_Process_MvlRecordSet(com.portalmobile.meta4.schemas.types.Csp_Params_Process_MvlRecord[] csp_Params_Process_MvlRecordSet) {
        this.csp_Params_Process_MvlRecordSet = csp_Params_Process_MvlRecordSet;
    }


    /**
     * Gets the param_Parametro value for this Csp_Params_Process_MvlBlock.
     * 
     * @return param_Parametro
     */
    public java.lang.String getParam_Parametro() {
        return param_Parametro;
    }


    /**
     * Sets the param_Parametro value for this Csp_Params_Process_MvlBlock.
     * 
     * @param param_Parametro
     */
    public void setParam_Parametro(java.lang.String param_Parametro) {
        this.param_Parametro = param_Parametro;
    }


    /**
     * Gets the param_Proceso value for this Csp_Params_Process_MvlBlock.
     * 
     * @return param_Proceso
     */
    public java.lang.String getParam_Proceso() {
        return param_Proceso;
    }


    /**
     * Sets the param_Proceso value for this Csp_Params_Process_MvlBlock.
     * 
     * @param param_Proceso
     */
    public void setParam_Proceso(java.lang.String param_Proceso) {
        this.param_Proceso = param_Proceso;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Params_Process_MvlBlock)) return false;
        Csp_Params_Process_MvlBlock other = (Csp_Params_Process_MvlBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Params_Process_MvlRecordSet==null && other.getCsp_Params_Process_MvlRecordSet()==null) || 
             (this.csp_Params_Process_MvlRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Params_Process_MvlRecordSet, other.getCsp_Params_Process_MvlRecordSet()))) &&
            ((this.param_Parametro==null && other.getParam_Parametro()==null) || 
             (this.param_Parametro!=null &&
              this.param_Parametro.equals(other.getParam_Parametro()))) &&
            ((this.param_Proceso==null && other.getParam_Proceso()==null) || 
             (this.param_Proceso!=null &&
              this.param_Proceso.equals(other.getParam_Proceso())));
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
        if (getCsp_Params_Process_MvlRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Params_Process_MvlRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Params_Process_MvlRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getParam_Parametro() != null) {
            _hashCode += getParam_Parametro().hashCode();
        }
        if (getParam_Proceso() != null) {
            _hashCode += getParam_Proceso().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Params_Process_MvlBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Params_Process_MvlBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Params_Process_MvlRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Params_Process_MvlRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Params_Process_MvlRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param_Parametro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "param_Parametro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param_Proceso");
        elemField.setXmlName(new javax.xml.namespace.QName("", "param_Proceso"));
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
