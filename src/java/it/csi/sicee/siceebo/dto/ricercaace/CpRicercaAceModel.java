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
 * logica di business associata alla Schermata [cpRicercaAce]
 */
@Validation
public class CpRicercaAceModel extends BaseSessionAwareDTO {

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
	 * @generated
	 */
	private java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue> appDatamotivazioneRilascio = new java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue>();

	/**
	 * imposta il valore dell' ApplicationData 'appDatamotivazioneRilascio'
	 * @param value
	 * @generated
	 */

	public void setAppDatamotivazioneRilascio(java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue> value) {
		appDatamotivazioneRilascio = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamotivazioneRilascio'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue> getAppDatamotivazioneRilascio() {
		return appDatamotivazioneRilascio;
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
	 * @generated
	 */
	private java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue> appDataclasseEnergetica = new java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue>();

	/**
	 * imposta il valore dell' ApplicationData 'appDataclasseEnergetica'
	 * @param value
	 * @generated
	 */

	public void setAppDataclasseEnergetica(java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue> value) {
		appDataclasseEnergetica = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataclasseEnergetica'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue> getAppDataclasseEnergetica() {
		return appDataclasseEnergetica;
	}

	/**
	 * @generated
	 */
	private java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue> appDatadestinazioneUso = new java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue>();

	/**
	 * imposta il valore dell' ApplicationData 'appDatadestinazioneUso'
	 * @param value
	 * @generated
	 */

	public void setAppDatadestinazioneUso(java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue> value) {
		appDatadestinazioneUso = value;
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadestinazioneUso'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.LabelValue> getAppDatadestinazioneUso() {
		return appDatadestinazioneUso;
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatamotivazioneCtu'
	 * @param value
	 * @generated
	 */

	public void setAppDatamotivazioneCtu(java.lang.String value) {
		getSession().put("appDatamotivazioneCtu", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatamotivazioneCtu'
	 * @generated
	 */
	public java.lang.String getAppDatamotivazioneCtu() {
		return (java.lang.String) (getSession().get("appDatamotivazioneCtu"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
