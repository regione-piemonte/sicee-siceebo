

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioPartecipante] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioPartecipante() {
	var contentPanelName = "cpDettaglioPartecipante";
	/// arricchimento di base per guigen::TextField [tfCodiceFiscale]
	var addBasicEnrichmentToTfCodiceFiscale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodiceFiscale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfCodiceFiscale);

	/// arricchimento di base per guigen::TextField [tfCognome]
	var addBasicEnrichmentToTfCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfCognome);
	/// arricchimento di base per guigen::TextField [tfNome]
	var addBasicEnrichmentToTfNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfNome);
	/// arricchimento di base per guigen::TextField [tfLuogoNascita]
	var addBasicEnrichmentToTfLuogoNascita =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfLuogoNascita',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfLuogoNascita);
	/// arricchimento per guigen::Calendar [calDataNascita]: aggiunta datepicker
	var addDateToCalDataNascita = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataNascita", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addDateToCalDataNascita);

	/// arricchimento di base per guigen::TextField [tfNumCertificatore]
	var addBasicEnrichmentToTfNumCertificatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumCertificatore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfNumCertificatore);
	/// arricchimento di base per guigen::TextField [tfAlbo]
	var addBasicEnrichmentToTfAlbo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAlbo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfAlbo);
	/// arricchimento di base per guigen::TextField [tfProvAlbo]
	var addBasicEnrichmentToTfProvAlbo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfProvAlbo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfProvAlbo);
	/// arricchimento di base per guigen::TextField [tfNumIscrAlbo]
	var addBasicEnrichmentToTfNumIscrAlbo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumIscrAlbo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfNumIscrAlbo);
	/// arricchimento per guigen::Calendar [calDataIscrAlbo]: aggiunta datepicker
	var addDateToCalDataIscrAlbo = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataIscrAlbo", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addDateToCalDataIscrAlbo);
	/// arricchimento di base per guigen::TextField [tfPercFreq]
	var addBasicEnrichmentToTfPercFreq =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPercFreq',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfPercFreq);
	/// arricchimento per guigen::Calendar [calDataEsame]: aggiunta datepicker
	var addDateToCalDataEsame = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataEsame", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addDateToCalDataEsame);
	/// arricchimento di base per guigen::TextField [tfVotoEsame]
	var addBasicEnrichmentToTfVotoEsame =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVotoEsame',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfVotoEsame);

	/// arricchimento di base per guigen::TextField [tfLuogoEsame]
	var addBasicEnrichmentToTfLuogoEsame =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfLuogoEsame',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfLuogoEsame);
	/// arricchimento di base per guigen::TextField [tfTelefono]
	var addBasicEnrichmentToTfTelefono =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTelefono',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfTelefono);
	/// arricchimento di base per guigen::TextField [tfEmail]
	var addBasicEnrichmentToTfEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioPartecipante", addBasicEnrichmentToTfEmail);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioPartecipante(){
/*PROTECTED REGION ID(R1982446582) ENABLED START*/
	/*
	 * definire e registrare qui eventuali arricchimenti custom, nel formato:
	 * var customEnr_n = function(){
	 *	// codice da eseguire all'applicazione dell'arricchimento
	 * };
	 * String customEnr_fragmentID = p_[id del pannello a cui deve essere associato l'arricchimento];
	 * uiEnricherMgr.registerEnrichment(contentPanelName, customEnr_fragmentID, customEnr_n);
	*/

/*PROTECTED REGION END*/
}

function initUIStructCpDettaglioPartecipante(){
	var contentPanelName = "cpDettaglioPartecipante";
	var structure =
      {
        name: "p_pDettaglioPartecipante", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpDettaglioPartecipante", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpLabelCorso", panels: []
            }
,            {
              name: "p_wpDettaglioPartecipante", panels: []
            }
,            {
              name: "p_pDatiRegistrazioneNav", panels: []
            }
            ]
          }
          ]
        }
,        {
          name: "p_pLeft", panels: [
          {
            name: "p_pMenu", panels: []
          }
          ]
        }
,        {
          name: "p_pUp", panels: [
          {
            name: "p_pUserInfoCustom", panels: [
            ]
          }
          ]
        }
        ]
      }
;
	uiEnricherMgr.setPageStructure(contentPanelName, structure);
}



// startup dell arricchimento con JQuery
$( function() {
	uiNRichLib.initStateManager();

	initStdEnrichments4CpDettaglioPartecipante();
	initCustomEnrichments4CpDettaglioPartecipante();
	initUIStructCpDettaglioPartecipante();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioPartecipante");

});



