/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDDestUsoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDDestUso;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDDestUsoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDDestUsoDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeDDestUsoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDDestUso>, SiceeDDestUsoDao
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
	 * @return SiceeDDestUsoPk
	 */
	
	public SiceeDDestUsoPk insert(SiceeDDestUso dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA ) VALUES ( ?, ?, ?, ?, ?, ? )",dto.getIdDestUso(),dto.getSigla(),dto.getDescr(),dto.getFlgEdificio(),dto.getFlgVisibileCombo(),dto.getFlgRicerca());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_DEST_USO table.
	 */
	
	public void update(SiceeDDestUsoPk pk, SiceeDDestUso dto) throws SiceeDDestUsoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_DEST_USO = ?, SIGLA = ?, DESCR = ?, FLG_EDIFICIO = ?, FLG_VISIBILE_COMBO = ?, FLG_RICERCA = ? WHERE ID_DEST_USO = ?",dto.getIdDestUso(),dto.getSigla(),dto.getDescr(),dto.getFlgEdificio(),dto.getFlgVisibileCombo(),dto.getFlgRicerca(),pk.getIdDestUso());
	}

	/** 
	 * Deletes a single row in the SICEE_D_DEST_USO table.
	 */
	
	public void delete(SiceeDDestUsoPk pk) throws SiceeDDestUsoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_DEST_USO = ?",pk.getIdDestUso());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDDestUso
	 */
	public SiceeDDestUso mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDDestUso dto = new SiceeDDestUso();
		dto.setIdDestUso( new Integer( rs.getInt(1) ) );
		dto.setSigla( rs.getString( 2 ) );
		dto.setDescr( rs.getString( 3 ) );
		dto.setFlgEdificio( rs.getString( 4 ) );
		dto.setFlgVisibileCombo( rs.getString( 5 ) );
		dto.setFlgRicerca( rs.getString( 6 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_DEST_USO";
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'ID_DEST_USO = :idDestUso'.
	 */
	
	public SiceeDDestUso findByPrimaryKey(Integer idDestUso) throws SiceeDDestUsoDaoException
	{
		try {
			List<SiceeDDestUso> list = jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " WHERE ID_DEST_USO = ?", this,idDestUso);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria ''.
	 */
	
	public List<SiceeDDestUso> findAll() throws SiceeDDestUsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " ORDER BY ID_DEST_USO", this);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'ID_DEST_USO = :idDestUso'.
	 */
	
	public List<SiceeDDestUso> findWhereIdDestUsoEquals(Integer idDestUso) throws SiceeDDestUsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " WHERE ID_DEST_USO = ? ORDER BY ID_DEST_USO", this,idDestUso);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'SIGLA = :sigla'.
	 */
	
	public List<SiceeDDestUso> findWhereSiglaEquals(String sigla) throws SiceeDDestUsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " WHERE SIGLA = ? ORDER BY SIGLA", this,sigla);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDDestUso> findWhereDescrEquals(String descr) throws SiceeDDestUsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'FLG_EDIFICIO = :flgEdificio'.
	 */
	
	public List<SiceeDDestUso> findWhereFlgEdificioEquals(String flgEdificio) throws SiceeDDestUsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " WHERE FLG_EDIFICIO = ? ORDER BY FLG_EDIFICIO", this,flgEdificio);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'FLG_VISIBILE_COMBO = :flgVisibileCombo'.
	 */
	
	public List<SiceeDDestUso> findWhereFlgVisibileComboEquals(String flgVisibileCombo) throws SiceeDDestUsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " WHERE FLG_VISIBILE_COMBO = ? ORDER BY FLG_VISIBILE_COMBO", this,flgVisibileCombo);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'FLG_RICERCA = :flgRicerca'.
	 */
	
	public List<SiceeDDestUso> findWhereFlgRicercaEquals(String flgRicerca) throws SiceeDDestUsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " WHERE FLG_RICERCA = ? ORDER BY FLG_RICERCA", this,flgRicerca);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'FLG_RICERCA = 'S''.
	 */
	
	public List<SiceeDDestUso> findAllFlgRicercaSI() throws SiceeDDestUsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " WHERE FLG_RICERCA = 'S' ORDER BY SIGLA", this);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_DEST_USO table that match the criteria 'FLG_VISIBILE_COMBO = 'S''.
	 */
	
	public List<SiceeDDestUso> findAllFlgVisibileComboSI() throws SiceeDDestUsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_DEST_USO, SIGLA, DESCR, FLG_EDIFICIO, FLG_VISIBILE_COMBO, FLG_RICERCA FROM " + getTableName() + " WHERE FLG_VISIBILE_COMBO = 'S' ORDER BY SIGLA", this);
		}
		catch (Exception e) {
			throw new SiceeDDestUsoDaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns the rows from the SICEE_D_DEST_USO table that matches the specified primary-key value.
	 */
	public SiceeDDestUso findByPrimaryKey(SiceeDDestUsoPk pk) throws SiceeDDestUsoDaoException
	{
		return findByPrimaryKey( pk.getIdDestUso() );
	}

}
