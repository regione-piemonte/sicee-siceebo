<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpNewApe" class="formPanelBlock"><!-- startFragment:p_fpNewApe -->
		
	
<div class="formPanel" id="fpNewApe">


	
	

	
	
			
	
	<div id="p_wpRicercaAce05ParamOR" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAce05ParamOR -->
	
	

<div class="widgetsPanel" id="wpRicercaAce05ParamOR">
	
	<customtag:widgetsPanel id="wpRicercaAce05ParamORTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','ptNotaParametri05OR')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget ptNotaParametri05OR -->
<s:text name="cpRicercaAce.ptNotaParametri05OR.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','cbFlgEdifE0')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbFlgEdifE0.label')}" labelFor="widg_cbFlgEdifE0" errorFor="appDataricercaAce.flgEdifE0" labelId="cbFlgEdifE0Lbl"
	position="first" colSpan="3" >


<!-- widget cbFlgEdifE0 -->
<s:checkbox 
	
	
	name="appDataricercaAce.flgEdifE0" id="widg_cbFlgEdifE0"
	disabled="isWidgetDisabled('cpRicercaAce','cbFlgEdifE0')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaAce','cbFlgEdifE0')" >
	<s:hidden name="__checkbox_appDataricercaAce.flgEdifE0" id="__checkbox_widg_cbFlgEdifE0" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAce','tfEpglNrenGlobaleDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfEpglNrenGlobaleDa.label')}" labelFor="widg_tfEpglNrenGlobaleDa" errorFor="appDataricercaAce.epglNrenGlobaleDa" labelId="tfEpglNrenGlobaleDaLbl"
	position="first"  >


<!-- widget tfEpglNrenGlobaleDa -->
<s:textfield 
	
	
	name="appDataricercaAce.epglNrenGlobaleDa" id="widg_tfEpglNrenGlobaleDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfEpglNrenGlobaleDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfEpglNrenGlobaleA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfEpglNrenGlobaleA.label')}" labelFor="widg_tfEpglNrenGlobaleA" errorFor="appDataricercaAce.EpglNrenGlobaleA" labelId="tfEpglNrenGlobaleALbl"
	position="last"  >


<!-- widget tfEpglNrenGlobaleA -->
<s:textfield 
	
	
	name="appDataricercaAce.EpglNrenGlobaleA" id="widg_tfEpglNrenGlobaleA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfEpglNrenGlobaleA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfEpglRenGlobaleDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfEpglRenGlobaleDa.label')}" labelFor="widg_tfEpglRenGlobaleDa" errorFor="appDataricercaAce.epglRenGlobaleDa" labelId="tfEpglRenGlobaleDaLbl"
	position="first"  >


<!-- widget tfEpglRenGlobaleDa -->
<s:textfield 
	
	
	name="appDataricercaAce.epglRenGlobaleDa" id="widg_tfEpglRenGlobaleDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfEpglRenGlobaleDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfEpglRenGlobaleA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfEpglRenGlobaleA.label')}" labelFor="widg_tfEpglRenGlobaleA" errorFor="appDataricercaAce.epglRenGlobaleA" labelId="tfEpglRenGlobaleALbl"
	position="last"  >


<!-- widget tfEpglRenGlobaleA -->
<s:textfield 
	
	
	name="appDataricercaAce.epglRenGlobaleA" id="widg_tfEpglRenGlobaleA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfEpglRenGlobaleA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfEmissioniCo2Da')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfEmissioniCo2Da.label')}" labelFor="widg_tfEmissioniCo2Da" errorFor="appDataricercaAce.emissioniCo2Da" labelId="tfEmissioniCo2DaLbl"
	position="first"  >


<!-- widget tfEmissioniCo2Da -->
<s:textfield 
	
	
	name="appDataricercaAce.emissioniCo2Da" id="widg_tfEmissioniCo2Da"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfEmissioniCo2Da')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfEmissioniCo2A')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfEmissioniCo2A.label')}" labelFor="widg_tfEmissioniCo2A" errorFor="appDataricercaAce.emissioniCo2A" labelId="tfEmissioniCo2ALbl"
	position="last"  >


<!-- widget tfEmissioniCo2A -->
<s:textfield 
	
	
	name="appDataricercaAce.emissioniCo2A" id="widg_tfEmissioniCo2A"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfEmissioniCo2A')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSupRaffrescataDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSupRaffrescataDa.label')}" labelFor="widg_tfSupRaffrescataDa" errorFor="appDataricercaAce.supRaffrescataDa" labelId="tfSupRaffrescataDaLbl"
	position="first"  >


<!-- widget tfSupRaffrescataDa -->
<s:textfield 
	
	
	name="appDataricercaAce.supRaffrescataDa" id="widg_tfSupRaffrescataDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfSupRaffrescataDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSupRaffrescataA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSupRaffrescataA.label')}" labelFor="widg_tfSupRaffrescataA" errorFor="appDataricercaAce.supRaffrescataA" labelId="tfSupRaffrescataALbl"
	position="last"  >


<!-- widget tfSupRaffrescataA -->
<s:textfield 
	
	
	name="appDataricercaAce.supRaffrescataA" id="widg_tfSupRaffrescataA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfSupRaffrescataA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSupRiscaldataDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSupRiscaldataDa.label')}" labelFor="widg_tfSupRiscaldataDa" errorFor="appDataricercaAce.supRiscaldataDa" labelId="tfSupRiscaldataDaLbl"
	position="first"  >


<!-- widget tfSupRiscaldataDa -->
<s:textfield 
	
	
	name="appDataricercaAce.supRiscaldataDa" id="widg_tfSupRiscaldataDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfSupRiscaldataDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSupRiscaldataA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSupRiscaldataA.label')}" labelFor="widg_tfSupRiscaldataA" errorFor="appDataricercaAce.supRiscaldataA" labelId="tfSupRiscaldataALbl"
	position="last"  >


<!-- widget tfSupRiscaldataA -->
<s:textfield 
	
	
	name="appDataricercaAce.supRiscaldataA" id="widg_tfSupRiscaldataA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfSupRiscaldataA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfVolLordoRaffrescatoDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfVolLordoRaffrescatoDa.label')}" labelFor="widg_tfVolLordoRaffrescatoDa" errorFor="appDataricercaAce.volLordoRaffrescatoDa" labelId="tfVolLordoRaffrescatoDaLbl"
	position="first"  >


<!-- widget tfVolLordoRaffrescatoDa -->
<s:textfield 
	
	
	name="appDataricercaAce.volLordoRaffrescatoDa" id="widg_tfVolLordoRaffrescatoDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfVolLordoRaffrescatoDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfVolLordoRaffrescatoA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfVolLordoRaffrescatoA.label')}" labelFor="widg_tfVolLordoRaffrescatoA" errorFor="appDataricercaAce.volLordoRaffrescatoA" labelId="tfVolLordoRaffrescatoALbl"
	position="last"  >


<!-- widget tfVolLordoRaffrescatoA -->
<s:textfield 
	
	
	name="appDataricercaAce.volLordoRaffrescatoA" id="widg_tfVolLordoRaffrescatoA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfVolLordoRaffrescatoA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfVolLordoRiscaldatoDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfVolLordoRiscaldatoDa.label')}" labelFor="widg_tfVolLordoRiscaldatoDa" errorFor="appDataricercaAce.volLordoRiscaldatoDa" labelId="tfVolLordoRiscaldatoDaLbl"
	position="first"  >


<!-- widget tfVolLordoRiscaldatoDa -->
<s:textfield 
	
	
	name="appDataricercaAce.volLordoRiscaldatoDa" id="widg_tfVolLordoRiscaldatoDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfVolLordoRiscaldatoDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfVolLordoRiscaldatoA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfVolLordoRiscaldatoA.label')}" labelFor="widg_tfVolLordoRiscaldatoA" errorFor="appDataricercaAce.volLordoRiscaldatoA" labelId="tfVolLordoRiscaldatoALbl"
	position="last"  >


<!-- widget tfVolLordoRiscaldatoA -->
<s:textfield 
	
	
	name="appDataricercaAce.volLordoRiscaldatoA" id="widg_tfVolLordoRiscaldatoA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfVolLordoRiscaldatoA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfEphDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfEphDa.label')}" labelFor="widg_tfEphDa" errorFor="appDataricercaAce.ephDa" labelId="tfEphDaLbl"
	position="first"  >


<!-- widget tfEphDa -->
<s:textfield 
	
	
	name="appDataricercaAce.ephDa" id="widg_tfEphDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfEphDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfEphA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfEphA.label')}" labelFor="widg_tfEphA" errorFor="appDataricercaAce.ephA" labelId="tfEphALbl"
	position="last"  >


<!-- widget tfEphA -->
<s:textfield 
	
	
	name="appDataricercaAce.ephA" id="widg_tfEphA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfEphA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfAsolAsupDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfAsolAsupDa.label')}" labelFor="widg_tfAsolAsupDa" errorFor="appDataricercaAce.asolAsupDa" labelId="tfAsolAsupDaLbl"
	position="first"  >


<!-- widget tfAsolAsupDa -->
<s:textfield 
	
	
	name="appDataricercaAce.asolAsupDa" id="widg_tfAsolAsupDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfAsolAsupDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfAsolAsupA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfAsolAsupA.label')}" labelFor="widg_tfAsolAsupA" errorFor="appDataricercaAce.asolAsupA" labelId="tfAsolAsupALbl"
	position="last"  >


<!-- widget tfAsolAsupA -->
<s:textfield 
	
	
	name="appDataricercaAce.asolAsupA" id="widg_tfAsolAsupA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfAsolAsupA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfYieDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfYieDa.label')}" labelFor="widg_tfYieDa" errorFor="appDataricercaAce.yieDa" labelId="tfYieDaLbl"
	position="first"  >


<!-- widget tfYieDa -->
<s:textfield 
	
	
	name="appDataricercaAce.yieDa" id="widg_tfYieDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfYieDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfYieA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfYieA.label')}" labelFor="widg_tfYieA" errorFor="appDataricercaAce.yieA" labelId="tfYieALbl"
	position="last"  >


<!-- widget tfYieA -->
<s:textfield 
	
	
	name="appDataricercaAce.yieA" id="widg_tfYieA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfYieA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfVSuRaffDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfVSuRaffDa.label')}" labelFor="widg_tfVSuRaffDa" errorFor="appDataricercaAce.vSuRaffDa" labelId="tfVSuRaffDaLbl"
	position="first"  >


<!-- widget tfVSuRaffDa -->
<s:textfield 
	
	
	name="appDataricercaAce.vSuRaffDa" id="widg_tfVSuRaffDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfVSuRaffDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfVSuRaffA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfVSuRaffA.label')}" labelFor="widg_tfVSuRaffA" errorFor="appDataricercaAce.vSuRaffA" labelId="tfVSuRaffALbl"
	position="last"  >


<!-- widget tfVSuRaffA -->
<s:textfield 
	
	
	name="appDataricercaAce.vSuRaffA" id="widg_tfVSuRaffA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfVSuRaffA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfVSuRiscDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfVSuRiscDa.label')}" labelFor="widg_tfVSuRiscDa" errorFor="appDataricercaAce.vSuRiscDa" labelId="tfVSuRiscDaLbl"
	position="first"  >


<!-- widget tfVSuRiscDa -->
<s:textfield 
	
	
	name="appDataricercaAce.vSuRiscDa" id="widg_tfVSuRiscDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfVSuRiscDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfVSuRiscA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfVSuRiscA.label')}" labelFor="widg_tfVSuRiscA" errorFor="appDataricercaAce.vSuRiscA" labelId="tfVSuRiscALbl"
	position="last"  >


<!-- widget tfVSuRiscA -->
<s:textfield 
	
	
	name="appDataricercaAce.vSuRiscA" id="widg_tfVSuRiscA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfVSuRiscA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSVRaffDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSVRaffDa.label')}" labelFor="widg_tfSVRaffDa" errorFor="appDataricercaAce.sVRaffDa" labelId="tfSVRaffDaLbl"
	position="first"  >


<!-- widget tfSVRaffDa -->
<s:textfield 
	
	
	name="appDataricercaAce.sVRaffDa" id="widg_tfSVRaffDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfSVRaffDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSVRaffA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSVRaffA.label')}" labelFor="widg_tfSVRaffA" errorFor="appDataricercaAce.sVRaffA" labelId="tfSVRaffALbl"
	position="last"  >


<!-- widget tfSVRaffA -->
<s:textfield 
	
	
	name="appDataricercaAce.sVRaffA" id="widg_tfSVRaffA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfSVRaffA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSVRiscDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSVRiscDa.label')}" labelFor="widg_tfSVRiscDa" errorFor="appDataricercaAce.sVRiscDa" labelId="tfSVRiscDaLbl"
	position="first"  >


<!-- widget tfSVRiscDa -->
<s:textfield 
	
	
	name="appDataricercaAce.sVRiscDa" id="widg_tfSVRiscDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfSVRiscDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfSVRiscA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfSVRiscA.label')}" labelFor="widg_tfSVRiscA" errorFor="appDataricercaAce.sVRiscA" labelId="tfSVRiscALbl"
	position="last"  >


<!-- widget tfSVRiscA -->
<s:textfield 
	
	
	name="appDataricercaAce.sVRiscA" id="widg_tfSVRiscA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfSVRiscA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAce05ParamOR --></div>

	

		
	
</div>

	<!-- endFragment:p_fpNewApe --></div>
