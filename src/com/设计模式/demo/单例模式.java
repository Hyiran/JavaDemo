package com.设计模式.demo;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.dsa512;

/***
 * 单例模式，指的是类的实例对象在内存中永远保持只有一个，这样做的好处是避免不一致状态，比如打印机打印文件接口，同一台打印机同一时间只能打印一个文件
 * 有三个特性：
 * 1、构建方法私有化
 * 2、定义私有的静态类引用变量，并且初始化
 * 3、通过静态的方法对外提供类实例对象
 * @author libingxian
 *
 */
public class 单例模式 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		danli dl = danli.getInsitance("asdfasdf");
		dl.print("adsfasdf");
		long lo;
		danli dl2 = danli.getInsitance("asdfasdf");;
		dl2.print("asdfasdf");
		
		System.out.println(dl == dl2);
		
		danli2.getInsitance("asdfasdf");
		
	}
	

}

class danli{
	
	// 构造方法私有化
	private danli(String demo){
		
	}
	
	void print(String demo) {
		System.out.println(demo);
	}
	
	// 定义一个私有的空的静态类对象 --懒汉式单例，线程不安全
	private static danli dl = null;
	
	// 定义一个静态的对外提供对象的方法
	public static danli getInsitance(String demo){
		if (dl == null){
			System.out.println(demo);
			dl = new danli(demo);
		}
		return dl;
	}
	
}

class danli2{
	
	// 构造方法私有化
	private danli2(String demo){
		
	}
	
	void print(String demo) {
		System.out.println(demo);
	}
	
	// 定义一个私有的已经初始化好的静态类对象 --饿汉式单例，线程安全，已经分配好内存空间
	private static danli2 dl = new danli2("demo");
	
	// 定义一个静态的对外提供对象的方法
	public static danli2 getInsitance(String demo){
		return dl;
	}
	
}
