package it.csi.sicee.siceebo.presentation.decorator.ricercacertificatori;

/*PROTECTED REGION ID(R-1235609473) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import it.csi.sicee.siceebo.dto.certificatori.DocumentSummary;
import it.csi.sicee.siceebo.util.GenericUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDettaglioCertificatoreTblCurriculumSummaryCustomDecorator extends TableDecorator {

	public CpDettaglioCertificatoreTblCurriculumSummaryCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R1759399164) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2 

	public String getFlgScarico() {
		DocumentSummary curr = (DocumentSummary) this.getCurrentRowObject();

		String ret = null;

		//String codice = curr.getCod();
		String uid = curr.getUid();

		if (!GenericUtil.isNullOrEmpty(curr.getFlgScarico())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceebo/base/ricercaCertificatori/cpDettaglioCertificatore!handleTblCurriculumSummary_CLICKED.do?idRiga="
					+ uid + "&amp;idColonna=flgScarico\"><span class=\"pdf\">Scarica</span></a>";

		}

		return ret;

	}

	/*PROTECTED REGION END*/

}
