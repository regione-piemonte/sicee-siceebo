/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.dto;

import java.io.Serializable;

public class SiceeDTipoenteform2015 implements Serializable
{
	/** 
	 * This attribute maps to the column ID_TIPO_ENTEFORM in the SICEE_D_TIPO_ENTEFORM_2015 table.
	 */
	protected  String idTipoenteform;

	/** 
	 * This attribute maps to the column DESCR in the SICEE_D_TIPO_ENTEFORM_2015 table.
	 */
	protected String descr;

	/**
	 * Method 'SiceeDTipoenteform2015'
	 * 
	 */
	public SiceeDTipoenteform2015()
	{
	}

	/**
	 * Method 'getIdTipoenteform'
	 * 
	 * @return String
	 */
	public String getIdTipoenteform()
	{
		return idTipoenteform;
	}

	/**
	 * Method 'setIdTipoenteform'
	 * 
	 * @param idTipoenteform
	 */
	public void setIdTipoenteform(String idTipoenteform)
	{
		this.idTipoenteform = idTipoenteform;
	}

	/**
	 * Method 'getDescr'
	 * 
	 * @return String
	 */
	public String getDescr()
	{
		return descr;
	}

	/**
	 * Method 'setDescr'
	 * 
	 * @param descr
	 */
	public void setDescr(String descr)
	{
		this.descr = descr;
	}

	/**
	 * Method 'equals'
	 * 
	 * @param _other
	 * @return boolean
	 */
	public boolean equals(Object _other)
	{
		if (_other == null) {
			return false;
		}
		
		if (_other == this) {
			return true;
		}
		
		if (!(_other instanceof SiceeDTipoenteform2015)) {
			return false;
		}
		
		final SiceeDTipoenteform2015 _cast = (SiceeDTipoenteform2015) _other;
		if (idTipoenteform == null ? _cast.idTipoenteform != idTipoenteform : !idTipoenteform.equals( _cast.idTipoenteform )) {
			return false;
		}
		
		if (descr == null ? _cast.descr != descr : !descr.equals( _cast.descr )) {
			return false;
		}
		
		return true;
	}

	/**
	 * Method 'hashCode'
	 * 
	 * @return int
	 */
	public int hashCode()
	{
		int _hashCode = 0;
		if (idTipoenteform != null) {
			_hashCode = 29 * _hashCode + idTipoenteform.hashCode();
		}
		
		if (descr != null) {
			_hashCode = 29 * _hashCode + descr.hashCode();
		}
		
		return _hashCode;
	}


	/**
	 * Method 'createPk'
	 * 
	 * @return SiceeDTipoenteform2015Pk
	 */
	public SiceeDTipoenteform2015Pk createPk()
	{
		return new SiceeDTipoenteform2015Pk(idTipoenteform);
	}

	/**
	 * Method 'toString'
	 * 
	 * @return String
	 */
	public String toString()
	{
		StringBuffer ret = new StringBuffer();
		ret.append( "it.csi.sicee.siceesrv.business.dao.dto.SiceeDTipoenteform2015: " );
		ret.append( "idTipoenteform=" + idTipoenteform );
		ret.append( ", descr=" + descr );
		return ret.toString();
	}

}
