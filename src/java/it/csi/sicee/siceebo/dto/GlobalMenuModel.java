package it.csi.sicee.siceebo.dto;

import java.util.*;
import com.opensymphony.xwork2.validator.annotations.*;
import it.csi.sicee.siceebo.dto.geo.*;
import it.csi.sicee.siceebo.dto.entiformativi.*;
import it.csi.sicee.siceebo.dto.certificatori.*;
import it.csi.sicee.siceebo.dto.ace.*;
import it.csi.sicee.siceebo.dto.backoffice.*;

/**
 * Questo DTO incapsula tutto il contenuto informativo necessario all'esecuzione della
 * logica di business associata al Menu
 */
public class GlobalMenuModel extends BaseSessionAwareDTO {

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	////////////////////////////////////////////////////////////////////
	/// application data
	////////////////////////////////////////////////////////////////////

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

}
