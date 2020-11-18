/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceebo.business.facade;

import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;

import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
import it.csi.sicee.siceebo.business.BEException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTParametriDaoException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTEnteform2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteform2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteform2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTEnteformSl2015DaoException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTEnteformSl2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformSl2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformSl2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTEnteform2015DaoException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoenteform2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoenteform2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoenteform2015DaoException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTEnteformCf2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformCf2015;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTEnteformCf2015DaoException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCorso2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCorso2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCorso2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTCorso2015DaoException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTPartecipante2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTPartecipante2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTPartecipante2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTPartecipante2015DaoException;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoIstruzioneDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoIstruzione;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoIstruzioneDaoException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDIstruzioneDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoCorsoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDIstruzione;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoCorso;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDIstruzioneDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoCorsoDaoException;
import it.csi.sicee.siceebo.dto.entiformativi.EnteCf;
import it.csi.sicee.siceebo.dto.entiformativi.Corso;
import it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo;
import it.csi.sicee.siceebo.dto.entiformativi.Decodifica;
import it.csi.sicee.siceebo.dto.entiformativi.Esito;
import it.csi.sicee.siceebo.dto.entiformativi.Partecipante;
import it.csi.sicee.siceebo.dto.entiformativi.Istruzione;
import it.csi.sicee.siceebo.util.MailSender;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;

public class MiscMgr extends BaseMgr {
	
	SiceeTParametriDao siceeTParametriDao = null;
	SiceeTCertificatoreDao siceeTCertificatoreDao = null;
	SiceeTEnteformCf2015Dao siceeTEnteformCf2015Dao = null;
	SiceeTEnteformSl2015Dao siceeTEnteformSl2015Dao = null;
	SiceeTEnteform2015Dao siceeTEnteform2015Dao = null;
	SiceeTCorso2015Dao siceeTCorso2015Dao = null;
	SiceeDTipoenteform2015Dao siceeDTipoenteform2015Dao = null;
	SiceeTPartecipante2015Dao siceeTPartecipante2015Dao = null;
	SiceeDTipoIstruzioneDao siceeDTipoIstruzioneDao = null;
	SiceeDIstruzioneDao siceeDIstruzioneDao = null;
	SiceeDTipoCorsoDao siceeDTipoCorsoDao = null;
	
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	
	public SiceeDIstruzioneDao getSiceeDIstruzioneDao() {
		return this.siceeDIstruzioneDao;
	}
	public void setSiceeDIstruzioneDao(SiceeDIstruzioneDao siceeDIstruzioneDao) {
		this.siceeDIstruzioneDao = siceeDIstruzioneDao;
	}

	public SiceeDTipoIstruzioneDao getSiceeDTipoIstruzioneDao() {
		return this.siceeDTipoIstruzioneDao;
	}
	public void setSiceeDTipoIstruzioneDao(SiceeDTipoIstruzioneDao siceeDTipoIstruzioneDao) {
		this.siceeDTipoIstruzioneDao = siceeDTipoIstruzioneDao;
	}

	public SiceeTPartecipante2015Dao getSiceeTPartecipante2015Dao() {
		return this.siceeTPartecipante2015Dao;
	}
	public void setSiceeTPartecipante2015Dao(SiceeTPartecipante2015Dao siceeTPartecipante2015Dao) {
		this.siceeTPartecipante2015Dao = siceeTPartecipante2015Dao;
	}

	public SiceeDTipoenteform2015Dao getSiceeDTipoenteform2015Dao() {
		return this.siceeDTipoenteform2015Dao;
	}
	public void setSiceeDTipoenteform2015Dao(SiceeDTipoenteform2015Dao siceeDTipoenteform2015Dao) {
		this.siceeDTipoenteform2015Dao = siceeDTipoenteform2015Dao;
	}

	public SiceeTCorso2015Dao getSiceeTCorso2015Dao() {
		return this.siceeTCorso2015Dao;
	}
	public void setSiceeTCorso2015Dao(SiceeTCorso2015Dao siceeTCorso2015Dao) {
		this.siceeTCorso2015Dao = siceeTCorso2015Dao;
	}

	public SiceeTEnteformCf2015Dao getSiceeTEnteformCf2015Dao() {
		return this.siceeTEnteformCf2015Dao;
	}
	public void setSiceeTEnteformCf2015Dao(SiceeTEnteformCf2015Dao siceeTEnteformCf2015Dao) {
		this.siceeTEnteformCf2015Dao = siceeTEnteformCf2015Dao;
	}

	public SiceeTEnteform2015Dao getSiceeTEnteform2015Dao() {
		return this.siceeTEnteform2015Dao;
	}
	public void setSiceeTEnteformativo2015Dao(SiceeTEnteform2015Dao siceeTEnteform2015Dao) {
		this.siceeTEnteform2015Dao = siceeTEnteform2015Dao;
	}

	public SiceeTEnteformSl2015Dao getSiceeTEnteformSl2015Dao() {
		return this.siceeTEnteformSl2015Dao;
	}
	public void setSiceeTEnteformativoSl2015Dao(SiceeTEnteformSl2015Dao siceeTEnteformSl2015Dao) {
		this.siceeTEnteformSl2015Dao = siceeTEnteformSl2015Dao;
	}

	public SiceeTCertificatoreDao getSiceeTCertificatoreDao() {
		return this.siceeTCertificatoreDao;
	}
	public void setSiceeTCertificatoreDao(SiceeTCertificatoreDao siceeTCertificatoreDao) {
		this.siceeTCertificatoreDao = siceeTCertificatoreDao;
	}

	public SiceeTParametriDao getSiceeTParametriDao() {
		return this.siceeTParametriDao;
	}
	public void setSiceeTParametriDao(SiceeTParametriDao siceeTParametriDao) {
		this.siceeTParametriDao = siceeTParametriDao;
	}

	public SiceeDTipoCorsoDao getSiceeDTipoCorsoDao() {
		return this.siceeDTipoCorsoDao;
	}
	public void setSiceeDTipoCorsoDao(SiceeDTipoCorsoDao siceeDTipoCorsoDao) {
		this.siceeDTipoCorsoDao = siceeDTipoCorsoDao;
	}

	public String getParametro(String codice) {
		String value = "";

		try {
			SiceeTParametri param = this.getSiceeTParametriDao().findByPrimaryKey(codice);
			if (param != null) {
				value = param.getValore();
			} else {
				log.error(codice + " non configurato sul db", new Exception());
			}
		} catch (SiceeTParametriDaoException e) {
			log.error(e);
		}

		return value;
	}

	public ArrayList<Decodifica> getTipiSoggetto() {
		List<SiceeDTipoenteform2015> tipiSoggetto = null;
		ArrayList<Decodifica> tipiSoggettoReturn = null;
		try {
			tipiSoggetto = this.getSiceeDTipoenteform2015Dao().findAll();
		} catch (SiceeDTipoenteform2015DaoException e) {
			log.error(e);
		}
		if (tipiSoggetto !=  null)
			tipiSoggettoReturn = new ArrayList<Decodifica>();
		for (SiceeDTipoenteform2015 tipoSoggetto : tipiSoggetto) {
			Decodifica tipoSoggettoReturn = new Decodifica();
			tipoSoggettoReturn.setId(tipoSoggetto.getIdTipoenteform());
			tipoSoggettoReturn.setDescr(tipoSoggetto.getDescr());
			tipiSoggettoReturn.add(tipoSoggettoReturn);
		}

		return tipiSoggettoReturn;
	}
	
	public ArrayList<Istruzione> getTipiIstruzione() {
		List<SiceeDTipoIstruzione> tipiIstruzione = null;
		ArrayList<Istruzione> tipiIstruzioneReturn = null;
		try {
			tipiIstruzione = this.getSiceeDTipoIstruzioneDao().findAll();
		} catch (SiceeDTipoIstruzioneDaoException e) {
			log.error(e);
		}
		if (tipiIstruzione !=  null)
			tipiIstruzioneReturn = new ArrayList<Istruzione>();
		for (SiceeDTipoIstruzione tipoIstruzione : tipiIstruzione) {
			Istruzione tipoIstruzioneReturn = new Istruzione();
			tipoIstruzioneReturn.setIdTipoIstruzione(Integer.toString(tipoIstruzione.getIdTipoIstruzione()));
			tipoIstruzioneReturn.setDescr(tipoIstruzione.getDescr());
			tipiIstruzioneReturn.add(tipoIstruzioneReturn);
		}

		return tipiIstruzioneReturn;
	}

	public SiceeDIstruzione getIstruzione(Integer idIstruzione) {
		SiceeDIstruzione istruzione = null;
		try {
			istruzione = this.getSiceeDIstruzioneDao().findByPrimaryKey(idIstruzione);
		} catch (SiceeDIstruzioneDaoException e) {
			log.error(e);
		}

		return istruzione;
	}

	public EnteCf getIdEntiByCF(String codiceFiscale) {
		List<SiceeTEnteformCf2015> entiCf = null;
		EnteCf enteCfReturn = null;
		try {
			entiCf = this.getSiceeTEnteformCf2015Dao().findWhereCfCertificatoEquals(codiceFiscale);
		} catch (SiceeTEnteformCf2015DaoException e) {
			log.error(e);
		}
		for (SiceeTEnteformCf2015 ecf : entiCf) {
			if (ecf.getCfCertificato().equalsIgnoreCase(codiceFiscale)) {
				enteCfReturn = new EnteCf();
				enteCfReturn.setIdEnte(ecf.getIdEnte());
				enteCfReturn.setCfCertificato(ecf.getCfCertificato());
				enteCfReturn.setRuolo(ecf.getRuolo());
			}
		}

		return enteCfReturn;
	}

	public EnteFormativo getEnteByPk(long idEnte) {
		SiceeTEnteform2015 ente = null;
		SiceeTEnteformSl2015 enteSl = null;
		EnteFormativo enteFormativo = null;
		try {
			ente = this.getSiceeTEnteform2015Dao().findByPrimaryKey(idEnte);
			enteSl = this.getSiceeTEnteformSl2015Dao().findByPrimaryKey(ente.getFkEnteSl());
		} catch (SiceeTEnteform2015DaoException e) {
			log.error(e);
		} catch (SiceeTEnteformSl2015DaoException e) {
			log.error(e);
		}
		if (ente != null) {
			enteFormativo = new EnteFormativo();
			enteFormativo.setIdEnte(ente.getIdEnte());
			enteFormativo.setFkEnteSl(ente.getFkEnteSl());
			enteFormativo.setCodFormReg(ente.getCodFormReg());
			
			enteFormativo.setDenominazione(enteSl.getDenominazione());
			enteFormativo.setPiva(enteSl.getPIva());
			enteFormativo.setTipoSoggetto(enteSl.getTipoSoggetto());

			enteFormativo.setIdRegione(ente.getIdRegione());
			enteFormativo.setDescRegione(ente.getDescRegione());
			enteFormativo.setIdProv(ente.getIdProv());
			enteFormativo.setDescProv(ente.getDescProv());
			enteFormativo.setIdComune(ente.getIdComune());
			enteFormativo.setDescComune(ente.getDescComune());
			enteFormativo.setIdIndirizzo(ente.getIdIndirizzo());
			enteFormativo.setDescIndirizzo(ente.getDescIndirizzo());
			enteFormativo.setNumCivico(ente.getNumCivico());
			enteFormativo.setSedeCompleta("<b>" + ente.getDescComune() + " (" + ente.getDescProv() + ") - " + ente.getDescIndirizzo() + " " + ente.getNumCivico() + "</b>");
			enteFormativo.setCap(ente.getCap());
			enteFormativo.setReferente(ente.getReferente());
			enteFormativo.setTelefono(ente.getTelefono());
			enteFormativo.setCell(ente.getCell());
			enteFormativo.setEmail(ente.getEmail());
			enteFormativo.setEmailPec(ente.getEmailPec());
			enteFormativo.setFax(ente.getFax());
			enteFormativo.setSitoWeb(ente.getSitoWeb());
			
			enteFormativo.setBase64Logo(enteSl.getBase64Logo());
			enteFormativo.setParametriLogo(enteSl.getParametriLogo());
			if (!isNullOrEmpty(enteSl.getBase64Logo()))
				enteFormativo.setPresenzaLogo("<b><font color=\"green\">Logo presente</font></b>");
			else
				enteFormativo.setPresenzaLogo("<b><font color=\"red\">Nessun logo presente</font></b>");
		}

		return enteFormativo;
	}
	
	public ArrayList<Decodifica> getElencoSediEnteByFkEnteSl(long fkEnteSl) {
		List<SiceeTEnteform2015> elencoSediOperativeEnte = null;
		ArrayList<Decodifica> elencoSediOperativeDec = new ArrayList<Decodifica>();
		try {
			elencoSediOperativeEnte = this.getSiceeTEnteform2015Dao().findWhereFkEnteSlEquals(fkEnteSl);
		} catch (SiceeTEnteform2015DaoException e) {
			log.error(e);
		}
		for (SiceeTEnteform2015 ente : elencoSediOperativeEnte) {
			Decodifica d = new Decodifica();
			d.setId(Long.toString(ente.getIdEnte()));
			d.setDescr(ente.getDescComune() + " - " + ente.getDescIndirizzo());
			elencoSediOperativeDec.add(d);
		}

		return elencoSediOperativeDec;
	}

	public ArrayList<Decodifica> getElencoTipoCorsoValidi() {
		List<SiceeDTipoCorso> elencoTipoCorso = null;
		ArrayList<Decodifica> elencoTipoCorsoDec = new ArrayList<Decodifica>();
		try {
			elencoTipoCorso = this.getSiceeDTipoCorsoDao().findAllAbilitati();
		} catch (SiceeDTipoCorsoDaoException e) {
			log.error(e);
		}
		for (SiceeDTipoCorso ente : elencoTipoCorso) {
			Decodifica d = new Decodifica();
			d.setId(Long.toString(ente.getIdTipoCorso()));
			d.setDescr(ente.getDescrizione());
			elencoTipoCorsoDec.add(d);
		}

		return elencoTipoCorsoDec;
	}

	public ArrayList<Decodifica> getElencoTipoCorsoAll() {
		List<SiceeDTipoCorso> elencoTipoCorso = null;
		ArrayList<Decodifica> elencoTipoCorsoDec = new ArrayList<Decodifica>();
		try {
			log.debug("Prima di ricercare getElencoTipoCorsoAll");
			elencoTipoCorso = this.getSiceeDTipoCorsoDao().findAll();
			log.debug("Dopo aver ricercato getElencoTipoCorsoAll: "+elencoTipoCorso);
			
		} catch (SiceeDTipoCorsoDaoException e) {
			log.error(e);
		}
		
		for (SiceeDTipoCorso ente : elencoTipoCorso) {
			Decodifica d = new Decodifica();
			d.setId(Long.toString(ente.getIdTipoCorso()));
			d.setDescr(ente.getDescrizione());
			elencoTipoCorsoDec.add(d);
		}

		return elencoTipoCorsoDec;
	}

	public SiceeDTipoCorso getTipoCorsoById(int idTipoCorso) {
		SiceeDTipoCorso tipoCorso = null;
		try {
			tipoCorso = this.getSiceeDTipoCorsoDao().findByPrimaryKey(idTipoCorso);
		} catch (SiceeDTipoCorsoDaoException e) {
			log.error(e);
		}

		return tipoCorso;
	}

	
	/*
	public ArrayList<Decodifica> getElencoSediEnteByPiva(String partitaIva) {
		List<SiceeTEnteform2015> elencoSediOperativeEnte = null;
		ArrayList<Decodifica> elencoSediOperativeDec = new ArrayList<Decodifica>();
		try {
			elencoSediOperativeEnte = this.getSiceeTEnteform2015Dao().findWherePIvaEquals(partitaIva);
		} catch (SiceeTEnteform2015DaoException e) {
			log.error(e);
		}
		for (SiceeTEnteform2015 ente : elencoSediOperativeEnte) {
			Decodifica d = new Decodifica();
			d.setId(Long.toString(ente.getIdEnte()));
			d.setDescr(ente.getDescComune() + " - " + ente.getDescIndirizzo());
			elencoSediOperativeDec.add(d);
		}

		return elencoSediOperativeDec;
	}
*/	
	public void updateEnteFormativo(EnteFormativo enteFormativo) {
		SiceeTEnteform2015 ente = new SiceeTEnteform2015();
		SiceeTEnteformSl2015 enteSl = new SiceeTEnteformSl2015();
		SiceeTEnteform2015Pk pk = new SiceeTEnteform2015Pk();
		SiceeTEnteformSl2015Pk pkSl = new SiceeTEnteformSl2015Pk();
		pk.setIdEnte(enteFormativo.getIdEnte());
		pkSl.setIdEnteSl(enteFormativo.getFkEnteSl());
		ente.setIdEnte(enteFormativo.getIdEnte());
		ente.setFkEnteSl(enteFormativo.getFkEnteSl());
		ente.setCodFormReg(enteFormativo.getCodFormReg());

		enteSl.setDenominazione(enteFormativo.getDenominazione());
		enteSl.setPIva(enteFormativo.getPiva());
		enteSl.setTipoSoggetto(enteFormativo.getTipoSoggetto());

		ente.setIdRegione(enteFormativo.getIdRegione());
		ente.setDescRegione(enteFormativo.getDescRegione());
		ente.setIdProv(enteFormativo.getIdProv());
		ente.setDescProv(enteFormativo.getDescProv());
		ente.setIdComune(enteFormativo.getIdComune());
		ente.setDescComune(enteFormativo.getDescComune());
		ente.setIdIndirizzo(enteFormativo.getIdIndirizzo());
		ente.setDescIndirizzo(enteFormativo.getDescIndirizzo());
		ente.setNumCivico(enteFormativo.getNumCivico());
		ente.setCap(enteFormativo.getCap());
		ente.setReferente(enteFormativo.getReferente());
		ente.setTelefono(enteFormativo.getTelefono());
		ente.setCell(enteFormativo.getCell());
		ente.setEmail(enteFormativo.getEmail());
		ente.setEmailPec(enteFormativo.getEmailPec());
		ente.setFax(enteFormativo.getFax());
		ente.setSitoWeb(enteFormativo.getSitoWeb());
		
		enteSl.setBase64Logo(enteFormativo.getBase64Logo());
		enteSl.setParametriLogo(enteFormativo.getParametriLogo());

		try {
			this.getSiceeTEnteform2015Dao().update(pk, ente);
			enteSl = this.getSiceeTEnteformSl2015Dao().findByPrimaryKey(ente.getFkEnteSl());
			enteSl.setBase64Logo(enteFormativo.getBase64Logo());
			enteSl.setParametriLogo(enteFormativo.getParametriLogo());
			this.getSiceeTEnteformSl2015Dao().update(pkSl, enteSl);
		} catch (SiceeTEnteform2015DaoException e) {
			log.error(e);
		} catch (SiceeTEnteformSl2015DaoException e) {
			log.error(e);
		}
	}

	public ArrayList<Corso> getCorsiByidEnte(long idEnte) {
		List<SiceeTCorso2015> corsi = null;
		ArrayList<Corso> corsiReturn = null;
		ArrayList<Decodifica> elencoTipologieCorsi = null;
		try {
			corsi = this.getSiceeTCorso2015Dao().findBySiceeTEnteformativo2015(idEnte);
			
			elencoTipologieCorsi = getElencoTipoCorsoAll();

		} catch (SiceeTCorso2015DaoException e) {
			log.error(e);
		}
		if (corsi !=  null)
			corsiReturn = new ArrayList<Corso>();
		for (SiceeTCorso2015 corso : corsi) {
			Corso corsoReturn = new Corso();
			corsoReturn.setIdCorso(corso.getIdCorso());
			corsoReturn.setFkEnte(corso.getFkEnte());
			
			
			corsoReturn.setIdTipoCorso(corso.getFkTipoCorso());
			//corsoReturn.setTipoCorso1Descr(decodTipologiaCorso(corso.getTipoCorso1()));

			corsoReturn.setTipoCorsoDescr(GenericUtil.getDescById(corso.getFkTipoCorso(), elencoTipologieCorsi));

			corsoReturn.setNumCorso(corso.getNumCorso());
			corsoReturn.setAnnoFormativo(corso.getAnnoFormativo());
			corsoReturn.setConcatAnnoFormNumCorso(corso.getAnnoFormativo() + " - " + corso.getNumCorso());
			//corsoReturn.setTipoCorso2(corso.getTipoCorso2());
			
			corsoReturn.setTitolo(corso.getTitolo());
			corsoReturn.setTitoloBold("<b>" + corso.getTitolo() + "</b>");
			corsoReturn.setTotaleOre(corso.getTotaleOre());
			corsoReturn.setTotaleModuli(corso.getTotaleModuli());
			corsoReturn.setDataDal(convertToString(corso.getDataDal()));
			corsoReturn.setDataAl(convertToString(corso.getDataAl()));
			corsoReturn.setConcatDataDalAl(convertToString(corso.getDataDal()) + " - " + convertToString(corso.getDataAl()));
			corsoReturn.setDataEsame(convertToString(corso.getDataEsame()));
			//corsoReturn.setPartecipanti(corso.getNPartecipanti());
			corsoReturn.setLuogoCorso(corso.getLuogoCorso());
			corsoReturn.setProtApprov(corso.getProtApprov());
			corsoReturn.setDataApprov(convertToString(corso.getDataApprov()));
			corsoReturn.setNote(corso.getNote());
			corsiReturn.add(corsoReturn);
		}

		return corsiReturn;
	}

	public ArrayList<Partecipante> getPartecipantiByidCorso(long idCorso) {
		List<SiceeTPartecipante2015> partecipanti = null;
		ArrayList<Partecipante> partecipantiReturn = null;
		try {
			partecipanti = this.getSiceeTPartecipante2015Dao().findWhereFkCorsoEquals(idCorso);
		} catch (SiceeTPartecipante2015DaoException e) {
			log.error(e);
		}
		if (partecipanti !=  null)
			partecipantiReturn = new ArrayList<Partecipante>();
		for (SiceeTPartecipante2015 partecipante : partecipanti) {
			Partecipante partecipanteReturn = new Partecipante();
			partecipanteReturn.setIdPartecipante(partecipante.getIdPartecipante());
			partecipanteReturn.setFkCorso(partecipante.getFkCorso());
			partecipanteReturn.setCodiceFiscale(partecipante.getCodiceFiscale());
			partecipanteReturn.setNome(partecipante.getNome());
			partecipanteReturn.setCognome(partecipante.getCognome());
			partecipanteReturn.setLuogoNascita(partecipante.getLuogoNascita());
			partecipanteReturn.setDataNascita(convertToString(partecipante.getDataNascita()));
			partecipanteReturn.setFkTipoIstruzione(partecipante.getFkTipoIstruzione());
			partecipanteReturn.setNumCertificatore(partecipante.getNumCertificatore());
			partecipanteReturn.setAlbo(partecipante.getAlbo());
			partecipanteReturn.setDescProvAlbo(partecipante.getDescProvAlbo());
			partecipanteReturn.setNumIscrAlbo(partecipante.getNumIscrAlbo());
			partecipanteReturn.setDataIscrAlbo(convertToString(partecipante.getDataIscrAlbo()));
			partecipanteReturn.setPercFreq(partecipante.getPercFreq());
			partecipanteReturn.setDataEsame(convertToString(partecipante.getDataEsame()));
			partecipanteReturn.setEsitoEsame(partecipante.getEsitoEsame());
			partecipanteReturn.setEsitoEsameDecod(decodEsame(partecipante.getEsitoEsame()));
			partecipanteReturn.setLuogoEsame(partecipante.getLuogoEsame());
			partecipanteReturn.setVotoEsame(partecipante.getVotoEsame());
			partecipanteReturn.setTelefono(partecipante.getTelefono());
			partecipanteReturn.setEmail(partecipante.getEmail());
			partecipanteReturn.setNote(partecipante.getNote());
			partecipantiReturn.add(partecipanteReturn);
		}

		return partecipantiReturn;
	}
	
	public int countPartecipantiByidCorsoAndCodFisc(long idCorso, String codiceFiscale) {
		List<SiceeTPartecipante2015> partecipanti = null;
		try {
			partecipanti = this.getSiceeTPartecipante2015Dao().findWhereFkCorsoCodiceFiscaleEquals(idCorso, codiceFiscale);
		} catch (SiceeTPartecipante2015DaoException e) {
			log.error(e);
		}
		if ((partecipanti ==  null) || (partecipanti.size() == 0))
			return 0;
		else
			return partecipanti.size();
					
	}
	
	public Corso getCorsoByidCorso(Long idCorso) {
		SiceeTCorso2015 corso = null;
		Corso corsoReturn = null;
		try {
			corso = this.getSiceeTCorso2015Dao().findByPrimaryKey(idCorso);
		} catch (SiceeTCorso2015DaoException e) {
			log.error(e);
		}

		corsoReturn = new Corso();
		if (corso !=  null) {
			corsoReturn.setIdCorso(corso.getIdCorso());
			corsoReturn.setFkEnte(corso.getFkEnte());
			corsoReturn.setIdTipoCorso(corso.getFkTipoCorso());
			//corsoReturn.setTipoCorso2(corso.getTipoCorso2());
			corsoReturn.setNumCorso(corso.getNumCorso());
			corsoReturn.setAnnoFormativo(corso.getAnnoFormativo());
			corsoReturn.setTitolo(corso.getTitolo());
			corsoReturn.setTitoloBold("<b>" + corso.getTitolo() + "</b>");
			corsoReturn.setTotaleOre(corso.getTotaleOre());
			corsoReturn.setTotaleModuli(corso.getTotaleModuli());
			corsoReturn.setDataDal(convertToString(corso.getDataDal()));
			corsoReturn.setDataAl(convertToString(corso.getDataAl()));
			corsoReturn.setDataEsame(convertToString(corso.getDataEsame()));
			//corsoReturn.setPartecipanti(corso.getNPartecipanti());
			corsoReturn.setLuogoCorso(corso.getLuogoCorso());
			corsoReturn.setProtApprov(corso.getProtApprov());
			corsoReturn.setDataApprov(convertToString(corso.getDataApprov()));
			corsoReturn.setNote(corso.getNote());
		}

		return corsoReturn;
	}
	
	public Partecipante getPartecipanteByidPartecipante(Long idPartecipante) {
		SiceeTPartecipante2015 partecipante = null;
		Partecipante partecipanteReturn = null;
		try {
			partecipante = this.getSiceeTPartecipante2015Dao().findByPrimaryKey(idPartecipante);
		} catch (SiceeTPartecipante2015DaoException e) {
			log.error(e);
		}

		partecipanteReturn = new Partecipante();
		if (partecipante !=  null) {
			partecipanteReturn.setIdPartecipante(partecipante.getIdPartecipante());
			partecipanteReturn.setFkCorso(partecipante.getFkCorso());
			partecipanteReturn.setCodiceFiscale(partecipante.getCodiceFiscale());
			partecipanteReturn.setNome(partecipante.getNome());
			partecipanteReturn.setCognome(partecipante.getCognome());
			partecipanteReturn.setLuogoNascita(partecipante.getLuogoNascita());
			partecipanteReturn.setDataNascita(convertToString(partecipante.getDataNascita()));
			partecipanteReturn.setFkTipoIstruzione(partecipante.getFkTipoIstruzione());
			partecipanteReturn.setNumCertificatore(partecipante.getNumCertificatore());
			partecipanteReturn.setAlbo(partecipante.getAlbo());
			partecipanteReturn.setDescProvAlbo(partecipante.getDescProvAlbo());
			partecipanteReturn.setNumIscrAlbo(partecipante.getNumIscrAlbo());
			partecipanteReturn.setDataIscrAlbo(convertToString(partecipante.getDataIscrAlbo()));
			partecipanteReturn.setPercFreq(partecipante.getPercFreq());
			partecipanteReturn.setDataEsame(convertToString(partecipante.getDataEsame()));
			partecipanteReturn.setEsitoEsame(partecipante.getEsitoEsame());
			partecipanteReturn.setEsitoEsameDecod(decodEsame(partecipante.getEsitoEsame()));
			partecipanteReturn.setLuogoEsame(partecipante.getLuogoEsame());
			partecipanteReturn.setVotoEsame(partecipante.getVotoEsame());
			partecipanteReturn.setTelefono(partecipante.getTelefono());
			partecipanteReturn.setEmail(partecipante.getEmail());
			partecipanteReturn.setNote(partecipante.getNote());
		}

		return partecipanteReturn;
	}
	
	public void insertCorso(Corso corso) throws BEException {
		SiceeTCorso2015 corsoDb = new SiceeTCorso2015();
		//corsoDb.setIdCorso(corso.getIdCorso());
		corsoDb.setFkEnte(corso.getFkEnte());
		corsoDb.setFkTipoCorso(corso.getIdTipoCorso());
		//corsoDb.setTipoCorso2(corso.getTipoCorso2());
		corsoDb.setNumCorso(corso.getNumCorso());
		corsoDb.setAnnoFormativo(corso.getAnnoFormativo());
		corsoDb.setTitolo(corso.getTitolo());
		corsoDb.setTotaleOre(corso.getTotaleOre());
		corsoDb.setTotaleModuli(corso.getTotaleModuli());
		corsoDb.setDataDal(convertToDate(corso.getDataDal()));
		corsoDb.setDataAl(convertToDate(corso.getDataAl()));
		corsoDb.setDataEsame(convertToDate(corso.getDataEsame()));
		//corsoDb.setNPartecipanti(corso.getPartecipanti());
		corsoDb.setLuogoCorso(corso.getLuogoCorso());
		corsoDb.setProtApprov(corso.getProtApprov());
		corsoDb.setDataApprov(convertToDate(corso.getDataApprov()));
		corsoDb.setNote(corso.getNote());
		this.getSiceeTCorso2015Dao().insert(corsoDb);
	}

	public void updateCorso(Corso corso) throws BEException {
		SiceeTCorso2015 corsoDb = new SiceeTCorso2015();
		SiceeTCorso2015Pk pk = new SiceeTCorso2015Pk();
		pk.setIdCorso(corso.getIdCorso());
		corsoDb.setIdCorso(corso.getIdCorso());
		corsoDb.setFkEnte(corso.getFkEnte());
		corsoDb.setFkTipoCorso(corso.getIdTipoCorso());
		//corsoDb.setTipoCorso2(corso.getTipoCorso2());
		corsoDb.setNumCorso(corso.getNumCorso());
		corsoDb.setAnnoFormativo(corso.getAnnoFormativo());
		corsoDb.setTitolo(corso.getTitolo());
		corsoDb.setTotaleOre(corso.getTotaleOre());
		corsoDb.setTotaleModuli(corso.getTotaleModuli());
		corsoDb.setDataDal(convertToDate(corso.getDataDal()));
		corsoDb.setDataAl(convertToDate(corso.getDataAl()));
		corsoDb.setDataEsame(convertToDate(corso.getDataEsame()));
		//corsoDb.setNPartecipanti(corso.getPartecipanti());
		corsoDb.setLuogoCorso(corso.getLuogoCorso());
		corsoDb.setProtApprov(corso.getProtApprov());
		corsoDb.setDataApprov(convertToDate(corso.getDataApprov()));
		corsoDb.setNote(corso.getNote());

		try {
			this.getSiceeTCorso2015Dao().update(pk, corsoDb);
		} catch (SiceeTCorso2015DaoException e) {
			log.error(e);
		}
	}

	public void eliminaCorso(Long idCorso) throws BEException {
		SiceeTCorso2015Pk pk = new SiceeTCorso2015Pk();
		pk.setIdCorso(idCorso);
		try {
			this.getSiceeTPartecipante2015Dao().deleteWhereFkCorsoEquals(idCorso);
		} catch (SiceeTPartecipante2015DaoException e) {
			log.error(e);
		}
		try {
			this.getSiceeTCorso2015Dao().delete(pk);
		} catch (SiceeTCorso2015DaoException e) {
			log.error(e);
		}

	}

	public Long insertPartecipante(Partecipante partecipante) throws BEException {
		SiceeTPartecipante2015 partecipanteDb = new SiceeTPartecipante2015();
		SiceeTPartecipante2015Pk pk = null;

		partecipanteDb.setFkCorso(partecipante.getFkCorso());
		partecipanteDb.setCodiceFiscale(partecipante.getCodiceFiscale());
		partecipanteDb.setNome(partecipante.getNome());
		partecipanteDb.setCognome(partecipante.getCognome());
		partecipanteDb.setLuogoNascita(partecipante.getLuogoNascita());
		partecipanteDb.setDataNascita(convertToDate(partecipante.getDataNascita()));
		partecipanteDb.setFkTipoIstruzione(partecipante.getFkTipoIstruzione());
		partecipanteDb.setNumCertificatore(partecipante.getNumCertificatore());
		partecipanteDb.setAlbo(partecipante.getAlbo());
		partecipanteDb.setDescProvAlbo(partecipante.getDescProvAlbo());
		partecipanteDb.setNumIscrAlbo(partecipante.getNumIscrAlbo());
		partecipanteDb.setDataIscrAlbo(convertToDate(partecipante.getDataIscrAlbo()));
		partecipanteDb.setPercFreq(partecipante.getPercFreq());
		partecipanteDb.setDataEsame(convertToDate(partecipante.getDataEsame()));
		partecipanteDb.setEsitoEsame(partecipante.getEsitoEsame());
		partecipanteDb.setLuogoEsame(partecipante.getLuogoEsame());
		partecipanteDb.setVotoEsame(partecipante.getVotoEsame());
		partecipanteDb.setTelefono(partecipante.getTelefono());
		partecipanteDb.setEmail(partecipante.getEmail());
		partecipanteDb.setNote(partecipante.getNote());	
		pk = this.getSiceeTPartecipante2015Dao().insert(partecipanteDb);
		return pk.getIdPartecipante();
	}

	public void updatePartecipante(Partecipante partecipante) throws BEException {
		SiceeTPartecipante2015 partecipanteDb = new SiceeTPartecipante2015();
		SiceeTPartecipante2015Pk pk = new SiceeTPartecipante2015Pk();
		pk.setIdPartecipante(partecipante.getIdPartecipante());

		partecipanteDb.setIdPartecipante(partecipante.getIdPartecipante());
		partecipanteDb.setFkCorso(partecipante.getFkCorso());
		partecipanteDb.setCodiceFiscale(partecipante.getCodiceFiscale());
		partecipanteDb.setNome(partecipante.getNome());
		partecipanteDb.setCognome(partecipante.getCognome());
		partecipanteDb.setLuogoNascita(partecipante.getLuogoNascita());
		partecipanteDb.setDataNascita(convertToDate(partecipante.getDataNascita()));
		partecipanteDb.setFkTipoIstruzione(partecipante.getFkTipoIstruzione());
		partecipanteDb.setNumCertificatore(partecipante.getNumCertificatore());
		partecipanteDb.setAlbo(partecipante.getAlbo());
		partecipanteDb.setDescProvAlbo(partecipante.getDescProvAlbo());
		partecipanteDb.setNumIscrAlbo(partecipante.getNumIscrAlbo());
		partecipanteDb.setPercFreq(partecipante.getPercFreq());
		partecipanteDb.setDataIscrAlbo(convertToDate(partecipante.getDataIscrAlbo()));
		partecipanteDb.setDataEsame(convertToDate(partecipante.getDataEsame()));
		partecipanteDb.setEsitoEsame(partecipante.getEsitoEsame());
		partecipanteDb.setLuogoEsame(partecipante.getLuogoEsame());
		partecipanteDb.setVotoEsame(partecipante.getVotoEsame());
		partecipanteDb.setTelefono(partecipante.getTelefono());
		partecipanteDb.setEmail(partecipante.getEmail());
		partecipanteDb.setNote(partecipante.getNote());	

		try {
			this.getSiceeTPartecipante2015Dao().update(pk, partecipanteDb);
		} catch (SiceeTPartecipante2015DaoException e) {
			log.error(e);
		}
	}

	/*
	private String decodTipologiaCorso(String codice) {
		String descrizione = null;
		if (!MiscMgr.isNullOrEmpty(codice)) {
			if (codice.equalsIgnoreCase(Constants.TIPOCORSO1_AGGIORNAMENTO))
				descrizione = Constants.TIPOCORSO1_AGGIORNAMENTO_DESC;
			else if (codice.equalsIgnoreCase(Constants.TIPOCORSO1_FORMAZIONE))
				descrizione = Constants.TIPOCORSO1_FORMAZIONE_DESC;
		}
		return descrizione;
	}
	*/
	
	public static String decodEsame(String esame) {
		String esameDecod = null;
		if (esame != null) {
			if (esame.equalsIgnoreCase(Constants.ESITO_SUPERATO))
				esameDecod = Constants.ESITO_SUPERATO_DESC;
			else if (esame.equalsIgnoreCase(Constants.ESITO_SUPERATO_SESS_SUCC))
				esameDecod = Constants.ESITO_SUPERATO_SESS_SUCC_DESC;
			else if (esame.equalsIgnoreCase(Constants.ESITO_RESPINTO))
				esameDecod = Constants.ESITO_RESPINTO_DESC;
		}
		return esameDecod;
	}

	public void eliminaPartecipante(Long idPartecipante) throws BEException {
		SiceeTPartecipante2015Pk pk = new SiceeTPartecipante2015Pk();
		pk.setIdPartecipante(idPartecipante);
		try {
			this.getSiceeTPartecipante2015Dao().delete(pk);
		} catch (SiceeTPartecipante2015DaoException e) {
			log.error(e);
		}

	}

	public List<SiceeTCertificatore> recuperaCertificatoriByCf(String codiceFiscale) throws BEException {
		log.debug("codiceFiscale: " + codiceFiscale);
		List<SiceeTCertificatore> vo = null;
		try {
			vo = this.getSiceeTCertificatoreDao().findWhereCodiceFiscaleLike(codiceFiscale);
		} catch (Exception e) {
			log.error("Errore in recuperaCertificatoriByCf", e);
			throw new BEException(e.getMessage(), e);
		}
		return vo;
	}

	public SiceeTCertificatore recuperaCertificatore(String idCertificatore) throws BEException {
		log.debug("idCertificatore: " + idCertificatore);
		SiceeTCertificatore vo = null;
		try {
			vo = this.getSiceeTCertificatoreDao().findByPrimaryKey(idCertificatore);
		} catch (Exception e) {
			log.error("Errore in recuperaCertificatore", e);
			throw new BEException(e.getMessage(), e);
		}
		return vo;
	}

	public static String[] splitParametriLogo(String parametriLogo) {
		String[] split = parametriLogo.split(" ");
		return split;
	}

	public byte[] readFile(File f) {
		InputStream is = null;
		byte[] bytes = null;
		try {
			is = new FileInputStream(f);

			long length = f.length();
			log.debug("\n\n\n>>>>>>> file length: " + length);
			//if (length > Integer.MAX_VALUE) {
			if (length > Constants.MAX_LOGO_LENGTH) {
				log.error("File is too large");
				throw (new Exception());
			}

			bytes = new byte[(int) length];

			is.read(bytes);

			is.close();
		} catch (Exception e) {
			log.error("Impossibile leggere file", e);
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					log.error("Impossibile chiudere stream", e);
				}
			}
		}
		return bytes;
	}

	public void sendMailNotificaCertificatore(String bloccoCert, String nomeCert, String cognomeCert, String emailCert) {
		MailSender sender = new MailSender();
		it.csi.sicee.siceebo.util.Mail email = new it.csi.sicee.siceebo.util.Mail();

		// invio e-mail ad assistenza
		email.setDestinatario(this.getParametro(Constants.EMAIL_NOTIFICA));
		email.setHost(this.getParametro(Constants.MAIL_HOST));
		email.setPort(this.getParametro(Constants.MAIL_PORT));
		email.setMittente(this.getParametro(Constants.MAIL_MITT_NOTIFICA));

		email.setOggetto(this.creaOggettoEmailNotifica(bloccoCert));
		email.setHtml(this.creaHtmlEmailNotifica(bloccoCert, nomeCert, cognomeCert));
		email.setTesto(this.creaTestoEmailNotifica(bloccoCert, nomeCert, cognomeCert));

		try {
			sendMail(email);
		} catch (Exception e) {
			log.error(e);
		}

		// invio e-mail al certificatore
		email.setDestinatario(emailCert);
//		email.setHost(this.getParametro(Constants.MAIL_HOST));
//		email.setPort(this.getParametro(Constants.MAIL_PORT));
//		email.setMittente(this.getParametro(Constants.MAIL_MITT_NOTIFICA));
//
//		email.setOggetto(this.creaOggettoEmailNotifica(bloccoCert));
//		email.setHtml(this.creaHtmlEmailNotifica(bloccoCert, nomeCert, cognomeCert));
//		email.setTesto(this.creaTestoEmailNotifica(bloccoCert, nomeCert, cognomeCert));
		try {
			sendMail(email);
		} catch (Exception e) {
			log.error(e);
		}

	}
	
	public void sendMailNotificaSbloccoCertificatore(String nomeCert, String cognomeCert, String emailCert) {
		MailSender sender = new MailSender();
		it.csi.sicee.siceebo.util.Mail email = new it.csi.sicee.siceebo.util.Mail();

		// invio e-mail ad assistenza
		email.setDestinatario(this.getParametro(Constants.EMAIL_NOTIFICA));
		email.setHost(this.getParametro(Constants.MAIL_HOST));
		email.setPort(this.getParametro(Constants.MAIL_PORT));
		email.setMittente(this.getParametro(Constants.MAIL_MITT_NOTIFICA));

		email.setOggetto(this.getParametro(Constants.OGGETTO_MAIL_NOTIFICA_RIATTIVAZIONE));
		email.setHtml(this.creaHtmlEmailNotificaSblocco(nomeCert, cognomeCert));
		email.setTesto(this.creaTestoEmailNotificaSblocco(nomeCert, cognomeCert));

		try {
			sendMail(email);
		} catch (Exception e) {
			log.error(e);
		}

		// invio e-mail al certificatore
		email.setDestinatario(emailCert);
		
//		email.setHost(this.getParametro(Constants.MAIL_HOST));
//		email.setPort(this.getParametro(Constants.MAIL_PORT));
//		email.setMittente(this.getParametro(Constants.MAIL_MITT_NOTIFICA));
//
//		email.setOggetto(this.creaOggettoEmailNotifica(bloccoCert));
//		email.setHtml(this.creaHtmlEmailNotifica(bloccoCert, nomeCert, cognomeCert));
//		email.setTesto(this.creaTestoEmailNotifica(bloccoCert, nomeCert, cognomeCert));
		try {
			sendMail(email);
		} catch (Exception e) {
			log.error(e);
		}

	}
	
	public void sendMailNotificaEccezioneAnnullamento(String certificato, BEException e) {
		MailSender sender = new MailSender();
		it.csi.sicee.siceebo.util.Mail email = new it.csi.sicee.siceebo.util.Mail();
	
		// invio e-mail ad assistenza
		email.setDestinatario(this.getParametro(Constants.EMAIL_NOTIFICA));
		email.setHost(this.getParametro(Constants.MAIL_HOST));
		email.setPort(this.getParametro(Constants.MAIL_PORT));
		email.setMittente(this.getParametro(Constants.MAIL_MITT_NOTIFICA));

		email.setOggetto("SIPEE - ATTENZIONE errore annullamento APE scaduti ");
		
		StringBuffer testo = new StringBuffer("APE: ");
		testo.append(certificato);
		testo.append("\nEccezione: ");
		testo.append(e.getMessage());
		
		log.debug("Testo mail: "+testo.toString());
		
		email.setTesto(testo.toString());
		email.setHtml(testo.toString().replaceAll("\n", "<BR>"));

		try {
			sendMail(email);
		} catch (Exception ex) {
			log.error(ex);
		}

	}

	private String creaOggettoEmailNotifica(String bloccoCert) {
		String msg = null;
		String messaggio = null;
		int intBloccoCert;

		try {
			intBloccoCert = Integer.parseInt(bloccoCert);
			if (intBloccoCert == Constants.STATO_CERTIFICATORE_RADIATO) {
				messaggio = this.getParametro(Constants.OGGETTO_MAIL_NOTIFICA_RADIATO);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO) {
				messaggio = this.getParametro(Constants.OGGETTO_MAIL_NOTIFICA_ASSENZA_TITOLO_STUDIO);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_FALSE_DICHIARAZIONI) {
				messaggio = this.getParametro(Constants.OGGETTO_MAIL_NOTIFICA_FALSE_DICHIARAZIONI);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_ASSENZA_CORSO) {
				messaggio = this.getParametro(Constants.OGGETTO_MAIL_NOTIFICA_ASSENZA_CORSO);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_MANCANZA_INFORMAZIONI) {
				messaggio = this.getParametro(Constants.OGGETTO_MAIL_NOTIFICA_INTEGRAZIONE_DOC);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_MANCANZA_GENERICA) {
				messaggio = this.getParametro(Constants.OGGETTO_MAIL_NOTIFICA_ALTRO);
			}
			
			
			msg = messaggio;
		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;

	}

	private String creaHtmlEmailNotifica(String bloccoCert, String nome, String cognome) {
		String msg = null;
		String messaggio = null;
		int intBloccoCert;

		try {
			intBloccoCert = Integer.parseInt(bloccoCert);
			if (intBloccoCert == Constants.STATO_CERTIFICATORE_RADIATO) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_RADIATO_HTML);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_ASSENZA_TITOLO_STUDIO_HTML);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_FALSE_DICHIARAZIONI) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_FALSE_DICHIARAZIONI_HTML);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_ASSENZA_CORSO) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_ASSENZA_CORSO_HTML);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_MANCANZA_INFORMAZIONI) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_INTEGRAZIONE_DOC_HTML);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_MANCANZA_GENERICA) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_ALTRO_HTML);
			}

			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE, nome);
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE, cognome);

			msg = messaggio;

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;
	}

	private String creaHtmlEmailNotificaSblocco(String nome, String cognome) {
		String msg = null;
		String messaggio = null;

		try {
			messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_RIATTIVAZIONE_HTML);
			
			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE, nome);
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE, cognome);

			msg = messaggio;

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;
	}
	
	private String creaTestoEmailNotifica(String bloccoCert, String nome, String cognome) {
		String msg = null;
		String messaggio = null;
		int intBloccoCert;

		try {
			intBloccoCert = Integer.parseInt(bloccoCert);
			if (intBloccoCert == Constants.STATO_CERTIFICATORE_RADIATO) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_RADIATO_TXT);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_ASSENZA_TITOLO_STUDIO_TXT);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_FALSE_DICHIARAZIONI) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_FALSE_DICHIARAZIONI_TXT);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_ASSENZA_CORSO) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_ASSENZA_CORSO_TXT);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_MANCANZA_INFORMAZIONI) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_INTEGRAZIONE_DOC_TXT);
			} else if (intBloccoCert == Constants.STATO_CERTIFICATORE_MANCANZA_GENERICA) {
				messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_ALTRO_TXT);
			}
			
			
			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE, nome);
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE, cognome);

			msg = messaggio;

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;
	}

	private String creaTestoEmailNotificaSblocco(String nome, String cognome) {
		String msg = null;
		String messaggio = null;

		try {
			messaggio = this.getParametro(Constants.TESTO_MAIL_NOTIFICA_RIATTIVAZIONE_TXT);

			messaggio = messaggio.replaceAll(Constants.CARRIAGE_RETURN, "\n");
			messaggio = messaggio.replaceAll(Constants.NOME_CERTIFICATORE, nome);
			messaggio = messaggio.replaceAll(Constants.COGNOME_CERTIFICATORE, cognome);

			msg = messaggio;

		} catch (Exception e) {
			log.error(e.getMessage(), e);

		}
		return msg;
	}
	
	private void sendMail(it.csi.sicee.siceebo.util.Mail email)
	{
		MailSender sender = new MailSender();

		try
		{
			sender.sendMail(email, null);
		} catch (Exception ex) {
			log.error("Errore nell'invio della mail", ex);

			try {
				
				// In caso di eccezione invio mail (problema noto)
				// javax.activation.UnsupportedDataTypeException: no object DCH for MIME type multipart/mixed;
				// tentiamo di inviare la mail grazie al servizio messo a disposizione di siceews
				getSoaIntegrationMgr().sendMailService(email);
				
			} catch (BEException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			log.error(ex);
		}
	}
}
