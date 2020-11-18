/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.exceptions;

public class SiceeLAnnullamentoDaoException extends DaoException
{
	/**
	 * Method 'SiceeTCertificatoDaoException'
	 * 
	 * @param message
	 */
	public SiceeLAnnullamentoDaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'SiceeTCertificatoDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeLAnnullamentoDaoException(String message, Throwable cause)
	{
		super(message, cause);
	}

}
