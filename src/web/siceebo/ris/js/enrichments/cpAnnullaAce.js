

/**
 * Arricchimenti standard per il ContentPanel [cpAnnullaAce] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpAnnullaAce() {
	var contentPanelName = "cpAnnullaAce";
	/// arricchimento di base per guigen::TextField [tfDataAnnullamento]
	var addBasicEnrichmentToTfDataAnnullamento =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDataAnnullamento',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAnnullaAce", addBasicEnrichmentToTfDataAnnullamento);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpAnnullaAce(){
/*PROTECTED REGION ID(R-1674869691) ENABLED START*/
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

function initUIStructCpAnnullaAce(){
	var contentPanelName = "cpAnnullaAce";
	var structure =
      {
        name: "p_pAnnullaAce", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpAnnullaAce", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpAnnullaAce", panels: []
            }
,            {
              name: "p_pAnnullaFun", panels: []
            }
,            {
              name: "p_pAnnullaNav", panels: []
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

	initStdEnrichments4CpAnnullaAce();
	initCustomEnrichments4CpAnnullaAce();
	initUIStructCpAnnullaAce();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpAnnullaAce");

});



