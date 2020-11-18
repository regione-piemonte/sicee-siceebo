/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_CORSOENTEFORM_2015 table.
 */
public class SiceeTCorso2015Pk implements Serializable
{
	protected long idCorso;

	/** 
	 * This attribute represents whether the primitive attribute idCorso is null.
	 */
	protected boolean idCorsoNull;

	/** 
	 * Sets the value of idCorso
	 */
	public void setIdCorso(long idCorso)
	{
		this.idCorso = idCorso;
	}

	/** 
	 * Gets the value of idCorso
	 */
	public long getIdCorso()
	{
		return idCorso;
	}

	/**
	 * Method 'SiceeTCorsoenteform2015Pk'
	 * 
	 */
	public SiceeTCorso2015Pk()
	{
	}

	/**
	 * Method 'SiceeTCorsoenteform2015Pk'
	 * 
	 * @param idCorso
	 */
	public SiceeTCorso2015Pk(final long idCorso)
	{
		this.idCorso = idCorso;
	}

	/** 
	 * Sets the value of idCorsoNull
	 */
	public void setIdCorsoNull(boolean idCorsoNull)
	{
		this.idCorsoNull = idCorsoNull;
	}

	/** 
	 * Gets the value of idCorsoNull
	 */
	public boolean isIdCorsoNull()
	{
		return idCorsoNull;
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
		
		if (!(_other instanceof SiceeTCorso2015Pk)) {
			return false;
		}
		
		final SiceeTCorso2015Pk _cast = (SiceeTCorso2015Pk) _other;
		if (idCorso != _cast.idCorso) {
			return false;
		}
		
		if (idCorsoNull != _cast.idCorsoNull) {
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
		_hashCode = 29 * _hashCode + (int) (idCorso ^ (idCorso >>> 32));
		_hashCode = 29 * _hashCode + (idCorsoNull ? 1 : 0);
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
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTCorsoenteform2015Pk: " );
		ret.append( "idCorso=" + idCorso );
		return ret.toString();
	}

}
