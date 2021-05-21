package com.sport.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
import com.sport.pages.MyInformationPages;
import com.sport.pages.SettingPages;

public class LoginPageTest extends BaseTest {
	LoginPage loginPage;
	@BeforeClass
	public void initPage() {
		loginPage=new LoginPage(driver);
	}
	
	@Test(priority = 1)
	public void test_login_success() {
		loginPage.login_sucess("12345678909", "123456");
		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
		MainPages mainPages=new MainPages(driver);
		mainPages.turn_success("我的");
		MyInformationPages myInformationPages=new MyInformationPages(driver);
		myInformationPages.turn_to_target("设置");
		SettingPages settingPages =new SettingPages(driver);
		settingPages.quit();
	}
	@Test(priority = 2)
	public void test_login_fail1() {
		loginPage=new LoginPage(driver);
		String message=loginPage.login_fail("12345678909", "1234567");
//		System.out.println(loginPage.get_password());
		assertEquals(message, "该账户登录信息有误");
	}
	@Test(priority = 3)
	public void test_eye() {
		loginPage.click_eye();
		assertEquals(loginPage.get_password(), "1234567");
	}
	@Test(priority = 4)
	public void test_login_fail2() {
		loginPage=new LoginPage(driver);
		String message=loginPage.login_fail("", "1234567");
		System.out.println(loginPage.get_password());
		assertEquals(message, "该账户登录信息有误");
	}
	@Test(priority = 5)
	public void test_login_fail3() {
		loginPage=new LoginPage(driver);
		String message=loginPage.login_fail("12345678909", "");
		System.out.println(loginPage.get_password());
		assertEquals(message, "该账户登录信息有误");
	}
	@Test(priority = 6)
	public void test_eye2() {
		loginPage.click_eye();
		assertNotEquals(loginPage.get_password(), "1234567");
	}

}
