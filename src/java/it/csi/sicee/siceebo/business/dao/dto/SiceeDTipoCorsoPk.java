/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_CORSO table.
 */
public class SiceeDTipoCorsoPk implements Serializable
{
	protected Integer idTipoCorso;

	/** 
	 * Sets the value of idTipoCorso
	 */
	public void setIdTipoCorso(Integer idTipoCorso)
	{
		this.idTipoCorso = idTipoCorso;
	}

	/** 
	 * Gets the value of idTipoCorso
	 */
	public Integer getIdTipoCorso()
	{
		return idTipoCorso;
	}

	/**
	 * Method 'SiceeDTipoCorsoPk'
	 * 
	 */
	public SiceeDTipoCorsoPk()
	{
	}

	/**
	 * Method 'SiceeDDestUso2015Pk'
	 * 
	 * @param idDestUso2015
	 */
	public SiceeDTipoCorsoPk(final Integer idTipoCorso)
	{
		this.idTipoCorso = idTipoCorso;
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
		
		if (!(_other instanceof SiceeDTipoCorsoPk)) {
			return false;
		}
		
		final SiceeDTipoCorsoPk _cast = (SiceeDTipoCorsoPk) _other;
		if (idTipoCorso == null ? _cast.idTipoCorso != idTipoCorso : !idTipoCorso.equals( _cast.idTipoCorso )) {
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
		if (idTipoCorso != null) {
			_hashCode = 29 * _hashCode + idTipoCorso.hashCode();
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
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoCorsoPk: " );
		ret.append( "idTipoCorso=" + idTipoCorso );
		return ret.toString();
	}

}
