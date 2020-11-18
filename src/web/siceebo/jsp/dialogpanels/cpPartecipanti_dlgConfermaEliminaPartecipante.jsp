<%@taglib uri="/struts-tags" prefix="s" %>
<s:include value="../fragments/header.jsp" ></s:include>

<s:form id="dlgConfermaEliminaPartecipanteForm" action="cpPartecipanti" namespace="/base/entiFormativi" method="post">

	<!-- ####################### PANNELLO CONTENUTI ###################### -->
	<div id="contentPanel">
		<div id="centerWrapper" class="floatWrapper">
			<div id="centerPanel">
			
			<a id="main_content" name="main_content"></a>
				<h3><s:text name="cpPartecipanti.dlgConfermaEliminaPartecipante.label" /></h3>
				<div class="dialogPanel" id="dlgConfermaEliminaPartecipante">

		
		
<div id="p_pMsgConfermaEliminaPartecipante" class="msgBoxPanelBlock"><!-- startFragment:p_pMsgConfermaEliminaPartecipante -->

	
<div class="msgBoxPanel info" id="pMsgConfermaEliminaPartecipante">


		
<s:if test="isWidgetVisible('cpPartecipanti','txtMsgConfermaEliminaPartecipante')" >

	
<p>


<!-- widget txtMsgConfermaEliminaPartecipante -->
<s:text name="cpPartecipanti.txtMsgConfermaEliminaPartecipante.statictext.label" />

	
</p>

</s:if>

	


	
</div>

<!-- endFragment:p_pMsgConfermaEliminaPartecipante --></div>

	
	<div id="p_pCmdConfermaEliminaPartecipante" class="commandPanelBlock"><!-- startFragment:p_pCmdConfermaEliminaPartecipante -->
	
	
<div class="commandPanel functional" id="pCmdConfermaEliminaPartecipante">

	
	
		

	
	
	
	<div class="button left">
		
<s:if test="isWidgetVisible('cpPartecipanti','bIndietroPartecipanti')" >

	



<!-- widget bIndietroPartecipanti -->
<s:submit name="widg_bIndietroPartecipanti" id="widg_bIndietroPartecipanti" method="handleBIndietroPartecipanti_CLICKED"
	key="cpPartecipanti.bIndietroPartecipanti.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPartecipanti','bIndietroPartecipanti')" />

	


</s:if>

	


	</div>
	
	

	
	
	
	

	
	
	
	<div class="button right">
		
<s:if test="isWidgetVisible('cpPartecipanti','bEliminaPartecipante')" >

	



<!-- widget bEliminaPartecipante -->
<s:submit name="widg_bEliminaPartecipante" id="widg_bEliminaPartecipante" method="handleBEliminaPartecipante_CLICKED"
	key="cpPartecipanti.bEliminaPartecipante.label" cssClass="buttonWidget"
	disabled="isWidgetDisabled('cpPartecipanti','bEliminaPartecipante')" />

	


</s:if>

	


	</div>
	
	
	
	
	
	
	



	
	
</div>

	<!-- endFragment:p_pCmdConfermaEliminaPartecipante --></div>

				</div>

			</div>
		</div>
	</div>
	<!-- #################### FINE PANNELLO CONTENUTI #################### -->

</s:form>

<s:include value="../fragments/footer.jsp" ></s:include>
