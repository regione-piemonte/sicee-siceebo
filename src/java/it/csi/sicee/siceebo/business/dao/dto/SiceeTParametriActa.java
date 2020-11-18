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

public class SiceeTParametriActa implements Serializable
{
	/** 
	 * This attribute maps to the column ID_PARAMETRI_ACTA in the SICEE_T_PARAMETRI_ACTA table.
	 */
	protected Integer idParametriActa;
	
	/** 
	 * This attribute maps to the column CODICE in the SICEE_T_PARAMETRI_ACTA table.
	 */
	protected String codice;

	/** 
	 * This attribute maps to the column VALORE in the SICEE_T_PARAMETRI_ACTA table.
	 */
	protected String valore;

	/**
	 * Method 'SiceeTParametri'
	 * 
	 */
	public SiceeTParametriActa()
	{
	}

	/**
	 * Method 'getIdParametriActa'
	 * 
	 * @return Integer
	 */
	public Integer getIdParametriActa()
	{
		return this.idParametriActa;
	}

	/**
	 * Method 'setIdParametriActa'
	 * 
	 * @param idParametriActa
	 */
	public void setIdParametriActa(Integer idParametriActa)
	{
		this.idParametriActa = idParametriActa;
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
		
		if (!(_other instanceof SiceeTParametriActa)) {
			return false;
		}
		
		final SiceeTParametriActa _cast = (SiceeTParametriActa) _other;

		if (idParametriActa == null ? _cast.idParametriActa != idParametriActa : !idParametriActa.equals( _cast.idParametriActa )) {
			return false;
		}
		
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
		if (idParametriActa != null) {
			_hashCode = 29 * _hashCode + idParametriActa.hashCode();
		}
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
	 * @return SiceeTParametriActaPk
	 */
	public SiceeTParametriActaPk createPk()
	{
		return new SiceeTParametriActaPk(idParametriActa);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriActa: " );
		ret.append( "idParametriActa=" + this.idParametriActa );
		ret.append( ", codice=" + codice );
		ret.append( ", valore=" + valore );
		return ret.toString();
	}

}
