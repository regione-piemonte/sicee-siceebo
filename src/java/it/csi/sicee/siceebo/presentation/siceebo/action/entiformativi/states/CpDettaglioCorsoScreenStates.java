package it.csi.sicee.siceebo.presentation.siceebo.action.entiformativi.states;

import it.csi.sicee.siceebo.presentation.siceebo.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpDettaglioCorso
 */
public final class CpDettaglioCorsoScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpDettaglioCorsoScreenStates() {
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
		static final String[] WIDGETS_ON = new String[]{"tfTitolo", "calDataDal", "calDataAl", "tfProtApprov",
				"tfTotaleOre", "bIndietro", "bSalva", "menu", "tfNumCorso", "tfAnnoFormativo", "calDataApprov",
				"cbTipoCorso1", "tfLuogoCorso", "taNote", "lblSedeOperativa", "txtNotaA"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"tfTitolo", "calDataDal", "calDataAl", "tfProtApprov",
				"tfTotaleOre", "bIndietro", "bSalva", "menu", "tfNumCorso", "tfAnnoFormativo", "calDataApprov",
				"cbTipoCorso1", "tfLuogoCorso", "taNote", "lblSedeOperativa", "txtNotaA"};

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
		static final String[] WIDGETS_ON = new String[]{"bIndietro"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"lblSedeOperativa", "cbTipoCorso1", "tfAnnoFormativo",
				"tfNumCorso", "tfTitolo", "calDataDal", "calDataAl", "tfLuogoCorso", "tfProtApprov", "calDataApprov",
				"tfTotaleOre", "taNote", "txtNotaA", "bSalva", "menu"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"tfTitolo", "calDataDal", "calDataAl", "tfProtApprov",
				"tfTotaleOre", "bIndietro", "bSalva", "menu", "tfNumCorso", "tfAnnoFormativo", "calDataApprov",
				"cbTipoCorso1", "tfLuogoCorso", "taNote", "lblSedeOperativa", "txtNotaA"};

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
