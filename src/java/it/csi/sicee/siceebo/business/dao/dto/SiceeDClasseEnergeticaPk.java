/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * This class represents the primary key of the SICEE_D_CLASSE_ENERGETICA table.
 */
public class SiceeDClasseEnergeticaPk implements Serializable
{
	protected Integer idClasse;

	/** 
	 * Sets the value of idClasse
	 */
	public void setIdClasse(Integer idClasse)
	{
		this.idClasse = idClasse;
	}

	/** 
	 * Gets the value of idClasse
	 */
	public Integer getIdClasse()
	{
		return idClasse;
	}

	/**
	 * Method 'SiceeDClasseEnergeticaPk'
	 * 
	 */
	public SiceeDClasseEnergeticaPk()
	{
	}

	/**
	 * Method 'SiceeDClasseEnergeticaPk'
	 * 
	 * @param idClasse
	 */
	public SiceeDClasseEnergeticaPk(final Integer idClasse)
	{
		this.idClasse = idClasse;
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
		
		if (!(_other instanceof SiceeDClasseEnergeticaPk)) {
			return false;
		}
		
		final SiceeDClasseEnergeticaPk _cast = (SiceeDClasseEnergeticaPk) _other;
		if (idClasse == null ? _cast.idClasse != idClasse : !idClasse.equals( _cast.idClasse )) {
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
		if (idClasse != null) {
			_hashCode = 29 * _hashCode + idClasse.hashCode();
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
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeDClasseEnergeticaPk: " );
		ret.append( "idClasse=" + idClasse );
		return ret.toString();
	}

}
