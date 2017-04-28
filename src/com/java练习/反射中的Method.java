package com.java练习;

import java.lang.reflect.*;

public class 反射中的Method {

	public static String getTraceInfo() {
		StringBuffer sb = new StringBuffer();

		StackTraceElement[] stacks = new Throwable().getStackTrace();
		int stacksLen = stacks.length;
		sb.append("class: ").append(stacks[1].getClassName())
				.append("; method: ").append(stacks[1].getMethodName())
				.append("; number: ").append(stacks[1].getLineNumber());

		return sb.toString();
	}

	String _methodName = new Exception().getStackTrace()[1].getMethodName();// 获得调用者的方法名

	String _thisMethodName = new Exception().getStackTrace()[0].getMethodName();// 获得当前的方法名

	// 在运行的过程中，任意调用一个对象的方法
	public static void test() throws Exception {
		Class clz = Class.forName("com.java练习.Test");
		Test jdkobjec = (Test) clz.newInstance();
		Method[] mts = clz.getMethods();

		Method mt = clz.getMethod("doRun", new Class[] { String.class,
				String.class });
		System.out.println(jdkobjec.doRun("1", "2"));

	}

	public static void main(String args[]) throws Exception {
		test();

	}
}
