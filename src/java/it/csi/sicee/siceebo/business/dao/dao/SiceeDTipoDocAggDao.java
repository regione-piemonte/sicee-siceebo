package it.csi.sicee.siceebo.business.dao.dao;

import it.csi.sicee.siceebo.business.dao.dto.SiceeDTipoDocAgg;
import it.csi.sicee.siceebo.business.dao.exceptions.SiceeTDocAggiuntivaDaoException;

import java.util.List;

public interface SiceeDTipoDocAggDao {
	public SiceeDTipoDocAgg findByPrimaryKey(Integer idDoc) throws SiceeTDocAggiuntivaDaoException;

	public List<SiceeDTipoDocAgg> findAll() throws SiceeTDocAggiuntivaDaoException;
}
