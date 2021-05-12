package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.PlanDPage;
import com.sport.pages.PlanRPage;

public class PlanRTest extends BaseTest {
	PlanDPage planDPage;
	PlanRPage planRPage;
	@BeforeClass
	public void setPage() {
		planDPage=new PlanDPage(driver);
		planRPage=new PlanRPage(driver);
	}
	//核对信息
	@Test(priority = 1)
	public void test_check_iboy() throws InterruptedException {
		String i=planRPage.information("boy");	
		//断言
		assertEquals(i, "身高:165;体重:55boy");
	}
//	//核对信息
//	@Test(priority = 2)
//	public void test_check_igirl() throws InterruptedException {
//		String i=planRPage.information("girl");	
//		//断言
//		assertEquals(i, "身高:165;体重:55girl");
//	}
//	
	//进入详细推荐计划
	@Test(priority = 3)
	public void test_enter_plan() throws InterruptedException {
		String text = planDPage.enterPlanR();	
		//断言
		System.out.println(text);
	}
	//增加推荐计划
	@Test(priority = 4)
	public void test_add_success() throws InterruptedException {
		String text = planDPage.addPlanR();	
		//断言
		assertEquals(text, "you have added");
	}
}
