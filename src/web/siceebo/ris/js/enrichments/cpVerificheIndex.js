

/**
 * Arricchimenti standard per il ContentPanel [cpVerificheIndex] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpVerificheIndex() {
	var contentPanelName = "cpVerificheIndex";
	/// arricchimento di base per guigen::TextField [tfAnnoCertificato]
	var addBasicEnrichmentToTfAnnoCertificato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoCertificato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce", addBasicEnrichmentToTfAnnoCertificato);
	/// arricchimento di base per guigen::TextField [tfCertificatore]
	var addBasicEnrichmentToTfCertificatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCertificatore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce", addBasicEnrichmentToTfCertificatore);
	/// arricchimento di base per guigen::TextField [tfProgCertificato]
	var addBasicEnrichmentToTfProgCertificato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfProgCertificato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce", addBasicEnrichmentToTfProgCertificato);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpVerificheIndex(){
/*PROTECTED REGION ID(R-1284358038) ENABLED START*/
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

function initUIStructCpVerificheIndex(){
	var contentPanelName = "cpVerificheIndex";
	var structure =
      {
        name: "p_pVerificheMdp", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpVerificheIndex", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpRicercaAce", panels: []
            }
,            {
              name: "p_pRicercaAce", panels: []
            }
,            {
              name: "p_wpVerificaIndex", panels: []
            }
,            {
              name: "p_cpTransazioniMdp", panels: []
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

	initStdEnrichments4CpVerificheIndex();
	initCustomEnrichments4CpVerificheIndex();
	initUIStructCpVerificheIndex();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpVerificheIndex");

});



