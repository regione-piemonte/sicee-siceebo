<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_fpOldApe" class="formPanelBlock"><!-- startFragment:p_fpOldApe -->
		
	
<div class="formPanel" id="fpOldApe">


	
	

	
	
			
	
	<div id="p_wpRicercaAceParamOR" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaAceParamOR -->
	
	

<div class="widgetsPanel" id="wpRicercaAceParamOR">
	
	<customtag:widgetsPanel id="wpRicercaAceParamORTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRicercaAce','ptNotaParametriOR')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget ptNotaParametriOR -->
<s:text name="cpRicercaAce.ptNotaParametriOR.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceVDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceVDa.label')}" labelFor="widg_tfRicAceVDa" errorFor="appDataricercaAce.vDa" labelId="tfRicAceVDaLbl"
	position="first"  >


<!-- widget tfRicAceVDa -->
<s:textfield 
	
	
	name="appDataricercaAce.vDa" id="widg_tfRicAceVDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceVDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceVA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceVA.label')}" labelFor="widg_tfRicAceVA" errorFor="appDataricercaAce.vA" labelId="tfRicAceVALbl"
	position="last"  >


<!-- widget tfRicAceVA -->
<s:textfield 
	
	
	name="appDataricercaAce.vA" id="widg_tfRicAceVA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceVA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceSuDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceSuDa.label')}" labelFor="widg_tfRicAceSuDa" errorFor="appDataricercaAce.suDa" labelId="tfRicAceSuDaLbl"
	position="first"  >


<!-- widget tfRicAceSuDa -->
<s:textfield 
	
	
	name="appDataricercaAce.suDa" id="widg_tfRicAceSuDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceSuDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceSuA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceSuA.label')}" labelFor="widg_tfRicAceSuA" errorFor="appDataricercaAce.suA" labelId="tfRicAceSuALbl"
	position="last"  >


<!-- widget tfRicAceSuA -->
<s:textfield 
	
	
	name="appDataricercaAce.suA" id="widg_tfRicAceSuA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceSuA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceVSuDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceVSuDa.label')}" labelFor="widg_tfRicAceVSuDa" errorFor="appDataricercaAce.vsuDa" labelId="tfRicAceVSuDaLbl"
	position="first"  >


<!-- widget tfRicAceVSuDa -->
<s:textfield 
	
	
	name="appDataricercaAce.vsuDa" id="widg_tfRicAceVSuDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceVSuDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceVSuA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceVSuA.label')}" labelFor="widg_tfRicAceVSuA" errorFor="appDataricercaAce.vsuA" labelId="tfRicAceVSuALbl"
	position="last"  >


<!-- widget tfRicAceVSuA -->
<s:textfield 
	
	
	name="appDataricercaAce.vsuA" id="widg_tfRicAceVSuA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceVSuA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceFattoreFormaDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceFattoreFormaDa.label')}" labelFor="widg_tfRicAceFattoreFormaDa" errorFor="appDataricercaAce.fattoreFormaDa" labelId="tfRicAceFattoreFormaDaLbl"
	position="first"  >


<!-- widget tfRicAceFattoreFormaDa -->
<s:textfield 
	
	
	name="appDataricercaAce.fattoreFormaDa" id="widg_tfRicAceFattoreFormaDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceFattoreFormaDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceFattoreFormaA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceFattoreFormaA.label')}" labelFor="widg_tfRicAceFattoreFormaA" errorFor="appDataricercaAce.fattoreFormaA" labelId="tfRicAceFattoreFormaALbl"
	position="last"  >


<!-- widget tfRicAceFattoreFormaA -->
<s:textfield 
	
	
	name="appDataricercaAce.fattoreFormaA" id="widg_tfRicAceFattoreFormaA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceFattoreFormaA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceTrasmSupOpacheDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceTrasmSupOpacheDa.label')}" labelFor="widg_tfRicAceTrasmSupOpacheDa" errorFor="appDataricercaAce.trasmSupOpacheDa" labelId="tfRicAceTrasmSupOpacheDaLbl"
	position="first"  >


<!-- widget tfRicAceTrasmSupOpacheDa -->
<s:textfield 
	
	
	name="appDataricercaAce.trasmSupOpacheDa" id="widg_tfRicAceTrasmSupOpacheDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceTrasmSupOpacheDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceTrasmSupOpacheA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceTrasmSupOpacheA.label')}" labelFor="widg_tfRicAceTrasmSupOpacheA" errorFor="appDataricercaAce.trasmSupOpacheA" labelId="tfRicAceTrasmSupOpacheALbl"
	position="last"  >


<!-- widget tfRicAceTrasmSupOpacheA -->
<s:textfield 
	
	
	name="appDataricercaAce.trasmSupOpacheA" id="widg_tfRicAceTrasmSupOpacheA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceTrasmSupOpacheA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceTrasmSupTraspDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceTrasmSupTraspDa.label')}" labelFor="widg_tfRicAceTrasmSupTraspDa" errorFor="appDataricercaAce.trasmSupTraspDa" labelId="tfRicAceTrasmSupTraspDaLbl"
	position="first"  >


<!-- widget tfRicAceTrasmSupTraspDa -->
<s:textfield 
	
	
	name="appDataricercaAce.trasmSupTraspDa" id="widg_tfRicAceTrasmSupTraspDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceTrasmSupTraspDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceTrasmSupTraspA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceTrasmSupTraspA.label')}" labelFor="widg_tfRicAceTrasmSupTraspA" errorFor="appDataricercaAce.trasmSupTraspA" labelId="tfRicAceTrasmSupTraspALbl"
	position="last"  >


<!-- widget tfRicAceTrasmSupTraspA -->
<s:textfield 
	
	
	name="appDataricercaAce.trasmSupTraspA" id="widg_tfRicAceTrasmSupTraspA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceTrasmSupTraspA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','cbRicAceFabbisognoSupIndice')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbRicAceFabbisognoSupIndice.label')}" labelFor="widg_cbRicAceFabbisognoSupIndice" errorFor="appDataricercaAce.flgFabbisognoSupIndice" labelId="cbRicAceFabbisognoSupIndiceLbl"
	position="first" colSpan="3" >


<!-- widget cbRicAceFabbisognoSupIndice -->
<s:checkbox 
	
	
	name="appDataricercaAce.flgFabbisognoSupIndice" id="widg_cbRicAceFabbisognoSupIndice"
	disabled="isWidgetDisabled('cpRicercaAce','cbRicAceFabbisognoSupIndice')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaAce','cbRicAceFabbisognoSupIndice')" >
	<s:hidden name="__checkbox_appDataricercaAce.flgFabbisognoSupIndice" id="__checkbox_widg_cbRicAceFabbisognoSupIndice" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceRendMedioAcsDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceRendMedioAcsDa.label')}" labelFor="widg_tfRicAceRendMedioAcsDa" errorFor="appDataricercaAce.rendMedioAcsDa" labelId="tfRicAceRendMedioAcsDaLbl"
	position="first"  >


<!-- widget tfRicAceRendMedioAcsDa -->
<s:textfield 
	
	
	name="appDataricercaAce.rendMedioAcsDa" id="widg_tfRicAceRendMedioAcsDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceRendMedioAcsDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceRendMedioAcsA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceRendMedioAcsA.label')}" labelFor="widg_tfRicAceRendMedioAcsA" errorFor="appDataricercaAce.rendMedioAcsA" labelId="tfRicAceRendMedioAcsALbl"
	position="last"  >


<!-- widget tfRicAceRendMedioAcsA -->
<s:textfield 
	
	
	name="appDataricercaAce.rendMedioAcsA" id="widg_tfRicAceRendMedioAcsA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceRendMedioAcsA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceRendMedioImpTermicoDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceRendMedioImpTermicoDa.label')}" labelFor="widg_tfRicAceRendMedioImpTermicoDa" errorFor="appDataricercaAce.rendMedioImpTermicoDa" labelId="tfRicAceRendMedioImpTermicoDaLbl"
	position="first"  >


<!-- widget tfRicAceRendMedioImpTermicoDa -->
<s:textfield 
	
	
	name="appDataricercaAce.rendMedioImpTermicoDa" id="widg_tfRicAceRendMedioImpTermicoDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceRendMedioImpTermicoDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceRendMedioImpTermicoA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceRendMedioImpTermicoA.label')}" labelFor="widg_tfRicAceRendMedioImpTermicoA" errorFor="appDataricercaAce.rendMedioImpTermicoA" labelId="tfRicAceRendMedioImpTermicoALbl"
	position="last"  >


<!-- widget tfRicAceRendMedioImpTermicoA -->
<s:textfield 
	
	
	name="appDataricercaAce.rendMedioImpTermicoA" id="widg_tfRicAceRendMedioImpTermicoA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceRendMedioImpTermicoA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceFabAcsSuDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceFabAcsSuDa.label')}" labelFor="widg_tfRicAceFabAcsSuDa" errorFor="appDataricercaAce.fabAcsSuDa" labelId="tfRicAceFabAcsSuDaLbl"
	position="first"  >


<!-- widget tfRicAceFabAcsSuDa -->
<s:textfield 
	
	
	name="appDataricercaAce.fabAcsSuDa" id="widg_tfRicAceFabAcsSuDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceFabAcsSuDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceFabAcsSuA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceFabAcsSuA.label')}" labelFor="widg_tfRicAceFabAcsSuA" errorFor="appDataricercaAce.fabAcsSuA" labelId="tfRicAceFabAcsSuALbl"
	position="last"  >


<!-- widget tfRicAceFabAcsSuA -->
<s:textfield 
	
	
	name="appDataricercaAce.fabAcsSuA" id="widg_tfRicAceFabAcsSuA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceFabAcsSuA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceIndiceEplDa')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceIndiceEplDa.label')}" labelFor="widg_tfRicAceIndiceEplDa" errorFor="appDataricercaAce.indiceEplDa" labelId="tfRicAceIndiceEplDaLbl"
	position="first"  >


<!-- widget tfRicAceIndiceEplDa -->
<s:textfield 
	
	
	name="appDataricercaAce.indiceEplDa" id="widg_tfRicAceIndiceEplDa"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceIndiceEplDa')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','tfRicAceIndiceEplA')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.tfRicAceIndiceEplA.label')}" labelFor="widg_tfRicAceIndiceEplA" errorFor="appDataricercaAce.indiceEplA" labelId="tfRicAceIndiceEplALbl"
	position="last"  >


<!-- widget tfRicAceIndiceEplA -->
<s:textfield 
	
	
	name="appDataricercaAce.indiceEplA" id="widg_tfRicAceIndiceEplA"
maxlength="10"	disabled="isWidgetDisabled('cpRicercaAce','tfRicAceIndiceEplA')"
	size="15" cssClass="numbers"
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRicercaAce','cbRicAceFabbisognoAcsDiverso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRicercaAce.cbRicAceFabbisognoAcsDiverso.label')}" labelFor="widg_cbRicAceFabbisognoAcsDiverso" errorFor="appDataricercaAce.flgFabbisognoAcsDiverso" labelId="cbRicAceFabbisognoAcsDiversoLbl"
	position="first" colSpan="3" >


<!-- widget cbRicAceFabbisognoAcsDiverso -->
<s:checkbox 
	
	
	name="appDataricercaAce.flgFabbisognoAcsDiverso" id="widg_cbRicAceFabbisognoAcsDiverso"
	disabled="isWidgetDisabled('cpRicercaAce','cbRicAceFabbisognoAcsDiverso')"
	cssClass="checkbox"
	
	/> 
<s:if test="!isWidgetDisabled('cpRicercaAce','cbRicAceFabbisognoAcsDiverso')" >
	<s:hidden name="__checkbox_appDataricercaAce.flgFabbisognoAcsDiverso" id="__checkbox_widg_cbRicAceFabbisognoAcsDiverso" />
</s:if>

	
</customtag:widgetsPanelColumn>

</s:if>

	



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaAceParamOR --></div>

	

		
	
</div>

	<!-- endFragment:p_fpOldApe --></div>
