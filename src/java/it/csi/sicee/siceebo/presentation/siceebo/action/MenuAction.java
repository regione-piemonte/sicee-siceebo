package it.csi.sicee.siceebo.presentation.siceebo.action;

import java.util.*;

import org.apache.struts2.interceptor.validation.SkipValidation;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.validator.annotations.*;

import it.csi.sicee.siceebo.dto.*;
import it.csi.sicee.siceebo.business.*;
import it.csi.sicee.siceebo.presentation.siceebo.command.*;
import it.csi.sicee.siceebo.presentation.siceebo.interceptor.FatClientOnly;

/**
 * MenuAction Action Class.
 *
 * @author GuiGen
 */
@Validation()
public class MenuAction extends BaseAction<GlobalMenuModel> implements ModelDriven<GlobalMenuModel> {

	private GlobalMenuModel model;

	public GlobalMenuModel getModel() {
		return model;
	}

	public void setModel(GlobalMenuModel modello) {
		this.model = modello;
	}

	@Override
	public void setSession(Map session) {
		// TODO Auto-generated method stub
		super.setSession(session);
		if (model == null) {
			model = new GlobalMenuModel();
		}
		model.setSession(session);
	}

	private Map<String, JumpExtCommand> jumpExtCommands = new HashMap<String, JumpExtCommand>();

	public Map<String, JumpExtCommand> getJumpExtCommands() {
		return jumpExtCommands;
	}

	public void setJumpExtCommands(Map<String, JumpExtCommand> jumpExtCommands) {
		this.jumpExtCommands = jumpExtCommands;
	}

	/**
	 * classe model associata
	 */
	public Class modelClass() {
		return it.csi.sicee.siceebo.dto.GlobalMenuModel.class;
	}

	/**
	 *
	 * @return Il risultato delle azioni, SUCCESS altrimenti.
	 */
	@SkipValidation
	public String execute() throws CommandExecutionException {
		return SUCCESS;
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuhome() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuhome", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuhome] returning result [" + result + "]");
			}
			setActiveMenu("mnuhome");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuhome] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuhome");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuRicCertificatori() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuRicCertificatori", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRicCertificatori] returning result [" + result + "]");
			}
			setActiveMenu("mnuRicCertificatori");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRicCertificatori] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuRicCertificatori");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuRicCertificatoriAdv() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuRicCertificatoriAdv", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRicCertificatoriAdv] returning result [" + result + "]");
			}
			setActiveMenu("mnuRicCertificatoriAdv");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRicCertificatoriAdv] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuRicCertificatoriAdv");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuRicACE() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuRicACE", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRicACE] returning result [" + result + "]");
			}
			setActiveMenu("mnuRicACE");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuRicACE] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuRicACE");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuStampaAce() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuStampaAce", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuStampaAce] returning result [" + result + "]");
			}
			setActiveMenu("mnuStampaAce");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuStampaAce] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuStampaAce");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuDatiRegistrazione() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuDatiRegistrazione", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuDatiRegistrazione] returning result [" + result + "]");
			}
			setActiveMenu("mnuDatiRegistrazione");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuDatiRegistrazione] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuDatiRegistrazione");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuSchedaCorsi() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuSchedaCorsi", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuSchedaCorsi] returning result [" + result + "]");
			}
			setActiveMenu("mnuSchedaCorsi");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuSchedaCorsi] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuSchedaCorsi");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuTransazioniMdp() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuTransazioniMdp", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuTransazioniMdp] returning result [" + result + "]");
			}
			setActiveMenu("mnuTransazioniMdp");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuTransazioniMdp] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuTransazioniMdp");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuVerificaIndex() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuVerificaIndex", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuVerificaIndex] returning result [" + result + "]");
			}
			setActiveMenu("mnuVerificaIndex");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuVerificaIndex] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuVerificaIndex");
			return SUCCESS;
		}
	}

	/**
	 * 
	 * @return SUCCESS result.
	 */
	public String goToMnuVerificaActa() throws CommandExecutionException {

		// gestione degli eventi di tipo CLICKED
		ICommand action = initCommand(null, "global", "mnuVerificaActa", "CLICKED");
		String result = action.doCommand(this);
		if (result != null) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuVerificaActa] returning result [" + result + "]");
			}
			setActiveMenu("mnuVerificaActa");
			return result;
		} else {
			if (LOG.isDebugEnabled()) {
				LOG.debug("[MenuAction::goToMnuVerificaActa] returning default result [SUCCESS]");
			}
			setActiveMenu("mnuVerificaActa");
			return SUCCESS;
		}
	}

	public static final String ACTIVE_MENU_ATTRNAME = "active_menu";

	public void setActiveMenu(String menuName) {
		session.put(ACTIVE_MENU_ATTRNAME, "menu_items_" + menuName);
	}

	/**
	 * inizializza la struttura dei command da eseguire per ciascun event handler 
	 * di ciascun widget
	 */
	protected ICommand initCommand(String moduleName, String panelName, String sourceWidget, String eventType) {
		ICommand cmd = null;
		try {
			cmd = CommandFactory.getInstance().buildCmdStructure_internal(null, "global",
					"_" + sourceWidget.toLowerCase() + "_" + "CLICKED");
		} catch (CommandExecutionException cee) {
			LOG.error("Errore imprevisto nella creazione dei comandi:" + cee.getMessage() + ", restituisco NOPCommand",
					cee);
			cmd = new NOPCommand();
		}
		return cmd;
	}

	/**
	 * Gestione della validazione
	 */
	public void validate() {
		/*PROTECTED REGION ID(R-963475072) ENABLED START*/
		/* Inserire la validazione */
		/*PROTECTED REGION END*/
	}

	/**
	 *	Metodo per la rimozione dalla sessione degli application data a scope
	 *  SAME_PAGE. 
	 */
	public void clearPageScopedAppData(String targetContentPanelName) {
		// non sapendo quale content panel si sta abbandonando vengono rimossi tutti
		// gli appdata a scope PAGE

	}

	protected void dumpModel(boolean pre) {
		// metodo intenzionalmente vuoto
	}

	protected void doBeforeEventCommand() {
		// il menu e' globale: non sono previsti before/after event commands
	}

	protected void doAfterEventCommand() {
		// il menu e' globale: non sono previsti before/after event commands
	}
}
