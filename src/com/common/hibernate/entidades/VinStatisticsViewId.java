package com.common.hibernate.entidades;

// Generated 26-ago-2014 10:48:56 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VinStatisticsViewId generated by hbm2java
 */
@Embeddable
public class VinStatisticsViewId implements java.io.Serializable {

	private int ordinal;
	private String idProcess;
	private String nameProcess;
	private String comment;
	private String idSystem;
	private String nameSystem;
	private String idUser;
	private String userName;
	private String dateExec;
	private String text;

	public VinStatisticsViewId() {
	}

	public VinStatisticsViewId(int ordinal, String nameProcess,
			String idSystem, String nameSystem, String idUser, String userName) {
		this.ordinal = ordinal;
		this.nameProcess = nameProcess;
		this.idSystem = idSystem;
		this.nameSystem = nameSystem;
		this.idUser = idUser;
		this.userName = userName;
	}

	public VinStatisticsViewId(int ordinal, String idProcess,
			String nameProcess, String comment, String idSystem,
			String nameSystem, String idUser, String userName, String dateExec,
			String text) {
		this.ordinal = ordinal;
		this.idProcess = idProcess;
		this.nameProcess = nameProcess;
		this.comment = comment;
		this.idSystem = idSystem;
		this.nameSystem = nameSystem;
		this.idUser = idUser;
		this.userName = userName;
		this.dateExec = dateExec;
		this.text = text;
	}

	@Column(name = "ordinal", nullable = false)
	public int getOrdinal() {
		return this.ordinal;
	}

	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}

	@Column(name = "id_process", length = 200)
	public String getIdProcess() {
		return this.idProcess;
	}

	public void setIdProcess(String idProcess) {
		this.idProcess = idProcess;
	}

	@Column(name = "name_process", nullable = false, length = 200)
	public String getNameProcess() {
		return this.nameProcess;
	}

	public void setNameProcess(String nameProcess) {
		this.nameProcess = nameProcess;
	}

	@Column(name = "comment", length = 250)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "id_system", nullable = false, length = 10)
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

	@Column(name = "id_user", nullable = false, length = 200)
	public String getIdUser() {
		return this.idUser;
	}

	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}

	@Column(name = "user_name", nullable = false, length = 150)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "date_exec", length = 19)
	public String getDateExec() {
		return this.dateExec;
	}

	public void setDateExec(String dateExec) {
		this.dateExec = dateExec;
	}

	@Column(name = "text", length = 250)
	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof VinStatisticsViewId))
			return false;
		VinStatisticsViewId castOther = (VinStatisticsViewId) other;

		return (this.getOrdinal() == castOther.getOrdinal())
				&& ((this.getIdProcess() == castOther.getIdProcess()) || (this
						.getIdProcess() != null
						&& castOther.getIdProcess() != null && this
						.getIdProcess().equals(castOther.getIdProcess())))
				&& ((this.getNameProcess() == castOther.getNameProcess()) || (this
						.getNameProcess() != null
						&& castOther.getNameProcess() != null && this
						.getNameProcess().equals(castOther.getNameProcess())))
				&& ((this.getComment() == castOther.getComment()) || (this
						.getComment() != null && castOther.getComment() != null && this
						.getComment().equals(castOther.getComment())))
				&& ((this.getIdSystem() == castOther.getIdSystem()) || (this
						.getIdSystem() != null
						&& castOther.getIdSystem() != null && this
						.getIdSystem().equals(castOther.getIdSystem())))
				&& ((this.getNameSystem() == castOther.getNameSystem()) || (this
						.getNameSystem() != null
						&& castOther.getNameSystem() != null && this
						.getNameSystem().equals(castOther.getNameSystem())))
				&& ((this.getIdUser() == castOther.getIdUser()) || (this
						.getIdUser() != null && castOther.getIdUser() != null && this
						.getIdUser().equals(castOther.getIdUser())))
				&& ((this.getUserName() == castOther.getUserName()) || (this
						.getUserName() != null
						&& castOther.getUserName() != null && this
						.getUserName().equals(castOther.getUserName())))
				&& ((this.getDateExec() == castOther.getDateExec()) || (this
						.getDateExec() != null
						&& castOther.getDateExec() != null && this
						.getDateExec().equals(castOther.getDateExec())))
				&& ((this.getText() == castOther.getText()) || (this.getText() != null
						&& castOther.getText() != null && this.getText()
						.equals(castOther.getText())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrdinal();
		result = 37 * result
				+ (getIdProcess() == null ? 0 : this.getIdProcess().hashCode());
		result = 37
				* result
				+ (getNameProcess() == null ? 0 : this.getNameProcess()
						.hashCode());
		result = 37 * result
				+ (getComment() == null ? 0 : this.getComment().hashCode());
		result = 37 * result
				+ (getIdSystem() == null ? 0 : this.getIdSystem().hashCode());
		result = 37
				* result
				+ (getNameSystem() == null ? 0 : this.getNameSystem()
						.hashCode());
		result = 37 * result
				+ (getIdUser() == null ? 0 : this.getIdUser().hashCode());
		result = 37 * result
				+ (getUserName() == null ? 0 : this.getUserName().hashCode());
		result = 37 * result
				+ (getDateExec() == null ? 0 : this.getDateExec().hashCode());
		result = 37 * result
				+ (getText() == null ? 0 : this.getText().hashCode());
		return result;
	}

}
