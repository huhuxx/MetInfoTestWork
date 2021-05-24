package com.sport.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;

public class MainPagesTest extends BaseTest {
	MainPages mainPages;
	@BeforeClass
	public void login() {
		LoginPage loginPage=new LoginPage(driver);
		 mainPages=loginPage.login_sucess("12345678909", "123456");
	}
	@Test(priority = 1)
	public void test_insert() {
		mainPages.turn_success("我的");
		assertTrue(mainPages.my_button().isSelected());
	}
}
