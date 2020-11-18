package it.csi.sicee.siceebo.util;

/**
 * <p>Classe delle costanti applicative.</p>
 *
 * @author GuiGen
 */
public final class Constants {
	/**
	 * identificativo dell'applicativo.
	 */
	public static final String APPLICATION_CODE = "siceebo";

	/**
	 * nome dell'attributo di sessione in cui viene memorizzato il valore corrente del
	 * captcha 
	 */
	public static final String CAPTCHA_SESSION_NAME = "current_captcha_value";

	/*PROTECTED REGION ID(R1581691183) ENABLED START*/

	/** The rb. */
	private static java.util.ResourceBundle rb = java.util.ResourceBundle.getBundle("/META-INF/siceebo");

	/** The siceews tenant username. */
	public static final String WS_SICEEWS_URL = rb.getString("siceebo.siceews.url");

	public static String SESSIONE_VAR_UID_INDEX = "uidIndex";

	/** The Constant ISTAT_TORINO. */
	public static final String ISTAT_TORINO = "001272";

	/** The Constant NUOVO. */
	public static final int NUOVO = 0;

	/** The Constant BOZZA. */
	public static final int BOZZA = 1;

	/** The Constant CONSOLIDATO. */
	public static final int CONSOLIDATO = 2;

	/** The Constant INVIATO. */
	public static final int INVIATO = 3;

	/** The Constant ANNULLATO. */
	public static final int ANNULLATO = 4;

	/** The Constant ANNULLATO_BO. */
	public static final int ANNULLATO_BO = 8;

	/** The Constant MDP_ANNULLATO_BO. */
	public static final int MDP_UNSUCCESSFULL = 5;

	// E' un codice convenzionale non inserito sul DB, mi serve per creare la query
	/** The Constant INVIATO_ANNULLATO. */
	public static final int INVIATO_ANNULLATO = 99;

	/** The Constant DATA_INIZIO_CERTIFICAZIONI. */
	public static final String DATA_INIZIO_CERTIFICAZIONI = "01/11/2009";

	/** The formatter data web. */
	public static java.text.SimpleDateFormat FORMATTER_DATA_WEB = new java.text.SimpleDateFormat("dd/MM/yyyy");

	/** The Constant ID_STATO_CERTIFICATO_3. */
	public static final int ID_STATO_CERTIFICATO_3 = 3;

	/** The numero max certificatori bo. */
	public static String NUMERO_MAX_CERTIFICATORI_BO = "NUMERO_MAX_CERTIFICATORI_BO";

	/** The numero max ace bo. */
	public static String NUMERO_MAX_ACE_BO = "NUMERO_MAX_ACE_BO";

	/** The numero minimo id certificatore. */
	public static String NUMERO_MINIMO_ID_CERTIFICATORE = "NUMERO_MINIMO_ID_CERTIFICATORE";

	/** The Constant COD_REGIONE_PIEMONTE. */
	public static final String COD_REGIONE_PIEMONTE = "01";

	/** The Constant COD_DATA_ELABORAZIONE. */
	public static final String COD_DATA_ELABORAZIONE = "DATA_ELABORAZIONE";

	/** The Constant VALORE_1. */
	public static final int VALORE_1 = 1;

	/** The Constant FLG_S. */
	public static final String FLG_S = "S";

	/** The Constant FLG_N. */
	public static final String FLG_N = "N";

	/** The Constant LABEL_SI. */
	public static final String LABEL_SI = "Si";

	/** The Constant LABEL_NO. */
	public static final String LABEL_NO = "No";

	/** The Constant SICEEBO. */
	public static final String SICEEBO = "SICEEBO";

	/** The Constant PK_PROGR. */
	public static final int PK_PROGR = 2;

	/** The Constant PK_ANNO. */
	public static final int PK_ANNO = 0;

	/** The Constant PK_ID_CERTIFICATORE. */
	public static final int PK_ID_CERTIFICATORE = 1;

	/** The Constant PK_NUM_CERTIFICATORE. */
	public static final int PK_NUM_CERTIFICATORE = 1;

	/** The Constant LABEL_ANNULLATO. */
	public static final String LABEL_ANNULLATO = "ANNULLATO";

	/** The Constant LABEL_NON_BLOCCATO. */
	public static final String LABEL_NON_BLOCCATO = "non bloccato";

	/** The Constant LABEL_RUOLO. */
	public static final String LABEL_RUOLO_LETTORE_ARPA = "LETTORE_SICEEBO@ARPA";
	public static final String LABEL_RUOLO_LETTORE_REG_PMN = "LETTORE_SICEEBO@REG_PMN";
	public static final String LABEL_RUOLO_LETTORE_CTU_ESTERNI = "LETTORE_CTU_SICEEBO@UTENTI_ESTERNI";

	/** The Constant RUOLO_RW. */
	public static final String RUOLO_RW = "RW";

	/** The Constant RUOLO_R. */
	public static final String RUOLO_R = "R";

	public static final Integer ID_PDF_APE_CONSOLIDATO = 1;
	public static final Integer ID_PDF_APE_FIRMATO = 2;
	public static final Integer ID_PDF_INDICATORE_APE = 3;

	public static final Integer FLG_0 = 0;
	public static final Integer FLG_1 = 1;

	/** The Constant AGENZIA_FORMATIVA. */
	public static final String AGENZIA_FORMATIVA = "4";

	/** The Constant TIPOCORSO1_FORMAZIONE/AGGIORNAMENTO. */
	public static final String TIPOCORSO1_FORMAZIONE = "FORM";
	public static final String TIPOCORSO1_FORMAZIONE_DESC = "Formazione (80 + ore)";
	public static final String TIPOCORSO1_AGGIORNAMENTO = "AGG";
	public static final String TIPOCORSO1_AGGIORNAMENTO_DESC = "Aggiornamento (10 + ore) Regionale";

	public static final String TIPOCORSO2_NAZ = "NAZ";
	public static final String TIPOCORSO2_REG = "REG";

	public static final String ESITO_SUPERATO = "SUPERATO";
	public static final String ESITO_SUPERATO_DESC = "Superato";
	public static final String ESITO_SUPERATO_SESS_SUCC = "SUPERATO_SESS_SUCC";
	public static final String ESITO_SUPERATO_SESS_SUCC_DESC = "Superato in sessione successiva";
	public static final String ESITO_RESPINTO = "RESPINTO";
	public static final String ESITO_RESPINTO_DESC = "Respinto";

	public static final int ID_TIPO_DOC_TITOLO_DI_STUDIO = 6;

	public static final int MAX_LOGO_LENGTH = 256000;
	public static final int LOGO_WIDTH = 300;
	public static final int LOGO_HEIGHT = 150;

	// MODOL stuff
	public static final String MODOL_ENCODING = "UTF-8";
	public static final String CODICE_APPLICAZIONE_MODOL = "SICEE";
	public static final String CODICE_MODULO_MODOL_APE = "MODULO_APE_2015-v1.0.0";
	public static final String CODICE_MODULO_MODOL_APE_2015 = "MODULO_APE_2015-v2.0.0";

	// boolean
	public static final boolean TRUE = true;
	public static final boolean FALSE = false;

	public static final String SI = "S";
	public static final String NO = "N";

	public static final int ID_MOTIVO_ALTRO = 105;
	public static final int ID_MOTIVO_ANTE_OPERAM = 200;
	public static final int ID_MOTIVO_POST_OPERAM = 201;

	public static final int ID_MOTIVO_ANNULLATO_BO = 10;

	// nuovi stati Alex -- begin
	public static final int STATO_CERTIFICATORE_RADIATO = 1;
	public static final int STATO_CERTIFICATORE_DECEDUTO = 2;
	public static final int STATO_CERTIFICATORE_ASSENZA_TITOLO_STUDIO = 3;
	public static final int STATO_CERTIFICATORE_FALSE_DICHIARAZIONI = 4;

	public static final int STATO_CERTIFICATORE_ASSENZA_CORSO = 5;
	public static final int STATO_CERTIFICATORE_MANCANZA_INFORMAZIONI = 6;
	public static final int STATO_CERTIFICATORE_MANCANZA_GENERICA = 7;

	// nuovi stati Alex -- end

	// E-MAIL stuff - begin
	public static final String EMAIL_NOTIFICA = "EMAIL_NOTIFICA";
	public static final String MAIL_HOST = "MAIL_HOST";
	public static final String MAIL_PORT = "MAIL_PORT";
	public static final String MAIL_MITT_NOTIFICA = "MITTENTE_EMAIL_NOTIFICA";
	public static final String OGGETTO_MAIL_NOTIFICA_RADIATO = "OGGETTO_MAIL_NOTIFICA_RADIATO";
	public static final String TESTO_MAIL_NOTIFICA_RADIATO_TXT = "TESTO_MAIL_NOTIFICA_RADIATO_TXT";
	public static final String TESTO_MAIL_NOTIFICA_RADIATO_HTML = "TESTO_MAIL_NOTIFICA_RADIATO_HTML";
	public static final String OGGETTO_MAIL_NOTIFICA_ASSENZA_TITOLO_STUDIO = "OGGETTO_MAIL_NOTIFICA_ASSENZA_TITOLO_STUDIO";
	public static final String TESTO_MAIL_NOTIFICA_ASSENZA_TITOLO_STUDIO_TXT = "TESTO_MAIL_NOTIFICA_ASSENZA_TITOLO_STUDIO_TXT";
	public static final String TESTO_MAIL_NOTIFICA_ASSENZA_TITOLO_STUDIO_HTML = "TESTO_MAIL_NOTIFICA_ASSENZA_TITOLO_STUDIO_HTML";
	public static final String OGGETTO_MAIL_NOTIFICA_FALSE_DICHIARAZIONI = "OGGETTO_MAIL_NOTIFICA_FALSE_DICHIARAZIONI";
	public static final String TESTO_MAIL_NOTIFICA_FALSE_DICHIARAZIONI_TXT = "TESTO_MAIL_NOTIFICA_FALSE_DICHIARAZIONI_TXT";
	public static final String TESTO_MAIL_NOTIFICA_FALSE_DICHIARAZIONI_HTML = "TESTO_MAIL_NOTIFICA_FALSE_DICHIARAZIONI_HTML";
	public static final String OGGETTO_MAIL_NOTIFICA_RIATTIVAZIONE = "OGGETTO_MAIL_NOTIFICA_RIATTIVAZIONE";
	public static final String TESTO_MAIL_NOTIFICA_RIATTIVAZIONE_TXT = "TESTO_MAIL_NOTIFICA_RIATTIVAZIONE_TXT";
	public static final String TESTO_MAIL_NOTIFICA_RIATTIVAZIONE_HTML = "TESTO_MAIL_NOTIFICA_RIATTIVAZIONE_HTML";

	public static final String OGGETTO_MAIL_NOTIFICA_ASSENZA_CORSO = "OGGETTO_MAIL_NOTIFICA_ASSENZA_CORSO";
	public static final String TESTO_MAIL_NOTIFICA_ASSENZA_CORSO_TXT = "TESTO_MAIL_NOTIFICA_ASSENZA_CORSO_TXT";
	public static final String TESTO_MAIL_NOTIFICA_ASSENZA_CORSO_HTML = "TESTO_MAIL_NOTIFICA_ASSENZA_CORSO_HTML";

	public static final String OGGETTO_MAIL_NOTIFICA_INTEGRAZIONE_DOC = "OGGETTO_MAIL_NOTIFICA_INTEGRAZIONE_DOC";
	public static final String TESTO_MAIL_NOTIFICA_INTEGRAZIONE_DOC_TXT = "TESTO_MAIL_NOTIFICA_INTEGRAZIONE_DOC_TXT";
	public static final String TESTO_MAIL_NOTIFICA_INTEGRAZIONE_DOC_HTML = "TESTO_MAIL_NOTIFICA_INTEGRAZIONE_DOC_HTML";

	public static final String OGGETTO_MAIL_NOTIFICA_ALTRO = "OGGETTO_MAIL_NOTIFICA_ALTRO";
	public static final String TESTO_MAIL_NOTIFICA_ALTRO_TXT = "TESTO_MAIL_NOTIFICA_ALTRO_TXT";
	public static final String TESTO_MAIL_NOTIFICA_ALTRO_HTML = "TESTO_MAIL_NOTIFICA_ALTRO_HTML";

	public static final String SERVIZIO_ATTIVO_ANNULLA_CERT_SCADUTI = "SERVIZIO_ATTIVO_ANNULLA_CERT_SCADUTI";

	public static final String COGNOME_CERTIFICATORE = "@cognome.certificatore@";
	public static final String NOME_CERTIFICATORE = "@nome.certificatore@";

	public static final String CARRIAGE_RETURN = "@cr@";

	public static final int ID_TIPO_DOC_CURRICULUM = 1;
	public static final String DESC_TIPO_DOC_CURRICULUM = "CURRICULUM VITAE";

	public static final String PAGINA_RICERCA_APE_CERTIFICATORE = "RICERCA_APE_CERTIFICATORE";
	public static final String PAGINA_RICERCA_APE = "RICERCA_APE";

	/** The Constant ID_TIPO_AZIONE_INVIO. */
	public static final long ID_TIPO_AZIONE_INVIO = 1;

	/** The Constant ID_TIPO_AZIONE_CANCELLAZIONE. */
	public static final long ID_TIPO_AZIONE_ANNULLAMENTO = 2;

	public static final String TIPOLOGIA_ALLEGATO_ACE_NEW = "CERTIFICATO_NEW";

	public static final int LUNGHEZZA_MASSIMA_NOTE = 2000;

	public static final int ID_STATO_TRANS_MDP_NEW_ANNULLATO_BO = 0;
	public static final int ID_STATO_TRANS_MDP_NEW_CREA_TRANS = 1;
	public static final int ID_STATO_TRANS_MDP_NEW_URL_WIS = 2;
	public static final int ID_STATO_TRANS_MDP_NEW_AVVIO_TRANS = 3;
	public static final int ID_STATO_TRANS_MDP_NEW_ATTESA_RT = 4;
	public static final int ID_STATO_TRANS_MDP_NEW_PAGAMENTO_OK = 5;
	public static final int ID_STATO_TRANS_MDP_NEW_FALLITO = 6;
	public static final int ID_STATO_TRANS_MDP_NEW_ANNULLATO = 7;
	public static final int ID_STATO_TRANS_MDP_NEW_PAGAMENTO_KO = 8;
	public static final int ID_STATO_TRANS_MDP_NEW_PAGAMENTO_KO_AUTO = 9;

	/**
	 * Lunghezza di una partita IVA
	 */
	public static final int PARTITA_IVA_LEN = 11;
	/**
	 * Espressione regolare per la partita IVA
	 */
	public static final String PARTITA_IVA = "[0-9]{11}";

	public static final String PRESENTE = "PRESENTE";
	public static final String NON_PRESENTE = "NON PRESENTE";

	public static final String DESC_MOTIVO_ANNULLAMENTO_AUTO_SCADENZA = "Annullamento automatico per avvenuta scadenza";
	public static final String DESC_MOTIVO_ANNULLAMENTO_SCADENZA = "Annullato da BO per scadenza";

	// E-MAIL stuff - end

	/*PROTECTED REGION END*/
}
