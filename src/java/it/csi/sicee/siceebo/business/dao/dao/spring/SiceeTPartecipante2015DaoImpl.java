/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTPartecipante2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTPartecipante2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTPartecipante2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTPartecipante2015DaoException;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTPartecipante2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTPartecipante2015>, SiceeTPartecipante2015Dao
{
	protected JdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	/**
	 * Method 'setDataSource'
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTPartecipante2015Pk
	 */
	
	public SiceeTPartecipante2015Pk insert(SiceeTPartecipante2015 dto)
	{
		dto.setIdPartecipante(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdPartecipante(),dto.getFkCorso(),dto.getCodiceFiscale(),dto.getNome(),dto.getCognome(),dto.getLuogoNascita(), dto.getDataNascita(),dto.getFkTipoIstruzione(),dto.getNumCertificatore(),dto.getAlbo(),dto.getDescProvAlbo(),dto.getNumIscrAlbo(),dto.getDataIscrAlbo(),dto.getPercFreq(),dto.getDataEsame(),dto.getEsitoEsame(),dto.getLuogoEsame(),dto.getVotoEsame(),dto.getTelefono(),dto.getEmail(),dto.getNote());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	
	public void update(SiceeTPartecipante2015Pk pk, SiceeTPartecipante2015 dto) throws SiceeTPartecipante2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_PARTECIPANTE = ?, FK_CORSO = ?, CODICE_FISCALE = ?, NOME = ?, COGNOME = ?, LUOGO_NASCITA = ?, DATA_NASCITA = ?, FK_TIPO_ISTRUZIONE = ?, NUM_CERTIFICATORE = ?, ALBO = ?, DESC_PROV_ALBO = ?, NUM_ISCR_ALBO = ?, DATA_ISCR_ALBO = ?, PERC_FREQ = ?, DATA_ESAME = ?, ESITO_ESAME = ?, LUOGO_ESAME = ?, VOTO_ESAME = ?, TELEFONO = ?, EMAIL = ?, NOTE = ? WHERE ID_PARTECIPANTE = ?",dto.getIdPartecipante(),dto.getFkCorso(),dto.getCodiceFiscale(),dto.getNome(),dto.getCognome(),dto.getLuogoNascita(),dto.getDataNascita(),dto.getFkTipoIstruzione(),dto.getNumCertificatore(),dto.getAlbo(),dto.getDescProvAlbo(),dto.getNumIscrAlbo(),dto.getDataIscrAlbo(),dto.getPercFreq(),dto.getDataEsame(),dto.getEsitoEsame(),dto.getLuogoEsame(),dto.getVotoEsame(),dto.getTelefono(),dto.getEmail(),dto.getNote(),pk.getIdPartecipante());
	}

	/** 
	 * Deletes a single row in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	
	public void delete(SiceeTPartecipante2015Pk pk) throws SiceeTPartecipante2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_PARTECIPANTE = ?",pk.getIdPartecipante());
	}

	/** 
	 * Deletes a multiples rows in the SICEE_T_PARTECIPANTE_2015 table.
	 */
	
	public void deleteWhereFkCorsoEquals(long fkCorso) throws SiceeTPartecipante2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE FK_CORSO = ?",fkCorso);
	}
	
	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTPartecipante2015
	 */
	public SiceeTPartecipante2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTPartecipante2015 dto = new SiceeTPartecipante2015();
		dto.setIdPartecipante( rs.getLong( 1 ) );
		dto.setFkCorso( rs.getLong( 2 ) );
		dto.setCodiceFiscale( rs.getString( 3 ) );
		dto.setNome( rs.getString( 4 ) );
		dto.setCognome( rs.getString( 5 ) );
		dto.setLuogoNascita( rs.getString( 6 ) );
		dto.setDataNascita( rs.getTimestamp( 7 ) );
		dto.setFkTipoIstruzione( new Integer( rs.getInt(8) ) );
		if (rs.wasNull()) {
			dto.setFkTipoIstruzione( null );
		}
		
		dto.setNumCertificatore( rs.getString( 9 ) );
		dto.setAlbo( rs.getString( 10 ) );
		dto.setDescProvAlbo( rs.getString( 11 ) );
		dto.setNumIscrAlbo( rs.getString( 12 ) );
		dto.setDataIscrAlbo( rs.getTimestamp(13 ) );
		dto.setPercFreq( rs.getString(14 ) );
		dto.setDataEsame( rs.getTimestamp(15 ) );
		dto.setEsitoEsame( rs.getString( 16 ) );
		dto.setLuogoEsame( rs.getString( 17 ) );
		dto.setVotoEsame( rs.getString( 18 ) );
		dto.setTelefono( rs.getString( 19 ) );
		dto.setEmail( rs.getString( 20 ) );
		dto.setNote( rs.getString( 21 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_PARTECIPANTE_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'ID_PARTECIPANTE = :idPartecipante'.
	 */
	
	public SiceeTPartecipante2015 findByPrimaryKey(long idPartecipante) throws SiceeTPartecipante2015DaoException
	{
		try {
			List<SiceeTPartecipante2015> list = jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE ID_PARTECIPANTE = ?", this,idPartecipante);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTPartecipante2015> findAll() throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " ORDER BY ID_PARTECIPANTE", this);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'FK_CORSO = :fkCorso'.
	 */
	
	public List<SiceeTPartecipante2015> findBySiceeTCorsoenteform2015(long fkCorso) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE FK_CORSO = ?", this,fkCorso);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'ID_PARTECIPANTE = :idPartecipante'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereIdPartecipanteEquals(long idPartecipante) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE ID_PARTECIPANTE = ? ORDER BY ID_PARTECIPANTE", this,idPartecipante);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'FK_CORSO = :fkCorso'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereFkCorsoEquals(long fkCorso) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE FK_CORSO = ? ORDER BY DATA_ESAME DESC", this,fkCorso);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereCodiceFiscaleEquals(String codiceFiscale) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE CODICE_FISCALE = ? ORDER BY CODICE_FISCALE", this,codiceFiscale);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'FK_CORSO = :fkCorso AND CODICE_FISCALE = :codiceFiscale'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereFkCorsoCodiceFiscaleEquals(long fkCorso, String codiceFiscale) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE FK_CORSO = ? AND CODICE_FISCALE = ? ORDER BY CODICE_FISCALE", this,fkCorso,codiceFiscale);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'NOME = :nome'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereNomeEquals(String nome) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE NOME = ? ORDER BY NOME", this,nome);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'COGNOME = :cognome'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereCognomeEquals(String cognome) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE COGNOME = ? ORDER BY COGNOME", this,cognome);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'FK_ISTRUZIONE = :fkIstruzione'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereFkIstruzioneEquals(Integer fkIstruzione) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE FK_ISTRUZIONE = ? ORDER BY FK_ISTRUZIONE", this,fkIstruzione);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'NUM_CERTIFICATORE = :numCertificatore'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereNumCertificatoreEquals(String numCertificatore) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE NUM_CERTIFICATORE = ? ORDER BY NUM_CERTIFICATORE", this,numCertificatore);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'ALBO = :albo'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereAlboEquals(String albo) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE ALBO = ? ORDER BY ALBO", this,albo);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'DESC_PROV_ALBO = :descProvAlbo'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereDescProvAlboEquals(String descProvAlbo) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE DESC_PROV_ALBO = ? ORDER BY DESC_PROV_ALBO", this,descProvAlbo);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'NUM_ISCR_ALBO = :numIscrAlbo'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereNumIscrAlboEquals(String numIscrAlbo) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE NUM_ISCR_ALBO = ? ORDER BY NUM_ISCR_ALBO", this,numIscrAlbo);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'DATA_ISCR_ALBO = :dataIscrAlbo'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereDataIscrAlboEquals(Date dataIscrAlbo) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE DATA_ISCR_ALBO = ? ORDER BY DATA_ISCR_ALBO", this,dataIscrAlbo);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'DATA_ESAME = :dataEsame'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereDataEsameEquals(Date dataEsame) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE DATA_ESAME = ? ORDER BY DATA_ESAME", this,dataEsame);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'ESITO_ESAME = :esitoEsame'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereEsitoEsameEquals(String esitoEsame) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE ESITO_ESAME = ? ORDER BY ESITO_ESAME", this,esitoEsame);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'VOTO_ESAME = :votoEsame'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereVotoEsameEquals(String votoEsame) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE VOTO_ESAME = ? ORDER BY VOTO_ESAME", this,votoEsame);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'TELEFONO = :telefono'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereTelefonoEquals(String telefono) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE TELEFONO = ? ORDER BY TELEFONO", this,telefono);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'EMAIL = :email'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereEmailEquals(String email) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE EMAIL = ? ORDER BY EMAIL", this,email);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARTECIPANTE_2015 table that match the criteria 'NOTE = :note'.
	 */
	
	public List<SiceeTPartecipante2015> findWhereNoteEquals(String note) throws SiceeTPartecipante2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARTECIPANTE, FK_CORSO, CODICE_FISCALE, NOME, COGNOME, LUOGO_NASCITA, DATA_NASCITA, FK_TIPO_ISTRUZIONE, NUM_CERTIFICATORE, ALBO, DESC_PROV_ALBO, NUM_ISCR_ALBO, DATA_ISCR_ALBO, PERC_FREQ, DATA_ESAME, ESITO_ESAME, LUOGO_ESAME, VOTO_ESAME, TELEFONO, EMAIL, NOTE FROM " + getTableName() + " WHERE NOTE = ? ORDER BY NOTE", this,note);
		}
		catch (Exception e) {
			throw new SiceeTPartecipante2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_PARTECIPANTE_2015 table that matches the specified primary-key value.
	 */
	public SiceeTPartecipante2015 findByPrimaryKey(SiceeTPartecipante2015Pk pk) throws SiceeTPartecipante2015DaoException
	{
		return findByPrimaryKey( pk.getIdPartecipante() );
	}

}
