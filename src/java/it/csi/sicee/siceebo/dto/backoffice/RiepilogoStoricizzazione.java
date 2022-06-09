package it.csi.sicee.siceebo.dto.backoffice;

public class RiepilogoStoricizzazione implements java.io.Serializable {

	/// Field [logAccessoStor]
	private java.lang.Integer logAccessoStor = null;

	/**
	 * imposta il valore del campo [logAccessoStor]
	 * @param val
	 * @generated
	 */

	public void setLogAccessoStor(java.lang.Integer val) {
		logAccessoStor = val;
	}

	/**
	 * legge il valore del campo [logAccessoStor]
	 * @generated
	 */
	public java.lang.Integer getLogAccessoStor() {
		return logAccessoStor;
	}

	/// Field [logAccessoCanc]
	private java.lang.Integer logAccessoCanc = null;

	/**
	 * imposta il valore del campo [logAccessoCanc]
	 * @param val
	 * @generated
	 */

	public void setLogAccessoCanc(java.lang.Integer val) {
		logAccessoCanc = val;
	}

	/**
	 * legge il valore del campo [logAccessoCanc]
	 * @generated
	 */
	public java.lang.Integer getLogAccessoCanc() {
		return logAccessoCanc;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public RiepilogoStoricizzazione() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R49108428) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
