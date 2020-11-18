package it.csi.sicee.siceebo.dto.ricercaace;

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
 * logica di business associata alla Schermata [cpSostitutiAce]
 */
@Validation
public class CpSostitutiAceModel extends BaseSessionAwareDTO {

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

	// Table tblElencoSostituzioniAce

	private java.lang.String widgTblElencoSostituzioniAce;

	public void setWidg_tblElencoSostituzioniAce(java.lang.String value) {
		widgTblElencoSostituzioniAce = value;
	}

	public java.lang.String getWidg_tblElencoSostituzioniAce() {
		return widgTblElencoSostituzioniAce;
	}

}
