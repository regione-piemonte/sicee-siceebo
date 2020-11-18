/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_ENTEFORM_SL_2015 table.
 */
public class SiceeTEnteformSl2015Pk implements Serializable
{
	protected long idEnteSl;

	/** 
	 * This attribute represents whether the primitive attribute idEnte is null.
	 */
	protected boolean idEnteSlNull;

	/** 
	 * Sets the value of idEnte
	 */
	public void setIdEnteSl(long idEnteSl)
	{
		this.idEnteSl = idEnteSl;
	}

	/** 
	 * Gets the value of idEnte
	 */
	public long getIdEnteSl()
	{
		return idEnteSl;
	}

	/**
	 * Method 'SiceeTEnteformativo2015Pk'
	 * 
	 */
	public SiceeTEnteformSl2015Pk()
	{
	}

	/**
	 * Method 'SiceeTEnteformativo2015Pk'
	 * 
	 * @param idEnteSl
	 */
	public SiceeTEnteformSl2015Pk(final long idEnteSl)
	{
		this.idEnteSl = idEnteSl;
	}

	/** 
	 * Sets the value of idEnteSlNull
	 */
	public void setIdEnteSlNull(boolean idEnteSlNull)
	{
		this.idEnteSlNull = idEnteSlNull;
	}

	/** 
	 * Gets the value of idEnteSlNull
	 */
	public boolean isIdEnteSlNull()
	{
		return idEnteSlNull;
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
		
		if (!(_other instanceof SiceeTEnteformSl2015Pk)) {
			return false;
		}
		
		final SiceeTEnteformSl2015Pk _cast = (SiceeTEnteformSl2015Pk) _other;
		if (idEnteSl != _cast.idEnteSl) {
			return false;
		}
		
		if (idEnteSlNull != _cast.idEnteSlNull) {
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
		_hashCode = 29 * _hashCode + (int) (idEnteSl ^ (idEnteSl >>> 32));
		_hashCode = 29 * _hashCode + (idEnteSlNull ? 1 : 0);
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
		ret.append( "idEnte=" + idEnteSl );
		return ret.toString();
	}

}
