/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.presentation.siceebo.action.ricercaace;


import it.csi.sicee.siceebo.business.facade.CertificatoreMgr;
import it.csi.sicee.siceebo.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceebo.dto.ace.Ace;
import it.csi.sicee.siceebo.dto.ace.FiltroRicercaAce;
import it.csi.sicee.siceebo.dto.certificatori.Certificatore;
import it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFive;
import it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour;
import it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction;
import it.csi.sicee.siceebo.presentation.siceebo.action.ICommand;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;

public class ExportResultXlsAction extends BaseAction {
	

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private String inputName;

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

//	public int getBufferSize() {
//		return bufferSize;
//	}
//
//	public void setBufferSize(int bufferSize) {
//		this.bufferSize = bufferSize;
//	}

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	
	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	private String contentDisposition;
	private String contentLength;
	private InputStream inputStream;
//	private int bufferSize;
	private String contentType;
	private WritableCellFormat arial10Colorformat = null;
	private WritableCellFormat arial10Lineformat = null;
	private WritableCellFormat nfInteroCell = null;
	private WritableCellFormat nfDoubleFourCell = null;
	private WritableCellFormat nfDoubleFiveCell = null;
	
	public String execute() throws Exception {
		
		//XlsGenerator xls = new XlsGenerator();

	    //response.setContentType("application/x-download");
	    //response.addHeader("Content-Disposition", "attachment;filename = report.xls");
	    
		LOG.debug("[ExportResultXlsAction::execute] BEGIN");
		
		//ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//WritableWorkbook workbook;
		try {
			
			ArrayList<Ace> aceList = getAppAceList();
			
			/*
			ArrayList<CertificatoreExport> certificatori = getCertificatoreMgr()
			.findElencoCertificatoriForExport(getAppDatacertificatori(), filtroRicerca.getDataACEdal(), filtroRicerca.getDataACEal());

			String dataACEdal = filtroRicerca.getDataACEdal()!=null?GenericUtil.convertToString(filtroRicerca.getDataACEdal()):"";
			String dataACEal = filtroRicerca.getDataACEal()!=null?GenericUtil.convertToString(filtroRicerca.getDataACEal()):"";;

			*/
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//workbook = Workbook.createWorkbook(new File("myfile.xls"));
			
			WritableWorkbook workbook = Workbook.createWorkbook(baos);
			WritableSheet sheet = workbook.createSheet("Foglio1", 0);
			
			int riga = 1;
			int col = 1;
			
			// Definisco gli stili
			WritableFont arial10Boldfont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 
			WritableCellFormat arial10Boldformat = new WritableCellFormat (arial10Boldfont); 

			WritableFont arial10Colorfont = new WritableFont(WritableFont.ARIAL, 10); 
			arial10Colorformat = new WritableCellFormat (arial10Colorfont);
			arial10Colorformat.setBackground(Colour.YELLOW2);
			arial10Colorformat.setBorder(Border.ALL, BorderLineStyle.THIN);

			WritableFont arial10Linefont = new WritableFont(WritableFont.ARIAL, 10); 
			arial10Lineformat = new WritableCellFormat (arial10Linefont); 
			arial10Lineformat.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			nfInteroCell = new WritableCellFormat(NumberFormats.INTEGER);
			nfInteroCell.setBorder(Border.ALL, BorderLineStyle.THIN);

			//NumberFormat nfFour = new NumberFormat("#,##0.####");
			NumberFormat nfFour = new NumberFormat("#,##0.0000");
			nfDoubleFourCell = new WritableCellFormat(nfFour);
			nfDoubleFourCell.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			//NumberFormat nfFive = new NumberFormat("#,##0.#####");
			NumberFormat nfFive = new NumberFormat("#,##0.00000");
			nfDoubleFiveCell = new WritableCellFormat(nfFive);
			nfDoubleFiveCell.setBorder(Border.ALL, BorderLineStyle.THIN);
			/*
			Locale locale = Locale.ITALIAN;
			NumberFormat format = NumberFormat.getNumberInstance(locale);
			format.setMaximumFractionDigits(cifre); // what you seem to want
			format.setMinimumFractionDigits(cifre); // cifre dopo la virgola
			*/
			
			
			Label label = new Label(col,riga,"Elenco A.P.E.", arial10Boldformat);
			sheet.addCell(label);

			if (aceList != null && aceList.size() > 0)
			{
				// Devo capire se gli ace sono OLD o NEW (prendo il rpimo, son sicuro che son dello stesso tipo)
				if (aceList.get(0).getFlgOld().equalsIgnoreCase(Constants.LABEL_SI))
				{
					componiAceOld(sheet);
				}
				else
				{
					componiAceNew(sheet);
				}
			}

			
			/*
			riga = 4;
			
			String[] intestazioneCol = new String[]{
					"Anno", 
					"Numero Matricola", 
					"Codice ACE", 
					"Certificatore", 
					"Stato", 
					"Data inizio", 
					"Data invio", 
					"Provincia", 
					"Comune", 
					"Indirizzo", 
					"Sezione", 
					"Foglio", 
					"Particella", 
					"Subalterno", 
					"Gradi giorno", 
					"Piano", 
					"Piani totali", 
					"Destinazione d'uso", 
					"Caratteristiche dell'edificio",
					"Descrizione tipologia edificio", 
					"Anno costruzione", 
					"Anno ristrutturazione", 
					"Volume lordo riscaldato (V) [m3]",
					"Superficie disperdente totale (S) [m2]", 
					"Superficie utile climatizzata (SU) [m2]", 
					"V/SU", 
					"Fattore forma (S/V)", 
					"Trasmittanza media superfici opache verticali [W/m2*K]", 
					"Trasmittanza media superfici trasparenti [W/m2*K]", 
					"Tipologia impianto di riscaldamento", 
					"Fonte energetica per riscaldamento", 
					"Fonte energetica per acs",
					"Classe energetica regionale", 
					"Classe energetica nazionale", 
					"Fabbisogno di energia termica utile ideale (Qh,nd) per unita' di sup/vol [kWh/m2 o kWh/m3]", 
					"Fabbisogno di energia termica utile ideale (QH,nd) per unita' di sup/vol Torino [kWh/m2 o kWh/m3]",
					"Fabbisogno di energia termica utile per acqua calda sanitaria [kWh/anno]", 
					"Fabbisogno di energia termica utile per acqua calda sanitaria Torino [kWh/anno]",
					"Fabbisogno di energia termica utile per acqua calda sanitaria soddisfatto da fonti rinnovabili [kWh/anno]", 
					"Fabbisogno di energia termica utile per acs/Superficie utile (Qhw/SU)",
					"Rendimento medio globale impianto termico (ETAg)", 
					"Rendimento medio globale stagionale per ACS (ETAg acs)", 
					"Coefficiente di prestazione della pompa calore (se installata)", 
					"Indice di prestazione energetica riscaldamento invernale (Epi,r) [kWh/m2 o kWh/m3]",
					"Indice di prestazione energetica per il riscaldamento invernale Torino (EPi To) [kWh/m2 o kWh/m3]", 
					"Indice di prestazione energetica per acs (EPacs)",
					"Indice prestazione energetica globale (EPL lordo) [kWh/m2 o kWh/m3]", 
					"Indice prestazione energetica globaleTorino (EPL lordo) [kWh/m2 o kWh/m3]",
					"Motivazione rilascio", 
					"Metodologia di calcolo adottata", 
					"Software utilizzato",
					"Prestazione energetica raggiungibile",
					"Num. appart/unita'",
					"UI servite",
					"Potenza nominale generatore",
					"Classe efficienza generatore",
					"Anno installatore generatore",
					"Contabilizzazione/ripartizione",
					"Rendimento di generazione",
					"Rendimento di regolazione",
					"Rendimento di emissione",
					"Rendimento di distribuzione"};

					
			
			//convertToString
			//62 colonne
			
			for (int i = 0; i < intestazioneCol.length; i++) {
				
				label = new Label(col ,riga, intestazioneCol[i], arial10Colorformat);
				sheet.addCell(label);
				sheet.setColumnView(col, 42);
				col++;
			}
			
			

			for (int i = 0; i < aceList.size(); i++) 
			{
				col = 1;
				riga++;
				
				Ace cert = aceList.get(i);
				
				sheet.addCell(settaCella(col++, riga, cert.getAnno(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getNumCertificatore(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getProgrCertificato(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getNomeCognomeCert(), arial10Lineformat));
				
				sheet.addCell(settaCella(col++, riga, cert.getDescStato(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDtInizio(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDtUpload(), arial10Lineformat));
				
				sheet.addCell(settaCella(col++, riga, cert.getDescProv(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDescComune(), arial10Lineformat));

				String indirizzoNumero = StringUtils.trimToEmpty(cert.getDescIndirizzo());
				
				if (StringUtils.trimToNull(cert.getNumCivico()) != null)
				{
					indirizzoNumero += ", " + cert.getNumCivico();
				}

				sheet.addCell(settaCella(col++, riga, indirizzoNumero, arial10Lineformat));
				
				
				
				
				sheet.addCell(settaCella(col++, riga, cert.getSezione(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getFoglio(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getParticella(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getSubalterno(), arial10Lineformat));

				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getGradiGiorno()), nfInteroCell));

				sheet.addCell(settaCella(col++, riga, GenericUtil.convertToString(cert.getPiano()), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, GenericUtil.convertToString(cert.getNumPianiComplessivi()), arial10Lineformat));

				
				
				
				sheet.addCell(settaCella(col++, riga, cert.getDescDestUso(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDescEdificio(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDescTipoEdificio(), arial10Lineformat));


				
				
				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getAnnoCostruzione()), nfInteroCell));

				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getAnnoUltRist()), nfInteroCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getVolLordoRiscaldato(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getSupDisperdenteTot(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getSu(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getVSu(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getFattoreForma(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getTrasmOpache(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getTrasmTrasp(), nfDoubleFourCell));

				
				
				sheet.addCell(settaCella(col++, riga, cert.getDescTipoImpianto(), arial10Lineformat));
				sheet.addCell(settaCella(col++, riga, cert.getDescCombustibileRisc(), arial10Lineformat));
				sheet.addCell(settaCella(col++, riga, cert.getDescCombustibileAcs(), arial10Lineformat));

				
				sheet.addCell(settaCella(col++, riga, cert.getDescClasse(), arial10Lineformat));
				sheet.addCell(settaCella(col++, riga, cert.getDescClasse19205(), arial10Lineformat));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomRiscQh(), nfDoubleFourCell));
				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomRiscQhto(), nfDoubleFourCell));


				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomAcsQhw(), nfDoubleFourCell));
				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomAcsQhwto(), nfDoubleFourCell));

				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getEnAcsRinno(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomAcsQhwSu(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendImpEtag(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendAcsEtagacs(), nfDoubleFiveCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getValorePrestPdc(), nfDoubleFourCell));


				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getIndRiscEpi(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getIndRiscEpito(), nfDoubleFourCell));
				
				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getFabbAcs(), nfDoubleFourCell));
				
				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getIndGlobEplordo(), nfDoubleFourCell));
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getIndGlobEplordoTo(), nfDoubleFourCell));


				sheet.addCell(settaCella(col++, riga, cert.getDescMotivo(), arial10Lineformat));

				
				sheet.addCell(settaCella(col++, riga, cert.getMetodologiaCalcolo(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getSwUtilizzato(), arial10Lineformat));

				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getPrestazioneEne(), nfDoubleFourCell));

				sheet.addCell(settaCella(col++, riga, GenericUtil.convertToString(cert.getNumAppartamenti()), arial10Lineformat));
				
				sheet.addCell(settaCella(col++, riga, cert.getUiServite(), arial10Lineformat));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getPotRiscaldamento(), nfDoubleFourCell));

				sheet.addCell(settaCella(col++, riga, cert.getDescClasseEffRisc(), arial10Lineformat));

				
				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getGenAnnoRisc()), nfInteroCell));
				
				
				sheet.addCell(settaCella(col++, riga, cert.getFlgContRip(), arial10Lineformat));

				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendGener(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendRegol(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendEmiss(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendDistrib(), nfDoubleFourCell));

			}
			*/
			//ByteArrayInputStream filePdf = workbook;
			
			workbook.write();
			workbook.close();
			
			byte[] prova = baos.toByteArray();
			
			ByteArrayInputStream filePdf = new ByteArrayInputStream(prova);

			inputStream = filePdf;
			
			String nomeFile = "elencoAPE.xls";
			contentDisposition = "attachment; filename=\"" + nomeFile + "\";";
			 
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[ExportResultXlsAction::execute] END");
			
			if (inputStream != null) {
				inputStream.close();
			}
			
		}
		return "report";
	}

	private void componiAceNew(WritableSheet sheet) throws Exception {
		
		LOG.debug("[ExportResultXlsAction::componiAceNew] BEGIN");

		try {
			
			ArrayList<Ace> aceList = getAppAceList();
			
			
			/*
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//workbook = Workbook.createWorkbook(new File("myfile.xls"));
			
			WritableWorkbook workbook = Workbook.createWorkbook(baos);
			WritableSheet sheet = workbook.createSheet("Foglio1", 0);
			
			int riga = 1;
			int col = 1;
			
			// Definisco gli stili
			WritableFont arial10Boldfont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 
			WritableCellFormat arial10Boldformat = new WritableCellFormat (arial10Boldfont); 

			WritableFont arial10Colorfont = new WritableFont(WritableFont.ARIAL, 10); 
			WritableCellFormat arial10Colorformat = new WritableCellFormat (arial10Colorfont);
			arial10Colorformat.setBackground(Colour.YELLOW2);
			arial10Colorformat.setBorder(Border.ALL, BorderLineStyle.THIN);

			WritableFont arial10Linefont = new WritableFont(WritableFont.ARIAL, 10); 
			WritableCellFormat arial10Lineformat = new WritableCellFormat (arial10Linefont); 
			arial10Lineformat.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			WritableCellFormat nfInteroCell = new WritableCellFormat(NumberFormats.INTEGER);
			nfInteroCell.setBorder(Border.ALL, BorderLineStyle.THIN);

			//NumberFormat nfFour = new NumberFormat("#,##0.####");
			NumberFormat nfFour = new NumberFormat("#,##0.0000");
			WritableCellFormat nfDoubleFourCell = new WritableCellFormat(nfFour);
			nfDoubleFourCell.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			//NumberFormat nfFive = new NumberFormat("#,##0.#####");
			NumberFormat nfFive = new NumberFormat("#,##0.00000");
			WritableCellFormat nfDoubleFiveCell = new WritableCellFormat(nfFive);
			nfDoubleFiveCell.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			
			Label label = new Label(col,riga,"Elenco A.P.E.", arial10Boldformat);
			sheet.addCell(label);
			

			riga = 4;
			*/
			
			Label label = null;
			int riga = 4;
			int col = 1;

			String[] intestazioneCol = new String[]{
					"Anno", 
					"Numero Matricola", 
					"Codice ACE", 
					"Certificatore", 
					"Stato", 
					"Data inizio", 
					"Data invio", 
					"Data scadenza",
					"Provincia", 
					"Comune", 
					"Indirizzo", 
					"Sezione", 
					"Foglio", 
					"Particella", 
					"Subalterno", 
					"Piano", 
					"Destinazione d'uso", 
					"Anno costruzione", 
					"Anno ristrutturazione", 
					"Edificio a energia quasi zero",
					"Indice della prestazione energetica non rinnovabile EPgl,nren",
					"Indice della prestazione energetica rinnovabile EPgl,ren",
					"Emissioni CO2",
					"Superficie utile raffrescata (m2)",
					"Superficie utile riscaldata (m2)",
					"Volume lordo raffrescato (m3)",
					"Volume lordo riscaldato (m3)",
					"EPh",
					"Asol,est/Asup utile",
					"Yie",
					"V/SU raffrescato",
					"V/SU riscaldato ",
					"S/V raffrescato ",
					"S/V riscaldato "};

					
			
			//convertToString
			//62 colonne
			
			for (int i = 0; i < intestazioneCol.length; i++) {
				
				label = new Label(col ,riga, intestazioneCol[i], arial10Colorformat);
				sheet.addCell(label);
				sheet.setColumnView(col, 42);
				col++;
			}
			
			

			for (int i = 0; i < aceList.size(); i++) 
			{
				col = 1;
				riga++;
				
				Ace cert = aceList.get(i);
				
				sheet.addCell(settaCella(col++, riga, cert.getAnno(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getNumCertificatore(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getProgrCertificato(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getNomeCognomeCert(), arial10Lineformat));
				
				sheet.addCell(settaCella(col++, riga, cert.getDescStato(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDtInizio(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDtUpload(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDtScadenza(), arial10Lineformat));
				
				sheet.addCell(settaCella(col++, riga, cert.getDescProv(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDescComune(), arial10Lineformat));

				String indirizzoNumero = StringUtils.trimToEmpty(cert.getDescIndirizzo());
				
				if (StringUtils.trimToNull(cert.getNumCivico()) != null)
				{
					indirizzoNumero += ", " + cert.getNumCivico();
				}

				sheet.addCell(settaCella(col++, riga, indirizzoNumero, arial10Lineformat));
				
				
				
				sheet.addCell(settaCella(col++, riga, cert.getSezione(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getFoglio(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getParticella(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getSubalterno(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, GenericUtil.convertToString(cert.getPiano()), arial10Lineformat));
				
				sheet.addCell(settaCella(col++, riga, cert.getDescDestUso(), arial10Lineformat));

				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getAnnoCostruzione()), nfInteroCell));

				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getAnnoUltRist()), nfInteroCell));

				
				
				sheet.addCell(settaCella(col++, riga, cert.getFlgEdifE0(), arial10Lineformat));
				
				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getEpglNrenGlobale(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getEpglRenGlobale(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getEmissioniCo2(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getSupRaffrescata(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getSupRiscaldata(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getVolLordoRaffrescato(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getVolLordoRiscaldato(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getEph(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getAsolAsup(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getYie(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getVSuRaff(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getVSuRisc(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getSVRaff(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getSVRisc(), nfDoubleFourCell));

				
				
			}
			
			
			 
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[ExportResultXlsAction::componiAceNew] END");
		}
	}

	
	private void componiAceOld(WritableSheet sheet) throws Exception {
		
		LOG.debug("[ExportResultXlsAction::componiAceOld] BEGIN");

		try {
			
			ArrayList<Ace> aceList = getAppAceList();
			
			
			/*
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//workbook = Workbook.createWorkbook(new File("myfile.xls"));
			
			WritableWorkbook workbook = Workbook.createWorkbook(baos);
			WritableSheet sheet = workbook.createSheet("Foglio1", 0);
			
			int riga = 1;
			int col = 1;
			
			// Definisco gli stili
			WritableFont arial10Boldfont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD); 
			WritableCellFormat arial10Boldformat = new WritableCellFormat (arial10Boldfont); 

			WritableFont arial10Colorfont = new WritableFont(WritableFont.ARIAL, 10); 
			WritableCellFormat arial10Colorformat = new WritableCellFormat (arial10Colorfont);
			arial10Colorformat.setBackground(Colour.YELLOW2);
			arial10Colorformat.setBorder(Border.ALL, BorderLineStyle.THIN);

			WritableFont arial10Linefont = new WritableFont(WritableFont.ARIAL, 10); 
			WritableCellFormat arial10Lineformat = new WritableCellFormat (arial10Linefont); 
			arial10Lineformat.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			WritableCellFormat nfInteroCell = new WritableCellFormat(NumberFormats.INTEGER);
			nfInteroCell.setBorder(Border.ALL, BorderLineStyle.THIN);

			//NumberFormat nfFour = new NumberFormat("#,##0.####");
			NumberFormat nfFour = new NumberFormat("#,##0.0000");
			WritableCellFormat nfDoubleFourCell = new WritableCellFormat(nfFour);
			nfDoubleFourCell.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			//NumberFormat nfFive = new NumberFormat("#,##0.#####");
			NumberFormat nfFive = new NumberFormat("#,##0.00000");
			WritableCellFormat nfDoubleFiveCell = new WritableCellFormat(nfFive);
			nfDoubleFiveCell.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			
			Label label = new Label(col,riga,"Elenco A.P.E.", arial10Boldformat);
			sheet.addCell(label);
			

			riga = 4;
			*/
			
			Label label = null;
			int riga = 4;
			int col = 1;

			String[] intestazioneCol = new String[]{
					"Anno", 
					"Numero Matricola", 
					"Codice ACE", 
					"Certificatore", 
					"Stato", 
					"Data inizio", 
					"Data invio", 
					"Data scadenza",
					"Provincia", 
					"Comune", 
					"Indirizzo", 
					"Sezione", 
					"Foglio", 
					"Particella", 
					"Subalterno", 
					"Gradi giorno", 
					"Piano", 
					"Piani totali", 
					"Destinazione d'uso", 
					"Caratteristiche dell'edificio",
					"Descrizione tipologia edificio", 
					"Anno costruzione", 
					"Anno ristrutturazione", 
					"Volume lordo riscaldato (V) [m3]",
					"Superficie disperdente totale (S) [m2]", 
					"Superficie utile climatizzata (SU) [m2]", 
					"V/SU", 
					"Fattore forma (S/V)", 
					"Trasmittanza media superfici opache verticali [W/m2*K]", 
					"Trasmittanza media superfici trasparenti [W/m2*K]", 
					"Tipologia impianto di riscaldamento", 
					"Fonte energetica per riscaldamento", 
					"Fonte energetica per acs",
					"Classe energetica regionale", 
					"Classe energetica nazionale", 
					"Fabbisogno di energia termica utile ideale (Qh,nd) per unita' di sup/vol [kWh/m2 o kWh/m3]", 
					"Fabbisogno di energia termica utile ideale (QH,nd) per unita' di sup/vol Torino [kWh/m2 o kWh/m3]",
					"Fabbisogno di energia termica utile per acqua calda sanitaria [kWh/anno]", 
					"Fabbisogno di energia termica utile per acqua calda sanitaria Torino [kWh/anno]",
					"Fabbisogno di energia termica utile per acqua calda sanitaria soddisfatto da fonti rinnovabili [kWh/anno]", 
					"Fabbisogno di energia termica utile per acs/Superficie utile (Qhw/SU)",
					"Rendimento medio globale impianto termico (ETAg)", 
					"Rendimento medio globale stagionale per ACS (ETAg acs)", 
					"Coefficiente di prestazione della pompa calore (se installata)", 
					"Indice di prestazione energetica riscaldamento invernale (Epi,r) [kWh/m2 o kWh/m3]",
					"Indice di prestazione energetica per il riscaldamento invernale Torino (EPi To) [kWh/m2 o kWh/m3]", 
					"Indice di prestazione energetica per acs (EPacs)",
					"Indice prestazione energetica globale (EPL lordo) [kWh/m2 o kWh/m3]", 
					"Indice prestazione energetica globaleTorino (EPL lordo) [kWh/m2 o kWh/m3]",
					"Motivazione rilascio", 
					"Metodologia di calcolo adottata", 
					"Software utilizzato",
					"Prestazione energetica raggiungibile",
					"Num. appart/unita'",
					"UI servite",
					"Potenza nominale generatore",
					"Classe efficienza generatore",
					"Anno installatore generatore",
					"Contabilizzazione/ripartizione",
					"Rendimento di generazione",
					"Rendimento di regolazione",
					"Rendimento di emissione",
					"Rendimento di distribuzione"};

					
			
			//convertToString
			//62 colonne
			
			for (int i = 0; i < intestazioneCol.length; i++) {
				
				label = new Label(col ,riga, intestazioneCol[i], arial10Colorformat);
				sheet.addCell(label);
				sheet.setColumnView(col, 42);
				col++;
			}
			
			

			for (int i = 0; i < aceList.size(); i++) 
			{
				col = 1;
				riga++;
				
				Ace cert = aceList.get(i);
				
				sheet.addCell(settaCella(col++, riga, cert.getAnno(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getNumCertificatore(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getProgrCertificato(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getNomeCognomeCert(), arial10Lineformat));
				
				sheet.addCell(settaCella(col++, riga, cert.getDescStato(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDtInizio(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDtUpload(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDtScadenza(), arial10Lineformat));
				
				sheet.addCell(settaCella(col++, riga, cert.getDescProv(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDescComune(), arial10Lineformat));

				String indirizzoNumero = StringUtils.trimToEmpty(cert.getDescIndirizzo());
				
				if (StringUtils.trimToNull(cert.getNumCivico()) != null)
				{
					indirizzoNumero += ", " + cert.getNumCivico();
				}

				sheet.addCell(settaCella(col++, riga, indirizzoNumero, arial10Lineformat));
				
				
				
				sheet.addCell(settaCella(col++, riga, cert.getSezione(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getFoglio(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getParticella(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getSubalterno(), arial10Lineformat));

				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getGradiGiorno()), nfInteroCell));

				sheet.addCell(settaCella(col++, riga, GenericUtil.convertToString(cert.getPiano()), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, GenericUtil.convertToString(cert.getNumPianiComplessivi()), arial10Lineformat));

				
				
				
				sheet.addCell(settaCella(col++, riga, cert.getDescDestUso(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDescEdificio(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getDescTipoEdificio(), arial10Lineformat));


				
				
				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getAnnoCostruzione()), nfInteroCell));

				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getAnnoUltRist()), nfInteroCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getVolLordoRiscaldato(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getSupDisperdenteTot(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getSu(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getVSu(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getFattoreForma(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getTrasmOpache(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getTrasmTrasp(), nfDoubleFourCell));

				
				
				sheet.addCell(settaCella(col++, riga, cert.getDescTipoImpianto(), arial10Lineformat));
				sheet.addCell(settaCella(col++, riga, cert.getDescCombustibileRisc(), arial10Lineformat));
				sheet.addCell(settaCella(col++, riga, cert.getDescCombustibileAcs(), arial10Lineformat));

				
				sheet.addCell(settaCella(col++, riga, cert.getDescClasse(), arial10Lineformat));
				sheet.addCell(settaCella(col++, riga, cert.getDescClasse19205(), arial10Lineformat));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomRiscQh(), nfDoubleFourCell));
				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomRiscQhto(), nfDoubleFourCell));


				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomAcsQhw(), nfDoubleFourCell));
				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomAcsQhwto(), nfDoubleFourCell));

				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getEnAcsRinno(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getDomAcsQhwSu(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendImpEtag(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendAcsEtagacs(), nfDoubleFiveCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getValorePrestPdc(), nfDoubleFourCell));


				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getIndRiscEpi(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getIndRiscEpito(), nfDoubleFourCell));
				
				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getFabbAcs(), nfDoubleFourCell));
				
				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getIndGlobEplordo(), nfDoubleFourCell));
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getIndGlobEplordoTo(), nfDoubleFourCell));


				sheet.addCell(settaCella(col++, riga, cert.getDescMotivo(), arial10Lineformat));

				
				sheet.addCell(settaCella(col++, riga, cert.getMetodologiaCalcolo(), arial10Lineformat));

				sheet.addCell(settaCella(col++, riga, cert.getSwUtilizzato(), arial10Lineformat));

				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getPrestazioneEne(), nfDoubleFourCell));

				sheet.addCell(settaCella(col++, riga, GenericUtil.convertToString(cert.getNumAppartamenti()), arial10Lineformat));
				
				sheet.addCell(settaCella(col++, riga, cert.getUiServite(), arial10Lineformat));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getPotRiscaldamento(), nfDoubleFourCell));

				sheet.addCell(settaCella(col++, riga, cert.getDescClasseEffRisc(), arial10Lineformat));

				
				sheet.addCell(settaCellaNumber(col++, riga, convertToDouble(cert.getGenAnnoRisc()), nfInteroCell));
				
				
				sheet.addCell(settaCella(col++, riga, cert.getFlgContRip(), arial10Lineformat));

				
				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendGener(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendRegol(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendEmiss(), nfDoubleFourCell));

				sheet.addCell(settaCellaNumberDouble(col++, riga, cert.getRendDistrib(), nfDoubleFourCell));

			}
			
			
			 
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[ExportResultXlsAction::componiAceOld] END");
		}
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
	}

	@Override
	public Class modelClass() {
		return null;
	}
	
	
	public ArrayList<Ace> getAppAceList() {
		return (ArrayList<Ace>) (getSession()
				.get("appDataaceList"));
	}

	public FiltroRicercaAce getAppDataricercaAce() {
		return (FiltroRicercaAce) (getSession()
				.get("appDataricercaAce"));
	}
	
	public ArrayList<Certificatore> getAppDatacertificatori() {
		return (ArrayList<Certificatore>) (getSession()
				.get("appDatacertificatori"));
	}
	
	
	public String getAppDatacodAceInviatoSelezionato() {
		return (String) (getSession()
				.get("appDatacodAceInviatoSelezionato"));
	}
	
	private Label settaCella(int col, int riga, String valore, WritableCellFormat cellFormat)
	{
		return new Label(col, riga, valore, cellFormat);
	}

	public static Double convertToDouble(Integer dt) {
		if (dt != null) {			
			return Double.valueOf(dt);
		} else
			return new Double(0);
	}
	
	private Number settaCellaNumberDouble(int col, int riga, UDTPositiveDoubleFour valoreDF, WritableCellFormat nfNumberCell)
	{
		Double valore;
		if (valoreDF == null)
		{
			valore = new Double(0);
		}
		else
		{
			valore = valoreDF.getValue();
		}
		
		return settaCellaNumber(col, riga, arrotonda(valore,4), nfNumberCell);
	}

	private Number settaCellaNumberDouble(int col, int riga, UDTPositiveDoubleFive valoreDF, WritableCellFormat nfNumberCell)
	{
		Double valore;
		if (valoreDF == null)
		{
			valore = new Double(0);
		}
		else
		{
			valore = valoreDF.getValue();
		}
		
		return settaCellaNumber(col, riga, arrotonda(valore,5), nfNumberCell);
	}

	private Number settaCellaNumber(int col, int riga, double valore, WritableCellFormat nfNumberCell)
	{
		
		return new Number(col, riga, valore, nfNumberCell);
		
	}


	private double arrotonda( double numero, int nCifreDecimali ){
	    return Math.round( numero * Math.pow( 10, nCifreDecimali ) )/Math.pow( 10, nCifreDecimali );
	}

	@Override
	public BaseSessionAwareDTO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setModel(BaseSessionAwareDTO t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void dumpModel(boolean pre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doBeforeEventCommand()  {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAfterEventCommand()  {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
