/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTEnteformCf2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformCf2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformCf2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTEnteformCf2015DaoException;
import java.util.List;

public interface SiceeTEnteformCf2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTEnteformCf2015Pk
	 */
	public SiceeTEnteformCf2015Pk insert(SiceeTEnteformCf2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_ENTEFORM_CF_2015 table.
	 */
	public void update(SiceeTEnteformCf2015Pk pk, SiceeTEnteformCf2015 dto) throws SiceeTEnteformCf2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_ENTEFORM_CF_2015 table.
	 */
	public void delete(SiceeTEnteformCf2015Pk pk) throws SiceeTEnteformCf2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria 'ID_ENTE = :idEnte AND CF_CERTIFICATO = :cfCertificato'.
	 */
	public SiceeTEnteformCf2015 findByPrimaryKey(long idEnte, String cfCertificato) throws SiceeTEnteformCf2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria ''.
	 */
	public List<SiceeTEnteformCf2015> findAll() throws SiceeTEnteformCf2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	public List<SiceeTEnteformCf2015> findBySiceeTEnteformativo2015(long idEnte) throws SiceeTEnteformCf2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	public List<SiceeTEnteformCf2015> findWhereIdEnteEquals(long idEnte) throws SiceeTEnteformCf2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria 'CF_CERTIFICATO = :cfCertificato'.
	 */
	public List<SiceeTEnteformCf2015> findWhereCfCertificatoEquals(String cfCertificato) throws SiceeTEnteformCf2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_ENTEFORM_CF_2015 table that matches the specified primary-key value.
	 */
	public SiceeTEnteformCf2015 findByPrimaryKey(SiceeTEnteformCf2015Pk pk) throws SiceeTEnteformCf2015DaoException;

}
