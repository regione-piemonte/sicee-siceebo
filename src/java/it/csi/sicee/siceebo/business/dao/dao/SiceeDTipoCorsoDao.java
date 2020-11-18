/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoCorsoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDDestUso2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDDestUso2015Pk;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoCorso;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoCorsoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDDestUso2015DaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoCorsoDaoException;

import java.util.List;

public interface SiceeDTipoCorsoDao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeDTipoCorsoPk
	 */
	public SiceeDTipoCorsoPk insert(SiceeDTipoCorso dto);

	/** 
	 * Updates a single row in the SICEE_D_TIPO_CORSO table.
	 */
	public void update(SiceeDTipoCorsoPk pk, SiceeDTipoCorso dto) throws SiceeDTipoCorsoDaoException;

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_CORSO table.
	 */
	public void delete(SiceeDTipoCorsoPk pk) throws SiceeDTipoCorsoDaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_CORSO table that match the criteria 'ID_TIPO_CORSO = :idTipoCorso'.
	 */
	public SiceeDTipoCorso findByPrimaryKey(Integer idTipoCorso) throws SiceeDTipoCorsoDaoException;

	/** 
	 * Returns all rows from the SICEE_D_TIPO_CORSO table that match the criteria ''.
	 */
	public List<SiceeDTipoCorso> findAll() throws SiceeDTipoCorsoDaoException;

	public List<SiceeDTipoCorso> findAllAbilitati() throws SiceeDTipoCorsoDaoException;

	/** 
	 * Returns the rows from the SICEE_D_TIPO_CORSO table that matches the specified primary-key value.
	 */
	public SiceeDTipoCorso findByPrimaryKey(SiceeDTipoCorsoPk pk) throws SiceeDTipoCorsoDaoException;

}
