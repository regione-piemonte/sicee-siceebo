/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTActaDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTActa;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTActaPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTActaDaoException;
import java.util.Date;
import java.util.List;

public interface SiceeTActaDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTActaPk
	 */
	public SiceeTActaPk insert(SiceeTActa dto);

	/** 
	 * Updates a single row in the SICEE_T_ACTA table.
	 */
	public void update(SiceeTActaPk pk, SiceeTActa dto) throws SiceeTActaDaoException;

	public void updateRisanaProtAnomali() throws SiceeTActaDaoException;

	/** 
	 * Deletes a single row in the SICEE_T_ACTA table.
	 */
	public void delete(SiceeTActaPk pk) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	public SiceeTActa findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria ''.
	 */
	public List<SiceeTActa> findAll() throws SiceeTActaDaoException;

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria ''.
	 */
	public List<SiceeTActa> findProtocolloAnomalo() throws SiceeTActaDaoException;


	/** 
	 * Returns the rows from the SICEE_T_ACTA table that matches the specified primary-key value.
	 */
	public SiceeTActa findByPrimaryKey(SiceeTActaPk pk) throws SiceeTActaDaoException;

}
