package com.ʵ��demo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ��ʽ������ {
	public static String getDateString(String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(new Date());
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(��ʽ������.getDateString("yyyy-MM-dd HH:mm:ss"));
	}

}
