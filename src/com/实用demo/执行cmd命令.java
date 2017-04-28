package com. µ”√demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ÷¥––cmd√¸¡Ó {
	/***
	 * ÷¥––cmd√¸¡Ó
	 */
	public static void execCmd() throws Exception{
		int i;
		Runtime rt = Runtime.getRuntime();
		Process ps = rt.exec("cmd /c xcopy /Y /E E:\\workspace\\HK_GW_Test\\test-output \\\\192.168.0.178\\hkgw\\");
		BufferedReader reader = new BufferedReader(new InputStreamReader(ps.getInputStream()));
		FileWriter fw = new FileWriter(new File("cmd.txt"));
		String tmp;
		while((tmp = reader.readLine())!=null){
			System.out.println(tmp);
			fw.write(tmp + "\n");
		}
		fw.close();
		reader.close();
		ps.getOutputStream().close();
		
	}
	
	public static void main(String[] args) throws Exception {
		÷¥––cmd√¸¡Ó.execCmd();
	}
}
