<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/ricercaace/CpRisultatoAceAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricercaAce -->
<!-- pageId:cpRisultatoAce -->

<s:form id="cpRisultatoAce" action="cpRisultatoAce" namespace="/base/ricercaAce" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisultatoAce_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRisultatoAce','menu')" >

	


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
				<h3><s:text name="cpRisultatoAce.pRisultatoAce.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpRisultatoAce" class="formPanelBlock"><!-- startFragment:p_fpRisultatoAce -->
		
	


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpRisultatoAce" class="widgetsPanelBlock"><!-- startFragment:p_wpRisultatoAce -->
	
	

<div class="widgetsPanel" id="wpRisultatoAce">
	

	
	
<s:if test="isWidgetVisible('cpRisultatoAce','tblRisultatoAce')" >

	
<div class="tableWidget">


<!-- widget tblRisultatoAce -->
<s:set name="cpRisultatoAce_tblRisultatoAce_clearStatus" value="isTableClearStatus('cpRisultatoAce_tblRisultatoAce')" />
<s:url id="cpRisultatoAceViewUrl"						   
					   action="cpRisultatoAce"
					   namespace="/base/ricercaAce"/>
<display:table name="appDataaceList"  				
			   excludedParams="*"			   export="false"
               id="widg_tblRisultatoAce"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisultatoAceViewUrl}"  
               clearStatus="${cpRisultatoAce_tblRisultatoAce_clearStatus}"
               uid="row_tblRisultatoAce"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.ricercaace.CpRisultatoAceTblRisultatoAceCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblRisultatoAce.codice}" name="appDatacodAceSelezionato" id="%{'tblRisultatoAce-editcell-'+ (#attr.row_tblRisultatoAce_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>
		<display:column property="codice" titleKey="cpRisultatoAce.tblRisultatoAce.codice.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="nomeCognomeCert" titleKey="cpRisultatoAce.tblRisultatoAce.nomeCognomeCert.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descIndirizzoCompleto" titleKey="cpRisultatoAce.tblRisultatoAce.descIndirizzoCompleto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dtUpload" titleKey="cpRisultatoAce.tblRisultatoAce.dtUpload.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="dtScadenza" titleKey="cpRisultatoAce.tblRisultatoAce.dtScadenza.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>
		<display:column property="descStato" titleKey="cpRisultatoAce.tblRisultatoAce.descStato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgModulo" titleKey="cpRisultatoAce.tblRisultatoAce.flgModulo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgRicevuta" titleKey="cpRisultatoAce.tblRisultatoAce.flgRicevuta.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgTracciato" titleKey="cpRisultatoAce.tblRisultatoAce.flgTracciato.label" 
			sortable="false" headerClass="nosort"
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
		
<s:if test="isWidgetVisible('cpRisultatoAce','bNuovaRicerca')" >

	



<!-- widget bNuovaRicerca -->
<s:submit name="widg_bNuovaRicerca" id="widg_bNuovaRicerca" method="handleBNuovaRicerca_CLICKED"
	key="cpRisultatoAce.bNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAce','bNuovaRicerca')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoAce','bAffinaRicerca')" >

	



<!-- widget bAffinaRicerca -->
<s:submit name="widg_bAffinaRicerca" id="widg_bAffinaRicerca" method="handleBAffinaRicerca_CLICKED"
	key="cpRisultatoAce.bAffinaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAce','bAffinaRicerca')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoAce','btnSostituzioni')" >

	



<!-- widget btnSostituzioni -->
<s:submit name="widg_btnSostituzioni" id="widg_btnSostituzioni" method="handleBtnSostituzioni_CLICKED"
	key="cpRisultatoAce.btnSostituzioni.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAce','btnSostituzioni')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoAce','bStampaReport')" >

	



<!-- widget bStampaReport -->
<s:submit name="widg_bStampaReport" id="widg_bStampaReport" method="handleBStampaReport_CLICKED"
	key="cpRisultatoAce.bStampaReport.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAce','bStampaReport')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoAce','btnAnnulla')" >

	



<!-- widget btnAnnulla -->
<s:submit name="widg_btnAnnulla" id="widg_btnAnnulla" method="handleBtnAnnulla_CLICKED"
	key="cpRisultatoAce.btnAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAce','btnAnnulla')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoAce','bScaricaXml')" >

	



<!-- widget bScaricaXml -->
<s:submit name="widg_bScaricaXml" id="widg_bScaricaXml" method="handleBScaricaXml_CLICKED"
	key="cpRisultatoAce.bScaricaXml.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAce','bScaricaXml')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoAce','bDocAgg')" >

	



<!-- widget bDocAgg -->
<s:submit name="widg_bDocAgg" id="widg_bDocAgg" method="handleBDocAgg_CLICKED"
	key="cpRisultatoAce.bDocAgg.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAce','bDocAgg')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoAce','scarica')" >

	



<!-- widget scarica -->
<s:submit name="widg_scarica" id="widg_scarica" method="handleScarica_CLICKED"
	key="cpRisultatoAce.scarica.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisultatoAce','scarica')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoNav --></div>

			
	
	
	<div id="p_emailMultipanel" class="panelBlock"><!-- startFragment:p_emailMultipanel -->
		

		
<s:if test="#session.cpRisultatoAce_emailMultipanel_selectedMultiPanel == 'cpRisultatoAce_emailMultipanel_emailPanel'">
	<s:include value="/jsp/multipanels/cpRisultatoAce_emailMultipanel_emailPanel.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_emailMultipanel --></div>

	

		
	

	<!-- endFragment:p_fpRisultatoAce --></div>

	

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
