package com.ʵ��demo;

import java.io.IOException;
import java.io.InputStream;

/***
 * ִ��bat�ļ�
 * 
 * @author libingxian
 * 
 */
public class ִ���ļ� {
	public void runbat(String batName) {
		try {
			Process ps = Runtime.getRuntime().exec(batName);
			InputStream in = ps.getInputStream();
			int c;
			while ((c = in.read()) != -1) {
				System.out.println(c);// ����㲻��Ҫ����������п���ע����
			}
			in.close();
			ps.waitFor();
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("child thread done");
	}

	public static void main(String[] args) {
		ִ���ļ� test1 = new ִ���ļ�();
		String batName = "E:\\workspace\\HK_GW_Test\\copy_report.bat";
		batName = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		test1.runbat(batName);
		System.out.println("main thread");
	}
}