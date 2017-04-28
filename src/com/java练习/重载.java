package com.java练习;

/***
 * 
 * @author libingxian
 * 重构：对代码优化
 * 重载 Overloading：发生在同一个类中，函数名一样，参数个数/参数类型不一样
 * 重写 Overriding：发生在子类继承父类中，子类中有一个方法名，参数列表和返回值类型与父类相同的方法完全相同,子类的对象使用这个方法时，将调用子类中的定义，对它而言，父类中的定义如同被"屏蔽"了
 */
public class 重载 {
	
	public String func1(String a,String b){
		return a + b;
	}
	
	public String func1(String a,String b,String c){
		return a + b + c;
	}
}

class test extends 重载{
	
	public String func1(String a,String b){
		return String.valueOf(a);
	}
	
	
	
}
