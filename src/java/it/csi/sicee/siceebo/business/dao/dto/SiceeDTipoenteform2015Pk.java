/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_D_TIPO_ENTEFORM_2015 table.
 */
public class SiceeDTipoenteform2015Pk implements Serializable
{
	protected String idTipoenteform;

	/** 
	 * Sets the value of idTipoenteform
	 */
	public void setIdTipoenteform(String idTipoenteform)
	{
		this.idTipoenteform = idTipoenteform;
	}

	/** 
	 * Gets the value of idTipoenteform
	 */
	public String getIdTipoenteform()
	{
		return idTipoenteform;
	}

	/**
	 * Method 'SiceeDTipoenteform2015Pk'
	 * 
	 */
	public SiceeDTipoenteform2015Pk()
	{
	}

	/**
	 * Method 'SiceeDTipoenteform2015Pk'
	 * 
	 * @param idTipoenteform
	 */
	public SiceeDTipoenteform2015Pk(final String idTipoenteform)
	{
		this.idTipoenteform = idTipoenteform;
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
		
		if (!(_other instanceof SiceeDTipoenteform2015Pk)) {
			return false;
		}
		
		final SiceeDTipoenteform2015Pk _cast = (SiceeDTipoenteform2015Pk) _other;
		if (idTipoenteform == null ? _cast.idTipoenteform != idTipoenteform : !idTipoenteform.equals( _cast.idTipoenteform )) {
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
		if (idTipoenteform != null) {
			_hashCode = 29 * _hashCode + idTipoenteform.hashCode();
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
		ret.append( "it.csi.sicee.siceesrv.business.dao.dto.SiceeDTipoenteform2015Pk: " );
		ret.append( "idTipoenteform=" + idTipoenteform );
		return ret.toString();
	}

}
