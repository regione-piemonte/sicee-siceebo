/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_ENTEFORMATIVO_2015 table.
 */
public class SiceeTEnteform2015Pk implements Serializable
{
	protected long idEnte;

	/** 
	 * This attribute represents whether the primitive attribute idEnte is null.
	 */
	protected boolean idEnteNull;

	/** 
	 * Sets the value of idEnte
	 */
	public void setIdEnte(long idEnte)
	{
		this.idEnte = idEnte;
	}

	/** 
	 * Gets the value of idEnte
	 */
	public long getIdEnte()
	{
		return idEnte;
	}

	/**
	 * Method 'SiceeTEnteformativo2015Pk'
	 * 
	 */
	public SiceeTEnteform2015Pk()
	{
	}

	/**
	 * Method 'SiceeTEnteformativo2015Pk'
	 * 
	 * @param idEnte
	 */
	public SiceeTEnteform2015Pk(final long idEnte)
	{
		this.idEnte = idEnte;
	}

	/** 
	 * Sets the value of idEnteNull
	 */
	public void setIdEnteNull(boolean idEnteNull)
	{
		this.idEnteNull = idEnteNull;
	}

	/** 
	 * Gets the value of idEnteNull
	 */
	public boolean isIdEnteNull()
	{
		return idEnteNull;
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
		
		if (!(_other instanceof SiceeTEnteform2015Pk)) {
			return false;
		}
		
		final SiceeTEnteform2015Pk _cast = (SiceeTEnteform2015Pk) _other;
		if (idEnte != _cast.idEnte) {
			return false;
		}
		
		if (idEnteNull != _cast.idEnteNull) {
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
		_hashCode = 29 * _hashCode + (int) (idEnte ^ (idEnte >>> 32));
		_hashCode = 29 * _hashCode + (idEnteNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformativo2015Pk: " );
		ret.append( "idEnte=" + idEnte );
		return ret.toString();
	}

}
