package com.hxy.dataTest;

import org.testng.annotations.Test;

import com.hxy.dataProvider.NSDataProvider;
import com.hxy.pageObjects.ProductShow;
import com.hxy.util.BaseTest;

public class UpdateBanner extends BaseTest {
	@Test(dataProvider = "excel2",dataProviderClass = NSDataProvider.class)
	public void updateBackground_color(String background_color,String text_color) throws InterruptedException {
		ProductShow p = new ProductShow(driver);
		p.set_background_color_data(background_color);
	}
	@Test(dataProvider = "excel2",dataProviderClass = NSDataProvider.class)
	public void updateText_color(String background_color,String text_color) throws InterruptedException {
		ProductShow p = new ProductShow(driver);
		p.set_text_color_data(text_color);
	}
}
