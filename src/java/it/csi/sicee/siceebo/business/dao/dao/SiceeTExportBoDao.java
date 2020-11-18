/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTExportBoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBo;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTExportBoDaoException;
import it.csi.sicee.siceebo.dto.ace.FiltroRicercaAce;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTExportBoDao.
 */
public interface SiceeTExportBoDao
{
	
	public void updateStato(SiceeTExportBoPk pk, Integer fkStato) throws SiceeTExportBoDaoException;
	
	/**
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria FiltroRicercaAce.
	 *
	 * @param filtro the filtro
	 * @param parametro the parametro
	 * @return the list
	 * @throws SiceeTExportBoDaoException the sicee t export bo dao exception
	 */
	
	public List<SiceeTExportBo> findElencoAceByCodice(FiltroRicercaAce filtro, Long parametro) throws SiceeTExportBoDaoException;

	/**
	 * Find elenco ace by filtro count.
	 *
	 * @param filtro the filtro
	 * @param parametro the parametro
	 * @return the integer
	 * @throws SiceeTExportBoDaoException the sicee t export bo dao exception
	 */
	public Integer findElencoAceByFiltroCount(FiltroRicercaAce filtro, Long parametro) throws SiceeTExportBoDaoException;

	/**
	 * Find elenco ace by filtro.
	 *
	 * @param filtro the filtro
	 * @param parametro the parametro
	 * @return the list
	 * @throws SiceeTExportBoDaoException the sicee t export bo dao exception
	 */
	public List<SiceeTExportBo> findElencoAceByFiltro(FiltroRicercaAce filtro, Long parametro) throws SiceeTExportBoDaoException;

	/**
	 * Find ace by primary key.
	 *
	 * @param key the key
	 * @param isOld the is old
	 * @return the sicee t export bo
	 * @throws SiceeTExportBoDaoException the sicee t export bo dao exception
	 */
	public SiceeTExportBo findAceByPrimaryKey(SiceeTExportBoPk key, boolean isOld) throws SiceeTExportBoDaoException;
}
