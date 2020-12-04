package com.hxy.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.hxy.readproperties.ReadProperties;

public class BaseTest {
	public WebDriver driver;
	@BeforeMethod
	public void startBrowser() throws InterruptedException, IOException {
//		String firefox_driver = ReadProperties.getPropertyValue("gecko_driver");
//		String firefox_path = ReadProperties.getPropertyValue("firefox_path");
		System.setProperty("webdriver.gecko.driver", "D:\\Firefoxgeckodriver\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\Firefox\\firefox.exe");
//		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:99/admin/index.php");
		Thread.sleep(1000);
		driver.findElement(By.name("login_name")).sendKeys("root");
		driver.findElement(By.name("login_pass")).sendKeys("root");
		driver.findElement(By.xpath("//button[@class='btn btn-primary px-4']")).click();	
		Thread.sleep(4000);
	}

	@AfterMethod
	public void doAfterMethod() throws InterruptedException {
		if (this.driver != null) {
			this.driver.quit();
		}
		Thread.sleep(2000);
	}
}
