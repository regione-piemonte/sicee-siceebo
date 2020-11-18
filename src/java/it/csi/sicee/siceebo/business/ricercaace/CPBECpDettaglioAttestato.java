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

/*PROTECTED REGION ID(R-85924552) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;

/*PROTECTED REGION END*/

public class CPBECpDettaglioAttestato {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [labelValueArray, scope:USER_ACTION]
	public static final String APPDATA_LABELVALUEARRAY_CODE = "appDatalabelValueArray";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioAttestato";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRitorno definito in un ExecCommand del
	 * ContentPanel cpDettaglioAttestato
	 */
	public ExecResults gestisciRitorno(

			it.csi.sicee.siceebo.dto.ricercaace.CpDettaglioAttestatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRITORNO_OUTCOME_CODE__RIC_APE = //NOSONAR  Reason:EIAS
				"RIC_APE"; //NOSONAR  Reason:EIAS
		final String GESTISCIRITORNO_OUTCOME_CODE__RIC_APE_CERT = //NOSONAR  Reason:EIAS
				"RIC_APE_CERT"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-831019965) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String paginaChiamante = theModel.getAppDatapaginaProvenienza();
			if (paginaChiamante.equals(Constants.PAGINA_RICERCA_APE)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIRITORNO_OUTCOME_CODE__RIC_APE);
			} else if (paginaChiamante.equals(Constants.PAGINA_RICERCA_APE_CERTIFICATORE)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIRITORNO_OUTCOME_CODE__RIC_APE_CERT);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciRitorno] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDettaglioAttestato definito in un ExecCommand del
	 * ContentPanel cpDettaglioAttestato
	 */
	public ExecResults visualizzaDettaglioAttestato(

			it.csi.sicee.siceebo.dto.ricercaace.CpDettaglioAttestatoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADETTAGLIOATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-169960929) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			ArrayList<LabelValue> labelValueList = getSoaIntegrationMgr().getDettaglioAce(codiceCertificato);

			log.debug("STAMPO il labelValueList: " + labelValueList);
			log.debug("STAMPO il labelValueList.size(): " + labelValueList.size());

			theModel.setAppDatalabelValueArray(labelValueList);

			// impostazione del result code 
			result.setResultCode(VISUALIZZADETTAGLIOATTESTATO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaDettaglioAttestato] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tbDettaglioAttestato
	 */
	public static void resetClearStatus_widg_tbDettaglioAttestato(java.util.Map session) {
		session.put("cpDettaglioAttestato_tbDettaglioAttestato_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1371320708) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/*PROTECTED REGION END*/
}
