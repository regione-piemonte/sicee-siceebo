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

public class SiceeLAnnullamento implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CERTIFICATORE in the SICEE_L_ANNULLAMENTO table.
	 */
	protected String idCertificatore;

	/** 
	 * This attribute maps to the column PROGR_CERTIFICATO in the SICEE_L_ANNULLAMENTO table.
	 */
	protected String progrCertificato;

	/** 
	 * This attribute maps to the column ANNO in the SICEE_L_ANNULLAMENTO table.
	 */
	protected String anno;

	/** 
	 * This attribute maps to the column ID_ANNULLAMENTO in the SICEE_L_ANNULLAMENTO table.
	 */
	protected long idAnnullamento;

	/** 
	 * This attribute maps to the column DT_ANNULLAMENTO in the SICEE_L_ANNULLAMENTO table.
	 */
	protected Date dtAnnullamento;

	/** 
	 * This attribute maps to the column MOTIVO_ANNULLAMENTO in the SICEE_L_ANNULLAMENTO table.
	 */
	protected String motivoAnnullamento;

		
	/**
	 * Method 'SiceeTCertificato'
	 * 
	 */
	public SiceeLAnnullamento()
	{
	}

	/**
	 * Method 'getIdCertificatore'
	 * 
	 * @return String
	 */
	public String getIdCertificatore()
	{
		return idCertificatore;
	}

	/**
	 * Method 'setIdCertificatore'
	 * 
	 * @param idCertificatore
	 */
	public void setIdCertificatore(String idCertificatore)
	{
		this.idCertificatore = idCertificatore;
	}

	/**
	 * Method 'getProgrCertificato'
	 * 
	 * @return String
	 */
	public String getProgrCertificato()
	{
		return progrCertificato;
	}

	/**
	 * Method 'setProgrCertificato'
	 * 
	 * @param progrCertificato
	 */
	public void setProgrCertificato(String progrCertificato)
	{
		this.progrCertificato = progrCertificato;
	}

	/**
	 * Method 'getAnno'
	 * 
	 * @return String
	 */
	public String getAnno()
	{
		return anno;
	}

	/**
	 * Method 'setAnno'
	 * 
	 * @param anno
	 */
	public void setAnno(String anno)
	{
		this.anno = anno;
	}

	/**
	 * Method 'getIdAnnullamento'
	 * 
	 * @return long
	 */
	public long getIdAnnullamento()
	{
		return idAnnullamento;
	}

	/**
	 * Method 'setIdAnnullamento'
	 * 
	 * @param idAnnullamento
	 */
	public void setIdAnnullamento(long idAnnullamento)
	{
		this.idAnnullamento = idAnnullamento;
	}

	/**
	 * Method 'getDtAnnullamento'
	 * 
	 * @return Date
	 */
	public Date getDtAnnullamento()
	{
		return dtAnnullamento;
	}

	/**
	 * Method 'setDtAnnullamento'
	 * 
	 * @param dtAnnullamento
	 */
	public void setDtAnnullamento(Date dtAnnullamento)
	{
		this.dtAnnullamento = dtAnnullamento;
	}

	/**
	 * Method 'getMotivoAnnullamento'
	 * 
	 * @return String
	 */
	public String getMotivoAnnullamento()
	{
		return motivoAnnullamento;
	}

	/**
	 * Method 'setMotivoAnnullamento'
	 * 
	 * @param motivoAnnullamento
	 */
	public void setMotivoAnnullamento(String motivoAnnullamento)
	{
		this.motivoAnnullamento = motivoAnnullamento;
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
		
		if (!(_other instanceof SiceeLAnnullamento)) {
			return false;
		}
		
		final SiceeLAnnullamento _cast = (SiceeLAnnullamento) _other;
		if (idCertificatore == null ? _cast.idCertificatore != idCertificatore : !idCertificatore.equals( _cast.idCertificatore )) {
			return false;
		}
		
		if (progrCertificato == null ? _cast.progrCertificato != progrCertificato : !progrCertificato.equals( _cast.progrCertificato )) {
			return false;
		}
		
		if (anno == null ? _cast.anno != anno : !anno.equals( _cast.anno )) {
			return false;
		}
		
		if (idAnnullamento != _cast.idAnnullamento) {
			return false;
		}

		if (dtAnnullamento == null ? _cast.dtAnnullamento != dtAnnullamento : !dtAnnullamento.equals( _cast.dtAnnullamento )) {
			return false;
		}
		
		if (motivoAnnullamento == null ? _cast.motivoAnnullamento != motivoAnnullamento : !motivoAnnullamento.equals( _cast.motivoAnnullamento )) {
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
		if (idCertificatore != null) {
			_hashCode = 29 * _hashCode + idCertificatore.hashCode();
		}
		
		if (progrCertificato != null) {
			_hashCode = 29 * _hashCode + progrCertificato.hashCode();
		}
		
		if (anno != null) {
			_hashCode = 29 * _hashCode + anno.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (idAnnullamento ^ (idAnnullamento >>> 32));

		if (dtAnnullamento != null) {
			_hashCode = 29 * _hashCode + dtAnnullamento.hashCode();
		}
		
		if (motivoAnnullamento != null) {
			_hashCode = 29 * _hashCode + motivoAnnullamento.hashCode();
		}

		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeLAnnullamentoPk
	 */
	public SiceeLAnnullamentoPk createPk()
	{
		return new SiceeLAnnullamentoPk(idCertificatore, progrCertificato, anno);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeLAnnullamento: " );
		ret.append( "idCertificatore=" + idCertificatore );
		ret.append( ", progrCertificato=" + progrCertificato );
		ret.append( ", anno=" + anno );
		ret.append( ", idAnnullamento=" + idAnnullamento );
		ret.append( ", dtAnnullamento=" + dtAnnullamento );
		ret.append( ", motivoAnnullamento=" + motivoAnnullamento );
		return ret.toString();
	}

}
