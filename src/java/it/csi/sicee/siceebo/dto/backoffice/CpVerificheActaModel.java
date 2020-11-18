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
 * logica di business associata alla Schermata [cpVerificheActa]
 */
@Validation
public class CpVerificheActaModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataverificaActa'
	 * @param value
	 * @generated
	 */

	public void setAppDataverificaActa(java.util.ArrayList<it.csi.sicee.siceebo.dto.backoffice.VerificaActa> value) {
		getSession().put("appDataverificaActa", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataverificaActa'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.backoffice.VerificaActa> getAppDataverificaActa() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.backoffice.VerificaActa>) (getSession()
				.get("appDataverificaActa"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// Table tblVerificaIndex

	private java.lang.String widgTblVerificaIndex;

	public void setWidg_tblVerificaIndex(java.lang.String value) {
		widgTblVerificaIndex = value;
	}

	public java.lang.String getWidg_tblVerificaIndex() {
		return widgTblVerificaIndex;
	}

}
