/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.pdf;

import it.csi.sicee.siceebo.business.facade.CertificatoMgr;
//import it.csi.modol.modolsrv.dto.Applicazione;
//import it.csi.modol.modolsrv.dto.Utente;
//import it.csi.modol.modolsrv.dto.XmlModel;
import it.csi.sicee.siceebo.business.facade.ServiziMgr;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.XmlBeanUtils;

import java.io.Serializable;

import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ModuloBuilder  implements Serializable {

	protected static final Logger log = Logger.getLogger(Constants.APPLICATION_CODE + ".business.pdf");
	
	private static final long serialVersionUID = 1L;

	private ServiziMgr serviziMgr;
	
	private String idCertificatore;
	private String progrCertificato;
	private String anno;
	
	public String getIdCertificatore() {
		return idCertificatore;
	}
	public void setIdCertificatore(String idCertificatore) {
		this.idCertificatore = idCertificatore;
	}

	public String getProgrCertificato() {
		return progrCertificato;
	}
	public void setProgrCertificato(String progrCertificato) {
		this.progrCertificato = progrCertificato;
	}

	public String getAnno() {
		return anno;
	}
	public void setAnno(String anno) {
		this.anno = anno;
	}

	public ServiziMgr getServiziMgr() {
		return serviziMgr;
	}
	public void setServiziMgr(ServiziMgr serviziMgr) {
		this.serviziMgr = serviziMgr;
	}

	protected CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}
	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

//	public byte[] showApeOld(){
//		log.debug("[ModuloBuilder::showApe] START");
//		Applicazione app;
//		Utente utente;
//		XmlModel model;
//		try {
//			app = new Applicazione();
//			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
//			utente = null;
//			model = getXmlApeOld();
//		
//			return getServiziMgr().showModuloModolOld(app,Constants.CODICE_MODULO_MODOL_APE,utente,model);
//		
//		}catch(Exception e){
//			log.error("Errore apertura file",e);
//			return null;
//		}finally{
//			log.debug("[ModuloBuilder::showApe] END");
//		}
//	}
	
//	public byte[] showApeReadOnly(){
//		log.debug("[ModuloBuilder::showApeReadOnly] START");
//
//		try {
//
//			return getServiziMgr().recuperaStampaCertificatoReadOnly(getIdCertificatore(), getProgrCertificato(), getAnno(), null);
//		
//		}catch(Exception e){
//			log.error("Errore apertura file",e);
//			return null;
//		}finally{
//			log.debug("[ModuloBuilder::showApeReadOnly] END");
//		}
//	}
	
	public byte[] showApeIText(){
		log.debug("[ModuloBuilder::showApeIText] START");

		try {

			return getServiziMgr().recuperaStampaCertificatoIText(getIdCertificatore(), getProgrCertificato(), getAnno(), null);
		
		}catch(Exception e){
			log.error("Errore apertura file",e);
			return null;
		}finally{
			log.debug("[ModuloBuilder::showApeIText] END");
		}
	}
	
//	public byte[] showApeReadOnlyOld(){
//		log.debug("[ModuloBuilder::showApeReadOnly] START");
//		Applicazione app;
//		Utente utente;
//		XmlModel model;
//		try {
//			app = new Applicazione();
//			app.setCodiceApplicazione(Constants.CODICE_APPLICAZIONE_MODOL);
//			utente = null;
//			model = getXmlApeReadOnly();
//		
//			return getServiziMgr().showModuloModolStaticoOld(app,Constants.CODICE_MODULO_MODOL_APE_2015,utente,model);
//		
//		}catch(Exception e){
//			log.error("Errore apertura file",e);
//			return null;
//		}finally{
//			log.debug("[ModuloBuilder::showApeReadOnly] END");
//		}
//	}
	
//	private XmlModel getXmlApeOld(){
//		log.debug("[ModuloBuilder::getXmlApe] START");
//
//		//recupero il modello xml dal documento
//		XmlModel model;
//		try {
//			model = new XmlModel();
//
//			// INIEZIONE FOTO - START
//			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getApe(getIdCertificatore(), getProgrCertificato(), getAnno()));
//			String indexImage = getCertificatoMgr().recuperaFoto(getIdCertificatore(), getProgrCertificato(), getAnno());
//			
//			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//			InputStream myInputStream = new ByteArrayInputStream(xmlByteArray);
//			Document doc = docBuilder.parse(myInputStream);
//			Node datiPrecompilati = doc.getElementsByTagName("data:datiPrecompilati").item(0);
//			NodeList list = datiPrecompilati.getChildNodes();
//			for (int i = 0; i < list.getLength(); i++) {
//				Node node = list.item(i);
//				if ("data:foto".equals(node.getNodeName())) {
//				   node.setTextContent(indexImage);
//			   }
//			}
//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			Transformer transformer = transformerFactory.newTransformer();
//			DOMSource source = new DOMSource(doc);
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			StreamResult result = new StreamResult(bos);
//			transformer.transform(source, result);
//			model.setXmlContent(bos.toByteArray());
//			// INIEZIONE FOTO - END
//
//			//model.setXmlContent(xmlByteArray);
//			return model;
//			
//		}catch(Exception e){
//			log.error("Errore", e);
//			return null;
//		} finally{
//			log.debug("[ModuloBuilder::getXmlApe] END");
//		}
//	}
	
//	private XmlModel getXmlApeReadOnly(){
//		log.debug("[ModuloBuilder::getXmlApeReadOnly] START");
//
//		//recupero il modello xml dal documento
//		XmlModel model;
//		try {
//			model = new XmlModel();
//
//			// INIEZIONE FOTO - START
//			byte[] xmlByteArray = getCertificatoMgr().recuperaTracciatoXml(getIdCertificatore(), getProgrCertificato(), getAnno());
//			
////			byte[] xmlByteArray = XmlBeanUtils.extractByteArray(getServiziMgr().getApe(getIdCertificatore(), getProgrCertificato(), getAnno()));
////			String indexImage = getCertificatoMgr().recuperaFoto(getIdCertificatore(), getProgrCertificato(), getAnno());
////			
//			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
//			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
//			InputStream myInputStream = new ByteArrayInputStream(xmlByteArray);
//			
//			Document doc = docBuilder.parse(myInputStream);
//			
//			TransformerFactory transformerFactory = TransformerFactory.newInstance();
//			Transformer transformer = transformerFactory.newTransformer();
//			DOMSource source = new DOMSource(doc);
//			ByteArrayOutputStream bos = new ByteArrayOutputStream();
//			StreamResult result = new StreamResult(bos);
//			transformer.transform(source, result);
//			model.setXmlContent(bos.toByteArray());
//			// INIEZIONE FOTO - END
//
//			//model.setXmlContent(xmlByteArray);
//			return model;
//			
//		}catch(Exception e){
//			log.error("Errore", e);
//			return null;
//		} finally{
//			log.debug("[ModuloBuilder::getXmlApeReadOnly] END");
//		}
//	}

}
