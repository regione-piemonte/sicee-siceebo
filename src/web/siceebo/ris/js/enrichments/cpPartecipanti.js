

/**
 * Arricchimenti standard per il ContentPanel [cpPartecipanti] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpPartecipanti() {
	var contentPanelName = "cpPartecipanti";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpPartecipanti(){
/*PROTECTED REGION ID(R203017865) ENABLED START*/
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

function initUIStructCpPartecipanti(){
	var contentPanelName = "cpPartecipanti";
	var structure =
      {
        name: "p_pPartecipanti", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpPartecipanti", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpLabelCorso", panels: []
            }
,            {
              name: "p_wpPartecipanti", panels: []
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

	initStdEnrichments4CpPartecipanti();
	initCustomEnrichments4CpPartecipanti();
	initUIStructCpPartecipanti();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpPartecipanti");

});



