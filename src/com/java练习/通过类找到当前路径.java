package com.java��ϰ;

public class ͨ�����ҵ���ǰ·�� {
	
	public static void main(String args[]){
		System.out.println(ͨ�����ҵ���ǰ·��.class.getResource("")); // �ӵ�ǰ��·������
		System.out.println(ͨ�����ҵ���ǰ·��.class.getResource("/")); // ����Ŀ��ClassPath���»�ȡ��Դ
		System.out.println(ͨ�����ҵ���ǰ·��.class.getClass().getClassLoader().getResource(""));
		System.out.println(ͨ�����ҵ���ǰ·��.class.getClass().getClassLoader().getResource("/"));
	}
}	
