package com.java��ϰ;

import mx4j.tools.config.DefaultConfigurationBuilder.New;

import com.allure.demo.aaa;

/*
 ����String a = new String("abc")
 ��˵һ˵���ڴ��д洢�������String ������ a �Ǵ洢��ջ�ڴ��У���������һ���ռ����ڴ洢  new String("abc") �ڶ��ڴ��п��ٵĿռ���׵�ַ
 
1������==����������ڻ����������͵ı�������ֱ�ӱȽ���洢�� ��ֵ���Ƿ���ȣ�
������������������͵ı�������Ƚϵ�����ָ��Ķ���ĵ�ַ

2������equals������ע�⣺equals�������������ڻ����������͵ı���
�����û�ж�equals����������д����Ƚϵ����������͵ı�����ָ��Ķ���ĵ�ַ��
������String��Date�����equals������������д�Ļ����Ƚϵ�����ָ��Ķ�������ݡ�
@author libingxian
 
 */
public class �����ȽϷ������� {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ��������ֻ��==����ȽϷ��������ڱȽ������������͵�ֵ
		int i = 10;
		int j = 10;
		System.out.println(i==j);
		
		// �������Ϳ���ʹ��== �� equals ���Ƚ�
		
		// ����������==�����бȽϵ�ʱ�򣬱Ƚϵ������ö���ĵ�ַ�����������Ƿ�һ��
		Object o1 = new Object();
		Object o2 = new Object();
		
		System.out.println(o1==o2);
		
		String a = new String("abc");
		String b = new String("abc");
		String c = new String("abc");
		a = c;
		b = c;
		System.out.println(a==b);
		
		// equals ֻ�����������ñ��������ڱȽ����ö�������String ��double�ȶ����������д�����ڱȽ�ֵ
		System.out.println(o1.equals(o2)); // û����д���Ƚ����ö���������false
		System.out.println("abc".equals("abc"));// ��д��equlas���Ƚ�ֵ��������true
		
		
	}
}
