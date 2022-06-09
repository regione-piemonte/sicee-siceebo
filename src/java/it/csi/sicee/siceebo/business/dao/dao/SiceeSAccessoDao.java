/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2021
*******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dto.SiceeSAccesso;
import it.csi.sicee.siceebo.business.dao.dto.SiceeSAccessoPk;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeSAccessoDaoException;

public interface SiceeSAccessoDao {
	
	public SiceeSAccessoPk insert(SiceeSAccesso dto) throws SiceeSAccessoDaoException;

	public Integer findLogAccessoDaCancellareCount() throws SiceeSAccessoDaoException;

	public void deleteOld() throws SiceeSAccessoDaoException;
}
