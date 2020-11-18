/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.exceptions;

public class SiceeDBloccoCertificatoreDaoException extends DaoException
{
	/**
	 * Method 'SiceeDBloccoCertDaoException'
	 * 
	 * @param message
	 */
	public SiceeDBloccoCertificatoreDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDBloccoCertDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDBloccoCertificatoreDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
