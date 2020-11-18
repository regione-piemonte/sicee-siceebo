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

public class SiceeDClasseEnergetica implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CLASSE in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	protected Integer idClasse;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	protected String descr;

	/** 
	 * This attribute maps to the column FLG_NAZIONALE_19205 in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	protected String flgNazionale19205;

	/** 
	 * This attribute maps to the column FLG_ATTIVO in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	protected Integer flgAttivo;
	
	/**
	 * Method 'SiceeDClasseEnergetica'
	 * 
	 */
	public SiceeDClasseEnergetica()
	{
	}

	/**
	 * Method 'getIdClasse'
	 * 
	 * @return Integer
	 */
	public Integer getIdClasse()
	{
		return idClasse;
	}

	/**
	 * Method 'setIdClasse'
	 * 
	 * @param idClasse
	 */
	public void setIdClasse(Integer idClasse)
	{
		this.idClasse = idClasse;
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
	 * Method 'getFlgNazionale19205'
	 * 
	 * @return String
	 */
	public String getFlgNazionale19205()
	{
		return flgNazionale19205;
	}

	/**
	 * Method 'setFlgNazionale19205'
	 * 
	 * @param flgNazionale19205
	 */
	public void setFlgNazionale19205(String flgNazionale19205)
	{
		this.flgNazionale19205 = flgNazionale19205;
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
		
		if (!(_other instanceof SiceeDClasseEnergetica)) {
			return false;
		}
		
		final SiceeDClasseEnergetica _cast = (SiceeDClasseEnergetica) _other;
		if (idClasse == null ? _cast.idClasse != idClasse : !idClasse.equals( _cast.idClasse )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
			return false;
		}
		
		if (flgNazionale19205 == null ? _cast.flgNazionale19205 != flgNazionale19205 : !flgNazionale19205.equals( _cast.flgNazionale19205 )) {
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
		if (idClasse != null) {
			_hashCode = 29 * _hashCode + idClasse.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		if (flgNazionale19205 != null) {
			_hashCode = 29 * _hashCode + flgNazionale19205.hashCode();
		}
		
		if (flgAttivo != null) {
			_hashCode = 29 * _hashCode + flgAttivo.hashCode();
		}
		
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDClasseEnergeticaPk
	 */
	public SiceeDClasseEnergeticaPk createPk()
	{
		return new SiceeDClasseEnergeticaPk(idClasse);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeDClasseEnergetica: " );
		ret.append( "idClasse=" + idClasse );
		ret.append( ", descr=" + descr );
		ret.append( ", flgNazionale19205=" + flgNazionale19205 );
		ret.append( ", flgAttivo=" + flgAttivo );

		return ret.toString();
	}

}
