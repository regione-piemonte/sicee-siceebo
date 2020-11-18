/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDTipoCorsoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoCorso;
import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoCorsoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeDTipoCorsoDaoException;

import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.soap.providers.com.Log;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeDTipoCorsoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeDTipoCorso>, SiceeDTipoCorsoDao
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
	 * @return SiceeDTipoCorsoPk
	 */
	
	public SiceeDTipoCorsoPk insert(SiceeDTipoCorso dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_TIPO_CORSO, DESCRIZIONE, DESCRIZIONE_ATTESTATO, FLG_ABILITATO ) VALUES ( ?, ?, ?, ? )",dto.getIdTipoCorso(),dto.getDescrizione(),dto.getDescrizioneAttestato(),dto.getFlgAbilitato());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_D_TIPO_CORSO table.
	 */
	
	public void update(SiceeDTipoCorsoPk pk, SiceeDTipoCorso dto) throws SiceeDTipoCorsoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_TIPO_CORSO = ?, DESCRIZIONE = ?, DESCRIZIONE_ATTESTATO = ?, FLG_ABILITATO = ? WHERE ID_TIPO_CORSO = ?",dto.getIdTipoCorso(),dto.getDescrizione(),dto.getDescrizioneAttestato(),dto.getFlgAbilitato(),pk.getIdTipoCorso());
	}

	/** 
	 * Deletes a single row in the SICEE_D_TIPO_CORSO table.
	 */
	
	public void delete(SiceeDTipoCorsoPk pk) throws SiceeDTipoCorsoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_TIPO_CORSO = ?",pk.getIdTipoCorso());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeDTipoCorso
	 */
	public SiceeDTipoCorso mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeDTipoCorso dto = new SiceeDTipoCorso();
		dto.setIdTipoCorso( new Integer( rs.getInt(1) ) );
		dto.setDescrizione( rs.getString( 2 ) );
		dto.setDescrizioneAttestato( rs.getString( 3 ) );
		dto.setFlgAbilitato( rs.getString( 4 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_D_TIPO_CORSO";
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_CORSO table that match the criteria 'ID_TIPO_CORSO = :idTipoCorso'.
	 */
	
	public SiceeDTipoCorso findByPrimaryKey(Integer idTipoCorso) throws SiceeDTipoCorsoDaoException
	{
		try {
			List<SiceeDTipoCorso> list = jdbcTemplate.query("SELECT ID_TIPO_CORSO, DESCRIZIONE, DESCRIZIONE_ATTESTATO, FLG_ABILITATO FROM " + getTableName() + " WHERE ID_TIPO_CORSO = ?", this,idTipoCorso);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeDTipoCorsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_CORSO table that match the criteria ''.
	 */
	
	public List<SiceeDTipoCorso> findAllAbilitati() throws SiceeDTipoCorsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_CORSO, DESCRIZIONE, DESCRIZIONE_ATTESTATO, FLG_ABILITATO FROM " + getTableName() + " WHERE FLG_ABILITATO = ? ORDER BY ID_TIPO_CORSO", this, 1);
		}
		catch (Exception e) {
			throw new SiceeDTipoCorsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_D_TIPO_CORSO table that match the criteria ''.
	 */
	
	public List<SiceeDTipoCorso> findAll() throws SiceeDTipoCorsoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_TIPO_CORSO, DESCRIZIONE, DESCRIZIONE_ATTESTATO, FLG_ABILITATO FROM " + getTableName() + " ORDER BY ID_TIPO_CORSO", this);
		}
		catch (Exception e) {
			
			System.err.println("Stampo l'errore: "+e);		
			
			throw new SiceeDTipoCorsoDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_D_TIPO_CORSO table that matches the specified primary-key value.
	 */
	public SiceeDTipoCorso findByPrimaryKey(SiceeDTipoCorsoPk pk) throws SiceeDTipoCorsoDaoException
	{
		return findByPrimaryKey( pk.getIdTipoCorso() );
	}

}
