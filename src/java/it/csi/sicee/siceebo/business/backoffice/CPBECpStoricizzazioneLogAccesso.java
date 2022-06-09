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

/*PROTECTED REGION ID(R-976231696) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.BackOfficeMgr;
import it.csi.sicee.siceebo.business.facade.ConnectorMgr;

/*PROTECTED REGION END*/

public class CPBECpStoricizzazioneLogAccesso {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [riepilogoStoricizzazione, scope:USER_ACTION]
	public static final String APPDATA_RIEPILOGOSTORICIZZAZIONE_CODE = "appDatariepilogoStoricizzazione";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpStoricizzazioneLogAccesso";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestStoricizzaLogAccesso definito in un ExecCommand del
	 * ContentPanel cpStoricizzazioneLogAccesso
	 */
	public ExecResults gestStoricizzaLogAccesso(

			it.csi.sicee.siceebo.dto.backoffice.CpStoricizzazioneLogAccessoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTSTORICIZZALOGACCESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String GESTSTORICIZZALOGACCESSO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1940440977) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				getConnectorMgr().storicizzaLogAccesso();

				theModel.setAppDatariepilogoStoricizzazione(getBackOfficeMgr().getRiepilogoStoricizzazione());

				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);

				// impostazione del result code 
				result.setResultCode(GESTSTORICIZZALOGACCESSO_OUTCOME_CODE__OK);
			} catch (BEException e) {
				result.getGlobalErrors().add(e.getMessage());
				result.setResultCode(GESTSTORICIZZALOGACCESSO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestStoricizzaLogAccesso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inizializzaCountRecordStoricizzazione definito in un ExecCommand del
	 * ContentPanel cpStoricizzazioneLogAccesso
	 */
	public ExecResults inizializzaCountRecordStoricizzazione(

			it.csi.sicee.siceebo.dto.backoffice.CpStoricizzazioneLogAccessoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZACOUNTRECORDSTORICIZZAZIONE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INIZIALIZZACOUNTRECORDSTORICIZZAZIONE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2141224278) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {
				theModel.setAppDatariepilogoStoricizzazione(getBackOfficeMgr().getRiepilogoStoricizzazione());

				// impostazione del result code 
				result.setResultCode(INIZIALIZZACOUNTRECORDSTORICIZZAZIONE_OUTCOME_CODE__OK);

			} catch (BEException e) {
				result.getGlobalErrors().add(e.getMessage());
				result.setResultCode(INIZIALIZZACOUNTRECORDSTORICIZZAZIONE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::inizializzaCountRecordStoricizzazione] Errore occorso nell'esecuzione del metodo:"
							+ e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R817487806) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private BackOfficeMgr backOfficeMgr;

	public BackOfficeMgr getBackOfficeMgr() {
		return backOfficeMgr;
	}
	public void setBackOfficeMgr(BackOfficeMgr backOfficeMgr) {
		this.backOfficeMgr = backOfficeMgr;
	}

	private ConnectorMgr connectorMgr;

	public ConnectorMgr getConnectorMgr() {
		return connectorMgr;
	}
	public void setConnectorMgr(ConnectorMgr connectorMgr) {
		this.connectorMgr = connectorMgr;
	}

	/*PROTECTED REGION END*/
}
