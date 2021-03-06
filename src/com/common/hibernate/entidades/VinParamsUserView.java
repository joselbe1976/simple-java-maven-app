package com.common.hibernate.entidades;

// Generated 26-ago-2014 10:48:56 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * VinParamsUserView generated by hbm2java
 */
@Entity
@Table(name = "vin_params_user_view", catalog = "movilidad")
public class VinParamsUserView implements java.io.Serializable {

	private VinParamsUserViewId id;

	public VinParamsUserView() {
	}

	public VinParamsUserView(VinParamsUserViewId id) {
		this.id = id;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "idUser", column = @Column(name = "id_user", nullable = false, length = 200)),
			@AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, length = 150)),
			@AttributeOverride(name = "idParam", column = @Column(name = "id_param", nullable = false)),
			@AttributeOverride(name = "nameParam", column = @Column(name = "name_param", nullable = false, length = 100)),
			@AttributeOverride(name = "value", column = @Column(name = "value", length = 65535)),
			@AttributeOverride(name = "comment", column = @Column(name = "comment", length = 250)),
			@AttributeOverride(name = "commentParam", column = @Column(name = "comment_param", length = 250)) })
	public VinParamsUserViewId getId() {
		return this.id;
	}

	public void setId(VinParamsUserViewId id) {
		this.id = id;
	}

}
