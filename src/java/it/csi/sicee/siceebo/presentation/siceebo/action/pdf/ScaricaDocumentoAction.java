/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.presentation.siceebo.action.pdf;

import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction;
import it.csi.sicee.siceebo.presentation.siceebo.action.ICommand;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceeorch.dto.siceeorch.Documento;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

public class ScaricaDocumentoAction extends BaseAction<BaseSessionAwareDTO> {

	private SOAIntegrationMgr soaIntegrationMgr;
	private String inputName;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	
	
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	
//	public int getBufferSize() {
//		return bufferSize;
//	}
//
//	public void setBufferSize(int bufferSize) {
//		this.bufferSize = bufferSize;
//	}
	
	public String getContentDisposition() {
		return contentDisposition;
	}

	public String getContentType() {
		return contentType;
	}

	

	private String contentDisposition;
	public String getInputName() {
		return inputName;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

//	private int bufferSize;
	private String contentType;
	private String filename;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String execute() throws Exception {
		
		LOG.debug("[ScaricaDocumentoAction::execute] BEGIN");
		try {
			
			 String uid = getAppDatauid();
				
			 LOG.debug("uid: " + uid);
			 		 
			Documento doc = getSoaIntegrationMgr().recuperaDocumento(uid);
			if (doc.getDoc() != null) {
				if (doc.getMimeType() != null
						&& !doc.getMimeType().trim().equals("")) {
					contentType = doc.getMimeType();
				} else {
					contentType = "application/download";
				}

				contentDisposition = "attachment; filename=\"" + doc.getNome()
						+ "\";";

				inputStream = new ByteArrayInputStream(doc.getDoc());
			}
		 
		 
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[ScaricaDocumentoAction::execute] END");
		}
		return SUCCESS;
	}
	
	public java.lang.String getAppDatauid() {
		return (java.lang.String) (getSession().get(Constants.SESSIONE_VAR_UID_INDEX));
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class modelClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseSessionAwareDTO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setModel(BaseSessionAwareDTO t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void dumpModel(boolean pre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doBeforeEventCommand() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doAfterEventCommand() {
		// TODO Auto-generated method stub
		
	}




	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	


}
