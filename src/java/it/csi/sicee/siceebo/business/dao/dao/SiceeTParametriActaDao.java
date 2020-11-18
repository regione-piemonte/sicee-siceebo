/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTParametriActaDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriActa;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriActaPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTParametriActaDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTParametriDao.
 */
public interface SiceeTParametriActaDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTParametriActaPk
	 */
	public SiceeTParametriActaPk insert(SiceeTParametriActa dto);

	/**
	 * Updates a single row in the SICEE_T_PARAMETRI_ACTA table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTParametriActaDaoException the sicee t parametri dao exception
	 */
	public void update(SiceeTParametriActaPk pk, SiceeTParametriActa dto) throws SiceeTParametriActaDaoException;

	/**
	 * Deletes a single row in the SICEE_T_PARAMETRI table.
	 *
	 * @param pk the pk
	 * @throws SiceeTParametriActaDaoException the sicee t parametri dao exception
	 */
	public void delete(SiceeTParametriActaPk pk) throws SiceeTParametriActaDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI_ACTA table that match the criteria 'CODICE = :codice'.
	 *
	 * @param codice the codice
	 * @return the sicee t parametri
	 * @throws SiceeTParametriActaDaoException the sicee t parametri dao exception
	 */
	public SiceeTParametriActa findByPrimaryKey(Integer codice) throws SiceeTParametriActaDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI_ACTA table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTParametriActaDaoException the sicee t parametri dao exception
	 */
	public List<SiceeTParametriActa> findAll() throws SiceeTParametriActaDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI_ACTA table that match the criteria 'CODICE = :codice'.
	 *
	 * @param codice the codice
	 * @return the list
	 * @throws SiceeTParametriActaDaoException the sicee t parametri dao exception
	 */
	public List<SiceeTParametriActa> findWhereCodiceEquals(String codice) throws SiceeTParametriActaDaoException;

	/**
	 * Returns all rows from the SICEE_T_PARAMETRI_ACTA table that match the criteria 'VALORE = :valore'.
	 *
	 * @param valore the valore
	 * @return the list
	 * @throws SiceeTParametriActaDaoException the sicee t parametri dao exception
	 */
	public List<SiceeTParametriActa> findWhereValoreEquals(String valore) throws SiceeTParametriActaDaoException;

	/**
	 * Returns the rows from the SICEE_T_PARAMETRI_ACTA table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t parametri
	 * @throws SiceeTParametriActaDaoException the sicee t parametri dao exception
	 */
	public SiceeTParametriActa findByPrimaryKey(SiceeTParametriActaPk pk) throws SiceeTParametriActaDaoException;

}
