/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.exceptions;

public class SiceeLRicercheCtuDaoException extends DaoException
{
	/**
	 * Method 'SiceeLRicercheCtuDaoException'
	 * 
	 * @param message
	 */
	public SiceeLRicercheCtuDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeLRicercheCtuDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeLRicercheCtuDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
