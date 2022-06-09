/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2021
*******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import java.util.List;

import it.csi.sicee.siceebo.business.dao.dto.SiceeLAccesso;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLAccessoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeLAccessoDaoException;

public interface SiceeLAccessoDao {
	
	public void delete(SiceeLAccessoPk pk) throws SiceeLAccessoDaoException;

	public Integer findLogAccessoDaStoricizzareCount() throws SiceeLAccessoDaoException;
	
	public List<SiceeLAccesso> findDaArchiviare() throws SiceeLAccessoDaoException;
}
