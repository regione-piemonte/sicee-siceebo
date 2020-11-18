/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.exceptions;

public class SiceeDTipoCorsoDaoException extends DaoException
{
	/**
	 * Method 'SiceeDTipoCorsoDaoException'
	 * 
	 * @param message
	 */
	public SiceeDTipoCorsoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeDTipoCorsoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeDTipoCorsoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
