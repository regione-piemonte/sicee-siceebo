/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTCorso2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCorso2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCorso2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTCorso2015DaoException;
import java.util.Date;
import java.util.List;

public interface SiceeTCorso2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTCorso2015Pk
	 */
	public SiceeTCorso2015Pk insert(SiceeTCorso2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_CORSOENTEFORM_2015 table.
	 */
	public void update(SiceeTCorso2015Pk pk, SiceeTCorso2015 dto) throws SiceeTCorso2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_CORSOENTEFORM_2015 table.
	 */
	public void delete(SiceeTCorso2015Pk pk) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'ID_CORSO = :idCorso'.
	 */
	public SiceeTCorso2015 findByPrimaryKey(long idCorso) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria ''.
	 */
	public List<SiceeTCorso2015> findAll() throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	public List<SiceeTCorso2015> findBySiceeTEnteformativo2015(long idEnte) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'ID_CORSO = :idCorso'.
	 */
	public List<SiceeTCorso2015> findWhereIdCorsoEquals(long idCorso) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	public List<SiceeTCorso2015> findWhereIdEnteEquals(long idEnte) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'TITOLO = :titolo'.
	 */
	public List<SiceeTCorso2015> findWhereTitoloEquals(String titolo) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'TOTALE_ORE = :totaleOre'.
	 */
	public List<SiceeTCorso2015> findWhereTotaleOreEquals(long totaleOre) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'N_PARTECIPANTI = :nPartecipanti'.
	 */
	public List<SiceeTCorso2015> findWhereNPartecipantiEquals(long nPartecipanti) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'DATA_ESAME = :dataEsame'.
	 */
	public List<SiceeTCorso2015> findWhereDataEsameEquals(Date dataEsame) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'CORSO_DAL = :corsoDal'.
	 */
	public List<SiceeTCorso2015> findWhereCorsoDalEquals(Date corsoDal) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_CORSOENTEFORM_2015 table that match the criteria 'CORSO_AL = :corsoAl'.
	 */
	public List<SiceeTCorso2015> findWhereCorsoAlEquals(Date corsoAl) throws SiceeTCorso2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_CORSOENTEFORM_2015 table that matches the specified primary-key value.
	 */
	public SiceeTCorso2015 findByPrimaryKey(SiceeTCorso2015Pk pk) throws SiceeTCorso2015DaoException;

}
