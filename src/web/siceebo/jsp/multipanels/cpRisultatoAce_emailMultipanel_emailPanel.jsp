<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

	
	<div id="p_emailPanel" class="formPanelBlock"><!-- startFragment:p_emailPanel -->
		
	
<h4 class="fpLabel"><s:text name="cpRisultatoAce.emailPanel.label" /></h4>
<div class="formPanel" id="emailPanel">


	
	

	
	
			
	
	<div id="p_emailWidgetPanel" class="widgetsPanelBlock"><!-- startFragment:p_emailWidgetPanel -->
	
	

<div class="widgetsPanel" id="emailWidgetPanel">
	
	<customtag:widgetsPanel id="emailWidgetPanelTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpRisultatoAce','email')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpRisultatoAce.email.label')}" labelFor="widg_email" errorFor="appDataemailInvioApe" labelId="emailLbl"
	position="first"  >


<!-- widget email -->
<s:textfield 
	
title=""	
	name="appDataemailInvioApe" id="widg_email"
maxlength="50"	disabled="isWidgetDisabled('cpRisultatoAce','email')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpRisultatoAce','emailWidgetPanel_1_2_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2"  >


<!-- widget emailWidgetPanel_1_2_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpRisultatoAce','emailWidgetPanel_1_3_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="last" >


<!-- widget emailWidgetPanel_1_3_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_emailWidgetPanel --></div>

			
	
	<div id="p_CloseEmailPanel" class="commandPanelBlock"><!-- startFragment:p_CloseEmailPanel -->
	
	
<div class="commandPanel functional" id="CloseEmailPanel">

	
	
		

	
	
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpRisultatoAce','closeEmailForm')" >

	



<!-- widget closeEmailForm -->
<s:submit name="widg_closeEmailForm" id="widg_closeEmailForm" method="handleCloseEmailForm_CLICKED"
	key="cpRisultatoAce.closeEmailForm.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAce','closeEmailForm')" />

	


</s:if>

	


		
<s:if test="isWidgetVisible('cpRisultatoAce','inviaEmailZipXmlApe')" >

	



<!-- widget inviaEmailZipXmlApe -->
<s:submit name="widg_inviaEmailZipXmlApe" id="widg_inviaEmailZipXmlApe" method="handleInviaEmailZipXmlApe_CLICKED"
	key="cpRisultatoAce.inviaEmailZipXmlApe.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpRisultatoAce','inviaEmailZipXmlApe')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_CloseEmailPanel --></div>

	

		
	
</div>

	<!-- endFragment:p_emailPanel --></div>
