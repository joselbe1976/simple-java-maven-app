package com.common.hibernate.entidades;

// Generated 26-ago-2014 10:48:56 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VinNotificationsId generated by hbm2java
 */
@Embeddable
public class VinNotificationsId implements java.io.Serializable {

	private int ordinal;
	private String idUser;

	public VinNotificationsId() {
	}

	public VinNotificationsId(int ordinal, String idUser) {
		this.ordinal = ordinal;
		this.idUser = idUser;
	}

	@Column(name = "ordinal", nullable = false)
	public int getOrdinal() {
		return this.ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	@Column(name = "id_user", nullable = false, length = 200)
	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VinNotificationsId))
			return false;
		VinNotificationsId castOther = (VinNotificationsId) other;

		return (this.getOrdinal() == castOther.getOrdinal())
				&& ((this.getIdUser() == castOther.getIdUser()) || (this
						.getIdUser() != null && castOther.getIdUser() != null && this
						.getIdUser().equals(castOther.getIdUser())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrdinal();
		result = 37 * result
				+ (getIdUser() == null ? 0 : this.getIdUser().hashCode());
		return result;
	}

}
