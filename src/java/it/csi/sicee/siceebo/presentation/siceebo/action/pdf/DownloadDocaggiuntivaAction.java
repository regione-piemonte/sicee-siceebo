package it.csi.sicee.siceebo.presentation.siceebo.action.pdf;

import it.csi.sicee.siceebo.business.facade.*;
import it.csi.sicee.siceebo.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceebo.dto.ace.DocumentoAggiuntivo;
import it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction;
import it.csi.sicee.siceebo.presentation.siceebo.action.CommandExecutionException;
import it.csi.sicee.siceebo.presentation.siceebo.action.ICommand;
import it.csi.sicee.siceeorch.dto.siceeorch.Documento;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DownloadDocaggiuntivaAction extends BaseAction<BaseSessionAwareDTO> {

	private BaseSessionAwareDTO model;
	private String contentDisposition;
	private String contentType;
	private InputStream inputStream;
	private AceMgr aceMgr;

	@Override
	public String execute() {
		String contentType = "application/download";
		String contentDisp = "attachment;filename=";
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		String uidDocumentoAggiuntivo = null;
		try {
			uidDocumentoAggiuntivo = (String) session.get("appDatauidDocumentoSelezionato");
			Documento doc = soaIntegrationMgr.recuperaDocumento(uidDocumentoAggiuntivo);
			if(doc.getDoc()!=null) {
				contentDisp +=doc.getNome();
				setContentDisposition(contentDisp);
				setContentType(contentType);
				setInputStream(new ByteArrayInputStream(doc.getDoc()));
				return "downloadFile";
			}else
				return "KO";

		} catch (Exception e) {
			LOG.error("Errore download documento", e);
		}

		return "KO";
	}

	@Override
	public Class modelClass() {
		return null;
	}

	@Override
	public BaseSessionAwareDTO getModel() {
		return null;
	}

	@Override
	public void setModel(BaseSessionAwareDTO baseSessionAwareDTO) {

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
	protected ICommand initCommand(String moduleName, String panelName, String widgName, String eventName) {
		return null;
	}

	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {

	}

	private MiscMgr miscMgr;

	public AceMgr getAceMgr() {
		return aceMgr;
	}

	public void setAceMgr(AceMgr aceMgr) {
		this.aceMgr = aceMgr;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private CertificatoreMgr certificatoreMgr;

	public CertificatoreMgr getCertificatoreMgr() {
		return certificatoreMgr;
	}

	public void setCertificatoreMgr(CertificatoreMgr certificatoreMgr) {
		this.certificatoreMgr = certificatoreMgr;
	}

	private CertificatoMgr certificatoMgr;

	public CertificatoMgr getCertificatoMgr() {
		return certificatoMgr;
	}

	public void setCertificatoMgr(CertificatoMgr certificatoMgr) {
		this.certificatoMgr = certificatoMgr;
	}

	private SOAIntegrationMgr soaIntegrationMgr;

	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
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

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
