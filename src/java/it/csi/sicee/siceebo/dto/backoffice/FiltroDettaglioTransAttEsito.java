package it.csi.sicee.siceebo.dto.backoffice;

public class FiltroDettaglioTransAttEsito implements java.io.Serializable {

	/// Field [idTipoRicerca]
	private java.lang.Integer idTipoRicerca = null;

	/**
	 * imposta il valore del campo [idTipoRicerca]
	 * @param val
	 * @generated
	 */

	public void setIdTipoRicerca(java.lang.Integer val) {
		idTipoRicerca = val;
	}

	/**
	 * legge il valore del campo [idTipoRicerca]
	 * @generated
	 */
	public java.lang.Integer getIdTipoRicerca() {
		return idTipoRicerca;
	}

	/// Field [creazioneDal]
	private it.csi.sicee.siceebo.dto.type.UDTDateValid creazioneDal = null;

	/**
	 * imposta il valore del campo [creazioneDal]
	 * @param val
	 * @generated
	 */

	public void setCreazioneDal(it.csi.sicee.siceebo.dto.type.UDTDateValid val) {
		creazioneDal = val;
	}

	/**
	 * legge il valore del campo [creazioneDal]
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.type.UDTDateValid getCreazioneDal() {
		return creazioneDal;
	}

	/// Field [creazioneAl]
	private it.csi.sicee.siceebo.dto.type.UDTDateValid creazioneAl = null;

	/**
	 * imposta il valore del campo [creazioneAl]
	 * @param val
	 * @generated
	 */

	public void setCreazioneAl(it.csi.sicee.siceebo.dto.type.UDTDateValid val) {
		creazioneAl = val;
	}

	/**
	 * legge il valore del campo [creazioneAl]
	 * @generated
	 */
	public it.csi.sicee.siceebo.dto.type.UDTDateValid getCreazioneAl() {
		return creazioneAl;
	}

	/// Field [idTransazione]
	private java.lang.String idTransazione = null;

	/**
	 * imposta il valore del campo [idTransazione]
	 * @param val
	 * @generated
	 */

	public void setIdTransazione(java.lang.String val) {
		idTransazione = val;
	}

	/**
	 * legge il valore del campo [idTransazione]
	 * @generated
	 */
	public java.lang.String getIdTransazione() {
		return idTransazione;
	}

	/// Field [iuv]
	private java.lang.String iuv = null;

	/**
	 * imposta il valore del campo [iuv]
	 * @param val
	 * @generated
	 */

	public void setIuv(java.lang.String val) {
		iuv = val;
	}

	/**
	 * legge il valore del campo [iuv]
	 * @generated
	 */
	public java.lang.String getIuv() {
		return iuv;
	}

	/// Field [idMdp]
	private java.lang.String idMdp = null;

	/**
	 * imposta il valore del campo [idMdp]
	 * @param val
	 * @generated
	 */

	public void setIdMdp(java.lang.String val) {
		idMdp = val;
	}

	/**
	 * legge il valore del campo [idMdp]
	 * @generated
	 */
	public java.lang.String getIdMdp() {
		return idMdp;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 * @generated
	 */
	public FiltroDettaglioTransAttEsito() {
		super();

	}

	/**
	 * @generated
	 */
	public String toString() {
		/*PROTECTED REGION ID(R1403762007) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
