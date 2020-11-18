package it.csi.sicee.siceebo.presentation.siceebo.action.entiformativi;

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
import it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel;

import it.csi.sicee.siceebo.presentation.siceebo.command.*;

import it.csi.sicee.siceebo.presentation.siceebo.security.*;

import it.csi.sicee.siceebo.business.*;

import it.csi.sicee.siceebo.presentation.siceebo.action.*;

import it.csi.sicee.siceebo.presentation.siceebo.action.entiformativi.states.CpPartecipantiScreenStates;

import it.csi.sicee.siceebo.presentation.siceebo.interceptor.MethodProtection;

import it.csi.sicee.siceebo.presentation.siceebo.interceptor.FatClientOnly;
import it.csi.sicee.siceebo.presentation.uiutils.*;
import flexjson.JSON;

/**
 * CpPartecipantiAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
@Conversion()
public class CpPartecipantiAction extends AbstractCPAction<CpPartecipantiModel>
		implements
			Preparable,
			ModelDriven<CpPartecipantiModel> {

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	private CpPartecipantiModel model;

	/**
	 * Il modello del content panel.
	 * Viene riempito a fornte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	public CpPartecipantiModel getModel() {
		return model;
	}

	/**
	 * Il modello del content panel.
	 * Viene riempito a fronte delle interazioni con il browser e viene passato allo
	 * strato di business.
	 */
	@VisitorFieldValidator(message = "", appendPrefix = false)
	public void setModel(CpPartecipantiModel modello) {
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
			model = new CpPartecipantiModel();
		}
		// associo la sessione applicativa al modello, in modo che
		// possa implementare l'accesso agli application data
		// di scope session/same page
		model.setSession(session);
	}

	/**
	 * nome del content panel
	 */
	private static final String CP_NAME = "cpPartecipanti";

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
		return it.csi.sicee.siceebo.dto.entiformativi.CpPartecipantiModel.class;
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
	 * Gestione dell'evento CLICKED sul widget [btnEliminaPartecipante]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnEliminaPartecipante_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cppartecipanti", "btnEliminaPartecipante", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [btnDettaglioPartecipante]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBtnDettaglioPartecipante_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cppartecipanti", "btnDettaglioPartecipante", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bIndietro]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBIndietro_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cppartecipanti", "bIndietro", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bInserisciNuovoPartecipante]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBInserisciNuovoPartecipante_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cppartecipanti", "bInserisciNuovoPartecipante", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bIndietroPartecipanti]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBIndietroPartecipanti_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cppartecipanti", "bIndietroPartecipanti", "CLICKED");

	}

	/**
	 * Gestione dell'evento CLICKED sul widget [bEliminaPartecipante]
	 */
	@MethodProtection(level = "REJECT_SAME")
	public String handleBEliminaPartecipante_CLICKED() throws CommandExecutionException {

		return handleEventInternal("entiformativi", "cppartecipanti", "bEliminaPartecipante", "CLICKED");

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
	 * al data-binding relativo al dataset DATASET del widget tblElencoPartecipanti.
	 * @return sempre il result "provideData"
	 */
	@SkipValidation
	@FatClientOnly
	public String provideTblElencoPartecipanti_DATASET() throws CommandExecutionException {

		return provideDataInternal("appDatapartecipanti", "", false, false);
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-1254370120) ENABLED START*/
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
