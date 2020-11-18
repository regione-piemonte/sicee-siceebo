<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/entiformativi/CpPartecipantiAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/entiFormativi -->
<!-- pageId:cpPartecipanti -->

<s:form id="cpPartecipanti" action="cpPartecipanti" namespace="/base/entiFormativi" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpPartecipanti_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpPartecipanti','menu')" >

	


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
				<h3><s:text name="cpPartecipanti.pPartecipanti.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpPartecipanti" class="formPanelBlock"><!-- startFragment:p_fpPartecipanti -->
		
	
<div class="formPanel" id="fpPartecipanti">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpLabelCorso" class="widgetsPanelBlock"><!-- startFragment:p_wpLabelCorso -->
	
	

<div class="widgetsPanel" id="wpLabelCorso">
	
	<customtag:widgetsPanel id="wpLabelCorsoTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpPartecipanti','lblTitoloCorso')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPartecipanti.lblTitoloCorso.label')}" labelFor="widg_lblTitoloCorso" errorFor="appDatadettaglioCorso.titoloBold" labelId="lblTitoloCorsoLbl"  position="first" >


<!-- widget lblTitoloCorso -->
<s:property value="appDatadettaglioCorso.titoloBold" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpPartecipanti','lblSedeOperativa')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPartecipanti.lblSedeOperativa.label')}" labelFor="widg_lblSedeOperativa" errorFor="appDataenteFormativo.sedeCompleta" labelId="lblSedeOperativaLbl"   >


<!-- widget lblSedeOperativa -->
<s:property value="appDataenteFormativo.sedeCompleta" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpPartecipanti','lblNTotPartecipanti')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpPartecipanti.lblNTotPartecipanti.label')}" labelFor="widg_lblNTotPartecipanti" errorFor="appDatadettaglioCorso.partecipanti" labelId="lblNTotPartecipantiLbl"  position="last" >


<!-- widget lblNTotPartecipanti -->
<s:property value="appDatadettaglioCorso.partecipanti" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLabelCorso --></div>

			
	
	<div id="p_wpPartecipanti" class="widgetsPanelBlock"><!-- startFragment:p_wpPartecipanti -->
	
	
<h4 class="wpLabel">Partecipanti </h4>
<div class="widgetsPanel" id="wpPartecipanti">
	

	
	
<s:if test="isWidgetVisible('cpPartecipanti','tblElencoPartecipanti')" >

	
<div class="tableWidget">


<!-- widget tblElencoPartecipanti -->
<s:set name="cpPartecipanti_tblElencoPartecipanti_clearStatus" value="isTableClearStatus('cpPartecipanti_tblElencoPartecipanti')" />
<s:url id="cpPartecipantiViewUrl"						   
					   action="cpPartecipanti"
					   namespace="/base/entiFormativi"/>
<display:table name="appDatapartecipanti"  				
			   excludedParams="*"			   export="true"
               id="widg_tblElencoPartecipanti"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpPartecipantiViewUrl}"  
               clearStatus="${cpPartecipanti_tblElencoPartecipanti_clearStatus}"
               uid="row_tblElencoPartecipanti"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.entiformativi.CpPartecipantiTblElencoPartecipantiCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblElencoPartecipanti.idPartecipante}" name="appDataidPartecipanteSelezionato" id="%{'tblElencoPartecipanti-editcell-'+ (#attr.row_tblElencoPartecipanti_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="cognome" titleKey="cpPartecipanti.tblElencoPartecipanti.cognome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="cognome" titleKey="cpPartecipanti.tblElencoPartecipanti.cognome.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="cognome" titleKey="cpPartecipanti.tblElencoPartecipanti.cognome.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="nome" titleKey="cpPartecipanti.tblElencoPartecipanti.nome.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nome" titleKey="cpPartecipanti.tblElencoPartecipanti.nome.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="nome" titleKey="cpPartecipanti.tblElencoPartecipanti.nome.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="codiceFiscale" titleKey="cpPartecipanti.tblElencoPartecipanti.codiceFiscale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codiceFiscale" titleKey="cpPartecipanti.tblElencoPartecipanti.codiceFiscale.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="codiceFiscale" titleKey="cpPartecipanti.tblElencoPartecipanti.codiceFiscale.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="telefono" titleKey="cpPartecipanti.tblElencoPartecipanti.telefono.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="telefono" titleKey="cpPartecipanti.tblElencoPartecipanti.telefono.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="telefono" titleKey="cpPartecipanti.tblElencoPartecipanti.telefono.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="email" titleKey="cpPartecipanti.tblElencoPartecipanti.email.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="email" titleKey="cpPartecipanti.tblElencoPartecipanti.email.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="email" titleKey="cpPartecipanti.tblElencoPartecipanti.email.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="dataEsame" titleKey="cpPartecipanti.tblElencoPartecipanti.dataEsame.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="dataEsame" titleKey="cpPartecipanti.tblElencoPartecipanti.dataEsame.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="dataEsame" titleKey="cpPartecipanti.tblElencoPartecipanti.dataEsame.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="esitoEsameDecod" titleKey="cpPartecipanti.tblElencoPartecipanti.esitoEsameDecod.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="esitoEsameDecod" titleKey="cpPartecipanti.tblElencoPartecipanti.esitoEsameDecod.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="esitoEsameDecod" titleKey="cpPartecipanti.tblElencoPartecipanti.esitoEsameDecod.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpPartecipanti --></div>

			
	
	<div id="p_wpButtons" class="widgetsPanelBlock"><!-- startFragment:p_wpButtons -->
	
	

<div class="widgetsPanel" id="wpButtons">
	
	<customtag:widgetsPanel id="wpButtonsTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpPartecipanti','btnEliminaPartecipante')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnEliminaPartecipante -->
<s:submit name="widg_btnEliminaPartecipante" id="widg_btnEliminaPartecipante" method="handleBtnEliminaPartecipante_CLICKED"
	key="cpPartecipanti.btnEliminaPartecipante.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPartecipanti','btnEliminaPartecipante')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue=""  position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpPartecipanti','btnDettaglioPartecipante')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnDettaglioPartecipante -->
<s:submit name="widg_btnDettaglioPartecipante" id="widg_btnDettaglioPartecipante" method="handleBtnDettaglioPartecipante_CLICKED"
	key="cpPartecipanti.btnDettaglioPartecipante.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPartecipanti','btnDettaglioPartecipante')" />

	
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
		
<s:if test="isWidgetVisible('cpPartecipanti','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpPartecipanti.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPartecipanti','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpPartecipanti','bInserisciNuovoPartecipante')" >

	



<!-- widget bInserisciNuovoPartecipante -->
<s:submit name="widg_bInserisciNuovoPartecipante" id="widg_bInserisciNuovoPartecipante" method="handleBInserisciNuovoPartecipante_CLICKED"
	key="cpPartecipanti.bInserisciNuovoPartecipante.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPartecipanti','bInserisciNuovoPartecipante')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCorsiNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpPartecipanti --></div>

	

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
