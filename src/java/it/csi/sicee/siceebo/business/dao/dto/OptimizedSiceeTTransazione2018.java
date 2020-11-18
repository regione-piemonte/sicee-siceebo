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

public class OptimizedSiceeTTransazione2018 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TRANSAZIONE_2018 in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Integer idTransazione2018;

	/** 
	 * This attribute maps to the column FK_STATO_TRANS_2018 in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Integer fkStatoTrans2018;

	/** 
	 * This attribute maps to the column DESCR_STATO_TRANS in the SICEE_D_STATO_TRANS_2018 table.
	 */
	protected String descrStatoTrans2018;
	
	/** 
	 * This attribute maps to the column S1_ID_TRANSAZIONE_MDP in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s1IdTransazioneMdp;
	
	/** 
	 * This attribute maps to the column S1_DT_CREAZIONE_TRANSAZIONE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Date s1DtCreazioneTransazione;

	/** 
	 * This attribute maps to the column S1_VALORE_TRANSAZIONE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Double s1ValoreTransazione;

	/** 
	 * This attribute maps to the column S2_RAG_SOCIALE_PSP in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s2RagSocialePsp;

	/** 
	 * This attribute maps to the column S3_ID_IUV in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected String s3IdIuv;

	/** 
	 * This attribute maps to the column S3_DT_AVVIO_TRANSAZIONE in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Date s3DtAvvioTransazione;

	/** 
	 * This attribute maps to the column OP_GETSTATOTRANS_FK_STATO in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Integer opGetstatotransFkStato;

	/** 
	 * This attribute maps to the column DESCR_STATO_TRANS_MDP in the SICEE_D_STATO_TRANS_MDP_2018 table.
	 */
	protected String descrStatoTransMdp;

	/** 
	 * This attribute maps to the column OP_GETSTATOTRANS_DT in the SICEE_T_TRANSAZIONE_2018 table.
	 */
	protected Date opGetstatotransDt;

	/**
	 * Method 'SiceeTTransazione2018'
	 * 
	 */
	public OptimizedSiceeTTransazione2018()
	{
	}

	/**
	 * Method 'getIdTransazione2018'
	 * 
	 * @return Integer
	 */
	public Integer getIdTransazione2018()
	{
		return idTransazione2018;
	}

	/**
	 * Method 'setIdTransazione2018'
	 * 
	 * @param idTransazione2018
	 */
	public void setIdTransazione2018(Integer idTransazione2018)
	{
		this.idTransazione2018 = idTransazione2018;
	}

	/**
	 * Method 'getFkStatoTrans2018'
	 * 
	 * @return Integer
	 */
	public Integer getFkStatoTrans2018()
	{
		return fkStatoTrans2018;
	}

	/**
	 * Method 'setFkStatoTrans2018'
	 * 
	 * @param fkStatoTrans2018
	 */
	public void setFkStatoTrans2018(Integer fkStatoTrans2018)
	{
		this.fkStatoTrans2018 = fkStatoTrans2018;
	}

	/**
	 * Method 'getDescrStatoTrans2018'
	 * 
	 * @return String
	 */
	public String getDescrStatoTrans2018()
	{
		return descrStatoTrans2018;
	}

	/**
	 * Method 'setDescrStatoTrans2018'
	 * 
	 * @param descrStatoTrans2018
	 */
	public void setDescrStatoTrans2018(String descrStatoTrans2018)
	{
		this.descrStatoTrans2018 = descrStatoTrans2018;
	}
	
	/**
	 * Method 'getS1IdTransazioneMdp'
	 * 
	 * @return String
	 */
	public String getS1IdTransazioneMdp()
	{
		return s1IdTransazioneMdp;
	}

	/**
	 * Method 'setS1IdTransazioneMdp'
	 * 
	 * @param s1IdTransazioneMdp
	 */
	public void setS1IdTransazioneMdp(String s1IdTransazioneMdp)
	{
		this.s1IdTransazioneMdp = s1IdTransazioneMdp;
	}
	
	/**
	 * Method 'getS1DtCreazioneTransazione'
	 * 
	 * @return Date
	 */
	public Date getS1DtCreazioneTransazione()
	{
		return s1DtCreazioneTransazione;
	}

	/**
	 * Method 'setS1DtCreazioneTransazione'
	 * 
	 * @param s1DtCreazioneTransazione
	 */
	public void setS1DtCreazioneTransazione(Date s1DtCreazioneTransazione)
	{
		this.s1DtCreazioneTransazione = s1DtCreazioneTransazione;
	}

	/**
	 * Method 'getS1ValoreTransazione'
	 * 
	 * @return long
	 */
	public Double getS1ValoreTransazione()
	{
		return s1ValoreTransazione;
	}

	/**
	 * Method 'setS1ValoreTransazione'
	 * 
	 * @param s1ValoreTransazione
	 */
	public void setS1ValoreTransazione(Double s1ValoreTransazione)
	{
		this.s1ValoreTransazione = s1ValoreTransazione;
	}
	
	/**
	 * Method 'getS2RagSocialePsp'
	 * 
	 * @return String
	 */
	public String getS2RagSocialePsp()
	{
		return s2RagSocialePsp;
	}

	/**
	 * Method 'setS2RagSocialePsp'
	 * 
	 * @param s2RagSocialePsp
	 */
	public void setS2RagSocialePsp(String s2RagSocialePsp)
	{
		this.s2RagSocialePsp = s2RagSocialePsp;
	}

	/**
	 * Method 'getS3IdIuv'
	 * 
	 * @return String
	 */
	public String getS3IdIuv()
	{
		return s3IdIuv;
	}

	/**
	 * Method 'setS3IdIuv'
	 * 
	 * @param s3IdIuv
	 */
	public void setS3IdIuv(String s3IdIuv)
	{
		this.s3IdIuv = s3IdIuv;
	}

	/**
	 * Method 'getS3DtAvvioTransazione'
	 * 
	 * @return Date
	 */
	public Date getS3DtAvvioTransazione()
	{
		return s3DtAvvioTransazione;
	}

	/**
	 * Method 'setS3DtAvvioTransazione'
	 * 
	 * @param s3DtAvvioTransazione
	 */
	public void setS3DtAvvioTransazione(Date s3DtAvvioTransazione)
	{
		this.s3DtAvvioTransazione = s3DtAvvioTransazione;
	}

	/**
	 * Method 'getOpGetstatotransFkStato'
	 * 
	 * @return Integer
	 */
	public Integer getOpGetstatotransFkStato()
	{
		return opGetstatotransFkStato;
	}

	/**
	 * Method 'setOpGetstatotransFkStato'
	 * 
	 * @param opGetstatotransFkStato
	 */
	public void setOpGetstatotransFkStato(Integer opGetstatotransFkStato)
	{
		this.opGetstatotransFkStato = opGetstatotransFkStato;
	}

	/**
	 * Method 'getDescrStatoTransMdp'
	 * 
	 * @return String
	 */
	public String getDescrStatoTransMdp()
	{
		return descrStatoTransMdp;
	}

	/**
	 * Method 'setDescrStatoTransMdp'
	 * 
	 * @param descrStatoTransMdp
	 */
	public void setDescrStatoTransMdp(String descrStatoTransMdp)
	{
		this.descrStatoTransMdp = descrStatoTransMdp;
	}
	
	/**
	 * Method 'getOpGetstatotransDt'
	 * 
	 * @return Date
	 */
	public Date getOpGetstatotransDt()
	{
		return opGetstatotransDt;
	}

	/**
	 * Method 'setOpGetstatotransDt'
	 * 
	 * @param opGetstatotransDt
	 */
	public void setOpGetstatotransDt(Date opGetstatotransDt)
	{
		this.opGetstatotransDt = opGetstatotransDt;
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
		
		if (!(_other instanceof OptimizedSiceeTTransazione2018)) {
			return false;
		}
		
		final OptimizedSiceeTTransazione2018 _cast = (OptimizedSiceeTTransazione2018) _other;
		if (idTransazione2018 != _cast.idTransazione2018) {
			return false;
		}
		
		if (fkStatoTrans2018 == null ? _cast.fkStatoTrans2018 != fkStatoTrans2018 : !fkStatoTrans2018.equals( _cast.fkStatoTrans2018 )) {
			return false;
		}

		if (descrStatoTrans2018 == null ? _cast.descrStatoTrans2018 != descrStatoTrans2018 : !descrStatoTrans2018.equals( _cast.descrStatoTrans2018 )) {
			return false;
		}

		if (s1ValoreTransazione == null ? _cast.s1ValoreTransazione != s1ValoreTransazione : !s1ValoreTransazione.equals( _cast.s1ValoreTransazione )) {
			return false;
		}
		
		if (s1DtCreazioneTransazione == null ? _cast.s1DtCreazioneTransazione != s1DtCreazioneTransazione : !s1DtCreazioneTransazione.equals( _cast.s1DtCreazioneTransazione )) {
			return false;
		}
		
		if (s1ValoreTransazione != _cast.s1ValoreTransazione) {
			return false;
		}

		if (s2RagSocialePsp == null ? _cast.s2RagSocialePsp != s2RagSocialePsp : !s2RagSocialePsp.equals( _cast.s2RagSocialePsp )) {
			return false;
		}
		
		if (s3IdIuv != _cast.s3IdIuv) {
			return false;
		}
		
		if (s3DtAvvioTransazione == null ? _cast.s3DtAvvioTransazione != s3DtAvvioTransazione : !s3DtAvvioTransazione.equals( _cast.s3DtAvvioTransazione )) {
			return false;
		}
		
		if (opGetstatotransFkStato == null ? _cast.opGetstatotransFkStato != opGetstatotransFkStato : !opGetstatotransFkStato.equals( _cast.opGetstatotransFkStato )) {
			return false;
		}

		if (descrStatoTransMdp == null ? _cast.descrStatoTransMdp != descrStatoTransMdp : !descrStatoTransMdp.equals( _cast.descrStatoTransMdp )) {
			return false;
		}

		if (opGetstatotransDt == null ? _cast.opGetstatotransDt != opGetstatotransDt : !opGetstatotransDt.equals( _cast.opGetstatotransDt )) {
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
		_hashCode = 29 * _hashCode + (int) (idTransazione2018 ^ (idTransazione2018 >>> 32));
		if (fkStatoTrans2018 != null) {
			_hashCode = 29 * _hashCode + fkStatoTrans2018.hashCode();
		}

		if (descrStatoTrans2018 != null) {
			_hashCode = 29 * _hashCode + descrStatoTrans2018.hashCode();
		}

		if (s1DtCreazioneTransazione != null) {
			_hashCode = 29 * _hashCode + s1DtCreazioneTransazione.hashCode();
		}
		
		if (s1ValoreTransazione != null) {
			_hashCode = 29 * _hashCode + s1ValoreTransazione.hashCode();
		}
		
		if (s2RagSocialePsp != null) {
			_hashCode = 29 * _hashCode + s2RagSocialePsp.hashCode();
		}
		
		if (s3IdIuv != null) {
			_hashCode = 29 * _hashCode + s3IdIuv.hashCode();
		}
		
		if (s3DtAvvioTransazione != null) {
			_hashCode = 29 * _hashCode + s3DtAvvioTransazione.hashCode();
		}
		
		if (opGetstatotransFkStato != null) {
			_hashCode = 29 * _hashCode + opGetstatotransFkStato.hashCode();
		}

		if (descrStatoTransMdp != null) {
			_hashCode = 29 * _hashCode + descrStatoTransMdp.hashCode();
		}
		
		if (opGetstatotransDt != null) {
			_hashCode = 29 * _hashCode + opGetstatotransDt.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTTransazione2018Pk
	 */
	public SiceeTTransazione2018Pk createPk()
	{
		return new SiceeTTransazione2018Pk(idTransazione2018);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceeweb.business.dao.dto.SiceeTTransazione2018: " );
		ret.append( "idTransazione2018=" + idTransazione2018 );
		ret.append( ", fkStatoTrans2018=" + fkStatoTrans2018 );
		ret.append( ", descrStatoTrans2018=" + descrStatoTrans2018 );
		ret.append( ", s1ValoreTransazione=" + s1ValoreTransazione );
		ret.append( ", s1DtCreazioneTransazione=" + s1DtCreazioneTransazione );
		ret.append( ", s1ValoreTransazione=" + s1ValoreTransazione );
		ret.append( ", s2RagSocialePsp=" + s2RagSocialePsp );
		ret.append( ", s3IdIuv=" + s3IdIuv );
		ret.append( ", s3DtAvvioTransazione=" + s3DtAvvioTransazione );
		ret.append( ", opGetstatotransFkStato=" + opGetstatotransFkStato );
		ret.append( ", descrStatoTransMdp=" + descrStatoTransMdp );
		ret.append( ", opGetstatotransDt=" + opGetstatotransDt );
		return ret.toString();
	}

}
