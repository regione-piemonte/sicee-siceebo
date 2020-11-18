<%@taglib prefix="s" uri="/struts-tags" %>

	
<div id="mainMenu">
	<h3>Menu di navigazione</h3>
	<ul>
		
<s:if test="isMenuVisible('mnuhome')">
	<s:if test="isMenuEnabled('mnuhome')">
		<s:url id="targetUrlMnuhome" action="goToMnuhomeFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuhome')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuhome}" id="menu_items_mnuhome">
				<s:text name="mnuhome.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuhome.label" /></li>
	</s:else>
	

</s:if>

		
		
<s:if test="isMenuVisible('mnuRicCertificatori')">
	<s:if test="isMenuEnabled('mnuRicCertificatori')">
		<s:url id="targetUrlMnuRicCertificatori" action="goToMnuRicCertificatoriFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRicCertificatori')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRicCertificatori}" id="menu_items_mnuRicCertificatori">
				<s:text name="mnuRicCertificatori.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRicCertificatori.label" /></li>
	</s:else>
	

</s:if>

		
		
<s:if test="isMenuVisible('mnuRicCertificatoriAdv')">
	<s:if test="isMenuEnabled('mnuRicCertificatoriAdv')">
		<s:url id="targetUrlMnuRicCertificatoriAdv" action="goToMnuRicCertificatoriAdvFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRicCertificatoriAdv')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRicCertificatoriAdv}" id="menu_items_mnuRicCertificatoriAdv">
				<s:text name="mnuRicCertificatoriAdv.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRicCertificatoriAdv.label" /></li>
	</s:else>
	

</s:if>

		
		
<s:if test="isMenuVisible('mnuRicACE')">
	<s:if test="isMenuEnabled('mnuRicACE')">
		<s:url id="targetUrlMnuRicACE" action="goToMnuRicACEFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuRicACE')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuRicACE}" id="menu_items_mnuRicACE">
				<s:text name="mnuRicACE.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuRicACE.label" /></li>
	</s:else>
	

</s:if>

		
		
<s:if test="isMenuVisible('mnuStampaAce')">
	<s:if test="isMenuEnabled('mnuStampaAce')">
		<s:url id="targetUrlMnuStampaAce" action="goToMnuStampaAceFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuStampaAce')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuStampaAce}" id="menu_items_mnuStampaAce">
				<s:text name="mnuStampaAce.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuStampaAce.label" /></li>
	</s:else>
	

</s:if>

		
		
			
<s:if test="isMenuVisible('mnuDatiEnteFormativo')">
	<s:if test="isAtLeastOneSubMenuVisible('mnuDatiEnteFormativo')">
	
		<li class="parent<s:property value="%{(isMenuActive('mnuDatiEnteFormativo') || isSubMenuActive('mnuDatiEnteFormativo')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuDatiEnteFormativo')"> id="current"</s:if>><span><s:text name="mnuDatiEnteFormativo.label" /></span>
			<ul>
				

<s:if test="isMenuVisible('mnuDatiRegistrazione')">
	<s:if test="isMenuEnabled('mnuDatiRegistrazione')">
		<s:url id="targetUrlMnuDatiRegistrazione" action="goToMnuDatiRegistrazioneFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuDatiRegistrazione')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuDatiRegistrazione}" id="menu_items_mnuDatiRegistrazione">
				<s:text name="mnuDatiRegistrazione.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuDatiRegistrazione.label" /></li>
	</s:else>
	

</s:if>



			</ul>
		</li>
	
	</s:if>
	<s:else>
	
		<li><s:text name="mnuDatiEnteFormativo.label" /></li>
	
	</s:else>
</s:if>

		
		
			
<s:if test="isMenuVisible('mnuGestioneCorsiPartecipanti')">
	<s:if test="isAtLeastOneSubMenuVisible('mnuGestioneCorsiPartecipanti')">
	
		<li class="parent<s:property value="%{(isMenuActive('mnuGestioneCorsiPartecipanti') || isSubMenuActive('mnuGestioneCorsiPartecipanti')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuGestioneCorsiPartecipanti')"> id="current"</s:if>><span><s:text name="mnuGestioneCorsiPartecipanti.label" /></span>
			<ul>
				

<s:if test="isMenuVisible('mnuSchedaCorsi')">
	<s:if test="isMenuEnabled('mnuSchedaCorsi')">
		<s:url id="targetUrlMnuSchedaCorsi" action="goToMnuSchedaCorsiFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuSchedaCorsi')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuSchedaCorsi}" id="menu_items_mnuSchedaCorsi">
				<s:text name="mnuSchedaCorsi.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuSchedaCorsi.label" /></li>
	</s:else>
	

</s:if>



			</ul>
		</li>
	
	</s:if>
	<s:else>
	
		<li><s:text name="mnuGestioneCorsiPartecipanti.label" /></li>
	
	</s:else>
</s:if>

		
		
			
<s:if test="isMenuVisible('mnuBackOffice')">
	<s:if test="isAtLeastOneSubMenuVisible('mnuBackOffice')">
	
		<li class="parent<s:property value="%{(isMenuActive('mnuBackOffice') || isSubMenuActive('mnuBackOffice')) ? ' active' : ''}" />"<s:if test="isMenuActive('mnuBackOffice')"> id="current"</s:if>><span><s:text name="mnuBackOffice.label" /></span>
			<ul>
				

<s:if test="isMenuVisible('mnuTransazioniMdp')">
	<s:if test="isMenuEnabled('mnuTransazioniMdp')">
		<s:url id="targetUrlMnuTransazioniMdp" action="goToMnuTransazioniMdpFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuTransazioniMdp')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuTransazioniMdp}" id="menu_items_mnuTransazioniMdp">
				<s:text name="mnuTransazioniMdp.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuTransazioniMdp.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuVerificaIndex')">
	<s:if test="isMenuEnabled('mnuVerificaIndex')">
		<s:url id="targetUrlMnuVerificaIndex" action="goToMnuVerificaIndexFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuVerificaIndex')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuVerificaIndex}" id="menu_items_mnuVerificaIndex">
				<s:text name="mnuVerificaIndex.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuVerificaIndex.label" /></li>
	</s:else>
	

</s:if>




<s:if test="isMenuVisible('mnuVerificaActa')">
	<s:if test="isMenuEnabled('mnuVerificaActa')">
		<s:url id="targetUrlMnuVerificaActa" action="goToMnuVerificaActaFromMenu" namespace="/secure" includeParams="none" />
		<li<s:if test="isMenuActive('mnuVerificaActa')"> id="current" class="active"</s:if>>
			<s:a href="%{targetUrlMnuVerificaActa}" id="menu_items_mnuVerificaActa">
				<s:text name="mnuVerificaActa.label" />
			</s:a>
		</li>
	</s:if>
	<s:else>
		<li><s:text name="mnuVerificaActa.label" /></li>
	</s:else>
	

</s:if>



			</ul>
		</li>
	
	</s:if>
	<s:else>
	
		<li><s:text name="mnuBackOffice.label" /></li>
	
	</s:else>
</s:if>

		

		
<!-- STATIC LINKS -->

<%@taglib uri="http://www.csi.it/taglibs/remincl-1.0" prefix="r"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:catch var="ex">
	<r:include url="/ris/utheme/sisp7/siceebo/include/static_links.html" resourceProvider="sp" />
</c:catch>
	</ul>
</div>


