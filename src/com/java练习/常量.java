package com.java练习;

public class 常量 {
	static final int TYPE = 0;
	public static void main(String args[]) {
		常量.TYPE = 1; //常量不可以被修改
	}
}

class test2 extends 常量{
	
	public static void main(String args[]) {
		System.out.println(常量.TYPE);
		System.out.println(test2.TYPE); // 常量可以被继承
	}
	

}

