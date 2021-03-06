package com.common.hibernate.entidades.tinnova;
// Generated 12-abr-2016 16:30:08 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * M4tDepartamentosId generated by hbm2java
 */
@Embeddable
public class M4tDepartamentosId implements java.io.Serializable {

	private String idSociedad;
	private String idDepartamento;

	public M4tDepartamentosId() {
	}

	public M4tDepartamentosId(String idSociedad, String idDepartamento) {
		this.idSociedad = idSociedad;
		this.idDepartamento = idDepartamento;
	}

	@Column(name = "ID_SOCIEDAD", nullable = false, length = 2)
	public String getIdSociedad() {
		return this.idSociedad;
	}

	public void setIdSociedad(String idSociedad) {
		this.idSociedad = idSociedad;
	}

	@Column(name = "ID_DEPARTAMENTO", nullable = false, length = 8)
	public String getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(String idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof M4tDepartamentosId))
			return false;
		M4tDepartamentosId castOther = (M4tDepartamentosId) other;

		return ((this.getIdSociedad() == castOther.getIdSociedad()) || (this.getIdSociedad() != null
				&& castOther.getIdSociedad() != null && this.getIdSociedad().equals(castOther.getIdSociedad())))
				&& ((this.getIdDepartamento() == castOther.getIdDepartamento())
						|| (this.getIdDepartamento() != null && castOther.getIdDepartamento() != null
								&& this.getIdDepartamento().equals(castOther.getIdDepartamento())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdSociedad() == null ? 0 : this.getIdSociedad().hashCode());
		result = 37 * result + (getIdDepartamento() == null ? 0 : this.getIdDepartamento().hashCode());
		return result;
	}

}
