<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/stampaAce -->
<!-- pageId:cpStampaAce -->

<s:form id="cpStampaAce" action="cpStampaAce" namespace="/base/stampaAce" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpStampaAce_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpStampaAce','menu')" >

	


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
				<h3><s:text name="cpStampaAce.pStampaAce.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpStampaAce" class="formPanelBlock"><!-- startFragment:p_fpStampaAce -->
		
	
<div class="formPanel" id="fpStampaAce">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpRicercaAceCod" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAceCod -->
	
	
<h4 class="wpLabel">Ricerca per codice </h4>
<div class="widgetsPanel" id="wpRicercaAceCod">
	
	<customtag:widgetsPanel id="wpRicercaAceCodTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpStampaAce','tfAnnoCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpStampaAce.tfAnnoCertificato.label')}" labelFor="widg_tfAnnoCertificato" errorFor="appDataricercaAce.annoCertificato" labelId="tfAnnoCertificatoLbl"
	position="first"  >


<!-- widget tfAnnoCertificato -->
<s:textfield 
	
	
	name="appDataricercaAce.annoCertificato" id="widg_tfAnnoCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpStampaAce','tfAnnoCertificato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpStampaAce','tfCertificatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpStampaAce.tfCertificatore.label')}" labelFor="widg_tfCertificatore" errorFor="appDataricercaAce.certificatore" labelId="tfCertificatoreLbl"
	  >


<!-- widget tfCertificatore -->
<s:textfield 
	
	
	name="appDataricercaAce.certificatore" id="widg_tfCertificatore"
maxlength="6"	disabled="isWidgetDisabled('cpStampaAce','tfCertificatore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpStampaAce','tfProgCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpStampaAce.tfProgCertificato.label')}" labelFor="widg_tfProgCertificato" errorFor="appDataricercaAce.progCertificato" labelId="tfProgCertificatoLbl"
	position="last"  >


<!-- widget tfProgCertificato -->
<s:textfield 
	
	
	name="appDataricercaAce.progCertificato" id="widg_tfProgCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpStampaAce','tfProgCertificato')"
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
	

	
	
<s:if test="isWidgetVisible('cpStampaAce','ptNotaA')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaA -->
<s:text name="cpStampaAce.ptNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpStampaAce','ptNotaB')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget ptNotaB -->
<s:text name="cpStampaAce.ptNotaB.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_pDescCompilaz --></div>

			
	
	<div id="p_pRicercaAceInviatiByCodiceNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaAceInviatiByCodiceNav -->
	
	
<div class="commandPanel navigation" id="pRicercaAceInviatiByCodiceNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpStampaAce','bRicercaByCodiceNav')" >

	



<!-- widget bRicercaByCodiceNav -->
<s:submit name="widg_bRicercaByCodiceNav" id="widg_bRicercaByCodiceNav" method="handleBRicercaByCodiceNav_CLICKED"
	key="cpStampaAce.bRicercaByCodiceNav.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpStampaAce','bRicercaByCodiceNav')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAceInviatiByCodiceNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpStampaAce --></div>

	

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
