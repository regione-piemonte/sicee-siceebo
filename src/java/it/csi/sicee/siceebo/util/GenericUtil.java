/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceebo.util;

import it.csi.sicee.siceebo.business.dao.dto.SiceeTParametri;
import it.csi.sicee.siceebo.dto.ace.Ace;
import it.csi.sicee.siceebo.dto.entiformativi.Decodifica;
import it.csi.sicee.siceebo.dto.type.UDTDateValid;
import it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFive;
import it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour;
import it.csi.sicee.siceebo.dto.type.UDTPositiveInteger;




import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import org.apache.log4j.Logger;

/**
 * The Class GenericUtil.
 */
public class GenericUtil {

	/** The Constant BEGIN. */
	static final int BEGIN = 1;

	/** The Constant END. */
	static final int END = 2;

	/** The Constant VALUE. */
	static final int VALUE = 3;

	/** The Constant TEST. */
	static final int TEST = 4;

	/** The Constant SIMPLE. */
	static final int SIMPLE = 5;

	private static Hashtable<Integer, String> decimalFormats = new Hashtable<Integer, String>();

	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE);

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @param testName
	 *            the test name
	 */
	public static void stampa(Object o, boolean useLog4j, int depth,
			String testName) {
		try {
			if (useLog4j) {
				log.debug(testName + " BEGIN");
			} else {
				System.out.println(testName + " BEGIN");
			}
			if (o != null) {
				if (o.getClass().isArray()) {
					Object[] a = (Object[]) o;
					stampa(a, useLog4j, depth);
				} else {
					stampa(o, useLog4j, depth);
				}
			}
			if (useLog4j) {
				log.debug(testName + " END");
			} else {
				System.out.println(testName + " END");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 */
	public static void stampa(Object o, boolean useLog4j, int depth) {

		try {
			if (o == null) {
				print(o, null, useLog4j, depth, BEGIN);
			} else {
				if (o instanceof String) {
					print(o, o, useLog4j, depth, SIMPLE);
				} else {
					print(o, null, useLog4j, depth, BEGIN);
					callGetMethods(o, useLog4j, depth + 1);
					print(o, null, useLog4j, depth, END);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the.
	 * 
	 * @param o
	 *            the o
	 * @param value
	 *            the value
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @param type
	 *            the type
	 * @throws Exception
	 *             the exception
	 */
	private static void print(Object o, Object value, boolean useLog4j,
			int depth, int type) throws Exception {

		StringBuffer tab = new StringBuffer();
		for (int i = 0; i < depth; i++) {
			tab.append("\t");
		}
		if (o != null) {
			String className = o.getClass().getName();
			switch (type) {
			case BEGIN:
				tab.append(className);
				tab.append(" BEGIN");
				break;
			case END:
				tab.append(className);
				tab.append(" END");
				break;
			case VALUE:
				tab.append(((Method) o).getName());
				tab.append(" == ");
				tab.append(value);
				break;
			case SIMPLE:
				tab.append(o);
				tab.append(" == ");
				tab.append(value);
				break;
			default:

			}
		} else if (type == TEST) {
			tab.append("");
		} else {
			tab.append("Oggetto nullo!!");
		}

		if (useLog4j) {
			log.debug(tab);
		} else {
			System.out.println(tab);
		}

	}

	/**
	 * Call get methods.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 */
	private static void callGetMethods(Object o, boolean useLog4j, int depth) {
		try {
			Method[] meth = o.getClass().getDeclaredMethods();
			for (int i = 0; i < meth.length; i++) {
				Method thisM = meth[i];
				if (thisM.getName().startsWith("get")) {
					if (!thisM.getName().equals("get")) {
						Object result = thisM.invoke(o, new Object[] {});
						if (result != null && result.getClass().isArray()) {
							Object[] a = (Object[]) result;
							stampa(a, useLog4j, depth);
						} else {
							print(thisM, result, useLog4j, depth, VALUE);
						}
					}
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * Stampa.
	 * 
	 * @param o
	 *            the o
	 * @param useLog4j
	 *            the use log4j
	 * @param depth
	 *            the depth
	 * @throws Exception
	 *             the exception
	 */
	public static void stampa(Object[] o, boolean useLog4j, int depth)
			throws Exception {
		String className = o.getClass().getSimpleName();
		for (int i = 0; i < o.length; i++) {
			stampa(o[i], false, depth);
		}

		if (o.length == 0) {
			System.out.println(className + " vuoto");
		}

	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param n
	 *            the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveDoubleFour n) {

		// System.out.println("isNullOrEmpty(UDTPositiveDoubleFour: "+(n == null
		// || n.getValue() == null));

		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param n
	 *            the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveDoubleFive n) {
		// System.out.println("isNullOrEmpty(UDTPositiveDoubleFive: "+(n == null
		// || n.getValue() == null));

		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param n
	 *            the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveInteger n) {
		// System.out.println("isNullOrEmpty(UDTPositiveInteger: "+(n == null ||
		// n.getValue() == null));

		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(String s) {
		// System.out.println("isNullOrEmpty(String: "+(s == null ||
		// s.trim().length() == 0));

		return s == null || s.trim().length() == 0;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Integer s) {

		// System.out.println("isNullOrEmpty(Integer: "+(s == null));

		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Double s) {
		// System.out.println("isNullOrEmpty(Double: "+(s == null));

		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Boolean s) {
		// System.out.println("isNullOrEmpty(Boolean: "+(s == null));

		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param n
	 *            the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTDateValid n) {
		// System.out.println("isNullOrEmpty(UDTDateValid: "+(n == null ||
		// n.getValue() == null));

		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Object s) {
		return s == null;
	}

	/**
	 * Checks if is lunghezza minimo2.
	 * 
	 * @param s
	 *            the s
	 * @return true, if is lunghezza minimo2
	 */
	public static boolean isLunghezzaMinimo2(String s) {
		return s.trim().length() > Constants.VALORE_1;
	}

	/**
	 * Check valide six number.
	 * 
	 * @param num
	 *            the num
	 * @return true, if successful
	 */
	public static boolean checkValideSixNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]{6}"))
				return true;
			else
				return false;
		}

		return false;
	}

	/**
	 * Convert to string.
	 * 
	 * @param dt
	 *            the dt
	 * @return the string
	 */
	public static String convertToString(UDTDateValid dt) {
		if (dt != null) {
			return dt.getValue();
		} else
			return null;
	}
	
	public static String convertToString(Long dt) {
		if (dt != null) {
			return dt.toString();
		} else
			return null;
	}

	public static Integer convertToInteger(String s) {
		Integer converted = null;

		if (!isNullOrEmpty(s)) {
			return new Integer(s);
		}
		else 
			return null;
	}
	/**
	 * Convert to double.
	 * 
	 * @param dt
	 *            the dt
	 * @return the double
	 */
	public static Double convertToDouble(String dt) {
		if (dt != null) {
			return Double.valueOf(dt);
		} else
			return null;
	}

	public static Float convertToFloat(Double bi) {
		if(bi != null) {
				return new Float(bi);
		}
		else
			return null;
	}
	
	public static Float convertToFloat(String bi) {
		if(bi != null) {
				return new Float(bi);
		}
		else
			return null;
	}
	
	/**
	 * Convert to double.
	 * 
	 * @param dt
	 *            the dt
	 * @return the double
	 */
	public static Double convertToDouble(Integer dt) {
		if (dt != null) {
			return Double.valueOf(dt);
		} else
			return null;
	}

	/**
	 * Convert to string.
	 * 
	 * @param i
	 *            the i
	 * @return the string
	 */
	public static String convertToString(Integer i) {
		if (i == null)
			return null;
		else
			return Integer.toString(i);
	}

	/*
	 * public static String convertToString(UDTPositiveDoubleFour dt) {
	 * if (dt != null) {
	 * return dt.toString();
	 * } else
	 * return null;
	 * }
	 * 
	 * public static String convertToString(UDTPositiveDoubleFive dt) {
	 * if (dt != null) {
	 * return dt.toString();
	 * } else
	 * return null;
	 * }
	 */
	/**
	 * Convert to string.
	 * 
	 * @param num
	 *            the num
	 * @return the string
	 */
	public static String convertToString(UDTPositiveDoubleFive num) {
		java.util.Locale.setDefault(java.util.Locale.ITALY);
		java.text.DecimalFormat df = new java.text.DecimalFormat(
				"##########.#####");

		return (num != null) ? df.format(num.getValue()) : null;
	}

	/**
	 * Convert to string.
	 * 
	 * @param num
	 *            the num
	 * @return the string
	 */
	public static String convertToString(UDTPositiveDoubleFour num) {
		java.util.Locale.setDefault(java.util.Locale.ITALY);
		java.text.DecimalFormat df = new java.text.DecimalFormat(
				"##########.####");

		return (num != null) ? df.format(num.getValue()) : null;
	}

	/**
	 * Convert to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	public static String convertToString(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			return sdf.format(dt);
		} else
			return null;
	}
	
	public static String convertToStringDataCompleta(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			return sdf.format(dt);
		} else
			return null;
	}

	
	/**
	 * Converte un {@link BigDecimal} in stringa
	 * 
	 * @param number Numero da convertire
	 * @param decimali Decimali da visualizzare
	 * @return Numero convertito
	 */
	public static String convertToString(Double number, int decimali) {
		DecimalFormat formatter = null;
		String format = null;
		String stringValue = null;

		if(number != null) {
			format = getNumberFormat(decimali);
			formatter = new DecimalFormat(format);
			stringValue = formatter.format(number.doubleValue());
		}
		return stringValue;
	}
	
	/**
	 * Converte un {@link BigDecimal} in stringa
	 * 
	 * @param number Numero da convertire
	 * @param decimali Decimali da visualizzare
	 * @return Numero convertito
	 */
	public static String convertToString(Double number) {
		
		return convertToString(number, 2);
	}

	/**
	 * Convert to date.
	 *
	 * @param s the s
	 * @return the java.util. date
	 * @throws BEException the bE exception
	 */
	public static java.util.Date convertToDate(String s) throws Exception{
		if (s != null && s.length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return sdf.parse(s);
			} catch (ParseException e) {
				throw new Exception("Errore nella parsificazioen della data "
						+ s, e);
			}
		} else
			return null;
	}
	
	/**
	 * Verify param.
	 * 
	 * @param param
	 *            the param
	 * @param paramMancante
	 *            the param mancante
	 * @return true, if successful
	 */
	public static boolean verifyParam(SiceeTParametri param,
			String paramMancante) {
		if (param == null) {
			log.debug("PARAMETRO " + paramMancante + " INESISTENTE");
			return false;
		}

		return true;
	}

	/**
	 * Gets the data odierna.
	 * 
	 * @return the data odierna
	 */
	public static String getDataOdierna() {
		return Constants.FORMATTER_DATA_WEB.format(new Date(System
				.currentTimeMillis()));
	}

	/**
	 * Remove the one year.
	 *
	 * @param base the base
	 * @return the string
	 */
	public static String removeOneYear(String base) throws Exception {
		java.util.Date dt_base = convertToDate(base);
		Calendar cal_base = Calendar.getInstance();
		cal_base.setTime(dt_base);
		cal_base.add(Calendar.YEAR, -1);
		java.util.Date dt_after = cal_base.getTime();
		return Constants.FORMATTER_DATA_WEB.format(dt_after);
	}

	/**
	 * Remove the one day.
	 *
	 * @param base the base
	 * @return the string
	 */
	public static String removeOneDay(String base) throws Exception {
		java.util.Date dt_base = convertToDate(base);
		Calendar cal_base = Calendar.getInstance();
		cal_base.setTime(dt_base);
		cal_base.add(Calendar.DAY_OF_YEAR, -1);
		java.util.Date dt_after = cal_base.getTime();
		return Constants.FORMATTER_DATA_WEB.format(dt_after);
	}

	
	/**
	 * Gets the data odierna.
	 * 
	 * @return the data odierna
	 */
	public static java.sql.Date getDataOdiernaSql() {
		return new java.sql.Date(System
				.currentTimeMillis());
	}
	
	/**
	 * Restituisce il formato numerico richiesto
	 * 
	 * @param decimali Decimali da visualizzare
	 * @return Formato numerico
	 */
	private static String getNumberFormat(int decimali) {
		String format = null;
		String decimal = null;
		int decimaliCount;

		format = decimalFormats.get(decimali);
		if(format == null) {
			format = "#,##0";
			decimal = "";
			for(decimaliCount = 0; decimaliCount < decimali; decimaliCount++) {
				decimal += "0";
			}
			if(decimal.length() > 0) {
				format += ("." + decimal);
			}
			decimalFormats.put(decimali, format);
		}
		return format;
	}

	public static String getMessaggiFormattatiHtml(String[] msgList)
	{
		StringBuffer sbMsg = new StringBuffer();
		
		String msg = null;
		for (int i = 0; i < msgList.length; i++) {
			
			msg = msgList[i];
			
			if (i != 0)
			{
				sbMsg.append("<BR>");
			}
			
			sbMsg.append(msg);
			
		}
		
		return sbMsg.toString();
	}
	
	public static boolean checkValideFourNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[0-9]{4}"))
				return true;
			else
				return false;
		}

		return false;
	}
	
	public static String getHashFile(byte[] theFile) throws Exception {
		
		FileInputStream fileInputStream=null;
		String retAsh=null;
		
		    try {
		    	/*
		    	byte[] bFile = new byte[(int) fAsh.length()];
				FileInputStream is = new FileInputStream(fAsh);
				is.read(bFile);
				is.close();
			    
			    MessageDigest md = MessageDigest.getInstance("SHA1");
			    byte[] dataBytes = new byte[bFile.length];
			    int nread = 0; 
			    
			    while ((nread = is.read(dataBytes)) != -1) {
			      md.update(dataBytes, 0, nread);
			    };
			    byte[] mdbytes = md.digest();
			    */
			    

			    // PRIMO FILE
			    MessageDigest md = MessageDigest.getInstance("SHA1");
				InputStream is = new ByteArrayInputStream(theFile);
			    //FileInputStream is = new FileInputStream(fAsh);
			    byte[] dataBytes = new byte[1024];
			    int nread = 0; 
			    while ((nread = is.read(dataBytes)) != -1) {
			      md.update(dataBytes, 0, nread);
			    };
			    byte[] mdbytes = md.digest();
			    
			    //byte --> hex format
			    StringBuffer sb = new StringBuffer("");
			    for (int i = 0; i < mdbytes.length; i++) {
			    	sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
			    }
			    
			    log.debug("ASH TROVATO=" + sb.toString());
			    retAsh = sb.toString();
			    
	    } catch (FileNotFoundException e) {
	    	log.error("Errore", e);
	    	throw new Exception(e.getMessage(), e);
	    } catch (IOException e) {
	    	log.error("Errore", e);
	    	throw new Exception(e.getMessage(), e);
	    }catch (NoSuchAlgorithmException e) {
	    	log.error("Errore", e);
	    	throw new Exception(e.getMessage(), e);
	    }
		
		return retAsh;
	}
	
	public static boolean isCertificatoPresente(String idCertificato, ArrayList<Ace> attestatoList) {
		boolean isPresente = false;

		if (idCertificato != null && idCertificato != null) {
			for (Ace ace : attestatoList) {

				if (idCertificato.equals(ace.getCodice())) {
					isPresente = true;
				}
			}
		}

		return isPresente;
	}

	public static String raddoppiaApici(String value)
	{
		String ret = null;
		
		if (value != null)
		{
			ret = value.replace("'", "''");
		}
		
		return ret;
	}

	public static String getDescById(Integer id, ArrayList<Decodifica> elenco)
	{
		String ret = null;
		
		if (elenco != null)
		{
			for (Decodifica decodifica : elenco) {
				if (decodifica.getId().equalsIgnoreCase(GenericUtil.convertToString(id)))
				{
					ret = decodifica.getDescr();
				}
			}
		}
		
		return ret;
	}
	

}