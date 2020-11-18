package it.csi.sicee.siceebo.business.backoffice;

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

/*PROTECTED REGION ID(R-860998711) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.BackOfficeMgr;

/*PROTECTED REGION END*/

public class CPBECpVerificheIndex {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [resocontoTransMdp, scope:USER_SESSION]
	public static final String APPDATA_RESOCONTOTRANSMDP_CODE = "appDataresocontoTransMdp";

	// ApplicationData: [dettaglioTransAttEsito, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOTRANSATTESITO_CODE = "appDatadettaglioTransAttEsito";

	// ApplicationData: [idTransazioniSel, scope:USER_SESSION]
	public static final String APPDATA_IDTRANSAZIONISEL_CODE = "appDataidTransazioniSel";

	// ApplicationData: [ricercaAce, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACE_CODE = "appDataricercaAce";

	// ApplicationData: [verificaIndex, scope:USER_SESSION]
	public static final String APPDATA_VERIFICAINDEX_CODE = "appDataverificaIndex";

	// ApplicationData: [idVerificaSel, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASEL_CODE = "appDataidVerificaSel";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpVerificheIndex";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaACEbyCodice definito in un ExecCommand del
	 * ContentPanel cpVerificheIndex
	 */
	public ExecResults ricercaACEbyCodice(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheIndexModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACEBYCODICE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACEBYCODICE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1113835876) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			FiltroRicercaAce filtro = theModel.getAppDataricercaAce();
			//UserInfo user = theModel.getAppDatacurrentUser();

			if (filtro != null) {
				if (checkFiltroAce(filtro, result)) {
					// prende solo gli Ace con stato Inviato
					ArrayList<VerificaIndex> docList = getBackOfficeMgr().findDettaglioIndex(filtro);

					if (docList != null && docList.size() > 0) {
						theModel.setAppDataverificaIndex(docList);

						// impostazione del result code
						result.setResultCode(RICERCAACEBYCODICE_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Nessun riferimento index su DB");
						result.setResultCode(RICERCAACEBYCODICE_OUTCOME_CODE__KO);
					}
				} else {
					// impostazione del result code
					result.setResultCode(RICERCAACEBYCODICE_OUTCOME_CODE__KO);
				}
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaACEbyCodice] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recuperaFile definito in un ExecCommand del
	 * ContentPanel cpVerificheIndex
	 */
	public ExecResults recuperaFile(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheIndexModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECUPERAFILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RECUPERAFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-621955443) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idVerificaSelez = theModel.getAppDataidVerificaSel();
			result.setResultCode(RECUPERAFILE_OUTCOME_CODE__OK);

			ArrayList<VerificaIndex> verificheList = theModel.getAppDataverificaIndex();

			// Recupero la verifica
			VerificaIndex verificaIndex = getVerificaIndexById(idVerificaSelez, verificheList);

			if (idVerificaSelez != null && verificaIndex != null) {

				if (verificaIndex.getEsito() != null && !verificaIndex.getEsito()) {
					// E' un documento NON presente su Index, quindi lo recupero

					String uidRestore = getBackOfficeMgr().restoreFile(idVerificaSelez);

					if (uidRestore != null) {
						result.getGlobalMessages().add("Il file e' stato recuperato correttamente");

						ArrayList<VerificaIndex> docList = getBackOfficeMgr()
								.findDettaglioIndex(theModel.getAppDataricercaAce());

						theModel.setAppDataverificaIndex(docList);

						result.setResultCode(RECUPERAFILE_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Non e' stato possibile recuperare il file");
					}

				} else {
					result.getGlobalErrors().add("Il file e' gia' presente su INDEX");

				}

			} else {

				theModel.setAppDataidVerificaSel(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recuperaFile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaFile definito in un ExecCommand del
	 * ContentPanel cpVerificheIndex
	 */
	public ExecResults visualizzaFile(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheIndexModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZAFILE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZAFILE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1553622238) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idVerificaSelez = theModel.getAppDataidVerificaSel();
			result.setResultCode(VISUALIZZAFILE_OUTCOME_CODE__KO);

			ArrayList<VerificaIndex> verificheList = theModel.getAppDataverificaIndex();

			// Recupero la verifica
			VerificaIndex verificaIndex = getVerificaIndexById(idVerificaSelez, verificheList);

			if (idVerificaSelez != null && verificaIndex != null) {

				if (verificaIndex.getEsito() != null && verificaIndex.getEsito()) {

					theModel.getSession().put(Constants.SESSIONE_VAR_UID_INDEX, idVerificaSelez);

					// E' un documento presente su Index, quindi lo posso scaricare
					result.setResultCode(VISUALIZZAFILE_OUTCOME_CODE__OK);

				} else {
					result.getGlobalErrors().add("Il documento non e' presente su INDEX");

				}

			} else {
				theModel.setAppDataidVerificaSel(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaFile] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inizializzaVerificheIndex definito in un ExecCommand del
	 * ContentPanel cpVerificheIndex
	 */
	public ExecResults inizializzaVerificheIndex(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheIndexModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAVERIFICHEINDEX_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-844894347) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(INIZIALIZZAVERIFICHEINDEX_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaVerificheIndex] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblVerificaIndex
	 */
	public static void resetClearStatus_widg_tblVerificaIndex(java.util.Map session) {
		session.put("cpVerificheIndex_tblVerificaIndex_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1645687861) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private BackOfficeMgr backOfficeMgr;

	public BackOfficeMgr getBackOfficeMgr() {
		return backOfficeMgr;
	}
	public void setBackOfficeMgr(BackOfficeMgr backOfficeMgr) {
		this.backOfficeMgr = backOfficeMgr;
	}

	private boolean checkFiltroAce(FiltroRicercaAce filtro, ExecResults result) {
		int errors = 0;
		if (!GenericUtil.checkValideFourNumber(filtro.getAnnoCertificato())) {
			errors++;
		}
		if (!GenericUtil.checkValideSixNumber(filtro.getCertificatore())) {
			errors++;
		}
		if (!GenericUtil.checkValideFourNumber(filtro.getProgCertificato())) {
			errors++;
		}

		if (errors > 0) {
			result.getGlobalErrors().add("Tutti i campi sono obbligatori e numerici.");
			return false;
		}

		return true;
	}

	private VerificaIndex getVerificaIndexById(String idVerifica, ArrayList<VerificaIndex> verificheList) {
		for (VerificaIndex verificaIndex : verificheList) {
			if (verificaIndex.getUidIndex().equalsIgnoreCase(idVerifica)) {
				return verificaIndex;
			}
		}

		return null;
	}

	/*PROTECTED REGION END*/
}
