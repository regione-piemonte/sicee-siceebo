/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class SiceeTExportBo.
 */
public class SiceeTExportBo implements Serializable
{

	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_T_EXPORT_BO table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_T_EXPORT_BO table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_T_EXPORT_BO table.
	 */
	protected String anno;

	
	/** 
	 * This attribute maps to the column NUM_CERTIFICATORE in the SICEE_T_CERTIFICATORE table.
	 */
	protected String numCertificatore;

	/** 
	 * This attribute maps to the column NOME in the SICEE_T_CERTIFICATORE table.
	 */
	protected String nome;

	/** 
	 * This attribute maps to the column COGNOME in the SICEE_T_CERTIFICATORE table.
	 */
	protected String cognome;

	/** 
	 * This attribute maps to the column DT_INIZIO in the SICEE_T_EXPORT_BO table.
	 */
	protected Date dtInizio;

	/** 
	 * This attribute maps to the column DT_UPLOAD in the SICEE_T_EXPORT_BO table.
	 */
	protected Date dtUpload;

	/** 
	 * This attribute maps to the column DT_SCADENZA in the SICEE_T_EXPORT_BO table.
	 */
	protected Date dtScadenza;

	/** 
	 * This attribute maps to the column DESC_PROV in the SICEE_T_EXPORT_BO table.
	 */
	protected String descProv;

	/** 
	 * This attribute maps to the column DESC_COMUNE in the SICEE_T_EXPORT_BO table.
	 */
	protected String descComune;

	/** 
	 * This attribute maps to the column GRADI_GIORNO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer gradiGiorno;

	/** 
	 * This attribute maps to the column PIANO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer piano;

	/** 
	 * This attribute maps to the column NUM_PIANI_COMPLESSIVI in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer numPianiComplessivi;

	/** 
	 * This attribute maps to the column FK_STATO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkStato;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_STATO_CERT table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descStato;

	/** 
	 * This attribute maps to the column FK_DEST_USO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkDestUso;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_DEST_USO table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descDestUso;

	/** 
	 * This attribute maps to the column DESC_TIPO_EDIFICIO in the SICEE_T_EXPORT_BO table.
	 */
	protected String descTipoEdificio;
	
	/** 
	 * This attribute maps to the column FK_CARATT_EDIFICIO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkCarattEdificio;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_CARATT_EDIFICIO table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descEdificio;

	/** 
	 * This attribute maps to the column FK_CLASSE in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkClasse;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_CLASSE_ENERGETICA table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descClasse;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_CLASSE_ENERGETICA table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descClasse192_05;

	
	
	/** 
	 * This attribute maps to the column DOM_RISC_QH in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domRiscQh;


	
	
	
	
	

	/** 
	 * This attribute maps to the column ANNO_COSTRUZIONE in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer annoCostruzione;

	/** 
	 * This attribute maps to the column ANNO_ULT_RIST in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer annoUltRist;

	/** 
	 * This attribute maps to the column VOL_LORDO_RISCALDATO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double volLordoRiscaldato;

	/** 
	 * This attribute maps to the column SUP_DISPERDENTE_TOT in the SICEE_T_EXPORT_BO table.
	 */
	protected Double supDisperdenteTot;

	/** 
	 * This attribute maps to the column SU in the SICEE_T_EXPORT_BO table.
	 */
	protected Double su;

	/** 
	 * This attribute maps to the column TRASM_OPACHE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double trasmOpache;

	/** 
	 * This attribute maps to the column TRASM_TRASP in the SICEE_T_EXPORT_BO table.
	 */
	protected Double trasmTrasp;


	
	
	
	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPO_IMPIANTO table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descTipoImpianto;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_COMBUSTIBILE table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descCombRisc;

	
	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_COMBUSTIBILE table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descCombAsc;
	
	
	
	
	
	/** 
	 * This attribute maps to the column FATTORE_FORMA in the SICEE_T_EXPORT_BO table.
	 */
	protected Double fattoreForma;

	/** 
	 * This attribute maps to the column V_SU in the SICEE_T_EXPORT_BO table.
	 */
	protected Double vSu;

	/** 
	 * This attribute maps to the column DOM_RISC_QHTO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domRiscQhto;

	/** 
	 * This attribute maps to the column IND_RISC_EPI in the SICEE_T_EXPORT_BO table.
	 */
	protected Double indRiscEpi;
	
	
	/** 
	 * This attribute maps to the column IND_RISC_EPITO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double indRiscEpito;
	

	/** 
	 * This attribute maps to the column FABB_ACS in the SICEE_T_EXPORT_BO table.
	 */
	protected Double fabbAcs;

	
	
	
	
	/** 
	 * This attribute maps to the column FLG_FABB_MAX_INDICE in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgFabbMaxIndice;

	/** 
	 * This attribute maps to the column VALORE_PREST_PDC in the SICEE_T_EXPORT_BO table.
	 */
	protected Double valorePrestPdc;

	/** 
	 * This attribute maps to the column REND_ACS_ETAGACS in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendAcsEtagacs;

	/** 
	 * This attribute maps to the column DOM_ACS_QHW in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domAcsQhw;

	/** 
	 * This attribute maps to the column EN_ACS_RINNO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double enAcsRinno;

	/** 
	 * This attribute maps to the column REND_IMP_ETAG in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendImpEtag;

	/** 
	 * This attribute maps to the column DOM_ACS_QHW_SU in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domAcsQhwSu;

	/** 
	 * This attribute maps to the column IND_GLOB_EPLORDO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double indGlobEplordo;

	
	/** 
	 * This attribute maps to the column IND_GLOB_EPLORDO_TO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double indGlobEplordoTo;

	/** 
	 * This attribute maps to the column DOM_ACS_QHWTO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double domAcsQhwto;

	/** 
	 * This attribute maps to the column FLG_FABB_ACS in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgFabbAcs;

	/** 
	 * This attribute maps to the column FK_MOTIVO in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer fkMotivo;

	
	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_MOTIVO_RILASCIO table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descMotivo;
	
	/** 
	 * This attribute maps to the column METODOLOGIA_CALCOLO in the SICEE_T_EXPORT_BO table.
	 */
	protected String metodologiaCalcolo;

	/** 
	 * This attribute maps to the column SW_UTILIZZATO in the SICEE_T_EXPORT_BO table.
	 */
	protected String swUtilizzato;

	/** 
	 * This attribute maps to the column DESC_INDIRIZZO in the SICEE_T_EXPORT_BO table.
	 */
	protected String descIndirizzo;

	/** 
	 * This attribute maps to the column NUM_CIVICO in the SICEE_T_EXPORT_BO table.
	 */
	protected String numCivico;

	/** 
	 * This attribute maps to the column SEZIONE in the SICEE_T_EXPORT_BO table.
	 */
	protected String sezione;

	/** 
	 * This attribute maps to the column FOGLIO in the SICEE_T_EXPORT_BO table.
	 */
	protected String foglio;

	/** 
	 * This attribute maps to the column PARTICELLA in the SICEE_T_EXPORT_BO table.
	 */
	protected String particella;

	/** 
	 * This attribute maps to the column SUBALTERNO in the SICEE_T_EXPORT_BO table.
	 */
	protected String subalterno;

	/** 
	 * This attribute maps to the column ID_PROV in the SICEE_T_EXPORT_BO table.
	 */
	protected String idProv;

	/** 
	 * This attribute maps to the column ID_COMUNE in the SICEE_T_EXPORT_BO table.
	 */
	protected String idComune;

	
	/** 
	 * This attribute maps to the column PRESTAZIONE_ENTE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double prestazioneEne;

	
	
	

	
	/** 
	 * This attribute maps to the column NUM_APPARTAMENTI in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer numAppartamenti;

	/** 
	 * This attribute maps to the column UI_SERVITE in the SICEE_T_EXPORT_BO table.
	 */
	protected String uiServite;

	/** 
	 * This attribute maps to the column POT_RISCALDAMENTO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double potRiscaldamento;

	
	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_CLASSE_EFFICIENZA table.
	 * AGGIUNTO MANUALMETE
	 */
	protected String descClasseEff;

	
	/** 
	 * This attribute maps to the column GEN_ANNO_RISC in the SICEE_T_EXPORT_BO table.
	 */
	protected Integer genAnnoRisc;

	/** 
	 * This attribute maps to the column FLG_CONT_RIP in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgContRip;

	
	
	/** 
	 * This attribute maps to the column REND_GENER in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendGener;

	
	
	/** 
	 * This attribute maps to the column REND_REGOL in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendRegol;

	
	/** 
	 * This attribute maps to the column REND_EMISS in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendEmiss;
	
	
	/** 
	 * This attribute maps to the column REND_DISTRIB in the SICEE_T_EXPORT_BO table.
	 */
	protected Double rendDistrib;

	
	/** 
	 * This attribute maps to the column FLG_OLD in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgOld;

	/** 
	 * This attribute maps to the column FLG_EDIF_E0 in the SICEE_T_EXPORT_BO table.
	 */
	protected String flgEdifE0;

	/** 
	 * This attribute maps to the column EPGL_NREN_GLOBALE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double epglNrenGlobale;

	/** 
	 * This attribute maps to the column EPGL_REN_GLOBALE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double epglRenGlobale;

	/** 
	 * This attribute maps to the column EMISSIONI_CO2 in the SICEE_T_EXPORT_BO table.
	 */
	protected Double emissioniCo2;

	/** 
	 * This attribute maps to the column SUP_RAFFRESCATA in the SICEE_T_EXPORT_BO table.
	 */
	protected Double supRaffrescata;

	/** 
	 * This attribute maps to the column SUP_RISCALDATA in the SICEE_T_EXPORT_BO table.
	 */
	protected Double supRiscaldata;

	/** 
	 * This attribute maps to the column VOL_LORDO_RAFFRESCATO in the SICEE_T_EXPORT_BO table.
	 */
	protected Double volLordoRaffrescato;

	/** 
	 * This attribute maps to the column EPH in the SICEE_T_EXPORT_BO table.
	 */
	protected Double eph;

	/** 
	 * This attribute maps to the column ASOL_ASUP in the SICEE_T_EXPORT_BO table.
	 */
	protected Double asolAsup;

	/** 
	 * This attribute maps to the column YIE in the SICEE_T_EXPORT_BO table.
	 */
	protected Double yie;

	/** 
	 * This attribute maps to the column V_SU_RAFF in the SICEE_T_EXPORT_BO table.
	 */
	protected Double vSuRaff;

	/** 
	 * This attribute maps to the column V_SU_RISC in the SICEE_T_EXPORT_BO table.
	 */
	protected Double vSuRisc;

	/** 
	 * This attribute maps to the column S_V_RAFF in the SICEE_T_EXPORT_BO table.
	 */
	protected Double sVRaff;

	/** 
	 * This attribute maps to the column S_V_RISC in the SICEE_T_EXPORT_BO table.
	 */
	protected Double sVRisc;
	
	/**
	 * Method 'SiceeTExportBo'.
	 */
	public SiceeTExportBo()
	{
	}


	/**
	 * Gets the id certificatore.
	 *
	 * @return the id certificatore
	 */
	public String getIdCertificatore() {
		return this.idCertificatore;
	}

	/**
	 * Sets the id certificatore.
	 *
	 * @param idCertificatore the new id certificatore
	 */
	public void setIdCertificatore(String idCertificatore) {
		this.idCertificatore = idCertificatore;
	}

	/**
	 * Gets the progr certificato.
	 *
	 * @return the progr certificato
	 */
	public String getProgrCertificato() {
		return this.progrCertificato;
	}

	/**
	 * Sets the progr certificato.
	 *
	 * @param progrCertificato the new progr certificato
	 */
	public void setProgrCertificato(String progrCertificato) {
		this.progrCertificato = progrCertificato;
	}

	/**
	 * Gets the anno.
	 *
	 * @return the anno
	 */
	public String getAnno() {
		return this.anno;
	}

	/**
	 * Sets the anno.
	 *
	 * @param anno the new anno
	 */
	public void setAnno(String anno) {
		this.anno = anno;
	}

	/**
	 * Gets the num certificatore.
	 *
	 * @return the num certificatore
	 */
	public String getNumCertificatore() {
		return this.numCertificatore;
	}

	/**
	 * Sets the num certificatore.
	 *
	 * @param numCertificatore the new num certificatore
	 */
	public void setNumCertificatore(String numCertificatore) {
		this.numCertificatore = numCertificatore;
	}

	/**
	 * Gets the dt inizio.
	 *
	 * @return the dt inizio
	 */
	public Date getDtInizio() {
		return this.dtInizio;
	}

	/**
	 * Sets the dt inizio.
	 *
	 * @param dtInizio the new dt inizio
	 */
	public void setDtInizio(Date dtInizio) {
		this.dtInizio = dtInizio;
	}

	/**
	 * Gets the dt upload.
	 *
	 * @return the dt upload
	 */
	public Date getDtUpload() {
		return this.dtUpload;
	}

	/**
	 * Sets the dt upload.
	 *
	 * @param dtUpload the new dt upload
	 */
	public void setDtUpload(Date dtUpload) {
		this.dtUpload = dtUpload;
	}
	
	/**
	 * Gets the dt scadenza.
	 *
	 * @return the dt scadenza
	 */
	public Date getDtScadenza() {
		return this.dtScadenza;
	}

	/**
	 * Sets the dt scadenza.
	 *
	 * @param dtScadenza the new dt scadenza
	 */
	public void setDtScadenza(Date dtScadenza) {
		this.dtScadenza = dtScadenza;
	}

	/**
	 * Gets the desc prov.
	 *
	 * @return the desc prov
	 */
	public String getDescProv() {
		return this.descProv;
	}

	/**
	 * Sets the desc prov.
	 *
	 * @param descProv the new desc prov
	 */
	public void setDescProv(String descProv) {
		this.descProv = descProv;
	}

	/**
	 * Gets the desc comune.
	 *
	 * @return the desc comune
	 */
	public String getDescComune() {
		return this.descComune;
	}

	/**
	 * Sets the desc comune.
	 *
	 * @param descComune the new desc comune
	 */
	public void setDescComune(String descComune) {
		this.descComune = descComune;
	}

	/**
	 * Gets the gradi giorno.
	 *
	 * @return the gradi giorno
	 */
	public Integer getGradiGiorno() {
		return this.gradiGiorno;
	}

	/**
	 * Sets the gradi giorno.
	 *
	 * @param gradiGiorno the new gradi giorno
	 */
	public void setGradiGiorno(Integer gradiGiorno) {
		this.gradiGiorno = gradiGiorno;
	}

	/**
	 * Gets the piano.
	 *
	 * @return the piano
	 */
	public Integer getPiano() {
		return this.piano;
	}

	/**
	 * Sets the piano.
	 *
	 * @param piano the new piano
	 */
	public void setPiano(Integer piano) {
		this.piano = piano;
	}

	/**
	 * Gets the num piani complessivi.
	 *
	 * @return the num piani complessivi
	 */
	public Integer getNumPianiComplessivi() {
		return this.numPianiComplessivi;
	}

	/**
	 * Sets the num piani complessivi.
	 *
	 * @param numPianiComplessivi the new num piani complessivi
	 */
	public void setNumPianiComplessivi(Integer numPianiComplessivi) {
		this.numPianiComplessivi = numPianiComplessivi;
	}

	/**
	 * Gets the fk stato.
	 *
	 * @return the fk stato
	 */
	public Integer getFkStato() {
		return this.fkStato;
	}

	/**
	 * Sets the fk stato.
	 *
	 * @param fkStato the new fk stato
	 */
	public void setFkStato(Integer fkStato) {
		this.fkStato = fkStato;
	}

	/**
	 * Gets the desc stato.
	 *
	 * @return the desc stato
	 */
	public String getDescStato() {
		return this.descStato;
	}

	/**
	 * Sets the desc stato.
	 *
	 * @param descStato the new desc stato
	 */
	public void setDescStato(String descStato) {
		this.descStato = descStato;
	}

	/**
	 * Gets the fk dest uso.
	 *
	 * @return the fk dest uso
	 */
	public Integer getFkDestUso() {
		return this.fkDestUso;
	}

	/**
	 * Sets the fk dest uso.
	 *
	 * @param fkDestUso the new fk dest uso
	 */
	public void setFkDestUso(Integer fkDestUso) {
		this.fkDestUso = fkDestUso;
	}

	/**
	 * Gets the desc dest uso.
	 *
	 * @return the desc dest uso
	 */
	public String getDescDestUso() {
		return this.descDestUso;
	}

	/**
	 * Sets the desc dest uso.
	 *
	 * @param descDestUso the new desc dest uso
	 */
	public void setDescDestUso(String descDestUso) {
		this.descDestUso = descDestUso;
	}

	/**
	 * Gets the desc tipo edificio.
	 *
	 * @return the desc tipo edificio
	 */
	public String getDescTipoEdificio() {
		return this.descTipoEdificio;
	}

	/**
	 * Sets the desc tipo edificio.
	 *
	 * @param descTipoEdificio the new desc tipo edificio
	 */
	public void setDescTipoEdificio(String descTipoEdificio) {
		this.descTipoEdificio = descTipoEdificio;
	}

	/**
	 * Gets the fk caratt edificio.
	 *
	 * @return the fk caratt edificio
	 */
	public Integer getFkCarattEdificio() {
		return this.fkCarattEdificio;
	}

	/**
	 * Sets the fk caratt edificio.
	 *
	 * @param fkCarattEdificio the new fk caratt edificio
	 */
	public void setFkCarattEdificio(Integer fkCarattEdificio) {
		this.fkCarattEdificio = fkCarattEdificio;
	}

	/**
	 * Gets the desc edificio.
	 *
	 * @return the desc edificio
	 */
	public String getDescEdificio() {
		return this.descEdificio;
	}

	/**
	 * Sets the desc edificio.
	 *
	 * @param descEdificio the new desc edificio
	 */
	public void setDescEdificio(String descEdificio) {
		this.descEdificio = descEdificio;
	}

	/**
	 * Gets the fk classe.
	 *
	 * @return the fk classe
	 */
	public Integer getFkClasse() {
		return this.fkClasse;
	}

	/**
	 * Sets the fk classe.
	 *
	 * @param fkClasse the new fk classe
	 */
	public void setFkClasse(Integer fkClasse) {
		this.fkClasse = fkClasse;
	}

	/**
	 * Gets the desc classe.
	 *
	 * @return the desc classe
	 */
	public String getDescClasse() {
		return this.descClasse;
	}

	/**
	 * Sets the desc classe.
	 *
	 * @param descClasse the new desc classe
	 */
	public void setDescClasse(String descClasse) {
		this.descClasse = descClasse;
	}

	/**
	 * Gets the anno costruzione.
	 *
	 * @return the anno costruzione
	 */
	public Integer getAnnoCostruzione() {
		return this.annoCostruzione;
	}

	/**
	 * Sets the anno costruzione.
	 *
	 * @param annoCostruzione the new anno costruzione
	 */
	public void setAnnoCostruzione(Integer annoCostruzione) {
		this.annoCostruzione = annoCostruzione;
	}

	/**
	 * Gets the anno ult rist.
	 *
	 * @return the anno ult rist
	 */
	public Integer getAnnoUltRist() {
		return this.annoUltRist;
	}

	/**
	 * Sets the anno ult rist.
	 *
	 * @param annoUltRist the new anno ult rist
	 */
	public void setAnnoUltRist(Integer annoUltRist) {
		this.annoUltRist = annoUltRist;
	}

	/**
	 * Gets the vol lordo riscaldato.
	 *
	 * @return the vol lordo riscaldato
	 */
	public Double getVolLordoRiscaldato() {
		return this.volLordoRiscaldato;
	}

	/**
	 * Sets the vol lordo riscaldato.
	 *
	 * @param volLordoRiscaldato the new vol lordo riscaldato
	 */
	public void setVolLordoRiscaldato(Double volLordoRiscaldato) {
		this.volLordoRiscaldato = volLordoRiscaldato;
	}

	/**
	 * Gets the sup disperdente tot.
	 *
	 * @return the sup disperdente tot
	 */
	public Double getSupDisperdenteTot() {
		return this.supDisperdenteTot;
	}

	/**
	 * Sets the sup disperdente tot.
	 *
	 * @param supDisperdenteTot the new sup disperdente tot
	 */
	public void setSupDisperdenteTot(Double supDisperdenteTot) {
		this.supDisperdenteTot = supDisperdenteTot;
	}

	/**
	 * Gets the su.
	 *
	 * @return the su
	 */
	public Double getSu() {
		return this.su;
	}

	/**
	 * Sets the su.
	 *
	 * @param su the new su
	 */
	public void setSu(Double su) {
		this.su = su;
	}

	/**
	 * Gets the trasm opache.
	 *
	 * @return the trasm opache
	 */
	public Double getTrasmOpache() {
		return this.trasmOpache;
	}

	/**
	 * Sets the trasm opache.
	 *
	 * @param trasmOpache the new trasm opache
	 */
	public void setTrasmOpache(Double trasmOpache) {
		this.trasmOpache = trasmOpache;
	}

	/**
	 * Gets the trasm trasp.
	 *
	 * @return the trasm trasp
	 */
	public Double getTrasmTrasp() {
		return this.trasmTrasp;
	}

	/**
	 * Sets the trasm trasp.
	 *
	 * @param trasmTrasp the new trasm trasp
	 */
	public void setTrasmTrasp(Double trasmTrasp) {
		this.trasmTrasp = trasmTrasp;
	}

	/**
	 * Gets the fattore forma.
	 *
	 * @return the fattore forma
	 */
	public Double getFattoreForma() {
		return this.fattoreForma;
	}

	/**
	 * Sets the fattore forma.
	 *
	 * @param fattoreForma the new fattore forma
	 */
	public void setFattoreForma(Double fattoreForma) {
		this.fattoreForma = fattoreForma;
	}

	/**
	 * Gets the v su.
	 *
	 * @return the v su
	 */
	public Double getvSu() {
		return this.vSu;
	}

	/**
	 * Sets the v su.
	 *
	 * @param vSu the new v su
	 */
	public void setvSu(Double vSu) {
		this.vSu = vSu;
	}

	/**
	 * Gets the dom risc qhto.
	 *
	 * @return the dom risc qhto
	 */
	public Double getDomRiscQhto() {
		return this.domRiscQhto;
	}

	/**
	 * Sets the dom risc qhto.
	 *
	 * @param domRiscQhto the new dom risc qhto
	 */
	public void setDomRiscQhto(Double domRiscQhto) {
		this.domRiscQhto = domRiscQhto;
	}

	/**
	 * Gets the ind risc epito.
	 *
	 * @return the ind risc epito
	 */
	public Double getIndRiscEpito() {
		return this.indRiscEpito;
	}

	/**
	 * Sets the ind risc epito.
	 *
	 * @param indRiscEpito the new ind risc epito
	 */
	public void setIndRiscEpito(Double indRiscEpito) {
		this.indRiscEpito = indRiscEpito;
	}

	/**
	 * Gets the flg fabb max indice.
	 *
	 * @return the flg fabb max indice
	 */
	public String getFlgFabbMaxIndice() {
		return this.flgFabbMaxIndice;
	}

	/**
	 * Sets the flg fabb max indice.
	 *
	 * @param flgFabbMaxIndice the new flg fabb max indice
	 */
	public void setFlgFabbMaxIndice(String flgFabbMaxIndice) {
		this.flgFabbMaxIndice = flgFabbMaxIndice;
	}

	/**
	 * Gets the valore prest pdc.
	 *
	 * @return the valore prest pdc
	 */
	public Double getValorePrestPdc() {
		return this.valorePrestPdc;
	}

	/**
	 * Sets the valore prest pdc.
	 *
	 * @param valorePrestPdc the new valore prest pdc
	 */
	public void setValorePrestPdc(Double valorePrestPdc) {
		this.valorePrestPdc = valorePrestPdc;
	}

	/**
	 * Gets the rend acs etagacs.
	 *
	 * @return the rend acs etagacs
	 */
	public Double getRendAcsEtagacs() {
		return this.rendAcsEtagacs;
	}

	/**
	 * Sets the rend acs etagacs.
	 *
	 * @param rendAcsEtagacs the new rend acs etagacs
	 */
	public void setRendAcsEtagacs(Double rendAcsEtagacs) {
		this.rendAcsEtagacs = rendAcsEtagacs;
	}

	/**
	 * Gets the dom acs qhw.
	 *
	 * @return the dom acs qhw
	 */
	public Double getDomAcsQhw() {
		return this.domAcsQhw;
	}

	/**
	 * Sets the dom acs qhw.
	 *
	 * @param domAcsQhw the new dom acs qhw
	 */
	public void setDomAcsQhw(Double domAcsQhw) {
		this.domAcsQhw = domAcsQhw;
	}

	/**
	 * Gets the en acs rinno.
	 *
	 * @return the en acs rinno
	 */
	public Double getEnAcsRinno() {
		return this.enAcsRinno;
	}

	/**
	 * Sets the en acs rinno.
	 *
	 * @param enAcsRinno the new en acs rinno
	 */
	public void setEnAcsRinno(Double enAcsRinno) {
		this.enAcsRinno = enAcsRinno;
	}

	/**
	 * Gets the rend imp etag.
	 *
	 * @return the rend imp etag
	 */
	public Double getRendImpEtag() {
		return this.rendImpEtag;
	}

	/**
	 * Sets the rend imp etag.
	 *
	 * @param rendImpEtag the new rend imp etag
	 */
	public void setRendImpEtag(Double rendImpEtag) {
		this.rendImpEtag = rendImpEtag;
	}

	/**
	 * Gets the dom acs qhw su.
	 *
	 * @return the dom acs qhw su
	 */
	public Double getDomAcsQhwSu() {
		return this.domAcsQhwSu;
	}

	/**
	 * Sets the dom acs qhw su.
	 *
	 * @param domAcsQhwSu the new dom acs qhw su
	 */
	public void setDomAcsQhwSu(Double domAcsQhwSu) {
		this.domAcsQhwSu = domAcsQhwSu;
	}

	/**
	 * Gets the ind glob eplordo.
	 *
	 * @return the ind glob eplordo
	 */
	public Double getIndGlobEplordo() {
		return this.indGlobEplordo;
	}

	/**
	 * Sets the ind glob eplordo.
	 *
	 * @param indGlobEplordo the new ind glob eplordo
	 */
	public void setIndGlobEplordo(Double indGlobEplordo) {
		this.indGlobEplordo = indGlobEplordo;
	}

	/**
	 * Gets the dom acs qhwto.
	 *
	 * @return the dom acs qhwto
	 */
	public Double getDomAcsQhwto() {
		return this.domAcsQhwto;
	}

	/**
	 * Sets the dom acs qhwto.
	 *
	 * @param domAcsQhwto the new dom acs qhwto
	 */
	public void setDomAcsQhwto(Double domAcsQhwto) {
		this.domAcsQhwto = domAcsQhwto;
	}

	/**
	 * Gets the flg fabb acs.
	 *
	 * @return the flg fabb acs
	 */
	public String getFlgFabbAcs() {
		return this.flgFabbAcs;
	}

	/**
	 * Sets the flg fabb acs.
	 *
	 * @param flgFabbAcs the new flg fabb acs
	 */
	public void setFlgFabbAcs(String flgFabbAcs) {
		this.flgFabbAcs = flgFabbAcs;
	}

	/**
	 * Gets the fk motivo.
	 *
	 * @return the fk motivo
	 */
	public Integer getFkMotivo() {
		return this.fkMotivo;
	}

	/**
	 * Sets the fk motivo.
	 *
	 * @param fkMotivo the new fk motivo
	 */
	public void setFkMotivo(Integer fkMotivo) {
		this.fkMotivo = fkMotivo;
	}

	/**
	 * Gets the desc motivo.
	 *
	 * @return the desc motivo
	 */
	public String getDescMotivo() {
		return this.descMotivo;
	}

	/**
	 * Sets the desc motivo.
	 *
	 * @param descMotivo the new desc motivo
	 */
	public void setDescMotivo(String descMotivo) {
		this.descMotivo = descMotivo;
	}

	/**
	 * Gets the metodologia calcolo.
	 *
	 * @return the metodologia calcolo
	 */
	public String getMetodologiaCalcolo() {
		return this.metodologiaCalcolo;
	}

	/**
	 * Sets the metodologia calcolo.
	 *
	 * @param metodologiaCalcolo the new metodologia calcolo
	 */
	public void setMetodologiaCalcolo(String metodologiaCalcolo) {
		this.metodologiaCalcolo = metodologiaCalcolo;
	}

	/**
	 * Gets the sw utilizzato.
	 *
	 * @return the sw utilizzato
	 */
	public String getSwUtilizzato() {
		return this.swUtilizzato;
	}

	/**
	 * Sets the sw utilizzato.
	 *
	 * @param swUtilizzato the new sw utilizzato
	 */
	public void setSwUtilizzato(String swUtilizzato) {
		this.swUtilizzato = swUtilizzato;
	}

	/**
	 * Gets the desc indirizzo.
	 *
	 * @return the desc indirizzo
	 */
	public String getDescIndirizzo() {
		return this.descIndirizzo;
	}

	/**
	 * Sets the desc indirizzo.
	 *
	 * @param descIndirizzo the new desc indirizzo
	 */
	public void setDescIndirizzo(String descIndirizzo) {
		this.descIndirizzo = descIndirizzo;
	}

	/**
	 * Gets the num civico.
	 *
	 * @return the num civico
	 */
	public String getNumCivico() {
		return this.numCivico;
	}

	/**
	 * Sets the num civico.
	 *
	 * @param numCivico the new num civico
	 */
	public void setNumCivico(String numCivico) {
		this.numCivico = numCivico;
	}

	/**
	 * Gets the sezione.
	 *
	 * @return the sezione
	 */
	public String getSezione() {
		return this.sezione;
	}

	/**
	 * Sets the sezione.
	 *
	 * @param sezione the new sezione
	 */
	public void setSezione(String sezione) {
		this.sezione = sezione;
	}

	/**
	 * Gets the foglio.
	 *
	 * @return the foglio
	 */
	public String getFoglio() {
		return this.foglio;
	}

	/**
	 * Sets the foglio.
	 *
	 * @param foglio the new foglio
	 */
	public void setFoglio(String foglio) {
		this.foglio = foglio;
	}

	/**
	 * Gets the particella.
	 *
	 * @return the particella
	 */
	public String getParticella() {
		return this.particella;
	}

	/**
	 * Sets the particella.
	 *
	 * @param particella the new particella
	 */
	public void setParticella(String particella) {
		this.particella = particella;
	}

	/**
	 * Gets the subalterno.
	 *
	 * @return the subalterno
	 */
	public String getSubalterno() {
		return this.subalterno;
	}

	/**
	 * Sets the subalterno.
	 *
	 * @param subalterno the new subalterno
	 */
	public void setSubalterno(String subalterno) {
		this.subalterno = subalterno;
	}
	
	/**
	 * Method 'getIdProv'.
	 *
	 * @return String
	 */
	public String getIdProv()
	{
		return this.idProv;
	}

	/**
	 * Method 'setIdProv'.
	 *
	 * @param idProv the new id prov
	 */
	public void setIdProv(String idProv)
	{
		this.idProv = idProv;
	}

	/**
	 * Method 'getIdComune'.
	 *
	 * @return String
	 */
	public String getIdComune()
	{
		return this.idComune;
	}

	/**
	 * Method 'setIdComune'.
	 *
	 * @param idComune the new id comune
	 */
	public void setIdComune(String idComune)
	{
		this.idComune = idComune;
	}
	
	/**
	 * Gets the nome.
	 *
	 * @return the nome
	 */
	public String getNome() {
		return this.nome;
	}


	/**
	 * Sets the nome.
	 *
	 * @param nome the new nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}


	/**
	 * Gets the cognome.
	 *
	 * @return the cognome
	 */
	public String getCognome() {
		return this.cognome;
	}


	/**
	 * Sets the cognome.
	 *
	 * @param cognome the new cognome
	 */
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}


	/**
	 * Gets the desc classe192_05.
	 *
	 * @return the desc classe192_05
	 */
	public String getDescClasse192_05() {
		return this.descClasse192_05;
	}


	/**
	 * Sets the desc classe192_05.
	 *
	 * @param descClasse192_05 the new desc classe192_05
	 */
	public void setDescClasse192_05(String descClasse192_05) {
		this.descClasse192_05 = descClasse192_05;
	}


	/**
	 * Gets the dom risc qh.
	 *
	 * @return the dom risc qh
	 */
	public Double getDomRiscQh() {
		return this.domRiscQh;
	}


	/**
	 * Sets the dom risc qh.
	 *
	 * @param domRiscQh the new dom risc qh
	 */
	public void setDomRiscQh(Double domRiscQh) {
		this.domRiscQh = domRiscQh;
	}


	/**
	 * Gets the desc tipo impianto.
	 *
	 * @return the desc tipo impianto
	 */
	public String getDescTipoImpianto() {
		return this.descTipoImpianto;
	}


	/**
	 * Sets the desc tipo impianto.
	 *
	 * @param descTipoImpianto the new desc tipo impianto
	 */
	public void setDescTipoImpianto(String descTipoImpianto) {
		this.descTipoImpianto = descTipoImpianto;
	}


	/**
	 * Gets the desc comb risc.
	 *
	 * @return the desc comb risc
	 */
	public String getDescCombRisc() {
		return this.descCombRisc;
	}


	/**
	 * Sets the desc comb risc.
	 *
	 * @param descCombRisc the new desc comb risc
	 */
	public void setDescCombRisc(String descCombRisc) {
		this.descCombRisc = descCombRisc;
	}


	/**
	 * Gets the desc comb asc.
	 *
	 * @return the desc comb asc
	 */
	public String getDescCombAsc() {
		return this.descCombAsc;
	}


	/**
	 * Sets the desc comb asc.
	 *
	 * @param descCombAsc the new desc comb asc
	 */
	public void setDescCombAsc(String descCombAsc) {
		this.descCombAsc = descCombAsc;
	}


	/**
	 * Gets the ind risc epi.
	 *
	 * @return the ind risc epi
	 */
	public Double getIndRiscEpi() {
		return this.indRiscEpi;
	}


	/**
	 * Sets the ind risc epi.
	 *
	 * @param indRiscEpi the new ind risc epi
	 */
	public void setIndRiscEpi(Double indRiscEpi) {
		this.indRiscEpi = indRiscEpi;
	}


	/**
	 * Gets the fabb acs.
	 *
	 * @return the fabb acs
	 */
	public Double getFabbAcs() {
		return this.fabbAcs;
	}


	/**
	 * Sets the fabb acs.
	 *
	 * @param fabbAcs the new fabb acs
	 */
	public void setFabbAcs(Double fabbAcs) {
		this.fabbAcs = fabbAcs;
	}


	/**
	 * Gets the ind glob eplordo to.
	 *
	 * @return the ind glob eplordo to
	 */
	public Double getIndGlobEplordoTo() {
		return this.indGlobEplordoTo;
	}


	/**
	 * Sets the ind glob eplordo to.
	 *
	 * @param indGlobEplordoTo the new ind glob eplordo to
	 */
	public void setIndGlobEplordoTo(Double indGlobEplordoTo) {
		this.indGlobEplordoTo = indGlobEplordoTo;
	}


	/**
	 * Gets the prestazione ene.
	 *
	 * @return the prestazione ene
	 */
	public Double getPrestazioneEne() {
		return this.prestazioneEne;
	}


	/**
	 * Sets the prestazione ene.
	 *
	 * @param prestazioneEne the new prestazione ene
	 */
	public void setPrestazioneEne(Double prestazioneEne) {
		this.prestazioneEne = prestazioneEne;
	}


	/**
	 * Gets the num appartamenti.
	 *
	 * @return the num appartamenti
	 */
	public Integer getNumAppartamenti() {
		return this.numAppartamenti;
	}


	/**
	 * Sets the num appartamenti.
	 *
	 * @param numAppartamenti the new num appartamenti
	 */
	public void setNumAppartamenti(Integer numAppartamenti) {
		this.numAppartamenti = numAppartamenti;
	}


	/**
	 * Gets the ui servite.
	 *
	 * @return the ui servite
	 */
	public String getUiServite() {
		return this.uiServite;
	}


	/**
	 * Sets the ui servite.
	 *
	 * @param uiServite the new ui servite
	 */
	public void setUiServite(String uiServite) {
		this.uiServite = uiServite;
	}


	/**
	 * Gets the pot riscaldamento.
	 *
	 * @return the pot riscaldamento
	 */
	public Double getPotRiscaldamento() {
		return this.potRiscaldamento;
	}


	/**
	 * Sets the pot riscaldamento.
	 *
	 * @param potRiscaldamento the new pot riscaldamento
	 */
	public void setPotRiscaldamento(Double potRiscaldamento) {
		this.potRiscaldamento = potRiscaldamento;
	}


	/**
	 * Gets the desc classe eff.
	 *
	 * @return the desc classe eff
	 */
	public String getDescClasseEff() {
		return this.descClasseEff;
	}


	/**
	 * Sets the desc classe eff.
	 *
	 * @param descClasseEff the new desc classe eff
	 */
	public void setDescClasseEff(String descClasseEff) {
		this.descClasseEff = descClasseEff;
	}


	/**
	 * Gets the gen anno risc.
	 *
	 * @return the gen anno risc
	 */
	public Integer getGenAnnoRisc() {
		return this.genAnnoRisc;
	}


	/**
	 * Sets the gen anno risc.
	 *
	 * @param genAnnoRisc the new gen anno risc
	 */
	public void setGenAnnoRisc(Integer genAnnoRisc) {
		this.genAnnoRisc = genAnnoRisc;
	}


	/**
	 * Gets the flg cont rip.
	 *
	 * @return the flg cont rip
	 */
	public String getFlgContRip() {
		return this.flgContRip;
	}


	/**
	 * Sets the flg cont rip.
	 *
	 * @param flgContRip the new flg cont rip
	 */
	public void setFlgContRip(String flgContRip) {
		this.flgContRip = flgContRip;
	}


	/**
	 * Gets the rend gener.
	 *
	 * @return the rend gener
	 */
	public Double getRendGener() {
		return this.rendGener;
	}


	/**
	 * Sets the rend gener.
	 *
	 * @param rendGener the new rend gener
	 */
	public void setRendGener(Double rendGener) {
		this.rendGener = rendGener;
	}


	/**
	 * Gets the rend regol.
	 *
	 * @return the rend regol
	 */
	public Double getRendRegol() {
		return this.rendRegol;
	}


	/**
	 * Sets the rend regol.
	 *
	 * @param rendRegol the new rend regol
	 */
	public void setRendRegol(Double rendRegol) {
		this.rendRegol = rendRegol;
	}


	/**
	 * Gets the rend emiss.
	 *
	 * @return the rend emiss
	 */
	public Double getRendEmiss() {
		return this.rendEmiss;
	}


	/**
	 * Sets the rend emiss.
	 *
	 * @param rendEmiss the new rend emiss
	 */
	public void setRendEmiss(Double rendEmiss) {
		this.rendEmiss = rendEmiss;
	}


	/**
	 * Gets the rend distrib.
	 *
	 * @return the rend distrib
	 */
	public Double getRendDistrib() {
		return this.rendDistrib;
	}


	/**
	 * Sets the rend distrib.
	 *
	 * @param rendDistrib the new rend distrib
	 */
	public void setRendDistrib(Double rendDistrib) {
		this.rendDistrib = rendDistrib;
	}


	/**
	 * Method 'getFlgOld'
	 * 
	 * @return String
	 */
	public String getFlgOld()
	{
		return flgOld;
	}

	/**
	 * Method 'setFlgOld'
	 * 
	 * @param flgOld
	 */
	public void setFlgOld(String flgOld)
	{
		this.flgOld = flgOld;
	}

	/**
	 * Method 'getFlgEdifE0'
	 * 
	 * @return String
	 */
	public String getFlgEdifE0()
	{
		return flgEdifE0;
	}

	/**
	 * Method 'setFlgEdifE0'
	 * 
	 * @param flgEdifE0
	 */
	public void setFlgEdifE0(String flgEdifE0)
	{
		this.flgEdifE0 = flgEdifE0;
	}

	/**
	 * Method 'getEpglNrenGlobale'
	 * 
	 * @return Double
	 */
	public Double getEpglNrenGlobale()
	{
		return epglNrenGlobale;
	}

	/**
	 * Method 'setEpglNrenGlobale'
	 * 
	 * @param epglNrenGlobale
	 */
	public void setEpglNrenGlobale(Double epglNrenGlobale)
	{
		this.epglNrenGlobale = epglNrenGlobale;
	}

	/**
	 * Method 'getEpglRenGlobale'
	 * 
	 * @return Double
	 */
	public Double getEpglRenGlobale()
	{
		return epglRenGlobale;
	}

	/**
	 * Method 'setEpglRenGlobale'
	 * 
	 * @param epglRenGlobale
	 */
	public void setEpglRenGlobale(Double epglRenGlobale)
	{
		this.epglRenGlobale = epglRenGlobale;
	}

	/**
	 * Method 'getEmissioniCo2'
	 * 
	 * @return Double
	 */
	public Double getEmissioniCo2()
	{
		return emissioniCo2;
	}

	/**
	 * Method 'setEmissioniCo2'
	 * 
	 * @param emissioniCo2
	 */
	public void setEmissioniCo2(Double emissioniCo2)
	{
		this.emissioniCo2 = emissioniCo2;
	}

	/**
	 * Method 'getSupRaffrescata'
	 * 
	 * @return Double
	 */
	public Double getSupRaffrescata()
	{
		return supRaffrescata;
	}

	/**
	 * Method 'setSupRaffrescata'
	 * 
	 * @param supRaffrescata
	 */
	public void setSupRaffrescata(Double supRaffrescata)
	{
		this.supRaffrescata = supRaffrescata;
	}

	/**
	 * Method 'getSupRiscaldata'
	 * 
	 * @return Double
	 */
	public Double getSupRiscaldata()
	{
		return supRiscaldata;
	}

	/**
	 * Method 'setSupRiscaldata'
	 * 
	 * @param supRiscaldata
	 */
	public void setSupRiscaldata(Double supRiscaldata)
	{
		this.supRiscaldata = supRiscaldata;
	}

	/**
	 * Method 'getVolLordoRaffrescato'
	 * 
	 * @return Double
	 */
	public Double getVolLordoRaffrescato()
	{
		return volLordoRaffrescato;
	}

	/**
	 * Method 'setVolLordoRaffrescato'
	 * 
	 * @param volLordoRaffrescato
	 */
	public void setVolLordoRaffrescato(Double volLordoRaffrescato)
	{
		this.volLordoRaffrescato = volLordoRaffrescato;
	}

	/**
	 * Method 'getEph'
	 * 
	 * @return Double
	 */
	public Double getEph()
	{
		return eph;
	}

	/**
	 * Method 'setEph'
	 * 
	 * @param eph
	 */
	public void setEph(Double eph)
	{
		this.eph = eph;
	}

	/**
	 * Method 'getAsolAsup'
	 * 
	 * @return Double
	 */
	public Double getAsolAsup()
	{
		return asolAsup;
	}

	/**
	 * Method 'setAsolAsup'
	 * 
	 * @param asolAsup
	 */
	public void setAsolAsup(Double asolAsup)
	{
		this.asolAsup = asolAsup;
	}

	/**
	 * Method 'getYie'
	 * 
	 * @return Double
	 */
	public Double getYie()
	{
		return yie;
	}

	/**
	 * Method 'setYie'
	 * 
	 * @param yie
	 */
	public void setYie(Double yie)
	{
		this.yie = yie;
	}

	/**
	 * Method 'getVSuRaff'
	 * 
	 * @return Double
	 */
	public Double getVSuRaff()
	{
		return vSuRaff;
	}

	/**
	 * Method 'setVSuRaff'
	 * 
	 * @param vSuRaff
	 */
	public void setVSuRaff(Double vSuRaff)
	{
		this.vSuRaff = vSuRaff;
	}

	/**
	 * Method 'getVSuRisc'
	 * 
	 * @return Double
	 */
	public Double getVSuRisc()
	{
		return vSuRisc;
	}

	/**
	 * Method 'setVSuRisc'
	 * 
	 * @param vSuRisc
	 */
	public void setVSuRisc(Double vSuRisc)
	{
		this.vSuRisc = vSuRisc;
	}

	/**
	 * Method 'getSVRaff'
	 * 
	 * @return Double
	 */
	public Double getSVRaff()
	{
		return sVRaff;
	}

	/**
	 * Method 'setSVRaff'
	 * 
	 * @param sVRaff
	 */
	public void setSVRaff(Double sVRaff)
	{
		this.sVRaff = sVRaff;
	}

	/**
	 * Method 'getSVRisc'
	 * 
	 * @return Double
	 */
	public Double getSVRisc()
	{
		return sVRisc;
	}

	/**
	 * Method 'setSVRisc'
	 * 
	 * @param sVRisc
	 */
	public void setSVRisc(Double sVRisc)
	{
		this.sVRisc = sVRisc;
	}
	
	/**
	 * Method 'equals'.
	 *
	 * @param _other the _other
	 * @return boolean
	 */
	@Override
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeTExportBo)) {
			return false;
		}
		
		final SiceeTExportBo _cast = (SiceeTExportBo) _other;
		if (this.idCertificatore == null ? _cast.idCertificatore != this.idCertificatore : !this.idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (this.progrCertificato == null ? _cast.progrCertificato != this.progrCertificato : !this.progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (this.anno == null ? _cast.anno != this.anno : !this.anno.equals( _cast.anno )) {
			return false;
		}

		if (this.numCertificatore == null ? _cast.numCertificatore != this.numCertificatore : !this.numCertificatore.equals( _cast.numCertificatore )) {
			return false;
		}

		if (this.dtInizio == null ? _cast.dtInizio != this.dtInizio : !this.dtInizio.equals( _cast.dtInizio )) {
			return false;
		}
		
		if (this.dtUpload == null ? _cast.dtUpload != this.dtUpload : !this.dtUpload.equals( _cast.dtUpload )) {
			return false;
		}
		
		if (this.descProv == null ? _cast.descProv != this.descProv : !this.descProv.equals( _cast.descProv )) {
			return false;
		}
		
		if (this.descComune == null ? _cast.descComune != this.descComune : !this.descComune.equals( _cast.descComune )) {
			return false;
		}
		
		if (this.gradiGiorno == null ? _cast.gradiGiorno != this.gradiGiorno : !this.gradiGiorno.equals( _cast.gradiGiorno )) {
			return false;
		}
		
		if (this.piano == null ? _cast.piano != this.piano : !this.piano.equals( _cast.piano )) {
			return false;
		}
		
		if (this.numPianiComplessivi == null ? _cast.numPianiComplessivi != this.numPianiComplessivi : !this.numPianiComplessivi.equals( _cast.numPianiComplessivi )) {
			return false;
		}
		
		if (this.fkStato == null ? _cast.fkStato != this.fkStato : !this.fkStato.equals( _cast.fkStato )) {
			return false;
		}

		if (this.descStato == null ? _cast.descStato != this.descStato : !this.descStato.equals( _cast.descStato )) {
			return false;
		}

		if (this.fkDestUso == null ? _cast.fkDestUso != this.fkDestUso : !this.fkDestUso.equals( _cast.fkDestUso )) {
			return false;
		}

		if (this.descDestUso == null ? _cast.descDestUso != this.descDestUso : !this.descDestUso.equals( _cast.descDestUso )) {
			return false;
		}

		if (this.descTipoEdificio == null ? _cast.descTipoEdificio != this.descTipoEdificio : !this.descTipoEdificio.equals( _cast.descTipoEdificio )) {
			return false;
		}
		
		if (this.fkCarattEdificio == null ? _cast.fkCarattEdificio != this.fkCarattEdificio : !this.fkCarattEdificio.equals( _cast.fkCarattEdificio )) {
			return false;
		}

		if (this.descEdificio == null ? _cast.descEdificio != this.descEdificio : !this.descEdificio.equals( _cast.descEdificio )) {
			return false;
		}

		if (this.fkClasse == null ? _cast.fkClasse != this.fkClasse : !this.fkClasse.equals( _cast.fkClasse )) {
			return false;
		}

		if (this.descClasse == null ? _cast.descClasse != this.descClasse : !this.descClasse.equals( _cast.descClasse )) {
			return false;
		}

		if (this.annoCostruzione == null ? _cast.annoCostruzione != this.annoCostruzione : !this.annoCostruzione.equals( _cast.annoCostruzione )) {
			return false;
		}
		
		if (this.annoUltRist == null ? _cast.annoUltRist != this.annoUltRist : !this.annoUltRist.equals( _cast.annoUltRist )) {
			return false;
		}
		
		if (this.volLordoRiscaldato == null ? _cast.volLordoRiscaldato != this.volLordoRiscaldato : !this.volLordoRiscaldato.equals( _cast.volLordoRiscaldato )) {
			return false;
		}
		
		if (this.supDisperdenteTot == null ? _cast.supDisperdenteTot != this.supDisperdenteTot : !this.supDisperdenteTot.equals( _cast.supDisperdenteTot )) {
			return false;
		}
		
		if (this.su == null ? _cast.su != this.su : !this.su.equals( _cast.su )) {
			return false;
		}
		
		if (this.trasmOpache == null ? _cast.trasmOpache != this.trasmOpache : !this.trasmOpache.equals( _cast.trasmOpache )) {
			return false;
		}
		
		if (this.trasmTrasp == null ? _cast.trasmTrasp != this.trasmTrasp : !this.trasmTrasp.equals( _cast.trasmTrasp )) {
			return false;
		}
		
		if (this.fattoreForma == null ? _cast.fattoreForma != this.fattoreForma : !this.fattoreForma.equals( _cast.fattoreForma )) {
			return false;
		}
		
		if (this.vSu == null ? _cast.vSu != this.vSu : !this.vSu.equals( _cast.vSu )) {
			return false;
		}
		
		if (this.domRiscQhto == null ? _cast.domRiscQhto != this.domRiscQhto : !this.domRiscQhto.equals( _cast.domRiscQhto )) {
			return false;
		}
		
		if (this.indRiscEpito == null ? _cast.indRiscEpito != this.indRiscEpito : !this.indRiscEpito.equals( _cast.indRiscEpito )) {
			return false;
		}
		
		if (this.flgFabbMaxIndice == null ? _cast.flgFabbMaxIndice != this.flgFabbMaxIndice : !this.flgFabbMaxIndice.equals( _cast.flgFabbMaxIndice )) {
			return false;
		}
		
		if (this.valorePrestPdc == null ? _cast.valorePrestPdc != this.valorePrestPdc : !this.valorePrestPdc.equals( _cast.valorePrestPdc )) {
			return false;
		}
		
		if (this.rendAcsEtagacs == null ? _cast.rendAcsEtagacs != this.rendAcsEtagacs : !this.rendAcsEtagacs.equals( _cast.rendAcsEtagacs )) {
			return false;
		}
		
		if (this.domAcsQhw == null ? _cast.domAcsQhw != this.domAcsQhw : !this.domAcsQhw.equals( _cast.domAcsQhw )) {
			return false;
		}
		
		if (this.enAcsRinno == null ? _cast.enAcsRinno != this.enAcsRinno : !this.enAcsRinno.equals( _cast.enAcsRinno )) {
			return false;
		}
		
		if (this.rendImpEtag == null ? _cast.rendImpEtag != this.rendImpEtag : !this.rendImpEtag.equals( _cast.rendImpEtag )) {
			return false;
		}
		
		if (this.domAcsQhwSu == null ? _cast.domAcsQhwSu != this.domAcsQhwSu : !this.domAcsQhwSu.equals( _cast.domAcsQhwSu )) {
			return false;
		}
		
		if (this.indGlobEplordo == null ? _cast.indGlobEplordo != this.indGlobEplordo : !this.indGlobEplordo.equals( _cast.indGlobEplordo )) {
			return false;
		}
		
		if (this.domAcsQhwto == null ? _cast.domAcsQhwto != this.domAcsQhwto : !this.domAcsQhwto.equals( _cast.domAcsQhwto )) {
			return false;
		}
		
		if (this.flgFabbAcs == null ? _cast.flgFabbAcs != this.flgFabbAcs : !this.flgFabbAcs.equals( _cast.flgFabbAcs )) {
			return false;
		}
		
		if (this.fkMotivo == null ? _cast.fkMotivo != this.fkMotivo : !this.fkMotivo.equals( _cast.fkMotivo )) {
			return false;
		}

		if (this.descMotivo == null ? _cast.descMotivo != this.descMotivo : !this.descMotivo.equals( _cast.descMotivo )) {
			return false;
		}

		if (this.metodologiaCalcolo == null ? _cast.metodologiaCalcolo != this.metodologiaCalcolo : !this.metodologiaCalcolo.equals( _cast.metodologiaCalcolo )) {
			return false;
		}
		
		if (this.swUtilizzato == null ? _cast.swUtilizzato != this.swUtilizzato : !this.swUtilizzato.equals( _cast.swUtilizzato )) {
			return false;
		}
		
		if (this.descIndirizzo == null ? _cast.descIndirizzo != this.descIndirizzo : !this.descIndirizzo.equals( _cast.descIndirizzo )) {
			return false;
		}
		
		if (this.numCivico == null ? _cast.numCivico != this.numCivico : !this.numCivico.equals( _cast.numCivico )) {
			return false;
		}
		
		if (this.sezione == null ? _cast.sezione != this.sezione : !this.sezione.equals( _cast.sezione )) {
			return false;
		}
		
		if (this.foglio == null ? _cast.foglio != this.foglio : !this.foglio.equals( _cast.foglio )) {
			return false;
		}
		
		if (this.particella == null ? _cast.particella != this.particella : !this.particella.equals( _cast.particella )) {
			return false;
		}
		
		if (this.subalterno == null ? _cast.subalterno != this.subalterno : !this.subalterno.equals( _cast.subalterno )) {
			return false;
		}

		if (this.idComune == null ? _cast.idComune != this.idComune : !this.idComune.equals( _cast.idComune )) {
			return false;
		}

		if (this.idProv == null ? _cast.idProv != this.idProv : !this.idProv.equals( _cast.idProv )) {
			return false;
		}

		if (this.nome == null ? _cast.nome != this.nome : !this.nome.equals( _cast.nome )) {
			return false;
		}
		if (this.cognome == null ? _cast.cognome != this.cognome : !this.cognome.equals( _cast.cognome )) {
			return false;
		}
		if (this.descClasse192_05 == null ? _cast.descClasse192_05 != this.descClasse192_05 : !this.descClasse192_05.equals( _cast.descClasse192_05 )) {
			return false;
		}
		if (this.domRiscQh == null ? _cast.domRiscQh != this.domRiscQh : !this.domRiscQh.equals( _cast.domRiscQh )) {
			return false;
		}
		if (this.descTipoImpianto == null ? _cast.descTipoImpianto != this.descTipoImpianto : !this.descTipoImpianto.equals( _cast.descTipoImpianto )) {
			return false;
		}
		if (this.descCombRisc == null ? _cast.descCombRisc != this.descCombRisc : !this.descCombRisc.equals( _cast.descCombRisc )) {
			return false;
		}
		if (this.descCombAsc == null ? _cast.descCombAsc != this.descCombAsc : !this.descCombAsc.equals( _cast.descCombAsc )) {
			return false;
		}
		if (this.indRiscEpi == null ? _cast.indRiscEpi != this.indRiscEpi : !this.indRiscEpi.equals( _cast.indRiscEpi )) {
			return false;
		}
		if (this.fabbAcs == null ? _cast.fabbAcs != this.fabbAcs : !this.fabbAcs.equals( _cast.fabbAcs )) {
			return false;
		}
		if (this.indGlobEplordoTo == null ? _cast.indGlobEplordoTo != this.indGlobEplordoTo : !this.indGlobEplordoTo.equals( _cast.indGlobEplordoTo )) {
			return false;
		}
		if (this.prestazioneEne == null ? _cast.prestazioneEne != this.prestazioneEne : !this.prestazioneEne.equals( _cast.prestazioneEne )) {
			return false;
		}
		if (this.numAppartamenti == null ? _cast.numAppartamenti != this.numAppartamenti : !this.numAppartamenti.equals( _cast.numAppartamenti )) {
			return false;
		}
		if (this.uiServite == null ? _cast.uiServite != this.uiServite : !this.uiServite.equals( _cast.uiServite )) {
			return false;
		}
		if (this.potRiscaldamento == null ? _cast.potRiscaldamento != this.potRiscaldamento : !this.potRiscaldamento.equals( _cast.potRiscaldamento )) {
			return false;
		}
		if (this.descClasseEff == null ? _cast.descClasseEff != this.descClasseEff : !this.descClasseEff.equals( _cast.descClasseEff )) {
			return false;
		}
		if (this.genAnnoRisc == null ? _cast.genAnnoRisc != this.genAnnoRisc : !this.genAnnoRisc.equals( _cast.genAnnoRisc )) {
			return false;
		}
		if (this.flgContRip == null ? _cast.flgContRip != this.flgContRip : !this.flgContRip.equals( _cast.flgContRip )) {
			return false;
		}
		if (this.rendGener == null ? _cast.rendGener != this.rendGener : !this.rendGener.equals( _cast.rendGener )) {
			return false;
		}
		if (this.rendRegol == null ? _cast.rendRegol != this.rendRegol : !this.rendRegol.equals( _cast.rendRegol )) {
			return false;
		}
		if (this.rendEmiss == null ? _cast.rendEmiss != this.rendEmiss : !this.rendEmiss.equals( _cast.rendEmiss )) {
			return false;
		}
		if (this.rendDistrib == null ? _cast.rendDistrib != this.rendDistrib : !this.rendDistrib.equals( _cast.rendDistrib )) {
			return false;
		}
		

		if (flgOld == null ? _cast.flgOld != flgOld : !flgOld.equals( _cast.flgOld )) {
			return false;
		}
		
		if (flgEdifE0 == null ? _cast.flgEdifE0 != flgEdifE0 : !flgEdifE0.equals( _cast.flgEdifE0 )) {
			return false;
		}
		
		if (epglNrenGlobale == null ? _cast.epglNrenGlobale != epglNrenGlobale : !epglNrenGlobale.equals( _cast.epglNrenGlobale )) {
			return false;
		}
		
		if (epglRenGlobale == null ? _cast.epglRenGlobale != epglRenGlobale : !epglRenGlobale.equals( _cast.epglRenGlobale )) {
			return false;
		}
		
		if (emissioniCo2 == null ? _cast.emissioniCo2 != emissioniCo2 : !emissioniCo2.equals( _cast.emissioniCo2 )) {
			return false;
		}
		
		if (supRaffrescata == null ? _cast.supRaffrescata != supRaffrescata : !supRaffrescata.equals( _cast.supRaffrescata )) {
			return false;
		}
		
		if (supRiscaldata == null ? _cast.supRiscaldata != supRiscaldata : !supRiscaldata.equals( _cast.supRiscaldata )) {
			return false;
		}
		
		if (volLordoRaffrescato == null ? _cast.volLordoRaffrescato != volLordoRaffrescato : !volLordoRaffrescato.equals( _cast.volLordoRaffrescato )) {
			return false;
		}
		
		if (eph == null ? _cast.eph != eph : !eph.equals( _cast.eph )) {
			return false;
		}
		
		if (asolAsup == null ? _cast.asolAsup != asolAsup : !asolAsup.equals( _cast.asolAsup )) {
			return false;
		}
		
		if (yie == null ? _cast.yie != yie : !yie.equals( _cast.yie )) {
			return false;
		}
		
		if (vSuRaff == null ? _cast.vSuRaff != vSuRaff : !vSuRaff.equals( _cast.vSuRaff )) {
			return false;
		}
		
		if (vSuRisc == null ? _cast.vSuRisc != vSuRisc : !vSuRisc.equals( _cast.vSuRisc )) {
			return false;
		}
		
		if (sVRaff == null ? _cast.sVRaff != sVRaff : !sVRaff.equals( _cast.sVRaff )) {
			return false;
		}
		
		if (sVRisc == null ? _cast.sVRisc != sVRisc : !sVRisc.equals( _cast.sVRisc )) {
			return false;
		}
		return true;
	}

	/**
	 * Method 'hashCode'.
	 *
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		int _hashCode = 0;
		if (this.idCertificatore != null) {
			_hashCode = 29 * _hashCode + this.idCertificatore.hashCode();
		}
		
		if (this.progrCertificato != null) {
			_hashCode = 29 * _hashCode + this.progrCertificato.hashCode();
		}
		
		if (this.anno != null) {
			_hashCode = 29 * _hashCode + this.anno.hashCode();
		}

		if (this.numCertificatore != null) {
			_hashCode = 29 * _hashCode + this.numCertificatore.hashCode();
		}

		if (this.dtInizio != null) {
			_hashCode = 29 * _hashCode + this.dtInizio.hashCode();
		}
		
		if (this.dtUpload != null) {
			_hashCode = 29 * _hashCode + this.dtUpload.hashCode();
		}
		
		if (this.descProv != null) {
			_hashCode = 29 * _hashCode + this.descProv.hashCode();
		}
		
		if (this.descComune != null) {
			_hashCode = 29 * _hashCode + this.descComune.hashCode();
		}
		
		if (this.gradiGiorno != null) {
			_hashCode = 29 * _hashCode + this.gradiGiorno.hashCode();
		}
		
		if (this.piano != null) {
			_hashCode = 29 * _hashCode + this.piano.hashCode();
		}
		
		if (this.numPianiComplessivi != null) {
			_hashCode = 29 * _hashCode + this.numPianiComplessivi.hashCode();
		}
		
		if (this.fkStato != null) {
			_hashCode = 29 * _hashCode + this.fkStato.hashCode();
		}

		if (this.descStato != null) {
			_hashCode = 29 * _hashCode + this.descStato.hashCode();
		}

		if (this.fkDestUso != null) {
			_hashCode = 29 * _hashCode + this.fkDestUso.hashCode();
		}

		if (this.descDestUso != null) {
			_hashCode = 29 * _hashCode + this.descDestUso.hashCode();
		}

		if (this.descTipoEdificio != null) {
			_hashCode = 29 * _hashCode + this.descTipoEdificio.hashCode();
		}
		
		if (this.fkCarattEdificio != null) {
			_hashCode = 29 * _hashCode + this.fkCarattEdificio.hashCode();
		}

		if (this.descEdificio != null) {
			_hashCode = 29 * _hashCode + this.descEdificio.hashCode();
		}

		if (this.fkClasse != null) {
			_hashCode = 29 * _hashCode + this.fkClasse.hashCode();
		}

		if (this.descClasse != null) {
			_hashCode = 29 * _hashCode + this.descClasse.hashCode();
		}

		if (this.annoCostruzione != null) {
			_hashCode = 29 * _hashCode + this.annoCostruzione.hashCode();
		}
		
		if (this.annoUltRist != null) {
			_hashCode = 29 * _hashCode + this.annoUltRist.hashCode();
		}
		
		if (this.volLordoRiscaldato != null) {
			_hashCode = 29 * _hashCode + this.volLordoRiscaldato.hashCode();
		}
		
		if (this.supDisperdenteTot != null) {
			_hashCode = 29 * _hashCode + this.supDisperdenteTot.hashCode();
		}
		
		if (this.su != null) {
			_hashCode = 29 * _hashCode + this.su.hashCode();
		}
		
		if (this.trasmOpache != null) {
			_hashCode = 29 * _hashCode + this.trasmOpache.hashCode();
		}
		
		if (this.trasmTrasp != null) {
			_hashCode = 29 * _hashCode + this.trasmTrasp.hashCode();
		}
		
		if (this.fattoreForma != null) {
			_hashCode = 29 * _hashCode + this.fattoreForma.hashCode();
		}
		
		if (this.vSu != null) {
			_hashCode = 29 * _hashCode + this.vSu.hashCode();
		}
		
		if (this.domRiscQhto != null) {
			_hashCode = 29 * _hashCode + this.domRiscQhto.hashCode();
		}
		
		if (this.indRiscEpito != null) {
			_hashCode = 29 * _hashCode + this.indRiscEpito.hashCode();
		}
		
		if (this.flgFabbMaxIndice != null) {
			_hashCode = 29 * _hashCode + this.flgFabbMaxIndice.hashCode();
		}
		
		if (this.valorePrestPdc != null) {
			_hashCode = 29 * _hashCode + this.valorePrestPdc.hashCode();
		}
		
		if (this.rendAcsEtagacs != null) {
			_hashCode = 29 * _hashCode + this.rendAcsEtagacs.hashCode();
		}
		
		if (this.domAcsQhw != null) {
			_hashCode = 29 * _hashCode + this.domAcsQhw.hashCode();
		}
		
		if (this.enAcsRinno != null) {
			_hashCode = 29 * _hashCode + this.enAcsRinno.hashCode();
		}
		
		if (this.rendImpEtag != null) {
			_hashCode = 29 * _hashCode + this.rendImpEtag.hashCode();
		}
		
		if (this.domAcsQhwSu != null) {
			_hashCode = 29 * _hashCode + this.domAcsQhwSu.hashCode();
		}
		
		if (this.indGlobEplordo != null) {
			_hashCode = 29 * _hashCode + this.indGlobEplordo.hashCode();
		}
		
		if (this.domAcsQhwto != null) {
			_hashCode = 29 * _hashCode + this.domAcsQhwto.hashCode();
		}
		
		if (this.flgFabbAcs != null) {
			_hashCode = 29 * _hashCode + this.flgFabbAcs.hashCode();
		}
		
		if (this.fkMotivo != null) {
			_hashCode = 29 * _hashCode + this.fkMotivo.hashCode();
		}

		if (this.descMotivo != null) {
			_hashCode = 29 * _hashCode + this.descMotivo.hashCode();
		}

		if (this.metodologiaCalcolo != null) {
			_hashCode = 29 * _hashCode + this.metodologiaCalcolo.hashCode();
		}
		
		if (this.swUtilizzato != null) {
			_hashCode = 29 * _hashCode + this.swUtilizzato.hashCode();
		}
		
		if (this.descIndirizzo != null) {
			_hashCode = 29 * _hashCode + this.descIndirizzo.hashCode();
		}
		
		if (this.numCivico != null) {
			_hashCode = 29 * _hashCode + this.numCivico.hashCode();
		}
		
		if (this.sezione != null) {
			_hashCode = 29 * _hashCode + this.sezione.hashCode();
		}
		
		if (this.foglio != null) {
			_hashCode = 29 * _hashCode + this.foglio.hashCode();
		}
		
		if (this.particella != null) {
			_hashCode = 29 * _hashCode + this.particella.hashCode();
		}
		
		if (this.subalterno != null) {
			_hashCode = 29 * _hashCode + this.subalterno.hashCode();
		}

		if (this.idComune != null) {
			_hashCode = 29 * _hashCode + this.idComune.hashCode();
		}

		if (this.idProv != null) {
			_hashCode = 29 * _hashCode + this.idProv.hashCode();
		}

		if (this.nome != null) {
			_hashCode = 29 * _hashCode + this.nome.hashCode();
		}

		if (this.cognome != null) {
			_hashCode = 29 * _hashCode + this.cognome.hashCode();
		}

		if (this.descClasse192_05 != null) {
			_hashCode = 29 * _hashCode + this.descClasse192_05.hashCode();
		}

		if (this.domRiscQh != null) {
			_hashCode = 29 * _hashCode + this.domRiscQh.hashCode();
		}

		if (this.descTipoImpianto != null) {
			_hashCode = 29 * _hashCode + this.descTipoImpianto.hashCode();
		}

		if (this.descCombRisc != null) {
			_hashCode = 29 * _hashCode + this.descCombRisc.hashCode();
		}

		if (this.descCombAsc != null) {
			_hashCode = 29 * _hashCode + this.descCombAsc.hashCode();
		}

		if (this.indRiscEpi != null) {
			_hashCode = 29 * _hashCode + this.indRiscEpi.hashCode();
		}

		if (this.fabbAcs != null) {
			_hashCode = 29 * _hashCode + this.fabbAcs.hashCode();
		}

		if (this.indGlobEplordoTo != null) {
			_hashCode = 29 * _hashCode + this.indGlobEplordoTo.hashCode();
		}

		if (this.prestazioneEne != null) {
			_hashCode = 29 * _hashCode + this.prestazioneEne.hashCode();
		}

		if (this.numAppartamenti != null) {
			_hashCode = 29 * _hashCode + this.numAppartamenti.hashCode();
		}

		if (this.uiServite != null) {
			_hashCode = 29 * _hashCode + this.uiServite.hashCode();
		}

		if (this.potRiscaldamento != null) {
			_hashCode = 29 * _hashCode + this.potRiscaldamento.hashCode();
		}

		if (this.descClasseEff != null) {
			_hashCode = 29 * _hashCode + this.descClasseEff.hashCode();
		}

		if (this.genAnnoRisc != null) {
			_hashCode = 29 * _hashCode + this.genAnnoRisc.hashCode();
		}

		if (this.flgContRip != null) {
			_hashCode = 29 * _hashCode + this.flgContRip.hashCode();
		}

		if (this.rendGener != null) {
			_hashCode = 29 * _hashCode + this.rendGener.hashCode();
		}

		if (this.rendRegol != null) {
			_hashCode = 29 * _hashCode + this.rendRegol.hashCode();
		}

		if (this.rendEmiss != null) {
			_hashCode = 29 * _hashCode + this.rendEmiss.hashCode();
		}

		if (this.rendDistrib != null) {
			_hashCode = 29 * _hashCode + this.rendDistrib.hashCode();
		}


		if (flgOld != null) {
			_hashCode = 29 * _hashCode + flgOld.hashCode();
		}
		
		if (flgEdifE0 != null) {
			_hashCode = 29 * _hashCode + flgEdifE0.hashCode();
		}
		
		if (epglNrenGlobale != null) {
			_hashCode = 29 * _hashCode + epglNrenGlobale.hashCode();
		}
		
		if (epglRenGlobale != null) {
			_hashCode = 29 * _hashCode + epglRenGlobale.hashCode();
		}
		
		if (emissioniCo2 != null) {
			_hashCode = 29 * _hashCode + emissioniCo2.hashCode();
		}
		
		if (supRaffrescata != null) {
			_hashCode = 29 * _hashCode + supRaffrescata.hashCode();
		}
		
		if (supRiscaldata != null) {
			_hashCode = 29 * _hashCode + supRiscaldata.hashCode();
		}
		
		if (volLordoRaffrescato != null) {
			_hashCode = 29 * _hashCode + volLordoRaffrescato.hashCode();
		}
		
		if (eph != null) {
			_hashCode = 29 * _hashCode + eph.hashCode();
		}
		
		if (asolAsup != null) {
			_hashCode = 29 * _hashCode + asolAsup.hashCode();
		}
		
		if (yie != null) {
			_hashCode = 29 * _hashCode + yie.hashCode();
		}
		
		if (vSuRaff != null) {
			_hashCode = 29 * _hashCode + vSuRaff.hashCode();
		}
		
		if (vSuRisc != null) {
			_hashCode = 29 * _hashCode + vSuRisc.hashCode();
		}
		
		if (sVRaff != null) {
			_hashCode = 29 * _hashCode + sVRaff.hashCode();
		}
		
		if (sVRisc != null) {
			_hashCode = 29 * _hashCode + sVRisc.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'.
	 *
	 * @return SiceeTExportBoPk
	 */
	public SiceeTExportBoPk createPk()
	{
		return new SiceeTExportBoPk(this.idCertificatore, this.progrCertificato, this.anno);
	}

	/**
	 * Method 'toString'.
	 *
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBo: " );
		ret.append( "idCertificatore=" + this.idCertificatore );
		ret.append( ", progrCertificato=" + this.progrCertificato );
		ret.append( ", anno=" + this.anno );
		ret.append( ", numCertificatore=" + this.numCertificatore );
		ret.append( ", dtInizio=" + this.dtInizio );
		ret.append( ", dtUpload=" + this.dtUpload );
		ret.append( ", descProv=" + this.descProv );
		ret.append( ", descComune=" + this.descComune );
		ret.append( ", gradiGiorno=" + this.gradiGiorno );
		ret.append( ", piano=" + this.piano );
		ret.append( ", numPianiComplessivi=" + this.numPianiComplessivi );
		ret.append( ", fkStato=" + this.fkStato );
		ret.append( ", descStato=" + this.descStato );
		ret.append( ", fkDestUso=" + this.fkDestUso );
		ret.append( ", descDestUso=" + this.descDestUso );
		ret.append( ", descTipoEdificio=" + this.descTipoEdificio );
		ret.append( ", fkCarattEdificio=" + this.fkCarattEdificio );
		ret.append( ", descEdificio=" + this.descEdificio );
		ret.append( ", fkClasse=" + this.fkClasse );
		ret.append( ", descClasse=" + this.descClasse );
		ret.append( ", annoCostruzione=" + this.annoCostruzione );
		ret.append( ", annoUltRist=" + this.annoUltRist );
		ret.append( ", volLordoRiscaldato=" + this.volLordoRiscaldato );
		ret.append( ", supDisperdenteTot=" + this.supDisperdenteTot );
		ret.append( ", su=" + this.su );
		ret.append( ", trasmOpache=" + this.trasmOpache );
		ret.append( ", trasmTrasp=" + this.trasmTrasp );
		ret.append( ", fattoreForma=" + this.fattoreForma );
		ret.append( ", vSu=" + this.vSu );
		ret.append( ", domRiscQhto=" + this.domRiscQhto );
		ret.append( ", indRiscEpito=" + this.indRiscEpito );
		ret.append( ", flgFabbMaxIndice=" + this.flgFabbMaxIndice );
		ret.append( ", valorePrestPdc=" + this.valorePrestPdc );
		ret.append( ", rendAcsEtagacs=" + this.rendAcsEtagacs );
		ret.append( ", domAcsQhw=" + this.domAcsQhw );
		ret.append( ", enAcsRinno=" + this.enAcsRinno );
		ret.append( ", rendImpEtag=" + this.rendImpEtag );
		ret.append( ", domAcsQhwSu=" + this.domAcsQhwSu );
		ret.append( ", indGlobEplordo=" + this.indGlobEplordo );
		ret.append( ", domAcsQhwto=" + this.domAcsQhwto );
		ret.append( ", flgFabbAcs=" + this.flgFabbAcs );
		ret.append( ", fkMotivo=" + this.fkMotivo );
		ret.append( ", descMotivo=" + this.descMotivo );
		ret.append( ", metodologiaCalcolo=" + this.metodologiaCalcolo );
		ret.append( ", swUtilizzato=" + this.swUtilizzato );
		ret.append( ", descIndirizzo=" + this.descIndirizzo );
		ret.append( ", numCivico=" + this.numCivico );
		ret.append( ", sezione=" + this.sezione );
		ret.append( ", foglio=" + this.foglio );
		ret.append( ", particella=" + this.particella );
		ret.append( ", subalterno=" + this.subalterno );
		ret.append( ", idComune=" + this.idComune );
		ret.append( ", idProv=" + this.idProv );

		
		ret.append( ", nome=" + this.nome );
		ret.append( ", cognome=" + this.cognome );
		ret.append( ", descClasse192_05=" + this.descClasse192_05 );
		ret.append( ", domRiscQh=" + this.domRiscQh );
		ret.append( ", descTipoImpianto=" + this.descTipoImpianto );
		ret.append( ", descCombRisc=" + this.descCombRisc );
		ret.append( ", descCombAsc=" + this.descCombAsc );
		ret.append( ", indRiscEpi=" + this.indRiscEpi );
		ret.append( ", fabbAcs=" + this.fabbAcs );
		ret.append( ", indGlobEplordoTo=" + this.indGlobEplordoTo );
		ret.append( ", prestazioneEne=" + this.prestazioneEne );
		ret.append( ", numAppartamenti=" + this.numAppartamenti );
		ret.append( ", uiServite=" + this.uiServite );
		ret.append( ", potRiscaldamento=" + this.potRiscaldamento );
		ret.append( ", descClasseEff=" + this.descClasseEff );
		ret.append( ", genAnnoRisc=" + this.genAnnoRisc );
		ret.append( ", flgContRip=" + this.flgContRip );
		ret.append( ", rendGener=" + this.rendGener );
		ret.append( ", rendRegol=" + this.rendRegol );
		ret.append( ", rendEmiss=" + this.rendEmiss );
		ret.append( ", rendDistrib=" + this.rendDistrib );
		ret.append( ", flgOld=" + this.flgOld );
		ret.append( ", flgEdifE0=" + this.flgEdifE0 );
		ret.append( ", epglNrenGlobale=" + this.epglNrenGlobale );
		ret.append( ", epglRenGlobale=" + this.epglRenGlobale );
		ret.append( ", emissioniCo2=" + this.emissioniCo2 );
		ret.append( ", supRaffrescata=" + this.supRaffrescata );
		ret.append( ", supRiscaldata=" + this.supRiscaldata );
		ret.append( ", volLordoRaffrescato=" + this.volLordoRaffrescato );
		ret.append( ", eph=" + this.eph );
		ret.append( ", asolAsup=" + this.asolAsup );
		ret.append( ", yie=" + this.yie );
		ret.append( ", vSuRaff=" + this.vSuRaff );
		ret.append( ", vSuRisc=" + this.vSuRisc );
		ret.append( ", sVRaff=" + this.sVRaff );
		ret.append( ", sVRisc=" + this.sVRisc );
		return ret.toString();
	}


}
