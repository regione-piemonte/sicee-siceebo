/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_PARTECIPANTI_2015 table.
 */
public class SiceeTPartecipante2015Pk implements Serializable
{
	protected long idPartecipante;

	/** 
	 * This attribute represents whether the primitive attribute idPartecipante is null.
	 */
	protected boolean idPartecipanteNull;

	/** 
	 * Sets the value of idPartecipante
	 */
	public void setIdPartecipante(long idPartecipante)
	{
		this.idPartecipante = idPartecipante;
	}

	/** 
	 * Gets the value of idPartecipante
	 */
	public long getIdPartecipante()
	{
		return idPartecipante;
	}

	/**
	 * Method 'SiceeTPartecipanti2015Pk'
	 * 
	 */
	public SiceeTPartecipante2015Pk()
	{
	}

	/**
	 * Method 'SiceeTPartecipanti2015Pk'
	 * 
	 * @param idPartecipante
	 */
	public SiceeTPartecipante2015Pk(final long idPartecipante)
	{
		this.idPartecipante = idPartecipante;
	}

	/** 
	 * Sets the value of idPartecipanteNull
	 */
	public void setIdPartecipanteNull(boolean idPartecipanteNull)
	{
		this.idPartecipanteNull = idPartecipanteNull;
	}

	/** 
	 * Gets the value of idPartecipanteNull
	 */
	public boolean isIdPartecipanteNull()
	{
		return idPartecipanteNull;
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
		
		if (!(_other instanceof SiceeTPartecipante2015Pk)) {
			return false;
		}
		
		final SiceeTPartecipante2015Pk _cast = (SiceeTPartecipante2015Pk) _other;
		if (idPartecipante != _cast.idPartecipante) {
			return false;
		}
		
		if (idPartecipanteNull != _cast.idPartecipanteNull) {
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
		_hashCode = 29 * _hashCode + (idPartecipanteNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTPartecipanti2015Pk: " );
		ret.append( "idPartecipante=" + idPartecipante );
		return ret.toString();
	}

}
