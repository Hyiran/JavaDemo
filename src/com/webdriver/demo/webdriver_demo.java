package com.webdriver.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.Select;

public class webdriver_demo {
	
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static void main(String []args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "E:\\testproject\\chromedriver.exe");
		driver = new ChromeDriver();
//		driver.get("http://www.hk515.com/Account/Logout");
		Thread.sleep(1000);
		driver.get("http://www.hk515.com/Login");
		driver.findElement(By.id("LoginNamePhoneEmail_input")).clear();
		CharSequence cs = new String("15914063350");
		CharSequence []name ={cs}; 
		WebElement ee = driver.findElement(By.id("LoginNamePhoneEmail_input"));
		ee.sendKeys(name);
		driver.findElement(By.id("Password_input")).clear();
		
		cs = new String("123456");
		CharSequence []pwd = {cs}; 
		driver.findElement(By.id("Password_input")).sendKeys(pwd);
		driver.findElement(By.id("login_button")).click();
		Thread.sleep(5000);
		driver.get("http://www.hk515.com/Doctor/16031906161054885001770429927947558");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//p[contains(text(),'预约')]")).click();
		Thread.sleep(5000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight/2)",new Object[]{}); // 向下滚动一半，查找下面的元素
//		driver.findElement(By.id("localPatient")).click();
		
		Select select = new Select(driver.findElement(By.id("localPatient")));
		select.selectByValue("1");
		
		Thread.sleep(100000);
		
	}

}
