package it.csi.sicee.siceebo.presentation.decorator.ricercacertificatori;

/*PROTECTED REGION ID(R-195919280) ENABLED START*/
/// inserire qui eventuali import aggiuntive
import it.csi.sicee.siceebo.dto.certificatori.CorsoAttestatoSummary;
import it.csi.sicee.siceebo.util.GenericUtil;
/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDettaglioCertificatoreTblAttPartNewSummaryCustomDecorator extends TableDecorator {

	public CpDettaglioCertificatoreTblAttPartNewSummaryCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R987297549) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public String getFlgScarico() {
		CorsoAttestatoSummary doc = (CorsoAttestatoSummary) this.getCurrentRowObject();

		String ret = null;
		String uid = doc.getUid();

		if (!GenericUtil.isNullOrEmpty(doc.getUid())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceebo/base/ricercaCertificatori/cpDettaglioCertificatore!handleTblAttPartOldSummary_CLICKED.do?idRiga="
					+ uid + "&amp;idColonna=flgScarico\"><span class=\"pdf\">Scarica</a></span></a>";

		}

		return ret;

	}

	/*PROTECTED REGION END*/

}
