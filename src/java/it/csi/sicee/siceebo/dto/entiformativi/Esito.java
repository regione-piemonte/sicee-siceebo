package it.csi.sicee.siceebo.dto.entiformativi;

public class Esito implements java.io.Serializable {

	/// Field [idEsito]
	private java.lang.String idEsito = null;

	/**
	 * imposta il valore del campo [idEsito]
	 * @param val
	 * @generated
	 */

	public void setIdEsito(java.lang.String val) {
		idEsito = val;
	}

	/**
	 * legge il valore del campo [idEsito]
	 * @generated
	 */
	public java.lang.String getIdEsito() {
		return idEsito;
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
	public Esito() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R930571561) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
