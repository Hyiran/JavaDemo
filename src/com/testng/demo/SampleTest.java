package com.testng.demo;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest {
	
    @Test
    public void testMethodOne(){
        Assert.assertTrue(true);
    }
	  
    @Test
    public void testMethodTwo(){
    	Assert.assertTrue(false);
    }
	  
    @Test(dependsOnMethods={"testMethodTwo"})
    public void testMethodThree(){
        Assert.assertTrue(true);
    }
    
    @Test(dependsOnMethods={"testMethodTwo"})
    public void testMethodThree2(){
        Assert.assertTrue(true);
    }
}