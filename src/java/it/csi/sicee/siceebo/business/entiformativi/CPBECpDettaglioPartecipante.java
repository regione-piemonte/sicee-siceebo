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

/*PROTECTED REGION ID(R-1154455433) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.business.facade.MiscMgr;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceebo.business.facade.BaseMgr;
/*PROTECTED REGION END*/

public class CPBECpDettaglioPartecipante {

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

	// ApplicationData: [modalitaDettaglioCorso, scope:USER_SESSION]
	public static final String APPDATA_MODALITADETTAGLIOCORSO_CODE = "appDatamodalitaDettaglioCorso";

	// ApplicationData: [dettaglioPartecipante, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOPARTECIPANTE_CODE = "appDatadettaglioPartecipante";

	// ApplicationData: [idPartecipanteSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDPARTECIPANTESELEZIONATO_CODE = "appDataidPartecipanteSelezionato";

	// ApplicationData: [modalitaDettaglioPartecipante, scope:USER_SESSION]
	public static final String APPDATA_MODALITADETTAGLIOPARTECIPANTE_CODE = "appDatamodalitaDettaglioPartecipante";

	// ApplicationData: [cfSel, scope:USER_SESSION]
	public static final String APPDATA_CFSEL_CODE = "appDatacfSel";

	// ApplicationData: [listaCf, scope:USER_SESSION]
	public static final String APPDATA_LISTACF_CODE = "appDatalistaCf";

	// ApplicationData: [listaTipoIstruzione, scope:USER_SESSION]
	public static final String APPDATA_LISTATIPOISTRUZIONE_CODE = "appDatalistaTipoIstruzione";

	// ApplicationData: [listaEsito, scope:USER_SESSION]
	public static final String APPDATA_LISTAESITO_CODE = "appDatalistaEsito";

	// ApplicationData: [dettaglioCorso, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOCORSO_CODE = "appDatadettaglioCorso";

	// ApplicationData: [tipoRuoloUtente, scope:USER_SESSION]
	public static final String APPDATA_TIPORUOLOUTENTE_CODE = "appDatatipoRuoloUtente";

	// ApplicationData: [enteFormativo, scope:USER_SESSION]
	public static final String APPDATA_ENTEFORMATIVO_CODE = "appDataenteFormativo";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioPartecipante";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaListaCf definito in un ExecCommand del
	 * ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults caricaListaCf(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICALISTACF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CARICALISTACF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-511714943) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String cfDigitato = theModel.getAppDatadettaglioPartecipante().getCodiceFiscale().toUpperCase();
			log.debug("\n\n\n>>>>>>> CF digitato: " + cfDigitato);
			if (cfDigitato.length() >= 3) {
				ArrayList<SiceeTCertificatore> listaCertificatori = (ArrayList<SiceeTCertificatore>) getMiscMgr()
						.recuperaCertificatoriByCf(cfDigitato + "%");
				ArrayList<DtListaCf> listaCf = new ArrayList<DtListaCf>();
				for (SiceeTCertificatore lc : listaCertificatori) {
					DtListaCf dtListaCf = new DtListaCf();
					dtListaCf.setIdCertificatore(lc.getIdCertificatore());
					dtListaCf.setCodiceFiscale(lc.getCodiceFiscale());
					log.debug("\n\n\n>>>>>>> CF estratto: " + lc.getCodiceFiscale());
					listaCf.add(dtListaCf);
				}
				theModel.setAppDatalistaCf(listaCf);
			}

			// impostazione del result code 
			result.setResultCode(CARICALISTACF_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaListaCf] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo copiaDatiPartecipanteCertif definito in un ExecCommand del
	 * ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults copiaDatiPartecipanteCertif(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String COPIADATIPARTECIPANTECERTIF_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String COPIADATIPARTECIPANTECERTIF_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2102923697) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String idCertificatore = theModel.getAppDatacfSel();
			String telefono = null;
			if (!MiscMgr.isNullOrEmpty(idCertificatore)) {
				SiceeTCertificatore certificatore = getMiscMgr().recuperaCertificatore(idCertificatore);
				theModel.getAppDatadettaglioPartecipante().setCodiceFiscale(certificatore.getCodiceFiscale());
				theModel.getAppDatadettaglioPartecipante().setCognome(certificatore.getCognome());
				theModel.getAppDatadettaglioPartecipante().setNome(certificatore.getNome());
				theModel.getAppDatadettaglioPartecipante().setLuogoNascita(certificatore.getDescComuneNascita());
				theModel.getAppDatadettaglioPartecipante()
						.setDataNascita(MiscMgr.convertToString(certificatore.getDtNascita()));
				theModel.getAppDatadettaglioPartecipante().setNumCertificatore(certificatore.getNumCertificatore());
				theModel.getAppDatadettaglioPartecipante().setAlbo(certificatore.getOrdine());
				theModel.getAppDatadettaglioPartecipante().setDescProvAlbo(certificatore.getDescProvOrdine());
				theModel.getAppDatadettaglioPartecipante().setNumIscrAlbo(certificatore.getNumIscrAlbo());
				theModel.getAppDatadettaglioPartecipante()
						.setDataIscrAlbo(BaseMgr.convertToString(certificatore.getDataIscrAlbo()));
				Integer tipoIstruzione = null;
				if (!BaseMgr.isNullOrEmpty(certificatore.getFkIstruzione())) {
					tipoIstruzione = getMiscMgr().getIstruzione(certificatore.getFkIstruzione()).getFkTipoIstruzione();
				}
				theModel.getAppDatadettaglioPartecipante().setFkTipoIstruzione(tipoIstruzione);

				telefono = certificatore.getTelefono();
				if (!BaseMgr.isNullOrEmpty(certificatore.getCell())) {
					if (!BaseMgr.isNullOrEmpty(telefono)) {
						telefono = telefono + " / " + certificatore.getCell();
					} else {
						telefono = telefono + certificatore.getCell();
					}
				}
				theModel.getAppDatadettaglioPartecipante().setTelefono(telefono);
				theModel.getAppDatadettaglioPartecipante().setEmail(certificatore.getEmail());

				ArrayList<DtListaCf> listaCf = new ArrayList<DtListaCf>();
				DtListaCf lcf = new DtListaCf();
				lcf.setIdCertificatore("");
				lcf.setCodiceFiscale("");
				listaCf.add(lcf);
				theModel.setAppDatalistaCf(listaCf);
			}

			// impostazione del result code 
			result.setResultCode(COPIADATIPARTECIPANTECERTIF_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::copiaDatiPartecipanteCertif] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo controlloStampaAttestato definito in un ExecCommand del
	 * ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults controlloStampaAttestato(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CONTROLLOSTAMPAATTESTATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CONTROLLOSTAMPAATTESTATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-74502421) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			boolean ok = true;
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getCognome())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.cognome", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getNome())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.nome", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getDataNascita())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.dataNascita", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getLuogoNascita())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.luogoNascita", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getPercFreq())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.percFreq", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getDataEsame())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.dataEsame", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getEsitoEsame())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.esitoEsame", result);
				ok = false;
			} else if (theModel.getAppDatadettaglioPartecipante().getEsitoEsame()
					.equalsIgnoreCase(Constants.ESITO_RESPINTO)) {
				addValueRequiredFieldError("appDatadettaglioPartecipante.esitoEsame", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getTelefono())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.telefono", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getEmail())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.email", result);
				ok = false;
			}

			if (ok) {
				Partecipante partecipante = theModel.getAppDatadettaglioPartecipante();
				String modalita = theModel.getAppDatamodalitaDettaglioPartecipante();
				if (modalita.equalsIgnoreCase("INSERT")) {
					if (getMiscMgr().countPartecipantiByidCorsoAndCodFisc(partecipante.getFkCorso(),
							partecipante.getCodiceFiscale()) == 0) {
						Long idPartecipante = getMiscMgr().insertPartecipante(partecipante);
						theModel.getAppDatadettaglioPartecipante().setIdPartecipante(idPartecipante);
						theModel.setAppDatamodalitaDettaglioPartecipante("UPDATE");
						result.setResultCode(CONTROLLOSTAMPAATTESTATO_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors()
								.add("Esiste gia' un partecipante a questo corso con lo stesso codice fiscale");
						result.setResultCode(CONTROLLOSTAMPAATTESTATO_OUTCOME_CODE__KO);
					}
				} else {
					getMiscMgr().updatePartecipante(partecipante);
					result.setResultCode(CONTROLLOSTAMPAATTESTATO_OUTCOME_CODE__OK);
				}
			} else {
				result.setResultCode(CONTROLLOSTAMPAATTESTATO_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::controlloStampaAttestato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaPartecipante definito in un ExecCommand del
	 * ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults salvaPartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAPARTECIPANTE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAPARTECIPANTE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R2049428693) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n salvaPartecipante :: inizio");
			boolean ok = true;
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getCognome())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.cognome", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getNome())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.nome", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getDataNascita())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.dataNascita", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getLuogoNascita())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.luogoNascita", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getPercFreq())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.percFreq", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getDataEsame())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.dataEsame", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getEsitoEsame())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.esitoEsame", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getTelefono())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.telefono", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDatadettaglioPartecipante().getEmail())) {
				addMissingRequiredFieldError("appDatadettaglioPartecipante.email", result);
				ok = false;
			}

			if (ok) {
				Partecipante partecipante = theModel.getAppDatadettaglioPartecipante();
				String modalita = theModel.getAppDatamodalitaDettaglioPartecipante();
				if (modalita.equalsIgnoreCase("INSERT")) {
					if (getMiscMgr().countPartecipantiByidCorsoAndCodFisc(partecipante.getFkCorso(),
							partecipante.getCodiceFiscale()) == 0) {
						getMiscMgr().insertPartecipante(partecipante);
						result.setResultCode(SALVAPARTECIPANTE_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors()
								.add("Esiste gia' un partecipante a questo corso con lo stesso codice fiscale");
						result.setResultCode(SALVAPARTECIPANTE_OUTCOME_CODE__KO);
					}
				} else {
					getMiscMgr().updatePartecipante(partecipante);
					result.setResultCode(SALVAPARTECIPANTE_OUTCOME_CODE__OK);
				}
			} else {
				result.setResultCode(SALVAPARTECIPANTE_OUTCOME_CODE__KO);
			}
			log.debug("\n\n\n salvaPartecipante :: fine");

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaPartecipante] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadFromDB definito in un ExecCommand del
	 * ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults loadFromDB(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

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
			/*PROTECTED REGION ID(R-1050400266) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n ON ENTER :: loadFromDb :: inizio");

			Partecipante partecipante = null;
			String modalita = theModel.getAppDatamodalitaDettaglioPartecipante();
			if (modalita.equalsIgnoreCase("INSERT")) {
				partecipante = new Partecipante();
				partecipante.setFkCorso(theModel.getAppDataidCorsoSelezionato());
			} else {
				Long idPartecipanteSelezionato = theModel.getAppDataidPartecipanteSelezionato();
				partecipante = recuperaPartecipante(idPartecipanteSelezionato);
			}

			theModel.setAppDatadettaglioPartecipante(partecipante);

			ArrayList<Istruzione> tipiIstruzione = null;
			tipiIstruzione = getMiscMgr().getTipiIstruzione();
			theModel.setAppDatalistaTipoIstruzione(tipiIstruzione);

			ArrayList<DtListaCf> listaCf = new ArrayList<DtListaCf>();
			DtListaCf lcf = new DtListaCf();
			lcf.setIdCertificatore("");
			lcf.setCodiceFiscale("");
			listaCf.add(lcf);
			theModel.setAppDatalistaCf(listaCf);

			ArrayList<Esito> listaEsiti = new ArrayList<Esito>();
			Esito esito = new Esito();
			esito.setIdEsito(Constants.ESITO_SUPERATO);
			esito.setDescr(Constants.ESITO_SUPERATO_DESC);
			listaEsiti.add(esito);
			esito = new Esito();
			esito.setIdEsito(Constants.ESITO_SUPERATO_SESS_SUCC);
			esito.setDescr(Constants.ESITO_SUPERATO_SESS_SUCC_DESC);
			listaEsiti.add(esito);
			esito = new Esito();
			esito.setIdEsito(Constants.ESITO_RESPINTO);
			esito.setDescr(Constants.ESITO_RESPINTO_DESC);
			listaEsiti.add(esito);
			theModel.setAppDatalistaEsito(listaEsiti);

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
	/*PROTECTED REGION ID(R1621116759) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
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

	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	private void addValueRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il partecipante deve aver superato l'esame");
	}

	private Partecipante recuperaPartecipante(Long idPartecipante) throws BEException {
		Partecipante partecipante = null;
		partecipante = getMiscMgr().getPartecipanteByidPartecipante(idPartecipante);
		return partecipante;
	}

	/*PROTECTED REGION END*/
}
