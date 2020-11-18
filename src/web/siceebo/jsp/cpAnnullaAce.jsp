<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricercaAce -->
<!-- pageId:cpAnnullaAce -->

<s:form id="cpAnnullaAce" action="cpAnnullaAce" namespace="/base/ricercaAce" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpAnnullaAce_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpAnnullaAce','menu')" >

	


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
				<h3><s:text name="cpAnnullaAce.pAnnullaAce.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpAnnullaAce" class="formPanelBlock"><!-- startFragment:p_fpAnnullaAce -->
		
	
<div class="formPanel" id="fpAnnullaAce">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpAnnullaAce" class="widgetsPanelBlock"><!-- startFragment:p_wpAnnullaAce -->
	
	

<div class="widgetsPanel" id="wpAnnullaAce">
	
	<customtag:widgetsPanel id="wpAnnullaAceTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpAnnullaAce','tfDataAnnullamento')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAnnullaAce.tfDataAnnullamento.label')}" labelFor="widg_tfDataAnnullamento" errorFor="appDataannullamentoApe.data" labelId="tfDataAnnullamentoLbl"
	  >


<!-- widget tfDataAnnullamento -->
<s:textfield 
	
	
	name="appDataannullamentoApe.data" id="widg_tfDataAnnullamento"
maxlength="10"	disabled="isWidgetDisabled('cpAnnullaAce','tfDataAnnullamento')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpAnnullaAce','taMotivazione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpAnnullaAce.taMotivazione.label')}" labelFor="widg_taMotivazione" errorFor="appDataannullamentoApe.motivazione" labelId="taMotivazioneLbl"
	  fieldRequired="true">


<!-- widget taMotivazione -->
<s:textarea 
	
	
	name="appDataannullamentoApe.motivazione" id="widg_taMotivazione"
	disabled="isWidgetDisabled('cpAnnullaAce','taMotivazione')"
	rows="10"
	cols="60"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAnnullaAce --></div>

			
	
	<div id="p_pAnnullaFun" class="commandPanelBlock"><!-- startFragment:p_pAnnullaFun -->
	
	
<div class="commandPanel functional" id="pAnnullaFun">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpAnnullaAce','btnAvanti')" >

	



<!-- widget btnAvanti -->
<s:submit name="widg_btnAvanti" id="widg_btnAvanti" method="handleBtnAvanti_CLICKED"
	key="cpAnnullaAce.btnAvanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAnnullaAce','btnAvanti')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pAnnullaFun --></div>

			
	
	<div id="p_pAnnullaNav" class="commandPanelBlock"><!-- startFragment:p_pAnnullaNav -->
	
	
<div class="commandPanel navigation" id="pAnnullaNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpAnnullaAce','btnSostituzioni')" >

	



<!-- widget btnSostituzioni -->
<s:submit name="widg_btnSostituzioni" id="widg_btnSostituzioni" method="handleBtnSostituzioni_CLICKED"
	key="cpAnnullaAce.btnSostituzioni.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpAnnullaAce','btnSostituzioni')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pAnnullaNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpAnnullaAce --></div>

	

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
