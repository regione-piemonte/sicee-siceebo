

/**
 * Arricchimenti standard per il ContentPanel [cpRecuperaCoordinateLOCCSI] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRecuperaCoordinateLOCCSI() {
	var contentPanelName = "cpRecuperaCoordinateLOCCSI";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRecuperaCoordinateLOCCSI(){
/*PROTECTED REGION ID(R940771721) ENABLED START*/
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

function initUIStructCpRecuperaCoordinateLOCCSI(){
	var contentPanelName = "cpRecuperaCoordinateLOCCSI";
	var structure =
      {
        name: "p_pRecuperaCoordinateLOCCSI", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpRecuperaCoordinateLOCCSI", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpRecuperaCoordinateLOCCSI", panels: []
            }
,            {
              name: "p_cpRecuperaCoordinateLOCCSI", panels: []
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

	initStdEnrichments4CpRecuperaCoordinateLOCCSI();
	initCustomEnrichments4CpRecuperaCoordinateLOCCSI();
	initUIStructCpRecuperaCoordinateLOCCSI();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRecuperaCoordinateLOCCSI");

});



