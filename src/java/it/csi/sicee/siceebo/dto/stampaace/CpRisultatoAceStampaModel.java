package it.csi.sicee.siceebo.dto.stampaace;

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
 * logica di business associata alla Schermata [cpRisultatoAceStampa]
 */
@Validation
public class CpRisultatoAceStampaModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataaceSostituzioneList'
	 * @param value
	 * @generated
	 */

	public void setAppDataaceSostituzioneList(java.util.ArrayList<it.csi.sicee.siceebo.dto.ace.Ace> value) {
		getSession().put("appDataaceSostituzioneList", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataaceSostituzioneList'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.ace.Ace> getAppDataaceSostituzioneList() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.ace.Ace>) (getSession().get("appDataaceSostituzioneList"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tblRisultatoAce

	private it.csi.sicee.siceebo.dto.ace.Ace widgTblRisultatoAce;

	public void setWidg_tblRisultatoAce(it.csi.sicee.siceebo.dto.ace.Ace value) {
		widgTblRisultatoAce = value;
	}

	public it.csi.sicee.siceebo.dto.ace.Ace getWidg_tblRisultatoAce() {
		return widgTblRisultatoAce;
	}

}
