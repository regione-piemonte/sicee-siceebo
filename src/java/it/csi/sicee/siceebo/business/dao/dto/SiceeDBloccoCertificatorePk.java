/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_BLOCCO_CERTIFICATORE table.
 */
public class SiceeDBloccoCertificatorePk implements Serializable
{
	protected Integer idBloccoCertificatore;

	/** 
	 * Sets the value of idBloccoCert
	 */
	public void setIdBloccoCertificatore(Integer idBloccoCertificatore)
	{
		this.idBloccoCertificatore = idBloccoCertificatore;
	}

	/** 
	 * Gets the value of idBloccoCert
	 */
	public Integer getIdBloccoCertificatore()
	{
		return idBloccoCertificatore;
	}

	/**
	 * Method 'SiceeDBloccoCertPk'
	 * 
	 */
	public SiceeDBloccoCertificatorePk()
	{
	}

	/**
	 * Method 'SiceeDBloccoCertificatorePk'
	 * 
	 * @param idBlocco
	 */
	public SiceeDBloccoCertificatorePk(final Integer idBloccoCertificatore)
	{
		this.idBloccoCertificatore = idBloccoCertificatore;
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
		
		if (!(_other instanceof SiceeDBloccoCertificatorePk)) {
			return false;
		}
		
		final SiceeDBloccoCertificatorePk _cast = (SiceeDBloccoCertificatorePk) _other;
		if (idBloccoCertificatore == null ? _cast.idBloccoCertificatore != idBloccoCertificatore : !idBloccoCertificatore.equals( _cast.idBloccoCertificatore )) {
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
		if (idBloccoCertificatore != null) {
			_hashCode = 29 * _hashCode + idBloccoCertificatore.hashCode();
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
		ret.append( "it.csi.sicee.siceesrv.business.dao.dto.SiceeDBloccoCertificatorePk: " );
		ret.append( "idBloccoCertificatore=" + idBloccoCertificatore );
		return ret.toString();
	}

}
