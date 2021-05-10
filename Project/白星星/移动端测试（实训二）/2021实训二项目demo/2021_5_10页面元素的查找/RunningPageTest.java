package com.sport.testcases;

import java.awt.Desktop.Action;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.pages.RunningPage;
import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;

public class RunningPageTest extends BaseTest {
	RunningPage runningPage ;
	MainPages mainPages;
	LoginPage loginPage;
	@BeforeClass
	public void initPage() throws InterruptedException {
		loginPage = new LoginPage(driver);
		mainPages = new MainPages(driver);
		runningPage = new RunningPage(driver);
		loginPage.login_sucess("19831125536", "123456");
		Thread.sleep(3000);
		mainPages.turn_success("秒表");
	}
	
	@Test(description = "打开计时并暂停停止")
	public void openRunning() throws InterruptedException {
		String timeString = runningPage.getTime();
		
	}
	
	
}
