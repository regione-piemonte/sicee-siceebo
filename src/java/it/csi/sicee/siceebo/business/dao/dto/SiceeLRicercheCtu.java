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
import java.util.Date;

public class SiceeLRicercheCtu implements Serializable
{
	/** 
	 * This attribute maps to the column CF_CTU in the SICEE_L_RICERCHE_CTU table.
	 */
	protected String cfCtu;

	/** 
	 * This attribute maps to the column DATA_RICERCA in the SICEE_L_RICERCHE_CTU table.
	 */
	protected Date dataRicerca;

	/** 
	 * This attribute maps to the column MOTIVAZIONE_CTU in the SICEE_L_RICERCHE_CTU table.
	 */
	protected String motivazioneCtu;

	/**
	 * Method 'SiceeLRicercheCtu'
	 * 
	 */
	public SiceeLRicercheCtu()
	{
	}

	/**
	 * Method 'getCfCtu'
	 * 
	 * @return String
	 */
	public String getCfCtu()
	{
		return cfCtu;
	}

	/**
	 * Method 'setCfCtu'
	 * 
	 * @param cfCtu
	 */
	public void setCfCtu(String cfCtu)
	{
		this.cfCtu = cfCtu;
	}

	/**
	 * Method 'getDataRicerca'
	 * 
	 * @return Date
	 */
	public Date getDataRicerca()
	{
		return dataRicerca;
	}

	/**
	 * Method 'setDataRicerca'
	 * 
	 * @param dataRicerca
	 */
	public void setDataRicerca(Date dataRicerca)
	{
		this.dataRicerca = dataRicerca;
	}

	/**
	 * Method 'getMotivazioneCtu'
	 * 
	 * @return String
	 */
	public String getMotivazioneCtu()
	{
		return motivazioneCtu;
	}

	/**
	 * Method 'setMotivazioneCtu'
	 * 
	 * @param motivazioneCtu
	 */
	public void setMotivazioneCtu(String motivazioneCtu)
	{
		this.motivazioneCtu = motivazioneCtu;
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
		
		if (!(_other instanceof SiceeLRicercheCtu)) {
			return false;
		}
		
		final SiceeLRicercheCtu _cast = (SiceeLRicercheCtu) _other;
		if (cfCtu == null ? _cast.cfCtu != cfCtu : !cfCtu.equals( _cast.cfCtu )) {
			return false;
		}
		
		if (dataRicerca == null ? _cast.dataRicerca != dataRicerca : !dataRicerca.equals( _cast.dataRicerca )) {
			return false;
		}
		
		if (motivazioneCtu == null ? _cast.motivazioneCtu != motivazioneCtu : !motivazioneCtu.equals( _cast.motivazioneCtu )) {
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
		if (cfCtu != null) {
			_hashCode = 29 * _hashCode + cfCtu.hashCode();
		}
		
		if (dataRicerca != null) {
			_hashCode = 29 * _hashCode + dataRicerca.hashCode();
		}
		
		if (motivazioneCtu != null) {
			_hashCode = 29 * _hashCode + motivazioneCtu.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeLRicercheCtuPk
	 */
	public SiceeLRicercheCtuPk createPk()
	{
		return new SiceeLRicercheCtuPk(cfCtu, dataRicerca);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeLRicercheCtu: " );
		ret.append( "cfCtu=" + cfCtu );
		ret.append( ", dataRicerca=" + dataRicerca );
		ret.append( ", motivazioneCtu=" + motivazioneCtu );
		return ret.toString();
	}

}
