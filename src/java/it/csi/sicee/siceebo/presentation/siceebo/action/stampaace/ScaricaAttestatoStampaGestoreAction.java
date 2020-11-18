/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.presentation.siceebo.action.stampaace;

import it.csi.sicee.siceebo.business.facade.AceMgr;
import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.dto.BaseSessionAwareDTO;
import it.csi.sicee.siceebo.dto.ace.Ace;
import it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction;
import it.csi.sicee.siceebo.presentation.siceebo.action.ICommand;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceeorch.dto.siceeorch.Documento;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;


// TODO: Auto-generated Javadoc
/**
 * The Class ScaricaAttestatoStampaGestoreAction.
 */
public class ScaricaAttestatoStampaGestoreAction extends BaseAction<BaseSessionAwareDTO> {

	/** The ace mgr. */
	private AceMgr aceMgr;

	/**
	 * Gets the ace mgr.
	 *
	 * @return the ace mgr
	 */
	public AceMgr getAceMgr() {
		return aceMgr;
	}

	/**
	 * Sets the ace mgr.
	 *
	 * @param aceMgr the new ace mgr
	 */
	public void setAceMgr(AceMgr aceMgr) {
		this.aceMgr = aceMgr;
	}
	
	/** The soa integration mgr. */
	private SOAIntegrationMgr soaIntegrationMgr;

	/**
	 * Gets the soa integration mgr.
	 *
	 * @return the soa integration mgr
	 */
	public SOAIntegrationMgr getSoaIntegrationMgr() {
		return soaIntegrationMgr;
	}

	/**
	 * Sets the soa integration mgr.
	 *
	 * @param soaIntegrationMgr the new soa integration mgr
	 */
	public void setSoaIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	/** The input name. */
	private String inputName;
	
	/**
	 * Sets the input name.
	 *
	 * @param inputName the new input name
	 */
	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	
	/**
	 * Gets the buffer size.
	 *
	 * @return the buffer size
	 */
//	public int getBufferSize() {
//		return bufferSize;
//	}

	/**
	 * Sets the buffer size.
	 *
	 * @param bufferSize the new buffer size
	 */
//	public void setBufferSize(int bufferSize) {
//		this.bufferSize = bufferSize;
//	}
	
	/**
	 * Gets the content disposition.
	 *
	 * @return the content disposition
	 */
	public String getContentDisposition() {
		return contentDisposition;
	}
	
	/**
	 * Gets the content type.
	 *
	 * @return the content type
	 */
	public String getContentType() {
		return contentType;
	}

	/** The content disposition. */
	private String contentDisposition;
	
	/**
	 * Gets the input name.
	 *
	 * @return the input name
	 */
	public String getInputName() {
		return inputName;
	}

	/**
	 * Sets the content disposition.
	 *
	 * @param contentDisposition the new content disposition
	 */
	public void setContentDisposition(String contentDisposition) {
		this.contentDisposition = contentDisposition;
	}

	/**
	 * Sets the content type.
	 *
	 * @param contentType the new content type
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/** The input stream. */
	private InputStream inputStream;
	
	/**
	 * Gets the input stream.
	 *
	 * @return the input stream
	 */
	public InputStream getInputStream() {
		return inputStream;
	}
	
	/**
	 * Sets the input stream.
	 *
	 * @param inputStream the new input stream
	 */
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	/** The buffer size. */
//	private int bufferSize;
	
	/** The content type. */
	private String contentType;
	
	/** The filename. */
	private String filename;

	/**
	 * Gets the filename.
	 *
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Sets the filename.
	 *
	 * @param filename the new filename
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	public java.lang.String getAppDataCodAttestatoDaStampare() {
		return (java.lang.String) (getSession()
				.get("appDatacodAttestatoDaStampare"));
	}
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute() throws Exception {

		LOG.debug("[ScaricaAttestatoStampaMonitoraggioAction::execute] BEGIN");
		try {

			//Documento doc = null;
			String numeroCertificato = getAppDataCodAttestatoDaStampare();

			LOG.debug("numeroCertificato: " + numeroCertificato);
			
			Documento doc = null;
			 // Da implementare quando si farà il servizio del rercupero stampa
			
			boolean isAttestatoOld = getAceMgr().isAttestatoOld(numeroCertificato);
			Ace certificato = getAceMgr().findAce(numeroCertificato, isAttestatoOld);
			String nomeFile = null;

//			Ace certificato = getAppDataaceList().get(0);
//			String nomeFile = null;
//			
//			boolean isAttestatoOld = getAceMgr().isAttestatoOld(certificato.getCodice());

			if (isAttestatoOld)
			{
				if (certificato.getIdStato() == Constants.ANNULLATO || certificato.getIdStato() == Constants.ANNULLATO_BO) {
					byte[] byteDoc = getSoaIntegrationMgr().getStampaDocumentoAnnullato(numeroCertificato);
					inputStream = new ByteArrayInputStream(byteDoc);
				
					nomeFile = certificato.getCodice()
					.replaceAll(" ", "_") + "_annullato.pdf";
					
					contentType = "application/download";
					
					//contentDisposition = "attachment; filename=\"" + nomeFile + "\";";
					
				}
				else {
						String numeroAttestato = certificato.getCodice();
						byte[] certificatoByte = getSoaIntegrationMgr().getStampaCertificato(numeroAttestato, "ANTEPRIMA");
						
						if (certificatoByte != null) {
						
							ByteArrayInputStream filePdf = new ByteArrayInputStream(certificatoByte);
							inputStream = filePdf;
							nomeFile = numeroAttestato.replaceAll(" ", "_") + "_bozza.pdf";
							//contentDisposition = "attachment; filename=\"" + nomeFile + "\";";
						}
						else {
							addActionError("Certificato non disponibile.");
							return NONE;
						}
					//}
					
				}
			}
			else
			{
				
				String uidDoc = getSoaIntegrationMgr().findUidRifIndex(certificato, Constants.ID_PDF_APE_CONSOLIDATO);
				doc = getSoaIntegrationMgr().recuperaDocumento(uidDoc);
				nomeFile = doc.getNome();
				inputStream = new ByteArrayInputStream(doc.getDoc());
				contentType = doc.getMimeType();
				
//				String uidDoc = getSoaIntegrationMgr().findUidRifIndex(certificato, Constants.ID_PDF_APE_CONSOLIDATO);
//				Documento doc = getSoaIntegrationMgr().recuperaDocumento(uidDoc);
//				nomeFile = doc.getNome();
//				inputStream = new ByteArrayInputStream(doc.getDoc());
//				contentType = doc.getMimeType();
//				contentDisposition = "attachment; filename=\"" + nomeFile + "\";";

			}
			contentDisposition = "attachment; filename=\"" + nomeFile + "\";";


		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			addActionError("Si e' verificato un errore. Non e' stato possibile generare il documento.");
			return NONE;
		} finally {
			LOG.debug("[ScaricaAttestatoStampaMonitoraggioAction::execute] END");
		}
		return SUCCESS;
	}
	
	



	/*
	public it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore getAppDatacertificatore() {
		return (it.csi.sicee.siceeweb.dto.certificatore.DatiCertificatore) (getSession()
				.get("appDatacertificatore"));
	}
	
	public it.csi.sicee.siceeweb.dto.attestati.DatiAttestato getAppDatacertificato() {
		return (it.csi.sicee.siceeweb.dto.attestati.DatiAttestato) (getSession()
				.get("appDatacertificato"));
	}
*/	
	/*public java.lang.String getAppDataCodAttestatoDaStampare() {
		return (java.lang.String) (getSession()
				.get("appDatacodAttestatoDaStampare"));
	}*/
	
	/**
	 * Gets the app dataace list.
	 *
	 * @return the app dataace list
	 */
	public List<it.csi.sicee.siceebo.dto.ace.Ace> getAppDataaceList() {
		return (List<it.csi.sicee.siceebo.dto.ace.Ace>) (getSession()
				.get("appDataaceList"));
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction#clearPageScopedAppData(java.lang.String)
	 */
	@Override
	public void clearPageScopedAppData(String targetContentPanelName) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction#modelClass()
	 */
	@Override
	public Class modelClass() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction#getModel()
	 */
	@Override
	public BaseSessionAwareDTO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction#setModel(it.csi.sicee.siceebo.dto.BaseSessionAwareDTO)
	 */
	@Override
	public void setModel(BaseSessionAwareDTO t) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction#dumpModel(boolean)
	 */
	@Override
	protected void dumpModel(boolean pre) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction#doBeforeEventCommand()
	 */
	@Override
	protected void doBeforeEventCommand() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction#doAfterEventCommand()
	 */
	@Override
	protected void doAfterEventCommand()  {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see it.csi.sicee.siceebo.presentation.siceebo.action.BaseAction#initCommand(java.lang.String, java.lang.String)
	 */
	@Override
	protected ICommand initCommand(String moduleName, String panelName,
			String widgName, String eventName) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	


}
