

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaCertificatori] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaCertificatori() {
	var contentPanelName = "cpRicercaCertificatori";
	/// arricchimento di base per guigen::TextField [tfRicCertMatr]
	var addBasicEnrichmentToTfRicCertMatr =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicCertMatr',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaCertificatori", addBasicEnrichmentToTfRicCertMatr);

	/// arricchimento di base per guigen::TextField [tfRicCertNome]
	var addBasicEnrichmentToTfRicCertNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicCertNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaCertificatori", addBasicEnrichmentToTfRicCertNome);
	/// arricchimento di base per guigen::TextField [tfRicCertCognome]
	var addBasicEnrichmentToTfRicCertCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicCertCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaCertificatori", addBasicEnrichmentToTfRicCertCognome);
	/// arricchimento di base per guigen::TextField [tfRicCertRagSociale]
	var addBasicEnrichmentToTfRicCertRagSociale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicCertRagSociale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaCertificatori", addBasicEnrichmentToTfRicCertRagSociale);



	/// arricchimento di base per guigen::TextField [tfRicComune]
	var addBasicEnrichmentToTfRicComune =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicComune',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaCertificatori", addBasicEnrichmentToTfRicComune);
	/// arricchimento per guigen::Calendar [calRicCertACEDal]: aggiunta datepicker
	var addDateToCalRicCertACEDal = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicCertACEDal", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaCertificatori", addDateToCalRicCertACEDal);
	/// arricchimento per guigen::Calendar [calRicCertACEal]: aggiunta datepicker
	var addDateToCalRicCertACEal = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicCertACEal", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaCertificatori", addDateToCalRicCertACEal);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaCertificatori(){
/*PROTECTED REGION ID(R-510763600) ENABLED START*/
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

function initUIStructCpRicercaCertificatori(){
	var contentPanelName = "cpRicercaCertificatori";
	var structure =
      {
        name: "p_pRicercaCertificatori", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpRicercaCertificatori", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpRicercaCertificatori", panels: []
            }
,            {
              name: "p_pRicercaCertificatoriNav", panels: []
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

	initStdEnrichments4CpRicercaCertificatori();
	initCustomEnrichments4CpRicercaCertificatori();
	initUIStructCpRicercaCertificatori();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaCertificatori");

});



