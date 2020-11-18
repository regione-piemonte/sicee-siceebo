<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/ricercacertificatori/CpRisultatoCertificatoriAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricercaCertificatori -->
<!-- pageId:cpRisultatoCertificatori -->

<s:form id="cpRisultatoCertificatori" action="cpRisultatoCertificatori" namespace="/base/ricercaCertificatori" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisultatoCertificatori_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRisultatoCertificatori','menu')" >

	


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
				<h3><s:text name="cpRisultatoCertificatori.pRisultatoCertificatori.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpRisultatoCertificatori" class="formPanelBlock"><!-- startFragment:p_fpRisultatoCertificatori -->
		
	
<div class="formPanel" id="fpRisultatoCertificatori">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="false" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpRisultatoCertificatori" class="widgetsPanelBlock"><!-- startFragment:p_wpRisultatoCertificatori -->
	
	

<div class="widgetsPanel" id="wpRisultatoCertificatori">
	

	
	
<s:if test="isWidgetVisible('cpRisultatoCertificatori','tblRisultatoCertificatori')" >

	
<div class="tableWidget">


<!-- widget tblRisultatoCertificatori -->
<s:set name="cpRisultatoCertificatori_tblRisultatoCertificatori_clearStatus" value="isTableClearStatus('cpRisultatoCertificatori_tblRisultatoCertificatori')" />
<s:url id="cpRisultatoCertificatoriViewUrl"						   
					   action="cpRisultatoCertificatori"
					   namespace="/base/ricercaCertificatori"/>
<display:table name="appDatacertificatoreList"  				
			   excludedParams="*"			   export="false"
               id="widg_tblRisultatoCertificatori"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisultatoCertificatoriViewUrl}"  
               clearStatus="${cpRisultatoCertificatori_tblRisultatoCertificatori_clearStatus}"
               uid="row_tblRisultatoCertificatori"
               summary="" 
               class="dataTable">
	
		<display:column property="matricola" titleKey="cpRisultatoCertificatori.tblRisultatoCertificatori.matricola.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="nome" titleKey="cpRisultatoCertificatori.tblRisultatoCertificatori.nome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="cognome" titleKey="cpRisultatoCertificatori.tblRisultatoCertificatori.cognome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descTitolo" titleKey="cpRisultatoCertificatori.tblRisultatoCertificatori.descTitolo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="ragSociale" titleKey="cpRisultatoCertificatori.tblRisultatoCertificatori.ragSociale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="indirizzo" titleKey="cpRisultatoCertificatori.tblRisultatoCertificatori.indirizzo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="descComProv" titleKey="cpRisultatoCertificatori.tblRisultatoCertificatori.descComProv.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisultatoCertificatori --></div>

			
	
	<div id="p_pPagamentoNav" class="commandPanelBlock"><!-- startFragment:p_pPagamentoNav -->
	
	
<div class="commandPanel navigation" id="pPagamentoNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoCertificatori','bNuovaRicerca')" >

	



<!-- widget bNuovaRicerca -->
<s:submit name="widg_bNuovaRicerca" id="widg_bNuovaRicerca" method="handleBNuovaRicerca_CLICKED"
	key="cpRisultatoCertificatori.bNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoCertificatori','bNuovaRicerca')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoCertificatori','bAffinaRicerca')" >

	



<!-- widget bAffinaRicerca -->
<s:submit name="widg_bAffinaRicerca" id="widg_bAffinaRicerca" method="handleBAffinaRicerca_CLICKED"
	key="cpRisultatoCertificatori.bAffinaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoCertificatori','bAffinaRicerca')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoCertificatori','scarica')" >

	



<!-- widget scarica -->
<s:submit name="widg_scarica" id="widg_scarica" method="handleScarica_CLICKED"
	key="cpRisultatoCertificatori.scarica.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisultatoCertificatori','scarica')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pPagamentoNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRisultatoCertificatori --></div>

	

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
