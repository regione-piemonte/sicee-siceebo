<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/backOffice -->
<!-- pageId:cpRecuperaCoordinateLOCCSI -->

<s:form id="cpRecuperaCoordinateLOCCSI" action="cpRecuperaCoordinateLOCCSI" namespace="/base/backOffice" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRecuperaCoordinateLOCCSI_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRecuperaCoordinateLOCCSI','menu')" >

	


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
				<h3><s:text name="cpRecuperaCoordinateLOCCSI.pRecuperaCoordinateLOCCSI.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpRecuperaCoordinateLOCCSI" class="formPanelBlock"><!-- startFragment:p_fpRecuperaCoordinateLOCCSI -->
		
	
<div class="formPanel" id="fpRecuperaCoordinateLOCCSI">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpRecuperaCoordinateLOCCSI" class="widgetsPanelBlock"><!-- startFragment:p_wpRecuperaCoordinateLOCCSI -->
	
	

<div class="widgetsPanel" id="wpRecuperaCoordinateLOCCSI">
	
	<customtag:widgetsPanel id="wpRecuperaCoordinateLOCCSITbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRecuperaCoordinateLOCCSI','ptFunzCertificatiSenzaCoordinate')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpRecuperaCoordinateLOCCSI.ptFunzCertificatiSenzaCoordinate.label')}" labelFor="widg_ptFunzCertificatiSenzaCoordinate" errorFor="appDatacountCertificatiSenzaCoordinate" labelId="ptFunzCertificatiSenzaCoordinateLbl"   >


<!-- widget ptFunzCertificatiSenzaCoordinate -->
<s:property value="appDatacountCertificatiSenzaCoordinate" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRecuperaCoordinateLOCCSI --></div>

			
	
	<div id="p_cpRecuperaCoordinateLOCCSI" class="commandPanelBlock"><!-- startFragment:p_cpRecuperaCoordinateLOCCSI -->
	
	
<div class="commandPanel functional" id="cpRecuperaCoordinateLOCCSI">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRecuperaCoordinateLOCCSI','bRecuperaCoordinateLOCCSI')" >

	



<!-- widget bRecuperaCoordinateLOCCSI -->
<s:submit name="widg_bRecuperaCoordinateLOCCSI" id="widg_bRecuperaCoordinateLOCCSI" method="handleBRecuperaCoordinateLOCCSI_CLICKED"
	key="cpRecuperaCoordinateLOCCSI.bRecuperaCoordinateLOCCSI.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRecuperaCoordinateLOCCSI','bRecuperaCoordinateLOCCSI')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpRecuperaCoordinateLOCCSI --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRecuperaCoordinateLOCCSI --></div>

	

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
