package com.java练习;

import mx4j.tools.config.DefaultConfigurationBuilder.New;

/*
 * java实现多线程有两个方法，一个是继承Thread类，一个是实现Runnable接口
 * 1.继承Thread类，重写run方法，通过start启动
 * 2.实现Runnable接口，实现run方法，把类引用作为参数传递给new Thread(参数)，通过start进行启动
 * */
public class 多线程实现 {
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		thread1 th1 = new thread1();
		th1.start();
		
		thread2 th2 = new thread2();
		Thread thread  = new Thread(th2);
		thread.start();
		
	}

}

class thread1 extends Thread{
	
	@Override
	public void run(){
		for(int i=0;i< 100;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName());
		}
	}

}


class thread2 implements Runnable{
	
	@Override
	public void run(){
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("thread2");
		}
		
		
	}

}