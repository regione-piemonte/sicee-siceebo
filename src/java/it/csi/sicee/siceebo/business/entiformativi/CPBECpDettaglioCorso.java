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

/*PROTECTED REGION ID(R441777453) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.business.facade.MiscMgr;
/*PROTECTED REGION END*/

public class CPBECpDettaglioCorso {

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

	// ApplicationData: [idCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCORSOSELEZIONATO_CODE = "appDataidCorsoSelezionato";

	// ApplicationData: [dettaglioCorso, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOCORSO_CODE = "appDatadettaglioCorso";

	// ApplicationData: [modalitaDettaglioCorso, scope:USER_SESSION]
	public static final String APPDATA_MODALITADETTAGLIOCORSO_CODE = "appDatamodalitaDettaglioCorso";

	// ApplicationData: [tipoRuoloUtente, scope:USER_SESSION]
	public static final String APPDATA_TIPORUOLOUTENTE_CODE = "appDatatipoRuoloUtente";

	// ApplicationData: [idSedeOperativaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSEDEOPERATIVASELEZIONATA_CODE = "appDataidSedeOperativaSelezionata";

	// ApplicationData: [elencoTipologieCorsi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOLOGIECORSI_CODE = "appDataelencoTipologieCorsi";

	// ApplicationData: [enteFormativo, scope:USER_SESSION]
	public static final String APPDATA_ENTEFORMATIVO_CODE = "appDataenteFormativo";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioCorso";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaCorso definito in un ExecCommand del
	 * ContentPanel cpDettaglioCorso
	 */
	public ExecResults salvaCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioCorsoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVACORSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVACORSO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R376583733) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n salvaCorso :: inizio");
			Corso corso = theModel.getAppDatadettaglioCorso();
			String modalita = theModel.getAppDatamodalitaDettaglioCorso();
			boolean ok = true;

			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioCorso().getIdTipoCorso())) {
				addMissingRequiredFieldError("appDatadettaglioCorso.idTipoCorso", result);
				ok = false;
			}

			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioCorso().getAnnoFormativo())) {
				addMissingRequiredFieldError("appDatadettaglioCorso.annoFormativo", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioCorso().getNumCorso())) {
				addMissingRequiredFieldError("appDatadettaglioCorso.numCorso", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioCorso().getTitolo())) {
				addMissingRequiredFieldError("appDatadettaglioCorso.titolo", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioCorso().getDataDal())) {
				addMissingRequiredFieldError("appDatadettaglioCorso.dataDal", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioCorso().getDataAl())) {
				addMissingRequiredFieldError("appDatadettaglioCorso.dataAl", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioCorso().getProtApprov())) {
				addMissingRequiredFieldError("appDatadettaglioCorso.protApprov", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioCorso().getDataApprov())) {
				addMissingRequiredFieldError("appDatadettaglioCorso.dataApprov", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioCorso().getTotaleOre())) {
				addMissingRequiredFieldError("appDatadettaglioCorso.totaleOre", result);
				ok = false;
			}

			if (ok) {
				if (modalita.equalsIgnoreCase("INSERT")) {
					getMiscMgr().insertCorso(corso);
					result.setResultCode(SALVACORSO_OUTCOME_CODE__OK);
				} else {
					getMiscMgr().updateCorso(corso);
					result.setResultCode(SALVACORSO_OUTCOME_CODE__OK);
				}
			} else {
				result.setResultCode(SALVACORSO_OUTCOME_CODE__KO);
			}
			log.debug("\n\n\n salvaCorso :: fine");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaCorso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadFromDB definito in un ExecCommand del
	 * ContentPanel cpDettaglioCorso
	 */
	public ExecResults loadFromDB(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioCorsoModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADFROMDB_OUTCOME_CODE__OK_RW = //NOSONAR  Reason:EIAS
				"OK_RW"; //NOSONAR  Reason:EIAS
		final String LOADFROMDB_OUTCOME_CODE__OK_R = //NOSONAR  Reason:EIAS
				"OK_R"; //NOSONAR  Reason:EIAS
		final String LOADFROMDB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1281131008) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n ON ENTER :: loadFromDb :: inizio");
			/*
			ArrayList<Decodifica> elencoTipologieCorsi = new ArrayList<Decodifica>();
			Decodifica tipologiaCorso = new Decodifica();
			
			tipologiaCorso.setId(Constants.TIPOCORSO1_AGGIORNAMENTO);
			tipologiaCorso.setDescr(Constants.TIPOCORSO1_AGGIORNAMENTO_DESC);
			elencoTipologieCorsi.add(tipologiaCorso);
			tipologiaCorso = new Decodifica();
			tipologiaCorso.setId(Constants.TIPOCORSO1_FORMAZIONE);
			tipologiaCorso.setDescr(Constants.TIPOCORSO1_FORMAZIONE_DESC);
			elencoTipologieCorsi.add(tipologiaCorso);
			*/

			ArrayList<Decodifica> elencoTipologieCorsi = getMiscMgr().getElencoTipoCorsoValidi();

			Corso corso = null;

			theModel.setAppDataelencoTipologieCorsi(elencoTipologieCorsi);

			String modalita = theModel.getAppDatamodalitaDettaglioCorso();
			if (modalita.equalsIgnoreCase("INSERT")) {
				corso = new Corso();
				corso.setFkEnte(theModel.getAppDataidSedeOperativaSelezionata());
			} else {
				Long idCorsoSelezionato = theModel.getAppDataidCorsoSelezionato();
				corso = recuperaCorso(idCorsoSelezionato);
			}

			theModel.setAppDatadettaglioCorso(corso);
			if (theModel.getAppDatatipoRuoloUtente().equalsIgnoreCase(Constants.RUOLO_RW))
				result.setResultCode(LOADFROMDB_OUTCOME_CODE__OK_RW);
			else
				result.setResultCode(LOADFROMDB_OUTCOME_CODE__OK_R);
			log.debug("\n\n\n ON ENTER :: loadFromDb :: fine");

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadFromDB] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R34527207) ENABLED START*/
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

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	/*PROTECTED REGION END*/
}
