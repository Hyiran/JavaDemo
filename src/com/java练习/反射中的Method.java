package com.java��ϰ;

import java.lang.reflect.*;

public class �����е�Method {

	public static String getTraceInfo() {
		StringBuffer sb = new StringBuffer();

		StackTraceElement[] stacks = new Throwable().getStackTrace();
		int stacksLen = stacks.length;
		sb.append("class: ").append(stacks[1].getClassName())
				.append("; method: ").append(stacks[1].getMethodName())
				.append("; number: ").append(stacks[1].getLineNumber());

		return sb.toString();
	}

	String _methodName = new Exception().getStackTrace()[1].getMethodName();// ��õ����ߵķ�����

	String _thisMethodName = new Exception().getStackTrace()[0].getMethodName();// ��õ�ǰ�ķ�����

	// �����еĹ����У��������һ������ķ���
	public static void test() throws Exception {
		Class clz = Class.forName("com.java��ϰ.Test");
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
