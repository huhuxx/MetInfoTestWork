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

public class CollectCourseTest2 extends BaseTest{
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
		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
		Thread.sleep(2000);
	}
	
	/**
	 * 7
	 * 在“我的收藏”->点击加号->点击“健身”，选择第二个课程添加收藏
	 * @throws InterruptedException 
	 */
	@Test(dependsOnMethods = {"login"})
	public void addCollect_inSouso1() throws InterruptedException {
		//进入“我的收藏”
		mainPages.turn_success("我的");
		Thread.sleep(1500);
		myInformationPages.turn_to_target("我的收藏");
		Thread.sleep(1500);
		//点击添加-选择“健身”
		myCollectPage.clickAdd_btn();
		Thread.sleep(1500);
		allCoursePage.turn_success("健身");
		Thread.sleep(1500);
		//选择第二个课程添加收藏
		allCoursePage.clickOneCourse(1);
		Thread.sleep(1500);
		courseDetailPage.clickAdd_btn();
		//判断提示内容是否符合预期
		final WebDriverWait wait = new WebDriverWait(driver, 10);
		Assert.assertNotNull(wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[contains(@text,'"+"收藏课程成功"+"')]"))));
		//收藏成功，提示“收藏课程成功”
	}
}
