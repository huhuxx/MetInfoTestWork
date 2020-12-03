package com.hxy.dataTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.hxy.dataProvider.NSDataProvider;
import com.hxy.pageObjects.ContentManage;
import com.hxy.util.BaseTest;

public class UpdateContent extends BaseTest {
	public ContentManage c(WebDriver driver) {
		ContentManage  c =new ContentManage(driver);
		return c;
	}
	@Test(dataProvider = "excel4",dataProviderClass = NSDataProvider.class)
	public void updateContent_size(String size,String color,String x,String jdurl,String tburl) throws InterruptedException {
		c(driver).editContent_text_size(size);
	}
	@Test(dataProvider = "excel4",dataProviderClass = NSDataProvider.class)
	public void updateContent_color(String size,String color,String x,String jdurl,String tburl) throws InterruptedException {
		c(driver).editContent_text_color(color);
	}
	@Test(dataProvider = "excel4",dataProviderClass = NSDataProvider.class)
	public void updateContent_x(String size,String color,String x,String jdurl,String tburl) throws InterruptedException {
		c(driver).editContent_model(x);
	}
	@Test(dataProvider = "excel4",dataProviderClass = NSDataProvider.class)
	public void updateContent(String size,String color,String x,String jdurl,String tburl) throws InterruptedException {
		c(driver).editContent_JingDong(jdurl);
	}
	@Test(dataProvider = "excel4",dataProviderClass = NSDataProvider.class)
	public void updateTitle(String size,String color,String x,String jdurl,String tburl) throws InterruptedException {
		c(driver).editContent_Taobao(tburl);
	}
}
