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

/*PROTECTED REGION ID(R-1183677622) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.BackOfficeMgr;

/*PROTECTED REGION END*/

public class CPBECpRecuperaCoordinateLOCCSI {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [countCertificatiSenzaCoordinate, scope:USER_SESSION]
	public static final String APPDATA_COUNTCERTIFICATISENZACOORDINATE_CODE = "appDatacountCertificatiSenzaCoordinate";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRecuperaCoordinateLOCCSI";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestRecuperoCoordinateLOCCSI definito in un ExecCommand del
	 * ContentPanel cpRecuperaCoordinateLOCCSI
	 */
	public ExecResults gestRecuperoCoordinateLOCCSI(

			it.csi.sicee.siceebo.dto.backoffice.CpRecuperaCoordinateLOCCSIModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTRECUPEROCOORDINATELOCCSI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R892790154) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				getBackOfficeMgr().aggiornaCoordinateCertificati();
				theModel.setAppDatacountCertificatiSenzaCoordinate(
						getBackOfficeMgr().getCountCertificatiSenzaCoordinate());
				result.getGlobalMessages().add(Messages.INFO_SALVATAGGIO_CORRETTO);
			} catch (BEException e) {
				result.getGlobalErrors().add(e.getMessage());
			}

			// impostazione del result code 
			result.setResultCode(GESTRECUPEROCOORDINATELOCCSI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestRecuperoCoordinateLOCCSI] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inizializzaCountCertificatiSenzaCoordinate definito in un ExecCommand del
	 * ContentPanel cpRecuperaCoordinateLOCCSI
	 */
	public ExecResults inizializzaCountCertificatiSenzaCoordinate(

			it.csi.sicee.siceebo.dto.backoffice.CpRecuperaCoordinateLOCCSIModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZACOUNTCERTIFICATISENZACOORDINATE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1119510696) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			try {
				theModel.setAppDatacountCertificatiSenzaCoordinate(
						getBackOfficeMgr().getCountCertificatiSenzaCoordinate());
			} catch (BEException e) {
				result.getGlobalErrors().add(e.getMessage());
			}
			// impostazione del result code 
			result.setResultCode(INIZIALIZZACOUNTCERTIFICATISENZACOORDINATE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::inizializzaCountCertificatiSenzaCoordinate] Errore occorso nell'esecuzione del metodo:"
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
	/*PROTECTED REGION ID(R579441898) ENABLED START*/
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
