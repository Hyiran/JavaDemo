package com.ʵ��demo;

import java.io.File;

/***
 * ���õݹ����ָ��Ŀ¼����ȡ���е��ļ�
 * @author libingxian
 *
 */
public class ����Ŀ¼ {
	
	public void checkFolder(String folderPath) {
		File file = new File(folderPath);
		File []files;
		if(!file.exists() || !file.isDirectory()){ // �ж��ļ��Ƿ���ڡ��Ƿ���һ���ļ���
			System.out.println(String.format("%s is not right",file));
		}else{
			files = file.listFiles(); // �г����е��ļ�Ŀ¼
			for (File fi : files) { 
				if (fi.isDirectory()){
					checkFolder(fi.getPath()); // �ݹ飬������������������
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
		����Ŀ¼ demo = new ����Ŀ¼();
		demo.checkFolder("D:\\allure-commandline");
	}

}
