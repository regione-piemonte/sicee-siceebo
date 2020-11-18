<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>

<s:include value="fragments/header.jsp" ></s:include>



<!-- appmoduleId:base/entiFormativi -->
<!-- pageId:cpDettaglioCorso -->

<s:form id="cpDettaglioCorso" action="cpDettaglioCorso" namespace="/base/entiFormativi" method="post">


<%-- NO SCRIPT --%>
		
	
	
		
<!-- ####################### PANNELLO CONTENUTI ###################### -->
<div id="contentPanel">

	<!-- ================ UDLRC Layout UP PANEL ================ -->
	<div id="northPanel">
		<div class="wrapper">
		
	
	<div id="p_pUp" class="formPanelBlock"><!-- startFragment:p_pUp -->

	
	

	
	
			
	
	
<s:include value="/jsp/userpanels/cpDettaglioCorso_pUserInfoCustom.jsp"></s:include>

	



	

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

	
		
			
<s:if test="isWidgetVisible('cpDettaglioCorso','menu')" >

	


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
				<h3><s:text name="cpDettaglioCorso.pDettaglioCorso.label" /></h3>

					
	
	<div id="p_pCenter" class="formPanelBlock"><!-- startFragment:p_pCenter -->

	
	

	
	
			
	
	<div id="p_fpDettaglioCorso" class="formPanelBlock"><!-- startFragment:p_fpDettaglioCorso -->
		
	
<div class="formPanel" id="fpDettaglioCorso">


	
	

	
	
			
	
	<div id="p_pErrori" class="stdMessagePanelBlock"><!-- startFragment:p_pErrori -->
	
	
<div class="stdMessagePanel" id="pErrori">
	<customtag:stdMessagePanel id="pErrori" errorMessage="true" errorDetails="false" actionMessage="true" />
</div>

	<!-- endFragment:p_pErrori --></div>

			
	
	<div id="p_wpDettaglioCorso" class="widgetsPanelBlock"><!-- startFragment:p_wpDettaglioCorso -->
	
	
<h4 class="wpLabel">Corsi di Formazione e Aggiornamento </h4>
<div class="widgetsPanel" id="wpDettaglioCorso">
	
	<customtag:widgetsPanel id="wpDettaglioCorsoTbl" columns="6" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCorso','lblSedeOperativa')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCorso.lblSedeOperativa.label')}" labelFor="widg_lblSedeOperativa" errorFor="appDataenteFormativo.sedeCompleta" labelId="lblSedeOperativaLbl"  position="first" >


<!-- widget lblSedeOperativa -->
<s:property value="appDataenteFormativo.sedeCompleta" escape="false" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','cbTipoCorso1')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.cbTipoCorso1.label')}" labelFor="widg_cbTipoCorso1" errorFor="appDatadettaglioCorso.idTipoCorso" labelId="cbTipoCorso1Lbl"
	position="first"  >


<!-- widget cbTipoCorso1 -->
<s:select name="appDatadettaglioCorso.idTipoCorso" id="widg_cbTipoCorso1"
	 
	
		title=""
			
	  headerKey="" headerValue="" 
	  list="appDataelencoTipologieCorsi"
	  disabled="isWidgetDisabled('cpDettaglioCorso','cbTipoCorso1')"
	  listKey="id"
	  listValue="descr"
	  
	  />


	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','tfAnnoFormativo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.tfAnnoFormativo.label')}" labelFor="widg_tfAnnoFormativo" errorFor="appDatadettaglioCorso.annoFormativo" labelId="tfAnnoFormativoLbl"
	position="first"  >


<!-- widget tfAnnoFormativo -->
<s:textfield 
	
title=""	
	name="appDatadettaglioCorso.annoFormativo" id="widg_tfAnnoFormativo"
maxlength="20"	disabled="isWidgetDisabled('cpDettaglioCorso','tfAnnoFormativo')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','tfNumCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.tfNumCorso.label')}" labelFor="widg_tfNumCorso" errorFor="appDatadettaglioCorso.numCorso" labelId="tfNumCorsoLbl"
	  >


<!-- widget tfNumCorso -->
<s:textfield 
	
title=""	
	name="appDatadettaglioCorso.numCorso" id="widg_tfNumCorso"
maxlength="20"	disabled="isWidgetDisabled('cpDettaglioCorso','tfNumCorso')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','tfTitolo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.tfTitolo.label')}" labelFor="widg_tfTitolo" errorFor="appDatadettaglioCorso.titolo" labelId="tfTitoloLbl"
	position="first"  >


<!-- widget tfTitolo -->
<s:textfield 
	
title=""	
	name="appDatadettaglioCorso.titolo" id="widg_tfTitolo"
maxlength="160"	disabled="isWidgetDisabled('cpDettaglioCorso','tfTitolo')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','calDataDal')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.calDataDal.label')}" labelFor="widg_calDataDal" errorFor="appDatadettaglioCorso.dataDal" labelId="calDataDalLbl"
	position="first"  >


<!-- widget calDataDal -->
<s:textfield 
	
	
	name="appDatadettaglioCorso.dataDal" id="widg_calDataDal"
	disabled="isWidgetDisabled('cpDettaglioCorso','calDataDal')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','calDataAl')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.calDataAl.label')}" labelFor="widg_calDataAl" errorFor="appDatadettaglioCorso.dataAl" labelId="calDataAlLbl"
	  >


<!-- widget calDataAl -->
<s:textfield 
	
	
	name="appDatadettaglioCorso.dataAl" id="widg_calDataAl"
	disabled="isWidgetDisabled('cpDettaglioCorso','calDataAl')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','tfLuogoCorso')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.tfLuogoCorso.label')}" labelFor="widg_tfLuogoCorso" errorFor="appDatadettaglioCorso.luogoCorso" labelId="tfLuogoCorsoLbl"
	position="first"  >


<!-- widget tfLuogoCorso -->
<s:textfield 
	
title=""	
	name="appDatadettaglioCorso.luogoCorso" id="widg_tfLuogoCorso"
maxlength="160"	disabled="isWidgetDisabled('cpDettaglioCorso','tfLuogoCorso')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','tfProtApprov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.tfProtApprov.label')}" labelFor="widg_tfProtApprov" errorFor="appDatadettaglioCorso.protApprov" labelId="tfProtApprovLbl"
	position="first"  >


<!-- widget tfProtApprov -->
<s:textfield 
	
title=""	
	name="appDatadettaglioCorso.protApprov" id="widg_tfProtApprov"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioCorso','tfProtApprov')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','calDataApprov')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.calDataApprov.label')}" labelFor="widg_calDataApprov" errorFor="appDatadettaglioCorso.dataApprov" labelId="calDataApprovLbl"
	  >


<!-- widget calDataApprov -->
<s:textfield 
	
	
	name="appDatadettaglioCorso.dataApprov" id="widg_calDataApprov"
	disabled="isWidgetDisabled('cpDettaglioCorso','calDataApprov')"
	size="10" maxlength="10" 
	cssClass="calendar"
/> <div class="infoCalendar"></div>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" />
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','tfTotaleOre')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.tfTotaleOre.label')}" labelFor="widg_tfTotaleOre" errorFor="appDatadettaglioCorso.totaleOre" labelId="tfTotaleOreLbl"
	position="first"  >


<!-- widget tfTotaleOre -->
<s:textfield 
	
title=""	
	name="appDatadettaglioCorso.totaleOre" id="widg_tfTotaleOre"
maxlength="10"	disabled="isWidgetDisabled('cpDettaglioCorso','tfTotaleOre')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','taNote')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCorso.taNote.label')}" labelFor="widg_taNote" errorFor="appDatadettaglioCorso.note" labelId="taNoteLbl"
	position="first" colSpan="3" >


<!-- widget taNote -->
<s:textarea 
	
	
	name="appDatadettaglioCorso.note" id="widg_taNote"
	disabled="isWidgetDisabled('cpDettaglioCorso','taNote')"
	rows="5"
	cols="100"
	></s:textarea>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="4" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCorso','txtNotaA')" >

	
<customtag:widgetsPanelColumn labelField="true" textLabel="%{getText('cpDettaglioCorso.txtNotaA.label')}" labelFor="widg_txtNotaA" errorFor="widg_txtNotaA" labelId="txtNotaALbl"  position="first" >


<!-- widget txtNotaA -->
<s:text name="cpDettaglioCorso.txtNotaA.statictext.label" />

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpDettaglioCorso --></div>

			
	
	<div id="p_pDatiRegistrazioneNav" class="commandPanelBlock"><!-- startFragment:p_pDatiRegistrazioneNav -->
	
	
<div class="commandPanel navigation" id="pDatiRegistrazioneNav">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioCorso','bIndietro')" >

	



<!-- widget bIndietro -->
<s:submit name="widg_bIndietro" id="widg_bIndietro" method="handleBIndietro_CLICKED"
	key="cpDettaglioCorso.bIndietro.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCorso','bIndietro')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioCorso','bSalva')" >

	



<!-- widget bSalva -->
<s:submit name="widg_bSalva" id="widg_bSalva" method="handleBSalva_CLICKED"
	key="cpDettaglioCorso.bSalva.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCorso','bSalva')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDatiRegistrazioneNav --></div>

	

		
	
</div>

	<!-- endFragment:p_fpDettaglioCorso --></div>

	

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
