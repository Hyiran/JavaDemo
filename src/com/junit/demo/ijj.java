package com.junit.demo;

import org.omg.CORBA.PUBLIC_MEMBER;

public class ijj {
	public static void main(String args[]){
		A a= new A();  // 第一步，初始化A，跳到对应的类 class A里面
	}
}

class AA{
	
	public AA(){
		System.out.println("1");
	}
	
	public static B b2 = new B("2");
	private B b1 = new B("3"); // 私有的类不能被继承，所以不会执行
	static {
			B b3 = new B("4");
		}
}

class A extends AA{ // 第二步，因为A 继承AA，所以又跳到AA里面
	
	private static B b3 = C.b; 
	private B b5 = fun();
	private static B b4 = new C().b2;
	private B b1 = new B("5");
	private static B b2 = new B("6");
	public static B fun(){
		return new B("11");
	}
	
	public A(){
		System.out.println("7");
	}
	
}

class B{
	public B(String str){
		System.out.println(str);
	}
}


class C{
	
	public static B b = new B("8");
	public B b2 = new B("10");
	static   
	{
		B b1 = new B("9");
	}
}
