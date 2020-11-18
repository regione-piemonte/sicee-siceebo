package it.csi.sicee.siceebo.dto.ricercacertificatori;

import java.util.*;
import it.csi.sicee.siceebo.dto.*;
import it.csi.sicee.siceebo.dto.geo.*;
import it.csi.sicee.siceebo.dto.entiformativi.*;
import it.csi.sicee.siceebo.dto.certificatori.*;
import it.csi.sicee.siceebo.dto.ace.*;
import it.csi.sicee.siceebo.dto.backoffice.*;

import it.csi.sicee.siceebo.presentation.uiutils.*;
import flexjson.JSON;
import com.opensymphony.xwork2.conversion.annotations.*;
import com.opensymphony.xwork2.validator.annotations.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata alla Schermata [cpDettaglioCertificatore]
 */
@Validation
public class CpDettaglioCertificatoreModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

	/**
	 * imposta il valore dell' ApplicationData 'appDatacurrentUser'
	 * @param value
	 * @generated
	 */

	public void setAppDatacurrentUser(it.csi.sicee.siceebo.dto.UserInfo value) {
		getSession().put("appDatacurrentUser", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacurrentUser'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.UserInfo getAppDatacurrentUser() {
		return (it.csi.sicee.siceebo.dto.UserInfo) (getSession().get("appDatacurrentUser"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidCertificatoreSel'
	 * @param value
	 * @generated
	 */

	public void setAppDataidCertificatoreSel(java.lang.String value) {
		getSession().put("appDataidCertificatoreSel", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidCertificatoreSel'
	 * @generated
	 */
	public java.lang.String getAppDataidCertificatoreSel() {
		return (java.lang.String) (getSession().get("appDataidCertificatoreSel"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoMotivazioniBlocco'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoMotivazioniBlocco(
			java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Decodifica> value) {
		getSession().put("appDataelencoMotivazioniBlocco", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoMotivazioniBlocco'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Decodifica> getAppDataelencoMotivazioniBlocco() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Decodifica>) (getSession()
				.get("appDataelencoMotivazioniBlocco"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatoreDett'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatoreDett(it.csi.sicee.siceebo.dto.certificatori.Certificatore value) {
		getSession().put("appDatacertificatoreDett", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatoreDett'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.certificatori.Certificatore getAppDatacertificatoreDett() {
		return (it.csi.sicee.siceebo.dto.certificatori.Certificatore) (getSession().get("appDatacertificatoreDett"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacertificatoreList'
	 * @param value
	 * @generated
	 */

	public void setAppDatacertificatoreList(
			java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.Certificatore> value) {
		getSession().put("appDatacertificatoreList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacertificatoreList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.Certificatore> getAppDatacertificatoreList() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.Certificatore>) (getSession()
				.get("appDatacertificatoreList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatachiaviCurriculum'
	 * @param value
	 * @generated
	 */

	public void setAppDatachiaviCurriculum(
			java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.DocumentSummary> value) {
		getSession().put("appDatachiaviCurriculum", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatachiaviCurriculum'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.DocumentSummary> getAppDatachiaviCurriculum() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.DocumentSummary>) (getSession()
				.get("appDatachiaviCurriculum"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatachiaviTitoloStudio'
	 * @param value
	 * @generated
	 */

	public void setAppDatachiaviTitoloStudio(
			java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.DocumentSummary> value) {
		getSession().put("appDatachiaviTitoloStudio", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatachiaviTitoloStudio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.DocumentSummary> getAppDatachiaviTitoloStudio() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.DocumentSummary>) (getSession()
				.get("appDatachiaviTitoloStudio"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatachiaviAttPartNew'
	 * @param value
	 * @generated
	 */

	public void setAppDatachiaviAttPartNew(
			java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.CorsoAttestatoSummary> value) {
		getSession().put("appDatachiaviAttPartNew", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatachiaviAttPartNew'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.CorsoAttestatoSummary> getAppDatachiaviAttPartNew() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.CorsoAttestatoSummary>) (getSession()
				.get("appDatachiaviAttPartNew"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatachiaviAttPartOld'
	 * @param value
	 * @generated
	 */

	public void setAppDatachiaviAttPartOld(
			java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.DocumentSummary> value) {
		getSession().put("appDatachiaviAttPartOld", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatachiaviAttPartOld'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.DocumentSummary> getAppDatachiaviAttPartOld() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.DocumentSummary>) (getSession()
				.get("appDatachiaviAttPartOld"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatauidDaStampare'
	 * @param value
	 * @generated
	 */

	public void setAppDatauidDaStampare(java.lang.String value) {
		getSession().put("appDatauidDaStampare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatauidDaStampare'
	 * @generated
	 */
	public java.lang.String getAppDatauidDaStampare() {
		return (java.lang.String) (getSession().get("appDatauidDaStampare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataricercaAce'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaAce(it.csi.sicee.siceebo.dto.ace.FiltroRicercaAce value) {
		getSession().put("appDataricercaAce", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaAce'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.ace.FiltroRicercaAce getAppDataricercaAce() {
		return (it.csi.sicee.siceebo.dto.ace.FiltroRicercaAce) (getSession().get("appDataricercaAce"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataaceList'
	 * @param value
	 * @generated
	 */

	public void setAppDataaceList(java.util.ArrayList<it.csi.sicee.siceebo.dto.ace.Ace> value) {
		getSession().put("appDataaceList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaceList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.ace.Ace> getAppDataaceList() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.ace.Ace>) (getSession().get("appDataaceList"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodAceSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodAceSelezionato(java.lang.String value) {
		getSession().put("appDatacodAceSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodAceSelezionato'
	 * @generated
	 */
	public java.lang.String getAppDatacodAceSelezionato() {
		return (java.lang.String) (getSession().get("appDatacodAceSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapaginaProvenienza'
	 * @param value
	 * @generated
	 */

	public void setAppDatapaginaProvenienza(java.lang.String value) {
		getSession().put("appDatapaginaProvenienza", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapaginaProvenienza'
	 * @generated
	 */
	public java.lang.String getAppDatapaginaProvenienza() {
		return (java.lang.String) (getSession().get("appDatapaginaProvenienza"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacodAttestatoDaStampare'
	 * @param value
	 * @generated
	 */

	public void setAppDatacodAttestatoDaStampare(java.lang.String value) {
		getSession().put("appDatacodAttestatoDaStampare", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacodAttestatoDaStampare'
	 * @generated
	 */
	public java.lang.String getAppDatacodAttestatoDaStampare() {
		return (java.lang.String) (getSession().get("appDatacodAttestatoDaStampare"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataannullamentoApe'
	 * @param value
	 * @generated
	 */

	public void setAppDataannullamentoApe(it.csi.sicee.siceebo.dto.ace.Annullamento value) {
		getSession().put("appDataannullamentoApe", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataannullamentoApe'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.ace.Annullamento getAppDataannullamentoApe() {
		return (it.csi.sicee.siceebo.dto.ace.Annullamento) (getSession().get("appDataannullamentoApe"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamsgGenerico'
	 * @param value
	 * @generated
	 */

	public void setAppDatamsgGenerico(java.lang.String value) {
		getSession().put("appDatamsgGenerico", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamsgGenerico'
	 * @generated
	 */
	public java.lang.String getAppDatamsgGenerico() {
		return (java.lang.String) (getSession().get("appDatamsgGenerico"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// HiddenValue hdvFitt

	private java.lang.String widgHdvFitt;

	public void setWidg_hdvFitt(java.lang.String value) {
		widgHdvFitt = value;
	}

	public java.lang.String getWidg_hdvFitt() {
		return widgHdvFitt;
	}

	// Table tblTitoloStudioSummary

	private java.lang.String widgTblTitoloStudioSummary;

	public void setWidg_tblTitoloStudioSummary(java.lang.String value) {
		widgTblTitoloStudioSummary = value;
	}

	public java.lang.String getWidg_tblTitoloStudioSummary() {
		return widgTblTitoloStudioSummary;
	}

	// Table tblCurriculumSummary

	private java.lang.String widgTblCurriculumSummary;

	public void setWidg_tblCurriculumSummary(java.lang.String value) {
		widgTblCurriculumSummary = value;
	}

	public java.lang.String getWidg_tblCurriculumSummary() {
		return widgTblCurriculumSummary;
	}

	// Table tblAttPartNewSummary

	private java.lang.String widgTblAttPartNewSummary;

	public void setWidg_tblAttPartNewSummary(java.lang.String value) {
		widgTblAttPartNewSummary = value;
	}

	public java.lang.String getWidg_tblAttPartNewSummary() {
		return widgTblAttPartNewSummary;
	}

	// Table tblAttPartOldSummary

	private java.lang.String widgTblAttPartOldSummary;

	public void setWidg_tblAttPartOldSummary(java.lang.String value) {
		widgTblAttPartOldSummary = value;
	}

	public java.lang.String getWidg_tblAttPartOldSummary() {
		return widgTblAttPartOldSummary;
	}

}
