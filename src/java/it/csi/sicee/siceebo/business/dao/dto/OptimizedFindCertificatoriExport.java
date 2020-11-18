/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OptimizedFindCertificatoriExport implements Serializable
{
	protected java.lang.String idCert; 

	protected java.lang.String matricola; 

	protected java.lang.String nome; 

	protected java.lang.String cognome; 

	protected java.lang.String titolo;  

	protected java.lang.String descProvOrdine;

	protected java.lang.String numIscrAlbo;

	protected java.util.Date dataIscrAlbo;

	protected java.lang.String corsoFrequentato;

	protected java.util.Date dataModulo1Da;

	protected java.util.Date dataModulo1A;

	protected java.util.Date dataModulo2Da;

	protected java.util.Date dataModulo2A;

	protected java.lang.String attPartecipEmesso;

	protected java.util.Date dataAttPartecip;

	protected java.lang.String attEsamePresso;

	protected java.util.Date dataAttEsame;

	protected java.lang.String codiceFiscaleCert;

	protected java.util.Date dataNascitaCert;

	protected java.lang.String descRegioneNascitaCert;

	protected java.lang.String descProvNascitaCert;

	protected java.lang.String descComuneNascitaCert;

	protected java.lang.String descRegioneResidenzaCert;

	protected java.lang.String descProvResidenzaCert;

	protected java.lang.String descComuneResidenzaCert;

	protected java.lang.String descIndirizzoCert;

	protected java.lang.String numCivicoResidenzaCert;

	protected java.lang.String capCert;

	protected java.lang.String telefonoCert;

	protected java.lang.String cellCert;

	protected java.lang.String emailCert;

	protected java.lang.String emailPecCert;

	protected java.lang.String faxCert;

	protected java.lang.String sitoWebCert;

	protected java.lang.String denominazioneAzienda;

	protected java.lang.String pIvaAzienda;

	protected java.lang.String descRegioneAzienda;

	protected java.lang.String descProvAzienda;
	
	protected java.lang.String descComuneAzienda;

	protected java.lang.String descIndirizzoAzienda;

	protected java.lang.String numCivicoAzienda;

	protected java.lang.String capAzienda;

	protected java.lang.Integer numAceTot;
	
	protected java.lang.Integer numAceClasseApiu;
	
	protected java.lang.Integer numAceClasseA;

	protected java.lang.Integer numAceClasseB;

	protected java.lang.Integer numAceClasseC;

	protected java.lang.Integer numAceClasseD;

	protected java.lang.Integer numAceClasseE;

	protected java.lang.Integer numAceClasseF;

	protected java.lang.Integer numAceClasseG;

	protected java.lang.Integer numAceClasseNC;


	/**
	 * Method 'OptimizedFindCertificatori'
	 * 
	 */
	public OptimizedFindCertificatoriExport()
	{
	}


	public java.lang.String getIdCert() {
		return idCert;
	}


	public void setIdCert(java.lang.String idCert) {
		this.idCert = idCert;
	}


	public java.lang.String getMatricola() {
		return matricola;
	}


	public void setMatricola(java.lang.String matricola) {
		this.matricola = matricola;
	}


	public java.lang.String getNome() {
		return nome;
	}


	public void setNome(java.lang.String nome) {
		this.nome = nome;
	}


	public java.lang.String getCognome() {
		return cognome;
	}


	public void setCognome(java.lang.String cognome) {
		this.cognome = cognome;
	}


	public java.lang.String getTitolo() {
		return titolo;
	}


	public void setTitolo(java.lang.String titolo) {
		this.titolo = titolo;
	}


	public java.lang.String getDescProvOrdine() {
		return descProvOrdine;
	}


	public void setDescProvOrdine(java.lang.String descProvOrdine) {
		this.descProvOrdine = descProvOrdine;
	}


	public java.lang.String getNumIscrAlbo() {
		return numIscrAlbo;
	}


	public void setNumIscrAlbo(java.lang.String numIscrAlbo) {
		this.numIscrAlbo = numIscrAlbo;
	}


	public java.util.Date getDataIscrAlbo() {
		return dataIscrAlbo;
	}


	public void setDataIscrAlbo(java.util.Date dataIscrAlbo) {
		this.dataIscrAlbo = dataIscrAlbo;
	}


	public java.lang.String getCorsoFrequentato() {
		return corsoFrequentato;
	}


	public void setCorsoFrequentato(java.lang.String corsoFrequentato) {
		this.corsoFrequentato = corsoFrequentato;
	}


	public java.util.Date getDataModulo1Da() {
		return dataModulo1Da;
	}


	public void setDataModulo1Da(java.util.Date dataModulo1Da) {
		this.dataModulo1Da = dataModulo1Da;
	}


	public java.util.Date getDataModulo1A() {
		return dataModulo1A;
	}


	public void setDataModulo1A(java.util.Date dataModulo1A) {
		this.dataModulo1A = dataModulo1A;
	}


	public java.util.Date getDataModulo2Da() {
		return dataModulo2Da;
	}


	public void setDataModulo2Da(java.util.Date dataModulo2Da) {
		this.dataModulo2Da = dataModulo2Da;
	}


	public java.util.Date getDataModulo2A() {
		return dataModulo2A;
	}


	public void setDataModulo2A(java.util.Date dataModulo2A) {
		this.dataModulo2A = dataModulo2A;
	}


	public java.lang.String getAttPartecipEmesso() {
		return attPartecipEmesso;
	}


	public void setAttPartecipEmesso(java.lang.String attPartecipEmesso) {
		this.attPartecipEmesso = attPartecipEmesso;
	}


	public java.util.Date getDataAttPartecip() {
		return dataAttPartecip;
	}


	public void setDataAttPartecip(java.util.Date dataAttPartecip) {
		this.dataAttPartecip = dataAttPartecip;
	}


	public java.lang.String getAttEsamePresso() {
		return attEsamePresso;
	}


	public void setAttEsamePresso(java.lang.String attEsamePresso) {
		this.attEsamePresso = attEsamePresso;
	}


	public java.util.Date getDataAttEsame() {
		return dataAttEsame;
	}


	public void setDataAttEsame(java.util.Date dataAttEsame) {
		this.dataAttEsame = dataAttEsame;
	}


	public java.lang.String getCodiceFiscaleCert() {
		return codiceFiscaleCert;
	}


	public void setCodiceFiscaleCert(java.lang.String codiceFiscaleCert) {
		this.codiceFiscaleCert = codiceFiscaleCert;
	}

	
	public java.util.Date getDataNascitaCert() {
		return dataNascitaCert;
	}


	public void setDataNascitaCert(java.util.Date dataNascitaCert) {
		this.dataNascitaCert = dataNascitaCert;
	}


	public java.lang.String getDescRegioneNascitaCert() {
		return descRegioneNascitaCert;
	}


	public void setDescRegioneNascitaCert(java.lang.String descRegioneNascitaCert) {
		this.descRegioneNascitaCert = descRegioneNascitaCert;
	}


	public java.lang.String getDescProvNascitaCert() {
		return descProvNascitaCert;
	}


	public void setDescProvNascitaCert(java.lang.String descProvNascitaCert) {
		this.descProvNascitaCert = descProvNascitaCert;
	}


	public java.lang.String getDescComuneNascitaCert() {
		return descComuneNascitaCert;
	}


	public void setDescComuneNascitaCert(java.lang.String descComuneNascitaCert) {
		this.descComuneNascitaCert = descComuneNascitaCert;
	}


	public java.lang.String getDescRegioneResidenzaCert() {
		return descRegioneResidenzaCert;
	}


	public void setDescRegioneResidenzaCert(
			java.lang.String descRegioneResidenzaCert) {
		this.descRegioneResidenzaCert = descRegioneResidenzaCert;
	}


	public java.lang.String getDescProvResidenzaCert() {
		return descProvResidenzaCert;
	}


	public void setDescProvResidenzaCert(java.lang.String descProvResidenzaCert) {
		this.descProvResidenzaCert = descProvResidenzaCert;
	}


	public java.lang.String getDescComuneResidenzaCert() {
		return descComuneResidenzaCert;
	}


	public void setDescComuneResidenzaCert(java.lang.String descComuneResidenzaCert) {
		this.descComuneResidenzaCert = descComuneResidenzaCert;
	}


	public java.lang.String getDescIndirizzoCert() {
		return descIndirizzoCert;
	}


	public void setDescIndirizzoCert(java.lang.String descIndirizzoCert) {
		this.descIndirizzoCert = descIndirizzoCert;
	}


	public java.lang.String getNumCivicoResidenzaCert() {
		return numCivicoResidenzaCert;
	}


	public void setNumCivicoResidenzaCert(java.lang.String numCivicoResidenzaCert) {
		this.numCivicoResidenzaCert = numCivicoResidenzaCert;
	}


	public java.lang.String getCapCert() {
		return capCert;
	}


	public void setCapCert(java.lang.String capCert) {
		this.capCert = capCert;
	}


	public java.lang.String getTelefonoCert() {
		return telefonoCert;
	}


	public void setTelefonoCert(java.lang.String telefonoCert) {
		this.telefonoCert = telefonoCert;
	}


	public java.lang.String getCellCert() {
		return cellCert;
	}


	public void setCellCert(java.lang.String cellCert) {
		this.cellCert = cellCert;
	}


	public java.lang.String getEmailCert() {
		return emailCert;
	}


	public void setEmailCert(java.lang.String emailCert) {
		this.emailCert = emailCert;
	}


	public java.lang.String getEmailPecCert() {
		return emailPecCert;
	}


	public void setEmailPecCert(java.lang.String emailPecCert) {
		this.emailPecCert = emailPecCert;
	}


	public java.lang.String getFaxCert() {
		return faxCert;
	}


	public void setFaxCert(java.lang.String faxCert) {
		this.faxCert = faxCert;
	}


	public java.lang.String getSitoWebCert() {
		return sitoWebCert;
	}


	public void setSitoWebCert(java.lang.String sitoWebCert) {
		this.sitoWebCert = sitoWebCert;
	}


	public java.lang.String getDenominazioneAzienda() {
		return denominazioneAzienda;
	}


	public void setDenominazioneAzienda(java.lang.String denominazioneAzienda) {
		this.denominazioneAzienda = denominazioneAzienda;
	}


	public java.lang.String getpIvaAzienda() {
		return pIvaAzienda;
	}


	public void setpIvaAzienda(java.lang.String pIvaAzienda) {
		this.pIvaAzienda = pIvaAzienda;
	}


	public java.lang.String getDescRegioneAzienda() {
		return descRegioneAzienda;
	}


	public void setDescRegioneAzienda(java.lang.String descRegioneAzienda) {
		this.descRegioneAzienda = descRegioneAzienda;
	}


	public java.lang.String getDescProvAzienda() {
		return descProvAzienda;
	}


	public void setDescProvAzienda(java.lang.String descProvAzienda) {
		this.descProvAzienda = descProvAzienda;
	}


	public java.lang.String getDescComuneAzienda() {
		return descComuneAzienda;
	}


	public void setDescComuneAzienda(java.lang.String descComuneAzienda) {
		this.descComuneAzienda = descComuneAzienda;
	}


	public java.lang.String getDescIndirizzoAzienda() {
		return descIndirizzoAzienda;
	}


	public void setDescIndirizzoAzienda(java.lang.String descIndirizzoAzienda) {
		this.descIndirizzoAzienda = descIndirizzoAzienda;
	}


	public java.lang.String getNumCivicoAzienda() {
		return numCivicoAzienda;
	}


	public void setNumCivicoAzienda(java.lang.String numCivicoAzienda) {
		this.numCivicoAzienda = numCivicoAzienda;
	}


	public java.lang.String getCapAzienda() {
		return capAzienda;
	}


	public void setCapAzienda(java.lang.String capAzienda) {
		this.capAzienda = capAzienda;
	}


	public java.lang.Integer getNumAceTot() {
		return numAceTot;
	}


	public void setNumAceTot(java.lang.Integer numAceTot) {
		this.numAceTot = numAceTot;
	}


	public java.lang.Integer getNumAceClasseApiu() {
		return numAceClasseApiu;
	}


	public void setNumAceClasseApiu(java.lang.Integer numAceClasseApiu) {
		this.numAceClasseApiu = numAceClasseApiu;
	}


	public java.lang.Integer getNumAceClasseA() {
		return numAceClasseA;
	}


	public void setNumAceClasseA(java.lang.Integer numAceClasseA) {
		this.numAceClasseA = numAceClasseA;
	}


	public java.lang.Integer getNumAceClasseB() {
		return numAceClasseB;
	}


	public void setNumAceClasseB(java.lang.Integer numAceClasseB) {
		this.numAceClasseB = numAceClasseB;
	}


	public java.lang.Integer getNumAceClasseC() {
		return numAceClasseC;
	}


	public void setNumAceClasseC(java.lang.Integer numAceClasseC) {
		this.numAceClasseC = numAceClasseC;
	}


	public java.lang.Integer getNumAceClasseD() {
		return numAceClasseD;
	}


	public void setNumAceClasseD(java.lang.Integer numAceClasseD) {
		this.numAceClasseD = numAceClasseD;
	}


	public java.lang.Integer getNumAceClasseE() {
		return numAceClasseE;
	}


	public void setNumAceClasseE(java.lang.Integer numAceClasseE) {
		this.numAceClasseE = numAceClasseE;
	}


	public java.lang.Integer getNumAceClasseF() {
		return numAceClasseF;
	}


	public void setNumAceClasseF(java.lang.Integer numAceClasseF) {
		this.numAceClasseF = numAceClasseF;
	}


	public java.lang.Integer getNumAceClasseG() {
		return numAceClasseG;
	}


	public void setNumAceClasseG(java.lang.Integer numAceClasseG) {
		this.numAceClasseG = numAceClasseG;
	}


	public java.lang.Integer getNumAceClasseNC() {
		return numAceClasseNC;
	}


	public void setNumAceClasseNC(java.lang.Integer numAceClasseNC) {
		this.numAceClasseNC = numAceClasseNC;
	}


	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.OptimizedFindCertificatoriExport: " );
		ret.append( "idCert=" + idCert );
		ret.append( ", matricola=" + matricola );
		ret.append( ", nome=" + nome );
		ret.append( ", cognome=" + cognome );
		ret.append( ", titolo=" + titolo );
		ret.append( ", descProvOrdine=" + descProvOrdine );
		ret.append( ", numIscrAlbo=" + numIscrAlbo );
		ret.append( ", dataIscrAlbo=" + dataIscrAlbo );
		ret.append( ", corsoFrequentato=" +corsoFrequentato );

		ret.append( ", dataModulo1Da=" + dataModulo1Da );
		ret.append( ", dataModulo1A=" + dataModulo1A );
		ret.append( ", dataModulo2Da=" + dataModulo2Da );
		ret.append( ", dataModulo2A=" + dataModulo2A );
		ret.append( ", attPartecipEmesso=" + attPartecipEmesso );
		ret.append( ", dataAttPartecip=" + dataAttPartecip );
		ret.append( ", attEsamePresso=" + attEsamePresso );
		ret.append( ", dataAttEsame=" + dataAttEsame );
		ret.append( ", codiceFiscaleCert=" + codiceFiscaleCert );
		ret.append( ", dataNascitaCert=" + dataNascitaCert );
		ret.append( ", descRegioneNascitaCert=" + descRegioneNascitaCert );
		ret.append( ", descProvNascitaCert=" + descProvNascitaCert );
		ret.append( ", descComuneNascitaCert=" + descComuneNascitaCert );
		ret.append( ", descRegioneResidenzaCert=" + descRegioneResidenzaCert );
		ret.append( ", descProvResidenzaCert=" + descProvResidenzaCert );
		ret.append( ", descComuneResidenzaCert=" + descComuneResidenzaCert );
		ret.append( ", descIndirizzoCert=" + descIndirizzoCert );
		ret.append( ", numCivicoResidenzaCert=" + numCivicoResidenzaCert );
		ret.append( ", capCert=" + capCert );
		ret.append( ", telefonoCert=" + telefonoCert );
		ret.append( ", cellCert=" + cellCert );
		ret.append( ", emailCert=" + emailCert );
		ret.append( ", emailPecCert=" + emailPecCert );
		ret.append( ", faxCert=" + faxCert );
		ret.append( ", sitoWebCert=" + sitoWebCert );
		ret.append( ", denominazioneAzienda=" + denominazioneAzienda );
		ret.append( ", pIvaAzienda=" + pIvaAzienda );
		ret.append( ", descRegioneAzienda=" + descRegioneAzienda );
		ret.append( ", descProvAzienda=" + descProvAzienda );
		ret.append( ", descComuneAzienda=" + descComuneAzienda );
		ret.append( ", descIndirizzoAzienda=" + descIndirizzoAzienda );
		ret.append( ", numCivicoAzienda=" + numCivicoAzienda );
		ret.append( ", capAzienda=" + capAzienda );
		ret.append( ", numAceTot=" + numAceTot );
		ret.append( ", numAceClasseApiu=" + numAceClasseApiu );
		ret.append( ", numAceClasseA=" + numAceClasseA );
		ret.append( ", numAceClasseB=" + numAceClasseB );
		ret.append( ", numAceClasseC=" + numAceClasseC );
		ret.append( ", numAceClasseD=" + numAceClasseD );
		ret.append( ", numAceClasseE=" + numAceClasseE );
		ret.append( ", numAceClasseF=" + numAceClasseF );
		ret.append( ", numAceClasseG=" + numAceClasseG );
		ret.append( ", numAceClasseNC=" + numAceClasseNC );
		
		return ret.toString();
	}
}
