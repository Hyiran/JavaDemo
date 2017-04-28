package com.实用demo;

import java.io.File;

/***
 * 利用递归遍历指定目录，获取所有的文件
 * @author libingxian
 *
 */
public class 遍历目录 {
	
	public void checkFolder(String folderPath) {
		File file = new File(folderPath);
		File []files;
		if(!file.exists() || !file.isDirectory()){ // 判断文件是否存在、是否是一个文件夹
			System.out.println(String.format("%s is not right",file));
		}else{
			files = file.listFiles(); // 列出所有的文件目录
			for (File fi : files) { 
				if (fi.isDirectory()){
					checkFolder(fi.getPath()); // 递归，调用自身函数继续遍历
				}else{
					System.out.println(fi.getPath());
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		遍历目录 demo = new 遍历目录();
		demo.checkFolder("D:\\allure-commandline");
	}

}
