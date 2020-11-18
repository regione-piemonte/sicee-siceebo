

/**
 * Arricchimenti standard per il ContentPanel [cpDatiRegistrazione] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDatiRegistrazione() {
	var contentPanelName = "cpDatiRegistrazione";

	/// arricchimento di base per guigen::TextField [tfRagSociale]
	var addBasicEnrichmentToTfRagSociale =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRagSociale',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRegistrazione1", addBasicEnrichmentToTfRagSociale);
	/// arricchimento di base per guigen::TextField [tfPIVA]
	var addBasicEnrichmentToTfPIVA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfPIVA',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRegistrazione1", addBasicEnrichmentToTfPIVA);

	/// arricchimento di base per guigen::TextField [tfCodFormReg]
	var addBasicEnrichmentToTfCodFormReg =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCodFormReg',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRegistrazione2", addBasicEnrichmentToTfCodFormReg);



	/// arricchimento di base per guigen::TextField [tfIndirizzo]
	var addBasicEnrichmentToTfIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRegistrazione2", addBasicEnrichmentToTfIndirizzo);

	/// arricchimento di base per guigen::TextField [tfNumCivico]
	var addBasicEnrichmentToTfNumCivico =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfNumCivico',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRegistrazione2", addBasicEnrichmentToTfNumCivico);
	/// arricchimento di base per guigen::TextField [tfCap]
	var addBasicEnrichmentToTfCap =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCap',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiRegistrazione2", addBasicEnrichmentToTfCap);
	/// arricchimento di base per guigen::TextField [tfTelefono]
	var addBasicEnrichmentToTfTelefono =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfTelefono',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpContatti", addBasicEnrichmentToTfTelefono);
	/// arricchimento di base per guigen::TextField [tfCell]
	var addBasicEnrichmentToTfCell =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCell',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpContatti", addBasicEnrichmentToTfCell);
	/// arricchimento di base per guigen::TextField [tfEmail]
	var addBasicEnrichmentToTfEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpContatti", addBasicEnrichmentToTfEmail);
	/// arricchimento di base per guigen::TextField [tfEmailPEC]
	var addBasicEnrichmentToTfEmailPEC =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmailPEC',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpContatti", addBasicEnrichmentToTfEmailPEC);
	/// arricchimento di base per guigen::TextField [tfSitoWeb]
	var addBasicEnrichmentToTfSitoWeb =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSitoWeb',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpContatti", addBasicEnrichmentToTfSitoWeb);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDatiRegistrazione(){
/*PROTECTED REGION ID(R-1845101899) ENABLED START*/
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

function initUIStructCpDatiRegistrazione(){
	var contentPanelName = "cpDatiRegistrazione";
	var structure =
      {
        name: "p_pDatiRegistrazione", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpDatiRegistrazione", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpDatiRegistrazione1", panels: []
            }
,            {
              name: "p_wpSelezioneSO", panels: []
            }
,            {
              name: "p_wpDatiRegistrazione2", panels: []
            }
,            {
              name: "p_wpContatti", panels: []
            }
,            {
              name: "p_wpLogo", panels: []
            }
,            {
              name: "p_pDatiRegistrazioneNav", panels: []
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

	initStdEnrichments4CpDatiRegistrazione();
	initCustomEnrichments4CpDatiRegistrazione();
	initUIStructCpDatiRegistrazione();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDatiRegistrazione");

});



