/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.util;

import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificato;
import it.csi.sicee.siceebo.business.print.dto.ApeDto;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTAzienda;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTDatiGenerali;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDCombustibile;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDRiqEner2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDUnitaMisura2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTAltreInfo;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTImportDati2015;
import it.csi.sicee.siceebo.business.facade.BaseMgr;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.Converter;
//import it.csi.sicee.siceeweb.xml.attestato.data.ImageJPG;
//import it.csi.sicee.siceeweb.xml.attestato.data.MODDocument;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoClasseEnergetica;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoClassificazioni;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCodiciREN;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCombustibiliDettImpianti;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCombustibiliEnEsportata;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoUnitaMisura;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoClasseEnergetica.ClasseEnergetica;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoClassificazioni.Classificazione;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCodiciREN.CodiceREN;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCombustibiliDettImpianti.CombustibileDettImpianti;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoCombustibiliEnEsportata.CombustibileEnEsportata;
//import it.csi.sicee.siceeweb.xml.attestato.data.DatiPrecompilatiDocument.DatiPrecompilati.ElencoUnitaMisura.UnitaMisura;
//import it.csi.sicee.siceeweb.xml.attestato.data.PrestEnergImpiantiDocument.PrestEnergImpianti.ElencoFontiEnergetiche;
//import it.csi.sicee.siceeweb.xml.attestato.data.RowConsumiCombustibileDocument.RowConsumiCombustibile;
//import it.csi.sicee.siceeweb.xml.attestato.data.RowDatiCatastaliDocument.RowDatiCatastali;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
/*
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.impl.util.Base64;
*/
import org.xml.sax.SAXException;


/**
 * Mappa DTO con gli oggetti GUI e viceversa
 * 
 */
public class MapDto {

	private static Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".util");

//	public static MODDocument mapToMODDocument(byte[] theXml){
//		try {
//			log.debug("[MapDto::mapToMODDocument] start");
//			String theXmlString = ModolXFAReader.getXMLData(theXml, "data:MOD");
//			//log.debug("theXmlString " + theXmlString);
//			InputStream is = new ByteArrayInputStream(XmlBeanUtils.readString(theXmlString));
//			MODDocument apeDoc = MODDocument.Factory.parse(is);
//			
//			log.debug("[MapDto::mapToMODDocument] end");
//			return apeDoc;
//		} catch (XmlException e) {
//			log.error("Errore mapToMODDocument - XmlException",e);
//			return null;
//		} catch (IOException e) {
//			log.error("Errore mapToMODDocument - IOException",e);
//			return null;
//		} catch (ParserConfigurationException e) {
//			log.error("Errore mapToMODDocument - ParserConfigurationException",e);
//			return null;
//		} catch (SAXException e) {
//			log.error("Errore mapToMODDocument - SAXException",e);
//			return null;
//		}		
//	}

	public static ApeDto mapFromCertificatoToApe(SiceeTCertificato certificato, SiceeTImportDati2015 datiOrigXML, ApeDto apeDto){
		log.debug("[MapDto::.mapFromCertificatoToApe] start");
		
		if (datiOrigXML == null)
			apeDto.setIsBozzaDaXml(false);
		else
			apeDto.setIsBozzaDaXml(true);
		apeDto.setFkStato(certificato.getFkStato());
		apeDto.setAnno(certificato.getAnno());
		apeDto.setIdCertificatoreCertificato(certificato.getIdCertificatore());
		apeDto.setProgrCertificato(certificato.getProgrCertificato());
		apeDto.setDtScadenza(certificato.getDtScadenza());
		apeDto.setDescRegione(certificato.getDescRegione());
		apeDto.setDescComune(certificato.getDescComune());
		apeDto.setDescIndirizzoCertificato(certificato.getDescIndirizzo());
		apeDto.setNumCivico(certificato.getNumCivico());
		apeDto.setPiano(certificato.getPiano());
		apeDto.setInterno(certificato.getInterno());
		apeDto.setCoordN(certificato.getCoordN());
		apeDto.setCoordE(certificato.getCoordE());
		apeDto.setDtInizio(certificato.getDtInizio());
		apeDto.setCodiceComuneCatastale(certificato.getCodiceComuneCatastale());
		apeDto.setFoglio(certificato.getFoglio());
		apeDto.setSezione(certificato.getSezione());
		apeDto.setParticella(certificato.getParticella());
		apeDto.setSubalterno(certificato.getSubalterno());

		log.debug("[MapDto::.mapFromCertificatoToApe] end");
		return apeDto;
	}

	public static ApeDto mapFromDatiGeneraliToApe(SiceeTDatiGenerali datiGenerali, ApeDto apeDto){
		log.debug("[MapDto::.mapFromDatiGeneraliToApe] start");
		
		apeDto.setAnnoCostruzione(datiGenerali.getAnnoCostruzione());
		apeDto.setZonaClimatica(datiGenerali.getZonaClimatica());
		apeDto.setOggetto(Integer.toString(datiGenerali.getFkOggettoApe()));
	
		log.debug("[MapDto::.mapFromDatiGeneraliToApe] end");
		return apeDto;
	}

	public static ApeDto mapFromAltreInfoToApe(SiceeTAltreInfo altreInfo, ApeDto apeDto, String dMotivo, String flagServizioEnergia){
		log.debug("[MapDto::.mapFromAltreInfoToApe] start");
		
		apeDto.setMotivazione(Integer.toString(altreInfo.getFkMotivo()));
		if (!BaseMgr.isNullOrEmpty(dMotivo)) {
			apeDto.setDescrizioneAltraMotivazione(dMotivo);
		} else {
			apeDto.setDescrizioneAltraMotivazione(altreInfo.getMotivoAltro());
		}
		apeDto.setFlagServizioEnergia(flagServizioEnergia);
		log.debug("[MapDto::.mapFromAltreInfoToApe] end");
		return apeDto;
	}

	public static ApeDto mapFromCertificatoreToApe(SiceeTCertificatore certificatore, SiceeTAzienda azienda, String dTitolo, ApeDto apeDto){
		log.debug("[MapDto::.mapFromCertificatoreToApe] start");
		
		String cognomeRagSociale = certificatore.getCognome();
		apeDto.setNumCertificatore(certificatore.getNumCertificatore());
		apeDto.setDTitolo(dTitolo);
		
		String tmpStr = "";
		if (certificatore.getIscrittoOrdine() != null && certificatore.getIscrittoOrdine().equalsIgnoreCase(Constants.SI))
		{
			if (certificatore.getOrdine() != null)
				tmpStr = certificatore.getOrdine() + " / ";
			if (certificatore.getNumIscrAlbo() != null)
				tmpStr = tmpStr + certificatore.getNumIscrAlbo();			
		}
		apeDto.setIscrittoOrdine(tmpStr);
		
		log.debug("azienda: "+azienda);
		
		if (azienda != null && azienda.getDescIndirizzo() != null) {
			
			log.debug("azienda.getDescIndirizzo(): "+azienda.getDescIndirizzo());
			
			// Nel caso ci sia l'azienda concateno la denominazione
			cognomeRagSociale += " / " + azienda.getDenominazione();
			
			apeDto.setDescIndirizzoCertificatore(azienda.getDescIndirizzo());
			apeDto.setNumCivicoResidenza(azienda.getNumCivico());
			apeDto.setDescComuneResidenza(azienda.getDescComune());
			apeDto.setDescProvResidenza(azienda.getDescProv());
		} else {
			if ("S".equalsIgnoreCase(certificatore.getFlgResidenzaItalia())) {
				apeDto.setDescIndirizzoCertificatore(certificatore.getDescIndirizzo());
				apeDto.setNumCivicoResidenza(certificatore.getNumCivicoResidenza());
				apeDto.setDescComuneResidenza(certificatore.getDescComuneResidenza());
				apeDto.setDescProvResidenza(certificatore.getDescProvResidenza());
			} else {
				apeDto.setDescIndirizzoCertificatore(certificatore.getViaEstera());
				apeDto.setNumCivicoResidenza(certificatore.getCivicoEstero());
				apeDto.setDescComuneResidenza(certificatore.getCittaEstera());
				apeDto.setDescProvResidenza(certificatore.getStatoResEstero());
			}
		}

		apeDto.setNome(certificatore.getNome());
		apeDto.setCognomeRagSociale(cognomeRagSociale);
		apeDto.setCognome(certificatore.getCognome());

		apeDto.setEmail(certificatore.getEmail());
		apeDto.setTelefono(certificatore.getTelefono());
	
		log.debug("[MapDto::.mapFromCertificatoreToApe] end");
		return apeDto;
	}

	/*
	public static MODDocument mapToDatiGenerici(MODDocument modDoc, ApeDto apeDto){
		log.debug("[MapDto::mapToDatiGenerici] start");
		
		modDoc.getMOD().getSystem().setModuloEditabile(Constants.TRUE);
		modDoc.getMOD().getSystem().setBtSalvaInBozza(Constants.TRUE);
		modDoc.getMOD().getSystem().setBtSalvaEcontrolla(Constants.TRUE);
		//modDoc.getMOD().getSystem().setBtInvia(Constants.FALSE);
		
		// stato modulo
		String statoModulo = "";

		statoModulo = "CONSOLIDATO";
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setStatoModulo(statoModulo);
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setAnno(Converter.convertToBigInteger(apeDto.getAnno()));
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setIdCertificatore(apeDto.getNumCertificatore());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setProgressivoCertificato(apeDto.getProgrCertificato());
		
		// data validità
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String dataStr = sdf.format(apeDto.getDtScadenza());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setDataValidita(dataStr);
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setRegione(apeDto.getDescRegione());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setComune(apeDto.getDescComune());
		String civico = "";
		if (apeDto.getNumCivico() != null)
			civico = apeDto.getNumCivico();
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setIndirizzo(apeDto.getDescIndirizzoCertificato() + " " + civico);
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setPiano(Converter.convertToString(apeDto.getPiano()));
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setInterno(apeDto.getInterno());

		// coordinate geografiche
		java.math.BigDecimal coordN = Converter.convertToBigDecimal(apeDto.getCoordN());
		java.math.BigDecimal coordE = Converter.convertToBigDecimal(apeDto.getCoordE());
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setCoordinateGIS(coordN.toString() + " " + coordE.toString());

		modDoc.getMOD().getAttestato().getDatiPrecompilati().setAnnoCostruzione(Converter.convertToString(apeDto.getAnnoCostruzione()));
		modDoc.getMOD().getAttestato().getDatiGenerali().setZonaClimatica(apeDto.getZonaClimatica());

		// certificatore
		civico = "";
		String indirizzo = "";
		String comune = "";
		String prov = "";
		
		if (apeDto.getDescIndirizzoCertificatore() != null)
			indirizzo = apeDto.getDescIndirizzoCertificatore();
		if (apeDto.getNumCivicoResidenza() != null)
			civico = apeDto.getNumCivicoResidenza();
		if (apeDto.getDescComuneResidenza() != null)
			comune = apeDto.getDescComuneResidenza();
		if (apeDto.getDescProvResidenza() != null)
			prov = apeDto.getDescProvResidenza();
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setDenominazione(apeDto.getNome() + " " + apeDto.getCognomeRagSociale());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setIndirizzo(indirizzo
				+ " " + civico
				+ " " + comune
				+ " (" + prov  + ")");
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setEmail(apeDto.getEmail());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setTelefono(apeDto.getTelefono());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setTitolo(apeDto.getDTitolo());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().getCertificatore().setOrdine(apeDto.getIscrittoOrdine());

		// data emissione
		dataStr = sdf.format(apeDto.getDtInizio());
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setDataEmissione(dataStr);
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setFirma(apeDto.getCognome() 
				+ " " + apeDto.getNome()
				+ " " + "N."
				+ " " + apeDto.getNumCertificatore());

		modDoc.getMOD().getAttestato().getDatiGenerali().setOggetto(Converter.convertToBigInteger(apeDto.getOggetto()));
		modDoc.getMOD().getAttestato().getDatiGenerali().setMotivazione(Converter.convertToBigInteger(apeDto.getMotivazione()));
		modDoc.getMOD().getAttestato().getDatiGenerali().setMotivazioneAltro(apeDto.getDescrizioneAltraMotivazione());

		log.debug("[MapDto::mapToDatiGenerici] end");
		return modDoc;
	}
	*/
	/* Non serve più: teniamolo ancora un po' per eventuali usi futuri */
//	public static MODDocument mapToFoto(MODDocument modDoc, String indexImage){
//		log.debug("[MapDto::mapToFoto] start");
//		
//		if (indexImage != null) {
//			ImageJPG foto = ImageJPG.Factory.newInstance();
//						
//			try {
//				foto.setStringValue(new String(Base64.encode(indexImage.getBytes(Constants.MODOL_ENCODING)), Constants.MODOL_ENCODING));
//			} catch (Exception ex) {
//				log.debug("eccezione nell'encoding");
//				log.debug(ex.toString());
//			}
//			modDoc.getMOD().getAttestato().getDatiPrecompilati().setFoto(foto);
//		}
//		
//		log.debug("[MapDto::mapToFoto] end");
//		return modDoc;
//	}

	/*
	public static MODDocument mapToDatiCatastali(MODDocument modDoc, ApeDto apeDto){
		log.debug("[MapDto::mapToDatiCatastali] start");
		// sezione dati catastali

		List<RowDatiCatastali> rowDatiCatastaliList = modDoc.getMOD().getAttestato().getDatiPrecompilati().getSezDatiCatastali().getRowDatiCatastaliList();
		//List<RowDatiCatastali> rowDatiCatastaliBuildList = new ArrayList<RowDatiCatastali>();

		if (rowDatiCatastaliList.size() == 0) {
			//log.debug("\n>>>>>>> rowDatiCatastaliList.size() == 0 ; prima volta che entro");
			RowDatiCatastali rdc = RowDatiCatastali.Factory.newInstance();
			rdc.setFlagPrincipale(true);
			rdc.setComuneCatastale(apeDto.getCodiceComuneCatastale());
			rdc.setSezione(apeDto.getSezione());
			rdc.setFoglio(apeDto.getFoglio());
			rdc.setParticella(apeDto.getParticella());
			try{rdc.setDa1(Converter.convertToBigInteger(apeDto.getSubalterno()));}catch (Exception e) {rdc.setDa1(null);}
			try{rdc.setA1(Converter.convertToBigInteger(apeDto.getSubalterno()));}catch (Exception e) {rdc.setA1(null);}
			rowDatiCatastaliList.add(rdc);	

			RowDatiCatastali[] rowDatiCatastaliArray = new RowDatiCatastali[rowDatiCatastaliList.size()];
			rowDatiCatastaliArray = rowDatiCatastaliList.toArray(rowDatiCatastaliArray);
			modDoc.getMOD().getAttestato().getDatiPrecompilati().getSezDatiCatastali().setRowDatiCatastaliArray(rowDatiCatastaliArray);
		} 
		else {
			//log.debug("\n>>>>>>> rowDatiCatastaliList.size() > 0 ; ciclo sulle righe");
			for(RowDatiCatastali rdc : rowDatiCatastaliList) {
				if (rdc.getFlagPrincipale() == true) {
					rdc.setComuneCatastale(apeDto.getCodiceComuneCatastale());
					rdc.setSezione(apeDto.getSezione());
					rdc.setFoglio(apeDto.getFoglio());
					rdc.setParticella(apeDto.getParticella());
					try{rdc.setDa1(Converter.convertToBigInteger(apeDto.getSubalterno()));}catch (Exception e) {rdc.setDa1(null);}
					try{rdc.setA1(Converter.convertToBigInteger(apeDto.getSubalterno()));}catch (Exception e) {rdc.setA1(null);}
				
				}
				//rowDatiCatastaliBuildList.add(rdc);	
			}
			RowDatiCatastali[] rowDatiCatastaliArray = new RowDatiCatastali[rowDatiCatastaliList.size()];
			rowDatiCatastaliArray = rowDatiCatastaliList.toArray(rowDatiCatastaliArray);
			modDoc.getMOD().getAttestato().getDatiPrecompilati().getSezDatiCatastali().setRowDatiCatastaliArray(rowDatiCatastaliArray);
		}	

		log.debug("[MapDto::mapToDatiCatastali] end");
		return modDoc;
	}

	public static MODDocument mapToElencoClassificazioni(MODDocument modDoc, List<SiceeDDestUso2015> elencoClassificazioni){
		log.debug("[MapDto::mapToElencoClassificazioni] start");
		
		ElencoClassificazioni e = ElencoClassificazioni.Factory.newInstance();
		Classificazione classificazione = null;
		List<Classificazione> classificazioneList = e.getClassificazioneList();
		classificazione = Classificazione.Factory.newInstance();
		classificazione.setCodice(Converter.convertToBigInteger(-1));
		classificazione.setDescrizione(" ");
		classificazioneList.add(classificazione);
		for (SiceeDDestUso2015 c : elencoClassificazioni) {
			classificazione = Classificazione.Factory.newInstance();
			classificazione.setCodice(Converter.convertToBigInteger(c.getIdDestUso2015()));
			classificazione.setDescrizione(c.getSigla() + " " + c.getDescr());
			classificazione.setFlagIsResidenziale(c.getFlgResidenziale());
			classificazioneList.add(classificazione);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoClassificazioni(e);
		
		log.debug("[MapDto::mapToElencoClassificazioni] end");
		return modDoc;
	}



	public static MODDocument mapToElencoUnitaMisura(MODDocument modDoc, List<SiceeDUnitaMisura2015> elencoUnitaMisura){
		log.debug("[MapDto::mapToElencoUnitaMisura] start");
		
		ElencoUnitaMisura e = ElencoUnitaMisura.Factory.newInstance();
		UnitaMisura unitaMisura = null;
		List<UnitaMisura> unitaMisuraList = e.getUnitaMisuraList();
		unitaMisura = UnitaMisura.Factory.newInstance();
		unitaMisura.setCodice(Converter.convertToBigInteger(-1));
		unitaMisura.setDescrizione(" ");
		unitaMisuraList.add(unitaMisura);
		for (SiceeDUnitaMisura2015 um : elencoUnitaMisura) {
			unitaMisura = UnitaMisura.Factory.newInstance();
			unitaMisura.setCodice(Converter.convertToBigInteger(um.getIdUnitaMisura()));
			unitaMisura.setDescrizione(um.getDescr());
			unitaMisuraList.add(unitaMisura);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoUnitaMisura(e);
		
		log.debug("[MapDto::mapToElencoUnitaMisura] end");
		return modDoc;
	}

	public static MODDocument mapToElencoClasseEnergetica(MODDocument modDoc, List<SiceeDClasseEnergetica> elencoClasseEnergetica){
		log.debug("[MapDto::mapToElencoClasseEnergetica] start");
		
		ElencoClasseEnergetica e = ElencoClasseEnergetica.Factory.newInstance();
		ClasseEnergetica classeEnergetica = null;
		List<ClasseEnergetica> classeEnergeticaList = e.getClasseEnergeticaList();
		classeEnergetica = ClasseEnergetica.Factory.newInstance();
		classeEnergetica.setCodice(Converter.convertToBigInteger(-1));
		classeEnergetica.setDescrizione(" ");
		classeEnergeticaList.add(classeEnergetica);
		for (SiceeDClasseEnergetica ce : elencoClasseEnergetica) {
			classeEnergetica = ClasseEnergetica.Factory.newInstance();
			classeEnergetica.setCodice(Converter.convertToBigInteger(ce.getIdClasse()));
			classeEnergetica.setDescrizione(ce.getDescr());
			classeEnergeticaList.add(classeEnergetica);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoClasseEnergetica(e);
		
		log.debug("[MapDto::mapToElencoClasseEnergetica] end");
		return modDoc;
	}


	public static MODDocument mapToElencoCodiciREN(MODDocument modDoc, List<SiceeDRiqEner2015> elencoCodiciREN){
		log.debug("[MapDto::mapToElencoCodiciREN] start");
		
		ElencoCodiciREN e = ElencoCodiciREN.Factory.newInstance();
		CodiceREN codiceREN = null;
		List<CodiceREN> codiceRENList = e.getCodiceRENList();
		codiceREN = CodiceREN.Factory.newInstance();
		codiceREN.setCodice("-1");
		codiceREN.setDescrizione(" ");
		codiceRENList.add(codiceREN);
		for (SiceeDRiqEner2015 cren : elencoCodiciREN) {
			codiceREN = CodiceREN.Factory.newInstance();
			codiceREN.setCodice(cren.getCodiceRen());
			codiceREN.setDescrizione(cren.getCodiceRen());
			codiceRENList.add(codiceREN);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoCodiciREN(e);
		
		log.debug("[MapDto::mapToElencoCodiciREN] end");
		return modDoc;
	}

	public static MODDocument mapToElencoCombustibiliEnEsportata(MODDocument modDoc, List<SiceeDCombustibile> elencoCombustibiliEnEsportata){
		log.debug("[MapDto::mapToElencoCombustibiliEnEsportata] start");
		
		ElencoCombustibiliEnEsportata e = ElencoCombustibiliEnEsportata.Factory.newInstance();
		CombustibileEnEsportata combustibileEnEsportata = null;
		List<CombustibileEnEsportata> combustibileEnEsportataList = e.getCombustibileEnEsportataList();
		combustibileEnEsportata = CombustibileEnEsportata.Factory.newInstance();
		combustibileEnEsportata.setCodice(Converter.convertToBigInteger(-1));
		combustibileEnEsportata.setDescrizione(" ");
		combustibileEnEsportataList.add(combustibileEnEsportata);
		for (SiceeDCombustibile c : elencoCombustibiliEnEsportata) {
			combustibileEnEsportata = CombustibileEnEsportata.Factory.newInstance();
			combustibileEnEsportata.setCodice(Converter.convertToBigInteger(c.getIdCombustibile()));
			combustibileEnEsportata.setDescrizione(c.getDescr());
			combustibileEnEsportataList.add(combustibileEnEsportata);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoCombustibiliEnEsportata(e);
		
		log.debug("[MapDto::mapToElencoCombustibiliEnEsportata] end");
		return modDoc;
	}

	public static MODDocument mapToElencoCombustibiliDettImpianti(MODDocument modDoc, List<SiceeDCombustibile> elencoCombustibiliDettImpianti){
		log.debug("[MapDto::mapToElencoCombustibiliDettImpianti] start");
		
		ElencoCombustibiliDettImpianti e = ElencoCombustibiliDettImpianti.Factory.newInstance();
		CombustibileDettImpianti combustibileDettImpianti = null;
		List<CombustibileDettImpianti> combustibileDettImpiantiList = e.getCombustibileDettImpiantiList();
		combustibileDettImpianti = CombustibileDettImpianti.Factory.newInstance();
		combustibileDettImpianti.setCodice(Converter.convertToBigInteger(-1));
		combustibileDettImpianti.setDescrizione(" ");
		combustibileDettImpiantiList.add(combustibileDettImpianti);
		for (SiceeDCombustibile c : elencoCombustibiliDettImpianti) {
			combustibileDettImpianti = CombustibileDettImpianti.Factory.newInstance();
			combustibileDettImpianti.setCodice(Converter.convertToBigInteger(c.getIdCombustibile()));
			combustibileDettImpianti.setDescrizione(c.getDescr());
			combustibileDettImpiantiList.add(combustibileDettImpianti);
	    }		
		
		modDoc.getMOD().getAttestato().getDatiPrecompilati().setElencoCombustibiliDettImpianti(e);
		
		log.debug("[MapDto::mapToElencoCombustibiliDettImpianti] end");
		return modDoc;
	}

	public static MODDocument mapToElencoConsumiCombustibile(MODDocument modDoc, List<SiceeDCombustibile> elencoConsumiCombustibile){
		log.debug("[MapDto::mapToElencoConsumiCombustibile] start");
		
		ElencoFontiEnergetiche e = ElencoFontiEnergetiche.Factory.newInstance();
		RowConsumiCombustibile consumiCombustibile = null;
		List<RowConsumiCombustibile> consumiCombustibileList = e.getRowConsumiCombustibileList();
		for (SiceeDCombustibile c : elencoConsumiCombustibile) {
			consumiCombustibile = RowConsumiCombustibile.Factory.newInstance();
			consumiCombustibile.setIdCombustibile(Converter.convertToBigInteger(c.getIdCombustibile()));
			consumiCombustibile.setDescrCombustibile(c.getDescr());
			consumiCombustibileList.add(consumiCombustibile);
	    }		
		
		modDoc.getMOD().getAttestato().getPrestEnergImpianti().setElencoFontiEnergetiche(e);
		
		log.debug("[MapDto::mapToElencoConsumiCombustibile] end");
		return modDoc;
	}
*/
}
