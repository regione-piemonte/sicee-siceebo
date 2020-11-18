package it.csi.sicee.siceebo.business.ricercacertificatori;

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

/*PROTECTED REGION ID(R912201762) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.CertificatoreMgr;

/*PROTECTED REGION END*/

public class CPBECpRisultatoCertificatoriAdv {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [certificatoreList, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORELIST_CODE = "appDatacertificatoreList";

	// ApplicationData: [ricercaCertificatori, scope:USER_SESSION]
	public static final String APPDATA_RICERCACERTIFICATORI_CODE = "appDataricercaCertificatori";

	// ApplicationData: [idCertificatoreSel, scope:USER_SESSION]
	public static final String APPDATA_IDCERTIFICATORESEL_CODE = "appDataidCertificatoreSel";

	// ApplicationData: [elencoMotivazioniBlocco, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMOTIVAZIONIBLOCCO_CODE = "appDataelencoMotivazioniBlocco";

	// ApplicationData: [idMotivoBloccoSel, scope:USER_SESSION]
	public static final String APPDATA_IDMOTIVOBLOCCOSEL_CODE = "appDataidMotivoBloccoSel";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRisultatoCertificatoriAdv";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bloccaTuttiCertificatori definito in un ExecCommand del
	 * ContentPanel cpRisultatoCertificatoriAdv
	 */
	public ExecResults bloccaTuttiCertificatori(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRisultatoCertificatoriAdvModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BLOCCATUTTICERTIFICATORI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BLOCCATUTTICERTIFICATORI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2108456307) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String idBloccoCert = theModel.getAppDataidMotivoBloccoSel();

			log.debug("STAMPO L'ID MOTIVO BLOCCO: " + idBloccoCert);

			String descBloccoCert = null;
			if (GenericUtil.isNullOrEmpty(idBloccoCert)) {
				//log.debug("\n\n\n >>>>>>> BLOCCO CERT E' NULLO !!!!!");
				result.getGlobalErrors().add("Selezionare la motivazione del blocco");
				result.setResultCode(BLOCCATUTTICERTIFICATORI_OUTCOME_CODE__KO);
			} else {

				ArrayList<Decodifica> lisMot = theModel.getAppDataelencoMotivazioniBlocco();
				for (Decodifica decodifica : lisMot) {
					if (decodifica.getId().equals(idBloccoCert)) {
						descBloccoCert = decodifica.getDescr();
					}
				}

				ArrayList<Certificatore> certificatori = theModel.getAppDatacertificatoreList();

				for (int i = 0; i < certificatori.size(); i++) {

					Certificatore certificatore = certificatori.get(i);

					getCertificatoreMgr().bloccoSbloccoCert(certificatore.getId(), idBloccoCert, null,
							certificatore.getNome(), certificatore.getCognome(), certificatore.getEmail());

					certificatori.get(i).setDescBloccoCert(descBloccoCert);

				}

				result.getGlobalMessages().add("Certificatori bloccati correttamente");

				// impostazione del result code 
				result.setResultCode(BLOCCATUTTICERTIFICATORI_OUTCOME_CODE__OK);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bloccaTuttiCertificatori] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo visualizzaDettaglio definito in un ExecCommand del
	 * ContentPanel cpRisultatoCertificatoriAdv
	 */
	public ExecResults visualizzaDettaglio(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRisultatoCertificatoriAdvModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VISUALIZZADETTAGLIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VISUALIZZADETTAGLIO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-902174228) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (theModel.getAppDataidCertificatoreSel() != null && isCertificatorePresente(
					theModel.getAppDataidCertificatoreSel(), theModel.getAppDatacertificatoreList())) {

				// l'applicativo porta nel primo tab
				theModel.getSession().remove("cpDettaglioCertificatore_tspDettCert_selectedMultiPanel");
				result.setResultCode(VISUALIZZADETTAGLIO_OUTCOME_CODE__OK);
			} else {
				theModel.setAppDataidCertificatoreSel(null);

				result.getGlobalErrors().add("Occorre selezionare un certificatore");
				result.setResultCode(VISUALIZZADETTAGLIO_OUTCOME_CODE__KO);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::visualizzaDettaglio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblRisultatoCertificatori
	 */
	public static void resetClearStatus_widg_tblRisultatoCertificatori(java.util.Map session) {
		session.put("cpRisultatoCertificatoriAdv_tblRisultatoCertificatori_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-637975220) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	public static boolean isCertificatorePresente(String idCertificatore, ArrayList<Certificatore> certificatoreList) {
		boolean isPresente = false;

		if (idCertificatore != null && certificatoreList != null) {
			for (Certificatore ace : certificatoreList) {

				if (idCertificatore.equals(ace.getId())) {
					isPresente = true;
				}
			}
		}

		return isPresente;
	}
	/*PROTECTED REGION END*/
}
