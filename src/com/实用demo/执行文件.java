package com.实用demo;

import java.io.IOException;
import java.io.InputStream;

/***
 * 执行bat文件
 * 
 * @author libingxian
 * 
 */
public class 执行文件 {
	public void runbat(String batName) {
		try {
			Process ps = Runtime.getRuntime().exec(batName);
			InputStream in = ps.getInputStream();
			int c;
			while ((c = in.read()) != -1) {
				System.out.println(c);// 如果你不需要看输出，这行可以注销掉
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
		执行文件 test1 = new 执行文件();
		String batName = "E:\\workspace\\HK_GW_Test\\copy_report.bat";
		batName = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
		test1.runbat(batName);
		System.out.println("main thread");
	}
}