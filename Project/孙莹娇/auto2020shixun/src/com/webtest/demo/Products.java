package com.webtest.demo;

import org.testng.annotations.Test;

import com.webtest.core.BaseTest;

public class Products extends BaseTest {
	@Test(priority = 0)
	public void loginTest() throws InterruptedException {
		String url = "http://localhost:98/";
		webtest.open(url);
		webtest.click("xpath=//a[@text='登录']");
		
		webtest.type("username", "会员1");
		System.out.println("1111");
		webtest.type("password", "huiyuan");
		webtest.click("//*[@type='submit']");
		System.out.println("2222");
		Thread.sleep(3000);
	}
	@Test(priority = 1)
	public void productTest() throws InterruptedException {
		webtest.open("http://localhost:98/");
		webtest.click("xpath=//a[@href='product/']");
		Thread.sleep(4000);
	}
}
