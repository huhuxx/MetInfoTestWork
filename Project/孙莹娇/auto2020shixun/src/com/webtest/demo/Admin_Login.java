<<<<<<< HEAD:孙莹娇/auto2020shixun/src/com/webtest/demo/Admin_Login.java
package com.webtest.demo;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.webtest.core.BaseTest;
import com.webtest.core.JavaMailTestListener;
import com.webtest.utils.FreeMarker;
import com.webtest.utils.MailUtil;

import freemarker.template.TemplateException;

@Listeners(JavaMailTestListener.class)
public class Admin_Login {
	
//	@Test
//	public void testLogin() {
//		
//		webtest.open("http://localhost:8032/mymovie/admin.php/");
//		
//		webtest.type("name=username", "admin");
//		webtest.type("name=password", "admin");
//		webtest.click("xpath=//input[@type='submit']");
//		assertTrue(webtest.isTextPresent("退出"));
//	}
	@Test
	public void test1() {
		Assert.assertEquals(1, 1);
	}
	@Test
	public void test2() {
		Assert.assertEquals(1, 4);
	}
	@Test
	public void test3() {
		Assert.assertEquals(2, 2);
	}
	@Test
	public void test4() {
		Assert.assertEquals(1, 2);
	}
	@AfterSuite
	public void mailUtil() throws IOException, TemplateException {
		FreeMarker freeMarker=new FreeMarker();
		freeMarker.makeReport();
		
		MailUtil m=new MailUtil();
		m.sendMail(JavaMailTestListener.content);
		
	}
}
=======
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
>>>>>>> 29b5201bfb36505d7c15dcc973267393a477fd17:Project/孙莹娇/auto2020shixun/src/com/webtest/demo/Admin_Login.java
