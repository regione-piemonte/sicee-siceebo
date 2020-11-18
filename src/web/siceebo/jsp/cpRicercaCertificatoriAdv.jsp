<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/ricercaCertificatori -->
<!-- pageId:cpRicercaCertificatoriAdv -->

<s:form id="cpRicercaCertificatoriAdv" action="cpRicercaCertificatoriAdv" namespace="/base/ricercaCertificatori" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpRicercaCertificatoriAdv_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','menu')" >

	


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
				<h3><s:text name="cpRicercaCertificatoriAdv.pRicercaCertificatori.label" /></h3>

					
	
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
	

	
	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','tfRicCertMatr')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.tfRicCertMatr.label')}" labelFor="widg_tfRicCertMatr" errorFor="appDataricercaCertificatori.numMatricola" labelId="tfRicCertMatrLbl"
	position="first" colSpan="3" >


<!-- widget tfRicCertMatr -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.numMatricola" id="widg_tfRicCertMatr"
maxlength="6"	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','tfRicCertMatr')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','tfRicCertNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.tfRicCertNome.label')}" labelFor="widg_tfRicCertNome" errorFor="appDataricercaCertificatori.nome" labelId="tfRicCertNomeLbl"
	position="first" colSpan="3" >


<!-- widget tfRicCertNome -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.nome" id="widg_tfRicCertNome"
maxlength="30"	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','tfRicCertNome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','tfRicCertCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.tfRicCertCognome.label')}" labelFor="widg_tfRicCertCognome" errorFor="appDataricercaCertificatori.cognome" labelId="tfRicCertCognomeLbl"
	position="first" colSpan="3" >


<!-- widget tfRicCertCognome -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.cognome" id="widg_tfRicCertCognome"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','tfRicCertCognome')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','calRicDataNascitaDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.calRicDataNascitaDal.label')}" labelFor="widg_calRicDataNascitaDal" errorFor="appDataricercaCertificatori.dataNascitadal" labelId="calRicDataNascitaDalLbl"
	position="first"  >


<!-- widget calRicDataNascitaDal -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.dataNascitadal" id="widg_calRicDataNascitaDal"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','calRicDataNascitaDal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','calRicDataNascitaAl')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.calRicDataNascitaAl.label')}" labelFor="widg_calRicDataNascitaAl" errorFor="appDataricercaCertificatori.dataNascitaal" labelId="calRicDataNascitaAlLbl"
	position="last"  >


<!-- widget calRicDataNascitaAl -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.dataNascitaal" id="widg_calRicDataNascitaAl"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','calRicDataNascitaAl')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','tfRicCertRagSociale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.tfRicCertRagSociale.label')}" labelFor="widg_tfRicCertRagSociale" errorFor="appDataricercaCertificatori.ragSociale" labelId="tfRicCertRagSocialeLbl"
	position="first" colSpan="3" >


<!-- widget tfRicCertRagSociale -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.ragSociale" id="widg_tfRicCertRagSociale"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','tfRicCertRagSociale')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','cbRegione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.cbRegione.label')}" labelFor="widg_cbRegione" errorFor="appDataricercaCertificatori.codRegione" labelId="cbRegioneLbl"
	position="first" colSpan="3" >


<!-- widget cbRegione -->

<s:url id="widg_cbRegioneurlComboBoxValueChange"
   action="/siceebo/cpRicercaCertificatoriAdv!handleCbRegione_VALUE_CHANGED" namespace="/base/ricercaCertificatori"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaCertificatori.codRegione" id="widg_cbRegione"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregione"
	  disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','cbRegione')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbRegione','conferma','%{widg_cbRegioneurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbRegione','conferma','%{widg_cbRegioneurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','cbProvincia')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.cbProvincia.label')}" labelFor="widg_cbProvincia" errorFor="appDataricercaCertificatori.codProvincia" labelId="cbProvinciaLbl"
	position="first" colSpan="3" >


<!-- widget cbProvincia -->

<s:url id="widg_cbProvinciaurlComboBoxValueChange"
   action="/siceebo/cpRicercaCertificatoriAdv!handleCbProvincia_VALUE_CHANGED" namespace="/base/ricercaCertificatori"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataricercaCertificatori.codProvincia" id="widg_cbProvincia"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovince"
	  disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','cbProvincia')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProvincia','conferma','%{widg_cbProvinciaurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','cbComune')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.cbComune.label')}" labelFor="widg_cbComune" errorFor="appDataricercaCertificatori.codComune" labelId="cbComuneLbl"
	position="first"  >


<!-- widget cbComune -->
<s:select name="appDataricercaCertificatori.codComune" id="widg_cbComune"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatacomuni"
	  disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','cbComune')"
	  listKey="cod"
	  listValue="nome"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','tfRicComune')" >

	
<customtag:widgetsPanelColumn 
	position="last" colSpan="2" >


<!-- widget tfRicComune -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.descComune" id="widg_tfRicComune"
maxlength="50"	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','tfRicComune')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','cbTitolo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.cbTitolo.label')}" labelFor="widg_cbTitolo" errorFor="appDataricercaCertificatori.codTitolo" labelId="cbTitoloLbl"
	position="first" colSpan="3" >


<!-- widget cbTitolo -->
<s:select name="appDataricercaCertificatori.codTitolo" id="widg_cbTitolo"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatatitoli"
	  disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','cbTitolo')"
	  listKey="id"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','rbTitoloStudioAllegato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.rbTitoloStudioAllegato.label')}" labelFor="widg_rbTitoloStudioAllegato" errorFor="appDataricercaCertificatori.titoloStudioAllegato" labelId="rbTitoloStudioAllegatoLbl"
	position="first" colSpan="3" >


<!-- widget rbTitoloStudioAllegato -->

	
<div id="appDataricercaCertificatori.titoloStudioAllegato" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbTSASi" name="appDataricercaCertificatori.titoloStudioAllegato"
	list="#{'S':'si'}"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','rbTitoloStudioAllegato')"
	cssClass="radio"
	
	/> <label  for="widg_rbTSASiS"><s:text name="cpRicercaCertificatoriAdv.rbTitoloStudioAllegato.rbTSASi.label" /></label>








<s:radio
	
title=""	
	id="widg_rbTSANo" name="appDataricercaCertificatori.titoloStudioAllegato"
	list="#{'N':'no'}"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','rbTitoloStudioAllegato')"
	cssClass="radio"
	
	/> <label  for="widg_rbTSANoN"><s:text name="cpRicercaCertificatoriAdv.rbTitoloStudioAllegato.rbTSANo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','rbIscrOrdProf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.rbIscrOrdProf.label')}" labelFor="widg_rbIscrOrdProf" errorFor="appDataricercaCertificatori.iscrOrdProf" labelId="rbIscrOrdProfLbl"
	position="first" colSpan="3" >


<!-- widget rbIscrOrdProf -->

	
<div id="appDataricercaCertificatori.iscrOrdProf" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbIOPSi" name="appDataricercaCertificatori.iscrOrdProf"
	list="#{'S':'si'}"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','rbIscrOrdProf')"
	cssClass="radio"
	
	/> <label  for="widg_rbIOPSiS"><s:text name="cpRicercaCertificatoriAdv.rbIscrOrdProf.rbIOPSi.label" /></label>








<s:radio
	
title=""	
	id="widg_rbIOPNo" name="appDataricercaCertificatori.iscrOrdProf"
	list="#{'N':'no'}"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','rbIscrOrdProf')"
	cssClass="radio"
	
	/> <label  for="widg_rbIOPNoN"><s:text name="cpRicercaCertificatoriAdv.rbIscrOrdProf.rbIOPNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','cbTipoCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.cbTipoCorso.label')}" labelFor="widg_cbTipoCorso" errorFor="appDataricercaCertificatori.tipoCorso" labelId="cbTipoCorsoLbl"
	position="first" colSpan="3" >


<!-- widget cbTipoCorso -->
<s:select name="appDataricercaCertificatori.tipoCorso" id="widg_cbTipoCorso"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipoCorsi"
	  disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','cbTipoCorso')"
	  listKey="id"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','calRicCertACEDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.calRicCertACEDal.label')}" labelFor="widg_calRicCertACEDal" errorFor="appDataricercaCertificatori.dataACEdal" labelId="calRicCertACEDalLbl"
	position="first"  >


<!-- widget calRicCertACEDal -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.dataACEdal" id="widg_calRicCertACEDal"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','calRicCertACEDal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','calRicCertACEal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.calRicCertACEal.label')}" labelFor="widg_calRicCertACEal" errorFor="appDataricercaCertificatori.dataACEal" labelId="calRicCertACEalLbl"
	position="last"  >


<!-- widget calRicCertACEal -->
<s:textfield 
	
	
	name="appDataricercaCertificatori.dataACEal" id="widg_calRicCertACEal"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','calRicCertACEal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','rbBloccato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.rbBloccato.label')}" labelFor="widg_rbBloccato" errorFor="appDataricercaCertificatori.bloccato" labelId="rbBloccatoLbl"
	position="first"  >


<!-- widget rbBloccato -->

	
<div id="appDataricercaCertificatori.bloccato" class="radiobuttons ">







<s:radio
	
title=""	
	id="widg_rbBloccatoSi" name="appDataricercaCertificatori.bloccato"
	list="#{'S':'si'}"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','rbBloccato')"
	cssClass="radio"
	
	/> <label  for="widg_rbBloccatoSiS"><s:text name="cpRicercaCertificatoriAdv.rbBloccato.rbBloccatoSi.label" /></label>








<s:radio
	
title=""	
	id="widg_rbBloccatoNo" name="appDataricercaCertificatori.bloccato"
	list="#{'N':'no'}"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','rbBloccato')"
	cssClass="radio"
	
	/> <label  for="widg_rbBloccatoNoN"><s:text name="cpRicercaCertificatoriAdv.rbBloccato.rbBloccatoNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','cbMotivazioneBlocco')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaCertificatoriAdv.cbMotivazioneBlocco.label')}" labelFor="widg_cbMotivazioneBlocco" errorFor="appDataricercaCertificatori.motivazioneBlocco" labelId="cbMotivazioneBloccoLbl"
	position="last"  >


<!-- widget cbMotivazioneBlocco -->
<s:select name="appDataricercaCertificatori.motivazioneBlocco" id="widg_cbMotivazioneBlocco"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoMotivazioniBlocco"
	  disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','cbMotivazioneBlocco')"
	  listKey="id"
	  listValue="descr"
	  
	  />


	
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

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','bNuovaRicerca')" >

	



<!-- widget bNuovaRicerca -->
<s:submit name="widg_bNuovaRicerca" id="widg_bNuovaRicerca" method="handleBNuovaRicerca_CLICKED"
	key="cpRicercaCertificatoriAdv.bNuovaRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','bNuovaRicerca')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRicercaCertificatoriAdv','bRicerca')" >

	



<!-- widget bRicerca -->
<s:submit name="widg_bRicerca" id="widg_bRicerca" method="handleBRicerca_CLICKED"
	key="cpRicercaCertificatoriAdv.bRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRicercaCertificatoriAdv','bRicerca')" />

	


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
