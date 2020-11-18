/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.presentation.siceebo.action.entiformativi;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Preparable;
import com.opensymphony.xwork2.validator.annotations.*;

import it.csi.sicee.siceebo.dto.*;
import it.csi.sicee.siceebo.dto.entiformativi.Corso;
import it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo;
import it.csi.sicee.siceebo.dto.entiformativi.Partecipante;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoCorso;
import it.csi.sicee.siceebo.business.facade.MiscMgr;
import it.csi.sicee.siceebo.business.print.dto.StampaAttestatoDto;
import it.csi.sicee.siceebo.business.print.extended.StampaAttestato;
import it.csi.sicee.siceebo.presentation.siceebo.action.*;
import it.csi.sicee.siceebo.util.GenericUtil;

/**
 * CpRegistrazAction Action Class.
 * 
 * @author GuiGen
 */

public class CpStampaAttestatoAction extends BaseAction<BaseSessionAwareDTO> implements Preparable {

	private String inputName;

	public String getInputName() {
		return inputName;
	}

	public void setInputName(String inputName) {
		this.inputName = inputName;
	}

	public void setAppDatadettaglioCorso(
			it.csi.sicee.siceebo.dto.entiformativi.Corso value) {
		getSession().put("appDatadettaglioCorso", value);
	}

	public it.csi.sicee.siceebo.dto.entiformativi.Corso getAppDatadettaglioCorso() {
		return (it.csi.sicee.siceebo.dto.entiformativi.Corso) (getSession()
				.get("appDatadettaglioCorso"));
	}

	public void setAppDataenteFormativo(
			it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo value) {
		getSession().put("appDataenteFormativo", value);
	}

	public it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo getAppDataenteFormativo() {
		return (it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo) (getSession()
				.get("appDataenteFormativo"));
	}

	public void setAppDatadettaglioPartecipante(
			it.csi.sicee.siceebo.dto.entiformativi.Partecipante value) {
		getSession().put("appDatadettaglioPartecipante", value);
	}

	public it.csi.sicee.siceebo.dto.entiformativi.Partecipante getAppDatadettaglioPartecipante() {
		return (it.csi.sicee.siceebo.dto.entiformativi.Partecipante) (getSession()
				.get("appDatadettaglioPartecipante"));
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
		LOG.debug("[CpStampaAttestatoAction::execute] BEGIN");

		Partecipante partecipante = getAppDatadettaglioPartecipante();
		Corso corso = getAppDatadettaglioCorso();
		EnteFormativo ente = getAppDataenteFormativo();

		try {
			StampaAttestatoDto dto = new StampaAttestatoDto();

			dto.setNome(partecipante.getNome());
			dto.setCognome(partecipante.getCognome());
			dto.setLuogoNascita(partecipante.getLuogoNascita());
			dto.setDataNascita(partecipante.getDataNascita());
			dto.setFkTipoIstruzione(partecipante.getFkTipoIstruzione());
			dto.setNumCertificatore(partecipante.getNumCertificatore());
			dto.setAlbo(partecipante.getAlbo());
			dto.setDescProvAlbo(partecipante.getDescProvAlbo());
			dto.setNumIscrAlbo(partecipante.getNumIscrAlbo());
			dto.setDataIscrAlbo(partecipante.getDataIscrAlbo());
			dto.setPercFreq(partecipante.getPercFreq());
			dto.setDataEsame(partecipante.getDataEsame());
			dto.setEsitoEsame(partecipante.getEsitoEsame());
			dto.setVotoEsame(partecipante.getVotoEsame());

			SiceeDTipoCorso tipoCorso = getMiscMgr().getTipoCorsoById(corso.getIdTipoCorso());
			dto.setDescrizioneAttestato(tipoCorso.getDescrizioneAttestato());
			//dto.setTipoCorso2(corso.getTipoCorso2());
			
			
			
			dto.setNumCorso(corso.getNumCorso());
			dto.setAnnoFormativo(corso.getAnnoFormativo());
			dto.setTitolo(corso.getTitolo());
			dto.setTotaleOre(corso.getTotaleOre());
			dto.setDataDal(corso.getDataDal());
			dto.setDataAl(corso.getDataAl());
			//dto.setPartecipanti(corso.getPartecipanti());
			dto.setProtApprov(corso.getProtApprov());
			dto.setDataApprov(corso.getDataApprov());
			dto.setLuogoCorso(corso.getLuogoCorso());
			
			dto.setDenominazione(ente.getDenominazione());
			dto.setDescComune(ente.getDescComune());
			dto.setDescProv(ente.getDescProv());
			dto.setDescIndirizzo(ente.getDescIndirizzo());
			dto.setNumCivico(ente.getNumCivico());
			dto.setBase64Logo(ente.getBase64Logo());
			dto.setParametriLogo(ente.getParametriLogo());
			
			StampaAttestato ext = new StampaAttestato();

			//gestione logo
			/*
			InputStream ioBf = ServletActionContext.getServletContext()
					.getResourceAsStream("/img/logo.jpg");
			// FileInputStream ioBf = new FileInputStream(FOTOFILE);
			byte[] b = new byte[ioBf.available()];
			ioBf.read(b);
			dto.setLogo(b);
			*/
			ByteArrayInputStream filePdf = ext.stampaModulo(dto,
					ServletActionContext.getServletContext(), null, false);
			inputStream = filePdf;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			LOG.debug("[CpStampaAttestatoAction::execute] END");
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return "report";

	}

	private MiscMgr miscMgr = null;

	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}

	public void validate() {

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
