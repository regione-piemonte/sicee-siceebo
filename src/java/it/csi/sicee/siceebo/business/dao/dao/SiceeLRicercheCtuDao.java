/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeLRicercheCtuDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLRicercheCtu;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLRicercheCtuPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeLRicercheCtuDaoException;
import java.util.Date;
import java.util.List;

public interface SiceeLRicercheCtuDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeLRicercheCtuPk
	 */
	public SiceeLRicercheCtuPk insert(SiceeLRicercheCtu dto);

	/** 
	 * Updates a single row in the SICEE_L_RICERCHE_CTU table.
	 */
	public void update(SiceeLRicercheCtuPk pk, SiceeLRicercheCtu dto) throws SiceeLRicercheCtuDaoException;

	/** 
	 * Deletes a single row in the SICEE_L_RICERCHE_CTU table.
	 */
	public void delete(SiceeLRicercheCtuPk pk) throws SiceeLRicercheCtuDaoException;

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria 'CF_CTU = :cfCtu AND DATA_RICERCA = :dataRicerca'.
	 */
	public SiceeLRicercheCtu findByPrimaryKey(String cfCtu, Date dataRicerca) throws SiceeLRicercheCtuDaoException;

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria ''.
	 */
	public List<SiceeLRicercheCtu> findAll() throws SiceeLRicercheCtuDaoException;

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria 'CF_CTU = :cfCtu'.
	 */
	public List<SiceeLRicercheCtu> findWhereCfCtuEquals(String cfCtu) throws SiceeLRicercheCtuDaoException;

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria 'DATA_RICERCA = :dataRicerca'.
	 */
	public List<SiceeLRicercheCtu> findWhereDataRicercaEquals(Date dataRicerca) throws SiceeLRicercheCtuDaoException;

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria 'MOTIVAZIONE_CTU = :motivazioneCtu'.
	 */
	public List<SiceeLRicercheCtu> findWhereMotivazioneCtuEquals(String motivazioneCtu) throws SiceeLRicercheCtuDaoException;

	/** 
	 * Returns the rows from the SICEE_L_RICERCHE_CTU table that matches the specified primary-key value.
	 */
	public SiceeLRicercheCtu findByPrimaryKey(SiceeLRicercheCtuPk pk) throws SiceeLRicercheCtuDaoException;

}
