<%@taglib uri="/struts-tags" prefix="s" %>
<div id="p_pHome" class="panelBlock"><!-- startFragment:p_pHome -->
<div class="userDefinedPanel" id="pHome">
<!--PROTECTED REGION ID(R-567039396) ENABLED START-->
<!-- Inserire il codice del pannello -->
<div class="contenuti">
<dl>
	<s:if test="isMenuVisible('mnuRicCertificatori')">
		<s:if test="isMenuEnabled('mnuRicCertificatori')">
			<dt><s:url id="targetUrlRicercaCertificatori"
				action="goToMnuRicCertificatoriFromMenu" includeParams="none" namespace="/secure"/> <s:a
				href="%{targetUrlRicercaCertificatori}">
				<s:text name="Ricerca certificatori" />
			</s:a></dt>
			<dd>In questa sezione &egrave; possibile effettuare la ricerca
			dei certificatori iscritti all&rsquo;elenco regionale che hanno
			inviato almeno un A.P.E. e visualizzare tutti i dati indicati durante la
			registrazione.</dd>
		</s:if>
<!--		<s:else>
			<dt><s:text name="Ricerca certificatori" /></dt>
			<dd>In questa sezione &egrave; possibile effettuare la ricerca
			dei certificatori iscritti all&rsquo;elenco regionale che hanno
			inviato almeno un A.P.E. e visualizzare tutti i dati indicati durante la
			registrazione.</dd>
		</s:else> -->
	</s:if>

	<s:if test="isMenuVisible('mnuRicCertificatoriAdv')">
		<s:if test="isMenuEnabled('mnuRicCertificatoriAdv')">
			<dt><s:url id="targetUrlRicCertificatoriAdv"
				action="goToMnuRicCertificatoriAdvFromMenu" includeParams="none" namespace="/secure" /> <s:a
				href="%{targetUrlRicCertificatoriAdv}">
				<s:text name="Verifica certificatori" />
			</s:a></dt>
			<dd>In questa sezione &egrave; possibile ricercare i certificatori iscritti al SIPEE al fine di verificare la completezza e veridicit&agrave delle informazioni, documenti ed A.P.E., 
			rispettivamente inseriti e trasmessi, ed eventualmente procedere con le opportune segnalazioni e controlli.</dd>
		</s:if>
<!--		<s:else>
			<dt><s:text name="Ricerca A.P.E." /></dt>
			<dd>In questa sezione &egrave; possibile effettuare delle
			ricerche sui certificatori iscritti al SIPEE, per poter verificare la completezza e veridicit&agrave di informaizoni, documenti ed A.P.E., 
			inseriti e trasmessi, ed eventualmente procedere con le opportune segnalazioni e controlli.</dd>
		</s:else> -->
	</s:if>
	
	<s:if test="isMenuVisible('mnuRicACE')">
		<s:if test="isMenuEnabled('mnuRicACE')">
			<dt><s:url id="targetUrlRicercaAce"
				action="goToMnuRicACEFromMenu" includeParams="none" namespace="/secure" /> <s:a
				href="%{targetUrlRicercaAce}">
				<s:text name="Ricerca A.P.E." />
			</s:a></dt>
			<dd>In questa sezione &egrave; possibile effettuare delle
			ricerche su tutti gli A.P.E. inviati alla Regione per poter visionare i
			certificati originali firmati digitalmente e visualizzare i dati pi&ugrave;
			significativi per poter effettuare i controlli.</dd>
		</s:if>
<!--		<s:else>
			<dt><s:text name="Ricerca A.P.E." /></dt>
			<dd>In questa sezione &egrave; possibile effettuare delle
			ricerche su tutti gli A.P.E. inviati alla Regione per poter visionare i
			certificati originali firmati digitalmente e visualizzare i dati pi&ugrave;
			significativi per poter effettuare i controlli.</dd>
		</s:else> -->
	</s:if>
	
	
	
	<s:if test="isMenuVisible('mnuStampaAce')">
		<dt><s:url id="targetUrlStampaAce"
			action="goToMnuStampaAceFromMenu" includeParams="none" namespace="/secure"/> <s:a
			href="%{targetUrlStampaAce}">
			<s:text name="Stampa A.P.E." />
		</s:a></dt>
		<dd>Preview stampa A.P.E.</dd>
	</s:if>
	
	<s:if test="isMenuVisible('mnuDatiRegistrazione')">
		<s:if test="isMenuEnabled('mnuDatiRegistrazione')">
			<dt><s:url id="targetUrlDatiRegistrazione"
				action="goToMnuDatiRegistrazioneFromMenu" includeParams="none" namespace="/secure" /> <s:a
				href="%{targetUrlDatiRegistrazione}">
				<s:text name="Dati enti e soggetti formativi" />
			</s:a></dt>
			<dd>In questa sezione &egrave; possibile inserire e modificare le informazioni inerenti 
			il soggetto autorizzato a svolgere corsi di formazione e aggiornamento per i <b>certificatori 
			energetici degli edifici</b></dd>
		</s:if>
<!--		<s:else>
			<dt><s:text name="Dati enti e soggetti formativi" /></dt>
			<dd>In questa sezione &egrave; possibile inserire e modificare le informazioni inerenti 
			il soggetto autorizzato a svolgere corsi di formazione e aggiornamento per i <b>certificatori 
			energetici degli edifici</b></dd>
		</s:else> -->
	</s:if>
	<br>
	<s:if test="isMenuVisible('mnuSchedaCorsi')">
		<s:if test="isMenuEnabled('mnuSchedaCorsi')">
			<dt><s:url id="targetUrlSchedaCorsi"
				action="goToMnuSchedaCorsiFromMenu" includeParams="none" namespace="/secure" /> <s:a
				href="%{targetUrlSchedaCorsi}">
				<s:text name="Gestione corsi e partecipanti" />
			</s:a></dt>
			<dd>In questa sezione &egrave; possibile gestire le informazioni inerenti 
			i corsi di formazione e aggiornamento per i <b>certificatori energetici degli edifici</b>, 
			i rispettivi partecipanti, gli esami sostenuti, i relativi esiti ed attestati</dd>
		</s:if>
<!--		<s:else>
			<dt><s:text name="Gestione corsi e partecipanti" /></dt>
			<dd>In questa sezione &egrave; possibile gestire le informazioni inerenti 
			i corsi di formazione e aggiornamento per i <b>certificatori energetici degli edifici</b>, 
			i rispettivi partecipanti, gli esami sostenuti, i relativi esiti ed attestati</dd>
		</s:else> -->
	</s:if>

</dl>
</div>
<!--PROTECTED REGION END-->
</div>
<!-- endFragment:p_pHome --></div>
