package com.tianan.kltsp.dc.biz.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 日期处理工具类
 * 
 */
public class DateUtils {

	/**
	 * 默认日期格式
	 */
	// public static final SimpleDateFormat default_date_df = new
	// SimpleDateFormat("yyyy-MM-dd");

	/**
	 * 默认时间格式
	 */
	// public static final SimpleDateFormat default_time_df = new
	// SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/**
	 * 无分隔符时间格式
	 */
	// public static final SimpleDateFormat unsign_date_df = new
	// SimpleDateFormat("yyyyMMdd");

	/**
	 * 无分隔符时间格式
	 */
	// public static final SimpleDateFormat unsign_time_df = new
	// SimpleDateFormat("yyyyMMddHHmmss");

	private static final String default_date_df = "yyyy-MM-dd";

	private static final String default_time_df = "yyyy-MM-dd HH:mm:ss";

	private static final String unsign_date_df = "yyyyMMdd";

	private static final String unsign_time_df = "yyyyMMddHHmmss";

	private static Map<String, ThreadLocal<SimpleDateFormat>> dateFormatMap = new HashMap<String, ThreadLocal<SimpleDateFormat>>();

	/**
	 * 使用ThreadLocal以空间换时间解决SimpleDateFormat线程安全问题 第一次调用get将返回null
	 * 故需要初始化一个SimpleDateFormat，并set到threadLocal中
	 * 
	 * @return
	 */
	public static SimpleDateFormat getDateFormat(final String pattern) {
		ThreadLocal<SimpleDateFormat> threadLocal = dateFormatMap.get(pattern);
		if (threadLocal == null) {
			threadLocal = new ThreadLocal<SimpleDateFormat>() {
				@Override
				protected SimpleDateFormat initialValue() {
					return new SimpleDateFormat(pattern);
				}
			};
			dateFormatMap.put(pattern, threadLocal);
		}
		return threadLocal.get();
	}

	/**
	 * 取当前日期字符串 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String defaultCurrentDate() {
		return DateUtils.defaultCurrentDate(false);
	}

	/**
	 * 
	 * @param unsign
	 *            是否有分隔符
	 * @return
	 */
	public static String defaultCurrentDate(boolean unsign) {
		String str = null;
		Date now = Calendar.getInstance().getTime();
		if (unsign) {
			str = DateUtils.getDateFormat(unsign_date_df).format(now);
		} else {
			str = DateUtils.getDateFormat(default_date_df).format(now);
		}

		return str;
	}

	/**
	 * 取当前日期字符串 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String defaultYesterdayDate() {
		return DateUtils.defaultYesterdayDate(false);
	}

	/**
	 * 
	 * @param unsign
	 *            是否有分隔符
	 * @return
	 */
	public static String defaultYesterdayDate(boolean unsign) {
		String str = null;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		Date yesterday = cal.getTime();
		if (unsign) {
			str = DateUtils.getDateFormat(unsign_date_df).format(yesterday);
		} else {
			str = DateUtils.getDateFormat(default_date_df).format(yesterday);
		}

		return str;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String defaultCurrentTime() {
		return DateUtils.defaultCurrentTime(false);
	}

	/**
	 * 取当前时间字符串
	 * 
	 * @param unsign
	 *            是否有分隔符
	 * @return
	 */
	public static String defaultCurrentTime(boolean unsign) {
		String str = null;
		Date now = Calendar.getInstance().getTime();
		if (unsign) {
			str = DateUtils.getDateFormat(unsign_time_df).format(now);
		} else {
			str = DateUtils.getDateFormat(default_time_df).format(now);
		}

		return str;
	}

	/**
	 * 取当前日期字符串yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String defaultYesterdayTime() {
		return DateUtils.defaultYesterdayTime(false);
	}

	/**
	 * 
	 * @param unsign
	 *            是否有分隔符
	 * @return
	 */
	public static String defaultYesterdayTime(boolean unsign) {
		String str = null;
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DATE, cal.get(Calendar.DATE) - 1);
		Date yesterday = cal.getTime();
		if (unsign) {
			str = DateUtils.getDateFormat(unsign_time_df).format(yesterday);
		} else {
			str = DateUtils.getDateFormat(default_time_df).format(yesterday);
		}

		return str;
	}

	/**
	 * 将日期按照一个格式转换为另一个格式的字符串
	 * 
	 * @param str
	 * @param from
	 *            原始的时间格式
	 * @param to
	 *            转换后的时间格式
	 * @return
	 */
	public static String transformat(String str, String from, String to) {

		DateFormat fromDateFormat = DateUtils.getDateFormat(from);
		Date date = null;
		try {
			date = fromDateFormat.parse(str);
		} catch (Exception e) {
			throw new RuntimeException("时间转换异常:str=" + str + ", from=" + from);
		}

		DateFormat toDateFormat = DateUtils.getDateFormat(to);

		return toDateFormat.format(date);
	}

	/**
	 * 取当前日期字符串 yyyy-MM-dd
	 * 
	 * @return
	 */
	public static String defaultFormatDate(Date date) {
		return DateUtils.defaultFormatDate(date, false);
	}

	/**
	 * 
	 * @param unsign
	 *            是否有分隔符
	 * @return
	 */
	public static String defaultFormatDate(Date date, boolean unsign) {
		String str = null;
		if (unsign) {
			str = DateUtils.getDateFormat(unsign_date_df).format(date);
		} else {
			str = DateUtils.getDateFormat(default_date_df).format(date);
		}

		return str;
	}

	/**
	 * yyyy-MM-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String defaultFormatTime(Date date) {
		return DateUtils.defaultFormatTime(date, false);
	}

	/**
	 * 取当前时间字符串
	 * 
	 * @param unsign
	 *            是否有分隔符
	 * @return
	 */
	public static String defaultFormatTime(Date date, boolean unsign) {
		String str = null;
		if (unsign) {
			str = DateUtils.getDateFormat(unsign_time_df).format(date);
		} else {
			str = DateUtils.getDateFormat(default_time_df).format(date);
		}

		return str;
	}

	public static Date defualtParseDate(String str) {
		return DateUtils.defualtParseDate(str, false);
	}

	public static Date defualtParseDate(String str, boolean unsign) {
		Date date = null;

		SimpleDateFormat tmp = null;
		try {
			if (unsign) {
				tmp = DateUtils.getDateFormat(unsign_date_df);
			} else {
				tmp = DateUtils.getDateFormat(default_date_df);
			}
			date = tmp.parse(str);
		} catch (Exception e) {
			throw new RuntimeException("日期转换异常:str=" + str + ", format=" + tmp.toPattern());
		}

		return date;
	}

	public static Date defualtParseTime(String str) {
		return DateUtils.defualtParseTime(str, false);
	}

	public static Date defualtParseTime(String str, boolean unsign) {
		Date date = null;

		SimpleDateFormat tmp = null;
		try {
			if (unsign) {
				tmp = DateUtils.getDateFormat(unsign_time_df);
			} else {
				tmp = DateUtils.getDateFormat(default_time_df);
			}
			date = tmp.parse(str);
		} catch (Exception e) {
			throw new RuntimeException("时间转换异常:str=" + str + ", format=" + tmp.toPattern());
		}

		return date;
	}

	/**
	 * 字符串转日期
	 * 
	 * @param str
	 *            字符串
	 * @param format
	 *            格式
	 * @return 日期
	 */
	public static Date parse(String str, String format) {
		Date date = null;

		SimpleDateFormat tmp = DateUtils.getDateFormat(format);
		try {
			date = tmp.parse(str);
		} catch (Exception e) {
			throw new RuntimeException("时间转换异常:str=" + str + ", format=" + tmp.toPattern());
		}

		return date;
	}

	/**
	 * 日期转字符串
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            格式
	 * @return 日期字符串
	 */
	public static String format(Date date, String format) {
		if(date==null){
			return null;
		}
		String str = null;

		SimpleDateFormat tmp = DateUtils.getDateFormat(format);
		try {
			str = tmp.format(date);
		} catch (Exception e) {
			throw new RuntimeException("时间格式化异常:date=" + date + ", format=" + tmp.toPattern());
		}

		return str;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Calendar smdate, Calendar bdate) {
		long time1 = smdate.getTimeInMillis();
		long time2 = bdate.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算两个日期之间相差的天数
	 *
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) {
		long time1 = smdate.getTime();
		long time2 = bdate.getTime();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 *
	 *
	 * @param dateStr
	 * @param fromFormat
	 *            原始的时间格式
	 * @param toFormat
	 *            转换后的时间格式
	 * @return
	 */
	public static String formatDate(String dateStr, String fromFormat, String toFormat) {

		DateFormat fromDateFormat = new SimpleDateFormat(fromFormat);
		Date date = null;
		try {
			date = fromDateFormat.parse(dateStr);
		} catch (Exception e) {
			throw new RuntimeException("时间转换异常:dateStr=" + dateStr + ", fromFormat=" + fromFormat);
		}

		DateFormat toDateFormat = new SimpleDateFormat(toFormat);

		return toDateFormat.format(date);
	}

	/***
	 * 根据日期 置为0点 开始生效时间 2015-05-05 00:00:00 000
	 * 
	 * @param date
	 * @return
	 */
	public static Date dateResetZero(Date date) {
		Date rDate = org.apache.commons.lang.time.DateUtils.setHours(date, 0);
		rDate = org.apache.commons.lang.time.DateUtils.setMinutes(rDate, 0);
		rDate = org.apache.commons.lang.time.DateUtils.setSeconds(rDate, 0);
		rDate = org.apache.commons.lang.time.DateUtils.setMilliseconds(rDate, 0);
		return rDate;
	}

	/*
	 * 根据日期 置为23点 开始生效时间 2015-05-05 23:59:59 999
	 * 
	 * @param date
	 * 
	 * @return
	 */
	public static Date dateReset23(Date date) {
		Date rDate = org.apache.commons.lang.time.DateUtils.setHours(date, 23);
		rDate = org.apache.commons.lang.time.DateUtils.setMinutes(rDate, 59);
		rDate = org.apache.commons.lang.time.DateUtils.setSeconds(rDate, 59);
		rDate = org.apache.commons.lang.time.DateUtils.setMilliseconds(rDate, 999);
		return rDate;
	}

	/* 根据data取指定天数的日期 add by linkun */
	public static Date addDays(Date date, int amount) {
		return addDay(date, Calendar.DAY_OF_MONTH, amount);
	}

	public static Date addMins(Date date, int amount) {
		return addDay(date, Calendar.MINUTE, amount);
	}

	public static Date addDay(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	public static Date firstDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		return c.getTime();
	}

	public static Date endDayOfMonth(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));// 设置为1号,当前日期既为本月第一天
		return c.getTime();
	}

	public static void main(String[] args) {
		// Date first = firstDayOfMonth(new Date());
		// Date end = endDayOfMonth(new Date());
		// System.out.println(defaultFormatTime(first));
		// System.out.println(defaultFormatTime(end));

		Date now = new Date();
		System.out.println(now);
		System.out.println(addDay(now, Calendar.SECOND, 5));
		int i = new Random().nextInt(300);
		System.out.println(i);
		System.out.println(addDay(now, Calendar.SECOND, i));
	}
}
