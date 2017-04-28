package com.testng.demo;

import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestParameterCase {
	
	@BeforeClass
	public void BeforeTest(){
		
	}
	
	@AfterClass
	public void AfterClass(){
		
	}
	
	@Test
	@Parameters({"test1","test2"})
	public void TestCase1(String test1,String test2){
		System.out.println(test1 + " " + test2);
	}
	
}
