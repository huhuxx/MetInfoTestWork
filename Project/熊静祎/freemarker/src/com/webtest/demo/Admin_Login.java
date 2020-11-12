package com.webtest.demo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import org.testng.annotations.Test;

import com.freemarker.BaseTest;

/**
 * author:xiongjingyi
 * 
 */


public class Admin_Login  extends BaseTest{
	
	@Test
	public void testLogin() throws InterruptedException {
		
		webtest.open("http://localhost:8070/xjy/");
		webtest.type("name=login_name", "xjy");
		Thread.sleep(3000);
		webtest.type("name=login_pass", "xjy");
		Thread.sleep(3000);
		webtest.click("xpath=//input[@type='submit']");
	}
	
	@Test
	public void test1() {
		assertEquals(1, 1);
	}
	
	@Test
	public void test2() {
		assertEquals(3, 5);
	}
	
	@Test
	public void test3() {
		assertEquals(7, 6);
	}

}
