/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTEnteformSl2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformSl2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteformSl2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTEnteformSl2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
//import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTEnteformSl2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTEnteformSl2015>, SiceeTEnteformSl2015Dao
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
	 * @return SiceeTEnteformSl2015Pk
	 */
	
	public SiceeTEnteformSl2015Pk insert(SiceeTEnteformSl2015 dto)
	{
		dto.setIdEnteSl(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdEnteSl(),dto.getTipoSoggetto(),dto.getDenominazione(),dto.getPIva(),dto.getIdRegione(),dto.getDescRegione(),dto.getIdProv(),dto.getDescProv(),dto.getIdComune(),dto.getDescComune(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getNumCivico(),dto.getCap(),dto.getReferente(),dto.getTelefono(),dto.getCell(),dto.getEmail(),dto.getEmailPec(),dto.getFax(),dto.getSitoWeb(),dto.getBase64Logo(),dto.getParametriLogo());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_ENTEFORM_SL_2015 table.
	 */
	
	public void update(SiceeTEnteformSl2015Pk pk, SiceeTEnteformSl2015 dto) throws SiceeTEnteformSl2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_ENTE_SL = ?, TIPO_SOGGETTO = ?, DENOMINAZIONE = ?, P_IVA = ?, ID_REGIONE = ?, DESC_REGIONE = ?, ID_PROV = ?, DESC_PROV = ?, ID_COMUNE = ?, DESC_COMUNE = ?, ID_INDIRIZZO = ?, DESC_INDIRIZZO = ?, NUM_CIVICO = ?, CAP = ?, REFERENTE = ?, TELEFONO = ?, CELL = ?, EMAIL = ?, EMAIL_PEC = ?, FAX = ?, SITO_WEB = ?, BASE64_LOGO = ?, PARAMETRI_LOGO = ? WHERE ID_ENTE_SL = ?",dto.getIdEnteSl(),dto.getTipoSoggetto(),dto.getDenominazione(),dto.getPIva(),dto.getIdRegione(),dto.getDescRegione(),dto.getIdProv(),dto.getDescProv(),dto.getIdComune(),dto.getDescComune(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getNumCivico(),dto.getCap(),dto.getReferente(),dto.getTelefono(),dto.getCell(),dto.getEmail(),dto.getEmailPec(),dto.getFax(),dto.getSitoWeb(),dto.getBase64Logo(),dto.getParametriLogo(),pk.getIdEnteSl());
	}

	/** 
	 * Deletes a single row in the SICEE_T_ENTEFORM_SL_2015 table.
	 */
	
	public void delete(SiceeTEnteformSl2015Pk pk) throws SiceeTEnteformSl2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_ENTE_SL = ?",pk.getIdEnteSl());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTEnteformSl2015
	 */
	public SiceeTEnteformSl2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTEnteformSl2015 dto = new SiceeTEnteformSl2015();
		dto.setIdEnteSl( rs.getLong( 1 ) );
		dto.setTipoSoggetto( rs.getString( 2 ) );
		dto.setDenominazione( rs.getString( 3 ) );
		dto.setPIva( rs.getString( 4 ) );
		dto.setIdRegione( rs.getString( 5 ) );
		dto.setDescRegione( rs.getString( 6 ) );
		dto.setIdProv( rs.getString( 7 ) );
		dto.setDescProv( rs.getString( 8 ) );
		dto.setIdComune( rs.getString( 9 ) );
		dto.setDescComune( rs.getString( 10 ) );
		dto.setIdIndirizzo( rs.getString(11) );
		dto.setDescIndirizzo( rs.getString( 12 ) );
		dto.setNumCivico( rs.getString( 13 ) );
		dto.setCap( rs.getString( 14 ) );
		dto.setReferente( rs.getString( 15 ) );
		dto.setTelefono( rs.getString( 16 ) );
		dto.setCell( rs.getString( 17 ) );
		dto.setEmail( rs.getString( 18 ) );
		dto.setEmailPec( rs.getString( 19 ) );
		dto.setFax( rs.getString( 20 ) );
		dto.setSitoWeb( rs.getString( 21 ) );
		dto.setBase64Logo( rs.getString( 22 ) );
		dto.setParametriLogo( rs.getString( 23 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_ENTEFORM_SL_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_ENTE_SL = :idEnteSl'.
	 */
	
	public SiceeTEnteformSl2015 findByPrimaryKey(long idEnte) throws SiceeTEnteformSl2015DaoException
	{
		try {
			List<SiceeTEnteformSl2015> list = jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE ID_ENTE_SL = ?", this,idEnte);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'CF_CERTIFICATO = :cfCertificato'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereCfCertificatoEquals(String cfCertificato) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE CF_CERTIFICATO = ? ORDER BY CF_CERTIFICATO", this,cfCertificato);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTEnteformSl2015> findAll() throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " ORDER BY ID_ENTE_SL", this);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_ENTE_SL = :idEnteSl'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereIdEnteEquals(long idEnte) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE ID_ENTE_SL = ? ORDER BY ID_ENTE_SL", this,idEnte);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DENOMINAZIONE = :denominazione'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereDenominazioneEquals(String denominazione) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE DENOMINAZIONE = ? ORDER BY DENOMINAZIONE", this,denominazione);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'P_IVA = :pIva'.
	 */
	
	public List<SiceeTEnteformSl2015> findWherePIvaEquals(String pIva) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE P_IVA = ? ORDER BY P_IVA", this,pIva);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_REGIONE = :idRegione'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereIdRegioneEquals(String idRegione) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE ID_REGIONE = ? ORDER BY ID_REGIONE", this,idRegione);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DESC_REGIONE = :descRegione'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereDescRegioneEquals(String descRegione) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE DESC_REGIONE = ? ORDER BY DESC_REGIONE", this,descRegione);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_PROV = :idProv'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereIdProvEquals(String idProv) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE ID_PROV = ? ORDER BY ID_PROV", this,idProv);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DESC_PROV = :descProv'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereDescProvEquals(String descProv) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE DESC_PROV = ? ORDER BY DESC_PROV", this,descProv);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereIdComuneEquals(String idComune) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE ID_COMUNE = ? ORDER BY ID_COMUNE", this,idComune);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereDescComuneEquals(String descComune) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE DESC_COMUNE = ? ORDER BY DESC_COMUNE", this,descComune);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereIdIndirizzoEquals(String idIndirizzo) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE ID_INDIRIZZO = ? ORDER BY ID_INDIRIZZO", this,idIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE DESC_INDIRIZZO = ? ORDER BY DESC_INDIRIZZO", this,descIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'NUM_CIVICO = :numCivico'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereNumCivicoEquals(String numCivico) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE NUM_CIVICO = ? ORDER BY NUM_CIVICO", this,numCivico);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'CAP = :cap'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereCapEquals(String cap) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE CAP = ? ORDER BY CAP", this,cap);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'TELEFONO = :telefono'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereTelefonoEquals(String telefono) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE TELEFONO = ? ORDER BY TELEFONO", this,telefono);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'CELL = :cell'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereCellEquals(String cell) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE CELL = ? ORDER BY CELL", this,cell);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'EMAIL = :email'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereEmailEquals(String email) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE EMAIL = ? ORDER BY EMAIL", this,email);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'EMAIL_PEC = :emailPec'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereEmailPecEquals(String emailPec) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE EMAIL_PEC = ? ORDER BY EMAIL_PEC", this,emailPec);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'FAX = :fax'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereFaxEquals(String fax) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE FAX = ? ORDER BY FAX", this,fax);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_SL_2015 table that match the criteria 'SITO_WEB = :sitoWeb'.
	 */
	
	public List<SiceeTEnteformSl2015> findWhereSitoWebEquals(String sitoWeb) throws SiceeTEnteformSl2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE_SL, TIPO_SOGGETTO, DENOMINAZIONE, P_IVA, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB, BASE64_LOGO, PARAMETRI_LOGO FROM " + getTableName() + " WHERE SITO_WEB = ? ORDER BY SITO_WEB", this,sitoWeb);
		}
		catch (Exception e) {
			throw new SiceeTEnteformSl2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_ENTEFORM_SL_2015 table that matches the specified primary-key value.
	 */
	public SiceeTEnteformSl2015 findByPrimaryKey(SiceeTEnteformSl2015Pk pk) throws SiceeTEnteformSl2015DaoException
	{
		return findByPrimaryKey( pk.getIdEnteSl() );
	}

}
