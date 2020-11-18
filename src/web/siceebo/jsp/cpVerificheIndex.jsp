<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/backoffice/CpVerificheIndexAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/backOffice -->
<!-- pageId:cpVerificheIndex -->

<s:form id="cpVerificheIndex" action="cpVerificheIndex" namespace="/base/backOffice" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpVerificheIndex_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpVerificheIndex','menu')" >

	


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
				<h3><s:text name="cpVerificheIndex.pVerificheMdp.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpVerificheIndex" class="formPanelBlock"><!-- startFragment:p_fpVerificheIndex -->
		
	
<div class="formPanel" id="fpVerificheIndex">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpRicercaAce" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAce -->
	
	
<h4 class="wpLabel">Ricerca ACE </h4>
<div class="widgetsPanel" id="wpRicercaAce">
	
	<customtag:widgetsPanel id="wpRicercaAceTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpVerificheIndex','tfAnnoCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVerificheIndex.tfAnnoCertificato.label')}" labelFor="widg_tfAnnoCertificato" errorFor="appDataricercaAce.annoCertificato" labelId="tfAnnoCertificatoLbl"
	position="first"  >


<!-- widget tfAnnoCertificato -->
<s:textfield 
	
	
	name="appDataricercaAce.annoCertificato" id="widg_tfAnnoCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpVerificheIndex','tfAnnoCertificato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpVerificheIndex','tfCertificatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVerificheIndex.tfCertificatore.label')}" labelFor="widg_tfCertificatore" errorFor="appDataricercaAce.certificatore" labelId="tfCertificatoreLbl"
	  >


<!-- widget tfCertificatore -->
<s:textfield 
	
	
	name="appDataricercaAce.certificatore" id="widg_tfCertificatore"
maxlength="6"	disabled="isWidgetDisabled('cpVerificheIndex','tfCertificatore')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpVerificheIndex','tfProgCertificato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpVerificheIndex.tfProgCertificato.label')}" labelFor="widg_tfProgCertificato" errorFor="appDataricercaAce.progCertificato" labelId="tfProgCertificatoLbl"
	position="last"  >


<!-- widget tfProgCertificato -->
<s:textfield 
	
	
	name="appDataricercaAce.progCertificato" id="widg_tfProgCertificato"
maxlength="4"	disabled="isWidgetDisabled('cpVerificheIndex','tfProgCertificato')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAce --></div>

			
	
	<div id="p_pRicercaAce" class="commandPanelBlock"><!-- startFragment:p_pRicercaAce -->
	
	
<div class="commandPanel functional" id="pRicercaAce">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpVerificheIndex','bRicercaByCodiceNav')" >

	



<!-- widget bRicercaByCodiceNav -->
<s:submit name="widg_bRicercaByCodiceNav" id="widg_bRicercaByCodiceNav" method="handleBRicercaByCodiceNav_CLICKED"
	key="cpVerificheIndex.bRicercaByCodiceNav.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVerificheIndex','bRicercaByCodiceNav')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaAce --></div>

			
	
	<div id="p_wpVerificaIndex" class="widgetsPanelBlock"><!-- startFragment:p_wpVerificaIndex -->
	
	

<div class="widgetsPanel" id="wpVerificaIndex">
	

	
	
<s:if test="isWidgetVisible('cpVerificheIndex','tblVerificaIndex')" >

	
<div class="tableWidget">


<!-- widget tblVerificaIndex -->
<s:set name="cpVerificheIndex_tblVerificaIndex_clearStatus" value="isTableClearStatus('cpVerificheIndex_tblVerificaIndex')" />
<s:url id="cpVerificheIndexViewUrl"						   
					   action="cpVerificheIndex"
					   namespace="/base/backOffice"/>
<display:table name="appDataverificaIndex"  				
			   excludedParams="*"			   export="true"
               id="widg_tblVerificaIndex"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpVerificheIndexViewUrl}"  
               clearStatus="${cpVerificheIndex_tblVerificaIndex_clearStatus}"
               uid="row_tblVerificaIndex"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.backoffice.CpVerificheIndexTblVerificaIndexCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblVerificaIndex.uidIndex}" name="appDataidVerificaSel" id="%{'tblVerificaIndex-editcell-'+ (#attr.row_tblVerificaIndex_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="descTipoDoc" titleKey="cpVerificheIndex.tblVerificaIndex.descTipoDoc.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descTipoDoc" titleKey="cpVerificheIndex.tblVerificaIndex.descTipoDoc.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descTipoDoc" titleKey="cpVerificheIndex.tblVerificaIndex.descTipoDoc.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="nomeDoc" titleKey="cpVerificheIndex.tblVerificaIndex.nomeDoc.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nomeDoc" titleKey="cpVerificheIndex.tblVerificaIndex.nomeDoc.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="nomeDoc" titleKey="cpVerificheIndex.tblVerificaIndex.nomeDoc.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="uidIndex" titleKey="cpVerificheIndex.tblVerificaIndex.uidIndex.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="uidIndex" titleKey="cpVerificheIndex.tblVerificaIndex.uidIndex.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="uidIndex" titleKey="cpVerificheIndex.tblVerificaIndex.uidIndex.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="dataCaricamento" titleKey="cpVerificheIndex.tblVerificaIndex.dataCaricamento.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dataCaricamento" titleKey="cpVerificheIndex.tblVerificaIndex.dataCaricamento.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dataCaricamento" titleKey="cpVerificheIndex.tblVerificaIndex.dataCaricamento.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="descEsito" titleKey="cpVerificheIndex.tblVerificaIndex.descEsito.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descEsito" titleKey="cpVerificheIndex.tblVerificaIndex.descEsito.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descEsito" titleKey="cpVerificheIndex.tblVerificaIndex.descEsito.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpVerificaIndex --></div>

			
	
	<div id="p_cpTransazioniMdp" class="commandPanelBlock"><!-- startFragment:p_cpTransazioniMdp -->
	
	
<div class="commandPanel functional" id="cpTransazioniMdp">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpVerificheIndex','bRecupera')" >

	



<!-- widget bRecupera -->
<s:submit name="widg_bRecupera" id="widg_bRecupera" method="handleBRecupera_CLICKED"
	key="cpVerificheIndex.bRecupera.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVerificheIndex','bRecupera')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpVerificheIndex','bVisualizza')" >

	



<!-- widget bVisualizza -->
<s:submit name="widg_bVisualizza" id="widg_bVisualizza" method="handleBVisualizza_CLICKED"
	key="cpVerificheIndex.bVisualizza.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpVerificheIndex','bVisualizza')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpTransazioniMdp --></div>

	

		
	
</div>

	<!-- endFragment:p_fpVerificheIndex --></div>

	

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
