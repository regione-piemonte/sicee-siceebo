<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/ricercacertificatori/CpDettaglioCertificatoreAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricercaCertificatori -->
<!-- pageId:cpDettaglioCertificatore -->

<s:form id="cpDettaglioCertificatore" action="cpDettaglioCertificatore" namespace="/base/ricercaCertificatori" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioCertificatore_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpDettaglioCertificatore','menu')" >

	


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
				<h3><s:text name="cpDettaglioCertificatore.pDettaglioCertificatore.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpDettCert" class="formPanelBlock"><!-- startFragment:p_fpDettCert -->
		
	
<div class="formPanel" id="fpDettCert">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpStatoCertificatore" class="widgetsPanelBlock"><!-- startFragment:p_wpStatoCertificatore -->
	
	
<h4 class="wpLabel">Stato Certificatore </h4>
<div class="widgetsPanel" id="wpStatoCertificatore">
	
	<customtag:widgetsPanel id="wpStatoCertificatoreTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','lblDettCertStatoBlocco')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCertificatore.lblDettCertStatoBlocco.label')}" labelFor="widg_lblDettCertStatoBlocco" errorFor="appDatacertificatoreDett.descBloccoCert" labelId="lblDettCertStatoBloccoLbl"  position="first" >


<!-- widget lblDettCertStatoBlocco -->
<s:property value="appDatacertificatoreDett.descBloccoCert" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','cbMotivazioneBlocco')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.cbMotivazioneBlocco.label')}" labelFor="widg_cbMotivazioneBlocco" errorFor="appDatacertificatoreDett.idBloccoCert" labelId="cbMotivazioneBloccoLbl"
	  >


<!-- widget cbMotivazioneBlocco -->
<s:select name="appDatacertificatoreDett.idBloccoCert" id="widg_cbMotivazioneBlocco"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoMotivazioniBlocco"
	  disabled="isWidgetDisabled('cpDettaglioCertificatore','cbMotivazioneBlocco')"
	  listKey="id"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','taNoteBlocco')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.taNoteBlocco.label')}" labelFor="widg_taNoteBlocco" errorFor="appDatacertificatoreDett.noteBloccoCert" labelId="taNoteBloccoLbl"
	position="first" colSpan="5" >


<!-- widget taNoteBlocco -->
<s:textarea 
	
	
	name="appDatacertificatoreDett.noteBloccoCert" id="widg_taNoteBlocco"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','taNoteBlocco')"
	rows="5"
	cols="80"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','btnBloccaCert')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget btnBloccaCert -->
<s:submit name="widg_btnBloccaCert" id="widg_btnBloccaCert" method="handleBtnBloccaCert_CLICKED"
	key="cpDettaglioCertificatore.btnBloccaCert.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','btnBloccaCert')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','btnSbloccaCert')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnSbloccaCert -->
<s:submit name="widg_btnSbloccaCert" id="widg_btnSbloccaCert" method="handleBtnSbloccaCert_CLICKED"
	key="cpDettaglioCertificatore.btnSbloccaCert.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','btnSbloccaCert')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpStatoCertificatore --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDettCert --></div>

			
	
	<div id="p_wpInfDett" class="widgetsPanelBlock"><!-- startFragment:p_wpInfDett -->
	
	
<h4 class="wpLabel">Informazioni di dettaglio </h4>
<div class="widgetsPanel" id="wpInfDett">
	
	<customtag:widgetsPanel id="wpInfDettTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','hdvFitt')" >

	
<div class="hidden">


<!-- widget hdvFitt -->
<s:hidden name="widg_hdvFitt" id="widg_hdvFitt" />

	
</div>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpInfDett --></div>

			
	
	
	<div class="tabSetPanelContent">
	<div id="p_tspDettCert" class="tabSetPanelBlock"><!-- startFragment:p_tspDettCert -->
	
	
<div class="tabSetPanel" id="tspDettCert">
	<ul>
		<s:url id="cpDettaglioCertificatore_tspDettCert_fpDatiGenerali_URL" action="cpDettaglioCertificatore" namespace="/base/ricercaCertificatori" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpDettaglioCertificatore_tspDettCert_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpDettaglioCertificatore_tspDettCert_fpDatiGenerali'}" />
		</s:url>
		<s:if test="%{#session.cpDettaglioCertificatore_tspDettCert_selectedMultiPanel == 'cpDettaglioCertificatore_tspDettCert_fpDatiGenerali' || #session.cpDettaglioCertificatore_tspDettCert_selectedMultiPanel == null}">
			<li class="item-1 active"
			title="Dati Generali e Contatti"
			>
			<span class="activeItem"><s:text name="cpDettaglioCertificatore.fpDatiGenerali.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-1">

	<csiuicore:ajaxify id="p_tspDettCert" 
		widgetType="button" 
		requestUri="/siceebo/base/ricercaCertificatori/cpDettaglioCertificatore!handle_CpDettaglioCertificatore_TspDettCert_FpDatiGenerali_CLICKED.do" 
		pageId="cpDettaglioCertificatore" 
		formName="cpDettaglioCertificatore"
		javascriptDetection="false">
				<s:submit name="tspDettCert"
				          id="tspDettCert_fpDatiGenerali"
				          method="handle_CpDettaglioCertificatore_TspDettCert_FpDatiGenerali_CLICKED"
				          title="Dati Generali e Contatti"
				          key="cpDettaglioCertificatore.fpDatiGenerali.label" />
					
	</csiuicore:ajaxify>
			</li>
		</s:else>
		<s:url id="cpDettaglioCertificatore_tspDettCert_fpTitoloStudio_URL" action="cpDettaglioCertificatore" namespace="/base/ricercaCertificatori" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpDettaglioCertificatore_tspDettCert_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpDettaglioCertificatore_tspDettCert_fpTitoloStudio'}" />
		</s:url>
		<s:if test="%{#session.cpDettaglioCertificatore_tspDettCert_selectedMultiPanel == 'cpDettaglioCertificatore_tspDettCert_fpTitoloStudio'}">
			<li class="item-2 active"
			title="Titolo di studio e formazione"
			>
			<span class="activeItem"><s:text name="cpDettaglioCertificatore.fpTitoloStudio.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-2">

	<csiuicore:ajaxify id="p_tspDettCert" 
		widgetType="button" 
		requestUri="/siceebo/base/ricercaCertificatori/cpDettaglioCertificatore!handle_CpDettaglioCertificatore_TspDettCert_FpTitoloStudio_CLICKED.do" 
		pageId="cpDettaglioCertificatore" 
		formName="cpDettaglioCertificatore"
		javascriptDetection="false">
				<s:submit name="tspDettCert"
				          id="tspDettCert_fpTitoloStudio"
				          method="handle_CpDettaglioCertificatore_TspDettCert_FpTitoloStudio_CLICKED"
				          title="Titolo di studio e formazione"
				          key="cpDettaglioCertificatore.fpTitoloStudio.label" />
					
	</csiuicore:ajaxify>
			</li>
		</s:else>
		<s:url id="cpDettaglioCertificatore_tspDettCert_fpApe_URL" action="cpDettaglioCertificatore" namespace="/base/ricercaCertificatori" method="handleChangeTab" includeParams="get">
			<s:param name="selectedTabKey" value="%{'cpDettaglioCertificatore_tspDettCert_selectedMultiPanel'}" />
			<s:param name="selectedTabValue" value="%{'cpDettaglioCertificatore_tspDettCert_fpApe'}" />
		</s:url>
		<s:if test="%{#session.cpDettaglioCertificatore_tspDettCert_selectedMultiPanel == 'cpDettaglioCertificatore_tspDettCert_fpApe'}">
			<li class="item-3 active"
			title="A.P.E. prodotti"
			>
			<span class="activeItem"><s:text name="cpDettaglioCertificatore.fpApe.label" /></span></li>
		</s:if>
		<s:else>
			<li class="item-3">

	<csiuicore:ajaxify id="p_tspDettCert" 
		widgetType="button" 
		requestUri="/siceebo/base/ricercaCertificatori/cpDettaglioCertificatore!handle_CpDettaglioCertificatore_TspDettCert_FpApe_CLICKED.do" 
		pageId="cpDettaglioCertificatore" 
		formName="cpDettaglioCertificatore"
		javascriptDetection="false">
				<s:submit name="tspDettCert"
				          id="tspDettCert_fpApe"
				          method="handle_CpDettaglioCertificatore_TspDettCert_FpApe_CLICKED"
				          title="A.P.E. prodotti"
				          key="cpDettaglioCertificatore.fpApe.label" />
					
	</csiuicore:ajaxify>
			</li>
		</s:else>
	</ul>
</div>


	
		

		
<s:if test="#session.cpDettaglioCertificatore_tspDettCert_selectedMultiPanel == 'cpDettaglioCertificatore_tspDettCert_fpDatiGenerali' || #session.cpDettaglioCertificatore_tspDettCert_selectedMultiPanel == null">
	<s:include value="/jsp/tabs/cpDettaglioCertificatore_tspDettCert_fpDatiGenerali.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpDettaglioCertificatore_tspDettCert_selectedMultiPanel == 'cpDettaglioCertificatore_tspDettCert_fpTitoloStudio'">
	<s:include value="/jsp/tabs/cpDettaglioCertificatore_tspDettCert_fpTitoloStudio.jsp" ></s:include>
</s:if>
		

		
<s:if test="#session.cpDettaglioCertificatore_tspDettCert_selectedMultiPanel == 'cpDettaglioCertificatore_tspDettCert_fpApe'">
	<s:include value="/jsp/tabs/cpDettaglioCertificatore_tspDettCert_fpApe.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_tspDettCert --></div>
	</div>

	

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
