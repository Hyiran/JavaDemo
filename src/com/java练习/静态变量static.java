package com.java练习;

import java.text.SimpleDateFormat;
import java.util.Date;

import mx4j.tools.config.DefaultConfigurationBuilder.New;

/**
 * 静态变量是类拥有的，非对象拥有，内存中有专门的静态区来存储
 * 非静态变量是对象拥有，每个对象有会有一个副本
 * @author libingxian
 */

public class 静态变量static {
	
	
	static String a = "10"; // 这是静态变量
	String b = "10"; // 这是非静态变量
	
	public static String getDate(){
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     return formatter.format(new Date()).toString();
	}
	
	public static void changea(){ 
		a = "1"; // 改变静态变量的值，a会作用于整个类
	}
	
	public void changeb(){
		b = "1"; // 改变非静态变量的值，b只会作用于本函数内
	}
	
	public static void main(String[] args) throws InterruptedException {
		静态变量static.changea();
		System.out.println(静态变量static.a);
		
		new 静态变量static().changeb();
		System.out.println(new 静态变量static().b);
		
		String a = 静态变量static.getDate();
		System.out.println(a);
		Thread.sleep(10000);
		String b = a;
		System.out.println(b);
		
	}
}
