package it.csi.sicee.siceebo.dto.ace;

public class Annullamento implements java.io.Serializable {

	/// Field [data]
	private java.lang.String data = null;

	/**
	 * imposta il valore del campo [data]
	 * @param val
	 * @generated
	 */

	public void setData(java.lang.String val) {
		data = val;
	}

	/**
	 * legge il valore del campo [data]
	 * @generated
	 */
	public java.lang.String getData() {
		return data;
	}

	/// Field [motivazione]
	private java.lang.String motivazione = null;

	/**
	 * imposta il valore del campo [motivazione]
	 * @param val
	 * @generated
	 */

	public void setMotivazione(java.lang.String val) {
		motivazione = val;
	}

	/**
	 * legge il valore del campo [motivazione]
	 * @generated
	 */
	public java.lang.String getMotivazione() {
		return motivazione;
	}

	/// Field [idMotivo]
	private java.lang.Integer idMotivo = null;

	/**
	 * imposta il valore del campo [idMotivo]
	 * @param val
	 * @generated
	 */

	public void setIdMotivo(java.lang.Integer val) {
		idMotivo = val;
	}

	/**
	 * legge il valore del campo [idMotivo]
	 * @generated
	 */
	public java.lang.Integer getIdMotivo() {
		return idMotivo;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public Annullamento() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R-1538327867) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
