/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.facade;

import it.csi.csi.porte.InfoPortaDelegata;
import it.csi.csi.porte.proxy.PDProxy;
import it.csi.csi.util.xml.PDConfigReader;
import it.csi.csi.wrapper.CSIException;
import it.csi.csi.wrapper.SystemException;
import it.csi.csi.wrapper.UnrecoverableException;
import it.csi.csi.wrapper.UserException;
//import it.csi.modol.modolpdfgeneratorsrv.dto.pdfa.PdfAInputRequest;
//import it.csi.modol.modolpdfgeneratorsrv.interfacecsi.ModolPdfGeneratorSrvITF;
//import it.csi.modol.modolsrv.dto.Applicazione;
//import it.csi.modol.modolsrv.dto.Modulo;
//import it.csi.modol.modolsrv.dto.ProcessFormRequest;
//import it.csi.modol.modolsrv.dto.ProcessFormResponse;
//import it.csi.modol.modolsrv.dto.Utente;
//import it.csi.modol.modolsrv.dto.XmlModel;
//import it.csi.modol.modolsrv.dto.criteri.CriterioRicercaModulo;
//import it.csi.modol.modolsrv.dto.utility.RendererModalityExpert;
import it.csi.sicee.siceebo.business.print.dto.ApeDto;
//import it.csi.modol.modolsrv.interfacecsi.ModolSrvITF;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.Messages;
import it.csi.sicee.siceebo.util.XmlBeanUtils;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceebo.business.facade.BaseMgr;
import it.csi.sicee.siceeorch.exception.siceeorch.DocumentoException;
import it.csi.sicee.siceeweb.xml.attestato.data.MODDocument;
import it.csi.sicee.siceebo.util.MapDto;
import it.csi.sicee.siceebo.business.facade.CertificatoMgr;
import it.csi.sicee.siceebo.business.facade.exceptions.ServiceException;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertXml2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTAzienda;







import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;


public class ServiziMgr {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business.manager");
	
	private final String MODOL_RESOURCE = "/META-INF/defpd_modolsrv.xml";
	private final String MODOL_PDF_RESOURCE = "/META-INF/defpd_modolpdfgeneratorsrv.xml";

	protected CertificatoMgr certificatoMgr;
	
	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}
	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}
	
	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

//	public ModolSrvITF getModolOld() {
//		log.debug("[ServiziMgr::getModol] BEGIN");
//		InputStream is = getClass().getResourceAsStream(MODOL_RESOURCE);
//		if (is != null) {
//			try {
//				InfoPortaDelegata info = PDConfigReader.read(is);
//				log.debug("[ServiziMgr::getModol] END");
//				return (ModolSrvITF) PDProxy.newInstance(info);
//			} 
//			catch (Exception e) {
//				log.error("[ServiziMgr::getModol] errore nella parsificazione della configurazione di MODOL:"+ e, e);
//				throw new IllegalArgumentException("errore nella parsificazione della configurazione di MODOL");
//			}
//		} else{
//			log.error("[ServiziMgr::getModol] configurazione di MODOL non trovata");
//		}
//		throw new IllegalArgumentException("configurazione di MODOL non trovata");
//	}
		
//	public byte[] getXmlFromPdfOld(byte[] thePdf){
//		log.debug("[AllegatoBuilder:getXmlFromPdf] START");
//
//		Applicazione app;
//		Utente utente;
//		
//		byte[] file;
//		app = new Applicazione();
//		app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
//		utente = null;
//		 try {
//			file = getXmlFromModolOld(app,utente,thePdf); //recupero l'xml da modol
//		} catch (ServiceException e) {
//			log.error("Errore in getXmlFromPdf() - recupero dati xml da MODOL" + e.getMessage());
//			log.error("Stampo l'eccezione: ",e);
//			return null;
//		}
//		log.debug("[AllegatoBuilder:getXmlFromPdf] END");
//		 return file;
//	}
	
//	public byte[] getXmlFromModolOld(Applicazione app, Utente utente, byte[] thePdf) throws ServiceException {
//		log.debug("[SigitMgr::getXmlFromModol] BEGIN");
//		try {
//			return getXmlFromModolServOld(app, utente, thePdf);
//		}
//		catch(Exception e) {
//			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
//		}
//		finally {
//			log.debug("[SigitMgr::getXmlFromModol] END");
//		}
//	}
	
//	public byte[] getXmlFromModolServOld(Applicazione app, Utente utente, byte[] thePdf) throws ServiceException {
//		log.debug("[ServiziMgr::getXmlFromModol] BEGIN");
//		ProcessFormRequest pfr = new ProcessFormRequest();
//		pfr.setContenuto(thePdf);
//		try {
//			ProcessFormResponse response=  getModolOld().processForm(app, utente, pfr);
//			log.debug("DATI XML FROM MODOL " + "\\n" + new String(response.getDatiXml()));
//			return response.getDatiXml(); //ritorna l'xml con i dati, per metterlo in xmlBean usare AllegatoG Document
//		} catch (SystemException e) {
//			log.error(e.getStackTrace());
//			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
//		} catch (UserException e) {
//			log.error(e.getStackTrace());
//			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
//		}finally{
//			log.debug("[ServiziMgr::getXmlFromModol] END");
//		}
//	}
	
	
	
//	public byte[] showModuloModolOld(Applicazione app, String codModuloModol, Utente utente, XmlModel xmlModel) throws ServiceException {
//		log.debug("[ServiziMgr::showModuloModol] BEGIN");
//		try
//		{
//			Modulo modulo = cercaModuloOld(app, codModuloModol);
//			log.debug("CODICE MODULO MODOL: "  + codModuloModol);
//			if(modulo!=null)
//			{
//				
//				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
//				
//				log.debug("########################################");
//				log.debug("faccio la merge");
//				log.debug("xmlModel: "+xmlModel.toString());
//				log.debug("modulo: "+modulo);
//				log.debug("xmlContent:\n"+ new String(xmlModel.getXmlContent()));
//				log.debug("########################################");
//
//				return getModolOld().mergeModulo(app, utente, modulo, xmlModel).getDataContent();
//			}
//			
//			return null;
//		}
//		catch (Exception e) {
//			log.error("Errore nella generazione del modulo", e);
//			throw new ServiceException(e, "Errore nella generazione del modulo");
//		}finally{
//			log.debug("[ServiziMgr::showModuloModol] END");
//		}
//	}
	
//	public byte[] recuperaStampaCertificatoReadOnly(String idCertificatore, String progrCertificato, String anno, Integer idStatoCertificato) throws ServiceException {
//
//		log.debug("idCertificatore: " + idCertificatore);
//		log.debug("progressivoCertificato: " + progrCertificato);
//		log.debug("anno: " + anno);
//
//		byte[] docXml = null;
//		try {
//			
//				docXml = getSOAIntegrationMgr().recuperaStampaCertificatoReadOnly(idCertificatore, progrCertificato, anno, idStatoCertificato);
//				
//			
//		} catch (Exception e) {
//			log.error("Errore in recuperaFoto", e);
//			throw new ServiceException(e, "Errore nella generazione del modulo");
//		}
//		return docXml;
//	}

	public byte[] recuperaStampaCertificatoIText(String idCertificatore, String progrCertificato, String anno, Integer idStatoCertificato) throws ServiceException {

		log.debug("idCertificatore: " + idCertificatore);
		log.debug("progressivoCertificato: " + progrCertificato);
		log.debug("anno: " + anno);

		byte[] docXml = null;
		try {
			
				docXml = getSOAIntegrationMgr().recuperaStampaCertificatoIText(idCertificatore, progrCertificato, anno, idStatoCertificato);
				
			
		} catch (Exception e) {
			log.error("Errore in recuperaFoto", e);
			throw new ServiceException(e, "Errore nella generazione del modulo");
		}
		return docXml;
	}
	
//	public byte[] showModuloModolStaticoOld(Applicazione app, String codModuloModol, Utente utente, XmlModel xmlModel) throws ServiceException {
//		log.debug("[ServiziMgr::showModuloModolStatico] BEGIN");
//		try
//		{
//			Modulo modulo = cercaModuloOld(app, codModuloModol);
//			log.debug("CODICE MODULO MODOL: "  + codModuloModol);
//			if(modulo!=null)
//			{
//				
//				RendererModalityExpert.attivaRenderingReaderExtensions(modulo.getModello().getRendererModality());
//				
//				log.debug("########################################");
//				log.debug("faccio la merge");
//				log.debug("xmlModel: "+xmlModel.toString());
//				log.debug("modulo: "+modulo);
//				log.debug("xmlContent:\n"+ new String(xmlModel.getXmlContent()));
//				log.debug("########################################");
//
//				
//				modulo = getModolOld().mergeModulo(app, utente, modulo, xmlModel);
//				log.debug("merge effettuato");
//				byte[] thePdf = modulo.getDataContent();
//				
//				log.debug("Stampo il thePdf: "+thePdf);
//				
//				log.debug("PRIMA DELLA CREAZIONE DEL PDF STATICO");
//				
//				PdfAInputRequest pdfAInputRequest = new PdfAInputRequest();
//				pdfAInputRequest.setPdfInput(thePdf);
//				
//				it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione appPdfStatico = new it.csi.modol.modolpdfgeneratorsrv.dto.Applicazione();
//				appPdfStatico.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
//				
//				byte[] thePdfStatico = getModolPdfOld().toPdfA(appPdfStatico, null, pdfAInputRequest);
//				
//				log.debug("Stampo l'array del pdf statico: "+thePdfStatico);
//				
//				log.debug("DOPO DELLA CREAZIONE DEL PDF STATICO");
//				
//				
//				
//				
//				return thePdfStatico;
//			}
//			
//			return null;
//		}
//		catch (Exception e) {
//			log.error("Errore nella generazione del modulo", e);
//			throw new ServiceException(e, "Errore nella generazione del modulo");
//		}finally{
//			log.debug("[ServiziMgr::showModuloModolStatico] END");
//		}
//	}
	
//	public ModolPdfGeneratorSrvITF getModolPdfOld() {
//		log.debug("[ServiziMgr::getModolPdf] BEGIN");
//		InputStream is = getClass().getResourceAsStream(MODOL_PDF_RESOURCE);
//		if (is != null) {
//			try {
//				InfoPortaDelegata info = PDConfigReader.read(is);
//				log.debug("[ServiziMgr::getModolPdf] END");
//				
//				log.error("Stampo la info: "+info);
//				
//				
//				ModolPdfGeneratorSrvITF pd = (ModolPdfGeneratorSrvITF) PDProxy.newInstance(info);
//				
//				try
//				{
//					log.debug("la pd è diversa da null: "+(pd!=null));
//					
//
//				} catch (Exception e) {
//					log.error("errore nello stampare la pd");
//				}
//				return pd;
//			} 
//			catch (Exception e) {
//				log.error("[ServiziMgr::getModolPdf] errore nella parsificazione della configurazione di MODOL:"+ e, e);
//				throw new IllegalArgumentException("errore nella parsificazione della configurazione di MODOL");
//			}
//		} else{
//			log.error("[ServiziMgr::getModolPdf] configurazione di MODOL non trovata");
//		}
//		throw new IllegalArgumentException("configurazione di MODOL PDF non trovata");
//	}
	
	
//	public MODDocument getApe(String idCertificatore, String progrCertificato, String anno) throws ServiceException {
//		log.debug("[ServiziMgr::getApe] BEGIN");
//		try {
//			// recupero XML da db
//			SiceeTCertXml2015 certXML = getCertificatoMgr().recuperaCertXml2015(idCertificatore, progrCertificato, anno);
//			// recupero da tutti i dto i dati da forzare nell'XML
//			// e li mappo su un dto unico per comodità
//			ApeDto apeDto = new ApeDto();
//			SiceeTCertificato certificato = getCertificatoMgr().recuperaCertificato(idCertificatore, progrCertificato, anno);
//			SiceeTImportDati2015 datiOrigXML = getCertificatoMgr().getSiceeTImportDati2015Dao().findByPrimaryKey(idCertificatore, progrCertificato, anno);
//			SiceeTDatiGenerali datiGenerali = getCertificatoMgr().recuperaDatiGenerali(idCertificatore, progrCertificato, anno);
//			SiceeTAltreInfo altreInfo = getCertificatoMgr().recuperaAltreInfo(idCertificatore, progrCertificato, anno);
//			String dMotivo = null;
//			String flagServizioEnergia = "N";
//			if (!BaseMgr.isNullOrEmpty(altreInfo.getAltroServiziEnergia())) {
//				dMotivo = getCertificatoMgr().recuperaDMotivoRilascioDecodifica(altreInfo.getAltroServiziEnergia()).getDescr();
//				if ((Constants.ID_MOTIVO_ANTE_OPERAM == altreInfo.getAltroServiziEnergia()) 
//						||(Constants.ID_MOTIVO_POST_OPERAM == altreInfo.getAltroServiziEnergia())) {
//					flagServizioEnergia = "S";
//					// decodifico solo se il motivo è ANTE_OPERAM o POST_OPERAM (getDescr() non produce un null pointer) 
//				}
//			}
//
//			SiceeTCertificatore certificatore = getCertificatoMgr().recuperaCertificatore(idCertificatore);
//			SiceeTAzienda azienda = getCertificatoMgr().recuperaAzienda(certificatore.getFkAzienda());
//			String dTitolo = getCertificatoMgr().recuperaDTitolo(certificatore.getFkIstruzione());
//			//List<SiceeDDestUso2015> elencoClassificazioni = getCertificatoMgr().recuperaElencoClassificazioni();
//			//List<SiceeDUnitaMisura2015> elencoUnitaMisura = getCertificatoMgr().recuperaElencoUnitaMisura();
//			//List<SiceeDClasseEnergetica> elencoClasseEnergetica = getCertificatoMgr().recuperaElencoClasseEnergetica();
//			//List<SiceeDRiqEner2015> elencoCodiciREN = getCertificatoMgr().recuperaElencoCodiciREN();
//			//List<SiceeDCombustibile> elencoCombustibiliEnEsportata = getCertificatoMgr().recuperaElencoCombustibiliEnEsportata();
//			//List<SiceeDCombustibile> elencoCombustibiliDettImpianti = getCertificatoMgr().recuperaElencoCombustibiliDettImpianti();
//			//List<SiceeDCombustibile> elencoConsumiCombustibile = getCertificatoMgr().recuperaElencoConsumiCombustibile();
//			apeDto = MapDto.mapFromCertificatoToApe(certificato, datiOrigXML, apeDto);
//			apeDto = MapDto.mapFromDatiGeneraliToApe(datiGenerali, apeDto);
//			apeDto = MapDto.mapFromAltreInfoToApe(altreInfo, apeDto, dMotivo, flagServizioEnergia);
//			apeDto = MapDto.mapFromCertificatoreToApe(certificatore, azienda, dTitolo, apeDto);
//
//			
//			MODDocument modDoc = null;
//			if (certXML != null) {
//				log.debug("CERTIFICATO TROVATO");
//				//log.debug("Contenuto xml: " + certXML.getXmlAllegato());
//				modDoc = MapDto.mapToMODDocument(XmlBeanUtils.readString(certXML.getXmlAllegato()));
//				modDoc = MapDto.mapToDatiGenerici(modDoc, apeDto);				
//				modDoc = MapDto.mapToDatiCatastali(modDoc, apeDto);			
//				/*
//				modDoc = MapDto.mapToElencoClassificazioni(modDoc, elencoClassificazioni);					
//				modDoc = MapDto.mapToElencoUnitaMisura(modDoc, elencoUnitaMisura);			
//				modDoc = MapDto.mapToElencoClasseEnergetica(modDoc, elencoClasseEnergetica);				
//				modDoc = MapDto.mapToElencoCodiciREN(modDoc, elencoCodiciREN);							
//				modDoc = MapDto.mapToElencoCombustibiliEnEsportata(modDoc, elencoCombustibiliEnEsportata);							
//				modDoc = MapDto.mapToElencoCombustibiliDettImpianti(modDoc, elencoCombustibiliDettImpianti);						
//				*/
//
//			} else {
//				log.debug("CERTIFICATO NON TROVATO");
//			}
//			return modDoc;
//		} catch (Exception e) {
//			log.error("Errore getApe",e);
//			throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
//		} finally{
//			log.debug("[ServiziMgr::getApe] END");
//		}
//			
//	}
	
//	public Modulo cercaModuloOld(Applicazione applicazione, String codiceModulo) throws ServiceException {
//		log.debug("[ServiziMgr::cercaModulo] BEGIN");
//		log.debug("CODICE MODOL: [" + codiceModulo + "]");
//		CriterioRicercaModulo criterio;
//		try {
//			criterio = new CriterioRicercaModulo();
//			criterio.setCodiceModulo(codiceModulo);
//			Modulo[] moduli = getModolOld().ricercaModuli(applicazione, null , criterio);
//			if(moduli!=null && moduli.length>0)
//			{
//				return moduli[0];
//			}
//			else
//			{
//				log.error("Non ho trovato il modulo su MODOL");
//				throw new ServiceException(null, Messages.ERROR_RECUPERO_SERVIZIO);
//			}
//		}catch (Exception e) {
//				log.error("Errore recupero modulo: ", e);
//				throw new ServiceException(e, Messages.ERROR_RECUPERO_SERVIZIO);
//		}finally{
//			log.debug("[ServiziMgr::cercaModulo] END");
//		}
//	}
	
	
}