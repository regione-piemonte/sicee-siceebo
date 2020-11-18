package it.csi.sicee.siceebo.business.stampaace;

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

/*PROTECTED REGION ID(R657499795) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.AceMgr;
/*PROTECTED REGION END*/

public class CPBECpStampaAce {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [ricercaAce, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACE_CODE = "appDataricercaAce";

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [aceList, scope:USER_SESSION]
	public static final String APPDATA_ACELIST_CODE = "appDataaceList";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpStampaAce";

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
	 * ContentPanel cpStampaAce
	 */
	public ExecResults ricercaACEbyCodice(

			it.csi.sicee.siceebo.dto.stampaace.CpStampaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACEBYCODICE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACEBYCODICE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1993838318) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			FiltroRicercaAce filtro = theModel.getAppDataricercaAce();

			if (filtro != null) {
				if (checkFiltroAce(filtro, result)) {

					// prende tutti gli Ace
					ArrayList<Ace> aceList = getAceMgr().findAceByCodiceAllStatus(filtro);

					if (aceList != null && aceList.size() > 0) {

						theModel.setAppDataaceList(aceList);

						// impostazione del result code
						result.setResultCode(RICERCAACEBYCODICE_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Nessun A.P.E. trovato");

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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R834309947) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private AceMgr aceMgr;

	public AceMgr getAceMgr() {
		return aceMgr;
	}

	public void setAceMgr(AceMgr aceMgr) {
		this.aceMgr = aceMgr;
	}

	private boolean checkFiltroAce(FiltroRicercaAce filtro, ExecResults result) {
		int errors = 0;
		if (!checkValideFourNumber(filtro.getAnnoCertificato())) {
			errors++;
		}
		if (!checkValideSixNumber(filtro.getCertificatore())) {
			errors++;
		}
		if (!checkValideFourNumber(filtro.getProgCertificato())) {
			errors++;
		}

		if (errors > 0) {
			result.getGlobalErrors().add("Tutti i campi sono obbligatori e numerici.");
			return false;
		}

		return true;
	}

	public boolean checkValideFourNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]{4}"))
				return true;
			else
				return false;
		}

		return false;
	}

	public boolean checkValideSixNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]{6}"))
				return true;
			else
				return false;
		}

		return false;
	}

	private ArrayList<String> pulisciArray(ArrayList<String> list) {
		if (list != null) {
			for (int i = 0; i < list.size(); i++) {

				if (list.get(i) == null || list.get(i).equals("")) {
					list.remove(i);
					break;
				}
			}
		}

		return list;
	}

	private boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}
	/*PROTECTED REGION END*/
}
