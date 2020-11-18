/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;

/** 
 * This class represents the primary key of the SICEE_T_PARAMETRI_ACTA table.
 */
public class SiceeTParametriActaPk implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1893546527389796958L;

	protected Integer idParametriActa;

	/** 
	 * This attribute represents whether the primitive attribute idParametriActa is null.
	 */
	protected boolean idParametriActaNull;

	/** 
	 * Sets the value of idParametriActa
	 */
	public void setIdParametriActa(Integer idParametriActa)
	{
		this.idParametriActa = idParametriActa;
	}

	/** 
	 * Gets the value of idParametriActa
	 */
	public Integer getIdParametriActa()
	{
		return this.idParametriActa;
	}

	/**
	 * Method 'SiceeTParametriActaPk'
	 * 
	 */
	public SiceeTParametriActaPk()
	{
	}

	/**
	 * Method 'SiceeTParametriActaPk'
	 * 
	 * @param idAzienda
	 */
	public SiceeTParametriActaPk(final Integer idParametriActa)
	{
		this.idParametriActa = idParametriActa;
	}

	/** 
	 * Sets the value of idParametriActaNull
	 */
	public void setIdParametriActaNull(boolean idParametriActaNull)
	{
		this.idParametriActaNull = idParametriActaNull;
	}

	/** 
	 * Gets the value of idParametriActaNull
	 */
	public boolean isIdParametriActaNull()
	{
		return this.idParametriActaNull;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	@Override
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeTParametriActaPk)) {
			return false;
		}
		
		final SiceeTParametriActaPk _cast = (SiceeTParametriActaPk) _other;
		if (this.idParametriActa != _cast.idParametriActa) {
			return false;
		}
		
		if (this.idParametriActaNull != _cast.idParametriActaNull) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	@Override
	public int hashCode()
	{
		int _hashCode = 0;
		_hashCode = 29 * _hashCode + (int) (this.idParametriActa ^ (this.idParametriActa >>> 32));
		_hashCode = 29 * _hashCode + (this.idParametriActaNull ? 1 : 0);
		return _hashCode;
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	@Override
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriActaPk: " );
		ret.append( "idParametriActa=" + this.idParametriActa );
		return ret.toString();
	}

}
