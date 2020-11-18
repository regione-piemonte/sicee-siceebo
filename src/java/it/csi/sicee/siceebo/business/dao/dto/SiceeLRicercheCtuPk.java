/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_L_RICERCHE_CTU table.
 */
public class SiceeLRicercheCtuPk implements Serializable
{
	protected String cfCtu;

	protected Date dataRicerca;

	/** 
	 * Sets the value of cfCtu
	 */
	public void setCfCtu(String cfCtu)
	{
		this.cfCtu = cfCtu;
	}

	/** 
	 * Gets the value of cfCtu
	 */
	public String getCfCtu()
	{
		return cfCtu;
	}

	/** 
	 * Sets the value of dataRicerca
	 */
	public void setDataRicerca(Date dataRicerca)
	{
		this.dataRicerca = dataRicerca;
	}

	/** 
	 * Gets the value of dataRicerca
	 */
	public Date getDataRicerca()
	{
		return dataRicerca;
	}

	/**
	 * Method 'SiceeLRicercheCtuPk'
	 * 
	 */
	public SiceeLRicercheCtuPk()
	{
	}

	/**
	 * Method 'SiceeLRicercheCtuPk'
	 * 
	 * @param cfCtu
	 * @param dataRicerca
	 */
	public SiceeLRicercheCtuPk(final String cfCtu, final Date dataRicerca)
	{
		this.cfCtu = cfCtu;
		this.dataRicerca = dataRicerca;
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
		
		if (!(_other instanceof SiceeLRicercheCtuPk)) {
			return false;
		}
		
		final SiceeLRicercheCtuPk _cast = (SiceeLRicercheCtuPk) _other;
		if (cfCtu == null ? _cast.cfCtu != cfCtu : !cfCtu.equals( _cast.cfCtu )) {
			return false;
		}
		
		if (dataRicerca == null ? _cast.dataRicerca != dataRicerca : !dataRicerca.equals( _cast.dataRicerca )) {
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
		if (cfCtu != null) {
			_hashCode = 29 * _hashCode + cfCtu.hashCode();
		}
		
		if (dataRicerca != null) {
			_hashCode = 29 * _hashCode + dataRicerca.hashCode();
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
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeLRicercheCtuPk: " );
		ret.append( "cfCtu=" + cfCtu );
		ret.append( ", dataRicerca=" + dataRicerca );
		return ret.toString();
	}

}
