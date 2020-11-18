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

public class SiceeTEnteformCf2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_ENTE in the SICEE_T_ENTEFORM_CF_2015 table.
	 */
	protected long idEnte;

	/** 
	 * This attribute maps to the column CF_CERTIFICATO in the SICEE_T_ENTEFORM_CF_2015 table.
	 */
	protected String cfCertificato;

	/** 
	 * This attribute maps to the column RUOLO in the SICEE_T_ENTEFORM_CF_2015 table.
	 */
	protected String ruolo;

	/**
	 * Method 'SiceeTEnteCf2015'
	 * 
	 */
	public SiceeTEnteformCf2015()
	{
	}

	/**
	 * Method 'getIdEnte'
	 * 
	 * @return long
	 */
	public long getIdEnte()
	{
		return idEnte;
	}

	/**
	 * Method 'setIdEnte'
	 * 
	 * @param idEnte
	 */
	public void setIdEnte(long idEnte)
	{
		this.idEnte = idEnte;
	}

	/**
	 * Method 'getCfCertificato'
	 * 
	 * @return String
	 */
	public String getCfCertificato()
	{
		return cfCertificato;
	}

	/**
	 * Method 'setCfCertificato'
	 * 
	 * @param cfCertificato
	 */
	public void setCfCertificato(String cfCertificato)
	{
		this.cfCertificato = cfCertificato;
	}

	/**
	 * Method 'getRuolo'
	 * 
	 * @return String
	 */
	public String getRuolo()
	{
		return ruolo;
	}

	/**
	 * Method 'setRuolo'
	 * 
	 * @param ruolo
	 */
	public void setRuolo(String ruolo)
	{
		this.ruolo = ruolo;
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
		
		if (!(_other instanceof SiceeTEnteformCf2015)) {
			return false;
		}
		
		final SiceeTEnteformCf2015 _cast = (SiceeTEnteformCf2015) _other;
		if (idEnte != _cast.idEnte) {
			return false;
		}
		
		if (cfCertificato == null ? _cast.cfCertificato != cfCertificato : !cfCertificato.equals( _cast.cfCertificato )) {
			return false;
		}
		
		if (ruolo == null ? _cast.ruolo != ruolo : !ruolo.equals( _cast.ruolo )) {
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
		if (ruolo!= null) {
			_hashCode = 29 * _hashCode + ruolo.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTEnteformCf2015Pk
	 */
	public SiceeTEnteformCf2015Pk createPk()
	{
		return new SiceeTEnteformCf2015Pk(idEnte, cfCertificato);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteCf2015: " );
		ret.append( "idEnte=" + idEnte );
		ret.append( ", cfCertificato=" + cfCertificato );
		ret.append( ", ruolo=" + ruolo );
		return ret.toString();
	}

}
