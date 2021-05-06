package com.hxy.util;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.hxy.readproperties.ReadProperties;

public class BaseAsset {
	public WebDriver driver;
	@BeforeTest
	public void startBrowser() throws InterruptedException, IOException {
		String firefox_driver = ReadProperties.getPropertyValue("gecko_driver");
		String firefox_path = ReadProperties.getPropertyValue("firefox_path");
//		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver\\geckodriver.exe");
//		System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		System.setProperty("webdriver.gecko.driver", "D:\\Firefoxgeckodriver\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:99");
		Thread.sleep(2000);
	}

	@AfterTest
	public void quitBrowser() {
		this.driver.quit();
	}	
}
