/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.exceptions;

public class SiceeSAccessoDaoException extends DaoException {

	/**
	 * Method 'SiceeLAccessoDaoException'
	 * 
	 * @param message
	 */
	public SiceeSAccessoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeLAccessoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeSAccessoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
