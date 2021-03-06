package com.common.hibernate.entidades;

// Generated 26-ago-2014 10:48:56 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * VinParamsUser generated by hbm2java
 */
@Entity
@Table(name = "vin_params_user", catalog = "movilidad")
public class VinParamsUser implements java.io.Serializable {

	private VinParamsUserId id;
	private VinParamsGlobal vinParamsGlobal;
	private VinUsers vinUsers;
	private String value;
	private String comment;

	public VinParamsUser() {
	}

	public VinParamsUser(VinParamsUserId id, VinParamsGlobal vinParamsGlobal,
			VinUsers vinUsers) {
		this.id = id;
		this.vinParamsGlobal = vinParamsGlobal;
		this.vinUsers = vinUsers;
	}

	public VinParamsUser(VinParamsUserId id, VinParamsGlobal vinParamsGlobal,
			VinUsers vinUsers, String value, String comment) {
		this.id = id;
		this.vinParamsGlobal = vinParamsGlobal;
		this.vinUsers = vinUsers;
		this.value = value;
		this.comment = comment;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idUser", column = @Column(name = "id_user", nullable = false, length = 200)),
			@AttributeOverride(name = "idParam", column = @Column(name = "id_param", nullable = false)) })
	public VinParamsUserId getId() {
		return this.id;
	}

	public void setId(VinParamsUserId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_param", nullable = false, insertable = false, updatable = false)
	public VinParamsGlobal getVinParamsGlobal() {
		return this.vinParamsGlobal;
	}

	public void setVinParamsGlobal(VinParamsGlobal vinParamsGlobal) {
		this.vinParamsGlobal = vinParamsGlobal;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false, insertable = false, updatable = false)
	public VinUsers getVinUsers() {
		return this.vinUsers;
	}

	public void setVinUsers(VinUsers vinUsers) {
		this.vinUsers = vinUsers;
	}

	@Column(name = "value", length = 65535)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name = "comment", length = 250)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
