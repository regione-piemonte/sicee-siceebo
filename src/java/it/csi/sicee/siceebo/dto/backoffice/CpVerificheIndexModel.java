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
 * logica di business associata alla Schermata [cpVerificheIndex]
 */
@Validation
public class CpVerificheIndexModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDataresocontoTransMdp'
	 * @param value
	 * @generated
	 */

	public void setAppDataresocontoTransMdp(it.csi.sicee.siceebo.dto.backoffice.ResocontoTransMdp value) {
		getSession().put("appDataresocontoTransMdp", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataresocontoTransMdp'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.backoffice.ResocontoTransMdp getAppDataresocontoTransMdp() {
		return (it.csi.sicee.siceebo.dto.backoffice.ResocontoTransMdp) (getSession().get("appDataresocontoTransMdp"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatadettaglioTransAttEsito'
	 * @param value
	 * @generated
	 */

	public void setAppDatadettaglioTransAttEsito(
			java.util.ArrayList<it.csi.sicee.siceebo.dto.backoffice.DettaglioTransAttEsito> value) {
		getSession().put("appDatadettaglioTransAttEsito", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatadettaglioTransAttEsito'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.backoffice.DettaglioTransAttEsito> getAppDatadettaglioTransAttEsito() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.backoffice.DettaglioTransAttEsito>) (getSession()
				.get("appDatadettaglioTransAttEsito"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidTransazioniSel'
	 * @param value
	 * @generated
	 */

	public void setAppDataidTransazioniSel(java.util.ArrayList<java.lang.String> value) {
		getSession().put("appDataidTransazioniSel", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidTransazioniSel'
	 * @generated
	 */
	public java.util.ArrayList<java.lang.String> getAppDataidTransazioniSel() {
		return (java.util.ArrayList<java.lang.String>) (getSession().get("appDataidTransazioniSel"));
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
	 * imposta il valore dell' ApplicationData 'appDataverificaIndex'
	 * @param value
	 * @generated
	 */

	public void setAppDataverificaIndex(java.util.ArrayList<it.csi.sicee.siceebo.dto.backoffice.VerificaIndex> value) {
		getSession().put("appDataverificaIndex", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataverificaIndex'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.backoffice.VerificaIndex> getAppDataverificaIndex() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.backoffice.VerificaIndex>) (getSession()
				.get("appDataverificaIndex"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidVerificaSel'
	 * @param value
	 * @generated
	 */

	public void setAppDataidVerificaSel(java.lang.String value) {
		getSession().put("appDataidVerificaSel", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidVerificaSel'
	 * @generated
	 */
	public java.lang.String getAppDataidVerificaSel() {
		return (java.lang.String) (getSession().get("appDataidVerificaSel"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
