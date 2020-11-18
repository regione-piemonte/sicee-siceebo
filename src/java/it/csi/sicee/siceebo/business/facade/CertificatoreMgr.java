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
import it.csi.sicee.siceebo.business.dao.dao.OptimizedSiceeTCorso2015Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDBloccoCertificatoreDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDIstruzioneDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoDocumentoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoIstruzioneDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDTitoloDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTAziendaDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTDocumentoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceebo.business.dao.dto.OptimizedFindCertificatori;
import it.csi.sicee.siceebo.business.dao.dto.OptimizedFindCertificatoriExport;
import it.csi.sicee.siceebo.business.dao.dto.OptimizedSiceeTCorso2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDBloccoCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDIstruzione;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoDocumento;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoIstruzione;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTitolo;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTAziendaPk;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatorePk;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTDocumento;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceebo.business.dao.exceptions.OptimizedFindCertificatoriDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.OptimizedSiceeTCorso2015DaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDBloccoCertificatoreDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDIstruzioneDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoDocumentoDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoIstruzioneDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTitoloDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTAziendaDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTCertificatoreDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTDocumentoDaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTParametriDaoException;
import it.csi.sicee.siceebo.dto.certificatori.Certificatore;
import it.csi.sicee.siceebo.dto.certificatori.CertificatoreExport;
import it.csi.sicee.siceebo.dto.certificatori.CorsoAttestatoSummary;
import it.csi.sicee.siceebo.dto.certificatori.DocumentSummary;
import it.csi.sicee.siceebo.dto.certificatori.FiltroRicercaCertificatori;
import it.csi.sicee.siceebo.dto.certificatori.Titolo;
import it.csi.sicee.siceebo.dto.type.UDTDateValid;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;












import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.transaction.annotation.Transactional;

// TODO: Auto-generated Javadoc
/**
 * Facade di gestione dell'entita' Certificatore.
 *
 * @author 869
 */
public class CertificatoreMgr extends BaseMgr {
/*

	private SiceeTCertificatoreDao siceeTCertificatoreDao;
	
	public SiceeTCertificatoreDao getSiceeTCertificatoreDao() {
		return siceeTCertificatoreDao;
	}
	public void setSiceeTCertificatoreDao(
			SiceeTCertificatoreDao siceeTCertificatoreDao) {
		this.siceeTCertificatoreDao = siceeTCertificatoreDao;
	}

	private SiceeTAziendaDao siceeTAziendaDao;
	
	public SiceeTAziendaDao getSiceeTAziendaDao() {
		return siceeTAziendaDao;
	}
	public void setSiceeTAziendaDao(
			SiceeTAziendaDao siceeTAziendaDao) {
		this.siceeTAziendaDao = siceeTAziendaDao;
	}
*/

	private MiscMgr miscMgr;
	public MiscMgr getMiscMgr() {
		return this.miscMgr;
	}
	public void setMiscMgr(
			MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}
	
	/** The sicee d istruzione dao. */
	private SiceeDIstruzioneDao siceeDIstruzioneDao;

	/**
	 * Gets the sicee d istruzione dao.
	 *
	 * @return the sicee d istruzione dao
	 */
	public SiceeDIstruzioneDao getSiceeDIstruzioneDao() {
		return this.siceeDIstruzioneDao;
	}
	
	/**
	 * Sets the sicee d istruzione dao.
	 *
	 * @param siceeDIstruzioneDao the new sicee d istruzione dao
	 */
	public void setSiceeDIstruzioneDao(
			SiceeDIstruzioneDao siceeDIstruzioneDao) {
		this.siceeDIstruzioneDao = siceeDIstruzioneDao;
	}

	/** The sicee d titolo dao. */
	private SiceeDTitoloDao siceeDTitoloDao;

	/**
	 * Gets the sicee d titolo dao.
	 *
	 * @return the sicee d titolo dao
	 */
	public SiceeDTitoloDao getSiceeDTitoloDao() {
		return this.siceeDTitoloDao;
	}
	
	/**
	 * Sets the sicee d titolo dao.
	 *
	 * @param siceeDTitoloDao the new sicee d titolo dao
	 */
	public void setSiceeDTitoloDao(
			SiceeDTitoloDao siceeDTitoloDao) {
		this.siceeDTitoloDao = siceeDTitoloDao;
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

	/** The sicee t certificatore dao. */
	private SiceeTCertificatoreDao siceeTCertificatoreDao;

	/**
	 * Gets the sicee t certificatore dao.
	 *
	 * @return the sicee t certificatore dao
	 */
	public SiceeTCertificatoreDao getSiceeTCertificatoreDao() {
		return this.siceeTCertificatoreDao;
	}

	/**
	 * Sets the sicee t certificatore dao.
	 *
	 * @param siceeTCertificatoreDao the new sicee t certificatore dao
	 */
	public void setSiceeTCertificatoreDao(SiceeTCertificatoreDao siceeTCertificatoreDao) {
		this.siceeTCertificatoreDao = siceeTCertificatoreDao;
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

	private SiceeDBloccoCertificatoreDao siceeDBloccoCertificatoreDao;
	public SiceeDBloccoCertificatoreDao getSiceeDBloccoCertificatoreDao() {
		return this.siceeDBloccoCertificatoreDao;
	}
	public void setSiceeDBloccoCertificatoreDao(SiceeDBloccoCertificatoreDao siceeDBloccoCertificatoreDao) {
		this.siceeDBloccoCertificatoreDao = siceeDBloccoCertificatoreDao;
	}

	private SiceeDTipoIstruzioneDao siceeDTipoIstruzioneDao;
	public SiceeDTipoIstruzioneDao getSiceeDTipoIstruzioneDao() {
		return this.siceeDTipoIstruzioneDao;
	}
	public void setSiceeDTipoIstruzioneDao(SiceeDTipoIstruzioneDao siceeDTipoIstruzioneDao) {
		this.siceeDTipoIstruzioneDao = siceeDTipoIstruzioneDao;
	}

	private SiceeTAziendaDao siceeTAziendaDao;
	public SiceeTAziendaDao getSiceeTAziendaDao() {
		return this.siceeTAziendaDao;
	}
	public void setSiceeTAziendaDao(SiceeTAziendaDao siceeTAziendaDao) {
		this.siceeTAziendaDao = siceeTAziendaDao;
	}

	/** The sicee t documento dao. */
	private SiceeTDocumentoDao siceeTDocumentoDao;

	/**
	 * Gets the sicee t documento dao.
	 *
	 * @return the sicee t documento dao
	 */
	public SiceeTDocumentoDao getSiceeTDocumentoDao() {
		return this.siceeTDocumentoDao;
	}

	/**
	 * Sets the sicee t documento dao.
	 *
	 * @param siceeTDocumentoDao the new sicee t documento dao
	 */
	public void setSiceeTDocumentoDao(SiceeTDocumentoDao siceeTDocumentoDao) {
		this.siceeTDocumentoDao = siceeTDocumentoDao;
	}

	/** The sicee d tipo documento dao. */
	private SiceeDTipoDocumentoDao siceeDTipoDocumentoDao;

	/**
	 * Gets the sicee d tipo documento dao.
	 *
	 * @return the sicee d tipo documento dao
	 */
	public SiceeDTipoDocumentoDao getSiceeDTipoDocumentoDao() {
		return this.siceeDTipoDocumentoDao;
	}

	/**
	 * Sets the sicee d tipo documento dao.
	 *
	 * @param siceeDTipoDocumentoDao the new sicee d tipo documento dao
	 */
	public void setSiceeDTipoDocumentoDao(SiceeDTipoDocumentoDao siceeDTipoDocumentoDao) {
		this.siceeDTipoDocumentoDao = siceeDTipoDocumentoDao;
	}
	
	
	/** The sicee t corso 2015 dao. */
	private OptimizedSiceeTCorso2015Dao optimizedSiceeTCorso2015Dao;

	/**
	 * Gets the sicee t corso 2015 dao.
	 *
	 * @return the sicee t corso 2015 dao
	 */
	public OptimizedSiceeTCorso2015Dao getOptimizedSiceeTCorso2015Dao() {
		return this.optimizedSiceeTCorso2015Dao;
	}

	/**
	 * Sets the sicee t corso 2015 dao.
	 *
	 * @param siceeDTipoDocumentoDao the new sicee t corso 2015 dao
	 */
	public void setOptimizedSiceeTCorso2015Dao(OptimizedSiceeTCorso2015Dao optimizedSiceeTCorso2015Dao) {
		this.optimizedSiceeTCorso2015Dao = optimizedSiceeTCorso2015Dao;
	}
	
	/**
	 * Map to db titolo.
	 *
	 * @param tit the tit
	 * @return the sicee d titolo
	 */
	public SiceeDTitolo mapToDBTitolo(Titolo tit){
		SiceeDTitolo dto = new SiceeDTitolo();
		dto.setDescr(tit.getDescr());
		dto.setFlgEdifici(tit.getEdifici()? "S" : "N");
		dto.setFlgImpianti(tit.getImpianti()? "S" : "N");
		dto.setIdTitolo(tit.getId());
		dto.setSigla(dto.getSigla());
		return dto;
	}

	/**
	 * Map from db titolo.
	 *
	 * @param dto the dto
	 * @return the titolo
	 */
	public Titolo mapFromDBTitolo(SiceeDTitolo dto){
		Titolo ris = new Titolo();
		ris.setId(dto.getIdTitolo());
		ris.setDescr(dto.getDescr());
		ris.setEdifici(("S".equals(dto.getFlgEdifici())? true : false));
		ris.setImpianti(("S".equals(dto.getFlgImpianti())? true : false));
		ris.setSigla(dto.getSigla());
		ris.setFlgMdp(dto.getFlgMdp());
		return ris;
	}
	
	/**
	 * Map from db titolo.
	 *
	 * @param dto the dto
	 * @return the titolo
	 */
	public Titolo mapFromDBTitolo(SiceeDIstruzione dto){
		Titolo ris = new Titolo();
		ris.setId(convertToString(dto.getIdIstruzione()));
		ris.setDescr(dto.getDenominazione());
		return ris;
	}
	
	/**
	 * Map from dbo certificatori.
	 *
	 * @param dto the dto
	 * @return the certificatore
	 */
	public Certificatore mapFromDBOCertificatori(OptimizedFindCertificatori dto){
		Certificatore ris = new Certificatore();
		ris.setId(dto.getIdCertificatore());
		ris.setMatricola(dto.getMatricola());
		ris.setNome(dto.getNome());
		ris.setCognome(dto.getCognome());
		ris.setEmail(dto.getEmail());
		ris.setDescTitolo(dto.getTitolo());
		ris.setRagSociale(dto.getRagioneSociale());
		ris.setDescBloccoCert(dto.getStatoBloccoCert());
		
		String indirizzo = StringUtils.trimToEmpty(dto.getIndirizzo());
		
		if (StringUtils.trimToNull(dto.getNumCivico()) != null)
		{
			indirizzo += ", " + dto.getNumCivico();
		}
		ris.setIndirizzo(indirizzo);
		
		String comune = StringUtils.trimToEmpty(dto.getDescComune());
		if (StringUtils.trimToNull(dto.getDescProv()) != null)
		{
			comune += " (" + dto.getDescProv() + ")";
		}
		ris.setDescComProv(comune);

		return ris;
	}
	

	/**
	 * Map from dbo certificatori export.
	 *
	 * @param dto the dto
	 * @return the certificatore export
	 */
	public CertificatoreExport mapFromDBOCertificatoriExport(OptimizedFindCertificatoriExport dto){
		CertificatoreExport ris = new CertificatoreExport();
		ris.setId(dto.getIdCert());
		ris.setMatricola(dto.getMatricola());
		ris.setNome(dto.getNome());
		ris.setCognome(dto.getCognome());
		ris.setDescTitolo(dto.getTitolo());
		ris.setDescProvOrdine(dto.getDescProvOrdine());
		ris.setNumIscrAlbo(dto.getNumIscrAlbo());
		ris.setDataIscrAlbo(convertToUDTDateValid(dto.getDataIscrAlbo()));
		ris.setCorsoFrequentato(dto.getCorsoFrequentato());
		ris.setDataModulo1Da(convertToUDTDateValid(dto.getDataModulo1Da()));
		ris.setDataModulo1A(convertToUDTDateValid(dto.getDataModulo1A()));
		ris.setDataModulo2Da(convertToUDTDateValid(dto.getDataModulo2Da()));
		ris.setDataModulo2A(convertToUDTDateValid(dto.getDataModulo2A()));
		ris.setAttPartecipEmesso(dto.getAttPartecipEmesso());
		ris.setDataAttPartecip(convertToUDTDateValid(dto.getDataAttPartecip()));
		ris.setAttEsamePresso(dto.getAttEsamePresso());
		ris.setDataAttEsame(convertToUDTDateValid(dto.getDataAttEsame()));
		ris.setCodiceFiscaleCert(dto.getCodiceFiscaleCert());
		
		ris.setDataNascitaCert(convertToUDTDateValid(dto.getDataNascitaCert()));
		ris.setDescRegioneNascitaCert(dto.getDescRegioneNascitaCert());
		ris.setDescProvNascitaCert(dto.getDescProvNascitaCert());
		ris.setDescComuneNascitaCert(dto.getDescComuneNascitaCert());
		
		ris.setDescRegioneResidenzaCert(dto.getDescRegioneResidenzaCert());
		ris.setDescProvResidenzaCert(dto.getDescProvResidenzaCert());
		ris.setDescComuneResidenzaCert(dto.getDescComuneResidenzaCert());
		ris.setDescIndirizzoCert(dto.getDescIndirizzoCert());
		ris.setNumCivicoResidenzaCert(dto.getNumCivicoResidenzaCert());
		ris.setCapCert(dto.getCapCert());
		ris.setTelefonoCert(dto.getTelefonoCert());
		ris.setCellCert(dto.getCellCert());
		ris.setEmailCert(dto.getEmailCert());
		ris.setEmailPecCert(dto.getEmailPecCert());
		ris.setFaxCert(dto.getFaxCert());
		ris.setSitoWebCert(dto.getSitoWebCert());
		ris.setDenominazioneAzienda(dto.getDenominazioneAzienda());
		ris.setPIvaAzienda(dto.getpIvaAzienda());
		ris.setDescRegioneAzienda(dto.getDescRegioneAzienda());
		ris.setDescProvAzienda(dto.getDescProvAzienda());
		ris.setDescComuneAzienda(dto.getDescComuneAzienda());
		ris.setDescIndirizzoAzienda(dto.getDescIndirizzoAzienda());
		ris.setNumCivicoAzienda(dto.getNumCivicoAzienda());
		ris.setCapAzienda(dto.getCapAzienda());
		ris.setNumAceTot(dto.getNumAceTot());
		ris.setNumAceClasseApiu(dto.getNumAceClasseApiu());
		ris.setNumAceClasseA(dto.getNumAceClasseA());
		ris.setNumAceClasseB(dto.getNumAceClasseB());
		ris.setNumAceClasseC(dto.getNumAceClasseC());
		ris.setNumAceClasseD(dto.getNumAceClasseD());
		ris.setNumAceClasseE(dto.getNumAceClasseE());
		ris.setNumAceClasseF(dto.getNumAceClasseF());
		ris.setNumAceClasseG(dto.getNumAceClasseG());
		ris.setNumAceClasseNC(dto.getNumAceClasseNC());

		return ris;
	}
	
	/**
	 * Gets the all titoli.
	 *
	 * @return the all titoli
	 * @throws BEException the bE exception
	 */
	/*
	@Transactional(readOnly = true)
	public ArrayList<Titolo> getAllTitoli()throws BEException{
		ArrayList<Titolo> titoli = new ArrayList<Titolo>();
		try {
			List<SiceeDTitolo> temp = getSiceeDTitoloDao().findAll();
			Iterator<SiceeDTitolo> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDTitolo siceeDTitolo = it.next();
				Titolo curr = mapFromDBTitolo(siceeDTitolo);
				titoli.add(curr);
			}
			return titoli;
		} catch (SiceeDTitoloDaoException e) {
			throw new BEException("Erorre nella lettura dell'elenco di titoli", e);
		}
	}
	*/
	
	/**
	 * Gets the all titoli.
	 *
	 * @return the all titoli
	 * @throws BEException the bE exception
	 */
	@Transactional(readOnly = true)
	public ArrayList<Titolo> getAllTitoli()throws BEException{
		ArrayList<Titolo> titoli = new ArrayList<Titolo>();
		try {
			List<SiceeDIstruzione> temp = getSiceeDIstruzioneDao().findAll();
			Iterator<SiceeDIstruzione> it = temp.iterator();
			while (it.hasNext()) {
				SiceeDIstruzione siceeDTitolo = it.next();
				Titolo curr = mapFromDBTitolo(siceeDTitolo);
				titoli.add(curr);
			}
			return titoli;
		} catch (SiceeDIstruzioneDaoException e) {
			throw new BEException("Erorre nella lettura dell'elenco di titoli", e);
		}
	}
	/**
	 * Gets the titolo by id.
	 *
	 * @param id the id
	 * @return the titolo by id
	 * @throws BEException the bE exception
	 */
	@Transactional(readOnly = true)
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

	/**
	 * Gets the numero max certificatori.
	 *
	 * @return the numero max certificatori
	 * @throws BEException the bE exception
	 */
	public Integer getNumeroMaxCertificatori()throws BEException {
		try {
			SiceeTParametri param = getSiceeTParametriDao().findByPrimaryKey(Constants.NUMERO_MAX_CERTIFICATORI_BO);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MAX_CERTIFICATORI_BO))
			{
				return Integer.valueOf(param.getValore());
			}
			else
			{
				return null;
			}
		} catch (SiceeTParametriDaoException e) {
			throw new BEException("Errore nella lettura del parametro "+Constants.NUMERO_MAX_CERTIFICATORI_BO, e);
		}
	}

	/**
	 * Find elenco certificatore count.
	 *
	 * @param filtro the filtro
	 * @param soloOperativi se true vengono recuperati ice rtificatori che hanno almento un ape in stato inviato
	 * @return the integer
	 * @throws BEException the bE exception
	 */
	public Integer findElencoCertificatoreCount(FiltroRicercaCertificatori filtro, boolean soloOperativi)throws BEException {
		Integer count = null;
		try {

			SiceeTParametri param = getSiceeTParametriDao().findByPrimaryKey(Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MINIMO_ID_CERTIFICATORE))
			{
				count = 
					getOptimizedFindCertificatoriDao().findElencoCertificatoriCount(filtro, soloOperativi, new Long(param.getValore()));
			}
		
			return count;
		} 
		catch (OptimizedFindCertificatoriDaoException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella ricerca dei certificatori", e);
			throw new BEException("Errore nella ricerca dei certificatori", e);
		}catch (SiceeTParametriDaoException e) {
			throw new BEException("Errore nella lettura del parametro "+Constants.NUMERO_MINIMO_ID_CERTIFICATORE, e);
		}
	}

	/**
	 * Find elenco certificatore.
	 *
	 * @param filtro the filtro
	 * @param soloOperativi se true vengono recuperati ice rtificatori che hanno almento un ape in stato inviato
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public ArrayList<Certificatore> findElencoCertificatore(FiltroRicercaCertificatori filtro, boolean soloOperativi) throws BEException {
		ArrayList<Certificatore> certificatori = new ArrayList<Certificatore>();
		try {

			log.debug("Cognome: " + filtro.getCognome());
			log.debug("Nome: " + filtro.getNome());
			
			
			SiceeTParametri param = getSiceeTParametriDao().findByPrimaryKey(Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MINIMO_ID_CERTIFICATORE))
			{
				List<OptimizedFindCertificatori> temp = 
					getOptimizedFindCertificatoriDao().findElencoCertificatori(filtro, soloOperativi, new Long(param.getValore()));
				
				Iterator<OptimizedFindCertificatori> it = temp.iterator();
				while (it.hasNext()) {
					OptimizedFindCertificatori findCertificatori = it.next();
					Certificatore curr = mapFromDBOCertificatori(findCertificatori);
					certificatori.add(curr);
				}
			}
			
			return certificatori;
			
		} catch (OptimizedFindCertificatoriDaoException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella ricerca dei certificatori", e);
			throw new BEException("Errore nella ricerca dei certificatori", e);
		}
		catch (SiceeTParametriDaoException e) {
			log.error("Errore nella lettura del parametro "+Constants.NUMERO_MINIMO_ID_CERTIFICATORE, e);
			throw new BEException("Errore nella lettura del parametro "+Constants.NUMERO_MINIMO_ID_CERTIFICATORE, e);
		}
	
	}

	/**
	 * Find elenco certificatori for export.
	 *
	 * @param certificatoriTrovati the certificatori trovati
	 * @param dataACEdal the data ac edal
	 * @param dataACEal the data ac eal
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public ArrayList<CertificatoreExport> findElencoCertificatoriForExport(
			List<Certificatore> certificatoriTrovati, UDTDateValid dataACEdal, UDTDateValid dataACEal) throws BEException {
		
		ArrayList<CertificatoreExport> certificatori = new ArrayList<CertificatoreExport>();
		try {

			ArrayList<String> idCertificatori = new ArrayList<String>();
			
			for (int i = 0; i < certificatoriTrovati.size(); i++) 
			{
				idCertificatori.add(certificatoriTrovati.get(i).getId());
			}
			
			/*
			log.debug("Cognome: " + filtro.getCognome());
			log.debug("Nome: " + filtro.getNome());
			*/
			
			SiceeTParametri param = getSiceeTParametriDao().findByPrimaryKey(Constants.NUMERO_MINIMO_ID_CERTIFICATORE);
			if (GenericUtil.verifyParam(param, Constants.NUMERO_MINIMO_ID_CERTIFICATORE))
			{
				
				List<OptimizedFindCertificatoriExport> temp = 
					getOptimizedFindCertificatoriDao().findElencoCertificatoriForExport(idCertificatori, dataACEdal, dataACEal, new Long(param.getValore()));
				
				Iterator<OptimizedFindCertificatoriExport> it = temp.iterator();
				while (it.hasNext()) {
					OptimizedFindCertificatoriExport findCertificatori = it.next();
					CertificatoreExport curr = mapFromDBOCertificatoriExport(findCertificatori);
					certificatori.add(curr);
				}
			}
			return certificatori;
			
			
			
		} catch (OptimizedFindCertificatoriDaoException e) {
			// TODO Auto-generated catch block
			log.error("Errore nella ricerca dei certificatori", e);
			throw new BEException("Errore nella ricerca dei certificatori", e);
		}
		catch (SiceeTParametriDaoException e) {
			log.error("Errore nella lettura del parametro "+Constants.NUMERO_MINIMO_ID_CERTIFICATORE, e);
			throw new BEException("Errore nella lettura del parametro "+Constants.NUMERO_MINIMO_ID_CERTIFICATORE, e);
		}
	
	}

	
	/**
	 * Find id certificatore from num certificatore.
	 *
	 * @param numCertificatore the num certificatore
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public String findIdCertificatoreFromNumCertificatore(String numCertificatore) throws BEException {
		String idCertificatore = null;
		try {
			SiceeTCertificatore cert = getSiceeTCertificatoreDao().findWhereNumCertificatoreEquals(numCertificatore);

			if (cert != null) {
				idCertificatore = cert.getIdCertificatore();
			}
		} catch (SiceeTCertificatoreDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return idCertificatore;
	}

	public List<SiceeDBloccoCertificatore> findBloccoCertificatoreAll() throws BEException {
		List<SiceeDBloccoCertificatore> elenco = null;
		try {
			elenco = getSiceeDBloccoCertificatoreDao().findWhereFlgBloccoEquals(1);

		} catch (SiceeDBloccoCertificatoreDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return elenco;
	}
	
	public SiceeDBloccoCertificatore findBloccoCertificatoreById(Integer idStatoCert) throws BEException {
		SiceeDBloccoCertificatore stato = null;
		try {
			stato = getSiceeDBloccoCertificatoreDao().findByPrimaryKey(idStatoCert);

		} catch (SiceeDBloccoCertificatoreDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return stato;
	}
	
	public Certificatore getCertificatoreDettById(String idCertificatoreSel) throws BEException{
		SiceeTCertificatore siceeTCertificatore  = null;
		SiceeTAzienda siceeTAzienda  = null;
		SiceeDIstruzione siceeDIstruzione  = null;
		SiceeDTipoIstruzione siceeDTipoIstruzione  = null;
		Certificatore certificatoreReturn = null;
		String motivazioneBlocco = null;

		try {
			siceeTCertificatore = this.getSiceeTCertificatoreDao().findByPrimaryKey(idCertificatoreSel);
		} catch (SiceeTCertificatoreDaoException e) {
			log.error(e);
		}

		certificatoreReturn = new Certificatore();
		if (siceeTCertificatore !=  null) {
			certificatoreReturn.setId(siceeTCertificatore.getIdCertificatore());
			certificatoreReturn.setMatricola(siceeTCertificatore.getNumCertificatore());
			certificatoreReturn.setCodiceFiscale(siceeTCertificatore.getCodiceFiscale());
			certificatoreReturn.setNome(siceeTCertificatore.getNome());
			certificatoreReturn.setCognome(siceeTCertificatore.getCognome());
			certificatoreReturn.setTelefono(siceeTCertificatore.getTelefono());
			certificatoreReturn.setCell(siceeTCertificatore.getCell());
			certificatoreReturn.setEmail(siceeTCertificatore.getEmail());
			certificatoreReturn.setEmailPec(siceeTCertificatore.getEmailPec());
			certificatoreReturn.setIscrittoOrdine(siceeTCertificatore.getIscrittoOrdine());
			certificatoreReturn.setSezioneIstruzione(siceeTCertificatore.getSezione());
			certificatoreReturn.setSettoreIstruzione(siceeTCertificatore.getSettore());
			
			certificatoreReturn.setAlboApp(siceeTCertificatore.getOrdine());

			certificatoreReturn.setAlboDescrProv(siceeTCertificatore.getDescProvOrdine());
			certificatoreReturn.setAlboNumIscrizione(siceeTCertificatore.getNumIscrAlbo());
			
			certificatoreReturn.setAlboDataIscrizione(GenericUtil.convertToString(siceeTCertificatore.getDataIscrAlbo()));
			
			
			certificatoreReturn.setDtNascita(GenericUtil.convertToString(siceeTCertificatore.getDtNascita()));
			
			String comuneNascita = StringUtils.trimToEmpty(siceeTCertificatore.getDescComuneNascita());
			if (StringUtils.trimToNull(siceeTCertificatore.getDescProvNascita()) != null)
			{
				comuneNascita += " (" + siceeTCertificatore.getDescProvNascita() + ")";
			}
			certificatoreReturn.setDescComuneNascita(comuneNascita);
			
			
			if (siceeTCertificatore.getFlgResidenzaItalia().equalsIgnoreCase(Constants.FLG_S))
			{
				// Residenza italiana
				certificatoreReturn.setIndirizzo(siceeTCertificatore.getDescIndirizzo());
				certificatoreReturn.setCivicoResidenza(siceeTCertificatore.getNumCivicoResidenza());
				certificatoreReturn.setCapResidenza(siceeTCertificatore.getCap());

				String comune = StringUtils.trimToEmpty(siceeTCertificatore.getDescComuneResidenza());
				if (StringUtils.trimToNull(siceeTCertificatore.getDescProvResidenza()) != null)
				{
					comune += " (" + siceeTCertificatore.getDescProvResidenza() + ")";
				}
				certificatoreReturn.setDescComProv(comune);
			}
			else
			{
				// residenza estera
				certificatoreReturn.setIndirizzo(siceeTCertificatore.getViaEstera());
				certificatoreReturn.setCivicoResidenza(siceeTCertificatore.getCivicoEstero());
				certificatoreReturn.setCapResidenza(siceeTCertificatore.getCapEstero());

				String citta = StringUtils.trimToEmpty(siceeTCertificatore.getCittaEstera());
				if (StringUtils.trimToNull(siceeTCertificatore.getStatoResEstero()) != null)
				{
					citta += " (" + siceeTCertificatore.getStatoResEstero() + ")";
				}
				certificatoreReturn.setDescComProv(citta);
			}
			
			
			
			if (GenericUtil.isNullOrEmpty(siceeTCertificatore.getFkBloccoCertificatore())) {
				certificatoreReturn.setIdBloccoCert(null);
				//certificatoreReturn.setStatoBloccoCert("<b>NON BLOCCATO</b>");
				certificatoreReturn.setDescBloccoCert(Constants.LABEL_NON_BLOCCATO.toUpperCase());
			} else {
				certificatoreReturn.setIdBloccoCert(Integer.toString(siceeTCertificatore.getFkBloccoCertificatore()));
				motivazioneBlocco = findBloccoCertificatoreById(siceeTCertificatore.getFkBloccoCertificatore()).getDescr();
				//certificatoreReturn.setStatoBloccoCert("<b>" + motivazioneBlocco + "</b>");
				certificatoreReturn.setDescBloccoCert(motivazioneBlocco);
			}

			certificatoreReturn.setNoteBloccoCert(siceeTCertificatore.getNoteBloccoCertificatore());

			try {
				siceeTAzienda = this.getSiceeTAziendaDao().findByPrimaryKey(siceeTCertificatore.getFkAzienda());
				if (siceeTAzienda !=  null) {
					certificatoreReturn.setDenominazioneAz(siceeTAzienda.getDenominazione());
					certificatoreReturn.setPivaAz(siceeTAzienda.getPIva());
					certificatoreReturn.setIndirizzoAz(siceeTAzienda.getDescIndirizzo());
					certificatoreReturn.setCivicoAz(siceeTAzienda.getNumCivico());
					certificatoreReturn.setComuneAz(siceeTAzienda.getDescComune());
					certificatoreReturn.setCapAz(siceeTAzienda.getCap());
					certificatoreReturn.setProvAz(siceeTAzienda.getDescProv());
				}
			} catch (SiceeTAziendaDaoException e) {
				log.error(e);
			}

			try {
				siceeDIstruzione = this.getSiceeDIstruzioneDao().findByPrimaryKey(siceeTCertificatore.getFkIstruzione());
				if (siceeDIstruzione !=  null) {
					siceeDTipoIstruzione = this.getSiceeDTipoIstruzioneDao().findByPrimaryKey(siceeDIstruzione.getFkTipoIstruzione());
					if (siceeDTipoIstruzione !=  null) {
						certificatoreReturn.setTipoIstruzione(siceeDTipoIstruzione.getDescr());
					}
					certificatoreReturn.setCodiceIstruzione(siceeDIstruzione.getCodice());
					certificatoreReturn.setTitoloIstruzione(siceeDIstruzione.getDenominazione());
				}
			} catch (SiceeDIstruzioneDaoException e) {
				log.error(e);
			} catch (SiceeDTipoIstruzioneDaoException e) {
				log.error(e);
			}
		}

		GenericUtil.stampa(certificatoreReturn, true, 3);
		
		return certificatoreReturn;
	}
	
	public void bloccoSbloccoCert(String idCertificatoreSel, String bloccoCert, String noteBlocco, String nomeCert, String cognomeCert, String emailCert)
			throws BEException {
		SiceeTCertificatore siceeTCertificatore  = null;
		SiceeTCertificatorePk pk = null;
		int intBloccoCert;

		try {
			siceeTCertificatore = this.getSiceeTCertificatoreDao().findByPrimaryKey(idCertificatoreSel);
			pk = new SiceeTCertificatorePk();
			pk.setIdCertificatore(siceeTCertificatore.getIdCertificatore());
			if (GenericUtil.isNullOrEmpty(bloccoCert)) {
				siceeTCertificatore.setFkBloccoCertificatore(null);
				siceeTCertificatore.setDataBloccoCertificatore(null);
			} else {
				siceeTCertificatore.setFkBloccoCertificatore(Integer.parseInt(bloccoCert));
				siceeTCertificatore.setDataBloccoCertificatore(GenericUtil.getDataOdiernaSql());
			}
			
			if (noteBlocco != null) // Se e' nullo vuol dire che arrivo dal blocco massivo, e non devo a ndare a sovrascrivere le note
			{
				if (GenericUtil.isNullOrEmpty(noteBlocco)) {
					siceeTCertificatore.setNoteBloccoCertificatore(null);
				} else {
					siceeTCertificatore.setNoteBloccoCertificatore(noteBlocco);
				}
			}
			
			GenericUtil.stampa(siceeTCertificatore, true, 3);
			
			this.getSiceeTCertificatoreDao().update(pk, siceeTCertificatore);
			
			if (!GenericUtil.isNullOrEmpty(bloccoCert))
			{
				try {
					intBloccoCert = Integer.parseInt(bloccoCert);
					if ((intBloccoCert == Constants.STATO_CERTIFICATORE_RADIATO) || 
							(intBloccoCert == Constants.STATO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO) ||
							(intBloccoCert == Constants.STATO_CERTIFICATORE_FALSE_DICHIARAZIONI) ||
							(intBloccoCert == Constants.STATO_CERTIFICATORE_ASSENZA_CORSO) ||
							(intBloccoCert == Constants.STATO_CERTIFICATORE_MANCANZA_INFORMAZIONI) ||
							(intBloccoCert == Constants.STATO_CERTIFICATORE_MANCANZA_GENERICA) ) {
						
						getMiscMgr().sendMailNotificaCertificatore(bloccoCert, nomeCert, cognomeCert, emailCert);
	
					} 
				} catch (NumberFormatException exc) {}
			}
			else
			{
				// Vuol dire che sto sbloccando il certificatore
				getMiscMgr().sendMailNotificaSbloccoCertificatore(nomeCert, cognomeCert, emailCert);
			}
			
		} catch (SiceeTCertificatoreDaoException e) {
			//e.printStackTrace();
			log.debug(e.getMessage());
			log.error(e);
		}

	}
	
	public ArrayList<DocumentSummary> getDocumentiTitoloDiStudio(String idCert)
			throws BEException {
		ArrayList<DocumentSummary> ret = new ArrayList<DocumentSummary>();
		try {
			ArrayList<SiceeTDocumento> docList = (ArrayList<SiceeTDocumento>) this.getSiceeTDocumentoDao()
					.findTitoloDiStudio(idCert);
			
			if (docList != null && docList.size() > 0)
			{
				for (SiceeTDocumento doc : docList) {
					SiceeDTipoDocumento tipoDoc = this.getSiceeDTipoDocumentoDao().findByPrimaryKey(doc.getIdTipoDoc());
					ret.add(this.mapToDocumentSummary(doc, tipoDoc));
				}
			}
			
		} catch (SiceeTDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SiceeDTipoDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		
		log.debug("\nSTAMPO LA LISTA TITOLI DI STUDIO TROVATI (DOVREBBE ESSERE SEMPRE E SOLO UNO): "+ret);
		
		return ret;
	}

	/**
	 * Gets the curriculum.
	 *
	 * @param cert the cert
	 * @return the curriculum
	 * @throws BEException the bE exception
	 */
	public ArrayList<DocumentSummary> getCurriculum(String idCert)
			throws BEException {
		ArrayList<DocumentSummary> ret = new ArrayList<DocumentSummary>();
		try {
			SiceeTDocumento doc = this.getSiceeTDocumentoDao()
					.findWhereIdCertificatoreAndIdTipoDocEquals(
							idCert, TIPO_CURRICULUM_VITAE);
			if (doc != null) {
				SiceeDTipoDocumento tipoDoc = new SiceeDTipoDocumento();
				tipoDoc.setIdTipoDoc(Constants.ID_TIPO_DOC_CURRICULUM);
				tipoDoc.setDsTipoDoc(Constants.DESC_TIPO_DOC_CURRICULUM);
				ret.add(this.mapToDocumentSummary(doc, tipoDoc));
			}
		} catch (SiceeTDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		return ret;
	}
	
	public ArrayList<CorsoAttestatoSummary> getDocumentiPartecipazioneNew(String codFiscale)
			throws BEException {
		ArrayList<CorsoAttestatoSummary> ret = new ArrayList<CorsoAttestatoSummary>();
		try {
			log.debug("\ngetDocumentiPartecipazioneNew :: CF CERTIFICATORE : "+ codFiscale);
			ArrayList<OptimizedSiceeTCorso2015> docList = (ArrayList<OptimizedSiceeTCorso2015>) this.getOptimizedSiceeTCorso2015Dao()
					.executeByCodiceFiscale(codFiscale);
			for (OptimizedSiceeTCorso2015 doc : docList) {
				ret.add(this.mapToCorsoAttestatoSummary(doc));
			}
		} catch (OptimizedSiceeTCorso2015DaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		
		log.debug("\nSTAMPO LA LISTA CORSI/DOCUMENTI TROVATI (NEW): "+ ret);
		
		return ret;
	}
	
	public ArrayList<DocumentSummary> getDocumentiPartecipazioneOld(String idCert)
			throws BEException {
		ArrayList<DocumentSummary> ret = new ArrayList<DocumentSummary>();
		try {
			ArrayList<SiceeTDocumento> docList = (ArrayList<SiceeTDocumento>) this.getSiceeTDocumentoDao()
					.findAttPartOld(idCert);
			
			for (SiceeTDocumento doc : docList) {
				SiceeDTipoDocumento tipoDoc = this.getSiceeDTipoDocumentoDao().findByPrimaryKey(doc.getIdTipoDoc());
				ret.add(this.mapToDocumentSummary(doc, tipoDoc));
			}
			
		} catch (SiceeTDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SiceeDTipoDocumentoDaoException e) {
			throw new BEException(e.getMessage(), e);
		}
		
		log.debug("\nSTAMPO LA LISTA DOCUMENTI TROVATI (OLD): "+ret);
		
		return ret;
	}
	
	private DocumentSummary mapToDocumentSummary(SiceeTDocumento doc, SiceeDTipoDocumento tipoDoc) {
		DocumentSummary cv = new DocumentSummary();
		cv.setCod(convertToString(tipoDoc.getIdTipoDoc()));
		cv.setTipo(tipoDoc.getDsTipoDoc());
		cv.setNome(doc.getNomeFile());
		cv.setFlgScarico("Scarica");
		cv.setUid(doc.getIdentificDoc());
		cv.setDataUpload(GenericUtil.convertToString(doc.getDtUpload()));
		return cv;
	}
	
	private CorsoAttestatoSummary mapToCorsoAttestatoSummary(OptimizedSiceeTCorso2015 doc) {
		CorsoAttestatoSummary cas = new CorsoAttestatoSummary();
		cas.setIdCorso(GenericUtil.convertToString(doc.getIdCorso()));
		cas.setTitolo(doc.getTitolo());
		cas.setDenominazione(doc.getDenominazione());
		cas.setTotaleOre(GenericUtil.convertToString(doc.getTotaleOre()));
		cas.setDataEsame(GenericUtil.convertToString(doc.getDataEsame()));
		cas.setEsitoEsame(doc.getEsitoEsame());
		cas.setUid(doc.getIdentificDoc());
		cas.setFlgScarico("");
		return cas;
	}
	
}
