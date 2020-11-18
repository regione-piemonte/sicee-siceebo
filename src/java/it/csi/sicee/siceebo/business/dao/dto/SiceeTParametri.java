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

public class SiceeTParametri implements Serializable
{
	/** 
	 * This attribute maps to the column CODICE in the SICEE_T_PARAMETRI table.
	 */
	protected String codice;

	/** 
	 * This attribute maps to the column VALORE in the SICEE_T_PARAMETRI table.
	 */
	protected String valore;

	/**
	 * Method 'SiceeTParametri'
	 * 
	 */
	public SiceeTParametri()
	{
	}

	/**
	 * Method 'getCodice'
	 * 
	 * @return String
	 */
	public String getCodice()
	{
		return codice;
	}

	/**
	 * Method 'setCodice'
	 * 
	 * @param codice
	 */
	public void setCodice(String codice)
	{
		this.codice = codice;
	}

	/**
	 * Method 'getValore'
	 * 
	 * @return String
	 */
	public String getValore()
	{
		return valore;
	}

	/**
	 * Method 'setValore'
	 * 
	 * @param valore
	 */
	public void setValore(String valore)
	{
		this.valore = valore;
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
		
		if (!(_other instanceof SiceeTParametri)) {
			return false;
		}
		
		final SiceeTParametri _cast = (SiceeTParametri) _other;
		if (codice == null ? _cast.codice != codice : !codice.equals( _cast.codice )) {
			return false;
		}
		
		if (valore == null ? _cast.valore != valore : !valore.equals( _cast.valore )) {
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
		if (codice != null) {
			_hashCode = 29 * _hashCode + codice.hashCode();
		}
		
		if (valore != null) {
			_hashCode = 29 * _hashCode + valore.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTParametriPk
	 */
	public SiceeTParametriPk createPk()
	{
		return new SiceeTParametriPk(codice);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTParametri: " );
		ret.append( "codice=" + codice );
		ret.append( ", valore=" + valore );
		return ret.toString();
	}

}
