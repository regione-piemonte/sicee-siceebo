/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTActaDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTActa;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTActaPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTActaDaoException;
import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTActaDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTActa>, SiceeTActaDao
{
	protected SimpleJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	/**
	 * Method 'setDataSource'
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		jdbcTemplate = new SimpleJdbcTemplate(dataSource);
	}

	/**
	 * Method 'insert'
	 * 
	 * @param dto
	 * @return SiceeTActaPk
	 */
	
	public SiceeTActaPk insert(SiceeTActa dto)
	{
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO, ID_PROTOCOLLO_ACTA ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getVolume(),dto.getIdDocActa(),dto.getIdClassificazioneActa(),dto.getTipoDocumentoActa(),dto.getFailedStepActa(),dto.getTimestampArchiviazione(),dto.getNumeroProtocollo(),dto.getMailInviata(),dto.getTimestampProtocollo(),dto.getIdProtocolloActa());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_ACTA table.
	 */
	
	public void update(SiceeTActaPk pk, SiceeTActa dto) throws SiceeTActaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_CERTIFICATORE = ?, PROGR_CERTIFICATO = ?, ANNO = ?, VOLUME = ?, ID_DOC_ACTA = ?, ID_CLASSIFICAZIONE_ACTA = ?, TIPO_DOCUMENTO_ACTA = ?, FAILED_STEP_ACTA = ?, TIMESTAMP_ARCHIVIAZIONE = ?, NUMERO_PROTOCOLLO = ?, MAIL_INVIATA = ?, TIMESTAMP_PROTOCOLLO = ?, ID_PROTOCOLLO_ACTA = ? WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",dto.getIdCertificatore(),dto.getProgrCertificato(),dto.getAnno(),dto.getVolume(),dto.getIdDocActa(),dto.getIdClassificazioneActa(),dto.getTipoDocumentoActa(),dto.getFailedStepActa(),dto.getTimestampArchiviazione(),dto.getNumeroProtocollo(),dto.getMailInviata(),dto.getTimestampProtocollo(),dto.getIdProtocolloActa(),pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/** 
	 * Updates a single row in the SICEE_T_ACTA table.
	 */
	
	public void updateRisanaProtAnomali() throws SiceeTActaDaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_PROTOCOLLO_ACTA = NULL WHERE ID_PROTOCOLLO_ACTA IS NOT NULL AND NUMERO_PROTOCOLLO IS NULL");
	}

	/** 
	 * Deletes a single row in the SICEE_T_ACTA table.
	 */
	
	public void delete(SiceeTActaPk pk) throws SiceeTActaDaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?",pk.getIdCertificatore(),pk.getProgrCertificato(),pk.getAnno());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTActa
	 */
	public SiceeTActa mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTActa dto = new SiceeTActa();
		dto.setIdCertificatore( rs.getString( 1 ) );
		dto.setProgrCertificato( rs.getString( 2 ) );
		dto.setAnno( rs.getString( 3 ) );
		dto.setVolume( rs.getString( 4 ) );
		dto.setIdDocActa( rs.getString( 5 ) );
		dto.setIdClassificazioneActa( rs.getString( 6 ) );
		dto.setTipoDocumentoActa( rs.getString( 7 ) );
		dto.setFailedStepActa( rs.getString( 8 ) );
		dto.setTimestampArchiviazione( rs.getTimestamp(9 ) );
		dto.setNumeroProtocollo( rs.getString( 10 ) );
		dto.setMailInviata( rs.getString( 11 ) );
		dto.setTimestampProtocollo( rs.getTimestamp(12 ) );
		dto.setIdProtocolloActa( rs.getString( 13 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_ACTA";
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria 'ID_CERTIFICATORE = :idCertificatore AND PROGR_CERTIFICATO = :progrCertificato AND ANNO = :anno'.
	 */
	
	public SiceeTActa findByPrimaryKey(String idCertificatore, String progrCertificato, String anno) throws SiceeTActaDaoException
	{
		try {
			List<SiceeTActa> list = jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO, ID_PROTOCOLLO_ACTA FROM " + getTableName() + " WHERE ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ? AND ANNO = ?", this,idCertificatore,progrCertificato,anno);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria ''.
	 */
	
	public List<SiceeTActa> findAll() throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO, ID_PROTOCOLLO_ACTA FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ACTA table that match the criteria ''.
	 */
	
	public List<SiceeTActa> findProtocolloAnomalo() throws SiceeTActaDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, VOLUME, ID_DOC_ACTA, ID_CLASSIFICAZIONE_ACTA, TIPO_DOCUMENTO_ACTA, FAILED_STEP_ACTA, TIMESTAMP_ARCHIVIAZIONE, NUMERO_PROTOCOLLO, MAIL_INVIATA, TIMESTAMP_PROTOCOLLO, ID_PROTOCOLLO_ACTA FROM " + getTableName() + " WHERE ID_PROTOCOLLO_ACTA IS NOT NULL AND NUMERO_PROTOCOLLO IS NULL ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTActaDaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_ACTA table that matches the specified primary-key value.
	 */
	public SiceeTActa findByPrimaryKey(SiceeTActaPk pk) throws SiceeTActaDaoException
	{
		return findByPrimaryKey( pk.getIdCertificatore(), pk.getProgrCertificato(), pk.getAnno() );
	}

}
