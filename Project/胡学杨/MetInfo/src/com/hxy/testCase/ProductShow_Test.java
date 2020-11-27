package com.hxy.testCase;

import org.testng.annotations.Test;

import com.hxy.pageObjects.ProductShow;
import com.hxy.util.BaseTest;

public class ProductShow_Test extends BaseTest {
	//3¸ö
	ProductShow c = new ProductShow(driver);
	@Test
	public void ProductShow_set_background_color() throws InterruptedException {
		c.set_background_color();
	}
//	@Test
//	public void ProductShow_set_text_color() throws InterruptedException {
//		c.set_text_color();
//	}
//	@Test
//	public void ProductShow_set_text_distance() throws InterruptedException {
//		c.set_text_distance();
//	}
}
