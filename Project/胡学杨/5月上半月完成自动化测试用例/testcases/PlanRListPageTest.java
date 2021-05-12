package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.PlanRListPage;

public class PlanRListPageTest extends BaseTest {
	PlanRListPage planRListPage;
	@BeforeClass
	public void setPage() {
		planRListPage=new PlanRListPage(driver);
	}
	//进入推荐计划列表
	@Test(priority = 1)
	public void test_Information_check() throws InterruptedException {
		planRListPage.plan_enter();
		//断言
		assertEquals(driver.currentActivity(), ".ZFT.RecoPlanActivity");
	}
//	//OK按钮
//	@Test(priority = 2)
//	public void test_planDList_OK() throws InterruptedException {
//		planRListPage.OK();
//		//断言
//		//assertEquals(text, "added successfully");
//	}
	//List页面添加计划
	@Test(priority = 3)
	public void test_planDList_add() throws InterruptedException {
		String text = planRListPage.plan_add();
		//断言
		assertEquals(text, "added successfully");
	}
	//List页面再次添加计划
	@Test(priority = 4)
	public void test_planDList_addAgain() throws InterruptedException {
		String text = planRListPage.plan_addAgain();
		//断言
		assertEquals(text, "you have added");
	}

}
