package com.java练习;

import java.awt.List;
import java.util.ArrayList;

// 对于泛型还不是很理解，，，
public class 泛型 {
	
	public void test(){
		/*
		 * 场景： 当列表中存放了字符类型、int类型等各种类型数据时，如果在取出的时候进行强制类型转换，会因为无法强制转换而报错
		 * */
		
		int a = 100;
		ArrayList li = new ArrayList();
		li.add("hello");
		li.add("dea");
		li.add(100);
		
		for (int i = 0; i < li.size(); i++) {
			String name = (String) li.get(i);
			int b = (int)li.get(0);
		}
	}
	
	public void test2(){
		ArrayList<String> li = new ArrayList<String>();
		li.add("a");
		li.add("b");
		// li.add(10);// 报错了
		
		for (String tmp : li) {
			String name = tmp;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// 使用泛型类
		Box<String> bs = new Box<String>("abc");
		Box<Integer> bs2 = new Box<Integer>(123);
	}

}

class Box<T>{
	private T t;
	
	public Box(T a){
		
	}
	
	public void setT(T a) {
		this.t = a;
	}
}



