<%@ taglib uri="/struts-tags" prefix="s" %>
<div id="p_pUserInfoCustom"><!-- startFragment:p_pUserInfoCustomRegistraz -->
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
	<span id="logout">
		<s:url id="targetUrlEsci" action="cpEsci" includeParams="none"  namespace="/base/main"/>
		<s:a href="%{targetUrlEsci}" title="Disconnetti dal servizio">
			<s:text name="esci" />
		</s:a>
		
	</span>
	</div>
	
</div>

<!-- endFragment:p_pUserInfoCustomRegistraz --></div>
