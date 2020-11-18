/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDBloccoCertificatoreDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDBloccoCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDBloccoCertificatorePk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDBloccoCertificatoreDaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SiceeDBloccoCertificatoreDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDBloccoCertificatore>, SiceeDBloccoCertificatoreDao
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
	 * @return SiceeDBloccoCertificatorePk
	 */
	
	public SiceeDBloccoCertificatorePk insert(SiceeDBloccoCertificatore dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_BLOCCO_CERTIFICATORE, FLG_BLOCCO, DESCR ) VALUES ( ?, ?, ? )",dto.getIdBloccoCertificatore(),dto.getFlgBlocco(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_BLOCCO_CERTIFICATORE table.
	 */
	
	public void update(SiceeDBloccoCertificatorePk pk, SiceeDBloccoCertificatore dto) throws SiceeDBloccoCertificatoreDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_BLOCCO_CERTIFICATORE = ?, FLG_BLOCCO = ?, DESCR = ? WHERE ID_BLOCCO_CERTIFICATORE = ?",dto.getIdBloccoCertificatore(),dto.getFlgBlocco(),dto.getDescr(),pk.getIdBloccoCertificatore());
	}

	/** 
	 * Deletes a single row in the SICEE_D_BLOCCO_CERTIFICATORE table.
	 */
	
	public void delete(SiceeDBloccoCertificatorePk pk) throws SiceeDBloccoCertificatoreDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_BLOCCO_CERTIFICATORE = ?",pk.getIdBloccoCertificatore());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDBloccoCert
	 */
	public SiceeDBloccoCertificatore mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDBloccoCertificatore dto = new SiceeDBloccoCertificatore();
		dto.setIdBloccoCertificatore( new Integer( rs.getInt(1) ) );
		dto.setFlgBlocco( new Integer( rs.getInt(2) ) );
		dto.setDescr( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_BLOCCO_CERTIFICATORE";
	}

	/** 
	 * Returns all rows from the SICEE_D_BLOCCO_CERTIFICATORE table that match the criteria 'ID_BLOCCO_CERTIFICATORE = :idBloccoCert'.
	 */
	
	public SiceeDBloccoCertificatore findByPrimaryKey(Integer idBloccoCert) throws SiceeDBloccoCertificatoreDaoException
	{
		try {
			List<SiceeDBloccoCertificatore> list = jdbcTemplate.query("SELECT ID_BLOCCO_CERTIFICATORE, FLG_BLOCCO, DESCR FROM " + getTableName() + " WHERE ID_BLOCCO_CERTIFICATORE = ?", this,idBloccoCert);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDBloccoCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_BLOCCO_CERTIFICATORE table that match the criteria ''.
	 */
	
	public List<SiceeDBloccoCertificatore> findAll() throws SiceeDBloccoCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_BLOCCO_CERTIFICATORE, FLG_BLOCCO, DESCR FROM " + getTableName() + " ORDER BY ID_BLOCCO_CERTIFICATORE", this);
		}
		catch (Exception e) {
			throw new SiceeDBloccoCertificatoreDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_BLOCCO_CERTIFICATORE table that match the criteria 'ID_BLOCCO = :idBlocco'.
	 */
	
	public List<SiceeDBloccoCertificatore> findWhereFlgBloccoEquals(Integer flgBlocco) throws SiceeDBloccoCertificatoreDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_BLOCCO_CERTIFICATORE, FLG_BLOCCO, DESCR FROM " + getTableName() + " WHERE FLG_BLOCCO = ? ORDER BY ID_BLOCCO_CERTIFICATORE", this,flgBlocco);
		}
		catch (Exception e) {
			throw new SiceeDBloccoCertificatoreDaoException("Query failed", e);
		}
		
	}

}
