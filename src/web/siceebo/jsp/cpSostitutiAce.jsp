<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/ricercaace/CpSostitutiAceAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricercaAce -->
<!-- pageId:cpSostitutiAce -->

<s:form id="cpSostitutiAce" action="cpSostitutiAce" namespace="/base/ricercaAce" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpSostitutiAce_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpSostitutiAce','menu')" >

	


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
				<h3><s:text name="cpSostitutiAce.pSostitutiAce.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpSostitutiAce" class="formPanelBlock"><!-- startFragment:p_fpSostitutiAce -->
		
	
<div class="formPanel" id="fpSostitutiAce">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="false" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpAceSostituito" class="widgetsPanelBlock"><!-- startFragment:p_wpAceSostituito -->
	
	

<div class="widgetsPanel" id="wpAceSostituito">
	
	<customtag:widgetsPanel id="wpAceSostituitoTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpSostitutiAce','ptNCertificato')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpSostitutiAce.ptNCertificato.label')}" labelFor="widg_ptNCertificato" errorFor="appDatacodAceSelezionato" labelId="ptNCertificatoLbl"   >


<!-- widget ptNCertificato -->
<s:property value="appDatacodAceSelezionato" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAceSostituito --></div>

			
	
	<div id="p_wpRisultatoAce" class="widgetsPanelBlock"><!-- startFragment:p_wpRisultatoAce -->
	
	

<div class="widgetsPanel" id="wpRisultatoAce">
	

	
	
<s:if test="isWidgetVisible('cpSostitutiAce','tblElencoSostituzioniAce')" >

	
<div class="tableWidget">


<!-- widget tblElencoSostituzioniAce -->
<s:set name="cpSostitutiAce_tblElencoSostituzioniAce_clearStatus" value="isTableClearStatus('cpSostitutiAce_tblElencoSostituzioniAce')" />
<s:url id="cpSostitutiAceViewUrl"						   
					   action="cpSostitutiAce"
					   namespace="/base/ricercaAce"/>
<display:table name="appDataaceSostituzioneList"  				
			   excludedParams="*"			   export="false"
               id="widg_tblElencoSostituzioniAce"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpSostitutiAceViewUrl}"  
               clearStatus="${cpSostitutiAce_tblElencoSostituzioniAce_clearStatus}"
               uid="row_tblElencoSostituzioniAce"
               summary="" 
               class="dataTable">
	
		<display:column property="codice" titleKey="cpSostitutiAce.tblElencoSostituzioniAce.codice.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descStato" titleKey="cpSostitutiAce.tblElencoSostituzioniAce.descStato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dtSostituzione" titleKey="cpSostitutiAce.tblElencoSostituzioniAce.dtSostituzione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="motivoSostituzione" titleKey="cpSostitutiAce.tblElencoSostituzioniAce.motivoSostituzione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisultatoAce --></div>

			
	
	<div id="p_pPagamentoNav" class="commandPanelBlock"><!-- startFragment:p_pPagamentoNav -->
	
	
<div class="commandPanel navigation" id="pPagamentoNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpSostitutiAce','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpSostitutiAce.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpSostitutiAce','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpSostitutiAce --></div>

	

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
