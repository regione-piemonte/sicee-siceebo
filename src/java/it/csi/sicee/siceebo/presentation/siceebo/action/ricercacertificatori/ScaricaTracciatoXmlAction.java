/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.presentation.siceebo.action.ricercacertificatori;

import it.csi.sicee.siceebo.business.facade.CertificatoMgr;
import it.csi.sicee.siceebo.business.facade.CertificatoreMgr;
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction;
import it.csi.sicee.siceebo.presentation.siceebo.action.ICommand;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.Validation;

/**
 * CpRegistrazAction Action Class.
 * 
 * @author GuiGen
 */

public class ScaricaTracciatoXmlAction extends BaseAction<BaseSessionAwareDTO> implements Preparable {

	private String inputName;
	
	private String contentDisposition;

	public String getContentDisposition() {
		return contentDisposition;
	}

	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	
	public void setAppDatacodAttestatoDaStampare(java.lang.String value) {
		getSession().put("appDatacodAttestatoDaStampare", value);
	}

	public java.lang.String getAppDatacodAttestatoDaStampare() {
		return (java.lang.String) (getSession()
				.get("appDatacodAttestatoDaStampare"));
	}

	

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	private InputStream inputStream;

	// ///////////////////////////////////////
	// / property comuni a tutte le action
	// ///////////////////////////////////////

	/**
	 * I singoli eventi sui singoli widget sono gestiti dai metodi specifici
	 * 
	 * @return SUCCESS.
	 */

	public String execute() throws Exception {
		LOG.debug("[CpRicevutaInvioAction::execute] BEGIN");

		try {


			String numeroAttestato = getAppDatacodAttestatoDaStampare();

			LOG.debug("numeroCertificato: " + numeroAttestato);

			String[] split = numeroAttestato.split(" ");

			String idCertificatore = getCertificatoreMgr().findIdCertificatoreFromNumCertificatore(split[1]);
			String progrCertificato = split[2];
			String anno = split[0];
			
			LOG.debug("idCertificatore: " + idCertificatore);
			LOG.debug("progrCertificato: " + progrCertificato);
			LOG.debug("anno: " + anno);
			
			
			byte[] certificato = getCertificatoMgr().recuperaTracciatoImportXml(idCertificatore, progrCertificato, anno);


			
			if (certificato != null) {

				ByteArrayInputStream filePdf = new ByteArrayInputStream(
						certificato);

				inputStream = filePdf;

				setContentDisposition("attachment; filename=\"tracciato_xml.xml\";");

			}
		
		} finally {
			LOG.debug("[CpRicevutaInvioAction::execute] END");
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return "report";
	}

	
	private SOAIntegrationMgr soaIntegrationMgr;
	private CertificatoreMgr certificatoreMgr;
	private CertificatoMgr certificatoMgr;
	
	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	public CertificatoreMgr getCertificatoreMgr() {
		return this.certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}
	
	public CertificatoMgr getCertificatoMgr() {
		return this.certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}
	public void validate() {

	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
	}

	@Override
	public Class modelClass() {
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
	protected void doBeforeEventCommand()  {
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
