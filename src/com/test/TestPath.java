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
		 * Log4j建议只使用四个级别，优先级从高到低分别是ERROR、WARN、INFO、DEBUG
		 * 这里定义能显示到的最低级别,若定义到INFO级别,则看不到DEBUG级别的信息了~!级别后面是输出端
		 */
		
		new TestPath().test();
	}
}

@interface Intet{
	
}
