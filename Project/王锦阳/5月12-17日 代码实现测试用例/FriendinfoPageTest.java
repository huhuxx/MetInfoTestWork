package com.sport.testcases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.FriendInfoPages;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
import com.sport.pages.MyInformationPages;
import com.sport.pages.MyfriendPages;

public class FriendinfoPageTest extends BaseTest{
	MainPages mainPages;
	@BeforeClass
	public void login() throws InterruptedException {
		LoginPage loginPage=new LoginPage(driver);
		mainPages=loginPage.login_sucess("12345678909", "123456");
		mainPages.turn_success("我的");
		Thread.sleep(1000);
		MyInformationPages myPage=new MyInformationPages(driver);
		myPage.turn_to_target("我的好友");
		Thread.sleep(500);
		MyfriendPages myfriendPages=new MyfriendPages(driver);
		myfriendPages.click_head();
		Thread.sleep(500);
	}
	@Test(priority = 1)
	public void change_status() {
		FriendInfoPages friendInfoPages=new FriendInfoPages(driver);
		String status1=friendInfoPages.get_status();
		System.out.println(status1);
		friendInfoPages.change_status();
		String status2=friendInfoPages.get_status();
		System.out.println(status2);
		assertNotEquals(status1, status2);
	}
	@Test(priority = 2)
	public void cancel_att() throws InterruptedException {
		FriendInfoPages friendInfoPages=new FriendInfoPages(driver);
		String name1=friendInfoPages.get_friendName();
		Thread.sleep(500);
		friendInfoPages.back_to_friend();
		Thread.sleep(500);
		MyfriendPages myfriendPages=new MyfriendPages(driver);
		String name2=myfriendPages.find_name();
		Thread.sleep(500);
		assertNotEquals(name1, name2);
	}
	@Test(priority = 3)
	public void look_course() throws InterruptedException {
		MyfriendPages myfriendPages=new MyfriendPages(driver);
		myfriendPages.click_head();
		Thread.sleep(500);
		FriendInfoPages friendInfoPages=new FriendInfoPages(driver);
		friendInfoPages.get_course();
		Thread.sleep(500);
		assertNotEquals(driver.currentActivity(), ".MR.CourseActivity");
	}
	@Test(priority = 4)
	public void look_plan() throws InterruptedException {
		FriendInfoPages friendInfoPages=new FriendInfoPages(driver);
		friendInfoPages.get_plan();
		Thread.sleep(1000);
		assertNotEquals(driver.currentActivity(), ".MR.PlanActivity");
	}
	@Test(priority = 5)
	public void look_attention() throws InterruptedException {
		FriendInfoPages friendInfoPages=new FriendInfoPages(driver);
		friendInfoPages.get_attention();
		Thread.sleep(1000);
		assertEquals(driver.findElementById("android:id/message").getText(), "很抱歉，“健身助手ki”已停止运行。");
	}
	
}
