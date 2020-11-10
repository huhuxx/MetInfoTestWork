package com.bxx.test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.bxx.core.WebTestListener1;
import com.bxx.core.WebTestListener2;
import com.bxx.utils.ReadProperties;
import com.bxx.utils.UseBrowser;
import com.bxx.utils.Log;
public class BaseTest {

	public String LoginURL = "http://www.baidu.com";
	private static String URL = "http://www.taobao.com";
	UseBrowser useBrowser = new UseBrowser();
	private static WebDriver driver;

	@BeforeSuite
	public void start() throws Exception {
		try {
//			driver = useBrowser.startChrome(URL);
//			 driver = useBrowser.startIE(URL);
			 driver = useBrowser.startFirefox(URL);
		} catch (Exception e) {
			System.out.println(e);
		}
	} 


	
	@AfterSuite
	public void end() throws Exception {
		useBrowser.tearDownBrowser();
	}
	public WebDriver getDriver() {
        return driver;
    }

	@BeforeSuite(description = "添加监听器")
	public void addListener(ITestContext context) {
		System.out.println("添加监听器");
		TestRunner runner = (TestRunner)context;
		runner.addListener(new WebTestListener1());
		runner.addListener(new WebTestListener2());
	}
}
