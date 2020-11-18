/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceebo.business.facade;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.sicee.siceebo.business.BEException;
import it.csi.sicee.siceebo.dto.LabelValue;
import it.csi.sicee.siceebo.dto.ace.Ace;
import it.csi.sicee.siceebo.dto.geo.Comune;
import it.csi.sicee.siceebo.dto.geo.Provincia;
import it.csi.sicee.siceebo.dto.geo.Regione;
import it.csi.sicee.siceebo.dto.geo.Indirizzo;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.Converter;
import it.csi.sicee.siceebo.util.GenericUtil;
import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
import it.csi.sicee.siceeorch.dto.siceeorch.Via;
import it.csi.sicee.siceeorch.exception.siceeorch.DocumentoException;
import it.csi.sicee.siceeorch.exception.siceeorch.SiceesrvException;
import it.csi.sicee.siceeorch.exception.siceeorch.ToponomasticaException;
import it.csi.sicee.siceeorch.interfacecsi.siceeorch.SiceeorchSrv;
import it.csi.sicee.siceews.stubs.Allegato;
import it.csi.sicee.siceews.stubs.SiceewsMgrLocator;
import it.csi.sicee.siceews.stubs.SiceewsMgrSoapBindingStub;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.rpc.ServiceException;

// TODO: Auto-generated Javadoc
/**
 * Questa classe rappresenta il punto di contatto tra lo strato spring della web application
 * e il servizio di orchestrazione siceeorch.
 *
 * @author 869
 */
public class SOAIntegrationMgr extends BaseMgr{

	/** The srv. */
	protected static SiceeorchSrv srv;
	protected static SiceewsMgrSoapBindingStub srvSiceews;
	/** The Constant PD_SORCH_RES. */
	public final static String PD_SORCH_RES = "/META-INF/defpd_siceeorch.xml";
	
	private static String wsSiceeUrl = null;

	/**
	 * @param prot protocollo di richiamo del PEP. Puo' valere: 
	 * 1) EJB (default)
	 * 2) WS
	 * utilizzato solo se la security non e' custom
	 */
	public void setWSSiceeUrl(String ws) {
		log.debug("Stampo il ws passato: "+ws);
		wsSiceeUrl = ws;
	}

	public static String getWSSiceeUrl() {
		return wsSiceeUrl;
	}
	
	// Questo metodo non serve piu' perche' srvSiceews viene creato quando si istanzia la classe, lo lascio per sicurezza
	private static SiceewsMgrSoapBindingStub getWSSicee()
	{
		if (srvSiceews == null)
		{
			SiceewsMgrLocator loc = new SiceewsMgrLocator();
			//+Constants.WS_SICEEWS_URL
//			log.debug("SOAIntegrationMgr - PASSO 1: "+Constants.WS_SICEEWS_URL);
//			loc.setSiceewsMgrWSPortEndpointAddress(Constants.WS_SICEEWS_URL);
			log.debug("SOAIntegrationMgr - PASSO 2");
			try {
				srvSiceews = (SiceewsMgrSoapBindingStub) loc.getSiceewsMgrWSPort();
				
				log.debug("SOAIntegrationMgr - PASSO 3");
	
			} catch (Exception e) {
				log.error("ERRORE nell caricamento del WS si SICEEWS:"+e, e); // TODO log4j
			}
			catch (Throwable t)
			{
				log.debug("SOAIntegrationMgr - PASSO 4");
				
				log.error(t);
				log.debug("SOAIntegrationMgr - PASSO 5");
	
			}
		}
		return srvSiceews;
	}
	
	
	static{
		
		InputStream is = SOAIntegrationMgr.class.getResourceAsStream(PD_SORCH_RES);
		if (is != null){
			try {
				InfoPortaDelegata info = PDConfigReader.read(is);
				srv = (SiceeorchSrv)PDProxy.newInstance(info);
			} catch (Exception e) {
				log.error("ERRORE nell caricamento della PD del servizio di orchestrazione:"+e, e); // TODO log4j
			}
		}
		else{
			log.error("ERRORE nell caricamento della PD del servizio di orchestrazione:input stream nullo"); // TODO log4j
		}
		
		
		SiceewsMgrLocator loc = new SiceewsMgrLocator();
		//+Constants.WS_SICEEWS_URL
		log.debug("SOAIntegrationMgr - PASSO 1: "+Constants.WS_SICEEWS_URL);
		loc.setSiceewsMgrWSPortEndpointAddress(Constants.WS_SICEEWS_URL);
		log.debug("SOAIntegrationMgr - PASSO 2");
		try {
			srvSiceews = (SiceewsMgrSoapBindingStub) loc.getSiceewsMgrWSPort();
			
			log.debug("SOAIntegrationMgr - PASSO 3");

		} catch (Exception e) {
			log.error("ERRORE nell caricamento del WS si SICEEWS:"+e, e); // TODO log4j
		}
		catch (Throwable t)
		{
			log.debug("SOAIntegrationMgr - PASSO 4");
			
			log.error(t);
			log.debug("SOAIntegrationMgr - PASSO 5");

		}
		
	}
	

	/**
	 * Gets the province by piemonte.
	 *
	 * @return the province by piemonte
	 * @throws BEException the bE exception
	 */
	public ArrayList<Provincia> getProvinceByPiemonte() throws BEException{
		ArrayList<Provincia> ris = new ArrayList<Provincia>();
			try {
				ris = this.getProvinceByRegione(Constants.COD_REGIONE_PIEMONTE);
			} catch (BEException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			}
			
			return ris;
	}

	/**
	 * Gets the regioni.
	 *
	 * @return the regioni
	 * @throws BEException the bE exception
	 */
	public ArrayList<Regione> getRegioni() throws BEException{
		ArrayList<Regione> ris = new ArrayList<Regione>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Regione [] regioni = 
				srv.elencoRegioni();
			if (regioni!=null){
				for(it.csi.sicee.siceeorch.dto.siceeorch.Regione currProv:regioni){
					Regione currRis = new Regione();
					currRis.setCod(currProv.getCod());
					currRis.setNome(currProv.getNome());
					ris.add(currRis);
				}
			}
		} catch (ToponomasticaException e) {
			throw new BEException("Errore in getRegioni:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getRegioni:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getRegioni:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getRegioni:" + e, e);
		}
		return ris;
	}

	/**
	 * Gets the province by regione.
	 *
	 * @param codRegione the cod regione
	 * @return the province by regione
	 * @throws BEException the bE exception
	 */
	public ArrayList<Provincia> getProvinceByRegione(String codRegione) throws BEException{
		ArrayList<Provincia> ris = new ArrayList<Provincia>();
		if (codRegione !=null && codRegione.length()>0){
			try {
				it.csi.sicee.siceeorch.dto.siceeorch.Provincia [] province = 
					srv.elencoProvince(codRegione);
				if (province!=null){
					for(it.csi.sicee.siceeorch.dto.siceeorch.Provincia currProv:province){
						Provincia currRis = new Provincia();
						currRis.setCod(currProv.getCod());
						currRis.setNome(currProv.getNome());
						ris.add(currRis);
					}
				}
				return ris;
			} catch (ToponomasticaException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			} catch (SystemException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			} catch (CSIException e) {
				throw new BEException("Errore in getProvince della regione:" + e, e);
			}
		}
		else
			return ris;
	}

	
	/**
	 * Gets the comuni by provincia.
	 *
	 * @param codProvincia the cod provincia
	 * @return the comuni by provincia
	 * @throws BEException the bE exception
	 */
	public ArrayList<Comune> getComuniByProvincia(String codProvincia) throws BEException{
		ArrayList<Comune> ris = new ArrayList<Comune>();
		if (codProvincia !=null && codProvincia.length()>0){
			try {
				it.csi.sicee.siceeorch.dto.siceeorch.Comune [] comuni = 
					srv.elencoComuni(codProvincia);
				
				if (comuni!=null){
					for(it.csi.sicee.siceeorch.dto.siceeorch.Comune currCom:comuni){
						Comune currRis = new Comune();
						currRis.setCod(currCom.getCod());
						currRis.setNome(currCom.getNome());
						ris.add(currRis);
					}
				}
				return ris;
			} catch (ToponomasticaException e) {
				throw new BEException("Errore in getComuni della provincia:" + e, e);
			} catch (SystemException e) {
				throw new BEException("Errore in getComuni della provincia:" + e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore in getComuni della provincia:" + e, e);
			} catch (CSIException e) {
				throw new BEException("Errore in getComuni della provincia:" + e, e);
			}
		}
		else
			return ris;
	}

	/**
	 * Verifica indirizzi.
	 *
	 * @param descrIndirizzo the descr indirizzo
	 * @param codIstatComune the cod istat comune
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public List<Indirizzo> verificaIndirizzi(String descrIndirizzo,
			String codIstatComune) throws BEException {
		if (descrIndirizzo == null || descrIndirizzo.length() == 0
				|| codIstatComune == null) {
			return new ArrayList<Indirizzo>();
		} else {
			descrIndirizzo = descrIndirizzo.trim();
			Via[] vie;
			ArrayList<Indirizzo> indirizzi = new ArrayList<Indirizzo>();
			try {
				vie = srv.getVieByCodiceIstat(descrIndirizzo, codIstatComune);
			} catch (ToponomasticaException e) {
				throw new BEException("Errore nella verifica indirizzo: " + e,
						e);
			} catch (SystemException e) {
				throw new BEException("Errore nella verifica indirizzo: " + e,
						e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore nella verifica indirizzo: " + e,
						e);
			} catch (CSIException e) {
				throw new BEException("Errore nella verifica indirizzo: " + e,
						e);
			}
			if (vie != null) {
				for (Via via : vie) {
					Indirizzo curr = new Indirizzo();
					curr.setCod(via.getId());
					curr.setDescr(via.getDenominazione());
					indirizzi.add(curr);
				}
			}
			
			log.debug("STAMPO GLI INDIRIZZI: "+indirizzi);
			return indirizzi;
		}

	}

	/**
	 * Gets the indirizzo by id.
	 *
	 * @param id the id
	 * @return the indirizzo by id
	 * @throws BEException the bE exception
	 */
	public Indirizzo getIndirizzoById(Integer id) throws BEException {
		if (id == null) {
			return null;
		} else {
			try {
				Via via = srv.getViaById(id);
				if (via != null) {
					Indirizzo ris = new Indirizzo();
					ris.setCod(id);
					ris.setDescr(via.getDenominazione());
					return ris;
				} else {
					return null;
				}
			} catch (ToponomasticaException e) {
				throw new BEException("Errore nella lookup indirizzo: " + e, e);
			} catch (SystemException e) {
				throw new BEException("Errore nella lookup indirizzo: " + e, e);
			} catch (UnrecoverableException e) {
				throw new BEException("Errore nella lookup indirizzo: " + e, e);
			} catch (CSIException e) {
				throw new BEException("Errore nella lookup indirizzo: " + e, e);
			}
		}
	}

	/**
	 * Recupera documento.
	 *
	 * @param uid the uid
	 * @return the documento
	 */
	public Documento recuperaDocumento(String uid) {
		Documento docRet = null;
		try {
			Documento doc = new Documento();
			doc.setUid(uid);
			docRet = srv.ricercaDocumento(doc);
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		return docRet;
	}

	/**
	 * Restore documento.
	 *
	 * @param uid the uid
	 * @return the documento
	 */
	public String restoreFile(String uid) {
		Documento doc = new Documento();
		doc.setUid(uid);
		
		String ret = null;
		try {
			ret = srv.restoreDocumento(doc);
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		return ret;
	}
	
	/**
	 * Recupera documento.
	 *
	 * @param uid the uid
	 * @return the documento
	 */
	public String findUidRifIndex(Ace certificato, Integer idTipoDoc) {
		String uid = null;
		try {
			uid = srv.findUidRifIndex(certificato.getNumCertificatore(), certificato.getProgrCertificato(), certificato.getAnno(), idTipoDoc);
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		return uid;
	}

	
	
	/**
	 * Gets the stampa documento annullato.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the stampa documento annullato
	 */
	public byte[] getStampaDocumentoAnnullato(String numeroCertificato) {
		//Documento doc = new Documento();
		//doc.setUid(uid);
		byte[] byteDoc = null;
		try {
			String[] split = numeroCertificato.split(" ");
			
			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];
			
			byteDoc = srv.getStampaCertificato(numCertificatore, progrCertificato, annoCertificato, Constants.LABEL_ANNULLATO);
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
		return byteDoc;
	}
	
	/**
	 * Gets the stampa certificato.
	 *
	 * @param numeroCertificato the numero certificato
	 * @param scrittaSfondo the scritta sfondo
	 * @return the stampa certificato
	 */
	public byte[] getStampaCertificato(String numeroCertificato, String scrittaSfondo) {
		byte[] ret = null;
		try {

			String[] split = numeroCertificato.split(" ");
			
			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];
		
			ret = srv.getStampaCertificato(numCertificatore, progrCertificato, annoCertificato, scrittaSfondo);

		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		}
		return ret;
	}

	/**
	 * Gets the stampa dettaglio.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the stampa dettaglio
	 */
	public ArrayList<LabelValue> getDettaglioAce(String numeroCertificato) {
		ArrayList<LabelValue> ret = new ArrayList<LabelValue>();
		try {

			String[] split = numeroCertificato.split(" ");
			
			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];
						
			it.csi.sicee.siceeorch.dto.siceeorch.LabelValue [] labelValueA = 
					srv.getDettaglioAce(numCertificatore, progrCertificato, annoCertificato);
				
			LabelValue currRis = null;
				if (labelValueA!=null){
					
					for (it.csi.sicee.siceeorch.dto.siceeorch.LabelValue labelValue : labelValueA) {
						currRis = new LabelValue();
						currRis.setLabel(labelValue.getLabel());
						currRis.setValue(labelValue.getValue());
						ret.add(currRis);
					}
					
					
				}

		} catch (SystemException e) {
			log.error(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
		}
		return ret;
	}
	
	/**
	 * Gets the stampa ricevuta invio ace.
	 *
	 * @param numeroCertificato the numero certificato
	 * @return the stampa ricevuta invio ace
	 * @throws BEException the bE exception
	 */
	public byte[] getStampaRicevutaInvioAce(String numeroCertificato)
			throws BEException {
		byte[] ret = null;
		try {

			String[] split = numeroCertificato.split(" ");

			String numCertificatore = split[Constants.PK_NUM_CERTIFICATORE];
			String progrCertificato = split[Constants.PK_PROGR];
			String annoCertificato = split[Constants.PK_ANNO];

			ret = srv.getStampaRicevutaInvioAce(numCertificatore,
					progrCertificato, annoCertificato);

			return ret;
		} catch (SiceesrvException e) {
			throw new BEException("Errore in getStampaRicevutaInvioAce:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getStampaRicevutaInvioAce:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getStampaRicevutaInvioAce:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getStampaRicevutaInvioAce:" + e, e);
		}
	}
	
	/**
	 * Find ace sostitutivi.
	 *
	 * @param aceOld the ace old
	 * @return the array list
	 * @throws BEException the bE exception
	 */
	public ArrayList<Ace> findAceSostitutivi(Ace aceOld) throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Ace[] ace = 
				srv.findAceSostitutivi(convertTo(aceOld));
			if (ace != null) {
//				it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = srv.findCertificatore(filtro.getCertificatore());
//				if (cert != null) {
//					ace.setCertificatore(cert.getMatricola());
//				}

				for (int i = 0; i < ace.length; i++) {
					ret.add(convertTo(ace[i]));	
				}
				
				
				
			}
			
			
			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		}
	}

	public byte[] recuperaStampaCertificatoReadOnly(String idCertificatore, String progrCertificato, String anno, Integer idStatoCertificato) throws BEException {
		byte[] docXml = null;
		try {
			
			
			docXml = srv.getStampaCertificatoIText(idCertificatore, progrCertificato, anno, idStatoCertificato);
			
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly:" + e, e);

		} catch (SystemException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly:" + e, e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly:" + e, e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly:" + e, e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoReadOnly:" + e, e);
		}
		
		return docXml;
	}
	
	public byte[] recuperaStampaCertificatoIText(String idCertificatore, String progrCertificato, String anno, Integer idStatoCertificato) throws BEException {
		byte[] docPdf = null;
		try {
			
			
			docPdf = srv.getStampaCertificatoIText(idCertificatore, progrCertificato, anno, idStatoCertificato);
			
		} catch (DocumentoException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoIText:" + e, e);

		} catch (SystemException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoIText:" + e, e);
		} catch (UnrecoverableException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoIText:" + e, e);
		} catch (CSIException e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoIText:" + e, e);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new BEException("Errore in recuperaStampaCertificatoIText:" + e, e);
		}
		
		return docPdf;
	}
	/**
	 * Convert to.
	 *
	 * @param filtro the filtro
	 * @return the it.csi.sicee.siceeorch.dto.siceeorch. filtro ricerca ace
	 */
	private it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce convertTo(Ace filtro) {
		it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce ret = new it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce();
		ret.setAnno(filtro.getAnno());
		ret.setCertificatore(filtro.getNumCertificatore());
		ret.setNumero(filtro.getProgrCertificato());
		
		return ret;
	}
	
	/**
	 * Convert to.
	 *
	 * @param ace the ace
	 * @return the ace
	 */
	private Ace convertTo(it.csi.sicee.siceeorch.dto.siceeorch.Ace ace) {
		Ace ret = new Ace();
		ret.setCodice(ace.getAnno() + " " + ace.getCertificatore() + " " + ace.getNumero());
		ret.setDescStato(ace.getDescStato());
		return ret;
	}
	
	
	/**
	 * Salva documento.
	 *
	 * @param cert the cert
	 * @param bytes the bytes
	 * @param nomeAttestato the nome attestato
	 * @param contentType the content type
	 * @param length the length
	 * @return the string
	 * @throws BEException the bE exception
	 */
	public String salvaDocumento(String idCertificatore, String progrCertificato, String anno, byte[] bytes,
			String nomeAttestato, String tipoDocumentoIndex, String numeroCertificato)
			throws BEException {
		Documento doc = new Documento();
		String uid = null;
		try {

//			doc.setMatricola(cert.getNumCertificatore());
//			doc.setIdCertificatore(cert.getIdCertificatore());
//			doc.setDoc(bytes);
//			doc.setNome(nomeAttestato);
//			doc.setMimeType("application/pdf");
//			doc.setEncoding("UTF-8");
//			doc.setDimensione(new Long(bytes.length));
//			doc.setDataUpload(new Date(System.currentTimeMillis()));
//			doc.setTipologia(tipoDocumentoIndex);
//
//			doc.setDataUpload(new Date(System.currentTimeMillis()));
//
//			
			
			

			
			doc = new Documento();
			doc.setAttestato(numeroCertificato);
			doc.setDoc(bytes);
			doc.setNome(nomeAttestato);
			doc.setMimeType("application/pdf");
			doc.setEncoding("UTF-8");
			doc.setDimensione(new Long(bytes.length));
			
//			doc.setClasseEnergetica(att.getClasseEnerg().getLocTeorica()
//					.getDescClasseEnerg());
			
//			doc.setComune(att.getDatiAnagraficiImm().getDtCatastali()
//					.getDescrComune());
//			doc.setDestinazione(att.getDatiTecnici().getDestUso());
			//doc.setTipologia(tipoDocumentoIndex);
			doc.setTipologia(tipoDocumentoIndex);
			doc.setAnnoCertificato(anno);
			doc.setIdCertificatore(idCertificatore);
			doc.setProgrCertificato(progrCertificato);
			doc.setDataUpload(new Date(System.currentTimeMillis()));
			
			
			
			uid = srv.inserisciDocumento(doc);
			
//			srv.creaAlberatura(cert.getNumCertificatore(), "doc", 0, 0);
//			uid = srv.inserisciAllegato(doc);

			if (BaseMgr.isNullOrEmpty(uid)) {
				throw new DocumentoException("Attestato : "
						+ nomeAttestato + " UID null!!!");
			}
			
			/*
			else {
				
				
				SiceeTDocumento dto = (SiceeTDocumento) this
						.getSiceeTDocumentoDao()
						.findWhereIdCertificatoreAndIdTipoDocEquals(
								cert.getIdCertificatore(), tipoDocumentoDB);
				if (dto != null) {
					String u = dto.getIdentificDoc();
					if (!BaseMgr.isNullOrEmpty(u) && !u.equals(uid)) {
						Documento docOrch = new Documento();
						docOrch.setUid(u);
						try {
							srv.cancellaDocumento(docOrch);
						} catch (DocumentoException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (SystemException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (UnrecoverableException e) {
							log.warn("Warning cancellazione documento", e);
						} catch (CSIException e) {
							log.warn("Warning cancellazione documento", e);
						}
					}
				}
			}
			*/

		} catch (DocumentoException e) {
			throw new BEException(e.getMessage(), e);
		} catch (SystemException e) {
			throw new BEException(e.getMessage(), e);
		} catch (UnrecoverableException e) {
			throw new BEException(e.getMessage(), e);
		} catch (CSIException e) {
			throw new BEException(e.getMessage(), e);
		} 
		return uid;
	}

	/**
	 * Gets the regioni.
	 *
	 * @return the regioni
	 * @throws BEException the bE exception
	 */
	public Integer getStatoTransazioneMdpOld(Integer transazione) throws BEException{
		Integer statoTrans = null;
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Transazione trans = 
				srv.getMdpTransactionState(Converter.convertToString(transazione));
			if (trans!=null){
				statoTrans = Converter.convertToInteger(trans.getCodStato());
			}
		} catch (ToponomasticaException e) {
			throw new BEException("Errore in getRegioni:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in getRegioni:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getRegioni:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getRegioni:" + e, e);
		}
		return statoTrans;
	}

	public String[] getStatoTransazioneMdp(ArrayList<String> elencoTrans) throws BEException{
		String[] resultErrorList = null;
		try {
//			SiceewsMgrLocator loc = new SiceewsMgrLocator();
//			loc.setSiceewsMgrWSPortEndpointAddress("http://localhost:8080/siceews/SiceewsMgr/SiceewsMgrWS?wsdl");
//			
//			SiceewsMgrSoapBindingStub binding = (SiceewsMgrSoapBindingStub) loc.getSiceewsMgrWSPort();
			
			log.debug("getStatoTransazioneMdp - PASSO 1");
			
			boolean isAlive = getWSSicee().isAlive();

			log.debug("getStatoTransazioneMdp - PASSO 2: "+isAlive);

			//System.out.println("isAlive: "+isAlive);

			resultErrorList = getWSSicee().recuperaStatoTransazione(elencoTrans.toArray(new String[elencoTrans.size()]));

			log.debug("getStatoTransazioneMdp - PASSO 3: "+resultErrorList);

			//System.out.println("Dopo della chiamta SICEEWS");
			
		} catch (Exception e) {
			
			log.error("Sono in Exception");
			
			log.error(e);
			
			throw new BEException("Errore in getStatoTransazioneMdp:" + e, e);
		}
		catch (Throwable t)
		{
			log.error("Sono in Throwable");
			
			log.error(t);
			
			throw new BEException("Errore in getStatoTransazioneMdp:" + t, null);
		}
		return resultErrorList;
	}
	
	public String[] getRecuperaRT(ArrayList<String> elencoTrans) throws BEException{
		String[] resultErrorList = null;
		try {
//			SiceewsMgrLocator loc = new SiceewsMgrLocator();
//			loc.setSiceewsMgrWSPortEndpointAddress("http://localhost:8080/siceews/SiceewsMgr/SiceewsMgrWS?wsdl");
//			
//			SiceewsMgrSoapBindingStub binding = (SiceewsMgrSoapBindingStub) loc.getSiceewsMgrWSPort();
			log.debug("Prima di getWSSicee");
			
			boolean isAlive = getWSSicee().isAlive();

			log.debug("isAlive: "+isAlive);

			resultErrorList = getWSSicee().recuperaRT(elencoTrans.toArray(new String[elencoTrans.size()]));

			log.debug("Dopo della chiamta SICEEWS");
			
		} catch (Exception e) {
			throw new BEException("Errore in getRecuperaRT:" + e, e);
		}
		return resultErrorList;
	}

/*
	
	private it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce convertTo(FiltroRicercaAce filtro) {
		it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce ret = new it.csi.sicee.siceeorch.dto.siceeorch.FiltroRicercaAce();
		ret.setAnno(filtro.getAnnoCertificato());
		ret.setCertificatore(filtro.getCertificatore());
		ret.setNumero(filtro.getProgCertificato());
		
		return ret;
	}
	
	private Ace convertTo(it.csi.sicee.siceeorch.dto.siceeorch.Ace ace) {
		Ace ret = new Ace();
		String indirizzo = ace.getIndirizzo();
		if (!isNullOrEmpty(ace.getCivico())) {
			indirizzo = indirizzo + ", " + ace.getCivico() + " - ";
		}
		indirizzo = indirizzo + ace.getComune() + " - (" + ace.getProvincia() + ")";

		ret.setDescIndirizzo(indirizzo);
		ret.setCodice(ace.getAnno() + " " + ace.getCertificatore() + " " + ace.getNumero());
		ret.setAnno(ace.getAnno());
		ret.setCertificatore(ace.getCertificatore());
		ret.setNumero(ace.getNumero());
		ret.setDataInvio(convertToString(ace.getDataInvio()));
		ret.setUid(ace.getUid());
		ret.setCognome(ace.getCognome());
		ret.setNome(ace.getNome());
		ret.setDataUpload(convertToString(ace.getDataUpload()));
		ret.setFlgInviato("ModuloACE");
		ret.setFlgRicevuta("Ricevuta");
		
		return ret;
	}
	
	
	public ArrayList<Ace> findAce(it.csi.sicee.siceeweb.dto.ace.FiltroRicercaAce filtro) throws BEException {
		ArrayList<Ace> ret = new ArrayList<Ace>();
		try {
			it.csi.sicee.siceeorch.dto.siceeorch.Ace ace = 
				srv.findAce(convertTo(filtro));
			if (ace != null) {
				it.csi.sicee.siceeorch.dto.siceeorch.Certificatore cert = srv.findCertificatore(filtro.getCertificatore());
				if (cert != null) {
					ace.setCertificatore(cert.getMatricola());
				}
				ret.add(convertTo(ace));
			}
			
			
			return ret;
		} catch (SystemException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in getProvince della regione:" + e, e);
		}
	}
	*/
	
	public boolean sendMailService(it.csi.sicee.siceebo.util.Mail emailVo) throws BEException{
		log.info("[SOAIntegrationMgr::sendMailService] START");

		boolean isMailInviata = false;
		try {
			log.info("Prima di getWSSicee");
			
//			boolean isAlive = getWSSicee().isAlive();
//
//			log.debug("isAlive: "+isAlive);

			it.csi.sicee.siceews.stubs.Mail mailService = new it.csi.sicee.siceews.stubs.Mail();
			
			mailService.setMittente(emailVo.getMittente());
			mailService.setDestinatario(emailVo.getDestinatario());
			mailService.setDestinatarioCC(emailVo.getDestinatarioCC());
			mailService.setOggetto(emailVo.getOggetto());
			mailService.setHtml(emailVo.getHtml());
			
			/*
			ArrayList<Allegato> elencoAllegati = new ArrayList<Allegato>();

			if (doc != null)
			{
				
				it.csi.sicee.siceews.stubs.Allegato allegatoApe = new Allegato();
				allegatoApe.setNomeFile(doc.getNome());
				allegatoApe.setContentType("application/pkcs7-mime");
				allegatoApe.setFile(doc.getDoc());
				elencoAllegati.add(allegatoApe);

			}
			
			if (ricevutaInvioByte != null)
			{
				it.csi.sicee.siceews.stubs.Allegato allegatoRicevuta = new Allegato();
				allegatoRicevuta.setNomeFile("ricevuta_trasmissione.pdf");
				allegatoRicevuta.setContentType("application/pdf");
				allegatoRicevuta.setFile(ricevutaInvioByte);
				elencoAllegati.add(allegatoRicevuta);
			}
			
			if (elencoAllegati.size() > 0)
			{
				
				it.csi.sicee.siceews.stubs.Allegato[] elencoAllegatiNew = new it.csi.sicee.siceews.stubs.Allegato[elencoAllegati.size()]; 
				elencoAllegatiNew = elencoAllegati.toArray(elencoAllegatiNew);
				
				mailService.setElencoAllegati(elencoAllegatiNew);
			
			}
			*/
			isMailInviata = getWSSicee().invioMail(mailService);

			log.info("Dopo della chiamta SICEEWS");
			
		} catch (Exception e) {
			log.error("[SOAIntegrationMgr::sendMailService] - Errore nell'invio della mail", e);
			throw new BEException("Errore nell'invio della mail:" + e, e);
		}
		finally {
			log.info("[SOAIntegrationMgr::sendMailService] END");
		}
		return isMailInviata;
	}
	
	public void insertLogAccesso(String codiceFiscale, String nome, String cognome, String ruolo) throws BEException {
		try {
			srv.insertLogAccesso(codiceFiscale, nome, cognome, ruolo);
		} catch (SiceesrvException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		} catch (SystemException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		} catch (UnrecoverableException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		} catch (CSIException e) {
			throw new BEException("Errore in insertLogAccesso:" + e, e);
		}

	}
}
