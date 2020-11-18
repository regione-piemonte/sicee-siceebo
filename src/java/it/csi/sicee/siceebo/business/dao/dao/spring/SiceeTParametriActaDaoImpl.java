/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTParametriActaDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriActa;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametriActaPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTParametriActaDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeTParametriActaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTParametriActa>, SiceeTParametriActaDao
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
	 * @return SiceeTParametriActaPk
	 */
	public SiceeTParametriActaPk insert(SiceeTParametriActa dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " (ID_PARAMETRI_ACTA, CODICE, VALORE ) VALUES ( ?, ?, ? )",dto.getIdParametriActa(),dto.getCodice(),dto.getValore());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_PARAMETRI_ACTA table.
	 */
	public void update(SiceeTParametriActaPk pk, SiceeTParametriActa dto) throws SiceeTParametriActaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_PARAMETRI_ACTA = ?, CODICE = ?, VALORE = ? WHERE ID_PARAMETRI_ACTA = ?",dto.getIdParametriActa(),dto.getCodice(),dto.getValore(),pk.getIdParametriActa());
	}

	/** 
	 * Deletes a single row in the SICEE_T_PARAMETRI_ACTA table.
	 */
	public void delete(SiceeTParametriActaPk pk) throws SiceeTParametriActaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_PARAMETRI_ACTA = ?",pk.getIdParametriActa());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTParametri
	 */
	public SiceeTParametriActa mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTParametriActa dto = new SiceeTParametriActa();
		dto.setIdParametriActa( new Integer( rs.getInt(1) ) );
		dto.setCodice( rs.getString( 2 ) );
		dto.setValore( rs.getString( 3 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_PARAMETRI_ACTA";
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI_ACTA table that match the criteria 'ID_PARAMETRI_ACTA = :idParametriActa'.
	 */
	public SiceeTParametriActa findByPrimaryKey(Integer idParametriActa) throws SiceeTParametriActaDaoException
	{
		try {
			List<SiceeTParametriActa> list = jdbcTemplate.query("SELECT ID_PARAMETRI_ACTA, CODICE, VALORE FROM " + getTableName() + " WHERE ID_PARAMETRI_ACTA = ?", this,idParametriActa);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTParametriActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI_ACTA table that match the criteria ''.
	 */
	public List<SiceeTParametriActa> findAll() throws SiceeTParametriActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARAMETRI_ACTA, CODICE, VALORE FROM " + getTableName() + " ORDER BY ID_PARAMETRI_ACTA", this);
		}
		catch (Exception e) {
			throw new SiceeTParametriActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI_ACTA table that match the criteria 'CODICE = :codice'.
	 */
	public List<SiceeTParametriActa> findWhereCodiceEquals(String codice) throws SiceeTParametriActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARAMETRI_ACTA, CODICE, VALORE FROM " + getTableName() + " WHERE CODICE = ? ORDER BY CODICE", this,codice);
		}
		catch (Exception e) {
			throw new SiceeTParametriActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_PARAMETRI_ACTA table that match the criteria 'VALORE = :valore'.
	 */
	public List<SiceeTParametriActa> findWhereValoreEquals(String valore) throws SiceeTParametriActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_PARAMETRI_ACTA, CODICE, VALORE FROM " + getTableName() + " WHERE VALORE = ? ORDER BY VALORE", this,valore);
		}
		catch (Exception e) {
			throw new SiceeTParametriActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_PARAMETRI_ACTA table that matches the specified primary-key value.
	 */
	public SiceeTParametriActa findByPrimaryKey(SiceeTParametriActaPk pk) throws SiceeTParametriActaDaoException
	{
		return findByPrimaryKey( pk.getIdParametriActa() );
	}

}
