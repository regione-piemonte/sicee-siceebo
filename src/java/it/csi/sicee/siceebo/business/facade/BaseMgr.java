/*******************************************************************************
 * SPDX-License-Identifier: EUPL-1.2
 * Copyright Regione Piemonte - 2020
 *******************************************************************************/
/*
 * 
 */
package it.csi.sicee.siceebo.business.facade;

import it.csi.sicee.siceebo.business.BEException;
import it.csi.sicee.siceebo.dto.type.UDTDateValid;
import it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFive;
import it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleFour;
import it.csi.sicee.siceebo.dto.type.UDTPositiveDoubleTwo;
import it.csi.sicee.siceebo.dto.type.UDTPositiveInteger;
import it.csi.sicee.siceebo.util.Constants;

import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * The Class BaseMgr.
 */
public class BaseMgr {
	
	/** The log. */
	protected static Logger log = Logger.getLogger(Constants.APPLICATION_CODE
			+ ".business");

	/** The Constant ONE_YEAR_MILLIS. */
	public static final long ONE_YEAR_MILLIS = 1000 * 60 * 60 * 24 * 365;

	/** The Constant TIPO_CURRICULUM_VITAE. */
	static final Integer TIPO_CURRICULUM_VITAE = Integer.valueOf(1);

	/**
	 * Adds the one year.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	protected static String addOneYear(String base) throws BEException {
		java.util.Date dt_base = convertToDate(base);
		Calendar cal_base = Calendar.getInstance();
		cal_base.setTime(dt_base);
		cal_base.add(Calendar.YEAR, 1);
		java.util.Date dt_after = cal_base.getTime();
		return convertToString(dt_after);
	}

	/**
	 * Adds the one day.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	protected static String addOneDay(String base) throws BEException {
		java.util.Date dt_base = convertToDate(base);
		Calendar cal_base = Calendar.getInstance();
		cal_base.setTime(dt_base);
		cal_base.add(Calendar.DAY_OF_YEAR, 1);
		java.util.Date dt_after = cal_base.getTime();
		return convertToString(dt_after);
	}

	/*
	 * protected static boolean diffDate(String date1, String date2) throws
	 * BEException { java.util.Date dt_base1 = convertToDate(date1);
	 * java.util.Date dt_base2 = convertToDate(date2);
	 * 
	 * if (dt_base2 == null) { return false; }
	 * 
	 * Calendar cal_base1 = Calendar.getInstance(); cal_base1.setTime(dt_base1);
	 * 
	 * Calendar cal_base2 = Calendar.getInstance(); cal_base2.setTime(dt_base2);
	 * 
	 * // Get date in milliseconds long milisecond1 =
	 * cal_base1.getTimeInMillis(); long milisecond2 =
	 * cal_base2.getTimeInMillis();
	 * 
	 * // Find date difference in milliseconds long diffInMSec = milisecond2 -
	 * milisecond1;
	 * 
	 * // Find date difference in days // (24 hours 60 minutes 60 seconds 1000
	 * millisecond) long diffOfDays = diffInMSec / (24 * 60 * 60 * 1000);
	 * 
	 * return (diffOfDays >= 0 && diffOfDays <= Constants.NUMBER_OF_DAYS) ? true
	 * : false; }
	 */

	/**
	 * Correct crono date.
	 *
	 * @param date1 the date1
	 * @param date2 the date2
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public static boolean correctCronoDate(UDTDateValid date1,
			UDTDateValid date2) throws BEException {
		java.util.Date dt_base1 = convertToDate(date1);
		java.util.Date dt_base2 = convertToDate(date2);

		if (dt_base1 == null && dt_base2 == null) {
			return true;
		}

		Calendar cal_base1 = Calendar.getInstance();
		cal_base1.setTime(dt_base1);

		Calendar cal_base2 = Calendar.getInstance();
		cal_base2.setTime(dt_base2);

		// Get date in milliseconds
		long milisecond1 = cal_base1.getTimeInMillis();
		long milisecond2 = cal_base2.getTimeInMillis();

		// Find date difference in milliseconds
		long diffInMSec = milisecond2 - milisecond1;

		return (diffInMSec >= 0) ? true : false;
	}

	/**
	 * Correct seq double four.
	 *
	 * @param doubleFour1 the double four1
	 * @param doubleFour2 the double four2
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public static boolean correctSeqDoubleFour(
			UDTPositiveDoubleFour doubleFour1, UDTPositiveDoubleFour doubleFour2)
			throws BEException {
		Double df_base1 = convertTo(doubleFour1);
		Double df_base2 = convertTo(doubleFour2);

		if (df_base1 == null && df_base2 == null) {
			return true;
		}

		if ((df_base1 != null && df_base2 == null)
				|| (df_base1 == null && df_base2 != null)) {
			return true;
		}

		return (df_base2 >= df_base1) ? true : false;
	}

	/**
	 * Correct seq double five.
	 *
	 * @param doubleFive1 the double five1
	 * @param doubleFive2 the double five2
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public static boolean correctSeqDoubleFive(
			UDTPositiveDoubleFive doubleFive1, UDTPositiveDoubleFive doubleFive2)
			throws BEException {
		Double df_base1 = convertTo(doubleFive1);
		Double df_base2 = convertTo(doubleFive2);

		if (df_base1 == null && df_base2 == null) {
			return true;
		}

		if ((df_base1 != null && df_base2 == null)
				|| (df_base1 == null && df_base2 != null)) {
			return true;
		}

		return (df_base2 >= df_base1) ? true : false;
	}

	/**
	 * Correct crono anni.
	 *
	 * @param anno1 the anno1
	 * @param anno2 the anno2
	 * @return true, if successful
	 * @throws BEException the bE exception
	 */
	public static boolean correctCronoAnni(String anno1, String anno2)
			throws BEException {
		Integer an_base1 = convertToInteger(anno1);
		Integer an_base2 = convertToInteger(anno2);

		if (an_base1 == null && an_base2 == null) {
			return true;
		}

		return (an_base2 >= an_base1) ? true : false;

	}

	/**
	 * Adds the ten year.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	protected String addTenYear(String base) throws BEException {
		if (!isNullOrEmpty(base)) {
			java.util.Date dt_base = convertToDate(base);
			Calendar cal_base = Calendar.getInstance();
			cal_base.setTime(dt_base);
			cal_base.add(Calendar.YEAR, 10);
			java.util.Date dt_after = cal_base.getTime();
			return convertToString(dt_after);
		} else {
			return null;
		}
	}

	/**
	 * Adds the ten year.
	 *
	 * @param base the base
	 * @return the string
	 * @throws BEException the bE exception
	 */
	protected String addTenYear(UDTDateValid base) throws BEException {
		if (!isNullOrEmpty(base)) {
			java.util.Date dt_base = convertToDate(base);
			Calendar cal_base = Calendar.getInstance();
			cal_base.setTime(dt_base);
			cal_base.add(Calendar.YEAR, 10);
			java.util.Date dt_after = cal_base.getTime();
			return convertToString(dt_after);
		} else {
			return null;
		}
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
		} else {
			return null;
		}
	}

	/**
	 * Convert to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	public static String convertToString(UDTDateValid dt) {
		if (dt != null) {
			return dt.getValue();
		} else {
			return null;
		}
	}

	/**
	 * Gets the anno from udt date valid.
	 *
	 * @param dt the dt
	 * @return the anno from udt date valid
	 */
	public static String getAnnoFromUDTDateValid(UDTDateValid dt) {
		String res = null;
		if (!isNullOrEmpty(dt)) {
			res = convertToString(dt).substring(6);
		}

		return res;
	}

	/**
	 * Convert to udt date valid.
	 *
	 * @param dt the dt
	 * @return the uDT date valid
	 */
	public static UDTDateValid convertToUDTDateValid(java.util.Date dt) {
		if (dt != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			UDTDateValid udt = new UDTDateValid();
			udt.setValue(sdf.format(dt));
			return udt;
		} else {
			return null;
		}
	}

	/**
	 * Convert to date.
	 *
	 * @param s the s
	 * @return the java.util. date
	 * @throws BEException the bE exception
	 */
	public static java.util.Date convertToDate(String s) throws BEException {
		if (s != null && s.length() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return sdf.parse(s);
			} catch (ParseException e) {
				throw new BEException("Errore nella parsificazioen della data "
						+ s, e);
			}
		} else {
			return null;
		}
	}

	/**
	 * Convert to date.
	 *
	 * @param s the s
	 * @return the java.util. date
	 * @throws BEException the bE exception
	 */
	public static java.util.Date convertToDate(UDTDateValid s)
			throws BEException {
		if (s != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				return sdf.parse(s.getValue());
			} catch (ParseException e) {
				throw new BEException("Errore nella parsificazioen della data "
						+ s, e);
			}
		} else {
			return null;
		}
	}

	/**
	 * Convert to date from xml.
	 *
	 * @param s the s
	 * @return the java.util. date
	 * @throws BEException the bE exception
	 */
	public static java.util.Date convertToDateFromXml(String s)
			throws BEException {
		if (s != null && s.length() > 0) {
			try {
				return convertToDate(s);
			} catch (BEException e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				try {
					return sdf.parse(s);
				} catch (ParseException ex) {
					throw new BEException(
							"Errore nella parsificazione della data " + s, ex);
				}
			}
		} else {
			return null;
		}
	}

	/**
	 * Convert to timestamp.
	 *
	 * @param s the s
	 * @return the java.sql. timestamp
	 * @throws BEException the bE exception
	 */
	public static java.sql.Timestamp convertToTimestamp(String s)
			throws BEException {
		Timestamp time = null;
		if (s != null && s.length() > 0) {
			time = new Timestamp(new Long(s));
		}

		return time;
	}

	/**
	 * Convert to timestamp.
	 *
	 * @param s the s
	 * @return the java.sql. timestamp
	 * @throws BEException the bE exception
	 */
	public static java.sql.Timestamp convertToTimestamp(Date s)
			throws BEException {
		Timestamp time = null;
		if (s != null) {
			time = new Timestamp(s.getTime());
		}

		return time;
	}

	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	protected String convertToString(Boolean i) {
		if (i == null) {
			return null;
		} else {
			if (i) {
				return "S";
			} else {
				return "N";
			}
		}

	}

	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	protected String convertToString(Integer i) {
		if (i == null) {
			return null;
		} else {
			return Integer.toString(i);
		}
	}

	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	protected String convertToString(Long i) {
		if (i == null) {
			return null;
		} else {
			return Long.toString(i);
		}
	}

	/**
	 * Convert to string.
	 *
	 * @param i the i
	 * @return the string
	 */
	protected String convertToString(Double i) {
		if (i == null) {
			return null;
		} else {
			return parseNumberFive(i);
		}
	}

	/**
	 * Convert to integer.
	 *
	 * @param s the s
	 * @return the integer
	 */
	public static Integer convertToInteger(String s) {
		if (s == null || s.length() == 0) {
			return null;
		} else {
			try {
				return new Integer(Integer.parseInt(s));
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * Convert to double.
	 *
	 * @param s the s
	 * @return the double
	 */
	public Double convertToDouble(String s) {
		if (s == null || s.length() == 0) {
			return null;
		} else {
			try {
				return new Double(Double.parseDouble(s.replaceAll(",", ".")));
			} catch (Exception e) {
				log.debug("Stringa da convertire in Double: " + s);
				return null;
			}
		}
	}

	/**
	 * Convert to long.
	 *
	 * @param s the s
	 * @return the long
	 */
	public Long convertToLong(String s) {
		if (s == null || s.length() == 0) {
			return null;
		} else {
			try {
				return new Long(Long.parseLong(s));
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * Convert to boolean.
	 *
	 * @param s the s
	 * @return the boolean
	 */
	public Boolean convertToBoolean(String s) {
		if (s == null || s.length() == 0) {
			return null;
		} else {
			try {
				if (s.equalsIgnoreCase("s")) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return null;
			}
		}
	}

	/**
	 * Instantiates a new base mgr.
	 */
	public BaseMgr() {
		super();
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(String s) {
		return s == null || s.length() == 0;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param n the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveDoubleFour n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param n the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveDoubleFive n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param n the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTPositiveInteger n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param n the n
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(UDTDateValid n) {
		return n == null || n.getValue() == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Double s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Integer s) {
		return s == null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param s the s
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Long s) {
		return s == null;
	}

	/**
	 * Check valide number.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideNumber(String num) {
		if (!isNullOrEmpty(num)) {
			if (num.matches("^[+]?\\d*$")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/**
	 * Check valide telephone number.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideTelephoneNumber(String num) {
		return true;
	}

	/**
	 * Check valide email.
	 *
	 * @param email the email
	 * @return true, if successful
	 */
	public static boolean checkValideEmail(String email) {
		if (!isNullOrEmpty(email)) {
			if (email
					.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*([,;]\\s*\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*)*")) {
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/**
	 * Check valide double with five decimal numbers.
	 *
	 * @param num the num
	 * @return true, if successful
	 */
	public static boolean checkValideDoubleWithFiveDecimalNumbers(String num) {
		log.debug("Numero da validare: " + num);
		if (!isNullOrEmpty(num)) {
			if (num.matches("^(?=.*[0-9].*$)\\d{0,10}(?:\\,\\d{0,5})?$")) {
				log.debug("validato: " + num);
				return true;
			} else {
				return false;
			}
		}

		return false;
	}

	/**
	 * Parses the number for print.
	 *
	 * @param d the d
	 * @return the string
	 */
	protected String parseNumberForPrint(Double d) {
		String str = "";
		DecimalFormat df = new DecimalFormat("############.#####");
		if (d != null) {
			str = df.format(d);
		}

		return str;
	}

	/**
	 * Parses the number five.
	 *
	 * @param d the d
	 * @return the string
	 */
	protected String parseNumberFive(Double d) {
		String str = "";
		DecimalFormat df = new DecimalFormat("############.######");
		if (d != null) {
			str = df.format(d);
		}

		return str;
	}

	/**
	 * To upper case.
	 *
	 * @param str the str
	 * @return the string
	 */
	protected String toUpperCase(String str) {
		return (str != null) ? str.toUpperCase() : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the double
	 */
	public static Double convertTo(UDTPositiveDoubleFive num) {

		return (num != null) ? num.getValue() : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the double
	 */
	public static Double convertTo(UDTPositiveDoubleTwo num) {

		return (num != null) ? num.getValue() : null;
	}

	/**
	 * Convert to string.
	 *
	 * @param num the num
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
	 * @param num the num
	 * @return the string
	 */
	public static String convertToString(UDTPositiveDoubleTwo num) {
		java.util.Locale.setDefault(java.util.Locale.ITALY);
		java.text.DecimalFormat df = new java.text.DecimalFormat(
				"##########.##");
		return (num != null) ? df.format(num.getValue()) : null;
	}

	/**
	 * Converto to string.
	 *
	 * @param dt the dt
	 * @return the string
	 */
	protected String convertoToString(UDTDateValid dt) {
		if (dt != null) {
			return dt.getValue();
		}

		return null;
	}

	/**
	 * Convert to string.
	 *
	 * @param num the num
	 * @return the string
	 */
	public static String convertToString(UDTPositiveDoubleFour num) {
		java.util.Locale.setDefault(java.util.Locale.ITALY);
		java.text.DecimalFormat df = new java.text.DecimalFormat(
				"##########.####");

		return (num != null) ? df.format(num.getValue()) : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the integer
	 */
	protected Integer convertTo(UDTPositiveInteger num) {

		return (num != null) ? num.getValue() : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the double
	 */
	public static Double convertTo(UDTPositiveDoubleFour num) {

		return (num != null) ? num.getValue() : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the uDT positive double four
	 */
	protected UDTPositiveDoubleFour convertTo(Double num) {

		return (num != null) ? new UDTPositiveDoubleFour(num) : null;
	}

	/**
	 * Convert to double five.
	 *
	 * @param num the num
	 * @return the uDT positive double five
	 */
	protected UDTPositiveDoubleFive convertToDoubleFive(Double num) {

		return (num != null) ? new UDTPositiveDoubleFive(num) : null;
	}

	/**
	 * Convert to double two.
	 *
	 * @param num the num
	 * @return the uDT positive double two
	 */
	protected UDTPositiveDoubleTwo convertToDoubleTwo(Double num) {

		return (num != null) ? new UDTPositiveDoubleTwo(num) : null;
	}

	/**
	 * Convert to double four.
	 *
	 * @param num the num
	 * @return the uDT positive double four
	 */
	protected UDTPositiveDoubleFour convertToDoubleFour(Double num) {

		return (num != null) ? new UDTPositiveDoubleFour(num) : null;
	}

	/**
	 * Convert to.
	 *
	 * @param num the num
	 * @return the uDT positive integer
	 */
	protected UDTPositiveInteger convertTo(Integer num) {

		return (num != null) ? new UDTPositiveInteger(num) : null;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param list the list
	 * @return true, if is null or empty
	 */
	protected boolean isNullOrEmpty(List<?> list) {
		return (list != null) ? list.isEmpty() : false;
	}

	/**
	 * Checks if is null or empty.
	 *
	 * @param flag the flag
	 * @return true, if is null or empty
	 */
	public static boolean isNullOrEmpty(Boolean flag) {
		return (flag != null) ? false : true;
	}

	/**
	 * Gets the value not null.
	 *
	 * @param value the value
	 * @return the value not null
	 */
	public static Object getValueNotNull(Object value) {
		return (value != null) ? value : "";
	}

	/**
	 * Convert to string for report.
	 *
	 * @param obj the obj
	 * @return the string
	 */
	public String convertToStringForReport(Object obj) {
		if (obj != null) {
			String className = obj.getClass().getName();
			String valueForReport = String.valueOf(obj);
			if (className.indexOf("String") > 0) {
				return valueForReport;
			}

			if (valueForReport.indexOf(".") > 0) {
				valueForReport = valueForReport.replace(".", ",");
				if (valueForReport.endsWith(",0")) {
					valueForReport = valueForReport.substring(0,
							valueForReport.length() - 2);
				}
				return valueForReport;
			} else {
				return valueForReport;
			}
		} else {
			return "";
		}
	}
}