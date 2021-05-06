package com.hxy.testCase;

import com.hxy.pageObjects.ProductShow;
import com.hxy.util.BaseTest;

public class ProductShow_Test extends BaseTest {
	//3¸ö
	ProductShow c = new ProductShow(driver);
	public void ProductShow_set_background_color() throws InterruptedException {
		c.set_background_color();
	}
	public void ProductShow_set_text_color() throws InterruptedException {
		c.set_text_color();
	}
	public void ProductShow_set_background_color() throws InterruptedException {
		c.set_background_color();
	}
}
