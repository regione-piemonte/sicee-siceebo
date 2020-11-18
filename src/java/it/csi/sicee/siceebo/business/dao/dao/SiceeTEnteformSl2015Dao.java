/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTEnteformSl2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformSl2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformSl2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTEnteformSl2015DaoException;
import java.util.List;

public interface SiceeTEnteformSl2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTEnteformSl2015Pk
	 */
	public SiceeTEnteformSl2015Pk insert(SiceeTEnteformSl2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_ENTEFORM_SL_2015 table.
	 */
	public void update(SiceeTEnteformSl2015Pk pk, SiceeTEnteformSl2015 dto) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_ENTEFORM_SL_2015 table.
	 */
	public void delete(SiceeTEnteformSl2015Pk pk) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	public SiceeTEnteformSl2015 findByPrimaryKey(long idEnte) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria ''.
	 */
	public List<SiceeTEnteformSl2015> findAll() throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	public List<SiceeTEnteformSl2015> findWhereIdEnteEquals(long idEnte) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DENOMINAZIONE = :denominazione'.
	 */
	public List<SiceeTEnteformSl2015> findWhereDenominazioneEquals(String denominazione) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'P_IVA = :pIva'.
	 */
	public List<SiceeTEnteformSl2015> findWherePIvaEquals(String pIva) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_REGIONE = :idRegione'.
	 */
	public List<SiceeTEnteformSl2015> findWhereIdRegioneEquals(String idRegione) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DESC_REGIONE = :descRegione'.
	 */
	public List<SiceeTEnteformSl2015> findWhereDescRegioneEquals(String descRegione) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_PROV = :idProv'.
	 */
	public List<SiceeTEnteformSl2015> findWhereIdProvEquals(String idProv) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DESC_PROV = :descProv'.
	 */
	public List<SiceeTEnteformSl2015> findWhereDescProvEquals(String descProv) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	public List<SiceeTEnteformSl2015> findWhereIdComuneEquals(String idComune) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	public List<SiceeTEnteformSl2015> findWhereDescComuneEquals(String descComune) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 */
	public List<SiceeTEnteformSl2015> findWhereIdIndirizzoEquals(String idIndirizzo) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	public List<SiceeTEnteformSl2015> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'NUM_CIVICO = :numCivico'.
	 */
	public List<SiceeTEnteformSl2015> findWhereNumCivicoEquals(String numCivico) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'CAP = :cap'.
	 */
	public List<SiceeTEnteformSl2015> findWhereCapEquals(String cap) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'TELEFONO = :telefono'.
	 */
	public List<SiceeTEnteformSl2015> findWhereTelefonoEquals(String telefono) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'CELL = :cell'.
	 */
	public List<SiceeTEnteformSl2015> findWhereCellEquals(String cell) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'EMAIL = :email'.
	 */
	public List<SiceeTEnteformSl2015> findWhereEmailEquals(String email) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'EMAIL_PEC = :emailPec'.
	 */
	public List<SiceeTEnteformSl2015> findWhereEmailPecEquals(String emailPec) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'FAX = :fax'.
	 */
	public List<SiceeTEnteformSl2015> findWhereFaxEquals(String fax) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'SITO_WEB = :sitoWeb'.
	 */
	public List<SiceeTEnteformSl2015> findWhereSitoWebEquals(String sitoWeb) throws SiceeTEnteformSl2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_ENTEFORM_SL_2015 table that matches the specified primary-key value.
	 */
	public SiceeTEnteformSl2015 findByPrimaryKey(SiceeTEnteformSl2015Pk pk) throws SiceeTEnteformSl2015DaoException;

}
