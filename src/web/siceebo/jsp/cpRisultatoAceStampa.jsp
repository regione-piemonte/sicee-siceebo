<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/stampaace/CpRisultatoAceStampaAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/stampaAce -->
<!-- pageId:cpRisultatoAceStampa -->

<s:form id="cpRisultatoAceStampa" action="cpRisultatoAceStampa" namespace="/base/stampaAce" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisultatoAceStampa_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRisultatoAceStampa','menu')" >

	


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
				<h3><s:text name="cpRisultatoAceStampa.pRisultatoAceStampa.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpRisultatoAceStampa" class="formPanelBlock"><!-- startFragment:p_fpRisultatoAceStampa -->
		
	
<div class="formPanel" id="fpRisultatoAceStampa">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpRisultatoAce" class="widgetsPanelBlock"><!-- startFragment:p_wpRisultatoAce -->
	
	

<div class="widgetsPanel" id="wpRisultatoAce">
	

	
	
<s:if test="isWidgetVisible('cpRisultatoAceStampa','tblRisultatoAce')" >

	
<div class="tableWidget">


<!-- widget tblRisultatoAce -->
<s:set name="cpRisultatoAceStampa_tblRisultatoAce_clearStatus" value="isTableClearStatus('cpRisultatoAceStampa_tblRisultatoAce')" />
<s:url id="cpRisultatoAceStampaViewUrl"						   
					   action="cpRisultatoAceStampa"
					   namespace="/base/stampaAce"/>
<display:table name="appDataaceList"  				
			   excludedParams="*"			   export="false"
               id="widg_tblRisultatoAce"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisultatoAceStampaViewUrl}"  
               clearStatus="${cpRisultatoAceStampa_tblRisultatoAce_clearStatus}"
               uid="row_tblRisultatoAce"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.stampaace.CpRisultatoAceStampaTblRisultatoAceCustomDecorator"               class="dataTable">
	
		<display:column property="codice" titleKey="cpRisultatoAceStampa.tblRisultatoAce.codice.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="nomeCognomeCert" titleKey="cpRisultatoAceStampa.tblRisultatoAce.nomeCognomeCert.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descIndirizzoCompleto" titleKey="cpRisultatoAceStampa.tblRisultatoAce.descIndirizzoCompleto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dtUpload" titleKey="cpRisultatoAceStampa.tblRisultatoAce.dtUpload.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="descStato" titleKey="cpRisultatoAceStampa.tblRisultatoAce.descStato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgModulo" titleKey="cpRisultatoAceStampa.tblRisultatoAce.flgModulo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisultatoAce --></div>

			
	
	<div id="p_pSpampaNav" class="commandPanelBlock"><!-- startFragment:p_pSpampaNav -->
	
	
<div class="commandPanel navigation" id="pSpampaNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoAceStampa','bNuovaRicerca')" >

	



<!-- widget bNuovaRicerca -->
<s:submit name="widg_bNuovaRicerca" id="widg_bNuovaRicerca" method="handleBNuovaRicerca_CLICKED"
	key="cpRisultatoAceStampa.bNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAceStampa','bNuovaRicerca')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pSpampaNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRisultatoAceStampa --></div>

	

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
