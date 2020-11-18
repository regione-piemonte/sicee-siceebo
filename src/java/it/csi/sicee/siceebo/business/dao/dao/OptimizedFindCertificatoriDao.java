/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dto.OptimizedFindCertificatori;
import it.csi.sicee.siceebo.business.dao.dto.OptimizedFindCertificatoriExport;
import it.csi.sicee.siceebo.business.dao.exceptions.OptimizedFindCertificatoriDaoException;
import it.csi.sicee.siceebo.dto.certificatori.FiltroRicercaCertificatori;
import it.csi.sicee.siceebo.dto.type.UDTDateValid;

import java.util.List;


/**
 * The Interface OptimizedFindCertificatoriDao.
 */
public interface OptimizedFindCertificatoriDao
{
	
	/**
	 * Method 'execute'.
	 *
	 * @param filtro the filtro
	 * @param parametro the parametro
	 * @return List<OptimizedFindCertificatori>
	 * @throws OptimizedFindCertificatoriDaoException the optimized find certificatori dao exception
	 */

	public Integer findElencoCertificatoriCount(FiltroRicercaCertificatori filtro, boolean soloOperativi, Long parametro) throws OptimizedFindCertificatoriDaoException;

	/**
	 * Find elenco certificatori.
	 *
	 * @param filtro the filtro
	 * @param parametro the parametro
	 * @return the list
	 * @throws OptimizedFindCertificatoriDaoException the optimized find certificatori dao exception
	 */
	public List<OptimizedFindCertificatori> findElencoCertificatori(FiltroRicercaCertificatori filtro, boolean soloOperativi, Long parametro) throws OptimizedFindCertificatoriDaoException;

	/**
	 * Find elenco certificatori for export.
	 *
	 * @param idCertificatori the id certificatori
	 * @param dataACEdal the data ac edal
	 * @param dataACEal the data ac eal
	 * @param parametro the parametro
	 * @return the list
	 * @throws OptimizedFindCertificatoriDaoException the optimized find certificatori dao exception
	 */
	public List<OptimizedFindCertificatoriExport> findElencoCertificatoriForExport(List<String> idCertificatori, UDTDateValid dataACEdal, UDTDateValid dataACEal, Long parametro)	throws OptimizedFindCertificatoriDaoException;

}
