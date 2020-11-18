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

/*PROTECTED REGION ID(R-1210971645) ENABLED START*/

import it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriModel;
import it.csi.sicee.siceebo.business.BEException;
import it.csi.sicee.siceebo.business.facade.BaseMgr;
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.business.facade.CertificatoreMgr;
import it.csi.sicee.siceebo.dto.ExecResults;

/*PROTECTED REGION END*/

public class CPBECpRicercaCertificatori {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [ricercaCertificatori, scope:USER_SESSION]
	public static final String APPDATA_RICERCACERTIFICATORI_CODE = "appDataricercaCertificatori";

	// ApplicationData: [titoli, scope:USER_SESSION]
	public static final String APPDATA_TITOLI_CODE = "appDatatitoli";

	// ApplicationData: [regione, scope:USER_SESSION]
	public static final String APPDATA_REGIONE_CODE = "appDataregione";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [certificatoreList, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORELIST_CODE = "appDatacertificatoreList";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaCertificatori";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setRegioneDtCatastali definito in un ExecCommand del
	 * ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setRegioneDtCatastali(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETREGIONEDTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-602108211) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDataricercaCertificatori().setCodProvincia(null);

			theModel.getAppDataricercaCertificatori().setCodComune(null);

			// impostazione del result code 
			result.setResultCode(SETREGIONEDTCATASTALI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setRegioneDtCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaDtCatastali definito in un ExecCommand del
	 * ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1279170057) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			theModel.getAppDataricercaCertificatori().setCodComune(null);

			// impostazione del result code
			result.setResultCode(SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvinciaDtCatastali] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaCertificatori definito in un ExecCommand del
	 * ContentPanel cpRicercaCertificatori
	 */
	public ExecResults ricercaCertificatori(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCACERTIFICATORI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCACERTIFICATORI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1032110327) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			FiltroRicercaCertificatori filtro = theModel.getAppDataricercaCertificatori();

			//GenericUtil.stampa(filtro, true, 4);

			if (GenericUtil.isNullOrEmpty(filtro.getNumMatricola()) && GenericUtil.isNullOrEmpty(filtro.getCodTitolo())
					&& GenericUtil.isNullOrEmpty(filtro.getCodTitolo()) && GenericUtil.isNullOrEmpty(filtro.getNome())
					&& GenericUtil.isNullOrEmpty(filtro.getCognome())
					&& GenericUtil.isNullOrEmpty(filtro.getDataNascitadal())
					&& GenericUtil.isNullOrEmpty(filtro.getDataNascitaal())
					&& GenericUtil.isNullOrEmpty(filtro.getRagSociale())
					&& GenericUtil.isNullOrEmpty(filtro.getCodRegione())
					&& GenericUtil.isNullOrEmpty(filtro.getCodProvincia())
					&& GenericUtil.isNullOrEmpty(filtro.getCodComune())
					&& GenericUtil.isNullOrEmpty(filtro.getDescComune())
					&& GenericUtil.isNullOrEmpty(filtro.getTitoloStudioAllegato())
					&& GenericUtil.isNullOrEmpty(filtro.getIscrOrdProf())
					&& GenericUtil.isNullOrEmpty(filtro.getTipoCorso())
					&& GenericUtil.isNullOrEmpty(filtro.getBloccato())
					&& GenericUtil.isNullOrEmpty(filtro.getMotivazioneBlocco())
					//&& (GenericUtil.isNullOrEmpty(filtro.getFlgEsameSosten()) || !filtro.getFlgEsameSosten())
					&& GenericUtil.isNullOrEmpty(filtro.getDataACEdal())
					&& GenericUtil.isNullOrEmpty(filtro.getDataACEal())) {
				result.getGlobalErrors().add("E' necessario impostare almeno un filtro di ricerca");
				result.setResultCode(RICERCACERTIFICATORI_OUTCOME_CODE__KO);
			} else {
				boolean ok = true;

				if (!GenericUtil.isNullOrEmpty(filtro.getNumMatricola())
						&& !GenericUtil.checkValideSixNumber(filtro.getNumMatricola())) {
					result.getFldErrors().put("appDataricercaCertificatori.numMatricola",
							"Il campo deve essere di 6 cifre");
					ok = false;
				}

				if (!GenericUtil.isNullOrEmpty(filtro.getNome()) && !GenericUtil.isLunghezzaMinimo2(filtro.getNome())) {
					result.getFldErrors().put("appDataricercaCertificatori.nome", "Inserire almeno 2 caratteri");
					ok = false;
				}

				if (!GenericUtil.isNullOrEmpty(filtro.getCognome())
						&& !GenericUtil.isLunghezzaMinimo2(filtro.getCognome())) {
					result.getFldErrors().put("appDataricercaCertificatori.cognome", "Inserire almeno 2 caratteri");
					ok = false;
				}

				if (!GenericUtil.isNullOrEmpty(filtro.getRagSociale())
						&& !GenericUtil.isLunghezzaMinimo2(filtro.getRagSociale())) {
					result.getFldErrors().put("appDataricercaCertificatori.ragSociale", "Inserire almeno 2 caratteri");
					ok = false;
				}

				if (!GenericUtil.isNullOrEmpty(filtro.getDataNascitadal())
						&& GenericUtil.isNullOrEmpty(filtro.getDataNascitaal())) {
					result.getFldErrors().put("appDataricercaCertificatori.dataNascitaal",
							"Questa data non puo' essere vuota se e' stata valorizzata 'dal'");
					ok = false;
				} else if (GenericUtil.isNullOrEmpty(filtro.getDataNascitadal())
						&& !GenericUtil.isNullOrEmpty(filtro.getDataNascitaal())) {
					result.getFldErrors().put("appDataricercaCertificatori.dataNascitaAl",
							"Questa data non puo' essere vuota se e' stata valorizzata 'al'");
					ok = false;
				} else if (!BaseMgr.correctCronoDate(filtro.getDataNascitadal(), filtro.getDataNascitaal())) {
					result.getFldErrors().put("appDataricercaCertificatori.dataNascitaal",
							"Questa data non puo' essere precedente alla data 'dal'");
					ok = false;
				}

				if (!GenericUtil.isNullOrEmpty(filtro.getDataACEdal())
						&& GenericUtil.isNullOrEmpty(filtro.getDataACEal())) {
					result.getFldErrors().put("appDataricercaCertificatori.dataACEal",
							"Questa data non puo' essere vuota se e' stata valorizzata 'dal'");
					ok = false;
				} else if (GenericUtil.isNullOrEmpty(filtro.getDataACEdal())
						&& !GenericUtil.isNullOrEmpty(filtro.getDataACEal())) {
					result.getFldErrors().put("appDataricercaCertificatori.dataACEAl",
							"Questa data non puo' essere vuota se e' stata valorizzata 'al'");
					ok = false;
				} else if (!BaseMgr.correctCronoDate(filtro.getDataACEdal(), filtro.getDataACEal())) {
					result.getFldErrors().put("appDataricercaCertificatori.dataACEal",
							"Questa data non puo' essere precedente alla data 'dal'");
					ok = false;
				}

				if (ok) {

					Integer countCertificatori = getCertificatoreMgr().findElencoCertificatoreCount(filtro, false);

					if (countCertificatori != null && countCertificatori > 0) {

						Integer numMax = getCertificatoreMgr().getNumeroMaxCertificatori();

						log.debug("STAMPO IL NUMERO MASSIMO CERTIFICATORI: " + numMax);

						if (countCertificatori < numMax) {

							ArrayList<Certificatore> certificatori = getCertificatoreMgr()
									.findElencoCertificatore(filtro, false);

							theModel.setAppDatacertificatoreList(certificatori);

							result.setResultCode(RICERCACERTIFICATORI_OUTCOME_CODE__OK);
						} else {
							result.getGlobalErrors().add("Sono stati estratti " + countCertificatori
									+ " record. E' necessario restringere il campo della ricerca. Il massimo consentito e' "
									+ numMax + " record.");

							result.setResultCode(RICERCACERTIFICATORI_OUTCOME_CODE__KO);
						}
					} else {
						result.getGlobalErrors().add("Nessun certificatore trovato");

						result.setResultCode(RICERCACERTIFICATORI_OUTCOME_CODE__KO);
					}
				} else {
					result.setResultCode(RICERCACERTIFICATORI_OUTCOME_CODE__KO);
				}
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaCertificatori] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciCombo definito in un ExecCommand del
	 * ContentPanel cpRicercaCertificatori
	 */
	public ExecResults gestisciCombo(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1113360033) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);
			loadComboTitoli(theModel);

			/*
			ArrayList<Decodifica> elencoTipoCorsi = new ArrayList<Decodifica>();
			Decodifica tipoCorso = new Decodifica();;
			tipoCorso.setId(Constants.TIPOCORSO1_AGGIORNAMENTO);
			tipoCorso.setDescr(Constants.TIPOCORSO1_AGGIORNAMENTO_DESC);
			elencoTipoCorsi.add(tipoCorso);
			tipoCorso = new Decodifica();
			tipoCorso.setId(Constants.TIPOCORSO1_FORMAZIONE);
			tipoCorso.setDescr(Constants.TIPOCORSO1_FORMAZIONE_DESC);
			elencoTipoCorsi.add(tipoCorso);
			*/
			//ArrayList<Decodifica> elencoTipoCorsi = getCertificatoreMgr().getMiscMgr().getElencoTipoCorso();

			//theModel.setAppDataelencoTipoCorsi(elencoTipoCorsi);

			// impostazione del result code
			result.setResultCode(GESTISCICOMBO_OUTCOME_CODE__OK);
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciCombo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-872093423) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private void gestisciComboDtCatasto(CpRicercaCertificatoriModel theModel) throws BEException {

		FiltroRicercaCertificatori filtro = theModel.getAppDataricercaCertificatori();

		ArrayList<Regione> regione = new ArrayList<Regione>();
		regione = getSOAIntegrationMgr().getRegioni();
		theModel.setAppDataregione(regione);

		String actRegSel = filtro != null ? filtro.getCodRegione() : null;
		String actProvSel = filtro != null ? filtro.getCodProvincia() : null;

		ArrayList<Provincia> province = new ArrayList<Provincia>();

		if (!GenericUtil.isNullOrEmpty(actRegSel)) {
			province = getSOAIntegrationMgr().getProvinceByRegione(actRegSel);
		} else {
			actProvSel = null;
		}

		theModel.setAppDataprovince(province);

		ArrayList<Comune> comuni = new ArrayList<Comune>();

		if (!GenericUtil.isNullOrEmpty(actProvSel)) {
			comuni = getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		}

		theModel.setAppDatacomuni(comuni);
	}

	private void loadComboTitoli(CpRicercaCertificatoriModel theModel) throws BEException {
		theModel.setAppDatatitoli(getCertificatoreMgr().getAllTitoli());
	}

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	/*PROTECTED REGION END*/
}
