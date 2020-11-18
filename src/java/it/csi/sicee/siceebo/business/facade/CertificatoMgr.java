/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.facade;

import it.csi.sicee.siceebo.business.BEException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDClasseEnergeticaDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDIstruzioneDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDMotivoRilascioDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeLAnnullamentoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTAltreInfoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTAziendaDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertXml2015Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTDatiGeneraliDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTFoto2015Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTImpdatiXml2015Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTImportDati2015Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTRifIndex2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDMotivoRilascio;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLAnnullamento;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBo;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBoPk;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTFoto2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTImpdatiXml2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTSiape;
import it.csi.sicee.siceebo.business.dao.exceptions.DaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTCertificatoDaoException;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTExportBoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTSiapeDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTRifIndex2015;
import it.csi.sicee.siceebo.dto.ace.Ace;
import it.csi.sicee.siceebo.dto.ace.Annullamento;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.Converter;
import it.csi.sicee.siceebo.util.GenericUtil;
import it.csi.sicee.siceebo.util.XmlBeanUtils;
import it.csi.sicee.siceeorch.dto.siceeorch.Documento;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.xmlbeans.impl.util.Base64;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


public class CertificatoMgr extends BaseMgr {

	private SOAIntegrationMgr soaIntegrationMgr;
	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return this.soaIntegrationMgr;
	}
	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}
	
	private CertificatoreMgr certificatoreMgr;
	public CertificatoreMgr getCertificatoreMgr() {
		return this.certificatoreMgr;
	}
	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private SiceeTCertXml2015Dao siceeTCertXml2015Dao;
	public SiceeTCertXml2015Dao getSiceeTCertXml2015Dao() {
		return this.siceeTCertXml2015Dao;
	}
	public void setSiceeTCertXml2015Dao(
			SiceeTCertXml2015Dao siceeTCertXml2015Dao) {
		this.siceeTCertXml2015Dao = siceeTCertXml2015Dao;
	}

	private SiceeTFoto2015Dao siceeTFoto2015Dao;
	public SiceeTFoto2015Dao getSiceeTFoto2015Dao() {
		return this.siceeTFoto2015Dao;
	}
	public void setSiceeTFoto2015Dao(
			SiceeTFoto2015Dao siceeTFoto2015Dao) {
		this.siceeTFoto2015Dao = siceeTFoto2015Dao;
	}

	private SiceeTCertificatoDao siceeTCertificatoDao;
	public SiceeTCertificatoDao getSiceeTCertificatoDao() {
		return this.siceeTCertificatoDao;
	}
	public void setSiceeTCertificatoDao(
			SiceeTCertificatoDao siceeTCertificatoDao) {
		this.siceeTCertificatoDao = siceeTCertificatoDao;
	}

	private SiceeTDatiGeneraliDao siceeTDatiGeneraliDao;
	public SiceeTDatiGeneraliDao getSiceeTDatiGeneraliDao() {
		return this.siceeTDatiGeneraliDao;
	}
	public void setSiceeTDatiGeneraliDao(
			SiceeTDatiGeneraliDao siceeTDatiGeneraliDao) {
		this.siceeTDatiGeneraliDao = siceeTDatiGeneraliDao;
	}
	
	private SiceeTCertificatoreDao siceeTCertificatoreDao;
	public SiceeTCertificatoreDao getSiceeTCertificatoreDao() {
		return this.siceeTCertificatoreDao;
	}
	public void setSiceeTCertificatoreDao(
			SiceeTCertificatoreDao siceeTCertificatoreDao) {
		this.siceeTCertificatoreDao = siceeTCertificatoreDao;
	}
	
	private SiceeTAziendaDao siceeTAziendaDao;
	public SiceeTAziendaDao getSiceeTAziendaDao() {
		return this.siceeTAziendaDao;
	}
	public void setSiceeTAziendaDao(
			SiceeTAziendaDao siceeTAziendaDao) {
		this.siceeTAziendaDao = siceeTAziendaDao;
	}
	
	private SiceeDIstruzioneDao siceeDIstruzioneDao;
	public SiceeDIstruzioneDao getSiceeDIstruzioneDao() {
		return this.siceeDIstruzioneDao;
	}
	public void setSiceeDIstruzioneDao(
			SiceeDIstruzioneDao siceeDIstruzioneDao) {
		this.siceeDIstruzioneDao = siceeDIstruzioneDao;
	}

	private SiceeDClasseEnergeticaDao siceeDClasseEnergeticaDao;
	public SiceeDClasseEnergeticaDao getSiceeDClasseEnergeticaDao() {
		return this.siceeDClasseEnergeticaDao;
	}
	public void setSiceeDClasseEnergeticaDao(
			SiceeDClasseEnergeticaDao siceeDClasseEnergeticaDao) {
		this.siceeDClasseEnergeticaDao = siceeDClasseEnergeticaDao;
	}

	private SiceeTImportDati2015Dao siceeTImportDati2015Dao;
	public SiceeTImportDati2015Dao getSiceeTImportDati2015Dao() {
		return this.siceeTImportDati2015Dao;
	}
	public void setSiceeTImportDati2015Dao(
			SiceeTImportDati2015Dao siceeTImportDati2015Dao) {
		this.siceeTImportDati2015Dao = siceeTImportDati2015Dao;
	}
	
	private SiceeTAltreInfoDao siceeTAltreInfoDao;
	public SiceeTAltreInfoDao getSiceeTAltreInfoDao() {
		return this.siceeTAltreInfoDao;
	}
	public void setSiceeTAltreInfoDao(
			SiceeTAltreInfoDao siceeTAltreInfoDao) {
		this.siceeTAltreInfoDao = siceeTAltreInfoDao;
	}

	private SiceeDMotivoRilascioDao siceeDMotivoRilascioDao;
	public SiceeDMotivoRilascioDao getSiceeDMotivoRilascioDao() {
		return this.siceeDMotivoRilascioDao;
	}
	public void setSiceeDMotivoRilascioDao(
			SiceeDMotivoRilascioDao siceeDMotivoRilascioDao) {
		this.siceeDMotivoRilascioDao = siceeDMotivoRilascioDao;
	}
	
	private SiceeTImpdatiXml2015Dao siceeTImpDatiXml2015Dao;
	public SiceeTImpdatiXml2015Dao getSiceeTImpdatiXml2015Dao() {
		return this.siceeTImpDatiXml2015Dao;
	}
	public void setSiceeTImpdatiXml2015Dao(
			SiceeTImpdatiXml2015Dao siceeTImpDatiXml2015Dao) {
		this.siceeTImpDatiXml2015Dao = siceeTImpDatiXml2015Dao;
	}

	private SiceeTExportBoDao siceeTExportBoDao;
	public SiceeTExportBoDao getSiceeTExportBoDao() {
		return this.siceeTExportBoDao;
	}
	public void setSiceeTExportBoDao(SiceeTExportBoDao siceeTExportBoDao) {
		this.siceeTExportBoDao = siceeTExportBoDao;
	}
	
	private SiceeTSiapeDao siceeTSiapeDao;
	public SiceeTSiapeDao getSiceeTSiapeDao() {
		return this.siceeTSiapeDao;
	}
	public void setSiceeTSiapeDao(SiceeTSiapeDao siceeTSiapeDao) {
		this.siceeTSiapeDao = siceeTSiapeDao;
	}

	private SiceeTRifIndex2015Dao siceeTRifIndex2015Dao;
	
	public SiceeTRifIndex2015Dao getSiceeTRifIndex2015Dao() {
		return this.siceeTRifIndex2015Dao;
	}
	public void setSiceeTRifIndex2015Dao(SiceeTRifIndex2015Dao siceeTRifIndex2015Dao) {
		this.siceeTRifIndex2015Dao = siceeTRifIndex2015Dao;
	}

	private SiceeLAnnullamentoDao siceeLAnnullamentoDao;
	
	public SiceeLAnnullamentoDao getSiceeLAnnullamentoDao() {
		return this.siceeLAnnullamentoDao;
	}
	public void setSiceeLAnnullamentoDao(SiceeLAnnullamentoDao siceeLAnnullamentoDao) {
		this.siceeLAnnullamentoDao = siceeLAnnullamentoDao;
	}

	public SiceeTCertXml2015 recuperaCertXml2015(String idCertificatore, String progrCertificato, String anno) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		SiceeTCertXml2015 vo = null;
		try {
			vo = this.getSiceeTCertXml2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
		} catch (Exception e) {
			log.error("Errore in recuperaCertXml2015", e);
			throw new BEException(e.getMessage(), e);
		}
		return vo;
	}
	
	
	
	public SiceeTCertificato recuperaCertificato(String idCertificatore, String progrCertificato, String anno) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		SiceeTCertificato vo = null;
		try {
			vo = this.getSiceeTCertificatoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
		} catch (Exception e) {
			log.error("Errore in recuperaCertificato", e);
			throw new BEException(e.getMessage(), e);
		}
		return vo;
	}

	public SiceeTDatiGenerali recuperaDatiGenerali(String idCertificatore, String progrCertificato, String anno) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		SiceeTDatiGenerali vo = null;
		try {
			vo = this.getSiceeTDatiGeneraliDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
		} catch (Exception e) {
			log.error("Errore in recuperaDatiGenerali", e);
			throw new BEException(e.getMessage(), e);
		}
		return vo;
	}

	public SiceeTAltreInfo recuperaAltreInfo(String idCertificatore, String progrCertificato, String anno) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		SiceeTAltreInfo vo = null;
		try {
			vo = this.getSiceeTAltreInfoDao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
		} catch (Exception e) {
			log.error("Errore in recuperaAltreInfo", e);
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

	public SiceeTAzienda recuperaAzienda(long idAzienda) throws BEException {

		log.debug("idAzienda: " + idAzienda);

		SiceeTAzienda vo = null;
		try {
			vo = this.getSiceeTAziendaDao().findByPrimaryKey(idAzienda);
		} catch (Exception e) {
			log.error("Errore in recuperaAzienda", e);
			throw new BEException(e.getMessage(), e);
		}
		return vo;
	}

	public String recuperaDTitolo(Integer fkIstruzione) throws BEException {

		log.debug("fkIstruzione: " + fkIstruzione);

		String dTitolo = null;
		try {
			// fkTitolo può essere null ?
			if (fkIstruzione != null)
				dTitolo = this.getSiceeDIstruzioneDao().findByPrimaryKey(fkIstruzione).getDenominazione();
		} catch (Exception e) {
			log.error("Errore in recuperaDTitolo", e);
			throw new BEException(e.getMessage(), e);
		}
		return dTitolo;
	}

	public List<SiceeDClasseEnergetica> recuperaElencoClasseEnergetica() throws BEException {

		List<SiceeDClasseEnergetica> list = new ArrayList<SiceeDClasseEnergetica>();
		try {
				list = this.getSiceeDClasseEnergeticaDao().findWhereFlgAttivoEquals(1);
		} catch (Exception e) {
			log.error("Errore in recuperaElencoClasseEnergetica", e);
			throw new BEException(e.getMessage(), e);
		}
		return list;
	}

	public String recuperaFoto(String idCertificatore, String progrCertificato, String anno) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		String indexImage = null;
		List<SiceeTFoto2015> voList = null;
		try {
			voList = this.getSiceeTFoto2015Dao().findBySiceeTCertificatoFlgPrincipale(idCertificatore, progrCertificato, anno, "S");
			if ((voList == null) || (voList.size() == 0)) {
				log.debug("\n>>>>>>>NESSUNA FOTO PRESENTE");
			}
			else {
				log.debug("\n>>>>>>>FOTO PRESENTE");
				SiceeTFoto2015 vo = voList.get(0);
				Documento doc = getSoaIntegrationMgr().recuperaDocumento(vo.getIdentificFoto());
				if (doc.getDoc() != null) {
					byte[] immagineEncodata = Base64.encode(doc.getDoc());
					indexImage = new String(immagineEncodata);
				}
			}
		} catch (Exception e) {
			log.error("Errore in recuperaFoto", e);
			throw new BEException(e.getMessage(), e);
		}
		return indexImage;
	}

	
	/**
	 * Aggiorna stato annullato.
	 *
	 * @param cert the cert
	 * @param att the att
	 * @param idMotivoSost the id motivo sost
	 * @param dataSost the data sost
	 * @param noteSost the note sost
	 * @throws BEException the bE exception
	 */
	@Transactional
	public void aggiornaStatoAnnullato(Ace ace, Annullamento annullamento, String numeroCertificato, String cfUtente, boolean isOld)
			throws BEException {
		String id = ace.getIdCertificatore();
		String prog = ace.getProgrCertificato();
		String anno = ace.getAnno();
		try {
			SiceeTCertificato dto = this.getSiceeTCertificatoDao()
					.findByPrimaryKey(id, prog, anno);
			dto.setFkStato(Constants.ANNULLATO_BO);
			dto.setFkMotivoSost(annullamento.getIdMotivo());
			log.debug("Stampo la data che ho ricevuto: "+annullamento.getData());
			dto.setDtSostituzione(Converter.convertToDate(annullamento.getData()));
			
			dto.setNoteSostituzione(annullamento.getMotivazione());
			
			dto.setCfUtenteSostituzione(cfUtente);
			
			this.getSiceeTCertificatoDao().update(dto.createPk(), dto);

			// Devo inserire una riga su SICEE_L_ANNULLAMENTO 
			annullaAttestatoScaduto(dto, cfUtente+": "+annullamento.getMotivazione());
			
			SiceeTExportBoPk exportpk = new SiceeTExportBoPk(id, prog, anno);
			SiceeTExportBo exportBo = this.getSiceeTExportBoDao().findAceByPrimaryKey(exportpk, isOld);
			if (exportBo != null) {
				this.getSiceeTExportBoDao().updateStato(exportpk, Constants.ANNULLATO_BO);
			}

			// Inserisco una riga anche nella tabellea SIEE_T_SIAPE, in modo che si sappia quali certificati bisogna inviare al SIAPE
			// Bisogna inviare a SIAPE i certificati annullati solo se in precenza è stato inviato quello di inserimento,
			// nel caso di annullamento di certificati vecchi non bisogna mandarlo al SIAPE
			SiceeTSiape siape = this.getSiceeTSiapeDao().findByPrimaryKey(dto.getIdCertificatore(), dto.getProgrCertificato(), dto.getAnno(), Constants.ID_TIPO_AZIONE_INVIO);

			if (siape != null)
			{
				siape.setIdTipoAzione(Constants.ID_TIPO_AZIONE_ANNULLAMENTO);
				this.getSiceeTSiapeDao().insert(siape);
			}

			if (dto.getFlgOld().equalsIgnoreCase(Constants.NO))
			{
				log.debug("Prima del creaPdfEConsolidaLibretto");
				//getServiziMgr().creaPdfEAnnullaCertificato(cert, id, prog, anno, att);
				creaPdfEAnnullaCertificatoReadOnly(ace, id, prog, anno, numeroCertificato);
			}

		} catch (Exception e) {
			log.error("Erroe", e);
			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();
			throw new BEException(e.getMessage(), e);
		}
	}
	
	public void creaPdfEAnnullaCertificatoReadOnly(Ace ace, String idCertificatore, String progrCertificato, String anno, String numeroCertificato) throws BEException
	{
		try
		{

			byte[] thePdf = getSoaIntegrationMgr().recuperaStampaCertificatoReadOnly(idCertificatore, progrCertificato, anno, Constants.ANNULLATO_BO);
			
			String nome = anno + "_" + ace.getNumCertificatore() + "_" + progrCertificato + "_annullato.pdf";

			log.debug("STAMPO il nome del pdf: "+nome);
			

			String uidIndex = getSoaIntegrationMgr().salvaDocumento(idCertificatore, progrCertificato, anno, thePdf,
					nome, 
					Constants.TIPOLOGIA_ALLEGATO_ACE_NEW, numeroCertificato);
			
			String hash = GenericUtil.getHashFile(thePdf);
			
			modificaDocumento(idCertificatore, progrCertificato, anno, Constants.ID_PDF_APE_CONSOLIDATO, nome, hash, uidIndex);
			
			
		}
		catch (Exception e) {
			log.error("Errore creaPdfESalvaAttestato: ", e);
			throw new BEException(e.getMessage(), e);
		}
	}
	
	public void modificaDocumento(String idCertificatore, String progrCertificato, String anno, Integer idTipoDoc, String nomeFile, String hash, String uidIndex) throws BEException {
		
		try {
			
			SiceeTRifIndex2015 rifIndex = getSiceeTRifIndex2015Dao().findBySiceeTCertificatoidTipoDoc(idCertificatore, progrCertificato, anno, idTipoDoc);
			
			rifIndex.setIdCertificatore(idCertificatore);
			rifIndex.setProgrCertificato(progrCertificato);
			rifIndex.setAnno(anno);
			rifIndex.setFkTipoDoc(idTipoDoc);
			rifIndex.setNomeFile(nomeFile);
			rifIndex.setHash(hash);
			rifIndex.setUidIndex(uidIndex);
			
			getSiceeTRifIndex2015Dao().update(rifIndex.createPk(), rifIndex);
			
		} catch (Exception e) {
			
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
		
	}

	public byte[] recuperaTracciatoXml(String idCertificatore, String progrCertificato, String anno) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		byte[] tracciato = null;
		try {
			SiceeTCertXml2015 certXML = recuperaCertXml2015(idCertificatore, progrCertificato, anno);
			tracciato = XmlBeanUtils.readString(certXML.getXmlAllegato());
			
		} catch (Exception e) {
			log.error("Errore in recuperaFoto", e);
			throw new BEException(e.getMessage(), e);
		}
		return tracciato;
	}
	
	public byte[] recuperaTracciatoImportXml(String idCertificatore, String progrCertificato, String anno) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		byte[] tracciato = null;
		try {
			SiceeTImpdatiXml2015 impXML = getSiceeTImpdatiXml2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			if (impXML != null)
			{
				tracciato = XmlBeanUtils.readString(impXML.getFXml());
			}
			
		} catch (Exception e) {
			log.error("Errore in recuperaFoto", e);
			throw new BEException(e.getMessage(), e);
		}
		return tracciato;
	}
	
	public boolean isImportDati2015(String idCertificatore, String progrCertificato, String anno) throws BEException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		boolean isImport = false;
		try {
			SiceeTImportDati2015 datiOrigXML = getSiceeTImportDati2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
			if (datiOrigXML != null)
			{
				isImport = true;
			}
			
		} catch (Exception e) {
			log.error("Errore in isImportDati2015", e);
			throw new BEException(e.getMessage(), e);
		}
		return isImport;
	}
	

				
	public SiceeDMotivoRilascio recuperaDMotivoRilascioDecodifica(Integer idMotivo) throws BEException {

		SiceeDMotivoRilascio vo = null;
		try {
			vo = this.getSiceeDMotivoRilascioDao().findByPrimaryKey(idMotivo);
		} catch (Exception e) {
			log.error("Errore in recuperaDMotivoRilascioDecodifica", e);
			throw new BEException(e.getMessage(), e);
		}
		return vo;
	}

	@Transactional
	public void annullaAttestatoScadutoTrans(SiceeTCertificato certificato)
			throws BEException {
		try {

			certificato.setFkStato(Constants.ANNULLATO_BO);
			certificato.setFkMotivoSost(Constants.ID_MOTIVO_ANNULLATO_BO);
			certificato.setDtSostituzione(GenericUtil.getDataOdiernaSql());
			certificato.setNoteSostituzione(Constants.DESC_MOTIVO_ANNULLAMENTO_SCADENZA);

			this.getSiceeTCertificatoDao()
					.update(certificato.createPk(), certificato);

			SiceeTExportBoPk exportpk = new SiceeTExportBoPk(certificato.getIdCertificatore(), certificato.getProgrCertificato(), certificato.getAnno());
			boolean isOld = certificato.getFlgOld().equalsIgnoreCase(Constants.FLG_S);

			SiceeTExportBo exportBo = this.getSiceeTExportBoDao().findAceByPrimaryKey(exportpk, isOld);
			if (exportBo != null) {
				this.getSiceeTExportBoDao().updateStato(exportpk, Constants.ANNULLATO_BO);
			}
			
			annullaAttestatoScaduto(certificato, Constants.DESC_MOTIVO_ANNULLAMENTO_AUTO_SCADENZA);
			
		} 
		catch (DaoException e) {
			log.error("Erroe", e);

			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();

			throw new BEException(e.getMessage(), e);
		}
		catch (BEException e) {
			TransactionAspectSupport.currentTransactionStatus()
			.setRollbackOnly();
			throw e;
		}
	}

	public void annullaAttestatoScaduto(SiceeTCertificato certificato, String motivo)
			throws BEException {
		try {
			
			SiceeLAnnullamento annullamento = new SiceeLAnnullamento();
			
			annullamento.setIdCertificatore(certificato.getIdCertificatore());
			annullamento.setProgrCertificato(certificato.getProgrCertificato());
			annullamento.setAnno(certificato.getAnno());
			
			annullamento.setDtAnnullamento(GenericUtil.getDataOdiernaSql());
			annullamento.setMotivoAnnullamento(motivo);
			
			this.getSiceeLAnnullamentoDao().insert(annullamento);
			
			//DEVO AGGIUNGERE UNA RIGA SULLA TABELLA SICEE_L_ANNULLAMENTO (che ancora non esiste)
			
		} catch (Exception e) {
			log.error("Erroe", e);
			throw new BEException(e.getMessage(), e);
		}
	}
}
