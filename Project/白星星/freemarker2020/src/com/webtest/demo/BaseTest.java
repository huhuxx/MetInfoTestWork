package com.webtest.demo;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.TestRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.freemarker.WebTestListener;
import com.webtest.utils.UseBrowser;


public class BaseTest {

	public String LoginURL = "http://localhost:9900/index.php";
	private static String URL = "http://localhost:9900/index.php";
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
		runner.addListener(new WebTestListener());

	}
}
