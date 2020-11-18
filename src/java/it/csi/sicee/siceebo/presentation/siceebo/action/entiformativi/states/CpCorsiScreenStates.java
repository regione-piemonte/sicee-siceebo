package it.csi.sicee.siceebo.presentation.siceebo.action.entiformativi.states;

import it.csi.sicee.siceebo.presentation.siceebo.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpCorsi
 */
public final class CpCorsiScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpCorsiScreenStates() {
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
		static final String[] WIDGETS_ON = new String[]{"tblElencoCorsi", "btnEliminaCorso", "btnDettaglioCorso",
				"btnPartecipanti", "bIndietro", "bInserisciNuovo", "menu", "txtMsgConfermaEliminaCorso",
				"bIndietroCorsi", "bEliminaCorso", "cbSelezioneSO"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"tblElencoCorsi", "btnEliminaCorso", "btnDettaglioCorso",
				"btnPartecipanti", "bIndietro", "bInserisciNuovo", "menu", "txtMsgConfermaEliminaCorso",
				"bIndietroCorsi", "bEliminaCorso", "cbSelezioneSO"};

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
		static final String[] WIDGETS_ON = new String[]{"btnDettaglioCorso", "btnPartecipanti", "bIndietro", "menu",
				"cbSelezioneSO"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"tblElencoCorsi", "btnEliminaCorso", "bInserisciNuovo",
				"txtMsgConfermaEliminaCorso", "bIndietroCorsi", "bEliminaCorso"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"tblElencoCorsi", "btnEliminaCorso", "btnDettaglioCorso",
				"btnPartecipanti", "bIndietro", "bInserisciNuovo", "menu", "txtMsgConfermaEliminaCorso",
				"bIndietroCorsi", "bEliminaCorso", "cbSelezioneSO"};

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

	/**
	 * Questa classe rappresenta lo ScreenState ABORT.
	 * NOTA BENE: questa classe e' attualmente non utilizzata (i widget visibili/abilitati sono
	 * contenuti nel file JSON che contiene il comando ScreenStateCommand.
	 * La classe e' pero' mantenuta per future evoluzioni. 
	 */
	public static final class ABORTScreenState {

		/**
		 * widget abilitati nello stato
		 */
		static final String[] WIDGETS_ON = new String[]{"bIndietro"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"cbSelezioneSO", "tblElencoCorsi", "btnEliminaCorso",
				"btnDettaglioCorso", "btnPartecipanti", "bInserisciNuovo", "menu", "txtMsgConfermaEliminaCorso",
				"bIndietroCorsi", "bEliminaCorso"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"tblElencoCorsi", "btnEliminaCorso", "btnDettaglioCorso",
				"btnPartecipanti", "bIndietro", "bInserisciNuovo", "menu", "txtMsgConfermaEliminaCorso",
				"bIndietroCorsi", "bEliminaCorso", "cbSelezioneSO"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{};

		/**
		 * Istanza del comando che permette di passare a questo stato
		 */
		static final ScreenStateCommand COMMAND = new ScreenStateCommand("ABORT", WIDGETS_ON, WIDGETS_OFF,
				WIDGETS_SHOWN, WIDGETS_HIDDEN);

		/**
		 * Costruttore privato (questa e' una utility class)
		 */
		private ABORTScreenState() {
			// costruttore intenzionalmente vuoto
		}
	}

}
