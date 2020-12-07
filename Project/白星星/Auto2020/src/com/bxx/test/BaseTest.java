package com.bxx.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.bxx.core.WebDriverEngine;
import com.bxx.core.WebTestListener1;
import com.bxx.core.WebTestListener2;
import com.bxx.freemarker.Freemarker;

import com.bxx.utils.ReadProperties;

import com.bxx.utils.Log;
import com.bxx.utils.MailUtil;
public class BaseTest {
	
	private WebDriver driver;
	public  WebDriverEngine webtest;
	public String driverType;
	public String url = "http://127.0.0.1:9999/admin/index.php";
	Freemarker freemarker = new Freemarker();
	MailUtil send = new MailUtil();

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
		} else if (driverType.equalsIgnoreCase("IEDriver")) {
			String ie_path = ReadProperties.getPropertyValue("ie_path");
			System.setProperty("webdriver.chrome.driver",ie_path);
			driver = new ChromeDriver();
			Log.info("Using IE");	
		}else{
			return null;
		}
		return driver;
	}
	
	
//	@BeforeSuite
//	public void tiaojian() throws InterruptedException {
//		webtest.open("http://localhost:9900/admin/index.php");
//		webtest.type("name=login_name","admin");
//		webtest.type("name=login_pass", "123456");
//		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
//	}

	@BeforeMethod
	public void doBeforeClass() throws Exception {

		driverType=ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
		webtest.open(ReadProperties.getPropertyValue("base_url"));
		webtest.type("name=login_name","root");
		webtest.type("name=login_pass", "root");
		webtest.click("xpath=//button[@class='btn btn-primary px-4']");
	
	
	}


	@AfterMethod
	public void doAfterMethod() {
		if(this.driver != null){
			this.driver.quit();
			}
		Log.info("Quitted Browser");
	}

	
	@AfterSuite 
	public void end() throws Exception {
		freemarker.finish();
		//压缩
		//压缩后的存放路径
//        ZipCompressor zc = new  ZipCompressor("D:\\eclipse\\WorkSpace201109\\selenium201109\\test-output\\html.zip");  
		//压缩谁
//        zc.compressExe("D:\\eclipse\\WorkSpace201109\\selenium201109\\test-output\\old");
//		发邮件
	    send.sendMessage("test");
	    
	}
	public WebDriver getDriver() {
        return driver;
    }

	@BeforeTest(description = "添加监听器")
	public void addListener(ITestContext context) {
		System.out.println("添加监听器");
		TestRunner runner = (TestRunner)context;
		runner.addListener(new WebTestListener1());
		runner.addListener(new WebTestListener2());
	}
}
