package com.���ģʽ.demo;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.DSASigner.dsa512;

/***
 * ����ģʽ��ָ�������ʵ���������ڴ�����Զ����ֻ��һ�����������ĺô��Ǳ��ⲻһ��״̬�������ӡ����ӡ�ļ��ӿڣ�ͬһ̨��ӡ��ͬһʱ��ֻ�ܴ�ӡһ���ļ�
 * ���������ԣ�
 * 1����������˽�л�
 * 2������˽�еľ�̬�����ñ��������ҳ�ʼ��
 * 3��ͨ����̬�ķ��������ṩ��ʵ������
 * @author libingxian
 *
 */
public class ����ģʽ {
	
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
	
	// ���췽��˽�л�
	private danli(String demo){
		
	}
	
	void print(String demo) {
		System.out.println(demo);
	}
	
	// ����һ��˽�еĿյľ�̬����� --����ʽ�������̲߳���ȫ
	private static danli dl = null;
	
	// ����һ����̬�Ķ����ṩ����ķ���
	public static danli getInsitance(String demo){
		if (dl == null){
			System.out.println(demo);
			dl = new danli(demo);
		}
		return dl;
	}
	
}

class danli2{
	
	// ���췽��˽�л�
	private danli2(String demo){
		
	}
	
	void print(String demo) {
		System.out.println(demo);
	}
	
	// ����һ��˽�е��Ѿ���ʼ���õľ�̬����� --����ʽ�������̰߳�ȫ���Ѿ�������ڴ�ռ�
	private static danli2 dl = new danli2("demo");
	
	// ����һ����̬�Ķ����ṩ����ķ���
	public static danli2 getInsitance(String demo){
		return dl;
	}
	
}
