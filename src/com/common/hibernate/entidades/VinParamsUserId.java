package com.common.hibernate.entidades;

// Generated 26-ago-2014 10:48:56 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VinParamsUserId generated by hbm2java
 */
@Embeddable
public class VinParamsUserId implements java.io.Serializable {

	private String idUser;
	private int idParam;

	public VinParamsUserId() {
	}

	public VinParamsUserId(String idUser, int idParam) {
		this.idUser = idUser;
		this.idParam = idParam;
	}

	@Column(name = "id_user", nullable = false, length = 200)
	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Column(name = "id_param", nullable = false)
	public int getIdParam() {
		return this.idParam;
	}

	public void setIdParam(int idParam) {
		this.idParam = idParam;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VinParamsUserId))
			return false;
		VinParamsUserId castOther = (VinParamsUserId) other;

		return ((this.getIdUser() == castOther.getIdUser()) || (this
				.getIdUser() != null && castOther.getIdUser() != null && this
				.getIdUser().equals(castOther.getIdUser())))
				&& (this.getIdParam() == castOther.getIdParam());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdUser() == null ? 0 : this.getIdUser().hashCode());
		result = 37 * result + this.getIdParam();
		return result;
	}

}
