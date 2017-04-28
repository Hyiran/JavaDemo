package com.实用demo;

public class 根据class路径获取资源文件 {

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
		System.out.println(ClassGetPath.class.getResource("执行文件.class"));
		System.out.println(ClassGetPath.class.getResource("/"));
	}
	
}

