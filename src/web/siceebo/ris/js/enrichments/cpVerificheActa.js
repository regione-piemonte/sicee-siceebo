

/**
 * Arricchimenti standard per il ContentPanel [cpVerificheActa] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpVerificheActa() {
	var contentPanelName = "cpVerificheActa";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpVerificheActa(){
/*PROTECTED REGION ID(R-961824837) ENABLED START*/
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

function initUIStructCpVerificheActa(){
	var contentPanelName = "cpVerificheActa";
	var structure =
      {
        name: "p_pVerificheActa", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpVerificheActa", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpVerificaActa", panels: []
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

	initStdEnrichments4CpVerificheActa();
	initCustomEnrichments4CpVerificheActa();
	initUIStructCpVerificheActa();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpVerificheActa");

});



