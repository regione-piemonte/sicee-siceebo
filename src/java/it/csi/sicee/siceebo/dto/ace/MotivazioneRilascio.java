/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.dto.ace;

public class MotivazioneRilascio implements java.io.Serializable {

	/// Field [cod]
	private java.lang.String _cod = null;

	public void setCod(java.lang.String val) {
		_cod = val;
	}

	public java.lang.String getCod() {
		return _cod;
	}

	/// Field [nome]
	private java.lang.String _nome = null;

	public void setNome(java.lang.String val) {
		_nome = val;
	}

	public java.lang.String getNome() {
		return _nome;
	}

	// il serial version uid e' fisso in quanto la classe in oggetto e' serializzabile
	// solo per la clusterizzazione della sessione web e non viene scambiata con altre
	// componenti.
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore vuoto del DTO.
	 */
	public MotivazioneRilascio() {
		super();

	}

	public String toString() {
		/*PROTECTED REGION ID(R-778802333) ENABLED START*/
		/// inserire qui la logica desiderata per la rappresenatazione a stringa
		return super.toString();
		/*PROTECTED REGION END*/
	}
}
