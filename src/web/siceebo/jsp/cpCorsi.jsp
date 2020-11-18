<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/entiformativi/CpCorsiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/entiFormativi -->
<!-- pageId:cpCorsi -->

<s:form id="cpCorsi" action="cpCorsi" namespace="/base/entiFormativi" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpCorsi_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpCorsi','menu')" >

	


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
				<h3><s:text name="cpCorsi.pCorsi.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpCorsi" class="formPanelBlock"><!-- startFragment:p_fpCorsi -->
		
	
<div class="formPanel" id="fpCorsi">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpSelezioneSO" class="widgetsPanelBlock"><!-- startFragment:p_wpSelezioneSO -->
	
	

<div class="widgetsPanel" id="wpSelezioneSO">
	
	<customtag:widgetsPanel id="wpSelezioneSOTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCorsi','cbSelezioneSO')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpCorsi.cbSelezioneSO.label')}" labelFor="widg_cbSelezioneSO" errorFor="appDataidSedeOperativaSelezionata" labelId="cbSelezioneSOLbl"
	position="first"  >


<!-- widget cbSelezioneSO -->

<s:url id="widg_cbSelezioneSOurlComboBoxValueChange"
   action="/siceebo/cpCorsi!handleCbSelezioneSO_VALUE_CHANGED" namespace="/base/entiFormativi"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidSedeOperativaSelezionata" id="widg_cbSelezioneSO"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSediOperative"
	  disabled="isWidgetDisabled('cpCorsi','cbSelezioneSO')"
	  listKey="id"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbSelezioneSO','conferma','%{widg_cbSelezioneSOurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbSelezioneSO','conferma','%{widg_cbSelezioneSOurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpSelezioneSO --></div>

			
	
	<div id="p_wpCorsi" class="widgetsPanelBlock"><!-- startFragment:p_wpCorsi -->
	
	
<h4 class="wpLabel">Corsi di Formazione e Aggiornamento </h4>
<div class="widgetsPanel" id="wpCorsi">
	

	
	
<s:if test="isWidgetVisible('cpCorsi','tblElencoCorsi')" >

	
<div class="tableWidget">


<!-- widget tblElencoCorsi -->
<s:set name="cpCorsi_tblElencoCorsi_clearStatus" value="isTableClearStatus('cpCorsi_tblElencoCorsi')" />
<s:url id="cpCorsiViewUrl"						   
					   action="cpCorsi"
					   namespace="/base/entiFormativi"/>
<display:table name="appDatacorsi"  				
			   excludedParams="*"			   export="true"
               id="widg_tblElencoCorsi"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpCorsiViewUrl}"  
               clearStatus="${cpCorsi_tblElencoCorsi_clearStatus}"
               uid="row_tblElencoCorsi"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.entiformativi.CpCorsiTblElencoCorsiCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblElencoCorsi.idCorso}" name="appDataidCorsoSelezionato" id="%{'tblElencoCorsi-editcell-'+ (#attr.row_tblElencoCorsi_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="tipoCorsoDescr" titleKey="cpCorsi.tblElencoCorsi.tipoCorsoDescr.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="tipoCorsoDescr" titleKey="cpCorsi.tblElencoCorsi.tipoCorsoDescr.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="tipoCorsoDescr" titleKey="cpCorsi.tblElencoCorsi.tipoCorsoDescr.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="titolo" titleKey="cpCorsi.tblElencoCorsi.titolo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="titolo" titleKey="cpCorsi.tblElencoCorsi.titolo.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="titolo" titleKey="cpCorsi.tblElencoCorsi.titolo.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="totaleOre" titleKey="cpCorsi.tblElencoCorsi.totaleOre.label" 
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}"  class="numbers"  media="html"
			
 >
			
		</display:column>

		<display:column property="totaleOre" titleKey="cpCorsi.tblElencoCorsi.totaleOre.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="totaleOre" titleKey="cpCorsi.tblElencoCorsi.totaleOre.export.label"
			sortable="false" headerClass="nosort"
			format="{0,number,#,##0}" 
			media="pdf" />	
		<display:column property="concatDataDalAl" titleKey="cpCorsi.tblElencoCorsi.concatDataDalAl.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="concatDataDalAl" titleKey="cpCorsi.tblElencoCorsi.concatDataDalAl.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="concatDataDalAl" titleKey="cpCorsi.tblElencoCorsi.concatDataDalAl.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="concatAnnoFormNumCorso" titleKey="cpCorsi.tblElencoCorsi.concatAnnoFormNumCorso.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="concatAnnoFormNumCorso" titleKey="cpCorsi.tblElencoCorsi.concatAnnoFormNumCorso.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="concatAnnoFormNumCorso" titleKey="cpCorsi.tblElencoCorsi.concatAnnoFormNumCorso.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="protApprov" titleKey="cpCorsi.tblElencoCorsi.protApprov.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="protApprov" titleKey="cpCorsi.tblElencoCorsi.protApprov.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="protApprov" titleKey="cpCorsi.tblElencoCorsi.protApprov.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpCorsi --></div>

			
	
	<div id="p_wpButtons" class="widgetsPanelBlock"><!-- startFragment:p_wpButtons -->
	
	

<div class="widgetsPanel" id="wpButtons">
	
	<customtag:widgetsPanel id="wpButtonsTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpCorsi','btnEliminaCorso')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnEliminaCorso -->
<s:submit name="widg_btnEliminaCorso" id="widg_btnEliminaCorso" method="handleBtnEliminaCorso_CLICKED"
	key="cpCorsi.btnEliminaCorso.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCorsi','btnEliminaCorso')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpCorsi','btnDettaglioCorso')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnDettaglioCorso -->
<s:submit name="widg_btnDettaglioCorso" id="widg_btnDettaglioCorso" method="handleBtnDettaglioCorso_CLICKED"
	key="cpCorsi.btnDettaglioCorso.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCorsi','btnDettaglioCorso')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  />
</s:else>


	
<s:if test="isWidgetVisible('cpCorsi','btnPartecipanti')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnPartecipanti -->
<s:submit name="widg_btnPartecipanti" id="widg_btnPartecipanti" method="handleBtnPartecipanti_CLICKED"
	key="cpCorsi.btnPartecipanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCorsi','btnPartecipanti')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpButtons --></div>

			
	
	<div id="p_pCorsiNav" class="commandPanelBlock"><!-- startFragment:p_pCorsiNav -->
	
	
<div class="commandPanel navigation" id="pCorsiNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCorsi','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpCorsi.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCorsi','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCorsi','bInserisciNuovo')" >

	



<!-- widget bInserisciNuovo -->
<s:submit name="widg_bInserisciNuovo" id="widg_bInserisciNuovo" method="handleBInserisciNuovo_CLICKED"
	key="cpCorsi.bInserisciNuovo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCorsi','bInserisciNuovo')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCorsiNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpCorsi --></div>

	

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
