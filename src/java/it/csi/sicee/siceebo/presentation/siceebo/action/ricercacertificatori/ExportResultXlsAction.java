/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.presentation.siceebo.action.ricercacertificatori;


import it.csi.sicee.siceebo.business.facade.CertificatoreMgr;
import it.csi.sicee.siceebo.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceebo.dto.certificatori.Certificatore;
import it.csi.sicee.siceebo.dto.certificatori.CertificatoreExport;
import it.csi.sicee.siceebo.dto.certificatori.FiltroRicercaCertificatori;
import it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction;
import it.csi.sicee.siceebo.presentation.siceebo.action.ICommand;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.apache.commons.lang.StringUtils;

public class ExportResultXlsAction extends BaseAction<BaseSessionAwareDTO> {
	

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
	
	public String execute() throws Exception {
		
		//XlsGenerator xls = new XlsGenerator();

	    //response.setContentType("application/x-download");
	    //response.addHeader("Content-Disposition", "attachment;filename = report.xls");
	    
		LOG.debug("[ExportResultXlsAction::execute] BEGIN");
		
		//ByteArrayOutputStream baos = new ByteArrayOutputStream();
		//WritableWorkbook workbook;
		try {
			
			FiltroRicercaCertificatori filtroRicerca = getAppDataricercaCertificatori();

			ArrayList<CertificatoreExport> certificatori = getCertificatoreMgr()
			.findElencoCertificatoriForExport(getAppDatacertificatoriList(), filtroRicerca.getDataACEdal(), filtroRicerca.getDataACEal());

			String dataACEdal = filtroRicerca.getDataACEdal()!=null?GenericUtil.convertToString(filtroRicerca.getDataACEdal()):Constants.DATA_INIZIO_CERTIFICAZIONI;
			String dataACEal = filtroRicerca.getDataACEal()!=null?GenericUtil.convertToString(filtroRicerca.getDataACEal()):GenericUtil.getDataOdierna();

			
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
			nfInteroCell.setFont(arial10Linefont);
			nfInteroCell.setBorder(Border.ALL, BorderLineStyle.THIN);
			
			Label label = new Label(col,riga,"Elenco certificatori", arial10Boldformat);
			sheet.addCell(label);

			riga = 4;
			
			/*
			String[] intestazioneCol = new String[]{"Matricola", "Nome", "Cognome", "Titolo", "Provincia ordine/collegio", "Numero iscrizione", "Data iscrizione", "Corso frequentato presso", 
					"Modulo 1 dal...al", "Modulo 2 dal...al", "Attestazione di partecipazione emessa da", "Data attestazione di partecipazione", "Esame sostenuto presso",
					"Data esame", "Numero totale di A.P.E. inviati", "Numero totale di A.P.E. inviati A+", "Numero totale di A.P.E. inviati A", "Numero totale di A.P.E. inviati B",
					"Numero totale di A.P.E. inviati C", "Numero totale di A.P.E. inviati D", "Numero totale di A.P.E. inviati E", "Numero totale di A.P.E. inviati F", 
					"Numero totale di A.P.E. inviati G", "Numero totale di A.P.E. inviati NC", "Data invio dal", "Data invio al", "Codice fiscale", 
					"Data di nascita", "Regione di nascita", "Provincia di nascita", "Comune di nascita","Regione residenza", 
					"Provincia residenza", "Comune residenza", "Indirizzo residenza", "Num Civico", "CAP", "Telefono", "Cellulare", "Email", "Email PEC", "Fax",
					"Sito web", "Ragione Sociale", "Partita Iva", "Regione", "Provincia", "Comune", "Indirizzo", "Numero Civico", "CAP"};
			*/
			
			String[] intestazioneCol = new String[]{"Matricola", "Nome", "Cognome", "Titolo", "Provincia ordine/collegio", "Numero iscrizione", "Data iscrizione", "Corso frequentato presso", 
					"Modulo 1 dal...al", "Modulo 2 dal...al", "Attestazione di partecipazione emessa da", "Data attestazione di partecipazione", "Esame sostenuto presso",
					"Data esame", "Numero totale di A.P.E. inviati", "Data invio dal", "Data invio al", "Codice fiscale", 
					"Data di nascita", "Regione di nascita", "Provincia di nascita", "Comune di nascita","Regione residenza", 
					"Provincia residenza", "Comune residenza", "Indirizzo residenza", "Num Civico", "CAP", "Telefono", "Cellulare", "Email", "Email PEC", "Fax",
					"Sito web", "Ragione Sociale", "Partita Iva", "Regione", "Provincia", "Comune", "Indirizzo", "Numero Civico", "CAP"};

			
			//convertToString
			
			
			for (int i = 0; i < intestazioneCol.length; i++) {
				
				label = new Label(col ,riga, intestazioneCol[i], arial10Colorformat);
				sheet.addCell(label);
				sheet.setColumnView(col, 18);
				col++;
			}
			/*
			
			
			label = new Label(col++, riga, "Nome", arial10Colorformat);
			sheet.addCell(label);
			sheet.setColumnView(col, 18);

			label = new Label(col++, riga, "Cognome", arial10Colorformat);
			sheet.addCell(label);
			sheet.setColumnView(col, 18);

			label = new Label(col++, riga, "Titolo", arial10Colorformat);
			sheet.addCell(label);
			sheet.setColumnView(col, 18);
			*/
			

			for (int i = 0; i < certificatori.size(); i++) 
			{
				col = 1;
				riga++;
				
				CertificatoreExport cert = certificatori.get(i);
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getMatricola(), arial10Lineformat));

				sheet.addCell(settaCellaLabel(col++, riga, cert.getNome(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getCognome(), arial10Lineformat));

				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescTitolo(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescProvOrdine(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getNumIscrAlbo(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, GenericUtil.convertToString(cert.getDataIscrAlbo()), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getCorsoFrequentato(), arial10Lineformat));
				
				StringBuffer dataModulo = new StringBuffer();
					
				dataModulo.append(StringUtils.trimToEmpty(GenericUtil.convertToString(cert.getDataModulo1Da())));
				if (!GenericUtil.isNullOrEmpty(cert.getDataModulo1Da()) && !GenericUtil.isNullOrEmpty(cert.getDataModulo1A()))
				{
					dataModulo.append(" - ");
				}
				dataModulo.append(StringUtils.trimToEmpty(GenericUtil.convertToString(cert.getDataModulo1A())));
				//StringUtils.trimToEmpty( +  + StringUtils.trimToEmpty(GenericUtil.convertToString(cert.getDataModulo1A()));
				
				sheet.addCell(settaCellaLabel(col++, riga, dataModulo.toString(), arial10Lineformat));


				dataModulo = new StringBuffer();
				dataModulo.append(StringUtils.trimToEmpty(GenericUtil.convertToString(cert.getDataModulo2Da())));
				if (!GenericUtil.isNullOrEmpty(cert.getDataModulo2Da()) && !GenericUtil.isNullOrEmpty(cert.getDataModulo2A()))
				{
					dataModulo.append(" - ");
				}
				dataModulo.append(StringUtils.trimToEmpty(GenericUtil.convertToString(cert.getDataModulo2A())));

				//dataModulo = StringUtils.trimToEmpty(GenericUtil.convertToString(cert.getDataModulo2Da())) + " - " + StringUtils.trimToEmpty(GenericUtil.convertToString(cert.getDataModulo2A()));
				sheet.addCell(settaCellaLabel(col++, riga, dataModulo.toString(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getAttPartecipEmesso(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, GenericUtil.convertToString(cert.getDataAttPartecip()), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getAttEsamePresso(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, GenericUtil.convertToString(cert.getDataAttEsame()), arial10Lineformat));
				
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceTot(), nfInteroCell));
				
				/*
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceClasseApiu(), nfInteroCell));
				
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceClasseA(), nfInteroCell));
				
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceClasseB(), nfInteroCell));
				
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceClasseC(), nfInteroCell));
				
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceClasseD(), nfInteroCell));
				
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceClasseE(), nfInteroCell));
				
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceClasseF(), nfInteroCell));
				
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceClasseG(), nfInteroCell));
				
				sheet.addCell(settaCellaNumber(col++, riga, cert.getNumAceClasseNC(), nfInteroCell));
				*/
				
				
				// DATA INVIO DAL .... AL 
				sheet.addCell(settaCellaLabel(col++, riga, dataACEdal, arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, dataACEal, arial10Lineformat));
				

				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getCodiceFiscaleCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, GenericUtil.convertToString(cert.getDataNascitaCert()), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescRegioneNascitaCert(), arial10Lineformat));

				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescProvNascitaCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescComuneNascitaCert(), arial10Lineformat));

				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescRegioneResidenzaCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescProvResidenzaCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescComuneResidenzaCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescIndirizzoCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getNumCivicoResidenzaCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getCapCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getTelefonoCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getCellCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getEmailCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getEmailPecCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getFaxCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getSitoWebCert(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDenominazioneAzienda(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getPIvaAzienda(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescRegioneAzienda(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescProvAzienda(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescComuneAzienda(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getDescIndirizzoAzienda(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getNumCivicoAzienda(), arial10Lineformat));
				
				sheet.addCell(settaCellaLabel(col++, riga, cert.getCapAzienda(), arial10Lineformat));
			}
			//ByteArrayInputStream filePdf = workbook;
			
			workbook.write();
			workbook.close();
			
			byte[] prova = baos.toByteArray();
			
			ByteArrayInputStream filePdf = new ByteArrayInputStream(prova);

			inputStream = filePdf;
			
			String nomeFile = "elencoCertificatori.xls";
			contentDisposition = "attachment; filename=\"" + nomeFile + "\";";
			 /*
			 
			InputStream inputStream = baos.toByteArray()
			
				OutputStream os = response.getOutputStream();
		      os.write(baos.toByteArray());
		      os.flush();
		      os.close();
		      */
		      
		      
		      
		      
			/*
		 att.setNumeroAttestato(getAppDatacodAceInviatoSelezionato());
		 ByteArrayInputStream filePdf = ext.stampaModulo(getCertificatoMgr().compilaCertificatoPerReport(att, getAppDatacertificatore()), ServletActionContext.getServletContext(), false, getMiscMgr().getParametroFoto());
		 inputStream = filePdf;
		 String nomeFile = getAppDatacertificato().getNumeroAttestato().replaceAll(" ", "_") + ".pdf";
		 contentDisposition = "attachment; filename=\"" + nomeFile + "\";";
	*/
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
	
/*
	public String execute() throws Exception {
		
		LOG.debug("[StampaReportAction::execute] BEGIN");
		try {

			Ace ext = new Ace();		 
		 DatiAttestato att = getAppDatacertificato();
		 if (att==null){
			 String[] split = getAppDatacodAceInviatoSelezionato().split(" ");
			 DatiCertificatore cert = new DatiCertificatore();
			 cert.setIdCertificatore(split[1]);
			 att = getCertificatoMgr().recuperaAttestato(cert, getAppDatacodAceInviatoSelezionato());
		 }

		 att.setNumeroAttestato(getAppDatacodAceInviatoSelezionato());
		 ByteArrayInputStream filePdf = ext.stampaModulo(getCertificatoMgr().compilaCertificatoPerReport(att, getAppDatacertificatore()), ServletActionContext.getServletContext(), false, getMiscMgr().getParametroFoto());
		 inputStream = filePdf;
		 String nomeFile = getAppDatacertificato().getNumeroAttestato().replaceAll(" ", "_") + ".pdf";
		 contentDisposition = "attachment; filename=\"" + nomeFile + "\";";
		 getCertificatoMgr().aggiornaStatoDefinitivo(getAppDatacertificatore(), getAppDatacertificato());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[StampaReportAction::execute] END");
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return "report";
	}
*/

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
	}

	@Override
	public Class modelClass() {
		return null;
	}
	
	public FiltroRicercaCertificatori getAppDataricercaCertificatori() {
		return (FiltroRicercaCertificatori) (getSession()
				.get("appDataricercaCertificatori"));
	}
	
	
	public List<Certificatore> getAppDatacertificatoriList() {
		return (List<Certificatore>) (getSession()
				.get("appDatacertificatoreList"));
	}
	
	
	public String getAppDatacodAceInviatoSelezionato() {
		return (String) (getSession()
				.get("appDatacodAceInviatoSelezionato"));
	}
	
	private Label settaCellaLabel(int col, int riga, String valore, WritableCellFormat cellFormat)
	{
		return new Label(col, riga, valore, cellFormat);
	}

	private Number settaCellaNumber(int col, int riga, Integer valore, WritableCellFormat nfInteroCell)
	{
		return new Number(col, riga, valore, nfInteroCell);
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
	protected void doBeforeEventCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAfterEventCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
