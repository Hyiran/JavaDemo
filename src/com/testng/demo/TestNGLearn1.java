package com.testng.demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Parameters;

import org.testng.asserts.Assertion;

@Test
public class TestNGLearn1{

	Assertion tassert; // testng 断言
	
    @BeforeClass
    public void beforeClass() {
    	tassert = new Assertion();
        System.out.println("this is before class");
    }
    
    /**
     * 两数相加
     * @param a
     * @param b
     * @return
     */
    public int add(int a,int b){
    	return a+b;
    }
        
    @Test
    @Parameters("test1")
    public void ParaTest(String test1){
        System.out.println("This is " + test1);
    }

    @AfterClass
    public void afterClass() {
        System.out.println("this is after class");
    }
}