/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.presentation.siceebo.action.stampaace;

//import it.csi.sicee.siceebo.business.facade.Message;
import it.csi.sicee.siceebo.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction;
import it.csi.sicee.siceebo.presentation.siceebo.action.CommandExecutionException;
import it.csi.sicee.siceebo.presentation.siceebo.action.ICommand;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.Messages;


import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.Preparable;

public class AnnullaApeXml extends BaseAction<BaseSessionAwareDTO> implements Preparable,ServletRequestAware {

	
	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute()
	{
		LOG.info("execute di AnnullaApeXml");
		try
		{
			LOG.info("OK");
			return "OK";
		}
		catch (Exception ex)
		{
			//session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_UPDATE_DB, Message.ERROR));
			LOG.error("Errore annulla ape",ex);
			return "KO";
		}
	}
	

	@SuppressWarnings("rawtypes")
	public Class modelClass() {
		return getClass();
	}

	public BaseSessionAwareDTO getModel() {
		return this.model;
	}

	public void setModel(BaseSessionAwareDTO t) {
		this.model = t;
	}

	@Override
	protected void dumpModel(boolean pre) {
		
	}

	@Override
	protected void doBeforeEventCommand() throws CommandExecutionException {
		
	}

	@Override
	protected void doAfterEventCommand() throws CommandExecutionException {
	}

	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		
	}
	
	private HttpServletRequest request;
	
	public HttpServletRequest getServletRequest() {
		return request;
	}

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
			
}
