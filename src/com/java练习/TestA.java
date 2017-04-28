package com.javaÁ·Ï°;

public class TestA {
	
	public int asser(int i) {
		System.out.println("asser:"+ i);
		return i;
	}
	
	public void test(int i,int j) {
		if(i > 10 & asser(j)==10){
			System.out.println("test£º" + i+j);
		}
	}
		
	public static void main(String[] args) throws Exception{
		Class<?> ai = TestA.class;
		TestA a = (TestA) ai.newInstance();
		a.test(1,11);
	}
}
