/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeLAnnullamentoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLAnnullamento;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLAnnullamentoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeLAnnullamentoDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class SiceeLAnnullamentoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeLAnnullamento>, SiceeLAnnullamentoDao
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
	 * @return SiceeLAnnullamentoPk
	 */
	
	public SiceeLAnnullamentoPk insert(SiceeLAnnullamento dto)
	{
		dto.setIdAnnullamento(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_ANNULLAMENTO, DT_ANNULLAMENTO, MOTIVO_ANNULLAMENTO ) VALUES ( ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getIdAnnullamento(),dto.getDtAnnullamento(),dto.getMotivoAnnullamento());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_L_ANNULLAMENTO table.
	 */
	
	public void update(SiceeLAnnullamentoPk pk, SiceeLAnnullamento dto) throws SiceeLAnnullamentoDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, ID_ANNULLAMENTO = ?, DT_ANNULLAMENTO = ?, MOTIVO_ANNULLAMENTO = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getIdAnnullamento(),dto.getDtAnnullamento(),dto.getMotivoAnnullamento(), pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Deletes a single row in the SICEE_L_ANNULLAMENTO table.
	 */
	
	public void delete(SiceeLAnnullamentoPk pk) throws SiceeLAnnullamentoDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeLAnnullamento
	 */
	public SiceeLAnnullamento mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeLAnnullamento dto = new SiceeLAnnullamento();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );

		dto.setIdAnnullamento( rs.getLong( 4 ) );

		dto.setDtAnnullamento( rs.getTimestamp(5 ) );
		dto.setMotivoAnnullamento( rs.getString( 6 ) );

		
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_L_ANNULLAMENTO";
	}

	/** 
	 * Returns all rows from the SICEE_L_ANNULLAMENTO table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeLAnnullamento findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeLAnnullamentoDaoException
	{
		try {
			List<SiceeLAnnullamento> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, ID_ANNULLAMENTO, DT_ANNULLAMENTO, MOTIVO_ANNULLAMENTO FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeLAnnullamentoDaoException("Query failed", e);
		}
		
	}
	
	
	/** 
	 * Returns the rows from the SICEE_L_ANNULLAMENTO table that matches the specified primary-key value.
	 */
	public SiceeLAnnullamento findByPrimaryKey(SiceeLAnnullamentoPk pk) throws SiceeLAnnullamentoDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
