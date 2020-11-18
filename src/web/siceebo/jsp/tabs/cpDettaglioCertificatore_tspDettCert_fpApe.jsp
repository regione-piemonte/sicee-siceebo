<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/ricercacertificatori/CpDettaglioCertificatoreAction" />

	
	<div id="p_fpApe" class="formPanelBlock"><!-- startFragment:p_fpApe -->
		
	


	
	

	
	
			
	
	<div id="p_wpRicercaApe" class="widgetsPanelBlock"><!-- startFragment:p_wpRicercaApe -->
	
	
<h4 class="wpLabel">A.P.E. prodotti </h4>
<div class="widgetsPanel" id="wpRicercaApe">
	
	<customtag:widgetsPanel id="wpRicercaApeTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfRicACEAnno')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfRicACEAnno.label')}" labelFor="widg_tfRicACEAnno" errorFor="appDataricercaAce.inviatiAnno" labelId="tfRicACEAnnoLbl"
	position="first"  >


<!-- widget tfRicACEAnno -->
<s:textfield 
	
	
	name="appDataricercaAce.inviatiAnno" id="widg_tfRicACEAnno"
maxlength="4"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfRicACEAnno')"
	size="15" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','rbStato')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.rbStato.label')}" labelFor="widg_rbStato" errorFor="appDataricercaAce.stato" labelId="rbStatoLbl"
	position="last"  >


<!-- widget rbStato -->

	
<div id="appDataricercaAce.stato" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbInviato" name="appDataricercaAce.stato"
	list="#{'3':'inviato'}"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','rbStato')"
	cssClass="radio"
	
	/> <label  for="widg_rbInviato3"><s:text name="cpDettaglioCertificatore.rbStato.rbInviato.label" /></label>








<s:radio
	
	
	id="widg_rbAnnullato" name="appDataricercaAce.stato"
	list="#{'4':'annullato'}"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','rbStato')"
	cssClass="radio"
	
	/> <label  for="widg_rbAnnullato4"><s:text name="cpDettaglioCertificatore.rbStato.rbAnnullato.label" /></label>








<s:radio
	
	
	id="widg_rbEntrambi" name="appDataricercaAce.stato"
	list="#{'99':'entrambi'}"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','rbStato')"
	cssClass="radio"
	
	/> <label  for="widg_rbEntrambi99"><s:text name="cpDettaglioCertificatore.rbStato.rbEntrambi.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','calRicACEDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.calRicACEDal.label')}" labelFor="widg_calRicACEDal" errorFor="appDataricercaAce.inviatiDal" labelId="calRicACEDalLbl"
	position="first"  >


<!-- widget calRicACEDal -->
<s:textfield 
	
	
	name="appDataricercaAce.inviatiDal" id="widg_calRicACEDal"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','calRicACEDal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','calRicACEal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.calRicACEal.label')}" labelFor="widg_calRicACEal" errorFor="appDataricercaAce.inviatiAl" labelId="calRicACEalLbl"
	position="last"  >


<!-- widget calRicACEal -->
<s:textfield 
	
	
	name="appDataricercaAce.inviatiAl" id="widg_calRicACEal"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','calRicACEal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','wpRicercaApe_3_1_fictitious_')" >

	
<customtag:widgetsPanelColumn  colSpan="2" position="first" >


<!-- widget wpRicercaApe_3_1_fictitious_ -->


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','bRicerca')" >

	
<customtag:widgetsPanelColumn colSpan="2" position="last">


<!-- widget bRicerca -->
<s:submit name="widg_bRicerca" id="widg_bRicerca" method="handleBRicerca_CLICKED"
	key="cpDettaglioCertificatore.bRicerca.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','bRicerca')" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpRicercaApe --></div>

			
	
	
	<div id="p_mpRisApeCert" class="panelBlock"><!-- startFragment:p_mpRisApeCert -->
		

		
<s:if test="#session.cpDettaglioCertificatore_mpRisApeCert_selectedMultiPanel == 'cpDettaglioCertificatore_mpRisApeCert_fpRisApeCert'">
	<s:include value="/jsp/multipanels/cpDettaglioCertificatore_mpRisApeCert_fpRisApeCert.jsp" ></s:include>
</s:if>
	<!-- endFragment:p_mpRisApeCert --></div>

			
	
	<div id="p_pDatiRegistrazioneNav3" class="commandPanelBlock"><!-- startFragment:p_pDatiRegistrazioneNav3 -->
	
	
<div class="commandPanel navigation" id="pDatiRegistrazioneNav3">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioCertificatore','bIndietro3')" >

	



<!-- widget bIndietro3 -->
<s:submit name="widg_bIndietro3" id="widg_bIndietro3" method="handleBIndietro3_CLICKED"
	key="cpDettaglioCertificatore.bIndietro3.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','bIndietro3')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDatiRegistrazioneNav3 --></div>

	

		
	

	<!-- endFragment:p_fpApe --></div>
