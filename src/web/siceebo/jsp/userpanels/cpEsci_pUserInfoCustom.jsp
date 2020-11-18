<%@taglib uri="/struts-tags" prefix="s" %>
<div id="p_pUserInfoCustom" class="panelBlock"><!-- startFragment:p_pUserInfoCustom -->
<div class="userDefinedPanel" id="pUserInfoCustom">
<!--PROTECTED REGION ID(R525290460) ENABLED START-->
<!-- Inserire il codice del pannello -->
<div id="contUtente">
	<div id="Utente">
	<s:if test="appDatacurrentUser != null">
		<span id="datiUtente">
			Utente: <strong><s:property value="appDatacurrentUser.nome" /> <s:property value="appDatacurrentUser.cognome" /></strong> 
		</span>
	</s:if>
	<s:else>
		<span id="datiUtente"><FONT color="red">ERRORE NEL TESTALINO!!!</FONT></span>
	</s:else>
	
</div>
<!--PROTECTED REGION END-->
</div>
<!-- endFragment:p_pUserInfoCustom --></div>
