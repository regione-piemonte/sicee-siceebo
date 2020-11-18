/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDClasseEnergeticaDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDClasseEnergetica;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDClasseEnergeticaPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDClasseEnergeticaDaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeDClasseEnergeticaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDClasseEnergetica>, SiceeDClasseEnergeticaDao
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
	 * @return SiceeDClasseEnergeticaPk
	 */
	
	public SiceeDClasseEnergeticaPk insert(SiceeDClasseEnergetica dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CLASSE, DESCR, FLG_NAZIONALE_19205, FLG_ATTIVO ) VALUES ( ?, ?, ?, ? )",dto.getIdClasse(),dto.getDescr(),dto.getFlgNazionale19205(),dto.getFlgAttivo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	
	public void update(SiceeDClasseEnergeticaPk pk, SiceeDClasseEnergetica dto) throws SiceeDClasseEnergeticaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CLASSE = ?, DESCR = ?, FLG_NAZIONALE_19205 = ?, FLG_ATTIVO = ? WHERE ID_CLASSE = ?",dto.getIdClasse(),dto.getDescr(),dto.getFlgNazionale19205(),dto.getFlgAttivo(),pk.getIdClasse());
	}

	/** 
	 * Deletes a single row in the SICEE_D_CLASSE_ENERGETICA table.
	 */
	
	public void delete(SiceeDClasseEnergeticaPk pk) throws SiceeDClasseEnergeticaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CLASSE = ?",pk.getIdClasse());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDClasseEnergetica
	 */
	public SiceeDClasseEnergetica mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDClasseEnergetica dto = new SiceeDClasseEnergetica();
		dto.setIdClasse( new Integer( rs.getInt(1) ) );
		dto.setDescr( rs.getString( 2 ) );
		dto.setFlgNazionale19205( rs.getString( 3 ) );
		dto.setFlgAttivo( new Integer( rs.getInt(4) ) );
		if (rs.wasNull()) {
			dto.setFlgAttivo( null );
		}
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_CLASSE_ENERGETICA";
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'ID_CLASSE = :idClasse'.
	 */
	
	public SiceeDClasseEnergetica findByPrimaryKey(Integer idClasse) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			List<SiceeDClasseEnergetica> list = jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205, FLG_ATTIVO FROM " + getTableName() + " WHERE ID_CLASSE = ?", this,idClasse);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria ''.
	 */
	
	public List<SiceeDClasseEnergetica> findAll() throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205, FLG_ATTIVO FROM " + getTableName() + " ORDER BY ID_CLASSE", this);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'ID_CLASSE = :idClasse'.
	 */
	
	public List<SiceeDClasseEnergetica> findWhereIdClasseEquals(Integer idClasse) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205, FLG_ATTIVO FROM " + getTableName() + " WHERE ID_CLASSE = ? ORDER BY ID_CLASSE", this,idClasse);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'DESCR = :descr'.
	 */
	
	public List<SiceeDClasseEnergetica> findWhereDescrEquals(String descr) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205, FLG_ATTIVO FROM " + getTableName() + " WHERE DESCR = ? ORDER BY DESCR", this,descr);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'FLG_NAZIONALE_19205 = :flgNazionale19205'.
	 */
	
	public List<SiceeDClasseEnergetica> findWhereFlgNazionale19205Equals(String flgNazionale19205) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205, FLG_ATTIVO FROM " + getTableName() + " WHERE FLG_NAZIONALE_19205 = ? ORDER BY FLG_NAZIONALE_19205", this,flgNazionale19205);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_CLASSE_ENERGETICA table that match the criteria 'FLG_ATTIVO = :flgAttivo'.
	 */
	public List<SiceeDClasseEnergetica> findWhereFlgAttivoEquals(Integer flgAttivo) throws SiceeDClasseEnergeticaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CLASSE, DESCR, FLG_NAZIONALE_19205, FLG_ATTIVO FROM " + getTableName() + " WHERE FLG_ATTIVO = ? ORDER BY ID_CLASSE", this,flgAttivo);
		}
		catch (Exception e) {
			throw new SiceeDClasseEnergeticaDaoException("Query failed", e);
		}
		
	}
	
	/** 
	 * Returns the rows from the SICEE_D_CLASSE_ENERGETICA table that matches the specified primary-key value.
	 */
	public SiceeDClasseEnergetica findByPrimaryKey(SiceeDClasseEnergeticaPk pk) throws SiceeDClasseEnergeticaDaoException
	{
		return findByPrimaryKey( pk.getIdClasse() );
	}

}
