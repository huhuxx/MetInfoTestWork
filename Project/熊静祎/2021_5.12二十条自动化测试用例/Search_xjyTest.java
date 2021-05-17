package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.CoursePages;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class Search_xjyTest extends BaseTest{
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	MainPages mainPages;
	CoursePages coursePages;
	
	//搜索框
	public AndroidElement search_box() {
		return driver.findElementById("android:id/search_src_text");
	}
	//搜索按钮
	public AndroidElement search_btn() {
		return driver.findElementById("android:id/search_go_btn");
	}
	
	@BeforeClass
	public void login() {
		LoginPage loginPage=new LoginPage(driver);
		loginPage.login_sucess("19831125536", "123456");
		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
	}
	
	//01 点击“推荐”，点击搜索框
	@Test(priority = 1)
	public void test_searchRecClick() { 
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.click(search_box());
		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
	}
	
	//02 点击“推荐”，点击搜索框，输入空格，点击搜索
	@Test(priority = 2)
	public void test_searchRecSpace() {
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "  ");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".LZYZYH.activity.SearchActivity");
	}
	
	//03 点击“推荐”，点击搜索框，输入“上衣”，点击搜索
	@Test(priority = 3)
	public void test_searchRecUp() {
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "上衣");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".LZYZYH.activity.SearchActivity");
	}
	
	//04 点击“推荐”，点击搜索框，输入“Nike”，点击搜索
		@Test(priority = 4)
		public void test_searchRecNike() {
			mainPages.turn_success("推荐");
			action.click(coursePages.btn_find());
			action.type(search_box(), "Nike");
			action.click(search_btn());
			assertEquals(driver.currentActivity(), ".LZYZYH.activity.SearchActivity");
		}
	
	//05 点击“推荐”，点击搜索框，输入“裤”，点击搜索
	@Test(priority = 5)
	public void test_searchRecDown() {
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "裤");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".LZYZYH.activity.SearchActivity");
	}
	
	//06 点击“课程”，点击搜索框
	@Test(priority = 6) 
	public void test_searchCouClick() { 
		mainPages.turn_success("课程");
		action.click(coursePages.btn_find());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//07 点击“课程”，点击搜索框，输入空格，点击搜索
	@Test(priority = 7)
	public void test_searchCouSpace() { 
		mainPages.turn_success("课程");
		action.click(coursePages.btn_find());
		action.type(search_box(), "  ");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//08 点击“课程”，点击搜索框，输入“搏击二”，点击搜索
	@Test(priority = 8)
	public void test_searchCouFightTwo() {
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "搏击二");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.CourseDetailActivity");
	}
	
	//09 点击“课程”，点击搜索框，输入“胸部放松”，点击搜索
	@Test(priority = 9)
	public void test_searchCouChest() {
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "胸部放松");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.CourseDetailActivity");
	}
	
	//10 点击“推荐”，点击搜索框，不输入内容，点击搜索
	@Test(priority = 10)
	public void test_searchRecNull() {
		assertEquals(1, 2, "页面显示空白");
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//11 点击“推荐”，点击搜索框，输入无效长字符串，点击搜索
	@Test(priority = 11)
	public void test_searchRecUseless() {
		assertEquals(1, 2, "页面显示空白");
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "无效的长字符串无效的长字符串无效的长字符串");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//12 点击“推荐”，点击搜索框，输入有效长字符串，点击搜索
	@Test(priority = 12)
	public void test_searchRecUseable() {
		assertEquals(1, 2, "页面显示空白");
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "上衣上衣上衣上衣上衣上衣上衣上衣上衣上衣");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//13 点击“推荐”，点击搜索框，输入多个关键字中加空格，点击搜索
	@Test(priority = 13)
	public void test_searchRecSpaces() {
		assertEquals(1, 2, "页面显示空白");
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "上 衣");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//14 点击“推荐”，点击搜索框，输入“shangyi”，点击搜索
	@Test(priority = 14)
	public void test_searchRecPin() {
		assertEquals(1, 2, "页面显示空白");
		mainPages.turn_success("推荐");
		action.click(coursePages.btn_find());
		action.type(search_box(), "shangyi");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//15 点击“课程”，点击搜索框，不输入内容，点击搜索
	@Test(priority = 15)
	public void test_searchCouNull() {
		assertEquals(1, 2, "无反应");
		mainPages.turn_success("课程");
		action.click(coursePages.btn_find());
		action.type(search_box(), "");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//16 点击“课程”，点击搜索框，输入无效长字符串，点击搜索
	@Test(priority = 16)
	public void test_searchCouUseless() {
		assertEquals(1, 2, "app停止运行");
		mainPages.turn_success("课程");
		action.click(coursePages.btn_find());
		action.type(search_box(), "无效的长字符串无效的长字符串无效的长字符串");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//17 点击“课程”，点击搜索框，输入有效长字符串，点击搜索
	@Test(priority = 17)
	public void test_searchCouUseable() {
		assertEquals(1, 2, "app停止运行");
		mainPages.turn_success("课程");
		action.click(coursePages.btn_find());
		action.type(search_box(), "搏击二搏击二搏击二搏击二搏击二搏击二搏击二搏击二");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//18 点击“课程”，点击搜索框，输入多个关键字中加空格，点击搜索
	@Test(priority = 18)
	public void test_searchCouSpaces() {
		assertEquals(1, 2, "app停止运行");
		mainPages.turn_success("课程");
		action.click(coursePages.btn_find());
		action.type(search_box(), "搏 击 二");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//19 点击“课程”，点击搜索框，输入“放松”，点击搜索
	@Test(priority = 19)
	public void test_searchCouRelax() {
		assertEquals(1, 2, "app停止运行");
		mainPages.turn_success("课程");
		action.click(coursePages.btn_find());
		action.type(search_box(), "放松");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	
	//20 点击“课程”，点击搜索框，输入“xiongbufangsong”，点击搜索
	@Test(priority = 20)
	public void test_searchCouPin() {
		assertEquals(1, 2, "app停止运行");
		mainPages.turn_success("课程");
		action.click(coursePages.btn_find());
		action.type(search_box(), "xiongbufangsong");
		action.click(search_btn());
		assertEquals(driver.currentActivity(), ".MR.SouSuoActivity");
	}
	

}
