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

public class SiceeDDestUso implements Serializable
{
	/** 
	 * This attribute maps to the column ID_DEST_USO in the SICEE_D_DEST_USO table.
	 */
	protected Integer idDestUso;

	/** 
	 * This attribute maps to the column SIGLA in the SICEE_D_DEST_USO table.
	 */
	protected String sigla;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_DEST_USO table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FLG_EDIFICIO in the SICEE_D_DEST_USO table.
	 */
	protected String flgEdificio;

	/** 
	 * This attribute maps to the column FLG_VISIBILE_COMBO in the SICEE_D_DEST_USO table.
	 */
	protected String flgVisibileCombo;

	/** 
	 * This attribute maps to the column FLG_RICERCA in the SICEE_D_DEST_USO table.
	 */
	protected String flgRicerca;

	/**
	 * Method 'SiceeDDestUso'
	 * 
	 */
	public SiceeDDestUso()
	{
	}

	/**
	 * Method 'getIdDestUso'
	 * 
	 * @return Integer
	 */
	public Integer getIdDestUso()
	{
		return idDestUso;
	}

	/**
	 * Method 'setIdDestUso'
	 * 
	 * @param idDestUso
	 */
	public void setIdDestUso(Integer idDestUso)
	{
		this.idDestUso = idDestUso;
	}

	/**
	 * Method 'getSigla'
	 * 
	 * @return String
	 */
	public String getSigla()
	{
		return sigla;
	}

	/**
	 * Method 'setSigla'
	 * 
	 * @param sigla
	 */
	public void setSigla(String sigla)
	{
		this.sigla = sigla;
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
	 * Method 'getFlgEdificio'
	 * 
	 * @return String
	 */
	public String getFlgEdificio()
	{
		return flgEdificio;
	}

	/**
	 * Method 'setFlgEdificio'
	 * 
	 * @param flgEdificio
	 */
	public void setFlgEdificio(String flgEdificio)
	{
		this.flgEdificio = flgEdificio;
	}

	/**
	 * Method 'getFlgVisibileCombo'
	 * 
	 * @return String
	 */
	public String getFlgVisibileCombo()
	{
		return flgVisibileCombo;
	}

	/**
	 * Method 'setFlgVisibileCombo'
	 * 
	 * @param flgVisibileCombo
	 */
	public void setFlgVisibileCombo(String flgVisibileCombo)
	{
		this.flgVisibileCombo = flgVisibileCombo;
	}

	/**
	 * Method 'getFlgRicerca'
	 * 
	 * @return String
	 */
	public String getFlgRicerca()
	{
		return flgRicerca;
	}

	/**
	 * Method 'setFlgRicerca'
	 * 
	 * @param flgRicerca
	 */
	public void setFlgRicerca(String flgRicerca)
	{
		this.flgRicerca = flgRicerca;
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
		
		if (!(_other instanceof SiceeDDestUso)) {
			return false;
		}
		
		final SiceeDDestUso _cast = (SiceeDDestUso) _other;
		if (idDestUso == null ? _cast.idDestUso != idDestUso : !idDestUso.equals( _cast.idDestUso )) {
			return false;
		}
		
		if (sigla == null ? _cast.sigla != sigla : !sigla.equals( _cast.sigla )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
			return false;
		}
		
		if (flgEdificio == null ? _cast.flgEdificio != flgEdificio : !flgEdificio.equals( _cast.flgEdificio )) {
			return false;
		}
		
		if (flgVisibileCombo == null ? _cast.flgVisibileCombo != flgVisibileCombo : !flgVisibileCombo.equals( _cast.flgVisibileCombo )) {
			return false;
		}
		
		if (flgRicerca == null ? _cast.flgRicerca != flgRicerca : !flgRicerca.equals( _cast.flgRicerca )) {
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
		if (idDestUso != null) {
			_hashCode = 29 * _hashCode + idDestUso.hashCode();
		}
		
		if (sigla != null) {
			_hashCode = 29 * _hashCode + sigla.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		if (flgEdificio != null) {
			_hashCode = 29 * _hashCode + flgEdificio.hashCode();
		}
		
		if (flgVisibileCombo != null) {
			_hashCode = 29 * _hashCode + flgVisibileCombo.hashCode();
		}
		
		if (flgRicerca != null) {
			_hashCode = 29 * _hashCode + flgRicerca.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDDestUsoPk
	 */
	public SiceeDDestUsoPk createPk()
	{
		return new SiceeDDestUsoPk(idDestUso);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeDDestUso: " );
		ret.append( "idDestUso=" + idDestUso );
		ret.append( ", sigla=" + sigla );
		ret.append( ", descr=" + descr );
		ret.append( ", flgEdificio=" + flgEdificio );
		ret.append( ", flgVisibileCombo=" + flgVisibileCombo );
		ret.append( ", flgRicerca=" + flgRicerca );
		return ret.toString();
	}

}
