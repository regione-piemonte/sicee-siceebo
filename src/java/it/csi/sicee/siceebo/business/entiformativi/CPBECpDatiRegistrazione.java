package it.csi.sicee.siceebo.business.entiformativi;

import java.util.*;

import it.csi.sicee.siceebo.dto.*;
import it.csi.sicee.siceebo.dto.geo.*;
import it.csi.sicee.siceebo.dto.entiformativi.*;
import it.csi.sicee.siceebo.dto.certificatori.*;
import it.csi.sicee.siceebo.dto.ace.*;
import it.csi.sicee.siceebo.dto.backoffice.*;

import org.apache.log4j.*;
import it.csi.sicee.siceebo.util.*;
import it.csi.sicee.siceebo.business.*;

/*PROTECTED REGION ID(R389290136) ENABLED START*/
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.swing.ImageIcon;

import it.csi.sicee.siceebo.business.facade.SOAIntegrationMgr;
import it.csi.sicee.siceebo.business.facade.MiscMgr;
import it.csi.sicee.siceebo.dto.entiformativi.Corso;
import it.csi.sicee.siceebo.dto.entiformativi.EnteFormativo;
import it.csi.sicee.siceebo.dto.entiformativi.EnteCf;
import it.csi.sicee.siceebo.dto.entiformativi.Decodifica;

import org.apache.xmlbeans.impl.util.Base64;

import com.lowagie.text.Image;
import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiReader;

/*PROTECTED REGION END*/

public class CPBECpDatiRegistrazione {

	/**  */
	protected static final Logger log = //NOSONAR  Reason:EIAS 
			Logger.getLogger(Constants.APPLICATION_CODE + ".business"); //NOSONAR  Reason:EIAS

	//////////////////////////////////////////////////////////////////////////////
	/// Costanti identificative degli Application Data
	//////////////////////////////////////////////////////////////////////////////

	// ApplicationData: [currentUser, scope:USER_SESSION]
	public static final String APPDATA_CURRENTUSER_CODE = "appDatacurrentUser";

	// ApplicationData: [regione, scope:USER_SESSION]
	public static final String APPDATA_REGIONE_CODE = "appDataregione";

	// ApplicationData: [province, scope:USER_SESSION]
	public static final String APPDATA_PROVINCE_CODE = "appDataprovince";

	// ApplicationData: [comuni, scope:USER_SESSION]
	public static final String APPDATA_COMUNI_CODE = "appDatacomuni";

	// ApplicationData: [suggestIndirizzo, scope:SAME_PAGE]
	public static final String APPDATA_SUGGESTINDIRIZZO_CODE = "appDatasuggestIndirizzo";

	// ApplicationData: [suggestIndirizzoCode, scope:SAME_PAGE]
	public static final String APPDATA_SUGGESTINDIRIZZOCODE_CODE = "appDatasuggestIndirizzoCode";

	// ApplicationData: [tipoEnti, scope:USER_SESSION]
	public static final String APPDATA_TIPOENTI_CODE = "appDatatipoEnti";

	// ApplicationData: [enteFormativo, scope:USER_SESSION]
	public static final String APPDATA_ENTEFORMATIVO_CODE = "appDataenteFormativo";

	// ApplicationData: [tipoRuoloUtente, scope:USER_SESSION]
	public static final String APPDATA_TIPORUOLOUTENTE_CODE = "appDatatipoRuoloUtente";

	// ApplicationData: [idSedeOperativaSelezionata, scope:USER_SESSION]
	public static final String APPDATA_IDSEDEOPERATIVASELEZIONATA_CODE = "appDataidSedeOperativaSelezionata";

	// ApplicationData: [elencoSediOperative, scope:USER_SESSION]
	public static final String APPDATA_ELENCOSEDIOPERATIVE_CODE = "appDataelencoSediOperative";

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi associati alla U.I.
	//////////////////////////////////////////////////////////////////////////////

	// nome del content panel associato al bean
	public static final String CPNAME = "cpDatiRegistrazione";

	/** 
	 * Restituisce il tab correntemente visibile in un determinato tab set
	 */
	private String getCurrentTab(Map session, String tabSetName) {
		String value = (String) session.get(CPNAME + "_" + tabSetName + "_selectedMultiPanel");
		return value;
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo abilitaCodFormReg definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults abilitaCodFormReg(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ABILITACODFORMREG_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String ABILITACODFORMREG_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R586631243) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (Constants.AGENZIA_FORMATIVA.equals(theModel.getAppDataenteFormativo().getTipoSoggetto())) {
				result.setResultCode(ABILITACODFORMREG_OUTCOME_CODE__ABILITA);
				theModel.getAppDataenteFormativo().setCodFormReg(null);
			} else {
				theModel.getAppDataenteFormativo().setCodFormReg(null);
				result.setResultCode(ABILITACODFORMREG_OUTCOME_CODE__DISABILITA);
			}
			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::abilitaCodFormReg] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo cambiaSedeOperativa definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults cambiaSedeOperativa(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CAMBIASEDEOPERATIVA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-671903712) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			log.debug("\n\n\n WHEN COMBOBOX VALUE CHANGED :: cambiaSedeOperativa :: inizio");
			String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
			EnteCf enteCf = null;
			EnteFormativo enteFormativo = null;
			enteCf = recuperaIdEnteFormativo(codiceFiscale);
			Long idSedeOperativaSelezionata = null;

			if (!MiscMgr.isNullOrEmpty(theModel.getAppDataidSedeOperativaSelezionata())) {
				idSedeOperativaSelezionata = theModel.getAppDataidSedeOperativaSelezionata();
			} else {
				// nel caso in cui un picio selezioni null dalla lista sedi operative torno alla sede operativa di default
				idSedeOperativaSelezionata = enteCf.getIdEnte();
			}
			enteFormativo = recuperaEnteFormativo(idSedeOperativaSelezionata);
			theModel.setAppDataenteFormativo(enteFormativo);
			theModel.setAppDataidSedeOperativaSelezionata(idSedeOperativaSelezionata);
			// l' elenco delle sedi operative è già stato determinato all'inizio
			gestisciCombo(theModel);
			// il ruolo è già stato determinato all'inizio e resta quello per tutte le sedi operative

			// impostazione del result code 
			result.setResultCode(CAMBIASEDEOPERATIVA_OUTCOME_CODE__OK);
			log.debug("\n\n\n WHEN COMBOBOX VALUE CHANGED :: cambiaSedeOperativa :: fine");

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::cambiaSedeOperativa] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setRegione definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults setRegione(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETREGIONE_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String SETREGIONE_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-943665004) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String actRegSel = null;
			EnteFormativo ef = theModel.getAppDataenteFormativo();
			if (ef != null) {
				actRegSel = ef.getIdRegione();
			}

			// carico le province (se non è stata selezionata una regione ritorno lista vuota)
			ArrayList<Provincia> province = new ArrayList<Provincia>();
			ArrayList<Comune> comuni = new ArrayList<Comune>();
			if (actRegSel != null) {
				province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByRegione(actRegSel);
				comuni = new ArrayList<Comune>();
			} else {
				province = new ArrayList<Provincia>();
				comuni = new ArrayList<Comune>();
			}
			theModel.setAppDataprovince(province);
			theModel.setAppDatacomuni(comuni);

			theModel.getAppDataenteFormativo().setDescRegione(
					getDescrRegione(theModel.getAppDataregione(), theModel.getAppDataenteFormativo().getIdRegione()));

			theModel.getAppDataenteFormativo().setIdProv(null);
			theModel.getAppDataenteFormativo().setDescProv(null);

			theModel.getAppDataenteFormativo().setIdComune(null);
			theModel.getAppDataenteFormativo().setDescComune(null);

			if (Constants.COD_REGIONE_PIEMONTE.equals(theModel.getAppDataenteFormativo().getIdRegione())) {
				result.setResultCode(SETREGIONE_OUTCOME_CODE__ABILITA);
			} else {
				result.setResultCode(SETREGIONE_OUTCOME_CODE__DISABILITA);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setRegione] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setProvincia definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults setProvincia(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETPROVINCIA_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-2078482408) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			String actProvSel = null;
			EnteFormativo ef = theModel.getAppDataenteFormativo();
			if (ef != null) {
				actProvSel = ef.getIdProv();
			}

			// carico i comuni (se non è stata selezionata una provincia ritorno lista vuota)
			ArrayList<Comune> comuni = new ArrayList<Comune>();
			if (actProvSel != null) {
				comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
			} else {
				comuni = new ArrayList<Comune>();
			}
			theModel.setAppDatacomuni(comuni);

			theModel.getAppDataenteFormativo().setDescProv(
					getDescrProvincia(theModel.getAppDataprovince(), theModel.getAppDataenteFormativo().getIdProv()));

			theModel.getAppDataenteFormativo().setIdComune(null);
			theModel.getAppDataenteFormativo().setDescComune(null);
			// impostazione del result code 
			result.setResultCode(SETPROVINCIA_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setProvincia] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo setComune definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults setComune(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SETCOMUNE_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-1729549400) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			theModel.getAppDataenteFormativo().setDescComune(
					getDescrComune(theModel.getAppDatacomuni(), theModel.getAppDataenteFormativo().getIdComune()));

			// impostazione del result code 
			result.setResultCode(SETCOMUNE_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::setComune] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo verificaIndirizzo definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults verificaIndirizzo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String VERIFICAINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R361907982) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			EnteFormativo ente = theModel.getAppDataenteFormativo();
			theModel.setAppDatasuggestIndirizzo((ArrayList<Indirizzo>) caricaComboIndirizzi(ente.getDescIndirizzo(),
					ente.getIdRegione(), ente.getIdComune()));

			// impostazione del result code 
			result.setResultCode(VERIFICAINDIRIZZO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::verificaIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo scegliIndirizzo definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults scegliIndirizzo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SCEGLIINDIRIZZO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-369852234) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			EnteFormativo ente = theModel.getAppDataenteFormativo();
			Integer code = theModel.getAppDatasuggestIndirizzoCode();
			Indirizzo ind = getSOAIntegrationMgr().getIndirizzoById(code);
			ente.setDescIndirizzo(ind.getDescr());
			ente.setIdIndirizzo(Integer.toString(ind.getCod()));

			// impostazione del result code 
			result.setResultCode(SCEGLIINDIRIZZO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::scegliIndirizzo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo caricaImmagineLogo definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults caricaImmagineLogo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String CARICAIMMAGINELOGO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-12168236) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			String base64Image = null;
			String nomeFoto = theModel.getWidg_fileImmagineLogoFileName();
			String contentType = theModel.getWidg_fileImmagineLogoContentType();
			log.debug("Nome file immagine: " + nomeFoto);
			log.debug("Content Type: " + contentType);
			if (!GenericUtil.isNullOrEmpty(nomeFoto)) {
				java.io.File file = theModel.getWidg_fileImmagineLogo();
				byte[] bytes = getMiscMgr().readFile(file);

				ByteArrayInputStream baFoto = new ByteArrayInputStream(bytes);
				//BufferedImage ioBf = null;
				try {
					log.debug("inizio jimi");
					JimiReader createJimiReader = Jimi.createJimiReader(baFoto);
					createJimiReader.getRasterImage();

					log.debug("fine jimi");

					//ioBf = ImageIO.read(baFoto);
					base64Image = resizeImageLogo(bytes);

					theModel.getAppDataenteFormativo().setBase64Logo(base64Image);
					theModel.getAppDataenteFormativo()
							.setPresenzaLogo("<b><font color=\"green\">Logo presente</font></b>");

				} catch (Exception e) {
					log.debug("Errore nell'immagine uploadata: " + e.toString());
					result.getGlobalErrors().add("Errore nell'immagine uploadata");
				}
			}
			// impostazione del result code 
			result.setResultCode(CARICAIMMAGINELOGO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::caricaImmagineLogo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo salvaEnteFormativo definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults salvaEnteFormativo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String SALVAENTEFORMATIVO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		final String SALVAENTEFORMATIVO_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1496804635) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n salvaEnteFormativo :: inizio");
			EnteFormativo enteFormativo = theModel.getAppDataenteFormativo();

			boolean ok = true;
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataenteFormativo().getTipoSoggetto())) {
				addMissingRequiredFieldError("appDataenteFormativo.tipoSoggetto", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataenteFormativo().getIdRegione())) {
				addMissingRequiredFieldError("appDataenteFormativo.idRegione", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataenteFormativo().getIdProv())) {
				addMissingRequiredFieldError("appDataenteFormativo.idProv", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataenteFormativo().getDescIndirizzo())) {
				addMissingRequiredFieldError("appDataenteFormativo.descIndirizzo", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataenteFormativo().getNumCivico())) {
				addMissingRequiredFieldError("appDataenteFormativo.numCivico", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataenteFormativo().getCap())) {
				addMissingRequiredFieldError("appDataenteFormativo.cap", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataenteFormativo().getTelefono())) {
				addMissingRequiredFieldError("appDataenteFormativo.telefono", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataenteFormativo().getEmail())) {
				addMissingRequiredFieldError("appDataenteFormativo.email", result);
				ok = false;
			}
			if (GenericUtil.isNullOrEmpty(theModel.getAppDataenteFormativo().getSitoWeb())) {
				addMissingRequiredFieldError("appDataenteFormativo.sitoWeb", result);
				ok = false;
			}

			if (ok) {
				getMiscMgr().updateEnteFormativo(enteFormativo);
				result.setResultCode(SALVAENTEFORMATIVO_OUTCOME_CODE__OK);
			} else {
				result.setResultCode(SALVAENTEFORMATIVO_OUTCOME_CODE__KO);
			}

			log.debug("\n\n\n salvaEnteFormativo :: fine");

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::salvaEnteFormativo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo gestisciComboGeo definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults gestisciComboGeo(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String GESTISCICOMBOGEO_OUTCOME_CODE__OK = //NOSONAR  Reason:EIAS
				"OK"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R774360849) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n>>>>>>>gestisciComboGeo inizio");
			//gestisciCombo(theModel);
			log.debug("\n\n>>>>>>>gestisciComboGeo fine");

			// impostazione del result code 
			result.setResultCode(GESTISCICOMBOGEO_OUTCOME_CODE__OK);

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::gestisciComboGeo] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo loadFromDB definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults loadFromDB(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String LOADFROMDB_OUTCOME_CODE__OK_RW = //NOSONAR  Reason:EIAS
				"OK_RW"; //NOSONAR  Reason:EIAS
		final String LOADFROMDB_OUTCOME_CODE__OK_R = //NOSONAR  Reason:EIAS
				"OK_R"; //NOSONAR  Reason:EIAS
		final String LOADFROMDB_OUTCOME_CODE__KO = //NOSONAR  Reason:EIAS
				"KO"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R872287989) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:

			log.debug("\n\n\n ON ENTER :: loadFromDb :: inizio");
			String codiceFiscale = theModel.getAppDatacurrentUser().getCodFisc();
			EnteCf enteCf = null;
			EnteFormativo enteFormativo = null;
			ArrayList<Decodifica> elencoSediOperative = null;
			Long idSedeOperativaSelezionata = null;
			enteCf = recuperaIdEnteFormativo(codiceFiscale);
			if (enteCf != null) {
				if (!MiscMgr.isNullOrEmpty(theModel.getAppDataidSedeOperativaSelezionata())) {
					// si verifica ai richiami successivi
					idSedeOperativaSelezionata = theModel.getAppDataidSedeOperativaSelezionata();
				} else {
					// si verifica all'apertura
					idSedeOperativaSelezionata = enteCf.getIdEnte();
				}

				enteFormativo = recuperaEnteFormativo(idSedeOperativaSelezionata);
				theModel.setAppDataenteFormativo(enteFormativo);
				theModel.setAppDataidSedeOperativaSelezionata(idSedeOperativaSelezionata);
				elencoSediOperative = recuperaElencoSediEnteFormativo(enteFormativo.getFkEnteSl());
				theModel.setAppDataelencoSediOperative(elencoSediOperative);
				gestisciCombo(theModel);
				theModel.setAppDatatipoRuoloUtente(enteCf.getRuolo());
				if (theModel.getAppDatatipoRuoloUtente().equalsIgnoreCase(Constants.RUOLO_RW))
					result.setResultCode(LOADFROMDB_OUTCOME_CODE__OK_RW);
				else
					result.setResultCode(LOADFROMDB_OUTCOME_CODE__OK_R);
			} else {
				result.getGlobalErrors().add("Nessun ente formativo associato a questo certificato");
				result.setResultCode(LOADFROMDB_OUTCOME_CODE__KO);
			}
			log.debug("\n\n\n ON ENTER :: loadFromDb :: fine");

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::loadFromDB] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo abilitaCodFormRegInit definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults abilitaCodFormRegInit(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ABILITACODFORMREGINIT_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String ABILITACODFORMREGINIT_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R1623315867) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (Constants.AGENZIA_FORMATIVA.equals(theModel.getAppDataenteFormativo().getTipoSoggetto())) {
				result.setResultCode(ABILITACODFORMREGINIT_OUTCOME_CODE__ABILITA);
			} else {
				result.setResultCode(ABILITACODFORMREGINIT_OUTCOME_CODE__DISABILITA);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::abilitaCodFormRegInit] Errore occorso nell'esecuzione del metodo:" + e, e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Implementazione del metodo abilitaVerificaIndirizziInit definito in un ExecCommand del
	 * ContentPanel cpDatiRegistrazione
	 */
	public ExecResults abilitaVerificaIndirizziInit(

			it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel

	) throws BEException {
		/// definizione costanti di outcome
		final String ABILITAVERIFICAINDIRIZZIINIT_OUTCOME_CODE__ABILITA = //NOSONAR  Reason:EIAS
				"ABILITA"; //NOSONAR  Reason:EIAS
		final String ABILITAVERIFICAINDIRIZZIINIT_OUTCOME_CODE__DISABILITA = //NOSONAR  Reason:EIAS
				"DISABILITA"; //NOSONAR  Reason:EIAS
		///
		try {
			ExecResults result = new ExecResults();
			/*PROTECTED REGION ID(R-713237852) ENABLED START*/
			// inserire qui la logica applicativa da eseguire:
			if (Constants.COD_REGIONE_PIEMONTE.equals(theModel.getAppDataenteFormativo().getIdRegione())) {
				result.setResultCode(ABILITAVERIFICAINDIRIZZIINIT_OUTCOME_CODE__ABILITA);
			} else {
				result.setResultCode(ABILITAVERIFICAINDIRIZZIINIT_OUTCOME_CODE__DISABILITA);
			}

			// impostazione del result code 

			// modifica degli attributi del model (che verranno propagati allo strato
			// di presentation). si puo' agire anche direttamente sull'attributo "session".

			result.setModel(theModel);
			return result;
			/*PROTECTED REGION END*/
		} catch (Exception e) {
			log.error("[BackEndFacade::abilitaVerificaIndirizziInit] Errore occorso nell'esecuzione del metodo:" + e,
					e);
			throw new BEException("Errore occorso nell'esecuzione del metodo:" + e, e);
		}
	}

	//////////////////////////////////////////////////////////////////////////////
	/// Metodi statici per il reset delle tabelle
	//////////////////////////////////////////////////////////////////////////////

	//////////////////////////////////////////////////////////////////////////////
	/// Property aggiuntive del bean
	//////////////////////////////////////////////////////////////////////////////
	/*PROTECTED REGION ID(R2088535574) ENABLED START*/
	//// inserire qui le property che si vogliono iniettare in questo bean (es. dao, proxy di pd, ...)

	private SOAIntegrationMgr soaIntegrationMgr;
	private MiscMgr miscMgr;

	public SOAIntegrationMgr getSOAIntegrationMgr() {
		return soaIntegrationMgr;
	}
	public void setSOAIntegrationMgr(SOAIntegrationMgr soaIntegrationMgr) {
		this.soaIntegrationMgr = soaIntegrationMgr;
	}

	public MiscMgr getMiscMgr() {
		return miscMgr;
	}
	public void setMiscMgr(MiscMgr miscMgr) {
		this.miscMgr = miscMgr;
	}

	private void gestisciCombo(it.csi.sicee.siceebo.dto.entiformativi.CpDatiRegistrazioneModel theModel)
			throws BEException {

		// carico decodifiche tipo soggetto formativo
		ArrayList<Decodifica> tipiSoggetto = getMiscMgr().getTipiSoggetto();
		theModel.setAppDatatipoEnti(tipiSoggetto);

		// se l'elenco è vuoto carico le regioni
		if ((theModel.getAppDataregione() == null) || (theModel.getAppDataregione().size() == 0)) {
			ArrayList<Regione> regioni = (ArrayList<Regione>) getSOAIntegrationMgr().getRegioni();
			theModel.setAppDataregione(regioni);
		}

		// regione attualmente selezionata
		String actRegSel = null;
		String actProvSel = null;
		EnteFormativo ef = theModel.getAppDataenteFormativo();
		if (ef != null) {
			actRegSel = ef.getIdRegione();
			actProvSel = ef.getIdProv();
		}

		// carico le province (se non è stata selezionata una regione ritorno lista vuota)
		ArrayList<Provincia> province = new ArrayList<Provincia>();
		if (actRegSel != null) {
			province = (ArrayList<Provincia>) getSOAIntegrationMgr().getProvinceByRegione(actRegSel);
		} else {
			province = new ArrayList<Provincia>();
		}
		theModel.setAppDataprovince(province);

		// carico i comuni (se non è stata selezionata una provincia ritorno lista vuota)
		ArrayList<Comune> comuni = new ArrayList<Comune>();
		if (actProvSel != null) {
			comuni = (ArrayList<Comune>) getSOAIntegrationMgr().getComuniByProvincia(actProvSel);
		} else {
			comuni = new ArrayList<Comune>();
		}
		theModel.setAppDatacomuni(comuni);

		// inizializzazione lista  suggerimenti indirizzi
		ArrayList<Indirizzo> indirizzi = new ArrayList<Indirizzo>();
		theModel.setAppDatasuggestIndirizzo(indirizzi);

	}

	private EnteCf recuperaIdEnteFormativo(String codiceFiscale) throws BEException {
		EnteCf enteCf = null;
		enteCf = getMiscMgr().getIdEntiByCF(codiceFiscale);
		return enteCf;
	}

	private EnteFormativo recuperaEnteFormativo(long idEnte) throws BEException {
		EnteFormativo enteFormativo = null;
		enteFormativo = getMiscMgr().getEnteByPk(idEnte);
		return enteFormativo;
	}

	private String getDescrRegione(ArrayList<Regione> regioni, String id) {
		if (regioni != null) {
			if (id != null && id.length() > 0) {
				for (Regione regione : regioni) {
					if (regione.getCod().equals(id))
						return regione.getNome();
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	private String getDescrProvincia(ArrayList<Provincia> province, String id) {
		if (province != null) {
			if (id != null && id.length() > 0) {
				for (Provincia provincia : province) {
					if (provincia.getCod().equals(id))
						return provincia.getNome();
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	private String getDescrComune(ArrayList<Comune> comuni, String id) {
		if (comuni != null) {
			if (id != null && id.length() > 0) {
				for (Comune comune : comuni) {
					if (comune.getCod().equals(id))
						return comune.getNome();
				}
				return null;
			} else
				return null;
		} else
			return null;
	}

	private List<Indirizzo> caricaComboIndirizzi(String descrIndirizzo, String codReg, String codComune)
			throws BEException {
		if (Constants.COD_REGIONE_PIEMONTE.equals(codReg)) {
			// cerco solo se regione == piemonte
			return getSOAIntegrationMgr().verificaIndirizzi(descrIndirizzo, codComune);
		} else
			return new ArrayList<Indirizzo>();
	}

	private ArrayList<Decodifica> recuperaElencoSediEnteFormativo(long fkEnteSl) throws BEException {
		ArrayList<Decodifica> elencoSediOperativeEnte = null;
		elencoSediOperativeEnte = getMiscMgr().getElencoSediEnteByFkEnteSl(fkEnteSl);
		return elencoSediOperativeEnte;
	}
	/*
	 private ArrayList<Decodifica> recuperaElencoSediEnteFormativo(
	 String partitaIva) throws BEException {
	 ArrayList<Decodifica> elencoSediOperativeEnte = null;
	 elencoSediOperativeEnte = getMiscMgr().getElencoSediEnteByPiva(partitaIva);
	 return elencoSediOperativeEnte;
	 }
	 */
	private void addMissingRequiredFieldError(String fname, ExecResults r) {
		r.getFldErrors().put("" + fname, "il campo e' obbligatorio");
	}

	private String resizeImageLogo(byte[] originalImageByte) throws Exception {

		String resizedBase64Image = null;
		try {

			ImageIcon imgIcon = new ImageIcon(originalImageByte);
			java.awt.Image originalImage = imgIcon.getImage();

			int iWidth = originalImage.getWidth(null);
			int iHeight = originalImage.getHeight(null);
			while ((iWidth > Constants.LOGO_WIDTH) || (iHeight > Constants.LOGO_HEIGHT)) {
				iWidth = (int) (iWidth * 0.90);
				iHeight = (int) (iHeight * 0.90);
			}

			BufferedImage resizedImage = new BufferedImage(iWidth, iHeight, BufferedImage.TYPE_4BYTE_ABGR);
			Graphics2D g2 = (Graphics2D) resizedImage.getGraphics();
			g2.drawImage(originalImage, 0, 0, resizedImage.getWidth(), resizedImage.getHeight(), 0, 0, iWidth, iHeight,
					null);
			g2.dispose();

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			javax.imageio.ImageIO.write(resizedImage, "png", bos);
			byte[] resizedImageByte = bos.toByteArray();
			bos.close();
			resizedBase64Image = new String(Base64.encode(resizedImageByte));

		} catch (Exception e) {
			log.error("Errore in resizeImageLogo");
			throw new Exception(e.getMessage(), e);
		}
		return resizedBase64Image;
	}
	/*PROTECTED REGION END*/
}
