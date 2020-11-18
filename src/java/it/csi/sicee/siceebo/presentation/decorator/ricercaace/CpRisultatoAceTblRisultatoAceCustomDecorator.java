package it.csi.sicee.siceebo.presentation.decorator.ricercaace;

/*PROTECTED REGION ID(R1318606193) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import it.csi.sicee.siceebo.dto.ace.Ace;
import it.csi.sicee.siceebo.util.GenericUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpRisultatoAceTblRisultatoAceCustomDecorator extends TableDecorator {

	public CpRisultatoAceTblRisultatoAceCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1493900910) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2 

	public String getFlgModulo() {
		Ace ace = (Ace) this.getCurrentRowObject();

		String ret = null;

		String codice = ace.getCodice();

		if (!GenericUtil.isNullOrEmpty(ace.getFlgModulo())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceebo/base/ricercaAce/cpRisultatoAce!handleTblRisultatoAce_CLICKED.do?idRiga="
					+ codice + "&amp;idColonna=flgModulo\"><span class=\"pdf\">Modulo A.P.E.</span></a>";

		}

		return ret;

	}

	public String getFlgRicevuta() {
		Ace ace = (Ace) this.getCurrentRowObject();

		String ret = null;

		String codice = ace.getCodice();

		if (!GenericUtil.isNullOrEmpty(ace.getFlgRicevuta())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceebo/base/ricercaAce/cpRisultatoAce!handleTblRisultatoAce_CLICKED.do?idRiga="
					+ codice + "&amp;idColonna=flgRicevuta\"><span class=\"pdf\">Ricevuta A.P.E.</span></a>";

		}

		return ret;

	}

	public String getFlgTracciato() {
		Ace ace = (Ace) this.getCurrentRowObject();

		String ret = null;

		String codice = ace.getCodice();

		if (!GenericUtil.isNullOrEmpty(ace.getFlgTracciato())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceebo/base/ricercaAce/cpRisultatoAce!handleTblRisultatoAce_CLICKED.do?idRiga="
					+ codice + "&amp;idColonna=flgTracciato\"><span class=\"pdf\">Tracciato XML</span></a>";

		}

		return ret;

	}
	/*PROTECTED REGION END*/

}
