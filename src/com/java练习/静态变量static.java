package com.java��ϰ;

import java.text.SimpleDateFormat;
import java.util.Date;

import mx4j.tools.config.DefaultConfigurationBuilder.New;

/**
 * ��̬��������ӵ�еģ��Ƕ���ӵ�У��ڴ�����ר�ŵľ�̬�����洢
 * �Ǿ�̬�����Ƕ���ӵ�У�ÿ�������л���һ������
 * @author libingxian
 */

public class ��̬����static {
	
	
	static String a = "10"; // ���Ǿ�̬����
	String b = "10"; // ���ǷǾ�̬����
	
	public static String getDate(){
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     return formatter.format(new Date()).toString();
	}
	
	public static void changea(){ 
		a = "1"; // �ı侲̬������ֵ��a��������������
	}
	
	public void changeb(){
		b = "1"; // �ı�Ǿ�̬������ֵ��bֻ�������ڱ�������
	}
	
	public static void main(String[] args) throws InterruptedException {
		��̬����static.changea();
		System.out.println(��̬����static.a);
		
		new ��̬����static().changeb();
		System.out.println(new ��̬����static().b);
		
		String a = ��̬����static.getDate();
		System.out.println(a);
		Thread.sleep(10000);
		String b = a;
		System.out.println(b);
		
	}
}
