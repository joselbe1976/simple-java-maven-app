/**
 * Csp_Mbl_Soap_DashboardBlock.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.portalmobile.meta4.schemas.types;

public class Csp_Mbl_Soap_DashboardBlock  implements java.io.Serializable {
    private com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardRecord[] csp_Mbl_Soap_DashboardRecordSet;

    private java.lang.String executereport;

    private java.util.Calendar param_Fecha;

    private java.lang.String private_Get_Date_Nm;

    public Csp_Mbl_Soap_DashboardBlock() {
    }

    public Csp_Mbl_Soap_DashboardBlock(
           com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardRecord[] csp_Mbl_Soap_DashboardRecordSet,
           java.lang.String executereport,
           java.util.Calendar param_Fecha,
           java.lang.String private_Get_Date_Nm) {
           this.csp_Mbl_Soap_DashboardRecordSet = csp_Mbl_Soap_DashboardRecordSet;
           this.executereport = executereport;
           this.param_Fecha = param_Fecha;
           this.private_Get_Date_Nm = private_Get_Date_Nm;
    }


    /**
     * Gets the csp_Mbl_Soap_DashboardRecordSet value for this Csp_Mbl_Soap_DashboardBlock.
     * 
     * @return csp_Mbl_Soap_DashboardRecordSet
     */
    public com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardRecord[] getCsp_Mbl_Soap_DashboardRecordSet() {
        return csp_Mbl_Soap_DashboardRecordSet;
    }


    /**
     * Sets the csp_Mbl_Soap_DashboardRecordSet value for this Csp_Mbl_Soap_DashboardBlock.
     * 
     * @param csp_Mbl_Soap_DashboardRecordSet
     */
    public void setCsp_Mbl_Soap_DashboardRecordSet(com.portalmobile.meta4.schemas.types.Csp_Mbl_Soap_DashboardRecord[] csp_Mbl_Soap_DashboardRecordSet) {
        this.csp_Mbl_Soap_DashboardRecordSet = csp_Mbl_Soap_DashboardRecordSet;
    }


    /**
     * Gets the executereport value for this Csp_Mbl_Soap_DashboardBlock.
     * 
     * @return executereport
     */
    public java.lang.String getExecutereport() {
        return executereport;
    }


    /**
     * Sets the executereport value for this Csp_Mbl_Soap_DashboardBlock.
     * 
     * @param executereport
     */
    public void setExecutereport(java.lang.String executereport) {
        this.executereport = executereport;
    }


    /**
     * Gets the param_Fecha value for this Csp_Mbl_Soap_DashboardBlock.
     * 
     * @return param_Fecha
     */
    public java.util.Calendar getParam_Fecha() {
        return param_Fecha;
    }


    /**
     * Sets the param_Fecha value for this Csp_Mbl_Soap_DashboardBlock.
     * 
     * @param param_Fecha
     */
    public void setParam_Fecha(java.util.Calendar param_Fecha) {
        this.param_Fecha = param_Fecha;
    }


    /**
     * Gets the private_Get_Date_Nm value for this Csp_Mbl_Soap_DashboardBlock.
     * 
     * @return private_Get_Date_Nm
     */
    public java.lang.String getPrivate_Get_Date_Nm() {
        return private_Get_Date_Nm;
    }


    /**
     * Sets the private_Get_Date_Nm value for this Csp_Mbl_Soap_DashboardBlock.
     * 
     * @param private_Get_Date_Nm
     */
    public void setPrivate_Get_Date_Nm(java.lang.String private_Get_Date_Nm) {
        this.private_Get_Date_Nm = private_Get_Date_Nm;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Csp_Mbl_Soap_DashboardBlock)) return false;
        Csp_Mbl_Soap_DashboardBlock other = (Csp_Mbl_Soap_DashboardBlock) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.csp_Mbl_Soap_DashboardRecordSet==null && other.getCsp_Mbl_Soap_DashboardRecordSet()==null) || 
             (this.csp_Mbl_Soap_DashboardRecordSet!=null &&
              java.util.Arrays.equals(this.csp_Mbl_Soap_DashboardRecordSet, other.getCsp_Mbl_Soap_DashboardRecordSet()))) &&
            ((this.executereport==null && other.getExecutereport()==null) || 
             (this.executereport!=null &&
              this.executereport.equals(other.getExecutereport()))) &&
            ((this.param_Fecha==null && other.getParam_Fecha()==null) || 
             (this.param_Fecha!=null &&
              this.param_Fecha.equals(other.getParam_Fecha()))) &&
            ((this.private_Get_Date_Nm==null && other.getPrivate_Get_Date_Nm()==null) || 
             (this.private_Get_Date_Nm!=null &&
              this.private_Get_Date_Nm.equals(other.getPrivate_Get_Date_Nm())));
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
        if (getCsp_Mbl_Soap_DashboardRecordSet() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCsp_Mbl_Soap_DashboardRecordSet());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCsp_Mbl_Soap_DashboardRecordSet(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExecutereport() != null) {
            _hashCode += getExecutereport().hashCode();
        }
        if (getParam_Fecha() != null) {
            _hashCode += getParam_Fecha().hashCode();
        }
        if (getPrivate_Get_Date_Nm() != null) {
            _hashCode += getPrivate_Get_Date_Nm().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Csp_Mbl_Soap_DashboardBlock.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_DashboardBlock"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("csp_Mbl_Soap_DashboardRecordSet");
        elemField.setXmlName(new javax.xml.namespace.QName("", "csp_Mbl_Soap_DashboardRecordSet"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.meta4.com/types", "Csp_Mbl_Soap_DashboardRecord"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("executereport");
        elemField.setXmlName(new javax.xml.namespace.QName("", "executereport"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("param_Fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "param_Fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("private_Get_Date_Nm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "private_Get_Date_Nm"));
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
