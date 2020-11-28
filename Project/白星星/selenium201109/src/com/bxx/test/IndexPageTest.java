package com.bxx.test;


import org.testng.annotations.Test;

import com.bxx.core.BaseTest;

public class IndexPageTest extends BaseTest{
	
	@Test
	public void loginTest() {
		String url = "http://127.0.0.1:9900/index.php";
		webtest.open(url);
		webtest.click("xpath=//a[@text='登录']");
		webtest.type("username", "会员1");
		webtest.type("password", "huiyuan");
		webtest.click("//*[@type='submit']");
	}
	
}
