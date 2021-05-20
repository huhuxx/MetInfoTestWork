package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.AllCoursePage;
import com.sport.pages.CourseDetailPage;
import com.sport.pages.CoursePages;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
import com.sport.pages.MyCollectPage;
import com.sport.pages.MyInformationPages;

public class CollectCourseTest1 extends BaseTest{
	MainPages mainPages;
	LoginPage loginPage;
	MyInformationPages myInformationPages;
	MyCollectPage myCollectPage;
	AllCoursePage allCoursePage;
	CourseDetailPage courseDetailPage;
	CoursePages coursePages;
	@BeforeClass
	public void initpage() {
		mainPages=new MainPages(driver);
		loginPage=new LoginPage(driver);
		myCollectPage=new MyCollectPage(driver);
		myInformationPages=new MyInformationPages(driver);
		allCoursePage=new AllCoursePage(driver);
		courseDetailPage=new CourseDetailPage(driver);
		coursePages=new CoursePages(driver);
	}
	/**
	 * 登录
	 * @throws InterruptedException
	 */
	@Test
	public void login() throws InterruptedException {
		loginPage.login_sucess("19831125536", "123456");
//		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
		Thread.sleep(2000);
	}
	/**
	 * 1
	 * 进入我的收藏，添加收藏课程
	 */
	@Test(priority = 1,dependsOnMethods = {"login"})
	public void addCollect_inMyCollecting() throws InterruptedException {
		mainPages.turn_success("我的");
		Thread.sleep(2000);
		myInformationPages.turn_to_target("我的收藏");
		Thread.sleep(2000);
		
		//点击添加，进入“全部课程”，点击第三个课程并收藏
		myCollectPage.clickAdd_btn();
		Thread.sleep(2000);
		allCoursePage.clickOneCourse(2);
		Thread.sleep(2000);
		courseDetailPage.clickAdd_btn();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏课程成功"+"')]"))));
		//收藏成功，提示“收藏课程成功”
		courseDetailPage.clickBackBtn();
		Thread.sleep(1500);
		allCoursePage.back();
		Thread.sleep(1500);
	}
	/**
	 * 2
	 * 在“课程”版块中收藏课程
	 * @throws InterruptedException 
	 */
	@Test(priority = 2,dependsOnMethods = {"login"})
	public void addCollect_inCourse() throws InterruptedException {
		//进入“课程”
		mainPages.turn_success("课程");
		//选择第二个课程
		Thread.sleep(1500);
		coursePages.clickKnow();
		Thread.sleep(1500);
		coursePages.clickOneCourse(1);
		//进入课程详情页，添加收藏
		Thread.sleep(1500);
		courseDetailPage.clickAdd_btn();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏课程成功"+"')]"))));
		//收藏成功，提示“收藏课程成功”
		courseDetailPage.clickBackBtn();
		Thread.sleep(1500);
	}
	/**
	 * 3
	 * 在“热门课程”中收藏课程
	 * @throws InterruptedException 
	 */
	@Test(priority = 3,dependsOnMethods = {"login"})
	public void addCollect_inRemenCourse() throws InterruptedException {
		//进入“课程”
		mainPages.turn_success("课程");
		//选择第二个课程
		Thread.sleep(1500);
		coursePages.clickKnow();
		Thread.sleep(1500);
		//进入“热门课程”
		coursePages.clickRemenCourse();
		Thread.sleep(1500);
		//进入课程详情页，添加收藏
		coursePages.clickOneCourse(3);	
		Thread.sleep(1500);
		courseDetailPage.clickAdd_btn();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏课程成功"+"')]"))));
		//收藏成功，提示“收藏课程成功”
		Thread.sleep(1500);
	}
	/**
	 * 4
	 * 在“最新课程”中收藏课程
	 * @throws InterruptedException 
	 */
	@Test(priority = 4,dependsOnMethods = {"login"})
	public void addCollect_inNewestCourse() throws InterruptedException {
		//进入“课程”
		mainPages.turn_success("课程");
		//选择第二个课程
		Thread.sleep(1500);
		coursePages.clickKnow();
		Thread.sleep(1500);
		//进入“最新课程”
		coursePages.clickNewestCourse();;
		Thread.sleep(1500);
		//进入课程详情页，添加收藏
		coursePages.clickOneCourse(2);	
		Thread.sleep(1500);
		courseDetailPage.clickAdd_btn();
		//判断toast提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏课程成功"+"')]"))));
		//收藏成功，提示“收藏课程成功”
	}
	/**
	 * 5
	 * 重复收藏
	 * @throws InterruptedException
	 */
	@Test(priority = 5,dependsOnMethods = {"login"})
	public void repeatAddCollect() throws InterruptedException {
		mainPages.turn_success("我的");
		Thread.sleep(1500);
		//进入“我的收藏”，点击加号+
		myInformationPages.turn_to_target("我的收藏");
		Thread.sleep(1500);
		
		//点击第一个已收藏的课程，进行重复收藏
		myCollectPage.clickOneCourse(1);
		Thread.sleep(2000);
		courseDetailPage.clickAdd_btn();
		
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏课程成功"+"')]"))));
		//重复收藏，提示内容和第一次收藏的相同，故是bug
	}
	/**
	 * 6
	 * 取消收藏
	 * @throws InterruptedException
	 */
	@Test(priority = 6,dependsOnMethods = {"login"})
	public void cancelCollect1() throws InterruptedException {
		mainPages.turn_success("我的");
		Thread.sleep(1500);
		//进入“我的收藏”，点击加号+
		myInformationPages.turn_to_target("我的收藏");
		Thread.sleep(1500);
		//点击第一个已收藏的课程，取消收藏
		myCollectPage.clickOneCourse(1);
		Thread.sleep(1500);
		courseDetailPage.clickAdd_btn();
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏课程成功"+"')]"))));
		//重复收藏，提示内容和第一次收藏的相同，故是bug
	}
	
}
