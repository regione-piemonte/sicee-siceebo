/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDMotivoRilascioDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDMotivoRilascio;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDMotivoRilascioPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDMotivoRilascioDaoException;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeDMotivoRilascioDao.
 */
public interface SiceeDMotivoRilascioDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeDMotivoRilascioPk
	 */
	public SiceeDMotivoRilascioPk insert(SiceeDMotivoRilascio dto);

	/**
	 * Updates a single row in the SICEE_D_MOTIVO_RILASCIO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public void update(SiceeDMotivoRilascioPk pk, SiceeDMotivoRilascio dto) throws SiceeDMotivoRilascioDaoException;

	/**
	 * Deletes a single row in the SICEE_D_MOTIVO_RILASCIO table.
	 *
	 * @param pk the pk
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public void delete(SiceeDMotivoRilascioPk pk) throws SiceeDMotivoRilascioDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'ID_MOTIVO = :idMotivo'.
	 *
	 * @param idMotivo the id motivo
	 * @return the sicee d motivo rilascio
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public SiceeDMotivoRilascio findByPrimaryKey(Integer idMotivo) throws SiceeDMotivoRilascioDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public List<SiceeDMotivoRilascio> findAll() throws SiceeDMotivoRilascioDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'ID_MOTIVO = :idMotivo'.
	 *
	 * @param idMotivo the id motivo
	 * @return the list
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public List<SiceeDMotivoRilascio> findWhereIdMotivoEquals(Integer idMotivo) throws SiceeDMotivoRilascioDaoException;

	/**
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'DESCR = :descr'.
	 *
	 * @param descr the descr
	 * @return the list
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public List<SiceeDMotivoRilascio> findWhereDescrEquals(String descr) throws SiceeDMotivoRilascioDaoException;

	/** 
	 * Returns all rows from the SICEE_D_MOTIVO_RILASCIO table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	public List<SiceeDMotivoRilascio> findWhereFlgAttivoEquals(Integer flgAttivo) throws SiceeDMotivoRilascioDaoException;

	
	/**
	 * Returns the rows from the SICEE_D_MOTIVO_RILASCIO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee d motivo rilascio
	 * @throws SiceeDMotivoRilascioDaoException the sicee d motivo rilascio dao exception
	 */
	public SiceeDMotivoRilascio findByPrimaryKey(SiceeDMotivoRilascioPk pk) throws SiceeDMotivoRilascioDaoException;

}
