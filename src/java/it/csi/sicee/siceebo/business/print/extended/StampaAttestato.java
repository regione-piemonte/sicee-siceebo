/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceebo.business.print.extended;

import it.csi.sicee.siceebo.business.facade.MiscMgr;
import it.csi.sicee.siceebo.business.print.dto.GenericDto;
import it.csi.sicee.siceebo.business.print.dto.StampaAttestatoDto;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Chunk;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

import org.apache.xmlbeans.impl.util.Base64;

// TODO: Auto-generated Javadoc
/**
 * The Class RicevutaAcquistoAce.
 */
public class StampaAttestato extends BaseExtendedPdf {
	
	/** The Constant log. */
	protected static final Logger log = Logger
	.getLogger(Constants.APPLICATION_CODE + ".business");

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#stampaModulo(it.csi.sicee.siceeweb.business.print.dto.GenericDto, com.lowagie.text.pdf.PdfReader, java.lang.String, boolean)
	 */
	@Override
	public ByteArrayInputStream stampaModulo(GenericDto dati, //PdfReader reader,
			String sfondo, boolean foto) throws IOException,
			DocumentException {

			
		createPdf(dati);
		addLogoAndPageNumber(dati);
		
		return new ByteArrayInputStream(baosStamper.toByteArray());
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#getTemplateFilename()
	 */
	@Override
	public String getTemplateFilename() {
		return "template_attestato.pdf";
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#checkGenericDto(it.csi.sicee.siceeweb.business.print.dto.GenericDto)
	 */
	@Override
	public boolean checkGenericDto(GenericDto dati) {
		return dati instanceof StampaAttestatoDto;
	}

	

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addContentPage(com.lowagie.text.Document, it.csi.sicee.siceeweb.business.print.dto.GenericDto)
	 */
	@Override
	protected void addContentPage(Document document, GenericDto dati)
			throws DocumentException {
		Paragraph p = null;
		Paragraph par = null;
		Chunk c = null;
		StringBuffer strBuffer = null;

		StampaAttestatoDto dto = (StampaAttestatoDto) dati;

		p = new Paragraph();
		p.setAlignment(Element.ALIGN_CENTER);

		addEmptyLine(p, 1);
		addEmptyLine(p, 1);
		addEmptyLine(p, 1);

		par = new Paragraph("ATTESTATO  DI  FREQUENZA  E  PROFITTO", this.bi16redFont);
		p.add(par);
		
		addEmptyLine(p, 1);
		
		par = new Paragraph(dto.getDescrizioneAttestato());
		/*
		if (dto.getTipoCorso1().equalsIgnoreCase(Constants.TIPOCORSO1_AGGIORNAMENTO)) {
			// Corso di Aggiornamento
			par = new Paragraph("Corso di Aggiornamento di tecnici certificatori energetici ai sensi della DGR 24-2360 del 02/11/2015", this.n11Font);
		} else if (dto.getTipoCorso2().equalsIgnoreCase(Constants.TIPOCORSO2_NAZ)) {
			// Corso di Formazione Nazionale
			par = new Paragraph("Corso di Formazione e superamento esame per tecnici certificatori energetici ai sensi del DPR 75/2013", this.n11Font);
		} else {
			// Corso di Formazione Regionale
			par = new Paragraph("Corso di Formazione e superamento esame per tecnici certificatori energetici ai sensi della DGR 24-2360 del 02/11/2015", this.n11Font);
		}
		*/
		p.add(par);

		addEmptyLine(p, 1);
		addEmptyLine(p, 1);

		par = new Paragraph("SI  ATTESTA  CHE", this.bi14Font);
		p.add(par);

		addEmptyLine(p, 1);

		par = new Paragraph(checkNull(dto.getCognome()) + " " + checkNull(dto.getNome()), this.b12Font);
		p.add(par);

		par = new Paragraph();
		c = new Chunk("Nato/a a: ", this.n12Font);
		par.add(c);
		c = new Chunk(checkNull(dto.getLuogoNascita()), this.b12Font);
		par.add(c);
		c = new Chunk(" il ", this.n12Font);
		par.add(c);
		c = new Chunk(checkNull(dto.getdataNascita()), this.b12Font);
		par.add(c);
		p.add(par);

		addEmptyLine(p, 1);
		
		document.add(p);

		p = new Paragraph();
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		addEmptyLine(p, 1);

		par = new Paragraph();
		c = new Chunk(" - ha regolarmente frequentato il corso dal titolo \"", this.n11Font);
		par.add(c);
		c = new Chunk(checkNull(dto.getTitolo()), this.b11Font);
		par.add(c);
		c = new Chunk("\" svoltosi dal ", this.n11Font);
		par.add(c);
		c = new Chunk(checkNull(dto.getDataDal()), this.b11Font);
		par.add(c);
		c = new Chunk(" al ", this.n11Font);
		par.add(c);
		c = new Chunk(checkNull(dto.getDataAl()), this.b11Font);
		par.add(c);
		c = new Chunk(" di durata complessiva pari a ", this.n11Font);
		par.add(c);
		c = new Chunk(checkNull(dto.getTotaleOre() + " ore "), this.b11Font);
		par.add(c);
		c = new Chunk("e per un totale di ore di frequenza pari al ", this.n11Font);
		par.add(c);
		c = new Chunk(checkNull(dto.getPercFreq() + "%"), this.b11Font);
		par.add(c);
		c = new Chunk(" del totale", this.n11Font);
		par.add(c);
		p.add(par);
		document.add(p);

		addEmptyLine(p, 1);

		p = new Paragraph();
		p.setAlignment(Element.ALIGN_JUSTIFIED);
		par = new Paragraph();
		c = new Chunk(" - ha sostenuto con profitto la verifica finale in data ", this.n11Font);
		par.add(c);
		c = new Chunk(checkNull(dto.getDataEsame()), this.b11Font);
		par.add(c);
		p.add(par);
		
		addEmptyLine(p, 1);
		addEmptyLine(p, 1);
		addEmptyLine(p, 1);
		
		document.add(p);
		
		p = new Paragraph();
		p.setAlignment(Element.ALIGN_CENTER);
		strBuffer = new StringBuffer();
		strBuffer.append("Autorizzazione prot. N. " + checkNull(dto.getProtApprov()));
		strBuffer.append(" del " + checkNull(dto.getDataApprov()));
		par = new Paragraph(strBuffer.toString(), this.n9Font);
		p.add(par);
		addEmptyLine(p, 1);
		strBuffer = new StringBuffer();
		strBuffer.append("Edizione: " + checkNull(dto.getNumCorso()));
		strBuffer.append("              ");
		strBuffer.append("Anno Formativo: " + checkNull(dto.getAnnoFormativo()));
		par = new Paragraph(strBuffer.toString(), this.n9Font);
		p.add(par);
		addEmptyLine(p, 1);
		strBuffer = new StringBuffer();
		strBuffer.append("Ente o Struttura Formativa: " + checkNull(dto.getDenominazione()));
		par = new Paragraph(strBuffer.toString(), this.n9Font);
		p.add(par);
		addEmptyLine(p, 1);
		strBuffer = new StringBuffer();
		if (GenericUtil.isNullOrEmpty(dto.getLuogoCorso())) {
			strBuffer.append("Sede: " + checkNull(dto.getDescComune()) + " (" + checkNull(dto.getDescProv()) + ") - " + checkNull(dto.getDescIndirizzo()) + " " + checkNull(dto.getNumCivico()));
		} else {
			strBuffer.append("Sede: " + checkNull(dto.getLuogoCorso()));
		}
		par = new Paragraph(strBuffer.toString(), this.n9Font);
		p.add(par);

		addEmptyLine(p, 1);
		addEmptyLine(p, 1);
		addEmptyLine(p, 1);
		document.add(p);

		p = new Paragraph();
		p.setAlignment(Element.ALIGN_RIGHT);
		strBuffer = new StringBuffer();
		strBuffer.append("Il  Responsabile  del  corso                      ");
		par = new Paragraph(strBuffer.toString(), this.n10Font);
		p.add(par);
		addEmptyLine(p, 1);
		strBuffer = new StringBuffer();
		strBuffer.append("______________________________               ");
		par = new Paragraph(strBuffer.toString(), this.n10Font);
		p.add(par);
		addEmptyLine(p, 1);
		addEmptyLine(p, 1);
		document.add(p);

		p = new Paragraph();
		p.setAlignment(Element.ALIGN_LEFT);
		strBuffer = new StringBuffer();
		strBuffer.append("Data _______________");
		par = new Paragraph(strBuffer.toString(), this.n9Font);
		p.add(par);
		document.add(p);
		
		if (document.isOpen()) {
			document.newPage();
		} else {
			log.warn("È impossibile aggiungere la title page: lo stream di Document non è aperto!");
		}
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addFooterPage(com.lowagie.text.Document)
	 */
	@Override
	protected void addFooterPage(Document doc) throws DocumentException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addTitlePage(com.lowagie.text.Document)
	 */
	@Override
	protected void addTitlePage(Document document) throws DocumentException {
		Paragraph p = new Paragraph();
		p.setAlignment(Element.ALIGN_CENTER);

		Paragraph par = new Paragraph("title page", this.n12Font);
		p.add(par);

		if (document.isOpen()) {
			document.add(p);
		} else {
			log.warn("È impossibile aggiungere la title page: lo stream di Document non è aperto!");
		}
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addMetaData(com.lowagie.text.Document)
	 */
	@Override
	protected void addMetaData(Document document) throws DocumentException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#addLogoAndPageNumber(it.csi.sicee.siceeweb.business.print.dto.GenericDto)
	 */
	@Override
	protected PdfStamper addLogoAndPageNumber(GenericDto dati)
			throws DocumentException {
		PdfStamper stamp = null;
		try {
			StampaAttestatoDto dto = (StampaAttestatoDto) dati;
			// crea un'istanza di PdfReader: consente la lettura del PDF			
			PdfReader reader = new PdfReader(baos.toByteArray());

			int n = reader.getNumberOfPages();
			// crea un'istanza del PdfStamper: consente la copia della
			// pagina in un nuovo stream
			baosStamper = new ByteArrayOutputStream();
			stamp = getStamper(reader, baosStamper);
			int i = 1;

			// carica l'immagine usata come Logo
			Image img = null;
			String[] split = MiscMgr.splitParametriLogo(dto.getParametriLogo());
			float xpos;
			float ypos;
			float scale;		
			if (!GenericUtil.isNullOrEmpty(dto.getBase64Logo())) {				
				img = Image.getInstance(Base64.decode(dto.getBase64Logo().getBytes()));
				xpos = Float.parseFloat(split[0]);
				ypos = Float.parseFloat(split[1]);
				scale = Float.parseFloat(split[2]);	
				img.setAbsolutePosition(xpos, ypos);
				img.scalePercent(scale);
				//img.setAbsolutePosition(50f, 760f);
				//img.scalePercent(50f);

				img.setAlignment(0);
			} else {
				log.debug("\n\n\n>>>>>> NESSUNA IMMAGINE IN BASE64 RILEVATA !!!");
			}
			baseFont = BaseFont.createFont(BaseFont.TIMES_ITALIC, BaseFont.WINANSI,
					BaseFont.EMBEDDED);

			PdfContentByte under = null;

			while (i <= n) {
				// recupera il contenuto in byte del nuovo PDF...
				under = stamp.getUnderContent(i);
				if (!GenericUtil.isNullOrEmpty(img)) {
					log.debug("\n\n\n>>>>>> ADD IMAGE");
					under.addImage(img);
				}

				//if (i == n) {

					//getUnderText(under, "Torino, " + dto.getDataOdierna(),50f, 130f, 10);
					//getUnderText(under, dto.getNumCertificatore(), 400f, 130f, 10);
					//int j = 0;
					//for (String id:dto.getSede()) {
						//getUnderText(under, id, 400f, 120f - (10 * j++), 10);
					//}
				//}

				i++;
			}

			stamp.close();
		} catch (Exception e) {
			log.error("", e);
		}

		return stamp;
	}
	
	/* (non-Javadoc)
	 * @see it.csi.sicee.siceeweb.business.print.extended.BaseExtendedPdf#createPdf(it.csi.sicee.siceeweb.business.print.dto.GenericDto)
	 */
	protected Document createPdf(GenericDto dati) throws DocumentException {
		Document doc = new Document(PageSize.A4, 70f, 70f, 100f, 100f);
		//setMargins(float marginLeft, float marginRight, float marginTop, float marginBottom)

		try {
			// ottiene un'istanza di doc e lo apre
			writeToPdf(doc);
			// metodo vuoto
			addMetaData(doc);
			// aggiunge il titolo centrato
			//addTitlePage(doc);
			// aggiunge il contenuto
			addContentPage(doc, dati);
			// aggiunge il footer
			//addFooterPage(doc);

			doc.close();
		} catch (Exception e) {
			log.error("", e);
		}

		return doc;
	}

	protected String checkNull(String token) {
		if (GenericUtil.isNullOrEmpty(token))
			return "";
		else
			return token;
	}
	
	protected String checkNull(Integer token) {
		if (GenericUtil.isNullOrEmpty(token))
			return "";
		else
			return Integer.toString(token);
	}
}
