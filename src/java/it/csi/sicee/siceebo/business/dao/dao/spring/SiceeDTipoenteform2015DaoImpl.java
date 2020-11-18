/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoenteform2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoenteform2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoenteform2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoenteform2015DaoException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SiceeDTipoenteform2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoenteform2015>, SiceeDTipoenteform2015Dao
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
	 * @return SiceeDTipoenteform2015Pk
	 */
	
	public SiceeDTipoenteform2015Pk insert(SiceeDTipoenteform2015 dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_ENTEFORM, DESCR ) VALUES ( ?, ? )",dto.getIdTipoenteform(),dto.getDescr());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_ENTEFORM_2015 table.
	 */
	
	public void update(SiceeDTipoenteform2015Pk pk, SiceeDTipoenteform2015 dto) throws SiceeDTipoenteform2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_ENTEFORM = ?, DESCR = ? WHERE ID_TIPO_ENTEFORM = ?",dto.getIdTipoenteform(),dto.getDescr(),pk.getIdTipoenteform());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_ENTEFORM_2015 table.
	 */
	
	public void delete(SiceeDTipoenteform2015Pk pk) throws SiceeDTipoenteform2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_ENTEFORM = ?",pk.getIdTipoenteform());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoenteform2015
	 */
	public SiceeDTipoenteform2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoenteform2015 dto = new SiceeDTipoenteform2015();
		dto.setIdTipoenteform( rs.getString(1) );
		dto.setDescr( rs.getString( 2 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_TIPO_ENTEFORM_2015";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ENTEFORM_2015 table that match the criteria 'ID_TIPO_ENTEFORM = :IdTipoenteform'.
	 */
	
	public SiceeDTipoenteform2015 findByPrimaryKey(String IdTipoenteform) throws SiceeDTipoenteform2015DaoException
	{
		try {
			List<SiceeDTipoenteform2015> list = jdbcTemplate.query("SELECT ID_TIPO_ENTEFORM, DESCR FROM " + getTableName() + " WHERE ID_TIPO_ENTEFORM = ?", this,IdTipoenteform);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoenteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ENTEFORM_2015 table that match the criteria ''.
	 */
	
	public List<SiceeDTipoenteform2015> findAll() throws SiceeDTipoenteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_ENTEFORM, DESCR FROM " + getTableName() + " ORDER BY DESCR", this);
		}
		catch (Exception e) {
			throw new SiceeDTipoenteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ENTEFORM_2015 table that match the criteria 'ID_TIPO_ENTEFORM = :IdTipoenteform'.
	 */
	
	public List<SiceeDTipoenteform2015> findWhereIdTipoenteformEquals(String IdTipoenteform) throws SiceeDTipoenteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_ENTEFORM, DESCR FROM " + getTableName() + " WHERE ID_TIPO_ENTEFORM = ? ORDER BY ID_TIPO_ENTEFORM", this,IdTipoenteform);
		}
		catch (Exception e) {
			throw new SiceeDTipoenteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_ENTEFORM_2015 table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDTipoenteform2015> findWhereDescrEquals(String descr) throws SiceeDTipoenteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_ENTEFORM, DESCR FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDTipoenteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_ENTEFORM_2015 table that matches the specified primary-key value.
	 */
	public SiceeDTipoenteform2015 findByPrimaryKey(SiceeDTipoenteform2015Pk pk) throws SiceeDTipoenteform2015DaoException
	{
		return findByPrimaryKey( pk.getIdTipoenteform() );
	}

}
