package com.java练习;

import mx4j.tools.config.DefaultConfigurationBuilder.New;

import com.allure.demo.aaa;

/*
 对于String a = new String("abc")
 先说一说在内存中存储的情况，String 的引用 a 是存储于栈内存中，它开辟了一个空间用于存储  new String("abc") 在堆内存中开辟的空间的首地址
 
1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；
　如果作用于引用类型的变量，则比较的是所指向的对象的地址

2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量
　如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
　诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
@author libingxian
 
 */
public class 两个比较方法区别 {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 基本类型只有==这个比较方法，用于比较两个基本类型的值
		int i = 10;
		int j = 10;
		System.out.println(i==j);
		
		// 引用类型可以使用== 和 equals 来比较
		
		// 引用类型用==来进行比较的时候，比较的是引用对象的地址，两个对象是否一样
		Object o1 = new Object();
		Object o2 = new Object();
		
		System.out.println(o1==o2);
		
		String a = new String("abc");
		String b = new String("abc");
		String c = new String("abc");
		a = c;
		b = c;
		System.out.println(a==b);
		
		// equals 只能作用于引用变量，用于比较引用对象，其中String 、double等对其进行了重写，用于比较值
		System.out.println(o1.equals(o2)); // 没有重写，比较引用对象，所以是false
		System.out.println("abc".equals("abc"));// 重写了equlas，比较值，所以是true
		
		
	}
}
