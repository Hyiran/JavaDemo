package com.java练习;

public class 通过类找到当前路径 {
	
	public static void main(String args[]){
		System.out.println(通过类找到当前路径.class.getResource("")); // 从当前的路径查找
		System.out.println(通过类找到当前路径.class.getResource("/")); // 从项目的ClassPath根下获取资源
		System.out.println(通过类找到当前路径.class.getClass().getClassLoader().getResource(""));
		System.out.println(通过类找到当前路径.class.getClass().getClassLoader().getResource("/"));
	}
}	
