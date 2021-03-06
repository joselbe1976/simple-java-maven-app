package com.common.hibernate.entidades.tinnova;
// Generated 12-abr-2016 16:30:08 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * M4tDatosPagoId generated by hbm2java
 */
@Embeddable
public class M4tDatosPagoId implements java.io.Serializable {

	private String idSociedad;
	private String idEmpleado;
	private Date fecAltaEmpleado;
	private short idDatoPago;

	public M4tDatosPagoId() {
	}

	public M4tDatosPagoId(String idSociedad, String idEmpleado, Date fecAltaEmpleado, short idDatoPago) {
		this.idSociedad = idSociedad;
		this.idEmpleado = idEmpleado;
		this.fecAltaEmpleado = fecAltaEmpleado;
		this.idDatoPago = idDatoPago;
	}

	@Column(name = "ID_SOCIEDAD", nullable = false, length = 2)
	public String getIdSociedad() {
		return this.idSociedad;
	}

	public void setIdSociedad(String idSociedad) {
		this.idSociedad = idSociedad;
	}

	@Column(name = "ID_EMPLEADO", nullable = false, length = 10)
	public String getIdEmpleado() {
		return this.idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	@Column(name = "FEC_ALTA_EMPLEADO", nullable = false, length = 23)
	public Date getFecAltaEmpleado() {
		return this.fecAltaEmpleado;
	}

	public void setFecAltaEmpleado(Date fecAltaEmpleado) {
		this.fecAltaEmpleado = fecAltaEmpleado;
	}

	@Column(name = "ID_DATO_PAGO", nullable = false, precision = 3, scale = 0)
	public short getIdDatoPago() {
		return this.idDatoPago;
	}

	public void setIdDatoPago(short idDatoPago) {
		this.idDatoPago = idDatoPago;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof M4tDatosPagoId))
			return false;
		M4tDatosPagoId castOther = (M4tDatosPagoId) other;

		return ((this.getIdSociedad() == castOther.getIdSociedad()) || (this.getIdSociedad() != null
				&& castOther.getIdSociedad() != null && this.getIdSociedad().equals(castOther.getIdSociedad())))
				&& ((this.getIdEmpleado() == castOther.getIdEmpleado()) || (this.getIdEmpleado() != null
						&& castOther.getIdEmpleado() != null && this.getIdEmpleado().equals(castOther.getIdEmpleado())))
				&& ((this.getFecAltaEmpleado() == castOther.getFecAltaEmpleado())
						|| (this.getFecAltaEmpleado() != null && castOther.getFecAltaEmpleado() != null
								&& this.getFecAltaEmpleado().equals(castOther.getFecAltaEmpleado())))
				&& (this.getIdDatoPago() == castOther.getIdDatoPago());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdSociedad() == null ? 0 : this.getIdSociedad().hashCode());
		result = 37 * result + (getIdEmpleado() == null ? 0 : this.getIdEmpleado().hashCode());
		result = 37 * result + (getFecAltaEmpleado() == null ? 0 : this.getFecAltaEmpleado().hashCode());
		result = 37 * result + this.getIdDatoPago();
		return result;
	}

}
