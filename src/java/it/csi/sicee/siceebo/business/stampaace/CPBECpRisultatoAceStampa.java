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

/*PROTECTED REGION ID(R409489438) ENABLED START*/

/*PROTECTED REGION END*/

public class CPBECpRisultatoAceStampa {

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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoAceStampa";

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
	 * ContentPanel cpRisultatoAceStampa
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceebo.dto.stampaace.CpRisultatoAceStampaModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO = //NOSONAR  Reason:EIAS
				"ATTESTATO"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__BOZZA = //NOSONAR  Reason:EIAS
				"BOZZA"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-130384138) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getIdRiga();

			if (GenericUtil.isNullOrEmpty(codiceCertificato)
					|| !GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDataaceList())) {

				result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__KO);

			} else {

				theModel.setAppDatacodAttestatoDaStampare(codiceCertificato);

				if (theModel.getIdColonna().equals("flgModulo")) {
					log.debug("getIdColonna: " + theModel.getIdColonna());
					result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO);
				} else if (theModel.getIdColonna().equals("flgModuloBozza")) {
					log.debug("getIdColonna: " + theModel.getIdColonna());
					result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__BOZZA);
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

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblRisultatoAce
	 */
	public static void resetClearStatus_widg_tblRisultatoAce(java.util.Map session) {
		session.put("cpRisultatoAceStampa_tblRisultatoAce_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-773674) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
