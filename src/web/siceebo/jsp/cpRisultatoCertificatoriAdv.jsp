<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/ricercacertificatori/CpRisultatoCertificatoriAdvAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricercaCertificatori -->
<!-- pageId:cpRisultatoCertificatoriAdv -->

<s:form id="cpRisultatoCertificatoriAdv" action="cpRisultatoCertificatoriAdv" namespace="/base/ricercaCertificatori" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRisultatoCertificatoriAdv_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRisultatoCertificatoriAdv','menu')" >

	


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
				<h3><s:text name="cpRisultatoCertificatoriAdv.pRisultatoCertificatori.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpRisultatoCertificatori" class="formPanelBlock"><!-- startFragment:p_fpRisultatoCertificatori -->
		
	
<div class="formPanel" id="fpRisultatoCertificatori">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_fpStatoCert" class="formPanelBlock"><!-- startFragment:p_fpStatoCert -->
		
	
<div class="formPanel" id="fpStatoCert">


	
	

	
	
			
	
	<div id="p_wpStatoCertificatore" class="widgetsPanelBlock"><!-- startFragment:p_wpStatoCertificatore -->
	
	
<h4 class="wpLabel">Gestione stato Certificatori </h4>
<div class="widgetsPanel" id="wpStatoCertificatore">
	
	<customtag:widgetsPanel id="wpStatoCertificatoreTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRisultatoCertificatoriAdv','cbMotivazioneBlocco')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRisultatoCertificatoriAdv.cbMotivazioneBlocco.label')}" labelFor="widg_cbMotivazioneBlocco" errorFor="appDataidMotivoBloccoSel" labelId="cbMotivazioneBloccoLbl"
	position="first"  >


<!-- widget cbMotivazioneBlocco -->
<s:select name="appDataidMotivoBloccoSel" id="widg_cbMotivazioneBlocco"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoMotivazioniBlocco"
	  disabled="isWidgetDisabled('cpRisultatoCertificatoriAdv','cbMotivazioneBlocco')"
	  listKey="id"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRisultatoCertificatoriAdv','btnBloccaCert')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget btnBloccaCert -->
<s:submit name="widg_btnBloccaCert" id="widg_btnBloccaCert" method="handleBtnBloccaCert_CLICKED"
	key="cpRisultatoCertificatoriAdv.btnBloccaCert.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoCertificatoriAdv','btnBloccaCert')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpStatoCertificatore --></div>

	

		
	
</div>

	<!-- endFragment:p_fpStatoCert --></div>

			
	
	<div id="p_wpRisultatoCertificatori" class="widgetsPanelBlock"><!-- startFragment:p_wpRisultatoCertificatori -->
	
	

<div class="widgetsPanel" id="wpRisultatoCertificatori">
	

	
	
<s:if test="isWidgetVisible('cpRisultatoCertificatoriAdv','tblRisultatoCertificatori')" >

	
<div class="tableWidget">


<!-- widget tblRisultatoCertificatori -->
<s:set name="cpRisultatoCertificatoriAdv_tblRisultatoCertificatori_clearStatus" value="isTableClearStatus('cpRisultatoCertificatoriAdv_tblRisultatoCertificatori')" />
<s:url id="cpRisultatoCertificatoriAdvViewUrl"						   
					   action="cpRisultatoCertificatoriAdv"
					   namespace="/base/ricercaCertificatori"/>
<display:table name="appDatacertificatoreList"  				
			   excludedParams="*"			   export="true"
               id="widg_tblRisultatoCertificatori"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpRisultatoCertificatoriAdvViewUrl}"  
               clearStatus="${cpRisultatoCertificatoriAdv_tblRisultatoCertificatori_clearStatus}"
               uid="row_tblRisultatoCertificatori"
               summary="" 
               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblRisultatoCertificatori.id}" name="appDataidCertificatoreSel" id="%{'tblRisultatoCertificatori-editcell-'+ (#attr.row_tblRisultatoCertificatori_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="matricola" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.matricola.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="matricola" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.matricola.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="matricola" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.matricola.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="nome" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.nome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="nome" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.nome.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="nome" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.nome.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="cognome" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.cognome.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="cognome" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.cognome.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="cognome" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.cognome.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descTitolo" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.descTitolo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descTitolo" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.descTitolo.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descTitolo" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.descTitolo.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="ragSociale" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.ragSociale.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="ragSociale" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.ragSociale.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="ragSociale" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.ragSociale.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="indirizzo" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.indirizzo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="indirizzo" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.indirizzo.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="indirizzo" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.indirizzo.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="descComProv" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.descComProv.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descComProv" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.descComProv.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descComProv" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.descComProv.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descBloccoCert" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.descBloccoCert.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descBloccoCert" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.descBloccoCert.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descBloccoCert" titleKey="cpRisultatoCertificatoriAdv.tblRisultatoCertificatori.descBloccoCert.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisultatoCertificatori --></div>

			
	
	<div id="p_pPagamentoNav" class="commandPanelBlock"><!-- startFragment:p_pPagamentoNav -->
	
	
<div class="commandPanel navigation" id="pPagamentoNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRisultatoCertificatoriAdv','bNuovaRicerca')" >

	



<!-- widget bNuovaRicerca -->
<s:submit name="widg_bNuovaRicerca" id="widg_bNuovaRicerca" method="handleBNuovaRicerca_CLICKED"
	key="cpRisultatoCertificatoriAdv.bNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoCertificatoriAdv','bNuovaRicerca')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoCertificatoriAdv','bAffinaRicerca')" >

	



<!-- widget bAffinaRicerca -->
<s:submit name="widg_bAffinaRicerca" id="widg_bAffinaRicerca" method="handleBAffinaRicerca_CLICKED"
	key="cpRisultatoCertificatoriAdv.bAffinaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoCertificatoriAdv','bAffinaRicerca')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoCertificatoriAdv','bVisualizzaDettaglio')" >

	



<!-- widget bVisualizzaDettaglio -->
<s:submit name="widg_bVisualizzaDettaglio" id="widg_bVisualizzaDettaglio" method="handleBVisualizzaDettaglio_CLICKED"
	key="cpRisultatoCertificatoriAdv.bVisualizzaDettaglio.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoCertificatoriAdv','bVisualizzaDettaglio')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoCertificatoriAdv','scarica')" >

	



<!-- widget scarica -->
<s:submit name="widg_scarica" id="widg_scarica" method="handleScarica_CLICKED"
	key="cpRisultatoCertificatoriAdv.scarica.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpRisultatoCertificatoriAdv','scarica')" />

	


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
