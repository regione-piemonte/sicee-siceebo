package it.csi.sicee.siceebo.dto.entiformativi;

public class Decodifica implements java.io.Serializable {

	/// Field [id]
	private java.lang.String id = null;

	/**
	 * imposta il valore del campo [id]
	 * @param val
	 * @generated
	 */

	public void setId(java.lang.String val) {
		id = val;
	}

	/**
	 * legge il valore del campo [id]
	 * @generated
	 */
	public java.lang.String getId() {
		return id;
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
	public Decodifica() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1386489240) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
