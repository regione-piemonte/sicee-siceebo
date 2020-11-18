<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgConfermaEliminaCorsoForm" action="cpCorsi" namespace="/base/entiFormativi" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpCorsi.dlgConfermaEliminaCorso.label" /></h3>
				<div class="dialogPanel" id="dlgConfermaEliminaCorso">

		
		
<div id="p_pMsgConfermaEliminaCorso" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgConfermaEliminaCorso -->

	
<div class="msgBoxPanel info" id="pMsgConfermaEliminaCorso">


		
<s:if test="isWidgetVisible('cpCorsi','txtMsgConfermaEliminaCorso')" >

	
<p>


<!-- widget txtMsgConfermaEliminaCorso -->
<s:text name="cpCorsi.txtMsgConfermaEliminaCorso.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgConfermaEliminaCorso --></div>

	
	<div id="p_pCmdConfermaEliminaCorso" class="commandPanelBlock"><!-- startFragment:p_pCmdConfermaEliminaCorso -->
	
	
<div class="commandPanel functional" id="pCmdConfermaEliminaCorso">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpCorsi','bIndietroCorsi')" >

	



<!-- widget bIndietroCorsi -->
<s:submit name="widg_bIndietroCorsi" id="widg_bIndietroCorsi" method="handleBIndietroCorsi_CLICKED"
	key="cpCorsi.bIndietroCorsi.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCorsi','bIndietroCorsi')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpCorsi','bEliminaCorso')" >

	



<!-- widget bEliminaCorso -->
<s:submit name="widg_bEliminaCorso" id="widg_bEliminaCorso" method="handleBEliminaCorso_CLICKED"
	key="cpCorsi.bEliminaCorso.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpCorsi','bEliminaCorso')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdConfermaEliminaCorso --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
