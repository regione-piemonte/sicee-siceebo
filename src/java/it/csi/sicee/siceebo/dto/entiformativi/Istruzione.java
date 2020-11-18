package it.csi.sicee.siceebo.dto.entiformativi;

public class Istruzione implements java.io.Serializable {

	/// Field [idTipoIstruzione]
	private java.lang.String idTipoIstruzione = null;

	/**
	 * imposta il valore del campo [idTipoIstruzione]
	 * @param val
	 * @generated
	 */

	public void setIdTipoIstruzione(java.lang.String val) {
		idTipoIstruzione = val;
	}

	/**
	 * legge il valore del campo [idTipoIstruzione]
	 * @generated
	 */
	public java.lang.String getIdTipoIstruzione() {
		return idTipoIstruzione;
	}

	/// Field [descr]
	private java.lang.String descr = null;

	/**
	 * imposta il valore del campo [descr]
	 * @param val
	 * @generated
	 */

	public void setDescr(java.lang.String val) {
		descr = val;
	}

	/**
	 * legge il valore del campo [descr]
	 * @generated
	 */
	public java.lang.String getDescr() {
		return descr;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Istruzione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-702400017) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
