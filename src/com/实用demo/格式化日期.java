package com.实用demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class 格式化日期 {
	public static String getDateString(String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(new Date());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(格式化日期.getDateString("yyyy-MM-dd HH:mm:ss"));
	}

}
