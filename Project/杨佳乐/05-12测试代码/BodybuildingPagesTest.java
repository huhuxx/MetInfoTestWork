package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
import com.sport.pages.MyInformationPages;
import com.sport.pages.BodybuildingPages;
import com.sport.pages.CourseDetailPage;

public class BodybuildingPagesTest extends BaseTest {
	BodybuildingPages bodyPages;
	LoginPage loginPage;
	MainPages mainPages;
	CourseDetailPage courseDetailPage;
	MyInformationPages myInformationPages;
	
	@BeforeMethod
	public void login() throws InterruptedException {
		loginPage=new LoginPage(driver);
		mainPages=new MainPages(driver);
		bodyPages=new BodybuildingPages(driver);
		courseDetailPage=new CourseDetailPage(driver);
		myInformationPages=new MyInformationPages(driver);
		loginPage.login("19831125535", "123456");
		Thread.sleep(3000);
	}
	
	@Test(priority = 1)
	public void test_one() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_one();
		assertEquals(driver.currentActivity(), ".CLB.EncyclopaediaActivity");
	}
	
	@Test(priority = 2)
	public void test_two() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_two();
		assertEquals(driver.currentActivity(), ".CLB.EncyclopaediaActivity");
	}
	
	@Test(priority = 3)
	public void test_three() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_three();
		assertEquals(driver.currentActivity(), ".CLB.Stair2Activity");
	}
	
	@Test(priority = 4)
	public void test_four() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_four();
		assertEquals(driver.currentActivity(), ".CLB.Stair2Activity");
	}
	
	@Test(priority = 5)
	public void test_five() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_five();
		assertEquals(driver.currentActivity(), ".CLB.Stair2Activity");
	}
	
	@Test(priority = 6)
	public void test_six() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_six();
		assertEquals(driver.currentActivity(), ".CLB.EssayDetailActivity");
	}
	
	@Test(priority = 7)
	public void test_seven() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_seven();
		assertEquals(driver.currentActivity(), ".CLB.Stair2Activity");
	}
	
	@Test(priority = 8)
	public void test_eight() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_eight();
		assertEquals(driver.currentActivity(), ".CLB.Stair2Activity");
	}
	
	@Test(priority = 9)
	public void test_nine() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_nine();
		assertEquals(driver.currentActivity(), ".CLB.Stair2Activity");
	}
	
	@Test(priority = 10)
	public void test_ten() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_ten();
		assertEquals(driver.currentActivity(), ".CLB.EncyclopaediaActivity");
	}
	
	@Test(priority = 11)
	public void test_eleven() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_eleven();
		assertEquals(driver.currentActivity(), ".CLB.EncyclopaediaActivity");
	}
	
	@Test(priority = 12)
	public void test_twelve() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_twelve();
		assertEquals(driver.currentActivity(), ".CLB.EssayDetailActivity");
	}
	
	@Test(priority = 13)
	public void test_thirteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_thirteen();
		assertEquals(driver.currentActivity(), ".MR.CourseDetailActivity");
	}
	
	@Test(priority = 14)
	public void test_fourteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_fourteen();
		courseDetailPage.addCollect_btn().click();
		Thread.sleep(3000);
		courseDetailPage.clickBackBtn();
		Thread.sleep(3000);
		bodyPages.inter_fourteen_one();
		mainPages.turn_success("我的");
		Thread.sleep(3000);
		myInformationPages.turn_to_target("我的收藏");
		Thread.sleep(3000);
		assertEquals(driver.currentActivity(), ".MR.MyLikeCoursesActivity");
	}
	
	@Test(priority = 15)
	public void test_fifteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_fifteen();
		courseDetailPage.addCollect_btn();
		Thread.sleep(3000);
		courseDetailPage.clickBackBtn();
		Thread.sleep(3000);
		bodyPages.inter_fifteen_one();
		assertEquals(driver.currentActivity(), ".MR.CourseDetailActivity");
	}
	
	@Test(priority = 16)
	public void test_sixteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_sixteen();
		courseDetailPage.clickOneMenu("视频列表");
		Thread.sleep(3000);
		assertEquals(driver.currentActivity(), ".MR.CourseDetailActivity");
	}
	
	@Test(priority = 17)
	public void test_seventeen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_seventeen();
		assertEquals(driver.currentActivity(), ".CLB.EssayDetailActivity");
	}
	
	@Test(priority = 18)
	public void test_eighteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_eighteen();
		assertEquals(driver.currentActivity(), ".CLB.Stair2Activity");
	}
	
	@Test(priority = 19)
	public void test_nineteen() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_nineteen();
		assertEquals(driver.currentActivity(), ".CLB.EncyclopaediaActivity");
	}
	
	@Test(priority = 20)
	public void test_twenty() throws InterruptedException {
		Thread.sleep(3000);
		mainPages.turn_success("健身百科");
		Thread.sleep(3000);
		bodyPages.inter_twenty();
		assertEquals(driver.currentActivity(), ".CLB.EncyclopaediaActivity");
	}
}