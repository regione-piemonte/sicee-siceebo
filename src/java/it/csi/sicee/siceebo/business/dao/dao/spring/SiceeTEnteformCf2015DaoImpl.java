/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTEnteformCf2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformCf2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformCf2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTEnteformCf2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTEnteformCf2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTEnteformCf2015>, SiceeTEnteformCf2015Dao
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
	 * @return SiceeTEnteformCf2015Pk
	 */
	
	public SiceeTEnteformCf2015Pk insert(SiceeTEnteformCf2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_ENTE, CF_CERTIFICATO, RUOLO ) VALUES ( ?, ?, ? )",dto.getIdEnte(),dto.getCfCertificato(),dto.getRuolo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_ENTEFORM_CF_2015 table.
	 */
	
	public void update(SiceeTEnteformCf2015Pk pk, SiceeTEnteformCf2015 dto) throws SiceeTEnteformCf2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_ENTE = ?, CF_CERTIFICATO = ?, RUOLO = ? WHERE ID_ENTE = ? AND CF_CERTIFICATO = ?",dto.getIdEnte(),dto.getCfCertificato(),dto.getRuolo(),pk.getIdEnte(),pk.getCfCertificato());
	}

	/** 
	 * Deletes a single row in the SICEE_T_ENTEFORM_CF_2015 table.
	 */
	
	public void delete(SiceeTEnteformCf2015Pk pk) throws SiceeTEnteformCf2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_ENTE = ? AND CF_CERTIFICATO = ?",pk.getIdEnte(),pk.getCfCertificato());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTEnteformCf2015
	 */
	public SiceeTEnteformCf2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTEnteformCf2015 dto = new SiceeTEnteformCf2015();
		dto.setIdEnte( rs.getLong( 1 ) );
		dto.setCfCertificato( rs.getString( 2 ) );
		dto.setRuolo( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_ENTEFORM_CF_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria 'ID_ENTE = :idEnte AND CF_CERTIFICATO = :cfCertificato'.
	 */
	
	public SiceeTEnteformCf2015 findByPrimaryKey(long idEnte, String cfCertificato) throws SiceeTEnteformCf2015DaoException
	{
		try {
			List<SiceeTEnteformCf2015> list = jdbcTemplate.query("SELECT ID_ENTE, CF_CERTIFICATO, RUOLO FROM " + getTableName() + " WHERE ID_ENTE = ? AND CF_CERTIFICATO = ?", this,idEnte,cfCertificato);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTEnteformCf2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTEnteformCf2015> findAll() throws SiceeTEnteformCf2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, CF_CERTIFICATO, RUOLO FROM " + getTableName() + " ORDER BY ID_ENTE, CF_CERTIFICATO", this);
		}
		catch (Exception e) {
			throw new SiceeTEnteformCf2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	
	public List<SiceeTEnteformCf2015> findBySiceeTEnteformativo2015(long idEnte) throws SiceeTEnteformCf2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, CF_CERTIFICATO, RUOLO FROM " + getTableName() + " WHERE ID_ENTE = ?", this,idEnte);
		}
		catch (Exception e) {
			throw new SiceeTEnteformCf2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	
	public List<SiceeTEnteformCf2015> findWhereIdEnteEquals(long idEnte) throws SiceeTEnteformCf2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, CF_CERTIFICATO, RUOLO FROM " + getTableName() + " WHERE ID_ENTE = ? ORDER BY ID_ENTE", this,idEnte);
		}
		catch (Exception e) {
			throw new SiceeTEnteformCf2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_CF_2015 table that match the criteria 'CF_CERTIFICATO = :cfCertificato'.
	 */
	
	public List<SiceeTEnteformCf2015> findWhereCfCertificatoEquals(String cfCertificato) throws SiceeTEnteformCf2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, CF_CERTIFICATO, RUOLO FROM " + getTableName() + " WHERE CF_CERTIFICATO = ? ORDER BY CF_CERTIFICATO", this,cfCertificato);
		}
		catch (Exception e) {
			throw new SiceeTEnteformCf2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_ENTEFORM_CF_2015 table that matches the specified primary-key value.
	 */
	public SiceeTEnteformCf2015 findByPrimaryKey(SiceeTEnteformCf2015Pk pk) throws SiceeTEnteformCf2015DaoException
	{
		return findByPrimaryKey( pk.getIdEnte(), pk.getCfCertificato() );
	}

}
