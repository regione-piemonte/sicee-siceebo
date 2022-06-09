<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/backOffice -->
<!-- pageId:cpStoricizzazioneLogAccesso -->

<s:form id="cpStoricizzazioneLogAccesso" action="cpStoricizzazioneLogAccesso" namespace="/base/backOffice" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpStoricizzazioneLogAccesso_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpStoricizzazioneLogAccesso','menu')" >

	


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
				<h3><s:text name="cpStoricizzazioneLogAccesso.pStoricizzazioneLogAccesso.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpStoricizzazioneLogAccesso" class="formPanelBlock"><!-- startFragment:p_fpStoricizzazioneLogAccesso -->
		
	
<div class="formPanel" id="fpStoricizzazioneLogAccesso">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpStoricizzazioneLogAccesso" class="widgetsPanelBlock"><!-- startFragment:p_wpStoricizzazioneLogAccesso -->
	
	

<div class="widgetsPanel" id="wpStoricizzazioneLogAccesso">
	
	<customtag:widgetsPanel id="wpStoricizzazioneLogAccessoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpStoricizzazioneLogAccesso','ptFunzLogAccessoStor')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpStoricizzazioneLogAccesso.ptFunzLogAccessoStor.label')}" labelFor="widg_ptFunzLogAccessoStor" errorFor="appDatariepilogoStoricizzazione.logAccessoStor" labelId="ptFunzLogAccessoStorLbl"   tdStyleClass="numbers">


<!-- widget ptFunzLogAccessoStor -->
<s:property value="appDatariepilogoStoricizzazione.logAccessoStor" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpStoricizzazioneLogAccesso','ptFunzLogAccessoCanc')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpStoricizzazioneLogAccesso.ptFunzLogAccessoCanc.label')}" labelFor="widg_ptFunzLogAccessoCanc" errorFor="appDatariepilogoStoricizzazione.logAccessoCanc" labelId="ptFunzLogAccessoCancLbl"   tdStyleClass="numbers">


<!-- widget ptFunzLogAccessoCanc -->
<s:property value="appDatariepilogoStoricizzazione.logAccessoCanc" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpStoricizzazioneLogAccesso --></div>

			
	
	<div id="p_cpStoricizzazioneLogAccesso" class="commandPanelBlock"><!-- startFragment:p_cpStoricizzazioneLogAccesso -->
	
	
<div class="commandPanel functional" id="cpStoricizzazioneLogAccesso">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpStoricizzazioneLogAccesso','bStoricizzaLogAccesso')" >

	



<!-- widget bStoricizzaLogAccesso -->
<s:submit name="widg_bStoricizzaLogAccesso" id="widg_bStoricizzaLogAccesso" method="handleBStoricizzaLogAccesso_CLICKED"
	key="cpStoricizzazioneLogAccesso.bStoricizzaLogAccesso.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpStoricizzazioneLogAccesso','bStoricizzaLogAccesso')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpStoricizzazioneLogAccesso --></div>

	

		
	
</div>

	<!-- endFragment:p_fpStoricizzazioneLogAccesso --></div>

	

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
