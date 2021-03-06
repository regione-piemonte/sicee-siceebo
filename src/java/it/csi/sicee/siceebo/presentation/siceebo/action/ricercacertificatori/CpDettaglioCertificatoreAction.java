package it.csi.sicee.siceebo.presentation.siceebo.action.ricercacertificatori;

import java.util.*;

import java.lang.reflect.InvocationTargetException;
import java.beans.IntrospectionException;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.ActionContext;

import it.csi.sicee.siceebo.util.*;
import it.csi.sicee.siceebo.dto.*;
import it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel;

import it.csi.sicee.siceebo.presentation.siceebo.command.*;

import it.csi.sicee.siceebo.presentation.siceebo.security.*;

import it.csi.sicee.siceebo.business.*;

import it.csi.sicee.siceebo.presentation.siceebo.action.*;

import it.csi.sicee.siceebo.presentation.siceebo.action.ricercacertificatori.states.CpDettaglioCertificatoreScreenStates;

import it.csi.sicee.siceebo.presentation.siceebo.interceptor.MethodProtection;

import it.csi.sicee.siceebo.presentation.siceebo.interceptor.FatClientOnly;
import it.csi.sicee.siceebo.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDettaglioCertificatoreAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDettaglioCertificatoreAction extends AbstractCPAction<CpDettaglioCertificatoreModel>
		implements
			Preparable,
			ModelDriven<CpDettaglioCertificatoreModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDettaglioCertificatoreModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDettaglioCertificatoreModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDettaglioCertificatoreModel modello) {
		this.model = modello;
	}

	/**
	 * Il metodo setSession() viene ridefinito in modo che venga asosciato all'oggetto
	 * model.
	 * N.B: il model deve essere creato in precedenza, altrimenti l'impostazione non 
	 * e' possibile. 
	 * Per questo motivo esso viene creato in questo (se non gia' esistente).
	 */
	@Override
	public void setSession(Map session) {
		// implementazione standard di SessionAware
		super.setSession(session);
		// creo una nuova istanza di modello, se gia' non esiste 
		if (model == null) {
			model = new CpDettaglioCertificatoreModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpDettaglioCertificatore";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "ricercaCertificatori";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/ricercaCertificatori";

	/**
	 * restituisce il nome del content panel
	 */
	public String getCPName() {
		return CP_NAME;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel
	 */
	public String getCPNamespace() {
		return CP_NAMESPACE;
	}

	/**
	 * restituisce il nome del namespace che contiene il content panel, comprensivo di prefisso "base"/"secure"
	 */
	public String getCPFullNamespace() {
		return CP_FULL_NAMESPACE;
	}

	private static final String URL_BACK_COMMAND = "/base/ricercaCertificatori/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sicee.siceebo.dto.ricercacertificatori.CpDettaglioCertificatoreModel.class;
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return super.execute();
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del click sui Tab
	/// contenuto nel contentPanel
	/// metodo: handle<id_completo_tab_item>_CLICKED
	/// 
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set tspDettCert 
	 */
	public String handle_CpDettaglioCertificatore_TspDettCert_FpDatiGenerali_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpDettaglioCertificatore_tspDettCert_selectedMultiPanel");
		getModel().setSelectedTabValue("cpDettaglioCertificatore_tspDettCert_fpDatiGenerali");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTspDettCert_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set tspDettCert 
	 */
	public String handle_CpDettaglioCertificatore_TspDettCert_FpTitoloStudio_CLICKED()
			throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpDettaglioCertificatore_tspDettCert_selectedMultiPanel");
		getModel().setSelectedTabValue("cpDettaglioCertificatore_tspDettCert_fpTitoloStudio");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTspDettCert_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	/**
	 * Gestione dell'evento di click sul tab Switcher del tab-set tspDettCert 
	 */
	public String handle_CpDettaglioCertificatore_TspDettCert_FpApe_CLICKED() throws CommandExecutionException {

		// impostazione dei parametri di selezione tab
		getModel().setSelectedTabKey("cpDettaglioCertificatore_tspDettCert_selectedMultiPanel");
		getModel().setSelectedTabValue("cpDettaglioCertificatore_tspDettCert_fpApe");
		// richiamo della logica associata al tab-switcher
		String tempResult = handleTspDettCert_CLICKED();
		// selezione del tab di destinazione
		handleChangeTab();
		return SUCCESS;
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

		if (AbstractCPAction.IMPLICIT_EVENT_ON_ENTER.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		// else
		return false;
	}

	protected boolean isOnRefreshLegacyMode() {
		return false;
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del singolo tipo di evento sul singolo widget
	/// contenuto nel contentPanel
	/// metodo: handle<nomeWidget>_<NOME_EVENTO>
	/// es: handletreeVoci_CLICKED
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento CLICKED sul widget [btnBloccaCert]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnBloccaCert_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "btnBloccaCert", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnSbloccaCert]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnSbloccaCert_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "btnSbloccaCert", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "bIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblTitoloStudioSummary]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblTitoloStudioSummary_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "tblTitoloStudioSummary",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblCurriculumSummary]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblCurriculumSummary_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "tblCurriculumSummary",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAttPartNewSummary]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttPartNewSummary_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "tblAttPartNewSummary",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblAttPartOldSummary]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblAttPartOldSummary_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "tblAttPartOldSummary",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bIndietro2]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBIndietro2_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "bIndietro2", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bRicerca]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBRicerca_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "bRicerca", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tblRisultatoAceCert]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTblRisultatoAceCert_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "tblRisultatoAceCert",
				"CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bStampaReport]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBStampaReport_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "bStampaReport", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnAnnulla]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnAnnulla_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "btnAnnulla", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bIndietro3]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBIndietro3_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "bIndietro3", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [tspDettCert]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleTspDettCert_CLICKED() throws CommandExecutionException {

		return handleEventInternal("ricercacertificatori", "cpdettagliocertificatore", "tspDettCert", "CLICKED");

	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodo di data providing sull'intero ContentPanel
	/// metodo: provide_CPDATA
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	/// metodi di data providing sui widget dotati di multi data binding
	/// contenuti nel contentPanel
	/// metodo: provide<nomeWidget>_<tipologia dati>
	/// es: provideCbComuni_DATASET
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbMotivazioneBlocco.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbMotivazioneBlocco_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoMotivazioniBlocco", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblTitoloStudioSummary.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblTitoloStudioSummary_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatachiaviTitoloStudio", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblCurriculumSummary.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblCurriculumSummary_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatachiaviCurriculum", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttPartNewSummary.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttPartNewSummary_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatachiaviAttPartNew", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblAttPartOldSummary.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblAttPartOldSummary_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatachiaviAttPartOld", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget tblRisultatoAceCert.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblRisultatoAceCert_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataaceList", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R439417449) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	/**
	 * Metodo di preparazione della schermata/action
	 */
	public void prepare() throws CommandExecutionException {
		super.prepare();

	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// nothing to clear...
	}

	@SkipValidation
	public String handleChangeTab() {
		if (this.hasActionErrors() || this.hasFieldErrors() || this.hasErrors())
			return INPUT;
		else {
			session.put(getModel().getSelectedTabKey(), getModel().getSelectedTabValue());
			return SUCCESS;
		}
	}

}
