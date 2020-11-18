/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OptimizedFindCertificatori implements Serializable
{
	protected java.lang.String idCertificatore;

	protected java.lang.String matricola;

	protected java.lang.String nome;

	protected java.lang.String cognome;

	protected java.lang.String email;

	protected java.lang.String titolo;

	protected java.lang.String ragioneSociale;

	protected java.lang.String indirizzo;

	protected java.lang.String numCivico;

	protected java.lang.String descComune;

	protected java.lang.String descProv;

	protected java.lang.String bloccoCert;

	protected java.lang.String statoBloccoCert;

	/**
	 * Method 'OptimizedFindCertificatori'
	 * 
	 */
	public OptimizedFindCertificatori()
	{
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIdCertificatore()
	{
		return idCertificatore;
	}

	/**
	 * Method 'setIdCertificatore'
	 * 
	 * @param idCertificatore
	 */
	public void setIdCertificatore(java.lang.String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/**
	 * Method 'getMatricola'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getMatricola()
	{
		return matricola;
	}

	/**
	 * Method 'setMatricola'
	 * 
	 * @param matricola
	 */
	public void setMatricola(java.lang.String matricola)
	{
		this.matricola = matricola;
	}

	/**
	 * Method 'getNome'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNome()
	{
		return nome;
	}

	/**
	 * Method 'setNome'
	 * 
	 * @param nome
	 */
	public void setNome(java.lang.String nome)
	{
		this.nome = nome;
	}

	/**
	 * Method 'getCognome'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getCognome()
	{
		return cognome;
	}

	/**
	 * Method 'setCognome'
	 * 
	 * @param cognome
	 */
	public void setCognome(java.lang.String cognome)
	{
		this.cognome = cognome;
	}

	/**
	 * Method 'getEmail'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getEmail()
	{
		return email;
	}

	/**
	 * Method 'setEmail'
	 * 
	 * @param email
	 */
	public void setEmail(java.lang.String email)
	{
		this.email = email;
	}
	
	/**
	 * Method 'getTitolo'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getTitolo()
	{
		return titolo;
	}

	/**
	 * Method 'setTitolo'
	 * 
	 * @param titolo
	 */
	public void setTitolo(java.lang.String titolo)
	{
		this.titolo = titolo;
	}

	/**
	 * Method 'getRagioneSociale'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getRagioneSociale()
	{
		return ragioneSociale;
	}

	/**
	 * Method 'setRagioneSociale'
	 * 
	 * @param ragioneSociale
	 */
	public void setRagioneSociale(java.lang.String ragioneSociale)
	{
		this.ragioneSociale = ragioneSociale;
	}

	/**
	 * Method 'getIndirizzo'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getIndirizzo()
	{
		return indirizzo;
	}

	/**
	 * Method 'setIndirizzo'
	 * 
	 * @param indirizzo
	 */
	public void setIndirizzo(java.lang.String indirizzo)
	{
		this.indirizzo = indirizzo;
	}

	/**
	 * Method 'getNumCivico'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getNumCivico()
	{
		return numCivico;
	}

	/**
	 * Method 'setNumCivico'
	 * 
	 * @param numCivico
	 */
	public void setNumCivico(java.lang.String numCivico)
	{
		this.numCivico = numCivico;
	}

	/**
	 * Method 'getDescComune'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDescComune()
	{
		return descComune;
	}

	/**
	 * Method 'setDescComune'
	 * 
	 * @param descComune
	 */
	public void setDescComune(java.lang.String descComune)
	{
		this.descComune = descComune;
	}

	/**
	 * Method 'getDescProv'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getDescProv()
	{
		return descProv;
	}

	/**
	 * Method 'setDescProv'
	 * 
	 * @param descProv
	 */
	public void setDescProv(java.lang.String descProv)
	{
		this.descProv = descProv;
	}

	/**
	 * Method 'getBloccoCert'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getBloccoCert()
	{
		return bloccoCert;
	}

	/**
	 * Method 'setBloccoCert'
	 * 
	 * @param bloccoCert
	 */
	public void setBloccoCert(java.lang.String bloccoCert)
	{
		this.bloccoCert = bloccoCert;
	}

	/**
	 * Method 'getStatoBloccoCert'
	 * 
	 * @return java.lang.String
	 */
	public java.lang.String getStatoBloccoCert()
	{
		return statoBloccoCert;
	}

	/**
	 * Method 'setStatoBloccoCert'
	 * 
	 * @param statoBloccoCert
	 */
	public void setStatoBloccoCert(java.lang.String statoBloccoCert)
	{
		this.statoBloccoCert = statoBloccoCert;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.OptimizedFindCertificatori: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", matricola=" + matricola );
		ret.append( ", nome=" + nome );
		ret.append( ", cognome=" + cognome );
		ret.append( ", titolo=" + titolo );
		ret.append( ", ragioneSociale=" + ragioneSociale );
		ret.append( ", indirizzo=" + indirizzo );
		ret.append( ", numCivico=" + numCivico );
		ret.append( ", descComune=" + descComune );
		ret.append( ", descProv=" + descProv );
		ret.append( ", bloccoCert=" + bloccoCert );
		ret.append( ", statoBloccoCert=" + statoBloccoCert );
		return ret.toString();
	}

}
