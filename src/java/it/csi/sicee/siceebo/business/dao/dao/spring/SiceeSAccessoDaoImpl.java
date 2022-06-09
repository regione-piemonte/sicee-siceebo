/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2021
*******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import it.csi.sicee.siceebo.business.dao.dao.SiceeSAccessoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeSAccesso;
import it.csi.sicee.siceebo.business.dao.dto.SiceeSAccessoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeSAccessoDaoException;
import it.csi.sicee.siceebo.util.Constants;

public class SiceeSAccessoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeSAccesso>, SiceeSAccessoDao {

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".dao");

	protected NamedParameterJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public SiceeSAccesso mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeSAccesso dto = new SiceeSAccesso();
		dto.setDtAccesso( rs.getTimestamp( 1 ) );
		dto.setCodiceFiscale( rs.getString( 2 ) );
		dto.setNome( rs.getString( 3 ) );
		dto.setCognome( rs.getString(4 ) );
		dto.setRuolo( rs.getString( 5 ) );
		
		return dto;
	}
	
	public SiceeSAccessoPk insert(SiceeSAccesso dto) throws SiceeSAccessoDaoException {
		log.debug("[SiceeSAccessoDaoImpl::insert] START");
		final String sql = "INSERT INTO " + getTableName()
				+ " ( 	DT_ACCESSO,CODICE_FISCALE,NOME,COGNOME,RUOLO ) VALUES (  :DT_ACCESSO , :CODICE_FISCALE , :NOME , :COGNOME , :RUOLO  )";

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_ACCESSO]
		params.addValue("DT_ACCESSO", dto.getDtAccesso(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", dto.getCodiceFiscale(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [NOME]
		params.addValue("NOME", dto.getNome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [COGNOME]
		params.addValue("COGNOME", dto.getCognome(), java.sql.Types.VARCHAR);

		// valorizzazione paametro relativo a colonna [RUOLO]
		params.addValue("RUOLO", dto.getRuolo(), java.sql.Types.VARCHAR);

		jdbcTemplate.update(sql.toString(), params);
		
		log.debug("[SiceeSAccessoDaoImpl::insert] END");
		return dto.createPk();
	}

	public Integer findLogAccessoDaCancellareCount() throws SiceeSAccessoDaoException {
		log.debug("[SiceeSAccessoDaoImpl::findLogAccessoDaCancellareCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM " + getTableName());
		
		sql.append(" WHERE ");

		sql.append(" EXTRACT(year FROM DT_ACCESSO) < (EXTRACT(year FROM CURRENT_DATE) - 4) ");
		
		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		try {
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error("[SiceeSAccessoDaoImpl::findLogAccessoDaCancellareCount] esecuzione query", ex);
			throw new SiceeSAccessoDaoException("Query failed", ex);
		} finally {
			log.debug("[SiceeSAccessoDaoImpl::findLogAccessoDaCancellareCount] END");
		}
		return count;
	}

	public void deleteOld() throws SiceeSAccessoDaoException {
		log.debug("[SiceeSAccessoDaoImpl::customDeleterOld] START");
		final StringBuffer sql = new StringBuffer("DELETE FROM " + getTableName() + " sAccesso WHERE ");
		MapSqlParameterSource params = new MapSqlParameterSource();

		sql.append(" EXISTS ");
		sql.append(" (SELECT 1 FROM " + getTableName() + " sAccesso2 ");
		sql.append(" WHERE sAccesso.DT_ACCESSO = sAccesso2.DT_ACCESSO AND sAccesso.CODICE_FISCALE = sAccesso2.CODICE_FISCALE ");
		sql.append(" AND EXTRACT(year FROM DT_ACCESSO) < (EXTRACT(year FROM CURRENT_DATE) - 4) ");
		sql.append(" AND ROWNUM <= (SELECT VALORE FROM SICEE_T_PARAMETRI WHERE CODICE='MAX_RECORDS_STORICIZZAZIONE')) ");

		jdbcTemplate.update(sql.toString(), params);
		log.debug("[SiceeSAccessoDaoImpl::customDeleterOld] END");

	}
	
	public String getTableName()
	{
		return "SICEE_S_ACCESSO";
	}

}
