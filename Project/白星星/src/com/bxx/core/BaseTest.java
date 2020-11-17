package com.bxx.core;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.bxx.freemarker.Freemarker;

import com.bxx.utils.ReadProperties;

import com.bxx.utils.Log;
import com.bxx.utils.MailUtil;
public class BaseTest {
	
	private WebDriver driver;
	public  WebDriverEngine webtest;
	public String driverType;
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
			
		}else{
			return null;
		}
		return driver;
	}
	
	@BeforeClass
	public void start() throws Exception {
		driverType=ReadProperties.getPropertyValue("driverType");
		driver = this.newWebDriver(driverType);
		driver.manage().window().maximize();
		Log.info(driverType);
		webtest = new WebDriverEngine(driver);
	} 


	
	@AfterSuite
	public void end() throws Exception {
		if(this.driver != null){
			this.driver.quit();
			}
		Log.info("Quitted Browser");
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
