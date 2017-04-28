package com.testng.demo;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/***
 * 
 * @author libingxian 
 * ����ϰ��Ҫ��ʹ��testng�ṩ��DataProvider��ǹ���,����ͬһ������β���
 * 1��ʹ�ö�ά������Ϊ���������ÿһ����Ԫ��Ϊ������� 
 * 2��ʹ�õ�������Ϊ���������ÿһ��������Ϊ�������
 */

public class DataProviderDemo {

	@DataProvider
	public Object[][] providerMethod(Method method) {
		Object[][] result = null;
		if (method.getName().equals("testmethod1")) {
			result = new Object[][] { { 1 } };
		} else if (method.getName().equals("testmethod2")) {
			result = new Object[][] { { "1", 2 }, { "2", 2 }, { "3", 3 } };
		} else {
			result = new Object[][] { { 3 } };
		}
		return result;
	}

	@DataProvider(name = "DataSource")
	public Iterator<Object[]> providerString() {
		List<Object> item = new ArrayList<Object>();
		for (int i = 0; i < 5; i++) {
			item.add(String.valueOf(i));
		}

		List<Object[]> users = new ArrayList<Object[]>();
		for (Object u : item) {
			users.add(new Object[] { u });
		}
		return users.iterator();
	}

	@Test(dataProvider = "providerMethod") // ֱ��ʹ�÷�������Ϊ����Դ
	public void testmethod1(int param) {
		System.out.println("method1 received:" + param);
	}

	@Test(dataProvider = "providerMethod2",dataProviderClass=data.class)
	public void testmethod2(String param1, int param2) {
		System.out.println("method2 received:" + param1 + param2);
	}

	@Test(dataProvider = "DataSource") // ʹ��nameֵ����Ϊ������
	public void testmethod3(String param) {
		System.out.println("method3 received:" + param);
	}
}

class data{
	
	@DataProvider
	public static Object[][] providerMethod2(Method method) {
		Object[][] result = null;
		if (method.getName().equals("testmethod1")) {
			result = new Object[][] { { 1 } };
		} else if (method.getName().equals("testmethod2")) {
			result = new Object[][] { { "1", 2 }, { "2", 2 }, { "3", 3 } };
		} else {
			result = new Object[][] { { 3 } };
		}
		return result;
	}
}
