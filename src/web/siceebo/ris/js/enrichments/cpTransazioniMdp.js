

/**
 * Arricchimenti standard per il ContentPanel [cpTransazioniMdp] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpTransazioniMdp() {
	var contentPanelName = "cpTransazioniMdp";
	/// arricchimento di base per guigen::TextField [tfIdTrans]
	var addBasicEnrichmentToTfIdTrans =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIdTrans',
			 	false,
			 	'java.lang.Integer',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFiltriRicerca", addBasicEnrichmentToTfIdTrans);
	/// arricchimento per guigen::Calendar [calRicMdpDal]: aggiunta datepicker
	var addDateToCalRicMdpDal = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicMdpDal", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFiltriRicerca", addDateToCalRicMdpDal);
	/// arricchimento per guigen::Calendar [calRicMdpAl]: aggiunta datepicker
	var addDateToCalRicMdpAl = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicMdpAl", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFiltriRicerca", addDateToCalRicMdpAl);
	/// arricchimento di base per guigen::TextField [tfIuv]
	var addBasicEnrichmentToTfIuv =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIuv',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFiltriRicerca", addBasicEnrichmentToTfIuv);
	/// arricchimento di base per guigen::TextField [tfIdMdp]
	var addBasicEnrichmentToTfIdMdp =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIdMdp',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpFiltriRicerca", addBasicEnrichmentToTfIdMdp);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpTransazioniMdp(){
/*PROTECTED REGION ID(R246595206) ENABLED START*/
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

function initUIStructCpTransazioniMdp(){
	var contentPanelName = "cpTransazioniMdp";
	var structure =
      {
        name: "p_pTransazioniMdp", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpTransazioniMdp", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpResTransMdp", panels: []
            }
,            {
              name: "p_wpFiltriRicerca", panels: []
            }
,            {
              name: "p_wpDettTransMdpAttesa", panels: []
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

	initStdEnrichments4CpTransazioniMdp();
	initCustomEnrichments4CpTransazioniMdp();
	initUIStructCpTransazioniMdp();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpTransazioniMdp");

});



