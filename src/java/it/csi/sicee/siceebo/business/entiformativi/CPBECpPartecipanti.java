package it.csi.sicee.siceebo.business.entiformativi;

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

/*PROTECTED REGION ID(R-1769254198) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.business.facade.MiscMgr;
/*PROTECTED REGION END*/

public class CPBECpPartecipanti {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [regione, scope:USER_SESSION]
	public static final String APPDATA_REGIONE_CODE = "appDataregione";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [corsi, scope:USER_SESSION]
	public static final String APPDATA_CORSI_CODE = "appDatacorsi";

	// ApplicationData: [idCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCORSOSELEZIONATO_CODE = "appDataidCorsoSelezionato";

	// ApplicationData: [modalitaDettaglioCorso, scope:USER_SESSION]
	public static final String APPDATA_MODALITADETTAGLIOCORSO_CODE = "appDatamodalitaDettaglioCorso";

	// ApplicationData: [idPartecipanteSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDPARTECIPANTESELEZIONATO_CODE = "appDataidPartecipanteSelezionato";

	// ApplicationData: [partecipanti, scope:USER_SESSION]
	public static final String APPDATA_PARTECIPANTI_CODE = "appDatapartecipanti";

	// ApplicationData: [modalitaDettaglioPartecipante, scope:USER_SESSION]
	public static final String APPDATA_MODALITADETTAGLIOPARTECIPANTE_CODE = "appDatamodalitaDettaglioPartecipante";

	// ApplicationData: [dettaglioCorso, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOCORSO_CODE = "appDatadettaglioCorso";

	// ApplicationData: [tipoRuoloUtente, scope:USER_SESSION]
	public static final String APPDATA_TIPORUOLOUTENTE_CODE = "appDatatipoRuoloUtente";

	// ApplicationData: [enteFormativo, scope:USER_SESSION]
	public static final String APPDATA_ENTEFORMATIVO_CODE = "appDataenteFormativo";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpPartecipanti";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo confermaEliminaPartecipante definito in un ExecCommand del
	 * ContentPanel cpPartecipanti
	 */
	public ExecResults confermaEliminaPartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONFERMAELIMINAPARTECIPANTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONFERMAELIMINAPARTECIPANTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R546657477) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDataidPartecipanteSelezionato() != null) {
				result.setResultCode(CONFERMAELIMINAPARTECIPANTE_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Occorre selezionare un partecipante");
				result.setResultCode(CONFERMAELIMINAPARTECIPANTE_OUTCOME_CODE__KO);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::confermaEliminaPartecipante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo updatePartecipante definito in un ExecCommand del
	 * ContentPanel cpPartecipanti
	 */
	public ExecResults updatePartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPDATEPARTECIPANTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String UPDATEPARTECIPANTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1552826030) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDataidPartecipanteSelezionato() != null) {
				theModel.setAppDatamodalitaDettaglioPartecipante("UPDATE");
				result.setResultCode(UPDATEPARTECIPANTE_OUTCOME_CODE__OK);
			} else {
				result.getGlobalErrors().add("Occorre selezionare un partecipante");
				result.setResultCode(UPDATEPARTECIPANTE_OUTCOME_CODE__KO);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::updatePartecipante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciNuovoPartecipante definito in un ExecCommand del
	 * ContentPanel cpPartecipanti
	 */
	public ExecResults inserisciNuovoPartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCINUOVOPARTECIPANTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1975269275) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDatamodalitaDettaglioPartecipante("INSERT");
			// impostazione del result code 
			result.setResultCode(INSERISCINUOVOPARTECIPANTE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciNuovoPartecipante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaPartecipante definito in un ExecCommand del
	 * ContentPanel cpPartecipanti
	 */
	public ExecResults eliminaPartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINAPARTECIPANTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1168237952) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			getMiscMgr().eliminaPartecipante(theModel.getAppDataidPartecipanteSelezionato());
			ArrayList<Partecipante> partecipanti = null;
			partecipanti = recuperaPartecipanti(theModel.getAppDataidCorsoSelezionato());
			theModel.setAppDatapartecipanti(partecipanti);

			// impostazione del result code 
			result.setResultCode(ELIMINAPARTECIPANTE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaPartecipante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadPartecipanti definito in un ExecCommand del
	 * ContentPanel cpPartecipanti
	 */
	public ExecResults loadPartecipanti(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADPARTECIPANTI_OUTCOME_CODE__OK_RW = //NOSONAR  Reason:EIAS
				"OK_RW"; //NOSONAR  Reason:EIAS
		final String LOADPARTECIPANTI_OUTCOME_CODE__OK_R = //NOSONAR  Reason:EIAS
				"OK_R"; //NOSONAR  Reason:EIAS
		final String LOADPARTECIPANTI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R952638097) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n ON ENTER :: loadPartecipanti :: inizio");
			// carico dettaglio corso
			Corso corso = null;
			corso = recuperaCorso(theModel.getAppDataidCorsoSelezionato());
			theModel.setAppDatadettaglioCorso(corso);

			// se nel dettaglio corso è stato valorizzato un valore del luogo corso diverso da quello di default
			if (!MiscMgr.isNullOrEmpty(corso.getLuogoCorso())) {
				theModel.getAppDataenteFormativo().setSedeCompleta(corso.getLuogoCorso());
			}
			// carico lista partecipanti
			ArrayList<Partecipante> partecipanti = null;
			partecipanti = recuperaPartecipanti(theModel.getAppDataidCorsoSelezionato());
			theModel.setAppDatapartecipanti(partecipanti);
			if (partecipanti != null) {
				theModel.getAppDatadettaglioCorso().setPartecipanti("<b>" + partecipanti.size() + "</b>");
			} else {
				theModel.getAppDatadettaglioCorso().setPartecipanti("<b>0</b>");
			}
			if (theModel.getAppDatatipoRuoloUtente().equalsIgnoreCase(Constants.RUOLO_RW))
				result.setResultCode(LOADPARTECIPANTI_OUTCOME_CODE__OK_RW);
			else
				result.setResultCode(LOADPARTECIPANTI_OUTCOME_CODE__OK_R);
			log.debug("\n\n\n ON ENTER :: loadPartecipanti :: fine");

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadPartecipanti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoPartecipanti
	 */
	public static void resetClearStatus_widg_tblElencoPartecipanti(java.util.Map session) {
		session.put("cpPartecipanti_tblElencoPartecipanti_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-158311958) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private SOAIntegrationMgr soaIntegrationMgr;
	private MiscMgr miscMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}
	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}
	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private Corso recuperaCorso(Long idCorso) throws BEException {
		Corso corso = null;
		corso = getMiscMgr().getCorsoByidCorso(idCorso);
		return corso;
	}

	private ArrayList<Partecipante> recuperaPartecipanti(Long idCorso) throws BEException {
		ArrayList<Partecipante> partecipanti = null;
		partecipanti = getMiscMgr().getPartecipantiByidCorso(idCorso);
		return partecipanti;
	}

	/*PROTECTED REGION END*/
}
