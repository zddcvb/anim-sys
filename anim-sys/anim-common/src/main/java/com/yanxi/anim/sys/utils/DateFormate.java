package com.yanxi.anim.sys.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 日期格式化
 * @author 邹丹丹
 *
 */
public class DateFormate {
	/**
	 * 格式化date，返回date对象
	 * @param date
	 * @return
	 */
	public static Date formateDate(Date date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String formatDate = format.format(date);
		try {
			return format.parse(formatDate);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * 格式化date，返回string對象
	 * @param date
	 * @return
	 */
	public static String formateDateToString(Date date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	/**
	 * 格式化日期，将字符串日期转成date对象
	 * @param date
	 * @return
	 */
	public static Date formateDate(String date){
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
}
