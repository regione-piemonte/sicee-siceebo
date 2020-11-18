/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTParametriDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTParametriDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeTParametriDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTParametri>, SiceeTParametriDao
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
	 * @return SiceeTParametriPk
	 */
	public SiceeTParametriPk insert(SiceeTParametri dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( CODICE, VALORE ) VALUES ( ?, ? )",dto.getCodice(),dto.getValore());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_PARAMETRI table.
	 */
	public void update(SiceeTParametriPk pk, SiceeTParametri dto) throws SiceeTParametriDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET CODICE = ?, VALORE = ? WHERE CODICE = ?",dto.getCodice(),dto.getValore(),pk.getCodice());
	}

	/** 
	 * Deletes a single row in the SICEE_T_PARAMETRI table.
	 */
	public void delete(SiceeTParametriPk pk) throws SiceeTParametriDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE CODICE = ?",pk.getCodice());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTParametri
	 */
	public SiceeTParametri mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTParametri dto = new SiceeTParametri();
		dto.setCodice( rs.getString( 1 ) );
		dto.setValore( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_PARAMETRI";
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'CODICE = :codice'.
	 */
	public SiceeTParametri findByPrimaryKey(String codice) throws SiceeTParametriDaoException
	{
		try {
			List<SiceeTParametri> list = jdbcTemplate.query("SELECT CODICE, VALORE FROM " + getTableName() + " WHERE CODICE = ?", this,codice);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTParametriDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria ''.
	 */
	public List<SiceeTParametri> findAll() throws SiceeTParametriDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE, VALORE FROM " + getTableName() + " ORDER BY CODICE", this);
		}
		catch (Exception e) {
			throw new SiceeTParametriDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'CODICE = :codice'.
	 */
	public List<SiceeTParametri> findWhereCodiceEquals(String codice) throws SiceeTParametriDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE, VALORE FROM " + getTableName() + " WHERE CODICE = ? ORDER BY CODICE", this,codice);
		}
		catch (Exception e) {
			throw new SiceeTParametriDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI table that match the criteria 'VALORE = :valore'.
	 */
	public List<SiceeTParametri> findWhereValoreEquals(String valore) throws SiceeTParametriDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CODICE, VALORE FROM " + getTableName() + " WHERE VALORE = ? ORDER BY VALORE", this,valore);
		}
		catch (Exception e) {
			throw new SiceeTParametriDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_PARAMETRI table that matches the specified primary-key value.
	 */
	public SiceeTParametri findByPrimaryKey(SiceeTParametriPk pk) throws SiceeTParametriDaoException
	{
		return findByPrimaryKey( pk.getCodice() );
	}

}
