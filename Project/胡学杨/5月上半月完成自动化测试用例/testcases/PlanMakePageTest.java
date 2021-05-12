package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.PlanMakePage;

public class PlanMakePageTest extends BaseTest {
	PlanMakePage planMakePage;
	@BeforeClass
	public void setPage() {
		planMakePage=new PlanMakePage(driver);
	}

	//制作计划返回
	@Test(priority = 1)
	public void test_planMake_return() throws InterruptedException {
		planMakePage.plan_make_return();
		//断言
		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
	}
	//制作计划增加计划
	@Test(priority = 2)
	public void test_planMake_success() throws InterruptedException {
		planMakePage.plan_make();
		//断言

	}
	//输入计划名返回
	@Test(priority = 3)
	public void test_planMake_inputback() throws InterruptedException {
		planMakePage.plan_input_back("123");
		//断言
		assertEquals(driver.currentActivity(), ".ZFT.ActionLibraryActivity");
	}
	//输入计划名保存计划
	@Test(priority = 4)
	public void test_planMake_inputyes() throws InterruptedException {
		planMakePage.plan_input_yes("123");
		//断言
		assertEquals(driver.currentActivity(), ".MR.ShouYeActivity");
	}
}
