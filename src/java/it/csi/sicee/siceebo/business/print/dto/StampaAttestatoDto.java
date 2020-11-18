/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.print.dto;

import java.io.Serializable;

public class StampaAttestatoDto extends GenericDto implements Serializable{
	
	private static final long serialVersionUID = 1L;

	// proprietà derivate da Partecipante
	private Long idPartecipante = null;
	private Long fkCorso = null;
	private String codiceFiscale = null;
	private String nome = null;
	private String cognome = null;
	private String luogoNascita = null;
	private String dataNascita = null;
	private Integer fkTipoIstruzione = null;
	private String numCertificatore = null;
	private String albo = null;
	private String descProvAlbo = null;
	private String numIscrAlbo = null;
	private String dataIscrAlbo = null;
	private String percFreq = null;
	private String dataEsame = null;
	private String esitoEsame = null;
	private String votoEsame = null;
	private String telefono = null;
	private String email = null;
	private String note = null;

	// proprietà derivate da Corso
	private Long idCorso = null;
	private Long fkEnte = null;
	private String descrizioneAttestato = null;
	private String numCorso = null;
	private String annoFormativo = null;
	private String titolo = null;
	private Integer totaleOre = null;
	private String dataDal = null;
	private String dataAl = null;
	private Integer partecipanti = null;
	private String protApprov = null;
	private String dataApprov = null;
	private String luogoCorso = null;

	// proprietà derivate da EnteFormativo
	private String denominazione = null;
	private String descComune = null;
	private String descProv = null;
	private String descIndirizzo = null;
	private String numCivico = null;
	private String base64Logo = null;
	private String parametriLogo = null;

	// metodi derivati da Partecipante
	public void setIdPartecipante(Long val) {
		idPartecipante = val;
	}
	public Long getIdPartecipante() {
		return idPartecipante;
	}

	public void setFkCorso(Long val) {
		fkCorso = val;
	}
	public Long getFkCorso() {
		return fkCorso;
	}

	public void setCodiceFiscale(String val) {
		codiceFiscale = val;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setNome(String val) {
		nome = val;
	}
	public String getNome() {
		return nome;
	}

	public void setCognome(String val) {
		cognome = val;
	}
	public String getCognome() {
		return cognome;
	}

	public void setLuogoNascita(String val) {
		luogoNascita = val;
	}
	public String getLuogoNascita() {
		return luogoNascita;
	}

	public void setDataNascita(String val) {
		dataNascita = val;
	}
	public String getdataNascita() {
		return dataNascita;
	}

	public void setFkTipoIstruzione(Integer val) {
		fkTipoIstruzione = val;
	}
	public Integer getFkTipoIstruzione() {
		return fkTipoIstruzione;
	}

	public void setNumCertificatore(String val) {
		numCertificatore = val;
	}
	public String getNumCertificatore() {
		return numCertificatore;
	}

	public void setAlbo(String val) {
		albo = val;
	}
	public String getAlbo() {
		return albo;
	}

	public void setDescProvAlbo(String val) {
		descProvAlbo = val;
	}
	public String getDescProvAlbo() {
		return descProvAlbo;
	}

	public void setNumIscrAlbo(String val) {
		numIscrAlbo = val;
	}
	public String getNumIscrAlbo() {
		return numIscrAlbo;
	}

	public void setDataIscrAlbo(String val) {
		dataIscrAlbo = val;
	}
	public String getDataIscrAlbo() {
		return dataIscrAlbo;
	}

	public void setPercFreq(String val) {
		percFreq = val;
	}
	public String getPercFreq() {
		return percFreq;
	}

	public void setDataEsame(String val) {
		dataEsame = val;
	}
	public String getDataEsame() {
		return dataEsame;
	}

	public void setEsitoEsame(String val) {
		esitoEsame = val;
	}
	public String getEsitoEsame() {
		return esitoEsame;
	}

	public void setVotoEsame(String val) {
		votoEsame = val;
	}
	public String getVotoEsame() {
		return votoEsame;
	}


	public void setTelefono(String val) {
		telefono = val;
	}
	public String getTelefono() {
		return telefono;
	}

	public void setEmail(String val) {
		email = val;
	}
	public String getEmail() {
		return email;
	}

	public void setNote(String val) {
		note = val;
	}
	public String getNote() {
		return note;
	}

	// metodi derivati da Corso
	public void setIdCorso(Long val) {
		idCorso = val;
	}
	public Long getIdCorso() {
		return idCorso;
	}

	public void setFkEnte(Long val) {
		fkEnte = val;
	}
	public Long getFkEnte() {
		return fkEnte;
	}

	public void setDescrizioneAttestato(String val) {
		descrizioneAttestato = val;
	}
	public String getDescrizioneAttestato() {
		return descrizioneAttestato;
	}

	public void setNumCorso(String val) {
		numCorso = val;
	}
	public String getNumCorso() {
		return numCorso;
	}

	public void setAnnoFormativo(String val) {
		annoFormativo = val;
	}
	public String getAnnoFormativo() {
		return annoFormativo;
	}

	public void setTitolo(String val) {
		titolo = val;
	}
	public String getTitolo() {
		return titolo;
	}

	public void setTotaleOre(Integer val) {
		totaleOre = val;
	}
	public Integer getTotaleOre() {
		return totaleOre;
	}

	public void setDataDal(String val) {
		dataDal = val;
	}
	public String getDataDal() {
		return dataDal;
	}

	public void setDataAl(String val) {
		dataAl = val;
	}
	public String getDataAl() {
		return dataAl;
	}

	public void setPartecipanti(Integer val) {
		partecipanti = val;
	}
	public Integer getPartecipanti() {
		return partecipanti;
	}

	public void setProtApprov(String val) {
		protApprov = val;
	}
	public String getProtApprov() {
		return protApprov;
	}

	public void setDataApprov(String val) {
		dataApprov = val;
	}
	public String getDataApprov() {
		return dataApprov;
	}

	public void setLuogoCorso(String val) {
		luogoCorso = val;
	}
	public String getLuogoCorso() {
		return luogoCorso;
	}

	// metodi derivati da EnteFormativo
	public void setDenominazione(String val) {
		denominazione = val;
	}
	public String getDenominazione() {
		return denominazione;
	}

	public void setDescComune(String val) {
		descComune = val;
	}
	public String getDescComune() {
		return descComune;
	}

	public void setDescProv(String val) {
		descProv = val;
	}
	public String getDescProv() {
		return descProv;
	}

	public void setDescIndirizzo(String val) {
		descIndirizzo = val;
	}
	public String getDescIndirizzo() {
		return descIndirizzo;
	}

	public void setNumCivico(String val) {
		numCivico = val;
	}
	public String getNumCivico() {
		return numCivico;
	}

	public void setBase64Logo(String val) {
		base64Logo = val;
	}
	public String getBase64Logo() {
		return base64Logo;
	}

	public void setParametriLogo(String val) {
		parametriLogo = val;
	}
	public String getParametriLogo() {
		return parametriLogo;
	}

}
