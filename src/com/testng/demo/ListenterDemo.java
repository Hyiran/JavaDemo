package com.testng.demo;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class ListenterDemo extends TestListenerAdapter{
	
	private int m_count = 0;
	private static Logger log = Logger.getLogger(ListenterDemo.class);
	
	@Override
	public void onTestFailure(ITestResult tr){
		log.error(String.format("FAIL %s %s reason:%s", tr.getClass().getName(),tr.getMethod().getMethodName(),tr.getThrowable().getMessage()));
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		Throwable cause = tr.getThrowable();
		
		if(cause != null){
			cause.printStackTrace(pw); // 输出所有的exception异常信息
			log.error(sw.getBuffer().toString());
		}
	}
	
	@Override
	public void onTestSuccess(ITestResult tr){
		log.info(tr.getName() + "-- Test method succ");
	}
	
	@Override 
	public void onTestSkipped(ITestResult tr){
		log.info(tr.getName() + "-- test method skipp");
		es();
	}
	
	@Override
	public void onTestStart(ITestResult tr) {
		log.info(tr.getName() + "-- test method start");
	};
	
	public void es(){
		System.out.println("aaa");
	}
	
}
