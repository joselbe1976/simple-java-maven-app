package com.common.hibernate.entidades;

// Generated 26-ago-2014 10:48:56 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VinUsersSystemId generated by hbm2java
 */
@Embeddable
public class VinUsersSystemId implements java.io.Serializable {

	private String idUser;
	private String idSystem;

	public VinUsersSystemId() {
	}

	public VinUsersSystemId(String idUser, String idSystem) {
		this.idUser = idUser;
		this.idSystem = idSystem;
	}

	@Column(name = "id_user", nullable = false, length = 200)
	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Column(name = "id_system", nullable = false, length = 10)
	public String getIdSystem() {
		return this.idSystem;
	}

	public void setIdSystem(String idSystem) {
		this.idSystem = idSystem;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VinUsersSystemId))
			return false;
		VinUsersSystemId castOther = (VinUsersSystemId) other;

		return ((this.getIdUser() == castOther.getIdUser()) || (this
				.getIdUser() != null && castOther.getIdUser() != null && this
				.getIdUser().equals(castOther.getIdUser())))
				&& ((this.getIdSystem() == castOther.getIdSystem()) || (this
						.getIdSystem() != null
						&& castOther.getIdSystem() != null && this
						.getIdSystem().equals(castOther.getIdSystem())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdUser() == null ? 0 : this.getIdUser().hashCode());
		result = 37 * result
				+ (getIdSystem() == null ? 0 : this.getIdSystem().hashCode());
		return result;
	}

}
