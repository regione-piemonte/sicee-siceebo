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

/*PROTECTED REGION ID(R1241992379) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.CertificatoreMgr;
import it.csi.sicee.siceebo.business.facade.CertificatoMgr;
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.business.facade.AceMgr;
import it.csi.sicee.siceebo.business.facade.BaseMgr;
import it.csi.sicee.siceebo.util.GenericUtil;
/*PROTECTED REGION END*/

public class CPBECpDettaglioCertificatore {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [idCertificatoreSel, scope:USER_SESSION]
	public static final String APPDATA_IDCERTIFICATORESEL_CODE = "appDataidCertificatoreSel";

	// ApplicationData: [elencoMotivazioniBlocco, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMOTIVAZIONIBLOCCO_CODE = "appDataelencoMotivazioniBlocco";

	// ApplicationData: [certificatoreDett, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATOREDETT_CODE = "appDatacertificatoreDett";

	// ApplicationData: [certificatoreList, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORELIST_CODE = "appDatacertificatoreList";

	// ApplicationData: [chiaviCurriculum, scope:USER_SESSION]
	public static final String APPDATA_CHIAVICURRICULUM_CODE = "appDatachiaviCurriculum";

	// ApplicationData: [chiaviTitoloStudio, scope:USER_SESSION]
	public static final String APPDATA_CHIAVITITOLOSTUDIO_CODE = "appDatachiaviTitoloStudio";

	// ApplicationData: [chiaviAttPartNew, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTNEW_CODE = "appDatachiaviAttPartNew";

	// ApplicationData: [chiaviAttPartOld, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTOLD_CODE = "appDatachiaviAttPartOld";

	// ApplicationData: [uidDaStampare, scope:USER_SESSION]
	public static final String APPDATA_UIDDASTAMPARE_CODE = "appDatauidDaStampare";

	// ApplicationData: [ricercaAce, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACE_CODE = "appDataricercaAce";

	// ApplicationData: [aceList, scope:USER_SESSION]
	public static final String APPDATA_ACELIST_CODE = "appDataaceList";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [annullamentoApe, scope:USER_SESSION]
	public static final String APPDATA_ANNULLAMENTOAPE_CODE = "appDataannullamentoApe";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDettaglioCertificatore";

	public static final String TABSET_TSPDETTCERT = "tspDettCert";
	public static final String TAB_TSPDETTCERT_FPDATIGENERALI = CPNAME + "_" + TABSET_TSPDETTCERT + "_"
			+ "fpDatiGenerali";
	public static final String TAB_TSPDETTCERT_FPTITOLOSTUDIO = CPNAME + "_" + TABSET_TSPDETTCERT + "_"
			+ "fpTitoloStudio";
	public static final String TAB_TSPDETTCERT_FPAPE = CPNAME + "_" + TABSET_TSPDETTCERT + "_" + "fpApe";

	public static final String MULTIPANEL_MPRISAPECERT = "mpRisApeCert";
	public static final String MPI_MPRISAPECERT_FPRISAPECERT = CPNAME + "_" + MULTIPANEL_MPRISAPECERT + "_"
			+ "fpRisApeCert";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo bloccaCertificatore definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults bloccaCertificatore(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String BLOCCACERTIFICATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String BLOCCACERTIFICATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1373135104) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Certificatore certificatore = theModel.getAppDatacertificatoreDett();
			String idCertificatoreSel = theModel.getAppDataidCertificatoreSel();

			log.debug("STAMPO L'ID BLOCCO CERT: " + certificatore.getIdBloccoCert());

			if (GenericUtil.isNullOrEmpty(certificatore.getIdBloccoCert())) {
				//log.debug("\n\n\n >>>>>>> BLOCCO CERT E' NULLO !!!!!");
				result.getGlobalErrors().add("Selezionare la motivazione del blocco");
				result.setResultCode(BLOCCACERTIFICATORE_OUTCOME_CODE__KO);
			} else {
				//log.debug("\n\n\n >>>>>>> BLOCCO CERT E' VALORIZZATO");
				eseguibloccaCertificatore(idCertificatoreSel, certificatore.getIdBloccoCert(),
						certificatore.getNoteBloccoCert(), certificatore.getNome(), certificatore.getCognome(),
						certificatore.getEmail());
				certificatore = recuperaCertificatoreDett(idCertificatoreSel);

				aggiornaListaCertificatori(theModel.getAppDatacertificatoreList(), idCertificatoreSel,
						certificatore.getDescBloccoCert());

				theModel.setAppDatacertificatoreDett(certificatore);

				result.getGlobalMessages().add("Certificatore bloccato correttamente");

				result.setResultCode(BLOCCACERTIFICATORE_OUTCOME_CODE__OK);
			}
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::bloccaCertificatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo sbloccaCertificatore definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults sbloccaCertificatore(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SBLOCCACERTIFICATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SBLOCCACERTIFICATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1139171173) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			Certificatore certificatore = theModel.getAppDatacertificatoreDett();
			String idCertificatoreSel = theModel.getAppDataidCertificatoreSel();
			/*
			if (!GenericUtil.isNullOrEmpty(certificatore.getBloccoCert())) {
				result.getGlobalErrors().add("Annullare la motivazione del blocco");
			} else {
				sbloccaCertificatore(idCertificatoreSel);
				theModel.setAppDatacertificatoreDett(certificatore);
			}
			 */
			eseguisbloccaCertificatore(idCertificatoreSel, certificatore.getNoteBloccoCert(), certificatore.getNome(),
					certificatore.getCognome(), certificatore.getEmail());

			certificatore = recuperaCertificatoreDett(idCertificatoreSel);

			aggiornaListaCertificatori(theModel.getAppDatacertificatoreList(), idCertificatoreSel,
					Constants.LABEL_NON_BLOCCATO);

			theModel.setAppDatacertificatoreDett(certificatore);

			result.getGlobalMessages().add("Certificatore sbloccato correttamente");

			result.setResultCode(SBLOCCACERTIFICATORE_OUTCOME_CODE__OK);

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::sbloccaCertificatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo inizializzaRicApeCert definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults inizializzaRicApeCert(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INIZIALIZZARICAPECERT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R67648020) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// prova - inizio
			//			Map prova = theModel.getSession();
			//			Set keySet = prova.keySet();
			//			for (Object object : keySet) {
			//				log.debug("Stampo il keyset: "+object);
			//				log.debug("Stampo il valore: "+prova.get(object));
			//			}
			// prova fine

			Certificatore certificatore = theModel.getAppDatacertificatoreDett();
			FiltroRicercaAce filtro = new FiltroRicercaAce();
			filtro.setNumMatricola(certificatore.getMatricola());
			filtro.setStato(Constants.INVIATO_ANNULLATO);
			//filtro.setFlgIsOld(false);
			theModel.setAppDataricercaAce(filtro);

			// impostazione del result code 
			result.setResultCode(INIZIALIZZARICAPECERT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::inizializzaRicApeCert] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaTitoloStudio definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults scaricaTitoloStudio(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICATITOLOSTUDIO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R790659433) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n>>>>>>> uid del documento preso da idRiga: " + theModel.getIdRiga());
			String uid = theModel.getIdRiga();

			theModel.setAppDatauidDaStampare(uid);

			// impostazione del result code 
			result.setResultCode(SCARICATITOLOSTUDIO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scaricaTitoloStudio] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaCurriculumVitae definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults scaricaCurriculumVitae(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICACURRICULUMVITAE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1048256732) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n>>>>>>> uid del documento preso da idRiga: " + theModel.getIdRiga());
			String uid = theModel.getIdRiga();

			theModel.setAppDatauidDaStampare(uid);

			// impostazione del result code 
			result.setResultCode(SCARICACURRICULUMVITAE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scaricaCurriculumVitae] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaAttestatoPartecipazioneNew definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults scaricaAttestatoPartecipazioneNew(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICAATTESTATOPARTECIPAZIONENEW_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1135094935) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n>>>>>>> uid del documento preso da idRiga: " + theModel.getIdRiga());
			String uid = theModel.getIdRiga();

			theModel.setAppDatauidDaStampare(uid);

			// impostazione del result code 
			result.setResultCode(SCARICAATTESTATOPARTECIPAZIONENEW_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::scaricaAttestatoPartecipazioneNew] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scaricaAttestatoPartecipazioneOld definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults scaricaAttestatoPartecipazioneOld(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCARICAATTESTATOPARTECIPAZIONEOLD_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-43457424) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n>>>>>>> uid del documento preso da idRiga: " + theModel.getIdRiga());
			String uid = theModel.getIdRiga();

			theModel.setAppDatauidDaStampare(uid);

			// impostazione del result code 
			result.setResultCode(SCARICAATTESTATOPARTECIPAZIONEOLD_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error(
					"[BackEndFacade::scaricaAttestatoPartecipazioneOld] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo ricercaAceCertByFiltro definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults ricercaAceCertByFiltro(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RICERCAACECERTBYFILTRO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RICERCAACECERTBYFILTRO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1966558769) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			boolean ok = true;
			FiltroRicercaAce filtro = theModel.getAppDataricercaAce();
			theModel.getAppDataricercaAce().setFlgIsRicCodice(false);

			//			UserInfo user = theModel.getAppDatacurrentUser();

			GenericUtil.stampa(filtro, true, 4);

			if (GenericUtil.isNullOrEmpty(filtro.getInviatiDal()) && GenericUtil.isNullOrEmpty(filtro.getInviatiAl())
					&& GenericUtil.isNullOrEmpty(filtro.getInviatiAnno())) {
				result.getGlobalErrors().add("E' necessario impostare almeno un filtro di ricerca");
				result.setResultCode(RICERCAACECERTBYFILTRO_OUTCOME_CODE__KO);
			} else {

				if (!GenericUtil.isNullOrEmpty(filtro.getInviatiAnno())
						&& !GenericUtil.checkValideFourNumber(filtro.getInviatiAnno())) {
					result.getFldErrors().put("appDataricercaAce.inviatiAnno", "Il campo deve essere di 4 cifre");
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

			}

			if (result.getFldErrors().isEmpty() && result.getGlobalErrors().isEmpty()) {

				Integer countAce = getAceMgr().findElencoAceByFiltroCount(filtro);

				if (countAce != null && countAce > 0) {

					Integer numMax = getAceMgr().getNumeroMaxAce();

					if (countAce < numMax) {

						ArrayList<Ace> aceList = getAceMgr().findElencoAceByFiltro(filtro);

						theModel.setAppDataaceList(aceList);

						// impostazione del result code
						result.setResultCode(RICERCAACECERTBYFILTRO_OUTCOME_CODE__OK);
					} else {
						result.getGlobalErrors().add("Sono stati estratti " + countAce
								+ " record. E' necessario restringere il campo della ricerca. Il massimo consentito e' "
								+ numMax + " record.");

						result.setResultCode(RICERCAACECERTBYFILTRO_OUTCOME_CODE__KO);
					}
				} else {
					result.getGlobalErrors().add("Nessun A.P.E. trovato");

					result.setResultCode(RICERCAACECERTBYFILTRO_OUTCOME_CODE__KO);
				}
			} else {
				// impostazione del result code
				result.setResultCode(RICERCAACECERTBYFILTRO_OUTCOME_CODE__KO);
			}

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::ricercaAceCertByFiltro] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo preparaScaricoModulo definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO = //NOSONAR  Reason:EIAS
				"ATTESTATO"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__RICEVUTA = //NOSONAR  Reason:EIAS
				"RICEVUTA"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__TRACCIATO_XML = //NOSONAR  Reason:EIAS
				"TRACCIATO_XML"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__TRACCIATO_XML_ASSENTE = //NOSONAR  Reason:EIAS
				"TRACCIATO_XML_ASSENTE"; //NOSONAR  Reason:EIAS
		final String PREPARASCARICOMODULO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-752714951) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getIdRiga();

			if (GenericUtil.isNullOrEmpty(codiceCertificato)
					|| !GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDataaceList())) {

				result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__KO);

			} else {
				theModel.setAppDatacodAttestatoDaStampare(codiceCertificato);

				if (theModel.getIdColonna().equals("flgModulo")) {
					result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__ATTESTATO);
				} else if (theModel.getIdColonna().equals("flgRicevuta")) {
					result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__RICEVUTA);
				} else if (theModel.getIdColonna().equals("flgTracciato")) {

					log.debug("numeroCertificato: " + theModel.getIdRiga());

					String[] split = theModel.getIdRiga().split(" ");

					String idCertificatore = getCertificatoreMgr().findIdCertificatoreFromNumCertificatore(split[1]);
					String progrCertificato = split[2];
					String anno = split[0];

					log.debug("idCertificatore: " + idCertificatore);
					log.debug("progrCertificato: " + progrCertificato);
					log.debug("anno: " + anno);

					boolean isImport = getCertificatoMgr().isImportDati2015(idCertificatore, progrCertificato, anno);

					log.debug("isImport: " + isImport);

					if (isImport) {
						result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__TRACCIATO_XML);

					} else {
						result.getGlobalErrors().add(
								"L'A.P.E. selezionato non e' frutto di un import XML con dati di calcolo associati");

						// Devo mettere un messaggio
						result.setResultCode(PREPARASCARICOMODULO_OUTCOME_CODE__TRACCIATO_XML_ASSENTE);

					}

				}
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::preparaScaricoModulo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo stampaReport definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String STAMPAREPORT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String STAMPAREPORT_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1640178162) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)
					&& GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDataaceList())) {

				theModel.setAppDatapaginaProvenienza(Constants.PAGINA_RICERCA_APE_CERTIFICATORE);

				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__OK);

			} else {
				theModel.setAppDatacodAceSelezionato(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");

				result.setResultCode(STAMPAREPORT_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::stampaReport] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaApe definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults annullaApe(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLAAPE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLAAPE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1842064919) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String codiceCertificato = theModel.getAppDatacodAceSelezionato();

			if (!GenericUtil.isNullOrEmpty(codiceCertificato)
					&& GenericUtil.isCertificatoPresente(codiceCertificato, theModel.getAppDataaceList())) {

				boolean isAttestatoOld = getAceMgr().isAttestatoOld(codiceCertificato);

				Ace ace = getAceMgr().findAce(codiceCertificato, isAttestatoOld);

				if (log.isDebugEnabled())
					GenericUtil.stampa(ace, true, 4);

				if (ace.getIdStato() == Constants.INVIATO) {

					theModel.setAppDatapaginaProvenienza(Constants.PAGINA_RICERCA_APE_CERTIFICATORE);

					result.setResultCode(ANNULLAAPE_OUTCOME_CODE__OK);
				} else {
					result.getGlobalErrors().add("Il certificato non e' in stato inviato.");
					result.setResultCode(ANNULLAAPE_OUTCOME_CODE__KO);
				}
			} else {
				theModel.setAppDatacodAceSelezionato(null);

				result.getGlobalErrors().add("Selezionare un elemento della tabella.");

				result.setResultCode(ANNULLAAPE_OUTCOME_CODE__KO);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaApe] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initDettaglioCertificatore definito in un ExecCommand del
	 * ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults initDettaglioCertificatore(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITDETTAGLIOCERTIFICATORE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String INITDETTAGLIOCERTIFICATORE_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R564367175) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("ON ENTER :: initDettaglioCertificatore :: inizio");
			Certificatore certificatore = null;
			String idCertificatoreSel = theModel.getAppDataidCertificatoreSel();
			certificatore = recuperaCertificatoreDett(idCertificatoreSel);
			if (certificatore == null) {
				result.setResultCode(INITDETTAGLIOCERTIFICATORE_OUTCOME_CODE__KO);
			} else {
				theModel.setAppDatacertificatoreDett(certificatore);

				ArrayList<DocumentSummary> ret = getCertificatoreMgr()
						.getDocumentiTitoloDiStudio(certificatore.getId());

				theModel.setAppDatachiaviTitoloStudio(ret);

				ArrayList<DocumentSummary> retCurr = getCertificatoreMgr().getCurriculum(certificatore.getId());

				theModel.setAppDatachiaviCurriculum(retCurr);

				ArrayList<CorsoAttestatoSummary> attNew = getCertificatoreMgr()
						.getDocumentiPartecipazioneNew(certificatore.getCodiceFiscale());

				theModel.setAppDatachiaviAttPartNew(attNew);

				ArrayList<DocumentSummary> retOld = getCertificatoreMgr()
						.getDocumentiPartecipazioneOld(certificatore.getId());

				theModel.setAppDatachiaviAttPartOld(retOld);

				result.setResultCode(INITDETTAGLIOCERTIFICATORE_OUTCOME_CODE__OK);
			}

			if (theModel.getAppDatamsgGenerico() != null) {
				result.getGlobalMessages().add(theModel.getAppDatamsgGenerico());
				theModel.setAppDatamsgGenerico(null);
			}

			log.debug("ON ENTER :: initDettaglioCertificatore :: fine");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initDettaglioCertificatore] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblTitoloStudioSummary
	 */
	public static void resetClearStatus_widg_tblTitoloStudioSummary(java.util.Map session) {
		session.put("cpDettaglioCertificatore_tblTitoloStudioSummary_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblCurriculumSummary
	 */
	public static void resetClearStatus_widg_tblCurriculumSummary(java.util.Map session) {
		session.put("cpDettaglioCertificatore_tblCurriculumSummary_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttPartNewSummary
	 */
	public static void resetClearStatus_widg_tblAttPartNewSummary(java.util.Map session) {
		session.put("cpDettaglioCertificatore_tblAttPartNewSummary_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblAttPartOldSummary
	 */
	public static void resetClearStatus_widg_tblAttPartOldSummary(java.util.Map session) {
		session.put("cpDettaglioCertificatore_tblAttPartOldSummary_clearStatus", Boolean.TRUE);
	}

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblRisultatoAceCert
	 */
	public static void resetClearStatus_widg_tblRisultatoAceCert(java.util.Map session) {
		session.put("cpDettaglioCertificatore_tblRisultatoAceCert_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R1765552793) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private AceMgr aceMgr;

	public AceMgr getAceMgr() {
		return aceMgr;
	}

	public void setAceMgr(AceMgr aceMgr) {
		this.aceMgr = aceMgr;
	}

	//	private SOAIntegrationMgr soaIntegrationMgr;
	//
	//	public SOAIntegrationMgr getSOAIntegrationMgr() {
	//		return soaIntegrationMgr;
	//	}
	//
	//	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
	//		this.soaIntegrationMgr = soaIntegrationMgr;
	//	}

	private Certificatore recuperaCertificatoreDett(String idCertificatoreSel) throws BEException {
		Certificatore certificatore = null;
		certificatore = getCertificatoreMgr().getCertificatoreDettById(idCertificatoreSel);
		return certificatore;
	}

	private void eseguibloccaCertificatore(String idCertificatoreSel, String bloccoCert, String noteBlocco,
			String nomeCert, String cognomeCert, String emailCert) throws BEException {
		getCertificatoreMgr().bloccoSbloccoCert(idCertificatoreSel, bloccoCert, noteBlocco, nomeCert, cognomeCert,
				emailCert);

	}

	private void eseguisbloccaCertificatore(String idCertificatoreSel, String noteBlocco, String nomeCert,
			String cognomeCert, String emailCert) throws BEException {
		getCertificatoreMgr().bloccoSbloccoCert(idCertificatoreSel, null, noteBlocco, nomeCert, cognomeCert, emailCert);
	}

	private void aggiornaListaCertificatori(ArrayList<Certificatore> certificatori, String idCertificatoreSel,
			String statoBloccoCert) {
		// Devo modificare la descrizione del resultSet del risultato della ricerca

		for (int i = 0; i < certificatori.size(); i++) {
			if (certificatori.get(i).getId().equals(idCertificatoreSel)) {
				// Ho trovato il certificatore selezionato, devo cambiate lo stato
				certificatori.get(i).setDescBloccoCert(statoBloccoCert);

				break;
			}

		}

		//return certificatori;
	}

	/*PROTECTED REGION END*/
}
