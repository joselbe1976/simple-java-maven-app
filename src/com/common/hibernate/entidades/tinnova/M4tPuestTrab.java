package com.common.hibernate.entidades.tinnova;
// Generated 12-abr-2016 16:30:08 by Hibernate Tools 3.5.0.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * M4tPuestTrab generated by hbm2java
 */
@Entity
@Table(name = "M4T_PUEST_TRAB", schema = "dbo", catalog = "EMIND")
public class M4tPuestTrab implements java.io.Serializable {

	private M4tPuestTrabId id;
	private String NPuesto;
	private String responsabilidades;
	private String tareas;
	private String formacNecesaria;
	private String experienciaMinima;
	private String experiencValorabl;
	private String coment;
	private String formacValorable;
	private Date fecUltActualizac;
	private String idUsuario;
	private String idFamiliaPuesto;
	private String idTipoPuesto;
	private short idNivelSalarial;
	private String idNivSalarExSt;
	private Byte nivelHay;
	private Short puntosHay;
	private String idNivel1Cno94;
	private String idNivel2Cno94;
	private String idCodigoCno94;
	private String idSubcodCno;
	private Set<M4tHistPuestos> m4tHistPuestoses = new HashSet<M4tHistPuestos>(0);

	public M4tPuestTrab() {
	}

	public M4tPuestTrab(M4tPuestTrabId id, String NPuesto, String idFamiliaPuesto, String idTipoPuesto,
			short idNivelSalarial, String idNivSalarExSt, String idNivel1Cno94, String idNivel2Cno94,
			String idCodigoCno94, String idSubcodCno) {
		this.id = id;
		this.NPuesto = NPuesto;
		this.idFamiliaPuesto = idFamiliaPuesto;
		this.idTipoPuesto = idTipoPuesto;
		this.idNivelSalarial = idNivelSalarial;
		this.idNivSalarExSt = idNivSalarExSt;
		this.idNivel1Cno94 = idNivel1Cno94;
		this.idNivel2Cno94 = idNivel2Cno94;
		this.idCodigoCno94 = idCodigoCno94;
		this.idSubcodCno = idSubcodCno;
	}

	public M4tPuestTrab(M4tPuestTrabId id, String NPuesto, String responsabilidades, String tareas,
			String formacNecesaria, String experienciaMinima, String experiencValorabl, String coment,
			String formacValorable, Date fecUltActualizac, String idUsuario, String idFamiliaPuesto,
			String idTipoPuesto, short idNivelSalarial, String idNivSalarExSt, Byte nivelHay, Short puntosHay,
			String idNivel1Cno94, String idNivel2Cno94, String idCodigoCno94, String idSubcodCno,
			Set<M4tHistPuestos> m4tHistPuestoses) {
		this.id = id;
		this.NPuesto = NPuesto;
		this.responsabilidades = responsabilidades;
		this.tareas = tareas;
		this.formacNecesaria = formacNecesaria;
		this.experienciaMinima = experienciaMinima;
		this.experiencValorabl = experiencValorabl;
		this.coment = coment;
		this.formacValorable = formacValorable;
		this.fecUltActualizac = fecUltActualizac;
		this.idUsuario = idUsuario;
		this.idFamiliaPuesto = idFamiliaPuesto;
		this.idTipoPuesto = idTipoPuesto;
		this.idNivelSalarial = idNivelSalarial;
		this.idNivSalarExSt = idNivSalarExSt;
		this.nivelHay = nivelHay;
		this.puntosHay = puntosHay;
		this.idNivel1Cno94 = idNivel1Cno94;
		this.idNivel2Cno94 = idNivel2Cno94;
		this.idCodigoCno94 = idCodigoCno94;
		this.idSubcodCno = idSubcodCno;
		this.m4tHistPuestoses = m4tHistPuestoses;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idSociedad", column = @Column(name = "ID_SOCIEDAD", nullable = false, length = 2) ),
			@AttributeOverride(name = "idPuesto", column = @Column(name = "ID_PUESTO", nullable = false, length = 10) ) })
	public M4tPuestTrabId getId() {
		return this.id;
	}

	public void setId(M4tPuestTrabId id) {
		this.id = id;
	}

	@Column(name = "N_PUESTO", nullable = false, length = 40)
	public String getNPuesto() {
		return this.NPuesto;
	}

	public void setNPuesto(String NPuesto) {
		this.NPuesto = NPuesto;
	}

	@Column(name = "RESPONSABILIDADES")
	public String getResponsabilidades() {
		return this.responsabilidades;
	}

	public void setResponsabilidades(String responsabilidades) {
		this.responsabilidades = responsabilidades;
	}

	@Column(name = "TAREAS")
	public String getTareas() {
		return this.tareas;
	}

	public void setTareas(String tareas) {
		this.tareas = tareas;
	}

	@Column(name = "FORMAC_NECESARIA")
	public String getFormacNecesaria() {
		return this.formacNecesaria;
	}

	public void setFormacNecesaria(String formacNecesaria) {
		this.formacNecesaria = formacNecesaria;
	}

	@Column(name = "EXPERIENCIA_MINIMA")
	public String getExperienciaMinima() {
		return this.experienciaMinima;
	}

	public void setExperienciaMinima(String experienciaMinima) {
		this.experienciaMinima = experienciaMinima;
	}

	@Column(name = "EXPERIENC_VALORABL")
	public String getExperiencValorabl() {
		return this.experiencValorabl;
	}

	public void setExperiencValorabl(String experiencValorabl) {
		this.experiencValorabl = experiencValorabl;
	}

	@Column(name = "COMENT")
	public String getComent() {
		return this.coment;
	}

	public void setComent(String coment) {
		this.coment = coment;
	}

	@Column(name = "FORMAC_VALORABLE")
	public String getFormacValorable() {
		return this.formacValorable;
	}

	public void setFormacValorable(String formacValorable) {
		this.formacValorable = formacValorable;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_ULT_ACTUALIZAC", length = 23)
	public Date getFecUltActualizac() {
		return this.fecUltActualizac;
	}

	public void setFecUltActualizac(Date fecUltActualizac) {
		this.fecUltActualizac = fecUltActualizac;
	}

	@Column(name = "ID_USUARIO", length = 40)
	public String getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Column(name = "ID_FAMILIA_PUESTO", nullable = false, length = 4)
	public String getIdFamiliaPuesto() {
		return this.idFamiliaPuesto;
	}

	public void setIdFamiliaPuesto(String idFamiliaPuesto) {
		this.idFamiliaPuesto = idFamiliaPuesto;
	}

	@Column(name = "ID_TIPO_PUESTO", nullable = false, length = 2)
	public String getIdTipoPuesto() {
		return this.idTipoPuesto;
	}

	public void setIdTipoPuesto(String idTipoPuesto) {
		this.idTipoPuesto = idTipoPuesto;
	}

	@Column(name = "ID_NIVEL_SALARIAL", nullable = false, precision = 3, scale = 0)
	public short getIdNivelSalarial() {
		return this.idNivelSalarial;
	}

	public void setIdNivelSalarial(short idNivelSalarial) {
		this.idNivelSalarial = idNivelSalarial;
	}

	@Column(name = "ID_NIV_SALAR_EX_ST", nullable = false, length = 4)
	public String getIdNivSalarExSt() {
		return this.idNivSalarExSt;
	}

	public void setIdNivSalarExSt(String idNivSalarExSt) {
		this.idNivSalarExSt = idNivSalarExSt;
	}

	@Column(name = "NIVEL_HAY", precision = 2, scale = 0)
	public Byte getNivelHay() {
		return this.nivelHay;
	}

	public void setNivelHay(Byte nivelHay) {
		this.nivelHay = nivelHay;
	}

	@Column(name = "PUNTOS_HAY", precision = 4, scale = 0)
	public Short getPuntosHay() {
		return this.puntosHay;
	}

	public void setPuntosHay(Short puntosHay) {
		this.puntosHay = puntosHay;
	}

	@Column(name = "ID_NIVEL1_CNO94", nullable = false, length = 1)
	public String getIdNivel1Cno94() {
		return this.idNivel1Cno94;
	}

	public void setIdNivel1Cno94(String idNivel1Cno94) {
		this.idNivel1Cno94 = idNivel1Cno94;
	}

	@Column(name = "ID_NIVEL2_CNO94", nullable = false, length = 2)
	public String getIdNivel2Cno94() {
		return this.idNivel2Cno94;
	}

	public void setIdNivel2Cno94(String idNivel2Cno94) {
		this.idNivel2Cno94 = idNivel2Cno94;
	}

	@Column(name = "ID_CODIGO_CNO94", nullable = false, length = 3)
	public String getIdCodigoCno94() {
		return this.idCodigoCno94;
	}

	public void setIdCodigoCno94(String idCodigoCno94) {
		this.idCodigoCno94 = idCodigoCno94;
	}

	@Column(name = "ID_SUBCOD_CNO", nullable = false, length = 4)
	public String getIdSubcodCno() {
		return this.idSubcodCno;
	}

	public void setIdSubcodCno(String idSubcodCno) {
		this.idSubcodCno = idSubcodCno;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "m4tPuestTrab")
	public Set<M4tHistPuestos> getM4tHistPuestoses() {
		return this.m4tHistPuestoses;
	}

	public void setM4tHistPuestoses(Set<M4tHistPuestos> m4tHistPuestoses) {
		this.m4tHistPuestoses = m4tHistPuestoses;
	}

}