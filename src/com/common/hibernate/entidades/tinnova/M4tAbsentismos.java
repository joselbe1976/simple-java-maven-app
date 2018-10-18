package com.common.hibernate.entidades.tinnova;
// Generated 12-abr-2016 16:30:08 by Hibernate Tools 3.5.0.Final

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * M4tAbsentismos generated by hbm2java
 */
@Entity
@Table(name = "M4T_ABSENTISMOS", schema = "dbo", catalog = "EMIND")
public class M4tAbsentismos implements java.io.Serializable {

	private M4tAbsentismosId id;
	private M4tFasesAlta m4tFasesAlta;
	private M4tTiposAbsentis m4tTiposAbsentis;
	private Date fecFin;
	private String idUsuario;
	private Date fecUltActualizac;
	private String coment;
	private BigDecimal porcMatPrc;
	private String idTpAccidente;
	private String idCausaAccidente;
	private String idDescripcionAccidente;
	private String idParteCuerpo;
	private BigDecimal coefAcHParcSt;
	private String hospitalizacion;
	private Date fecIniRecaida;
	private Date fecFinRecaida;
	private Date fecAltaRecaida;
	private Date fecIniHospi;
	private Date fecFinHospi;

	public M4tAbsentismos() {
	}

	public M4tAbsentismos(M4tAbsentismosId id, M4tFasesAlta m4tFasesAlta, M4tTiposAbsentis m4tTiposAbsentis) {
		this.id = id;
		this.m4tFasesAlta = m4tFasesAlta;
		this.m4tTiposAbsentis = m4tTiposAbsentis;
	}

	public M4tAbsentismos(M4tAbsentismosId id, M4tFasesAlta m4tFasesAlta, M4tTiposAbsentis m4tTiposAbsentis,
			Date fecFin, String idUsuario, Date fecUltActualizac, String coment, BigDecimal porcMatPrc,
			String idTpAccidente, String idCausaAccidente, String idDescripcionAccidente, String idParteCuerpo,
			BigDecimal coefAcHParcSt, String hospitalizacion, Date fecIniRecaida, Date fecFinRecaida,
			Date fecAltaRecaida, Date fecIniHospi, Date fecFinHospi) {
		this.id = id;
		this.m4tFasesAlta = m4tFasesAlta;
		this.m4tTiposAbsentis = m4tTiposAbsentis;
		this.fecFin = fecFin;
		this.idUsuario = idUsuario;
		this.fecUltActualizac = fecUltActualizac;
		this.coment = coment;
		this.porcMatPrc = porcMatPrc;
		this.idTpAccidente = idTpAccidente;
		this.idCausaAccidente = idCausaAccidente;
		this.idDescripcionAccidente = idDescripcionAccidente;
		this.idParteCuerpo = idParteCuerpo;
		this.coefAcHParcSt = coefAcHParcSt;
		this.hospitalizacion = hospitalizacion;
		this.fecIniRecaida = fecIniRecaida;
		this.fecFinRecaida = fecFinRecaida;
		this.fecAltaRecaida = fecAltaRecaida;
		this.fecIniHospi = fecIniHospi;
		this.fecFinHospi = fecFinHospi;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "idSociedad", column = @Column(name = "ID_SOCIEDAD", nullable = false, length = 2) ),
			@AttributeOverride(name = "idEmpleado", column = @Column(name = "ID_EMPLEADO", nullable = false, length = 10) ),
			@AttributeOverride(name = "fecAltaEmpleado", column = @Column(name = "FEC_ALTA_EMPLEADO", nullable = false, length = 23) ),
			@AttributeOverride(name = "fecInicio", column = @Column(name = "FEC_INICIO", nullable = false, length = 23) ) })
	public M4tAbsentismosId getId() {
		return this.id;
	}

	public void setId(M4tAbsentismosId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "ID_SOCIEDAD", referencedColumnName = "ID_SOCIEDAD", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "FEC_ALTA_EMPLEADO", referencedColumnName = "FEC_ALTA_EMPLEADO", nullable = false, insertable = false, updatable = false) })
	public M4tFasesAlta getM4tFasesAlta() {
		return this.m4tFasesAlta;
	}

	public void setM4tFasesAlta(M4tFasesAlta m4tFasesAlta) {
		this.m4tFasesAlta = m4tFasesAlta;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_TIPO_ABSENTISMO", nullable = false)
	public M4tTiposAbsentis getM4tTiposAbsentis() {
		return this.m4tTiposAbsentis;
	}

	public void setM4tTiposAbsentis(M4tTiposAbsentis m4tTiposAbsentis) {
		this.m4tTiposAbsentis = m4tTiposAbsentis;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_FIN", length = 23)
	public Date getFecFin() {
		return this.fecFin;
	}

	public void setFecFin(Date fecFin) {
		this.fecFin = fecFin;
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

	@Column(name = "PORC_MAT_PRC", precision = 5)
	public BigDecimal getPorcMatPrc() {
		return this.porcMatPrc;
	}

	public void setPorcMatPrc(BigDecimal porcMatPrc) {
		this.porcMatPrc = porcMatPrc;
	}

	@Column(name = "ID_TP_ACCIDENTE", length = 1)
	public String getIdTpAccidente() {
		return this.idTpAccidente;
	}

	public void setIdTpAccidente(String idTpAccidente) {
		this.idTpAccidente = idTpAccidente;
	}

	@Column(name = "ID_CAUSA_ACCIDENTE", length = 2)
	public String getIdCausaAccidente() {
		return this.idCausaAccidente;
	}

	public void setIdCausaAccidente(String idCausaAccidente) {
		this.idCausaAccidente = idCausaAccidente;
	}

	@Column(name = "ID_DESCRIPCION_ACCIDENTE", length = 3)
	public String getIdDescripcionAccidente() {
		return this.idDescripcionAccidente;
	}

	public void setIdDescripcionAccidente(String idDescripcionAccidente) {
		this.idDescripcionAccidente = idDescripcionAccidente;
	}

	@Column(name = "ID_PARTE_CUERPO", length = 2)
	public String getIdParteCuerpo() {
		return this.idParteCuerpo;
	}

	public void setIdParteCuerpo(String idParteCuerpo) {
		this.idParteCuerpo = idParteCuerpo;
	}

	@Column(name = "COEF_AC_H_PARC_ST", precision = 14)
	public BigDecimal getCoefAcHParcSt() {
		return this.coefAcHParcSt;
	}

	public void setCoefAcHParcSt(BigDecimal coefAcHParcSt) {
		this.coefAcHParcSt = coefAcHParcSt;
	}

	@Column(name = "HOSPITALIZACION", length = 1)
	public String getHospitalizacion() {
		return this.hospitalizacion;
	}

	public void setHospitalizacion(String hospitalizacion) {
		this.hospitalizacion = hospitalizacion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_INI_RECAIDA", length = 23)
	public Date getFecIniRecaida() {
		return this.fecIniRecaida;
	}

	public void setFecIniRecaida(Date fecIniRecaida) {
		this.fecIniRecaida = fecIniRecaida;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_FIN_RECAIDA", length = 23)
	public Date getFecFinRecaida() {
		return this.fecFinRecaida;
	}

	public void setFecFinRecaida(Date fecFinRecaida) {
		this.fecFinRecaida = fecFinRecaida;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_ALTA_RECAIDA", length = 23)
	public Date getFecAltaRecaida() {
		return this.fecAltaRecaida;
	}

	public void setFecAltaRecaida(Date fecAltaRecaida) {
		this.fecAltaRecaida = fecAltaRecaida;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_INI_HOSPI", length = 23)
	public Date getFecIniHospi() {
		return this.fecIniHospi;
	}

	public void setFecIniHospi(Date fecIniHospi) {
		this.fecIniHospi = fecIniHospi;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_FIN_HOSPI", length = 23)
	public Date getFecFinHospi() {
		return this.fecFinHospi;
	}

	public void setFecFinHospi(Date fecFinHospi) {
		this.fecFinHospi = fecFinHospi;
	}

}
