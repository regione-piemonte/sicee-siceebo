

/**
 * Arricchimenti standard per il ContentPanel [cpCorsi] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpCorsi() {
	var contentPanelName = "cpCorsi";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpCorsi(){
/*PROTECTED REGION ID(R-315307695) ENABLED START*/
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

function initUIStructCpCorsi(){
	var contentPanelName = "cpCorsi";
	var structure =
      {
        name: "p_pCorsi", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpCorsi", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpSelezioneSO", panels: []
            }
,            {
              name: "p_wpCorsi", panels: []
            }
,            {
              name: "p_wpButtons", panels: []
            }
,            {
              name: "p_pCorsiNav", panels: []
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

	initStdEnrichments4CpCorsi();
	initCustomEnrichments4CpCorsi();
	initUIStructCpCorsi();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpCorsi");

});



