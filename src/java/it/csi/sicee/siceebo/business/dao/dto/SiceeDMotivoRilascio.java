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

public class SiceeDMotivoRilascio implements Serializable
{
	/** 
	 * This attribute maps to the column ID_MOTIVO in the SICEE_D_MOTIVO_RILASCIO table.
	 */
	protected Integer idMotivo;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_MOTIVO_RILASCIO table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FLG_VISIBILE_COMBO in the SICEE_D_MOTIVO_RILASCIO table.
	 */
	protected String flgVisibileCombo;

	/** 
	 * This attribute maps to the column FLG_ATTIVO in the SICEE_D_MOTIVO_RILASCIO table.
	 */
	protected Integer flgAttivo;
	
	/**
	 * Method 'SiceeDMotivoRilascio'
	 * 
	 */
	public SiceeDMotivoRilascio()
	{
	}

	/**
	 * Method 'getIdMotivo'
	 * 
	 * @return Integer
	 */
	public Integer getIdMotivo()
	{
		return idMotivo;
	}

	/**
	 * Method 'setIdMotivo'
	 * 
	 * @param idMotivo
	 */
	public void setIdMotivo(Integer idMotivo)
	{
		this.idMotivo = idMotivo;
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
	 * Method 'getFlgAttivo'
	 * 
	 * @return Integer
	 */
	public Integer getFlgAttivo()
	{
		return flgAttivo;
	}

	/**
	 * Method 'setFlgAttivo'
	 * 
	 * @param flgAttivo
	 */
	public void setFlgAttivo(Integer flgAttivo)
	{
		this.flgAttivo = flgAttivo;
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
		
		if (!(_other instanceof SiceeDMotivoRilascio)) {
			return false;
		}
		
		final SiceeDMotivoRilascio _cast = (SiceeDMotivoRilascio) _other;
		if (idMotivo == null ? _cast.idMotivo != idMotivo : !idMotivo.equals( _cast.idMotivo )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
			return false;
		}

		if (flgVisibileCombo == null ? _cast.flgVisibileCombo != flgVisibileCombo : !flgVisibileCombo.equals( _cast.flgVisibileCombo )) {
			return false;
		}
		
		if (flgAttivo == null ? _cast.flgAttivo != flgAttivo : !flgAttivo.equals( _cast.flgAttivo )) {
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
		if (idMotivo != null) {
			_hashCode = 29 * _hashCode + idMotivo.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		if (flgVisibileCombo != null) {
			_hashCode = 29 * _hashCode + flgVisibileCombo.hashCode();
		}
		
		if (flgAttivo != null) {
			_hashCode = 29 * _hashCode + flgAttivo.hashCode();
		}
		
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDMotivoRilascioPk
	 */
	public SiceeDMotivoRilascioPk createPk()
	{
		return new SiceeDMotivoRilascioPk(idMotivo);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeDMotivoRilascio: " );
		ret.append( "idMotivo=" + idMotivo );
		ret.append( ", descr=" + descr );
		ret.append( ", flgVisibileCombo=" + flgVisibileCombo );
		ret.append( ", flgAttivo=" + flgAttivo );
		return ret.toString();
	}

}
