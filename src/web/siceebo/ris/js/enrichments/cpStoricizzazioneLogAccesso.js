

/**
 * Arricchimenti standard per il ContentPanel [cpStoricizzazioneLogAccesso] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpStoricizzazioneLogAccesso() {
	var contentPanelName = "cpStoricizzazioneLogAccesso";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpStoricizzazioneLogAccesso(){
/*PROTECTED REGION ID(R1178817629) ENABLED START*/
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

function initUIStructCpStoricizzazioneLogAccesso(){
	var contentPanelName = "cpStoricizzazioneLogAccesso";
	var structure =
      {
        name: "p_pStoricizzazioneLogAccesso", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpStoricizzazioneLogAccesso", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpStoricizzazioneLogAccesso", panels: []
            }
,            {
              name: "p_cpStoricizzazioneLogAccesso", panels: []
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

	initStdEnrichments4CpStoricizzazioneLogAccesso();
	initCustomEnrichments4CpStoricizzazioneLogAccesso();
	initUIStructCpStoricizzazioneLogAccesso();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpStoricizzazioneLogAccesso");

});



