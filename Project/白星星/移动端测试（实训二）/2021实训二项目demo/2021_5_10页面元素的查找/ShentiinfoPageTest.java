package com.sport.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
import com.sport.pages.MyInformationPages;
import com.sport.pages.ShentiinfoPage;

public class ShentiinfoPageTest extends BaseTest {
	ShentiinfoPage shentiinfoPage;
	LoginPage loginPage;
	MainPages mainPages;
	MyInformationPages myInformationPages;
	@BeforeClass
	public void initPage() throws InterruptedException {
		loginPage = new LoginPage(driver);
		mainPages = new MainPages(driver);
		myInformationPages = new MyInformationPages(driver);
		shentiinfoPage = new ShentiinfoPage(driver);
		loginPage.login_sucess("19831125536", "123456");
		Thread.sleep(3000);
		mainPages.turn_success("我的");
	}
	@Test
	public void updateTouxiang() {
		myInformationPages.turn_to_target("身体数据");

	}
	
}
