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

/*PROTECTED REGION ID(R1830748895) ENABLED START*/
import it.csi.sicee.siceebo.business.dao.dto.SiceeTDocAggiuntiva;
import it.csi.sicee.siceebo.business.facade.AceMgr;
/*PROTECTED REGION END*/

public class CPBECpDocAggiuntiva {

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

	// ApplicationData: [documentoAggiuntivo, scope:USER_SESSION]
	public static final String APPDATA_DOCUMENTOAGGIUNTIVO_CODE = "appDatadocumentoAggiuntivo";

	// ApplicationData: [idDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTOSELEZIONATO_CODE = "appDataidDocumentoSelezionato";

	// ApplicationData: [listDocumentazioneAggiuntiva, scope:USER_SESSION]
	public static final String APPDATA_LISTDOCUMENTAZIONEAGGIUNTIVA_CODE = "appDatalistDocumentazioneAggiuntiva";

	// ApplicationData: [uidDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_UIDDOCUMENTOSELEZIONATO_CODE = "appDatauidDocumentoSelezionato";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDocAggiuntiva";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaDownloadDocumento definito in un ExecCommand del
	 * ContentPanel cpDocAggiuntiva
	 */
	public ExecResults preparaDownloadDocumento(

			it.csi.sicee.siceebo.dto.ricercaace.CpDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1981880147) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Integer idDoc = theModel.getAppDataidDocumentoSelezionato();

			if (!GenericUtil.isNullOrEmpty(idDoc)) {
				SiceeTDocAggiuntiva docAggiuntiva = getAceMgr().getSiceeTDocAggiuntiva().findByPrimaryKey(idDoc);

				String uid = docAggiuntiva.getUidIndex();
				if (uid != null) {
					theModel.setAppDatauidDocumentoSelezionato(uid);
					result.setResultCode(PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Documento non presente sul sistema.");
					result.setResultCode(PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDataidDocumentoSelezionato(null);
				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
				result.setResultCode(PREPARADOWNLOADDOCUMENTO_OUTCOME_CODE__KO);
			}
			// impostazione del result code

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaDownloadDocumento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initListaDocumentazione definito in un ExecCommand del
	 * ContentPanel cpDocAggiuntiva
	 */
	public ExecResults initListaDocumentazione(

			it.csi.sicee.siceebo.dto.ricercaace.CpDocAggiuntivaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITLISTADOCUMENTAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INITLISTADOCUMENTAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1168717560) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDatamsgGenerico() != null) {
				result.getGlobalMessages().add(theModel.getAppDatamsgGenerico());
				theModel.setAppDatamsgGenerico(null);
			}

			if (!GenericUtil.isNullOrEmpty(theModel.getAppDatalistDocumentazioneAggiuntiva()))
				result.setResultCode(INITLISTADOCUMENTAZIONE_OUTCOME_CODE__OK);
			else
				result.setResultCode(INITLISTADOCUMENTAZIONE_OUTCOME_CODE__KO);
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initListaDocumentazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDocAggiuntiva
	 */
	public static void resetClearStatus_widg_tblDocAggiuntiva(java.util.Map session) {
		session.put("cpDocAggiuntiva_tblDocAggiuntiva_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-784609041) ENABLED START*/
	private AceMgr aceMgr;

	public AceMgr getAceMgr() {
		return aceMgr;
	}

	public void setAceMgr(AceMgr aceMgr) {
		this.aceMgr = aceMgr;
	}
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
