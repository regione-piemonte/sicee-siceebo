package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;

public class SiceeDTipoDocAgg implements Serializable {
	protected Integer idTipoDocAgg;
	protected String descTipoDocAgg;

	public SiceeDTipoDocAgg(Integer idTipoDocAgg, String descTipoDocAgg) {
		this.idTipoDocAgg = idTipoDocAgg;
		this.descTipoDocAgg = descTipoDocAgg;
	}

	public SiceeDTipoDocAgg() {
	}

	public Integer getIdTipoDocAgg() {
		return idTipoDocAgg;
	}

	public void setIdTipoDocAgg(Integer idTipoDocAgg) {
		this.idTipoDocAgg = idTipoDocAgg;
	}

	public String getDescTipoDocAgg() {
		return descTipoDocAgg;
	}

	public void setDescTipoDocAgg(String descTipoDocAgg) {
		this.descTipoDocAgg = descTipoDocAgg;
	}
}
