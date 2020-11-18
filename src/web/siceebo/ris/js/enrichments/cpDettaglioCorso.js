

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioCorso] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioCorso() {
	var contentPanelName = "cpDettaglioCorso";

	/// arricchimento di base per guigen::TextField [tfAnnoFormativo]
	var addBasicEnrichmentToTfAnnoFormativo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoFormativo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioCorso", addBasicEnrichmentToTfAnnoFormativo);
	/// arricchimento di base per guigen::TextField [tfNumCorso]
	var addBasicEnrichmentToTfNumCorso =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumCorso',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioCorso", addBasicEnrichmentToTfNumCorso);
	/// arricchimento di base per guigen::TextField [tfTitolo]
	var addBasicEnrichmentToTfTitolo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTitolo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioCorso", addBasicEnrichmentToTfTitolo);
	/// arricchimento per guigen::Calendar [calDataDal]: aggiunta datepicker
	var addDateToCalDataDal = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataDal", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioCorso", addDateToCalDataDal);
	/// arricchimento per guigen::Calendar [calDataAl]: aggiunta datepicker
	var addDateToCalDataAl = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataAl", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioCorso", addDateToCalDataAl);
	/// arricchimento di base per guigen::TextField [tfLuogoCorso]
	var addBasicEnrichmentToTfLuogoCorso =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfLuogoCorso',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioCorso", addBasicEnrichmentToTfLuogoCorso);
	/// arricchimento di base per guigen::TextField [tfProtApprov]
	var addBasicEnrichmentToTfProtApprov =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfProtApprov',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioCorso", addBasicEnrichmentToTfProtApprov);
	/// arricchimento per guigen::Calendar [calDataApprov]: aggiunta datepicker
	var addDateToCalDataApprov = function(){
		uiNRichLib.addDatePickerNRich("widg_calDataApprov", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioCorso", addDateToCalDataApprov);
	/// arricchimento di base per guigen::TextField [tfTotaleOre]
	var addBasicEnrichmentToTfTotaleOre =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTotaleOre',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDettaglioCorso", addBasicEnrichmentToTfTotaleOre);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioCorso(){
/*PROTECTED REGION ID(R395857030) ENABLED START*/
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

function initUIStructCpDettaglioCorso(){
	var contentPanelName = "cpDettaglioCorso";
	var structure =
      {
        name: "p_pDettaglioCorso", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpDettaglioCorso", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpDettaglioCorso", panels: []
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

	initStdEnrichments4CpDettaglioCorso();
	initCustomEnrichments4CpDettaglioCorso();
	initUIStructCpDettaglioCorso();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioCorso");

});



