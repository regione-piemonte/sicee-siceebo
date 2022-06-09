/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class SiceeSAccesso implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4651002746418606666L;
	protected Timestamp dtAccesso;
	protected String codiceFiscale;
	protected String nome;
	protected String cognome;
	protected String ruolo;
	
	public SiceeSAccesso() {
	}

	public Timestamp getDtAccesso() {
		return dtAccesso;
	}
	public void setDtAccesso(Timestamp dtAccesso) {
		this.dtAccesso = dtAccesso;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getRuolo() {
		return ruolo;
	}
	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
	
	/**
	 * Method 'equals'
	 * 
	 * @param _other
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
		
		if (!(_other instanceof SiceeSAccesso)) {
			return false;
		}
		
		final SiceeSAccesso _cast = (SiceeSAccesso) _other;
		if (dtAccesso == null ? _cast.dtAccesso != dtAccesso : !dtAccesso.equals( _cast.dtAccesso )) {
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
		
		if (ruolo == null ? _cast.ruolo != ruolo : !ruolo.equals( _cast.ruolo )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		int _hashCode = 0;
		if (dtAccesso != null) {
			_hashCode = 29 * _hashCode + dtAccesso.hashCode();
		}
		
		if (codiceFiscale != null) {
			_hashCode = 29 * _hashCode + codiceFiscale.hashCode();
		}
		
		if (nome != null) {
			_hashCode = 29 * _hashCode + nome.hashCode();
		}
		
		if (cognome != null) {
			_hashCode = 29 * _hashCode + cognome.hashCode();
		}
		
		if (ruolo != null) {
			_hashCode = 29 * _hashCode + ruolo.hashCode();
		}

		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeRNotaioAcePk
	 */
	public SiceeSAccessoPk createPk()
	{
		return new SiceeSAccessoPk(dtAccesso, codiceFiscale);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeSAccesso: " );
		ret.append( "dtAccesso=" + dtAccesso );
		ret.append( ", codiceFiscale=" + codiceFiscale );
		ret.append( ", nome=" + nome );
		ret.append( ", cognome=" + cognome );
		ret.append( ", ruolo=" + ruolo );
		return ret.toString();
	}
}
