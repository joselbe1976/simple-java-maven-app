package com.common.hibernate.entidades.tinnova;
// Generated 12-abr-2016 16:30:08 by Hibernate Tools 3.5.0.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * M4tPuestTrabId generated by hbm2java
 */
@Embeddable
public class M4tPuestTrabId implements java.io.Serializable {

	private String idSociedad;
	private String idPuesto;

	public M4tPuestTrabId() {
	}

	public M4tPuestTrabId(String idSociedad, String idPuesto) {
		this.idSociedad = idSociedad;
		this.idPuesto = idPuesto;
	}

	@Column(name = "ID_SOCIEDAD", nullable = false, length = 2)
	public String getIdSociedad() {
		return this.idSociedad;
	}

	public void setIdSociedad(String idSociedad) {
		this.idSociedad = idSociedad;
	}

	@Column(name = "ID_PUESTO", nullable = false, length = 10)
	public String getIdPuesto() {
		return this.idPuesto;
	}

	public void setIdPuesto(String idPuesto) {
		this.idPuesto = idPuesto;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof M4tPuestTrabId))
			return false;
		M4tPuestTrabId castOther = (M4tPuestTrabId) other;

		return ((this.getIdSociedad() == castOther.getIdSociedad()) || (this.getIdSociedad() != null
				&& castOther.getIdSociedad() != null && this.getIdSociedad().equals(castOther.getIdSociedad())))
				&& ((this.getIdPuesto() == castOther.getIdPuesto()) || (this.getIdPuesto() != null
						&& castOther.getIdPuesto() != null && this.getIdPuesto().equals(castOther.getIdPuesto())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getIdSociedad() == null ? 0 : this.getIdSociedad().hashCode());
		result = 37 * result + (getIdPuesto() == null ? 0 : this.getIdPuesto().hashCode());
		return result;
	}

}
