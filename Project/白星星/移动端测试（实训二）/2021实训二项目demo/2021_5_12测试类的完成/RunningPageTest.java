package com.sport.testcases;

import java.awt.Desktop.Action;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.pages.RunningPage;
import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
/**
 * running计时器的测试用例
 * @author 白星星
 *
 */
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
		Thread.sleep(3000);
	}
	
	@Test(description = "打开计时并暂停停止",priority = 1)
	public void test1() throws InterruptedException {
		Thread.sleep(1000);
		runningPage.pauseClick();
		Thread.sleep(1000);
		runningPage.stopClick();
		Thread.sleep(1000);
	}
	
	@Test(description = "计时暂停后继续计时",priority = 2)
	public void test2() throws InterruptedException {
		Thread.sleep(1000);
		runningPage.pauseClick();
		Thread.sleep(1000);
		runningPage.restartClick();
		Thread.sleep(1000);
		runningPage.pauseClick();
		runningPage.stopClick();
		Thread.sleep(1000);
	}
	
	@Test(description = "计时两次暂停后继续计时",priority = 3)
	public void test3() throws InterruptedException {
		Thread.sleep(1000);
		runningPage.pauseClick();
		Thread.sleep(1000);
		runningPage.restartClick();
		Thread.sleep(1000);
		runningPage.pauseClick();
		Thread.sleep(1000);
		runningPage.restartClick();
		Thread.sleep(1000);
		runningPage.pauseClick();
		runningPage.stopClick();
		Thread.sleep(1000);
	}
	@Test(description = "暂停验证时间是否正确",priority = 4)
	public void test4() throws InterruptedException {
		Thread.sleep(1000);
		runningPage.pauseClick();
		Thread.sleep(1000);
		String timeString = runningPage.action_text();
		System.out.println("time"+timeString);
		runningPage.restartClick();
		Thread.sleep(1000);
		runningPage.pauseClick();
		runningPage.stopClick();
		Thread.sleep(1000);
		
	}
	@Test(description = "多次暂停验证时间正确性",priority = 5)
	public void test5() throws InterruptedException {
		Thread.sleep(1000);
		runningPage.pauseClick();
		Thread.sleep(1000);
		String time1 = runningPage.action_text();
		System.out.println("time1"+time1);
		runningPage.restartClick();
		Thread.sleep(1000);
		runningPage.pauseClick();
		Thread.sleep(1000);
		String time2 = runningPage.action_text();
		System.out.println("time2"+time2);
		runningPage.restartClick();
		Thread.sleep(1000);
		runningPage.pauseClick();
		runningPage.stopClick();
		Thread.sleep(1000);
	}
	
	
	
}
