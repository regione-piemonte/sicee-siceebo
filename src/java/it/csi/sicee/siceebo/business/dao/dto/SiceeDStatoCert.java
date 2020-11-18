/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;

public class SiceeDStatoCert implements Serializable
{
	/** 
	 * This attribute maps to the column ID_STATO in the SICEE_D_STATO_CERT table.
	 */
	protected Integer idStato;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_STATO_CERT table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDStatoCert'
	 * 
	 */
	public SiceeDStatoCert()
	{
	}

	/**
	 * Method 'getIdStato'
	 * 
	 * @return Integer
	 */
	public Integer getIdStato()
	{
		return idStato;
	}

	/**
	 * Method 'setIdStato'
	 * 
	 * @param idStato
	 */
	public void setIdStato(Integer idStato)
	{
		this.idStato = idStato;
	}

	/**
	 * Method 'getDescr'
	 * 
	 * @return String
	 */
	public String getDescr()
	{
		return descr;
	}

	/**
	 * Method 'setDescr'
	 * 
	 * @param descr
	 */
	public void setDescr(String descr)
	{
		this.descr = descr;
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
		
		if (!(_other instanceof SiceeDStatoCert)) {
			return false;
		}
		
		final SiceeDStatoCert _cast = (SiceeDStatoCert) _other;
		if (idStato == null ? _cast.idStato != idStato : !idStato.equals( _cast.idStato )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
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
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDStatoCertPk
	 */
	public SiceeDStatoCertPk createPk()
	{
		return new SiceeDStatoCertPk(idStato);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceesrv.business.dao.dto.SiceeDStatoCert: " );
		ret.append( "idStato=" + idStato );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
