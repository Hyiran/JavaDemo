package com.java练习;

import org.apache.commons.exec.launcher.Java13CommandLauncher;

/*
 * java中有八中基本类型，基本类型的值直接是以2进制的形式存在于栈内存中，长度是定长的，所以叫基本类型
 * 浮点数类型：float（4个字节）、double（8个字节）
 * 整型类型：byte（1个字节）、short（2个字节）、int（4个字节）、long（8个字节）
 * 布尔类型：boolean（只有true 和 false 两个值）
 * 字符型：char（2个字节）
 * @author libingxian
 *
 */
public class 八种基本类型 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 浮点数
		float f1 = 18.2f;
		double f2 = 1/3;
		
		// 整型
		byte by = 56; // 2**
		short sh = 132;
		int in = 213231312;
		
		System.out.println(by);
	}

}
