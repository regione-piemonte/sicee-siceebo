/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatore;
import it.csi.sicee.siceebo.business.dao.dto.SiceeTCertificatorePk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTCertificatoreDaoException;
import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface SiceeTCertificatoreDao.
 */
public interface SiceeTCertificatoreDao
{
	
	/**
	 * Method 'insert'.
	 *
	 * @param dto the dto
	 * @return SiceeTCertificatorePk
	 */
	public SiceeTCertificatorePk insert(SiceeTCertificatore dto);

	/**
	 * Updates a single row in the SICEE_T_CERTIFICATORE table.
	 *
	 * @param pk the pk
	 * @param dto the dto
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public void update(SiceeTCertificatorePk pk, SiceeTCertificatore dto) throws SiceeTCertificatoreDaoException;

	/**
	 * Deletes a single row in the SICEE_T_CERTIFICATORE table.
	 *
	 * @param pk the pk
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public void delete(SiceeTCertificatorePk pk) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the sicee t certificatore
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public SiceeTCertificatore findByPrimaryKey(String idCertificatore) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria ''.
	 *
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findAll() throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_TITOLO = :fkTitolo'.
	 *
	 * @param fkTitolo the fk titolo
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findBySiceeDTitolo(String fkTitolo) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_AZIENDA = :fkAzienda'.
	 *
	 * @param fkAzienda the fk azienda
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findBySiceeTAzienda(long fkAzienda) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_CERTIFICATORE = :idCertificatore'.
	 *
	 * @param idCertificatore the id certificatore
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereIdCertificatoreEquals(String idCertificatore) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_AZIENDA = :fkAzienda'.
	 *
	 * @param fkAzienda the fk azienda
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFkAziendaEquals(long fkAzienda) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FK_TITOLO = :fkTitolo'.
	 *
	 * @param fkTitolo the fk titolo
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFkTitoloEquals(String fkTitolo) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NOME = :nome'.
	 *
	 * @param nome the nome
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereNomeEquals(String nome) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'COGNOME = :cognome'.
	 *
	 * @param cognome the cognome
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereCognomeEquals(String cognome) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereCodiceFiscaleEquals(String codiceFiscale) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CODICE_FISCALE = :codiceFiscale'.
	 *
	 * @param codiceFiscale the codice fiscale
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereCodiceFiscaleLike(String codiceFiscale) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_COMUNE_NASCITA = :idComuneNascita'.
	 *
	 * @param idComuneNascita the id comune nascita
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereIdComuneNascitaEquals(String idComuneNascita) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_COMUNE_NASCITA = :descComuneNascita'.
	 *
	 * @param descComuneNascita the desc comune nascita
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDescComuneNascitaEquals(String descComuneNascita) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_NASCITA = :dtNascita'.
	 *
	 * @param dtNascita the dt nascita
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDtNascitaEquals(Date dtNascita) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_PROV_NASCITA = :idProvNascita'.
	 *
	 * @param idProvNascita the id prov nascita
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereIdProvNascitaEquals(String idProvNascita) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_INDIRIZZO = :idIndirizzo'.
	 *
	 * @param idIndirizzo the id indirizzo
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereIdIndirizzoEquals(Integer idIndirizzo) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_PROV_NASCITA = :descProvNascita'.
	 *
	 * @param descProvNascita the desc prov nascita
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDescProvNascitaEquals(String descProvNascita) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_REGIONE_NASCITA = :idRegioneNascita'.
	 *
	 * @param idRegioneNascita the id regione nascita
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereIdRegioneNascitaEquals(String idRegioneNascita) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_INDIRIZZO = :descIndirizzo'.
	 *
	 * @param descIndirizzo the desc indirizzo
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDescIndirizzoEquals(String descIndirizzo) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CAP = :cap'.
	 *
	 * @param cap the cap
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereCapEquals(String cap) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_REGIONE_NASCITA = :descRegioneNascita'.
	 *
	 * @param descRegioneNascita the desc regione nascita
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDescRegioneNascitaEquals(String descRegioneNascita) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_COMUNE_RESIDENZA = :idComuneResidenza'.
	 *
	 * @param idComuneResidenza the id comune residenza
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereIdComuneResidenzaEquals(String idComuneResidenza) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_CIVICO_RESIDENZA = :numCivicoResidenza'.
	 *
	 * @param numCivicoResidenza the num civico residenza
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereNumCivicoResidenzaEquals(String numCivicoResidenza) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_COMUNE_RESIDENZA = :descComuneResidenza'.
	 *
	 * @param descComuneResidenza the desc comune residenza
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDescComuneResidenzaEquals(String descComuneResidenza) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_EDIFICI = :flgEdifici'.
	 *
	 * @param flgEdifici the flg edifici
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFlgEdificiEquals(String flgEdifici) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_IMPIANTI = :flgImpianti'.
	 *
	 * @param flgImpianti the flg impianti
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFlgImpiantiEquals(String flgImpianti) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_VERIFICATO = :flgVerificato'.
	 *
	 * @param flgVerificato the flg verificato
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFlgVerificatoEquals(String flgVerificato) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_PAGAMENTO = :flgPagamento'.
	 *
	 * @param flgPagamento the flg pagamento
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFlgPagamentoEquals(String flgPagamento) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NOTE = :note'.
	 *
	 * @param note the note
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereNoteEquals(String note) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_PROV_RESIDENZA = :idProvResidenza'.
	 *
	 * @param idProvResidenza the id prov residenza
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereIdProvResidenzaEquals(String idProvResidenza) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_ISCR_ELENCO = :dtIscrElenco'.
	 *
	 * @param dtIscrElenco the dt iscr elenco
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDtIscrElencoEquals(Date dtIscrElenco) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_PROV_RESIDENZA = :descProvResidenza'.
	 *
	 * @param descProvResidenza the desc prov residenza
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDescProvResidenzaEquals(String descProvResidenza) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DT_SCADENZA_ELENCO = :dtScadenzaElenco'.
	 *
	 * @param dtScadenzaElenco the dt scadenza elenco
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDtScadenzaElencoEquals(Date dtScadenzaElenco) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_REGIONE_RESIDENZA = :idRegioneResidenza'.
	 *
	 * @param idRegioneResidenza the id regione residenza
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereIdRegioneResidenzaEquals(String idRegioneResidenza) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_TOT_ACE = :numTotAce'.
	 *
	 * @param numTotAce the num tot ace
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereNumTotAceEquals(long numTotAce) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_REGIONE_RESIDENZA = :descRegioneResidenza'.
	 *
	 * @param descRegioneResidenza the desc regione residenza
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDescRegioneResidenzaEquals(String descRegioneResidenza) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ORDINE = :ordine'.
	 *
	 * @param ordine the ordine
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereOrdineEquals(String ordine) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DESC_PROV_ORDINE = :descProvOrdine'.
	 *
	 * @param descProvOrdine the desc prov ordine
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDescProvOrdineEquals(String descProvOrdine) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_ISCR_ALBO = :numIscrAlbo'.
	 *
	 * @param numIscrAlbo the num iscr albo
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereNumIscrAlboEquals(String numIscrAlbo) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'ID_PROV_ORDINE = :idProvOrdine'.
	 *
	 * @param idProvOrdine the id prov ordine
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereIdProvOrdineEquals(String idProvOrdine) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'SETTORE = :settore'.
	 *
	 * @param settore the settore
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereSettoreEquals(String settore) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'SEZIONE = :sezione'.
	 *
	 * @param sezione the sezione
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereSezioneEquals(String sezione) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'TELEFONO = :telefono'.
	 *
	 * @param telefono the telefono
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereTelefonoEquals(String telefono) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'DATA_ISCR_ALBO = :dataIscrAlbo'.
	 *
	 * @param dataIscrAlbo the data iscr albo
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereDataIscrAlboEquals(Date dataIscrAlbo) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FAX = :fax'.
	 *
	 * @param fax the fax
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFaxEquals(String fax) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'CELL = :cell'.
	 *
	 * @param cell the cell
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereCellEquals(String cell) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'EMAIL = :email'.
	 *
	 * @param email the email
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereEmailEquals(String email) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'NUM_CERTIFICATORE = :numCertificatore'.
	 *
	 * @param numCertificatore the num certificatore
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public SiceeTCertificatore findWhereNumCertificatoreEquals(String numCertificatore) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'STATO_ESTERO = :statoEstero'.
	 *
	 * @param statoEstero the stato estero
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereStatoEsteroEquals(String statoEstero) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CONSENSO_TEL = :flgConsensoTel'.
	 *
	 * @param flgConsensoTel the flg consenso tel
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFlgConsensoTelEquals(String flgConsensoTel) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CONSENSO_EMAIL = :flgConsensoEmail'.
	 *
	 * @param flgConsensoEmail the flg consenso email
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFlgConsensoEmailEquals(String flgConsensoEmail) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_CONSENSO_CELL = :flgConsensoCell'.
	 *
	 * @param flgConsensoCell the flg consenso cell
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFlgConsensoCellEquals(String flgConsensoCell) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'EMAIL_PEC = :emailPec'.
	 *
	 * @param emailPec the email pec
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereEmailPecEquals(String emailPec) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_NEWSLETTER = :flgNewsletter'.
	 *
	 * @param flgNewsletter the flg newsletter
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFlgNewsletterEquals(String flgNewsletter) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'FLG_ESAME_SOSTENUTO = :flgEsameSostenuto'.
	 *
	 * @param flgEsameSostenuto the flg esame sostenuto
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereFlgEsameSostenutoEquals(String flgEsameSostenuto) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns all rows from the SICEE_T_CERTIFICATORE table that match the criteria 'SITO_WEB = :sitoWeb'.
	 *
	 * @param sitoWeb the sito web
	 * @return the list
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public List<SiceeTCertificatore> findWhereSitoWebEquals(String sitoWeb) throws SiceeTCertificatoreDaoException;

	/**
	 * Returns the rows from the SICEE_T_CERTIFICATORE table that matches the specified primary-key value.
	 *
	 * @param pk the pk
	 * @return the sicee t certificatore
	 * @throws SiceeTCertificatoreDaoException the sicee t certificatore dao exception
	 */
	public SiceeTCertificatore findByPrimaryKey(SiceeTCertificatorePk pk) throws SiceeTCertificatoreDaoException;

}
