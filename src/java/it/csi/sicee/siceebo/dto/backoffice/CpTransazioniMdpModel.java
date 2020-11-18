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
 * logica di business associata alla Schermata [cpTransazioniMdp]
 */
@Validation
public class CpTransazioniMdpModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatafiltroDettaglioTransAttEsito'
	 * @param value
	 * @generated
	 */

	public void setAppDatafiltroDettaglioTransAttEsito(
			it.csi.sicee.siceebo.dto.backoffice.FiltroDettaglioTransAttEsito value) {
		getSession().put("appDatafiltroDettaglioTransAttEsito", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatafiltroDettaglioTransAttEsito'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.backoffice.FiltroDettaglioTransAttEsito getAppDatafiltroDettaglioTransAttEsito() {
		return (it.csi.sicee.siceebo.dto.backoffice.FiltroDettaglioTransAttEsito) (getSession()
				.get("appDatafiltroDettaglioTransAttEsito"));
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

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

}
