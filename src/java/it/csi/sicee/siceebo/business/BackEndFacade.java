package it.csi.sicee.siceebo.business;

import java.util.*;

import it.csi.sicee.siceebo.dto.*;

import org.apache.log4j.*;
import it.csi.sicee.siceebo.util.*;

/*PROTECTED REGION ID(R-1534196706) ENABLED START*/
import it.csi.sicee.siceebo.business.facade.ActivationMgr;
import it.csi.sicee.siceebo.business.facade.BackOfficeMgr;
import it.csi.sicee.siceebo.business.facade.MiscMgr;
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.iride2.iridefed.entity.Ruolo;
import it.csi.iride2.policy.entity.Identita;
/*PROTECTED REGION END*/

public class BackEndFacade {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [labelValue, scope:USER_ACTION]
	public static final String APPDATA_LABELVALUE_CODE = "appDatalabelValue";

	// ApplicationData: [paginaProvenienza, scope:USER_SESSION]
	public static final String APPDATA_PAGINAPROVENIENZA_CODE = "appDatapaginaProvenienza";

	// ApplicationData: [msgGenerico, scope:USER_SESSION]
	public static final String APPDATA_MSGGENERICO_CODE = "appDatamsgGenerico";

	// ApplicationData: [idRigaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDRIGASELEZIONATA_CODE = "appDataidRigaSelezionata";

	// ApplicationData: [mappaUrl, scope:USER_ACTION]
	public static final String APPDATA_MAPPAURL_CODE = "appDatamappaUrl";

	// ApplicationData: [regione, scope:USER_SESSION]
	public static final String APPDATA_REGIONE_CODE = "appDataregione";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [elencoSediOperative, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEDIOPERATIVE_CODE = "appDataelencoSediOperative";

	// ApplicationData: [idSedeOperativaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSEDEOPERATIVASELEZIONATA_CODE = "appDataidSedeOperativaSelezionata";

	// ApplicationData: [enteFormativo, scope:USER_SESSION]
	public static final String APPDATA_ENTEFORMATIVO_CODE = "appDataenteFormativo";

	// ApplicationData: [suggestIndirizzo, scope:SAME_PAGE]
	public static final String APPDATA_SUGGESTINDIRIZZO_CODE = "appDatasuggestIndirizzo";

	// ApplicationData: [suggestIndirizzoCode, scope:SAME_PAGE]
	public static final String APPDATA_SUGGESTINDIRIZZOCODE_CODE = "appDatasuggestIndirizzoCode";

	// ApplicationData: [elencoTipologieCorsi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOLOGIECORSI_CODE = "appDataelencoTipologieCorsi";

	// ApplicationData: [corsi, scope:USER_SESSION]
	public static final String APPDATA_CORSI_CODE = "appDatacorsi";

	// ApplicationData: [idCorsoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDCORSOSELEZIONATO_CODE = "appDataidCorsoSelezionato";

	// ApplicationData: [modalitaDettaglioCorso, scope:USER_SESSION]
	public static final String APPDATA_MODALITADETTAGLIOCORSO_CODE = "appDatamodalitaDettaglioCorso";

	// ApplicationData: [modalitaDettaglioPartecipante, scope:USER_SESSION]
	public static final String APPDATA_MODALITADETTAGLIOPARTECIPANTE_CODE = "appDatamodalitaDettaglioPartecipante";

	// ApplicationData: [dettaglioCorso, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOCORSO_CODE = "appDatadettaglioCorso";

	// ApplicationData: [tipoEnti, scope:USER_SESSION]
	public static final String APPDATA_TIPOENTI_CODE = "appDatatipoEnti";

	// ApplicationData: [idPartecipanteSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDPARTECIPANTESELEZIONATO_CODE = "appDataidPartecipanteSelezionato";

	// ApplicationData: [partecipanti, scope:USER_SESSION]
	public static final String APPDATA_PARTECIPANTI_CODE = "appDatapartecipanti";

	// ApplicationData: [dettaglioPartecipante, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOPARTECIPANTE_CODE = "appDatadettaglioPartecipante";

	// ApplicationData: [listaCf, scope:USER_SESSION]
	public static final String APPDATA_LISTACF_CODE = "appDatalistaCf";

	// ApplicationData: [cfSel, scope:USER_SESSION]
	public static final String APPDATA_CFSEL_CODE = "appDatacfSel";

	// ApplicationData: [listaTipoIstruzione, scope:USER_SESSION]
	public static final String APPDATA_LISTATIPOISTRUZIONE_CODE = "appDatalistaTipoIstruzione";

	// ApplicationData: [listaEsito, scope:USER_SESSION]
	public static final String APPDATA_LISTAESITO_CODE = "appDatalistaEsito";

	// ApplicationData: [tipoRuoloUtente, scope:USER_SESSION]
	public static final String APPDATA_TIPORUOLOUTENTE_CODE = "appDatatipoRuoloUtente";

	// ApplicationData: [titoli, scope:USER_SESSION]
	public static final String APPDATA_TITOLI_CODE = "appDatatitoli";

	// ApplicationData: [ricercaCertificatori, scope:USER_SESSION]
	public static final String APPDATA_RICERCACERTIFICATORI_CODE = "appDataricercaCertificatori";

	// ApplicationData: [certificatoreList, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATORELIST_CODE = "appDatacertificatoreList";

	// ApplicationData: [elencoTipoCorsi, scope:USER_SESSION]
	public static final String APPDATA_ELENCOTIPOCORSI_CODE = "appDataelencoTipoCorsi";

	// ApplicationData: [elencoMotivazioniBlocco, scope:USER_SESSION]
	public static final String APPDATA_ELENCOMOTIVAZIONIBLOCCO_CODE = "appDataelencoMotivazioniBlocco";

	// ApplicationData: [idCertificatoreSel, scope:USER_SESSION]
	public static final String APPDATA_IDCERTIFICATORESEL_CODE = "appDataidCertificatoreSel";

	// ApplicationData: [certificatoreDett, scope:USER_SESSION]
	public static final String APPDATA_CERTIFICATOREDETT_CODE = "appDatacertificatoreDett";

	// ApplicationData: [idMotivoBloccoSel, scope:USER_SESSION]
	public static final String APPDATA_IDMOTIVOBLOCCOSEL_CODE = "appDataidMotivoBloccoSel";

	// ApplicationData: [chiaviTitoloStudio, scope:USER_SESSION]
	public static final String APPDATA_CHIAVITITOLOSTUDIO_CODE = "appDatachiaviTitoloStudio";

	// ApplicationData: [chiaviCurriculum, scope:USER_SESSION]
	public static final String APPDATA_CHIAVICURRICULUM_CODE = "appDatachiaviCurriculum";

	// ApplicationData: [chiaviAttPartNew, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTNEW_CODE = "appDatachiaviAttPartNew";

	// ApplicationData: [chiaviAttPartOld, scope:USER_SESSION]
	public static final String APPDATA_CHIAVIATTPARTOLD_CODE = "appDatachiaviAttPartOld";

	// ApplicationData: [uidDaStampare, scope:USER_SESSION]
	public static final String APPDATA_UIDDASTAMPARE_CODE = "appDatauidDaStampare";

	// ApplicationData: [ricercaAce, scope:USER_SESSION]
	public static final String APPDATA_RICERCAACE_CODE = "appDataricercaAce";

	// ApplicationData: [motivazioneRilascio, scope:USER_ACTION]
	public static final String APPDATA_MOTIVAZIONERILASCIO_CODE = "appDatamotivazioneRilascio";

	// ApplicationData: [aceList, scope:USER_SESSION]
	public static final String APPDATA_ACELIST_CODE = "appDataaceList";

	// ApplicationData: [classeEnergetica, scope:USER_ACTION]
	public static final String APPDATA_CLASSEENERGETICA_CODE = "appDataclasseEnergetica";

	// ApplicationData: [destinazioneUso, scope:USER_ACTION]
	public static final String APPDATA_DESTINAZIONEUSO_CODE = "appDatadestinazioneUso";

	// ApplicationData: [codAttestatoDaStampare, scope:USER_SESSION]
	public static final String APPDATA_CODATTESTATODASTAMPARE_CODE = "appDatacodAttestatoDaStampare";

	// ApplicationData: [codAceSelezionato, scope:USER_SESSION]
	public static final String APPDATA_CODACESELEZIONATO_CODE = "appDatacodAceSelezionato";

	// ApplicationData: [aceSostituzioneList, scope:USER_SESSION]
	public static final String APPDATA_ACESOSTITUZIONELIST_CODE = "appDataaceSostituzioneList";

	// ApplicationData: [labelValueArray, scope:USER_ACTION]
	public static final String APPDATA_LABELVALUEARRAY_CODE = "appDatalabelValueArray";

	// ApplicationData: [motivazioneCtu, scope:USER_SESSION]
	public static final String APPDATA_MOTIVAZIONECTU_CODE = "appDatamotivazioneCtu";

	// ApplicationData: [annullamentoApe, scope:USER_SESSION]
	public static final String APPDATA_ANNULLAMENTOAPE_CODE = "appDataannullamentoApe";

	// ApplicationData: [emailInvioApe, scope:USER_SESSION]
	public static final String APPDATA_EMAILINVIOAPE_CODE = "appDataemailInvioApe";

	// ApplicationData: [documentoAggiuntivo, scope:USER_SESSION]
	public static final String APPDATA_DOCUMENTOAGGIUNTIVO_CODE = "appDatadocumentoAggiuntivo";

	// ApplicationData: [idDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_IDDOCUMENTOSELEZIONATO_CODE = "appDataidDocumentoSelezionato";

	// ApplicationData: [listDocumentazioneAggiuntiva, scope:USER_SESSION]
	public static final String APPDATA_LISTDOCUMENTAZIONEAGGIUNTIVA_CODE = "appDatalistDocumentazioneAggiuntiva";

	// ApplicationData: [uidDocumentoSelezionato, scope:USER_SESSION]
	public static final String APPDATA_UIDDOCUMENTOSELEZIONATO_CODE = "appDatauidDocumentoSelezionato";

	// ApplicationData: [resocontoTransMdp, scope:USER_SESSION]
	public static final String APPDATA_RESOCONTOTRANSMDP_CODE = "appDataresocontoTransMdp";

	// ApplicationData: [dettaglioTransAttEsito, scope:USER_SESSION]
	public static final String APPDATA_DETTAGLIOTRANSATTESITO_CODE = "appDatadettaglioTransAttEsito";

	// ApplicationData: [idTransazioniSel, scope:USER_SESSION]
	public static final String APPDATA_IDTRANSAZIONISEL_CODE = "appDataidTransazioniSel";

	// ApplicationData: [verificaIndex, scope:USER_SESSION]
	public static final String APPDATA_VERIFICAINDEX_CODE = "appDataverificaIndex";

	// ApplicationData: [idVerificaSel, scope:USER_SESSION]
	public static final String APPDATA_IDVERIFICASEL_CODE = "appDataidVerificaSel";

	// ApplicationData: [filtroDettaglioTransAttEsito, scope:USER_SESSION]
	public static final String APPDATA_FILTRODETTAGLIOTRANSATTESITO_CODE = "appDatafiltroDettaglioTransAttEsito";

	// ApplicationData: [verificaActa, scope:USER_SESSION]
	public static final String APPDATA_VERIFICAACTA_CODE = "appDataverificaActa";

	// ApplicationData: [riepilogoStoricizzazione, scope:USER_ACTION]
	public static final String APPDATA_RIEPILOGOSTORICIZZAZIONE_CODE = "appDatariepilogoStoricizzazione";

	// ApplicationData: [countCertificatiSenzaCoordinate, scope:USER_SESSION]
	public static final String APPDATA_COUNTCERTIFICATISENZACOORDINATE_CODE = "appDatacountCertificatiSenzaCoordinate";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	/// - i metodi relativi a menu e azioni di inizializzazione sono direttamente 
	///   implementati in questa classe
	/// - i metodi relativi ai singoli content panel sono delegati nei rispettivi
	///   bean
	//////////////////////////////////////////////////////////////////////////////

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegioneDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setRegioneDtCatastali(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatori
		return getCPBECpRicercaCertificatori().setRegioneDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatori
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatori
		return getCPBECpRicercaCertificatori().setProvinciaDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaCertificatori utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatori
	 */
	public ExecResults ricercaCertificatori(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatori
		return getCPBECpRicercaCertificatori().ricercaCertificatori(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciCombo utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatori
	 */
	public ExecResults gestisciCombo(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatori
		return getCPBECpRicercaCertificatori().gestisciCombo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegioneDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatoriAdv
	 */
	public ExecResults setRegioneDtCatastali(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriAdvModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatoriAdv
		return getCPBECpRicercaCertificatoriAdv().setRegioneDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatoriAdv
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriAdvModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatoriAdv
		return getCPBECpRicercaCertificatoriAdv().setProvinciaDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaCertificatori utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatoriAdv
	 */
	public ExecResults ricercaCertificatori(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriAdvModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatoriAdv
		return getCPBECpRicercaCertificatoriAdv().ricercaCertificatori(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciCombo utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaCertificatoriAdv
	 */
	public ExecResults gestisciCombo(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRicercaCertificatoriAdvModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaCertificatoriAdv
		return getCPBECpRicercaCertificatoriAdv().gestisciCombo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bloccaTuttiCertificatori utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoCertificatoriAdv
	 */
	public ExecResults bloccaTuttiCertificatori(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRisultatoCertificatoriAdvModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoCertificatoriAdv
		return getCPBECpRisultatoCertificatoriAdv().bloccaTuttiCertificatori(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaDettaglio utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoCertificatoriAdv
	 */
	public ExecResults visualizzaDettaglio(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpRisultatoCertificatoriAdvModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoCertificatoriAdv
		return getCPBECpRisultatoCertificatoriAdv().visualizzaDettaglio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo bloccaCertificatore utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults bloccaCertificatore(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().bloccaCertificatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo sbloccaCertificatore utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults sbloccaCertificatore(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().sbloccaCertificatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inizializzaRicApeCert utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults inizializzaRicApeCert(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().inizializzaRicApeCert(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaTitoloStudio utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults scaricaTitoloStudio(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().scaricaTitoloStudio(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaCurriculumVitae utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults scaricaCurriculumVitae(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().scaricaCurriculumVitae(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaAttestatoPartecipazioneNew utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults scaricaAttestatoPartecipazioneNew(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().scaricaAttestatoPartecipazioneNew(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scaricaAttestatoPartecipazioneOld utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults scaricaAttestatoPartecipazioneOld(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().scaricaAttestatoPartecipazioneOld(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAceCertByFiltro utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults ricercaAceCertByFiltro(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().ricercaAceCertByFiltro(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaScaricoModulo utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().preparaScaricoModulo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaReport utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().stampaReport(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo annullaApe utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults annullaApe(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().annullaApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initDettaglioCertificatore utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCertificatore
	 */
	public ExecResults initDettaglioCertificatore(

			it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCertificatore
		return getCPBECpDettaglioCertificatore().initDettaglioCertificatore(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo abilitaCodFormReg utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults abilitaCodFormReg(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().abilitaCodFormReg(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo cambiaSedeOperativa utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults cambiaSedeOperativa(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().cambiaSedeOperativa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setRegione utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults setRegione(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().setRegione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvincia utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults setProvincia(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().setProvincia(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setComune utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults setComune(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().setComune(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults verificaIndirizzo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().verificaIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo scegliIndirizzo utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults scegliIndirizzo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().scegliIndirizzo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaImmagineLogo utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults caricaImmagineLogo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().caricaImmagineLogo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaEnteFormativo utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults salvaEnteFormativo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().salvaEnteFormativo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboGeo utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().gestisciComboGeo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadFromDB utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults loadFromDB(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().loadFromDB(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo abilitaCodFormRegInit utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults abilitaCodFormRegInit(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().abilitaCodFormRegInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo abilitaVerificaIndirizziInit utilizzato in un ExecCommand
	 * del ContentPanel cpDatiRegistrazione
	 */
	public ExecResults abilitaVerificaIndirizziInit(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDatiRegistrazione
		return getCPBECpDatiRegistrazione().abilitaVerificaIndirizziInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo cambiaSedeOperativa utilizzato in un ExecCommand
	 * del ContentPanel cpCorsi
	 */
	public ExecResults cambiaSedeOperativa(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCorsi
		return getCPBECpCorsi().cambiaSedeOperativa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaDettaglioCorso utilizzato in un ExecCommand
	 * del ContentPanel cpCorsi
	 */
	public ExecResults preparaDettaglioCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCorsi
		return getCPBECpCorsi().preparaDettaglioCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo confermaEliminaCorso utilizzato in un ExecCommand
	 * del ContentPanel cpCorsi
	 */
	public ExecResults confermaEliminaCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCorsi
		return getCPBECpCorsi().confermaEliminaCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo updateCorso utilizzato in un ExecCommand
	 * del ContentPanel cpCorsi
	 */
	public ExecResults updateCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCorsi
		return getCPBECpCorsi().updateCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo elencoPartecipanti utilizzato in un ExecCommand
	 * del ContentPanel cpCorsi
	 */
	public ExecResults elencoPartecipanti(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCorsi
		return getCPBECpCorsi().elencoPartecipanti(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inserisciNuovoCorso utilizzato in un ExecCommand
	 * del ContentPanel cpCorsi
	 */
	public ExecResults inserisciNuovoCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCorsi
		return getCPBECpCorsi().inserisciNuovoCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaCorso utilizzato in un ExecCommand
	 * del ContentPanel cpCorsi
	 */
	public ExecResults eliminaCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCorsi
		return getCPBECpCorsi().eliminaCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadCorsi utilizzato in un ExecCommand
	 * del ContentPanel cpCorsi
	 */
	public ExecResults loadCorsi(

			it.csi.sicee.siceebo.dto.entiformativi.CpCorsiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpCorsi
		return getCPBECpCorsi().loadCorsi(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaCorso utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCorso
	 */
	public ExecResults salvaCorso(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioCorsoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCorso
		return getCPBECpDettaglioCorso().salvaCorso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadFromDB utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioCorso
	 */
	public ExecResults loadFromDB(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioCorsoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioCorso
		return getCPBECpDettaglioCorso().loadFromDB(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo confermaEliminaPartecipante utilizzato in un ExecCommand
	 * del ContentPanel cpPartecipanti
	 */
	public ExecResults confermaEliminaPartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPartecipanti
		return getCPBECpPartecipanti().confermaEliminaPartecipante(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo updatePartecipante utilizzato in un ExecCommand
	 * del ContentPanel cpPartecipanti
	 */
	public ExecResults updatePartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPartecipanti
		return getCPBECpPartecipanti().updatePartecipante(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inserisciNuovoPartecipante utilizzato in un ExecCommand
	 * del ContentPanel cpPartecipanti
	 */
	public ExecResults inserisciNuovoPartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPartecipanti
		return getCPBECpPartecipanti().inserisciNuovoPartecipante(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo eliminaPartecipante utilizzato in un ExecCommand
	 * del ContentPanel cpPartecipanti
	 */
	public ExecResults eliminaPartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPartecipanti
		return getCPBECpPartecipanti().eliminaPartecipante(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadPartecipanti utilizzato in un ExecCommand
	 * del ContentPanel cpPartecipanti
	 */
	public ExecResults loadPartecipanti(

			it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpPartecipanti
		return getCPBECpPartecipanti().loadPartecipanti(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo caricaListaCf utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults caricaListaCf(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioPartecipante
		return getCPBECpDettaglioPartecipante().caricaListaCf(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo copiaDatiPartecipanteCertif utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults copiaDatiPartecipanteCertif(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioPartecipante
		return getCPBECpDettaglioPartecipante().copiaDatiPartecipanteCertif(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo controlloStampaAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults controlloStampaAttestato(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioPartecipante
		return getCPBECpDettaglioPartecipante().controlloStampaAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo salvaPartecipante utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults salvaPartecipante(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioPartecipante
		return getCPBECpDettaglioPartecipante().salvaPartecipante(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo loadFromDB utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioPartecipante
	 */
	public ExecResults loadFromDB(

			it.csi.sicee.siceebo.dto.entiformativi.CpDettaglioPartecipanteModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioPartecipante
		return getCPBECpDettaglioPartecipante().loadFromDB(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaACEbyCodice utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults ricercaACEbyCodice(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().ricercaACEbyCodice(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo setProvinciaDtCatastali utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults setProvinciaDtCatastali(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().setProvinciaDtCatastali(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciApeOldAndNew utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciApeOldAndNew(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().gestisciApeOldAndNew(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaAceByFiltro utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults ricercaAceByFiltro(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().ricercaAceByFiltro(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciComboInit utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciComboInit(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().gestisciComboInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciVisRuolo utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciVisRuolo(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().gestisciVisRuolo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciCombo utilizzato in un ExecCommand
	 * del ContentPanel cpRicercaAce
	 */
	public ExecResults gestisciCombo(

			it.csi.sicee.siceebo.dto.ricercaace.CpRicercaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRicercaAce
		return getCPBECpRicercaAce().gestisciCombo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaScaricoModulo utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoAce
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoAce
		return getCPBECpRisultatoAce().preparaScaricoModulo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recuperaSostituti utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoAce
	 */
	public ExecResults recuperaSostituti(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoAce
		return getCPBECpRisultatoAce().recuperaSostituti(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo stampaReport utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoAce
	 */
	public ExecResults stampaReport(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoAce
		return getCPBECpRisultatoAce().stampaReport(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo annullaApe utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoAce
	 */
	public ExecResults annullaApe(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoAce
		return getCPBECpRisultatoAce().annullaApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaAperturaDocAggiuntiva utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoAce
	 */
	public ExecResults preparaAperturaDocAggiuntiva(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoAce
		return getCPBECpRisultatoAce().preparaAperturaDocAggiuntiva(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo invaEmailZipXmlApe utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoAce
	 */
	public ExecResults invaEmailZipXmlApe(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoAce
		return getCPBECpRisultatoAce().invaEmailZipXmlApe(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initListaAttestati utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoAce
	 */
	public ExecResults initListaAttestati(

			it.csi.sicee.siceebo.dto.ricercaace.CpRisultatoAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoAce
		return getCPBECpRisultatoAce().initListaAttestati(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo annullaCerificato utilizzato in un ExecCommand
	 * del ContentPanel cpAnnullaAce
	 */
	public ExecResults annullaCerificato(

			it.csi.sicee.siceebo.dto.ricercaace.CpAnnullaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAnnullaAce
		return getCPBECpAnnullaAce().annullaCerificato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciRitorno utilizzato in un ExecCommand
	 * del ContentPanel cpAnnullaAce
	 */
	public ExecResults gestisciRitorno(

			it.csi.sicee.siceebo.dto.ricercaace.CpAnnullaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAnnullaAce
		return getCPBECpAnnullaAce().gestisciRitorno(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initDatiAnnullamento utilizzato in un ExecCommand
	 * del ContentPanel cpAnnullaAce
	 */
	public ExecResults initDatiAnnullamento(

			it.csi.sicee.siceebo.dto.ricercaace.CpAnnullaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpAnnullaAce
		return getCPBECpAnnullaAce().initDatiAnnullamento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestisciRitorno utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioAttestato
	 */
	public ExecResults gestisciRitorno(

			it.csi.sicee.siceebo.dto.ricercaace.CpDettaglioAttestatoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioAttestato
		return getCPBECpDettaglioAttestato().gestisciRitorno(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaDettaglioAttestato utilizzato in un ExecCommand
	 * del ContentPanel cpDettaglioAttestato
	 */
	public ExecResults visualizzaDettaglioAttestato(

			it.csi.sicee.siceebo.dto.ricercaace.CpDettaglioAttestatoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDettaglioAttestato
		return getCPBECpDettaglioAttestato().visualizzaDettaglioAttestato(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaDownloadDocumento utilizzato in un ExecCommand
	 * del ContentPanel cpDocAggiuntiva
	 */
	public ExecResults preparaDownloadDocumento(

			it.csi.sicee.siceebo.dto.ricercaace.CpDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDocAggiuntiva
		return getCPBECpDocAggiuntiva().preparaDownloadDocumento(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo initListaDocumentazione utilizzato in un ExecCommand
	 * del ContentPanel cpDocAggiuntiva
	 */
	public ExecResults initListaDocumentazione(

			it.csi.sicee.siceebo.dto.ricercaace.CpDocAggiuntivaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpDocAggiuntiva
		return getCPBECpDocAggiuntiva().initListaDocumentazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaACEbyCodice utilizzato in un ExecCommand
	 * del ContentPanel cpStampaAce
	 */
	public ExecResults ricercaACEbyCodice(

			it.csi.sicee.siceebo.dto.stampaace.CpStampaAceModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpStampaAce
		return getCPBECpStampaAce().ricercaACEbyCodice(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo preparaScaricoModulo utilizzato in un ExecCommand
	 * del ContentPanel cpRisultatoAceStampa
	 */
	public ExecResults preparaScaricoModulo(

			it.csi.sicee.siceebo.dto.stampaace.CpRisultatoAceStampaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRisultatoAceStampa
		return getCPBECpRisultatoAceStampa().preparaScaricoModulo(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo cercaTransazioni utilizzato in un ExecCommand
	 * del ContentPanel cpTransazioniMdp
	 */
	public ExecResults cercaTransazioni(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazioniMdp
		return getCPBECpTransazioniMdp().cercaTransazioni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo annullaTransazioni utilizzato in un ExecCommand
	 * del ContentPanel cpTransazioniMdp
	 */
	public ExecResults annullaTransazioni(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazioniMdp
		return getCPBECpTransazioniMdp().annullaTransazioni(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo verificaTransMdp utilizzato in un ExecCommand
	 * del ContentPanel cpTransazioniMdp
	 */
	public ExecResults verificaTransMdp(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazioniMdp
		return getCPBECpTransazioniMdp().verificaTransMdp(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recuperaRT utilizzato in un ExecCommand
	 * del ContentPanel cpTransazioniMdp
	 */
	public ExecResults recuperaRT(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazioniMdp
		return getCPBECpTransazioniMdp().recuperaRT(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo cercaTransazioniInit utilizzato in un ExecCommand
	 * del ContentPanel cpTransazioniMdp
	 */
	public ExecResults cercaTransazioniInit(

			it.csi.sicee.siceebo.dto.backoffice.CpTransazioniMdpModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpTransazioniMdp
		return getCPBECpTransazioniMdp().cercaTransazioniInit(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo ricercaACEbyCodice utilizzato in un ExecCommand
	 * del ContentPanel cpVerificheIndex
	 */
	public ExecResults ricercaACEbyCodice(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheIndexModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVerificheIndex
		return getCPBECpVerificheIndex().ricercaACEbyCodice(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo recuperaFile utilizzato in un ExecCommand
	 * del ContentPanel cpVerificheIndex
	 */
	public ExecResults recuperaFile(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheIndexModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVerificheIndex
		return getCPBECpVerificheIndex().recuperaFile(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo visualizzaFile utilizzato in un ExecCommand
	 * del ContentPanel cpVerificheIndex
	 */
	public ExecResults visualizzaFile(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheIndexModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVerificheIndex
		return getCPBECpVerificheIndex().visualizzaFile(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inizializzaVerificheIndex utilizzato in un ExecCommand
	 * del ContentPanel cpVerificheIndex
	 */
	public ExecResults inizializzaVerificheIndex(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheIndexModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVerificheIndex
		return getCPBECpVerificheIndex().inizializzaVerificheIndex(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo risolviProtocollazione utilizzato in un ExecCommand
	 * del ContentPanel cpVerificheActa
	 */
	public ExecResults risolviProtocollazione(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheActaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVerificheActa
		return getCPBECpVerificheActa().risolviProtocollazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inizializzaVerificheActa utilizzato in un ExecCommand
	 * del ContentPanel cpVerificheActa
	 */
	public ExecResults inizializzaVerificheActa(

			it.csi.sicee.siceebo.dto.backoffice.CpVerificheActaModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpVerificheActa
		return getCPBECpVerificheActa().inizializzaVerificheActa(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestStoricizzaLogAccesso utilizzato in un ExecCommand
	 * del ContentPanel cpStoricizzazioneLogAccesso
	 */
	public ExecResults gestStoricizzaLogAccesso(

			it.csi.sicee.siceebo.dto.backoffice.CpStoricizzazioneLogAccessoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpStoricizzazioneLogAccesso
		return getCPBECpStoricizzazioneLogAccesso().gestStoricizzaLogAccesso(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inizializzaCountRecordStoricizzazione utilizzato in un ExecCommand
	 * del ContentPanel cpStoricizzazioneLogAccesso
	 */
	public ExecResults inizializzaCountRecordStoricizzazione(

			it.csi.sicee.siceebo.dto.backoffice.CpStoricizzazioneLogAccessoModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpStoricizzazioneLogAccesso
		return getCPBECpStoricizzazioneLogAccesso().inizializzaCountRecordStoricizzazione(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo gestRecuperoCoordinateLOCCSI utilizzato in un ExecCommand
	 * del ContentPanel cpRecuperaCoordinateLOCCSI
	 */
	public ExecResults gestRecuperoCoordinateLOCCSI(

			it.csi.sicee.siceebo.dto.backoffice.CpRecuperaCoordinateLOCCSIModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRecuperaCoordinateLOCCSI
		return getCPBECpRecuperaCoordinateLOCCSI().gestRecuperoCoordinateLOCCSI(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * richiama il metodo inizializzaCountCertificatiSenzaCoordinate utilizzato in un ExecCommand
	 * del ContentPanel cpRecuperaCoordinateLOCCSI
	 */
	public ExecResults inizializzaCountCertificatiSenzaCoordinate(

			it.csi.sicee.siceebo.dto.backoffice.CpRecuperaCoordinateLOCCSIModel theModel

	) throws BEException {
		// l'esecuzione viene delegata al bean corrispondente al ContentPanel cpRecuperaCoordinateLOCCSI
		return getCPBECpRecuperaCoordinateLOCCSI().inizializzaCountCertificatiSenzaCoordinate(theModel);
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initRicCertificatori definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults initRicCertificatori(

			it.csi.sicee.siceebo.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITRICCERTIFICATORI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R955466368) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(INITRICCERTIFICATORI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initRicCertificatori] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initRicCertificatoriAdv definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults initRicCertificatoriAdv(

			it.csi.sicee.siceebo.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITRICCERTIFICATORIADV_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1888936421) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// Questa comando mi serve poe far in modo che se si ripassa dal menu e si chiede il dettaglio
			// l'applicativo porta nel primo tab
			theModel.getSession().remove("cpDettaglioCertificatore_tspDettCert_selectedMultiPanel");

			// impostazione del result code 
			result.setResultCode(INITRICCERTIFICATORIADV_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initRicCertificatoriAdv] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo initRicACE definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults initRicACE(

			it.csi.sicee.siceebo.dto.GlobalMenuModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String INITRICACE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1953315979) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			// impostazione del result code 
			result.setResultCode(INITRICACE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::initRicACE] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo checkEnabled definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults checkEnabled(

			it.csi.sicee.siceebo.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CHECKENABLED_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String CHECKENABLED_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1679769053) ENABLED START*/
			if (!getActivationMgr().isServiceEnabled()) {
				String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();

				SecurityHelper sh = new SecurityHelper();
				Identita currentUser = sh.getCurrentUser(theModel.getSession());

				//				Ruolo rol = new Ruolo();
				//				rol.setCodiceRuolo("LETTORE_SICEEBO");
				//				rol.setCodiceDominio("ARPA");

				if (sh.getIridePEP().isPersonaInRuolo(currentUser,
						new Ruolo(Constants.LABEL_RUOLO_LETTORE_CTU_ESTERNI))) {
					theModel.getAppDatacurrentUser().setRuolo(Constants.LABEL_RUOLO_LETTORE_CTU_ESTERNI);
				} else if (sh.getIridePEP().isPersonaInRuolo(currentUser,
						new Ruolo(Constants.LABEL_RUOLO_LETTORE_ARPA))) {
					theModel.getAppDatacurrentUser().setRuolo(Constants.LABEL_RUOLO_LETTORE_ARPA);
				} else if (sh.getIridePEP().isPersonaInRuolo(currentUser,
						new Ruolo(Constants.LABEL_RUOLO_LETTORE_REG_PMN))) {
					theModel.getAppDatacurrentUser().setRuolo(Constants.LABEL_RUOLO_LETTORE_REG_PMN);
				}
				log.debug("########STAMPO IL RUOLO (dopo set): " + theModel.getAppDatacurrentUser().getRuolo());
				//				
				//				Ruolo[] ruoli = sh.getIridePEP().verifyCurrentUserForRole(
				//						identita,
				//						new Application(
				//								CostantiApplicative.CODICE_APPLICATIVO_IRIDE));
				//				
				//				

				/*
				"LETTORE_SICEEBO", "ARPA");
				"LETTORE_SICEEBO", "REG_PMN");
				"LETTORE_CTU_SICEEBO", "UTENTI_ESTERNI");
				 */

				if (getActivationMgr().isUserEnabled(codiceFiscale)) {
					result.setResultCode(CHECKENABLED_OUTCOME_CODE__OK);
				} else {
					result.setResultCode(CHECKENABLED_OUTCOME_CODE__KO);
				}
			} else {
				SecurityHelper sh = new SecurityHelper();
				Identita currentUser = sh.getCurrentUser(theModel.getSession());
				if (sh.getIridePEP().isPersonaInRuolo(currentUser,
						new Ruolo(Constants.LABEL_RUOLO_LETTORE_CTU_ESTERNI))) {
					theModel.getAppDatacurrentUser().setRuolo(Constants.LABEL_RUOLO_LETTORE_CTU_ESTERNI);
				} else if (sh.getIridePEP().isPersonaInRuolo(currentUser,
						new Ruolo(Constants.LABEL_RUOLO_LETTORE_ARPA))) {
					theModel.getAppDatacurrentUser().setRuolo(Constants.LABEL_RUOLO_LETTORE_ARPA);
				} else if (sh.getIridePEP().isPersonaInRuolo(currentUser,
						new Ruolo(Constants.LABEL_RUOLO_LETTORE_REG_PMN))) {
					theModel.getAppDatacurrentUser().setRuolo(Constants.LABEL_RUOLO_LETTORE_REG_PMN);
				}
				log.debug("########STAMPO IL RUOLO (dopo set): " + theModel.getAppDatacurrentUser().getRuolo());

				result.setResultCode(CHECKENABLED_OUTCOME_CODE__OK);
			}
			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::checkEnabled] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaLogAccesso definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults salvaLogAccesso(

			it.csi.sicee.siceebo.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVALOGACCESSO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-484381076) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			UserInfo user = theModel.getAppDatacurrentUser();

			getSoaIntegrationMgr().insertLogAccesso(user.getCodFisc(), user.getNome(), user.getCognome(),
					user.getRuolo());

			// impostazione del result code 
			result.setResultCode(SALVALOGACCESSO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaLogAccesso] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestAnnullAttestatiScaduti definito in un ExecCommand del
	 * ContentPanel 
	 */
	public ExecResults gestAnnullAttestatiScaduti(

			it.csi.sicee.siceebo.dto.GlobalHomeModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTANNULLATTESTATISCADUTI_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-443840157) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String gestAnnullAttScaduti = getMiscMgr().getParametro(Constants.SERVIZIO_ATTIVO_ANNULLA_CERT_SCADUTI);

			log.debug("Verifico se e' attivo il servizio di annullamento attestati scaduti: " + gestAnnullAttScaduti);

			if (Constants.SI.equalsIgnoreCase(gestAnnullAttScaduti)) {
				getBackOfficeMgr().annullaAttestatiScaduti();
			}

			// impostazione del result code 
			result.setResultCode(GESTANNULLATTESTATISCADUTI_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestAnnullAttestatiScaduti] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property relative ai bean spring associati agli specifici content panel
	//////////////////////////////////////////////////////////////////////////////

	/**
	 * riferimento al CPBE del content panel cpRicercaCertificatori
	 */
	private it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRicercaCertificatori cPBECpRicercaCertificatori = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaCertificatori
	 */
	public void setCPBECpRicercaCertificatori(
			it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRicercaCertificatori bean) {
		this.cPBECpRicercaCertificatori = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaCertificatori
	 */
	public it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRicercaCertificatori getCPBECpRicercaCertificatori() {
		return this.cPBECpRicercaCertificatori;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaCertificatoriAdv
	 */
	private it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRicercaCertificatoriAdv cPBECpRicercaCertificatoriAdv = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaCertificatoriAdv
	 */
	public void setCPBECpRicercaCertificatoriAdv(
			it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRicercaCertificatoriAdv bean) {
		this.cPBECpRicercaCertificatoriAdv = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaCertificatoriAdv
	 */
	public it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRicercaCertificatoriAdv getCPBECpRicercaCertificatoriAdv() {
		return this.cPBECpRicercaCertificatoriAdv;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoCertificatori
	 */
	private it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRisultatoCertificatori cPBECpRisultatoCertificatori = null;

	/**
	 * riferimento al CPBE del content panel cpRisultatoCertificatori
	 */
	public void setCPBECpRisultatoCertificatori(
			it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRisultatoCertificatori bean) {
		this.cPBECpRisultatoCertificatori = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoCertificatori
	 */
	public it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRisultatoCertificatori getCPBECpRisultatoCertificatori() {
		return this.cPBECpRisultatoCertificatori;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoCertificatoriAdv
	 */
	private it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRisultatoCertificatoriAdv cPBECpRisultatoCertificatoriAdv = null;

	/**
	 * riferimento al CPBE del content panel cpRisultatoCertificatoriAdv
	 */
	public void setCPBECpRisultatoCertificatoriAdv(
			it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRisultatoCertificatoriAdv bean) {
		this.cPBECpRisultatoCertificatoriAdv = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoCertificatoriAdv
	 */
	public it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpRisultatoCertificatoriAdv getCPBECpRisultatoCertificatoriAdv() {
		return this.cPBECpRisultatoCertificatoriAdv;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioCertificatore
	 */
	private it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpDettaglioCertificatore cPBECpDettaglioCertificatore = null;

	/**
	 * riferimento al CPBE del content panel cpDettaglioCertificatore
	 */
	public void setCPBECpDettaglioCertificatore(
			it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpDettaglioCertificatore bean) {
		this.cPBECpDettaglioCertificatore = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioCertificatore
	 */
	public it.csi.sicee.siceebo.business.ricercacertificatori.CPBECpDettaglioCertificatore getCPBECpDettaglioCertificatore() {
		return this.cPBECpDettaglioCertificatore;
	}

	/**
	 * riferimento al CPBE del content panel cpDatiRegistrazione
	 */
	private it.csi.sicee.siceebo.business.entiformativi.CPBECpDatiRegistrazione cPBECpDatiRegistrazione = null;

	/**
	 * riferimento al CPBE del content panel cpDatiRegistrazione
	 */
	public void setCPBECpDatiRegistrazione(it.csi.sicee.siceebo.business.entiformativi.CPBECpDatiRegistrazione bean) {
		this.cPBECpDatiRegistrazione = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDatiRegistrazione
	 */
	public it.csi.sicee.siceebo.business.entiformativi.CPBECpDatiRegistrazione getCPBECpDatiRegistrazione() {
		return this.cPBECpDatiRegistrazione;
	}

	/**
	 * riferimento al CPBE del content panel cpCorsi
	 */
	private it.csi.sicee.siceebo.business.entiformativi.CPBECpCorsi cPBECpCorsi = null;

	/**
	 * riferimento al CPBE del content panel cpCorsi
	 */
	public void setCPBECpCorsi(it.csi.sicee.siceebo.business.entiformativi.CPBECpCorsi bean) {
		this.cPBECpCorsi = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpCorsi
	 */
	public it.csi.sicee.siceebo.business.entiformativi.CPBECpCorsi getCPBECpCorsi() {
		return this.cPBECpCorsi;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioCorso
	 */
	private it.csi.sicee.siceebo.business.entiformativi.CPBECpDettaglioCorso cPBECpDettaglioCorso = null;

	/**
	 * riferimento al CPBE del content panel cpDettaglioCorso
	 */
	public void setCPBECpDettaglioCorso(it.csi.sicee.siceebo.business.entiformativi.CPBECpDettaglioCorso bean) {
		this.cPBECpDettaglioCorso = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioCorso
	 */
	public it.csi.sicee.siceebo.business.entiformativi.CPBECpDettaglioCorso getCPBECpDettaglioCorso() {
		return this.cPBECpDettaglioCorso;
	}

	/**
	 * riferimento al CPBE del content panel cpPartecipanti
	 */
	private it.csi.sicee.siceebo.business.entiformativi.CPBECpPartecipanti cPBECpPartecipanti = null;

	/**
	 * riferimento al CPBE del content panel cpPartecipanti
	 */
	public void setCPBECpPartecipanti(it.csi.sicee.siceebo.business.entiformativi.CPBECpPartecipanti bean) {
		this.cPBECpPartecipanti = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpPartecipanti
	 */
	public it.csi.sicee.siceebo.business.entiformativi.CPBECpPartecipanti getCPBECpPartecipanti() {
		return this.cPBECpPartecipanti;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioPartecipante
	 */
	private it.csi.sicee.siceebo.business.entiformativi.CPBECpDettaglioPartecipante cPBECpDettaglioPartecipante = null;

	/**
	 * riferimento al CPBE del content panel cpDettaglioPartecipante
	 */
	public void setCPBECpDettaglioPartecipante(
			it.csi.sicee.siceebo.business.entiformativi.CPBECpDettaglioPartecipante bean) {
		this.cPBECpDettaglioPartecipante = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioPartecipante
	 */
	public it.csi.sicee.siceebo.business.entiformativi.CPBECpDettaglioPartecipante getCPBECpDettaglioPartecipante() {
		return this.cPBECpDettaglioPartecipante;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAce
	 */
	private it.csi.sicee.siceebo.business.ricercaace.CPBECpRicercaAce cPBECpRicercaAce = null;

	/**
	 * riferimento al CPBE del content panel cpRicercaAce
	 */
	public void setCPBECpRicercaAce(it.csi.sicee.siceebo.business.ricercaace.CPBECpRicercaAce bean) {
		this.cPBECpRicercaAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRicercaAce
	 */
	public it.csi.sicee.siceebo.business.ricercaace.CPBECpRicercaAce getCPBECpRicercaAce() {
		return this.cPBECpRicercaAce;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoAce
	 */
	private it.csi.sicee.siceebo.business.ricercaace.CPBECpRisultatoAce cPBECpRisultatoAce = null;

	/**
	 * riferimento al CPBE del content panel cpRisultatoAce
	 */
	public void setCPBECpRisultatoAce(it.csi.sicee.siceebo.business.ricercaace.CPBECpRisultatoAce bean) {
		this.cPBECpRisultatoAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoAce
	 */
	public it.csi.sicee.siceebo.business.ricercaace.CPBECpRisultatoAce getCPBECpRisultatoAce() {
		return this.cPBECpRisultatoAce;
	}

	/**
	 * riferimento al CPBE del content panel cpAnnullaAce
	 */
	private it.csi.sicee.siceebo.business.ricercaace.CPBECpAnnullaAce cPBECpAnnullaAce = null;

	/**
	 * riferimento al CPBE del content panel cpAnnullaAce
	 */
	public void setCPBECpAnnullaAce(it.csi.sicee.siceebo.business.ricercaace.CPBECpAnnullaAce bean) {
		this.cPBECpAnnullaAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpAnnullaAce
	 */
	public it.csi.sicee.siceebo.business.ricercaace.CPBECpAnnullaAce getCPBECpAnnullaAce() {
		return this.cPBECpAnnullaAce;
	}

	/**
	 * riferimento al CPBE del content panel cpSostitutiAce
	 */
	private it.csi.sicee.siceebo.business.ricercaace.CPBECpSostitutiAce cPBECpSostitutiAce = null;

	/**
	 * riferimento al CPBE del content panel cpSostitutiAce
	 */
	public void setCPBECpSostitutiAce(it.csi.sicee.siceebo.business.ricercaace.CPBECpSostitutiAce bean) {
		this.cPBECpSostitutiAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpSostitutiAce
	 */
	public it.csi.sicee.siceebo.business.ricercaace.CPBECpSostitutiAce getCPBECpSostitutiAce() {
		return this.cPBECpSostitutiAce;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioAttestato
	 */
	private it.csi.sicee.siceebo.business.ricercaace.CPBECpDettaglioAttestato cPBECpDettaglioAttestato = null;

	/**
	 * riferimento al CPBE del content panel cpDettaglioAttestato
	 */
	public void setCPBECpDettaglioAttestato(it.csi.sicee.siceebo.business.ricercaace.CPBECpDettaglioAttestato bean) {
		this.cPBECpDettaglioAttestato = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDettaglioAttestato
	 */
	public it.csi.sicee.siceebo.business.ricercaace.CPBECpDettaglioAttestato getCPBECpDettaglioAttestato() {
		return this.cPBECpDettaglioAttestato;
	}

	/**
	 * riferimento al CPBE del content panel cpDocAggiuntiva
	 */
	private it.csi.sicee.siceebo.business.ricercaace.CPBECpDocAggiuntiva cPBECpDocAggiuntiva = null;

	/**
	 * riferimento al CPBE del content panel cpDocAggiuntiva
	 */
	public void setCPBECpDocAggiuntiva(it.csi.sicee.siceebo.business.ricercaace.CPBECpDocAggiuntiva bean) {
		this.cPBECpDocAggiuntiva = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDocAggiuntiva
	 */
	public it.csi.sicee.siceebo.business.ricercaace.CPBECpDocAggiuntiva getCPBECpDocAggiuntiva() {
		return this.cPBECpDocAggiuntiva;
	}

	/**
	 * riferimento al CPBE del content panel cpStampaAce
	 */
	private it.csi.sicee.siceebo.business.stampaace.CPBECpStampaAce cPBECpStampaAce = null;

	/**
	 * riferimento al CPBE del content panel cpStampaAce
	 */
	public void setCPBECpStampaAce(it.csi.sicee.siceebo.business.stampaace.CPBECpStampaAce bean) {
		this.cPBECpStampaAce = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpStampaAce
	 */
	public it.csi.sicee.siceebo.business.stampaace.CPBECpStampaAce getCPBECpStampaAce() {
		return this.cPBECpStampaAce;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoAceStampa
	 */
	private it.csi.sicee.siceebo.business.stampaace.CPBECpRisultatoAceStampa cPBECpRisultatoAceStampa = null;

	/**
	 * riferimento al CPBE del content panel cpRisultatoAceStampa
	 */
	public void setCPBECpRisultatoAceStampa(it.csi.sicee.siceebo.business.stampaace.CPBECpRisultatoAceStampa bean) {
		this.cPBECpRisultatoAceStampa = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRisultatoAceStampa
	 */
	public it.csi.sicee.siceebo.business.stampaace.CPBECpRisultatoAceStampa getCPBECpRisultatoAceStampa() {
		return this.cPBECpRisultatoAceStampa;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	private it.csi.sicee.siceebo.business.main.CPBECpHome cPBECpHome = null;

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public void setCPBECpHome(it.csi.sicee.siceebo.business.main.CPBECpHome bean) {
		this.cPBECpHome = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpHome
	 */
	public it.csi.sicee.siceebo.business.main.CPBECpHome getCPBECpHome() {
		return this.cPBECpHome;
	}

	/**
	 * riferimento al CPBE del content panel cpNonAbilitato
	 */
	private it.csi.sicee.siceebo.business.main.CPBECpNonAbilitato cPBECpNonAbilitato = null;

	/**
	 * riferimento al CPBE del content panel cpNonAbilitato
	 */
	public void setCPBECpNonAbilitato(it.csi.sicee.siceebo.business.main.CPBECpNonAbilitato bean) {
		this.cPBECpNonAbilitato = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpNonAbilitato
	 */
	public it.csi.sicee.siceebo.business.main.CPBECpNonAbilitato getCPBECpNonAbilitato() {
		return this.cPBECpNonAbilitato;
	}

	/**
	 * riferimento al CPBE del content panel cpEsci
	 */
	private it.csi.sicee.siceebo.business.main.CPBECpEsci cPBECpEsci = null;

	/**
	 * riferimento al CPBE del content panel cpEsci
	 */
	public void setCPBECpEsci(it.csi.sicee.siceebo.business.main.CPBECpEsci bean) {
		this.cPBECpEsci = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpEsci
	 */
	public it.csi.sicee.siceebo.business.main.CPBECpEsci getCPBECpEsci() {
		return this.cPBECpEsci;
	}

	/**
	 * riferimento al CPBE del content panel cpDisabled
	 */
	private it.csi.sicee.siceebo.business.main.CPBECpDisabled cPBECpDisabled = null;

	/**
	 * riferimento al CPBE del content panel cpDisabled
	 */
	public void setCPBECpDisabled(it.csi.sicee.siceebo.business.main.CPBECpDisabled bean) {
		this.cPBECpDisabled = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpDisabled
	 */
	public it.csi.sicee.siceebo.business.main.CPBECpDisabled getCPBECpDisabled() {
		return this.cPBECpDisabled;
	}

	/**
	 * riferimento al CPBE del content panel cpTransazioniMdp
	 */
	private it.csi.sicee.siceebo.business.backoffice.CPBECpTransazioniMdp cPBECpTransazioniMdp = null;

	/**
	 * riferimento al CPBE del content panel cpTransazioniMdp
	 */
	public void setCPBECpTransazioniMdp(it.csi.sicee.siceebo.business.backoffice.CPBECpTransazioniMdp bean) {
		this.cPBECpTransazioniMdp = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpTransazioniMdp
	 */
	public it.csi.sicee.siceebo.business.backoffice.CPBECpTransazioniMdp getCPBECpTransazioniMdp() {
		return this.cPBECpTransazioniMdp;
	}

	/**
	 * riferimento al CPBE del content panel cpVerificheIndex
	 */
	private it.csi.sicee.siceebo.business.backoffice.CPBECpVerificheIndex cPBECpVerificheIndex = null;

	/**
	 * riferimento al CPBE del content panel cpVerificheIndex
	 */
	public void setCPBECpVerificheIndex(it.csi.sicee.siceebo.business.backoffice.CPBECpVerificheIndex bean) {
		this.cPBECpVerificheIndex = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpVerificheIndex
	 */
	public it.csi.sicee.siceebo.business.backoffice.CPBECpVerificheIndex getCPBECpVerificheIndex() {
		return this.cPBECpVerificheIndex;
	}

	/**
	 * riferimento al CPBE del content panel cpVerificheActa
	 */
	private it.csi.sicee.siceebo.business.backoffice.CPBECpVerificheActa cPBECpVerificheActa = null;

	/**
	 * riferimento al CPBE del content panel cpVerificheActa
	 */
	public void setCPBECpVerificheActa(it.csi.sicee.siceebo.business.backoffice.CPBECpVerificheActa bean) {
		this.cPBECpVerificheActa = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpVerificheActa
	 */
	public it.csi.sicee.siceebo.business.backoffice.CPBECpVerificheActa getCPBECpVerificheActa() {
		return this.cPBECpVerificheActa;
	}

	/**
	 * riferimento al CPBE del content panel cpStoricizzazioneLogAccesso
	 */
	private it.csi.sicee.siceebo.business.backoffice.CPBECpStoricizzazioneLogAccesso cPBECpStoricizzazioneLogAccesso = null;

	/**
	 * riferimento al CPBE del content panel cpStoricizzazioneLogAccesso
	 */
	public void setCPBECpStoricizzazioneLogAccesso(
			it.csi.sicee.siceebo.business.backoffice.CPBECpStoricizzazioneLogAccesso bean) {
		this.cPBECpStoricizzazioneLogAccesso = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpStoricizzazioneLogAccesso
	 */
	public it.csi.sicee.siceebo.business.backoffice.CPBECpStoricizzazioneLogAccesso getCPBECpStoricizzazioneLogAccesso() {
		return this.cPBECpStoricizzazioneLogAccesso;
	}

	/**
	 * riferimento al CPBE del content panel cpRecuperaCoordinateLOCCSI
	 */
	private it.csi.sicee.siceebo.business.backoffice.CPBECpRecuperaCoordinateLOCCSI cPBECpRecuperaCoordinateLOCCSI = null;

	/**
	 * riferimento al CPBE del content panel cpRecuperaCoordinateLOCCSI
	 */
	public void setCPBECpRecuperaCoordinateLOCCSI(
			it.csi.sicee.siceebo.business.backoffice.CPBECpRecuperaCoordinateLOCCSI bean) {
		this.cPBECpRecuperaCoordinateLOCCSI = bean;
	}

	/**
	 * riferimento al CPBE del content panel cpRecuperaCoordinateLOCCSI
	 */
	public it.csi.sicee.siceebo.business.backoffice.CPBECpRecuperaCoordinateLOCCSI getCPBECpRecuperaCoordinateLOCCSI() {
		return this.cPBECpRecuperaCoordinateLOCCSI;
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R-1264235389) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)
	private ActivationMgr activationMgr;

	public ActivationMgr getActivationMgr() {
		return activationMgr;
	}

	public void setActivationMgr(ActivationMgr activationMgr) {
		this.activationMgr = activationMgr;
	}

	private BackOfficeMgr backOfficeMgr;

	public BackOfficeMgr getBackOfficeMgr() {
		return backOfficeMgr;
	}

	public void setBackOfficeMgr(BackOfficeMgr backOfficeMgr) {
		this.backOfficeMgr = backOfficeMgr;
	}

	private MiscMgr miscMgr;

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return this.soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/*PROTECTED REGION END*/
}
