/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.exceptions;

import it.csi.sicee.siceebo.util.Constants;

import org.apache.log4j.Logger;

public class SiceeTCertificatoreDaoException extends DaoException
{
	/**
	 * Method 'SiceeTCertificatoreDaoException'
	 * 
	 * @param message
	 */
	public SiceeTCertificatoreDaoException(String message)
	{
		
		super(message);
		Logger log = Logger.getLogger(Constants.APPLICATION_CODE
				+ ".business");
			log.debug(message);
	}

	/**
	 * Method 'SiceeTCertificatoreDaoException'
	 * 
	 * @param message
	 * @param cause
	 */
	public SiceeTCertificatoreDaoException(String message, Throwable cause)
	{
		
		super(message, cause);
		Logger log = Logger.getLogger(Constants.APPLICATION_CODE
				+ ".business");
			log.debug(message);
			log.debug(cause);
	}

}
