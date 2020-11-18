

/**
 * Arricchimenti standard per il ContentPanel [cpDettaglioCertificatore] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpDettaglioCertificatore() {
	var contentPanelName = "cpDettaglioCertificatore";

	/// arricchimento di base per guigen::TextField [tfDettCertCognome]
	var addBasicEnrichmentToTfDettCertCognome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertCognome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiPersonali", addBasicEnrichmentToTfDettCertCognome);
	/// arricchimento di base per guigen::TextField [tfDettCertNome]
	var addBasicEnrichmentToTfDettCertNome =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertNome',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiPersonali", addBasicEnrichmentToTfDettCertNome);
	/// arricchimento di base per guigen::TextField [tfDettCertCodFisc]
	var addBasicEnrichmentToTfDettCertCodFisc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertCodFisc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiPersonali", addBasicEnrichmentToTfDettCertCodFisc);
	/// arricchimento di base per guigen::TextField [tfDettCertDtNasc]
	var addBasicEnrichmentToTfDettCertDtNasc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertDtNasc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiPersonali", addBasicEnrichmentToTfDettCertDtNasc);
	/// arricchimento di base per guigen::TextField [tfDettCertComuneNasc]
	var addBasicEnrichmentToTfDettCertComuneNasc =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertComuneNasc',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiPersonali", addBasicEnrichmentToTfDettCertComuneNasc);
	/// arricchimento di base per guigen::TextField [tfDettCertIndirizzoRes]
	var addBasicEnrichmentToTfDettCertIndirizzoRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertIndirizzoRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiPersonali", addBasicEnrichmentToTfDettCertIndirizzoRes);
	/// arricchimento di base per guigen::TextField [tfDettCertCivicoRes]
	var addBasicEnrichmentToTfDettCertCivicoRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertCivicoRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiPersonali", addBasicEnrichmentToTfDettCertCivicoRes);
	/// arricchimento di base per guigen::TextField [tfDettCertCapRes]
	var addBasicEnrichmentToTfDettCertCapRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertCapRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiPersonali", addBasicEnrichmentToTfDettCertCapRes);
	/// arricchimento di base per guigen::TextField [tfDettCertComuneRes]
	var addBasicEnrichmentToTfDettCertComuneRes =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertComuneRes',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpDatiPersonali", addBasicEnrichmentToTfDettCertComuneRes);
	/// arricchimento di base per guigen::TextField [tfDettCertDenominazioneAz]
	var addBasicEnrichmentToTfDettCertDenominazioneAz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertDenominazioneAz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAzienda", addBasicEnrichmentToTfDettCertDenominazioneAz);
	/// arricchimento di base per guigen::TextField [tfDettCertPivaAz]
	var addBasicEnrichmentToTfDettCertPivaAz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertPivaAz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAzienda", addBasicEnrichmentToTfDettCertPivaAz);
	/// arricchimento di base per guigen::TextField [tfDettCertIndirizzoAz]
	var addBasicEnrichmentToTfDettCertIndirizzoAz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertIndirizzoAz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAzienda", addBasicEnrichmentToTfDettCertIndirizzoAz);
	/// arricchimento di base per guigen::TextField [tfDettCertCivicoAz]
	var addBasicEnrichmentToTfDettCertCivicoAz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertCivicoAz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAzienda", addBasicEnrichmentToTfDettCertCivicoAz);
	/// arricchimento di base per guigen::TextField [tfDettCertCapAz]
	var addBasicEnrichmentToTfDettCertCapAz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertCapAz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAzienda", addBasicEnrichmentToTfDettCertCapAz);
	/// arricchimento di base per guigen::TextField [tfDettCertComuneAz]
	var addBasicEnrichmentToTfDettCertComuneAz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertComuneAz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAzienda", addBasicEnrichmentToTfDettCertComuneAz);
	/// arricchimento di base per guigen::TextField [tfDettCertProvAz]
	var addBasicEnrichmentToTfDettCertProvAz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertProvAz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpAzienda", addBasicEnrichmentToTfDettCertProvAz);
	/// arricchimento di base per guigen::TextField [tfDettCertTelefono]
	var addBasicEnrichmentToTfDettCertTelefono =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertTelefono',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpContatti", addBasicEnrichmentToTfDettCertTelefono);
	/// arricchimento di base per guigen::TextField [tfDettCertCell]
	var addBasicEnrichmentToTfDettCertCell =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertCell',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpContatti", addBasicEnrichmentToTfDettCertCell);
	/// arricchimento di base per guigen::TextField [tfDettCertEmail]
	var addBasicEnrichmentToTfDettCertEmail =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertEmail',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpContatti", addBasicEnrichmentToTfDettCertEmail);
	/// arricchimento di base per guigen::TextField [tfDettCertEmailpec]
	var addBasicEnrichmentToTfDettCertEmailpec =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertEmailpec',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpContatti", addBasicEnrichmentToTfDettCertEmailpec);

	/// arricchimento di base per guigen::TextField [tfDettCertTipoIstruzione]
	var addBasicEnrichmentToTfDettCertTipoIstruzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertTipoIstruzione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTitoloStudio", addBasicEnrichmentToTfDettCertTipoIstruzione);
	/// arricchimento di base per guigen::TextField [tfDettCertCodiceIstruzione]
	var addBasicEnrichmentToTfDettCertCodiceIstruzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertCodiceIstruzione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTitoloStudio", addBasicEnrichmentToTfDettCertCodiceIstruzione);
	/// arricchimento di base per guigen::TextField [tfDettCertTitoloIstruzione]
	var addBasicEnrichmentToTfDettCertTitoloIstruzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertTitoloIstruzione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTitoloStudio", addBasicEnrichmentToTfDettCertTitoloIstruzione);
	/// arricchimento di base per guigen::TextField [tfDettCertSezioneIstruzione]
	var addBasicEnrichmentToTfDettCertSezioneIstruzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertSezioneIstruzione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTitoloStudio", addBasicEnrichmentToTfDettCertSezioneIstruzione);
	/// arricchimento di base per guigen::TextField [tfDettCertSettoreIstruzione]
	var addBasicEnrichmentToTfDettCertSettoreIstruzione =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertSettoreIstruzione',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTitoloStudio", addBasicEnrichmentToTfDettCertSettoreIstruzione);
	/// arricchimento di base per guigen::TextField [tfDettCertAlbo]
	var addBasicEnrichmentToTfDettCertAlbo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertAlbo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTitoloStudio", addBasicEnrichmentToTfDettCertAlbo);
	/// arricchimento di base per guigen::TextField [tfDettCertAlboProv]
	var addBasicEnrichmentToTfDettCertAlboProv =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertAlboProv',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTitoloStudio", addBasicEnrichmentToTfDettCertAlboProv);
	/// arricchimento di base per guigen::TextField [tfDettCertAlboNumIscriz]
	var addBasicEnrichmentToTfDettCertAlboNumIscriz =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertAlboNumIscriz',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTitoloStudio", addBasicEnrichmentToTfDettCertAlboNumIscriz);
	/// arricchimento di base per guigen::TextField [tfDettCertAlboData]
	var addBasicEnrichmentToTfDettCertAlboData =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfDettCertAlboData',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpTitoloStudio", addBasicEnrichmentToTfDettCertAlboData);

	/// arricchimento di base per guigen::TextField [tfRicACEAnno]
	var addBasicEnrichmentToTfRicACEAnno =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicACEAnno',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaApe", addBasicEnrichmentToTfRicACEAnno);
	/// arricchimento per guigen::Calendar [calRicACEDal]: aggiunta datepicker
	var addDateToCalRicACEDal = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicACEDal", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaApe", addDateToCalRicACEDal);
	/// arricchimento per guigen::Calendar [calRicACEal]: aggiunta datepicker
	var addDateToCalRicACEal = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicACEal", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaApe", addDateToCalRicACEal);


}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpDettaglioCertificatore(){
/*PROTECTED REGION ID(R2126882616) ENABLED START*/
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

function initUIStructCpDettaglioCertificatore(){
	var contentPanelName = "cpDettaglioCertificatore";
	var structure =
      {
        name: "p_pDettaglioCertificatore", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpDettCert", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_wpStatoCertificatore", panels: []
            }
            ]
          }
,          {
            name: "p_wpInfDett", panels: []
          }
,          {
            name: "p_tspDettCert", panels: [
            {
              name: "p_fpDatiGenerali", panels: [
              {
                name: "p_wpDatiPersonali", panels: []
              }
,              {
                name: "p_wpAzienda", panels: []
              }
,              {
                name: "p_wpContatti", panels: []
              }
,              {
                name: "p_pDatiRegistrazioneNav", panels: []
              }
              ]
            }
,            {
              name: "p_fpTitoloStudio", panels: [
              {
                name: "p_wpTitoloStudio", panels: []
              }
,              {
                name: "p_wpTitoloStudioAll", panels: []
              }
,              {
                name: "p_wpCurriculum", panels: []
              }
,              {
                name: "p_wpAttPartNew", panels: []
              }
,              {
                name: "p_wpAttPartOld", panels: []
              }
,              {
                name: "p_pDatiRegistrazioneNav2", panels: []
              }
              ]
            }
,            {
              name: "p_fpApe", panels: [
              {
                name: "p_wpRicercaApe", panels: []
              }
,              {
                name: "p_mpRisApeCert", panels: [
                {
                  name: "p_fpRisApeCert", panels: [
                  {
                    name: "p_wpRisApeCert", panels: []
                  }
,                  {
                    name: "p_cpRisApeCert", panels: []
                  }
                  ]
                }
                ]
              }
,              {
                name: "p_pDatiRegistrazioneNav3", panels: []
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

	initStdEnrichments4CpDettaglioCertificatore();
	initCustomEnrichments4CpDettaglioCertificatore();
	initUIStructCpDettaglioCertificatore();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpDettaglioCertificatore");

});



