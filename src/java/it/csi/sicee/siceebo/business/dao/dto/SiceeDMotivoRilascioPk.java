/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_MOTIVO_RILASCIO table.
 */
public class SiceeDMotivoRilascioPk implements Serializable
{
	protected Integer idMotivo;

	/** 
	 * Sets the value of idMotivo
	 */
	public void setIdMotivo(Integer idMotivo)
	{
		this.idMotivo = idMotivo;
	}

	/** 
	 * Gets the value of idMotivo
	 */
	public Integer getIdMotivo()
	{
		return idMotivo;
	}

	/**
	 * Method 'SiceeDMotivoRilascioPk'
	 * 
	 */
	public SiceeDMotivoRilascioPk()
	{
	}

	/**
	 * Method 'SiceeDMotivoRilascioPk'
	 * 
	 * @param idMotivo
	 */
	public SiceeDMotivoRilascioPk(final Integer idMotivo)
	{
		this.idMotivo = idMotivo;
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
		
		if (!(_other instanceof SiceeDMotivoRilascioPk)) {
			return false;
		}
		
		final SiceeDMotivoRilascioPk _cast = (SiceeDMotivoRilascioPk) _other;
		if (idMotivo == null ? _cast.idMotivo != idMotivo : !idMotivo.equals( _cast.idMotivo )) {
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
		if (idMotivo != null) {
			_hashCode = 29 * _hashCode + idMotivo.hashCode();
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
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeDMotivoRilascioPk: " );
		ret.append( "idMotivo=" + idMotivo );
		return ret.toString();
	}

}
