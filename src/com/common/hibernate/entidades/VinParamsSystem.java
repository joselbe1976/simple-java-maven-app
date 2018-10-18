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
 * VinParamsSystem generated by hbm2java
 */
@Entity
@Table(name = "vin_params_system", catalog = "movilidad")
public class VinParamsSystem implements java.io.Serializable {

	private VinParamsSystemId id;
	private VinSystems vinSystems;
	private VinParamsGlobal vinParamsGlobal;
	private String value;
	private String comment;

	public VinParamsSystem() {
	}

	public VinParamsSystem(VinParamsSystemId id, VinSystems vinSystems,
			VinParamsGlobal vinParamsGlobal, String value) {
		this.id = id;
		this.vinSystems = vinSystems;
		this.vinParamsGlobal = vinParamsGlobal;
		this.value = value;
	}

	public VinParamsSystem(VinParamsSystemId id, VinSystems vinSystems,
			VinParamsGlobal vinParamsGlobal, String value, String comment) {
		this.id = id;
		this.vinSystems = vinSystems;
		this.vinParamsGlobal = vinParamsGlobal;
		this.value = value;
		this.comment = comment;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idSystem", column = @Column(name = "id_system", nullable = false, length = 10)),
			@AttributeOverride(name = "idParam", column = @Column(name = "id_param", nullable = false)) })
	public VinParamsSystemId getId() {
		return this.id;
	}

	public void setId(VinParamsSystemId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_system", nullable = false, insertable = false, updatable = false)
	public VinSystems getVinSystems() {
		return this.vinSystems;
	}

	public void setVinSystems(VinSystems vinSystems) {
		this.vinSystems = vinSystems;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_param", nullable = false, insertable = false, updatable = false)
	public VinParamsGlobal getVinParamsGlobal() {
		return this.vinParamsGlobal;
	}

	public void setVinParamsGlobal(VinParamsGlobal vinParamsGlobal) {
		this.vinParamsGlobal = vinParamsGlobal;
	}

	@Column(name = "value", nullable = false, length = 65535)
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
