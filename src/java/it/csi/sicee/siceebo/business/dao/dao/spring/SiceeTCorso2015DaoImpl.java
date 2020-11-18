/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTCorso2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCorso2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCorso2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTCorso2015DaoException;
import it.csi.sicee.siceebo.util.Constants;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.apache.log4j.Logger;

public class SiceeTCorso2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTCorso2015>, SiceeTCorso2015Dao
{
	protected JdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business");

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
	 * @return SiceeTCorso2015Pk
	 */
	
	public SiceeTCorso2015Pk insert(SiceeTCorso2015 dto)
	{
		dto.setIdCorso(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCorso(),dto.getFkEnte(),dto.getTipoCorso1(),dto.getTipoCorso2(),dto.getNumCorso(),dto.getAnnoFormativo(),dto.getTitolo(),dto.isTotaleOreNull()?null:dto.getTotaleOre(),dto.isTotaleModuliNull()?null:dto.getTotaleModuli(),dto.isNPartecipantiNull()?null:dto.getNPartecipanti(),dto.getDataEsame(),dto.getDataDal(),dto.getDataAl(),dto.getLuogoCorso(),dto.getProtApprov(),dto.getDataApprov(),dto.getNote(),dto.getFkTipoCorso());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_CORSO_2015 table.
	 */
	
	public void update(SiceeTCorso2015Pk pk, SiceeTCorso2015 dto) throws SiceeTCorso2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CORSO = ?, FK_ENTE = ?, TIPO_CORSO1 = ?, TIPO_CORSO2 = ?, NUM_CORSO = ?, ANNO_FORMATIVO = ?, TITOLO = ?, TOTALE_ORE = ?, TOTALE_MODULI = ?, N_PARTECIPANTI = ?, DATA_ESAME = ?, DATA_DAL = ?, DATA_AL = ?, LUOGO_CORSO = ?, PROT_APPROV = ?, DATA_APPROV = ?, NOTE = ?, FK_TIPO_CORSO = ? WHERE ID_CORSO = ?",dto.getIdCorso(),dto.getFkEnte(),dto.getTipoCorso1(),dto.getTipoCorso2(),dto.getNumCorso(),dto.getAnnoFormativo(),dto.getTitolo(),dto.getTotaleOre(),dto.getTotaleModuli(),dto.getNPartecipanti(),dto.getDataEsame(),dto.getDataDal(),dto.getDataAl(),dto.getLuogoCorso(),dto.getProtApprov(),dto.getDataApprov(),dto.getNote(),dto.getFkTipoCorso(),pk.getIdCorso());
	}

	/** 
	 * Deletes a single row in the SICEE_T_CORSO_2015 table.
	 */
	
	public void delete(SiceeTCorso2015Pk pk) throws SiceeTCorso2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CORSO = ?",pk.getIdCorso());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTCorso2015
	 */
	public SiceeTCorso2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTCorso2015 dto = new SiceeTCorso2015();
		dto.setIdCorso( rs.getLong( 1 ) );
		dto.setFkEnte( rs.getLong( 2 ) );
		dto.setTipoCorso1( rs.getString( 3 ) );
		dto.setTipoCorso2( rs.getString( 4 ) );
		dto.setNumCorso( rs.getString( 5 ) );
		dto.setAnnoFormativo( rs.getString( 6 ) );
		dto.setTitolo( rs.getString( 7 ) );
		dto.setTotaleOre( rs.getInt( 8 ) );
		if (rs.wasNull()) {
			dto.setTotaleOreNull( true );
			dto.setTotaleOre(null);
		}
		dto.setTotaleModuli( rs.getInt( 9 ) );
		if (rs.wasNull()) {
			dto.setTotaleModuliNull( true );
			dto.setTotaleModuli(null);
		}
		
		dto.setNPartecipanti( rs.getInt( 10 ) );
		if (rs.wasNull()) {
			dto.setNPartecipantiNull( true );
			dto.setNPartecipanti(null);
		}
		
		dto.setDataEsame( rs.getTimestamp(11 ) );
		dto.setDataDal( rs.getTimestamp(12 ) );
		dto.setDataAl( rs.getTimestamp(13 ) );
		dto.setLuogoCorso( rs.getString( 14 ) );
		dto.setProtApprov( rs.getString( 15 ) );
		dto.setDataApprov( rs.getTimestamp(16 ) );
		dto.setNote( rs.getString( 17 ) );
		dto.setFkTipoCorso( new Integer( rs.getInt(18) ) );

		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_CORSO_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'ID_CORSO = :idCorso'.
	 */
	
	public SiceeTCorso2015 findByPrimaryKey(long idCorso) throws SiceeTCorso2015DaoException
	{
		try {
			List<SiceeTCorso2015> list = jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE ID_CORSO = ?", this,idCorso);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTCorso2015> findAll() throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " ORDER BY ID_CORSO", this);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	
	public List<SiceeTCorso2015> findBySiceeTEnteformativo2015(long idEnte) throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE FK_ENTE = ? ORDER BY DATA_DAL DESC", this,idEnte);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'ID_CORSO = :idCorso'.
	 */
	
	public List<SiceeTCorso2015> findWhereIdCorsoEquals(long idCorso) throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE ID_CORSO = ? ORDER BY ID_CORSO", this,idCorso);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	
	public List<SiceeTCorso2015> findWhereIdEnteEquals(long idEnte) throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE ID_ENTE = ? ORDER BY ID_ENTE", this,idEnte);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'TITOLO = :titolo'.
	 */
	
	public List<SiceeTCorso2015> findWhereTitoloEquals(String titolo) throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE TITOLO = ? ORDER BY TITOLO", this,titolo);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'TOTALE_ORE = :totaleOre'.
	 */
	
	public List<SiceeTCorso2015> findWhereTotaleOreEquals(long totaleOre) throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE TOTALE_ORE = ? ORDER BY TOTALE_ORE", this,totaleOre);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'N_PARTECIPANTI = :nPartecipanti'.
	 */
	
	public List<SiceeTCorso2015> findWhereNPartecipantiEquals(long nPartecipanti) throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE N_PARTECIPANTI = ? ORDER BY N_PARTECIPANTI", this,nPartecipanti);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'DATA_ESAME = :dataEsame'.
	 */
	
	public List<SiceeTCorso2015> findWhereDataEsameEquals(Date dataEsame) throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE DATA_ESAME = ? ORDER BY DATA_ESAME", this,dataEsame);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'DATA_DAL = :corsoDal'.
	 */
	
	public List<SiceeTCorso2015> findWhereCorsoDalEquals(Date corsoDal) throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE DATA_DAL = ? ORDER BY DATA_DAL", this,corsoDal);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_CORSO_2015 table that match the criteria 'DATA_AL = :corsoAl'.
	 */
	
	public List<SiceeTCorso2015> findWhereCorsoAlEquals(Date corsoAl) throws SiceeTCorso2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CORSO, FK_ENTE, TIPO_CORSO1, TIPO_CORSO2, NUM_CORSO, ANNO_FORMATIVO, TITOLO, TOTALE_ORE, TOTALE_MODULI, N_PARTECIPANTI, DATA_ESAME, DATA_DAL, DATA_AL, LUOGO_CORSO, PROT_APPROV, DATA_APPROV, NOTE, FK_TIPO_CORSO FROM " + getTableName() + " WHERE DATA_AL = ? ORDER BY DATA_AL", this,corsoAl);
		}
		catch (Exception e) {
			throw new SiceeTCorso2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_CORSO_2015 table that matches the specified primary-key value.
	 */
	public SiceeTCorso2015 findByPrimaryKey(SiceeTCorso2015Pk pk) throws SiceeTCorso2015DaoException
	{
		return findByPrimaryKey( pk.getIdCorso() );
	}

}
