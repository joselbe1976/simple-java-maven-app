package com.common.hibernate.entidades;

// Generated 26-ago-2014 10:48:56 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VinProcessViewId generated by hbm2java
 */
@Embeddable
public class VinProcessViewId implements java.io.Serializable {

	private String idProcess;
	private String name;
	private String idSystem;
	private String nameSystem;
	private String comment;

	public VinProcessViewId() {
	}

	public VinProcessViewId(String idProcess, String name, String nameSystem) {
		this.idProcess = idProcess;
		this.name = name;
		this.nameSystem = nameSystem;
	}

	public VinProcessViewId(String idProcess, String name, String idSystem,
			String nameSystem, String comment) {
		this.idProcess = idProcess;
		this.name = name;
		this.idSystem = idSystem;
		this.nameSystem = nameSystem;
		this.comment = comment;
	}

	@Column(name = "id_process", nullable = false, length = 200)
	public String getIdProcess() {
		return this.idProcess;
	}

	public void setIdProcess(String idProcess) {
		this.idProcess = idProcess;
	}

	@Column(name = "name", nullable = false, length = 200)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "id_system", length = 10)
	public String getIdSystem() {
		return this.idSystem;
	}

	public void setIdSystem(String idSystem) {
		this.idSystem = idSystem;
	}

	@Column(name = "name_system", nullable = false, length = 100)
	public String getNameSystem() {
		return this.nameSystem;
	}

	public void setNameSystem(String nameSystem) {
		this.nameSystem = nameSystem;
	}

	@Column(name = "comment", length = 250)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VinProcessViewId))
			return false;
		VinProcessViewId castOther = (VinProcessViewId) other;

		return ((this.getIdProcess() == castOther.getIdProcess()) || (this
				.getIdProcess() != null && castOther.getIdProcess() != null && this
				.getIdProcess().equals(castOther.getIdProcess())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getIdSystem() == castOther.getIdSystem()) || (this
						.getIdSystem() != null
						&& castOther.getIdSystem() != null && this
						.getIdSystem().equals(castOther.getIdSystem())))
				&& ((this.getNameSystem() == castOther.getNameSystem()) || (this
						.getNameSystem() != null
						&& castOther.getNameSystem() != null && this
						.getNameSystem().equals(castOther.getNameSystem())))
				&& ((this.getComment() == castOther.getComment()) || (this
						.getComment() != null && castOther.getComment() != null && this
						.getComment().equals(castOther.getComment())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getIdProcess() == null ? 0 : this.getIdProcess().hashCode());
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37 * result
				+ (getIdSystem() == null ? 0 : this.getIdSystem().hashCode());
		result = 37
				* result
				+ (getNameSystem() == null ? 0 : this.getNameSystem()
						.hashCode());
		result = 37 * result
				+ (getComment() == null ? 0 : this.getComment().hashCode());
		return result;
	}

}
