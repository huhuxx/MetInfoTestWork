package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.MessagePage;

public class MessagePageTest extends BaseTest {
	MessagePage message;
	@BeforeClass
	public void initPage() {
		message=new MessagePage(driver);
	}
	//验证失败
	@Test
	public void test_code_fail() throws InterruptedException {
		message.check("17732053746", "123456");
		assertEquals(driver.currentActivity(), ".ws.CustomerserviceActivity");
		System.out.println("验证失败");
	}
}
