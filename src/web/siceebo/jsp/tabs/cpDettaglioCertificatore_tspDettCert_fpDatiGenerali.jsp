<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpDatiGenerali" class="formPanelBlock"><!-- startFragment:p_fpDatiGenerali -->
		
	
<div class="formPanel" id="fpDatiGenerali">


	
	

	
	
			
	
	<div id="p_wpDatiPersonali" class="widgetsPanelBlock"><!-- startFragment:p_wpDatiPersonali -->
	
	
<h4 class="wpLabel">Dati Personali </h4>
<div class="widgetsPanel" id="wpDatiPersonali">
	
	<customtag:widgetsPanel id="wpDatiPersonaliTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertCognome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertCognome.label')}" labelFor="widg_tfDettCertCognome" errorFor="appDatacertificatoreDett.cognome" labelId="tfDettCertCognomeLbl"
	position="first"  >


<!-- widget tfDettCertCognome -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.cognome" id="widg_tfDettCertCognome"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertCognome')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertNome')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertNome.label')}" labelFor="widg_tfDettCertNome" errorFor="appDatacertificatoreDett.nome" labelId="tfDettCertNomeLbl"
	  >


<!-- widget tfDettCertNome -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.nome" id="widg_tfDettCertNome"
maxlength="30"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertNome')"
	size="40" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertCodFisc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertCodFisc.label')}" labelFor="widg_tfDettCertCodFisc" errorFor="appDatacertificatoreDett.codiceFiscale" labelId="tfDettCertCodFiscLbl"
	position="last"  >


<!-- widget tfDettCertCodFisc -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.codiceFiscale" id="widg_tfDettCertCodFisc"
maxlength="30"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertCodFisc')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertComuneNasc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertComuneNasc.label')}" labelFor="widg_tfDettCertComuneNasc" errorFor="appDatacertificatoreDett.descComuneNascita" labelId="tfDettCertComuneNascLbl"
	  >


<!-- widget tfDettCertComuneNasc -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.descComuneNascita" id="widg_tfDettCertComuneNasc"
maxlength="100"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertComuneNasc')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertDtNasc')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertDtNasc.label')}" labelFor="widg_tfDettCertDtNasc" errorFor="appDatacertificatoreDett.dtNascita" labelId="tfDettCertDtNascLbl"
	position="last"  >


<!-- widget tfDettCertDtNasc -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.dtNascita" id="widg_tfDettCertDtNasc"
maxlength="10"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertDtNasc')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertIndirizzoRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertIndirizzoRes.label')}" labelFor="widg_tfDettCertIndirizzoRes" errorFor="appDatacertificatoreDett.indirizzo" labelId="tfDettCertIndirizzoResLbl"
	position="first"  >


<!-- widget tfDettCertIndirizzoRes -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.indirizzo" id="widg_tfDettCertIndirizzoRes"
maxlength="160"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertIndirizzoRes')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertCivicoRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertCivicoRes.label')}" labelFor="widg_tfDettCertCivicoRes" errorFor="appDatacertificatoreDett.civicoResidenza" labelId="tfDettCertCivicoResLbl"
	  >


<!-- widget tfDettCertCivicoRes -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.civicoResidenza" id="widg_tfDettCertCivicoRes"
maxlength="10"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertCivicoRes')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertCapRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertCapRes.label')}" labelFor="widg_tfDettCertCapRes" errorFor="appDatacertificatoreDett.capResidenza" labelId="tfDettCertCapResLbl"
	position="first"  >


<!-- widget tfDettCertCapRes -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.capResidenza" id="widg_tfDettCertCapRes"
maxlength="10"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertCapRes')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertComuneRes')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertComuneRes.label')}" labelFor="widg_tfDettCertComuneRes" errorFor="appDatacertificatoreDett.descComProv" labelId="tfDettCertComuneResLbl"
	  >


<!-- widget tfDettCertComuneRes -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.descComProv" id="widg_tfDettCertComuneRes"
maxlength="100"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertComuneRes')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDatiPersonali --></div>

			
	
	<div id="p_wpAzienda" class="widgetsPanelBlock"><!-- startFragment:p_wpAzienda -->
	
	
<h4 class="wpLabel">Dati Azienda / Studio professionale </h4>
<div class="widgetsPanel" id="wpAzienda">
	
	<customtag:widgetsPanel id="wpAziendaTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertDenominazioneAz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertDenominazioneAz.label')}" labelFor="widg_tfDettCertDenominazioneAz" errorFor="appDatacertificatoreDett.denominazioneAz" labelId="tfDettCertDenominazioneAzLbl"
	position="first"  >


<!-- widget tfDettCertDenominazioneAz -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.denominazioneAz" id="widg_tfDettCertDenominazioneAz"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertDenominazioneAz')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertPivaAz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertPivaAz.label')}" labelFor="widg_tfDettCertPivaAz" errorFor="appDatacertificatoreDett.pivaAz" labelId="tfDettCertPivaAzLbl"
	  >


<!-- widget tfDettCertPivaAz -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.pivaAz" id="widg_tfDettCertPivaAz"
maxlength="30"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertPivaAz')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertIndirizzoAz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertIndirizzoAz.label')}" labelFor="widg_tfDettCertIndirizzoAz" errorFor="appDatacertificatoreDett.indirizzoAz" labelId="tfDettCertIndirizzoAzLbl"
	position="first"  >


<!-- widget tfDettCertIndirizzoAz -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.indirizzoAz" id="widg_tfDettCertIndirizzoAz"
maxlength="160"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertIndirizzoAz')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertCivicoAz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertCivicoAz.label')}" labelFor="widg_tfDettCertCivicoAz" errorFor="appDatacertificatoreDett.civicoAz" labelId="tfDettCertCivicoAzLbl"
	  >


<!-- widget tfDettCertCivicoAz -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.civicoAz" id="widg_tfDettCertCivicoAz"
maxlength="10"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertCivicoAz')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertCapAz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertCapAz.label')}" labelFor="widg_tfDettCertCapAz" errorFor="appDatacertificatoreDett.capAz" labelId="tfDettCertCapAzLbl"
	position="first"  >


<!-- widget tfDettCertCapAz -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.capAz" id="widg_tfDettCertCapAz"
maxlength="10"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertCapAz')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertComuneAz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertComuneAz.label')}" labelFor="widg_tfDettCertComuneAz" errorFor="appDatacertificatoreDett.comuneAz" labelId="tfDettCertComuneAzLbl"
	  >


<!-- widget tfDettCertComuneAz -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.comuneAz" id="widg_tfDettCertComuneAz"
maxlength="100"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertComuneAz')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertProvAz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertProvAz.label')}" labelFor="widg_tfDettCertProvAz" errorFor="appDatacertificatoreDett.provAz" labelId="tfDettCertProvAzLbl"
	position="last"  >


<!-- widget tfDettCertProvAz -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.provAz" id="widg_tfDettCertProvAz"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertProvAz')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpAzienda --></div>

			
	
	<div id="p_wpContatti" class="widgetsPanelBlock"><!-- startFragment:p_wpContatti -->
	
	
<h4 class="wpLabel">Contatti </h4>
<div class="widgetsPanel" id="wpContatti">
	
	<customtag:widgetsPanel id="wpContattiTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertTelefono')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertTelefono.label')}" labelFor="widg_tfDettCertTelefono" errorFor="appDatacertificatoreDett.telefono" labelId="tfDettCertTelefonoLbl"
	position="first"  >


<!-- widget tfDettCertTelefono -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.telefono" id="widg_tfDettCertTelefono"
maxlength="30"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertTelefono')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertCell')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertCell.label')}" labelFor="widg_tfDettCertCell" errorFor="appDatacertificatoreDett.cell" labelId="tfDettCertCellLbl"
	  >


<!-- widget tfDettCertCell -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.cell" id="widg_tfDettCertCell"
maxlength="30"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertCell')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertEmail')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertEmail.label')}" labelFor="widg_tfDettCertEmail" errorFor="appDatacertificatoreDett.email" labelId="tfDettCertEmailLbl"
	position="first"  >


<!-- widget tfDettCertEmail -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.email" id="widg_tfDettCertEmail"
maxlength="70"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertEmail')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertEmailpec')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertEmailpec.label')}" labelFor="widg_tfDettCertEmailpec" errorFor="appDatacertificatoreDett.emailpec" labelId="tfDettCertEmailpecLbl"
	  >


<!-- widget tfDettCertEmailpec -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.emailpec" id="widg_tfDettCertEmailpec"
maxlength="70"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertEmailpec')"
	size="30" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpContatti --></div>

			
	
	<div id="p_pDatiRegistrazioneNav" class="commandPanelBlock"><!-- startFragment:p_pDatiRegistrazioneNav -->
	
	
<div class="commandPanel navigation" id="pDatiRegistrazioneNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioCertificatore','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpDettaglioCertificatore.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDatiRegistrazioneNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDatiGenerali --></div>
