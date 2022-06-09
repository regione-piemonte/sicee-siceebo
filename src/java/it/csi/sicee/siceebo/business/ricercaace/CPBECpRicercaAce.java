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

/*PROTECTED REGION ID(R1573794296) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.AceMgr;
import it.csi.sicee.siceebo.business.facade.BaseMgr;
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceebo.dto.ExecResults;
import it.csi.sicee.siceebo.dto.UserInfo;
import it.csi.sicee.siceebo.dto.ace.Ace;
import it.csi.sicee.siceebo.dto.ace.FiltroRicercaAce;
import it.csi.sicee.siceebo.dto.geo.Comune;
import it.csi.sicee.siceebo.dto.geo.Provincia;
import it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;

import java.util.ArrayList;
import java.util.Map;

import org.apache.log4j.Logger;

/*PROTECTED REGION END*/

public class CPBECpRicercaAce {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [ricercaAce, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACE_CODE = "appDataricercaAce";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [motivazioneRilascio, scope:USER_ACTION]
	public static final String APPDATA_MOTIVAZIONERILASCIO_CODE = "appDatamotivazioneRilascio";

	// ApplicationData: [aceList, scope:USER_SESSION]
	public static final String APPDATA_ACELIST_CODE = "appDataaceList";

	// ApplicationData: [classeEnergetica, scope:USER_ACTION]
	public static final String APPDATA_CLASSEENERGETICA_CODE = "appDataclasseEnergetica";

	// ApplicationData: [destinazioneUso, scope:USER_ACTION]
	public static final String APPDATA_DESTINAZIONEUSO_CODE = "appDatadestinazioneUso";

	// ApplicationData: [motivazioneCtu, scope:USER_SESSION]
	public static final String APPDATA_MOTIVAZIONECTU_CODE = "appDatamotivazioneCtu";

	// ApplicationData: [mappaUrl, scope:USER_ACTION]
	public static final String APPDATA_MAPPAURL_CODE = "appDatamappaUrl";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpRicercaAce";

	public static final String MULTIPANEL_MPOLDAPE = "mpOldApe";
	public static final String MPI_MPOLDAPE_FPOLDAPE = CPNAME + "_" + MULTIPANEL_MPOLDAPE + "_" + "fpOldApe";

	public static final String MULTIPANEL_MPNEWAPE = "mpNewApe";
	public static final String MPI_MPNEWAPE_FPNEWAPE = CPNAME + "_" + MULTIPANEL_MPNEWAPE + "_" + "fpNewApe";

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
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults ricercaACEbyCodice(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACEBYCODICE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACEBYCODICE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2088731571) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			boolean ok = true;
			FiltroRicercaAce filtro = theModel.getAppDataricercaAce();
			UserInfo user = theModel.getAppDatacurrentUser();

			// Questo paramentro mi serve nel caso nel passo successivo debba rifare la ricerca, ad esempio a seguito della cancellazione APE
			theModel.getAppDataricercaAce().setFlgIsRicCodice(true);

			log.debug("STAMPO il RUOLO: " + user.getRuolo());
			log.debug("STAMPO il COD RUOLO: " + user.getCodRuolo());
			log.debug("STAMPO il CF: " + user.getCodFisc());

			if (user.getRuolo().equalsIgnoreCase(Constants.LABEL_RUOLO_LETTORE_CTU_ESTERNI)) {
				if (BaseMgr.isNullOrEmpty(theModel.getAppDatamotivazioneCtu())) {
					// impostazione del result code 
					result.getGlobalErrors().add(
							"Per i CTU  e' obbligatorio specificare il motivo della ricerca e gli estremi del mandato/nomina");
					ok = false;
					result.setResultCode(RICERCAACEBYCODICE_OUTCOME_CODE__KO);
				} else {
					// inserisco un record di tracciamento nella tabella log solo nel caso in cui sia un LETTORE CTU ESTERNI
					log.debug("\n\n\n >>>> prima di inseriscirecord in log ...");
					getAceMgr().inserisciSiceeLRicercheCtu(user.getCodFisc(), new Date(),
							theModel.getAppDatamotivazioneCtu());
				}
			}

			if (ok) {
				if (filtro != null) {
					if (checkFiltroAce(filtro, result)) {
						// prende solo gli Ace con stato Inviato
						ArrayList<Ace> aceList = getAceMgr().findElencoAceByCodice(filtro);

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
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaACEbyCodice] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvinciaDtCatastali definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIADTCATASTALI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1660213186) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code
			result.setResultCode("OK");
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
	 * Implementazione del metodo gestisciApeOldAndNew definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciApeOldAndNew(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIAPEOLDANDNEW_OUTCOME_CODE__OLD = //NOSONAR  Reason:EIAS
				"OLD"; //NOSONAR  Reason:EIAS
		final String GESTISCIAPEOLDANDNEW_OUTCOME_CODE__NEW = //NOSONAR  Reason:EIAS
				"NEW"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R244569882) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			FiltroRicercaAce filtro = theModel.getAppDataricercaAce();

			if (filtro != null && filtro.getFlgIsOld()) {
				loadComboMotivazioneRilascio(theModel);
				loadComboClasseEnergetica(theModel);
				loadComboDestinazioneUso(theModel);

				pulisciCampiApeNew(theModel);
				// impostazione del result code 
				result.setResultCode(GESTISCIAPEOLDANDNEW_OUTCOME_CODE__OLD);
			} else {
				loadComboMotivazioneRilascio2015(theModel);
				loadComboClasseEnergetica2015(theModel);
				loadComboDestinazioneUso2015(theModel);

				pulisciCampiApeOld(theModel);

				// impostazione del result code 
				result.setResultCode(GESTISCIAPEOLDANDNEW_OUTCOME_CODE__NEW);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciApeOldAndNew] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAceByFiltro definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults ricercaAceByFiltro(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACEBYFILTRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACEBYFILTRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1922690648) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			boolean ok = true;
			FiltroRicercaAce filtro = theModel.getAppDataricercaAce();
			// Questo paramentro mi serve nel caso nel passo successivo debba rifare la ricerca, ad esempio a seguito della cancellazione APE
			theModel.getAppDataricercaAce().setFlgIsRicCodice(false);

			UserInfo user = theModel.getAppDatacurrentUser();

			log.debug("STAMPO il RUOLO: " + user.getRuolo());
			log.debug("STAMPO il COD RUOLO: " + user.getCodRuolo());
			log.debug("STAMPO il CF: " + user.getCodFisc());

			if (user.getRuolo().equalsIgnoreCase(Constants.LABEL_RUOLO_LETTORE_CTU_ESTERNI)) {
				if (BaseMgr.isNullOrEmpty(theModel.getAppDatamotivazioneCtu())) {
					// impostazione del result code 
					result.getGlobalErrors().add(
							"Per i CTU  e' obbligatorio specificare il motivo della ricerca e gli estremi del mandato/nomina");
					ok = false;
					result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
				} else {
					// inserisco un record di tracciamento nella tabella log solo nel caso in cui sia un LETTORE CTU ESTERNI
					log.debug("\n\n\n >>>> prima di inseriscirecord in log ...");
					getAceMgr().inserisciSiceeLRicercheCtu(user.getCodFisc(), new Date(),
							theModel.getAppDatamotivazioneCtu());
				}
			}

			if (ok) {
				GenericUtil.stampa(filtro, true, 4);

				filtro.setClassiEnergeticheSelez(pulisciArray(filtro.getClassiEnergeticheSelez()));
				filtro.setDestinazioniUsoSelez(pulisciArray(filtro.getDestinazioniUsoSelez()));

				// Pulisco i campi della ricerca per codice
				filtro.setAnnoCertificato(null);
				filtro.setCertificatore(null);
				filtro.setProgCertificato(null);

				if (GenericUtil.isNullOrEmpty(filtro.getNumMatricola())
						&& GenericUtil.isNullOrEmpty(filtro.getCodProvincia())
						&& GenericUtil.isNullOrEmpty(filtro.getCodComune())
						&& GenericUtil.isNullOrEmpty(filtro.getDescComune())
						&& GenericUtil.isNullOrEmpty(filtro.getDescIndirizzo())
						&& GenericUtil.isNullOrEmpty(filtro.getNumCivico())
						&& GenericUtil.isNullOrEmpty(filtro.getSezione())
						&& GenericUtil.isNullOrEmpty(filtro.getFoglio())
						&& GenericUtil.isNullOrEmpty(filtro.getParticella())
						&& GenericUtil.isNullOrEmpty(filtro.getSubalterno())
						&& GenericUtil.isNullOrEmpty(filtro.getAnnoCostruzioneDal())
						&& GenericUtil.isNullOrEmpty(filtro.getAnnoCostruzioneAl())
						&& GenericUtil.isNullOrEmpty(filtro.getAnnoRistrutDal())
						&& GenericUtil.isNullOrEmpty(filtro.getAnnoRistrutAl())
						&& GenericUtil.isNullOrEmpty(filtro.getInviatiDal())
						&& GenericUtil.isNullOrEmpty(filtro.getInviatiAl())
						&& (filtro.getClassiEnergeticheSelez() == null
								|| filtro.getClassiEnergeticheSelez().size() == 0)
						&& (filtro.getDestinazioniUsoSelez() == null || filtro.getDestinazioniUsoSelez().size() == 0)
						&& GenericUtil.isNullOrEmpty(filtro.getCodMotivoRilascio())
						//&& (GenericUtil.isNullOrEmpty(filtro.getStato()))
						&& GenericUtil.isNullOrEmpty(filtro.getVDa()) && GenericUtil.isNullOrEmpty(filtro.getVA())
						&& GenericUtil.isNullOrEmpty(filtro.getSuDa()) && GenericUtil.isNullOrEmpty(filtro.getSuA())
						&& GenericUtil.isNullOrEmpty(filtro.getVsuDa()) && GenericUtil.isNullOrEmpty(filtro.getVsuA())
						&& GenericUtil.isNullOrEmpty(filtro.getFattoreFormaDa())
						&& GenericUtil.isNullOrEmpty(filtro.getFattoreFormaA())
						&& GenericUtil.isNullOrEmpty(filtro.getTrasmSupOpacheDa())
						&& GenericUtil.isNullOrEmpty(filtro.getTrasmSupOpacheA())
						&& GenericUtil.isNullOrEmpty(filtro.getTrasmSupTraspDa())
						&& GenericUtil.isNullOrEmpty(filtro.getTrasmSupTraspA())
						&& (GenericUtil.isNullOrEmpty(filtro.getFlgFabbisognoSupIndice())
								|| !filtro.getFlgFabbisognoSupIndice())
						&& GenericUtil.isNullOrEmpty(filtro.getRendMedioAcsDa())
						&& GenericUtil.isNullOrEmpty(filtro.getRendMedioAcsA())
						&& GenericUtil.isNullOrEmpty(filtro.getRendMedioImpTermicoDa())
						&& GenericUtil.isNullOrEmpty(filtro.getRendMedioImpTermicoA())
						&& GenericUtil.isNullOrEmpty(filtro.getFabAcsSuDa())
						&& GenericUtil.isNullOrEmpty(filtro.getFabAcsSuA())
						&& GenericUtil.isNullOrEmpty(filtro.getIndiceEplDa())
						&& GenericUtil.isNullOrEmpty(filtro.getIndiceEplA())
						&& (GenericUtil.isNullOrEmpty(filtro.getFlgFabbisognoAcsDiverso())
								|| !filtro.getFlgFabbisognoAcsDiverso())

						&& (GenericUtil.isNullOrEmpty(filtro.getFlgEdifE0()) || !filtro.getFlgEdifE0())

						&& GenericUtil.isNullOrEmpty(filtro.getEpglNrenGlobaleDa())
						&& GenericUtil.isNullOrEmpty(filtro.getEpglNrenGlobaleA())
						&& GenericUtil.isNullOrEmpty(filtro.getEpglRenGlobaleDa())
						&& GenericUtil.isNullOrEmpty(filtro.getEpglRenGlobaleA())
						&& GenericUtil.isNullOrEmpty(filtro.getEmissioniCo2Da())
						&& GenericUtil.isNullOrEmpty(filtro.getEmissioniCo2A())
						&& GenericUtil.isNullOrEmpty(filtro.getSupRaffrescataDa())
						&& GenericUtil.isNullOrEmpty(filtro.getSupRaffrescataA())
						&& GenericUtil.isNullOrEmpty(filtro.getSupRiscaldataDa())
						&& GenericUtil.isNullOrEmpty(filtro.getSupRiscaldataA())
						&& GenericUtil.isNullOrEmpty(filtro.getVolLordoRaffrescatoDa())
						&& GenericUtil.isNullOrEmpty(filtro.getVolLordoRaffrescatoA())
						&& GenericUtil.isNullOrEmpty(filtro.getVolLordoRiscaldatoDa())
						&& GenericUtil.isNullOrEmpty(filtro.getVolLordoRiscaldatoA())
						&& GenericUtil.isNullOrEmpty(filtro.getEphDa()) && GenericUtil.isNullOrEmpty(filtro.getEphA())
						&& GenericUtil.isNullOrEmpty(filtro.getAsolAsupDa())
						&& GenericUtil.isNullOrEmpty(filtro.getAsolAsupA())
						&& GenericUtil.isNullOrEmpty(filtro.getYieDa()) && GenericUtil.isNullOrEmpty(filtro.getYieA())
						&& GenericUtil.isNullOrEmpty(filtro.getVSuRaffDa())
						&& GenericUtil.isNullOrEmpty(filtro.getVSuRaffA())
						&& GenericUtil.isNullOrEmpty(filtro.getVSuRiscDa())
						&& GenericUtil.isNullOrEmpty(filtro.getVSuRiscA())
						&& GenericUtil.isNullOrEmpty(filtro.getSVRaffDa())
						&& GenericUtil.isNullOrEmpty(filtro.getSVRaffA())
						&& GenericUtil.isNullOrEmpty(filtro.getSVRiscDa())
						&& GenericUtil.isNullOrEmpty(filtro.getSVRiscA()))

				//		&& (filtro.getDestinazioniUso2015Selez() == null || filtro
				//			.getDestinazioniUso2015Selez().size() == 0)

				//filtro.setDestinazioniUso05Selez(null);

				{
					result.getGlobalErrors().add("E' necessario impostare almeno un filtro di ricerca");
					result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
				} else {

					if (!GenericUtil.isNullOrEmpty(filtro.getNumMatricola())
							&& !GenericUtil.checkValideSixNumber(filtro.getNumMatricola())) {
						result.getFldErrors().put("appDataricercaAce.numMatricola", "Il campo deve essere di 6 cifre");
					}

					if (!GenericUtil.isNullOrEmpty(filtro.getAnnoCostruzioneDal())
							&& GenericUtil.isNullOrEmpty(filtro.getAnnoCostruzioneAl())) {
						result.getFldErrors().put("appDataricercaAce.annoCostruzioneAl",
								"Questo campo non puo' essere vuoto se e' stato valorizzato 'dal'");
					} else if (GenericUtil.isNullOrEmpty(filtro.getAnnoCostruzioneDal())
							&& !GenericUtil.isNullOrEmpty(filtro.getAnnoCostruzioneAl())) {
						result.getFldErrors().put("appDataricercaAce.annoCostruzioneDal",
								"Questo campo non puo' essere vuoto se e' stato valorizzato 'al'");
					} else if (!BaseMgr.correctCronoAnni(filtro.getAnnoCostruzioneDal(),
							filtro.getAnnoCostruzioneAl())) {
						result.getFldErrors().put("appDataricercaAce.annoCostruzioneAl",
								"Questo anno non puo' essere precedente all'anno 'dal'");
					}

					if (!GenericUtil.isNullOrEmpty(filtro.getAnnoRistrutDal())
							&& GenericUtil.isNullOrEmpty(filtro.getAnnoRistrutAl())) {
						result.getFldErrors().put("appDataricercaAce.annoRistrutAl",
								"Questo campo non puo' essere vuoto se e' stato valorizzato 'dal'");
					} else if (GenericUtil.isNullOrEmpty(filtro.getAnnoRistrutDal())
							&& !GenericUtil.isNullOrEmpty(filtro.getAnnoRistrutAl())) {
						result.getFldErrors().put("appDataricercaAce.annoRistrutDal",
								"Questo campo non puo' essere vuoto se e' stato valorizzato 'al'");
					} else if (!BaseMgr.correctCronoAnni(filtro.getAnnoRistrutDal(), filtro.getAnnoRistrutAl())) {
						result.getFldErrors().put("appDataricercaAce.annoRistrutAl",
								"Questo anno non puo' essere precedente all'anno 'dal'");
					}

					if (!GenericUtil.isNullOrEmpty(filtro.getInviatiDal())
							&& GenericUtil.isNullOrEmpty(filtro.getInviatiAl())) {
						result.getFldErrors().put("appDataricercaAce.inviatiAl",
								"Questo campo non puo' essere vuoto se e' stato valorizzato 'dal'");
					} else if (GenericUtil.isNullOrEmpty(filtro.getInviatiDal())
							&& !GenericUtil.isNullOrEmpty(filtro.getInviatiAl())) {
						result.getFldErrors().put("appDataricercaAce.inviatiDal",
								"Questo campo non puo' essere vuoto se e' stato valorizzato 'al'");
					} else if (!BaseMgr.correctCronoDate(filtro.getInviatiDal(), filtro.getInviatiAl())) {
						result.getFldErrors().put("appDataricercaAce.inviatiAl",
								"Questa data non puo' essere precedente alla data 'dal'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getVDa(), filtro.getVA())) {
						result.getFldErrors().put("appDataricercaAce.vA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					//////////////////////////////////////

					if (!BaseMgr.correctSeqDoubleFour(filtro.getSuDa(), filtro.getSuA())) {
						result.getFldErrors().put("appDataricercaAce.suA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getVsuDa(), filtro.getVsuA())) {
						result.getFldErrors().put("appDataricercaAce.vsuA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getFattoreFormaDa(), filtro.getFattoreFormaA())) {
						result.getFldErrors().put("appDataricercaAce.fattoreFormaA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getTrasmSupOpacheDa(), filtro.getTrasmSupOpacheA())) {
						result.getFldErrors().put("appDataricercaAce.trasmSupOpacheA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getTrasmSupTraspDa(), filtro.getTrasmSupTraspA())) {
						result.getFldErrors().put("appDataricercaAce.trasmSupTraspA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFive(filtro.getRendMedioAcsDa(), filtro.getRendMedioAcsA())) {
						result.getFldErrors().put("appDataricercaAce.rendMedioAcsA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getRendMedioImpTermicoDa(),
							filtro.getRendMedioImpTermicoA())) {
						result.getFldErrors().put("appDataricercaAce.rendMedioImpTermicoA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getFabAcsSuDa(), filtro.getFabAcsSuA())) {
						result.getFldErrors().put("appDataricercaAce.fabAcsSuA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getIndiceEplDa(), filtro.getIndiceEplA())) {
						result.getFldErrors().put("appDataricercaAce.indiceEplA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getEpglNrenGlobaleDa(), filtro.getEpglNrenGlobaleA())) {
						result.getFldErrors().put("appDataricercaAce.epglNrenGlobaleA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getEpglRenGlobaleDa(), filtro.getEpglRenGlobaleA())) {
						result.getFldErrors().put("appDataricercaAce.epglRenGlobaleA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getEmissioniCo2Da(), filtro.getEmissioniCo2A())) {
						result.getFldErrors().put("appDataricercaAce.emissioniCo2A",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getSupRaffrescataDa(), filtro.getSupRaffrescataA())) {
						result.getFldErrors().put("appDataricercaAce.supRaffrescataA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getSupRiscaldataDa(), filtro.getSupRiscaldataA())) {
						result.getFldErrors().put("appDataricercaAce.supRiscaldataA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getVolLordoRaffrescatoDa(),
							filtro.getVolLordoRaffrescatoA())) {
						result.getFldErrors().put("appDataricercaAce.volLordoRaffrescatoA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getVolLordoRiscaldatoDa(),
							filtro.getVolLordoRiscaldatoA())) {
						result.getFldErrors().put("appDataricercaAce.volLordoRiscaldatoA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getEphDa(), filtro.getEphA())) {
						result.getFldErrors().put("appDataricercaAce.ephA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getAsolAsupDa(), filtro.getAsolAsupA())) {
						result.getFldErrors().put("appDataricercaAce.asolAsupA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getYieDa(), filtro.getYieA())) {
						result.getFldErrors().put("appDataricercaAce.yieA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getVSuRaffDa(), filtro.getVSuRaffA())) {
						result.getFldErrors().put("appDataricercaAce.vSuRaffA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getVSuRiscDa(), filtro.getVSuRiscA())) {
						result.getFldErrors().put("appDataricercaAce.vSuRiscA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getSVRaffDa(), filtro.getSVRaffA())) {
						result.getFldErrors().put("appDataricercaAce.sVRaffA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

					if (!BaseMgr.correctSeqDoubleFour(filtro.getSVRiscDa(), filtro.getSVRiscA())) {
						result.getFldErrors().put("appDataricercaAce.sVRiscA",
								"Questo valore non puo' essere inferiore al valore 'da'");
					}

				}

				if (result.getFldErrors().isEmpty() && result.getGlobalErrors().isEmpty()) {

					Integer countAce = getAceMgr().findElencoAceByFiltroCount(filtro);

					if (countAce != null && countAce > 0) {

						Integer numMax = getAceMgr().getNumeroMaxAce();

						if (countAce < numMax) {

							ArrayList<Ace> aceList = getAceMgr().findElencoAceByFiltro(filtro);

							theModel.setAppDataaceList(aceList);

							// impostazione del result code
							result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__OK);
						} else {
							result.getGlobalErrors().add("Sono stati estratti " + countAce
									+ " record. E' necessario restringere il campo della ricerca. Il massimo consentito e' "
									+ numMax + " record.");

							result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
						}
					} else {
						result.getGlobalErrors().add("Nessun A.P.E. trovato");

						result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
					}
				} else {
					// impostazione del result code
					result.setResultCode(RICERCAACEBYFILTRO_OUTCOME_CODE__KO);
				}
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAceByFiltro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboInit definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciComboInit(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-176974106) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.info("Prima di recuperare url Maps");
			SiceeTParametri param = aceMgr.getSiceeTParametriDao().findByPrimaryKey(Constants.LINK_MAPPA_WMS);

			if (param != null) {
				theModel.setAppDatamappaUrl(param.getValore());
			}

			log.debug("PASSO 1 - gestisciComboInit");
			gestisciComboDtCatasto(theModel);
			log.debug("PASSO 2 - gestisciComboInit");

			loadComboMotivazioneRilascio2015(theModel);
			log.debug("PASSO 3 - gestisciComboInit");

			loadComboClasseEnergetica2015(theModel);

			log.debug("PASSO 4 - gestisciComboInit");

			loadComboDestinazioneUso2015(theModel);
			log.debug("PASSO 5 - gestisciComboInit");

			// impostazione del result code 
			result.setResultCode(GESTISCICOMBOINIT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciVisRuolo definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciVisRuolo(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIVISRUOLO_OUTCOME_CODE__LETTORE = //NOSONAR  Reason:EIAS
				"LETTORE"; //NOSONAR  Reason:EIAS
		final String GESTISCIVISRUOLO_OUTCOME_CODE__ALL = //NOSONAR  Reason:EIAS
				"ALL"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1528151877) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UserInfo user = theModel.getAppDatacurrentUser();

			log.debug("STAMPO il RUOLO: " + user.getRuolo());
			log.debug("STAMPO il COD RUOLO: " + user.getCodRuolo());

			if (user.getRuolo().equalsIgnoreCase(Constants.LABEL_RUOLO_LETTORE_CTU_ESTERNI)) {
				// impostazione del result code 
				result.setResultCode(GESTISCIVISRUOLO_OUTCOME_CODE__LETTORE);

			} else {
				// impostazione del result code 
				result.setResultCode(GESTISCIVISRUOLO_OUTCOME_CODE__ALL);

			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciVisRuolo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciCombo definito in un ExecCommand del
	 * ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciCombo(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R129722134) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			gestisciComboDtCatasto(theModel);

			FiltroRicercaAce filtro = theModel.getAppDataricercaAce();

			if (filtro != null && filtro.getFlgIsOld()) {
				loadComboMotivazioneRilascio(theModel);
				loadComboClasseEnergetica(theModel);
				loadComboDestinazioneUso(theModel);
			} else {
				loadComboMotivazioneRilascio2015(theModel);
				loadComboClasseEnergetica2015(theModel);
				loadComboDestinazioneUso2015(theModel);
			}

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
	/*PROTECTED REGION ID(R1524485308) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private AceMgr aceMgr;

	public AceMgr getAceMgr() {
		return aceMgr;
	}

	public void setAceMgr(AceMgr aceMgr) {
		this.aceMgr = aceMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	private void gestisciComboDtCatasto(CpRicercaAceModel theModel) throws BEException {

		log.debug("PASSO 1 - gestisciComboDtCatasto");
		FiltroRicercaAce filtro = theModel.getAppDataricercaAce();
		log.debug("PASSO 2 - gestisciComboDtCatasto");

		ArrayList<Provincia> province = new ArrayList<Provincia>();
		province = getSOAIntegrationMgr().getProvinceByPiemonte();
		theModel.setAppDataprovince(province);
		log.debug("PASSO 3 - gestisciComboDtCatasto");

		String actProvSel = null;
		if (filtro == null) {
			filtro = new FiltroRicercaAce();
			log.debug("PASSO 3.1 - gestisciComboDtCatasto");

			filtro.setStato(Constants.INVIATO_ANNULLATO);

			log.debug("PASSO 3.2 - gestisciComboDtCatasto");

			filtro.setFlgIsOld(false);
			theModel.setAppDataricercaAce(filtro);
		} else {
			actProvSel = filtro.getCodProvincia();
		}
		log.debug("PASSO 4 - gestisciComboDtCatasto");

		//String actProvSel = filtro != null ? filtro.getCodProvincia() : null;
		ArrayList<Comune> comuni = new ArrayList<Comune>();
		log.debug("PASSO 5 - gestisciComboDtCatasto");

		if (!GenericUtil.isNullOrEmpty(actProvSel)) {
			comuni = getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		}
		log.debug("PASSO 6 - gestisciComboDtCatasto");

		theModel.setAppDatacomuni(comuni);
	}

	private void loadComboMotivazioneRilascio(CpRicercaAceModel theModel) throws BEException {
		theModel.setAppDatamotivazioneRilascio(getAceMgr().getAllMotiviRilascioOld());
	}

	private void loadComboMotivazioneRilascio2015(CpRicercaAceModel theModel) throws BEException {
		theModel.setAppDatamotivazioneRilascio(getAceMgr().getAllMotiviRilascio2015());
	}

	private void loadComboClasseEnergetica(CpRicercaAceModel theModel) throws BEException {
		theModel.setAppDataclasseEnergetica(getAceMgr().getAllClasseEnergeticaOld());
	}

	private void loadComboClasseEnergetica2015(CpRicercaAceModel theModel) throws BEException {
		theModel.setAppDataclasseEnergetica(getAceMgr().getAllClasseEnergetica2015());
	}

	private void loadComboDestinazioneUso(CpRicercaAceModel theModel) throws BEException {
		theModel.setAppDatadestinazioneUso(getAceMgr().getAllDestinazioneUso());
	}

	private void loadComboDestinazioneUso2015(CpRicercaAceModel theModel) throws BEException {
		theModel.setAppDatadestinazioneUso(getAceMgr().getAllDestinazioneUso2015());
	}

	private void pulisciCampiApeOld(CpRicercaAceModel theModel) throws BEException {

		FiltroRicercaAce filtro = theModel.getAppDataricercaAce();

		filtro.setClassiEnergeticheSelez(null);
		filtro.setDestinazioniUsoSelez(null);
		filtro.setCodMotivoRilascio(null);
		filtro.setVDa(null);
		filtro.setVA(null);
		filtro.setSuDa(null);
		filtro.setSuA(null);
		filtro.setVsuDa(null);
		filtro.setVsuA(null);
		filtro.setFattoreFormaDa(null);
		filtro.setFattoreFormaA(null);
		filtro.setTrasmSupOpacheDa(null);
		filtro.setTrasmSupOpacheA(null);
		filtro.setTrasmSupTraspDa(null);
		filtro.setTrasmSupTraspA(null);
		filtro.setFlgFabbisognoSupIndice(null);
		filtro.setRendMedioAcsDa(null);
		filtro.setRendMedioAcsA(null);
		filtro.setRendMedioImpTermicoDa(null);
		filtro.setRendMedioImpTermicoA(null);
		filtro.setFabAcsSuDa(null);
		filtro.setFabAcsSuA(null);
		filtro.setIndiceEplDa(null);
		filtro.setIndiceEplA(null);
		filtro.setFlgFabbisognoAcsDiverso(null);

	}

	private void pulisciCampiApeNew(CpRicercaAceModel theModel) throws BEException {

		FiltroRicercaAce filtro = theModel.getAppDataricercaAce();

		filtro.setClassiEnergeticheSelez(null);
		filtro.setDestinazioniUsoSelez(null);
		filtro.setCodMotivoRilascio(null);
		filtro.setFlgEdifE0(null);
		filtro.setEpglNrenGlobaleDa(null);
		filtro.setEpglNrenGlobaleA(null);
		filtro.setEpglRenGlobaleDa(null);
		filtro.setEpglRenGlobaleA(null);
		filtro.setEmissioniCo2Da(null);
		filtro.setEmissioniCo2A(null);
		filtro.setSupRaffrescataDa(null);
		filtro.setSupRaffrescataA(null);
		filtro.setSupRiscaldataDa(null);
		filtro.setSupRiscaldataA(null);
		filtro.setVolLordoRaffrescatoDa(null);
		filtro.setVolLordoRaffrescatoA(null);
		filtro.setVolLordoRiscaldatoDa(null);
		filtro.setVolLordoRiscaldatoA(null);
		filtro.setEphDa(null);
		filtro.setEphA(null);
		filtro.setAsolAsupDa(null);
		filtro.setAsolAsupA(null);
		filtro.setYieDa(null);
		filtro.setYieA(null);
		filtro.setVSuRaffDa(null);
		filtro.setVSuRaffA(null);
		filtro.setVSuRiscDa(null);
		filtro.setVSuRiscA(null);
		filtro.setSVRaffDa(null);
		filtro.setSVRaffA(null);
		filtro.setSVRiscDa(null);
		filtro.setSVRiscA(null);

	}

	private boolean checkFiltroAce(FiltroRicercaAce filtro, ExecResults result) {
		int errors = 0;
		if (!GenericUtil.checkValideFourNumber(filtro.getAnnoCertificato())) {
			errors++;
		}
		if (!GenericUtil.checkValideSixNumber(filtro.getCertificatore())) {
			errors++;
		}
		if (!GenericUtil.checkValideFourNumber(filtro.getProgCertificato())) {
			errors++;
		}

		if (errors > 0) {
			result.getGlobalErrors().add("Tutti i campi sono obbligatori e numerici.");
			return false;
		}

		return true;
	}

	//	public boolean checkValideFourNumber(String num) {
	//		if (!isNullOrEmpty(num)) {
	//			if (num.matches("^[0-9]{4}"))
	//				return true;
	//			else
	//				return false;
	//		}
	//
	//		return false;
	//	}

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
