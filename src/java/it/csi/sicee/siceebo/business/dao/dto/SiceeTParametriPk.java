/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_PARAMETRI table.
 */
public class SiceeTParametriPk implements Serializable
{
	protected String codice;

	/** 
	 * Sets the value of codice
	 */
	public void setCodice(String codice)
	{
		this.codice = codice;
	}

	/** 
	 * Gets the value of codice
	 */
	public String getCodice()
	{
		return codice;
	}

	/**
	 * Method 'SiceeTParametriPk'
	 * 
	 */
	public SiceeTParametriPk()
	{
	}

	/**
	 * Method 'SiceeTParametriPk'
	 * 
	 * @param codice
	 */
	public SiceeTParametriPk(final String codice)
	{
		this.codice = codice;
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
		
		if (!(_other instanceof SiceeTParametriPk)) {
			return false;
		}
		
		final SiceeTParametriPk _cast = (SiceeTParametriPk) _other;
		if (codice == null ? _cast.codice != codice : !codice.equals( _cast.codice )) {
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
		if (codice != null) {
			_hashCode = 29 * _hashCode + codice.hashCode();
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
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriPk: " );
		ret.append( "codice=" + codice );
		return ret.toString();
	}

}
