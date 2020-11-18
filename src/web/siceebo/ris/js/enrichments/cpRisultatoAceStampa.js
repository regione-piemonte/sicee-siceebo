

/**
 * Arricchimenti standard per il ContentPanel [cpRisultatoAceStampa] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisultatoAceStampa() {
	var contentPanelName = "cpRisultatoAceStampa";

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisultatoAceStampa(){
/*PROTECTED REGION ID(R360556149) ENABLED START*/
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

function initUIStructCpRisultatoAceStampa(){
	var contentPanelName = "cpRisultatoAceStampa";
	var structure =
      {
        name: "p_pRisultatoAceStampa", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpRisultatoAceStampa", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpRisultatoAce", panels: []
            }
,            {
              name: "p_pSpampaNav", panels: []
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

	initStdEnrichments4CpRisultatoAceStampa();
	initCustomEnrichments4CpRisultatoAceStampa();
	initUIStructCpRisultatoAceStampa();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisultatoAceStampa");

});



