<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %><%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/backoffice/CpTransazioniMdpAction" />


<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/backOffice -->
<!-- pageId:cpTransazioniMdp -->

<s:form id="cpTransazioniMdp" action="cpTransazioniMdp" namespace="/base/backOffice" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpTransazioniMdp_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpTransazioniMdp','menu')" >

	


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
				<h3><s:text name="cpTransazioniMdp.pTransazioniMdp.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpTransazioniMdp" class="formPanelBlock"><!-- startFragment:p_fpTransazioniMdp -->
		
	
<div class="formPanel" id="fpTransazioniMdp">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpResTransMdp" class="widgetsPanelBlock"><!-- startFragment:p_wpResTransMdp -->
	
	

<div class="widgetsPanel" id="wpResTransMdp">
	
	<customtag:widgetsPanel id="wpResTransMdpTbl" columns="2" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpTransazioniMdp','ptDataDal')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpTransazioniMdp.ptDataDal.label')}" labelFor="widg_ptDataDal" errorFor="appDataresocontoTransMdp.dataCreazioneDal" labelId="ptDataDalLbl"   >


<!-- widget ptDataDal -->
<s:property value="appDataresocontoTransMdp.dataCreazioneDal" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransazioniMdp','ptDataAl')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpTransazioniMdp.ptDataAl.label')}" labelFor="widg_ptDataAl" errorFor="appDataresocontoTransMdp.dataCreazioneAl" labelId="ptDataAlLbl"   >


<!-- widget ptDataAl -->
<s:property value="appDataresocontoTransMdp.dataCreazioneAl" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransazioniMdp','ptTotFalliti')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpTransazioniMdp.ptTotFalliti.label')}" labelFor="widg_ptTotFalliti" errorFor="appDataresocontoTransMdp.totFalliti" labelId="ptTotFallitiLbl"   >


<!-- widget ptTotFalliti -->
<s:property value="appDataresocontoTransMdp.totFalliti" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransazioniMdp','ptTotAnnullati')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpTransazioniMdp.ptTotAnnullati.label')}" labelFor="widg_ptTotAnnullati" errorFor="appDataresocontoTransMdp.totAnnullati" labelId="ptTotAnnullatiLbl"   >


<!-- widget ptTotAnnullati -->
<s:property value="appDataresocontoTransMdp.totAnnullati" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransazioniMdp','ptTotPagamentoKo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpTransazioniMdp.ptTotPagamentoKo.label')}" labelFor="widg_ptTotPagamentoKo" errorFor="appDataresocontoTransMdp.totPagamentiKo" labelId="ptTotPagamentoKoLbl"   >


<!-- widget ptTotPagamentoKo -->
<s:property value="appDataresocontoTransMdp.totPagamentiKo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransazioniMdp','ptTotPagamentoKoAuto')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpTransazioniMdp.ptTotPagamentoKoAuto.label')}" labelFor="widg_ptTotPagamentoKoAuto" errorFor="appDataresocontoTransMdp.totPagamentiKoAuto" labelId="ptTotPagamentoKoAutoLbl"   >


<!-- widget ptTotPagamentoKoAuto -->
<s:property value="appDataresocontoTransMdp.totPagamentiKoAuto" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransazioniMdp','ptTotPagamentoOk')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpTransazioniMdp.ptTotPagamentoOk.label')}" labelFor="widg_ptTotPagamentoOk" errorFor="appDataresocontoTransMdp.totPagamentiOk" labelId="ptTotPagamentoOkLbl"   >


<!-- widget ptTotPagamentoOk -->
<s:property value="appDataresocontoTransMdp.totPagamentiOk" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransazioniMdp','ptTotImportoPagamentoOk')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpTransazioniMdp.ptTotImportoPagamentoOk.label')}" labelFor="widg_ptTotImportoPagamentoOk" errorFor="appDataresocontoTransMdp.totImportoPagamentiOk" labelId="ptTotImportoPagamentoOkLbl"   tdStyleClass="numbers">


<!-- widget ptTotImportoPagamentoOk -->
<s:property value="appDataresocontoTransMdp.totImportoPagamentiOk" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpResTransMdp --></div>

			
	
	<div id="p_wpFiltriRicerca" class="widgetsPanelBlock"><!-- startFragment:p_wpFiltriRicerca -->
	
	
<h4 class="wpLabel">Tipo ricerca </h4>
<div class="widgetsPanel" id="wpFiltriRicerca">
	
	<customtag:widgetsPanel id="wpFiltriRicercaTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpTransazioniMdp','rbFiltroRicerca')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpTransazioniMdp.rbFiltroRicerca.label')}" labelFor="widg_rbFiltroRicerca" errorFor="appDatafiltroDettaglioTransAttEsito.idTipoRicerca" labelId="rbFiltroRicercaLbl"
	position="first" colSpan="3" >


<!-- widget rbFiltroRicerca -->

	
<div id="appDatafiltroDettaglioTransAttEsito.idTipoRicerca" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbAvvioTrans" name="appDatafiltroDettaglioTransAttEsito.idTipoRicerca"
	list="#{'3':'AVVIO TRANSAZIONE'}"
	disabled="isWidgetDisabled('cpTransazioniMdp','rbFiltroRicerca')"
	cssClass="radio"
	
	/> <label  for="widg_rbAvvioTrans3"><s:text name="cpTransazioniMdp.rbFiltroRicerca.rbAvvioTrans.label" /></label>








<s:radio
	
	
	id="widg_rbAttesaRt" name="appDatafiltroDettaglioTransAttEsito.idTipoRicerca"
	list="#{'4':'ATTESA RT'}"
	disabled="isWidgetDisabled('cpTransazioniMdp','rbFiltroRicerca')"
	cssClass="radio"
	
	/> <label  for="widg_rbAttesaRt4"><s:text name="cpTransazioniMdp.rbFiltroRicerca.rbAttesaRt.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransazioniMdp','tfIdTrans')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpTransazioniMdp.tfIdTrans.label')}" labelFor="widg_tfIdTrans" errorFor="appDatafiltroDettaglioTransAttEsito.idTransazione" labelId="tfIdTransLbl"
	position="first" colSpan="3" >


<!-- widget tfIdTrans -->
<s:textfield 
	
	
	name="appDatafiltroDettaglioTransAttEsito.idTransazione" id="widg_tfIdTrans"
maxlength="15"	disabled="isWidgetDisabled('cpTransazioniMdp','tfIdTrans')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpTransazioniMdp','calRicMdpDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpTransazioniMdp.calRicMdpDal.label')}" labelFor="widg_calRicMdpDal" errorFor="appDatafiltroDettaglioTransAttEsito.creazioneDal" labelId="calRicMdpDalLbl"
	position="first"  >


<!-- widget calRicMdpDal -->
<s:textfield 
	
	
	name="appDatafiltroDettaglioTransAttEsito.creazioneDal" id="widg_calRicMdpDal"
	disabled="isWidgetDisabled('cpTransazioniMdp','calRicMdpDal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpTransazioniMdp','calRicMdpAl')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpTransazioniMdp.calRicMdpAl.label')}" labelFor="widg_calRicMdpAl" errorFor="appDatafiltroDettaglioTransAttEsito.creazioneAl" labelId="calRicMdpAlLbl"
	position="last"  >


<!-- widget calRicMdpAl -->
<s:textfield 
	
	
	name="appDatafiltroDettaglioTransAttEsito.creazioneAl" id="widg_calRicMdpAl"
	disabled="isWidgetDisabled('cpTransazioniMdp','calRicMdpAl')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpTransazioniMdp','tfIuv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpTransazioniMdp.tfIuv.label')}" labelFor="widg_tfIuv" errorFor="appDatafiltroDettaglioTransAttEsito.iuv" labelId="tfIuvLbl"
	position="first"  >


<!-- widget tfIuv -->
<s:textfield 
	
	
	name="appDatafiltroDettaglioTransAttEsito.iuv" id="widg_tfIuv"
maxlength="50"	disabled="isWidgetDisabled('cpTransazioniMdp','tfIuv')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpTransazioniMdp','tfIdMdp')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpTransazioniMdp.tfIdMdp.label')}" labelFor="widg_tfIdMdp" errorFor="appDatafiltroDettaglioTransAttEsito.idMdp" labelId="tfIdMdpLbl"
	position="last"  >


<!-- widget tfIdMdp -->
<s:textfield 
	
	
	name="appDatafiltroDettaglioTransAttEsito.idMdp" id="widg_tfIdMdp"
maxlength="50"	disabled="isWidgetDisabled('cpTransazioniMdp','tfIdMdp')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpTransazioniMdp','wpFiltriRicerca_5_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpFiltriRicerca_5_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpTransazioniMdp','bRicerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget bRicerca -->
<s:submit name="widg_bRicerca" id="widg_bRicerca" method="handleBRicerca_CLICKED"
	key="cpTransazioniMdp.bRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazioniMdp','bRicerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpFiltriRicerca --></div>

			
	
	<div id="p_wpDettTransMdpAttesa" class="widgetsPanelBlock"><!-- startFragment:p_wpDettTransMdpAttesa -->
	
	

<div class="widgetsPanel" id="wpDettTransMdpAttesa">
	

	
	
<s:if test="isWidgetVisible('cpTransazioniMdp','tblDettTransAttEsito')" >

	
<div class="tableWidget">


<!-- widget tblDettTransAttEsito -->
<s:set name="cpTransazioniMdp_tblDettTransAttEsito_clearStatus" value="isTableClearStatus('cpTransazioniMdp_tblDettTransAttEsito')" />
<s:url id="cpTransazioniMdpViewUrl"						   
					   action="cpTransazioniMdp"
					   namespace="/base/backOffice"/>
<display:table name="appDatadettaglioTransAttEsito"  				
			   excludedParams="*"			   export="true"
               id="widg_tblDettTransAttEsito"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpTransazioniMdpViewUrl}"  
               clearStatus="${cpTransazioniMdp_tblDettTransAttEsito_clearStatus}"
               uid="row_tblDettTransAttEsito"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.backoffice.CpTransazioniMdpTblDettTransAttEsitoCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:checkboxlist list="%{#attr.row_tblDettTransAttEsito.idTransazione}" name="appDataidTransazioniSel" id="%{'tblDettTransAttEsito-editcell-'+ (#attr.row_tblDettTransAttEsito_rowNum - 1)}" cssClass="checkbox"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="idTransazione" titleKey="cpTransazioniMdp.tblDettTransAttEsito.idTransazione.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="idTransazione" titleKey="cpTransazioniMdp.tblDettTransAttEsito.idTransazione.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="idTransazione" titleKey="cpTransazioniMdp.tblDettTransAttEsito.idTransazione.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="dtCreazioneTrans" titleKey="cpTransazioniMdp.tblDettTransAttEsito.dtCreazioneTrans.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dtCreazioneTrans" titleKey="cpTransazioniMdp.tblDettTransAttEsito.dtCreazioneTrans.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dtCreazioneTrans" titleKey="cpTransazioniMdp.tblDettTransAttEsito.dtCreazioneTrans.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="descStatoTrans" titleKey="cpTransazioniMdp.tblDettTransAttEsito.descStatoTrans.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descStatoTrans" titleKey="cpTransazioniMdp.tblDettTransAttEsito.descStatoTrans.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descStatoTrans" titleKey="cpTransazioniMdp.tblDettTransAttEsito.descStatoTrans.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="importo" titleKey="cpTransazioniMdp.tblDettTransAttEsito.importo.label" 
			sortable="true" headerClass="sortable"
			format="{0,number,#,##0.00}"  class="numbers"  media="html"
			
 >
			
		</display:column>

		<display:column property="importo" titleKey="cpTransazioniMdp.tblDettTransAttEsito.importo.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="importo" titleKey="cpTransazioniMdp.tblDettTransAttEsito.importo.export.label"
			sortable="true" headerClass="sortable"
			format="{0,number,#,##0.00}" 
			media="pdf" />	
		<display:column property="idIuv" titleKey="cpTransazioniMdp.tblDettTransAttEsito.idIuv.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="idIuv" titleKey="cpTransazioniMdp.tblDettTransAttEsito.idIuv.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="idIuv" titleKey="cpTransazioniMdp.tblDettTransAttEsito.idIuv.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="idTransazioneMdp" titleKey="cpTransazioniMdp.tblDettTransAttEsito.idTransazioneMdp.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="idTransazioneMdp" titleKey="cpTransazioniMdp.tblDettTransAttEsito.idTransazioneMdp.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="idTransazioneMdp" titleKey="cpTransazioniMdp.tblDettTransAttEsito.idTransazioneMdp.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="dtAvvioTrans" titleKey="cpTransazioniMdp.tblDettTransAttEsito.dtAvvioTrans.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dtAvvioTrans" titleKey="cpTransazioniMdp.tblDettTransAttEsito.dtAvvioTrans.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dtAvvioTrans" titleKey="cpTransazioniMdp.tblDettTransAttEsito.dtAvvioTrans.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="descStatoTransMdp" titleKey="cpTransazioniMdp.tblDettTransAttEsito.descStatoTransMdp.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descStatoTransMdp" titleKey="cpTransazioniMdp.tblDettTransAttEsito.descStatoTransMdp.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descStatoTransMdp" titleKey="cpTransazioniMdp.tblDettTransAttEsito.descStatoTransMdp.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="dtStatoTransMdp" titleKey="cpTransazioniMdp.tblDettTransAttEsito.dtStatoTransMdp.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateTimeComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dtStatoTransMdp" titleKey="cpTransazioniMdp.tblDettTransAttEsito.dtStatoTransMdp.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateTimeComparator"
			media="excel" />
		<display:column property="dtStatoTransMdp" titleKey="cpTransazioniMdp.tblDettTransAttEsito.dtStatoTransMdp.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateTimeComparator"
			media="pdf" />	
</display:table>

<s:hidden name="__tableselectionempty_appDataidTransazioniSel" id="__tableselectionempty_widg_tblDettTransAttEsito" />




	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpDettTransMdpAttesa --></div>

			
	
	<div id="p_cpTransazioniMdp" class="commandPanelBlock"><!-- startFragment:p_cpTransazioniMdp -->
	
	
<div class="commandPanel functional" id="cpTransazioniMdp">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpTransazioniMdp','bAnnullaTransaz')" >

	



<!-- widget bAnnullaTransaz -->
<s:submit name="widg_bAnnullaTransaz" id="widg_bAnnullaTransaz" method="handleBAnnullaTransaz_CLICKED"
	key="cpTransazioniMdp.bAnnullaTransaz.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazioniMdp','bAnnullaTransaz')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpTransazioniMdp','bVerificaMdp')" >

	



<!-- widget bVerificaMdp -->
<s:submit name="widg_bVerificaMdp" id="widg_bVerificaMdp" method="handleBVerificaMdp_CLICKED"
	key="cpTransazioniMdp.bVerificaMdp.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazioniMdp','bVerificaMdp')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpTransazioniMdp','bRecuperaRT')" >

	



<!-- widget bRecuperaRT -->
<s:submit name="widg_bRecuperaRT" id="widg_bRecuperaRT" method="handleBRecuperaRT_CLICKED"
	key="cpTransazioniMdp.bRecuperaRT.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpTransazioniMdp','bRecuperaRT')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpTransazioniMdp --></div>

	

		
	
</div>

	<!-- endFragment:p_fpTransazioniMdp --></div>

	

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
