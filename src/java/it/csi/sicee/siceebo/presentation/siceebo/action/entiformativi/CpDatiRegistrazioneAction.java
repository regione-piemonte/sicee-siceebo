package it.csi.sicee.siceebo.presentation.siceebo.action.entiformativi;

import java.io.File;
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
import it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel;

import it.csi.sicee.siceebo.presentation.siceebo.command.*;

import it.csi.sicee.siceebo.presentation.siceebo.security.*;

import it.csi.sicee.siceebo.business.*;

import it.csi.sicee.siceebo.presentation.siceebo.action.*;

import it.csi.sicee.siceebo.presentation.siceebo.action.entiformativi.states.CpDatiRegistrazioneScreenStates;

import it.csi.sicee.siceebo.presentation.siceebo.interceptor.MethodProtection;

import it.csi.sicee.siceebo.presentation.siceebo.interceptor.FatClientOnly;
import it.csi.sicee.siceebo.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpDatiRegistrazioneAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpDatiRegistrazioneAction extends AbstractCPAction<CpDatiRegistrazioneModel>
		implements
			Preparable,
			ModelDriven<CpDatiRegistrazioneModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpDatiRegistrazioneModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpDatiRegistrazioneModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpDatiRegistrazioneModel modello) {
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
			model = new CpDatiRegistrazioneModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpDatiRegistrazione";

	/**
	 * nome del namespace che contiene il content panel
	 */
	private static final String CP_NAMESPACE = "entiFormativi";

	/**
	 * nome completo del namespace che contiene il content panel
	 */
	private static final String CP_FULL_NAMESPACE = "/base/entiFormativi";

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

	private static final String URL_BACK_COMMAND = "/base/entiFormativi/" + CP_NAME;

	/**
	 * classe model associata al ContentPanel
	 */
	public Class modelClass() {
		return it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel.class;
	}

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici   
	 * @return SUCCESS.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return super.execute();
	}

	protected boolean isImplicitEventDefined(String implicitEventName) {

		if (AbstractCPAction.IMPLICIT_EVENT_ON_REFRESH //NOSONAR
				.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		if (AbstractCPAction.IMPLICIT_EVENT_ON_ENTER.equals(implicitEventName)) //NOSONAR
			return true; //NOSONAR

		// else
		return false;
	}

	protected boolean isOnRefreshLegacyMode() {
		return true;
	}

	//////////////////////////////////////////////////////////////////////////////////
	/// metodi specifici per la gestione del singolo tipo di evento sul singolo widget
	/// contenuto nel contentPanel
	/// metodo: handle<nomeWidget>_<NOME_EVENTO>
	/// es: handletreeVoci_CLICKED
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbTipoSoggetto]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbTipoSoggetto_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "cbTipoSoggetto", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbSelezioneSO]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbSelezioneSO_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "cbSelezioneSO", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbReg]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbReg_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "cbReg", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbProv]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbProv_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "cbProv", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbCom]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbCom_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "cbCom", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [vVerifInd]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleVVerifInd_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "vVerifInd", "CLICKED");

	}

	/**
	 * Gestione dell'evento VALUE_CHANGED sul widget [cbSceltaInd]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleCbSceltaInd_VALUE_CHANGED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "cbSceltaInd", "VALUE_CHANGED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnCaricaLogo]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnCaricaLogo_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "btnCaricaLogo", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "bIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bSalva]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBSalva_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cpdatiregistrazione", "bSalva", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget cbTipoSoggetto.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbTipoSoggetto_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatatipoEnti", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSelezioneSO.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSelezioneSO_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataelencoSediOperative", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbReg.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbReg_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataregione", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbProv.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbProv_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDataprovince", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbCom.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbCom_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatacomuni", "", false, false);
	}

	/**
	 * Prepara l'input stream referenziato dal result "provideData" con i valori relativi 
	 * al data-binding relativo al dataset DATASET del widget cbSceltaInd.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideCbSceltaInd_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatasuggestIndirizzo", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-628947892) ENABLED START*/
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
		String[] appDataToClear = new String[]{"suggestIndirizzo", "suggestIndirizzo_bckp", "suggestIndirizzoCode",
				"suggestIndirizzoCode_bckp"

		};

		ClearAppDataCommand clearCmd = new ClearAppDataCommand(appDataToClear);
		session.put(PENDING_CLEAR_COMMAND_ATTRIBUTE, clearCmd);

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
