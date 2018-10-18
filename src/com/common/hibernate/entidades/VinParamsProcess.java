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
 * VinParamsProcess generated by hbm2java
 */
@Entity
@Table(name = "vin_params_process", catalog = "movilidad")
public class VinParamsProcess implements java.io.Serializable {

	private VinParamsProcessId id;
	private VinProcess vinProcess;
	private VinParamsGlobal vinParamsGlobal;
	private String value;
	private String comment;

	public VinParamsProcess() {
	}

	public VinParamsProcess(VinParamsProcessId id, VinProcess vinProcess,
			VinParamsGlobal vinParamsGlobal, String value) {
		this.id = id;
		this.vinProcess = vinProcess;
		this.vinParamsGlobal = vinParamsGlobal;
		this.value = value;
	}

	public VinParamsProcess(VinParamsProcessId id, VinProcess vinProcess,
			VinParamsGlobal vinParamsGlobal, String value, String comment) {
		this.id = id;
		this.vinProcess = vinProcess;
		this.vinParamsGlobal = vinParamsGlobal;
		this.value = value;
		this.comment = comment;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idProcess", column = @Column(name = "id_process", nullable = false, length = 200)),
			@AttributeOverride(name = "idParam", column = @Column(name = "id_param", nullable = false)) })
	public VinParamsProcessId getId() {
		return this.id;
	}

	public void setId(VinParamsProcessId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_process", nullable = false, insertable = false, updatable = false)
	public VinProcess getVinProcess() {
		return this.vinProcess;
	}

	public void setVinProcess(VinProcess vinProcess) {
		this.vinProcess = vinProcess;
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