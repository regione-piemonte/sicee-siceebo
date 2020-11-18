/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceebo.business.facade;


import it.csi.sicee.siceebo.business.BEException;
import it.csi.sicee.siceebo.business.dao.dao.OptimizedFindCertificatoriDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDClasseEnergeticaDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDDestUso2015Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDDestUsoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDMotivoRilascioDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDStatoCertDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeLRicercheCtuDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTExportBoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDDestUso;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDMotivoRilascio;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDStatoCert;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLRicercheCtu;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatoPk;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBo;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBoPk;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDClasseEnergeticaDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDDestUso2015DaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDDestUsoDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDMotivoRilascioDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTCertificatoDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTExportBoDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTParametriDaoException;
import it.csi.sicee.siceebo.business.facade.exceptions.ServiceException;
import it.csi.sicee.siceebo.dto.LabelValue;
import it.csi.sicee.siceebo.dto.ace.Ace;
import it.csi.sicee.siceebo.dto.ace.FiltroRicercaAce;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;
import it.csi.sicee.siceeweb.xml.attestato.data.MODDocument;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * Facade di gestione dell'entita' Ace.
 *
 * @author 869
 */
public class AceMgr extends BaseMgr {

	
	/** The sicee t export bo dao. */
	private SiceeTExportBoDao siceeTExportBoDao;
	
	/**
	 * Gets the sicee t export bo dao.
	 *
	 * @return the sicee t export bo dao
	 */
	public SiceeTExportBoDao getSiceeTExportBoDao() {
		return this.siceeTExportBoDao;
	}
	
	/**
	 * Sets the sicee t export bo dao.
	 *
	 * @param siceeTExportBoDao the new sicee t export bo dao
	 */
	public void setSiceeTExportBoDao(
			SiceeTExportBoDao siceeTExportBoDao) {
		this.siceeTExportBoDao = siceeTExportBoDao;
	}

	/** The sicee t parametri dao. */
	private SiceeTParametriDao siceeTParametriDao;

	/**
	 * Gets the sicee t parametri dao.
	 *
	 * @return the sicee t parametri dao
	 */
	public SiceeTParametriDao getSiceeTParametriDao() {
		return this.siceeTParametriDao;
	}

	/**
	 * Sets the sicee t parametri dao.
	 *
	 * @param siceeTParametriDao the new sicee t parametri dao
	 */
	public void setSiceeTParametriDao(SiceeTParametriDao siceeTParametriDao) {
		this.siceeTParametriDao = siceeTParametriDao;
	}

/*
	private SiceeTCertificatoreDao siceeTCertificatoreDao;
	
	public SiceeTCertificatoreDao getSiceeTCertificatoreDao() {
		return siceeTCertificatoreDao;
	}
	public void setSiceeTCertificatoreDao(
			SiceeTCertificatoreDao siceeTCertificatoreDao) {
		this.siceeTCertificatoreDao = siceeTCertificatoreDao;
	}
*/
	/*
	private SiceeTAziendaDao siceeTAziendaDao;
	
	public SiceeTAziendaDao getSiceeTAziendaDao() {
		return siceeTAziendaDao;
	}
	public void setSiceeTAziendaDao(
			SiceeTAziendaDao siceeTAziendaDao) {
		this.siceeTAziendaDao = siceeTAziendaDao;
	}
*/
	/** The sicee d motivo rilascio dao. */
private SiceeDMotivoRilascioDao siceeDMotivoRilascioDao;

	/**
	 * Gets the sicee d motivo rilascio dao.
	 *
	 * @return the sicee d motivo rilascio dao
	 */
	public SiceeDMotivoRilascioDao getSiceeDMotivoRilascioDao() {
		return this.siceeDMotivoRilascioDao;
	}
	
	/**
	 * Sets the sicee d motivo rilascio dao.
	 *
	 * @param siceeDMotivoRilascioDao the new sicee d motivo rilascio dao
	 */
	public void setSiceeDMotivoRilascioDao(
			SiceeDMotivoRilascioDao siceeDMotivoRilascioDao) {
		this.siceeDMotivoRilascioDao = siceeDMotivoRilascioDao;
	}

	/** The optimized find certificatori dao. */
	private OptimizedFindCertificatoriDao optimizedFindCertificatoriDao;

	/**
	 * Gets the optimized find certificatori dao.
	 *
	 * @return the optimized find certificatori dao
	 */
	public OptimizedFindCertificatoriDao getOptimizedFindCertificatoriDao() {
		return this.optimizedFindCertificatoriDao;
	}
	
	/**
	 * Sets the optimized find certificatori dao.
	 *
	 * @param optimizedFindCertificatoriDao the new optimized find certificatori dao
	 */
	public void setOptimizedFindCertificatoriDao(
			OptimizedFindCertificatoriDao optimizedFindCertificatoriDao) {
		this.optimizedFindCertificatoriDao = optimizedFindCertificatoriDao;
	}

	/** The sicee d classe energetica dao. */
	private SiceeDClasseEnergeticaDao siceeDClasseEnergeticaDao;

	/**
	 * Gets the sicee d classe energetica dao.
	 *
	 * @return the sicee d classe energetica dao
	 */
	public SiceeDClasseEnergeticaDao getSiceeDClasseEnergeticaDao() {
		return this.siceeDClasseEnergeticaDao;
	}
	
	/**
	 * Sets the sicee d classe energetica dao.
	 *
	 * @param siceeDClasseEnergeticaDao the new sicee d classe energetica dao
	 */
	public void setSiceeDClasseEnergeticaDao(
			SiceeDClasseEnergeticaDao siceeDClasseEnergeticaDao) {
		this.siceeDClasseEnergeticaDao = siceeDClasseEnergeticaDao;
	}

	/** The sicee d dest uso dao. */
	private SiceeDDestUsoDao siceeDDestUsoDao;

	/**
	 * Gets the sicee d dest uso dao.
	 *
	 * @return the sicee d dest uso dao
	 */
	public SiceeDDestUsoDao getSiceeDDestUsoDao() {
		return this.siceeDDestUsoDao;
	}
	
	/**
	 * Sets the sicee d dest uso 2015 dao.
	 *
	 * @param siceeDDestUsoDao the new sicee d dest 2015 uso dao
	 */
	public void setSiceeDDestUso2015Dao(
			SiceeDDestUso2015Dao siceeDDestUso2015Dao) {
		this.siceeDDestUso2015Dao = siceeDDestUso2015Dao;
	}

	
	/** The sicee t certificato dao. */
	private SiceeTCertificatoDao siceeTCertificatoDao;

	/**
	 * Gets the sicee t certificato dao.
	 *
	 * @return the sicee t certificato dao
	 */
	public SiceeTCertificatoDao getSiceeTCertificatoDao() {
		return this.siceeTCertificatoDao;
	}
	
	/**
	 * Sets the sicee t certificato dao.
	 *
	 * @param siceeTCertificatoDao the new sicee t certificato dao
	 */
	public void setSiceeTCertificatoDao(
			SiceeTCertificatoDao siceeTCertificatoDao) {
		this.siceeTCertificatoDao = siceeTCertificatoDao;
	}
	
	
	/** The certificatore mgr. */
	private CertificatoreMgr certificatoreMgr;

	/**
	 * Gets the certificatore mgr.
	 *
	 * @return the certificatore mgr
	 */
	public CertificatoreMgr getCertificatoreMgr() {
		return this.certificatoreMgr;
	}

	/**
	 * Sets the certificatore mgr.
	 *
	 * @param certificatoreMgr the new certificatore mgr
	 */
	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	/** The sicee d dest uso 2015 dao. */
	private SiceeDDestUso2015Dao siceeDDestUso2015Dao;

	/**
	 * Gets the sicee d dest uso 2015 dao.
	 *
	 * @return the sicee d dest uso 2015 dao
	 */
	public SiceeDDestUso2015Dao getSiceeDDestUso2015Dao() {
		return this.siceeDDestUso2015Dao;
	}
	
	/**
	 * Sets the sicee d dest uso dao.
	 *
	 * @param siceeDDestUsoDao the new sicee d dest uso dao
	 */
	public void setSiceeDDestUsoDao(
			SiceeDDestUsoDao siceeDDestUsoDao) {
		this.siceeDDestUsoDao = siceeDDestUsoDao;
	}

	private SiceeLRicercheCtuDao siceeLRicercheCtuDao;
	public SiceeLRicercheCtuDao getSiceeLRicercheCtuDao() {
		return this.siceeLRicercheCtuDao;
	}
	public void setSiceeLRicercheCtuDao(
			SiceeLRicercheCtuDao siceeLRicercheCtuDao) {
		this.siceeLRicercheCtuDao = siceeLRicercheCtuDao;
	}
		
	public void inserisciSiceeLRicercheCtu(String cfCtu, Date dataRicerca, String motivazioneCtu) throws BEException {

		
		log.debug("CF CTU: " + cfCtu);
		log.debug("Data Ricerca: " + dataRicerca);
		log.debug("Motivazione CTU: " + motivazioneCtu);
		SiceeLRicercheCtu vo = new SiceeLRicercheCtu();
		vo.setCfCtu(cfCtu);
		vo.setDataRicerca(dataRicerca);
		vo.setMotivazioneCtu(motivazioneCtu);

		try {
			this.getSiceeLRicercheCtuDao().insert(vo);
		} catch (Exception e) {
			log.error("Errore in inserisciSiceeLRicercheCtu", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	/**
	 * Map from db motivazione rilascio.
	 *
	 * @param dto the dto
	 * @return the label value
	 */
	public LabelValue mapFromDBMotivazioneRilascio(SiceeDMotivoRilascio dto){
		LabelValue ris = new LabelValue();
		ris.setValue(convertToString(dto.getIdMotivo()));
		ris.setLabel(dto.getDescr());
		return ris;
	}

	/**
	 * Map from db classe energetica.
	 *
	 * @param dto the dto
	 * @return the label value
	 */
	public LabelValue mapFromDBClasseEnergetica(SiceeDClasseEnergetica dto){
		LabelValue ris = new LabelValue();
		ris.setValue(convertToString(dto.getIdClasse()));
		ris.setLabel(dto.getDescr());
		return ris;
	}

	/**
	 * Map from db destinazione uso.
	 *
	 * @param dto the dto
	 * @return the label value
	 */
	public LabelValue mapFromDBDestinazioneUso(SiceeDDestUso dto){
		LabelValue ris = new LabelValue();
		ris.setValue(dto.getSigla());
		ris.setLabel(dto.getSigla());
		return ris;
	}
	
	/**
	 * Map from db destinazione uso 2015.
	 *
	 * @param dto the dto
	 * @return the label value
	 */
	public LabelValue mapFromDBDestinazioneUso2015(SiceeDDestUso2015 dto){
		LabelValue ris = new LabelValue();
		ris.setValue(dto.getSigla());
		ris.setLabel(dto.getSigla() + " - " + dto.getDescr());
		return ris;
	}
	
	/**
	 * Map from dbo ace.
	 *
	 * @param dto the dto
	 * @return the ace
	 */
	public Ace mapFromDBOAce(SiceeTExportBo dto){
		Ace ris = new Ace();
		
		ris.setIdCertificatore(dto.getIdCertificatore());
		
		
		ris.setProgrCertificato(dto.getProgrCertificato());
		ris.setAnno(dto.getAnno());
		ris.setNumCertificatore(dto.getNumCertificatore());

		String nomeCognome = "";
		
		if (dto.getNome() != null)
		{
			nomeCognome += dto.getNome();
		}

		if (dto.getCognome() != null)
		{
			nomeCognome += " " + dto.getCognome();
		}

		ris.setNomeCognomeCert(nomeCognome);
		
		ris.setDtInizio(convertToString(dto.getDtInizio()));
		ris.setDtUpload(convertToString(dto.getDtUpload()));
		ris.setDtScadenza(convertToString(dto.getDtScadenza()));
		ris.setDescProv(dto.getDescProv());
		ris.setDescComune(dto.getDescComune());
		ris.setGradiGiorno(dto.getGradiGiorno());
		ris.setPiano(dto.getPiano());
		ris.setNumPianiComplessivi(dto.getNumPianiComplessivi());
		ris.setDescStato(dto.getDescStato());
		ris.setIdStato(dto.getFkStato());
		ris.setDescDestUso(dto.getDescDestUso());
		ris.setDescTipoEdificio(dto.getDescTipoEdificio());
		ris.setDescEdificio(dto.getDescEdificio());
		ris.setDescClasse(dto.getDescClasse());
		ris.setDescClasse19205(dto.getDescClasse192_05());
		ris.setAnnoCostruzione(dto.getAnnoCostruzione());
		ris.setAnnoUltRist(dto.getAnnoUltRist());
		ris.setVolLordoRiscaldato(convertToDoubleFour(dto.getVolLordoRiscaldato()));
		ris.setSupDisperdenteTot(convertToDoubleFour(dto.getSupDisperdenteTot()));
		ris.setSu(convertToDoubleFour(dto.getSu()));
		ris.setVSu(convertToDoubleFour(dto.getvSu()));
		ris.setTrasmOpache(convertToDoubleFour(dto.getTrasmOpache()));
		ris.setTrasmTrasp(convertToDoubleFour(dto.getTrasmTrasp()));
		
		ris.setDescTipoImpianto(dto.getDescTipoImpianto());
		ris.setDescCombustibileRisc(dto.getDescCombRisc());
		ris.setDescCombustibileAcs(dto.getDescCombAsc());
		
		ris.setFattoreForma(convertToDoubleFour(dto.getFattoreForma()));
		ris.setDomRiscQh(convertToDoubleFour(dto.getDomRiscQh()));
		ris.setDomRiscQhto(convertToDoubleFour(dto.getDomRiscQhto()));
		ris.setIndRiscEpi(convertToDoubleFour(dto.getIndRiscEpi()));
		ris.setIndRiscEpito(convertToDoubleFour(dto.getIndRiscEpito()));
		
		ris.setFabbAcs(convertToDoubleFour(dto.getFabbAcs()));
		
		ris.setValorePrestPdc(convertToDoubleFour(dto.getValorePrestPdc()));
		ris.setRendAcsEtagacs(convertToDoubleFive(dto.getRendAcsEtagacs()));
		ris.setDomAcsQhw(convertToDoubleFour(dto.getDomAcsQhw()));
		ris.setEnAcsRinno(convertToDoubleFour(dto.getEnAcsRinno()));
		ris.setRendImpEtag(convertToDoubleFour(dto.getRendImpEtag()));
		ris.setDomAcsQhwSu(convertToDoubleFour(dto.getDomAcsQhwSu()));
		ris.setIndGlobEplordo(convertToDoubleFour(dto.getIndGlobEplordo()));
		ris.setIndGlobEplordoTo(convertToDoubleFour(dto.getIndGlobEplordoTo()));
		ris.setDomAcsQhwto(convertToDoubleFour(dto.getDomAcsQhwto()));
		ris.setDescMotivo(dto.getDescMotivo());
		ris.setMetodologiaCalcolo(dto.getMetodologiaCalcolo());
		ris.setSwUtilizzato(dto.getSwUtilizzato());
		ris.setDescIndirizzo(dto.getDescIndirizzo());
		ris.setNumCivico(dto.getNumCivico());
		ris.setSezione(dto.getSezione());
		ris.setFoglio(dto.getFoglio());
		ris.setParticella(dto.getParticella());
		ris.setSubalterno(dto.getSubalterno());
	
		ris.setPrestazioneEne(convertToDoubleFour(dto.getPrestazioneEne()));
		ris.setNumAppartamenti(dto.getNumAppartamenti());
		ris.setUiServite(dto.getUiServite());
		ris.setPotRiscaldamento(convertToDoubleFour(dto.getPotRiscaldamento()));
		ris.setDescClasseEffRisc(dto.getDescClasseEff());
		ris.setGenAnnoRisc(dto.getGenAnnoRisc());
		
		String flgContRip = "";
		
		if (dto.getFlgContRip() != null && dto.getFlgContRip().equalsIgnoreCase(Constants.FLG_S))
		{
			flgContRip = Constants.LABEL_SI;
		}
		else if (dto.getFlgContRip() != null && dto.getFlgContRip().equalsIgnoreCase(Constants.FLG_N))
		{
			flgContRip = Constants.LABEL_NO;
		}
		
		ris.setFlgContRip(flgContRip);
		
		ris.setRendGener(convertToDoubleFour(dto.getRendGener()));
		ris.setRendRegol(convertToDoubleFour(dto.getRendRegol()));
		ris.setRendEmiss(convertToDoubleFour(dto.getRendEmiss()));
		ris.setRendDistrib(convertToDoubleFour(dto.getRendDistrib()));
		
		
		
		String flgOld = "";
		
		if (dto.getFlgOld() != null && dto.getFlgOld().equalsIgnoreCase(Constants.FLG_S))
		{
			flgOld = Constants.LABEL_SI;
		}
		else if (dto.getFlgOld() != null && dto.getFlgOld().equalsIgnoreCase(Constants.FLG_N))
		{
			flgOld = Constants.LABEL_NO;
		}
		
		ris.setFlgOld(flgOld);
		
		
		String flgEdifE0 = "";
		
		if (dto.getFlgEdifE0() != null && dto.getFlgEdifE0().equalsIgnoreCase(Constants.FLG_S))
		{
			flgEdifE0 = Constants.LABEL_SI;
		}
		else if (dto.getFlgEdifE0() != null && dto.getFlgEdifE0().equalsIgnoreCase(Constants.FLG_N))
		{
			flgEdifE0 = Constants.LABEL_NO;
		}
		
		ris.setFlgEdifE0(flgEdifE0);
		
		ris.setEpglNrenGlobale(convertToDoubleFour(dto.getEpglNrenGlobale()));
		ris.setEpglRenGlobale(convertToDoubleFour(dto.getEpglRenGlobale()));
		ris.setEmissioniCo2(convertToDoubleFour(dto.getEmissioniCo2()));
		ris.setSupRaffrescata(convertToDoubleFour(dto.getSupRaffrescata()));
		ris.setSupRiscaldata(convertToDoubleFour(dto.getSupRiscaldata()));
		ris.setVolLordoRaffrescato(convertToDoubleFour(dto.getVolLordoRaffrescato()));
		ris.setVolLordoRiscaldato(convertToDoubleFour(dto.getVolLordoRiscaldato()));
		ris.setEph(convertToDoubleFour(dto.getEph()));
		ris.setAsolAsup(convertToDoubleFour(dto.getAsolAsup()));
		ris.setYie(convertToDoubleFour(dto.getYie()));
		ris.setVSuRaff(convertToDoubleFour(dto.getVSuRaff()));
		ris.setVSuRisc(convertToDoubleFour(dto.getVSuRisc()));
		ris.setSVRaff(convertToDoubleFour(dto.getSVRaff()));
		ris.setSVRisc(convertToDoubleFour(dto.getSVRisc()));
		
		return ris;
	}
	
	/**
	 * Map from certificato ace.
	 *
	 * @param dto the dto
	 * @return the ace
	 */
	public Ace mapFromCertificatoAce(SiceeTCertificato dto){
		Ace ris = new Ace();
		
		ris.setIdCertificatore(dto.getIdCertificatore());
		
		
		ris.setProgrCertificato(dto.getProgrCertificato());
		ris.setAnno(dto.getAnno());
		ris.setNumCertificatore(dto.getIdCertificatore());
		
		try {
			SiceeTCertificatore certificatore = getCertificatoreMgr().getSiceeTCertificatoreDao().findByPrimaryKey(dto.getIdCertificatore());
			if (certificatore != null) {
				ris.setNomeCognomeCert(certificatore.getNome() + " " + certificatore.getCognome()); 
			}
		}
		catch (Exception e) {
			log.error("Errore nella ricerca del certificatore", e);
		}
		
		ris.setDtInizio(convertToString(dto.getDtInizio()));
		ris.setDtUpload(convertToString(dto.getDtUpload()));
		ris.setDescProv(dto.getDescProv());
		ris.setDescComune(dto.getDescComune());
		ris.setPiano(dto.getPiano());
		ris.setNumPianiComplessivi(dto.getNumPianiComplessivi());
		ris.setIdStato(dto.getFkStato());
		ris.setDescIndirizzo(dto.getDescIndirizzo());
		ris.setNumCivico(dto.getNumCivico());
		ris.setSezione(dto.getSezione());
		ris.setFoglio(dto.getFoglio());
		ris.setParticella(dto.getParticella());
		ris.setSubalterno(dto.getSubalterno());
		ris.setNumAppartamenti(dto.getNumAppartamenti());
		
		return ris;
	}
	
	/**
	 * Find elenco ace by codice.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public ArrayList<Ace> findElencoAceByCodice(FiltroRicercaAce filtro) throws BEException {
		ArrayList<Ace> ace = new ArrayList<Ace>();
		try {

			SiceeTParametri param = getSiceeTParametriDao().findByPrimaryKey(Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MINIMO_ID_CERTIFICATORE))
			{

				// Questa ricerca mi serve per capire come comporre la query 
				String codiceTemp = filtro.getAnnoCertificato() + " " + filtro.getCertificatore() + " " + filtro.getProgCertificato();
				boolean isOld = isAttestatoOld(codiceTemp);
				filtro.setFlgIsOld(isOld);
				
				List<SiceeTExportBo> temp = 
					getSiceeTExportBoDao().findElencoAceByCodice(filtro, new Long(param.getValore()));

				Iterator<SiceeTExportBo> it = temp.iterator();
				while (it.hasNext()) {
					SiceeTExportBo findAce = it.next();
					Ace curr = mapFromDBOAce(findAce);


					String codice = curr.getAnno() + " " + curr.getNumCertificatore() + " " + curr.getProgrCertificato();
					curr.setCodice(codice);

					//String codAttestato = curr.getAnno() + " " + curr.getIdCertificatore() + " " + curr.getProgrCertificato();
					//curr.setCodiceAttestato(codAttestato);

					String indirizzoCompleto = StringUtils.trimToEmpty(curr.getDescIndirizzo());

					if (StringUtils.trimToNull(curr.getNumCivico()) != null)
					{
						indirizzoCompleto += ", " + curr.getNumCivico();
					}

					indirizzoCompleto += " - ";

					if (StringUtils.trimToNull(curr.getDescComune()) != null)
					{
						indirizzoCompleto += curr.getDescComune();
					}

					if (StringUtils.trimToNull(curr.getDescProv()) != null)
					{
						indirizzoCompleto += " (" + curr.getDescProv() + ")";
					}
					curr.setDescIndirizzoCompleto(indirizzoCompleto);

					curr.setFlgModulo("Modulo A.P.E.");

					if (!GenericUtil.isNullOrEmpty(curr.getIdStato())
							&& curr.getIdStato() == Constants.INVIATO) {
						curr.setFlgRicevuta("Ricevuta");
					}
					
					curr.setFlgTracciato("Tracciato xml");

					
					ace.add(curr);
				}
			}
			return ace;
			
		} catch (SiceeTExportBoDaoException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella ricerca degli AceByCodice", e);
			throw new BEException("Errore nella ricerca degli AceByCodice", e);
		}
		catch (SiceeTParametriDaoException e) {
			throw new BEException("Errore nella lettura del parametro "+Constants.NUMERO_MINIMO_ID_CERTIFICATORE, e);
		}
	
	}
	
	
	/**
	 * Find ace by codice all status.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 * @throws SiceeTCertificatoDaoException the sicee t certificato dao exception
	 */
	public ArrayList<Ace> findAceByCodiceAllStatus(FiltroRicercaAce filtro) throws BEException, SiceeTCertificatoDaoException {
		ArrayList<Ace> ace = new ArrayList<Ace>();
		
		String idCertificatore = getCertificatoreMgr().findIdCertificatoreFromNumCertificatore(filtro.getCertificatore());
		
		SiceeTCertificato certificato = getSiceeTCertificatoDao().findByPrimaryKey(idCertificatore, filtro.getProgCertificato(), filtro.getAnnoCertificato());

		if (certificato != null) {
			Ace curr = mapFromCertificatoAce(certificato);
			curr.setIdCertificatore(idCertificatore);
	
			String codice = curr.getAnno() + " " + filtro.getCertificatore() + " " + curr.getProgrCertificato();
			curr.setCodice(codice);
	
			String indirizzoCompleto = StringUtils.trimToEmpty(curr.getDescIndirizzo());
	
			if (StringUtils.trimToNull(curr.getNumCivico()) != null)
			{
				indirizzoCompleto += ", " + curr.getNumCivico();
			}
	
			indirizzoCompleto += " - ";
	
			if (StringUtils.trimToNull(curr.getDescComune()) != null)
			{
				indirizzoCompleto += curr.getDescComune();
			}
	
			if (StringUtils.trimToNull(curr.getDescProv()) != null)
			{
				indirizzoCompleto += " (" + curr.getDescProv() + ")";
			}
			curr.setDescIndirizzoCompleto(indirizzoCompleto);
	
			if (certificato.getFkStato() != Constants.BOZZA)
			{
				curr.setFlgModulo("Modulo A.P.E.");
			} else {
				curr.setFlgModulo("Bozza A.P.E.");
			}
			
			try {
				SiceeDStatoCert stato = getSiceeDStatoCertDao().findByPrimaryKey(certificato.getFkStato());
				
				curr.setDescStato(stato.getDescr());
			}
			catch (Exception e) {
				log.error("Errore nella ricerca dello stato certificato", e);
			}
	
			ace.add(curr);
		}

		return ace;
	
	}

	/**
	 * Gets the numero max ace.
	 *
	 * @return the numero max ace
	 * @throws BEException the bE exception
	 */
	public Integer getNumeroMaxAce()throws BEException {
		try {
			SiceeTParametri param = getSiceeTParametriDao().findByPrimaryKey(Constants.NUMERO_MAX_ACE_BO);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MAX_ACE_BO))
			{
				return Integer.valueOf(param.getValore());
			}
			else
			{
				return null;
			}
		} catch (SiceeTParametriDaoException e) {
			throw new BEException("Errore nella lettura del parametro "+Constants.NUMERO_MAX_ACE_BO, e);
		}
	}

	/**
	 * Find elenco ace by filtro count.
	 *
	 * @param filtro the filtro
	 * @return the integer
	 * @throws BEException the bE exception
	 */
	public Integer findElencoAceByFiltroCount(FiltroRicercaAce filtro) throws BEException {
		Integer count = null;
		try {

			SiceeTParametri param = getSiceeTParametriDao().findByPrimaryKey(Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MINIMO_ID_CERTIFICATORE))
			{

				count = 
					getSiceeTExportBoDao().findElencoAceByFiltroCount(filtro, new Long(param.getValore()));

				
			}
			return count;
			
		} catch (SiceeTExportBoDaoException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella ricerca degli AceByCodice", e);
			throw new BEException("Errore nella ricerca degli AceByCodice", e);
		}
		catch (SiceeTParametriDaoException e) {
			throw new BEException("Errore nella lettura del parametro "+Constants.NUMERO_MINIMO_ID_CERTIFICATORE, e);
		}
	}
	
	/**
	 * Find elenco ace by filtro.
	 *
	 * @param filtro the filtro
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public ArrayList<Ace> findElencoAceByFiltro(FiltroRicercaAce filtro) throws BEException {
		ArrayList<Ace> ace = new ArrayList<Ace>();
		try {

			SiceeTParametri param = getSiceeTParametriDao().findByPrimaryKey(Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MINIMO_ID_CERTIFICATORE))
			{

				List<SiceeTExportBo> temp = 
					getSiceeTExportBoDao().findElencoAceByFiltro(filtro, new Long(param.getValore()));

				Iterator<SiceeTExportBo> it = temp.iterator();
				while (it.hasNext()) {
					SiceeTExportBo findCertificatori = it.next();
					Ace curr = mapFromDBOAce(findCertificatori);


					String codice = curr.getAnno() + " " + curr.getNumCertificatore() + " " + curr.getProgrCertificato();
					curr.setCodice(codice);

					//String codAttestato = curr.getAnno() + " " + curr.getIdCertificatore() + " " + curr.getProgrCertificato();
					//curr.setCodiceAttestato(codAttestato);

					String indirizzoCompleto = StringUtils.trimToEmpty(curr.getDescIndirizzo());

					if (StringUtils.trimToNull(curr.getNumCivico()) != null)
					{
						indirizzoCompleto += ", " + curr.getNumCivico();
					}

					indirizzoCompleto += " - ";

					if (StringUtils.trimToNull(curr.getDescComune()) != null)
					{
						indirizzoCompleto += curr.getDescComune();
					}

					if (StringUtils.trimToNull(curr.getDescProv()) != null)
					{
						indirizzoCompleto += " (" + curr.getDescProv() + ")";
					}
					curr.setDescIndirizzoCompleto(indirizzoCompleto);

					curr.setFlgModulo("Modulo A.P.E.");
					
					if (!GenericUtil.isNullOrEmpty(curr.getIdStato())
							&& curr.getIdStato() == Constants.INVIATO) {
						curr.setFlgRicevuta("Ricevuta");
					}
					
					curr.setFlgTracciato("Tracciato xml");

					
					ace.add(curr);
				}
			}
			return ace;
			
		} catch (SiceeTExportBoDaoException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella ricerca degli AceByCodice", e);
			throw new BEException("Errore nella ricerca degli AceByCodice", e);
		}
		catch (SiceeTParametriDaoException e) {
			throw new BEException("Errore nella lettura del parametro "+Constants.NUMERO_MINIMO_ID_CERTIFICATORE, e);
		}
	}
	
	/**
	 * Gets the all motivi rilascio.
	 *
	 * @return the all motivi rilascio
	 * @throws BEException the bE exception
	 */
	public ArrayList<LabelValue> getAllMotiviRilascioOld()throws BEException{
		ArrayList<LabelValue> motivi = new ArrayList<LabelValue>();
		try {
			List<SiceeDMotivoRilascio> temp = getSiceeDMotivoRilascioDao().findWhereFlgAttivoEquals(Constants.FLG_0);
			Iterator<SiceeDMotivoRilascio> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDMotivoRilascio siceeDMotivoRilascio = it.next();
				LabelValue curr = mapFromDBMotivazioneRilascio(siceeDMotivoRilascio);
				motivi.add(curr);
			}
			return motivi;
		} catch (SiceeDMotivoRilascioDaoException e) {
			throw new BEException("Erorre nella lettura dell'elenco delle motivazione rilascio old ", e);
		}
	}
	
	/**
	 * Gets the all motivi rilascio.
	 *
	 * @return the all motivi rilascio
	 * @throws BEException the bE exception
	 */
	public ArrayList<LabelValue> getAllMotiviRilascio2015()throws BEException{
		ArrayList<LabelValue> motivi = new ArrayList<LabelValue>();
		try {
			List<SiceeDMotivoRilascio> temp = getSiceeDMotivoRilascioDao().findWhereFlgAttivoEquals(Constants.FLG_1);
			Iterator<SiceeDMotivoRilascio> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDMotivoRilascio siceeDMotivoRilascio = it.next();
				LabelValue curr = mapFromDBMotivazioneRilascio(siceeDMotivoRilascio);
				motivi.add(curr);
			}
			return motivi;
		} catch (SiceeDMotivoRilascioDaoException e) {
			throw new BEException("Erorre nella lettura dell'elenco delle motivazione rilascio new ", e);
		}
	}

	
	/**
	 * Gets the all classe energetica.
	 *
	 * @return the all classe energetica
	 * @throws BEException the bE exception
	 */
	public ArrayList<LabelValue> getAllClasseEnergeticaOld()throws BEException{
		ArrayList<LabelValue> classe = new ArrayList<LabelValue>();
		try {
			List<SiceeDClasseEnergetica> temp = getSiceeDClasseEnergeticaDao().findWhereFlgAttivoEquals(Constants.FLG_0);
			Iterator<SiceeDClasseEnergetica> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDClasseEnergetica siceeDClasseEnergetica = it.next();
				LabelValue curr = mapFromDBClasseEnergetica(siceeDClasseEnergetica);
				classe.add(curr);
			}
			return classe;
		} catch (SiceeDClasseEnergeticaDaoException e) {
			throw new BEException("Erorre nella lettura dell'elenco delle classi energetiche old", e);
		}
	}

	/**
	 * Gets the all classe energetica.
	 *
	 * @return the all classe energetica
	 * @throws BEException the bE exception
	 */
	public ArrayList<LabelValue> getAllClasseEnergetica2015()throws BEException{
		ArrayList<LabelValue> classe = new ArrayList<LabelValue>();
		try {
			List<SiceeDClasseEnergetica> temp = getSiceeDClasseEnergeticaDao().findWhereFlgAttivoEquals(Constants.FLG_1);
			Iterator<SiceeDClasseEnergetica> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDClasseEnergetica siceeDClasseEnergetica = it.next();
				LabelValue curr = mapFromDBClasseEnergetica(siceeDClasseEnergetica);
				classe.add(curr);
			}
			return classe;
		} catch (SiceeDClasseEnergeticaDaoException e) {
			throw new BEException("Erorre nella lettura dell'elenco delle classi energetiche new", e);
		}
	}


	/**
	 * Gets the all destinazione uso.
	 *
	 * @return the all destinazione uso
	 * @throws BEException the bE exception
	 */
	public ArrayList<LabelValue> getAllDestinazioneUso()throws BEException{
		ArrayList<LabelValue> destinazioni = new ArrayList<LabelValue>();
		try {
			
			List<SiceeDDestUso> temp = getSiceeDDestUsoDao().findAllFlgVisibileComboSI();
			Iterator<SiceeDDestUso> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDDestUso siceeDClasseEnergetica = it.next();
				LabelValue curr = mapFromDBDestinazioneUso(siceeDClasseEnergetica);
				destinazioni.add(curr);
			}
			
			return destinazioni;
		} catch (SiceeDDestUsoDaoException e) {
			throw new BEException("Erorre nella lettura dell'elenco delle destinazioni d'uso ", e);
		}
	}
	
	/**
	 * Gets the all destinazione uso 2015.
	 *
	 * @return the all destinazione uso 2015
	 * @throws BEException the bE exception
	 */
	public ArrayList<LabelValue> getAllDestinazioneUso2015()throws BEException{
		ArrayList<LabelValue> destinazioni = new ArrayList<LabelValue>();
		try {
			
			List<SiceeDDestUso2015> temp = getSiceeDDestUso2015Dao().findAll();
			Iterator<SiceeDDestUso2015> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDDestUso2015 siceeDDestUso2015 = it.next();
				LabelValue curr = mapFromDBDestinazioneUso2015(siceeDDestUso2015);
				destinazioni.add(curr);
			}
			
			return destinazioni;
		} catch (SiceeDDestUso2015DaoException e) {
			throw new BEException("Erorre nella lettura dell'elenco delle destinazioni d'uso 2015", e);
		}
	}

	/**
	 * Gets the stampa certificato.
	 *
	 * @param numeroCertificato the numero certificato
	 * @param idTipoDoc the tipo di documento
	 * @return the stampa certificato
	 * @throws BEException the bE exception
	 */
	public boolean isAttestatoOld(String numeroCertificato) throws BEException {
		try {

			// String[] split =
			// BaseMgr.recuperaChiaveAttestato(cert.getIdCertificatore(),
			// numeroCertificato);

			boolean isOld = false;
			
			log.debug("############");
			log.debug("numeroCertificato: "+numeroCertificato);
			String[] split = numeroCertificato.split(" ");

			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];

			String idCert = getCertificatoreMgr().findIdCertificatoreFromNumCertificatore(numCertificatore);
			//SiceeTCertificatore certificatore = getSiceeTCertificatoreDao().findWhereNumCertificatoreEquals(numCertificatore);

			log.debug("idCert: "+idCert);
			log.debug("progrCertificato: "+progrCertificato);
			log.debug("annoCertificato: "+annoCertificato);
			log.debug("############");
			
			SiceeTCertificato certificato = getSiceeTCertificatoDao().findByPrimaryKey(idCert, progrCertificato, annoCertificato);

			if (certificato != null)
			{
				isOld = certificato.getFlgOld().equalsIgnoreCase(Constants.FLG_S);
			}
			
			return isOld;

		} catch (Exception e) {
			throw new BEException("Errore in isAttestatoOld:" + e, e);
		}
	}
	

	/**
	 * Find uid doc.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public String findUidDoc(String numeroCertificato)throws BEException{
		try {

			String[] split = numeroCertificato.split(" ");

			String id = getCertificatoreMgr().findIdCertificatoreFromNumCertificatore(split[1]);
			String prog = split[2];
			String anno = split[0];
			

			log.debug("id: " + id);
			log.debug("prog: " + prog);
			log.debug("anno: " + anno);

			SiceeTCertificatoPk certificatoPk = new SiceeTCertificatoPk(id, prog, anno);
			SiceeTCertificato tCertificato = getSiceeTCertificatoDao().findByPrimaryKey(certificatoPk);

			return tCertificato!=null?tCertificato.getIdentificPdf():null;
		} catch (SiceeTCertificatoDaoException e) {
			throw new BEException("Erorre nella ricerca del certificato ", e);
		}
	}
	
	/**
	 * Find uid doc stampa monitoraggio.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public String findUidDocStampaMonitoraggio(String numeroCertificato)throws BEException{
		try {

			String[] split = numeroCertificato.split(" ");

			String id = split[1];
			String prog = split[2];
			String anno = split[0];
			
			log.debug("id: " + id);
			log.debug("prog: " + prog);
			log.debug("anno: " + anno);

			SiceeTCertificatoPk certificatoPk = new SiceeTCertificatoPk(id, prog, anno);
			SiceeTCertificato tCertificato = getSiceeTCertificatoDao().findByPrimaryKey(certificatoPk);

			return tCertificato!=null?tCertificato.getIdentificPdf():null;
		} catch (SiceeTCertificatoDaoException e) {
			throw new BEException("Erorre nella ricerca del certificato ", e);
		}
	}


	/**
	 * Find ace.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the ace
	 * @throws BEException the bE exception
	 */
	public Ace findAce(String numeroCertificato, boolean isOld) throws BEException{
		try {

			String[] split = numeroCertificato.split(" ");

			String id = getCertificatoreMgr().findIdCertificatoreFromNumCertificatore(split[1]);

			String prog = split[2];
			String anno = split[0];
			

			log.debug("id: " + id);
			log.debug("prog: " + prog);
			log.debug("anno: " + anno);

			SiceeTExportBoPk exportBoPk = new SiceeTExportBoPk(id, prog, anno);
			SiceeTExportBo tExportBo = getSiceeTExportBoDao().findAceByPrimaryKey(exportBoPk, isOld);
			
			

			return mapFromDBOAce(tExportBo);
		} catch (SiceeTExportBoDaoException e) {
			throw new BEException("Erorre nella ricerca del certificato ", e);
		}
	}
	
	/** The sicee d stato cert dao. */
	private SiceeDStatoCertDao siceeDStatoCertDao;
	
	/**
	 * Gets the sicee d stato cert dao.
	 *
	 * @return the sicee d stato cert dao
	 */
	public SiceeDStatoCertDao getSiceeDStatoCertDao() {
		return this.siceeDStatoCertDao;
	}
	
	/**
	 * Sets the sicee d stato cert dao.
	 *
	 * @param siceeDStatoCertDao the new sicee d stato cert dao
	 */
	public void setSiceeDStatoCertDao(SiceeDStatoCertDao siceeDStatoCertDao) {
		this.siceeDStatoCertDao = siceeDStatoCertDao;
	}

	
		/*
	public Titolo getTitoloById(String id)throws BEException {
		try {
			SiceeDTitolo temp = getSiceeDTitoloDao().findByPrimaryKey(id);
			if (temp!=null)
				return mapFromDBTitolo(temp);
			else
				return null;
		} catch (SiceeDTitoloDaoException e) {
			throw new BEException("Errore nella lettura del titolo "+id, e);
		}
	}
	public ArrayList<Certificatore> findElencoCertificatore(FiltroRicercaCertificatori filtro) throws BEException {
		ArrayList<Certificatore> certificatori = new ArrayList<Certificatore>();
		try {

			log.debug("Cognome: " + filtro.getCognome());
			log.debug("Nome: " + filtro.getNome());
			
			
			List<OptimizedFindCertificatori> temp = 
				getOptimizedFindCertificatoriDao().findElencoCertificatori(filtro);
			
			Iterator<OptimizedFindCertificatori> it = temp.iterator();
			while (it.hasNext()) {
				OptimizedFindCertificatori findCertificatori = it.next();
				Certificatore curr = mapFromDBOCertificatori(findCertificatori);
				certificatori.add(curr);
			}
			return certificatori;
			
			
			
		} catch (OptimizedFindCertificatoriDaoException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella ricerca dei certificatori", e);
			throw new BEException("Errore nella ricerca dei certificatori", e);
		}
		
	
	}

	public ArrayList<CertificatoreExport> findElencoCertificatoriForExport(
			List<Certificatore> certificatoriTrovati, UDTDateValid dataACEdal, UDTDateValid dataACEal) throws BEException {
		
		ArrayList<CertificatoreExport> certificatori = new ArrayList<CertificatoreExport>();
		try {

			ArrayList<String> idCertificatori = new ArrayList<String>();
			
			for (int i = 0; i < certificatoriTrovati.size(); i++) 
			{
				idCertificatori.add(certificatoriTrovati.get(i).getId());
			}
			
			
			List<OptimizedFindCertificatoriExport> temp = 
				getOptimizedFindCertificatoriDao().findElencoCertificatoriForExport(idCertificatori, dataACEdal, dataACEal);
			
			Iterator<OptimizedFindCertificatoriExport> it = temp.iterator();
			while (it.hasNext()) {
				OptimizedFindCertificatoriExport findCertificatori = it.next();
				CertificatoreExport curr = mapFromDBOCertificatoriExport(findCertificatori);
				certificatori.add(curr);
			}
			return certificatori;
			
			
			
		} catch (OptimizedFindCertificatoriDaoException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella ricerca dei certificatori", e);
			throw new BEException("Errore nella ricerca dei certificatori", e);
		}
		
	
	}
	*/

	
}
