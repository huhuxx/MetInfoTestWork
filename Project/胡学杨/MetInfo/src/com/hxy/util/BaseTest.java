package com.hxy.util;

import java.io.IOException;

import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.hxy.readproperties.ReadProperties;

public class BaseTest {
	public WebDriver driver;
	@BeforeTest
	public void startBrowser() throws InterruptedException, IOException {
		String firefox_driver = ReadProperties.getPropertyValue("gecko_driver");
		String firefox_path = ReadProperties.getPropertyValue("firefox_path");
		System.setProperty("webdriver.gecko.driver", "D:\\Firefoxgeckodriver\\geckodriver\\geckodriver.exe");
		System.setProperty("webdriver.firefox.bin", "D:\\Firefox\\firefox.exe");
		driver = new FirefoxDriver();
		driver.get("http://localhost:99/admin/index.php");
		Thread.sleep(1000);
		driver.findElement(By.name("login_name")).sendKeys("root");
		driver.findElement(By.name("login_pass")).sendKeys("root");
		driver.findElement(By.xpath("//button[@class='btn btn-primary px-4']")).click();	
		Thread.sleep(4000);
	}

	@AfterTest
	public void quitBrowser() {
		this.driver.quit();
	}	
}
