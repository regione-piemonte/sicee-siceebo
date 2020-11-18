/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_T_ENTEFORM_CF_2015 table.
 */
public class SiceeTEnteformCf2015Pk implements Serializable
{
	protected long idEnte;

	protected String cfCertificato;

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
	 * Sets the value of cfCertificato
	 */
	public void setCfCertificato(String cfCertificato)
	{
		this.cfCertificato = cfCertificato;
	}

	/** 
	 * Gets the value of cfCertificato
	 */
	public String getCfCertificato()
	{
		return cfCertificato;
	}

	/**
	 * Method 'SiceeTEnteCf2015Pk'
	 * 
	 */
	public SiceeTEnteformCf2015Pk()
	{
	}

	/**
	 * Method 'SiceeTEnteCf2015Pk'
	 * 
	 * @param idEnte
	 * @param cfCertificato
	 */
	public SiceeTEnteformCf2015Pk(final long idEnte, final String cfCertificato)
	{
		this.idEnte = idEnte;
		this.cfCertificato = cfCertificato;
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
		
		if (!(_other instanceof SiceeTEnteformCf2015Pk)) {
			return false;
		}
		
		final SiceeTEnteformCf2015Pk _cast = (SiceeTEnteformCf2015Pk) _other;
		if (idEnte != _cast.idEnte) {
			return false;
		}
		
		if (cfCertificato == null ? _cast.cfCertificato != cfCertificato : !cfCertificato.equals( _cast.cfCertificato )) {
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
		if (cfCertificato != null) {
			_hashCode = 29 * _hashCode + cfCertificato.hashCode();
		}
		
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
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteCf2015Pk: " );
		ret.append( "idEnte=" + idEnte );
		ret.append( ", cfCertificato=" + cfCertificato );
		return ret.toString();
	}

}
