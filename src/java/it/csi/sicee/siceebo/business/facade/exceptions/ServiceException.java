/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.facade.exceptions;


public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7583376730326946211L;
	
	protected Throwable throwable;
	
	
	/**
	 * Inizializza un'istanza della classe
	 * 
	 * @param cause Causa dell'eccezione
	 * @param msg Messaggio associato all'eccezione
	 */
	public ServiceException(Throwable cause, String msg) {
		super(msg, cause);
	}
	
	public ServiceException(String msg){
		super(msg);
	}
	
}
