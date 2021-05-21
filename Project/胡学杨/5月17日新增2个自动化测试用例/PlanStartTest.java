package com.sport.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.sport.base.BaseTest;
import com.sport.pages.PlanStartPage;

public class PlanStartTest extends BaseTest {
	PlanStartPage planStartPage;
	@BeforeClass
	public void setPage() {
		planStartPage=new PlanStartPage(driver);
	}

	//开始训练
	@Test(priority = 1)
	public void test_startTrain() throws InterruptedException {
		planStartPage.startTrain();
		assertEquals(driver.currentActivity(), ".ZFT.ExerciseActivity");
	}
	
	//下一个
	@Test(priority = 2)
	public void test_nextTrain() throws InterruptedException {
		String a = planStartPage.strain_string_name();
		String b = planStartPage.nextTrain();
		assertEquals(a, b);
	}
}
