/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.exceptions;

public class SiceeTParametriActaDaoException extends DaoException
{
	/**
	 * Method 'SiceeTParametriActaDaoException'
	 * 
	 * @param message
	 */
	public SiceeTParametriActaDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTParametriActaDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTParametriActaDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
