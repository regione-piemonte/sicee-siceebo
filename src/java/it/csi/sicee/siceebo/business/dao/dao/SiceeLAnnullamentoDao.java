/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeLAnnullamentoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLAnnullamento;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLAnnullamentoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeLAnnullamentoDaoException;

import java.util.Date;
import java.util.List;

public interface SiceeLAnnullamentoDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeLAnnullamentoPk
	 */
	public SiceeLAnnullamentoPk insert(SiceeLAnnullamento dto);

	/** 
	 * Updates a single row in the SICEE_L_ANNULLAMENTO table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeLAnnullamentoDaoException the sicee l annullamento dao exception
	 */
	public void update(SiceeLAnnullamentoPk pk, SiceeLAnnullamento dto) throws SiceeLAnnullamentoDaoException;

	/** 
	 * Deletes a single row in the SICEE_L_ANNULLAMENTO table.
	 *
	 * @param pk the pk
	 * @throws SiceeLAnnullamentoDaoException the sicee l annullamento dao exception
	 */
	public void delete(SiceeLAnnullamentoPk pk) throws SiceeLAnnullamentoDaoException;

	/** 
	 * Returns all rows from the SICEE_L_ANNULLAMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 *
	 * @param idCertificatore the id certificatore
	 * @param progrCertificato the progr certificato
	 * @param anno the anno
	 * @return the sicee l annullamento
	 * @throws SiceeLAnnullamentoDaoException the sicee l annullamento dao exception
	 */
	public SiceeLAnnullamento findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeLAnnullamentoDaoException;


	/** 
	 * Returns the rows from the SICEE_L_ANNULLAMENTO table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee l annullamento
	 * @throws SiceeLAnnullamentoDaoException the sicee l annullamento dao exception
	 */
	public SiceeLAnnullamento findByPrimaryKey(SiceeLAnnullamentoPk pk) throws SiceeLAnnullamentoDaoException;

}
