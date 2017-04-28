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
 * 本练习主要是使用testng提供的DataProvider标记功能,用于同一场景多次测试
 * 1、使用二维数组作为参数输出，每一个单元作为参数输出 
 * 2、使用迭代器作为参数输出，每一个迭代作为参数输出
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

	@Test(dataProvider = "providerMethod") // 直接使用方法名作为数据源
	public void testmethod1(int param) {
		System.out.println("method1 received:" + param);
	}

	@Test(dataProvider = "providerMethod2",dataProviderClass=data.class)
	public void testmethod2(String param1, int param2) {
		System.out.println("method2 received:" + param1 + param2);
	}

	@Test(dataProvider = "DataSource") // 使用name值来作为方法名
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
