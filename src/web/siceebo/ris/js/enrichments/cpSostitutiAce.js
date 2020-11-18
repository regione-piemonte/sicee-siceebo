

/**
 * Arricchimenti standard per il ContentPanel [cpSostitutiAce] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpSostitutiAce() {
	var contentPanelName = "cpSostitutiAce";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpSostitutiAce(){
/*PROTECTED REGION ID(R1839514320) ENABLED START*/
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

function initUIStructCpSostitutiAce(){
	var contentPanelName = "cpSostitutiAce";
	var structure =
      {
        name: "p_pSostitutiAce", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpSostitutiAce", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpAceSostituito", panels: []
            }
,            {
              name: "p_wpRisultatoAce", panels: []
            }
,            {
              name: "p_pPagamentoNav", panels: []
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

	initStdEnrichments4CpSostitutiAce();
	initCustomEnrichments4CpSostitutiAce();
	initUIStructCpSostitutiAce();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpSostitutiAce");

});



