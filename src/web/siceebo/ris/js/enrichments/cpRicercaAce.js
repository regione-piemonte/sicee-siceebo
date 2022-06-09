

/**
 * Arricchimenti standard per il ContentPanel [cpRicercaAce] da registrare nella
 * variabile globale uiEnricherMgr
 */
function initStdEnrichments4CpRicercaAce() {
	var contentPanelName = "cpRicercaAce";
	/// arricchimento di base per guigen::TextField [tfMotivazioneCtu]
	var addBasicEnrichmentToTfMotivazioneCtu =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfMotivazioneCtu',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpMotivazioneCTU", addBasicEnrichmentToTfMotivazioneCtu);
	/// arricchimento di base per guigen::TextField [tfAnnoCertificato]
	var addBasicEnrichmentToTfAnnoCertificato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAnnoCertificato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceCod", addBasicEnrichmentToTfAnnoCertificato);
	/// arricchimento di base per guigen::TextField [tfCertificatore]
	var addBasicEnrichmentToTfCertificatore =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfCertificatore',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceCod", addBasicEnrichmentToTfCertificatore);
	/// arricchimento di base per guigen::TextField [tfProgCertificato]
	var addBasicEnrichmentToTfProgCertificato =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfProgCertificato',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceCod", addBasicEnrichmentToTfProgCertificato);

	/// arricchimento di base per guigen::TextField [tfRicAceMatrCert]
	var addBasicEnrichmentToTfRicAceMatrCert =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceMatrCert',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceMatrCert);


	/// arricchimento di base per guigen::TextField [tfComRicAce]
	var addBasicEnrichmentToTfComRicAce =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfComRicAce',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfComRicAce);
	/// arricchimento di base per guigen::TextField [tfRicAceIndirizzo]
	var addBasicEnrichmentToTfRicAceIndirizzo =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceIndirizzo',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceIndirizzo);
	/// arricchimento di base per guigen::TextField [tfRicAceNCiv]
	var addBasicEnrichmentToTfRicAceNCiv =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceNCiv',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceNCiv);
	/// arricchimento di base per guigen::TextField [tfRicAceSezCatasto]
	var addBasicEnrichmentToTfRicAceSezCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceSezCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceSezCatasto);
	/// arricchimento di base per guigen::TextField [tfRicAceFoglioCatasto]
	var addBasicEnrichmentToTfRicAceFoglioCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceFoglioCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceFoglioCatasto);
	/// arricchimento di base per guigen::TextField [tfRicAceParticCatasto]
	var addBasicEnrichmentToTfRicAceParticCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceParticCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceParticCatasto);
	/// arricchimento di base per guigen::TextField [tfRicAceSubaltCatasto]
	var addBasicEnrichmentToTfRicAceSubaltCatasto =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceSubaltCatasto',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceSubaltCatasto);
	/// arricchimento di base per guigen::TextField [tfRicAceAnnoCostrDal]
	var addBasicEnrichmentToTfRicAceAnnoCostrDal =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceAnnoCostrDal',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceAnnoCostrDal);
	/// arricchimento di base per guigen::TextField [tfRicAceAnnoCostrAl]
	var addBasicEnrichmentToTfRicAceAnnoCostrAl =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceAnnoCostrAl',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceAnnoCostrAl);
	/// arricchimento di base per guigen::TextField [tfRicAceAnnoRistrutDal]
	var addBasicEnrichmentToTfRicAceAnnoRistrutDal =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceAnnoRistrutDal',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceAnnoRistrutDal);
	/// arricchimento di base per guigen::TextField [tfRicAceAnnoRistrutAl]
	var addBasicEnrichmentToTfRicAceAnnoRistrutAl =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceAnnoRistrutAl',
			 	false,
			 	'java.lang.String',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addBasicEnrichmentToTfRicAceAnnoRistrutAl);
	/// arricchimento per guigen::Calendar [calRicAceInvDal]: aggiunta datepicker
	var addDateToCalRicAceInvDal = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicAceInvDal", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addDateToCalRicAceInvDal);
	/// arricchimento per guigen::Calendar [calRicAceInvAl]: aggiunta datepicker
	var addDateToCalRicAceInvAl = function(){
		uiNRichLib.addDatePickerNRich("widg_calRicAceInvAl", 
		false, false, "", false);
	};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParam", addDateToCalRicAceInvAl);



	/// arricchimento di base per guigen::TextField [tfRicAceVDa]
	var addBasicEnrichmentToTfRicAceVDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceVDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceVDa);
	/// arricchimento di base per guigen::TextField [tfRicAceVA]
	var addBasicEnrichmentToTfRicAceVA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceVA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceVA);
	/// arricchimento di base per guigen::TextField [tfRicAceSuDa]
	var addBasicEnrichmentToTfRicAceSuDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceSuDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceSuDa);
	/// arricchimento di base per guigen::TextField [tfRicAceSuA]
	var addBasicEnrichmentToTfRicAceSuA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceSuA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceSuA);
	/// arricchimento di base per guigen::TextField [tfRicAceVSuDa]
	var addBasicEnrichmentToTfRicAceVSuDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceVSuDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceVSuDa);
	/// arricchimento di base per guigen::TextField [tfRicAceVSuA]
	var addBasicEnrichmentToTfRicAceVSuA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceVSuA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceVSuA);
	/// arricchimento di base per guigen::TextField [tfRicAceFattoreFormaDa]
	var addBasicEnrichmentToTfRicAceFattoreFormaDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceFattoreFormaDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceFattoreFormaDa);
	/// arricchimento di base per guigen::TextField [tfRicAceFattoreFormaA]
	var addBasicEnrichmentToTfRicAceFattoreFormaA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceFattoreFormaA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceFattoreFormaA);
	/// arricchimento di base per guigen::TextField [tfRicAceTrasmSupOpacheDa]
	var addBasicEnrichmentToTfRicAceTrasmSupOpacheDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceTrasmSupOpacheDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceTrasmSupOpacheDa);
	/// arricchimento di base per guigen::TextField [tfRicAceTrasmSupOpacheA]
	var addBasicEnrichmentToTfRicAceTrasmSupOpacheA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceTrasmSupOpacheA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceTrasmSupOpacheA);
	/// arricchimento di base per guigen::TextField [tfRicAceTrasmSupTraspDa]
	var addBasicEnrichmentToTfRicAceTrasmSupTraspDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceTrasmSupTraspDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceTrasmSupTraspDa);
	/// arricchimento di base per guigen::TextField [tfRicAceTrasmSupTraspA]
	var addBasicEnrichmentToTfRicAceTrasmSupTraspA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceTrasmSupTraspA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceTrasmSupTraspA);
	/// arricchimento di base per guigen::TextField [tfRicAceRendMedioAcsDa]
	var addBasicEnrichmentToTfRicAceRendMedioAcsDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceRendMedioAcsDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceRendMedioAcsDa);
	/// arricchimento di base per guigen::TextField [tfRicAceRendMedioAcsA]
	var addBasicEnrichmentToTfRicAceRendMedioAcsA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceRendMedioAcsA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceRendMedioAcsA);
	/// arricchimento di base per guigen::TextField [tfRicAceRendMedioImpTermicoDa]
	var addBasicEnrichmentToTfRicAceRendMedioImpTermicoDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceRendMedioImpTermicoDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceRendMedioImpTermicoDa);
	/// arricchimento di base per guigen::TextField [tfRicAceRendMedioImpTermicoA]
	var addBasicEnrichmentToTfRicAceRendMedioImpTermicoA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceRendMedioImpTermicoA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceRendMedioImpTermicoA);
	/// arricchimento di base per guigen::TextField [tfRicAceFabAcsSuDa]
	var addBasicEnrichmentToTfRicAceFabAcsSuDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceFabAcsSuDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceFabAcsSuDa);
	/// arricchimento di base per guigen::TextField [tfRicAceFabAcsSuA]
	var addBasicEnrichmentToTfRicAceFabAcsSuA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceFabAcsSuA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceFabAcsSuA);
	/// arricchimento di base per guigen::TextField [tfRicAceIndiceEplDa]
	var addBasicEnrichmentToTfRicAceIndiceEplDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceIndiceEplDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceIndiceEplDa);
	/// arricchimento di base per guigen::TextField [tfRicAceIndiceEplA]
	var addBasicEnrichmentToTfRicAceIndiceEplA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfRicAceIndiceEplA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAceParamOR", addBasicEnrichmentToTfRicAceIndiceEplA);
	/// arricchimento di base per guigen::TextField [tfEpglNrenGlobaleDa]
	var addBasicEnrichmentToTfEpglNrenGlobaleDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEpglNrenGlobaleDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfEpglNrenGlobaleDa);
	/// arricchimento di base per guigen::TextField [tfEpglNrenGlobaleA]
	var addBasicEnrichmentToTfEpglNrenGlobaleA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEpglNrenGlobaleA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfEpglNrenGlobaleA);
	/// arricchimento di base per guigen::TextField [tfEpglRenGlobaleDa]
	var addBasicEnrichmentToTfEpglRenGlobaleDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEpglRenGlobaleDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfEpglRenGlobaleDa);
	/// arricchimento di base per guigen::TextField [tfEpglRenGlobaleA]
	var addBasicEnrichmentToTfEpglRenGlobaleA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEpglRenGlobaleA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfEpglRenGlobaleA);
	/// arricchimento di base per guigen::TextField [tfEmissioniCo2Da]
	var addBasicEnrichmentToTfEmissioniCo2Da =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmissioniCo2Da',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfEmissioniCo2Da);
	/// arricchimento di base per guigen::TextField [tfEmissioniCo2A]
	var addBasicEnrichmentToTfEmissioniCo2A =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEmissioniCo2A',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfEmissioniCo2A);
	/// arricchimento di base per guigen::TextField [tfSupRaffrescataDa]
	var addBasicEnrichmentToTfSupRaffrescataDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSupRaffrescataDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfSupRaffrescataDa);
	/// arricchimento di base per guigen::TextField [tfSupRaffrescataA]
	var addBasicEnrichmentToTfSupRaffrescataA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSupRaffrescataA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfSupRaffrescataA);
	/// arricchimento di base per guigen::TextField [tfSupRiscaldataDa]
	var addBasicEnrichmentToTfSupRiscaldataDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSupRiscaldataDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfSupRiscaldataDa);
	/// arricchimento di base per guigen::TextField [tfSupRiscaldataA]
	var addBasicEnrichmentToTfSupRiscaldataA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSupRiscaldataA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfSupRiscaldataA);
	/// arricchimento di base per guigen::TextField [tfVolLordoRaffrescatoDa]
	var addBasicEnrichmentToTfVolLordoRaffrescatoDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolLordoRaffrescatoDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfVolLordoRaffrescatoDa);
	/// arricchimento di base per guigen::TextField [tfVolLordoRaffrescatoA]
	var addBasicEnrichmentToTfVolLordoRaffrescatoA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolLordoRaffrescatoA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfVolLordoRaffrescatoA);
	/// arricchimento di base per guigen::TextField [tfVolLordoRiscaldatoDa]
	var addBasicEnrichmentToTfVolLordoRiscaldatoDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolLordoRiscaldatoDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfVolLordoRiscaldatoDa);
	/// arricchimento di base per guigen::TextField [tfVolLordoRiscaldatoA]
	var addBasicEnrichmentToTfVolLordoRiscaldatoA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVolLordoRiscaldatoA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfVolLordoRiscaldatoA);
	/// arricchimento di base per guigen::TextField [tfEphDa]
	var addBasicEnrichmentToTfEphDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEphDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfEphDa);
	/// arricchimento di base per guigen::TextField [tfEphA]
	var addBasicEnrichmentToTfEphA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfEphA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfEphA);
	/// arricchimento di base per guigen::TextField [tfAsolAsupDa]
	var addBasicEnrichmentToTfAsolAsupDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAsolAsupDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfAsolAsupDa);
	/// arricchimento di base per guigen::TextField [tfAsolAsupA]
	var addBasicEnrichmentToTfAsolAsupA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfAsolAsupA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfAsolAsupA);
	/// arricchimento di base per guigen::TextField [tfYieDa]
	var addBasicEnrichmentToTfYieDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfYieDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfYieDa);
	/// arricchimento di base per guigen::TextField [tfYieA]
	var addBasicEnrichmentToTfYieA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfYieA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfYieA);
	/// arricchimento di base per guigen::TextField [tfVSuRaffDa]
	var addBasicEnrichmentToTfVSuRaffDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVSuRaffDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfVSuRaffDa);
	/// arricchimento di base per guigen::TextField [tfVSuRaffA]
	var addBasicEnrichmentToTfVSuRaffA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVSuRaffA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfVSuRaffA);
	/// arricchimento di base per guigen::TextField [tfVSuRiscDa]
	var addBasicEnrichmentToTfVSuRiscDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVSuRiscDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfVSuRiscDa);
	/// arricchimento di base per guigen::TextField [tfVSuRiscA]
	var addBasicEnrichmentToTfVSuRiscA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfVSuRiscA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfVSuRiscA);
	/// arricchimento di base per guigen::TextField [tfSVRaffDa]
	var addBasicEnrichmentToTfSVRaffDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSVRaffDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfSVRaffDa);
	/// arricchimento di base per guigen::TextField [tfSVRaffA]
	var addBasicEnrichmentToTfSVRaffA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSVRaffA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfSVRaffA);
	/// arricchimento di base per guigen::TextField [tfSVRiscDa]
	var addBasicEnrichmentToTfSVRiscDa =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSVRiscDa',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfSVRiscDa);
	/// arricchimento di base per guigen::TextField [tfSVRiscA]
	var addBasicEnrichmentToTfSVRiscA =
		function(){
			uiNRichLib.basicTextFieldNRich(
				'widg_tfSVRiscA',
			 	false,
			 	'it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour',
			 	null);
		};
	uiEnricherMgr.registerEnrichment(contentPanelName, "p_wpRicercaAce05ParamOR", addBasicEnrichmentToTfSVRiscA);

}

/**
 * Arricchimenti custom
 */
function initCustomEnrichments4CpRicercaAce(){
/*PROTECTED REGION ID(R1885815131) ENABLED START*/
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

function initUIStructCpRicercaAce(){
	var contentPanelName = "cpRicercaAce";
	var structure =
      {
        name: "p_pRicercaAce", panels: [
        {
          name: "p_pCenter", panels: [
          {
            name: "p_fpRicercaAce", panels: [
            {
              name: "p_pErrori", panels: [
              ]
            }
,            {
              name: "p_udpMappa", panels: [
              ]
            }
,            {
              name: "p_wpMotivazioneCTU", panels: []
            }
,            {
              name: "p_wpRicercaAceCod", panels: []
            }
,            {
              name: "p_pDescCompilaz", panels: []
            }
,            {
              name: "p_pRicercaAceInviatiByCodiceNav", panels: []
            }
,            {
              name: "p_wpRicercaAceParam", panels: []
            }
,            {
              name: "p_wpRicercaAceParam2", panels: []
            }
,            {
              name: "p_mpOldApe", panels: [
              {
                name: "p_fpOldApe", panels: [
                {
                  name: "p_wpRicercaAceParamOR", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_mpNewApe", panels: [
              {
                name: "p_fpNewApe", panels: [
                {
                  name: "p_wpRicercaAce05ParamOR", panels: []
                }
                ]
              }
              ]
            }
,            {
              name: "p_pRicercaAceNav", panels: []
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

	initStdEnrichments4CpRicercaAce();
	initCustomEnrichments4CpRicercaAce();
	initUIStructCpRicercaAce();
	uiEnricherMgr.setReady();
	uiEnricherMgr.applyAll("cpRicercaAce");

});



