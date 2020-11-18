/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeLRicercheCtuDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLRicercheCtu;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLRicercheCtuPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeLRicercheCtuDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeLRicercheCtuDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeLRicercheCtu>, SiceeLRicercheCtuDao
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
	 * @return SiceeLRicercheCtuPk
	 */
	
	public SiceeLRicercheCtuPk insert(SiceeLRicercheCtu dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( CF_CTU, DATA_RICERCA, MOTIVAZIONE_CTU ) VALUES ( ?, ?, ? )",dto.getCfCtu(),dto.getDataRicerca(),dto.getMotivazioneCtu());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_L_RICERCHE_CTU table.
	 */

	public void update(SiceeLRicercheCtuPk pk, SiceeLRicercheCtu dto) throws SiceeLRicercheCtuDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET CF_CTU = ?, DATA_RICERCA = ?, MOTIVAZIONE_CTU = ? WHERE CF_CTU = ? AND DATA_RICERCA = ?",dto.getCfCtu(),dto.getDataRicerca(),dto.getMotivazioneCtu(),pk.getCfCtu(),pk.getDataRicerca());
	}

	/** 
	 * Deletes a single row in the SICEE_L_RICERCHE_CTU table.
	 */

	public void delete(SiceeLRicercheCtuPk pk) throws SiceeLRicercheCtuDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE CF_CTU = ? AND DATA_RICERCA = ?",pk.getCfCtu(),pk.getDataRicerca());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeLRicercheCtu
	 */
	public SiceeLRicercheCtu mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeLRicercheCtu dto = new SiceeLRicercheCtu();
		dto.setCfCtu( rs.getString( 1 ) );
		dto.setDataRicerca( rs.getTimestamp(2 ) );
		dto.setMotivazioneCtu( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_L_RICERCHE_CTU";
	}

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria 'CF_CTU = :cfCtu AND DATA_RICERCA = :dataRicerca'.
	 */

	public SiceeLRicercheCtu findByPrimaryKey(String cfCtu, Date dataRicerca) throws SiceeLRicercheCtuDaoException
	{
		try {
			List<SiceeLRicercheCtu> list = jdbcTemplate.query("SELECT CF_CTU, DATA_RICERCA, MOTIVAZIONE_CTU FROM " + getTableName() + " WHERE CF_CTU = ? AND DATA_RICERCA = ?", this,cfCtu,dataRicerca);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeLRicercheCtuDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria ''.
	 */

	public List<SiceeLRicercheCtu> findAll() throws SiceeLRicercheCtuDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CF_CTU, DATA_RICERCA, MOTIVAZIONE_CTU FROM " + getTableName() + " ORDER BY CF_CTU, DATA_RICERCA", this);
		}
		catch (Exception e) {
			throw new SiceeLRicercheCtuDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria 'CF_CTU = :cfCtu'.
	 */

	public List<SiceeLRicercheCtu> findWhereCfCtuEquals(String cfCtu) throws SiceeLRicercheCtuDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CF_CTU, DATA_RICERCA, MOTIVAZIONE_CTU FROM " + getTableName() + " WHERE CF_CTU = ? ORDER BY CF_CTU", this,cfCtu);
		}
		catch (Exception e) {
			throw new SiceeLRicercheCtuDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria 'DATA_RICERCA = :dataRicerca'.
	 */

	public List<SiceeLRicercheCtu> findWhereDataRicercaEquals(Date dataRicerca) throws SiceeLRicercheCtuDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CF_CTU, DATA_RICERCA, MOTIVAZIONE_CTU FROM " + getTableName() + " WHERE DATA_RICERCA = ? ORDER BY DATA_RICERCA", this,dataRicerca);
		}
		catch (Exception e) {
			throw new SiceeLRicercheCtuDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_L_RICERCHE_CTU table that match the criteria 'MOTIVAZIONE_CTU = :motivazioneCtu'.
	 */

	public List<SiceeLRicercheCtu> findWhereMotivazioneCtuEquals(String motivazioneCtu) throws SiceeLRicercheCtuDaoException
	{
		try {
			return jdbcTemplate.query("SELECT CF_CTU, DATA_RICERCA, MOTIVAZIONE_CTU FROM " + getTableName() + " WHERE MOTIVAZIONE_CTU = ? ORDER BY MOTIVAZIONE_CTU", this,motivazioneCtu);
		}
		catch (Exception e) {
			throw new SiceeLRicercheCtuDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_L_RICERCHE_CTU table that matches the specified primary-key value.
	 */
	public SiceeLRicercheCtu findByPrimaryKey(SiceeLRicercheCtuPk pk) throws SiceeLRicercheCtuDaoException
	{
		return findByPrimaryKey( pk.getCfCtu(), pk.getDataRicerca() );
	}

}
