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

/*PROTECTED REGION ID(R1426622418) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.BackOfficeMgr;

/*PROTECTED REGION END*/

public class CPBECpVerificheActa {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [verificaActa, scope:USER_SESSION]
	public static final String APPDATA_VERIFICAACTA_CODE = "appDataverificaActa";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpVerificheActa";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo risolviProtocollazione definito in un ExecCommand del
	 * ContentPanel cpVerificheActa
	 */
	public ExecResults risolviProtocollazione(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheActaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RISOLVIPROTOCOLLAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RISOLVIPROTOCOLLAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1924620085) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				if (getBackOfficeMgr().isRisanamentoProtPossibile()) {
					getBackOfficeMgr().risanaProtAnomali();
					result.getGlobalMessages().add("Risanamento avvenuto correttamente");

					// Ricarico nuovamente i protocolli anomali
					ArrayList<VerificaActa> protList = getBackOfficeMgr().findProtocollazioniAnomale();
					theModel.setAppDataverificaActa(protList);
				} else {
					result.getGlobalErrors().add("C'e' un processo attivo, in questo momento non si puo' procedere.");
				}
			} catch (Exception e) {
				result.getGlobalErrors().add("Si e' verificato un problema.");

			}

			// impostazione del result code 
			result.setResultCode(RISOLVIPROTOCOLLAZIONE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::risolviProtocollazione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inizializzaVerificheActa definito in un ExecCommand del
	 * ContentPanel cpVerificheActa
	 */
	public ExecResults inizializzaVerificheActa(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheActaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZAVERIFICHEACTA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R609271385) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			ArrayList<VerificaActa> protList = getBackOfficeMgr().findProtocollazioniAnomale();

			theModel.setAppDataverificaActa(protList);

			// impostazione del result code 
			result.setResultCode(INIZIALIZZAVERIFICHEACTA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaVerificheActa] Errore occorso nell'esecuzione del metodo:" + e, e);
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
		session.put("cpVerificheActa_tblVerificaIndex_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1323154660) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private BackOfficeMgr backOfficeMgr;

	public BackOfficeMgr getBackOfficeMgr() {
		return backOfficeMgr;
	}
	public void setBackOfficeMgr(BackOfficeMgr backOfficeMgr) {
		this.backOfficeMgr = backOfficeMgr;
	}

	/*PROTECTED REGION END*/
}
