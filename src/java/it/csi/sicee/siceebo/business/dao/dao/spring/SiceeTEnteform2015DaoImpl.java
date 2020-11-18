/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTEnteform2015Dao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteform2015;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTEnteform2015Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTEnteform2015DaoException;
import java.util.List;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class SiceeTEnteform2015DaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTEnteform2015>, SiceeTEnteform2015Dao
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
	 * @return SiceeTEnteform2015Pk
	 */
	
	public SiceeTEnteform2015Pk insert(SiceeTEnteform2015 dto)
	{
		dto.setIdEnte(incrementer.nextLongValue());
		jdbcTemplate.update("INSERT INTO " + getTableName() + " ( ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )",dto.getIdEnte(),dto.getFkEnteSl(),dto.getCodFormReg(),dto.getIdRegione(),dto.getDescRegione(),dto.getIdProv(),dto.getDescProv(),dto.getIdComune(),dto.getDescComune(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getNumCivico(),dto.getCap(),dto.getReferente(),dto.getTelefono(),dto.getCell(),dto.getEmail(),dto.getEmailPec(),dto.getFax(),dto.getSitoWeb());
		return dto.createPk();
	}

	/** 
	 * Updates a single row in the SICEE_T_ENTEFORM_2015 table.
	 */
	
	public void update(SiceeTEnteform2015Pk pk, SiceeTEnteform2015 dto) throws SiceeTEnteform2015DaoException
	{
		jdbcTemplate.update("UPDATE " + getTableName() + " SET ID_ENTE = ?, FK_ENTE_SL = ?, COD_FORM_REG = ?, ID_REGIONE = ?, DESC_REGIONE = ?, ID_PROV = ?, DESC_PROV = ?, ID_COMUNE = ?, DESC_COMUNE = ?, ID_INDIRIZZO = ?, DESC_INDIRIZZO = ?, NUM_CIVICO = ?, CAP = ?, REFERENTE = ?, TELEFONO = ?, CELL = ?, EMAIL = ?, EMAIL_PEC = ?, FAX = ?, SITO_WEB = ? WHERE ID_ENTE = ?",dto.getIdEnte(),dto.getFkEnteSl(),dto.getCodFormReg(),dto.getIdRegione(),dto.getDescRegione(),dto.getIdProv(),dto.getDescProv(),dto.getIdComune(),dto.getDescComune(),dto.getIdIndirizzo(),dto.getDescIndirizzo(),dto.getNumCivico(),dto.getCap(),dto.getReferente(),dto.getTelefono(),dto.getCell(),dto.getEmail(),dto.getEmailPec(),dto.getFax(),dto.getSitoWeb(),pk.getIdEnte());
	}

	/** 
	 * Deletes a single row in the SICEE_T_ENTEFORM_2015 table.
	 */
	
	public void delete(SiceeTEnteform2015Pk pk) throws SiceeTEnteform2015DaoException
	{
		jdbcTemplate.update("DELETE FROM " + getTableName() + " WHERE ID_ENTE = ?",pk.getIdEnte());
	}

	/**
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTEnteform2015
	 */
	public SiceeTEnteform2015 mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTEnteform2015 dto = new SiceeTEnteform2015();
		dto.setIdEnte( rs.getLong( 1 ) );
		dto.setFkEnteSl( rs.getLong( 2 ) );
		dto.setCodFormReg( rs.getString( 3 ) );
		dto.setIdRegione( rs.getString( 4 ) );
		dto.setDescRegione( rs.getString( 5 ) );
		dto.setIdProv( rs.getString( 6 ) );
		dto.setDescProv( rs.getString( 7 ) );
		dto.setIdComune( rs.getString( 8 ) );
		dto.setDescComune( rs.getString( 9 ) );
		dto.setIdIndirizzo( rs.getString(10) );
		dto.setDescIndirizzo( rs.getString( 11 ) );
		dto.setNumCivico( rs.getString( 12 ) );
		dto.setCap( rs.getString( 13 ) );
		dto.setReferente( rs.getString( 14 ) );
		dto.setTelefono( rs.getString( 15 ) );
		dto.setCell( rs.getString( 16 ) );
		dto.setEmail( rs.getString( 17 ) );
		dto.setEmailPec( rs.getString( 18 ) );
		dto.setFax( rs.getString( 19 ) );
		dto.setSitoWeb( rs.getString( 20 ) );
		return dto;
	}

	/**
	 * Method 'getTableName'
	 * 
	 * @return String
	 */
	public String getTableName()
	{
		return "SICEE_T_ENTEFORM_2015";
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	
	public SiceeTEnteform2015 findByPrimaryKey(long idEnte) throws SiceeTEnteform2015DaoException
	{
		try {
			List<SiceeTEnteform2015> list = jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE ID_ENTE = ?", this,idEnte);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'CF_CERTIFICATO = :cfCertificato'.
	 */
	
	public List<SiceeTEnteform2015> findWhereCfCertificatoEquals(String cfCertificato) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE CF_CERTIFICATO = ? ORDER BY CF_CERTIFICATO", this,cfCertificato);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria ''.
	 */
	
	public List<SiceeTEnteform2015> findAll() throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " ORDER BY ID_ENTE", this);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	
	public List<SiceeTEnteform2015> findWhereIdEnteEquals(long idEnte) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE ID_ENTE = ? ORDER BY ID_ENTE", this,idEnte);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_ENTE = :idEnte'.
	 */
	
	public List<SiceeTEnteform2015> findWhereFkEnteSlEquals(long fkEnteSl) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE FK_ENTE_SL = ? ORDER BY ID_ENTE", this,fkEnteSl);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DENOMINAZIONE = :denominazione'.
	 */
	
	public List<SiceeTEnteform2015> findWhereDenominazioneEquals(String denominazione) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE DENOMINAZIONE = ? ORDER BY DENOMINAZIONE", this,denominazione);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'P_IVA = :pIva'.
	 */
	
	public List<SiceeTEnteform2015> findWherePIvaEquals(String pIva) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE P_IVA = ? ORDER BY P_IVA", this,pIva);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_REGIONE = :idRegione'.
	 */
	
	public List<SiceeTEnteform2015> findWhereIdRegioneEquals(String idRegione) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE ID_REGIONE = ? ORDER BY ID_REGIONE", this,idRegione);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DESC_REGIONE = :descRegione'.
	 */
	
	public List<SiceeTEnteform2015> findWhereDescRegioneEquals(String descRegione) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE DESC_REGIONE = ? ORDER BY DESC_REGIONE", this,descRegione);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_PROV = :idProv'.
	 */
	
	public List<SiceeTEnteform2015> findWhereIdProvEquals(String idProv) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE ID_PROV = ? ORDER BY ID_PROV", this,idProv);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DESC_PROV = :descProv'.
	 */
	
	public List<SiceeTEnteform2015> findWhereDescProvEquals(String descProv) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE DESC_PROV = ? ORDER BY DESC_PROV", this,descProv);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_COMUNE = :idComune'.
	 */
	
	public List<SiceeTEnteform2015> findWhereIdComuneEquals(String idComune) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE ID_COMUNE = ? ORDER BY ID_COMUNE", this,idComune);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DESC_COMUNE = :descComune'.
	 */
	
	public List<SiceeTEnteform2015> findWhereDescComuneEquals(String descComune) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE DESC_COMUNE = ? ORDER BY DESC_COMUNE", this,descComune);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 */
	
	public List<SiceeTEnteform2015> findWhereIdIndirizzoEquals(String idIndirizzo) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE ID_INDIRIZZO = ? ORDER BY ID_INDIRIZZO", this,idIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 */
	
	public List<SiceeTEnteform2015> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE DESC_INDIRIZZO = ? ORDER BY DESC_INDIRIZZO", this,descIndirizzo);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'NUM_CIVICO = :numCivico'.
	 */
	
	public List<SiceeTEnteform2015> findWhereNumCivicoEquals(String numCivico) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE NUM_CIVICO = ? ORDER BY NUM_CIVICO", this,numCivico);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'CAP = :cap'.
	 */
	
	public List<SiceeTEnteform2015> findWhereCapEquals(String cap) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE CAP = ? ORDER BY CAP", this,cap);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'TELEFONO = :telefono'.
	 */
	
	public List<SiceeTEnteform2015> findWhereTelefonoEquals(String telefono) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE TELEFONO = ? ORDER BY TELEFONO", this,telefono);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'CELL = :cell'.
	 */
	
	public List<SiceeTEnteform2015> findWhereCellEquals(String cell) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE CELL = ? ORDER BY CELL", this,cell);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'EMAIL = :email'.
	 */
	
	public List<SiceeTEnteform2015> findWhereEmailEquals(String email) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE EMAIL = ? ORDER BY EMAIL", this,email);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'EMAIL_PEC = :emailPec'.
	 */
	
	public List<SiceeTEnteform2015> findWhereEmailPecEquals(String emailPec) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE EMAIL_PEC = ? ORDER BY EMAIL_PEC", this,emailPec);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'FAX = :fax'.
	 */
	
	public List<SiceeTEnteform2015> findWhereFaxEquals(String fax) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE FAX = ? ORDER BY FAX", this,fax);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns all rows from the SICEE_T_ENTEFORM_2015 table that match the criteria 'SITO_WEB = :sitoWeb'.
	 */
	
	public List<SiceeTEnteform2015> findWhereSitoWebEquals(String sitoWeb) throws SiceeTEnteform2015DaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_ENTE, FK_ENTE_SL, COD_FORM_REG, ID_REGIONE, DESC_REGIONE, ID_PROV, DESC_PROV, ID_COMUNE, DESC_COMUNE, ID_INDIRIZZO, DESC_INDIRIZZO, NUM_CIVICO, CAP, REFERENTE, TELEFONO, CELL, EMAIL, EMAIL_PEC, FAX, SITO_WEB FROM " + getTableName() + " WHERE SITO_WEB = ? ORDER BY SITO_WEB", this,sitoWeb);
		}
		catch (Exception e) {
			throw new SiceeTEnteform2015DaoException("Query failed", e);
		}
		
	}

	/** 
	 * Returns the rows from the SICEE_T_ENTEFORM_2015 table that matches the specified primary-key value.
	 */
	public SiceeTEnteform2015 findByPrimaryKey(SiceeTEnteform2015Pk pk) throws SiceeTEnteform2015DaoException
	{
		return findByPrimaryKey( pk.getIdEnte() );
	}

}
