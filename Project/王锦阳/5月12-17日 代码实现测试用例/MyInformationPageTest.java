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
import com.sport.pages.SearchfriendPages;


public class MyInformationPageTest extends BaseTest{
	MainPages mainPages;
	MyfriendPages myfriendPages;
	@BeforeClass
	public void login() {
		LoginPage loginPage=new LoginPage(driver);
		mainPages=loginPage.login_sucess("12345678909", "123456");
	}
	@Test(priority = 1)
	public void turn_to_myfriend() throws InterruptedException {
		mainPages.turn_success("我的");
		Thread.sleep(1000);
		MyInformationPages myPage=new MyInformationPages(driver);
		myPage.turn_to_target("我的好友");
		myfriendPages=new MyfriendPages(driver);
		assertEquals(driver.currentActivity(), ".ws.FriendActivity");
	}
	@Test(priority = 2)
	public void exist_friend() {
		String fiendName=myfriendPages.find_name();
		assertNotEquals(fiendName, null);
	}
	@Test(priority = 3)
	public void test_cancel_attention() {
		String friend1=myfriendPages.find_name();
		myfriendPages.cancel_attention();
		String friend2=myfriendPages.find_name();
		assertNotEquals(friend1, friend2);
	}
	@Test(priority = 4)
	public void search_friend() throws InterruptedException {
		MyfriendPages myfriendPages=new MyfriendPages(driver);
		myfriendPages.turn_to_search();
		Thread.sleep(500);
		SearchfriendPages searchfriendPages=new SearchfriendPages(driver);
		searchfriendPages.searchfriendByName("王小阳");
		assertEquals(searchfriendPages.findfriendByName(),"王小阳");
		searchfriendPages.get_attention();
	}
	@Test(priority = 5)
	public void search_friend2() throws InterruptedException{
		SearchfriendPages searchfriendPages=new SearchfriendPages(driver);
		searchfriendPages.back_to_myfriend();
		MyfriendPages myfriendPages=new MyfriendPages(driver);
		myfriendPages.turn_to_search();
		Thread.sleep(500);
		SearchfriendPages searchfriendPages1=new SearchfriendPages(driver);
		String message=searchfriendPages1.searchfriendByPhone("12345678909");
		assertEquals(message, "账户信息不存在");
	}
	@Test(priority = 6)
	public void search_friendagain() throws InterruptedException{
		SearchfriendPages searchfriendPages=new SearchfriendPages(driver);
		searchfriendPages.searchfriendByName("王小阳");
		searchfriendPages.searchfriendByName("王小阳");
		assertEquals(searchfriendPages.findfriendByName2(), "王小阳");
	}
	@Test(priority = 7)
	public void attention_again() throws InterruptedException {
		SearchfriendPages searchfriendPages=new SearchfriendPages(driver);
		searchfriendPages.back_to_myfriend();
		String fiendName=myfriendPages.find_name();
		System.out.println(fiendName);
		myfriendPages.turn_to_search();
		Thread.sleep(500);
		SearchfriendPages searchfriendPages1=new SearchfriendPages(driver);
		searchfriendPages1.searchfriendByName(fiendName);
		assertNotEquals(searchfriendPages1.atttion_status(), "未关注");
	}
	@Test(priority = 8)
	public void look_friendinfo(){
		SearchfriendPages searchfriendPages=new SearchfriendPages(driver);
		String friendname=searchfriendPages.findfriendByName();
		searchfriendPages.goto_friendinfo();
		FriendInfoPages friendInfoPages = new FriendInfoPages(driver);
		assertEquals(friendInfoPages.get_friendName(),friendname );
	}
	
}
