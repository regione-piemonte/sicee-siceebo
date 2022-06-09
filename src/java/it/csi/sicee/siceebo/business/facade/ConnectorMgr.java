/*******************************************************************************
* SPDX-License-Identifier: EUPL-1.2
* Copyright Regione Piemonte - 2021
*******************************************************************************/
package it.csi.sicee.siceebo.business.facade;

import java.util.List;

import it.csi.sicee.siceebo.business.BEException;
import it.csi.sicee.siceebo.business.dao.dto.SiceeLAccesso;

public class ConnectorMgr extends BaseMgr {
	
	private BackOfficeMgr backOfficeMgr;
	
	public BackOfficeMgr getBackOfficeMgr() {
		return this.backOfficeMgr;
	}
	
	public void setBackOfficeMgr(BackOfficeMgr backOfficeMgr) {
		this.backOfficeMgr = backOfficeMgr;
	}
	
	
	public void storicizzaLogAccesso () throws BEException {
		
		// Cancello i log vecchi da SiceeSAccesso
		getBackOfficeMgr().eliminaLogAccessoOld();
		
		// Recupero i log da SiceeLAccesso da archiviare
		List<SiceeLAccesso> listLogDaArch = getBackOfficeMgr().recuperaLogAccessoDaArchiviare();
		
		for (SiceeLAccesso logDaArch : listLogDaArch) {
			
			log.debug("Stampo il log da archiviare: "+logDaArch.getDtAccesso() + " - " + logDaArch.getCodiceFiscale());
			try
			{
				getBackOfficeMgr().archiviaLogAccessoStorico(logDaArch);
			}
			catch (Exception ex)
			{
				log.error("Si e' verificata un'eccezione sull'archiviazione del sigitLAccessoDto: "+logDaArch.getDtAccesso() + " - " + logDaArch.getCodiceFiscale());
				// Stampo sui LOG l'eccezione ma proseguo con le eliminazioni
			}
		}			
	}
}
