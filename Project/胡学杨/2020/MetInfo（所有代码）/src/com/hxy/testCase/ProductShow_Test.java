package com.hxy.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hxy.pageObjects.ProductShow;
import com.hxy.util.BaseTest;

public class ProductShow_Test extends BaseTest {
	//3¸ö
	public ProductShow u(WebDriver webDriver) {
		ProductShow c = new ProductShow(webDriver);
		return c;
	}

	@Test
	public void ProductShow_set_background_color() throws InterruptedException {
		u(driver).set_background_color();
	}
	@Test
	public void ProductShow_set_text_color() throws InterruptedException {
		u(driver).set_text_color();
	}
	@Test
	public void ProductShow_set_text_distance() throws InterruptedException {
		u(driver).set_text_distance();
	}
}
