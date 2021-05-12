package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;

public class LoginPageTest extends BaseTest {
	LoginPage loginPage;
	@BeforeClass
	public void initPage() {
		loginPage=new LoginPage(driver);
	}
	//登录成功
	@Test
	public void test_login_success() {
		loginPage.login_sucess("17732053746", "123456");
		assertEquals(driver.currentActivity(), ".MainActivity");
	}
	//登陆失败
	@Test
	public void test_login_fail1() {
		loginPage.login_fail("1", "2");
		assertEquals(driver.currentActivity(), ".MainActivity");
	}
}
