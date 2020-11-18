/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_STATO_CERT table.
 */
public class SiceeDStatoCertPk implements Serializable
{
	protected Integer idStato;

	/** 
	 * Sets the value of idStato
	 */
	public void setIdStato(Integer idStato)
	{
		this.idStato = idStato;
	}

	/** 
	 * Gets the value of idStato
	 */
	public Integer getIdStato()
	{
		return idStato;
	}

	/**
	 * Method 'SiceeDStatoCertPk'
	 * 
	 */
	public SiceeDStatoCertPk()
	{
	}

	/**
	 * Method 'SiceeDStatoCertPk'
	 * 
	 * @param idStato
	 */
	public SiceeDStatoCertPk(final Integer idStato)
	{
		this.idStato = idStato;
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
		
		if (!(_other instanceof SiceeDStatoCertPk)) {
			return false;
		}
		
		final SiceeDStatoCertPk _cast = (SiceeDStatoCertPk) _other;
		if (idStato == null ? _cast.idStato != idStato : !idStato.equals( _cast.idStato )) {
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
		if (idStato != null) {
			_hashCode = 29 * _hashCode + idStato.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceesrv.business.dao.dto.SiceeDStatoCertPk: " );
		ret.append( "idStato=" + idStato );
		return ret.toString();
	}

}
