package com.ʵ��demo;

public class ����class·����ȡ��Դ�ļ� {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/***
		 * 
		 */
		ClassGetPath.getPath();
	}

}

class ClassGetPath{
	
	public static void getPath() {
		System.out.println(ClassGetPath.class.getResource("ִ���ļ�.class"));
		System.out.println(ClassGetPath.class.getResource("/"));
	}
	
}

