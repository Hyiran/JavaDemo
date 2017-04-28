package com.appium.demo;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumZhihuRegister {
	
	public static AppiumDriver driver;
	private static boolean isInstall = false;

	public static void startRecord() throws IOException {
		Runtime rt = Runtime.getRuntime();
		rt.exec("cmd.exe /C adb shell screenrecord /sdcard/runCase.mp4");
	}

	 
	public static void setUp() throws Exception {
		// 启动appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ad41ca38");
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");

		// 配置测试apk
		capabilities.setCapability("appPackage", "com.tencent.mm");
		capabilities.setCapability("appActivity",".ui.LauncherUI");
		capabilities.setCapability("sessionOverride", true); // 每次启动时覆盖session，否则第二次后运行会报错不能新建session
//		capabilities.setCapability("unicodeKeyboard", true); // 设置键盘
//		capabilities.setCapability("resetKeyboard", false); // 设置默认键盘为appium的键盘
		
		capabilities.setCapability("fastReset", "false");
		capabilities.setCapability("fullReset", "false");
		capabilities.setCapability("noReset", "true");
		  
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("androidProcess", "WEBVIEW_com.qihoo.browser");
		capabilities.setCapability(ChromeOptions.CAPABILITY, op);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// 如果真机设备已经安装知乎，则不需要重新安装
		if (isInstall) {
			File classpathRoot = new File(System.getProperty("user.dir"));
			File appDir = new File(classpathRoot, "apps");
			File app = new File(appDir, "zhihu.apk");
			capabilities.setCapability("app", app.getAbsolutePath());
		}
		startRecord();
	}

 
	public static void loginWithMicroBlog() throws InterruptedException {
		// swipe to right
		driver.findElementByXPath("//*[@text='发现']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@text='小程序']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[contains(@text, 'QQ阅读')]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='书库']").click();
		Set<String> contextNames = driver.getContextHandles();
		Thread.sleep(1000);
		for (String contextName : contextNames) {
		System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.qihoo.browser");
		Thread.sleep(1000);
		System.out.println("已经进入WEBVIEW啦");
		//System.out.println(driver.getPageSource());
		String s1 = driver.getWindowHandle();

		driver.findElementByXPath("//*[contains(@url, '古代')]").click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Set<String> set1 = driver.getWindowHandles();
		//System.out.println(set1);
		for(String windows: set1){
		if (windows.equalsIgnoreCase(s1)){

		}else{
		driver.switchTo().window(windows);
		}
		}
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElementByXPath("//[contains(@url, 'bid=716295')]").click();
		String s2 = driver.findElementByXPath("//[contains(@url, 'bid=716295')]").getText();
		System.out.println(s2);
		Assert.assertTrue(s2.contains("美人榻"));
		Thread.sleep(3000);
		driver.context("NATIVE_APP");
		System.out.println("已经回到NativeAPP啦");
		driver.findElementById("com.tencent.mm:id/io").click();
		//driver.findElement(By.id("com.tencent.mm:id/io")).click();
	}

	 
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public static void main(String args[]) throws Exception{
		setUp();
		loginWithMicroBlog();
	}
}