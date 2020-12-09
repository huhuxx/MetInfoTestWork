package com.webtest.core;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.webtest.utils.Log;
import com.webtest.utils.ReadProperties;

/**
 * author:lihuanzhen
 *
 */


public class BaseTest {

	public  WebDriverEngine webtest;
	protected WebDriver driver;
	public String driverType;

	
	

	private WebDriver newWebDriver(String driverType) throws IOException {
		WebDriver driver = null;
	 if (driverType.equalsIgnoreCase("firefox")) {
		    String firefox_driver =ReadProperties.getPropertyValue("gecko_driver");
			String firefox_path = ReadProperties.getPropertyValue("firefox_path");
			System.setProperty("webdriver.gecko.driver", firefox_driver);
			System.setProperty("webdriver.firefox.bin", firefox_path);
			driver = new FirefoxDriver();
	
			Log.info("Using Firefox");
		}  else if (driverType.equalsIgnoreCase("chrome")) {
			String chrome_path = ReadProperties.getPropertyValue("chrome_path");
			System.setProperty("webdriver.chrome.driver",chrome_path);
			driver = new ChromeDriver();
			Log.info("Using Chrome");
			
		}else{
			return null;
		}

		
		return driver;

	
	}



	@BeforeClass
	public void doBeforeClass() throws Exception {

		driverType=ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
	
	
	
	}
	
	@Test(priority = 1)
	public void testBackLogin() throws InterruptedException, IOException {
		webtest.open(ReadProperties.getPropertyValue("url"));
		webtest.type("name=login_name", ReadProperties.getPropertyValue("username"));
		Thread.sleep(2000);
		webtest.type("name=login_pass", ReadProperties.getPropertyValue("password"));
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
		Thread.sleep(2000);
	}
	
	@Test(priority = 2)
	public void testLogin() throws InterruptedException {
		webtest.enterFrame1("xpath=//iframe[@src='http://localhost:8070/index.php?lang=cn&pageset=1']");
		webtest.click("xpath=//a[text()='µ«¬º']");
		Thread.sleep(2000);
		webtest.type("name=username", "xjy1");
		Thread.sleep(2000);
		webtest.type("name=password", "xjy123456");
		webtest.click("xpath=//button[@class='btn btn-lg btn-primary btn-squared btn-block editable-click']");
		Thread.sleep(2000);
		System.out.println("≤‚ ‘”√¿˝2");
		webtest.leaveFrame();
	}


	@AfterClass
	public void doAfterMethod() {
		if(this.driver != null){
			this.driver.quit();
			}
		Log.info("Quitted Browser");
	}
	


	
	
	public WebDriver getDriver() {
        return driver;
    }


	

}
