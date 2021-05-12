package com.sport.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
import com.sport.pages.MyInformationPages;
import com.sport.pages.MyPhotoPages;
/**
 * 个人信息更改的测试用例
 * @author 白星星
 *
 */
public class MyPhotoPagesTest extends BaseTest{
	MyInformationPages myInformationPages;
	MyPhotoPages myPhotoPages;
	MainPages mainPages;
	LoginPage loginPage;
	
	@BeforeClass
	public void initPage() throws InterruptedException {
		loginPage = new LoginPage(driver);
		mainPages = new MainPages(driver);
		myPhotoPages = new MyPhotoPages(driver);
		myInformationPages = new MyInformationPages(driver);
		loginPage.login_sucess("19831125536", "123456");
		Thread.sleep(3000);
		mainPages.turn_success("我的");
		Thread.sleep(2000);
		myInformationPages.turn_to_target("头像");
		Thread.sleep(5000);
	}
	@Test(description = "点击更换图像，并取消",priority = 7)
	public void test1() throws InterruptedException {
		myPhotoPages.cancelClick();
		Thread.sleep(5000);
	}
	@Test(description = "点击更换图像，点击相册，选择图片进行更换",priority =2)
	public void test2() throws InterruptedException {
		myInformationPages.turn_to_target("头像");
		Thread.sleep(5000);
		myPhotoPages.photosClick();
		Thread.sleep(2000);
		myPhotoPages.selectPhotoClick();
		Thread.sleep(2000);
		myPhotoPages.selectPhotoClick();
		Thread.sleep(2000);
		myPhotoPages.selectAndsaveClick();
		Thread.sleep(5000);
	}
	@Test(description = "点击相册，选择图片更换，并选择取消",priority = 3)
	public void test3() throws InterruptedException {
		myPhotoPages.photosClick();
		Thread.sleep(2000);
		myPhotoPages.selectAndcancelClick();
		Thread.sleep(5000);
	}
	@Test(description = "点击相册，选择图片更换，并选择取消，重新选择后确认更换",priority = 4)
	public void test4() throws InterruptedException {
		myPhotoPages.photosClick();
		Thread.sleep(2000);
		myPhotoPages.selectAndcancelClick();
		Thread.sleep(2000);
		myPhotoPages.photosClick();
		Thread.sleep(2000);
		myPhotoPages.selectPhotoClick();
		Thread.sleep(2000);
		myPhotoPages.selectPhotoClick();
		Thread.sleep(2000);
		myPhotoPages.selectAndsaveClick();
		Thread.sleep(5000);
	}
	@Test(description = "点击拍照，拍照后选择确认",priority = 5)
	public void test5() throws InterruptedException {
		myPhotoPages.photographClick();
		Thread.sleep(2000);
		myPhotoPages.shutterClick();
		Thread.sleep(2000);
		myPhotoPages.shutterDoneClick();
		Thread.sleep(5000);
	}
	@Test(description = "点击拍照，拍照后选择重新拍后更换头像",priority =6)
	public void test6() throws InterruptedException {
		myPhotoPages.photographClick();
		Thread.sleep(2000);
		myPhotoPages.shutterClick();
		Thread.sleep(2000);
		myPhotoPages.reShutterClick();
		Thread.sleep(2000);
		myPhotoPages.shutterClick();
		Thread.sleep(2000);
		myPhotoPages.shutterDoneClick();
		Thread.sleep(5000);
	}
	@Test(description = "多次从相册更换图像",priority = 1)
	public void test7() throws InterruptedException {
		myPhotoPages.photosClick();
		Thread.sleep(2000);
		myPhotoPages.selectPhotoClick();
		Thread.sleep(2000);
		myPhotoPages.selectPhotoClick();
		Thread.sleep(2000);
		myPhotoPages.selectAndsaveClick();
		Thread.sleep(5000);
		
		myPhotoPages.photosClick();
		Thread.sleep(2000);
		myPhotoPages.selectPhotoClick();
		Thread.sleep(2000);
		myPhotoPages.selectPhotoClick();
		Thread.sleep(2000);
		myPhotoPages.selectAndsaveClick();
		Thread.sleep(5000);
	}
}
