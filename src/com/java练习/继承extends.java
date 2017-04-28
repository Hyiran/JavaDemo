package com.java练习;

import java.util.jar.Attributes.Name;

import org.omg.CORBA.PUBLIC_MEMBER;
/***
 * 
 * 
 * @author libingxian
 *
 */
class A{
	
	public static String name = "A"; // 公开的类可以被继承
	private int age = 23; // 私有的类不可以被继承
	
	public A(){ // 当子类没有构造方法时，
		System.out.println("a");
	}
}

public class 继承extends extends A{
	public 继承extends{
		super(继承extends);
	}
	
	public static void main(String args[]){
		System.out.println("aaa");
	}
}
