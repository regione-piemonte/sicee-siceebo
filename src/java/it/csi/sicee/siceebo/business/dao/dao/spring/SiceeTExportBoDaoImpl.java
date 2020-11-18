/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTExportBoDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBo;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTExportBoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTExportBoDaoException;
import it.csi.sicee.siceebo.dto.ace.FiltroRicercaAce;
import it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFive;
import it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class SiceeTExportBoDaoImpl extends AbstractDAO implements ParameterizedRowMapper<SiceeTExportBo>, SiceeTExportBoDao
{
	protected SimpleJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".dao");

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
	 * @return SiceeTExportBo
	 */
	public SiceeTExportBo mapRow(ResultSet rs, int row) throws SQLException
	{
		SiceeTExportBo dto = new SiceeTExportBo();
		
		//GenericUtil.stampa(rs, false, 4);
		
		dto.setIdCertificatore( rs.getString( "id_certificatore" ) );
		dto.setProgrCertificato( rs.getString( "progr_certificato" ) );
		dto.setAnno( rs.getString( "anno" ) );
		dto.setNumCertificatore( rs.getString( "num_certificatore" ) );
		

		dto.setNome( rs.getString( "nome" ) );
		dto.setCognome( rs.getString( "cognome" ) );

		
		dto.setDtInizio( rs.getTimestamp( "dt_inizio" ) );
		dto.setDtUpload( rs.getTimestamp( "dt_upload" ) );
		dto.setDtScadenza( rs.getTimestamp( "dt_scadenza" ) );
		dto.setDescProv( rs.getString( "desc_prov" ) );
		dto.setIdProv( rs.getString( "id_prov" ) );
		dto.setDescComune( rs.getString( "desc_comune" ) );
		dto.setIdComune( rs.getString( "id_comune" ) );
		dto.setGradiGiorno( new Integer( rs.getInt( "gradi_giorno" ) ) );
		if (rs.wasNull()) {
			dto.setGradiGiorno( null );
		}

		dto.setPiano( new Integer( rs.getInt( "piano" ) ) );
		if (rs.wasNull()) {
			dto.setPiano( null );
		}
		
		dto.setNumPianiComplessivi( new Integer( rs.getInt( "num_piani_complessivi" ) ) );
		if (rs.wasNull()) {
			dto.setNumPianiComplessivi( null );
		}

		dto.setDescStato( rs.getString( "desc_stato" ) );
		dto.setFkStato( new Integer( rs.getInt( "id_stato" ) ) );

		dto.setDescDestUso( rs.getString( "sigla_dest_uso" ) );
		
		dto.setDescTipoEdificio( rs.getString( "desc_tipo_edificio" ) );
		
		dto.setDescEdificio( rs.getString( "desc_edificio" ) );
		
		dto.setDescClasse( rs.getString( "desc_classe_energ" ) );
		dto.setDescClasse192_05( rs.getString( "desc_classe_energ_192_05" ) );
		
		dto.setAnnoCostruzione( new Integer( rs.getInt("anno_costruzione") ) );
		if (rs.wasNull()) {
			dto.setAnnoCostruzione( null );
		}
		
		dto.setAnnoUltRist( new Integer( rs.getInt("anno_ult_rist") ) );
		if (rs.wasNull()) {
			dto.setAnnoUltRist( null );
		}
		
		dto.setVolLordoRiscaldato( new Double( rs.getDouble("vol_lordo_riscaldato") ) );
		if (rs.wasNull()) {
			dto.setVolLordoRiscaldato( null );
		}
		
		dto.setSupDisperdenteTot( new Double( rs.getDouble("sup_disperdente_tot") ) );
		if (rs.wasNull()) {
			dto.setSupDisperdenteTot( null );
		}
		
		dto.setSu( new Double( rs.getDouble("su") ) );
		if (rs.wasNull()) {
			dto.setSu( null );
		}
		
		dto.setTrasmOpache( new Double( rs.getDouble("trasm_opache") ) );
		if (rs.wasNull()) {
			dto.setTrasmOpache( null );
		}
		
		dto.setTrasmTrasp( new Double( rs.getDouble("trasm_trasp") ) );
		if (rs.wasNull()) {
			dto.setTrasmTrasp( null );
		}
		
		
		dto.setDescTipoImpianto( rs.getString( "desc_tipo_impianto" ) );
		dto.setDescCombRisc( rs.getString( "desc_comb_risc" ) );
		
		// BEPPE sarebbe da rinominare in acs
		dto.setDescCombAsc( rs.getString( "desc_comb_acs" ) );

		
		
		
		dto.setFattoreForma( new Double( rs.getDouble("fattore_forma") ) );
		if (rs.wasNull()) {
			dto.setFattoreForma( null );
		}
		
		dto.setvSu( new Double( rs.getDouble("v_su") ) );
		if (rs.wasNull()) {
			dto.setvSu( null );
		}
		
		dto.setFattoreForma( new Double( rs.getDouble("fattore_forma") ) );
		if (rs.wasNull()) {
			dto.setFattoreForma( null );
		}
		
		dto.setDomRiscQh( new Double( rs.getDouble("dom_risc_qh") ) );
		if (rs.wasNull()) {
			dto.setDomRiscQh( null );
		}
		
		dto.setDomRiscQhto( new Double( rs.getDouble("dom_risc_qhto") ) );
		if (rs.wasNull()) {
			dto.setDomRiscQhto( null );
		}
		
		dto.setIndRiscEpito( new Double( rs.getDouble("ind_risc_epito") ) );
		if (rs.wasNull()) {
			dto.setIndRiscEpito( null );
		}

		dto.setIndRiscEpi( new Double( rs.getDouble("ind_risc_epi") ) );
		if (rs.wasNull()) {
			dto.setIndRiscEpi( null );
		}

		dto.setFabbAcs( new Double( rs.getDouble("fabb_acs") ) );
		if (rs.wasNull()) {
			dto.setFabbAcs( null );
		}
		
		dto.setValorePrestPdc( new Double( rs.getDouble("valore_prest_pdc") ) );
		if (rs.wasNull()) {
			dto.setValorePrestPdc( null );
		}
		
		dto.setRendAcsEtagacs( new Double( rs.getDouble("rend_acs_etagacs") ) );
		if (rs.wasNull()) {
			dto.setRendAcsEtagacs( null );
		}
		
		dto.setDomAcsQhw( new Double( rs.getDouble("dom_acs_qhw") ) );
		if (rs.wasNull()) {
			dto.setDomAcsQhw( null );
		}
		
		dto.setEnAcsRinno( new Double( rs.getDouble("en_acs_rinno") ) );
		if (rs.wasNull()) {
			dto.setEnAcsRinno( null );
		}
		
		dto.setRendImpEtag( new Double( rs.getDouble("rend_imp_etag") ) );
		if (rs.wasNull()) {
			dto.setRendImpEtag( null );
		}
		
		dto.setDomAcsQhwSu( new Double( rs.getDouble("dom_acs_qhw_su") ) );
		if (rs.wasNull()) {
			dto.setDomAcsQhwSu( null );
		}
		
		dto.setIndGlobEplordo( new Double( rs.getDouble("ind_glob_eplordo") ) );
		if (rs.wasNull()) {
			dto.setIndGlobEplordo( null );
		}

		dto.setIndGlobEplordoTo( new Double( rs.getDouble("ind_glob_eplordo_to") ) );
		if (rs.wasNull()) {
			dto.setIndGlobEplordoTo( null );
		}

		dto.setDomAcsQhwto( new Double( rs.getDouble("dom_acs_qhwto") ) );
		if (rs.wasNull()) {
			dto.setDomAcsQhwto( null );
		}
		
		dto.setDescMotivo( rs.getString( "desc_motivo" ) );
		
		dto.setMetodologiaCalcolo( rs.getString( "metodologia_calcolo" ) );
		dto.setSwUtilizzato( rs.getString( "sw_utilizzato" ) );
		dto.setDescIndirizzo( rs.getString( "desc_indirizzo" ) );
		
		dto.setNumCivico( rs.getString( "num_civico" ) );
		dto.setSezione( rs.getString( "sezione" ) );
		dto.setFoglio( rs.getString( "foglio" ) );
		
		dto.setParticella( rs.getString( "particella" ) );
		dto.setSubalterno( rs.getString( "subalterno" ) );

		
		dto.setPrestazioneEne( new Double( rs.getDouble("prestazione_ene") ) );
		if (rs.wasNull()) {
			dto.setPrestazioneEne( null );
		}

		dto.setNumAppartamenti( new Integer( rs.getInt("num_appartamenti") ) );
		if (rs.wasNull()) {
			dto.setNumAppartamenti( null );
		}

		dto.setUiServite( rs.getString( "ui_servite" ) );
		
		dto.setPotRiscaldamento( new Double( rs.getDouble("pot_riscaldamento") ) );
		if (rs.wasNull()) {
			dto.setPotRiscaldamento( null );
		}
		
		dto.setDescClasseEff( rs.getString( "desc_classe_eff" ) );
		
		dto.setGenAnnoRisc( new Integer( rs.getInt("gen_anno_risc") ) );
		if (rs.wasNull()) {
			dto.setGenAnnoRisc( null );
		}
		
		dto.setFlgContRip( rs.getString( "flg_cont_rip" ) );
		
		
		dto.setRendGener( new Double( rs.getDouble("rend_gener") ) );
		if (rs.wasNull()) {
			dto.setRendGener( null );
		}
		
		dto.setRendRegol( new Double( rs.getDouble("rend_regol") ) );
		if (rs.wasNull()) {
			dto.setRendRegol( null );
		}
		
		dto.setRendEmiss( new Double( rs.getDouble("rend_emiss") ) );
		if (rs.wasNull()) {
			dto.setRendEmiss( null );
		}
		
		dto.setRendDistrib( new Double( rs.getDouble("rend_distrib") ) );
		if (rs.wasNull()) {
			dto.setRendDistrib( null );
		}
		
		
		
		dto.setFlgOld( rs.getString( "flg_old" ) );
		dto.setFlgEdifE0( rs.getString( "flg_edif_e0" ) );

		dto.setEpglNrenGlobale( new Double( rs.getDouble("epgl_nren_globale") ) );
		if (rs.wasNull()) {
			dto.setEpglNrenGlobale( null );
		}
		
		dto.setEpglRenGlobale( new Double( rs.getDouble("epgl_ren_globale") ) );
		if (rs.wasNull()) {
			dto.setEpglRenGlobale( null );
		}
		
		dto.setEmissioniCo2( new Double( rs.getDouble("emissioni_co2") ) );
		if (rs.wasNull()) {
			dto.setEmissioniCo2( null );
		}
		
		dto.setSupRaffrescata( new Double( rs.getDouble("sup_raffrescata") ) );
		if (rs.wasNull()) {
			dto.setSupRaffrescata( null );
		}
		
		dto.setSupRiscaldata( new Double( rs.getDouble("sup_riscaldata") ) );
		if (rs.wasNull()) {
			dto.setSupRiscaldata( null );
		}
		
		dto.setVolLordoRaffrescato( new Double( rs.getDouble("vol_lordo_raffrescato") ) );
		if (rs.wasNull()) {
			dto.setVolLordoRaffrescato( null );
		}
		
		dto.setVolLordoRiscaldato( new Double( rs.getDouble("vol_lordo_riscaldato") ) );
		if (rs.wasNull()) {
			dto.setVolLordoRiscaldato( null );
		}
		
		dto.setEph( new Double( rs.getDouble("eph") ) );
		if (rs.wasNull()) {
			dto.setEph( null );
		}
		
		dto.setAsolAsup( new Double( rs.getDouble("asol_asup") ) );
		if (rs.wasNull()) {
			dto.setAsolAsup( null );
		}
		
		dto.setYie( new Double( rs.getDouble("yie") ) );
		if (rs.wasNull()) {
			dto.setYie( null );
		}
		
		dto.setVSuRaff( new Double( rs.getDouble("v_su_raff") ) );
		if (rs.wasNull()) {
			dto.setVSuRaff( null );
		}

		dto.setVSuRisc( new Double( rs.getDouble("v_su_risc") ) );
		if (rs.wasNull()) {
			dto.setVSuRisc( null );
		}

		dto.setSVRaff( new Double( rs.getDouble("s_v_raff") ) );
		if (rs.wasNull()) {
			dto.setSVRaff( null );
		}

		dto.setSVRisc( new Double( rs.getDouble("s_v_risc") ) );
		if (rs.wasNull()) {
			dto.setSVRisc( null );
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
		return "SICEE_T_EXPORT_BO";
	}

	/** 
	 * Updates a single row in the SICEE_T_EXPORT_BO table.
	 */
	
	public void updateStato(SiceeTExportBoPk pk, Integer fkStato) throws SiceeTExportBoDaoException
	{

		jdbcTemplate.update("UPDATE " + getTableName() + " SET FK_STATO = ? WHERE ANNO = ? AND ID_CERTIFICATORE = ? AND PROGR_CERTIFICATO = ?",
				fkStato,pk.getAnno(),pk.getIdCertificatore(),pk.getProgrCertificato());
	}

	public List<SiceeTExportBo> findElencoAceByCodice(
			FiltroRicercaAce filtro, Long parametro)
			throws SiceeTExportBoDaoException {
		try {
			
			StringBuffer query = getInizioQuery(filtro.getFlgIsOld());
			MapSqlParameterSource params = new MapSqlParameterSource();

			query.append(" AND cert.num_certificatore = :num_certificatore "); // Numero certificatore
			params.addValue("num_certificatore", filtro.getCertificatore(), Types.VARCHAR);
			
			query.append(" AND bo.progr_certificato = :progr_certificato "); // Progressivo certificato
			params.addValue("progr_certificato", filtro.getProgCertificato(), Types.VARCHAR);
			
			query.append(" AND bo.anno = :anno "); // Anno
			params.addValue("anno", filtro.getAnnoCertificato(), Types.VARCHAR);
			
			query.append(" AND bo.fk_stato in ("+Constants.INVIATO+","+Constants.ANNULLATO+","+Constants.ANNULLATO_BO+") ");

			query.append("AND bo.id_certificatore >:parametro "); 
			params.addValue("parametro", parametro, Types.NUMERIC);		
			
			//query.append(" ORDER BY  bo.anno, bo.id_certificatore, bo.progr_certificato "); // Ordinamento
			
			log.debug(query);
					
			return jdbcTemplate.query(query.toString(), this, params );
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
	}


	public Integer findElencoAceByFiltroCount(
			FiltroRicercaAce filtro, Long parametro)
	throws SiceeTExportBoDaoException {
		try {


			StringBuffer query = new StringBuffer("SELECT count(*) ");
			
			getQueryFromWhere(query, filtro.getFlgIsOld());
			
			MapSqlParameterSource params = new MapSqlParameterSource();

			completaQueryWhere(query, filtro, parametro, params);
			
			log.debug(query);

			Integer count = jdbcTemplate.queryForInt(query.toString(), params);
			
			return count;
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
	}

	public List<SiceeTExportBo> findElencoAceByFiltro(
			FiltroRicercaAce filtro, Long parametro)
			throws SiceeTExportBoDaoException {
		try {
			
			StringBuffer query = getInizioQuery(filtro.getFlgIsOld());
			MapSqlParameterSource params = new MapSqlParameterSource();

			completaQueryWhere(query, filtro, parametro, params);

			query.append(" ORDER BY  bo.anno, cert.num_certificatore, bo.progr_certificato "); // Ordinamento

			
			log.debug(query);
					
			return jdbcTemplate.query(query.toString(), this, params);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
	}
	
	public SiceeTExportBo findAceByPrimaryKey(
			SiceeTExportBoPk key, boolean isOld)
			throws SiceeTExportBoDaoException {
		try {
			
			StringBuffer query = getInizioQuery(isOld);
			MapSqlParameterSource params = new MapSqlParameterSource();

			query.append(" AND bo.id_certificatore = :id_certificatore "); // Numero certificatore
			params.addValue("id_certificatore", key.getIdCertificatore(), Types.VARCHAR);
			
			query.append(" AND bo.progr_certificato = :progr_certificato "); // Progressivo certificato
			params.addValue("progr_certificato", key.getProgrCertificato(), Types.VARCHAR);
			
			query.append(" AND bo.anno = :anno "); // Anno
			params.addValue("anno", key.getAnno(), Types.VARCHAR);
			
			//query.append(" ORDER BY  bo.anno, bo.id_certificatore, bo.progr_certificato "); // Ordinamento
			
			log.debug(query);
				
			List<SiceeTExportBo> list = jdbcTemplate.query(query.toString(), this, params);
			return list.size() == 0 ? null : list.get(0);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
	}

	private StringBuffer completaQueryWhere(StringBuffer query, FiltroRicercaAce filtro, Long parametro, MapSqlParameterSource params) 
	{
		
		if (!GenericUtil.isNullOrEmpty(filtro.getInviatiAnno())) {
			query.append("AND TO_CHAR(bo.dt_upload ,'YYYY') = :dt_anno ");
			//query.append("AND TRUNC(bo.dt_upload, 'YYYY') = TO_DATE(:dt_anno,'YYYY') ");
			params.addValue("dt_anno", filtro.getInviatiAnno(), Types.VARCHAR);
			//query.append("AND TRUNC(bo.dt_upload) BETWEEN TO_DATE(:dt_upload_dal,'DD/MM/YYYY') AND TO_DATE(:dt_upload_al,'DD/MM/YYYY') "); // --TRUNC(dt_upload) BETWEEN TO_DATE(':dataDal','DD/MM/YYYY') AND TO_DATE(':dataAl','DD/MM/YYYY') ");
		}		

		if (!GenericUtil.isNullOrEmpty(filtro.getNumMatricola())) {

			query.append("AND cert.num_certificatore = :num_matricola ");
			params.addValue("num_matricola", filtro.getNumMatricola(), Types.VARCHAR);
		}

		if ( !GenericUtil.isNullOrEmpty(filtro.getCodProvincia())) {
			query.append("AND bo.id_prov = :id_prov ");
			params.addValue("id_prov", filtro.getCodProvincia(), Types.VARCHAR);
		}

		if ( !GenericUtil.isNullOrEmpty(filtro.getCodComune())) {
			query.append("AND bo.id_comune = :id_comune ");
			params.addValue("id_comune", filtro.getCodComune(), Types.VARCHAR);
		}

		if ( !GenericUtil.isNullOrEmpty(filtro.getDescComune())) {
			query.append("AND UPPER(bo.desc_comune) = :desc_comune ");
			params.addValue("desc_comune", GenericUtil.raddoppiaApici(filtro.getDescComune()).toUpperCase(), Types.VARCHAR);
		}

		if (!GenericUtil.isNullOrEmpty(filtro.getDescIndirizzo())) {
			query.append("AND UPPER(bo.desc_indirizzo) LIKE UPPER(:desc_indirizzo) ");
			params.addValue("desc_indirizzo", likeString(filtro.getDescIndirizzo()), Types.VARCHAR);
		}

		if (!GenericUtil.isNullOrEmpty(filtro.getNumCivico())) {
			query.append("AND bo.num_civico = :num_civico ");
			params.addValue("num_civico", filtro.getNumCivico(), Types.VARCHAR);
		}

		if (!GenericUtil.isNullOrEmpty(filtro.getSezione())) {
			query.append("AND bo.sezione = :sezione ");
			params.addValue("sezione", filtro.getSezione(), Types.VARCHAR);
		}

		if (!GenericUtil.isNullOrEmpty(filtro.getFoglio())) {
			query.append("AND bo.foglio = :foglio ");
			params.addValue("foglio", filtro.getFoglio(), Types.VARCHAR);
		}

		if (!GenericUtil.isNullOrEmpty(filtro.getParticella())) {
			query.append("AND bo.particella = :particella ");
			params.addValue("particella", filtro.getParticella(), Types.VARCHAR);
		}

		if (!GenericUtil.isNullOrEmpty(filtro.getSubalterno())) {
			query.append("AND bo.subalterno = :subalterno ");
			params.addValue("subalterno", filtro.getSubalterno(), Types.VARCHAR);
		}

		if (!GenericUtil.isNullOrEmpty(filtro.getAnnoCostruzioneDal()) && !GenericUtil.isNullOrEmpty(filtro.getAnnoCostruzioneAl())) {
			query.append("AND bo.anno_costruzione BETWEEN :anno_costruzione_dal AND :anno_costruzione_al ");
			params.addValue("anno_costruzione_dal", filtro.getAnnoCostruzioneDal(), Types.VARCHAR);
			params.addValue("anno_costruzione_al", filtro.getAnnoCostruzioneAl(), Types.VARCHAR);
		}


		if (!GenericUtil.isNullOrEmpty(filtro.getAnnoRistrutDal()) && !GenericUtil.isNullOrEmpty(filtro.getAnnoRistrutAl())) {
			query.append("AND bo.anno_ult_rist BETWEEN :anno_ult_rist_dal AND :anno_ult_rist_al ");
			params.addValue("anno_ult_rist_dal", filtro.getAnnoRistrutDal(), Types.VARCHAR);
			params.addValue("anno_ult_rist_al", filtro.getAnnoRistrutAl(), Types.VARCHAR);
		}




		if (!GenericUtil.isNullOrEmpty(filtro.getInviatiDal()) && !GenericUtil.isNullOrEmpty(filtro.getInviatiAl())) {
			query.append("AND TRUNC(bo.dt_upload) BETWEEN TO_DATE(:dt_upload_dal,'DD/MM/YYYY') AND TO_DATE(:dt_upload_al,'DD/MM/YYYY') "); // --TRUNC(dt_upload) BETWEEN TO_DATE(':dataDal','DD/MM/YYYY') AND TO_DATE(':dataAl','DD/MM/YYYY') ");
			params.addValue("dt_upload_dal", filtro.getInviatiDal(), Types.VARCHAR);
			params.addValue("dt_upload_al", filtro.getInviatiAl(), Types.VARCHAR);
		}


		ArrayList<String > classiEnergSelez = filtro.getClassiEnergeticheSelez();
		
		if (classiEnergSelez != null && classiEnergSelez.size() > 0) 
		{
			query.append(completaWhereClasse(classiEnergSelez));
		}




		ArrayList<String > sigleDestUso = filtro.getDestinazioniUsoSelez();
		
		if (sigleDestUso != null && sigleDestUso.size() > 0) 
		{
			query.append(completaWhereSiglaDestUso(sigleDestUso));
		}

		if (!GenericUtil.isNullOrEmpty(filtro.getCodMotivoRilascio())) {
			query.append("AND bo.fk_motivo = :fk_motivo ");
			params.addValue("fk_motivo", filtro.getCodMotivoRilascio(), Types.VARCHAR);
		}

		
		if ( !GenericUtil.isNullOrEmpty(filtro.getStato()))
		{
			if (filtro.getStato() == Constants.INVIATO_ANNULLATO)
			{
				query.append(" AND bo.FK_STATO in ("+Constants.INVIATO+","+Constants.ANNULLATO+","+Constants.ANNULLATO_BO+") ");
			}
			else
			{
				query.append("AND bo.fk_stato = :fk_stato ");
				params.addValue("fk_stato", filtro.getStato(), Types.VARCHAR);
			}
		}

		/*
		if (filtro.getFlgStatoAnnullato()) {
			query.append("AND bo.fk_stato = :fk_stato ");
			params.addValue("fk_stato", Constants.ANNULLATO, Types.VARCHAR);
		}
		else
		{
			query.append("AND bo.fk_stato in ("+Constants.INVIATO+","+Constants.ANNULLATO+") ");
		}
		*/

		query.append("AND bo.id_certificatore >:parametro "); 
		params.addValue("parametro", parametro, Types.NUMERIC);						

		StringBuffer whereOr = new StringBuffer();

		//completaWhereSiglaDestUso(StringBuffer whereOr, String campo, UDTDateValid valoreDa, UDTDateValid valoreA)

		completaWhereValoriOrDaAFour(whereOr, "vol_lordo_riscaldato", filtro.getVDa(), filtro.getVA());
		completaWhereValoriOrDaAFour(whereOr, "su", filtro.getSuDa(), filtro.getSuA());
		completaWhereValoriOrDaAFour(whereOr, "v_su", filtro.getVsuDa(), filtro.getVsuA());
		completaWhereValoriOrDaAFour(whereOr, "fattore_forma", filtro.getFattoreFormaDa(), filtro.getFattoreFormaA());
		completaWhereValoriOrDaAFour(whereOr, "trasm_opache", filtro.getTrasmSupOpacheDa(), filtro.getTrasmSupOpacheA());
		completaWhereValoriOrDaAFour(whereOr, "trasm_trasp", filtro.getTrasmSupTraspDa(), filtro.getTrasmSupTraspA());
		completaWhereValoriOrDaAFive(whereOr, "rend_acs_etagacs", filtro.getRendMedioAcsDa(), filtro.getRendMedioAcsA());
		completaWhereValoriOrDaAFour(whereOr, "rend_imp_etag", filtro.getRendMedioImpTermicoDa(), filtro.getRendMedioImpTermicoA());
		completaWhereValoriOrDaAFour(whereOr, "dom_acs_qhw_su", filtro.getFabAcsSuDa(), filtro.getFabAcsSuA());
		completaWhereValoriOrDaAFour(whereOr, "ind_glob_eplordo", filtro.getIndiceEplDa(), filtro.getIndiceEplA());

		
		
		completaWhereValoriOrDaAFour(whereOr, "epgl_nren_globale", filtro.getEpglNrenGlobaleDa(), filtro.getEpglNrenGlobaleA());
		completaWhereValoriOrDaAFour(whereOr, "epgl_ren_globale", filtro.getEpglRenGlobaleDa(), filtro.getEpglRenGlobaleA());
		completaWhereValoriOrDaAFour(whereOr, "emissioni_co2", filtro.getEmissioniCo2Da(), filtro.getEmissioniCo2A());
		completaWhereValoriOrDaAFour(whereOr, "sup_raffrescata", filtro.getSupRaffrescataDa(), filtro.getSupRaffrescataA());
		completaWhereValoriOrDaAFour(whereOr, "sup_riscaldata", filtro.getSupRiscaldataDa(), filtro.getSupRiscaldataA());
		completaWhereValoriOrDaAFour(whereOr, "vol_lordo_raffrescato", filtro.getVolLordoRaffrescatoDa(), filtro.getVolLordoRaffrescatoA());
		completaWhereValoriOrDaAFour(whereOr, "vol_lordo_riscaldato", filtro.getVolLordoRiscaldatoDa(), filtro.getVolLordoRiscaldatoA());
		completaWhereValoriOrDaAFour(whereOr, "eph", filtro.getEphDa(), filtro.getEphA());
		completaWhereValoriOrDaAFour(whereOr, "asol_asup", filtro.getAsolAsupDa(), filtro.getAsolAsupA());
		completaWhereValoriOrDaAFour(whereOr, "yie", filtro.getYieDa(), filtro.getYieA());
		completaWhereValoriOrDaAFour(whereOr, "v_su_raff", filtro.getVSuRaffDa(), filtro.getVSuRaffA());
		completaWhereValoriOrDaAFour(whereOr, "v_su_risc", filtro.getVSuRiscDa(), filtro.getVSuRiscA());
		completaWhereValoriOrDaAFour(whereOr, "s_v_raff", filtro.getSVRaffDa(), filtro.getSVRaffA());
		completaWhereValoriOrDaAFour(whereOr, "s_v_risc", filtro.getSVRiscDa(), filtro.getSVRiscA());
		
		
		/*
		&& (GenericUtil.isNullOrEmpty(filtro
				.getFlgEdifE0()) || !filtro
				.getFlgEdifE0())
		 */

				
				
		
		if (whereOr.length() > 0)
		{
			whereOr.append(" ) ");
		}


		log.debug("STAMPO IL FILTRO: "+filtro);
		log.debug("Stampo filtro.getFlgEdifE0(): "+filtro.getFlgEdifE0());
		
		if (filtro.getFlgEdifE0() != null && filtro.getFlgEdifE0()) {
			if (whereOr.length() > 0)
			{
				whereOr.append(" OR ");
			}

			whereOr.append("bo.flg_edif_e0 = :flg_edif_e0 ");
			params.addValue("flg_edif_e0", Constants.FLG_S, Types.VARCHAR);
		}

		
		log.debug("Stampo filtro.getFlgFabbisognoSupIndice(): "+filtro.getFlgFabbisognoSupIndice());
		
		if (filtro.getFlgFabbisognoSupIndice() != null && filtro.getFlgFabbisognoSupIndice()) {
			if (whereOr.length() > 0)
			{
				whereOr.append(" OR ");
			}

			whereOr.append("bo.flg_fabb_max_indice = :flg_fabb_max_indice ");
			params.addValue("flg_fabb_max_indice", Constants.FLG_S, Types.VARCHAR);
		}

		if (filtro.getFlgFabbisognoAcsDiverso() != null && filtro.getFlgFabbisognoAcsDiverso()) {
			if (whereOr.length() > 0)
			{
				whereOr.append(" OR ");
			}

			whereOr.append("bo.flg_fabb_acs = :flg_fabb_acs ");
			params.addValue("flg_fabb_acs", Constants.FLG_S, Types.VARCHAR);
		}

		if (whereOr.length() > 0)
		{
			query.append("AND ( ");

			query.append(whereOr);

			query.append(" ) ");
		}

		return query;
	}
	
	private StringBuffer completaWhereClasse(ArrayList<String> classiEenergeticheSelez) 
	{
		StringBuffer whereClass = new StringBuffer();
		
		whereClass.append("AND bo.fk_classe in (");
		for (int i = 0; i < classiEenergeticheSelez.size(); i++) {
			
			if (i != 0)
			{
				whereClass.append(", ");
			}
			
			whereClass.append(classiEenergeticheSelez.get(i));
			
			//query.append("AND bo.fk_classe in (?, ?) ");
			//params.addValue("anno", filtro.get(), Types.VARCHAR);
		}
		whereClass.append(") ");
		
		return whereClass;
	}
	
	
	private StringBuffer completaWhereSiglaDestUso(ArrayList<String> sislaDestUsoSelez) 
	{
		StringBuffer whereClass = new StringBuffer();
		
		
		whereClass.append("AND (");
		for (int i = 0; i < sislaDestUsoSelez.size(); i++) {
			
			if (i != 0)
			{
				whereClass.append(" OR ");
			}
			
			whereClass.append("duso.sigla LIKE '");
			whereClass.append(sislaDestUsoSelez.get(i));
			whereClass.append("%' ");
			//query.append("AND bo.fk_classe in (?, ?) ");
			//params.addValue("anno", filtro.get(), Types.VARCHAR);
		}
		whereClass.append(") ");
		
		return whereClass;
	}
	
	
	private StringBuffer completaWhereValoriOrDaAFour(StringBuffer whereOr, String campo, UDTPositiveDoubleFour valoreDa, UDTPositiveDoubleFour valoreA) 
	{
		return completaWhereValoriOrDaA(whereOr, 
				campo, 
				valoreDa!=null?valoreDa.getValue():null, 
				valoreA!=null?valoreA.getValue():null);
	}

	private StringBuffer completaWhereValoriOrDaAFive(StringBuffer whereOr, String campo, UDTPositiveDoubleFive valoreDa, UDTPositiveDoubleFive valoreA) 
	{
		return completaWhereValoriOrDaA(whereOr, 
				campo, 
				valoreDa!=null?valoreDa.getValue():null, 
				valoreA!=null?valoreA.getValue():null);
	}

	private StringBuffer completaWhereValoriOrDaA(StringBuffer whereOr, String campo, Double valoreDa, Double valoreA) 
	{
		
		if (!GenericUtil.isNullOrEmpty(valoreDa) || !GenericUtil.isNullOrEmpty(valoreA))
		{
			
			if (whereOr.length() == 0)
			{
				whereOr.append(" ( ");
			}
			else
			{
				whereOr.append(" OR ");
			}

			
			if (!GenericUtil.isNullOrEmpty(valoreDa) && !GenericUtil.isNullOrEmpty(valoreA))
			{
				whereOr.append(" ( ");
				whereOr.append(campo);
				whereOr.append(" BETWEEN ");
				whereOr.append(valoreDa);
				whereOr.append(" AND ");
				whereOr.append(valoreA);
				whereOr.append(" ) ");
			}
			else if (!GenericUtil.isNullOrEmpty(valoreDa))
			{
				//bo.v_su >= ?
				whereOr.append(campo);
				whereOr.append(" >= ");
				whereOr.append(valoreDa);			}
			else if (!GenericUtil.isNullOrEmpty(valoreA))
			{
				//bo.vol_lordo_riscaldato <= ?
				whereOr.append(campo);
				whereOr.append(" <= ");
				whereOr.append(valoreA);
			}
		}
		
		
		
		return whereOr;
	}
	
		
	
	private StringBuffer getInizioQuery(Boolean isOld)
	{
		StringBuffer query = new StringBuffer();
		query.append("SELECT ");
		query.append("bo.anno, "); 
		query.append("bo.id_certificatore, "); 
		query.append("bo.progr_certificato, ");
		query.append("cert.num_certificatore, ");
		//query.append("bo.progr_certificato, ");
		
		query.append("cert.nome, ");
		query.append("cert.cognome, ");
		
		query.append("scert.descr desc_stato, ");
		query.append("bo.fk_stato id_stato, ");
		query.append("bo.dt_inizio, ");
		query.append("bo.dt_upload, ");
		query.append("bo.dt_scadenza, ");
		query.append("bo.desc_prov, ");
		query.append("bo.id_prov, ");
		query.append("bo.desc_comune, "); 
		query.append("bo.id_comune, "); 
		query.append("bo.desc_indirizzo, ");
		query.append("bo.num_civico, ");
		query.append("bo.sezione, ");
		query.append("bo.foglio, ");
		query.append("bo.particella, ");
		query.append("bo.subalterno, ");
		query.append("bo.gradi_giorno, ");
		query.append("bo.piano, ");
		query.append("bo.num_piani_complessivi, ");
		
		if (isOld != null)
		{
			query.append("duso.sigla sigla_dest_uso, ");
		}
		else
		{
			// In questo caso non mi interessa sapere se è nuovo o vecchio, ignoro la destinazione d'uso, quindi metto un dato fittizio
			query.append("'' sigla_dest_uso, ");
		}
		
		query.append("ed.descr desc_edificio, ");
		query.append("bo.desc_tipo_edificio, ");
		query.append("ce.descr desc_classe_energ, ");
		
		
		query.append("ce2.descr desc_classe_energ_192_05, ");
		
		query.append("bo.anno_costruzione, ");
		query.append("bo.anno_ult_rist, ");
		query.append("bo.vol_lordo_riscaldato, ");
		query.append("bo.sup_disperdente_tot, ");
		query.append("bo.su, ");
		query.append("bo.v_su, ");
		query.append("bo.fattore_forma, ");
		query.append("bo.trasm_opache, ");
		query.append("bo.trasm_trasp, ");
		
		query.append("ti.descr desc_tipo_impianto, ");
		query.append("dcomb.descr desc_comb_risc, ");
		query.append("dcomb2.descr desc_comb_acs, ");
		
		query.append("bo.dom_risc_qh, ");

		
		query.append("bo.dom_risc_qhto, ");
		query.append("bo.ind_risc_epito, ");
		
		
		query.append("bo.ind_risc_epi, ");
		query.append("bo.fabb_acs, ");
		
		query.append("bo.valore_prest_pdc, ");
		query.append("bo.rend_acs_etagacs, ");
		query.append("bo.dom_acs_qhw, ");
		query.append("bo.en_acs_rinno, ");
		query.append("bo.rend_imp_etag, ");
		query.append("bo.dom_acs_qhw_su, ");
		query.append("bo.ind_glob_eplordo, ");
		
		query.append("bo.ind_glob_eplordo_to, ");
		
		query.append("bo.dom_acs_qhwto, ");
		query.append("mr.descr desc_motivo, ");
		query.append("bo.metodologia_calcolo, ");
		query.append("bo.sw_utilizzato, ");
		

		query.append("bo.prestazione_ene, ");
		query.append("bo.num_appartamenti, ");
		query.append("bo.ui_servite, ");
		query.append("bo.pot_riscaldamento, ");
		
		query.append("ceff.descr desc_classe_eff, ");
		
		
		query.append("bo.gen_anno_risc, ");
		query.append("bo.flg_cont_rip, ");
		query.append("bo.rend_gener, ");
		query.append("bo.rend_regol, ");
		query.append("bo.rend_emiss, ");
		query.append("bo.rend_distrib, ");

		
		query.append("bo.flg_old, ");
		query.append("bo.flg_edif_e0, ");
		query.append("bo.epgl_nren_globale, ");
		query.append("bo.epgl_ren_globale, ");
		query.append("bo.emissioni_co2, ");
		query.append("bo.sup_raffrescata, ");
		query.append("bo.sup_riscaldata, ");
		query.append("bo.vol_lordo_raffrescato, ");
		query.append("bo.vol_lordo_riscaldato, ");
		query.append("bo.eph, ");
		query.append("bo.asol_asup, ");
		query.append("bo.yie, ");
		query.append("bo.v_su_raff, ");
		query.append("bo.v_su_risc, ");
		query.append("bo.s_v_raff, ");
		query.append("bo.s_v_risc ");
		
		
		getQueryFromWhere(query, isOld);
		
		return query;
	}

	private StringBuffer getQueryFromWhere(StringBuffer query, Boolean isOld)
	{

		query.append("FROM SICEE_T_EXPORT_BO bo, ");
		query.append("SICEE_T_CERTIFICATORE cert, ");
		query.append("SICEE_D_STATO_CERT scert, ");
		
		if (isOld != null)
		{
			if (isOld)
			{
				query.append("SICEE_D_DEST_USO duso, ");
			}
			else
			{
				query.append("SICEE_D_DEST_USO_2015 duso, ");
			}
		}
		
		query.append("SICEE_D_CARATT_EDIFICIO ed, ");
		query.append("SICEE_D_CLASSE_ENERGETICA ce, ");
		query.append("SICEE_D_CLASSE_ENERGETICA ce2, ");
		query.append("SICEE_D_CLASSE_EFFICIENZA ceff, ");
		
		query.append("SICEE_D_TIPO_IMPIANTO ti, ");
		query.append("SICEE_D_COMBUSTIBILE dcomb, ");
		query.append("SICEE_D_COMBUSTIBILE dcomb2, ");
		query.append("SICEE_D_MOTIVO_RILASCIO mr ");
		query.append("WHERE ");
		query.append("bo.id_certificatore = cert.id_certificatore ");
		query.append("AND bo.fk_stato = scert.id_stato ");

		if (isOld != null)
		{
			if (isOld)
			{
				query.append("AND bo.fk_dest_uso = duso.id_dest_uso (+) ");
			}
			else
			{
				query.append("AND bo.fk_dest_uso = duso.id_dest_uso_2015 (+) ");
			}
		}
		
		query.append("AND bo.fk_caratt_edificio = ed.id_caratt_edificio (+) ");

		query.append("AND bo.fk_tipo_impianto = ti.id_tipo_impianto (+) ");
		query.append("AND bo.fk_combustibile_risc = dcomb.id_combustibile (+) ");
		query.append("AND bo.fk_combustibile_acs = dcomb2.id_combustibile (+) ");

		query.append("AND bo.fk_classe_eff_risc = ceff.id_classe_eff (+) ");

		query.append("AND bo.fk_classe = ce.id_classe (+) ");
		query.append("AND bo.fk_classe_192_05 = ce2.id_classe (+) ");
		query.append("AND bo.fk_motivo = mr.id_motivo (+) ");
		
		if (isOld != null)
		{
			if (isOld)
			{
				query.append("AND bo.flg_old = '"+Constants.FLG_S + "' ");
			}
			else
			{
				query.append("AND bo.flg_old = '"+Constants.FLG_N + "' ");
			}
		}
		
		return query;
	}

	private String likeString(String str) {
		return new String("%"+str+"%");
	}
	
	
	/** 
	 * Returns all rows from the SICEE_T_EXPORT_BO table that match the criteria ''.
	 */
	/*
	public List<SiceeTExportBo> findAll() throws SiceeTExportBoDaoException
	{
		try {
			return jdbcTemplate.query("SELECT ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO, DT_INIZIO, DT_UPLOAD, DESC_PROV, DESC_COMUNE, GRADI_GIORNO, PIANO, NUM_PIANI_COMPLESSIVI, FK_STATO, FK_DEST_USO, DESC_TIPO_EDIFICIO, FK_CARATT_EDIFICIO, FK_CLASSE, ANNO_COSTRUZIONE, ANNO_ULT_RIST, VOL_LORDO_RISCALDATO, SUP_DISPERDENTE_TOT, SU, TRASM_OPACHE, TRASM_TRASP, FATTORE_FORMA, V_SU, DOM_RISC_QHTO, IND_RISC_EPITO, FLG_FABB_MAX_INDICE, VALORE_PREST_PDC, REND_ACS_ETAGACS, DOM_ACS_QHW, EN_ACS_RINNO, REND_IMP_ETAG, DOM_ACS_QHW_SU, IND_GLOB_EPLORDO, DOM_ACS_QHWTO, FLG_FABB_ACS, FK_MOTIVO, METODOLOGIA_CALCOLO, SW_UTILIZZATO, DESC_INDIRIZZO, NUM_CIVICO, SEZIONE, FOGLIO, PARTICELLA, SUBALTERNO FROM " + getTableName() + " ORDER BY ID_CERTIFICATORE, PROGR_CERTIFICATO, ANNO", this);
		}
		catch (Exception e) {
			throw new SiceeTExportBoDaoException("Query failed", e);
		}
		
	}
	*/

}
