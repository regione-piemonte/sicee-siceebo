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

public class SiceeTCorso2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_CORSO in the SICEE_T_CORSO_2015 table.
	 */
	protected Long idCorso;

	/** 
	 * This attribute maps to the column ID_ENTE in the SICEE_T_CORSO_2015 table.
	 */
	protected Long fkEnte;

	/** 
	 * This attribute maps to the column TIPO_CORSO1 in the SICEE_T_CORSO_2015 table.
	 */
	protected String tipoCorso1;

	/** 
	 * This attribute maps to the column TIPO_CORSO2 in the SICEE_T_CORSO_2015 table.
	 */
	protected String tipoCorso2;

	/** 
	 * This attribute maps to the column NUM_CORSO in the SICEE_T_CORSO_2015 table.
	 */
	protected String numCorso;

	/** 
	 * This attribute maps to the column ANNO_FORMATIVO in the SICEE_T_CORSO_2015 table.
	 */
	protected String annoFormativo;

	/** 
	 * This attribute maps to the column TITOLO in the SICEE_T_CORSO_2015 table.
	 */
	protected String titolo;

	/** 
	 * This attribute maps to the column TOTALE_ORE in the SICEE_T_CORSO_2015 table.
	 */
	protected Integer totaleOre;

	/** 
	 * This attribute represents whether the primitive attribute totaleOre is null.
	 */
	protected boolean totaleOreNull = true;

	/** 
	 * This attribute maps to the column TOTALE_MODULI in the SICEE_T_CORSO_2015 table.
	 */
	protected Integer totaleModuli;

	/** 
	 * This attribute represents whether the primitive attribute totaleModuli is null.
	 */
	protected boolean totaleModuliNull = true;

	/** 
	 * This attribute maps to the column N_PARTECIPANTI in the SICEE_T_CORSO_2015 table.
	 */
	protected Integer nPartecipanti;

	/** 
	 * This attribute represents whether the primitive attribute nPartecipanti is null.
	 */
	protected boolean nPartecipantiNull = true;

	/** 
	 * This attribute maps to the column DATA_ESAME in the SICEE_T_CORSO_2015 table.
	 */
	protected Date dataEsame;

	/** 
	 * This attribute maps to the column DATA_DAL in the SICEE_T_CORSO_2015 table.
	 */
	protected Date dataDal;

	/** 
	 * This attribute maps to the column DATA_AL in the SICEE_T_CORSO_2015 table.
	 */
	protected Date dataAl;

	/** 
	 * This attribute maps to the column LUOGO_CORSO in the SICEE_T_CORSO_2015 table.
	 */
	protected String luogoCorso;

	/** 
	 * This attribute maps to the column PROT_APPROV in the SICEE_T_CORSO_2015 table.
	 */
	protected String protApprov;

	/** 
	 * This attribute maps to the column DATA_APPROV in the SICEE_T_CORSO_2015 table.
	 */
	protected Date dataApprov;

	/** 
	 * This attribute maps to the column NOTE in the SICEE_T_CORSO_2015 table.
	 */
	protected String note;

	/** 
	 * This attribute maps to the column FK_TIPO_CORSO in the SICEE_T_CORSO_2015 table.
	 */
	protected Integer fkTipoCorso;

	/**
	 * Method 'SiceeTCorsoenteform2015'
	 * 
	 */
	public SiceeTCorso2015()
	{
	}

	/**
	 * Method 'getIdCorso'
	 * 
	 * @return Long
	 */
	public Long getIdCorso()
	{
		return idCorso;
	}

	/**
	 * Method 'setIdCorso'
	 * 
	 * @param idCorso
	 */
	public void setIdCorso(Long idCorso)
	{
		this.idCorso = idCorso;
	}

	/**
	 * Method 'getFkEnte'
	 * 
	 * @return Long
	 */
	public Long getFkEnte()
	{
		return fkEnte;
	}

	/**
	 * Method 'setFkEnte'
	 * 
	 * @param idEnte
	 */
	public void setFkEnte(Long fkEnte)
	{
		this.fkEnte = fkEnte;
	}

	/**
	 * Method 'getTipoCorso1'
	 * 
	 * @return String
	 */
	public String getTipoCorso1()
	{
		return tipoCorso1;
	}

	/**
	 * Method 'setTipoCorso1'
	 * 
	 * @param tipoCorso1
	 */
	public void setTipoCorso1(String tipoCorso1)
	{
		this.tipoCorso1 = tipoCorso1;
	}

	/**
	 * Method 'getTipoCorso2'
	 * 
	 * @return String
	 */
	public String getTipoCorso2()
	{
		return tipoCorso2;
	}

	/**
	 * Method 'setTipoCorso2'
	 * 
	 * @param tipoCorso2
	 */
	public void setTipoCorso2(String tipoCorso2)
	{
		this.tipoCorso2 = tipoCorso2;
	}

	/**
	 * Method 'getNumCorso'
	 * 
	 * @return String
	 */
	public String getNumCorso()
	{
		return numCorso;
	}

	/**
	 * Method 'setNumCorso'
	 * 
	 * @param numCorso
	 */
	public void setNumCorso(String numCorso)
	{
		this.numCorso = numCorso;
	}

	/**
	 * Method 'getAnnoFormativo'
	 * 
	 * @return String
	 */
	public String getAnnoFormativo()
	{
		return annoFormativo;
	}

	/**
	 * Method 'setAnnoFormativo'
	 * 
	 * @param annoFormativo
	 */
	public void setAnnoFormativo(String annoFormativo)
	{
		this.annoFormativo = annoFormativo;
	}

	/**
	 * Method 'getTitolo'
	 * 
	 * @return String
	 */
	public String getTitolo()
	{
		return titolo;
	}

	/**
	 * Method 'setTitolo'
	 * 
	 * @param titolo
	 */
	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}

	/**
	 * Method 'getTotaleOre'
	 * 
	 * @return Integer
	 */
	public Integer getTotaleOre()
	{
		return totaleOre;
	}

	/**
	 * Method 'setTotaleOre'
	 * 
	 * @param totaleOre
	 */
	public void setTotaleOre(Integer totaleOre)
	{
		this.totaleOre = totaleOre;
		this.totaleOreNull = false;
	}

	/**
	 * Method 'setTotaleOreNull'
	 * 
	 * @param value
	 */
	public void setTotaleOreNull(boolean value)
	{
		this.totaleOreNull = value;
	}

	/**
	 * Method 'isTotaleOreNull'
	 * 
	 * @return boolean
	 */
	public boolean isTotaleOreNull()
	{
		return totaleOreNull;
	}

	/**
	 * Method 'getTotaleModuli'
	 * 
	 * @return Integer
	 */
	public Integer getTotaleModuli()
	{
		return totaleModuli;
	}

	/**
	 * Method 'setTotaleModuli'
	 * 
	 * @param totaleModuli
	 */
	public void setTotaleModuli(Integer totaleModuli)
	{
		this.totaleModuli = totaleModuli;
		this.totaleModuliNull = false;
	}

	/**
	 * Method 'setTotaleModuliNull'
	 * 
	 * @param value
	 */
	public void setTotaleModuliNull(boolean value)
	{
		this.totaleModuliNull = value;
	}

	/**
	 * Method 'isTotaleModuliNull'
	 * 
	 * @return boolean
	 */
	public boolean isTotaleModuliNull()
	{
		return totaleModuliNull;
	}

	/**
	 * Method 'getNPartecipanti'
	 * 
	 * @return Integer
	 */
	public Integer getNPartecipanti()
	{
		return nPartecipanti;
	}

	/**
	 * Method 'setNPartecipanti'
	 * 
	 * @param nPartecipanti
	 */
	public void setNPartecipanti(Integer nPartecipanti)
	{
		this.nPartecipanti = nPartecipanti;
		this.nPartecipantiNull = false;
	}

	/**
	 * Method 'setNPartecipantiNull'
	 * 
	 * @param value
	 */
	public void setNPartecipantiNull(boolean value)
	{
		this.nPartecipantiNull = value;
	}

	/**
	 * Method 'isNPartecipantiNull'
	 * 
	 * @return boolean
	 */
	public boolean isNPartecipantiNull()
	{
		return nPartecipantiNull;
	}

	/**
	 * Method 'getDataEsame'
	 * 
	 * @return Date
	 */
	public Date getDataEsame()
	{
		return dataEsame;
	}

	/**
	 * Method 'setDataEsame'
	 * 
	 * @param dataEsame
	 */
	public void setDataEsame(Date dataEsame)
	{
		this.dataEsame = dataEsame;
	}

	/**
	 * Method 'getDataDal'
	 * 
	 * @return Date
	 */
	public Date getDataDal()
	{
		return dataDal;
	}

	/**
	 * Method 'setDataDal'
	 * 
	 * @param dataDal
	 */
	public void setDataDal(Date dataDal)
	{
		this.dataDal = dataDal;
	}

	/**
	 * Method 'getDataAl'
	 * 
	 * @return Date
	 */
	public Date getDataAl()
	{
		return dataAl;
	}
	/**
	 * Method 'setDataAl'
	 * 
	 * @param dataAl
	 */

	public void setDataAl(Date dataAl)
	{
		this.dataAl = dataAl;
	}

	/**
	 * Method 'getLuogoCorso'
	 * 
	 * @return String
	 */
	public String getLuogoCorso()
	{
		return luogoCorso;
	}
	/**
	 * Method 'setLuogoCorso'
	 * 
	 * @param luogoCorso
	 */
	public void setLuogoCorso(String luogoCorso)
	{
		this.luogoCorso = luogoCorso;
	}

	/**
	 * Method 'getProtApprov'
	 * 
	 * @return String
	 */
	public String getProtApprov()
	{
		return protApprov;
	}
	/**
	 * Method 'setProtApprov'
	 * 
	 * @param dataAl
	 */
	public void setProtApprov(String protApprov)
	{
		this.protApprov = protApprov;
	}

	/**
	 * Method 'getDataApprov'
	 * 
	 * @return Date
	 */
	public Date getDataApprov()
	{
		return dataApprov;
	}
	/**
	 * Method 'setDataApprov'
	 * 
	 * @param dataApprov
	 */
	public void setDataApprov(Date dataApprov)
	{
		this.dataApprov = dataApprov;
	}

	/**
	 * Method 'getNote'
	 * 
	 * @return String
	 */
	public String getNote()
	{
		return note;
	}
	/**
	 * Method 'setNote'
	 * 
	 * @param note
	 */
	public void setNote(String note)
	{
		this.note = note;
	}
	
	/**
	 * Method 'getFkTipoCorso'
	 * 
	 * @return Integer
	 */
	public Integer getFkTipoCorso()
	{
		return fkTipoCorso;
	}

	/**
	 * Method 'setFkTipoCorso'
	 * 
	 * @param fkTipoCorso
	 */
	public void setFkTipoCorso(Integer fkTipoCorso)
	{
		this.fkTipoCorso = fkTipoCorso;
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
		
		if (!(_other instanceof SiceeTCorso2015)) {
			return false;
		}
		
		final SiceeTCorso2015 _cast = (SiceeTCorso2015) _other;
		if (idCorso != _cast.idCorso) {
			return false;
		}
		
		if (fkEnte != _cast.fkEnte) {
			return false;
		}
		
		if (titolo == null ? _cast.titolo != titolo : !titolo.equals( _cast.titolo )) {
			return false;
		}
		
		if (totaleOre != _cast.totaleOre) {
			return false;
		}
		
		if (totaleOreNull != _cast.totaleOreNull) {
			return false;
		}
		
		if (nPartecipanti != _cast.nPartecipanti) {
			return false;
		}
		
		if (nPartecipantiNull != _cast.nPartecipantiNull) {
			return false;
		}
		
		if (dataEsame == null ? _cast.dataEsame != dataEsame : !dataEsame.equals( _cast.dataEsame )) {
			return false;
		}
		
		if (dataDal == null ? _cast.dataDal != dataDal : !dataDal.equals( _cast.dataDal )) {
			return false;
		}
		
		if (dataAl == null ? _cast.dataAl != dataAl : !dataAl.equals( _cast.dataAl )) {
			return false;
		}
		
		if (fkTipoCorso == null ? _cast.fkTipoCorso != fkTipoCorso : !fkTipoCorso.equals( _cast.fkTipoCorso )) {
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
		_hashCode = 29 * _hashCode + (int) (idCorso ^ (idCorso >>> 32));
		_hashCode = 29 * _hashCode + (int) (fkEnte ^ (fkEnte >>> 32));
		if (titolo != null) {
			_hashCode = 29 * _hashCode + titolo.hashCode();
		}
		
		_hashCode = 29 * _hashCode + (int) (totaleOre ^ (totaleOre >>> 32));
		_hashCode = 29 * _hashCode + (totaleOreNull ? 1 : 0);
		_hashCode = 29 * _hashCode + (int) (nPartecipanti ^ (nPartecipanti >>> 32));
		_hashCode = 29 * _hashCode + (nPartecipantiNull ? 1 : 0);
		if (dataEsame != null) {
			_hashCode = 29 * _hashCode + dataEsame.hashCode();
		}
		
		if (dataDal != null) {
			_hashCode = 29 * _hashCode + dataDal.hashCode();
		}
		
		if (dataAl != null) {
			_hashCode = 29 * _hashCode + dataAl.hashCode();
		}
		
		if (fkTipoCorso != null) {
			_hashCode = 29 * _hashCode + fkTipoCorso.hashCode();
		}
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTCorso2015Pk
	 */
	public SiceeTCorso2015Pk createPk()
	{
		return new SiceeTCorso2015Pk(idCorso);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTCorsoenteform2015: " );
		ret.append( "idCorso=" + idCorso );
		ret.append( ", fkEnte=" + fkEnte );
		ret.append( ", titolo=" + titolo );
		ret.append( ", totaleOre=" + totaleOre );
		ret.append( ", nPartecipanti=" + nPartecipanti );
		ret.append( ", dataEsame=" + dataEsame );
		ret.append( ", dataDal=" + dataDal );
		ret.append( ", dataAl=" + dataAl );
		ret.append( ", fkTipoCorso=" + fkTipoCorso );
		return ret.toString();
	}

}
