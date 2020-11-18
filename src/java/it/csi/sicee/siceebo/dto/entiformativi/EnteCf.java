package it.csi.sicee.siceebo.dto.entiformativi;

public class EnteCf implements java.io.Serializable {

	/// Field [idEnte]
	private long idEnte = 0;

	/**
	 * imposta il valore del campo [idEnte]
	 * @param val
	 * @generated
	 */

	public void setIdEnte(long val) {
		idEnte = val;
	}

	/**
	 * legge il valore del campo [idEnte]
	 * @generated
	 */
	public long getIdEnte() {
		return idEnte;
	}

	/// Field [cfCertificato]
	private java.lang.String cfCertificato = null;

	/**
	 * imposta il valore del campo [cfCertificato]
	 * @param val
	 * @generated
	 */

	public void setCfCertificato(java.lang.String val) {
		cfCertificato = val;
	}

	/**
	 * legge il valore del campo [cfCertificato]
	 * @generated
	 */
	public java.lang.String getCfCertificato() {
		return cfCertificato;
	}

	/// Field [ruolo]
	private java.lang.String ruolo = null;

	/**
	 * imposta il valore del campo [ruolo]
	 * @param val
	 * @generated
	 */

	public void setRuolo(java.lang.String val) {
		ruolo = val;
	}

	/**
	 * legge il valore del campo [ruolo]
	 * @generated
	 */
	public java.lang.String getRuolo() {
		return ruolo;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public EnteCf() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R707322274) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
