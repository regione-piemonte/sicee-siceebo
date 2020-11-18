package it.csi.sicee.siceebo.presentation.decorator.ricercacertificatori;

/*PROTECTED REGION ID(R-383356755) ENABLED START*/
/// inserire qui eventuali import aggiuntive

import it.csi.sicee.siceebo.dto.certificatori.DocumentSummary;
import it.csi.sicee.siceebo.util.GenericUtil;

/*PROTECTED REGION END*/

import org.displaytag.decorator.TableDecorator;

public class CpDettaglioCertificatoreTblTitoloStudioSummaryCustomDecorator extends TableDecorator {

	public CpDettaglioCertificatoreTblTitoloStudioSummaryCustomDecorator() {
		super();

	}

	/*PROTECTED REGION ID(R-912336726) ENABLED START*/
	/// Questo spazio e' destinato alla definizione del Decorator.
	/// La documentazione sull'utilizzo dei decoratori della display tag e' disponibile all'url:
	/// http://displaytag.sourceforge.net/1.2  

	public String getFlgScarico() {
		DocumentSummary doc = (DocumentSummary) this.getCurrentRowObject();

		String ret = null;
		//String codice = doc.getCod();
		String uid = doc.getUid();

		if (!GenericUtil.isNullOrEmpty(doc.getFlgScarico())) {

			ret = "<a id=\"id_linkable_cell\" href=\"/siceebo/base/ricercaCertificatori/cpDettaglioCertificatore!handleTblTitoloStudioSummary_CLICKED.do?idRiga="
					+ uid
					//+ codice
					+ "&amp;idColonna=flgScarico\"><span class=\"pdf\">Scarica</a></span></a>";
		}

		return ret;

	}

	/*PROTECTED REGION END*/

}
