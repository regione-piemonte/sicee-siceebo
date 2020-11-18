/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dto.OptimizedSiceeTTransazione2018;
import it.csi.sicee.siceebo.business.dao.exceptions.OptimizedSiceeTTransazione2018DaoException;
import it.csi.sicee.siceebo.dto.backoffice.FiltroDettaglioTransAttEsito;

import java.util.Date;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Interface OptimizedSiceeTCorso2015Dao.
 */
public interface OptimizedSiceeTTransazione2018Dao
{

	/**
	 * Method 'findDettTransazioniAttesaEsito'.
	 *
	 * @return List<OptimizedSiceeTTransazione2018>
	 * @throws OptimizedSiceeTTransazione2018DaoException the optimized sicee t transazione 2018 dao exception
	 */	public List<OptimizedSiceeTTransazione2018> findDettTransazioniAttesaEsito(FiltroDettaglioTransAttEsito filtro) throws OptimizedSiceeTTransazione2018DaoException;

		public Integer findCountTransazioniByStato(String dataCreazioneDal, String dataCreazioneAl, int statoTransazione) throws OptimizedSiceeTTransazione2018DaoException;
		
		public Float findCountValoreTransazioniPagamentoOk(String dataCreazioneDal, String dataCreazioneAl) throws OptimizedSiceeTTransazione2018DaoException;
}
