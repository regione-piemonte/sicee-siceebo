/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.OptimizedSiceeTTransazione2018Dao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTTransazione2018Dao;
import it.csi.sicee.siceebo.business.dao.dto.OptimizedSiceeTTransazione2018;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTTransazione2018;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTTransazione2018Pk;
import it.csi.sicee.siceebo.business.dao.exceptions.OptimizedSiceeTTransazione2018DaoException;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTTransazione2018DaoException;
import it.csi.sicee.siceebo.dto.backoffice.FiltroDettaglioTransAttEsito;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.transaction.annotation.Transactional;

public class OptimizedSiceeTTransazione2018DaoImpl extends AbstractDAO implements ParameterizedRowMapper<OptimizedSiceeTTransazione2018>, OptimizedSiceeTTransazione2018Dao
{
	protected static final Logger log = Logger
			.getLogger(Constants.APPLICATION_CODE + ".business");
	
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
	 * Method 'mapRow'
	 * 
	 * @param rs
	 * @param row
	 * @throws SQLException
	 * @return SiceeTTransazione2018
	 */
	public OptimizedSiceeTTransazione2018 mapRow(ResultSet rs, int row) throws SQLException
	{
		OptimizedSiceeTTransazione2018 dto = new OptimizedSiceeTTransazione2018();
		dto.setIdTransazione2018( rs.getInt( 1 ) );
		dto.setFkStatoTrans2018( new Integer( rs.getInt(2) ) );
		dto.setDescrStatoTrans2018( rs.getString( 3 ) );
		dto.setS1IdTransazioneMdp( rs.getString(4 ) );
		dto.setS1ValoreTransazione( new Double( rs.getDouble(5) ) );
		if (rs.wasNull()) {
			dto.setS1ValoreTransazione( null );
		}

		dto.setS1DtCreazioneTransazione( rs.getTimestamp(6 ) );
		dto.setS2RagSocialePsp( rs.getString( 7 ) );
		dto.setS3IdIuv( rs.getString( 8 ) );
		
		dto.setS3DtAvvioTransazione( rs.getTimestamp(9 ) );
		dto.setOpGetstatotransFkStato( new Integer( rs.getInt(10) ) );
		if (rs.wasNull()) {
			dto.setOpGetstatotransFkStato( null );
		}
		dto.setDescrStatoTransMdp( rs.getString( 11 ) );
		
		dto.setOpGetstatotransDt( rs.getTimestamp(12 ) );
		return dto;
	}


	public List<OptimizedSiceeTTransazione2018> findDettTransazioniAttesaEsito(FiltroDettaglioTransAttEsito filtro) throws OptimizedSiceeTTransazione2018DaoException
	{
		try {

			MapSqlParameterSource params = new MapSqlParameterSource();

			StringBuffer query = new StringBuffer("");

			query.append("SELECT ID_TRANSAZIONE_2018, FK_STATO_TRANS_2018,");
			query.append(" st.DESCR_STATO_TRANS, S1_ID_TRANSAZIONE_MDP, S1_VALORE_TRANSAZIONE, S1_DT_CREAZIONE_TRANSAZIONE,");
			query.append(" S2_RAG_SOCIALE_PSP, S3_ID_IUV,");
			query.append(" S3_DT_AVVIO_TRANSAZIONE, OP_GETSTATOTRANS_FK_STATO,");
			query.append(" stmdp.DESCR_STATO_TRANS_MDP, OP_GETSTATOTRANS_DT");
			query.append(" FROM SICEE_T_TRANSAZIONE_2018 t, SICEE_D_STATO_TRANS_2018 st, SICEE_D_STATO_TRANS_MDP_2018 stmdp");
			query.append(" WHERE t.FK_STATO_TRANS_2018 = st.ID_STATO_TRANS_2018");
			query.append(" AND t.op_getstatotrans_fk_stato = stmdp.ID_STATO_TRANS_MDP_2018 (+)");

			query.append(" AND t.FK_STATO_TRANS_2018 = :idStatoTrans ");
			
			params.addValue("idStatoTrans", filtro.getIdTipoRicerca(), Types.INTEGER);

			if (!GenericUtil.isNullOrEmpty(filtro.getIdTransazione()))
			{
				query.append(" AND ID_TRANSAZIONE_2018 = :idTrans ");
				params.addValue("idTrans", filtro.getIdTransazione(), Types.INTEGER);
			}

			if (!GenericUtil.isNullOrEmpty(filtro.getIuv()))
			{
				query.append(" AND S3_ID_IUV = :iuv ");
				params.addValue("iuv", filtro.getIuv(), Types.VARCHAR);
			}

			if (!GenericUtil.isNullOrEmpty(filtro.getIdMdp()))
			{
				query.append(" AND S1_ID_TRANSAZIONE_MDP = :idMdp ");
				params.addValue("idMdp", filtro.getIdMdp(), Types.VARCHAR);
			}

			if (!GenericUtil.isNullOrEmpty(filtro.getCreazioneDal()) || !GenericUtil.isNullOrEmpty(filtro.getCreazioneAl()))
			{
				// ha selezionato entrambe le date
				if (!GenericUtil.isNullOrEmpty(filtro.getCreazioneDal()) && !GenericUtil.isNullOrEmpty(filtro.getCreazioneAl()))
				{
					query.append(" AND TRUNC(S1_DT_CREAZIONE_TRANSAZIONE) BETWEEN TO_DATE(:dataCreazioneDal,'DD/MM/YYYY') AND TO_DATE(:dataCreazioneAl,'DD/MM/YYYY') "); 
					params.addValue("dataCreazioneDal", filtro.getCreazioneDal(), Types.VARCHAR);
					params.addValue("dataCreazioneAl", filtro.getCreazioneAl(), Types.VARCHAR);
				}
				else if (!GenericUtil.isNullOrEmpty(filtro.getCreazioneDal()))
				{
					query.append(" AND TRUNC(S1_DT_CREAZIONE_TRANSAZIONE) >= TO_DATE(:dataCreazioneDal,'DD/MM/YYYY') "); 
					params.addValue("dataCreazioneDal", filtro.getCreazioneDal(), Types.VARCHAR);
				}
				else if (!GenericUtil.isNullOrEmpty(filtro.getCreazioneAl()))
				{
					query.append(" AND TRUNC(S1_DT_CREAZIONE_TRANSAZIONE) <= TO_DATE(:dataCreazioneAl,'DD/MM/YYYY') "); 
					params.addValue("dataCreazioneAl", filtro.getCreazioneAl(), Types.VARCHAR);
				}
			
			}
			
			
			query.append(" ORDER BY ID_TRANSAZIONE_2018 DESC");


			log.debug(query);
			return jdbcTemplate.query(query.toString(), this, params);
			
		}
		catch (Exception e) {
			throw new OptimizedSiceeTTransazione2018DaoException("Query failed", e);
		}
	}
	
	public Integer findCountTransazioniByStato(
			String dataCreazioneDal, String dataCreazioneAl, int statoTransazione)
			throws OptimizedSiceeTTransazione2018DaoException {
		try {
			
			MapSqlParameterSource params = new MapSqlParameterSource();

			StringBuffer query = new StringBuffer("SELECT count(*) ");
			
			query.append(" FROM SICEE_T_TRANSAZIONE_2018 ");
			query.append(" WHERE FK_STATO_TRANS_2018 = :idStatoTrans");
			query.append(" AND TRUNC(S1_DT_CREAZIONE_TRANSAZIONE) BETWEEN TO_DATE(:dataCreazioneDal,'DD/MM/YYYY') AND TO_DATE(:dataCreazioneAl,'DD/MM/YYYY') "); 
						
			params.addValue("idStatoTrans", statoTransazione, Types.INTEGER);
			params.addValue("dataCreazioneDal", dataCreazioneDal, Types.VARCHAR);
			params.addValue("dataCreazioneAl", dataCreazioneAl, Types.VARCHAR);
			
			log.debug(query);
					
			Integer count = jdbcTemplate.queryForInt(query.toString(), params);
			
			return count;
		}
		catch (Exception e) {
			throw new OptimizedSiceeTTransazione2018DaoException("Query failed", e);
		}
	}

	public Float findCountValoreTransazioniPagamentoOk(
			String dataCreazioneDal, String dataCreazioneAl)
			throws OptimizedSiceeTTransazione2018DaoException {
		try {
			
			MapSqlParameterSource params = new MapSqlParameterSource();

			StringBuffer query = new StringBuffer(" SELECT SUM (S1_VALORE_TRANSAZIONE) ");
			
			query.append(" FROM SICEE_T_TRANSAZIONE_2018 ");
			query.append(" WHERE FK_STATO_TRANS_2018 = :idStatoTrans");
			query.append(" AND TRUNC(S1_DT_CREAZIONE_TRANSAZIONE) BETWEEN TO_DATE(:dataCreazioneDal,'DD/MM/YYYY') AND TO_DATE(:dataCreazioneAl,'DD/MM/YYYY') "); 
						
			params.addValue("idStatoTrans", Constants.ID_STATO_TRANS_MDP_NEW_PAGAMENTO_OK, Types.INTEGER);
			params.addValue("dataCreazioneDal", dataCreazioneDal, Types.VARCHAR);
			params.addValue("dataCreazioneAl", dataCreazioneAl, Types.VARCHAR);
			
			log.debug(query);
					
//			Long count = jdbcTemplate.queryForLong(query.toString(), params);
//			
//			log.debug("findCountValoreTransazioniPagamentoOk - Stampo il count: "+count);
//
//			Object object = jdbcTemplate.queryForObject(query.toString(), String.class, params);
//			
//			log.debug("findCountValoreTransazioniPagamentoOk - Stampo il count: "+object);

			String count = jdbcTemplate.queryForObject(query.toString(), String.class, params);
			
			log.debug("findCountValoreTransazioniPagamentoOk - Stampo il count: "+count);

			return GenericUtil.convertToFloat(count);
		}
		catch (Exception e) {
			throw new OptimizedSiceeTTransazione2018DaoException("Query failed", e);
		}
	}
}
