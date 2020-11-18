

/**
 * Arricchimenti standard per il ContentPanel [cpStampaAce] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpStampaAce() {
	var contentPanelName = "cpStampaAce";
	/// arricchimento di base per guigen::TextField [tfAnnoCertificato]
	var addBasicEnrichmentToTfAnnoCertificato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoCertificato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceCod", addBasicEnrichmentToTfAnnoCertificato);
	/// arricchimento di base per guigen::TextField [tfCertificatore]
	var addBasicEnrichmentToTfCertificatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCertificatore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceCod", addBasicEnrichmentToTfCertificatore);
	/// arricchimento di base per guigen::TextField [tfProgCertificato]
	var addBasicEnrichmentToTfProgCertificato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfProgCertificato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceCod", addBasicEnrichmentToTfProgCertificato);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpStampaAce(){
/*PROTECTED REGION ID(R1195639770) ENABLED START*/
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

function initUIStructCpStampaAce(){
	var contentPanelName = "cpStampaAce";
	var structure =
      {
        name: "p_pStampaAce", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpStampaAce", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpRicercaAceCod", panels: []
            }
,            {
              name: "p_pDescCompilaz", panels: []
            }
,            {
              name: "p_pRicercaAceInviatiByCodiceNav", panels: []
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

	initStdEnrichments4CpStampaAce();
	initCustomEnrichments4CpStampaAce();
	initUIStructCpStampaAce();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpStampaAce");

});



