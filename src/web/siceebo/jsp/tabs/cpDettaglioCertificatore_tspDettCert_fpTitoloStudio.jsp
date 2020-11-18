<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/ricercacertificatori/CpDettaglioCertificatoreAction" />

	
	<div id="p_fpTitoloStudio" class="formPanelBlock"><!-- startFragment:p_fpTitoloStudio -->
		
	
<div class="formPanel" id="fpTitoloStudio">


	
	

	
	
			
	
	<div id="p_wpTitoloStudio" class="widgetsPanelBlock"><!-- startFragment:p_wpTitoloStudio -->
	
	
<h4 class="wpLabel">Titolo di studio e formazione </h4>
<div class="widgetsPanel" id="wpTitoloStudio">
	
	<customtag:widgetsPanel id="wpTitoloStudioTbl" columns="4" tableStyleClass="formTable"
		summary="" 
		>
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','rbsIscrittoOrdine')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.rbsIscrittoOrdine.label')}" labelFor="widg_rbsIscrittoOrdine" errorFor="appDatacertificatoreDett.iscrittoOrdine" labelId="rbsIscrittoOrdineLbl"
	position="first"  >


<!-- widget rbsIscrittoOrdine -->

	
<div id="appDatacertificatoreDett.iscrittoOrdine" class="radiobuttons ">







<s:radio
	
	
	id="widg_rbIscrittoOrdineSi" name="appDatacertificatoreDett.iscrittoOrdine"
	list="#{'S':'si'}"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','rbsIscrittoOrdine')"
	cssClass="radio"
	
	/> <label  for="widg_rbIscrittoOrdineSiS"><s:text name="cpDettaglioCertificatore.rbsIscrittoOrdine.rbIscrittoOrdineSi.label" /></label>








<s:radio
	
	
	id="widg_rbIscrittoOrdineNo" name="appDatacertificatoreDett.iscrittoOrdine"
	list="#{'N':'no'}"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','rbsIscrittoOrdine')"
	cssClass="radio"
	
	/> <label  for="widg_rbIscrittoOrdineNoN"><s:text name="cpDettaglioCertificatore.rbsIscrittoOrdine.rbIscrittoOrdineNo.label" /></label>





	
</div>



	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertTipoIstruzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertTipoIstruzione.label')}" labelFor="widg_tfDettCertTipoIstruzione" errorFor="appDatacertificatoreDett.tipoIstruzione" labelId="tfDettCertTipoIstruzioneLbl"
	position="first" colSpan="3" >


<!-- widget tfDettCertTipoIstruzione -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.tipoIstruzione" id="widg_tfDettCertTipoIstruzione"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertTipoIstruzione')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertCodiceIstruzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertCodiceIstruzione.label')}" labelFor="widg_tfDettCertCodiceIstruzione" errorFor="appDatacertificatoreDett.codiceIstruzione" labelId="tfDettCertCodiceIstruzioneLbl"
	position="last"  >


<!-- widget tfDettCertCodiceIstruzione -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.codiceIstruzione" id="widg_tfDettCertCodiceIstruzione"
maxlength="10"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertCodiceIstruzione')"
	size="10" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertTitoloIstruzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertTitoloIstruzione.label')}" labelFor="widg_tfDettCertTitoloIstruzione" errorFor="appDatacertificatoreDett.titoloIstruzione" labelId="tfDettCertTitoloIstruzioneLbl"
	position="first"  >


<!-- widget tfDettCertTitoloIstruzione -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.titoloIstruzione" id="widg_tfDettCertTitoloIstruzione"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertTitoloIstruzione')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertSezioneIstruzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertSezioneIstruzione.label')}" labelFor="widg_tfDettCertSezioneIstruzione" errorFor="appDatacertificatoreDett.sezioneIstruzione" labelId="tfDettCertSezioneIstruzioneLbl"
	position="last"  >


<!-- widget tfDettCertSezioneIstruzione -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.sezioneIstruzione" id="widg_tfDettCertSezioneIstruzione"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertSezioneIstruzione')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertSettoreIstruzione')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertSettoreIstruzione.label')}" labelFor="widg_tfDettCertSettoreIstruzione" errorFor="appDatacertificatoreDett.settoreIstruzione" labelId="tfDettCertSettoreIstruzioneLbl"
	position="first"  >


<!-- widget tfDettCertSettoreIstruzione -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.settoreIstruzione" id="widg_tfDettCertSettoreIstruzione"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertSettoreIstruzione')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertAlbo')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertAlbo.label')}" labelFor="widg_tfDettCertAlbo" errorFor="appDatacertificatoreDett.alboApp" labelId="tfDettCertAlboLbl"
	position="first"  >


<!-- widget tfDettCertAlbo -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.alboApp" id="widg_tfDettCertAlbo"
maxlength="50"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertAlbo')"
	size="50" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertAlboProv')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertAlboProv.label')}" labelFor="widg_tfDettCertAlboProv" errorFor="appDatacertificatoreDett.alboDescrProv" labelId="tfDettCertAlboProvLbl"
	position="last"  >


<!-- widget tfDettCertAlboProv -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.alboDescrProv" id="widg_tfDettCertAlboProv"
maxlength="20"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertAlboProv')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertAlboNumIscriz')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertAlboNumIscriz.label')}" labelFor="widg_tfDettCertAlboNumIscriz" errorFor="appDatacertificatoreDett.alboNumIscrizione" labelId="tfDettCertAlboNumIscrizLbl"
	position="first"  >


<!-- widget tfDettCertAlboNumIscriz -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.alboNumIscrizione" id="widg_tfDettCertAlboNumIscriz"
maxlength="20"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertAlboNumIscriz')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="first"/>
</s:else>


	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tfDettCertAlboData')" >

	
<customtag:widgetsPanelColumn   labelField="true" textLabel="%{getText('cpDettaglioCertificatore.tfDettCertAlboData.label')}" labelFor="widg_tfDettCertAlboData" errorFor="appDatacertificatoreDett.alboDataIscrizione" labelId="tfDettCertAlboDataLbl"
	position="last"  >


<!-- widget tfDettCertAlboData -->
<s:textfield 
	
	
	name="appDatacertificatoreDett.alboDataIscrizione" id="widg_tfDettCertAlboData"
maxlength="20"	disabled="isWidgetDisabled('cpDettaglioCertificatore','tfDettCertAlboData')"
	size="20" 
/>

	
</customtag:widgetsPanelColumn>

</s:if>

	
<s:else>
	<customtag:widgetsPanelColumn textValue="" colSpan="2" position="last"/>
</s:else>



	
	
	
	</customtag:widgetsPanel>
	
</div>

	<!-- endFragment:p_wpTitoloStudio --></div>

			
	
	<div id="p_wpTitoloStudioAll" class="widgetsPanelBlock"><!-- startFragment:p_wpTitoloStudioAll -->
	
	
<h4 class="wpLabel">Titolo di studio allegato </h4>
<div class="widgetsPanel" id="wpTitoloStudioAll">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tblTitoloStudioSummary')" >

	
<div class="tableWidget">


<!-- widget tblTitoloStudioSummary -->
<s:set name="cpDettaglioCertificatore_tblTitoloStudioSummary_clearStatus" value="isTableClearStatus('cpDettaglioCertificatore_tblTitoloStudioSummary')" />
<s:url id="cpDettaglioCertificatoreViewUrl"						   
					   action="cpDettaglioCertificatore"
					   namespace="/base/ricercaCertificatori"/>
<display:table name="appDatachiaviTitoloStudio"  				
			   excludedParams="*"			   export="false"
               id="widg_tblTitoloStudioSummary"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioCertificatoreViewUrl}"  
               clearStatus="${cpDettaglioCertificatore_tblTitoloStudioSummary_clearStatus}"
               uid="row_tblTitoloStudioSummary"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.ricercacertificatori.CpDettaglioCertificatoreTblTitoloStudioSummaryCustomDecorator"               class="dataTable">
	
		<display:column property="nome" titleKey="cpDettaglioCertificatore.tblTitoloStudioSummary.nome.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipo" titleKey="cpDettaglioCertificatore.tblTitoloStudioSummary.tipo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUpload" titleKey="cpDettaglioCertificatore.tblTitoloStudioSummary.dataUpload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgScarico" titleKey="cpDettaglioCertificatore.tblTitoloStudioSummary.flgScarico.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpTitoloStudioAll --></div>

			
	
	<div id="p_wpCurriculum" class="widgetsPanelBlock"><!-- startFragment:p_wpCurriculum -->
	
	
<h4 class="wpLabel">Curriculum Vitae </h4>
<div class="widgetsPanel" id="wpCurriculum">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tblCurriculumSummary')" >

	
<div class="tableWidget">


<!-- widget tblCurriculumSummary -->
<s:set name="cpDettaglioCertificatore_tblCurriculumSummary_clearStatus" value="isTableClearStatus('cpDettaglioCertificatore_tblCurriculumSummary')" />
<s:url id="cpDettaglioCertificatoreViewUrl"						   
					   action="cpDettaglioCertificatore"
					   namespace="/base/ricercaCertificatori"/>
<display:table name="appDatachiaviCurriculum"  				
			   excludedParams="*"			   export="false"
               id="widg_tblCurriculumSummary"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioCertificatoreViewUrl}"  
               clearStatus="${cpDettaglioCertificatore_tblCurriculumSummary_clearStatus}"
               uid="row_tblCurriculumSummary"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.ricercacertificatori.CpDettaglioCertificatoreTblCurriculumSummaryCustomDecorator"               class="dataTable">
	
		<display:column property="nome" titleKey="cpDettaglioCertificatore.tblCurriculumSummary.nome.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipo" titleKey="cpDettaglioCertificatore.tblCurriculumSummary.tipo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUpload" titleKey="cpDettaglioCertificatore.tblCurriculumSummary.dataUpload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgScarico" titleKey="cpDettaglioCertificatore.tblCurriculumSummary.flgScarico.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpCurriculum --></div>

			
	
	<div id="p_wpAttPartNew" class="widgetsPanelBlock"><!-- startFragment:p_wpAttPartNew -->
	
	
<h4 class="wpLabel">Corsi ed esami sostenuti </h4>
<div class="widgetsPanel" id="wpAttPartNew">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tblAttPartNewSummary')" >

	
<div class="tableWidget">


<!-- widget tblAttPartNewSummary -->
<s:set name="cpDettaglioCertificatore_tblAttPartNewSummary_clearStatus" value="isTableClearStatus('cpDettaglioCertificatore_tblAttPartNewSummary')" />
<s:url id="cpDettaglioCertificatoreViewUrl"						   
					   action="cpDettaglioCertificatore"
					   namespace="/base/ricercaCertificatori"/>
<display:table name="appDatachiaviAttPartNew"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttPartNewSummary"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioCertificatoreViewUrl}"  
               clearStatus="${cpDettaglioCertificatore_tblAttPartNewSummary_clearStatus}"
               uid="row_tblAttPartNewSummary"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.ricercacertificatori.CpDettaglioCertificatoreTblAttPartNewSummaryCustomDecorator"               class="dataTable">
	
		<display:column property="titolo" titleKey="cpDettaglioCertificatore.tblAttPartNewSummary.titolo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="denominazione" titleKey="cpDettaglioCertificatore.tblAttPartNewSummary.denominazione.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="totaleOre" titleKey="cpDettaglioCertificatore.tblAttPartNewSummary.totaleOre.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataEsame" titleKey="cpDettaglioCertificatore.tblAttPartNewSummary.dataEsame.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="esitoEsame" titleKey="cpDettaglioCertificatore.tblAttPartNewSummary.esitoEsame.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgScarico" titleKey="cpDettaglioCertificatore.tblAttPartNewSummary.flgScarico.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAttPartNew --></div>

			
	
	<div id="p_wpAttPartOld" class="widgetsPanelBlock"><!-- startFragment:p_wpAttPartOld -->
	
	
<h4 class="wpLabel">Attestati di partecipazione e profitto a corsi regionali e nazionali antecedenti al 20/06/2016 </h4>
<div class="widgetsPanel" id="wpAttPartOld">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tblAttPartOldSummary')" >

	
<div class="tableWidget">


<!-- widget tblAttPartOldSummary -->
<s:set name="cpDettaglioCertificatore_tblAttPartOldSummary_clearStatus" value="isTableClearStatus('cpDettaglioCertificatore_tblAttPartOldSummary')" />
<s:url id="cpDettaglioCertificatoreViewUrl"						   
					   action="cpDettaglioCertificatore"
					   namespace="/base/ricercaCertificatori"/>
<display:table name="appDatachiaviAttPartOld"  				
			   excludedParams="*"			   export="false"
               id="widg_tblAttPartOldSummary"
               pagesize="0"
               keepStatus="true"
               requestURI="${cpDettaglioCertificatoreViewUrl}"  
               clearStatus="${cpDettaglioCertificatore_tblAttPartOldSummary_clearStatus}"
               uid="row_tblAttPartOldSummary"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.ricercacertificatori.CpDettaglioCertificatoreTblAttPartOldSummaryCustomDecorator"               class="dataTable">
	
		<display:column property="nome" titleKey="cpDettaglioCertificatore.tblAttPartOldSummary.nome.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="tipo" titleKey="cpDettaglioCertificatore.tblAttPartOldSummary.tipo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="dataUpload" titleKey="cpDettaglioCertificatore.tblAttPartOldSummary.dataUpload.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
		<display:column property="flgScarico" titleKey="cpDettaglioCertificatore.tblAttPartOldSummary.flgScarico.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpAttPartOld --></div>

			
	
	<div id="p_pDatiRegistrazioneNav2" class="commandPanelBlock"><!-- startFragment:p_pDatiRegistrazioneNav2 -->
	
	
<div class="commandPanel navigation" id="pDatiRegistrazioneNav2">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioCertificatore','bIndietro2')" >

	



<!-- widget bIndietro2 -->
<s:submit name="widg_bIndietro2" id="widg_bIndietro2" method="handleBIndietro2_CLICKED"
	key="cpDettaglioCertificatore.bIndietro2.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','bIndietro2')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pDatiRegistrazioneNav2 --></div>

	

		
	
</div>

	<!-- endFragment:p_fpTitoloStudio --></div>
