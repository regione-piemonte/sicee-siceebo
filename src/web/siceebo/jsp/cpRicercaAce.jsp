<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricercaAce -->
<!-- pageId:cpRicercaAce -->

<s:form id="cpRicercaAce" action="cpRicercaAce" namespace="/base/ricercaAce" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaAce_pUserInfoCustom.jsp"></s:include>

	



	

	<!-- endFragment:p_pUp --></div>

		</div>
	</div>
	<!-- ================ FINE UDLRC Layout UP PANEL ================ -->


	<!-- ================ UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->
	<div id="westCenterWrapper" class="floatWrapper">
		<!-- ***** UDLRC Layout LEFT PANEL ***** -->
		<div id="westPanel">
			<div class="wrapper">
			
	
	<div id="p_pLeft" class="formPanelBlock"><!-- startFragment:p_pLeft -->

	
	

	
	
			
	
	<div id="p_pMenu" class="menuPanelBlock"><!-- startFragment:p_pMenu -->
	
	
<div class="menuPanel vertical" id="pMenu">

	
		
			
<s:if test="isWidgetVisible('cpRicercaAce','menu')" >

	


	<s:include value="fragments/menu.jsp"></s:include>

	

</s:if>

	


		
	
	
</div>

	<!-- endFragment:p_pMenu --></div>

	

	<!-- endFragment:p_pLeft --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout LEFT PANEL ***** -->


		<!-- ***** UDLRC Layout CENTER PANEL ***** -->
		<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
			<div class="wrapper">
				<!-- titolo pannello PRIMO livello -->
				<h3><s:text name="cpRicercaAce.pRicercaAce.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpRicercaAce" class="formPanelBlock"><!-- startFragment:p_fpRicercaAce -->
		
	


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpMotivazioneCTU" class="widgetsPanelBlock"><!-- startFragment:p_wpMotivazioneCTU -->
	
	

<div class="widgetsPanel" id="wpMotivazioneCTU">
	
	<customtag:widgetsPanel id="wpMotivazioneCTUTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','tfMotivazioneCtu')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfMotivazioneCtu.label')}" labelFor="widg_tfMotivazioneCtu" errorFor="appDatamotivazioneCtu" labelId="tfMotivazioneCtuLbl"
	position="first"  >


<!-- widget tfMotivazioneCtu -->
<s:textfield 
	
	
	name="appDatamotivazioneCtu" id="widg_tfMotivazioneCtu"
maxlength="200"	disabled="isWidgetDisabled('cpRicercaAce','tfMotivazioneCtu')"
	size="100" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','wpMotivazioneCTU_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpMotivazioneCTU_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','wpMotivazioneCTU_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpMotivazioneCTU_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','ptNotaC')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget ptNotaC -->
<s:text name="cpRicercaAce.ptNotaC.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','wpMotivazioneCTU_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpMotivazioneCTU_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','wpMotivazioneCTU_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpMotivazioneCTU_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpMotivazioneCTU --></div>

			
	
	<div id="p_wpRicercaAceCod" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAceCod -->
	
	
<h4 class="wpLabel">Ricerca per codice </h4>
<div class="widgetsPanel" id="wpRicercaAceCod">
	
	<customtag:widgetsPanel id="wpRicercaAceCodTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','tfAnnoCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfAnnoCertificato.label')}" labelFor="widg_tfAnnoCertificato" errorFor="appDataricercaAce.annoCertificato" labelId="tfAnnoCertificatoLbl"
	position="first"  >


<!-- widget tfAnnoCertificato -->
<s:textfield 
	
	
	name="appDataricercaAce.annoCertificato" id="widg_tfAnnoCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfAnnoCertificato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfCertificatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfCertificatore.label')}" labelFor="widg_tfCertificatore" errorFor="appDataricercaAce.certificatore" labelId="tfCertificatoreLbl"
	  >


<!-- widget tfCertificatore -->
<s:textfield 
	
	
	name="appDataricercaAce.certificatore" id="widg_tfCertificatore"
maxlength="6"	disabled="isWidgetDisabled('cpRicercaAce','tfCertificatore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfProgCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfProgCertificato.label')}" labelFor="widg_tfProgCertificato" errorFor="appDataricercaAce.progCertificato" labelId="tfProgCertificatoLbl"
	position="last"  >


<!-- widget tfProgCertificato -->
<s:textfield 
	
	
	name="appDataricercaAce.progCertificato" id="widg_tfProgCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfProgCertificato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAceCod --></div>

			
	
	<div id="p_pDescCompilaz" class="widgetsPanelBlock"><!-- startFragment:p_pDescCompilaz -->
	
	

<div class="widgetsPanel" id="pDescCompilaz">
	
	<customtag:widgetsPanel id="pDescCompilazTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','ptNotaA')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaA -->
<s:text name="cpRicercaAce.ptNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAce','ptNotaB')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaB -->
<s:text name="cpRicercaAce.ptNotaB.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDescCompilaz --></div>

			
	
	<div id="p_pRicercaAceInviatiByCodiceNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceInviatiByCodiceNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceInviatiByCodiceNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAce','bRicercaByCodiceNav')" >

	



<!-- widget bRicercaByCodiceNav -->
<s:submit name="widg_bRicercaByCodiceNav" id="widg_bRicercaByCodiceNav" method="handleBRicercaByCodiceNav_CLICKED"
	key="cpRicercaAce.bRicercaByCodiceNav.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAce','bRicercaByCodiceNav')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAceInviatiByCodiceNav --></div>

			
	
	<div id="p_wpRicercaAceParam" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAceParam -->
	
	
<h4 class="wpLabel">Ricerca per parametri </h4>
<div class="widgetsPanel" id="wpRicercaAceParam">
	
	<customtag:widgetsPanel id="wpRicercaAceParamTbl" columns="8" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','ptNotaParametriAND')" >

	
<customtag:widgetsPanelColumn  colSpan="4" position="first" >


<!-- widget ptNotaParametriAND -->
<s:text name="cpRicercaAce.ptNotaParametriAND.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceMatrCert')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceMatrCert.label')}" labelFor="widg_tfRicAceMatrCert" errorFor="appDataricercaAce.numMatricola" labelId="tfRicAceMatrCertLbl"
	position="first" colSpan="3" >


<!-- widget tfRicAceMatrCert -->
<s:textfield 
	
	
	name="appDataricercaAce.numMatricola" id="widg_tfRicAceMatrCert"
maxlength="6"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceMatrCert')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','cbProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbProvincia.label')}" labelFor="widg_cbProvincia" errorFor="appDataricercaAce.codProvincia" labelId="cbProvinciaLbl"
	position="first" colSpan="3" >


<!-- widget cbProvincia -->

<s:url id="widg_cbProvinciaurlComboBoxValueChange"
   action="/siceebo/cpRicercaAce!handleCbProvincia_VALUE_CHANGED" namespace="/base/ricercaAce"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaAce.codProvincia" id="widg_cbProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovince"
	  disabled="isWidgetDisabled('cpRicercaAce','cbProvincia')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','cbComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbComune.label')}" labelFor="widg_cbComune" errorFor="appDataricercaAce.codComune" labelId="cbComuneLbl"
	position="first" colSpan="3" >


<!-- widget cbComune -->
<s:select name="appDataricercaAce.codComune" id="widg_cbComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatacomuni"
	  disabled="isWidgetDisabled('cpRicercaAce','cbComune')"
	  listKey="cod"
	  listValue="nome"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfComRicAce')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="4" >


<!-- widget tfComRicAce -->
<s:textfield 
	
	
	name="appDataricercaAce.descComune" id="widg_tfComRicAce"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaAce','tfComRicAce')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceIndirizzo.label')}" labelFor="widg_tfRicAceIndirizzo" errorFor="appDataricercaAce.descIndirizzo" labelId="tfRicAceIndirizzoLbl"
	position="first" colSpan="3" >


<!-- widget tfRicAceIndirizzo -->
<s:textfield 
	
	
	name="appDataricercaAce.descIndirizzo" id="widg_tfRicAceIndirizzo"
maxlength="160"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceIndirizzo')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceNCiv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceNCiv.label')}" labelFor="widg_tfRicAceNCiv" errorFor="appDataricercaAce.numCivico" labelId="tfRicAceNCivLbl"
	  >


<!-- widget tfRicAceNCiv -->
<s:textfield 
	
	
	name="appDataricercaAce.numCivico" id="widg_tfRicAceNCiv"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceNCiv')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceSezCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceSezCatasto.label')}" labelFor="widg_tfRicAceSezCatasto" errorFor="appDataricercaAce.sezione" labelId="tfRicAceSezCatastoLbl"
	position="first"  >


<!-- widget tfRicAceSezCatasto -->
<s:textfield 
	
	
	name="appDataricercaAce.sezione" id="widg_tfRicAceSezCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceSezCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceFoglioCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceFoglioCatasto.label')}" labelFor="widg_tfRicAceFoglioCatasto" errorFor="appDataricercaAce.foglio" labelId="tfRicAceFoglioCatastoLbl"
	  >


<!-- widget tfRicAceFoglioCatasto -->
<s:textfield 
	
	
	name="appDataricercaAce.foglio" id="widg_tfRicAceFoglioCatasto"
maxlength="5"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceFoglioCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceParticCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceParticCatasto.label')}" labelFor="widg_tfRicAceParticCatasto" errorFor="appDataricercaAce.particella" labelId="tfRicAceParticCatastoLbl"
	  >


<!-- widget tfRicAceParticCatasto -->
<s:textfield 
	
	
	name="appDataricercaAce.particella" id="widg_tfRicAceParticCatasto"
maxlength="9"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceParticCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceSubaltCatasto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceSubaltCatasto.label')}" labelFor="widg_tfRicAceSubaltCatasto" errorFor="appDataricercaAce.subalterno" labelId="tfRicAceSubaltCatastoLbl"
	position="last"  >


<!-- widget tfRicAceSubaltCatasto -->
<s:textfield 
	
	
	name="appDataricercaAce.subalterno" id="widg_tfRicAceSubaltCatasto"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceSubaltCatasto')"
	size="9" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceAnnoCostrDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceAnnoCostrDal.label')}" labelFor="widg_tfRicAceAnnoCostrDal" errorFor="appDataricercaAce.annoCostruzioneDal" labelId="tfRicAceAnnoCostrDalLbl"
	position="first"  >


<!-- widget tfRicAceAnnoCostrDal -->
<s:textfield 
	
	
	name="appDataricercaAce.annoCostruzioneDal" id="widg_tfRicAceAnnoCostrDal"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceAnnoCostrDal')"
	size="6" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceAnnoCostrAl')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceAnnoCostrAl.label')}" labelFor="widg_tfRicAceAnnoCostrAl" errorFor="appDataricercaAce.annoCostruzioneAl" labelId="tfRicAceAnnoCostrAlLbl"
	  >


<!-- widget tfRicAceAnnoCostrAl -->
<s:textfield 
	
	
	name="appDataricercaAce.annoCostruzioneAl" id="widg_tfRicAceAnnoCostrAl"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceAnnoCostrAl')"
	size="6" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceAnnoRistrutDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceAnnoRistrutDal.label')}" labelFor="widg_tfRicAceAnnoRistrutDal" errorFor="appDataricercaAce.annoRistrutDal" labelId="tfRicAceAnnoRistrutDalLbl"
	position="first"  >


<!-- widget tfRicAceAnnoRistrutDal -->
<s:textfield 
	
	
	name="appDataricercaAce.annoRistrutDal" id="widg_tfRicAceAnnoRistrutDal"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceAnnoRistrutDal')"
	size="6" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceAnnoRistrutAl')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceAnnoRistrutAl.label')}" labelFor="widg_tfRicAceAnnoRistrutAl" errorFor="appDataricercaAce.annoRistrutAl" labelId="tfRicAceAnnoRistrutAlLbl"
	  >


<!-- widget tfRicAceAnnoRistrutAl -->
<s:textfield 
	
	
	name="appDataricercaAce.annoRistrutAl" id="widg_tfRicAceAnnoRistrutAl"
maxlength="4"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceAnnoRistrutAl')"
	size="6" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','calRicAceInvDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.calRicAceInvDal.label')}" labelFor="widg_calRicAceInvDal" errorFor="appDataricercaAce.inviatiDal" labelId="calRicAceInvDalLbl"
	position="first"  >


<!-- widget calRicAceInvDal -->
<s:textfield 
	
	
	name="appDataricercaAce.inviatiDal" id="widg_calRicAceInvDal"
	disabled="isWidgetDisabled('cpRicercaAce','calRicAceInvDal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','calRicAceInvAl')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.calRicAceInvAl.label')}" labelFor="widg_calRicAceInvAl" errorFor="appDataricercaAce.inviatiAl" labelId="calRicAceInvAlLbl"
	  >


<!-- widget calRicAceInvAl -->
<s:textfield 
	
	
	name="appDataricercaAce.inviatiAl" id="widg_calRicAceInvAl"
	disabled="isWidgetDisabled('cpRicercaAce','calRicAceInvAl')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','rbIsOld')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.rbIsOld.label')}" labelFor="widg_rbIsOld" errorFor="appDataricercaAce.flgIsOld" labelId="rbIsOldLbl"
	position="first" colSpan="3" >


<!-- widget rbIsOld -->

	
<div id="appDataricercaAce.flgIsOld" class="radiobuttons ">







<s:url id="widg_rbIsOldurlRadioButtonValueChange"
   action="/siceebo/cpRicercaAce!handleRbIsOld_VALUE_CHANGED" namespace="/base/ricercaAce"  
   includeParams="all" portletUrlType="action" 
/>

<s:radio
	
	
	id="widg_rbApeOld" name="appDataricercaAce.flgIsOld"
	list="#{'true':'APE (vecchi ACE)'}"
	disabled="isWidgetDisabled('cpRicercaAce','rbIsOld')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbIsOldurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbApeOldtrue"><s:text name="cpRicercaAce.rbIsOld.rbApeOld.label" /></label>








<s:radio
	
	
	id="widg_rbApeNew" name="appDataricercaAce.flgIsOld"
	list="#{'false':'APE (post 1 ottobre 2015)'}"
	disabled="isWidgetDisabled('cpRicercaAce','rbIsOld')"
	cssClass="radio"
	onclick="onRBClick('%{widg_rbIsOldurlRadioButtonValueChange}')" 
	/> <label  for="widg_rbApeNewfalse"><s:text name="cpRicercaAce.rbIsOld.rbApeNew.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAceParam --></div>

			
	
	<div id="p_wpRicercaAceParam2" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAceParam2 -->
	
	

<div class="widgetsPanel" id="wpRicercaAceParam2">
	
	<customtag:widgetsPanel id="wpRicercaAceParam2Tbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','cbRicAceClasse')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbRicAceClasse.label')}" labelFor="widg_cbRicAceClasse" errorFor="appDataricercaAce.classiEnergeticheSelez" labelId="cbRicAceClasseLbl"
	position="first" colSpan="3" >


<!-- widget cbRicAceClasse -->
<s:select name="appDataricercaAce.classiEnergeticheSelez" id="widg_cbRicAceClasse"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataclasseEnergetica"
	  disabled="isWidgetDisabled('cpRicercaAce','cbRicAceClasse')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="10"
	  listKey="value"
	  listValue="label"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAce','cbRicAceDestUso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbRicAceDestUso.label')}" labelFor="widg_cbRicAceDestUso" errorFor="appDataricercaAce.destinazioniUsoSelez" labelId="cbRicAceDestUsoLbl"
	position="first" colSpan="3" >


<!-- widget cbRicAceDestUso -->
<s:select name="appDataricercaAce.destinazioniUsoSelez" id="widg_cbRicAceDestUso"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatadestinazioneUso"
	  disabled="isWidgetDisabled('cpRicercaAce','cbRicAceDestUso')"
	  multiple="true"
	  cssClass="selectMultiple"          
	  size="9"
	  listKey="value"
	  listValue="label"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAce','cbRicAceMotRilascio')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbRicAceMotRilascio.label')}" labelFor="widg_cbRicAceMotRilascio" errorFor="appDataricercaAce.codMotivoRilascio" labelId="cbRicAceMotRilascioLbl"
	position="first" colSpan="3" >


<!-- widget cbRicAceMotRilascio -->
<s:select name="appDataricercaAce.codMotivoRilascio" id="widg_cbRicAceMotRilascio"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatamotivazioneRilascio"
	  disabled="isWidgetDisabled('cpRicercaAce','cbRicAceMotRilascio')"
	  listKey="value"
	  listValue="label"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAce','rbStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.rbStato.label')}" labelFor="widg_rbStato" errorFor="appDataricercaAce.stato" labelId="rbStatoLbl"
	position="first" colSpan="3" >


<!-- widget rbStato -->

	
<div id="appDataricercaAce.stato" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbInviato" name="appDataricercaAce.stato"
	list="#{'3':'inviato'}"
	disabled="isWidgetDisabled('cpRicercaAce','rbStato')"
	cssClass="radio"
	
	/> <label  for="widg_rbInviato3"><s:text name="cpRicercaAce.rbStato.rbInviato.label" /></label>








<s:radio
	
	
	id="widg_rbAnnullato" name="appDataricercaAce.stato"
	list="#{'4':'annullato'}"
	disabled="isWidgetDisabled('cpRicercaAce','rbStato')"
	cssClass="radio"
	
	/> <label  for="widg_rbAnnullato4"><s:text name="cpRicercaAce.rbStato.rbAnnullato.label" /></label>








<s:radio
	
	
	id="widg_rbEntrambi" name="appDataricercaAce.stato"
	list="#{'99':'entrambi'}"
	disabled="isWidgetDisabled('cpRicercaAce','rbStato')"
	cssClass="radio"
	
	/> <label  for="widg_rbEntrambi99"><s:text name="cpRicercaAce.rbStato.rbEntrambi.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAceParam2 --></div>

			
	
	
	<div id="p_mpOldApe" class="panelBlock"><!-- startFragment:p_mpOldApe -->
		

		
<s:if test="#session.cpRicercaAce_mpOldApe_selectedMultiPanel == 'cpRicercaAce_mpOldApe_fpOldApe'">
	<s:include value="/jsp/multipanels/cpRicercaAce_mpOldApe_fpOldApe.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpOldApe --></div>

			
	
	
	<div id="p_mpNewApe" class="panelBlock"><!-- startFragment:p_mpNewApe -->
		

		
<s:if test="#session.cpRicercaAce_mpNewApe_selectedMultiPanel == 'cpRicercaAce_mpNewApe_fpNewApe'">
	<s:include value="/jsp/multipanels/cpRicercaAce_mpNewApe_fpNewApe.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpNewApe --></div>

			
	
	<div id="p_pRicercaAceNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaAce','bRicerca')" >

	



<!-- widget bRicerca -->
<s:submit name="widg_bRicerca" id="widg_bRicerca" method="handleBRicerca_CLICKED"
	key="cpRicercaAce.bRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaAce','bRicerca')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAceNav --></div>

	

		
	

	<!-- endFragment:p_fpRicercaAce --></div>

	

	<!-- endFragment:p_pCenter --></div>

			</div>
		</div>
		<!-- ***** FINE UDLRC Layout CENTER PANEL ***** -->



	</div>
	<!-- ================ FINE UDLRC Layout WEST-CENTER-EAST WRAPPER ================ -->



</div>
<!-- #################### FINE PANNELLO CONTENUTI #################### -->




</s:form>


	<s:include value="fragments/footer.jsp" ></s:include>
