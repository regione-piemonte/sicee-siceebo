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

public class SiceeDTipoCorso implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPO_CORSO in the SICEE_D_TIPO_CORSO table.
	 */
	protected Integer idTipoCorso;

	/** 
	 * This attribute maps to the column DESCRIZIONE in the SICEE_D_TIPO_CORSO table.
	 */
	protected String descrizione;

	/** 
	 * This attribute maps to the column DESCRIZIONE_ATTESTATO in the SICEE_D_TIPO_CORSO table.
	 */
	protected String descrizioneAttestato;

	/** 
	 * This attribute maps to the column FLG_ABILITATO in the SICEE_D_TIPO_CORSO table.
	 */
	protected String flgAbilitato;


	/**
	 * Method 'SiceeDDestUso2015'
	 * 
	 */
	public SiceeDTipoCorso()
	{
	}

	/**
	 * Method 'getIdTipoCorso'
	 * 
	 * @return Integer
	 */
	public Integer getIdTipoCorso()
	{
		return idTipoCorso;
	}

	/**
	 * Method 'setIdTipoCorso'
	 * 
	 * @param idTipoCorso
	 */
	public void setIdTipoCorso(Integer idTipoCorso)
	{
		this.idTipoCorso = idTipoCorso;
	}

	/**
	 * Method 'getDescrizione'
	 * 
	 * @return String
	 */
	public String getDescrizione()
	{
		return descrizione;
	}

	/**
	 * Method 'setDescrizione'
	 * 
	 * @param descrizione
	 */
	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}

	/**
	 * Method 'getDescrizioneAttestato'
	 * 
	 * @return String
	 */
	public String getDescrizioneAttestato()
	{
		return descrizioneAttestato;
	}

	/**
	 * Method 'setDescrizioneAttestato'
	 * 
	 * @param descrizioneAttestato
	 */
	public void setDescrizioneAttestato(String descrizioneAttestato)
	{
		this.descrizioneAttestato = descrizioneAttestato;
	}

	/**
	 * Method 'getFlgAbilitato'
	 * 
	 * @return String
	 */
	public String getFlgAbilitato()
	{
		return flgAbilitato;
	}

	/**
	 * Method 'setFlgAbilitato'
	 * 
	 * @param flgAbilitato
	 */
	public void setFlgAbilitato(String flgAbilitato)
	{
		this.flgAbilitato = flgAbilitato;
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
		
		if (!(_other instanceof SiceeDTipoCorso)) {
			return false;
		}
		
		final SiceeDTipoCorso _cast = (SiceeDTipoCorso) _other;
		if (idTipoCorso == null ? _cast.idTipoCorso != idTipoCorso : !idTipoCorso.equals( _cast.idTipoCorso )) {
			return false;
		}
		
		if (descrizione == null ? _cast.descrizione != descrizione : !descrizione.equals( _cast.descrizione )) {
			return false;
		}
		
		if (descrizioneAttestato == null ? _cast.descrizioneAttestato != descrizioneAttestato : !descrizioneAttestato.equals( _cast.descrizioneAttestato )) {
			return false;
		}
		
		if (flgAbilitato == null ? _cast.flgAbilitato != flgAbilitato : !flgAbilitato.equals( _cast.flgAbilitato )) {
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
		if (idTipoCorso != null) {
			_hashCode = 29 * _hashCode + idTipoCorso.hashCode();
		}
		
		if (descrizione != null) {
			_hashCode = 29 * _hashCode + descrizione.hashCode();
		}
		
		if (descrizioneAttestato != null) {
			_hashCode = 29 * _hashCode + descrizioneAttestato.hashCode();
		}
		
		if (flgAbilitato != null) {
			_hashCode = 29 * _hashCode + flgAbilitato.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDDestUso2015Pk
	 */
	public SiceeDTipoCorsoPk createPk()
	{
		return new SiceeDTipoCorsoPk(idTipoCorso);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeDTipoCorso: " );
		ret.append( "idTipoCorso=" + idTipoCorso );
		ret.append( ", sigla=" + descrizione );
		ret.append( ", descr=" + descrizioneAttestato );
		ret.append( ", flgResidenziale=" + flgAbilitato );
		return ret.toString();
	}

}
