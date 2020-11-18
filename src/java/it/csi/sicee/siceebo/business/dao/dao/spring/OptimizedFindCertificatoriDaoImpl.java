/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao.spring;

import it.csi.sicee.siceebo.business.dao.dao.OptimizedFindCertificatoriDao;
import it.csi.sicee.siceebo.business.dao.dto.OptimizedFindCertificatori;
import it.csi.sicee.siceebo.business.dao.dto.OptimizedFindCertificatoriExport;
import it.csi.sicee.siceebo.business.dao.exceptions.OptimizedFindCertificatoriDaoException;
import it.csi.sicee.siceebo.business.facade.BaseMgr;
import it.csi.sicee.siceebo.dto.certificatori.FiltroRicercaCertificatori;
import it.csi.sicee.siceebo.dto.type.UDTDateValid;
import it.csi.sicee.siceebo.util.Constants;
import it.csi.sicee.siceebo.util.GenericUtil;

import org.apache.log4j.Logger;

import java.util.List;

import javax.sql.DataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

public class OptimizedFindCertificatoriDaoImpl implements OptimizedFindCertificatoriDao
{
	
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".dao");

	protected NamedParameterJdbcTemplate jdbcTemplate;

	protected DataSource dataSource;

	/**
	 * Method 'setDataSource'
	 * 
	 * @param dataSource
	 */
	public void setDataSource(DataSource dataSource)
	{
		this.dataSource = dataSource;
		jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	private static class OptimizedFindCertificatoriRowMapper implements ParameterizedRowMapper<OptimizedFindCertificatori>
	{

		public OptimizedFindCertificatori mapRow(ResultSet rs, int row) throws SQLException
		{


			OptimizedFindCertificatori dto = new OptimizedFindCertificatori();

			//GenericUtil.stampa(rs, false, 4);

			dto.setIdCertificatore( rs.getString( "id_certificatore" ) );
			dto.setMatricola( rs.getString( "num_certificatore" ) );
			dto.setNome( rs.getString( "nome" ) );
			dto.setCognome( rs.getString( "cognome" ) );
			dto.setEmail( rs.getString( "email" ) );
			dto.setTitolo( rs.getString( "descr" ) );
			dto.setRagioneSociale( rs.getString( "denominazione" ) );
			dto.setIndirizzo( rs.getString( "desc_indirizzo" ) );
			dto.setNumCivico( rs.getString( "num_civico" ) );
			dto.setDescComune( rs.getString( "desc_comune" ) );
			dto.setDescProv( rs.getString( "desc_prov" ) );
			dto.setBloccoCert( rs.getString( "fk_blocco_certificatore" ) );
			if (BaseMgr.isNullOrEmpty(dto.getBloccoCert())) {
				dto.setStatoBloccoCert(Constants.LABEL_NON_BLOCCATO);
			} else {
				dto.setStatoBloccoCert(rs.getString( "stato_descr" ));
			}
			//GenericUtil.stampa(dto, false, 4);

			return dto;
		}
	}
	
	private static class OptimizedExportCertificatoriRowMapper implements ParameterizedRowMapper<OptimizedFindCertificatoriExport>
	{

		public OptimizedFindCertificatoriExport mapRow(ResultSet rs, int row) throws SQLException
		{


			
			//GenericUtil.stampa(rs, false, 4);
			
			
			OptimizedFindCertificatoriExport dto = new OptimizedFindCertificatoriExport();

			dto.setIdCert( rs.getString( "id_cert" ) );

			dto.setMatricola( rs.getString( "num_cert" ) );
			dto.setNome( rs.getString( "nome_cert" ) );
			
			dto.setCognome( rs.getString( "cognome_cert" ) );
			dto.setTitolo( rs.getString( "descr_tit" ) );
			
			dto.setDescProvOrdine( rs.getString( "desc_prov_ordine" ) );
			dto.setNumIscrAlbo( rs.getString( "num_iscr_albo" ) );
			dto.setDataIscrAlbo( rs.getTimestamp( "data_iscr_albo" ) );
			
			dto.setCorsoFrequentato( rs.getString( "corso_frequentato" ) );
			dto.setDataModulo1Da( rs.getTimestamp( "dt_modulo1_da" ) );
			dto.setDataModulo1A( rs.getTimestamp( "dt_modulo1_a" ) );
			
			dto.setDataModulo2Da( rs.getTimestamp( "dt_modulo2_da" ) );
			dto.setDataModulo2A( rs.getTimestamp( "dt_modulo2_a" ) );
			dto.setAttPartecipEmesso( rs.getString( "att_partecip_emesso" ) );
			
			dto.setDataAttPartecip( rs.getTimestamp( "dt_att_partecip" ) );
			dto.setAttEsamePresso( rs.getString( "att_esame_presso" ) );
			
			dto.setDataAttEsame( rs.getTimestamp( "dt_att_esame" ) );
			dto.setCodiceFiscaleCert( rs.getString( "codice_fiscale_cert" ) );
			
			dto.setDataNascitaCert( rs.getTimestamp( "dt_nascita_cert" ) );
			dto.setDescRegioneNascitaCert( rs.getString( "desc_regione_nascita_cert" ) );
			dto.setDescProvNascitaCert( rs.getString( "desc_prov_nascita_cert" ) );
			dto.setDescComuneNascitaCert( rs.getString( "desc_comune_nascita_cert" ) );
			
			dto.setDescRegioneResidenzaCert( rs.getString( "desc_regione_residenza_cert" ) );
			
			dto.setDescProvResidenzaCert( rs.getString( "desc_prov_residenza_cert" ) );
			dto.setDescComuneResidenzaCert( rs.getString( "desc_comune_residenza_cert" ) );
			dto.setDescIndirizzoCert( rs.getString( "desc_indirizzo_cert" ) );
			
			dto.setNumCivicoResidenzaCert( rs.getString( "num_civico_residenza_cert" ) );
			dto.setCapCert( rs.getString( "cap_cert" ) );
			dto.setTelefonoCert( rs.getString( "telefono_cert" ) );
			
			dto.setCellCert( rs.getString( "cell_cert" ) );
			dto.setEmailCert( rs.getString( "email_cert" ) );
			dto.setEmailPecCert( rs.getString( "email_pec_cert" ) );
			
			dto.setFaxCert( rs.getString( "fax_cert" ) );
			dto.setSitoWebCert( rs.getString( "sito_web_cert" ) );

			dto.setDenominazioneAzienda( rs.getString( "denominazione_azienda" ) );
			dto.setpIvaAzienda( rs.getString( "p_iva_azienda" ) );
			dto.setDescRegioneAzienda( rs.getString( "desc_regione_azienda" ) );
			
			dto.setDescProvAzienda( rs.getString( "desc_prov_azienda" ) );
			dto.setDescComuneAzienda( rs.getString( "desc_comune_azienda" ) );
			dto.setDescIndirizzoAzienda( rs.getString( "desc_indirizzo_azienda" ) );
			
			dto.setNumCivicoAzienda( rs.getString( "num_civico_azienda" ) );
			dto.setCapAzienda( rs.getString( "cap_azienda" ) );
			dto.setNumAceTot( new Integer(rs.getInt( "num_ace" )) );
			
			dto.setNumAceClasseApiu( new Integer(rs.getInt( "num_ace_classe1" )) );
			dto.setNumAceClasseA( new Integer(rs.getInt( "num_ace_classe2" )) );
			
			dto.setNumAceClasseB( new Integer(rs.getInt( "num_ace_classe3" )) );
			dto.setNumAceClasseC( new Integer(rs.getInt( "num_ace_classe4" )) );
			dto.setNumAceClasseD( new Integer(rs.getInt( "num_ace_classe5" )) );
			
			dto.setNumAceClasseE( new Integer(rs.getInt( "num_ace_classe6" )) );
			dto.setNumAceClasseF( new Integer(rs.getInt( "num_ace_classe7" )) );
			dto.setNumAceClasseG( new Integer(rs.getInt( "num_ace_classe8" )) );
			
			dto.setNumAceClasseNC( new Integer(rs.getInt( "num_ace_classe9" )) );

			//GenericUtil.stampa(dto, false, 4);
			
			return dto;
		}
	}

	public Integer findElencoCertificatoriCount(
			FiltroRicercaCertificatori filtro, boolean soloOperativi, Long parametro)
			throws OptimizedFindCertificatoriDaoException {
		try {
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			

			StringBuffer query = new StringBuffer("SELECT count(*) FROM ( ");
			
			componiQuery(query, filtro, soloOperativi, parametro, params);
			
			query.append(" ) "); 
			
			GenericUtil.stampa(filtro, true, 4);
			
			log.debug(query);
					
			Integer count = jdbcTemplate.queryForInt(query.toString(), params);
			
			return count;
		}
		catch (Exception e) {
			throw new OptimizedFindCertificatoriDaoException("Query failed", e);
		}
	}
	
	public List<OptimizedFindCertificatori> findElencoCertificatori(
			FiltroRicercaCertificatori filtro, boolean soloOperativi, Long parametro)
			throws OptimizedFindCertificatoriDaoException {
		try {
			

			
			MapSqlParameterSource params = new MapSqlParameterSource();
			
			StringBuffer query = new StringBuffer();
			
			componiQuery(query, filtro, soloOperativi, parametro, params);
			
			
			query.append(" ORDER BY num_certificatore asc" );
					
			
			GenericUtil.stampa(filtro, true, 4);
			
			log.debug(query);
					
			return jdbcTemplate.query(query.toString(), params, new OptimizedFindCertificatoriRowMapper());
		}
		catch (Exception e) {
			throw new OptimizedFindCertificatoriDaoException("Query failed", e);
		}
	}

	private StringBuffer componiQuery(StringBuffer strQuery, FiltroRicercaCertificatori filtro, boolean soloOperativi, Long parametro, MapSqlParameterSource params) 
	{
	
		boolean verCertificato = soloOperativi || !GenericUtil.isNullOrEmpty(filtro.getDataACEdal()) || !GenericUtil.isNullOrEmpty(filtro.getDataACEal());
		strQuery.append("SELECT ");
		strQuery.append("cre.id_certificatore, ");
		strQuery.append("cre.num_certificatore, ");
		strQuery.append("cre.nome, ");
		strQuery.append("cre.cognome, ");
		strQuery.append("cre.email, ");
		strQuery.append("t.denominazione descr, ");
		strQuery.append("a.denominazione, ");
		strQuery.append("a.desc_indirizzo, ");
		strQuery.append("a.num_civico, ");
		strQuery.append("a.desc_comune, ");
		strQuery.append("a.desc_prov, ");
		strQuery.append("cre.fk_blocco_certificatore, ");
		strQuery.append("sc.descr as stato_descr ");

		strQuery.append("FROM "); 
		
		strQuery.append("SICEE_D_ISTRUZIONE t, ");
		strQuery.append("SICEE_T_CERTIFICATORE cre, ");
		strQuery.append("SICEE_T_AZIENDA a, ");
		strQuery.append("SICEE_D_BLOCCO_CERTIFICATORE sc ");
//		if (filtro.getFlgEsameSosten())
//		{
//			query.append("SICEE_T_DATI_ESAMI de, ");
//		}
				
		if (verCertificato)
		{
			strQuery.append(", SICEE_T_CERTIFICATO cto ");
		}
		
		strQuery.append("WHERE ");
		
		strQuery.append("cre.fk_istruzione = t.id_istruzione (+) "); // Titolo
		strQuery.append(" AND cre.fk_blocco_certificatore = sc.id_blocco_certificatore (+) "); // blocco certificatore

		if ( !GenericUtil.isNullOrEmpty(filtro.getNumMatricola())) {
			strQuery.append(" AND cre.num_certificatore=:numMatricola ");
			params.addValue("numMatricola", filtro.getNumMatricola(), Types.VARCHAR);
			
			//query.append(" AND t.id_titolo="+filtro.getCodTitolo()+" ");
			
		}


		if ( !GenericUtil.isNullOrEmpty(filtro.getCodTitolo())) {
			strQuery.append(" AND t.id_istruzione=:sigla ");
			params.addValue("sigla", filtro.getCodTitolo(), Types.VARCHAR);
			
			//query.append(" AND t.id_titolo="+filtro.getCodTitolo()+" ");
			
		}

		if ( !GenericUtil.isNullOrEmpty(filtro.getNome())) {
			strQuery.append(" AND UPPER(cre.nome) like UPPER(:nome) "); // Nome
			params.addValue("nome", likeString(filtro.getNome()), Types.VARCHAR);
		}
		if ( !GenericUtil.isNullOrEmpty(filtro.getCognome())) {
			strQuery.append(" AND UPPER(cre.cognome) like UPPER(:cognome) "); // Cognome
			params.addValue("cognome",likeString(filtro.getCognome()), Types.VARCHAR);						
		}

		if ( !GenericUtil.isNullOrEmpty(filtro.getDataNascitadal()) && !GenericUtil.isNullOrEmpty(filtro.getDataNascitaal())) {
			strQuery.append("AND TRUNC(cre.dt_nascita) BETWEEN TO_DATE(:dataNascitaDal,'DD/MM/YYYY') AND TO_DATE(:dataNascitaAl,'DD/MM/YYYY') "); // data nascita dal …… al ……
			
			params.addValue("dataNascitaDal", filtro.getDataNascitadal(), Types.VARCHAR);
			params.addValue("dataNascitaAl", filtro.getDataNascitaal(), Types.VARCHAR);
		}
		
		strQuery.append("AND cre.fk_azienda = a.id_azienda "); // Ragione sociale

		if ( !GenericUtil.isNullOrEmpty(filtro.getRagSociale())) {
			strQuery.append(" and UPPER(a.denominazione) like UPPER(:ragioneSociale) ");
			params.addValue("ragioneSociale",likeString(filtro.getRagSociale()), Types.VARCHAR);						
		}

		
		if ( !GenericUtil.isNullOrEmpty(filtro.getCodRegione())) {
			strQuery.append(" AND a.id_regione=:idRegione ");
			params.addValue("idRegione", filtro.getCodRegione(), Types.VARCHAR);
		}
		if ( !GenericUtil.isNullOrEmpty(filtro.getCodComune())) {
			strQuery.append(" AND a.id_comune=:idComune ");
			params.addValue("idComune", filtro.getCodComune(), Types.VARCHAR);
		}
		if ( !GenericUtil.isNullOrEmpty(filtro.getDescComune())) {
			strQuery.append(" AND a.desc_comune=:descComune ");
			params.addValue("descComune", GenericUtil.raddoppiaApici(filtro.getDescComune()).toUpperCase(), Types.VARCHAR);
		}
		if ( !GenericUtil.isNullOrEmpty(filtro.getCodProvincia())) {
			strQuery.append(" AND a.id_prov=:idProvincia ");
			params.addValue("idProvincia", filtro.getCodProvincia(), Types.VARCHAR);
		}
/*		
		if (filtro.getFlgEsameSosten())
		{
			strQuery.append("AND cre.flg_esame_sostenuto = 'S' "); // Esame sostenuto
		}
*/		
		strQuery.append("AND to_number(cre.id_certificatore) >:parametro ");
		params.addValue("parametro", parametro, Types.NUMERIC);						
		
		
		if (verCertificato)
		{
			strQuery.append("AND cre.id_certificatore = cto.id_certificatore "); // N° ace inviati dal …… al ……
		
			strQuery.append("AND cto.fk_stato = "+Constants.ID_STATO_CERTIFICATO_3+" "); // N° ace inviati dal …… al ……
			
			if ( !GenericUtil.isNullOrEmpty(filtro.getDataACEdal()) && !GenericUtil.isNullOrEmpty(filtro.getDataACEal())) {
				strQuery.append("AND TRUNC(dt_upload) BETWEEN TO_DATE(:dataDal,'DD/MM/YYYY') AND TO_DATE(:dataAl,'DD/MM/YYYY') "); // N° ace inviati dal …… al ……
				
				params.addValue("dataDal", filtro.getDataACEdal(), Types.VARCHAR);
				params.addValue("dataAl", filtro.getDataACEal(), Types.VARCHAR);
			}
		}
		
		// controllo il titolo di studio se e solo se viene richiesto nei criteri di ricerca
		if ( !GenericUtil.isNullOrEmpty(filtro.getTitoloStudioAllegato())) {
			if (filtro.getTitoloStudioAllegato().equalsIgnoreCase("S")) {
				strQuery.append(" AND (select count(*) FROM SICEE_T_DOCUMENTO WHERE ID_CERTIFICATORE = cre.id_certificatore AND ID_TIPO_DOC = "+Constants.ID_TIPO_DOC_TITOLO_DI_STUDIO+") > 0 ");
			} else if (filtro.getTitoloStudioAllegato().equalsIgnoreCase("N")) {
				strQuery.append(" AND (select count(*) FROM SICEE_T_DOCUMENTO WHERE ID_CERTIFICATORE = cre.id_certificatore AND ID_TIPO_DOC = "+Constants.ID_TIPO_DOC_TITOLO_DI_STUDIO+") = 0 ");
			}
		}
		
		// controllo il tipo corso se e solo se viene richiesto nei criteri di ricerca
		if ( !GenericUtil.isNullOrEmpty(filtro.getTipoCorso())) {
			strQuery.append(" AND (select count(*) FROM SICEE_T_CORSO_2015, SICEE_T_PARTECIPANTE_2015");
			strQuery.append(" WHERE SICEE_T_CORSO_2015.ID_CORSO = SICEE_T_PARTECIPANTE_2015.FK_CORSO");
			strQuery.append(" AND SICEE_T_CORSO_2015.FK_TIPO_CORSO = :tipoCorso");
			strQuery.append(" AND SICEE_T_PARTECIPANTE_2015.CODICE_FISCALE = cre.CODICE_FISCALE) > 0");
			params.addValue("tipoCorso", filtro.getTipoCorso(), Types.VARCHAR);
		}
		
		// controllo l'iscrizione all'ordine professionale se e solo se viene richiesto nei criteri di ricerca
		if ( !GenericUtil.isNullOrEmpty(filtro.getIscrOrdProf())) {
			if (filtro.getIscrOrdProf().equalsIgnoreCase("S")) {
				strQuery.append(" AND cre.iscritto_ordine = 'S' ");
			} else if (filtro.getIscrOrdProf().equalsIgnoreCase("N")) {
				strQuery.append(" AND (cre.iscritto_ordine = 'N' OR cre.iscritto_ordine is null)");
			}
		}

		// controllo gli eventuali blocchi del certificatore se e solo se viene richiesto nei criteri di ricerca
		if ( !GenericUtil.isNullOrEmpty(filtro.getBloccato())) {
			if (filtro.getBloccato().equalsIgnoreCase("S")) {
				if (!GenericUtil.isNullOrEmpty(filtro.getMotivazioneBlocco())) {
					strQuery.append(" AND cre.fk_blocco_certificatore = :motivazioneBlocco");
					params.addValue("motivazioneBlocco", filtro.getMotivazioneBlocco(), Types.VARCHAR);
				} else {
					strQuery.append(" AND cre.fk_blocco_certificatore is not null");
				}
			} else if (filtro.getBloccato().equalsIgnoreCase("N")) {
				strQuery.append(" AND cre.fk_blocco_certificatore is null");
			}
		}
		
		strQuery.append(" GROUP BY cre.id_certificatore, cre.num_certificatore, cre.nome, cre.cognome, cre.email, t.denominazione, ");
		strQuery.append(" a.denominazione, a.desc_indirizzo, a.num_civico, a.desc_comune, a.desc_prov, cre.fk_blocco_certificatore, sc.descr");

		return strQuery;
	}

	//private static StringBuffer strSelect;
	//private static StringBuffer strFrom;
	//private static StringBuffer strWhere;
	
	public List<OptimizedFindCertificatoriExport> findElencoCertificatoriForExport(
			List<String> idCertificatori, UDTDateValid dataACEdal, UDTDateValid dataACEal, Long parametro)
			throws OptimizedFindCertificatoriDaoException {
		try {
			
			MapSqlParameterSource params = new MapSqlParameterSource();
			
			StringBuffer strSelect = new StringBuffer("SELECT gen.* ");
			
			StringBuffer strFrom = new StringBuffer("");

			StringBuffer strWhere = new StringBuffer("");
			
			strFrom.append(" FROM (SELECT count(*) num_ace, ");
			strFrom.append("cre.id_certificatore id_cert, ");
			strFrom.append("cre.num_certificatore num_cert, ");
			strFrom.append("cre.nome nome_cert, ");
			strFrom.append("cre.cognome cognome_cert, ");
			strFrom.append("t.denominazione descr_tit, ");
			strFrom.append("cre.desc_prov_ordine desc_prov_ordine, ");
			strFrom.append("cre.num_iscr_albo num_iscr_albo, ");
			strFrom.append("cre.data_iscr_albo data_iscr_albo, ");
			strFrom.append("de.corso_frequentato corso_frequentato, ");
			strFrom.append("de.dt_modulo1_da dt_modulo1_da, ");
			strFrom.append("de.dt_modulo1_a dt_modulo1_a, ");
			strFrom.append("de.dt_modulo2_da dt_modulo2_da, ");
			strFrom.append("de.dt_modulo2_a dt_modulo2_a, ");
			strFrom.append("de.att_partecip_emesso att_partecip_emesso, ");
			strFrom.append("de.dt_att_partecip dt_att_partecip, ");
			strFrom.append("de.att_esame_presso att_esame_presso, ");
			strFrom.append("de.dt_att_esame dt_att_esame, ");
			//queryFrom.append("cto.dt_upload dt_upload, ");
			strFrom.append("cre.codice_fiscale codice_fiscale_cert, ");
			
			strFrom.append("cre.dt_nascita dt_nascita_cert, ");
			strFrom.append("cre.desc_regione_nascita desc_regione_nascita_cert, ");
			strFrom.append("cre.desc_prov_nascita desc_prov_nascita_cert, ");
			strFrom.append("cre.desc_comune_nascita desc_comune_nascita_cert, ");
			
			
			strFrom.append("cre.desc_regione_residenza desc_regione_residenza_cert, ");
			strFrom.append("cre.desc_prov_residenza desc_prov_residenza_cert, ");
			strFrom.append("cre.desc_comune_residenza desc_comune_residenza_cert, ");
			strFrom.append("cre.desc_indirizzo desc_indirizzo_cert, ");
			strFrom.append("cre.num_civico_residenza num_civico_residenza_cert, ");
			strFrom.append("cre.cap cap_cert, ");
			strFrom.append("cre.telefono telefono_cert, ");
			strFrom.append("cre.cell cell_cert, ");
			strFrom.append("cre.email email_cert, ");
			strFrom.append("cre.email_pec email_pec_cert, ");
			strFrom.append("cre.fax fax_cert, ");
			strFrom.append("cre.sito_web sito_web_cert, ");
			strFrom.append("a.denominazione denominazione_azienda, ");
			strFrom.append("a.p_iva p_iva_azienda, ");
			strFrom.append("a.desc_regione desc_regione_azienda, ");
			strFrom.append("a.desc_prov desc_prov_azienda, ");
			strFrom.append("a.desc_comune desc_comune_azienda, ");
			strFrom.append("a.desc_indirizzo desc_indirizzo_azienda, ");
			strFrom.append("a.num_civico num_civico_azienda, ");
			strFrom.append("a.cap cap_azienda ");
			strFrom.append("FROM ");
			strFrom.append("SICEE_D_ISTRUZIONE t, ");
			strFrom.append("SICEE_T_CERTIFICATORE cre, ");
			strFrom.append("SICEE_T_AZIENDA a, ");
			strFrom.append("SICEE_T_DATI_ESAMI de, ");
			strFrom.append("SICEE_T_CERTIFICATO cto ");
			strFrom.append("WHERE ");
			strFrom.append("cre.fk_istruzione = t.id_istruzione (+) "); // Titolo
			strFrom.append("AND cre.fk_azienda = a.id_azienda "); // Ragione sociale
			strFrom.append("AND cre.id_certificatore = de.fk_certificatore (+) "); // Esame sostenuto
			strFrom.append("AND cre.id_certificatore = cto.id_certificatore "); // N° ace inviati dal …… al ……
			strFrom.append("AND to_number(cto.id_certificatore) >:parametro "); // N° ace inviati dal …… al ……
			params.addValue("parametro", parametro, Types.NUMERIC);						

			strFrom.append("AND cto.fk_stato = "+Constants.ID_STATO_CERTIFICATO_3+" "); // N° ace inviati dal …… al ……
			
			boolean isDataACEpresente = false;
			
			if ( !GenericUtil.isNullOrEmpty(dataACEdal) && !GenericUtil.isNullOrEmpty(dataACEal)) {
				strFrom.append("AND TRUNC(dt_upload) BETWEEN TO_DATE(:dataDal,'DD/MM/YYYY') AND TO_DATE(:dataAl,'DD/MM/YYYY') "); // N° ace inviati dal …… al ……
				
				params.addValue("dataDal", dataACEdal, Types.VARCHAR);
				params.addValue("dataAl", dataACEal, Types.VARCHAR);
				
				isDataACEpresente = true;
			}

			strFrom.append("GROUP BY cre.id_certificatore, ");
			strFrom.append("cre.num_certificatore, ");
			strFrom.append("cre.nome, ");
			strFrom.append("cre.cognome, ");
			strFrom.append("t.denominazione, ");
			strFrom.append("cre.desc_prov_ordine, ");
			strFrom.append("cre.num_iscr_albo, ");
			strFrom.append("cre.data_iscr_albo, ");
			strFrom.append("de.corso_frequentato, ");
			strFrom.append("de.dt_modulo1_da, ");
			strFrom.append("de.dt_modulo1_a, ");
			strFrom.append("de.dt_modulo2_da, ");
			strFrom.append("de.dt_modulo2_a, ");
			strFrom.append("de.att_partecip_emesso, ");
			strFrom.append("de.dt_att_partecip, ");
			strFrom.append("de.att_esame_presso, ");
			strFrom.append("de.dt_att_esame, ");
			//queryFrom.append("cto.dt_upload, ");
			strFrom.append("cre.codice_fiscale, ");
			
			strFrom.append("cre.dt_nascita, ");
			strFrom.append("cre.desc_regione_nascita, ");
			strFrom.append("cre.desc_prov_nascita, ");
			strFrom.append("cre.desc_comune_nascita, ");
			
			strFrom.append("cre.desc_regione_residenza, ");
			strFrom.append("cre.desc_prov_residenza, ");
			strFrom.append("cre.desc_comune_residenza, ");
			strFrom.append("cre.desc_indirizzo, ");
			strFrom.append("cre.num_civico_residenza, ");
			strFrom.append("cre.cap, ");
			strFrom.append("cre.telefono, ");
			strFrom.append("cre.cell, ");
			strFrom.append("cre.email, ");
			strFrom.append("cre.email_pec, ");
			strFrom.append("cre.fax, ");
			strFrom.append("cre.sito_web, ");
			strFrom.append("a.denominazione, ");
			strFrom.append("a.p_iva, ");
			strFrom.append("a.desc_regione, ");
			strFrom.append("a.desc_prov, ");
			strFrom.append("a.desc_comune, ");
			strFrom.append("a.desc_indirizzo, ");
			strFrom.append("a.num_civico, ");
			strFrom.append("a.cap ");
			strFrom.append(") gen ");

			
			for (int i = 1; i < 10; i++) {
				completaQueryClass(strSelect, strFrom, strWhere, i, isDataACEpresente);
			}
			
			
			
			strWhere.append(" AND (to_number(gen.id_cert) IN ( ");
			
			boolean isFirst = true;
			
			for (int i = 0; i < idCertificatori.size(); i++) {
				
				//if (i == 998)
				if (i != 0 && ((i % 999) == 0))
				{
					isFirst = true;
					strWhere.append(") OR gen.id_cert IN ( ");
				}
				
				strWhere.append(!isFirst?", ":"");
				strWhere.append(idCertificatori.get(i));
				isFirst = false;
			}
			
			strWhere.append(")) ");
					
			
			strWhere.append(" ORDER BY num_cert asc ");
					
			strSelect.append(strFrom).append(strWhere);

			log.debug(strSelect);
			
			return jdbcTemplate.query(strSelect.toString(), params, new OptimizedExportCertificatoriRowMapper());

		}
		catch (Exception e) {
			throw new OptimizedFindCertificatoriDaoException("Query failed", e);
		}
	}


	private StringBuffer completaQueryIn(StringBuffer strWhere, List<String> idCertificatori) 
	{
		
		strWhere.append(" AND to_number(gen.id_cert) IN ( ");
		
		for (int i = 0; i < idCertificatori.size(); i++) {
			
			strWhere.append(i!=0?", ":"");
			strWhere.append(idCertificatori.get(i));
		}
		strWhere.append(") ");
		
		return strWhere;
	}
	
	
	
	private StringBuffer completaQueryClass(StringBuffer strSelect, StringBuffer strFrom, StringBuffer strWhere, int iClass, boolean isDataACEpresente) 
	{
		
		strSelect.append(", classe"+iClass+".num_ace_classe"+iClass+"");
		
		strFrom.append(", (SELECT COUNT(*) num_ace_classe"+iClass+" ");
		strFrom.append(", cre.id_certificatore id_certificatore ");
		strFrom.append("FROM ");
		strFrom.append("SICEE_D_ISTRUZIONE t, ");
		strFrom.append("SICEE_T_CERTIFICATORE cre, ");
		strFrom.append("SICEE_T_AZIENDA a, ");
		strFrom.append("SICEE_T_DATI_ESAMI de, ");
		strFrom.append("SICEE_T_CERTIFICATO cto, ");
		strFrom.append("(SELECT id_certificatore, progr_certificato, anno FROM SICEE_T_CLASSE_ENERGETICA ");
		strFrom.append("WHERE fk_classe = "+iClass+") ce"+iClass+" ");
		strFrom.append("WHERE ");
		strFrom.append("cre.fk_istruzione = t.id_istruzione (+) "); // Titolo
		strFrom.append("AND cre.fk_azienda = a.id_azienda "); // Ragione sociale
		strFrom.append("AND cre.id_certificatore = de.fk_certificatore (+) "); // Esame sostenuto
		strFrom.append("AND cre.id_certificatore = cto.id_certificatore "); // N° ace inviati dal …… al ……
		strFrom.append("AND to_number(cto.id_certificatore) >:parametro "); // N° ace inviati dal …… al ……
//		params.addValue("parametro", parametro, Types.NUMERIC);						

		
		strFrom.append("AND cto.fk_stato = "+Constants.ID_STATO_CERTIFICATO_3+" "); // N° ace inviati dal …… al ……
				
		
		if (isDataACEpresente) 
		{
			strFrom.append("AND TRUNC(dt_upload) BETWEEN TO_DATE(:dataDal,'DD/MM/YYYY') AND TO_DATE(:dataAl,'DD/MM/YYYY') "); // N° ace inviati dal …… al ……
			
			//params.addValue("dataDal", dataACEdal, Types.DATE);
			//params.addValue("dataAl", dataACEal, Types.DATE);
		}

		//strFrom.append("AND TRUNC(dt_upload) BETWEEN TO_DATE('03/07/2011','DD/MM/YYYY') AND TO_DATE('05/07/2012','DD/MM/YYYY') "); // N° ace inviati dal …… al ……
				
		strFrom.append("AND cto.id_certificatore = ce"+iClass+".id_certificatore ");
		strFrom.append("AND cto.progr_certificato = ce"+iClass+".progr_certificato ");
		strFrom.append("AND cto.anno = ce"+iClass+".anno ");
		strFrom.append("GROUP BY cre.id_certificatore ");
		strFrom.append(") classe"+iClass+" ");
			
		
		strWhere.append(iClass==1?" WHERE ":" AND ");
		
		strWhere.append(" gen.id_cert = classe"+iClass+".id_certificatore (+) ");
		
		return strFrom;
	}
	
	private String likeString(String str) {
		return new String("%"+str+"%");
	}
	
	
}
