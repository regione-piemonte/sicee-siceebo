/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2021
*******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

import it.csi.sicee.siceebo.business.dao.dao.SiceeLAccessoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLAccesso;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLAccessoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeLAccessoDaoException;
import it.csi.sicee.siceebo.util.Constants;

public class SiceeLAccessoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeLAccesso>, SiceeLAccessoDao {
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".dao");

	protected NamedParameterJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public SiceeLAccesso mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeLAccesso dto = new SiceeLAccesso();
		dto.setDtAccesso( rs.getTimestamp( 1 ) );
		dto.setCodiceFiscale( rs.getString( 2 ) );
		dto.setNome( rs.getString( 3 ) );
		dto.setCognome( rs.getString(4 ) );
		dto.setRuolo( rs.getString( 5 ) );
		
		return dto;
	}
	
	public void delete(SiceeLAccessoPk pk) throws SiceeLAccessoDaoException {
		log.debug("[SiceeLAccessoDaoImpl::delete] START");
		final String sql = "DELETE FROM " + getTableName()
				+ " WHERE DT_ACCESSO = :DT_ACCESSO  AND CODICE_FISCALE = :CODICE_FISCALE ";

		if (pk == null) {
			log.error("[SiceeLAccessoDaoImpl::delete] ERROR chiave primaria non impostata");
			throw new SiceeLAccessoDaoException("Chiave primaria non impostata");
		}

		MapSqlParameterSource params = new MapSqlParameterSource();

		// valorizzazione paametro relativo a colonna [DT_ACCESSO]
		params.addValue("DT_ACCESSO", pk.getDtAccesso(), java.sql.Types.TIMESTAMP);

		// valorizzazione paametro relativo a colonna [CODICE_FISCALE]
		params.addValue("CODICE_FISCALE", pk.getCodiceFiscale(), java.sql.Types.VARCHAR);

		jdbcTemplate.update(sql.toString(), params);
		
		log.debug("[SiceeLAccessoDaoImpl::delete] END");	}

	public Integer findLogAccessoDaStoricizzareCount() throws SiceeLAccessoDaoException {
		log.debug("[SiceeLAccessoDaoImpl::findLogAccessoDaStoricizzareCount] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();
		
		sql.append("SELECT COUNT (*) ");
		
		sql.append(" FROM "+ getTableName());
		
		sql.append(" WHERE ");

		sql.append(" EXTRACT(year FROM DT_ACCESSO) < (EXTRACT(year FROM CURRENT_DATE) - 1) ");

		log.debug("STAMPO LA QUERY: " + sql.toString());
		
		Integer count = null;
		try {
			count = jdbcTemplate.queryForInt(sql.toString(), paramMap);

		} catch (RuntimeException ex) {
			log.error("[SiceeLAccessoDaoImpl::findLogAccessoDaStoricizzareCount] esecuzione query", ex);
			
			throw new SiceeLAccessoDaoException("Query failed", ex);
		} finally {
			log.debug("[SiceeLAccessoDaoImpl::findLogAccessoDaStoricizzareCount] END");
		}
		return count;
	}

	public List<SiceeLAccesso> findDaArchiviare() throws SiceeLAccessoDaoException {
		log.debug("[SiceeLAccessoDaoImpl::findDaArchiviare] START");
		StringBuilder sql = new StringBuilder();
		MapSqlParameterSource paramMap = new MapSqlParameterSource();

		sql.append("SELECT DT_ACCESSO,CODICE_FISCALE,NOME,COGNOME,RUOLO ");
		sql.append(" FROM " + getTableName());
		sql.append(" WHERE ");
		sql.append(" EXTRACT(year FROM DT_ACCESSO) < (EXTRACT(year FROM CURRENT_DATE) - 1) ");
		sql.append(" AND ROWNUM <= (SELECT VALORE FROM SICEE_T_PARAMETRI WHERE CODICE='MAX_RECORDS_STORICIZZAZIONE') ");
		sql.append(" ORDER BY DT_ACCESSO ASC ");
	
		List<SiceeLAccesso> list = null;
		try {
			list = jdbcTemplate.query(sql.toString(), paramMap, this);

		} catch (RuntimeException ex) {
			log.error("[SiceeLAccessoDaoImpl::findDaArchiviare] esecuzione query", ex);
			throw new SiceeLAccessoDaoException("Query failed", ex);
		} finally {
			log.debug("[SiceeLAccessoDaoImpl::findDaArchiviare] END");
		}
		return list;
	}

	public String getTableName()
	{
		return "SICEE_L_ACCESSO";
	}

}
