package it.csi.sicee.siceebo.dto.backoffice;

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
 * logica di business associata alla Schermata [cpStoricizzazioneLogAccesso]
 */
@Validation
public class CpStoricizzazioneLogAccessoModel extends BaseSessionAwareDTO {

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
	 * @generated
	 */
	private it.csi.sicee.siceebo.dto.backoffice.RiepilogoStoricizzazione appDatariepilogoStoricizzazione = null;

	/**
	 * imposta il valore dell' ApplicationData 'appDatariepilogoStoricizzazione'
	 * @param value
	 * @generated
	 */

	public void setAppDatariepilogoStoricizzazione(it.csi.sicee.siceebo.dto.backoffice.RiepilogoStoricizzazione value) {
		appDatariepilogoStoricizzazione = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatariepilogoStoricizzazione'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.backoffice.RiepilogoStoricizzazione getAppDatariepilogoStoricizzazione() {
		return appDatariepilogoStoricizzazione;
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
