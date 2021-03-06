package com.common.hibernate.entidades.tinnova;
// Generated 12-abr-2016 16:30:08 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * M4tInfGrafEmplId generated by hbm2java
 */
@Embeddable
public class M4tInfGrafEmplId implements java.io.Serializable {

	private String idSociedad;
	private String idEmpleado;
	private int idOrdinal;

	public M4tInfGrafEmplId() {
	}

	public M4tInfGrafEmplId(String idSociedad, String idEmpleado, int idOrdinal) {
		this.idSociedad = idSociedad;
		this.idEmpleado = idEmpleado;
		this.idOrdinal = idOrdinal;
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

	@Column(name = "ID_ORDINAL", nullable = false, precision = 6, scale = 0)
	public int getIdOrdinal() {
		return this.idOrdinal;
	}

	public void setIdOrdinal(int idOrdinal) {
		this.idOrdinal = idOrdinal;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof M4tInfGrafEmplId))
			return false;
		M4tInfGrafEmplId castOther = (M4tInfGrafEmplId) other;

		return ((this.getIdSociedad() == castOther.getIdSociedad()) || (this.getIdSociedad() != null
				&& castOther.getIdSociedad() != null && this.getIdSociedad().equals(castOther.getIdSociedad())))
				&& ((this.getIdEmpleado() == castOther.getIdEmpleado()) || (this.getIdEmpleado() != null
						&& castOther.getIdEmpleado() != null && this.getIdEmpleado().equals(castOther.getIdEmpleado())))
				&& (this.getIdOrdinal() == castOther.getIdOrdinal());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdSociedad() == null ? 0 : this.getIdSociedad().hashCode());
		result = 37 * result + (getIdEmpleado() == null ? 0 : this.getIdEmpleado().hashCode());
		result = 37 * result + this.getIdOrdinal();
		return result;
	}

}
