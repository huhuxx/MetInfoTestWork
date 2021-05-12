package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.SetPage;

public class SetTest extends BaseTest {
	SetPage setPage;
	LoginPage loginPage;
	@BeforeClass
	public void setPage() {
		setPage=new SetPage(driver);
		loginPage = new LoginPage(driver);
	}
	//退出成功
	@Test(priority = 1)
	public void test_exit_success() throws InterruptedException {
		setPage.exit("17732053746","123456");
		assertEquals(driver.currentActivity(), ".ws.LoginActivity");
		System.out.println("退出账号成功");
	}
	//注销失败
	@Test(priority = 2)
	public void test_login_fail() throws InterruptedException {
		setPage.layout("17732053746","123456");
		//断言
		loginPage.login("17732053746", "123456");
		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
		System.out.println("注销失败");
	}
	//返回成功
	@Test(priority = 3)
	public void test_return_fail() throws InterruptedException {
		setPage.back();
		//断言
		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
		System.out.println("返回成功");
	}
}
