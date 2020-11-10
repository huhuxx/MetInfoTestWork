package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.JavaMailTestListener;
import com.webtest.utils.MailUtil;

@Listeners(JavaMailTestListener.class)
public class Admin_Login  extends BaseTest{
	
	@Test
	public void testLogin() {
		
		webtest.open("http://localhost:8032/mymovie/admin.php/");
		
		webtest.type("name=username", "admin");
		webtest.type("name=password", "admin");
		webtest.click("xpath=//input[@type='submit']");
		assertTrue(webtest.isTextPresent("退出"));
	}
	@Test
	public void test5() {
		Assert.assertEquals(1, 4);
	}
	@AfterSuite
	public void mailUtil() {
		MailUtil m=new MailUtil();
		m.sendMail(JavaMailTestListener.content);
	}
}
