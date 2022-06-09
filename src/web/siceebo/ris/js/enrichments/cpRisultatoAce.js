

/**
 * Arricchimenti standard per il ContentPanel [cpRisultatoAce] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisultatoAce() {
	var contentPanelName = "cpRisultatoAce";

	/// arricchimento di base per guigen::TextField [email]
	var addBasicEnrichmentToEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_email',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_emailWidgetPanel", addBasicEnrichmentToEmail);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisultatoAce(){
/*PROTECTED REGION ID(R720960663) ENABLED START*/
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

function initUIStructCpRisultatoAce(){
	var contentPanelName = "cpRisultatoAce";
	var structure =
      {
        name: "p_pRisultatoAce", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpRisultatoAce", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpRisultatoAce", panels: []
            }
,            {
              name: "p_pPagamentoNav", panels: []
            }
,            {
              name: "p_emailMultipanel", panels: [
              {
                name: "p_emailPanel", panels: [
                {
                  name: "p_emailWidgetPanel", panels: []
                }
,                {
                  name: "p_CloseEmailPanel", panels: []
                }
                ]
              }
              ]
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

	initStdEnrichments4CpRisultatoAce();
	initCustomEnrichments4CpRisultatoAce();
	initUIStructCpRisultatoAce();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisultatoAce");

});



