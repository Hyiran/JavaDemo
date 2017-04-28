package com.webdriver.demo;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestChrome {
	
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\华康测试项目\\华康学习资料库\\python\\demo\\chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://192.168.0.223:8060/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
		Thread.sleep(3000);
		driver.findElement(By.id("adminid")).sendKeys("admin");
		driver.findElement(By.id("adminpwd")).sendKeys("111111");
	}

	@Test
	public void testUntitled() throws Exception {
		driver.findElement(By.id("btnAdd")).click();
		driver.findElement(By.id("diseaseName")).clear();
		driver.findElement(By.id("diseaseName")).sendKeys("阿发是大法师");
		new Select(driver.findElement(By.id("firstDeptId0")))
				.selectByVisibleText("风湿免疫科");
		new Select(driver.findElement(By.id("secondDeptId0")))
				.selectByVisibleText("风湿科");
		driver.findElement(By.id("btnEdit")).click();
		driver.findElement(By.id("diseaseName")).clear();
		driver.findElement(By.id("diseaseName")).sendKeys("阿发是大法师");
		driver.findElement(By.id("btnEdit")).click();
		driver.findElement(By.cssSelector("#returnSuperior > a")).click();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
