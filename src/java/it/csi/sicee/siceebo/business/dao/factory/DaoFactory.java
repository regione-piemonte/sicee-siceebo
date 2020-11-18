/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
package it.csi.sicee.siceebo.business.dao.factory;

import it.csi.sicee.siceebo.business.dao.dao.SiceeDClasseEnergeticaDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDDestUsoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDMotivoRilascioDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDStatoCertDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeDTitoloDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTCertificatoreDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTExportBoDao;
import it.csi.sicee.siceebo.business.dao.dao.SiceeTParametriDao;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class DaoFactory
{

	/**
	 * Method 'createSiceeDTitoloDao'
	 * 
	 * @return SiceeDTitoloDao
	 */
	public static SiceeDTitoloDao createSiceeDTitoloDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDTitoloDao) bf.getBean( "SiceeDTitoloDao" );
	}

	/**
	 * Method 'createSiceeDMotivoRilascioDao'
	 * 
	 * @return SiceeDMotivoRilascioDao
	 */
	public static SiceeDMotivoRilascioDao createSiceeDMotivoRilascioDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDMotivoRilascioDao) bf.getBean( "SiceeDMotivoRilascioDao" );
	}
	
	/**
	 * Method 'createSiceeTExportBoDao'
	 * 
	 * @return SiceeTExportBoDao
	 */
	public static SiceeTExportBoDao createSiceeTExportBoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTExportBoDao) bf.getBean( "SiceeTExportBoDao" );
	}
	
	/**
	 * Method 'createSiceeDClasseEnergeticaDao'
	 * 
	 * @return SiceeDClasseEnergeticaDao
	 */
	public static SiceeDClasseEnergeticaDao createSiceeDClasseEnergeticaDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDClasseEnergeticaDao) bf.getBean( "SiceeDClasseEnergeticaDao" );
	}

	/**
	 * Method 'createSiceeDDestUsoDao'
	 * 
	 * @return SiceeDDestUsoDao
	 */
	public static SiceeDDestUsoDao createSiceeDDestUsoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDDestUsoDao) bf.getBean( "SiceeDDestUsoDao" );
	}

	/**
	 * Method 'createSiceeTCertificatoreDao'
	 * 
	 * @return SiceeTCertificatoreDao
	 */
	public static SiceeTCertificatoreDao createSiceeTCertificatoreDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTCertificatoreDao) bf.getBean( "SiceeTCertificatoreDao" );
	}

	/**
	 * Method 'createSiceeTCertificatoDao'
	 * 
	 * @return SiceeTCertificatoDao
	 */
	public static SiceeTCertificatoDao createSiceeTCertificatoDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTCertificatoDao) bf.getBean( "SiceeTCertificatoDao" );
	}

	/**
	 * Method 'createSiceeTParametriDao'
	 * 
	 * @return SiceeTParametriDao
	 */
	public static SiceeTParametriDao createSiceeTParametriDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeTParametriDao) bf.getBean( "SiceeTParametriDao" );
	}
	
	/**
	 * Method 'createSiceeDDestUsoDao'
	 * 
	 * @return SiceeDDestUsoDao
	 */
	public static SiceeDStatoCertDao createSiceeDStatoCertDao()
	{
		BeanFactory bf = new XmlBeanFactory( new ClassPathResource("dao-beans.xml") );
		return (SiceeDStatoCertDao) bf.getBean( "SiceeDStatoCertDao" );
	}
}
