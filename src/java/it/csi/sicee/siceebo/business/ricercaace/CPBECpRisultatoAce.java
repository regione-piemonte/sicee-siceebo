package it.csi.sicee.siceebo.business.ricercaace;

import java.util.*;

import it.csi.sicee.siceebo.dto.*;
import it.csi.sicee.siceebo.dto.geo.*;
import it.csi.sicee.siceebo.dto.entiformativi.*;
import it.csi.sicee.siceebo.dto.certificatori.*;
import it.csi.sicee.siceebo.dto.ace.*;
import it.csi.sicee.siceebo.dto.backoffice.*;

import org.apache.log4j.*;
import it.csi.sicee.siceebo.util.*;
import it.csi.sicee.siceebo.business.*;

/*PROTECTED REGION ID(R-1740402820) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import java.io.FileInputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*PROTECTED REGION END*/

public class CPBECpRisultatoAce {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [aceList, scope:USER_SESSION]
	public static final String APPDATA_ACELIST_CODE = "appDataaceList";

	// ApplicationData: [ricercaAce, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACE_CODE = "appDataricercaAce";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [aceSostituzioneList, scope:USER_SESSION]
	public static final String APPDATA_ACESOSTITUZIONELIST_CODE = "appDataaceSostituzioneList";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	// ApplicationData: [annullamentoApe, scope:USER_SESSION]
	public static final String APPDATA_ANNULLAMENTOAPE_CODE = "appDataannullamentoApe";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	// ApplicationData: [emailInvioApe, scope:USER_SESSION]
	public static final String APPDATA_EMAILINVIOAPE_CODE = "appDataemailInvioApe";

	// ApplicationData: [listDocumentazioneAggiuntiva, scope:USER_SESSION]
	public static final String APPDATA_LISTDOCUMENTAZIONEAGGIUNTIVA_CODE = "appDatalistDocumentazioneAggiuntiva";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoAce";

	public static final String MULTIPANEL_EMAILMULTIPANEL = "emailMultipanel";
	public static final String MPI_EMAILMULTIPANEL_EMAILPANEL = CPNAME + "_" + MULTIPANEL_EMAILMULTIPANEL + "_"
			+ "emailPanel";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaScaricoModulo definito in un ExecCommand del
	 * ContentPanel cpRisultatoAce
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO = //NOSONAR  Reason:EIAS
				"ATTESTATO"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__RICEVUTA = //NOSONAR  Reason:EIAS
				"RICEVUTA"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__TRACCIATO_XML = //NOSONAR  Reason:EIAS
				"TRACCIATO_XML"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__TRACCIATO_XML_ASSENTE = //NOSONAR  Reason:EIAS
				"TRACCIATO_XML_ASSENTE"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1571657432) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getIdRiga();

			if (GenericUtil.isNullOrEmpty(codiceCertificato)
					|| !GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDataaceList())) {

				result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__KO);

			} else {
				theModel.setAppDatacodAttestatoDaStampare(codiceCertificato);

				if (theModel.getIdColonna().equals("flgModulo")) {
					result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO);
				} else if (theModel.getIdColonna().equals("flgRicevuta")) {
					result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__RICEVUTA);
				} else if (theModel.getIdColonna().equals("flgTracciato")) {

					log.debug("numeroCertificato: " + codiceCertificato);

					String[] split = theModel.getIdRiga().split(" ");

					String idCertificatore = getCertificatoreMgr().findIdCertificatoreFromNumCertificatore(split[1]);
					String progrCertificato = split[2];
					String anno = split[0];

					log.debug("idCertificatore: " + idCertificatore);
					log.debug("progrCertificato: " + progrCertificato);
					log.debug("anno: " + anno);

					boolean isImport = getCertificatoMgr().isImportDati2015(idCertificatore, progrCertificato, anno);

					log.debug("isImport: " + isImport);

					if (isImport) {
						result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__TRACCIATO_XML);

					} else {
						result.getGlobalErrors().add(
								"L'A.P.E. selezionato non e' frutto di un import XML con dati di calcolo associati");

						// Devo mettere un messaggio
						result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__TRACCIATO_XML_ASSENTE);

					}

				}
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaScaricoModulo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recuperaSostituti definito in un ExecCommand del
	 * ContentPanel cpRisultatoAce
	 */
	public ExecResults recuperaSostituti(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECUPERASOSTITUTI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RECUPERASOSTITUTI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1778231072) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)
					&& GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDataaceList())) {

				boolean isAttestatoOld = getAceMgr().isAttestatoOld(codiceCertificato);

				Ace ace = getAceMgr().findAce(codiceCertificato, isAttestatoOld);

				if (log.isDebugEnabled())
					GenericUtil.stampa(ace, true, 4);

				if (ace != null) {
					if (ace.getIdStato() == Constants.ANNULLATO || ace.getIdStato() == Constants.ANNULLATO_BO) {
						ArrayList<Ace> aceListSostitutivi = getSoaIntegrationMgr().findAceSostitutivi(ace);
						theModel.setAppDataaceSostituzioneList(aceListSostitutivi);

						result.setResultCode(RECUPERASOSTITUTI_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Il certificato non e' in stato annullato.");
						result.setResultCode(RECUPERASOSTITUTI_OUTCOME_CODE__KO);
					}
				} else {
					result.getGlobalErrors().add("Ace non trovato");
					result.setResultCode(RECUPERASOSTITUTI_OUTCOME_CODE__KO);
				}
			} else {

				theModel.setAppDatacodAceSelezionato(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");

				result.setResultCode(RECUPERASOSTITUTI_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recuperaSostituti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaReport definito in un ExecCommand del
	 * ContentPanel cpRisultatoAce
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPAREPORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPAREPORT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-334427987) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)
					&& GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDataaceList())) {

				theModel.setAppDatapaginaProvenienza(Constants.PAGINA_RICERCA_APE);

				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__OK);

			} else {
				theModel.setAppDatacodAceSelezionato(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");

				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaReport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaApe definito in un ExecCommand del
	 * ContentPanel cpRisultatoAce
	 */
	public ExecResults annullaApe(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2107110518) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)
					&& GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDataaceList())) {

				boolean isAttestatoOld = getAceMgr().isAttestatoOld(codiceCertificato);

				Ace ace = getAceMgr().findAce(codiceCertificato, isAttestatoOld);

				if (log.isDebugEnabled())
					GenericUtil.stampa(ace, true, 4);

				if (ace.getIdStato() == Constants.INVIATO) {

					theModel.setAppDatapaginaProvenienza(Constants.PAGINA_RICERCA_APE);

					result.setResultCode(ANNULLAAPE_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Il certificato non e' in stato inviato.");
					result.setResultCode(ANNULLAAPE_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDatacodAceSelezionato(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");

				result.setResultCode(ANNULLAAPE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaApe] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaAperturaDocAggiuntiva definito in un ExecCommand del
	 * ContentPanel cpRisultatoAce
	 */
	public ExecResults preparaAperturaDocAggiuntiva(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-33084395) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)
					&& GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDataaceList())) {
				boolean isAttestatoOld = getAceMgr().isAttestatoOld(codiceCertificato);

				Ace ace = getAceMgr().findAce(codiceCertificato, isAttestatoOld);
				ArrayList<DocumentoAggiuntivo> documenti = getAceMgr().findDocumentiAggiuntiviByAce(
						ace.getIdCertificatore(), ace.getProgrCertificato(), ace.getAnno());
				if (log.isDebugEnabled())
					GenericUtil.stampa(ace, true, 4);
				theModel.setAppDatalistDocumentazioneAggiuntiva(documenti);
				result.setResultCode(PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__OK);
			} else {
				theModel.setAppDatacodAceSelezionato(null);
				theModel.setAppDatalistDocumentazioneAggiuntiva(null);
				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
				result.setResultCode(PREPARAAPERTURADOCAGGIUNTIVA_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaAperturaDocAggiuntiva] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo invaEmailZipXmlApe definito in un ExecCommand del
	 * ContentPanel cpRisultatoAce
	 */
	public ExecResults invaEmailZipXmlApe(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INVAEMAILZIPXMLAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INVAEMAILZIPXMLAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-406457333) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String emailstr = theModel.getAppDataemailInvioApe();
			byte[] certificatomerge = new byte[0];
			List<File> certificati = new ArrayList<>();
			if (emailstr != null && this.validateEmail(emailstr)) {
				List<Ace> aceList = theModel.getAppDataaceList();
				//recupero certificati per ace
				for (Ace ace : aceList) {
					byte[] certificato = getCertificatoMgr().recuperaTracciatoImportXml(ace.getIdCertificatore(),
							ace.getProgrCertificato(), ace.getAnno());
					if (certificato != null) {
						//controllo dimensione file recuperati
						int certificatoSum = (certificato.length + certificatomerge.length);
						long fileSizeInMB = certificatoSum / (1024 * 1024);
						if (fileSizeInMB < 50) {
							certificatomerge = ArrayUtils.addAll(certificatomerge, certificato);
							File temp = new File(ace.getAnno() + "_" + ace.getNumCertificatore() + "_"
									+ ace.getProgrCertificato() + ".xml");
							temp.deleteOnExit();
							FileUtils.writeByteArrayToFile(temp, certificato);
							certificati.add(temp);
						} else {
							File zipFile = this.createZipFile(certificati);
							certificati.clear();
							File temp = new File(ace.getAnno() + "_" + ace.getNumCertificatore() + "_"
									+ ace.getProgrCertificato() + ".xml");
							temp.deleteOnExit();
							certificati.add(temp);
							certificatomerge = certificato;
							//invio mail con zip
							this.sendMail(zipFile, emailstr);
						}
					}
				}
				if (!certificati.isEmpty()) {
					File zipFile = this.createZipFile(certificati);
					//invio mail con zip
					this.sendMail(zipFile, emailstr);
				} else {
					result.getGlobalErrors().add("Nessun certificato APE trovato");
					result.setResultCode(INVAEMAILZIPXMLAPE_OUTCOME_CODE__KO);
				}
				result.setResultCode(INVAEMAILZIPXMLAPE_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Inserire un indirizzo email valido");
				result.setResultCode(INVAEMAILZIPXMLAPE_OUTCOME_CODE__KO);
			}
			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::invaEmailZipXmlApe] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initListaAttestati definito in un ExecCommand del
	 * ContentPanel cpRisultatoAce
	 */
	public ExecResults initListaAttestati(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITLISTAATTESTATI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1795659871) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatamsgGenerico() != null) {
				result.getGlobalMessages().add(theModel.getAppDatamsgGenerico());
				theModel.setAppDatamsgGenerico(null);
			}

			// impostazione del result code 
			result.setResultCode(INITLISTAATTESTATI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initListaAttestati] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblRisultatoAce
	 */
	public static void resetClearStatus_widg_tblRisultatoAce(java.util.Map session) {
		session.put("cpRisultatoAce_tblRisultatoAce_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R359630840) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private AceMgr aceMgr;

	private MiscMgr miscMgr;

	public AceMgr getAceMgr() {
		return aceMgr;
	}

	public void setAceMgr(AceMgr aceMgr) {
		this.aceMgr = aceMgr;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	public static boolean isCertificatoPresente(String idCertificato, ArrayList<Ace> attestatoList) {
		boolean isPresente = false;

		if (idCertificato != null && idCertificato != null) {
			for (Ace ace : attestatoList) {

				if (idCertificato.equals(ace.getCodice())) {
					isPresente = true;
				}
			}
		}

		return isPresente;
	}

	private File createZipFile(List<File> files) throws IOException {
		File zipFile = File.createTempFile("ace-zip", ".zip");
		try (FileOutputStream bos = new FileOutputStream(zipFile);
				ZipArchiveOutputStream zos = new ZipArchiveOutputStream(bos)) {
			for (File singleFile : files) {
				ZipArchiveEntry entry = new ZipArchiveEntry(singleFile.getName());
				FileInputStream in = new FileInputStream(singleFile);
				entry.setSize(singleFile.length());
				zos.putArchiveEntry(entry);
				IOUtils.copy(in, zos);
				zos.closeArchiveEntry();
			}
			zos.flush();
		}
		return zipFile;
	}

	private void sendMail(File file, String emailStr) throws MessagingException {
		java.util.Properties props = new java.util.Properties();

//		props.put("mail.smtp.host", getMiscMgr().getParametro(Constants.MAIL_HOST));
//		props.put("mail.smtp.port", getMiscMgr().getParametro(Constants.MAIL_PORT));
//		
//		Session session = Session.getDefaultInstance(props);

		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.host", getMiscMgr().getParametro(Constants.MAIL_HOST));
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", getMiscMgr().getParametro(Constants.MAIL_PORT));
		props.put("mail.smtp.starttls.enable", "true");

		//create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(getMiscMgr().getParametro(Constants.MAIL_USER), getMiscMgr().getParametro(Constants.MAIL_PWD));
			}
		};
		
		Session session=Session.getInstance(props,auth);
		
		
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(getMiscMgr().getParametro(Constants.MAIL_MITT_NOTIFICA)));

		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailStr));

		msg.setSubject("DOWNLOAD MASSIVO APE");
		MimeMultipart mp = new MimeMultipart();
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		FileDataSource source = new FileDataSource(file);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName("ape-zip.zip");
		mp.addBodyPart(messageBodyPart);
		msg.setContent(mp);
		Transport.send(msg);
	}

	private boolean validateEmail(String email) {
		Pattern p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(email);
		return m.find();
	}

	/*PROTECTED REGION END*/
}
