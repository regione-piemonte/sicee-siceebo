/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoenteform2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoenteform2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoenteform2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoenteform2015DaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDTipoenteform2015Dao.
 */
public interface SiceeDTipoenteform2015Dao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDTipoenteform2015Pk
	 */
	public SiceeDTipoenteform2015Pk insert(SiceeDTipoenteform2015 dto);

	/**
	 * Updates a single row in the SICEE_D_TIPO_ENTEFORM_2015 table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDTipoenteform2015DaoException the sicee d tipo enteform 2015 dao exception
	 */
	public void update(SiceeDTipoenteform2015Pk pk, SiceeDTipoenteform2015 dto) throws SiceeDTipoenteform2015DaoException;

	/**
	 * Deletes a single row in the SICEE_D_TIPO_ENTEFORM_2015 table.
	 *
	 * @param pk the pk
	 * @throws SiceeDTipoenteform2015DaoException the sicee d tipo enteform 2015 dao exception
	 */
	public void delete(SiceeDTipoenteform2015Pk pk) throws SiceeDTipoenteform2015DaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_ENTEFORM_2015 table that match the criteria 'ID_STATO = :idTipoenteform'.
	 *
	 * @param idTipoenteform the id stato
	 * @return the sicee d tipo enteform 2015
	 * @throws SiceeDTipoenteform2015DaoException the sicee d tipo enteform 2015 dao exception
	 */
	public SiceeDTipoenteform2015 findByPrimaryKey(String idTipoenteform) throws SiceeDTipoenteform2015DaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_ENTEFORM_2015 table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDTipoenteform2015DaoException the sicee d tipo enteform 2015 dao exception
	 */
	public List<SiceeDTipoenteform2015> findAll() throws SiceeDTipoenteform2015DaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_ENTEFORM_2015 table that match the criteria 'ID_STATO = :idTipoenteform'.
	 *
	 * @param idTipoenteform the id stato
	 * @return the list
	 * @throws SiceeDTipoenteform2015DaoException the sicee d tipo enteform 2015 dao exception
	 */
	public List<SiceeDTipoenteform2015> findWhereIdTipoenteformEquals(String idTipoenteform) throws SiceeDTipoenteform2015DaoException;

	/**
	 * Returns all rows from the SICEE_D_TIPO_ENTEFORM_2015 table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDTipoenteform2015DaoException the sicee d tipo enteform 2015 dao exception
	 */
	public List<SiceeDTipoenteform2015> findWhereDescrEquals(String descr) throws SiceeDTipoenteform2015DaoException;

	/**
	 * Returns the rows from the SICEE_D_TIPO_ENTEFORM_2015 table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d tipo enteform 2015
	 * @throws SiceeDTipoenteform2015DaoException the sicee d tipo enteform 2015 dao exception
	 */
	public SiceeDTipoenteform2015 findByPrimaryKey(SiceeDTipoenteform2015Pk pk) throws SiceeDTipoenteform2015DaoException;

}
