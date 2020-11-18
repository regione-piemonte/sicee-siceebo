<%@taglib uri="/struts-tags" prefix="s" %>
<%@taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@taglib uri="/customtag" prefix="customtag" %>
<%@taglib uri="/csiuicore" prefix="csiuicore" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setBundle basename="/it/csi/sicee/siceebo/presentation/siceebo/action/ricercacertificatori/CpDettaglioCertificatoreAction" />

	
	<div id="p_fpRisApeCert" class="formPanelBlock"><!-- startFragment:p_fpRisApeCert -->
		
	
<h4 class="fpLabel"><s:text name="cpDettaglioCertificatore.fpRisApeCert.label" /></h4>
<div class="formPanel" id="fpRisApeCert">


	
	

	
	
			
	
	<div id="p_wpRisApeCert" class="widgetsPanelBlock"><!-- startFragment:p_wpRisApeCert -->
	
	

<div class="widgetsPanel" id="wpRisApeCert">
	

	
	
<s:if test="isWidgetVisible('cpDettaglioCertificatore','tblRisultatoAceCert')" >

	
<div class="tableWidget">


<!-- widget tblRisultatoAceCert -->
<s:set name="cpDettaglioCertificatore_tblRisultatoAceCert_clearStatus" value="isTableClearStatus('cpDettaglioCertificatore_tblRisultatoAceCert')" />
<s:url id="cpDettaglioCertificatoreViewUrl"						   
					   action="cpDettaglioCertificatore"
					   namespace="/base/ricercaCertificatori"/>
<display:table name="appDataaceList"  				
			   excludedParams="*"			   export="true"
               id="widg_tblRisultatoAceCert"
               pagesize="10"
               keepStatus="true"
               requestURI="${cpDettaglioCertificatoreViewUrl}"  
               clearStatus="${cpDettaglioCertificatore_tblRisultatoAceCert_clearStatus}"
               uid="row_tblRisultatoAceCert"
               summary="" 
decorator="it.csi.sicee.siceebo.presentation.decorator.ricercacertificatori.CpDettaglioCertificatoreTblRisultatoAceCertCustomDecorator"               class="dataTable">
	
		<display:column headerClass="nosort" media="html">
			<s:radio list="%{#attr.row_tblRisultatoAceCert.codice}" name="appDatacodAceSelezionato" id="%{'tblRisultatoAceCert-editcell-'+ (#attr.row_tblRisultatoAceCert_rowNum - 1)}" cssClass="radio"
			/>
		</display:column>

		<display:column headerClass="nosort" media="excel pdf">
		</display:column>
		<display:column property="codice" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.codice.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="codice" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.codice.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="codice" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.codice.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="descIndirizzoCompleto" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.descIndirizzoCompleto.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descIndirizzoCompleto" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.descIndirizzoCompleto.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descIndirizzoCompleto" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.descIndirizzoCompleto.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="dtUpload" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.dtUpload.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dtUpload" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.dtUpload.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dtUpload" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.dtUpload.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="dtScadenza" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.dtScadenza.label" 
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"   media="html"
			
 >
			
		</display:column>

		<display:column property="dtScadenza" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.dtScadenza.export.label"
			sortable="true" headerClass="sortable"
			comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="excel" />
		<display:column property="dtScadenza" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.dtScadenza.export.label"
			sortable="true" headerClass="sortable"
			 comparator="it.csi.sicee.siceebo.presentation.siceebo.comparator.CsiDateComparator"
			media="pdf" />	
		<display:column property="descStato" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.descStato.label" 
			sortable="true" headerClass="sortable"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="descStato" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.descStato.export.label"
			sortable="true" headerClass="sortable"
			
			media="excel" />
		<display:column property="descStato" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.descStato.export.label"
			sortable="true" headerClass="sortable"
			 
			media="pdf" />	
		<display:column property="flgModulo" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.flgModulo.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="flgModulo" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.flgModulo.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="flgModulo" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.flgModulo.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="flgRicevuta" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.flgRicevuta.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="flgRicevuta" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.flgRicevuta.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="flgRicevuta" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.flgRicevuta.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
		<display:column property="flgTracciato" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.flgTracciato.label" 
			sortable="false" headerClass="nosort"
			    media="html"
			
 >
			
		</display:column>

		<display:column property="flgTracciato" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.flgTracciato.export.label"
			sortable="false" headerClass="nosort"
			
			media="excel" />
		<display:column property="flgTracciato" titleKey="cpDettaglioCertificatore.tblRisultatoAceCert.flgTracciato.export.label"
			sortable="false" headerClass="nosort"
			 
			media="pdf" />	
</display:table>





	
</div>

</s:if>

	



	
	
	
</div>

	<!-- endFragment:p_wpRisApeCert --></div>

			
	
	<div id="p_cpRisApeCert" class="commandPanelBlock"><!-- startFragment:p_cpRisApeCert -->
	
	
<div class="commandPanel functional" id="cpRisApeCert">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpDettaglioCertificatore','bStampaReport')" >

	



<!-- widget bStampaReport -->
<s:submit name="widg_bStampaReport" id="widg_bStampaReport" method="handleBStampaReport_CLICKED"
	key="cpDettaglioCertificatore.bStampaReport.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','bStampaReport')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpDettaglioCertificatore','btnAnnulla')" >

	



<!-- widget btnAnnulla -->
<s:submit name="widg_btnAnnulla" id="widg_btnAnnulla" method="handleBtnAnnulla_CLICKED"
	key="cpDettaglioCertificatore.btnAnnulla.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpDettaglioCertificatore','btnAnnulla')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_cpRisApeCert --></div>

	

		
	
</div>

	<!-- endFragment:p_fpRisApeCert --></div>
