package com.hxy.testCase;

import org.testng.annotations.Test;

import com.hxy.pageObjects.EditorialColumn;
import com.hxy.util.BaseTest;

public class EditorialColumn_Test extends BaseTest {
	//14¸ö
	EditorialColumn b = new EditorialColumn(driver);
	@Test
	public void EditorialColumn_set_newWindow_no() throws InterruptedException {
		b.set_newWindow_no();
	}
	@Test
	public void EditorialColumn_set_newWindow_yes() throws InterruptedException {
		b.set_newWindow_yes();
	}
	@Test
	public void EditorialColumn_set_setDisplay_all() throws InterruptedException {
		b.set_setDisplay_all();
	}
	@Test
	public void EditorialColumn_set_setDisplay_head() throws InterruptedException {
		b.set_setDisplay_head();
	}
	@Test
	public void EditorialColumn_set_setDisplay_no() throws InterruptedException {
		b.set_setDisplay_no();
	}
	@Test
	public void EditorialColumn_set_setDisplay_tail() throws InterruptedException {
		b.set_setDisplay_tail();
	}
	@Test
	public void EditorialColumn_set_updateTitle() throws InterruptedException {
		b.set_updateTitle();
	}
	@Test
	public void EditorialColumn_set_text_color() throws InterruptedException {
		b.set_text_color();
	}
	@Test
	public void EditorialColumn_set_text_size() throws InterruptedException {
		b.set_text_size();
	}
	@Test
	public void EditorialColumn_set_sortStyle_clickNumber() throws InterruptedException {
		b.set_sortStyle_clickNumber();
	}
	@Test
	public void EditorialColumn_set_sortStyle_daoxu() throws InterruptedException {
		b.set_sortStyle_daoxu();
	}
	@Test
	public void EditorialColumn_set_sortStyle_releaseTime() throws InterruptedException {
		b.set_sortStyle_releaseTime();
	}
	@Test
	public void EditorialColumn_set_sortStyle_zhengxu() throws InterruptedException {
		b.set_sortStyle_zhengxu();
	}
	@Test
	public void EditorialColumn_set_sortStyle_updateTime() throws InterruptedException {
		b.set_sortStyle_updateTime();
	}
}
