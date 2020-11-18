package it.csi.sicee.siceebo.presentation.siceebo.action.entiformativi.states;

import it.csi.sicee.siceebo.presentation.siceebo.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpDettaglioPartecipante
 */
public final class CpDettaglioPartecipanteScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpDettaglioPartecipanteScreenStates() {
		// costruttore intenzionalmente vuoto
	}

	/**
	 * Questa classe rappresenta lo ScreenState RUOLO_RW.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class RUOLO_RWScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"tfCodiceFiscale", "bCercaCfCertificatori", "cbListaCf",
				"tfCognome", "tfNome", "cbTipoIstruzione", "tfAlbo", "tfProvAlbo", "tfNumIscrAlbo", "calDataIscrAlbo",
				"calDataEsame", "cbEsitoEsame", "tfVotoEsame", "tfTelefono", "tfEmail", "taNote", "bIndietro", "bSalva",
				"menu", "bStampaAttestato", "lblSedeOperativa2", "lblTitoloCorso2", "tfLuogoNascita", "calDataNascita",
				"tfPercFreq", "tfLuogoEsame", "txtNotaA", "txtNotaB"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"tfNumCertificatore"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"tfCodiceFiscale", "bCercaCfCertificatori", "cbListaCf",
				"tfCognome", "tfNome", "cbTipoIstruzione", "tfNumCertificatore", "tfAlbo", "tfProvAlbo",
				"tfNumIscrAlbo", "calDataIscrAlbo", "calDataEsame", "cbEsitoEsame", "tfVotoEsame", "tfTelefono",
				"tfEmail", "taNote", "bIndietro", "bSalva", "menu", "bStampaAttestato", "lblSedeOperativa2",
				"lblTitoloCorso2", "tfLuogoNascita", "calDataNascita", "tfPercFreq", "tfLuogoEsame", "txtNotaA",
				"txtNotaB"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("RUOLO_RW", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private RUOLO_RWScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

	/**
	 * Questa classe rappresenta lo ScreenState RUOLO_R.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class RUOLO_RScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"bIndietro", "menu"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"lblTitoloCorso2", "lblSedeOperativa2", "tfCodiceFiscale",
				"bCercaCfCertificatori", "cbListaCf", "tfCognome", "tfNome", "tfLuogoNascita", "calDataNascita",
				"cbTipoIstruzione", "tfNumCertificatore", "tfAlbo", "tfProvAlbo", "tfNumIscrAlbo", "calDataIscrAlbo",
				"tfPercFreq", "calDataEsame", "tfVotoEsame", "cbEsitoEsame", "tfLuogoEsame", "tfTelefono", "tfEmail",
				"taNote", "bStampaAttestato", "txtNotaA", "txtNotaB", "bSalva"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"tfCodiceFiscale", "bCercaCfCertificatori", "cbListaCf",
				"tfCognome", "tfNome", "cbTipoIstruzione", "tfNumCertificatore", "tfAlbo", "tfProvAlbo",
				"tfNumIscrAlbo", "calDataIscrAlbo", "calDataEsame", "cbEsitoEsame", "tfVotoEsame", "tfTelefono",
				"tfEmail", "taNote", "bIndietro", "bSalva", "menu", "bStampaAttestato", "tfLuogoNascita",
				"calDataNascita", "tfPercFreq", "tfLuogoEsame", "lblTitoloCorso2", "lblSedeOperativa2", "txtNotaA",
				"txtNotaB"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("RUOLO_R", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private RUOLO_RScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

}
