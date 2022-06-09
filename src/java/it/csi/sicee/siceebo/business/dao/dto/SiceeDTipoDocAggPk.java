package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;

public class SiceeDTipoDocAggPk implements Serializable {

	protected Integer idTipoDocAgg;

	public SiceeDTipoDocAggPk(Integer idTipoDocAgg) {
		this.idTipoDocAgg = idTipoDocAgg;
	}

	public SiceeDTipoDocAggPk() {
	}

	public Integer getIdTipoDocAgg() {
		return idTipoDocAgg;
	}

	public void setIdTipoDocAgg(Integer idTipoDocAgg) {
		this.idTipoDocAgg = idTipoDocAgg;
	}
}
