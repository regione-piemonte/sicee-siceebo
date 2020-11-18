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

public class SiceeTEnteform2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_ENTE in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected long idEnte;

	/** 
	 * This attribute maps to the column FK_ENTE_SL in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected long fkEnteSl;

	/** 
	 * This attribute maps to the column COD_FORM_REG in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String codFormReg;

	/** 
	 * This attribute maps to the column ID_REGIONE in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String idRegione;

	/** 
	 * This attribute maps to the column DESC_REGIONE in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String descRegione;

	/** 
	 * This attribute maps to the column ID_PROV in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String idProv;

	/** 
	 * This attribute maps to the column DESC_PROV in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String descProv;

	/** 
	 * This attribute maps to the column ID_COMUNE in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String idComune;

	/** 
	 * This attribute maps to the column DESC_COMUNE in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String descComune;

	/** 
	 * This attribute maps to the column ID_INDIRIZZO in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String idIndirizzo;

	/** 
	 * This attribute maps to the column DESC_INDIRIZZO in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String descIndirizzo;

	/** 
	 * This attribute maps to the column NUM_CIVICO in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String numCivico;

	/** 
	 * This attribute maps to the column CAP in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String cap;

	/** 
	 * This attribute maps to the column REFERENTE in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String referente;

	/** 
	 * This attribute maps to the column TELEFONO in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String telefono;

	/** 
	 * This attribute maps to the column CELL in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String cell;

	/** 
	 * This attribute maps to the column EMAIL in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String email;

	/** 
	 * This attribute maps to the column EMAIL_PEC in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String emailPec;

	/** 
	 * This attribute maps to the column FAX in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String fax;

	/** 
	 * This attribute maps to the column SITO_WEB in the SICEE_T_ENTEFORM__2015 table.
	 */
	protected String sitoWeb;

	/**
	 * Method 'SiceeTEnteformativo2015'
	 * 
	 */
	public SiceeTEnteform2015()
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
	 * Method 'getFkEnteSl'
	 * 
	 * @return long
	 */
	public long getFkEnteSl()
	{
		return fkEnteSl;
	}

	/**
	 * Method 'setFkEnteSl'
	 * 
	 * @param fkEnteSl
	 */
	public void setFkEnteSl(long fkEnteSl)
	{
		this.fkEnteSl = fkEnteSl;
	}

	/**
	 * Method 'getCodFormReg'
	 * 
	 * @return String
	 */
	public String getCodFormReg()
	{
		return codFormReg;
	}

	/**
	 * Method 'setCodFormReg'
	 * 
	 * @param codFormReg
	 */
	public void setCodFormReg(String codFormReg)
	{
		this.codFormReg = codFormReg;
	}

	/**
	 * Method 'getIdRegione'
	 * 
	 * @return String
	 */
	public String getIdRegione()
	{
		return idRegione;
	}

	/**
	 * Method 'setIdRegione'
	 * 
	 * @param idRegione
	 */
	public void setIdRegione(String idRegione)
	{
		this.idRegione = idRegione;
	}

	/**
	 * Method 'getDescRegione'
	 * 
	 * @return String
	 */
	public String getDescRegione()
	{
		return descRegione;
	}

	/**
	 * Method 'setDescRegione'
	 * 
	 * @param descRegione
	 */
	public void setDescRegione(String descRegione)
	{
		this.descRegione = descRegione;
	}

	/**
	 * Method 'getIdProv'
	 * 
	 * @return String
	 */
	public String getIdProv()
	{
		return idProv;
	}

	/**
	 * Method 'setIdProv'
	 * 
	 * @param idProv
	 */
	public void setIdProv(String idProv)
	{
		this.idProv = idProv;
	}

	/**
	 * Method 'getDescProv'
	 * 
	 * @return String
	 */
	public String getDescProv()
	{
		return descProv;
	}

	/**
	 * Method 'setDescProv'
	 * 
	 * @param descProv
	 */
	public void setDescProv(String descProv)
	{
		this.descProv = descProv;
	}

	/**
	 * Method 'getIdComune'
	 * 
	 * @return String
	 */
	public String getIdComune()
	{
		return idComune;
	}

	/**
	 * Method 'setIdComune'
	 * 
	 * @param idComune
	 */
	public void setIdComune(String idComune)
	{
		this.idComune = idComune;
	}

	/**
	 * Method 'getDescComune'
	 * 
	 * @return String
	 */
	public String getDescComune()
	{
		return descComune;
	}

	/**
	 * Method 'setDescComune'
	 * 
	 * @param descComune
	 */
	public void setDescComune(String descComune)
	{
		this.descComune = descComune;
	}

	/**
	 * Method 'getIdIndirizzo'
	 * 
	 * @return String
	 */
	public String getIdIndirizzo()
	{
		return idIndirizzo;
	}

	/**
	 * Method 'setIdIndirizzo'
	 * 
	 * @param idIndirizzo
	 */
	public void setIdIndirizzo(String idIndirizzo)
	{
		this.idIndirizzo = idIndirizzo;
	}

	/**
	 * Method 'getDescIndirizzo'
	 * 
	 * @return String
	 */
	public String getDescIndirizzo()
	{
		return descIndirizzo;
	}

	/**
	 * Method 'setDescIndirizzo'
	 * 
	 * @param descIndirizzo
	 */
	public void setDescIndirizzo(String descIndirizzo)
	{
		this.descIndirizzo = descIndirizzo;
	}

	/**
	 * Method 'getNumCivico'
	 * 
	 * @return String
	 */
	public String getNumCivico()
	{
		return numCivico;
	}

	/**
	 * Method 'setNumCivico'
	 * 
	 * @param numCivico
	 */
	public void setNumCivico(String numCivico)
	{
		this.numCivico = numCivico;
	}

	/**
	 * Method 'getCap'
	 * 
	 * @return String
	 */
	public String getCap()
	{
		return cap;
	}

	/**
	 * Method 'setCap'
	 * 
	 * @param cap
	 */
	public void setCap(String cap)
	{
		this.cap = cap;
	}

	/**
	 * Method 'getReferente'
	 * 
	 * @return String
	 */
	public String getReferente()
	{
		return referente;
	}

	/**
	 * Method 'setReferente'
	 * 
	 * @param telefono
	 */
	public void setReferente(String referente)
	{
		this.referente = referente;
	}

	/**
	 * Method 'getTelefono'
	 * 
	 * @return String
	 */
	public String getTelefono()
	{
		return telefono;
	}

	/**
	 * Method 'setTelefono'
	 * 
	 * @param telefono
	 */
	public void setTelefono(String telefono)
	{
		this.telefono = telefono;
	}

	/**
	 * Method 'getCell'
	 * 
	 * @return String
	 */
	public String getCell()
	{
		return cell;
	}

	/**
	 * Method 'setCell'
	 * 
	 * @param cell
	 */
	public void setCell(String cell)
	{
		this.cell = cell;
	}

	/**
	 * Method 'getEmail'
	 * 
	 * @return String
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Method 'setEmail'
	 * 
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Method 'getEmailPec'
	 * 
	 * @return String
	 */
	public String getEmailPec()
	{
		return emailPec;
	}

	/**
	 * Method 'setEmailPec'
	 * 
	 * @param emailPec
	 */
	public void setEmailPec(String emailPec)
	{
		this.emailPec = emailPec;
	}

	/**
	 * Method 'getFax'
	 * 
	 * @return String
	 */
	public String getFax()
	{
		return fax;
	}

	/**
	 * Method 'setFax'
	 * 
	 * @param fax
	 */
	public void setFax(String fax)
	{
		this.fax = fax;
	}

	/**
	 * Method 'getSitoWeb'
	 * 
	 * @return String
	 */
	public String getSitoWeb()
	{
		return sitoWeb;
	}

	/**
	 * Method 'setSitoWeb'
	 * 
	 * @param sitoWeb
	 */
	public void setSitoWeb(String sitoWeb)
	{
		this.sitoWeb = sitoWeb;
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
		
		if (!(_other instanceof SiceeTEnteform2015)) {
			return false;
		}
		
		final SiceeTEnteform2015 _cast = (SiceeTEnteform2015) _other;
		if (idEnte != _cast.idEnte) {
			return false;
		}
		
		if (idRegione == null ? _cast.idRegione != idRegione : !idRegione.equals( _cast.idRegione )) {
			return false;
		}
		
		if (descRegione == null ? _cast.descRegione != descRegione : !descRegione.equals( _cast.descRegione )) {
			return false;
		}
		
		if (idProv == null ? _cast.idProv != idProv : !idProv.equals( _cast.idProv )) {
			return false;
		}
		
		if (descProv == null ? _cast.descProv != descProv : !descProv.equals( _cast.descProv )) {
			return false;
		}
		
		if (idComune == null ? _cast.idComune != idComune : !idComune.equals( _cast.idComune )) {
			return false;
		}
		
		if (descComune == null ? _cast.descComune != descComune : !descComune.equals( _cast.descComune )) {
			return false;
		}
		
		if (idIndirizzo == null ? _cast.idIndirizzo != idIndirizzo : !idIndirizzo.equals( _cast.idIndirizzo )) {
			return false;
		}
		
		if (descIndirizzo == null ? _cast.descIndirizzo != descIndirizzo : !descIndirizzo.equals( _cast.descIndirizzo )) {
			return false;
		}
		
		if (numCivico == null ? _cast.numCivico != numCivico : !numCivico.equals( _cast.numCivico )) {
			return false;
		}
		
		if (cap == null ? _cast.cap != cap : !cap.equals( _cast.cap )) {
			return false;
		}
		
		if (telefono == null ? _cast.telefono != telefono : !telefono.equals( _cast.telefono )) {
			return false;
		}
		
		if (cell == null ? _cast.cell != cell : !cell.equals( _cast.cell )) {
			return false;
		}
		
		if (email == null ? _cast.email != email : !email.equals( _cast.email )) {
			return false;
		}
		
		if (emailPec == null ? _cast.emailPec != emailPec : !emailPec.equals( _cast.emailPec )) {
			return false;
		}
		
		if (fax == null ? _cast.fax != fax : !fax.equals( _cast.fax )) {
			return false;
		}
		
		if (sitoWeb == null ? _cast.sitoWeb != sitoWeb : !sitoWeb.equals( _cast.sitoWeb )) {
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
		if (idRegione != null) {
			_hashCode = 29 * _hashCode + idRegione.hashCode();
		}
		
		if (descRegione != null) {
			_hashCode = 29 * _hashCode + descRegione.hashCode();
		}
		
		if (idProv != null) {
			_hashCode = 29 * _hashCode + idProv.hashCode();
		}
		
		if (descProv != null) {
			_hashCode = 29 * _hashCode + descProv.hashCode();
		}
		
		if (idComune != null) {
			_hashCode = 29 * _hashCode + idComune.hashCode();
		}
		
		if (descComune != null) {
			_hashCode = 29 * _hashCode + descComune.hashCode();
		}
		
		if (idIndirizzo != null) {
			_hashCode = 29 * _hashCode + idIndirizzo.hashCode();
		}
		
		if (descIndirizzo != null) {
			_hashCode = 29 * _hashCode + descIndirizzo.hashCode();
		}
		
		if (numCivico != null) {
			_hashCode = 29 * _hashCode + numCivico.hashCode();
		}
		
		if (cap != null) {
			_hashCode = 29 * _hashCode + cap.hashCode();
		}
		
		if (telefono != null) {
			_hashCode = 29 * _hashCode + telefono.hashCode();
		}
		
		if (cell != null) {
			_hashCode = 29 * _hashCode + cell.hashCode();
		}
		
		if (email != null) {
			_hashCode = 29 * _hashCode + email.hashCode();
		}
		
		if (emailPec != null) {
			_hashCode = 29 * _hashCode + emailPec.hashCode();
		}
		
		if (fax != null) {
			_hashCode = 29 * _hashCode + fax.hashCode();
		}
		
		if (sitoWeb != null) {
			_hashCode = 29 * _hashCode + sitoWeb.hashCode();
		}
		
		return _hashCode;
	}

	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeTEnteform2015Pk
	 */
	public SiceeTEnteform2015Pk createPk()
	{
		return new SiceeTEnteform2015Pk(idEnte);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformativo2015: " );
		ret.append( "idEnte=" + idEnte );
		ret.append( ", idRegione=" + idRegione );
		ret.append( ", descRegione=" + descRegione );
		ret.append( ", idProv=" + idProv );
		ret.append( ", descProv=" + descProv );
		ret.append( ", idComune=" + idComune );
		ret.append( ", descComune=" + descComune );
		ret.append( ", idIndirizzo=" + idIndirizzo );
		ret.append( ", descIndirizzo=" + descIndirizzo );
		ret.append( ", numCivico=" + numCivico );
		ret.append( ", cap=" + cap );
		ret.append( ", telefono=" + telefono );
		ret.append( ", cell=" + cell );
		ret.append( ", email=" + email );
		ret.append( ", emailPec=" + emailPec );
		ret.append( ", fax=" + fax );
		ret.append( ", sitoWeb=" + sitoWeb );
		return ret.toString();
	}

}
