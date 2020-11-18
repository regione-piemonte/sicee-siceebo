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
import it.csi.sicee.siceebo.business.facade.AceMgr;
import it.csi.sicee.siceebo.business.facade.CertificatoMgr;
import it.csi.sicee.siceebo.business.facade.CertificatoreMgr;
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;

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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoAce";

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

				if (ace.getIdStato() == Constants.ANNULLATO || ace.getIdStato() == Constants.ANNULLATO_BO) {
					ArrayList<Ace> aceListSostitutivi = getSoaIntegrationMgr().findAceSostitutivi(ace);
					theModel.setAppDataaceSostituzioneList(aceListSostitutivi);

					result.setResultCode(RECUPERASOSTITUTI_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Il certificato non e' in stato annullato.");
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

	public AceMgr getAceMgr() {
		return aceMgr;
	}

	public void setAceMgr(AceMgr aceMgr) {
		this.aceMgr = aceMgr;
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

	/*PROTECTED REGION END*/
}
