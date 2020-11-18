/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTEnteform2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteform2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteform2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTEnteform2015DaoException;
import java.util.List;

public interface SiceeTEnteform2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTEnteform2015Pk
	 */
	public SiceeTEnteform2015Pk insert(SiceeTEnteform2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_ENTEFORM_2015 table.
	 */
	public void update(SiceeTEnteform2015Pk pk, SiceeTEnteform2015 dto) throws SiceeTEnteform2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_ENTEFORM_2015 table.
	 */
	public void delete(SiceeTEnteform2015Pk pk) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	public SiceeTEnteform2015 findByPrimaryKey(long idEnte) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria ''.
	 */
	public List<SiceeTEnteform2015> findAll() throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	public List<SiceeTEnteform2015> findWhereIdEnteEquals(long idEnte) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'FK_ENTE_SL = :fkEnteSl'.
	 */
	public List<SiceeTEnteform2015> findWhereFkEnteSlEquals(long fkEnteSl) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DENOMINAZIONE = :denominazione'.
	 */
	public List<SiceeTEnteform2015> findWhereDenominazioneEquals(String denominazione) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'P_IVA = :pIva'.
	 */
	public List<SiceeTEnteform2015> findWherePIvaEquals(String pIva) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_REGIONE = :idRegione'.
	 */
	public List<SiceeTEnteform2015> findWhereIdRegioneEquals(String idRegione) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DESC_REGIONE = :descRegione'.
	 */
	public List<SiceeTEnteform2015> findWhereDescRegioneEquals(String descRegione) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_PROV = :idProv'.
	 */
	public List<SiceeTEnteform2015> findWhereIdProvEquals(String idProv) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DESC_PROV = :descProv'.
	 */
	public List<SiceeTEnteform2015> findWhereDescProvEquals(String descProv) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	public List<SiceeTEnteform2015> findWhereIdComuneEquals(String idComune) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	public List<SiceeTEnteform2015> findWhereDescComuneEquals(String descComune) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 */
	public List<SiceeTEnteform2015> findWhereIdIndirizzoEquals(String idIndirizzo) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	public List<SiceeTEnteform2015> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'NUM_CIVICO = :numCivico'.
	 */
	public List<SiceeTEnteform2015> findWhereNumCivicoEquals(String numCivico) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'CAP = :cap'.
	 */
	public List<SiceeTEnteform2015> findWhereCapEquals(String cap) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'TELEFONO = :telefono'.
	 */
	public List<SiceeTEnteform2015> findWhereTelefonoEquals(String telefono) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'CELL = :cell'.
	 */
	public List<SiceeTEnteform2015> findWhereCellEquals(String cell) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'EMAIL = :email'.
	 */
	public List<SiceeTEnteform2015> findWhereEmailEquals(String email) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'EMAIL_PEC = :emailPec'.
	 */
	public List<SiceeTEnteform2015> findWhereEmailPecEquals(String emailPec) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'FAX = :fax'.
	 */
	public List<SiceeTEnteform2015> findWhereFaxEquals(String fax) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'SITO_WEB = :sitoWeb'.
	 */
	public List<SiceeTEnteform2015> findWhereSitoWebEquals(String sitoWeb) throws SiceeTEnteform2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_ENTEFORM_2015 table that matches the specified primary-key value.
	 */
	public SiceeTEnteform2015 findByPrimaryKey(SiceeTEnteform2015Pk pk) throws SiceeTEnteform2015DaoException;

}
