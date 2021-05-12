package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.PlanDPage;

public class PlanTest extends BaseTest {
	PlanDPage planDPage;
	@BeforeClass
	public void setPage() {
		planDPage=new PlanDPage(driver);
	}

	//增加计划
	@Test(priority = 1)
	public void test_add_success() throws InterruptedException {
		planDPage.addPlan();
//		assertEquals(text, "you have added");
		
	}
	//再次增加
	@Test(priority = 2)
	public void test_addAgain_success() throws InterruptedException {
		String text = planDPage.addPlanAgain();
		//断言
		assertEquals(text, "you have added");
	}
	//开始训练
	@Test(priority = 3)
	public void test_startTrain() throws InterruptedException {
		planDPage.startTrain();
	}
}
