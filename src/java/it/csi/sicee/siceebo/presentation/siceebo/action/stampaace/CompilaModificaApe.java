/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.presentation.siceebo.action.stampaace;

//import it.csi.sicee.siceebo.business.facade.Message;
import it.csi.sicee.siceebo.business.pdf.ModuloBuilder;
import it.csi.sicee.siceebo.business.facade.CertificatoreMgr;
import it.csi.sicee.siceebo.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction;
import it.csi.sicee.siceebo.presentation.siceebo.action.CommandExecutionException;
import it.csi.sicee.siceebo.presentation.siceebo.action.ICommand;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.Messages;


import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class CompilaModificaApe extends BaseAction<BaseSessionAwareDTO> {

	private static final long serialVersionUID = 1L;
	private BaseSessionAwareDTO model;
	private InputStream inputStream;
	private String inputName;
	private String contentDisposition;
	private String contentType;
	
	private CertificatoreMgr certificatoreMgr;
	private ModuloBuilder moduloBuilder;

	public java.lang.String getAppDataCodAttestatoDaStampare() {
		return (java.lang.String) (getSession()
				.get("appDatacodAttestatoDaStampare"));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute()
	{
		
		String contentType = "application/download";
		String contentDisp = "attachment;filename=ape.pdf";

		LOG.debug("ricerco ape");
		try
		{
			String numeroCertificato = getAppDataCodAttestatoDaStampare();
			LOG.debug("numeroCertificato: " + numeroCertificato);

			String[] split = numeroCertificato.split(" ");

			String idCertificatore = getCertificatoreMgr().findIdCertificatoreFromNumCertificatore(split[1]);
			String progrCertificato = split[2];
			String anno = split[0];
			
			LOG.debug("idCertificatore: " + idCertificatore);
			LOG.debug("progrCertificato: " + progrCertificato);
			LOG.debug("anno: " + anno);
			
			moduloBuilder.setIdCertificatore(idCertificatore);
			moduloBuilder.setProgrCertificato(progrCertificato);
			moduloBuilder.setAnno(anno);


			byte[] ape = null;
			//ape = getModuloBuilder().showApe();
			ape = getModuloBuilder().showApeIText();
			if(ape!=null)
			{
				setInputStream(new ByteArrayInputStream(ape));
				LOG.debug("ape aggiunto");
				setContentDisposition(contentDisp);
				setContentType(contentType);
				return "downloadFile";
			}
			else
			{
				LOG.error("CompilaModificaApe: Errore (ape non trovato) su apertura ape");
				//session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_DB, Message.ERROR));
				return "KO";
			}
			
		}
		catch (Exception ex)
		{
			LOG.error("CompilaModificaApe: Errore (exception) su apertura ape", ex);
			//session.put(Constants.SESSIONE_VAR_MESSAGGE, new Message(Messages.ERROR_RECUPERO_DB, Message.ERROR));
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

	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getInputName() {
		return inputName;
	}
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public String getContentDisposition() {
		return contentDisposition;
	}
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	

	public ModuloBuilder getModuloBuilder() {
		return moduloBuilder;
	}
	public void setModuloBuilder(ModuloBuilder moduloBuilder) {
		this.moduloBuilder = moduloBuilder;
	}

	public CertificatoreMgr getCertificatoreMgr() {
		return this.certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	
}
