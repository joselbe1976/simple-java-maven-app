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
 * M4tTiposAbsentis generated by hbm2java
 */
@Entity
@Table(name = "M4T_TIPOS_ABSENTIS", schema = "dbo", catalog = "EMIND")
public class M4tTiposAbsentis implements java.io.Serializable {

	private String idTipoAbsentismo;
	private String NTipoAbsentismo;
	private String idUsuario;
	private Date fecUltActualizac;
	private String coment;
	private String idTAbsenNomina;
	private Set<M4tAbsentismos> m4tAbsentismoses = new HashSet<M4tAbsentismos>(0);

	public M4tTiposAbsentis() {
	}

	public M4tTiposAbsentis(String idTipoAbsentismo, String NTipoAbsentismo, String idTAbsenNomina) {
		this.idTipoAbsentismo = idTipoAbsentismo;
		this.NTipoAbsentismo = NTipoAbsentismo;
		this.idTAbsenNomina = idTAbsenNomina;
	}

	public M4tTiposAbsentis(String idTipoAbsentismo, String NTipoAbsentismo, String idUsuario, Date fecUltActualizac,
			String coment, String idTAbsenNomina, Set<M4tAbsentismos> m4tAbsentismoses) {
		this.idTipoAbsentismo = idTipoAbsentismo;
		this.NTipoAbsentismo = NTipoAbsentismo;
		this.idUsuario = idUsuario;
		this.fecUltActualizac = fecUltActualizac;
		this.coment = coment;
		this.idTAbsenNomina = idTAbsenNomina;
		this.m4tAbsentismoses = m4tAbsentismoses;
	}

	@Id

	@Column(name = "ID_TIPO_ABSENTISMO", unique = true, nullable = false, length = 2)
	public String getIdTipoAbsentismo() {
		return this.idTipoAbsentismo;
	}

	public void setIdTipoAbsentismo(String idTipoAbsentismo) {
		this.idTipoAbsentismo = idTipoAbsentismo;
	}

	@Column(name = "N_TIPO_ABSENTISMO", nullable = false, length = 40)
	public String getNTipoAbsentismo() {
		return this.NTipoAbsentismo;
	}

	public void setNTipoAbsentismo(String NTipoAbsentismo) {
		this.NTipoAbsentismo = NTipoAbsentismo;
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

	@Column(name = "ID_T_ABSEN_NOMINA", nullable = false, length = 2)
	public String getIdTAbsenNomina() {
		return this.idTAbsenNomina;
	}

	public void setIdTAbsenNomina(String idTAbsenNomina) {
		this.idTAbsenNomina = idTAbsenNomina;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m4tTiposAbsentis")
	public Set<M4tAbsentismos> getM4tAbsentismoses() {
		return this.m4tAbsentismoses;
	}

	public void setM4tAbsentismoses(Set<M4tAbsentismos> m4tAbsentismoses) {
		this.m4tAbsentismoses = m4tAbsentismoses;
	}

}
