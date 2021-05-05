package com.hxy.dataTest;

import org.testng.annotations.Test;

import com.hxy.dataProvider.NSDataProvider;
import com.hxy.pageObjects.SearchBox;
import com.hxy.util.BaseTest;

public class UpdateSearchBox extends BaseTest {
	@Test(dataProvider = "excel3",dataProviderClass = NSDataProvider.class)
	public void updateText(String text) throws InterruptedException {
		SearchBox s = new SearchBox(driver);
		s.set_content_data(text);
	}
}
