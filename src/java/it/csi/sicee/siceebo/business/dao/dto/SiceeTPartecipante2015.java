/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import it.csi.sicee.siceebo.business.dao.dao.*;
import it.csi.sicee.siceebo.business.dao.factory.*;
import it.csi.sicee.siceebo.business.dao.exceptions.*;
import java.io.Serializable;
import java.util.*;
import java.util.Date;

public class SiceeTPartecipante2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_PARTECIPANTE in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected long idPartecipante;

	/** 
	 * This attribute maps to the column FK_CORSO in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected long fkCorso;

	/** 
	 * This attribute maps to the column CODICE_FISCALE in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String codiceFiscale;

	/** 
	 * This attribute maps to the column NOME in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String nome;

	/** 
	 * This attribute maps to the column COGNOME in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String cognome;

	/** 
	 * This attribute maps to the column LUOGO_NASCITA in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String luogoNascita;

	/** 
	 * This attribute maps to the column DATA_NASCITA in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected Date dataNascita;


	/** 
	 * This attribute maps to the column FK_TIPO_ISTRUZIONE in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected Integer fkTipoIstruzione;

	/** 
	 * This attribute maps to the column NUM_CERTIFICATORE in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String numCertificatore;

	/** 
	 * This attribute maps to the column ALBO in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String albo;

	/** 
	 * This attribute maps to the column DESC_PROV_ALBO in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String descProvAlbo;

	/** 
	 * This attribute maps to the column NUM_ISCR_ALBO in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String numIscrAlbo;

	/** 
	 * This attribute maps to the column DATA_ISCR_ALBO in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected Date dataIscrAlbo;

	/** 
	 * This attribute maps to the column PERC_FREQ in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String percFreq;

	/** 
	 * This attribute maps to the column DATA_ESAME in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected Date dataEsame;

	/** 
	 * This attribute maps to the column ESITO_ESAME in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String esitoEsame;

	/** 
	 * This attribute maps to the column LUOGO_ESAME in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String luogoEsame;

	/** 
	 * This attribute maps to the column VOTO_ESAME in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String votoEsame;

	/** 
	 * This attribute maps to the column TELEFONO in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String telefono;

	/** 
	 * This attribute maps to the column EMAIL in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String email;

	/** 
	 * This attribute maps to the column NOTE in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	protected String note;

	/**
	 * Method 'SiceeTPartecipanti2015'
	 * 
	 */
	public SiceeTPartecipante2015()
	{
	}

	/**
	 * Method 'getIdPartecipante'
	 * 
	 * @return long
	 */
	public long getIdPartecipante()
	{
		return idPartecipante;
	}

	/**
	 * Method 'setIdPartecipante'
	 * 
	 * @param idPartecipante
	 */
	public void setIdPartecipante(long idPartecipante)
	{
		this.idPartecipante = idPartecipante;
	}

	/**
	 * Method 'getFkCorso'
	 * 
	 * @return long
	 */
	public long getFkCorso()
	{
		return fkCorso;
	}

	/**
	 * Method 'setFkCorso'
	 * 
	 * @param fkCorso
	 */
	public void setFkCorso(long fkCorso)
	{
		this.fkCorso = fkCorso;
	}

	/**
	 * Method 'getCodiceFiscale'
	 * 
	 * @return String
	 */
	public String getCodiceFiscale()
	{
		return codiceFiscale;
	}

	/**
	 * Method 'setCodiceFiscale'
	 * 
	 * @param codiceFiscale
	 */
	public void setCodiceFiscale(String codiceFiscale)
	{
		this.codiceFiscale = codiceFiscale;
	}

	/**
	 * Method 'getNome'
	 * 
	 * @return String
	 */
	public String getNome()
	{
		return nome;
	}

	/**
	 * Method 'setNome'
	 * 
	 * @param nome
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}

	/**
	 * Method 'getCognome'
	 * 
	 * @return String
	 */
	public String getCognome()
	{
		return cognome;
	}

	/**
	 * Method 'setCognome'
	 * 
	 * @param cognome
	 */
	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}

	/**
	 * Method 'getLuogoNascita'
	 * 
	 * @return String
	 */
	public String getLuogoNascita()
	{
		return luogoNascita;
	}

	/**
	 * Method 'setLuogoNascita'
	 * 
	 * @param luogoNascita
	 */
	public void setLuogoNascita(String luogoNascita)
	{
		this.luogoNascita = luogoNascita;
	}

	/**
	 * Method 'getDataNascita'
	 * 
	 * @return Date
	 */
	public Date getDataNascita()
	{
		return dataNascita;
	}

	/**
	 * Method 'setDataNascita'
	 * 
	 * @param dataNascita
	 */
	public void setDataNascita(Date dataNascita)
	{
		this.dataNascita = dataNascita;
	}

	/**
	 * Method 'getFkTipoIstruzione'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoIstruzione()
	{
		return fkTipoIstruzione;
	}

	/**
	 * Method 'setFkTipoIstruzione'
	 * 
	 * @param fkIstruzione
	 */
	public void setFkTipoIstruzione(Integer fkTipoIstruzione)
	{
		this.fkTipoIstruzione = fkTipoIstruzione;
	}

	/**
	 * Method 'getNumCertificatore'
	 * 
	 * @return String
	 */
	public String getNumCertificatore()
	{
		return numCertificatore;
	}

	/**
	 * Method 'setNumCertificatore'
	 * 
	 * @param numCertificatore
	 */
	public void setNumCertificatore(String numCertificatore)
	{
		this.numCertificatore = numCertificatore;
	}

	/**
	 * Method 'getAlbo'
	 * 
	 * @return String
	 */
	public String getAlbo()
	{
		return albo;
	}

	/**
	 * Method 'setAlbo'
	 * 
	 * @param albo
	 */
	public void setAlbo(String albo)
	{
		this.albo = albo;
	}

	/**
	 * Method 'getDescProvAlbo'
	 * 
	 * @return String
	 */
	public String getDescProvAlbo()
	{
		return descProvAlbo;
	}

	/**
	 * Method 'setDescProvAlbo'
	 * 
	 * @param descProvAlbo
	 */
	public void setDescProvAlbo(String descProvAlbo)
	{
		this.descProvAlbo = descProvAlbo;
	}

	/**
	 * Method 'getNumIscrAlbo'
	 * 
	 * @return String
	 */
	public String getNumIscrAlbo()
	{
		return numIscrAlbo;
	}

	/**
	 * Method 'setNumIscrAlbo'
	 * 
	 * @param numIscrAlbo
	 */
	public void setNumIscrAlbo(String numIscrAlbo)
	{
		this.numIscrAlbo = numIscrAlbo;
	}

	/**
	 * Method 'getDataIscrAlbo'
	 * 
	 * @return Date
	 */
	public Date getDataIscrAlbo()
	{
		return dataIscrAlbo;
	}

	/**
	 * Method 'setDataIscrAlbo'
	 * 
	 * @param dataIscrAlbo
	 */
	public void setDataIscrAlbo(Date dataIscrAlbo)
	{
		this.dataIscrAlbo = dataIscrAlbo;
	}

	/**
	 * Method 'getPercFreq'
	 * 
	 * @return String
	 */
	public String getPercFreq()
	{
		return percFreq;
	}

	/**
	 * Method 'setPercFreq'
	 * 
	 * @param percFreq
	 */
	public void setPercFreq(String percFreq)
	{
		this.percFreq = percFreq;
	}

	/**
	 * Method 'getDataEsame'
	 * 
	 * @return Date
	 */
	public Date getDataEsame()
	{
		return dataEsame;
	}

	/**
	 * Method 'setDataEsame'
	 * 
	 * @param dataEsame
	 */
	public void setDataEsame(Date dataEsame)
	{
		this.dataEsame = dataEsame;
	}

	/**
	 * Method 'getEsitoEsame'
	 * 
	 * @return String
	 */
	public String getEsitoEsame()
	{
		return esitoEsame;
	}

	/**
	 * Method 'setEsitoEsame'
	 * 
	 * @param esitoEsame
	 */
	public void setEsitoEsame(String esitoEsame)
	{
		this.esitoEsame = esitoEsame;
	}

	/**
	 * Method 'getLuogoEsame'
	 * 
	 * @return String
	 */
	public String getLuogoEsame()
	{
		return luogoEsame;
	}

	/**
	 * Method 'setLuogoEsame'
	 * 
	 * @param luogoEsame
	 */
	public void setLuogoEsame(String luogoEsame)
	{
		this.luogoEsame = luogoEsame;
	}

	/**
	 * Method 'getVotoEsame'
	 * 
	 * @return String
	 */
	public String getVotoEsame()
	{
		return votoEsame;
	}

	/**
	 * Method 'setVotoEsame'
	 * 
	 * @param votoEsame
	 */
	public void setVotoEsame(String votoEsame)
	{
		this.votoEsame = votoEsame;
	}

	/**
	 * Method 'getTelefono'
	 * 
	 * @return String
	 */
	public String getTelefono()
	{
		return telefono;
	}

	/**
	 * Method 'setTelefono'
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	/**
	 * Method 'getEmail'
	 * 
	 * @return String
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Method 'setEmail'
	 * 
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Method 'getNote'
	 * 
	 * @return String
	 */
	public String getNote()
	{
		return note;
	}

	/**
	 * Method 'setNote'
	 * 
	 * @param note
	 */
	public void setNote(String note)
	{
		this.note = note;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeTPartecipante2015)) {
			return false;
		}
		
		final SiceeTPartecipante2015 _cast = (SiceeTPartecipante2015) _other;
		if (idPartecipante != _cast.idPartecipante) {
			return false;
		}
		
		if (fkCorso != _cast.fkCorso) {
			return false;
		}
		
		if (codiceFiscale == null ? _cast.codiceFiscale != codiceFiscale : !codiceFiscale.equals( _cast.codiceFiscale )) {
			return false;
		}
		
		if (nome == null ? _cast.nome != nome : !nome.equals( _cast.nome )) {
			return false;
		}
		
		if (cognome == null ? _cast.cognome != cognome : !cognome.equals( _cast.cognome )) {
			return false;
		}
		
		if (fkTipoIstruzione == null ? _cast.fkTipoIstruzione != fkTipoIstruzione : !fkTipoIstruzione.equals( _cast.fkTipoIstruzione )) {
			return false;
		}
		
		if (numCertificatore == null ? _cast.numCertificatore != numCertificatore : !numCertificatore.equals( _cast.numCertificatore )) {
			return false;
		}
		
		if (albo == null ? _cast.albo != albo : !albo.equals( _cast.albo )) {
			return false;
		}
		
		if (descProvAlbo == null ? _cast.descProvAlbo != descProvAlbo : !descProvAlbo.equals( _cast.descProvAlbo )) {
			return false;
		}
		
		if (numIscrAlbo == null ? _cast.numIscrAlbo != numIscrAlbo : !numIscrAlbo.equals( _cast.numIscrAlbo )) {
			return false;
		}
		
		if (dataIscrAlbo == null ? _cast.dataIscrAlbo != dataIscrAlbo : !dataIscrAlbo.equals( _cast.dataIscrAlbo )) {
			return false;
		}
		
		if (dataEsame == null ? _cast.dataEsame != dataEsame : !dataEsame.equals( _cast.dataEsame )) {
			return false;
		}
		
		if (esitoEsame == null ? _cast.esitoEsame != esitoEsame : !esitoEsame.equals( _cast.esitoEsame )) {
			return false;
		}
		
		if (votoEsame == null ? _cast.votoEsame != votoEsame : !votoEsame.equals( _cast.votoEsame )) {
			return false;
		}
		
		if (telefono == null ? _cast.telefono != telefono : !telefono.equals( _cast.telefono )) {
			return false;
		}
		
		if (email == null ? _cast.email != email : !email.equals( _cast.email )) {
			return false;
		}
		
		if (note == null ? _cast.note != note : !note.equals( _cast.note )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + (int) (idPartecipante ^ (idPartecipante >>> 32));
		_hashCode = 29 * _hashCode + (int) (fkCorso ^ (fkCorso >>> 32));
		if (codiceFiscale != null) {
			_hashCode = 29 * _hashCode + codiceFiscale.hashCode();
		}
		
		if (nome != null) {
			_hashCode = 29 * _hashCode + nome.hashCode();
		}
		
		if (cognome != null) {
			_hashCode = 29 * _hashCode + cognome.hashCode();
		}
		
		if (fkTipoIstruzione != null) {
			_hashCode = 29 * _hashCode + fkTipoIstruzione.hashCode();
		}
		
		if (numCertificatore != null) {
			_hashCode = 29 * _hashCode + numCertificatore.hashCode();
		}
		
		if (albo != null) {
			_hashCode = 29 * _hashCode + albo.hashCode();
		}
		
		if (descProvAlbo != null) {
			_hashCode = 29 * _hashCode + descProvAlbo.hashCode();
		}
		
		if (numIscrAlbo != null) {
			_hashCode = 29 * _hashCode + numIscrAlbo.hashCode();
		}
		
		if (dataIscrAlbo != null) {
			_hashCode = 29 * _hashCode + dataIscrAlbo.hashCode();
		}
		
		if (dataEsame != null) {
			_hashCode = 29 * _hashCode + dataEsame.hashCode();
		}
		
		if (esitoEsame != null) {
			_hashCode = 29 * _hashCode + esitoEsame.hashCode();
		}
		
		if (votoEsame != null) {
			_hashCode = 29 * _hashCode + votoEsame.hashCode();
		}
		
		if (telefono != null) {
			_hashCode = 29 * _hashCode + telefono.hashCode();
		}
		
		if (email != null) {
			_hashCode = 29 * _hashCode + email.hashCode();
		}
		
		if (note != null) {
			_hashCode = 29 * _hashCode + note.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTPartecipanti2015Pk
	 */
	public SiceeTPartecipante2015Pk createPk()
	{
		return new SiceeTPartecipante2015Pk(idPartecipante);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTPartecipanti2015: " );
		ret.append( "idPartecipante=" + idPartecipante );
		ret.append( ", fkCorso=" + fkCorso );
		ret.append( ", codiceFiscale=" + codiceFiscale );
		ret.append( ", nome=" + nome );
		ret.append( ", cognome=" + cognome );
		ret.append( ", fkTipoIstruzione=" + fkTipoIstruzione );
		ret.append( ", numCertificatore=" + numCertificatore );
		ret.append( ", albo=" + albo );
		ret.append( ", descProvAlbo=" + descProvAlbo );
		ret.append( ", numIscrAlbo=" + numIscrAlbo );
		ret.append( ", dataIscrAlbo=" + dataIscrAlbo );
		ret.append( ", dataEsame=" + dataEsame );
		ret.append( ", esitoEsame=" + esitoEsame );
		ret.append( ", votoEsame=" + votoEsame );
		ret.append( ", telefono=" + telefono );
		ret.append( ", email=" + email );
		ret.append( ", note=" + note );
		return ret.toString();
	}

}
