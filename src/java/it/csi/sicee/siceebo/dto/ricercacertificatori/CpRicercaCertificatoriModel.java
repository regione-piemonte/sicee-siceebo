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
 * logica di business associata alla Schermata [cpRicercaCertificatori]
 */
@Validation
public class CpRicercaCertificatoriModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataricercaCertificatori'
	 * @param value
	 * @generated
	 */

	public void setAppDataricercaCertificatori(
			it.csi.sicee.siceebo.dto.certificatori.FiltroRicercaCertificatori value) {
		getSession().put("appDataricercaCertificatori", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataricercaCertificatori'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.certificatori.FiltroRicercaCertificatori getAppDataricercaCertificatori() {
		return (it.csi.sicee.siceebo.dto.certificatori.FiltroRicercaCertificatori) (getSession()
				.get("appDataricercaCertificatori"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatitoli'
	 * @param value
	 * @generated
	 */

	public void setAppDatatitoli(java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.Titolo> value) {
		getSession().put("appDatatitoli", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatitoli'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.Titolo> getAppDatatitoli() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.certificatori.Titolo>) (getSession().get("appDatatitoli"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
