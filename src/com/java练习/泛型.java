package com.java��ϰ;

import java.awt.List;
import java.util.ArrayList;

// ���ڷ��ͻ����Ǻ���⣬����
public class ���� {
	
	public void test(){
		/*
		 * ������ ���б��д�����ַ����͡�int���͵ȸ�����������ʱ�������ȡ����ʱ�����ǿ������ת��������Ϊ�޷�ǿ��ת��������
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
		// li.add(10);// ������
		
		for (String tmp : li) {
			String name = tmp;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// ʹ�÷�����
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



