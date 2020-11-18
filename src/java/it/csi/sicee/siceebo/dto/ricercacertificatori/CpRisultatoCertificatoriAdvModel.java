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
 * logica di business associata alla Schermata [cpRisultatoCertificatoriAdv]
 */
@Validation
public class CpRisultatoCertificatoriAdvModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataidMotivoBloccoSel'
	 * @param value
	 * @generated
	 */

	public void setAppDataidMotivoBloccoSel(java.lang.String value) {
		getSession().put("appDataidMotivoBloccoSel", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidMotivoBloccoSel'
	 * @generated
	 */
	public java.lang.String getAppDataidMotivoBloccoSel() {
		return (java.lang.String) (getSession().get("appDataidMotivoBloccoSel"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
