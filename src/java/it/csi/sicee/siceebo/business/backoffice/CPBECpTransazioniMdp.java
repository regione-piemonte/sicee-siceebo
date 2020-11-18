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

/*PROTECTED REGION ID(R-459289811) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.BackOfficeMgr;

/*PROTECTED REGION END*/

public class CPBECpTransazioniMdp {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [filtroDettaglioTransAttEsito, scope:USER_SESSION]
	public static final String APPDATA_FILTRODETTAGLIOTRANSATTESITO_CODE = "appDatafiltroDettaglioTransAttEsito";

	// ApplicationData: [resocontoTransMdp, scope:USER_SESSION]
	public static final String APPDATA_RESOCONTOTRANSMDP_CODE = "appDataresocontoTransMdp";

	// ApplicationData: [dettaglioTransAttEsito, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOTRANSATTESITO_CODE = "appDatadettaglioTransAttEsito";

	// ApplicationData: [idTransazioniSel, scope:USER_SESSION]
	public static final String APPDATA_IDTRANSAZIONISEL_CODE = "appDataidTransazioniSel";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpTransazioniMdp";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaTransazioni definito in un ExecCommand del
	 * ContentPanel cpTransazioniMdp
	 */
	public ExecResults cercaTransazioni(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCATRANSAZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CERCATRANSAZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R857748538) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Entro in cercaTransazioni");

			log.debug("Entro in cercaTransazioni getBackOfficeMgr(): " + getBackOfficeMgr());

			ResocontoTransMdp resoconto = getBackOfficeMgr().findResocontoTransazioniMdp();

			log.debug("Cerco resoconti: " + resoconto);

			FiltroDettaglioTransAttEsito filtro = theModel.getAppDatafiltroDettaglioTransAttEsito();

			ArrayList<DettaglioTransAttEsito> attEsitoList = getBackOfficeMgr().findDettaglioTransAttEsito(filtro);

			log.debug("Cerco attEsitoList: " + attEsitoList);

			theModel.setAppDataresocontoTransMdp(resoconto);
			theModel.setAppDatadettaglioTransAttEsito(attEsitoList);

			// impostazione del result code 
			result.setResultCode(CERCATRANSAZIONI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaTransazioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo annullaTransazioni definito in un ExecCommand del
	 * ContentPanel cpTransazioniMdp
	 */
	public ExecResults annullaTransazioni(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ANNULLATRANSAZIONI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String ANNULLATRANSAZIONI_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1896984391) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			getBackOfficeMgr().annullaTranazioniUnsuccessfull();

			ResocontoTransMdp resoconto = getBackOfficeMgr().findResocontoTransazioniMdp();

			FiltroDettaglioTransAttEsito filtro = theModel.getAppDatafiltroDettaglioTransAttEsito();

			ArrayList<DettaglioTransAttEsito> attEsitoList = getBackOfficeMgr().findDettaglioTransAttEsito(filtro);

			theModel.setAppDataresocontoTransMdp(resoconto);
			theModel.setAppDatadettaglioTransAttEsito(attEsitoList);

			// impostazione del result code 
			result.setResultCode(ANNULLATRANSAZIONI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::annullaTransazioni] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaTransMdp definito in un ExecCommand del
	 * ContentPanel cpTransazioniMdp
	 */
	public ExecResults verificaTransMdp(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICATRANSMDP_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String VERIFICATRANSMDP_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-744920746) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				ArrayList<DettaglioTransAttEsito> attEsitoList = theModel.getAppDatadettaglioTransAttEsito();

				ArrayList<String> idTransazioniSel = theModel.getAppDataidTransazioniSel();

				if (idTransazioniSel != null && idTransazioniSel.size() > 0) {

					log.debug("verificaTransMdp - PASSO1");
					// Devo verificare tutte le transazioni
					String[] msgErrorList = getBackOfficeMgr().aggiornaTransEsito(idTransazioniSel, attEsitoList);

					log.debug("verificaTransMdp - PASSO2: " + msgErrorList);

					if (msgErrorList != null && msgErrorList.length > 0) {
						log.debug("verificaTransMdp - Setto il messaggio KOK");

						String msgError = GenericUtil.getMessaggiFormattatiHtml(msgErrorList);
						result.getGlobalErrors().add(msgError);
					} else {

						log.debug("verificaTransMdp - Setto il messaggio OK");
						result.getGlobalMessages().add("Verifica avvenuta correttamente");
					}

					ResocontoTransMdp resoconto = getBackOfficeMgr().findResocontoTransazioniMdp();

					FiltroDettaglioTransAttEsito filtro = theModel.getAppDatafiltroDettaglioTransAttEsito();

					attEsitoList = getBackOfficeMgr().findDettaglioTransAttEsito(filtro);

					theModel.setAppDataresocontoTransMdp(resoconto);
					theModel.setAppDatadettaglioTransAttEsito(attEsitoList);

				} else {
					result.getGlobalErrors().add("Selezionare un elemento della tabella.");

					result.setResultCode(VERIFICATRANSMDP_OUTCOME_CODE__KO);
				}
				// impostazione del result code 
				result.setResultCode(VERIFICATRANSMDP_OUTCOME_CODE__OK);
			} catch (Exception ex) {
				result.getGlobalErrors().add("Si e' verificato un problema nella verifica delle transazioni");
				// impostazione del result code 
				result.setResultCode(VERIFICATRANSMDP_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaTransMdp] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo recuperaRT definito in un ExecCommand del
	 * ContentPanel cpTransazioniMdp
	 */
	public ExecResults recuperaRT(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String RECUPERART_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String RECUPERART_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R503208451) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			try {

				ArrayList<String> idTransazioniSel = theModel.getAppDataidTransazioniSel();

				if (idTransazioniSel != null && idTransazioniSel.size() > 0) {
					ArrayList<DettaglioTransAttEsito> attEsitoList = theModel.getAppDatadettaglioTransAttEsito();

					// Devo verificare tutte le transazioni
					String[] msgErrorList = getBackOfficeMgr().recuperaRT(idTransazioniSel, attEsitoList);

					if (msgErrorList != null && msgErrorList.length > 0) {
						String msgError = GenericUtil.getMessaggiFormattatiHtml(msgErrorList);
						result.getGlobalErrors().add(msgError);
					}

					ResocontoTransMdp resoconto = getBackOfficeMgr().findResocontoTransazioniMdp();

					FiltroDettaglioTransAttEsito filtro = theModel.getAppDatafiltroDettaglioTransAttEsito();

					attEsitoList = getBackOfficeMgr().findDettaglioTransAttEsito(filtro);

					theModel.setAppDataresocontoTransMdp(resoconto);
					theModel.setAppDatadettaglioTransAttEsito(attEsitoList);

					// impostazione del result code 
					result.setResultCode(RECUPERART_OUTCOME_CODE__OK);

				} else {
					result.getGlobalErrors().add("Selezionare un elemento della tabella.");

					result.setResultCode(RECUPERART_OUTCOME_CODE__KO);
				}
			} catch (Exception ex) {
				result.getGlobalErrors().add("Si e' verificato un problema nella verifica delle transazioni");
				// impostazione del result code 
				result.setResultCode(RECUPERART_OUTCOME_CODE__KO);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::recuperaRT] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cercaTransazioniInit definito in un ExecCommand del
	 * ContentPanel cpTransazioniMdp
	 */
	public ExecResults cercaTransazioniInit(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CERCATRANSAZIONIINIT_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R430256650) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("Entro in cercaTransazioni");

			log.debug("Entro in cercaTransazioni getBackOfficeMgr(): " + getBackOfficeMgr());

			ResocontoTransMdp resoconto = getBackOfficeMgr().findResocontoTransazioniMdp();

			log.debug("Cerco resoconti: " + resoconto);

			FiltroDettaglioTransAttEsito filtro = new FiltroDettaglioTransAttEsito();
			filtro.setIdTipoRicerca(Constants.ID_STATO_TRANS_MDP_NEW_ATTESA_RT);

			theModel.setAppDatafiltroDettaglioTransAttEsito(filtro);

			ArrayList<DettaglioTransAttEsito> attEsitoList = getBackOfficeMgr().findDettaglioTransAttEsito(filtro);

			log.debug("Cerco attEsitoList: " + attEsitoList);

			theModel.setAppDataresocontoTransMdp(resoconto);
			theModel.setAppDatadettaglioTransAttEsito(attEsitoList);

			// impostazione del result code 
			result.setResultCode(CERCATRANSAZIONIINIT_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cercaTransazioniInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * permette di resettare lo stato di paginazione della tabella widg_tblDettTransAttEsito
	 */
	public static void resetClearStatus_widg_tblDettTransAttEsito(java.util.Map session) {
		session.put("cpTransazioniMdp_tblDettTransAttEsito_clearStatus", Boolean.TRUE);
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-114734617) ENABLED START*/
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
