package com.实用demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class 执行cmd命令 {
	/**
	 * 执行cmd命令，并输出执行过程
	 * @param cmdStr cmd命令
	 * @param see 是否查看执行过程的输出
	 * @throws Exception
	 */
	public static void execCmd(String cmdStr,boolean see) throws Exception{
		int i;
		Runtime rt = Runtime.getRuntime();
		Process ps = rt.exec("cmd /c " + cmdStr);
		BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		FileWriter fw = new FileWriter(new File("cmd.txt"));
		String tmp;
		while(see && (tmp = reader.readLine())!=null){
			System.out.println(tmp);
			fw.write(tmp + "\n");
		}
		fw.close();
		reader.close();
		ps.getOutputStream().close();

	}
	
	public static void main(String[] args) throws Exception {
		执行cmd命令.execCmd("ping www.baidu.com",true);
	}
}
