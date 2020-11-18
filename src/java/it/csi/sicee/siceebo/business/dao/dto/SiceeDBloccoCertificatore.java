/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import it.csi.sicee.siceebo.business.dao.dao.*;
import it.csi.sicee.siceebo.business.dao.factory.*;
import it.csi.sicee.siceebo.business.dao.exceptions.*;
import java.io.Serializable;
import java.util.*;

public class SiceeDBloccoCertificatore implements Serializable
{
	/** 
	 * This attribute maps to the column ID_BLOCCO_CERT in the SICEE_D_BLOCCO_CERTIFICATORE table.
	 */
	protected Integer idBloccoCertificatore;

	/** 
	 * This attribute maps to the column FLG_BLOCCO in the SICEE_D_BLOCCO_CERTIFICATORE table.
	 */
	protected Integer flgBlocco;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_BLOCCO_CERTIFICATORE table.
	 */
	protected String descr;


	/**
	 * Method 'SiceeDBloccoCertificatore'
	 * 
	 */
	public SiceeDBloccoCertificatore()
	{
	}

	/**
	 * Method 'getIdBloccoCert'
	 * 
	 * @return Integer
	 */
	public Integer getIdBloccoCertificatore()
	{
		return idBloccoCertificatore;
	}

	/**
	 * Method 'setIdBloccoCert'
	 * 
	 * @param idBloccoCert
	 */
	public void setIdBloccoCertificatore(Integer idBloccoCertificatore)
	{
		this.idBloccoCertificatore = idBloccoCertificatore;
	}

	/**
	 * Method 'getFlgBlocco'
	 * 
	 * @return Integer
	 */
	public Integer getFlgBlocco()
	{
		return flgBlocco;
	}

	/**
	 * Method 'setFlgBlocco'
	 * 
	 * @param flgBlocco
	 */
	public void setFlgBlocco(Integer flgBlocco)
	{
		this.flgBlocco = flgBlocco;
	}

	/**
	 * Method 'getDescr'
	 * 
	 * @return String
	 */
	public String getDescr()
	{
		return descr;
	}

	/**
	 * Method 'setDescr'
	 * 
	 * @param descr
	 */
	public void setDescr(String descr)
	{
		this.descr = descr;
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
		
		if (!(_other instanceof SiceeDBloccoCertificatore)) {
			return false;
		}
		
		final SiceeDBloccoCertificatore _cast = (SiceeDBloccoCertificatore) _other;
		if (idBloccoCertificatore == null ? _cast.idBloccoCertificatore != idBloccoCertificatore : !idBloccoCertificatore.equals( _cast.idBloccoCertificatore )) {
			return false;
		}
		
		if (flgBlocco == null ? _cast.flgBlocco != flgBlocco : !flgBlocco.equals( _cast.flgBlocco )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
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
		if (idBloccoCertificatore != null) {
			_hashCode = 29 * _hashCode + idBloccoCertificatore.hashCode();
		}
		
		if (flgBlocco != null) {
			_hashCode = 29 * _hashCode + flgBlocco.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDBloccoCertificatorePk
	 */
	public SiceeDBloccoCertificatorePk createPk()
	{
		return new SiceeDBloccoCertificatorePk(idBloccoCertificatore);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeDBloccoCertificatore: " );
		ret.append( "idBloccoCertificatore=" + idBloccoCertificatore );
		ret.append( ", flgBlocco=" + flgBlocco );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
