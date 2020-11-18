package it.csi.sicee.siceebo.dto.entiformativi;

import java.io.File;
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
 * logica di business associata alla Schermata [cpDatiRegistrazione]
 */
@Validation
public class CpDatiRegistrazioneModel extends BaseSessionAwareDTO {

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
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzo'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzo(java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Indirizzo> value) {
		getSession().put("appDatasuggestIndirizzo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzo'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Indirizzo> getAppDatasuggestIndirizzo() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.geo.Indirizzo>) (getSession()
				.get("appDatasuggestIndirizzo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatasuggestIndirizzoCode'
	 * @param value
	 * @generated
	 */

	public void setAppDatasuggestIndirizzoCode(java.lang.Integer value) {
		getSession().put("appDatasuggestIndirizzoCode", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatasuggestIndirizzoCode'
	 * @generated
	 */
	public java.lang.Integer getAppDatasuggestIndirizzoCode() {
		return (java.lang.Integer) (getSession().get("appDatasuggestIndirizzoCode"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipoEnti'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipoEnti(java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Decodifica> value) {
		getSession().put("appDatatipoEnti", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipoEnti'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Decodifica> getAppDatatipoEnti() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Decodifica>) (getSession()
				.get("appDatatipoEnti"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataenteFormativo'
	 * @param value
	 * @generated
	 */

	public void setAppDataenteFormativo(it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo value) {
		getSession().put("appDataenteFormativo", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataenteFormativo'
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo getAppDataenteFormativo() {
		return (it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo) (getSession().get("appDataenteFormativo"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDatatipoRuoloUtente'
	 * @param value
	 * @generated
	 */

	public void setAppDatatipoRuoloUtente(java.lang.String value) {
		getSession().put("appDatatipoRuoloUtente", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDatatipoRuoloUtente'
	 * @generated
	 */
	public java.lang.String getAppDatatipoRuoloUtente() {
		return (java.lang.String) (getSession().get("appDatatipoRuoloUtente"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataidSedeOperativaSelezionata'
	 * @param value
	 * @generated
	 */

	public void setAppDataidSedeOperativaSelezionata(java.lang.Long value) {
		getSession().put("appDataidSedeOperativaSelezionata", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataidSedeOperativaSelezionata'
	 * @generated
	 */
	public java.lang.Long getAppDataidSedeOperativaSelezionata() {
		return (java.lang.Long) (getSession().get("appDataidSedeOperativaSelezionata"));
	}

	/**
	 * imposta il valore dell' ApplicationData 'appDataelencoSediOperative'
	 * @param value
	 * @generated
	 */

	public void setAppDataelencoSediOperative(
			java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Decodifica> value) {
		getSession().put("appDataelencoSediOperative", value);
	}

	/**
	 * legge il valore dell' ApplicationData 'appDataelencoSediOperative'
	 * @generated
	 */
	public java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Decodifica> getAppDataelencoSediOperative() {
		return (java.util.ArrayList<it.csi.sicee.siceebo.dto.entiformativi.Decodifica>) (getSession()
				.get("appDataelencoSediOperative"));
	}

	////////////////////////////////////////////////////////////////////
	/// campi per widget semplici
	////////////////////////////////////////////////////////////////////

	// FileUpload widg_fileImmagineLogo
	private File widgFileImmagineLogo; // The actual file(s)
	private String widgFileImmagineLogoContentType; // The content type of the file(s) 
	private String widgFileImmagineLogoFileName; // The uploaded file(s) name and path 

	public void setWidg_fileImmagineLogo(File value) {
		widgFileImmagineLogo = value;
	}
	@JSON(include = false)
	public File getWidg_fileImmagineLogo() {
		return widgFileImmagineLogo;
	}

	public void setWidg_fileImmagineLogoContentType(String value) {
		widgFileImmagineLogoContentType = value;
	}
	@JSON(include = false)
	public String getWidg_fileImmagineLogoContentType() {
		return widgFileImmagineLogoContentType;
	}

	public void setWidg_fileImmagineLogoFileName(String value) {
		widgFileImmagineLogoFileName = value;
	}
	@JSON(include = false)
	public String getWidg_fileImmagineLogoFileName() {
		return widgFileImmagineLogoFileName;
	}

}
