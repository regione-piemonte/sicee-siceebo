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

/*PROTECTED REGION ID(R-197597362) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.AceMgr;
import it.csi.sicee.siceebo.business.facade.CertificatoMgr;
/*PROTECTED REGION END*/

public class CPBECpAnnullaAce {

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

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	// ApplicationData: [annullamentoApe, scope:USER_SESSION]
	public static final String APPDATA_ANNULLAMENTOAPE_CODE = "appDataannullamentoApe";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpAnnullaAce";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaCerificato definito in un ExecCommand del
	 * ContentPanel cpAnnullaAce
	 */
	public ExecResults annullaCerificato(

			it.csi.sicee.siceebo.dto.ricercaace.CpAnnullaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLACERIFICATO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLACERIFICATO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2014240823) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			if (GenericUtil.isNullOrEmpty(theModel.getAppDataannullamentoApe().getMotivazione())) {
				result.getFldErrors().put("appDataannullamentoApe.motivazione", "il campo e' obbligatorio");

				result.setResultCode(ANNULLACERIFICATO_OUTCOME_CODE__KO);

			} else if (theModel.getAppDataannullamentoApe().getMotivazione().trim()
					.length() > Constants.LUNGHEZZA_MASSIMA_NOTE) {
				result.getGlobalErrors().add("Il campo Motivazione puo' essere al massimo di "
						+ Constants.LUNGHEZZA_MASSIMA_NOTE + " caratteri");
			} else {
				String codiceCertificato = theModel.getAppDatacodAceSelezionato();

				boolean isAttestatoOld = getAceMgr().isAttestatoOld(codiceCertificato);

				Ace ace = getAceMgr().findAce(codiceCertificato, isAttestatoOld);

				String cfUtente = theModel.getAppDatacurrentUser().getCodFisc();

				getCertificatoMgr().aggiornaStatoAnnullato(ace, theModel.getAppDataannullamentoApe(), codiceCertificato,
						cfUtente, isAttestatoOld);

				FiltroRicercaAce filtro = theModel.getAppDataricercaAce();

				ArrayList<Ace> aceList = null;
				if (filtro.getFlgIsRicCodice()) {
					// devo rifare la ricerca
					aceList = getAceMgr().findElencoAceByCodice(filtro);
				} else {
					// devo rifare la ricerca
					aceList = getAceMgr().findElencoAceByFiltro(filtro);
				}

				if (aceList != null && aceList.size() > 0) {
					theModel.setAppDataaceList(aceList);
				}

				result.getGlobalMessages().add("Certificato annullato correttamente.");

				theModel.setAppDatamsgGenerico("Certificato annullato correttamente.");

				// impostazione del result code 
				result.setResultCode(ANNULLACERIFICATO_OUTCOME_CODE__OK);
			}

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaCerificato] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciRitorno definito in un ExecCommand del
	 * ContentPanel cpAnnullaAce
	 */
	public ExecResults gestisciRitorno(

			it.csi.sicee.siceebo.dto.ricercaace.CpAnnullaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCIRITORNO_OUTCOME_CODE__RIC_APE = //NOSONAR  Reason:EIAS
				"RIC_APE"; //NOSONAR  Reason:EIAS
		final String GESTISCIRITORNO_OUTCOME_CODE__RIC_APE_CERT = //NOSONAR  Reason:EIAS
				"RIC_APE_CERT"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-41990183) ENABLED START*/
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
	 * Implementazione del metodo initDatiAnnullamento definito in un ExecCommand del
	 * ContentPanel cpAnnullaAce
	 */
	public ExecResults initDatiAnnullamento(

			it.csi.sicee.siceebo.dto.ricercaace.CpAnnullaAceModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITDATIANNULLAMENTO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1295689817) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			Annullamento annullamento = new Annullamento();
			annullamento.setIdMotivo(Constants.ID_MOTIVO_ANNULLATO_BO);
			annullamento.setData(GenericUtil.getDataOdierna());

			log.debug("Stampo la data che ho settato: " + annullamento.getData());

			theModel.setAppDataannullamentoApe(annullamento);

			// impostazione del result code 
			result.setResultCode(INITDATIANNULLAMENTO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initDatiAnnullamento] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-2036199514) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...) 
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
	/*PROTECTED REGION END*/
}
