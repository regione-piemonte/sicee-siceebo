/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTParametriDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTParametriDao.
 */
public interface SiceeTParametriDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTParametriPk
	 */
	public SiceeTParametriPk insert(SiceeTParametri dto);

	/**
	 * Updates a single row in the SICEE_T_PARAMETRI table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public void update(SiceeTParametriPk pk, SiceeTParametri dto) throws SiceeTParametriDaoException;

	/**
	 * Deletes a single row in the SICEE_T_PARAMETRI table.
	 *
	 * @param pk the pk
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public void delete(SiceeTParametriPk pk) throws SiceeTParametriDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'CODICE = :codice'.
	 *
	 * @param codice the codice
	 * @return the sicee t parametri
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public SiceeTParametri findByPrimaryKey(String codice) throws SiceeTParametriDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public List<SiceeTParametri> findAll() throws SiceeTParametriDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'CODICE = :codice'.
	 *
	 * @param codice the codice
	 * @return the list
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public List<SiceeTParametri> findWhereCodiceEquals(String codice) throws SiceeTParametriDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'VALORE = :valore'.
	 *
	 * @param valore the valore
	 * @return the list
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public List<SiceeTParametri> findWhereValoreEquals(String valore) throws SiceeTParametriDaoException;

	/**
	 * Returns the rows from the SICEE_T_PARAMETRI table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t parametri
	 * @throws SiceeTParametriDaoException the sicee t parametri dao exception
	 */
	public SiceeTParametri findByPrimaryKey(SiceeTParametriPk pk) throws SiceeTParametriDaoException;

}
