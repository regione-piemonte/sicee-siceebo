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

/*PROTECTED REGION ID(R1735248636) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.MiscMgr;
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;

/*PROTECTED REGION END*/

public class CPBECpCorsi {

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

	// ApplicationData: [elencoSediOperative, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEDIOPERATIVE_CODE = "appDataelencoSediOperative";

	// ApplicationData: [idSedeOperativaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSEDEOPERATIVASELEZIONATA_CODE = "appDataidSedeOperativaSelezionata";

	// ApplicationData: [enteFormativo, scope:USER_SESSION]
	public static final String APPDATA_ENTEFORMATIVO_CODE = "appDataenteFormativo";

	// ApplicationData: [corsi, scope:USER_SESSION]
	public static final String APPDATA_CORSI_CODE = "appDatacorsi";

	// ApplicationData: [idCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCORSOSELEZIONATO_CODE = "appDataidCorsoSelezionato";

	// ApplicationData: [modalitaDettaglioCorso, scope:USER_SESSION]
	public static final String APPDATA_MODALITADETTAGLIOCORSO_CODE = "appDatamodalitaDettaglioCorso";

	// ApplicationData: [tipoRuoloUtente, scope:USER_SESSION]
	public static final String APPDATA_TIPORUOLOUTENTE_CODE = "appDatatipoRuoloUtente";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpCorsi";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cambiaSedeOperativa definito in un ExecCommand del
	 * ContentPanel cpCorsi
	 */
	public ExecResults cambiaSedeOperativa(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CAMBIASEDEOPERATIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1166872188) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("\n\n\n WHEN COMBOBOX VALUE CHANGED :: cambiaSedeOperativa :: inizio");
			String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
			EnteCf enteCf = null;
			EnteFormativo enteFormativo = null;
			enteCf = recuperaIdEnteFormativo(codiceFiscale);
			ArrayList<Corso> corsi = null;
			Long idSedeOperativaSelezionata = null;

			if (!MiscMgr.isNullOrEmpty(theModel.getAppDataidSedeOperativaSelezionata())) {
				idSedeOperativaSelezionata = theModel.getAppDataidSedeOperativaSelezionata();
			} else {
				// nel caso in cui un picio selezioni null dalla lista sedi operative torno alla sede operativa di default
				idSedeOperativaSelezionata = enteCf.getIdEnte();
			}
			enteFormativo = recuperaEnteFormativo(idSedeOperativaSelezionata);
			theModel.setAppDataenteFormativo(enteFormativo);
			theModel.setAppDataidSedeOperativaSelezionata(idSedeOperativaSelezionata);
			corsi = recuperaCorsi(theModel.getAppDataidSedeOperativaSelezionata());
			theModel.setAppDatacorsi(corsi);

			// il ruolo è già stato determinato all'inizio e resta quello per tutte le sedi operative

			// impostazione del result code 
			result.setResultCode(CAMBIASEDEOPERATIVA_OUTCOME_CODE__OK);
			log.debug("\n\n\n WHEN COMBOBOX VALUE CHANGED :: cambiaSedeOperativa :: fine");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cambiaSedeOperativa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaDettaglioCorso definito in un ExecCommand del
	 * ContentPanel cpCorsi
	 */
	public ExecResults preparaDettaglioCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARADETTAGLIOCORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-494632193) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(PREPARADETTAGLIOCORSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaDettaglioCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo confermaEliminaCorso definito in un ExecCommand del
	 * ContentPanel cpCorsi
	 */
	public ExecResults confermaEliminaCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONFERMAELIMINACORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONFERMAELIMINACORSO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R676514505) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataidCorsoSelezionato() != null
					&& isCorsoPresente(theModel.getAppDataidCorsoSelezionato(), theModel.getAppDatacorsi())) {
				result.setResultCode(CONFERMAELIMINACORSO_OUTCOME_CODE__OK);
			} else {
				theModel.setAppDataidCorsoSelezionato(null);

				result.getGlobalErrors().add("Occorre selezionare un corso");
				result.setResultCode(CONFERMAELIMINACORSO_OUTCOME_CODE__KO);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::confermaEliminaCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo updateCorso definito in un ExecCommand del
	 * ContentPanel cpCorsi
	 */
	public ExecResults updateCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String UPDATECORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String UPDATECORSO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1674007040) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDataidCorsoSelezionato() != null
					&& isCorsoPresente(theModel.getAppDataidCorsoSelezionato(), theModel.getAppDatacorsi())) {
				theModel.setAppDatamodalitaDettaglioCorso("UPDATE");
				result.setResultCode(UPDATECORSO_OUTCOME_CODE__OK);
			} else {
				theModel.setAppDataidCorsoSelezionato(null);

				result.getGlobalErrors().add("Occorre selezionare un corso");
				result.setResultCode(UPDATECORSO_OUTCOME_CODE__KO);
			}
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::updateCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo elencoPartecipanti definito in un ExecCommand del
	 * ContentPanel cpCorsi
	 */
	public ExecResults elencoPartecipanti(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELENCOPARTECIPANTI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ELENCOPARTECIPANTI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1478657801) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (theModel.getAppDataidCorsoSelezionato() != null
					&& isCorsoPresente(theModel.getAppDataidCorsoSelezionato(), theModel.getAppDatacorsi())) {
				result.setResultCode(ELENCOPARTECIPANTI_OUTCOME_CODE__OK);
			} else {
				theModel.setAppDataidCorsoSelezionato(null);

				result.getGlobalErrors().add("Occorre selezionare un corso");
				result.setResultCode(ELENCOPARTECIPANTI_OUTCOME_CODE__KO);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::elencoPartecipanti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inserisciNuovoCorso definito in un ExecCommand del
	 * ContentPanel cpCorsi
	 */
	public ExecResults inserisciNuovoCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INSERISCINUOVOCORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2102504371) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.setAppDatamodalitaDettaglioCorso("INSERT");
			// impostazione del result code 
			result.setResultCode(INSERISCINUOVOCORSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inserisciNuovoCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo eliminaCorso definito in un ExecCommand del
	 * ContentPanel cpCorsi
	 */
	public ExecResults eliminaCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ELIMINACORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-143941778) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			getMiscMgr().eliminaCorso(theModel.getAppDataidCorsoSelezionato());
			ArrayList<Corso> corsi = null;
			corsi = recuperaCorsi(theModel.getAppDataidSedeOperativaSelezionata());
			theModel.setAppDatacorsi(corsi);

			// impostazione del result code 
			result.setResultCode(ELIMINACORSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::eliminaCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadCorsi definito in un ExecCommand del
	 * ContentPanel cpCorsi
	 */
	public ExecResults loadCorsi(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADCORSI_OUTCOME_CODE__OK_RW = //NOSONAR  Reason:EIAS
				"OK_RW"; //NOSONAR  Reason:EIAS
		final String LOADCORSI_OUTCOME_CODE__OK_R = //NOSONAR  Reason:EIAS
				"OK_R"; //NOSONAR  Reason:EIAS
		final String LOADCORSI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-419549853) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n ON ENTER :: loadCorsi :: inizio");
			String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
			EnteCf enteCf = null;
			EnteFormativo enteFormativo = null;
			ArrayList<Decodifica> elencoSediOperative = null;
			Long idSedeOperativaSelezionata = null;
			ArrayList<Corso> corsi = null;
			enteCf = recuperaIdEnteFormativo(codiceFiscale);
			if (enteCf != null) {
				if (!MiscMgr.isNullOrEmpty(theModel.getAppDataidSedeOperativaSelezionata())) {
					idSedeOperativaSelezionata = theModel.getAppDataidSedeOperativaSelezionata();
				} else {
					idSedeOperativaSelezionata = enteCf.getIdEnte();
				}
				enteFormativo = recuperaEnteFormativo(idSedeOperativaSelezionata);
				theModel.setAppDataenteFormativo(enteFormativo);
				theModel.setAppDataidSedeOperativaSelezionata(idSedeOperativaSelezionata);
				elencoSediOperative = recuperaElencoSediEnteFormativo(enteFormativo.getFkEnteSl());
				theModel.setAppDataelencoSediOperative(elencoSediOperative);
				corsi = recuperaCorsi(idSedeOperativaSelezionata);
				theModel.setAppDatacorsi(corsi);
				theModel.setAppDatatipoRuoloUtente(enteCf.getRuolo());
				if (theModel.getAppDatatipoRuoloUtente().equalsIgnoreCase(Constants.RUOLO_RW))
					result.setResultCode(LOADCORSI_OUTCOME_CODE__OK_RW);
				else
					result.setResultCode(LOADCORSI_OUTCOME_CODE__OK_R);
			} else {
				result.getGlobalErrors().add("Nessun ente formativo associato a questo certificato");
				result.setResultCode(LOADCORSI_OUTCOME_CODE__KO);

			}
			log.debug("\n\n\n ON ENTER :: loadCorsi :: fine");

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadCorsi] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblElencoCorsi
	 */
	public static void resetClearStatus_widg_tblElencoCorsi(java.util.Map session) {
		session.put("cpCorsi_tblElencoCorsi_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-676637518) ENABLED START*/
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

	private EnteCf recuperaIdEnteFormativo(String codiceFiscale) throws BEException {
		EnteCf enteCf = null;
		enteCf = getMiscMgr().getIdEntiByCF(codiceFiscale);
		return enteCf;
	}

	private EnteFormativo recuperaEnteFormativo(long idEnte) throws BEException {
		EnteFormativo enteFormativo = null;
		enteFormativo = getMiscMgr().getEnteByPk(idEnte);
		return enteFormativo;
	}

	private ArrayList<Decodifica> recuperaElencoSediEnteFormativo(long fkEnteSl) throws BEException {
		ArrayList<Decodifica> elencoSediOperativeEnte = null;
		elencoSediOperativeEnte = getMiscMgr().getElencoSediEnteByFkEnteSl(fkEnteSl);
		return elencoSediOperativeEnte;
	}
	/*
	 private ArrayList<Decodifica> recuperaElencoSediEnteFormativo(
	 String partitaIva) throws BEException {
	 ArrayList<Decodifica> elencoSediOperativeEnte = null;
	 elencoSediOperativeEnte = getMiscMgr().getElencoSediEnteByPiva(
	 partitaIva);
	 return elencoSediOperativeEnte;
	 }
	 */
	private ArrayList<Corso> recuperaCorsi(Long idEnte) throws BEException {
		ArrayList<Corso> corsi = null;
		corsi = getMiscMgr().getCorsiByidEnte(idEnte);
		return corsi;
	}

	public static boolean isCorsoPresente(Long idCorso, ArrayList<Corso> corsiList) {
		boolean isPresente = false;

		if (idCorso != null && idCorso != null) {
			for (Corso corso : corsiList) {

				if (idCorso.intValue() == corso.getIdCorso().intValue()) {
					isPresente = true;
				}
			}
		}

		return isPresente;
	}

	/*PROTECTED REGION END*/
}
