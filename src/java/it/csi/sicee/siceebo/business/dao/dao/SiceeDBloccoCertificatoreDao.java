/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDBloccoCertificatoreDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDBloccoCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDBloccoCertificatorePk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDBloccoCertificatoreDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDBloccoCertDao.
 */
public interface SiceeDBloccoCertificatoreDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDBloccoCertificatorePk
	 */
	public SiceeDBloccoCertificatorePk insert(SiceeDBloccoCertificatore dto);

	/**
	 * Updates a single row in the SICEE_D_BLOCCO_CERTIFICATORE table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDBloccoCertificatoreDaoException the sicee d stato certificatore dao exception
	 */
	public void update(SiceeDBloccoCertificatorePk pk, SiceeDBloccoCertificatore dto) throws SiceeDBloccoCertificatoreDaoException;

	/**
	 * Deletes a single row in the SICEE_D_BLOCCO_CERTIFICATORE table.
	 *
	 * @param pk the pk
	 * @throws SiceeDBloccoCertificatoreDaoException the sicee d stato certificatore dao exception
	 */
	public void delete(SiceeDBloccoCertificatorePk pk) throws SiceeDBloccoCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_D_BLOCCO_CERTIFICATORE table that match the criteria 'ID_BLOCCO_CERT = :idBloccoCert'.
	 *
	 * @param idBloccoCert the id stato
	 * @return the sicee d stato certificatore
	 * @throws SiceeDBloccoCertificatoreDaoException the sicee d stato certificatore dao exception
	 */
	public SiceeDBloccoCertificatore findByPrimaryKey(Integer idBloccoCert) throws SiceeDBloccoCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_D_BLOCCO_CERTIFICATORE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDBloccoCertDaoException the sicee d stato cert dao exception
	 */
	public List<SiceeDBloccoCertificatore> findAll() throws SiceeDBloccoCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_D_BLOCCO_CERTIFICATORE table that match the criteria 'FLG_BLOCCO = :flgBlocco'.
	 *
	 * @param flgBlocco the flg blocco
	 * @return the list
	 * @throws SiceeDBloccoCertificatoreDaoException the sicee d stato cert dao exception
	 */
	public List<SiceeDBloccoCertificatore> findWhereFlgBloccoEquals(Integer flgBlocco) throws SiceeDBloccoCertificatoreDaoException;



}
