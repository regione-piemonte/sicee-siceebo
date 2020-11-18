package it.csi.sicee.siceebo.presentation.decorator.stampaace;

/*PROTECTED REGION ID(R382078543) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import it.csi.sicee.siceebo.dto.ace.Ace;
import it.csi.sicee.siceebo.util.GenericUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpRisultatoAceStampaTblRisultatoAceCustomDecorator extends TableDecorator {

	public CpRisultatoAceStampaTblRisultatoAceCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1886222028) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public String getFlgModulo() {
		Ace ace = (Ace) this.getCurrentRowObject();

		String ret = null;

		String codice = ace.getCodice();

		if (!GenericUtil.isNullOrEmpty(ace.getFlgModulo())) {
			if (ace.getFlgModulo().equalsIgnoreCase("Modulo A.P.E.")) {
				ret = "<a id=\"id_linkable_cell\" href=\"/siceebo/base/stampaAce/cpRisultatoAceStampa!handleTblRisultatoAce_CLICKED.do?idRiga="
						+ codice + "&amp;idColonna=flgModulo\"><span class=\"pdf\">Modulo A.P.E.</span></a>";

			} else if (ace.getFlgModulo().equalsIgnoreCase("Bozza A.P.E.")) {
				ret = "<a id=\"id_linkable_cell\" href=\"/siceebo/base/stampaAce/cpRisultatoAceStampa!handleTblRisultatoAce_CLICKED.do?idRiga="
						+ codice + "&amp;idColonna=flgModuloBozza\"><span class=\"pdf\">Bozza A.P.E.</span></a>";

			}
		}

		return ret;

	}

	/*PROTECTED REGION END*/

}
