package com.hxy.testCase;

import org.testng.annotations.Test;

import com.hxy.pageObjects.ColumnManage;
import com.hxy.pageObjects.EditorialColumn;
import com.hxy.pageObjects.ProductShow;
import com.hxy.pageObjects.SearchBox;
import com.hxy.util.BaseTest;

public class ColumnManage_Test extends BaseTest {
	//6¸ö
	ColumnManage a = new ColumnManage(driver);
	@Test
	public void ColumnManage_updateTitle() throws InterruptedException {	
		a.updateTitle();
	}
	@Test
	public void ColumnManage_setDisplay_all() throws InterruptedException {	
		a.setDisplay_all();
	}
	@Test
	public void ColumnManage_setDisplay_head() throws InterruptedException {	
		a.setDisplay_head();
	}
	@Test
	public void ColumnManage_setDisplay_tail() throws InterruptedException {	
		a.setDisplay_tail();
	}
	@Test
	public void ColumnManage_setDisplay_no() throws InterruptedException {	
		a.setDisplay_no();
	}
	@Test
	public void ColumnManage_addColumn() throws InterruptedException {	
		a.addColumn();
	}
}
