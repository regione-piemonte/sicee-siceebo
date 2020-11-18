

/**
 * Arricchimenti standard per il ContentPanel [cpRisultatoCertificatoriAdv] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRisultatoCertificatoriAdv() {
	var contentPanelName = "cpRisultatoCertificatoriAdv";


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRisultatoCertificatoriAdv(){
/*PROTECTED REGION ID(R-276645397) ENABLED START*/
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

function initUIStructCpRisultatoCertificatoriAdv(){
	var contentPanelName = "cpRisultatoCertificatoriAdv";
	var structure =
      {
        name: "p_pRisultatoCertificatori", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpRisultatoCertificatori", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_fpStatoCert", panels: [
              {
                name: "p_wpStatoCertificatore", panels: []
              }
              ]
            }
,            {
              name: "p_wpRisultatoCertificatori", panels: []
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

	initStdEnrichments4CpRisultatoCertificatoriAdv();
	initCustomEnrichments4CpRisultatoCertificatoriAdv();
	initUIStructCpRisultatoCertificatoriAdv();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRisultatoCertificatoriAdv");

});



