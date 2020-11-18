package it.csi.sicee.siceebo.presentation.siceebo.action.entiformativi.states;

import it.csi.sicee.siceebo.presentation.siceebo.action.ScreenStateCommand;

/**
 * Questa classe contiene le informazioni relative agli ScreenStates del ContentPanel cpDatiRegistrazione
 */
public final class CpDatiRegistrazioneScreenStates {

	/**
	 * Costruttore privato (questa e' una utility class)
	 */
	private CpDatiRegistrazioneScreenStates() {
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
		static final String[] WIDGETS_ON = new String[]{"menu", "cbReg", "cbProv", "cbCom", "tfIndirizzo", "vVerifInd",
				"cbSceltaInd", "tfNumCivico", "tfCap", "tfTelefono", "tfCell", "tfEmail", "tfEmailPEC", "tfSitoWeb",
				"bIndietro", "bSalva", "cbTipoSoggetto", "tfCodFormReg", "cbSelezioneSO", "fileImmagineLogo",
				"btnCaricaLogo", "txtNotaA", "txtPresenzaLogo", "txtNotaNull"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"tfRagSociale", "tfPIVA"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"menu", "tfRagSociale", "tfPIVA", "cbReg", "cbProv", "cbCom",
				"tfIndirizzo", "vVerifInd", "cbSceltaInd", "tfNumCivico", "tfCap", "tfTelefono", "tfCell", "tfEmail",
				"tfEmailPEC", "tfSitoWeb", "bIndietro", "bSalva", "cbTipoSoggetto", "tfCodFormReg", "cbSelezioneSO",
				"fileImmagineLogo", "btnCaricaLogo", "txtNotaA", "txtPresenzaLogo", "txtNotaNull"};

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
		static final String[] WIDGETS_ON = new String[]{"menu", "bIndietro"};

		/**
		 * widget disabilitati nello stato
		 */
		static final String[] WIDGETS_OFF = new String[]{"cbTipoSoggetto", "tfRagSociale", "tfPIVA", "cbSelezioneSO",
				"tfCodFormReg", "cbReg", "cbProv", "cbCom", "tfIndirizzo", "vVerifInd", "cbSceltaInd", "tfNumCivico",
				"tfCap", "tfTelefono", "tfCell", "tfEmail", "tfEmailPEC", "tfSitoWeb", "fileImmagineLogo",
				"btnCaricaLogo", "txtPresenzaLogo", "txtNotaNull", "txtNotaA", "bSalva"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"menu", "tfRagSociale", "tfPIVA", "cbReg", "cbProv", "cbCom",
				"tfIndirizzo", "vVerifInd", "cbSceltaInd", "tfNumCivico", "tfCap", "tfTelefono", "tfCell", "tfEmail",
				"tfEmailPEC", "tfSitoWeb", "bIndietro", "bSalva", "cbTipoSoggetto", "tfCodFormReg", "cbSelezioneSO",
				"fileImmagineLogo", "btnCaricaLogo", "txtNotaA", "txtPresenzaLogo", "txtNotaNull"};

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
		static final String[] WIDGETS_OFF = new String[]{"cbTipoSoggetto", "tfRagSociale", "tfPIVA", "cbSelezioneSO",
				"tfCodFormReg", "cbReg", "cbProv", "cbCom", "tfIndirizzo", "vVerifInd", "cbSceltaInd", "tfNumCivico",
				"tfCap", "tfTelefono", "tfCell", "tfEmail", "tfEmailPEC", "tfSitoWeb", "fileImmagineLogo",
				"btnCaricaLogo", "txtPresenzaLogo", "txtNotaNull", "txtNotaA", "bSalva", "menu"};

		/**
		 * widget visibili nello stato
		 */
		static final String[] WIDGETS_SHOWN = new String[]{"tfRagSociale", "tfPIVA", "cbReg", "cbProv", "cbCom",
				"tfIndirizzo", "vVerifInd", "cbSceltaInd", "tfNumCivico", "tfCap", "tfTelefono", "tfCell", "tfEmail",
				"tfEmailPEC", "tfSitoWeb", "bIndietro", "bSalva", "menu", "cbTipoSoggetto", "tfCodFormReg",
				"cbSelezioneSO", "fileImmagineLogo", "btnCaricaLogo"};

		/**
		 * widget nascosti nello stato
		 */
		static final String[] WIDGETS_HIDDEN = new String[]{"txtPresenzaLogo", "txtNotaNull", "txtNotaA"};

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
