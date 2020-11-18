/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceebo.business.facade;


import it.csi.sicee.siceebo.business.BEException;
import it.csi.sicee.siceebo.business.dao.dao.OptimizedSiceeTTransazione2018Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoDocIndex2015Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTActaDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTFoto2015Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTParametriActaDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTRifIndex2015Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTTransazione2018Dao;
import it.csi.sicee.siceebo.business.dao.dto.OptimizedSiceeTTransazione2018;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoDocIndex2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTActa;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBo;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBoPk;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTFoto2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriActa;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTRifIndex2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTSiape;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTTransazione2018Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.OptimizedSiceeTTransazione2018DaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoDocIndex2015DaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTActaDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTCertificatoreDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTFoto2015DaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTParametriActaDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTRifIndex2015DaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTTransazione2018DaoException;
import it.csi.sicee.siceebo.dto.ace.FiltroRicercaAce;
import it.csi.sicee.siceebo.dto.backoffice.DettaglioTransAttEsito;
import it.csi.sicee.siceebo.dto.backoffice.FiltroDettaglioTransAttEsito;
import it.csi.sicee.siceebo.dto.backoffice.ResocontoTransMdp;
import it.csi.sicee.siceebo.dto.backoffice.VerificaActa;
import it.csi.sicee.siceebo.dto.backoffice.VerificaIndex;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.Converter;
import it.csi.sicee.siceebo.util.GenericUtil;
import it.csi.sicee.siceeorch.dto.siceeorch.Documento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.lowagie.text.BadElementException;

// TODO: Auto-generated Javadoc
/**
 * Facade di gestione del back office
 *
 */
public class BackOfficeMgr extends BaseMgr {

	private SOAIntegrationMgr soaIntegrationMgr;
	
	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return this.soaIntegrationMgr;
	}
	
	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	/** The  sicee t transazione 2018 dao. */
	private SiceeTTransazione2018Dao siceeTTransazione2018Dao;

	/**
	 * Gets the sicee t transazione 2018 dao.
	 *
	 * @return the sicee t transazione 2018 dao
	 */
	public SiceeTTransazione2018Dao getSiceeTTransazione2018Dao() {
		return this.siceeTTransazione2018Dao;
	}
	
	/**
	 * Sets the sicee t transazione 2018 dao.
	 *
	 * @param siceeTTransazione2018Dao the new sicee t transazione 2018 dao
	 */
	public void setSiceeTTransazione2018Dao(
			SiceeTTransazione2018Dao siceeTTransazione2018Dao) {
		this.siceeTTransazione2018Dao = siceeTTransazione2018Dao;
	}
	
	/** The sicee t transazione 2018 dao. */
	private OptimizedSiceeTTransazione2018Dao optimizedSiceeTTransazione2018Dao;

	/**
	 * Gets the optimized sicee t transazione 2018 dao.
	 *
	 * @return the optimized sicee t transazione 2018 dao
	 */
	public OptimizedSiceeTTransazione2018Dao getOptimizedSiceeTTransazione2018Dao() {
		return this.optimizedSiceeTTransazione2018Dao;
	}
	
	/**
	 * Sets the optimized sicee t transazione 2018 dao.
	 *
	 * @param optimizedSiceeTTransazione2018Dao the new optimized sicee t transazione 2018 dao
	 */
	public void setOptimizedSiceeTTransazione2018Dao(
			OptimizedSiceeTTransazione2018Dao optimizedSiceeTTransazione2018Dao) {
		this.optimizedSiceeTTransazione2018Dao = optimizedSiceeTTransazione2018Dao;
	}

	private SiceeTRifIndex2015Dao siceeTRifIndex2015Dao;
	
	public SiceeTRifIndex2015Dao getSiceeTRifIndex2015Dao() {
		return this.siceeTRifIndex2015Dao;
	}
	public void setSiceeTRifIndex2015Dao(SiceeTRifIndex2015Dao siceeTRifIndex2015Dao) {
		this.siceeTRifIndex2015Dao = siceeTRifIndex2015Dao;
	}
	
	private SiceeTFoto2015Dao siceeTFoto2015Dao;
	public SiceeTFoto2015Dao getSiceeTFoto2015Dao() {
		return this.siceeTFoto2015Dao;
	}
	public void setSiceeTFoto2015Dao(
			SiceeTFoto2015Dao siceeTFoto2015Dao) {
		this.siceeTFoto2015Dao = siceeTFoto2015Dao;
	}

	private SiceeDTipoDocIndex2015Dao siceeDTipoDocIndex2015Dao;
	public SiceeDTipoDocIndex2015Dao getSiceeDTipoDocIndex2015Dao() {
		return this.siceeDTipoDocIndex2015Dao;
	}
	public void setSiceeDTipoDocIndex2015Dao(
			SiceeDTipoDocIndex2015Dao siceeDTipoDocIndex2015Dao) {
		this.siceeDTipoDocIndex2015Dao = siceeDTipoDocIndex2015Dao;
	}
	
	private SiceeTCertificatoreDao siceeTCertificatoreDao;

	public SiceeTCertificatoreDao getSiceeTCertificatoreDao() {
		return this.siceeTCertificatoreDao;
	}

	public void setSiceeTCertificatoreDao(SiceeTCertificatoreDao siceeTCertificatoreDao) {
		this.siceeTCertificatoreDao = siceeTCertificatoreDao;
	}
	
	private SiceeTCertificatoDao siceeTCertificatoDao;
	public SiceeTCertificatoDao getSiceeTCertificatoDao() {
		return this.siceeTCertificatoDao;
	}
	public void setSiceeTCertificatoDao(
			SiceeTCertificatoDao siceeTCertificatoDao) {
		this.siceeTCertificatoDao = siceeTCertificatoDao;
	}

	private SiceeTActaDao siceeTActaDao;

	public SiceeTActaDao getSiceeTActaDao() {
		return this.siceeTActaDao;
	}

	public void setSiceeTActaDao(SiceeTActaDao siceeTActaDao) {
		this.siceeTActaDao = siceeTActaDao;
	}

	private SiceeTParametriActaDao siceeTParametriActaDao;

	public SiceeTParametriActaDao getSiceeTParametriActaDao() {
		return this.siceeTParametriActaDao;
	}

	public void setSiceeTParametriActaDao(SiceeTParametriActaDao siceeTParametriActaDao) {
		this.siceeTParametriActaDao = siceeTParametriActaDao;
	}


	public ResocontoTransMdp findResocontoTransazioniMdp()
			throws BEException {
		ResocontoTransMdp res = new ResocontoTransMdp();
		try {
			
			String dataOdierna = GenericUtil.getDataOdierna();
			String dataCreazioneAl = null;
			String dataCreazioneDal = null;
			log.debug("getDataOdierna: "+dataOdierna);

			dataCreazioneAl = GenericUtil.removeOneDay(dataOdierna);
			log.debug("dataCreazioneAl: "+dataCreazioneAl);
			dataCreazioneDal = GenericUtil.removeOneYear(dataCreazioneAl);
			log.debug("dataCreazioneDal: "+dataCreazioneDal);
		
			res.setDataCreazioneDal(dataCreazioneDal);
			res.setDataCreazioneAl(dataCreazioneAl);
			
			// Ricerco i totali
			int totale = this.getOptimizedSiceeTTransazione2018Dao().findCountTransazioniByStato(dataCreazioneDal, dataCreazioneAl, 
					Constants.ID_STATO_TRANS_MDP_NEW_FALLITO);
			
			res.setTotFalliti(GenericUtil.convertToString(totale));

			totale = this.getOptimizedSiceeTTransazione2018Dao().findCountTransazioniByStato(dataCreazioneDal, dataCreazioneAl, 
					Constants.ID_STATO_TRANS_MDP_NEW_ANNULLATO);
			
			res.setTotAnnullati(GenericUtil.convertToString(totale));

			totale = this.getOptimizedSiceeTTransazione2018Dao().findCountTransazioniByStato(dataCreazioneDal, dataCreazioneAl, 
					Constants.ID_STATO_TRANS_MDP_NEW_PAGAMENTO_KO);
			
			res.setTotPagamentiKo(GenericUtil.convertToString(totale));

			totale = this.getOptimizedSiceeTTransazione2018Dao().findCountTransazioniByStato(dataCreazioneDal, dataCreazioneAl, 
					Constants.ID_STATO_TRANS_MDP_NEW_PAGAMENTO_KO_AUTO);
			
			res.setTotPagamentiKoAuto(GenericUtil.convertToString(totale));

			totale = this.getOptimizedSiceeTTransazione2018Dao().findCountTransazioniByStato(dataCreazioneDal, dataCreazioneAl, 
					Constants.ID_STATO_TRANS_MDP_NEW_PAGAMENTO_OK);
			
			res.setTotPagamentiOk(GenericUtil.convertToString(totale));

			Float totaleValore = this.getOptimizedSiceeTTransazione2018Dao().findCountValoreTransazioniPagamentoOk(dataCreazioneDal, dataCreazioneAl);
			
			res.setTotImportoPagamentiOk(totaleValore);

		} catch (OptimizedSiceeTTransazione2018DaoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (Exception e) {
			throw new BEException(e.getMessage(), e);
		} 
		
		GenericUtil.stampa(res, true, 3);

		return res;
	}
	
	public ArrayList<DettaglioTransAttEsito> findDettaglioTransAttEsito(FiltroDettaglioTransAttEsito filtro)throws BEException{
		ArrayList<DettaglioTransAttEsito> attEsitoList = new ArrayList<DettaglioTransAttEsito>();
		try {
			List<OptimizedSiceeTTransazione2018> dtoList = this.getOptimizedSiceeTTransazione2018Dao().findDettTransazioniAttesaEsito(filtro);

			DettaglioTransAttEsito attEsito = null; 
			for (OptimizedSiceeTTransazione2018 dto : dtoList) {
				attEsito = mapFromDettaglioTransAttEsito(dto);
				
				GenericUtil.stampa(attEsito, true, 3);
				
				attEsitoList.add(attEsito);
			}

			return attEsitoList;
		} catch (OptimizedSiceeTTransazione2018DaoException e) {
			throw new BEException("Erorre nella lettura dell'elenco delle transazioni in attesa di esito", e);
		}
		
	}
	
	public void annullaTranazioniUnsuccessfull()throws BEException{
		try {
			this.getSiceeTTransazione2018Dao().annullaTranazioniUnsuccessfull();

		} catch (SiceeTTransazione2018DaoException e) {
			throw new BEException("Erorre nell'annulla transazioni unsuccessfull", e);
		}
		
	}
	
	
	public String[] aggiornaTransEsito(ArrayList<String> idTransazioniSel, ArrayList<DettaglioTransAttEsito> attEsitoList) throws BEException {
		
		String[] resultErrorList = null;
		try {
			
			log.debug("aggiornaTransEsito - PASSO 1");

			ArrayList<String> elencoTrans = new ArrayList<String>();
			
			for (String idTransazione : idTransazioniSel) {
				
				for (DettaglioTransAttEsito attEsito : attEsitoList) {
					
					log.debug("aggiornaTransEsito - PASSO 2: "+attEsito);

					
					log.debug("aggiornaTransEsito - PASSO 3: "+attEsito.getIdTransazioneMdp());

					if (idTransazione.equals(attEsito.getIdTransazione()) && !GenericUtil.isNullOrEmpty(attEsito.getIdTransazioneMdp()))
					{
						elencoTrans.add(attEsito.getIdTransazioneMdp());
						break;
					}
				}
			}
			
			
			
			log.debug("aggiornaTransEsito - PASSO 4: "+elencoTrans);
			// TEST DA ELIMINARE
//			elencoTrans.clear();
//			elencoTrans.add("TST000000000043215");
			
			resultErrorList = getSoaIntegrationMgr().getStatoTransazioneMdp(elencoTrans);
			
			log.debug("aggiornaTransEsito - PASSO 5: "+resultErrorList);

			
		}catch (BEException e) {
			
			log.error(e);
			throw e;
		}
		catch (Throwable t)
		{
			log.error(t);

			new BEException("Prova eccezione", null);
		}
		return resultErrorList;
	}
	
	public String[] recuperaRT(ArrayList<String> idTransazioniSel, ArrayList<DettaglioTransAttEsito> attEsitoList) throws BEException {

		String[] resultErrorList;
		try {

			ArrayList<String> elencoTrans = new ArrayList<String>();

			for (String idTransazione : idTransazioniSel) {

				for (DettaglioTransAttEsito attEsito : attEsitoList) {

					if (idTransazione.equals(attEsito.getIdTransazione()) && !GenericUtil.isNullOrEmpty(attEsito.getIdTransazioneMdp()))
					{
						elencoTrans.add(attEsito.getIdTransazioneMdp());
						break;
					}
				}
			}

			resultErrorList = getSoaIntegrationMgr().getRecuperaRT(elencoTrans);

		}catch (BEException e) {
			throw e;
		}

		return resultErrorList;
	}

	private DettaglioTransAttEsito mapFromDettaglioTransAttEsito(OptimizedSiceeTTransazione2018 dto) {
		DettaglioTransAttEsito attEsito = new DettaglioTransAttEsito();
		
		attEsito.setIdTransazione(GenericUtil.convertToString(dto.getIdTransazione2018()));
		attEsito.setIdTransazioneMdp(dto.getS1IdTransazioneMdp());
		attEsito.setDtCreazioneTrans(GenericUtil.convertToStringDataCompleta(dto.getS1DtCreazioneTransazione()));
		attEsito.setIdStatoTrans(dto.getFkStatoTrans2018());
		attEsito.setDescStatoTrans(dto.getDescrStatoTrans2018());
		//attEsito.setRagSocialePSP(dto.getS2RagSocialePsp());
		attEsito.setImporto(GenericUtil.convertToFloat(dto.getS1ValoreTransazione()));
		attEsito.setIdIuv(dto.getS3IdIuv());
		attEsito.setDtCreazioneTrans(GenericUtil.convertToStringDataCompleta(dto.getS1DtCreazioneTransazione()));
		attEsito.setIdStatoTransMdp(GenericUtil.convertToString(dto.getOpGetstatotransFkStato()));
		attEsito.setDescStatoTransMdp(dto.getDescrStatoTransMdp());
		attEsito.setDtStatoTransMdp(GenericUtil.convertToStringDataCompleta(dto.getOpGetstatotransDt()));

		return attEsito;
	}
	
	
	public ArrayList<VerificaIndex> findDettaglioIndex(FiltroRicercaAce filtro)throws BEException{
		ArrayList<VerificaIndex> attEsitoList = new ArrayList<VerificaIndex>();
		try {
			
			String idCertificatore = null;
			SiceeTCertificatore cert = getSiceeTCertificatoreDao().findWhereNumCertificatoreEquals(filtro.getCertificatore());

			if (cert != null) {
				idCertificatore = cert.getIdCertificatore();
			}

			List<SiceeTRifIndex2015> rifIndexList = this.getSiceeTRifIndex2015Dao().findBySiceeTCertificato(idCertificatore, filtro.getProgCertificato(), filtro.getAnnoCertificato());
			
			List<SiceeTFoto2015> fotoList = this.getSiceeTFoto2015Dao().findBySiceeTCertificato(idCertificatore, filtro.getProgCertificato(), filtro.getAnnoCertificato());

			List<SiceeDTipoDocIndex2015> tipoDocList = this.getSiceeDTipoDocIndex2015Dao().findAll();
			
			
			VerificaIndex attEsito = null; 
			//String presente = null;
			boolean isPresente = false;
			Documento doc = null;
			
			// Mappo i SiceeTRifIndex2015
			for (SiceeTRifIndex2015 dto : rifIndexList) {
				attEsito = mapFromVerificaIndex(dto, tipoDocList);
				isPresente = false;
				try
				{
					doc = getSoaIntegrationMgr().recuperaDocumento(attEsito.getUidIndex());
					if (doc != null)
					{
						isPresente = true;
					}
				}
				catch (Exception e)
				{
					// Stampo l'eccezione ma non la rilancio
					log.error("Ho cercato, ma NON ho trovato l'uid index: "+attEsito.getUidIndex());
					log.error(e);
				}
				
				attEsito.setEsito(isPresente);
				attEsito.setDescEsito(isPresente?Constants.PRESENTE:Constants.NON_PRESENTE);
				
				GenericUtil.stampa(attEsito, true, 3);
				
				attEsitoList.add(attEsito);
			}
			
			// Mappo i SiceeTRifIndex2015
			for (SiceeTFoto2015 dto : fotoList) {
				attEsito = mapFromVerificaIndex(dto);
				isPresente = false;
				try
				{
					doc = getSoaIntegrationMgr().recuperaDocumento(attEsito.getUidIndex());
					
					log.debug("Stampo il doc: "+doc);
					GenericUtil.stampa(doc, true, 3);
					log.debug("Stampo isPresente - prima: "+isPresente);

					if (doc != null)
					{
						isPresente = true;
					}
					log.debug("Stampo isPresente - dopo: "+isPresente);
				}
				catch (Exception e)
				{
					// Stampo l'eccezione ma non la rilancio
					log.error("Ho cercato, ma NON ho trovato l'uid index: "+attEsito.getUidIndex());
					log.error(e);
				}
				
				attEsito.setEsito(isPresente);
				attEsito.setDescEsito(isPresente?Constants.PRESENTE:Constants.NON_PRESENTE);
				
				GenericUtil.stampa(attEsito, true, 3);
				
				attEsitoList.add(attEsito);
			}
			
			return attEsitoList;
		} 
		catch (SiceeTCertificatoreDaoException e) {
			throw new BEException("Erorre nella lettura della SiceeTCertificatoreDaoException", e);
		} catch (SiceeTRifIndex2015DaoException e) {
			throw new BEException("Erorre nella lettura della SiceeTRifIndex2015", e);
		} catch (SiceeTFoto2015DaoException e) {
			throw new BEException("Erorre nella lettura della SiceeTFoto2015DaoException", e);
		} catch (SiceeDTipoDocIndex2015DaoException e) {
			throw new BEException("Erorre nella lettura della SiceeDTipoDocIndex2015DaoException", e);
		}
		
	}

	private VerificaIndex mapFromVerificaIndex(SiceeTRifIndex2015 dto, List<SiceeDTipoDocIndex2015> tipoDocList) {
		VerificaIndex attEsito = new VerificaIndex();
		
		for (SiceeDTipoDocIndex2015 siceeDTipoDocIndex2015 : tipoDocList) {
			if (dto.getFkTipoDoc().intValue() == siceeDTipoDocIndex2015.getIdTipoDoc().intValue())
			{
				attEsito.setDescTipoDoc(siceeDTipoDocIndex2015.getDescr());
				break;
			}
		}
		
		attEsito.setUidIndex(dto.getUidIndex());
		attEsito.setNomeDoc(dto.getNomeFile());
		attEsito.setDataCaricamento(GenericUtil.convertToStringDataCompleta(dto.getDtCaricamento()));

		
		
		return attEsito;
	}
	
	private VerificaIndex mapFromVerificaIndex(SiceeTFoto2015 dto) {
		VerificaIndex attEsito = new VerificaIndex();
		
		String principale = "Foto principale: ";
		
		if (dto.getFlgPrincipale() != null)
		{
			principale += dto.getFlgPrincipale().equalsIgnoreCase(Constants.SI)?Constants.LABEL_SI:Constants.LABEL_NO;
		}
		
		attEsito.setDescTipoDoc(principale);
		attEsito.setUidIndex(dto.getIdentificFoto());
		attEsito.setNomeDoc(dto.getNomeFoto());
		attEsito.setDataCaricamento(GenericUtil.convertToStringDataCompleta(dto.getDtFoto()));
		
		return attEsito;
	}
	
	private VerificaActa mapFromVerificaActa(SiceeTActa dto) {
		VerificaActa acta = null;
		
		if (dto != null)
		{
			acta = new VerificaActa();
			
			acta.setIdCertificatore(dto.getIdCertificatore());
			acta.setProgrCertificato(dto.getProgrCertificato());
			acta.setAnno(dto.getAnno());
			acta.setNumeroProtocollo(dto.getNumeroProtocollo());
			acta.setIdProtocollo(dto.getIdProtocolloActa());
			
		}
		
		return acta;
	}
	
	
	public String restoreFile(String uid) throws BEException{
		
		String uidRet = null;
		try {
			
			uidRet = getSoaIntegrationMgr().restoreFile(uid);

			return uidRet;
		} catch (Exception e) {
			throw new BEException("Erorre nel restore dell'UID", e);
		} 
	}
	
	public void annullaAttestatiScaduti()
			throws BEException {
		try {
			
			List<SiceeTCertificato> certList = this.getSiceeTCertificatoDao()
					.findWhereScaduti();
			
			for (SiceeTCertificato siceeTCertificato : certList) {
				
				if (log.isDebugEnabled())
					GenericUtil.stampa(siceeTCertificato, true, 3);
				
				try
				{
					
					getCertificatoMgr().annullaAttestatoScadutoTrans(siceeTCertificato);
				}
				catch (BEException e)
				{
					String codiceTemp = siceeTCertificato.getAnno() + " " + siceeTCertificato.getIdCertificatore() + " " + siceeTCertificato.getProgrCertificato();

					getMiscMgr().sendMailNotificaEccezioneAnnullamento(codiceTemp, e);
				}
			}
			
		} 
		catch (Exception e) {
			log.error("Erroe Exception", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	public ArrayList<VerificaActa> findProtocollazioniAnomale() throws BEException{
		ArrayList<VerificaActa> attEsitoList = new ArrayList<VerificaActa>();
		try {
			
			 List<SiceeTActa> acta = getSiceeTActaDao().findProtocolloAnomalo();

			 if (acta != null && acta.size() > 0)
			 {
				 
				 for (SiceeTActa siceeTActa : acta) {
					 attEsitoList.add(mapFromVerificaActa(siceeTActa));	
				}
				 
			 }
				 
			 
			return attEsitoList;
		} 
		catch (SiceeTActaDaoException e) {
			throw new BEException("Erorre nella lettura della SiceeTActaDaoException", e);
		} 
		
	}
	
	public boolean isRisanamentoProtPossibile() throws BEException{
		boolean isRisanabile = false;
		try {
			
			 List<SiceeTParametriActa> paramList = getSiceeTParametriActaDao().findWhereCodiceEquals(Constants.COD_DATA_ELABORAZIONE);

			 if (paramList != null && paramList.size() > 0)
			 {
				 SiceeTParametriActa param = paramList.get(0); // per un codice c'è solo una riga
				 
				 if (isNullOrEmpty(param.getValore()))
				 {
					 isRisanabile = true; 
				 }
				 
			 }
				 
			return isRisanabile;
		} 
		catch (SiceeTParametriActaDaoException e) {
			throw new BEException("Erorre nella lettura della SiceeTParametriActaDaoException", e);
		} 
		
	}
	
	
	public void risanaProtAnomali() throws BEException{
		try {
			
			 getSiceeTActaDao().updateRisanaProtAnomali();

		} 
		catch (SiceeTActaDaoException e) {
			throw new BEException("Erorre nella lettura della SiceeTActaDaoException", e);
		} 
		
	}
}
