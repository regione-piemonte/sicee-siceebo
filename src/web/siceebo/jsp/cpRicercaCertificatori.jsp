<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricercaCertificatori -->
<!-- pageId:cpRicercaCertificatori -->

<s:form id="cpRicercaCertificatori" action="cpRicercaCertificatori" namespace="/base/ricercaCertificatori" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaCertificatori_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRicercaCertificatori','menu')" >

	


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
				<h3><s:text name="cpRicercaCertificatori.pRicercaCertificatori.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpRicercaCertificatori" class="formPanelBlock"><!-- startFragment:p_fpRicercaCertificatori -->
		
	
<div class="formPanel" id="fpRicercaCertificatori">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpRicercaCertificatori" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaCertificatori -->
	
	

<div class="widgetsPanel" id="wpRicercaCertificatori">
	
	<customtag:widgetsPanel id="wpRicercaCertificatoriTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaCertificatori','tfRicCertMatr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.tfRicCertMatr.label')}" labelFor="widg_tfRicCertMatr" errorFor="appDataricercaCertificatori.numMatricola" labelId="tfRicCertMatrLbl"
	position="first" colSpan="3" >


<!-- widget tfRicCertMatr -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.numMatricola" id="widg_tfRicCertMatr"
maxlength="6"	disabled="isWidgetDisabled('cpRicercaCertificatori','tfRicCertMatr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','cbTitolo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.cbTitolo.label')}" labelFor="widg_cbTitolo" errorFor="appDataricercaCertificatori.codTitolo" labelId="cbTitoloLbl"
	position="first" colSpan="3" >


<!-- widget cbTitolo -->
<s:select name="appDataricercaCertificatori.codTitolo" id="widg_cbTitolo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatitoli"
	  disabled="isWidgetDisabled('cpRicercaCertificatori','cbTitolo')"
	  listKey="id"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','tfRicCertNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.tfRicCertNome.label')}" labelFor="widg_tfRicCertNome" errorFor="appDataricercaCertificatori.nome" labelId="tfRicCertNomeLbl"
	position="first" colSpan="3" >


<!-- widget tfRicCertNome -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.nome" id="widg_tfRicCertNome"
maxlength="30"	disabled="isWidgetDisabled('cpRicercaCertificatori','tfRicCertNome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','tfRicCertCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.tfRicCertCognome.label')}" labelFor="widg_tfRicCertCognome" errorFor="appDataricercaCertificatori.cognome" labelId="tfRicCertCognomeLbl"
	position="first" colSpan="3" >


<!-- widget tfRicCertCognome -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.cognome" id="widg_tfRicCertCognome"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaCertificatori','tfRicCertCognome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','tfRicCertRagSociale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.tfRicCertRagSociale.label')}" labelFor="widg_tfRicCertRagSociale" errorFor="appDataricercaCertificatori.ragSociale" labelId="tfRicCertRagSocialeLbl"
	position="first" colSpan="3" >


<!-- widget tfRicCertRagSociale -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.ragSociale" id="widg_tfRicCertRagSociale"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaCertificatori','tfRicCertRagSociale')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','cbRegione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.cbRegione.label')}" labelFor="widg_cbRegione" errorFor="appDataricercaCertificatori.codRegione" labelId="cbRegioneLbl"
	position="first" colSpan="3" >


<!-- widget cbRegione -->

<s:url id="widg_cbRegioneurlComboBoxValueChange"
   action="/siceebo/cpRicercaCertificatori!handleCbRegione_VALUE_CHANGED" namespace="/base/ricercaCertificatori"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaCertificatori.codRegione" id="widg_cbRegione"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregione"
	  disabled="isWidgetDisabled('cpRicercaCertificatori','cbRegione')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbRegione','conferma','%{widg_cbRegioneurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRegione','conferma','%{widg_cbRegioneurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','cbProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.cbProvincia.label')}" labelFor="widg_cbProvincia" errorFor="appDataricercaCertificatori.codProvincia" labelId="cbProvinciaLbl"
	position="first" colSpan="3" >


<!-- widget cbProvincia -->

<s:url id="widg_cbProvinciaurlComboBoxValueChange"
   action="/siceebo/cpRicercaCertificatori!handleCbProvincia_VALUE_CHANGED" namespace="/base/ricercaCertificatori"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaCertificatori.codProvincia" id="widg_cbProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovince"
	  disabled="isWidgetDisabled('cpRicercaCertificatori','cbProvincia')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','cbComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.cbComune.label')}" labelFor="widg_cbComune" errorFor="appDataricercaCertificatori.codComune" labelId="cbComuneLbl"
	position="first"  >


<!-- widget cbComune -->
<s:select name="appDataricercaCertificatori.codComune" id="widg_cbComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatacomuni"
	  disabled="isWidgetDisabled('cpRicercaCertificatori','cbComune')"
	  listKey="cod"
	  listValue="nome"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','tfRicComune')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="2" >


<!-- widget tfRicComune -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.descComune" id="widg_tfRicComune"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaCertificatori','tfRicComune')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','calRicCertACEDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.calRicCertACEDal.label')}" labelFor="widg_calRicCertACEDal" errorFor="appDataricercaCertificatori.dataACEdal" labelId="calRicCertACEDalLbl"
	position="first"  >


<!-- widget calRicCertACEDal -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.dataACEdal" id="widg_calRicCertACEDal"
	disabled="isWidgetDisabled('cpRicercaCertificatori','calRicCertACEDal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatori','calRicCertACEal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatori.calRicCertACEal.label')}" labelFor="widg_calRicCertACEal" errorFor="appDataricercaCertificatori.dataACEal" labelId="calRicCertACEalLbl"
	position="last"  >


<!-- widget calRicCertACEal -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.dataACEal" id="widg_calRicCertACEal"
	disabled="isWidgetDisabled('cpRicercaCertificatori','calRicCertACEal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaCertificatori --></div>

			
	
	<div id="p_pRicercaCertificatoriNav" class="commandPanelBlock"><!-- startFragment:p_pRicercaCertificatoriNav -->
	
	
<div class="commandPanel navigation" id="pRicercaCertificatoriNav">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaCertificatori','bRicerca')" >

	



<!-- widget bRicerca -->
<s:submit name="widg_bRicerca" id="widg_bRicerca" method="handleBRicerca_CLICKED"
	key="cpRicercaCertificatori.bRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaCertificatori','bRicerca')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pRicercaCertificatoriNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRicercaCertificatori --></div>

	

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
