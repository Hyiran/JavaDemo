package com.java��ϰ;

import org.junit.Assert;

/***
 * ��������������Ҫ��Ϊ�Ŀ飬�ֱ�Ϊ�༶������ʵ�����������������������鼶����
 * �༶����:�ֳ�Ϊ��̬�������������еģ�ͨ���������ʣ�������ڴ�ռ�
 * ʵ���������ֳ�Ϊ����������Ƕ������еģ�ͨ��������ʣ���ʼ������ʱ�Ż�����ڴ�ռ�
 * ������������ֻ�����ڷ�����
 * �鼶������ֻ�������ô�������
 * @author libingxian
 *
 */

public class ���������� {

	static int age; // ����һ���������ͨ������������
	String name; // ����һ��ʵ��������ͨ�����ʵ��������
	
	{
		int j = 111;
	}
	
	public void setName(String name) {
		String aname = name; // ����һ��ֻ������setName�����ڵı���
		if(aname != null){
			int boo = 0;// ����һ��ֻ������if���ڵı���,����Ҫ��ʼ������ܱ�����
			Assert.assertEquals(boo, "asdfs");
		}
		this.name = aname;
	}
	
	public void getName() {
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
