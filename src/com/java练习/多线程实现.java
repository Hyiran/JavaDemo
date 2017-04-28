package com.java��ϰ;

import mx4j.tools.config.DefaultConfigurationBuilder.New;

/*
 * javaʵ�ֶ��߳�������������һ���Ǽ̳�Thread�࣬һ����ʵ��Runnable�ӿ�
 * 1.�̳�Thread�࣬��дrun������ͨ��start����
 * 2.ʵ��Runnable�ӿڣ�ʵ��run����������������Ϊ�������ݸ�new Thread(����)��ͨ��start��������
 * */
public class ���߳�ʵ�� {
	
	
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