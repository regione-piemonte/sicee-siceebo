/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTPartecipante2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTPartecipante2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTPartecipante2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTPartecipante2015DaoException;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface SiceeTPartecipante2015Dao
{
	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTPartecipante2015Pk
	 */
	public SiceeTPartecipante2015Pk insert(SiceeTPartecipante2015 dto);

	/** 
	 * Updates a single row in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	public void update(SiceeTPartecipante2015Pk pk, SiceeTPartecipante2015 dto) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Deletes a single row in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	public void delete(SiceeTPartecipante2015Pk pk) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Deletes a multiples rows in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	public void deleteWhereFkCorsoEquals(long fkCorso) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'ID_PARTECIPANTE = :idPartecipante'.
	 */
	public SiceeTPartecipante2015 findByPrimaryKey(long idPartecipante) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria ''.
	 */
	public List<SiceeTPartecipante2015> findAll() throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'FK_CORSO = :fkCorso'.
	 */
	public List<SiceeTPartecipante2015> findBySiceeTCorsoenteform2015(long fkCorso) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'ID_PARTECIPANTE = :idPartecipante'.
	 */
	public List<SiceeTPartecipante2015> findWhereIdPartecipanteEquals(long idPartecipante) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'FK_CORSO = :fkCorso'.
	 */
	public List<SiceeTPartecipante2015> findWhereFkCorsoEquals(long fkCorso) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 */
	public List<SiceeTPartecipante2015> findWhereCodiceFiscaleEquals(String codiceFiscale) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'FK_CORSO = :fkCorso AND CODICE_FISCALE = :codiceFiscale'.
	 */
	public List<SiceeTPartecipante2015> findWhereFkCorsoCodiceFiscaleEquals(long fkCorso, String codiceFiscale) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'NOME = :nome'.
	 */
	public List<SiceeTPartecipante2015> findWhereNomeEquals(String nome) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'COGNOME = :cognome'.
	 */
	public List<SiceeTPartecipante2015> findWhereCognomeEquals(String cognome) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'FK_ISTRUZIONE = :fkIstruzione'.
	 */
	public List<SiceeTPartecipante2015> findWhereFkIstruzioneEquals(Integer fkIstruzione) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'NUM_CERTIFICATORE = :numCertificatore'.
	 */
	public List<SiceeTPartecipante2015> findWhereNumCertificatoreEquals(String numCertificatore) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'ALBO = :albo'.
	 */
	public List<SiceeTPartecipante2015> findWhereAlboEquals(String albo) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'DESC_PROV_ALBO = :descProvAlbo'.
	 */
	public List<SiceeTPartecipante2015> findWhereDescProvAlboEquals(String descProvAlbo) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'NUM_ISCR_ALBO = :numIscrAlbo'.
	 */
	public List<SiceeTPartecipante2015> findWhereNumIscrAlboEquals(String numIscrAlbo) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'DATA_ISCR_ALBO = :dataIscrAlbo'.
	 */
	public List<SiceeTPartecipante2015> findWhereDataIscrAlboEquals(Date dataIscrAlbo) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'DATA_ESAME = :dataEsame'.
	 */
	public List<SiceeTPartecipante2015> findWhereDataEsameEquals(Date dataEsame) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'ESITO_ESAME = :esitoEsame'.
	 */
	public List<SiceeTPartecipante2015> findWhereEsitoEsameEquals(String esitoEsame) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'VOTO_ESAME = :votoEsame'.
	 */
	public List<SiceeTPartecipante2015> findWhereVotoEsameEquals(String votoEsame) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'TELEFONO = :telefono'.
	 */
	public List<SiceeTPartecipante2015> findWhereTelefonoEquals(String telefono) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'EMAIL = :email'.
	 */
	public List<SiceeTPartecipante2015> findWhereEmailEquals(String email) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'NOTE = :note'.
	 */
	public List<SiceeTPartecipante2015> findWhereNoteEquals(String note) throws SiceeTPartecipante2015DaoException;

	/** 
	 * Returns the rows from the SICEE_T_PARTECIPANTE_2015 table that matches the specified primary-key value.
	 */
	public SiceeTPartecipante2015 findByPrimaryKey(SiceeTPartecipante2015Pk pk) throws SiceeTPartecipante2015DaoException;

}
