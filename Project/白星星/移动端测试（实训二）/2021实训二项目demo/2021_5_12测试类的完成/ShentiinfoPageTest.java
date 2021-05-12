package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.LoginPage;
import com.sport.pages.MainPages;
import com.sport.pages.MyInformationPages;
import com.sport.pages.ShentiinfoPage;
/**
 * 个人身体数据信息的更改
 * @author 白星星
 *
 */
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
		Thread.sleep(1000);
		myInformationPages.turn_to_target("身体数据");
		Thread.sleep(3000);
	}
	
	@Test(description = "更改身高",priority = 1)
	public void test1() throws InterruptedException {
		Thread.sleep(3000);
		shentiinfoPage.updateHeight();
		shentiinfoPage.inputText("190");
		shentiinfoPage.save();
		String height =shentiinfoPage.Height_text();
		assertEquals(height, "190");
	}
	@Test(description = "更改体重",priority = 2)
	public void test2() throws InterruptedException {
		Thread.sleep(3000);
		shentiinfoPage.updateWeight();
		shentiinfoPage.inputText("68");
		shentiinfoPage.save();
		String weight = shentiinfoPage.Weight_text();
		assertEquals(weight, "68");
	}
	@Test(description = "同时更改身高和体重",priority = 3)
	public void test3() throws InterruptedException {
		Thread.sleep(3000);
		shentiinfoPage.updateHeight();
		shentiinfoPage.inputText("180");
		shentiinfoPage.save();
		shentiinfoPage.updateWeight();
		shentiinfoPage.inputText("58");
		shentiinfoPage.save();
		String height =shentiinfoPage.Height_text();
		String weight = shentiinfoPage.Weight_text();
		assertEquals(height, "180");
		assertEquals(weight, "58");
	}
	@Test(description = "更改身高失败，身高过低异常",priority = 4)
	public void test4() throws InterruptedException {
		Thread.sleep(3000);
		shentiinfoPage.updateHeight();
		shentiinfoPage.inputText("9");
		String yichang1=shentiinfoPage.saveAndgetToast();
		assertEquals(yichang1, "身高过低异常");
		shentiinfoPage.cancle();
	}
	@Test(description = "更改身高失败，身高过高异常",priority = 5)
	public void test5() throws InterruptedException {
		Thread.sleep(3000);
		shentiinfoPage.updateHeight();
		shentiinfoPage.inputText("999");
		String yichang2 = shentiinfoPage.saveAndgetToast();
		assertEquals(yichang2, "身高过高异常");
		shentiinfoPage.cancle();
	}
	@Test(description = "更改体重失败，体重过高异常",priority = 6)
	public void test6() throws InterruptedException {
		Thread.sleep(3000);
		shentiinfoPage.updateWeight();
		shentiinfoPage.inputText("200");
		String yichang3 = shentiinfoPage.saveAndgetToast();
		assertEquals( yichang3,"体重过高异常");
		shentiinfoPage.cancle();
		
	}
	@Test(description = "更改体重失败，体重过低异常",priority = 7)
	public void test7() throws InterruptedException {
		Thread.sleep(3000);
		shentiinfoPage.updateWeight();
		shentiinfoPage.inputText("5");
		String yichang4 = shentiinfoPage.saveAndgetToast();
		assertEquals(yichang4, "体重过低异常");
		shentiinfoPage.cancle();
		
	}
	@Test(description = "更改身高体重成功后，BMI自动变化成功",dependsOnMethods = "test3",priority = 8)
	public void test8() {
		String bmiString = shentiinfoPage.BMI_text();
		assertEquals(bmiString, "19");
	}
	@Test(description = "身高输入为空，进行测试",priority = 9)
	public void test9() {
		shentiinfoPage.updateHeight();
		shentiinfoPage.inputText("");
		shentiinfoPage.saveAndgetToast();
	}
}
