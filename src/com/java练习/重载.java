package com.java��ϰ;

/***
 * 
 * @author libingxian
 * �ع����Դ����Ż�
 * ���� Overloading��������ͬһ�����У�������һ������������/�������Ͳ�һ��
 * ��д Overriding������������̳и����У���������һ���������������б�ͷ���ֵ�����븸����ͬ�ķ�����ȫ��ͬ,����Ķ���ʹ���������ʱ�������������еĶ��壬�������ԣ������еĶ�����ͬ��"����"��
 */
public class ���� {
	
	public String func1(String a,String b){
		return a + b;
	}
	
	public String func1(String a,String b,String c){
		return a + b + c;
	}
}

class test extends ����{
	
	public String func1(String a,String b){
		return String.valueOf(a);
	}
	
	
	
}
