<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/backoffice/CpVerificheActaAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/backOffice -->
<!-- pageId:cpVerificheActa -->

<s:form id="cpVerificheActa" action="cpVerificheActa" namespace="/base/backOffice" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpVerificheActa_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpVerificheActa','menu')" >

	


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
				<h3><s:text name="cpVerificheActa.pVerificheActa.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpVerificheActa" class="formPanelBlock"><!-- startFragment:p_fpVerificheActa -->
		
	
<div class="formPanel" id="fpVerificheActa">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpVerificaActa" class="widgetsPanelBlock"><!-- startFragment:p_wpVerificaActa -->
	
	

<div class="widgetsPanel" id="wpVerificaActa">
	

	
	
<s:if test="isWidgetVisible('cpVerificheActa','tblVerificaIndex')" >

	
<div class="tableWidget">


<!-- widget tblVerificaIndex -->
<s:set name="cpVerificheActa_tblVerificaIndex_clearStatus" value="isTableClearStatus('cpVerificheActa_tblVerificaIndex')" />
<s:url id="cpVerificheActaViewUrl"						   
					   action="cpVerificheActa"
					   namespace="/base/backOffice"/>
<display:table name="appDataverificaActa"  				
			   excludedParams="*"			   export="true"
               id="widg_tblVerificaIndex"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpVerificheActaViewUrl}"  
               clearStatus="${cpVerificheActa_tblVerificaIndex_clearStatus}"
               uid="row_tblVerificaIndex"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.backoffice.CpVerificheActaTblVerificaIndexCustomDecorator"               class="dataTable">
	
		<display:column property="idCertificatore" titleKey="cpVerificheActa.tblVerificaIndex.idCertificatore.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="idCertificatore" titleKey="cpVerificheActa.tblVerificaIndex.idCertificatore.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="idCertificatore" titleKey="cpVerificheActa.tblVerificaIndex.idCertificatore.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="progrCertificato" titleKey="cpVerificheActa.tblVerificaIndex.progrCertificato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="progrCertificato" titleKey="cpVerificheActa.tblVerificaIndex.progrCertificato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="progrCertificato" titleKey="cpVerificheActa.tblVerificaIndex.progrCertificato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="anno" titleKey="cpVerificheActa.tblVerificaIndex.anno.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="anno" titleKey="cpVerificheActa.tblVerificaIndex.anno.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="anno" titleKey="cpVerificheActa.tblVerificaIndex.anno.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="numeroProtocollo" titleKey="cpVerificheActa.tblVerificaIndex.numeroProtocollo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="numeroProtocollo" titleKey="cpVerificheActa.tblVerificaIndex.numeroProtocollo.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="numeroProtocollo" titleKey="cpVerificheActa.tblVerificaIndex.numeroProtocollo.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="idProtocollo" titleKey="cpVerificheActa.tblVerificaIndex.idProtocollo.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="idProtocollo" titleKey="cpVerificheActa.tblVerificaIndex.idProtocollo.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="idProtocollo" titleKey="cpVerificheActa.tblVerificaIndex.idProtocollo.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpVerificaActa --></div>

			
	
	<div id="p_cpTransazioniMdp" class="commandPanelBlock"><!-- startFragment:p_cpTransazioniMdp -->
	
	
<div class="commandPanel functional" id="cpTransazioniMdp">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpVerificheActa','bRisolvi')" >

	



<!-- widget bRisolvi -->
<s:submit name="widg_bRisolvi" id="widg_bRisolvi" method="handleBRisolvi_CLICKED"
	key="cpVerificheActa.bRisolvi.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpVerificheActa','bRisolvi')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpTransazioniMdp --></div>

	

		
	
</div>

	<!-- endFragment:p_fpVerificheActa --></div>

	

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
