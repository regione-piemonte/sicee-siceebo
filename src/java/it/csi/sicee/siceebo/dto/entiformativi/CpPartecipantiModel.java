package it.csi.sicee.siceebo.dto.entiformativi;

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
 * logica di business associata alla Schermata [cpPartecipanti]
 */
@Validation
public class CpPartecipantiModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataregione'
	 * @param value
	 * @generated
	 */

	public void setAppDataregione(java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Regione> value) {
		getSession().put("appDataregione", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataregione'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Regione> getAppDataregione() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Regione>) (getSession().get("appDataregione"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataprovince'
	 * @param value
	 * @generated
	 */

	public void setAppDataprovince(java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Provincia> value) {
		getSession().put("appDataprovince", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataprovince'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Provincia> getAppDataprovince() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Provincia>) (getSession().get("appDataprovince"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacomuni'
	 * @param value
	 * @generated
	 */

	public void setAppDatacomuni(java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Comune> value) {
		getSession().put("appDatacomuni", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacomuni'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Comune> getAppDatacomuni() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Comune>) (getSession().get("appDatacomuni"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatacorsi'
	 * @param value
	 * @generated
	 */

	public void setAppDatacorsi(java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Corso> value) {
		getSession().put("appDatacorsi", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatacorsi'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Corso> getAppDatacorsi() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Corso>) (getSession().get("appDatacorsi"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidCorsoSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidCorsoSelezionato(java.lang.Long value) {
		getSession().put("appDataidCorsoSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidCorsoSelezionato'
	 * @generated
	 */
	public java.lang.Long getAppDataidCorsoSelezionato() {
		return (java.lang.Long) (getSession().get("appDataidCorsoSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamodalitaDettaglioCorso'
	 * @param value
	 * @generated
	 */

	public void setAppDatamodalitaDettaglioCorso(java.lang.String value) {
		getSession().put("appDatamodalitaDettaglioCorso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamodalitaDettaglioCorso'
	 * @generated
	 */
	public java.lang.String getAppDatamodalitaDettaglioCorso() {
		return (java.lang.String) (getSession().get("appDatamodalitaDettaglioCorso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidPartecipanteSelezionato'
	 * @param value
	 * @generated
	 */

	public void setAppDataidPartecipanteSelezionato(java.lang.Long value) {
		getSession().put("appDataidPartecipanteSelezionato", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidPartecipanteSelezionato'
	 * @generated
	 */
	public java.lang.Long getAppDataidPartecipanteSelezionato() {
		return (java.lang.Long) (getSession().get("appDataidPartecipanteSelezionato"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatapartecipanti'
	 * @param value
	 * @generated
	 */

	public void setAppDatapartecipanti(java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Partecipante> value) {
		getSession().put("appDatapartecipanti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatapartecipanti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Partecipante> getAppDatapartecipanti() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Partecipante>) (getSession()
				.get("appDatapartecipanti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamodalitaDettaglioPartecipante'
	 * @param value
	 * @generated
	 */

	public void setAppDatamodalitaDettaglioPartecipante(java.lang.String value) {
		getSession().put("appDatamodalitaDettaglioPartecipante", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamodalitaDettaglioPartecipante'
	 * @generated
	 */
	public java.lang.String getAppDatamodalitaDettaglioPartecipante() {
		return (java.lang.String) (getSession().get("appDatamodalitaDettaglioPartecipante"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadettaglioCorso'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioCorso(it.csi.sicee.siceebo.dto.entiformativi.Corso value) {
		getSession().put("appDatadettaglioCorso", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioCorso'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.entiformativi.Corso getAppDatadettaglioCorso() {
		return (it.csi.sicee.siceebo.dto.entiformativi.Corso) (getSession().get("appDatadettaglioCorso"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipoRuoloUtente'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipoRuoloUtente(java.lang.String value) {
		getSession().put("appDatatipoRuoloUtente", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipoRuoloUtente'
	 * @generated
	 */
	public java.lang.String getAppDatatipoRuoloUtente() {
		return (java.lang.String) (getSession().get("appDatatipoRuoloUtente"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataenteFormativo'
	 * @param value
	 * @generated
	 */

	public void setAppDataenteFormativo(it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo value) {
		getSession().put("appDataenteFormativo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataenteFormativo'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo getAppDataenteFormativo() {
		return (it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo) (getSession().get("appDataenteFormativo"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
