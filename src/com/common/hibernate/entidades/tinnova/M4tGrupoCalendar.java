package com.common.hibernate.entidades.tinnova;
// Generated 12-abr-2016 16:30:08 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * M4tGrupoCalendar generated by hbm2java
 */
@Entity
@Table(name = "M4T_GRUPO_CALENDAR", schema = "dbo", catalog = "EMIND")
public class M4tGrupoCalendar implements java.io.Serializable {

	private String idGrupoCalendari;
	private String NGrupoCalendario;
	private String idUsuario;
	private Date fecUltActualizac;
	private String coment;
	private Set<M4tCalendario> m4tCalendarios = new HashSet<M4tCalendario>(0);
	private Set<M4tCentrosTrab> m4tCentrosTrabs = new HashSet<M4tCentrosTrab>(0);

	public M4tGrupoCalendar() {
	}

	public M4tGrupoCalendar(String idGrupoCalendari, String NGrupoCalendario) {
		this.idGrupoCalendari = idGrupoCalendari;
		this.NGrupoCalendario = NGrupoCalendario;
	}

	public M4tGrupoCalendar(String idGrupoCalendari, String NGrupoCalendario, String idUsuario, Date fecUltActualizac,
			String coment, Set<M4tCalendario> m4tCalendarios, Set<M4tCentrosTrab> m4tCentrosTrabs) {
		this.idGrupoCalendari = idGrupoCalendari;
		this.NGrupoCalendario = NGrupoCalendario;
		this.idUsuario = idUsuario;
		this.fecUltActualizac = fecUltActualizac;
		this.coment = coment;
		this.m4tCalendarios = m4tCalendarios;
		this.m4tCentrosTrabs = m4tCentrosTrabs;
	}

	@Id

	@Column(name = "ID_GRUPO_CALENDARI", unique = true, nullable = false, length = 2)
	public String getIdGrupoCalendari() {
		return this.idGrupoCalendari;
	}

	public void setIdGrupoCalendari(String idGrupoCalendari) {
		this.idGrupoCalendari = idGrupoCalendari;
	}

	@Column(name = "N_GRUPO_CALENDARIO", nullable = false, length = 40)
	public String getNGrupoCalendario() {
		return this.NGrupoCalendario;
	}

	public void setNGrupoCalendario(String NGrupoCalendario) {
		this.NGrupoCalendario = NGrupoCalendario;
	}

	@Column(name = "ID_USUARIO", length = 40)
	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_ULT_ACTUALIZAC", length = 23)
	public Date getFecUltActualizac() {
		return this.fecUltActualizac;
	}

	public void setFecUltActualizac(Date fecUltActualizac) {
		this.fecUltActualizac = fecUltActualizac;
	}

	@Column(name = "COMENT")
	public String getComent() {
		return this.coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m4tGrupoCalendar")
	public Set<M4tCalendario> getM4tCalendarios() {
		return this.m4tCalendarios;
	}

	public void setM4tCalendarios(Set<M4tCalendario> m4tCalendarios) {
		this.m4tCalendarios = m4tCalendarios;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m4tGrupoCalendar")
	public Set<M4tCentrosTrab> getM4tCentrosTrabs() {
		return this.m4tCentrosTrabs;
	}

	public void setM4tCentrosTrabs(Set<M4tCentrosTrab> m4tCentrosTrabs) {
		this.m4tCentrosTrabs = m4tCentrosTrabs;
	}

}
