/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class SiceeSAccessoPk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4114158566399266037L;
	
	protected Timestamp dtAccesso;
	
	protected String codiceFiscale;

	public SiceeSAccessoPk(Timestamp dtAccesso, String codiceFiscale) {
		this.dtAccesso = dtAccesso;
		this.codiceFiscale = codiceFiscale;
	}

	public Timestamp getDtAccesso() {
		return dtAccesso;
	}

	public void setDtAccesso(Timestamp dtAccesso) {
		this.dtAccesso = dtAccesso;
	}
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
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
		
		if (!(_other instanceof SiceeSAccessoPk)) {
			return false;
		}
		
		final SiceeSAccessoPk _cast = (SiceeSAccessoPk) _other;
		if (dtAccesso == null ? _cast.dtAccesso != dtAccesso : !dtAccesso.equals( _cast.dtAccesso )) {
			return false;
		}
		
		if (codiceFiscale == null ? _cast.codiceFiscale != codiceFiscale : !codiceFiscale.equals( _cast.codiceFiscale )) {
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
		if (dtAccesso != null) {
			_hashCode = 29 * _hashCode + dtAccesso.hashCode();
		}
		
		if (codiceFiscale != null) {
			_hashCode = 29 * _hashCode + codiceFiscale.hashCode();
		}
		
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
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeSAccessoPk: " );
		ret.append( "dtAccesso=" + dtAccesso );
		ret.append( "codiceFiscale=" + codiceFiscale );
		return ret.toString();
	}
}
