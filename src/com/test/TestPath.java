package com.test;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.*;

public class TestPath{
	
	private  Logger log;
	 
	public void test1(){
		Map<String,String> map=new HashMap<String,String>();   
		map.put("username", "qq");   
		map.put("passWord", "123");   
		map.put("userID", "1");   
		map.put("email", "qq@qq.com");
		
		map.get("");
	}
	

	public void test(){
		
		log = Logger.getLogger(this.getClass().getName());
		
		int a = 10;
		log.info("a is : " + a);
	}
	
	public static void main(String[] args){
		Properties prop = new Properties();
		/*
		 * Log4j����ֻʹ���ĸ��������ȼ��Ӹߵ��ͷֱ���ERROR��WARN��INFO��DEBUG
		 * ���ﶨ������ʾ������ͼ���,�����嵽INFO����,�򿴲���DEBUG�������Ϣ��~!��������������
		 */
		
		new TestPath().test();
	}
}

@interface Intet{
	
}
