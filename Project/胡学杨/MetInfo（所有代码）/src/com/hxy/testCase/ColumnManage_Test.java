package com.hxy.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hxy.pageObjects.ColumnManage;
import com.hxy.util.BaseTest;

public class ColumnManage_Test extends BaseTest {
	//6¸ö
	public ColumnManage u(WebDriver webDriver) {
		ColumnManage a = new ColumnManage(webDriver);
		return a;
	}
	@Test
	public void ColumnManage_updateTitle() throws InterruptedException {	
		u(driver).updateTitle();
	}
	@Test
	public void ColumnManage_setDisplay_all() throws InterruptedException {	
		u(driver).setDisplay_all();
	}
	@Test
	public void ColumnManage_setDisplay_head() throws InterruptedException {	
		u(driver).setDisplay_head();
	}
	@Test
	public void ColumnManage_addColumn() throws InterruptedException {	
		u(driver).addColumn();
	}
}
