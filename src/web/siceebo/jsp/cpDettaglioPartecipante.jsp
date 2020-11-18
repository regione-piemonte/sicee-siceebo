<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/entiFormativi -->
<!-- pageId:cpDettaglioPartecipante -->

<s:form id="cpDettaglioPartecipante" action="cpDettaglioPartecipante" namespace="/base/entiFormativi" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioPartecipante_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpDettaglioPartecipante','menu')" >

	


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
				<h3><s:text name="cpDettaglioPartecipante.pDettaglioPartecipante.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpDettaglioPartecipante" class="formPanelBlock"><!-- startFragment:p_fpDettaglioPartecipante -->
		
	
<div class="formPanel" id="fpDettaglioPartecipante">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpLabelCorso" class="widgetsPanelBlock"><!-- startFragment:p_wpLabelCorso -->
	
	

<div class="widgetsPanel" id="wpLabelCorso">
	
	<customtag:widgetsPanel id="wpLabelCorsoTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','lblTitoloCorso2')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioPartecipante.lblTitoloCorso2.label')}" labelFor="widg_lblTitoloCorso2" errorFor="appDatadettaglioCorso.titoloBold" labelId="lblTitoloCorso2Lbl"  position="first" >


<!-- widget lblTitoloCorso2 -->
<s:property value="appDatadettaglioCorso.titoloBold" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','lblSedeOperativa2')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioPartecipante.lblSedeOperativa2.label')}" labelFor="widg_lblSedeOperativa2" errorFor="appDataenteFormativo.sedeCompleta" labelId="lblSedeOperativa2Lbl"  position="last" >


<!-- widget lblSedeOperativa2 -->
<s:property value="appDataenteFormativo.sedeCompleta" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpLabelCorso --></div>

			
	
	<div id="p_wpDettaglioPartecipante" class="widgetsPanelBlock"><!-- startFragment:p_wpDettaglioPartecipante -->
	
	
<h4 class="wpLabel">Partecipante Corso </h4>
<div class="widgetsPanel" id="wpDettaglioPartecipante">
	
	<customtag:widgetsPanel id="wpDettaglioPartecipanteTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfCodiceFiscale')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfCodiceFiscale.label')}" labelFor="widg_tfCodiceFiscale" errorFor="appDatadettaglioPartecipante.codiceFiscale" labelId="tfCodiceFiscaleLbl"
	position="first"  >


<!-- widget tfCodiceFiscale -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.codiceFiscale" id="widg_tfCodiceFiscale"
maxlength="30"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfCodiceFiscale')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','bCercaCfCertificatori')" >

	
<customtag:widgetsPanelColumn colSpan="2" >


<!-- widget bCercaCfCertificatori -->
<s:submit name="widg_bCercaCfCertificatori" id="widg_bCercaCfCertificatori" method="handleBCercaCfCertificatori_CLICKED"
	key="cpDettaglioPartecipante.bCercaCfCertificatori.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioPartecipante','bCercaCfCertificatori')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','cbListaCf')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="" labelFor="widg_cbListaCf" errorFor="appDatacfSel" labelId="cbListaCfLbl"
	position="first"  >


<!-- widget cbListaCf -->

<s:url id="widg_cbListaCfurlComboBoxValueChange"
   action="/siceebo/cpDettaglioPartecipante!handleCbListaCf_VALUE_CHANGED" namespace="/base/entiFormativi"  
   includeParams="all" portletUrlType="action" 
/>
<s:select name="appDatacfSel" id="widg_cbListaCf"
	 
	

		title=" - Attenzione. Dopo aver selezionato un valore, la pagina verra' aggiornata automaticamente"
			
	  headerKey="" headerValue="" 
	  list="appDatalistaCf"
	  disabled="isWidgetDisabled('cpDettaglioPartecipante','cbListaCf')"
	  listKey="idCertificatore"
	  listValue="codiceFiscale"
	  onclick="onCBClick(this,'confermacbListaCf','conferma','%{widg_cbListaCfurlComboBoxValueChange}')" onfocus="inFocus(this)" onblur="lostFocus(this,'confermacbListaCf','conferma','%{widg_cbListaCfurlComboBoxValueChange}')" 
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfCognome.label')}" labelFor="widg_tfCognome" errorFor="appDatadettaglioPartecipante.cognome" labelId="tfCognomeLbl"
	position="first"  >


<!-- widget tfCognome -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.cognome" id="widg_tfCognome"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfCognome')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfNome.label')}" labelFor="widg_tfNome" errorFor="appDatadettaglioPartecipante.nome" labelId="tfNomeLbl"
	  >


<!-- widget tfNome -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.nome" id="widg_tfNome"
maxlength="30"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfNome')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfLuogoNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfLuogoNascita.label')}" labelFor="widg_tfLuogoNascita" errorFor="appDatadettaglioPartecipante.luogoNascita" labelId="tfLuogoNascitaLbl"
	position="first"  >


<!-- widget tfLuogoNascita -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.luogoNascita" id="widg_tfLuogoNascita"
maxlength="100"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfLuogoNascita')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','calDataNascita')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.calDataNascita.label')}" labelFor="widg_calDataNascita" errorFor="appDatadettaglioPartecipante.dataNascita" labelId="calDataNascitaLbl"
	  >


<!-- widget calDataNascita -->
<s:textfield 
	
	
	name="appDatadettaglioPartecipante.dataNascita" id="widg_calDataNascita"
	disabled="isWidgetDisabled('cpDettaglioPartecipante','calDataNascita')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','cbTipoIstruzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.cbTipoIstruzione.label')}" labelFor="widg_cbTipoIstruzione" errorFor="appDatadettaglioPartecipante.fkTipoIstruzione" labelId="cbTipoIstruzioneLbl"
	position="first"  >


<!-- widget cbTipoIstruzione -->
<s:select name="appDatadettaglioPartecipante.fkTipoIstruzione" id="widg_cbTipoIstruzione"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatalistaTipoIstruzione"
	  disabled="isWidgetDisabled('cpDettaglioPartecipante','cbTipoIstruzione')"
	  listKey="idTipoIstruzione"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfNumCertificatore')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfNumCertificatore.label')}" labelFor="widg_tfNumCertificatore" errorFor="appDatadettaglioPartecipante.numCertificatore" labelId="tfNumCertificatoreLbl"
	  >


<!-- widget tfNumCertificatore -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.numCertificatore" id="widg_tfNumCertificatore"
maxlength="10"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfNumCertificatore')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfAlbo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfAlbo.label')}" labelFor="widg_tfAlbo" errorFor="appDatadettaglioPartecipante.albo" labelId="tfAlboLbl"
	position="first"  >


<!-- widget tfAlbo -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.albo" id="widg_tfAlbo"
maxlength="200"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfAlbo')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfProvAlbo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfProvAlbo.label')}" labelFor="widg_tfProvAlbo" errorFor="appDatadettaglioPartecipante.descProvAlbo" labelId="tfProvAlboLbl"
	  >


<!-- widget tfProvAlbo -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.descProvAlbo" id="widg_tfProvAlbo"
maxlength="30"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfProvAlbo')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfNumIscrAlbo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfNumIscrAlbo.label')}" labelFor="widg_tfNumIscrAlbo" errorFor="appDatadettaglioPartecipante.numIscrAlbo" labelId="tfNumIscrAlboLbl"
	position="first"  >


<!-- widget tfNumIscrAlbo -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.numIscrAlbo" id="widg_tfNumIscrAlbo"
maxlength="20"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfNumIscrAlbo')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','calDataIscrAlbo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.calDataIscrAlbo.label')}" labelFor="widg_calDataIscrAlbo" errorFor="appDatadettaglioPartecipante.dataIscrAlbo" labelId="calDataIscrAlboLbl"
	  >


<!-- widget calDataIscrAlbo -->
<s:textfield 
	
	
	name="appDatadettaglioPartecipante.dataIscrAlbo" id="widg_calDataIscrAlbo"
	disabled="isWidgetDisabled('cpDettaglioPartecipante','calDataIscrAlbo')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfPercFreq')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfPercFreq.label')}" labelFor="widg_tfPercFreq" errorFor="appDatadettaglioPartecipante.percFreq" labelId="tfPercFreqLbl"
	position="first"  >


<!-- widget tfPercFreq -->
<s:textfield 
	
	
	name="appDatadettaglioPartecipante.percFreq" id="widg_tfPercFreq"
maxlength="10"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfPercFreq')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','calDataEsame')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.calDataEsame.label')}" labelFor="widg_calDataEsame" errorFor="appDatadettaglioPartecipante.dataEsame" labelId="calDataEsameLbl"
	position="first"  >


<!-- widget calDataEsame -->
<s:textfield 
	
	
	name="appDatadettaglioPartecipante.dataEsame" id="widg_calDataEsame"
	disabled="isWidgetDisabled('cpDettaglioPartecipante','calDataEsame')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfVotoEsame')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfVotoEsame.label')}" labelFor="widg_tfVotoEsame" errorFor="appDatadettaglioPartecipante.votoEsame" labelId="tfVotoEsameLbl"
	  >


<!-- widget tfVotoEsame -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.votoEsame" id="widg_tfVotoEsame"
maxlength="20"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfVotoEsame')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','cbEsitoEsame')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.cbEsitoEsame.label')}" labelFor="widg_cbEsitoEsame" errorFor="appDatadettaglioPartecipante.esitoEsame" labelId="cbEsitoEsameLbl"
	position="first"  >


<!-- widget cbEsitoEsame -->
<s:select name="appDatadettaglioPartecipante.esitoEsame" id="widg_cbEsitoEsame"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDatalistaEsito"
	  disabled="isWidgetDisabled('cpDettaglioPartecipante','cbEsitoEsame')"
	  listKey="idEsito"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfLuogoEsame')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfLuogoEsame.label')}" labelFor="widg_tfLuogoEsame" errorFor="appDatadettaglioPartecipante.luogoEsame" labelId="tfLuogoEsameLbl"
	  >


<!-- widget tfLuogoEsame -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.luogoEsame" id="widg_tfLuogoEsame"
maxlength="160"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfLuogoEsame')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfTelefono')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfTelefono.label')}" labelFor="widg_tfTelefono" errorFor="appDatadettaglioPartecipante.telefono" labelId="tfTelefonoLbl"
	position="first"  >


<!-- widget tfTelefono -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.telefono" id="widg_tfTelefono"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfTelefono')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','tfEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.tfEmail.label')}" labelFor="widg_tfEmail" errorFor="appDatadettaglioPartecipante.email" labelId="tfEmailLbl"
	  >


<!-- widget tfEmail -->
<s:textfield 
	
title=""	
	name="appDatadettaglioPartecipante.email" id="widg_tfEmail"
maxlength="70"	disabled="isWidgetDisabled('cpDettaglioPartecipante','tfEmail')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioPartecipante.taNote.label')}" labelFor="widg_taNote" errorFor="appDatadettaglioPartecipante.note" labelId="taNoteLbl"
	position="first" colSpan="3" >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDatadettaglioPartecipante.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpDettaglioPartecipante','taNote')"
	rows="5"
	cols="100"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','bStampaAttestato')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="first">


<!-- widget bStampaAttestato -->
<s:submit name="widg_bStampaAttestato" id="widg_bStampaAttestato" method="handleBStampaAttestato_CLICKED"
	key="cpDettaglioPartecipante.bStampaAttestato.label" cssClass="buttonWidget showReport"
	disabled="isWidgetDisabled('cpDettaglioPartecipante','bStampaAttestato')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','txtNotaA')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioPartecipante.txtNotaA.label')}" labelFor="widg_txtNotaA" errorFor="widg_txtNotaA" labelId="txtNotaALbl" colSpan="5" position="first" >


<!-- widget txtNotaA -->
<s:text name="cpDettaglioPartecipante.txtNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioPartecipante','txtNotaB')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioPartecipante.txtNotaB.label')}" labelFor="widg_txtNotaB" errorFor="widg_txtNotaB" labelId="txtNotaBLbl" colSpan="5" position="first" >


<!-- widget txtNotaB -->
<s:text name="cpDettaglioPartecipante.txtNotaB.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettaglioPartecipante --></div>

			
	
	<div id="p_pDatiRegistrazioneNav" class="commandPanelBlock"><!-- startFragment:p_pDatiRegistrazioneNav -->
	
	
<div class="commandPanel navigation" id="pDatiRegistrazioneNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioPartecipante','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpDettaglioPartecipante.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioPartecipante','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioPartecipante','bSalva')" >

	



<!-- widget bSalva -->
<s:submit name="widg_bSalva" id="widg_bSalva" method="handleBSalva_CLICKED"
	key="cpDettaglioPartecipante.bSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioPartecipante','bSalva')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDatiRegistrazioneNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDettaglioPartecipante --></div>

	

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
