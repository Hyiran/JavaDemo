package com.java练习;

import org.junit.Assert;

/***
 * 变量的作用域主要分为四块，分别为类级变量、实例级变量、方法级变量、块级变量
 * 类级变量:又称为静态变量，是类所有的，通过类名访问，会分配内存空间
 * 实例变量：又称为对象变量，是对象所有的，通过对象访问，初始化对象时才会分配内存空间
 * 方法级变量：只作用于方法内
 * 块级变量：只作用于用大括号内
 * @author libingxian
 *
 */

public class 变量作用域 {

	static int age; // 这是一个类变量，通过类名来调用
	String name; // 这是一个实例变量，通过类的实例来调用
	
	{
		int j = 111;
	}
	
	public void setName(String name) {
		String aname = name; // 这是一个只作用于setName方法内的变量
		if(aname != null){
			int boo = 0;// 这是一个只作用于if块内的变量,必须要初始化后才能被访问
			Assert.assertEquals(boo, "asdfs");
		}
		this.name = aname;
	}
	
	public void getName() {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
