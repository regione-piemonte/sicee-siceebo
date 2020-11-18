<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/entiFormativi -->
<!-- pageId:cpDatiRegistrazione -->

<s:form id="cpDatiRegistrazione" action="cpDatiRegistrazione" namespace="/base/entiFormativi" method="post" enctype="multipart/form-data">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDatiRegistrazione_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpDatiRegistrazione','menu')" >

	


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
				<h3><s:text name="cpDatiRegistrazione.pDatiRegistrazione.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpDatiRegistrazione" class="formPanelBlock"><!-- startFragment:p_fpDatiRegistrazione -->
		
	
<div class="formPanel" id="fpDatiRegistrazione">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpDatiRegistrazione1" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiRegistrazione1 -->
	
	
<h4 class="wpLabel">Ente e/o Soggetto formativo: Dati Anagrafici </h4>
<div class="widgetsPanel" id="wpDatiRegistrazione1">
	
	<customtag:widgetsPanel id="wpDatiRegistrazione1Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDatiRegistrazione','cbTipoSoggetto')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.cbTipoSoggetto.label')}" labelFor="widg_cbTipoSoggetto" errorFor="appDataenteFormativo.tipoSoggetto" labelId="cbTipoSoggettoLbl"
	position="first"  >


<!-- widget cbTipoSoggetto -->

<s:url id="widg_cbTipoSoggettourlComboBoxValueChange"
   action="/siceebo/cpDatiRegistrazione!handleCbTipoSoggetto_VALUE_CHANGED" namespace="/base/entiFormativi"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataenteFormativo.tipoSoggetto" id="widg_cbTipoSoggetto"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatatipoEnti"
	  disabled="isWidgetDisabled('cpDatiRegistrazione','cbTipoSoggetto')"
	  listKey="id"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbTipoSoggetto','conferma','%{widg_cbTipoSoggettourlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbTipoSoggetto','conferma','%{widg_cbTipoSoggettourlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfRagSociale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfRagSociale.label')}" labelFor="widg_tfRagSociale" errorFor="appDataenteFormativo.denominazione" labelId="tfRagSocialeLbl"
	position="first"  >


<!-- widget tfRagSociale -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.denominazione" id="widg_tfRagSociale"
maxlength="100"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfRagSociale')"
	size="80" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfPIVA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfPIVA.label')}" labelFor="widg_tfPIVA" errorFor="appDataenteFormativo.piva" labelId="tfPIVALbl"
	position="first"  >


<!-- widget tfPIVA -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.piva" id="widg_tfPIVA"
maxlength="11"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfPIVA')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiRegistrazione1 --></div>

			
	
	<div id="p_wpSelezioneSO" class="widgetsPanelBlock"><!-- startFragment:p_wpSelezioneSO -->
	
	
<h4 class="wpLabel">Indirizzo sede di riferimento </h4>
<div class="widgetsPanel" id="wpSelezioneSO">
	
	<customtag:widgetsPanel id="wpSelezioneSOTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDatiRegistrazione','cbSelezioneSO')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.cbSelezioneSO.label')}" labelFor="widg_cbSelezioneSO" errorFor="appDataidSedeOperativaSelezionata" labelId="cbSelezioneSOLbl"
	position="first"  >


<!-- widget cbSelezioneSO -->

<s:url id="widg_cbSelezioneSOurlComboBoxValueChange"
   action="/siceebo/cpDatiRegistrazione!handleCbSelezioneSO_VALUE_CHANGED" namespace="/base/entiFormativi"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataidSedeOperativaSelezionata" id="widg_cbSelezioneSO"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataelencoSediOperative"
	  disabled="isWidgetDisabled('cpDatiRegistrazione','cbSelezioneSO')"
	  listKey="id"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbSelezioneSO','conferma','%{widg_cbSelezioneSOurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbSelezioneSO','conferma','%{widg_cbSelezioneSOurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpSelezioneSO --></div>

			
	
	<div id="p_wpDatiRegistrazione2" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiRegistrazione2 -->
	
	

<div class="widgetsPanel" id="wpDatiRegistrazione2">
	
	<customtag:widgetsPanel id="wpDatiRegistrazione2Tbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfCodFormReg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfCodFormReg.label')}" labelFor="widg_tfCodFormReg" errorFor="appDataenteFormativo.codFormReg" labelId="tfCodFormRegLbl"
	position="first"  >


<!-- widget tfCodFormReg -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.codFormReg" id="widg_tfCodFormReg"
maxlength="20"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfCodFormReg')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','cbReg')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.cbReg.label')}" labelFor="widg_cbReg" errorFor="appDataenteFormativo.idRegione" labelId="cbRegLbl"
	position="first"  >


<!-- widget cbReg -->

<s:url id="widg_cbRegurlComboBoxValueChange"
   action="/siceebo/cpDatiRegistrazione!handleCbReg_VALUE_CHANGED" namespace="/base/entiFormativi"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataenteFormativo.idRegione" id="widg_cbReg"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataregione"
	  disabled="isWidgetDisabled('cpDatiRegistrazione','cbReg')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbReg','conferma','%{widg_cbRegurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbReg','conferma','%{widg_cbRegurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','cbProv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.cbProv.label')}" labelFor="widg_cbProv" errorFor="appDataenteFormativo.idProv" labelId="cbProvLbl"
	position="first"  >


<!-- widget cbProv -->

<s:url id="widg_cbProvurlComboBoxValueChange"
   action="/siceebo/cpDatiRegistrazione!handleCbProv_VALUE_CHANGED" namespace="/base/entiFormativi"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataenteFormativo.idProv" id="widg_cbProv"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDataprovince"
	  disabled="isWidgetDisabled('cpDatiRegistrazione','cbProv')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbProv','conferma','%{widg_cbProvurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbProv','conferma','%{widg_cbProvurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','cbCom')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.cbCom.label')}" labelFor="widg_cbCom" errorFor="appDataenteFormativo.idComune" labelId="cbComLbl"
	position="first"  >


<!-- widget cbCom -->

<s:url id="widg_cbComurlComboBoxValueChange"
   action="/siceebo/cpDatiRegistrazione!handleCbCom_VALUE_CHANGED" namespace="/base/entiFormativi"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDataenteFormativo.idComune" id="widg_cbCom"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatacomuni"
	  disabled="isWidgetDisabled('cpDatiRegistrazione','cbCom')"
	  listKey="cod"
	  listValue="nome"
	  onclick="onCBClick(this,'confermacbCom','conferma','%{widg_cbComurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbCom','conferma','%{widg_cbComurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfIndirizzo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfIndirizzo.label')}" labelFor="widg_tfIndirizzo" errorFor="appDataenteFormativo.descIndirizzo" labelId="tfIndirizzoLbl"
	position="first"  >


<!-- widget tfIndirizzo -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.descIndirizzo" id="widg_tfIndirizzo"
maxlength="160"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfIndirizzo')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','vVerifInd')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget vVerifInd -->
<s:submit name="widg_vVerifInd" id="widg_vVerifInd" method="handleVVerifInd_CLICKED"
	key="cpDatiRegistrazione.vVerifInd.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDatiRegistrazione','vVerifInd')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','cbSceltaInd')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_cbSceltaInd" errorFor="appDatasuggestIndirizzoCode" labelId="cbSceltaIndLbl"
	position="last"  >


<!-- widget cbSceltaInd -->

<s:url id="widg_cbSceltaIndurlComboBoxValueChange"
   action="/siceebo/cpDatiRegistrazione!handleCbSceltaInd_VALUE_CHANGED" namespace="/base/entiFormativi"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatasuggestIndirizzoCode" id="widg_cbSceltaInd"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatasuggestIndirizzo"
	  disabled="isWidgetDisabled('cpDatiRegistrazione','cbSceltaInd')"
	  listKey="cod"
	  listValue="descr"
	  onclick="onCBClick(this,'confermacbSceltaInd','conferma','%{widg_cbSceltaIndurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbSceltaInd','conferma','%{widg_cbSceltaIndurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfNumCivico')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfNumCivico.label')}" labelFor="widg_tfNumCivico" errorFor="appDataenteFormativo.numCivico" labelId="tfNumCivicoLbl"
	position="first"  >


<!-- widget tfNumCivico -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.numCivico" id="widg_tfNumCivico"
maxlength="10"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfNumCivico')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfCap')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfCap.label')}" labelFor="widg_tfCap" errorFor="appDataenteFormativo.cap" labelId="tfCapLbl"
	  >


<!-- widget tfCap -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.cap" id="widg_tfCap"
maxlength="5"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfCap')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiRegistrazione2 --></div>

			
	
	<div id="p_wpContatti" class="widgetsPanelBlock"><!-- startFragment:p_wpContatti -->
	
	
<h4 class="wpLabel">Contatti </h4>
<div class="widgetsPanel" id="wpContatti">
	
	<customtag:widgetsPanel id="wpContattiTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfTelefono')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfTelefono.label')}" labelFor="widg_tfTelefono" errorFor="appDataenteFormativo.telefono" labelId="tfTelefonoLbl"
	position="first"  >


<!-- widget tfTelefono -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.telefono" id="widg_tfTelefono"
maxlength="20"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfTelefono')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfCell')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfCell.label')}" labelFor="widg_tfCell" errorFor="appDataenteFormativo.cell" labelId="tfCellLbl"
	position="first"  >


<!-- widget tfCell -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.cell" id="widg_tfCell"
maxlength="20"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfCell')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfEmail.label')}" labelFor="widg_tfEmail" errorFor="appDataenteFormativo.email" labelId="tfEmailLbl"
	position="first"  >


<!-- widget tfEmail -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.email" id="widg_tfEmail"
maxlength="70"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfEmail')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfEmailPEC')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfEmailPEC.label')}" labelFor="widg_tfEmailPEC" errorFor="appDataenteFormativo.emailPec" labelId="tfEmailPECLbl"
	position="first"  >


<!-- widget tfEmailPEC -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.emailPec" id="widg_tfEmailPEC"
maxlength="70"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfEmailPEC')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','tfSitoWeb')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.tfSitoWeb.label')}" labelFor="widg_tfSitoWeb" errorFor="appDataenteFormativo.sitoWeb" labelId="tfSitoWebLbl"
	position="first"  >


<!-- widget tfSitoWeb -->
<s:textfield 
	
title=""	
	name="appDataenteFormativo.sitoWeb" id="widg_tfSitoWeb"
maxlength="50"	disabled="isWidgetDisabled('cpDatiRegistrazione','tfSitoWeb')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpContatti --></div>

			
	
	<div id="p_wpLogo" class="widgetsPanelBlock"><!-- startFragment:p_wpLogo -->
	
	
<h4 class="wpLabel">Logo dell'Ente / Soggetto formativo </h4>
<div class="widgetsPanel" id="wpLogo">
	
	<customtag:widgetsPanel id="wpLogoTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDatiRegistrazione','fileImmagineLogo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDatiRegistrazione.fileImmagineLogo.label')}" labelFor="widg_fileImmagineLogo" errorFor="widg_fileImmagineLogo" labelId="fileImmagineLogoLbl"
	position="first"  >


<s:file 
	
	
	name="widg_fileImmagineLogo" id="widg_fileImmagineLogo"
	disabled="isWidgetDisabled('cpDatiRegistrazione','fileImmagineLogo')"
	
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','btnCaricaLogo')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget btnCaricaLogo -->
<s:submit name="widg_btnCaricaLogo" id="widg_btnCaricaLogo" method="handleBtnCaricaLogo_CLICKED"
	key="cpDatiRegistrazione.btnCaricaLogo.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDatiRegistrazione','btnCaricaLogo')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','txtPresenzaLogo')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_txtPresenzaLogo" errorFor="appDataenteFormativo.presenzaLogo" labelId="txtPresenzaLogoLbl"  position="last" >


<!-- widget txtPresenzaLogo -->
<s:property value="appDataenteFormativo.presenzaLogo" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','txtNotaNull')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="" labelFor="widg_txtNotaNull" errorFor="widg_txtNotaNull" labelId="txtNotaNullLbl"  position="first" >


<!-- widget txtNotaNull -->
<s:text name="cpDatiRegistrazione.txtNotaNull.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','wpLogo_2_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget wpLogo_2_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','wpLogo_2_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget wpLogo_2_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDatiRegistrazione','txtNotaA')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDatiRegistrazione.txtNotaA.label')}" labelFor="widg_txtNotaA" errorFor="widg_txtNotaA" labelId="txtNotaALbl" colSpan="5" position="first" >


<!-- widget txtNotaA -->
<s:text name="cpDatiRegistrazione.txtNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLogo --></div>

			
	
	<div id="p_pDatiRegistrazioneNav" class="commandPanelBlock"><!-- startFragment:p_pDatiRegistrazioneNav -->
	
	
<div class="commandPanel navigation" id="pDatiRegistrazioneNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDatiRegistrazione','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpDatiRegistrazione.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDatiRegistrazione','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDatiRegistrazione','bSalva')" >

	



<!-- widget bSalva -->
<s:submit name="widg_bSalva" id="widg_bSalva" method="handleBSalva_CLICKED"
	key="cpDatiRegistrazione.bSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDatiRegistrazione','bSalva')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDatiRegistrazioneNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiRegistrazione --></div>

	

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
