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
		// ����appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ad41ca38");
		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "4.4.2");

		// ���ò���apk
		capabilities.setCapability("appPackage", "com.tencent.mm");
		capabilities.setCapability("appActivity",".ui.LauncherUI");
		capabilities.setCapability("sessionOverride", true); // ÿ������ʱ����session������ڶ��κ����лᱨ�����½�session
//		capabilities.setCapability("unicodeKeyboard", true); // ���ü���
//		capabilities.setCapability("resetKeyboard", false); // ����Ĭ�ϼ���Ϊappium�ļ���
		
		capabilities.setCapability("fastReset", "false");
		capabilities.setCapability("fullReset", "false");
		capabilities.setCapability("noReset", "true");
		  
		ChromeOptions op = new ChromeOptions();
		op.setExperimentalOption("androidProcess", "WEBVIEW_com.qihoo.browser");
		capabilities.setCapability(ChromeOptions.CAPABILITY, op);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// �������豸�Ѿ���װ֪��������Ҫ���°�װ
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
		driver.findElementByXPath("//*[@text='����']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[@text='С����']").click();
		Thread.sleep(1000);
		driver.findElementByXPath("//*[contains(@text, 'QQ�Ķ�')]").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='���']").click();
		Set<String> contextNames = driver.getContextHandles();
		Thread.sleep(1000);
		for (String contextName : contextNames) {
		System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.qihoo.browser");
		Thread.sleep(1000);
		System.out.println("�Ѿ�����WEBVIEW��");
		//System.out.println(driver.getPageSource());
		String s1 = driver.getWindowHandle();

		driver.findElementByXPath("//*[contains(@url, '�Ŵ�')]").click();
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
		Assert.assertTrue(s2.contains("�����"));
		Thread.sleep(3000);
		driver.context("NATIVE_APP");
		System.out.println("�Ѿ��ص�NativeAPP��");
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